package com.tencent.mobileqq.winkpublish.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class FSQUICStatus
{
  private String a;
  private boolean b;
  private int c;
  private int d;
  private int e;
  private int f;
  private volatile boolean g;
  private FSQUICStatus.QUICListener h;
  
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
    if ((this.h != null) && (!this.g))
    {
      this.g = true;
      this.h.a(this);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|reportQUICToHTTP() return:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("QUICStatus", 1, localStringBuilder.toString());
  }
  
  public void a()
  {
    this.c += 1;
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|increaseQUICCompleteCount():");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("QUICStatus", 1, localStringBuilder.toString());
  }
  
  public void a(FSQUICStatus.QUICListener paramQUICListener)
  {
    this.h = paramQUICListener;
  }
  
  public void b()
  {
    this.d += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|increaseHttpCompleteCount():");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("QUICStatus", 1, localStringBuilder.toString());
    if (this.e > 0)
    {
      f();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append("|increaseHttpCompleteCount(): trigger report,");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" | ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" url");
      localStringBuilder.append(this.a);
      QLog.d("QUICStatus", 1, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    this.e += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|increaseQUICFailedCount():");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("QUICStatus", 1, localStringBuilder.toString());
    if (this.d > 0)
    {
      f();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append("|increaseQUICFailedCount(): trigger report,");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" | ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" url");
      localStringBuilder.append(this.a);
      QLog.d("QUICStatus", 1, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    this.f += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|increaseHTTPFailedCount():");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" url");
    localStringBuilder.append(this.a);
    QLog.d("QUICStatus", 1, localStringBuilder.toString());
  }
  
  public void e()
  {
    this.b = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|setIsDownLoadByQUIC() true url");
    localStringBuilder.append(this.a);
    QLog.d("QUICStatus", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSQUICStatus
 * JD-Core Version:    0.7.0.1
 */