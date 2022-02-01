package com.tencent.mobileqq.filemanageraux.link;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanageraux.core.WeiyunTask;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.weiyun.ResponseHandler;
import cooperation.weiyun.vip.OpenWeiyunVipHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

final class WeiyunShareProcessController
  implements DialogInterface.OnClickListener, Handler.Callback, View.OnClickListener
{
  private final View jdField_a_of_type_AndroidViewView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private volatile FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private volatile WeiyunTask jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask;
  private final IShareRouter jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private volatile String jdField_a_of_type_JavaLangString;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private final boolean jdField_a_of_type_Boolean;
  private final View jdField_b_of_type_AndroidViewView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_b_of_type_Boolean;
  private final View jdField_c_of_type_AndroidViewView;
  private final TextView jdField_c_of_type_AndroidWidgetTextView;
  private final MqqHandler jdField_c_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_c_of_type_Boolean;
  private final View jdField_d_of_type_AndroidViewView;
  private final TextView jdField_d_of_type_AndroidWidgetTextView;
  
  WeiyunShareProcessController(IShareRouter paramIShareRouter, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter = paramIShareRouter;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373510);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373509));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131373503);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131373505);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373504));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373506));
    paramView.findViewById(2131373507).setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370434);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370450));
    paramView.findViewById(2131370436).setOnClickListener(this);
    paramView.findViewById(2131370448).setOnClickListener(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), this, false);
    this.jdField_c_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this, false);
    a();
  }
  
  private String a()
  {
    String str = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = this.jdField_d_of_type_AndroidWidgetTextView.getTag();
      if (((localObject instanceof String)) && (!TextUtils.isEmpty((String)localObject))) {
        return str + " " + BaseApplicationImpl.sApplication.getString(2131698203) + ":" + localObject;
      }
      return str;
    }
    return null;
  }
  
  private void a(float paramFloat)
  {
    int i = (int)Math.floor(100.0F * paramFloat);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(i + "%");
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void a(int paramInt, String paramString)
  {
    a();
    if (ResponseHandler.b(paramInt))
    {
      e();
      return;
    }
    if (paramInt == 2) {
      paramString = BaseApplicationImpl.sApplication.getResources().getString(2131694459);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      LinkUtils.a(1, paramString, true);
      return;
    }
    paramString = BaseApplicationImpl.sApplication.getResources();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131698187;; i = 2131698188)
    {
      paramString = paramString.getString(i, new Object[] { Integer.valueOf(paramInt) });
      break;
    }
  }
  
  private void a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if (paramBitmap == null) {
      a(-1, null);
    }
    for (;;)
    {
      a();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a(paramBitmap, paramInt, paramString);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
    }
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a().getAppInterface();
    if ((localAppInterface instanceof QQAppInterface))
    {
      Message localMessage = new Message();
      localMessage.what = 9;
      localMessage.obj = new Object[] { (QQAppInterface)localAppInterface, paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a(), Boolean.valueOf(this.jdField_a_of_type_Boolean), paramString };
      this.jdField_c_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    throw new IllegalStateException("processCloudFile: need QQAppInterface, must run in main process.");
  }
  
  private void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject != null)
    {
      a((FileManagerEntity)localObject, null);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a().getAppInterface();
    if ((localObject instanceof QQAppInterface))
    {
      Message localMessage = new Message();
      localMessage.what = 8;
      localMessage.obj = new Object[] { (QQAppInterface)localObject, paramString };
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    throw new IllegalStateException("processLocalFile: need QQAppInterface, must run in main process.");
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (this.jdField_a_of_type_Boolean)
    {
      Message localMessage = new Message();
      localMessage.what = 10;
      localMessage.obj = new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 };
      this.jdField_c_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    boolean bool;
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698184);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTag(paramString2);
      bool = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
    } while (!bool);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.b();
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      throw new IllegalArgumentException("handleError: args are invalid");
    }
    a(((Integer)paramArrayOfObject[0]).intValue(), (String)paramArrayOfObject[1]);
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      throw new IllegalArgumentException("handleUpload: args are invalid");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    int i;
    if (NetworkUtil.d(BaseApplicationImpl.sApplication))
    {
      paramArrayOfObject = localQQAppInterface.getFileManagerEngine().a().a(paramArrayOfObject, null, new WeiyunShareProcessController.UploadStatusListener(this, paramArrayOfObject, null));
      if (paramArrayOfObject == null) {
        i = -3;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i), null };
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramArrayOfObject);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = paramArrayOfObject;
      i = 0;
      continue;
      i = 2;
    }
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      throw new IllegalArgumentException("handleUploadSucceed: args are invalid");
    }
    UploadJobContext.StatusInfo localStatusInfo = (UploadJobContext.StatusInfo)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    if (QLog.isColorLevel()) {
      QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "upload is succeed, for file:" + paramArrayOfObject);
    }
    a(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = null;
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.WeiYunFileId = localStatusInfo.fileId;
    if (localStatusInfo.jobContext != null) {}
    for (paramArrayOfObject = localStatusInfo.jobContext.file().pDirKey;; paramArrayOfObject = null)
    {
      localFileManagerEntity.WeiYunDirKey = paramArrayOfObject;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = localFileManagerEntity;
      a(localFileManagerEntity, null);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131698179;; i = 2131698181)
    {
      localTextView.setText(i);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      return;
    }
  }
  
  private void d(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 1)) {
      throw new IllegalArgumentException("handleUploadProgress: args are invalid");
    }
    a(((Float)paramArrayOfObject[0]).floatValue());
  }
  
  private void e()
  {
    QQCustomDialog localQQCustomDialog;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a(), 2131755842);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131559084);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131698189);
      localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if (!this.jdField_a_of_type_Boolean) {
        break label130;
      }
    }
    label130:
    for (int i = 2131698191;; i = 2131698190)
    {
      localQQCustomDialog.setMessage(i);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690800, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131698192, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
  }
  
  private void e(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 5)) {
      throw new IllegalArgumentException("handleRequest: args are invalid");
    }
    Object localObject1 = (QQAppInterface)paramArrayOfObject[0];
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramArrayOfObject[1];
    Object localObject2 = (IShareRouter.ShareOptions)paramArrayOfObject[2];
    boolean bool1 = ((Boolean)paramArrayOfObject[3]).booleanValue();
    paramArrayOfObject = (String)paramArrayOfObject[4];
    if (NetworkUtil.d(BaseApplicationImpl.sApplication))
    {
      long l = LinkUtils.a(((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_Int);
      if (FileUtil.b(paramArrayOfObject))
      {
        WeiYunLogicCenter localWeiYunLogicCenter = ((QQAppInterface)localObject1).getFileManagerEngine().a();
        if (!((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_Boolean) {
          break label222;
        }
        localObject1 = ((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_JavaLangString;
        label113:
        boolean bool2 = ((IShareRouter.ShareOptions)localObject2).jdField_b_of_type_Boolean;
        i = ((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_Int;
        if (!((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_Boolean) {
          break label228;
        }
        localObject2 = ((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_JavaLangString;
        label141:
        localWeiYunLogicCenter.a(localFileManagerEntity, l, (String)localObject1, bool2, bool1, new WeiyunShareProcessController.GetShareLinkCallback(this, i, (String)localObject2, paramArrayOfObject, bool1, null));
      }
    }
    for (int i = 0;; i = 2)
    {
      if (i != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i), null };
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramArrayOfObject);
      }
      return;
      paramArrayOfObject = null;
      break;
      label222:
      localObject1 = null;
      break label113;
      label228:
      localObject2 = null;
      break label141;
    }
  }
  
  private void f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.b();
    if ((localFileManagerEntity == null) && (TextUtils.isEmpty(str2))) {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "startProcess: fileEntity and filePath are invalid");
    }
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
    String str1;
    if (this.jdField_a_of_type_Boolean)
    {
      str1 = "0X800A9D7";
      String str3 = LinkUtils.b(((IShareRouter.ShareOptions)localObject).jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break label138;
      }
      localObject = null;
      label104:
      LinkUtils.a(str1, str3, (String)localObject);
      if (!LinkUtils.a(localFileManagerEntity, false)) {
        break label149;
      }
      a(localFileManagerEntity, str2);
    }
    for (;;)
    {
      d();
      return;
      str1 = "0X800A9D6";
      break;
      label138:
      localObject = LinkUtils.a(((IShareRouter.ShareOptions)localObject).jdField_a_of_type_Boolean);
      break label104;
      label149:
      a(str2);
    }
  }
  
  private void f(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleRequestSucceed: args are invalid");
    }
    a((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  private void g()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      LinkUtils.a("0X800A9D8", null, null);
      ((ClipboardManager)BaseApplicationImpl.sApplication.getSystemService("clipboard")).setText(str);
      LinkUtils.a(2, 2131698177, true);
    }
  }
  
  private void g(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleGetQr: args are invalid");
    }
    Object localObject = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    String str = (String)paramArrayOfObject[2];
    try
    {
      paramArrayOfObject = LinkUtils.a((String)localObject, ViewUtils.a(184.0F));
      localObject = new Message();
      ((Message)localObject).what = 7;
      ((Message)localObject).obj = new Object[] { paramArrayOfObject, Integer.valueOf(i), str };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      return;
    }
    catch (Throwable paramArrayOfObject)
    {
      for (;;)
      {
        QLog.e("WeiyunShareProcessController<FileAssistant>", 2, "GetQrTask error", paramArrayOfObject);
        paramArrayOfObject = null;
      }
    }
  }
  
  private void h()
  {
    if (!TextUtils.isEmpty(a()))
    {
      LinkUtils.a("0X800A9D9", null, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a(null);
    }
  }
  
  private void h(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleQrRelay: args are invalid");
    }
    a((Bitmap)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  List<ShareActionSheetBuilder.ActionSheetItem> a(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return paramContext;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131698182;
      localTextView.setText(i);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!this.jdField_a_of_type_Boolean) {
        break label147;
      }
    }
    label147:
    for (int i = 2131698178;; i = 2131698180)
    {
      localTextView.setText(i);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
      this.jdField_d_of_type_AndroidWidgetTextView.setTag(null);
      boolean bool = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.b();
      }
      this.jdField_a_of_type_JavaLangString = null;
      return;
      i = 2131698183;
      break;
    }
  }
  
  void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = 1;
    if (paramActionSheetItem == null) {}
    int j;
    Object localObject1;
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            j = paramActionSheetItem.action;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
          } while ((localObject1 == null) || (((BaseActivity)localObject1).isFinishing()));
          if (NetworkUtil.d((Context)localObject1)) {
            break;
          }
          LinkUtils.a(0, 2131692257, false);
        } while (!QLog.isColorLevel());
        QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "toShare: net is not supported");
        return;
      } while ((j != 2) && (j != 3) && (j != 9) && (j != 10) && (j != 72));
      str = a();
    } while (TextUtils.isEmpty(str));
    switch (j)
    {
    default: 
      return;
    case 2: 
      paramActionSheetItem = new Intent();
      paramActionSheetItem.putExtra("isFromShare", true);
      paramActionSheetItem.putExtra("forward_type", -1);
      paramActionSheetItem.putExtra("forward_text", str);
      ForwardBaseOption.a((Activity)localObject1, paramActionSheetItem, 1, -1);
      return;
    case 3: 
      paramActionSheetItem = QZoneHelper.UserInfo.getInstance();
      localObject2 = ((BaseActivity)localObject1).getAppInterface();
      paramActionSheetItem.qzone_uin = ((AppInterface)localObject2).getAccount();
      if ((localObject2 instanceof VideoAppInterface)) {}
      for (paramActionSheetItem.nickname = ((VideoAppInterface)localObject2).a(0, ((AppInterface)localObject2).getCurrentAccountUin(), null);; paramActionSheetItem.nickname = null)
      {
        QZoneHelper.forwardToPublishMood((Activity)localObject1, paramActionSheetItem, "", ((BaseActivity)localObject1).getString(2131692179), str, 2);
        return;
      }
    case 9: 
    case 10: 
      paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.c();
      localObject1 = WXShareHelper.a();
      if (j == 9) {
        i = 0;
      }
      ((WXShareHelper)localObject1).a(str, i, paramActionSheetItem);
      return;
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_req", ForwardRecentActivity.f);
    ((Bundle)localObject2).putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
    ((Bundle)localObject2).putString("key_direct_show_uin", paramActionSheetItem.uin);
    paramActionSheetItem = new Intent();
    paramActionSheetItem.putExtra("isFromShare", true);
    paramActionSheetItem.putExtra("forward_type", -1);
    paramActionSheetItem.putExtra("forward_text", str);
    paramActionSheetItem.putExtras((Bundle)localObject2);
    ForwardBaseOption.a((Activity)localObject1, paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, -1, "");
  }
  
  boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  List<ShareActionSheetBuilder.ActionSheetItem> b(Context paramContext)
  {
    return new ArrayList();
  }
  
  void b()
  {
    WeiyunTask localWeiyunTask = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = null;
    if (localWeiyunTask != null) {
      localWeiyunTask.a();
    }
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask != null;
  }
  
  void c()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    b();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_c_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a((Object[])paramMessage.obj);
      continue;
      c((Object[])paramMessage.obj);
      continue;
      d((Object[])paramMessage.obj);
      continue;
      f((Object[])paramMessage.obj);
      continue;
      h((Object[])paramMessage.obj);
      continue;
      b((Object[])paramMessage.obj);
      continue;
      e((Object[])paramMessage.obj);
      continue;
      g((Object[])paramMessage.obj);
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
    if (this.jdField_a_of_type_Boolean) {}
    for (paramDialogInterface = "an_qq_qrcode_overcapacity";; paramDialogInterface = "an_qq_link_overcapacity")
    {
      OpenWeiyunVipHelper.a(localBaseActivity, paramDialogInterface, false);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      f();
      continue;
      g();
      continue;
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareProcessController
 * JD-Core Version:    0.7.0.1
 */