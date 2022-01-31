package com.tencent.ttpic.filter.aifilter;

import com.tencent.ttpic.openapi.filter.BeautyFaceList_260;
import com.tencent.ttpic.openapi.filter.RealTimeSmoothFilterV3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class FaceBeautyFilterHelper
{
  public static final FaceBeautyFilterHelper INSTANCE = new FaceBeautyFilterHelper();
  
  @NotNull
  public static final ArrayList<Object> getInitialedFilterList(@NotNull HashMap<String, String> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      Object localObject1 = (String)localEntry.getKey();
      label88:
      int i;
      switch (((String)localObject1).hashCode())
      {
      default: 
        i = -1;
      }
      Object localObject2;
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          localObject1 = localArrayList.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = ((Iterator)localObject1).next();
          } while (!(localObject2 instanceof BeautyFaceList_260));
          ((BeautyFaceList_260)localObject2).setRemoveWrinklesAlpha(Float.parseFloat((String)localEntry.getValue()));
          break;
          if (!((String)localObject1).equals("removeWrinkle")) {
            break label88;
          }
          i = 0;
          continue;
          if (!((String)localObject1).equals("removeEyePouch")) {
            break label88;
          }
          i = 1;
          continue;
          if (!((String)localObject1).equals("smooth")) {
            break label88;
          }
          i = 2;
        }
      }
      localObject1 = new BeautyFaceList_260();
      ((BeautyFaceList_260)localObject1).setRemoveWrinklesAlpha(Float.parseFloat((String)localEntry.getValue()));
      localArrayList.add(localObject1);
      continue;
      localObject1 = localArrayList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof BeautyFaceList_260))
          {
            ((BeautyFaceList_260)localObject2).setRemovePounchAlpha(Float.parseFloat((String)localEntry.getValue()));
            break;
          }
        }
      }
      localObject1 = new BeautyFaceList_260();
      ((BeautyFaceList_260)localObject1).setRemovePounchAlpha(Float.parseFloat((String)localEntry.getValue()));
      localArrayList.add(localObject1);
      continue;
      localObject1 = new RealTimeSmoothFilterV3();
      ((RealTimeSmoothFilterV3)localObject1).updateBlurAlpha(Float.parseFloat((String)localEntry.getValue()));
      localArrayList.add(localObject1);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.FaceBeautyFilterHelper
 * JD-Core Version:    0.7.0.1
 */