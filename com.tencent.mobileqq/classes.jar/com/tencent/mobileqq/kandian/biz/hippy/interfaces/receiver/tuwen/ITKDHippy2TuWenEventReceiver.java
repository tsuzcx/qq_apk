package com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen;

import com.tencent.mobileqq.kandian.biz.comment.ICommentNumChangedListener;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;

public abstract interface ITKDHippy2TuWenEventReceiver
  extends ICommentNumChangedListener, ITKDHippyEventReceiver
{
  public abstract void forbidScroll(boolean paramBoolean);
  
  public abstract void onHippyForbiddenChanged(int paramInt);
  
  public abstract void onHippyLoadStatusChanged(int paramInt);
  
  public abstract void openSubCommentPage(String paramString1, String paramString2);
  
  public abstract void scrollToNew();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.ITKDHippy2TuWenEventReceiver
 * JD-Core Version:    0.7.0.1
 */