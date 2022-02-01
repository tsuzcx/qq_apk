package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;

class FontBubbleManager$5
  extends MessageObserver
{
  FontBubbleManager$5(FontBubbleManager paramFontBubbleManager) {}
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    this.a.a(paramLong);
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.5
 * JD-Core Version:    0.7.0.1
 */