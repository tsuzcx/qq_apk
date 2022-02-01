package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Rect;
import android.support.v4.util.SparseArrayCompat;
import android.util.JsonReader;
import android.util.LongSparseArray;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.model.Font;
import com.tencent.mobileqq.dinifly.model.FontCharacter;
import com.tencent.mobileqq.dinifly.model.Marker;
import com.tencent.mobileqq.dinifly.model.layer.Layer;
import com.tencent.mobileqq.dinifly.model.layer.Layer.LayerType;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottieCompositionParser
{
  public static LottieComposition parse(JsonReader paramJsonReader)
  {
    float f5 = Utils.dpScale();
    LongSparseArray localLongSparseArray = new LongSparseArray();
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    ArrayList localArrayList2 = new ArrayList();
    SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat();
    LottieComposition localLottieComposition = new LottieComposition();
    paramJsonReader.beginObject();
    int j = 0;
    int i = 0;
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    if (paramJsonReader.hasNext())
    {
      Object localObject = paramJsonReader.nextName();
      int k = -1;
      label212:
      float f4;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (k)
        {
        default: 
          paramJsonReader.skipValue();
          label276:
          k = j;
          f4 = f3;
          f3 = f1;
          f1 = f4;
          j = i;
          i = k;
        }
        break;
      }
      for (;;)
      {
        k = j;
        f4 = f3;
        j = i;
        i = k;
        f3 = f1;
        f1 = f4;
        break;
        if (!((String)localObject).equals("w")) {
          break label212;
        }
        k = 0;
        break label212;
        if (!((String)localObject).equals("h")) {
          break label212;
        }
        k = 1;
        break label212;
        if (!((String)localObject).equals("ip")) {
          break label212;
        }
        k = 2;
        break label212;
        if (!((String)localObject).equals("op")) {
          break label212;
        }
        k = 3;
        break label212;
        if (!((String)localObject).equals("fr")) {
          break label212;
        }
        k = 4;
        break label212;
        if (!((String)localObject).equals("v")) {
          break label212;
        }
        k = 5;
        break label212;
        if (!((String)localObject).equals("layers")) {
          break label212;
        }
        k = 6;
        break label212;
        if (!((String)localObject).equals("assets")) {
          break label212;
        }
        k = 7;
        break label212;
        if (!((String)localObject).equals("fonts")) {
          break label212;
        }
        k = 8;
        break label212;
        if (!((String)localObject).equals("chars")) {
          break label212;
        }
        k = 9;
        break label212;
        if (!((String)localObject).equals("markers")) {
          break label212;
        }
        k = 10;
        break label212;
        k = paramJsonReader.nextInt();
        i = j;
        j = k;
        f4 = f1;
        f1 = f3;
        f3 = f4;
        continue;
        k = paramJsonReader.nextInt();
        j = i;
        f4 = f1;
        i = k;
        f1 = f3;
        f3 = f4;
        continue;
        f4 = (float)paramJsonReader.nextDouble();
        k = i;
        f1 = f3;
        f3 = f4;
        i = j;
        j = k;
        continue;
        f2 = (float)paramJsonReader.nextDouble();
        k = i;
        f2 -= 0.01F;
        f4 = f1;
        i = j;
        j = k;
        f1 = f3;
        f3 = f4;
        continue;
        f3 = (float)paramJsonReader.nextDouble();
        k = i;
        f4 = f1;
        i = j;
        j = k;
        f1 = f3;
        f3 = f4;
        continue;
        localObject = paramJsonReader.nextString().split("\\.");
        if (Utils.isAtLeastVersion(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Integer.parseInt(localObject[2]), 4, 4, 0)) {
          break label276;
        }
        localLottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
        k = i;
        f4 = f1;
        i = j;
        j = k;
        f1 = f3;
        f3 = f4;
        continue;
        parseLayers(paramJsonReader, localLottieComposition, localArrayList1, localLongSparseArray);
        k = i;
        f4 = f1;
        i = j;
        j = k;
        f1 = f3;
        f3 = f4;
        continue;
        parseAssets(paramJsonReader, localLottieComposition, localHashMap1, localHashMap2);
        k = i;
        f4 = f1;
        i = j;
        j = k;
        f1 = f3;
        f3 = f4;
        continue;
        parseFonts(paramJsonReader, localHashMap3);
        k = i;
        f4 = f1;
        i = j;
        j = k;
        f1 = f3;
        f3 = f4;
        continue;
        parseChars(paramJsonReader, localLottieComposition, localSparseArrayCompat);
        k = i;
        f4 = f1;
        i = j;
        j = k;
        f1 = f3;
        f3 = f4;
        continue;
        parseMarkers(paramJsonReader, localLottieComposition, localArrayList2);
        k = i;
        f4 = f1;
        i = j;
        j = k;
        f1 = f3;
        f3 = f4;
      }
    }
    paramJsonReader.endObject();
    localLottieComposition.init(new Rect(0, 0, (int)(i * f5), (int)(j * f5)), f1, f2, f3, localArrayList1, localLongSparseArray, localHashMap1, localHashMap2, localSparseArrayCompat, localHashMap3, localArrayList2);
    return localLottieComposition;
  }
  
  private static void parseAssets(JsonReader paramJsonReader, LottieComposition paramLottieComposition, Map<String, List<Layer>> paramMap, Map<String, LottieImageAsset> paramMap1)
  {
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext())
    {
      ArrayList localArrayList = new ArrayList();
      LongSparseArray localLongSparseArray = new LongSparseArray();
      paramJsonReader.beginObject();
      Object localObject1 = null;
      String str1 = null;
      int j = 0;
      int k = 0;
      String str2 = null;
      label48:
      while (paramJsonReader.hasNext())
      {
        Object localObject2 = paramJsonReader.nextName();
        int i = -1;
        switch (((String)localObject2).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramJsonReader.skipValue();
            break label48;
            if (((String)localObject2).equals("id"))
            {
              i = 0;
              continue;
              if (((String)localObject2).equals("layers"))
              {
                i = 1;
                continue;
                if (((String)localObject2).equals("w"))
                {
                  i = 2;
                  continue;
                  if (((String)localObject2).equals("h"))
                  {
                    i = 3;
                    continue;
                    if (((String)localObject2).equals("p"))
                    {
                      i = 4;
                      continue;
                      if (((String)localObject2).equals("u")) {
                        i = 5;
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        str2 = paramJsonReader.nextString();
        continue;
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          localObject2 = LayerParser.parse(paramJsonReader, paramLottieComposition);
          localLongSparseArray.put(((Layer)localObject2).getId(), localObject2);
          localArrayList.add(localObject2);
        }
        paramJsonReader.endArray();
        continue;
        k = paramJsonReader.nextInt();
        continue;
        j = paramJsonReader.nextInt();
        continue;
        str1 = paramJsonReader.nextString();
        continue;
        localObject1 = paramJsonReader.nextString();
      }
      paramJsonReader.endObject();
      if (str1 != null)
      {
        localObject1 = new LottieImageAsset(k, j, str2, str1, (String)localObject1);
        paramMap1.put(((LottieImageAsset)localObject1).getId(), localObject1);
      }
      else
      {
        paramMap.put(str2, localArrayList);
      }
    }
    paramJsonReader.endArray();
  }
  
  private static void parseChars(JsonReader paramJsonReader, LottieComposition paramLottieComposition, SparseArrayCompat<FontCharacter> paramSparseArrayCompat)
  {
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext())
    {
      FontCharacter localFontCharacter = FontCharacterParser.parse(paramJsonReader, paramLottieComposition);
      paramSparseArrayCompat.put(localFontCharacter.hashCode(), localFontCharacter);
    }
    paramJsonReader.endArray();
  }
  
  private static void parseFonts(JsonReader paramJsonReader, Map<String, Font> paramMap)
  {
    paramJsonReader.beginObject();
    label4:
    while (paramJsonReader.hasNext())
    {
      Object localObject = paramJsonReader.nextName();
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label4;
          if (((String)localObject).equals("list")) {
            i = 0;
          }
          break;
        }
      }
      paramJsonReader.beginArray();
      while (paramJsonReader.hasNext())
      {
        localObject = FontParser.parse(paramJsonReader);
        paramMap.put(((Font)localObject).getName(), localObject);
      }
      paramJsonReader.endArray();
    }
    paramJsonReader.endObject();
  }
  
  private static void parseLayers(JsonReader paramJsonReader, LottieComposition paramLottieComposition, List<Layer> paramList, LongSparseArray<Layer> paramLongSparseArray)
  {
    int i = 0;
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext())
    {
      Layer localLayer = LayerParser.parse(paramJsonReader, paramLottieComposition);
      int j = i;
      if (localLayer.getLayerType() == Layer.LayerType.IMAGE) {
        j = i + 1;
      }
      paramList.add(localLayer);
      paramLongSparseArray.put(localLayer.getId(), localLayer);
      i = j;
      if (j > 4)
      {
        L.warn("You have " + j + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
        i = j;
      }
    }
    paramJsonReader.endArray();
  }
  
  private static void parseMarkers(JsonReader paramJsonReader, LottieComposition paramLottieComposition, List<Marker> paramList)
  {
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext())
    {
      paramLottieComposition = null;
      paramJsonReader.beginObject();
      float f2 = 0.0F;
      float f1 = 0.0F;
      label22:
      while (paramJsonReader.hasNext())
      {
        String str = paramJsonReader.nextName();
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramJsonReader.skipValue();
            break label22;
            if (str.equals("cm"))
            {
              i = 0;
              continue;
              if (str.equals("tm"))
              {
                i = 1;
                continue;
                if (str.equals("dr")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        paramLottieComposition = paramJsonReader.nextString();
        continue;
        f1 = (float)paramJsonReader.nextDouble();
        continue;
        f2 = (float)paramJsonReader.nextDouble();
      }
      paramJsonReader.endObject();
      paramList.add(new Marker(paramLottieComposition, f1, f2));
    }
    paramJsonReader.endArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.LottieCompositionParser
 * JD-Core Version:    0.7.0.1
 */