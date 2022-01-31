package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;

class GenderDetector$GenderParams
{
  long faceID;
  int genderType = 0;
  boolean isInImage = true;
  PointF leftEye;
  PointF rightEye;
  
  GenderDetector$GenderParams(GenderDetector paramGenderDetector) {}
  
  public void setLeftEye(int paramInt1, int paramInt2)
  {
    if (this.leftEye == null) {
      this.leftEye = new PointF();
    }
    this.leftEye.set(paramInt1, paramInt2);
  }
  
  public void setRightEye(int paramInt1, int paramInt2)
  {
    if (this.rightEye == null) {
      this.rightEye = new PointF();
    }
    this.rightEye.set(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    if ((this.leftEye == null) || (this.rightEye == null)) {
      return "NULL";
    }
    return "(" + this.leftEye.x + "," + this.leftEye.y + "),(" + this.rightEye.x + "," + this.rightEye.y + "),gender:" + this.genderType + ",isInImage:" + this.isInImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.GenderDetector.GenderParams
 * JD-Core Version:    0.7.0.1
 */