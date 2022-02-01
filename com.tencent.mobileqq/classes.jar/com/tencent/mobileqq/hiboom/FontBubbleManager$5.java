package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;

class FontBubbleManager$5
  extends MessageObserver
{
  FontBubbleManager$5(FontBubbleManager paramFontBubbleManager) {}
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    this.a.a(paramLong);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams)
  {
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.5
 * JD-Core Version:    0.7.0.1
 */