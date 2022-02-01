package com.tencent.tkd.comment.publisher.qq.util;

import com.tencent.tkd.comment.publisher.qq.QQPublishCommentManager;
import com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge;

public class TkdQQToast
{
  public static void show(String paramString, int paramInt)
  {
    show(paramString, paramInt, 0);
  }
  
  public static void show(String paramString, int paramInt1, int paramInt2)
  {
    QQPublishCommentManager.getInstance().getPublisherBridge().showToast(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.util.TkdQQToast
 * JD-Core Version:    0.7.0.1
 */