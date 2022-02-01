package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.model.Font;
import com.tencent.mobileqq.dinifly.model.FontCharacter;
import com.tencent.mobileqq.dinifly.model.Marker;
import com.tencent.mobileqq.dinifly.model.layer.Layer;
import com.tencent.mobileqq.dinifly.model.layer.Layer.LayerType;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.utils.Logger;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottieCompositionMoshiParser
{
  static JsonReader.Options ASSETS_NAMES = JsonReader.Options.of(new String[] { "id", "layers", "w", "h", "p", "u" });
  private static final JsonReader.Options FONT_NAMES = JsonReader.Options.of(new String[] { "list" });
  private static final JsonReader.Options MARKER_NAMES = JsonReader.Options.of(new String[] { "cm", "tm", "dr" });
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers" });
  
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
    int j = 0;
    int i = 0;
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    for (;;)
    {
      Object localObject = paramJsonReader;
      if (!paramJsonReader.hasNext()) {
        break;
      }
      switch (((JsonReader)localObject).selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 10: 
        parseMarkers((JsonReader)localObject, localLottieComposition, localArrayList1);
        break;
      case 9: 
        parseChars((JsonReader)localObject, localLottieComposition, localSparseArrayCompat);
        break;
      case 8: 
        parseFonts((JsonReader)localObject, localHashMap1);
        break;
      case 7: 
        parseAssets((JsonReader)localObject, localLottieComposition, localHashMap2, localHashMap3);
        break;
      case 6: 
        parseLayers((JsonReader)localObject, localLottieComposition, localArrayList2, localLongSparseArray);
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
        i = paramJsonReader.nextInt();
        break;
      }
      j = paramJsonReader.nextInt();
    }
    localLottieComposition.init(new Rect(0, 0, (int)(j * f4), (int)(i * f4)), f3, f2, f1, localArrayList2, localLongSparseArray, localHashMap2, localHashMap3, localSparseArrayCompat, localHashMap1, localArrayList1);
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
      int j = 0;
      int i = 0;
      while (paramJsonReader.hasNext())
      {
        int k = paramJsonReader.selectName(ASSETS_NAMES);
        if (k != 0)
        {
          if (k != 1)
          {
            if (k != 2)
            {
              if (k != 3)
              {
                if (k != 4)
                {
                  if (k != 5)
                  {
                    paramJsonReader.skipName();
                    paramJsonReader.skipValue();
                  }
                  else
                  {
                    localObject2 = paramJsonReader.nextString();
                  }
                }
                else {
                  localObject1 = paramJsonReader.nextString();
                }
              }
              else {
                i = paramJsonReader.nextInt();
              }
            }
            else {
              j = paramJsonReader.nextInt();
            }
          }
          else
          {
            paramJsonReader.beginArray();
            while (paramJsonReader.hasNext())
            {
              Layer localLayer = LayerParser.parse(paramJsonReader, paramLottieComposition);
              localLongSparseArray.put(localLayer.getId(), localLayer);
              localArrayList.add(localLayer);
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
        localObject1 = new LottieImageAsset(j, i, str, (String)localObject1, (String)localObject2);
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
    while (paramJsonReader.hasNext()) {
      if (paramJsonReader.selectName(FONT_NAMES) != 0)
      {
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
      }
      else
      {
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          Font localFont = FontParser.parse(paramJsonReader);
          paramMap.put(localFont.getName(), localFont);
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
        Logger.warning(((StringBuilder)localObject).toString());
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
        int i = paramJsonReader.selectName(MARKER_NAMES);
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              paramJsonReader.skipName();
              paramJsonReader.skipValue();
            }
            else
            {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.LottieCompositionMoshiParser
 * JD-Core Version:    0.7.0.1
 */