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
    float f4 = Utils.dpScale();
    LongSparseArray localLongSparseArray = new LongSparseArray();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat();
    LottieComposition localLottieComposition = new LottieComposition();
    paramJsonReader.beginObject();
    int k = 0;
    int j = 0;
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (paramJsonReader.hasNext())
    {
      Object localObject = paramJsonReader.nextName();
      switch (((String)localObject).hashCode())
      {
      default: 
        break;
      case 839250809: 
        if (((String)localObject).equals("markers")) {
          i = 10;
        }
        break;
      case 97615364: 
        if (((String)localObject).equals("fonts")) {
          i = 8;
        }
        break;
      case 94623709: 
        if (((String)localObject).equals("chars")) {
          i = 9;
        }
        break;
      case 3553: 
        if (((String)localObject).equals("op")) {
          i = 3;
        }
        break;
      case 3367: 
        if (((String)localObject).equals("ip")) {
          i = 2;
        }
        break;
      case 3276: 
        if (((String)localObject).equals("fr")) {
          i = 4;
        }
        break;
      case 119: 
        if (((String)localObject).equals("w")) {
          i = 0;
        }
        break;
      case 118: 
        if (((String)localObject).equals("v")) {
          i = 5;
        }
        break;
      case 104: 
        if (((String)localObject).equals("h")) {
          i = 1;
        }
        break;
      case -1109732030: 
        if (((String)localObject).equals("layers")) {
          i = 6;
        }
        break;
      case -1408207997: 
        if (((String)localObject).equals("assets")) {
          i = 7;
        }
        break;
      }
      int i = -1;
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 10: 
        parseMarkers(paramJsonReader, localLottieComposition, localArrayList1);
        break;
      case 9: 
        parseChars(paramJsonReader, localLottieComposition, localSparseArrayCompat);
        break;
      case 8: 
        parseFonts(paramJsonReader, localHashMap1);
        break;
      case 7: 
        parseAssets(paramJsonReader, localLottieComposition, localHashMap2, localHashMap3);
        break;
      case 6: 
        parseLayers(paramJsonReader, localLottieComposition, localArrayList2, localLongSparseArray);
        break;
      case 5: 
        localObject = paramJsonReader.nextString().split("\\.");
        if (!Utils.isAtLeastVersion(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Integer.parseInt(localObject[2]), 4, 4, 0)) {
          localLottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
        }
        break;
      case 4: 
        f1 = (float)paramJsonReader.nextDouble();
        break;
      case 3: 
        f2 = (float)paramJsonReader.nextDouble() - 0.01F;
        break;
      case 2: 
        f3 = (float)paramJsonReader.nextDouble();
        break;
      case 1: 
        j = paramJsonReader.nextInt();
        break;
      }
      k = paramJsonReader.nextInt();
    }
    paramJsonReader.endObject();
    localLottieComposition.init(new Rect(0, 0, (int)(k * f4), (int)(j * f4)), f3, f2, f1, localArrayList2, localLongSparseArray, localHashMap2, localHashMap3, localSparseArrayCompat, localHashMap1, localArrayList1);
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
      String str = null;
      Object localObject1 = str;
      Object localObject2 = localObject1;
      int k = 0;
      int j = 0;
      while (paramJsonReader.hasNext())
      {
        Object localObject3 = paramJsonReader.nextName();
        int i = -1;
        int m = ((String)localObject3).hashCode();
        if (m != -1109732030)
        {
          if (m != 104)
          {
            if (m != 112)
            {
              if (m != 117)
              {
                if (m != 119)
                {
                  if ((m == 3355) && (((String)localObject3).equals("id"))) {
                    i = 0;
                  }
                }
                else if (((String)localObject3).equals("w")) {
                  i = 2;
                }
              }
              else if (((String)localObject3).equals("u")) {
                i = 5;
              }
            }
            else if (((String)localObject3).equals("p")) {
              i = 4;
            }
          }
          else if (((String)localObject3).equals("h")) {
            i = 3;
          }
        }
        else if (((String)localObject3).equals("layers")) {
          i = 1;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4)
                {
                  if (i != 5) {
                    paramJsonReader.skipValue();
                  } else {
                    localObject2 = paramJsonReader.nextString();
                  }
                }
                else {
                  localObject1 = paramJsonReader.nextString();
                }
              }
              else {
                j = paramJsonReader.nextInt();
              }
            }
            else {
              k = paramJsonReader.nextInt();
            }
          }
          else
          {
            paramJsonReader.beginArray();
            while (paramJsonReader.hasNext())
            {
              localObject3 = LayerParser.parse(paramJsonReader, paramLottieComposition);
              localLongSparseArray.put(((Layer)localObject3).getId(), localObject3);
              localArrayList.add(localObject3);
            }
            paramJsonReader.endArray();
          }
        }
        else {
          str = paramJsonReader.nextString();
        }
      }
      paramJsonReader.endObject();
      if (localObject1 != null)
      {
        localObject1 = new LottieImageAsset(k, j, str, (String)localObject1, (String)localObject2);
        paramMap1.put(((LottieImageAsset)localObject1).getId(), localObject1);
      }
      else
      {
        paramMap.put(str, localArrayList);
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
    while (paramJsonReader.hasNext())
    {
      Object localObject = paramJsonReader.nextName();
      int i = -1;
      if ((((String)localObject).hashCode() == 3322014) && (((String)localObject).equals("list"))) {
        i = 0;
      }
      if (i != 0)
      {
        paramJsonReader.skipValue();
      }
      else
      {
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          localObject = FontParser.parse(paramJsonReader);
          paramMap.put(((Font)localObject).getName(), localObject);
        }
        paramJsonReader.endArray();
      }
    }
    paramJsonReader.endObject();
  }
  
  private static void parseLayers(JsonReader paramJsonReader, LottieComposition paramLottieComposition, List<Layer> paramList, LongSparseArray<Layer> paramLongSparseArray)
  {
    paramJsonReader.beginArray();
    int i = 0;
    while (paramJsonReader.hasNext())
    {
      Object localObject = LayerParser.parse(paramJsonReader, paramLottieComposition);
      int j = i;
      if (((Layer)localObject).getLayerType() == Layer.LayerType.IMAGE) {
        j = i + 1;
      }
      paramList.add(localObject);
      paramLongSparseArray.put(((Layer)localObject).getId(), localObject);
      i = j;
      if (j > 4)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("You have ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
        L.warn(((StringBuilder)localObject).toString());
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
      while (paramJsonReader.hasNext())
      {
        String str = paramJsonReader.nextName();
        int i = -1;
        int j = str.hashCode();
        if (j != 3178)
        {
          if (j != 3214)
          {
            if ((j == 3705) && (str.equals("tm"))) {
              i = 1;
            }
          }
          else if (str.equals("dr")) {
            i = 2;
          }
        }
        else if (str.equals("cm")) {
          i = 0;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2) {
              paramJsonReader.skipValue();
            } else {
              f1 = (float)paramJsonReader.nextDouble();
            }
          }
          else {
            f2 = (float)paramJsonReader.nextDouble();
          }
        }
        else {
          paramLottieComposition = paramJsonReader.nextString();
        }
      }
      paramJsonReader.endObject();
      paramList.add(new Marker(paramLottieComposition, f2, f1));
    }
    paramJsonReader.endArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.LottieCompositionParser
 * JD-Core Version:    0.7.0.1
 */