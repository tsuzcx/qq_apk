package com.tencent.mobileqq.filemanageraux.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.webdownload.DownloadURLCheck.ReqDownloadUrlCheckRecmd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class UniformDownload$UniDownloadListener
  implements DialogInterface.OnDismissListener, Handler.Callback, DownloadListener
{
  final MqqHandler a = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private WeakReference<AppInterface> b;
  private WeakReference<Activity> c;
  private WeakReference<TouchWebView> d;
  private boolean e;
  private Dialog f;
  private boolean g;
  
  public UniformDownload$UniDownloadListener(AppInterface paramAppInterface, Activity paramActivity, TouchWebView paramTouchWebView)
  {
    this.b = new WeakReference(paramAppInterface);
    this.c = new WeakReference(paramActivity);
    this.d = new WeakReference(paramTouchWebView);
    if (paramTouchWebView == null) {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "constructor: webview is null");
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong, Activity paramActivity, AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a.sendEmptyMessage(1);
    }
    DownloadURLCheck.ReqDownloadUrlCheckRecmd localReqDownloadUrlCheckRecmd = new DownloadURLCheck.ReqDownloadUrlCheckRecmd();
    localReqDownloadUrlCheckRecmd.download_url.set(paramString1);
    localReqDownloadUrlCheckRecmd.mime_type.set(paramString2);
    try
    {
      localReqDownloadUrlCheckRecmd.uin.set(Long.parseLong(paramAppInterface.getCurrentAccountUin()));
    }
    catch (NumberFormatException paramString2)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, paramString2, new Object[0]);
    }
    paramString2 = new NewIntent(paramActivity.getApplicationContext(), WebSSOAgentServlet.class);
    paramString2.putExtra("extra_cmd", "QQApkSvc.check_download_url");
    paramString2.putExtra("extra_data", localReqDownloadUrlCheckRecmd.toByteArray());
    paramString2.setObserver(new UniformDownload.UniDownloadListener.1(this, paramString1, paramLong, paramBoolean));
    paramAppInterface.startServlet(paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return true;
      }
      paramMessage = this.f;
      if ((paramMessage != null) && (paramMessage.isShowing()))
      {
        this.f.dismiss();
        return true;
      }
    }
    else
    {
      paramMessage = (Activity)this.c.get();
      if (paramMessage != null)
      {
        if (paramMessage.isFinishing()) {
          return true;
        }
        if (this.f == null)
        {
          this.f = new ReportDialog(paramMessage);
          this.f.getWindow().setBackgroundDrawable(new ColorDrawable(0));
          this.f.setCanceledOnTouchOutside(false);
          this.f.requestWindowFeature(1);
          this.f.setOnDismissListener(this);
          this.f.setContentView(2131628218);
          this.f.findViewById(2131429409).setBackgroundColor(0);
          ((TextView)this.f.findViewById(2131447062)).setText(HardCodeUtil.a(2131913129));
        }
        this.f.show();
      }
    }
    return true;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.g = true;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    Object localObject1 = (TouchWebView)this.d.get();
    Activity localActivity = (Activity)this.c.get();
    Object localObject2 = (AppInterface)this.b.get();
    if ((localObject1 != null) && (localActivity != null) && (localObject2 != null) && (!localActivity.isFinishing()))
    {
      boolean bool2 = false;
      this.g = false;
      boolean bool1 = bool2;
      if (((TouchWebView)localObject1).getUrl() != null)
      {
        bool1 = bool2;
        if (((TouchWebView)localObject1).getUrl().equals(paramString1)) {
          bool1 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start UniformDownloadActivity: ");
        localStringBuilder.append(paramString4);
        QLog.d("UniformDownloadMgr<FileAssistant>", 2, localStringBuilder.toString());
      }
      if ("application/vnd.android.package-archive".equals(paramString4))
      {
        a(paramString1, paramString4, paramLong, localActivity, (AppInterface)localObject2, bool1);
        return;
      }
      localObject1 = ((TouchWebView)localObject1).getUrl();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("_filesize", paramLong);
      ((Bundle)localObject2).putString("param_user_agent", paramString2);
      ((Bundle)localObject2).putString("param_content_des", paramString3);
      ((Bundle)localObject2).putString("param_mime_type", paramString4);
      ((Bundle)localObject2).putString("param_refer_url", (String)localObject1);
      ((Bundle)localObject2).putBoolean("fromArkAppDownload", this.e);
      if ((UniformDownload.a(localActivity, paramString1, (Bundle)localObject2)) && (bool1)) {
        localActivity.finish();
      }
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("download failed, webview=");
    paramString1.append(localObject1);
    paramString1.append(", act=");
    paramString1.append(localActivity);
    paramString1.append(", app=");
    paramString1.append(localObject2);
    QLog.e("UniformDownloadMgr<FileAssistant>", 1, paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.app.UniformDownload.UniDownloadListener
 * JD-Core Version:    0.7.0.1
 */