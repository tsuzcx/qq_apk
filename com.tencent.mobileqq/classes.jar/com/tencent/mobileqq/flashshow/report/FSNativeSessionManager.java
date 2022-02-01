package com.tencent.mobileqq.flashshow.report;

import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class FSNativeSessionManager
{
  private static FSNativeSessionManager a;
  private String b;
  
  public static FSNativeSessionManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSNativeSessionManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void d()
  {
    StringBuilder localStringBuilder = new StringBuilder("android_session_kuaishan_");
    localStringBuilder.append(FSTransUtils.a());
    localStringBuilder.append("_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_");
    localStringBuilder.append(new Random().nextInt(100));
    this.b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("generateNativeSession  mSessionId = ");
    localStringBuilder.append(this.b);
    QLog.i("FSNativeSessionManager", 1, localStringBuilder.toString());
  }
  
  public String b()
  {
    if (this.b == null) {
      d();
    }
    return this.b;
  }
  
  public void c()
  {
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.FSNativeSessionManager
 * JD-Core Version:    0.7.0.1
 */