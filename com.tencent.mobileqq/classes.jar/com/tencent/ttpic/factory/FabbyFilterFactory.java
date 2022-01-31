package com.tencent.ttpic.factory;

import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;

public class FabbyFilterFactory
{
  public static BaseFilter createFilter(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramString == null)
    {
      localObject1 = localObject2;
      return localObject1;
    }
    FabbyFilterFactory.FILTER_MODEL[] arrayOfFILTER_MODEL = FabbyFilterFactory.FILTER_MODEL.values();
    int j = arrayOfFILTER_MODEL.length;
    int i = 0;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.factory.FabbyFilterFactory
 * JD-Core Version:    0.7.0.1
 */