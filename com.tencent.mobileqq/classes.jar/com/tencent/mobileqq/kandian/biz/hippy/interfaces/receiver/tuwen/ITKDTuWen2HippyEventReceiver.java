package com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen;

import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;

public abstract interface ITKDTuWen2HippyEventReceiver
  extends ITKDHippyEventReceiver
{
  public abstract void onDeleteMainComment(String paramString);
  
  public abstract void onDeleteSubComment(String paramString1, String paramString2);
  
  public abstract void onInsertSubComment(String paramString1, String paramString2, String paramString3);
  
  public abstract void onLikeMainCommentChanged(String paramString, boolean paramBoolean);
  
  public abstract void onOpenCommentPublisher();
  
  public abstract void sendCommentReadTime(long paramLong);
  
  public abstract void updateFollowUI(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.ITKDTuWen2HippyEventReceiver
 * JD-Core Version:    0.7.0.1
 */