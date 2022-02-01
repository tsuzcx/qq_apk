package com.tencent.mobileqq.flashshow.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class FSQUICStatus
{
  private String a;
  private int b;
  private int c;
  private int d;
  private int e;
  private volatile boolean f;
  private FSQUICStatus.QUICListener g;
  
  public FSQUICStatus(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.a = str;
  }
  
  private void f()
  {
    if ((this.g != null) && (!this.f))
    {
      this.f = true;
      this.g.a(this);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|reportQUICToHTTP() return:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("FSQUICStatus", 1, localStringBuilder.toString());
  }
  
  public void a()
  {
    this.b += 1;
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|increaseQUICCompleteCount():");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("FSQUICStatus", 1, localStringBuilder.toString());
  }
  
  public void a(FSQUICStatus.QUICListener paramQUICListener)
  {
    this.g = paramQUICListener;
  }
  
  public void b()
  {
    this.c += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|increaseHttpCompleteCount():");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("FSQUICStatus", 1, localStringBuilder.toString());
    if (this.d > 0)
    {
      f();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append("|increaseHttpCompleteCount(): trigger report,");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" | ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" url");
      localStringBuilder.append(this.a);
      QLog.d("FSQUICStatus", 1, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    this.d += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|increaseQUICFailedCount():");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("FSQUICStatus", 1, localStringBuilder.toString());
    if (this.c > 0)
    {
      f();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append("|increaseQUICFailedCount(): trigger report,");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" | ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" url");
      localStringBuilder.append(this.a);
      QLog.d("FSQUICStatus", 1, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    this.e += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|increaseHTTPFailedCount():");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("FSQUICStatus", 1, localStringBuilder.toString());
  }
  
  public void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|setIsDownLoadByQUIC() true url");
    localStringBuilder.append(this.a);
    QLog.d("FSQUICStatus", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.FSQUICStatus
 * JD-Core Version:    0.7.0.1
 */