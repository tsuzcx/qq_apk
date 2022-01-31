package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.model.DistortParam;
import com.tencent.ttpic.openapi.model.DistortionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeautyRealUtil
{
  public static DistortParam getDistortParam(DistortParam paramDistortParam, int paramInt1, int paramInt2)
  {
    DistortParam localDistortParam = new DistortParam();
    if (paramDistortParam == null) {
      return localDistortParam;
    }
    ArrayList localArrayList = new ArrayList();
    float f = paramInt1 / 100.0F;
    paramDistortParam = paramDistortParam.getItems().iterator();
    if (paramDistortParam.hasNext())
    {
      DistortionItem localDistortionItem = ((DistortionItem)paramDistortParam.next()).clone();
      if (paramInt2 == BeautyRealConfig.TYPE.CHIN.value) {
        if (paramInt1 < 0)
        {
          localDistortionItem.strength *= -f;
          localDistortionItem.direction = 2;
        }
      }
      for (;;)
      {
        localArrayList.add(localDistortionItem);
        break;
        localDistortionItem.strength *= f;
        localDistortionItem.direction = 4;
        continue;
        if (paramInt2 == BeautyRealConfig.TYPE.EYE.value)
        {
          localDistortionItem.strength *= f;
          localDistortionItem.strength = ((float)(localDistortionItem.strength * 0.75D));
        }
        else
        {
          localDistortionItem.strength *= f;
        }
      }
    }
    localDistortParam.setLevel(paramInt1);
    localDistortParam.setItems(localArrayList);
    return localDistortParam;
  }
  
  public static DistortParam getDistortParam4Pitu(DistortParam paramDistortParam, int paramInt1, int paramInt2)
  {
    DistortParam localDistortParam = new DistortParam();
    if (paramDistortParam == null) {
      return localDistortParam;
    }
    ArrayList localArrayList = new ArrayList();
    float f = paramInt1 / 100.0F;
    paramDistortParam = paramDistortParam.getItems().iterator();
    if (paramDistortParam.hasNext())
    {
      DistortionItem localDistortionItem = ((DistortionItem)paramDistortParam.next()).clone();
      if (paramInt2 == BeautyRealConfig.TYPE.CHIN.value) {
        if (paramInt1 < 0)
        {
          localDistortionItem.strength *= -f;
          localDistortionItem.direction = 2;
        }
      }
      for (;;)
      {
        localArrayList.add(localDistortionItem);
        break;
        localDistortionItem.strength *= f;
        localDistortionItem.direction = 4;
        continue;
        localDistortionItem.strength *= f;
      }
    }
    localDistortParam.setLevel(paramInt1);
    localDistortParam.setItems(localArrayList);
    return localDistortParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.BeautyRealUtil
 * JD-Core Version:    0.7.0.1
 */