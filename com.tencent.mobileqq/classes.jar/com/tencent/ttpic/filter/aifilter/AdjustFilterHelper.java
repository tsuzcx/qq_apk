package com.tencent.ttpic.filter.aifilter;

import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.FadeFilter;
import com.tencent.ttpic.openapi.filter.GrainFilter;
import com.tencent.ttpic.openapi.filter.HSLAdjustFilter;
import com.tencent.ttpic.openapi.filter.HighPassSharpenFilter;
import com.tencent.ttpic.openapi.filter.HighlightShadowFilter;
import com.tencent.ttpic.openapi.filter.VignettingFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class AdjustFilterHelper
{
  public static final AdjustFilterHelper INSTANCE = new AdjustFilterHelper();
  
  @NotNull
  public static final ArrayList<BaseFilter> getInitialedFilterList(@NotNull HashMap<String, String> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    HSLAdjustFilter localHSLAdjustFilter = new HSLAdjustFilter();
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    int j = 0;
    if (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      Object localObject = (String)localEntry.getKey();
      label356:
      int i;
      switch (((String)localObject).hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          label358:
          i = j;
        }
        break;
      }
      for (;;)
      {
        j = i;
        break;
        if (!((String)localObject).equals("brightValue")) {
          break label356;
        }
        i = 0;
        break label358;
        if (!((String)localObject).equals("contrastValue")) {
          break label356;
        }
        i = 1;
        break label358;
        if (!((String)localObject).equals("saturationValue")) {
          break label356;
        }
        i = 2;
        break label358;
        if (!((String)localObject).equals("scaleCValue")) {
          break label356;
        }
        i = 3;
        break label358;
        if (!((String)localObject).equals("sharpenValue")) {
          break label356;
        }
        i = 4;
        break label358;
        if (!((String)localObject).equals("darkCornerValue")) {
          break label356;
        }
        i = 5;
        break label358;
        if (!((String)localObject).equals("highlightValue")) {
          break label356;
        }
        i = 6;
        break label358;
        if (!((String)localObject).equals("shadowValue")) {
          break label356;
        }
        i = 7;
        break label358;
        if (!((String)localObject).equals("fadeValue")) {
          break label356;
        }
        i = 8;
        break label358;
        if (!((String)localObject).equals("grainValue")) {
          break label356;
        }
        i = 9;
        break label358;
        if (!((String)localObject).equals("hueAdjustRed")) {
          break label356;
        }
        i = 10;
        break label358;
        if (!((String)localObject).equals("satAdjustRed")) {
          break label356;
        }
        i = 11;
        break label358;
        if (!((String)localObject).equals("lumAdjustRed")) {
          break label356;
        }
        i = 12;
        break label358;
        if (!((String)localObject).equals("hueAdjustOrange")) {
          break label356;
        }
        i = 13;
        break label358;
        if (!((String)localObject).equals("satAdjustOrange")) {
          break label356;
        }
        i = 14;
        break label358;
        if (!((String)localObject).equals("lumAdjustOrange")) {
          break label356;
        }
        i = 15;
        break label358;
        if (!((String)localObject).equals("hueAdjustYellow")) {
          break label356;
        }
        i = 16;
        break label358;
        if (!((String)localObject).equals("satAdjustYellow")) {
          break label356;
        }
        i = 17;
        break label358;
        if (!((String)localObject).equals("lumAdjustYellow")) {
          break label356;
        }
        i = 18;
        break label358;
        if (!((String)localObject).equals("hueAdjustGreen")) {
          break label356;
        }
        i = 19;
        break label358;
        if (!((String)localObject).equals("satAdjustGreen")) {
          break label356;
        }
        i = 20;
        break label358;
        if (!((String)localObject).equals("lumAdjustGreen")) {
          break label356;
        }
        i = 21;
        break label358;
        if (!((String)localObject).equals("hueAdjustCyan")) {
          break label356;
        }
        i = 22;
        break label358;
        if (!((String)localObject).equals("satAdjustCyan")) {
          break label356;
        }
        i = 23;
        break label358;
        if (!((String)localObject).equals("lumAdjustCyan")) {
          break label356;
        }
        i = 24;
        break label358;
        if (!((String)localObject).equals("hueAdjustBlue")) {
          break label356;
        }
        i = 25;
        break label358;
        if (!((String)localObject).equals("satAdjustBlue")) {
          break label356;
        }
        i = 26;
        break label358;
        if (!((String)localObject).equals("lumAdjustBlue")) {
          break label356;
        }
        i = 27;
        break label358;
        if (!((String)localObject).equals("hueAdjustPurple")) {
          break label356;
        }
        i = 28;
        break label358;
        if (!((String)localObject).equals("satAdjustPurple")) {
          break label356;
        }
        i = 29;
        break label358;
        if (!((String)localObject).equals("lumAdjustPurple")) {
          break label356;
        }
        i = 30;
        break label358;
        if (!((String)localObject).equals("hueAdjustMagenta")) {
          break label356;
        }
        i = 31;
        break label358;
        if (!((String)localObject).equals("satAdjustMagenta")) {
          break label356;
        }
        i = 32;
        break label358;
        if (!((String)localObject).equals("lumAdjustMagenta")) {
          break label356;
        }
        i = 33;
        break label358;
        localObject = localArrayList.iterator();
        BaseFilter localBaseFilter;
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localBaseFilter = (BaseFilter)((Iterator)localObject).next();
            if ((localBaseFilter instanceof VibranceBaseFilter))
            {
              ((VibranceBaseFilter)localBaseFilter).setBrightness(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
              break;
            }
          }
        }
        localObject = new VibranceBaseFilter();
        ((VibranceBaseFilter)localObject).setBrightness(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localObject = localArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localBaseFilter = (BaseFilter)((Iterator)localObject).next();
            if ((localBaseFilter instanceof VibranceBaseFilter))
            {
              ((VibranceBaseFilter)localBaseFilter).setContrast(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
              break;
            }
          }
        }
        localObject = new VibranceBaseFilter();
        ((VibranceBaseFilter)localObject).setContrast(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localObject = localArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localBaseFilter = (BaseFilter)((Iterator)localObject).next();
            if ((localBaseFilter instanceof VibranceBaseFilter))
            {
              ((VibranceBaseFilter)localBaseFilter).setSaturation(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
              break;
            }
          }
        }
        localObject = new VibranceBaseFilter();
        ((VibranceBaseFilter)localObject).setSaturation(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localObject = new ColorTemperatureLutFilter();
        ((ColorTemperatureLutFilter)localObject).setAlphaTemp(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localObject = new HighPassSharpenFilter();
        ((HighPassSharpenFilter)localObject).setAlpha(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localObject = new VignettingFilter();
        ((VignettingFilter)localObject).setAlpha(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localObject = localArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localBaseFilter = (BaseFilter)((Iterator)localObject).next();
            if ((localBaseFilter instanceof HighlightShadowFilter))
            {
              ((HighlightShadowFilter)localBaseFilter).setHighlights(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
              break;
            }
          }
        }
        localObject = new HighlightShadowFilter();
        ((HighlightShadowFilter)localObject).setHighlights(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localObject = localArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localBaseFilter = (BaseFilter)((Iterator)localObject).next();
            if ((localBaseFilter instanceof HighlightShadowFilter))
            {
              ((HighlightShadowFilter)localBaseFilter).setShadows(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
              break;
            }
          }
        }
        localObject = new HighlightShadowFilter();
        ((HighlightShadowFilter)localObject).setShadows(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localObject = new FadeFilter();
        ((FadeFilter)localObject).setAlpha(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localObject = new GrainFilter();
        ((GrainFilter)localObject).setAlpha(Integer.parseInt((String)localEntry.getValue()) / 100.0F);
        localArrayList.add(localObject);
        i = j;
        continue;
        localHashMap.put("hueAdjustRed", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("satAdjustRed", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("lumAdjustRed", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("hueAdjustOrange", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("satAdjustOrange", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("lumAdjustOrange", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("hueAdjustYellow", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("satAdjustYellow", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("lumAdjustYellow", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("hueAdjustGreen", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("satAdjustGreen", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("lumAdjustGreen", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("hueAdjustCyan", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("satAdjustCyan", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("lumAdjustCyan", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("hueAdjustBlue", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("satAdjustBlue", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("lumAdjustBlue", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("hueAdjustPurple", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("satAdjustPurple", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("lumAdjustPurple", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("hueAdjustRed", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("satAdjustRed", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
        continue;
        localHashMap.put("lumAdjustRed", Float.valueOf(Integer.parseInt((String)localEntry.getValue()) / 100.0F));
        i = 1;
      }
    }
    if (j != 0)
    {
      localHSLAdjustFilter.setParams(localHashMap);
      localArrayList.add(localHSLAdjustFilter);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.AdjustFilterHelper
 * JD-Core Version:    0.7.0.1
 */