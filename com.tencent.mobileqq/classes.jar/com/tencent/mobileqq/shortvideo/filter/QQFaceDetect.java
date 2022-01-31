package com.tencent.mobileqq.shortvideo.filter;

public class QQFaceDetect
  extends QQBaseFilter
{
  public QQFaceDetect(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(999, paramQQFilterRenderManager);
  }
  
  public boolean needFaceDetect()
  {
    return true;
  }
  
  public void onDrawFrame()
  {
    this.mOutputTextureID = this.mInputTextureID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFaceDetect
 * JD-Core Version:    0.7.0.1
 */