package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.huayang.impl.IMonitor;

public class Monitor
  implements IMonitor
{
  public static boolean a = true;
  
  public static void a(String paramString)
  {
    if (a) {
      b(paramString);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static void b(String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new Monitor.1("https://cgi.pub.qq.com/report/report_vm?monitors=[$ID$]&t=$TIMESTAMP$".replace("$ID$", paramString).replace("$TIMESTAMP$", String.valueOf(System.currentTimeMillis()))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.Monitor
 * JD-Core Version:    0.7.0.1
 */