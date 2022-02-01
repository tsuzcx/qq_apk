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
  private final IShareRouter a;
  private final boolean b;
  private final View c;
  private final TextView d;
  private final View e;
  private final View f;
  private final TextView g;
  private final TextView h;
  private final View i;
  private final TextView j;
  private QQCustomDialog k;
  private final MqqHandler l;
  private final MqqHandler m;
  private final MqqHandler n;
  private volatile boolean o;
  private volatile WeiyunTask p;
  private volatile FileManagerEntity q;
  private volatile String r;
  private volatile boolean s;
  
  WeiyunShareProcessController(IShareRouter paramIShareRouter, View paramView, boolean paramBoolean)
  {
    this.a = paramIShareRouter;
    this.b = paramBoolean;
    this.c = paramView.findViewById(2131440672);
    this.d = ((TextView)paramView.findViewById(2131440671));
    this.e = paramView.findViewById(2131440665);
    this.f = paramView.findViewById(2131440667);
    this.g = ((TextView)paramView.findViewById(2131440666));
    this.h = ((TextView)paramView.findViewById(2131440668));
    paramView.findViewById(2131440669).setOnClickListener(this);
    this.i = paramView.findViewById(2131437255);
    this.j = ((TextView)paramView.findViewById(2131437270));
    paramView.findViewById(2131437257).setOnClickListener(this);
    paramView.findViewById(2131437268).setOnClickListener(this);
    this.l = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.m = new MqqWeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), this, false);
    this.n = new MqqWeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this, false);
    a();
  }
  
  private void a(float paramFloat)
  {
    int i1 = (int)Math.floor(paramFloat * 100.0F);
    TextView localTextView = this.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
    this.h.setVisibility(0);
  }
  
  private void a(int paramInt, String paramString)
  {
    a();
    if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(paramInt))
    {
      g();
      return;
    }
    if (paramInt == 2) {
      paramString = BaseApplicationImpl.sApplication.getResources().getString(2131892104);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = BaseApplicationImpl.sApplication.getResources();
      int i1;
      if (this.b) {
        i1 = 2131896152;
      } else {
        i1 = 2131896153;
      }
      paramString = paramString.getString(i1, new Object[] { Integer.valueOf(paramInt) });
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
      this.a.a(paramBitmap, paramInt, paramString);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
    }
    a();
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    AppInterface localAppInterface = this.a.getBaseActivity().getAppInterface();
    if ((localAppInterface instanceof QQAppInterface))
    {
      Message localMessage = new Message();
      localMessage.what = 9;
      localMessage.obj = new Object[] { (QQAppInterface)localAppInterface, paramFileManagerEntity, this.a.a(), Boolean.valueOf(this.b), paramString };
      this.n.sendMessage(localMessage);
      return;
    }
    throw new IllegalStateException("processCloudFile: need QQAppInterface, must run in main process.");
  }
  
  private void a(String paramString)
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      a((FileManagerEntity)localObject, null);
      return;
    }
    localObject = this.a.getBaseActivity().getAppInterface();
    if ((localObject instanceof QQAppInterface))
    {
      Message localMessage = new Message();
      localMessage.what = 8;
      localMessage.obj = new Object[] { (QQAppInterface)localObject, paramString };
      this.m.sendMessage(localMessage);
      return;
    }
    throw new IllegalStateException("processLocalFile: need QQAppInterface, must run in main process.");
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    this.r = paramString1;
    if (this.b)
    {
      Message localMessage = new Message();
      localMessage.what = 10;
      localMessage.obj = new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 };
      this.n.sendMessage(localMessage);
      return;
    }
    this.d.setText(2131896149);
    this.e.setVisibility(8);
    this.i.setVisibility(0);
    this.j.setText(paramString1);
    this.j.setTag(paramString2);
    boolean bool = this.o;
    this.o = false;
    if (bool) {
      this.a.h();
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
      int i1;
      if (NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication))
      {
        paramArrayOfObject = localQQAppInterface.getFileManagerEngine().d().a(paramArrayOfObject, null, new WeiyunShareProcessController.UploadStatusListener(this, paramArrayOfObject, null));
        if (paramArrayOfObject == null)
        {
          i1 = -3;
        }
        else
        {
          this.p = paramArrayOfObject;
          i1 = 0;
        }
      }
      else
      {
        i1 = 2;
      }
      if (i1 != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i1), null };
        this.l.sendMessage(paramArrayOfObject);
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
      this.p = null;
      Object localObject = new FileManagerEntity();
      ((FileManagerEntity)localObject).setCloudType(2);
      ((FileManagerEntity)localObject).WeiYunFileId = localStatusInfo.fileId;
      if (localStatusInfo.jobContext != null) {
        paramArrayOfObject = localStatusInfo.jobContext.file().pDirKey;
      } else {
        paramArrayOfObject = null;
      }
      ((FileManagerEntity)localObject).WeiYunDirKey = paramArrayOfObject;
      this.q = ((FileManagerEntity)localObject);
      a((FileManagerEntity)localObject, null);
      return;
    }
    throw new IllegalArgumentException("handleUploadSucceed: args are invalid");
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
  
  private void e(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 5))
    {
      Object localObject1 = (QQAppInterface)paramArrayOfObject[0];
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramArrayOfObject[1];
      Object localObject2 = (IShareRouter.ShareOptions)paramArrayOfObject[2];
      boolean bool1 = ((Boolean)paramArrayOfObject[3]).booleanValue();
      paramArrayOfObject = (String)paramArrayOfObject[4];
      int i1;
      if (NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication))
      {
        long l1 = LinkUtils.a(((IShareRouter.ShareOptions)localObject2).a);
        if (!FileUtil.b(paramArrayOfObject)) {
          paramArrayOfObject = null;
        }
        WeiYunLogicCenter localWeiYunLogicCenter = ((QQAppInterface)localObject1).getFileManagerEngine().d();
        if (((IShareRouter.ShareOptions)localObject2).b) {
          localObject1 = ((IShareRouter.ShareOptions)localObject2).c;
        } else {
          localObject1 = null;
        }
        boolean bool2 = ((IShareRouter.ShareOptions)localObject2).d;
        i1 = ((IShareRouter.ShareOptions)localObject2).a;
        if (((IShareRouter.ShareOptions)localObject2).b) {
          localObject2 = ((IShareRouter.ShareOptions)localObject2).c;
        } else {
          localObject2 = null;
        }
        localWeiYunLogicCenter.a(localFileManagerEntity, l1, (String)localObject1, bool2, bool1, new WeiyunShareProcessController.GetShareLinkCallback(this, i1, (String)localObject2, paramArrayOfObject, bool1, null));
        i1 = 0;
      }
      else
      {
        i1 = 2;
      }
      if (i1 != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i1), null };
        this.l.sendMessage(paramArrayOfObject);
        return;
      }
      return;
    }
    throw new IllegalArgumentException("handleRequest: args are invalid");
  }
  
  private void f()
  {
    this.f.setVisibility(0);
    TextView localTextView = this.g;
    int i1;
    if (this.b) {
      i1 = 2131896144;
    } else {
      i1 = 2131896146;
    }
    localTextView.setText(i1);
    this.h.setText("");
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
    if (this.k == null)
    {
      this.k = new QQCustomDialog(this.a.getBaseActivity(), 2131953338);
      this.k.setContentView(2131624611);
      this.k.setTitle(2131896154);
      QQCustomDialog localQQCustomDialog = this.k;
      int i1;
      if (this.b) {
        i1 = 2131896156;
      } else {
        i1 = 2131896155;
      }
      localQQCustomDialog.setMessage(i1);
      this.k.setNegativeButton(2131887648, this);
      this.k.setPositiveButton(2131896157, this);
      this.k.setCancelable(true);
      this.k.setCanceledOnTouchOutside(false);
    }
    if (!this.k.isShowing()) {
      this.k.show();
    }
  }
  
  private void g(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      Object localObject = (String)paramArrayOfObject[0];
      int i1 = ((Integer)paramArrayOfObject[1]).intValue();
      String str = (String)paramArrayOfObject[2];
      paramArrayOfObject = null;
      try
      {
        localObject = LinkUtils.a((String)localObject, ViewUtils.dip2px(184.0F));
        paramArrayOfObject = (Object[])localObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("WeiyunShareProcessController<FileAssistant>", 2, "GetQrTask error", localThrowable);
      }
      Message localMessage = new Message();
      localMessage.what = 7;
      localMessage.obj = new Object[] { paramArrayOfObject, Integer.valueOf(i1), str };
      this.l.sendMessage(localMessage);
      return;
    }
    throw new IllegalArgumentException("handleGetQr: args are invalid");
  }
  
  private void h()
  {
    FileManagerEntity localFileManagerEntity = this.a.c();
    String str2 = this.a.g();
    if ((localFileManagerEntity == null) && (TextUtils.isEmpty(str2)))
    {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "startProcess: fileEntity and filePath are invalid");
      return;
    }
    if (this.o) {
      return;
    }
    this.o = true;
    this.a.h();
    Object localObject = this.a.a();
    String str1;
    if (this.b) {
      str1 = "0X800A9D7";
    } else {
      str1 = "0X800A9D6";
    }
    String str3 = LinkUtils.c(((IShareRouter.ShareOptions)localObject).a);
    if (this.b) {
      localObject = null;
    } else {
      localObject = LinkUtils.a(((IShareRouter.ShareOptions)localObject).b);
    }
    LinkUtils.a(str1, str3, (String)localObject);
    if (LinkUtils.a(localFileManagerEntity, false)) {
      a(localFileManagerEntity, str2);
    } else {
      a(str2);
    }
    f();
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
  
  private void i()
  {
    String str = k();
    if (!TextUtils.isEmpty(str))
    {
      LinkUtils.a("0X800A9D8", null, null);
      ClipboardManager localClipboardManager = (ClipboardManager)BaseApplicationImpl.sApplication.getSystemService("clipboard");
      ClipboardMonitor.setText(localClipboardManager, str);
      localClipboardManager.setText(str);
      LinkUtils.a(2, 2131896142, true);
    }
  }
  
  private void j()
  {
    if (!TextUtils.isEmpty(k()))
    {
      LinkUtils.a("0X800A9D9", null, null);
      this.a.a(null);
    }
  }
  
  private String k()
  {
    String str = this.j.getText().toString();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject2 = this.j.getTag();
      Object localObject1 = str;
      if ((localObject2 instanceof String))
      {
        localObject1 = str;
        if (!TextUtils.isEmpty((String)localObject2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(BaseApplicationImpl.sApplication.getString(2131896168));
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      return localObject1;
    }
    return null;
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
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    TextView localTextView = this.d;
    int i1;
    if (this.b) {
      i1 = 2131896147;
    } else {
      i1 = 2131896148;
    }
    localTextView.setText(i1);
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    localTextView = this.g;
    if (this.b) {
      i1 = 2131896143;
    } else {
      i1 = 2131896145;
    }
    localTextView.setText(i1);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.j.setText("");
    this.j.setTag(null);
    boolean bool = this.o;
    this.o = false;
    if (bool) {
      this.a.h();
    }
    this.r = null;
  }
  
  void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    int i2 = paramActionSheetItem.action;
    Object localObject1 = this.a.getBaseActivity();
    if (localObject1 != null)
    {
      if (((BaseActivity)localObject1).isFinishing()) {
        return;
      }
      boolean bool = NetworkUtil.isNetSupport((Context)localObject1);
      int i1 = 0;
      if (!bool)
      {
        LinkUtils.a(0, 2131889169, false);
        if (QLog.isColorLevel()) {
          QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "toShare: net is not supported");
        }
        return;
      }
      if ((i2 == 2) || (i2 == 3) || (i2 == 9) || (i2 == 10) || (i2 == 72))
      {
        String str = k();
        if (TextUtils.isEmpty(str)) {
          return;
        }
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if ((i2 != 9) && (i2 != 10))
            {
              if (i2 != 72) {
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
            paramActionSheetItem = this.a.i();
            localObject1 = WXShareHelper.a();
            if (i2 != 9) {
              i1 = 1;
            }
            ((WXShareHelper)localObject1).a(str, i1, paramActionSheetItem);
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
          QZoneHelper.forwardToPublishMood((Activity)localObject1, paramActionSheetItem, "", ((BaseActivity)localObject1).getString(2131889086), str, 2);
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
  
  List<ShareActionSheetBuilder.ActionSheetItem> b(Context paramContext)
  {
    return new ArrayList();
  }
  
  boolean b()
  {
    return this.o;
  }
  
  boolean c()
  {
    return this.p != null;
  }
  
  void d()
  {
    WeiyunTask localWeiyunTask = this.p;
    this.p = null;
    if (localWeiyunTask != null) {
      localWeiyunTask.a();
    }
  }
  
  void e()
  {
    this.s = true;
    QQCustomDialog localQQCustomDialog = this.k;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.k = null;
    }
    d();
    this.l.removeCallbacksAndMessages(null);
    this.m.removeCallbacksAndMessages(null);
    this.n.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.s) {
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
    if ((paramDialogInterface.equals(this.k)) && (paramInt != 0))
    {
      if (paramInt != 1) {
        return;
      }
      IOpenWeiyunVipHelper localIOpenWeiyunVipHelper = (IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class);
      BaseActivity localBaseActivity = this.a.getBaseActivity();
      if (this.b) {
        paramDialogInterface = "an_qq_qrcode_overcapacity";
      } else {
        paramDialogInterface = "an_qq_link_overcapacity";
      }
      localIOpenWeiyunVipHelper.startOpenWeiyunVipCompareH5(localBaseActivity, paramDialogInterface, false);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131437257)
    {
      if (i1 != 2131437268)
      {
        if (i1 == 2131440669) {
          h();
        }
      }
      else {
        j();
      }
    }
    else {
      i();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareProcessController
 * JD-Core Version:    0.7.0.1
 */