package com.tencent.mobileqq.qqlive.data.anchor.sso;

import java.util.ArrayList;
import java.util.Iterator;

public class QQLiveAnchorDataFrame
{
  public ArrayList<QQLiveAnchorDataAddress> addresses;
  public int codecType;
  public String definition;
  public int level;
  
  public QQLiveAnchorDataFrame() {}
  
  public QQLiveAnchorDataFrame(QQLiveAnchorDataFrame paramQQLiveAnchorDataFrame)
  {
    if (paramQQLiveAnchorDataFrame == null) {
      return;
    }
    this.level = paramQQLiveAnchorDataFrame.level;
    this.definition = paramQQLiveAnchorDataFrame.definition;
    this.codecType = paramQQLiveAnchorDataFrame.codecType;
    if (paramQQLiveAnchorDataFrame.addresses != null)
    {
      this.addresses = new ArrayList();
      paramQQLiveAnchorDataFrame = paramQQLiveAnchorDataFrame.addresses.iterator();
      while (paramQQLiveAnchorDataFrame.hasNext())
      {
        QQLiveAnchorDataAddress localQQLiveAnchorDataAddress = (QQLiveAnchorDataAddress)paramQQLiveAnchorDataFrame.next();
        this.addresses.add(new QQLiveAnchorDataAddress(localQQLiveAnchorDataAddress));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFrame
 * JD-Core Version:    0.7.0.1
 */