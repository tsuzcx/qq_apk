package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.PointF;

class AEGenderDetectorOld$GenderParams
{
  long faceID;
  int genderType = 0;
  boolean isInImage = true;
  PointF rectWH;
  PointF rectXY;
  
  AEGenderDetectorOld$GenderParams(AEGenderDetectorOld paramAEGenderDetectorOld) {}
  
  public void setRectWH(int paramInt1, int paramInt2)
  {
    if (this.rectWH == null) {
      this.rectWH = new PointF();
    }
    this.rectWH.set(paramInt1, paramInt2);
  }
  
  public void setRectXY(int paramInt1, int paramInt2)
  {
    if (this.rectXY == null) {
      this.rectXY = new PointF();
    }
    this.rectXY.set(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    if ((this.rectXY == null) || (this.rectWH == null)) {
      return "NULL";
    }
    return "(" + this.rectXY.x + "," + this.rectXY.y + "),(" + this.rectWH.x + "," + this.rectWH.y + "),gender:" + this.genderType + ",isInImage:" + this.isInImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEGenderDetectorOld.GenderParams
 * JD-Core Version:    0.7.0.1
 */