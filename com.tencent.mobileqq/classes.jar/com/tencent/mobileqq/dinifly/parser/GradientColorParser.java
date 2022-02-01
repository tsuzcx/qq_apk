package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Color;
import android.support.annotation.IntRange;
import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

public class GradientColorParser
  implements ValueParser<GradientColor>
{
  private int colorPoints;
  
  public GradientColorParser(int paramInt)
  {
    this.colorPoints = paramInt;
  }
  
  private void addOpacityStopsToGradientIfNeeded(GradientColor paramGradientColor, List<Float> paramList)
  {
    int m = 0;
    int j = this.colorPoints * 4;
    if (paramList.size() <= j) {}
    for (;;)
    {
      return;
      int i = (paramList.size() - j) / 2;
      double[] arrayOfDouble1 = new double[i];
      double[] arrayOfDouble2 = new double[i];
      i = 0;
      int k = m;
      if (j < paramList.size())
      {
        if (j % 2 == 0) {
          arrayOfDouble1[i] = ((Float)paramList.get(j)).floatValue();
        }
        for (;;)
        {
          j += 1;
          break;
          arrayOfDouble2[i] = ((Float)paramList.get(j)).floatValue();
          i += 1;
        }
      }
      while (k < paramGradientColor.getSize())
      {
        i = paramGradientColor.getColors()[k];
        i = Color.argb(getOpacityAtPosition(paramGradientColor.getPositions()[k], arrayOfDouble1, arrayOfDouble2), Color.red(i), Color.green(i), Color.blue(i));
        paramGradientColor.getColors()[k] = i;
        k += 1;
      }
    }
  }
  
  @IntRange(from=0L, to=255L)
  private int getOpacityAtPosition(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    int i = 1;
    while (i < paramArrayOfDouble1.length)
    {
      double d1 = paramArrayOfDouble1[(i - 1)];
      double d2 = paramArrayOfDouble1[i];
      if (paramArrayOfDouble1[i] >= paramDouble)
      {
        paramDouble = (paramDouble - d1) / (d2 - d1);
        return (int)(MiscUtils.lerp(paramArrayOfDouble2[(i - 1)], paramArrayOfDouble2[i], paramDouble) * 255.0D);
      }
      i += 1;
    }
    return (int)(paramArrayOfDouble2[(paramArrayOfDouble2.length - 1)] * 255.0D);
  }
  
  public GradientColor parse(JsonReader paramJsonReader, float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramJsonReader.beginArray();
      }
      while (paramJsonReader.hasNext()) {
        localArrayList.add(Float.valueOf((float)paramJsonReader.nextDouble()));
      }
    }
    if (i != 0) {
      paramJsonReader.endArray();
    }
    if (this.colorPoints == -1) {
      this.colorPoints = (localArrayList.size() / 4);
    }
    paramJsonReader = new float[this.colorPoints];
    int[] arrayOfInt = new int[this.colorPoints];
    i = 0;
    int k = 0;
    int j = 0;
    if (i < this.colorPoints * 4)
    {
      int m = i / 4;
      double d = ((Float)localArrayList.get(i)).floatValue();
      switch (i % 4)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramJsonReader[m] = ((float)d);
        continue;
        j = (int)(d * 255.0D);
        continue;
        k = (int)(d * 255.0D);
        continue;
        arrayOfInt[m] = Color.argb(255, j, k, (int)(d * 255.0D));
      }
    }
    paramJsonReader = new GradientColor(paramJsonReader, arrayOfInt);
    addOpacityStopsToGradientIfNeeded(paramJsonReader, localArrayList);
    return paramJsonReader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.GradientColorParser
 * JD-Core Version:    0.7.0.1
 */