package com.tencent.mobileqq.shortvideo.gesture;

import android.graphics.PointF;
import android.graphics.RectF;

public class GestureKeyInfo
{
  int dataHeight = 0;
  int dataWidth = 0;
  public RectF hotArea = null;
  public PointF[] hotPoints = null;
  int originHeight = 0;
  int originWidth = 0;
  public long timeStamp = 0L;
  public String type;
  public boolean vaild = false;
  
  public void copyTo(GestureKeyInfo paramGestureKeyInfo)
  {
    paramGestureKeyInfo.vaild = this.vaild;
    paramGestureKeyInfo.type = this.type;
    paramGestureKeyInfo.timeStamp = this.timeStamp;
    paramGestureKeyInfo.hotPoints = this.hotPoints;
    paramGestureKeyInfo.hotArea = this.hotArea;
    paramGestureKeyInfo.dataWidth = this.dataWidth;
    paramGestureKeyInfo.dataHeight = this.dataHeight;
    paramGestureKeyInfo.originWidth = this.originWidth;
    paramGestureKeyInfo.originHeight = this.originHeight;
  }
  
  public void reset()
  {
    this.type = null;
    this.vaild = false;
    this.timeStamp = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo
 * JD-Core Version:    0.7.0.1
 */