package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Token;
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
    int i = this.colorPoints * 4;
    if (paramList.size() <= i) {
      return;
    }
    int j = (paramList.size() - i) / 2;
    double[] arrayOfDouble1 = new double[j];
    double[] arrayOfDouble2 = new double[j];
    int m = 0;
    int k = 0;
    for (;;)
    {
      j = m;
      if (i >= paramList.size()) {
        break;
      }
      if (i % 2 == 0)
      {
        arrayOfDouble1[k] = ((Float)paramList.get(i)).floatValue();
      }
      else
      {
        arrayOfDouble2[k] = ((Float)paramList.get(i)).floatValue();
        k += 1;
      }
      i += 1;
    }
    while (j < paramGradientColor.getSize())
    {
      i = paramGradientColor.getColors()[j];
      i = Color.argb(getOpacityAtPosition(paramGradientColor.getPositions()[j], arrayOfDouble1, arrayOfDouble2), Color.red(i), Color.green(i), Color.blue(i));
      paramGradientColor.getColors()[j] = i;
      j += 1;
    }
  }
  
  @IntRange(from=0L, to=255L)
  private int getOpacityAtPosition(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    int i = 1;
    int j;
    if (i < paramArrayOfDouble1.length)
    {
      j = i - 1;
      double d1 = paramArrayOfDouble1[j];
      double d2 = paramArrayOfDouble1[i];
      if (paramArrayOfDouble1[i] >= paramDouble) {
        paramDouble = MiscUtils.clamp((paramDouble - d1) / (d2 - d1), 0.0D, 1.0D);
      }
    }
    for (paramDouble = MiscUtils.lerp(paramArrayOfDouble2[j], paramArrayOfDouble2[i], paramDouble);; paramDouble = paramArrayOfDouble2[(paramArrayOfDouble2.length - 1)])
    {
      return (int)(paramDouble * 255.0D);
      i += 1;
      break;
    }
  }
  
  public GradientColor parse(JsonReader paramJsonReader, float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramJsonReader.peek();
    JsonReader.Token localToken = JsonReader.Token.BEGIN_ARRAY;
    int k = 0;
    if (localObject == localToken) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramJsonReader.beginArray();
    }
    while (paramJsonReader.hasNext()) {
      localArrayList.add(Float.valueOf((float)paramJsonReader.nextDouble()));
    }
    if (i != 0) {
      paramJsonReader.endArray();
    }
    if (this.colorPoints == -1) {
      this.colorPoints = (localArrayList.size() / 4);
    }
    int i = this.colorPoints;
    paramJsonReader = new float[i];
    localObject = new int[i];
    int m = 0;
    int j = 0;
    i = k;
    k = m;
    while (i < this.colorPoints * 4)
    {
      m = i / 4;
      double d = ((Float)localArrayList.get(i)).floatValue();
      int n = i % 4;
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            if (n == 3)
            {
              Double.isNaN(d);
              localObject[m] = Color.argb(255, k, j, (int)(d * 255.0D));
            }
          }
          else
          {
            Double.isNaN(d);
            j = (int)(d * 255.0D);
          }
        }
        else
        {
          Double.isNaN(d);
          k = (int)(d * 255.0D);
        }
      }
      else
      {
        if (m > 0)
        {
          paramFloat = paramJsonReader[(m - 1)];
          float f = (float)d;
          if (paramFloat >= f)
          {
            paramJsonReader[m] = (f + 0.01F);
            break label303;
          }
        }
        paramJsonReader[m] = ((float)d);
      }
      label303:
      i += 1;
    }
    paramJsonReader = new GradientColor(paramJsonReader, (int[])localObject);
    addOpacityStopsToGradientIfNeeded(paramJsonReader, localArrayList);
    return paramJsonReader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.GradientColorParser
 * JD-Core Version:    0.7.0.1
 */