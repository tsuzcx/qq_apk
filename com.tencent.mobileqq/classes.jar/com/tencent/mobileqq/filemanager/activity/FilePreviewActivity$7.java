package com.tencent.mobileqq.filemanager.activity;

import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$7
  implements ControlerCallback
{
  FilePreviewActivity$7(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (this.a.H) {
      return;
    }
    if (this.a.C != null) {
      this.a.C.t = System.currentTimeMillis();
    }
    this.a.H = true;
    if (!paramBoolean)
    {
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        this.a.x.setText(paramString3);
      } else {
        this.a.x.setText(HardCodeUtil.a(2131902576));
      }
      this.a.A.setVisibility(0);
      this.a.A.setOnClickListener(null);
      this.a.w.setVisibility(0);
      this.a.x.setVisibility(0);
      paramString1 = this.a;
      paramString1.M = true;
      paramString1.stopTitleProgress();
      if (this.a.C != null)
      {
        this.a.C.q = false;
        this.a.C.o = (this.a.C.t - this.a.C.s);
        this.a.C.e = String.valueOf(paramLong);
        this.a.C.k = paramString3;
        this.a.C.d = paramString6;
        this.a.C.p = (System.currentTimeMillis() - this.a.C.b);
        this.a.C.a();
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("OnCSReplay[false],retMsg[");
        paramString1.append(paramString3);
        paramString1.append("]");
        QLog.e("<FileAssistant>FilePreviewActivity", 2, paramString1.toString());
      }
      return;
    }
    if (paramBundle != null)
    {
      paramBoolean = paramBundle.getBoolean("ishttps", false);
      if (paramBoolean)
      {
        paramString1 = paramBundle.getString("httpsdomain", null);
        paramString3 = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramBundle.getShort("httpsport", (short)0));
        localStringBuilder.append("");
        paramString3.q = localStringBuilder.toString();
      }
    }
    else
    {
      paramBoolean = false;
    }
    paramString3 = this.a;
    paramString3.p = paramString1;
    paramString3.q = paramString2;
    paramString3.r = paramBoolean;
    paramString3.m = paramString4;
    paramString3.n = paramString5;
    if (paramBoolean)
    {
      paramString5 = new StringBuilder();
      paramString5.append("https://");
      paramString5.append(paramString1);
      paramString5.append(":");
      paramString5.append(paramString2);
      paramString5.append("/ftn_doc_previewer/");
      paramString5.append(this.a.t);
      paramString3.e = paramString5.toString();
    }
    else
    {
      paramString5 = new StringBuilder();
      paramString5.append("http://");
      paramString5.append(paramString1);
      paramString5.append(":");
      paramString5.append(paramString2);
      paramString5.append("/ftn_doc_previewer/");
      paramString5.append(this.a.t);
      paramString3.e = paramString5.toString();
    }
    paramString2 = this.a;
    paramString2.E = paramString6;
    if (paramString2.C != null)
    {
      this.a.C.q = true;
      this.a.C.h = paramString4;
      this.a.C.k = "";
      this.a.C.t = System.currentTimeMillis();
      this.a.C.o = (this.a.C.t - this.a.C.s);
      this.a.C.c = paramString1;
      this.a.C.g = this.a.e;
      this.a.C.d = paramString6;
      this.a.C.p = (System.currentTimeMillis() - this.a.C.b);
      this.a.C.a();
    }
    if (this.a.e == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("mPreviewUrl is null ,threadid[");
        paramString1.append(Thread.currentThread().getId());
        paramString1.append("], mainId[");
        paramString1.append(Looper.getMainLooper().getThread().getId());
        paramString1.append("]");
        QLog.e("<FileAssistant>FilePreviewActivity", 2, paramString1.toString());
      }
      this.a.finish();
      return;
    }
    this.a.d.loadUrl(this.a.e);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("time[");
      paramString1.append(System.currentTimeMillis());
      paramString1.append("]OnCSReplay mWebView.loadUrl(");
      paramString1.append(this.a.e);
      paramString1.append(")");
      QLog.i("<FileAssistant>FilePreviewActivity", 2, paramString1.toString());
    }
    if (this.a.C != null)
    {
      this.a.C.s = System.currentTimeMillis();
      this.a.C.n = "2";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */