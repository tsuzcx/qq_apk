package com.tencent.mobileqq.qqlive.data.anchor.sso;

import java.util.ArrayList;
import java.util.Iterator;

public class QQLiveAnchorDataRoomRichTitle
{
  public ArrayList<QQLiveAnchorDataRichTitleElement> elements;
  
  public QQLiveAnchorDataRoomRichTitle() {}
  
  public QQLiveAnchorDataRoomRichTitle(QQLiveAnchorDataRoomRichTitle paramQQLiveAnchorDataRoomRichTitle)
  {
    if (paramQQLiveAnchorDataRoomRichTitle != null)
    {
      if (paramQQLiveAnchorDataRoomRichTitle.elements == null) {
        return;
      }
      this.elements = new ArrayList();
      paramQQLiveAnchorDataRoomRichTitle = paramQQLiveAnchorDataRoomRichTitle.elements.iterator();
      while (paramQQLiveAnchorDataRoomRichTitle.hasNext())
      {
        QQLiveAnchorDataRichTitleElement localQQLiveAnchorDataRichTitleElement = (QQLiveAnchorDataRichTitleElement)paramQQLiveAnchorDataRoomRichTitle.next();
        this.elements.add(new QQLiveAnchorDataRichTitleElement(localQQLiveAnchorDataRichTitleElement));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomRichTitle
 * JD-Core Version:    0.7.0.1
 */