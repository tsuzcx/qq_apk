package com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common;

import com.tencent.mobileqq.kandian.biz.hippy.api.ParamsFetcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;

public abstract interface ITKDHippy2NativeEventReceiver
  extends ITKDHippyEventReceiver
{
  public abstract void biuComment(ParamsFetcher paramParamsFetcher);
  
  public abstract void closeComment();
  
  public abstract void onClickLike(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onCommentViewLayout();
  
  public abstract void onCreateComment(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract void onDeleteComment(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onSubCommentClose();
  
  public abstract void onSubCommentOpen();
  
  public abstract void openComment();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.ITKDHippy2NativeEventReceiver
 * JD-Core Version:    0.7.0.1
 */