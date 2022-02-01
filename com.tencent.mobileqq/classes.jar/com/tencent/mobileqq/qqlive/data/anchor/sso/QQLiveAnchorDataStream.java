package com.tencent.mobileqq.qqlive.data.anchor.sso;

import java.util.ArrayList;
import java.util.Iterator;

public class QQLiveAnchorDataStream
{
  public ArrayList<QQLiveAnchorDataFrame> frames;
  public String name;
  public int rawLevel;
  
  public QQLiveAnchorDataStream() {}
  
  public QQLiveAnchorDataStream(QQLiveAnchorDataStream paramQQLiveAnchorDataStream)
  {
    if (paramQQLiveAnchorDataStream == null) {
      return;
    }
    this.name = paramQQLiveAnchorDataStream.name;
    this.rawLevel = paramQQLiveAnchorDataStream.rawLevel;
    this.frames = new ArrayList();
    paramQQLiveAnchorDataStream = paramQQLiveAnchorDataStream.frames;
    if (paramQQLiveAnchorDataStream != null)
    {
      paramQQLiveAnchorDataStream = paramQQLiveAnchorDataStream.iterator();
      while (paramQQLiveAnchorDataStream.hasNext())
      {
        QQLiveAnchorDataFrame localQQLiveAnchorDataFrame = (QQLiveAnchorDataFrame)paramQQLiveAnchorDataStream.next();
        this.frames.add(new QQLiveAnchorDataFrame(localQQLiveAnchorDataFrame));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStream
 * JD-Core Version:    0.7.0.1
 */