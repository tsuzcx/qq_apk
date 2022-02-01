package com.tencent.qzonehub.api.panorama.impl;

import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import cooperation.qzone.util.PanoramaUtil;
import java.util.ArrayList;

public class PanoramaUtilImpl
  implements IPanoramaUtil
{
  public int computeSampleSize(Object paramObject, int paramInt1, int paramInt2)
  {
    return PanoramaUtil.getInstance().computeSampleSize((ImageLoader.Options)paramObject, paramInt1, paramInt2);
  }
  
  public ArrayList<float[]> getCylinderCoordinate(float paramFloat, boolean paramBoolean)
  {
    return PanoramaUtil.getInstance().getCylinderCoordinate(paramFloat, paramBoolean);
  }
  
  public ArrayList<float[]> getSphereCoordinate()
  {
    return PanoramaUtil.getInstance().getSphereCoordinate();
  }
  
  public boolean isHighDevice()
  {
    return PanoramaUtil.getInstance().isHighDevice();
  }
  
  public boolean isNeedShowPanorama()
  {
    return PanoramaUtil.getInstance().isNeedShowPanorama();
  }
  
  public boolean isPanoramaPhoto(int paramInt)
  {
    return PanoramaUtil.isPanoramaPhoto(paramInt);
  }
  
  public void reportMta(String paramString1, String paramString2, int paramInt)
  {
    PanoramaUtil.getInstance().reportMta(paramString1, paramString2, paramInt);
  }
  
  public void setPanoramaType(LocalMediaInfo paramLocalMediaInfo)
  {
    PanoramaUtil.setPanoramaType(paramLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.panorama.impl.PanoramaUtilImpl
 * JD-Core Version:    0.7.0.1
 */