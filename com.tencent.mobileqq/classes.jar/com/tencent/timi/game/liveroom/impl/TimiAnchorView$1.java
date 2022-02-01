package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;
import com.tencent.timi.game.utils.Logger;

class TimiAnchorView$1
  implements IQQGiftResourceDownloadCallback
{
  TimiAnchorView$1(TimiAnchorView paramTimiAnchorView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAllFinished: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt2);
    Logger.c("TimiAnchorView", localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSingleFinished: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    Logger.c("TimiAnchorView", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAnchorView.1
 * JD-Core Version:    0.7.0.1
 */