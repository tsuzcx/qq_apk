package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class SetFontBubble
{
  private static AtomicInteger c = new AtomicInteger();
  public int a = c.getAndIncrement();
  public FontBubble b;
  
  public SetFontBubble(FontBubble paramFontBubble)
  {
    this.b = paramFontBubble;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFontBubble: ");
      localStringBuilder.append(this.b.fontId);
      localStringBuilder.append(",");
      localStringBuilder.append(this.b.bubbleId);
      QLog.e("FontBubbleManager", 1, localStringBuilder.toString());
    }
    ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(this.b.fontId, this.b.bubbleId, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.SetFontBubble
 * JD-Core Version:    0.7.0.1
 */