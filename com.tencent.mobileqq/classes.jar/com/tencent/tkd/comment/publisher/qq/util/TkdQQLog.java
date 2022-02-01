package com.tencent.tkd.comment.publisher.qq.util;

import com.tencent.tkd.comment.publisher.qq.QQPublishCommentManager;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLogBridge;

public class TkdQQLog
{
  public static void d(String paramString1, String paramString2)
  {
    QQPublishCommentManager.getInstance().getLogBridge().d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    QQPublishCommentManager.getInstance().getLogBridge().e(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    QQPublishCommentManager.getInstance().getLogBridge().i(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    QQPublishCommentManager.getInstance().getLogBridge().w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.util.TkdQQLog
 * JD-Core Version:    0.7.0.1
 */