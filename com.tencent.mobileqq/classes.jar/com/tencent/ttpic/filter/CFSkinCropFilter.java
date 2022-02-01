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
    float f1 = 0.0F;
    if (paramFloat1 < 0.001F) {
      paramFloat1 = 0.0F;
    } else {
      paramFloat1 = 1.0F / paramFloat1;
    }
    if (paramFloat2 < 0.001F) {
      paramFloat2 = f1;
    } else {
      paramFloat2 = 1.0F / paramFloat2;
    }
    float[] arrayOfFloat = new float[8];
    f1 = ((PointF)this.facePoints.get(99)).x;
    float f2 = ((PointF)this.facePoints.get(103)).x;
    int i = 0;
    arrayOfFloat[0] = (f1 * 0.7F + f2 * 0.3F);
    arrayOfFloat[1] = (((PointF)this.facePoints.get(99)).y * 0.7F + ((PointF)this.facePoints.get(103)).y * 0.3F);
    arrayOfFloat[2] = (((PointF)this.facePoints.get(101)).x * 0.7F + ((PointF)this.facePoints.get(105)).x * 0.3F);
    arrayOfFloat[3] = (((PointF)this.facePoints.get(101)).y * 0.7F + ((PointF)this.facePoints.get(105)).y * 0.3F);
    arrayOfFloat[4] = (((PointF)this.facePoints.get(103)).x * 0.7F + ((PointF)this.facePoints.get(99)).x * 0.3F);
    arrayOfFloat[5] = (((PointF)this.facePoints.get(103)).y * 0.7F + ((PointF)this.facePoints.get(99)).y * 0.3F);
    arrayOfFloat[6] = (((PointF)this.facePoints.get(105)).x * 0.7F + ((PointF)this.facePoints.get(101)).x * 0.3F);
    arrayOfFloat[7] = (((PointF)this.facePoints.get(105)).y * 0.7F + ((PointF)this.facePoints.get(101)).y * 0.3F);
    while (i < 4)
    {
      int j = i * 2;
      arrayOfFloat[j] *= paramFloat1;
      j += 1;
      arrayOfFloat[j] *= paramFloat2;
      i += 1;
    }
    setTexCords(arrayOfFloat);
  }
  
  public void setFacePoints(List<PointF> paramList)
  {
    this.facePoints = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.CFSkinCropFilter
 * JD-Core Version:    0.7.0.1
 */