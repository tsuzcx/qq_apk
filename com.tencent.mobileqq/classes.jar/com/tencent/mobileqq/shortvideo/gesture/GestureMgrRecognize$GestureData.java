package com.tencent.mobileqq.shortvideo.gesture;

class GestureMgrRecognize$GestureData
{
  int dataHeight;
  byte[] dataRGBA = null;
  int dataWidth;
  int originHeight;
  int originWidth;
  
  GestureMgrRecognize$GestureData(GestureMgrRecognize paramGestureMgrRecognize, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dataRGBA = ((byte[])paramArrayOfByte.clone());
    this.dataWidth = paramInt1;
    this.dataHeight = paramInt2;
    this.originWidth = paramInt3;
    this.originHeight = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize.GestureData
 * JD-Core Version:    0.7.0.1
 */