package com.tencent.tkd.comment.publisher.qq.util;

import com.tencent.tkd.comment.publisher.qq.QQPublishCommentManager;
import com.tencent.tkd.comment.publisher.qq.bridge.QQSharedPreferenceBridge;

public class TkdQQSharedPreferences
{
  public static <T> T getValue(String paramString, T paramT)
  {
    return QQPublishCommentManager.getInstance().getSpBridge().getValue(paramString, paramT);
  }
  
  public static <T> void setValue(String paramString, T paramT)
  {
    QQPublishCommentManager.getInstance().getSpBridge().setValue(paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.util.TkdQQSharedPreferences
 * JD-Core Version:    0.7.0.1
 */