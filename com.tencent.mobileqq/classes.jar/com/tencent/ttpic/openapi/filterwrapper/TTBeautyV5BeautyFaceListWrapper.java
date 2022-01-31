package com.tencent.ttpic.openapi.filterwrapper;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.filter.TTBeautyV5BeautyFaceList;
import java.util.List;

public class TTBeautyV5BeautyFaceListWrapper
{
  private TTBeautyV5BeautyFaceList ttBeautyV5BeautyFaceList = new TTBeautyV5BeautyFaceList();
  
  public void clear()
  {
    this.ttBeautyV5BeautyFaceList.clear();
  }
  
  public void initial()
  {
    this.ttBeautyV5BeautyFaceList.initial();
  }
  
  public Frame render2(Frame paramFrame, List<List<PointF>> paramList, List<Float[]> paramList1, List<FaceStatus> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.ttBeautyV5BeautyFaceList.render2(paramFrame, paramList, paramList1, paramList2, paramBoolean1, paramBoolean2);
  }
  
  public void setContrastLevel(int paramInt)
  {
    this.ttBeautyV5BeautyFaceList.setContrastLevel(paramInt);
  }
  
  public void setEyeOpacity(float paramFloat)
  {
    this.ttBeautyV5BeautyFaceList.setEyeOpacity(paramFloat);
  }
  
  public void setEyePouchOpacity(float paramFloat)
  {
    this.ttBeautyV5BeautyFaceList.setEyePouchOpacity(paramFloat);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.ttBeautyV5BeautyFaceList.setRenderMode(paramInt);
  }
  
  public void setSmoothOpacity(float paramFloat)
  {
    this.ttBeautyV5BeautyFaceList.setSmoothOpacity(paramFloat);
  }
  
  public void setSmoothOpacity2(float paramFloat)
  {
    this.ttBeautyV5BeautyFaceList.setSmoothOpacity2(paramFloat);
  }
  
  public void setToothWhitenAlpha(float paramFloat)
  {
    this.ttBeautyV5BeautyFaceList.setToothWhitenAlpha(paramFloat);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.ttBeautyV5BeautyFaceList.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filterwrapper.TTBeautyV5BeautyFaceListWrapper
 * JD-Core Version:    0.7.0.1
 */