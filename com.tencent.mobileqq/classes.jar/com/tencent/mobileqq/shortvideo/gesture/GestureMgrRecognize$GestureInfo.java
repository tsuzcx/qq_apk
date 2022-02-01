package com.tencent.mobileqq.shortvideo.gesture;

class GestureMgrRecognize$GestureInfo
  extends GestureKeyInfo
{
  String curType;
  int hitCount = 0;
  int missCount = 0;
  
  GestureMgrRecognize$GestureInfo(GestureMgrRecognize paramGestureMgrRecognize) {}
  
  public void copyTo(GestureInfo paramGestureInfo)
  {
    super.copyTo(paramGestureInfo);
    paramGestureInfo.hitCount = this.hitCount;
    paramGestureInfo.missCount = this.missCount;
    paramGestureInfo.curType = this.curType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize.GestureInfo
 * JD-Core Version:    0.7.0.1
 */