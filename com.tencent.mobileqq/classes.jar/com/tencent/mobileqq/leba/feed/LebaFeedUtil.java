package com.tencent.mobileqq.leba.feed;

import com.tencent.qphone.base.util.QLog;

public class LebaFeedUtil
{
  public static boolean a = true;
  
  public static void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsShowQzoneFrame isShow=");
    localStringBuilder.append(paramBoolean);
    QLog.i("LebaFeedUtil", 1, localStringBuilder.toString());
    a = paramBoolean;
  }
  
  public static boolean a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.feed.LebaFeedUtil
 * JD-Core Version:    0.7.0.1
 */