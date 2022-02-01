package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Pair;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DislocationFilter
  extends BaseFilter
{
  private List<Pair<RectF, PointF>> mDislocationRects = new ArrayList();
  
  public DislocationFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void addLocation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    RectF localRectF = new RectF(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    PointF localPointF = new PointF(paramFloat5, paramFloat6);
    this.mDislocationRects.add(new Pair(localRectF, localPointF));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    setTexCords(GlUtil.ORIGIN_TEX_COORDS);
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    Iterator localIterator = this.mDislocationRects.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      float[] arrayOfFloat1 = AlgoUtils.calPositions(Math.min(Math.max(((RectF)localPair.first).left + ((PointF)localPair.second).x, 0.0F), 1.0F), Math.min(Math.max(((RectF)localPair.first).top + ((PointF)localPair.second).y, 0.0F), 1.0F), Math.min(Math.max(((RectF)localPair.first).right + ((PointF)localPair.second).x, 0.0F), 1.0F), Math.min(Math.max(((RectF)localPair.first).bottom + ((PointF)localPair.second).y, 0.0F), 1.0F), 1, 1);
      float[] arrayOfFloat2 = new float[arrayOfFloat1.length];
      int i = 0;
      while (i < arrayOfFloat1.length / 2)
      {
        int j = i * 2;
        arrayOfFloat2[j] = ((arrayOfFloat1[j] + 1.0F) / 2.0F - ((PointF)localPair.second).x);
        j += 1;
        arrayOfFloat2[j] = ((arrayOfFloat1[j] + 1.0F) / 2.0F - ((PointF)localPair.second).y);
        i += 1;
      }
      setPositions(arrayOfFloat1);
      setTexCords(arrayOfFloat2);
      super.renderTexture(paramInt1, paramInt2, paramInt3);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.DislocationFilter
 * JD-Core Version:    0.7.0.1
 */