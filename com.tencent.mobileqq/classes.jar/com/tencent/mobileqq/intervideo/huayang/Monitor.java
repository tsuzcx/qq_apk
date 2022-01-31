package com.tencent.mobileqq.intervideo.huayang;

import aecw;
import com.tencent.mobileqq.app.ThreadManager;

public class Monitor
{
  public static boolean a = true;
  
  public static void a(String paramString)
  {
    if (a) {
      b(paramString);
    }
  }
  
  public static void b(String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new aecw("http://cgi.pub.qq.com/report/report_vm?monitors=[$ID$]&t=$TIMESTAMP$".replace("$ID$", paramString).replace("$TIMESTAMP$", String.valueOf(System.currentTimeMillis()))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.Monitor
 * JD-Core Version:    0.7.0.1
 */