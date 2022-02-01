package com.tencent.ttpic.openapi.facedetect;

import android.graphics.PointF;
import java.util.List;

public abstract interface FaceDetector$FaceDetectListener
{
  public abstract void onFaceDetectResult(List<List<PointF>> paramList, List<float[]> paramList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.facedetect.FaceDetector.FaceDetectListener
 * JD-Core Version:    0.7.0.1
 */