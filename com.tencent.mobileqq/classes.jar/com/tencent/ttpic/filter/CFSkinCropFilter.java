package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import java.util.List;

public class CFSkinCropFilter
  extends BaseFilter
{
  private List<PointF> facePoints;
  
  public CFSkinCropFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    this.scaleFact = (200.0F / Math.max(paramFloat1, paramFloat2));
    if (this.facePoints == null)
    {
      setTexCords(new float[] { 0.3F, 0.3F, 0.3F, 0.7F, 0.7F, 0.7F, 0.7F, 0.3F });
      return;
    }
    if (paramFloat1 < 0.001F)
    {
      paramFloat1 = 0.0F;
      if (paramFloat2 >= 0.001F) {
        break label557;
      }
    }
    float[] arrayOfFloat;
    label557:
    for (paramFloat2 = 0.0F;; paramFloat2 = 1.0F / paramFloat2)
    {
      arrayOfFloat = new float[8];
      float f = ((PointF)this.facePoints.get(99)).x;
      arrayOfFloat[0] = (((PointF)this.facePoints.get(103)).x * 0.3F + f * 0.7F);
      f = ((PointF)this.facePoints.get(99)).y;
      arrayOfFloat[1] = (((PointF)this.facePoints.get(103)).y * 0.3F + f * 0.7F);
      f = ((PointF)this.facePoints.get(101)).x;
      arrayOfFloat[2] = (((PointF)this.facePoints.get(105)).x * 0.3F + f * 0.7F);
      f = ((PointF)this.facePoints.get(101)).y;
      arrayOfFloat[3] = (((PointF)this.facePoints.get(105)).y * 0.3F + f * 0.7F);
      f = ((PointF)this.facePoints.get(103)).x;
      arrayOfFloat[4] = (((PointF)this.facePoints.get(99)).x * 0.3F + f * 0.7F);
      f = ((PointF)this.facePoints.get(103)).y;
      arrayOfFloat[5] = (((PointF)this.facePoints.get(99)).y * 0.3F + f * 0.7F);
      f = ((PointF)this.facePoints.get(105)).x;
      arrayOfFloat[6] = (((PointF)this.facePoints.get(101)).x * 0.3F + f * 0.7F);
      f = ((PointF)this.facePoints.get(105)).y;
      arrayOfFloat[7] = (((PointF)this.facePoints.get(101)).y * 0.3F + f * 0.7F);
      int i = 0;
      while (i < 4)
      {
        arrayOfFloat[(i * 2)] *= paramFloat1;
        arrayOfFloat[(i * 2 + 1)] *= paramFloat2;
        i += 1;
      }
      paramFloat1 = 1.0F / paramFloat1;
      break;
    }
    setTexCords(arrayOfFloat);
  }
  
  public void setFacePoints(List<PointF> paramList)
  {
    this.facePoints = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.CFSkinCropFilter
 * JD-Core Version:    0.7.0.1
 */