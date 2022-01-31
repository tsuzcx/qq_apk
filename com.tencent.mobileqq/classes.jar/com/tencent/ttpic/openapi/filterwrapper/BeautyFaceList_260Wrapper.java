package com.tencent.ttpic.openapi.filterwrapper;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.filter.BeautyFaceList_260;
import java.util.List;

public class BeautyFaceList_260Wrapper
{
  private BeautyFaceList_260 beautyFaceList260 = new BeautyFaceList_260();
  
  public void clear()
  {
    this.beautyFaceList260.clear();
  }
  
  public void initial()
  {
    this.beautyFaceList260.initial();
  }
  
  public Frame render(Frame paramFrame, List<List<PointF>> paramList, List<Float[]> paramList1, List<FaceStatus> paramList2, boolean paramBoolean)
  {
    return this.beautyFaceList260.render(paramFrame, paramList, paramList1, paramList2, paramBoolean);
  }
  
  public void setEyeLightenAlpha(float paramFloat)
  {
    this.beautyFaceList260.setEyeLightenAlpha(paramFloat);
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    this.beautyFaceList260.setNormalAlphaFactor(paramFloat);
  }
  
  public void setRemovePounchAlpha(float paramFloat)
  {
    this.beautyFaceList260.setRemovePounchAlpha(paramFloat);
  }
  
  public void setRemoveWrinklesAlpha(float paramFloat)
  {
    this.beautyFaceList260.setRemoveWrinklesAlpha(paramFloat);
  }
  
  public void setRemoveWrinklesAlpha2(float paramFloat)
  {
    this.beautyFaceList260.setRemoveWrinklesAlpha2(paramFloat);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.beautyFaceList260.setRenderMode(paramInt);
  }
  
  public void setToothWhitenAlpha(float paramFloat)
  {
    this.beautyFaceList260.setToothWhitenAlpha(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filterwrapper.BeautyFaceList_260Wrapper
 * JD-Core Version:    0.7.0.1
 */