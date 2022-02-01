package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import java.util.List;

public class BeautyTransformList$FaceInfoOfFrame
{
  public List<Integer> countList;
  public List<List<PointF>> faces;
  public List<float[]> facesAngles;
  public float phoneRotate;
  
  public BeautyTransformList$FaceInfoOfFrame(List<List<PointF>> paramList, List<float[]> paramList1, List<Integer> paramList2)
  {
    this.faces = paramList1;
    this.facesAngles = paramList2;
    Object localObject;
    this.countList = localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BeautyTransformList.FaceInfoOfFrame
 * JD-Core Version:    0.7.0.1
 */