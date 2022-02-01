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
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
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
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373085);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373084));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131373078);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131373080);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373079));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373081));
    paramView.findViewById(2131373082).setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370093);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370108));
    paramView.findViewById(2131370095).setOnClickListener(this);
    paramView.findViewById(2131370106).setOnClickListener(this);
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
      Object localObject2 = this.jdField_d_of_type_AndroidWidgetTextView.getTag();
      Object localObject1 = str;
      if ((localObject2 instanceof String))
      {
        localObject1 = str;
        if (!TextUtils.isEmpty((String)localObject2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(BaseApplicationImpl.sApplication.getString(2131698267));
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      return localObject1;
    }
    return null;
  }
  
  private void a(float paramFloat)
  {
    int i = (int)Math.floor(paramFloat * 100.0F);
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void a(int paramInt, String paramString)
  {
    a();
    if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(paramInt))
    {
      e();
      return;
    }
    if (paramInt == 2) {
      paramString = BaseApplicationImpl.sApplication.getResources().getString(2131694424);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = BaseApplicationImpl.sApplication.getResources();
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 2131698251;
      } else {
        i = 2131698252;
      }
      paramString = paramString.getString(i, new Object[] { Integer.valueOf(paramInt) });
    }
    LinkUtils.a(1, paramString, true);
  }
  
  private void a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if (paramBitmap == null)
    {
      a(-1, null);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a(paramBitmap, paramInt, paramString);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
    }
    a();
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.getBaseActivity().getAppInterface();
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.getBaseActivity().getAppInterface();
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
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698248);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_d_of_type_AndroidWidgetTextView.setTag(paramString2);
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = false;
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.b();
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      a(((Integer)paramArrayOfObject[0]).intValue(), (String)paramArrayOfObject[1]);
      return;
    }
    throw new IllegalArgumentException("handleError: args are invalid");
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramArrayOfObject[0];
      paramArrayOfObject = (String)paramArrayOfObject[1];
      int i;
      if (NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication))
      {
        paramArrayOfObject = localQQAppInterface.getFileManagerEngine().a().a(paramArrayOfObject, null, new WeiyunShareProcessController.UploadStatusListener(this, paramArrayOfObject, null));
        if (paramArrayOfObject == null)
        {
          i = -3;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = paramArrayOfObject;
          i = 0;
        }
      }
      else
      {
        i = 2;
      }
      if (i != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i), null };
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramArrayOfObject);
      }
      return;
    }
    throw new IllegalArgumentException("handleUpload: args are invalid");
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      UploadJobContext.StatusInfo localStatusInfo = (UploadJobContext.StatusInfo)paramArrayOfObject[0];
      paramArrayOfObject = (String)paramArrayOfObject[1];
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("upload is succeed, for file:");
        ((StringBuilder)localObject).append(paramArrayOfObject);
        QLog.i("WeiyunShareProcessController<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      a(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = null;
      Object localObject = new FileManagerEntity();
      ((FileManagerEntity)localObject).setCloudType(2);
      ((FileManagerEntity)localObject).WeiYunFileId = localStatusInfo.fileId;
      if (localStatusInfo.jobContext != null) {
        paramArrayOfObject = localStatusInfo.jobContext.file().pDirKey;
      } else {
        paramArrayOfObject = null;
      }
      ((FileManagerEntity)localObject).WeiYunDirKey = paramArrayOfObject;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = ((FileManagerEntity)localObject);
      a((FileManagerEntity)localObject, null);
      return;
    }
    throw new IllegalArgumentException("handleUploadSucceed: args are invalid");
  }
  
  private void d()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2131698243;
    } else {
      i = 2131698245;
    }
    localTextView.setText(i);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void d(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1))
    {
      a(((Float)paramArrayOfObject[0]).floatValue());
      return;
    }
    throw new IllegalArgumentException("handleUploadProgress: args are invalid");
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.getBaseActivity(), 2131756189);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131558978);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131698253);
      QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 2131698255;
      } else {
        i = 2131698254;
      }
      localQQCustomDialog.setMessage(i);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131698256, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  private void e(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 5))
    {
      Object localObject1 = (QQAppInterface)paramArrayOfObject[0];
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramArrayOfObject[1];
      Object localObject2 = (IShareRouter.ShareOptions)paramArrayOfObject[2];
      boolean bool1 = ((Boolean)paramArrayOfObject[3]).booleanValue();
      paramArrayOfObject = (String)paramArrayOfObject[4];
      int i;
      if (NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication))
      {
        long l = LinkUtils.a(((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_Int);
        if (!FileUtil.a(paramArrayOfObject)) {
          paramArrayOfObject = null;
        }
        WeiYunLogicCenter localWeiYunLogicCenter = ((QQAppInterface)localObject1).getFileManagerEngine().a();
        if (((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_Boolean) {
          localObject1 = ((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_JavaLangString;
        } else {
          localObject1 = null;
        }
        boolean bool2 = ((IShareRouter.ShareOptions)localObject2).jdField_b_of_type_Boolean;
        i = ((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_Int;
        if (((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_Boolean) {
          localObject2 = ((IShareRouter.ShareOptions)localObject2).jdField_a_of_type_JavaLangString;
        } else {
          localObject2 = null;
        }
        localWeiYunLogicCenter.a(localFileManagerEntity, l, (String)localObject1, bool2, bool1, new WeiyunShareProcessController.GetShareLinkCallback(this, i, (String)localObject2, paramArrayOfObject, bool1, null));
        i = 0;
      }
      else
      {
        i = 2;
      }
      if (i != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i), null };
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramArrayOfObject);
        return;
      }
      return;
    }
    throw new IllegalArgumentException("handleRequest: args are invalid");
  }
  
  private void f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.b();
    if ((localFileManagerEntity == null) && (TextUtils.isEmpty(str2)))
    {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "startProcess: fileEntity and filePath are invalid");
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
    String str1;
    if (this.jdField_a_of_type_Boolean) {
      str1 = "0X800A9D7";
    } else {
      str1 = "0X800A9D6";
    }
    String str3 = LinkUtils.b(((IShareRouter.ShareOptions)localObject).jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      localObject = null;
    } else {
      localObject = LinkUtils.a(((IShareRouter.ShareOptions)localObject).jdField_a_of_type_Boolean);
    }
    LinkUtils.a(str1, str3, (String)localObject);
    if (LinkUtils.a(localFileManagerEntity, false)) {
      a(localFileManagerEntity, str2);
    } else {
      a(str2);
    }
    d();
  }
  
  private void f(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      a((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
      return;
    }
    throw new IllegalArgumentException("handleRequestSucceed: args are invalid");
  }
  
  private void g()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      LinkUtils.a("0X800A9D8", null, null);
      ClipboardManager localClipboardManager = (ClipboardManager)BaseApplicationImpl.sApplication.getSystemService("clipboard");
      ClipboardMonitor.setText(localClipboardManager, str);
      localClipboardManager.setText(str);
      LinkUtils.a(2, 2131698241, true);
    }
  }
  
  private void g(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      Object localObject = (String)paramArrayOfObject[0];
      int i = ((Integer)paramArrayOfObject[1]).intValue();
      String str = (String)paramArrayOfObject[2];
      paramArrayOfObject = null;
      try
      {
        localObject = LinkUtils.a((String)localObject, ViewUtils.a(184.0F));
        paramArrayOfObject = (Object[])localObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("WeiyunShareProcessController<FileAssistant>", 2, "GetQrTask error", localThrowable);
      }
      Message localMessage = new Message();
      localMessage.what = 7;
      localMessage.obj = new Object[] { paramArrayOfObject, Integer.valueOf(i), str };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    throw new IllegalArgumentException("handleGetQr: args are invalid");
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
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      a((Bitmap)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
      return;
    }
    throw new IllegalArgumentException("handleQrRelay: args are invalid");
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
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2131698246;
    } else {
      i = 2131698247;
    }
    localTextView.setText(i);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean) {
      i = 2131698242;
    } else {
      i = 2131698244;
    }
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
  }
  
  void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    int j = paramActionSheetItem.action;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.getBaseActivity();
    if (localObject1 != null)
    {
      if (((BaseActivity)localObject1).isFinishing()) {
        return;
      }
      boolean bool = NetworkUtil.isNetSupport((Context)localObject1);
      int i = 0;
      if (!bool)
      {
        LinkUtils.a(0, 2131692183, false);
        if (QLog.isColorLevel()) {
          QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "toShare: net is not supported");
        }
        return;
      }
      if ((j == 2) || (j == 3) || (j == 9) || (j == 10) || (j == 72))
      {
        String str = a();
        if (TextUtils.isEmpty(str)) {
          return;
        }
        if (j != 2)
        {
          if (j != 3)
          {
            if ((j != 9) && (j != 10))
            {
              if (j != 72) {
                return;
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("key_req", 1);
              ((Bundle)localObject2).putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
              ((Bundle)localObject2).putString("key_direct_show_uin", paramActionSheetItem.uin);
              paramActionSheetItem = new Intent();
              paramActionSheetItem.putExtra("isFromShare", true);
              paramActionSheetItem.putExtra("forward_type", -1);
              paramActionSheetItem.putExtra("forward_text", str);
              paramActionSheetItem.putExtras((Bundle)localObject2);
              ForwardBaseOption.a((Activity)localObject1, paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, -1, "");
              return;
            }
            paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.c();
            localObject1 = WXShareHelper.a();
            if (j != 9) {
              i = 1;
            }
            ((WXShareHelper)localObject1).a(str, i, paramActionSheetItem);
            return;
          }
          paramActionSheetItem = QZoneHelper.UserInfo.getInstance();
          Object localObject2 = ((BaseActivity)localObject1).getAppInterface();
          paramActionSheetItem.qzone_uin = ((AppInterface)localObject2).getAccount();
          if ((localObject2 instanceof VideoAppInterface)) {
            paramActionSheetItem.nickname = ((VideoAppInterface)localObject2).a(0, ((AppInterface)localObject2).getCurrentAccountUin(), null);
          } else {
            paramActionSheetItem.nickname = null;
          }
          QZoneHelper.forwardToPublishMood((Activity)localObject1, paramActionSheetItem, "", ((BaseActivity)localObject1).getString(2131692105), str, 2);
          return;
        }
        paramActionSheetItem = new Intent();
        paramActionSheetItem.putExtra("isFromShare", true);
        paramActionSheetItem.putExtra("forward_type", -1);
        paramActionSheetItem.putExtra("forward_text", str);
        ForwardBaseOption.a((Activity)localObject1, paramActionSheetItem, 1, -1);
      }
    }
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
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
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
    default: 
      break;
    case 10: 
      g((Object[])paramMessage.obj);
      break;
    case 9: 
      e((Object[])paramMessage.obj);
      break;
    case 8: 
      b((Object[])paramMessage.obj);
      break;
    case 7: 
      h((Object[])paramMessage.obj);
      break;
    case 5: 
      f((Object[])paramMessage.obj);
      break;
    case 4: 
      d((Object[])paramMessage.obj);
      break;
    case 2: 
      c((Object[])paramMessage.obj);
      break;
    case 1: 
    case 3: 
    case 6: 
      a((Object[])paramMessage.obj);
    }
    return true;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface.equals(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) && (paramInt != 0))
    {
      if (paramInt != 1) {
        return;
      }
      IOpenWeiyunVipHelper localIOpenWeiyunVipHelper = (IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class);
      BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.getBaseActivity();
      if (this.jdField_a_of_type_Boolean) {
        paramDialogInterface = "an_qq_qrcode_overcapacity";
      } else {
        paramDialogInterface = "an_qq_link_overcapacity";
      }
      localIOpenWeiyunVipHelper.startOpenWeiyunVipCompareH5(localBaseActivity, paramDialogInterface, false);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131370095)
    {
      if (i != 2131370106)
      {
        if (i == 2131373082) {
          f();
        }
      }
      else {
        h();
      }
    }
    else {
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareProcessController
 * JD-Core Version:    0.7.0.1
 */