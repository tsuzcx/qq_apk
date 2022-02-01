package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.layer.Layer;
import com.tencent.mobileqq.dinifly.model.layer.Layer.LayerType;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.utils.Logger;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottieCompositionParser
{
  static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers" });
  
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
    label272:
    for (;;)
    {
      Object localObject = paramJsonReader;
      if (!paramJsonReader.hasNext()) {
        break;
      }
      switch (((JsonReader)localObject).selectName(NAMES))
      {
      }
      for (;;)
      {
        break;
        parseLayers((JsonReader)localObject, localLottieComposition, localArrayList2, localLongSparseArray);
        continue;
        localObject = paramJsonReader.nextString().split("\\.");
        if (!Utils.isAtLeastVersion(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Integer.parseInt(localObject[2]), 4, 4, 0)) {
          localLottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
        }
        break label272;
        f1 = (float)paramJsonReader.nextDouble();
        break label272;
        f2 = (float)paramJsonReader.nextDouble() - 0.01F;
        break label272;
        f3 = (float)paramJsonReader.nextDouble();
        break label272;
        i = paramJsonReader.nextInt();
        break label272;
        j = paramJsonReader.nextInt();
        break label272;
      }
      paramJsonReader.skipValue();
    }
    localLottieComposition.init(new Rect(0, 0, (int)(j * f4), (int)(i * f4)), f3, f2, f1, localArrayList2, localLongSparseArray, localHashMap2, localHashMap3, localSparseArrayCompat, localHashMap1, localArrayList1);
    return localLottieComposition;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.LottieCompositionParser
 * JD-Core Version:    0.7.0.1
 */