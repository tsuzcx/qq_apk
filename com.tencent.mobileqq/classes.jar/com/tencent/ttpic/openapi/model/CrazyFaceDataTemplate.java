package com.tencent.ttpic.openapi.model;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrazyFaceDataTemplate
{
  public static final int LAYER_BACK = 0;
  public static final int LAYER_FACE_EX = 1;
  public static final int LAYER_FRONT = 2;
  public String advActionUrl;
  public String advId;
  public String advPicUrl;
  public CrazyFaceDataTemplate.ImageLayer backgroundLayer;
  public FilterMaterial effectFilter;
  public int effectFilterOrder;
  public FaceEditParams faceEditParams;
  public final List<FaceImageLayer> faceLayers = new ArrayList();
  public String folderPath;
  public CrazyFaceDataTemplate.ImageLayer foregroundLayer;
  public double height;
  public int minAppVersion;
  public String payPreviewImage;
  public double width;
  
  private static RectF wrapPointsWithRectF(List<Double> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    RectF localRectF = new RectF(3.4028235E+38F, 3.4028235E+38F, 1.4E-45F, 1.4E-45F);
    int i = 0;
    while (i < paramList.size() - 1)
    {
      double d1 = ((Double)paramList.get(i)).doubleValue();
      double d2 = ((Double)paramList.get(i + 1)).doubleValue();
      localRectF.left = ((float)Math.min(d1, localRectF.left));
      localRectF.right = ((float)Math.max(d1, localRectF.right));
      localRectF.top = ((float)Math.min(d2, localRectF.top));
      localRectF.bottom = ((float)Math.max(d2, localRectF.bottom));
      i += 2;
    }
    return localRectF;
  }
  
  public FaceImageLayer getFaceLayer(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.faceLayers.size())) {
      return (FaceImageLayer)this.faceLayers.get(paramInt);
    }
    return null;
  }
  
  public List<RectF> getFaceRects()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.faceLayers.iterator();
    while (localIterator.hasNext())
    {
      RectF localRectF = wrapPointsWithRectF(((FaceImageLayer)localIterator.next()).imageFacePoint);
      if (localRectF != null) {
        localArrayList.add(localRectF);
      }
    }
    return localArrayList;
  }
  
  public boolean hasAdditionFaceLayers()
  {
    return this.faceLayers.size() > 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.CrazyFaceDataTemplate
 * JD-Core Version:    0.7.0.1
 */