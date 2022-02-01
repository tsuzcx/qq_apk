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
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<Activity> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private WeakReference<TouchWebView> c;
  
  public UniformDownload$UniDownloadListener(AppInterface paramAppInterface, Activity paramActivity, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.c = new WeakReference(paramTouchWebView);
    if (paramTouchWebView == null) {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "constructor: webview is null");
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong, Activity paramActivity, AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
    DownloadURLCheck.ReqDownloadUrlCheckRecmd localReqDownloadUrlCheckRecmd = new DownloadURLCheck.ReqDownloadUrlCheckRecmd();
    localReqDownloadUrlCheckRecmd.download_url.set(paramString1);
    localReqDownloadUrlCheckRecmd.mime_type.set(paramString2);
    try
    {
      localReqDownloadUrlCheckRecmd.uin.set(Long.parseLong(paramAppInterface.getCurrentAccountUin()));
      paramString2 = new NewIntent(paramActivity.getApplicationContext(), WebSSOAgentServlet.class);
      paramString2.putExtra("extra_cmd", "QQApkSvc.check_download_url");
      paramString2.putExtra("extra_data", localReqDownloadUrlCheckRecmd.toByteArray());
      paramString2.setObserver(new UniformDownload.UniDownloadListener.1(this, paramString1, paramLong, paramBoolean));
      paramAppInterface.startServlet(paramString2);
      return;
    }
    catch (NumberFormatException paramString2)
    {
      for (;;)
      {
        QLog.e("UniformDownloadMgr<FileAssistant>", 1, paramString2, new Object[0]);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        paramMessage = (Activity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      } while ((paramMessage == null) || (paramMessage.isFinishing()));
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(paramMessage);
        this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131562006);
        this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363584).setBackgroundColor(0);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131379091)).setText(HardCodeUtil.a(2131715737));
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
      return true;
    } while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing()));
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    return true;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    boolean bool = true;
    Object localObject1 = (TouchWebView)this.c.get();
    Activity localActivity = (Activity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    Object localObject2 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject1 == null) || (localActivity == null) || (localObject2 == null) || (localActivity.isFinishing())) {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "download failed, webview=" + localObject1 + ", act=" + localActivity + ", app=" + localObject2);
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      if ((((TouchWebView)localObject1).getUrl() != null) && (((TouchWebView)localObject1).getUrl().equals(paramString1))) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UniformDownloadMgr<FileAssistant>", 2, "start UniformDownloadActivity: " + paramString4);
        }
        if (!"application/vnd.android.package-archive".equals(paramString4)) {
          break;
        }
        a(paramString1, paramString4, paramLong, localActivity, (AppInterface)localObject2, bool);
        return;
        bool = false;
      }
      localObject1 = ((TouchWebView)localObject1).getUrl();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("_filesize", paramLong);
      ((Bundle)localObject2).putString("param_user_agent", paramString2);
      ((Bundle)localObject2).putString("param_content_des", paramString3);
      ((Bundle)localObject2).putString("param_mime_type", paramString4);
      ((Bundle)localObject2).putString("param_refer_url", (String)localObject1);
      ((Bundle)localObject2).putBoolean("fromArkAppDownload", this.jdField_a_of_type_Boolean);
    } while ((!UniformDownload.a(localActivity, paramString1, (Bundle)localObject2)) || (!bool));
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.app.UniformDownload.UniDownloadListener
 * JD-Core Version:    0.7.0.1
 */