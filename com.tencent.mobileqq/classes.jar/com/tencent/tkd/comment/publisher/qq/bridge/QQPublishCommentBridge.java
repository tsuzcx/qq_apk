package com.tencent.tkd.comment.publisher.qq.bridge;

import android.text.Editable;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import org.json.JSONObject;

public abstract interface QQPublishCommentBridge
{
  public static final QQPublishCommentBridge EMPTY = new QQPublishCommentBridge.1();
  public static final int TOAST_TYPE_DEFAULT = 0;
  public static final int TOAST_TYPE_ERROR = 1;
  public static final int TOAST_TYPE_NONE = -1;
  public static final int TOAST_TYPE_SUCCESS = 2;
  
  public abstract JSONObject buildArticleBiuCommentInfo(Editable paramEditable);
  
  public abstract TkdQQArgument getArgument();
  
  public abstract String getCommentString(Editable paramEditable);
  
  public abstract boolean isNetworkAvailable();
  
  public abstract void showToast(String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge
 * JD-Core Version:    0.7.0.1
 */