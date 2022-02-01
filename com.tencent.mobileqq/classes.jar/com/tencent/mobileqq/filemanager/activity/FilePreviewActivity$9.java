package com.tencent.mobileqq.filemanager.activity;

import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$9
  implements FileWebView.TitilebarEventInterface
{
  long a = 0L;
  
  FilePreviewActivity$9(FilePreviewActivity paramFilePreviewActivity, Handler paramHandler) {}
  
  public void a()
  {
    this.c.d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.e();
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    if (l - this.a < 1000L) {
      return;
    }
    this.a = l;
    if (this.c.l) {
      return;
    }
    if (this.c.M)
    {
      this.c.e();
      return;
    }
    if (this.c.C != null)
    {
      this.c.C.n = "3";
      this.c.C.s = System.currentTimeMillis();
    }
    if (!NetworkUtil.isNetSupport(this.c.getActivity()))
    {
      this.c.y.setVisibility(8);
      this.c.z.setText(2131891374);
      this.c.z.setVisibility(0);
      this.c.u.setVisibility(0);
      if (this.c.C != null)
      {
        this.c.C.t = System.currentTimeMillis();
        this.c.C.o = (this.c.C.t - this.c.C.s);
        this.c.C.q = false;
        this.c.C.e = "2";
        this.c.C.p = (System.currentTimeMillis() - this.c.C.b);
        this.c.C.a();
      }
      this.c.a(5000);
      return;
    }
    this.c.f();
    new Handler().postDelayed(new FilePreviewActivity.9.1(this), 1500L);
  }
  
  public void c()
  {
    FilePreviewActivity.9.2 local2 = new FilePreviewActivity.9.2(this);
    this.b.postDelayed(local2, 3000L);
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "postDelayed(newRunnable, 3000)");
  }
  
  public void d()
  {
    this.c.runOnUiThread(new FilePreviewActivity.9.3(this));
  }
  
  public void e()
  {
    this.c.runOnUiThread(new FilePreviewActivity.9.4(this));
  }
  
  public void f()
  {
    this.c.a(1000);
  }
  
  public void g()
  {
    if (this.c.M) {
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.a < 1000L) {
      return;
    }
    this.a = l;
    if (this.c.l) {
      return;
    }
    this.c.d.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9
 * JD-Core Version:    0.7.0.1
 */