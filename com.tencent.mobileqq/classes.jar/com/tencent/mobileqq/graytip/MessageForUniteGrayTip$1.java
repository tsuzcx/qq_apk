package com.tencent.mobileqq.graytip;

import com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem;
import java.util.Comparator;

class MessageForUniteGrayTip$1
  implements Comparator<GrayTipsMessageConstants.HighlightItem>
{
  MessageForUniteGrayTip$1(MessageForUniteGrayTip paramMessageForUniteGrayTip) {}
  
  public int a(GrayTipsMessageConstants.HighlightItem paramHighlightItem1, GrayTipsMessageConstants.HighlightItem paramHighlightItem2)
  {
    return paramHighlightItem1.start - paramHighlightItem2.start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.MessageForUniteGrayTip.1
 * JD-Core Version:    0.7.0.1
 */