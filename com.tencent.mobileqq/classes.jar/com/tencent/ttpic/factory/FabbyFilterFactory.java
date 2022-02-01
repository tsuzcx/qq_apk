package com.tencent.ttpic.factory;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;

public class FabbyFilterFactory
{
  public static BaseFilter createFilter(String paramString)
  {
    Object localObject2 = null;
    if (paramString == null) {
      return null;
    }
    FabbyFilterFactory.FILTER_MODEL[] arrayOfFILTER_MODEL = FabbyFilterFactory.FILTER_MODEL.values();
    int j = arrayOfFILTER_MODEL.length;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      FabbyFilterFactory.FILTER_MODEL localFILTER_MODEL = arrayOfFILTER_MODEL[i];
      if (localFILTER_MODEL.name.equals(paramString))
      {
        paramString = TTPicFilterFactoryLocal.creatFilterById(localFILTER_MODEL.filterId);
        localObject1 = paramString;
        if (paramString == null) {
          break;
        }
        paramString.setEffectIndex(localFILTER_MODEL.effectIndex);
        return paramString;
      }
      i += 1;
    }
    return localObject1;
  }
  
  public static BaseFilter createFilter(String paramString, float paramFloat)
  {
    if (FileUtils.exists(paramString))
    {
      BaseFilter localBaseFilter = TTPicFilterFactoryLocal.creatFilterById(289);
      if (localBaseFilter != null)
      {
        ((GPUImageLookupFilter)localBaseFilter).updateLut(paramString);
        double d = paramFloat;
        Double.isNaN(d);
        localBaseFilter.setAdjustParam((float)(1.0D - d));
        return localBaseFilter;
      }
      return TTPicFilterFactoryLocal.lutFilterWithBitmap(BitmapUtils.decodeBitmap(paramString, true));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.factory.FabbyFilterFactory
 * JD-Core Version:    0.7.0.1
 */