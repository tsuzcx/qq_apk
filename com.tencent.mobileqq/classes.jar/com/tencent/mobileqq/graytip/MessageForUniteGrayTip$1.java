package com.tencent.mobileqq.graytip;

import com.tencent.mobileqq.data.MessageForGrayTips.HighlightItem;
import java.util.Comparator;

class MessageForUniteGrayTip$1
  implements Comparator<MessageForGrayTips.HighlightItem>
{
  MessageForUniteGrayTip$1(MessageForUniteGrayTip paramMessageForUniteGrayTip) {}
  
  public int a(MessageForGrayTips.HighlightItem paramHighlightItem1, MessageForGrayTips.HighlightItem paramHighlightItem2)
  {
    return paramHighlightItem1.start - paramHighlightItem2.start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.MessageForUniteGrayTip.1
 * JD-Core Version:    0.7.0.1
 */