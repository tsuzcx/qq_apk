package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientStroke;
import com.tencent.mobileqq.dinifly.model.content.GradientType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import java.util.ArrayList;
import java.util.List;

class GradientStrokeParser
{
  static GradientStroke parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    Object localObject4 = null;
    AnimatableGradientColorValue localAnimatableGradientColorValue = null;
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    AnimatablePointValue localAnimatablePointValue2 = null;
    AnimatablePointValue localAnimatablePointValue1 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    ShapeStroke.LineJoinType localLineJoinType = null;
    float f = 0.0F;
    Object localObject3 = null;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      Object localObject5 = paramJsonReader.nextName();
      int i = ((String)localObject5).hashCode();
      if (i != 100)
      {
        if (i != 101)
        {
          if (i != 103)
          {
            if (i != 111)
            {
              if (i != 119)
              {
                if (i != 3324)
                {
                  if (i != 3447)
                  {
                    if (i != 3454)
                    {
                      if (i != 3487)
                      {
                        if (i != 3519)
                        {
                          if (i != 115)
                          {
                            if ((i == 116) && (((String)localObject5).equals("t")))
                            {
                              i = 3;
                              break label331;
                            }
                          }
                          else if (((String)localObject5).equals("s"))
                          {
                            i = 4;
                            break label331;
                          }
                        }
                        else if (((String)localObject5).equals("nm"))
                        {
                          i = 0;
                          break label331;
                        }
                      }
                      else if (((String)localObject5).equals("ml"))
                      {
                        i = 9;
                        break label331;
                      }
                    }
                    else if (((String)localObject5).equals("lj"))
                    {
                      i = 8;
                      break label331;
                    }
                  }
                  else if (((String)localObject5).equals("lc"))
                  {
                    i = 7;
                    break label331;
                  }
                }
                else if (((String)localObject5).equals("hd"))
                {
                  i = 10;
                  break label331;
                }
              }
              else if (((String)localObject5).equals("w"))
              {
                i = 6;
                break label331;
              }
            }
            else if (((String)localObject5).equals("o"))
            {
              i = 2;
              break label331;
            }
          }
          else if (((String)localObject5).equals("g"))
          {
            i = 1;
            break label331;
          }
        }
        else if (((String)localObject5).equals("e"))
        {
          i = 5;
          break label331;
        }
      }
      else if (((String)localObject5).equals("d"))
      {
        i = 11;
        break label331;
      }
      i = -1;
      switch (i)
      {
      default: 
        label331:
        paramJsonReader.skipValue();
      }
      for (;;)
      {
        localObject5 = localObject1;
        localObject1 = localObject2;
        break;
        paramJsonReader.beginArray();
        label597:
        while (paramJsonReader.hasNext())
        {
          paramJsonReader.beginObject();
          String str2 = null;
          localObject5 = null;
          Object localObject6;
          while (paramJsonReader.hasNext())
          {
            localObject6 = paramJsonReader.nextName();
            i = ((String)localObject6).hashCode();
            if (i != 110)
            {
              if ((i == 118) && (((String)localObject6).equals("v")))
              {
                i = 1;
                break label498;
              }
            }
            else if (((String)localObject6).equals("n"))
            {
              i = 0;
              break label498;
            }
            i = -1;
            label498:
            if (i != 0)
            {
              if (i != 1) {
                paramJsonReader.skipValue();
              } else {
                localObject5 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
              }
            }
            else {
              str2 = paramJsonReader.nextString();
            }
          }
          paramJsonReader.endObject();
          if (str2.equals("o")) {
            localObject6 = localObject5;
          }
          do
          {
            localObject3 = localObject6;
            break label597;
            if (str2.equals("d")) {
              break;
            }
            localObject6 = localObject3;
          } while (!str2.equals("g"));
          paramLottieComposition.setHasDashPattern(true);
          localArrayList.add(localObject5);
        }
        paramJsonReader.endArray();
        if (localArrayList.size() == 1)
        {
          localArrayList.add(localArrayList.get(0));
        }
        else
        {
          break label768;
          bool = paramJsonReader.nextBoolean();
          continue;
          f = (float)paramJsonReader.nextDouble();
          continue;
          localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJsonReader.nextInt() - 1)];
          localObject5 = localObject1;
          localObject1 = localObject2;
          break;
          localObject1 = ShapeStroke.LineCapType.values()[(paramJsonReader.nextInt() - 1)];
          break label778;
          localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
          localObject5 = localObject1;
          localObject1 = localObject2;
          break;
          localAnimatablePointValue1 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
          break label778;
          localAnimatablePointValue2 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
          break label778;
          localObject4 = localObject1;
          if (paramJsonReader.nextInt() == 1) {
            localObject1 = GradientType.LINEAR;
          } else {
            localObject1 = GradientType.RADIAL;
          }
          localObject5 = localObject1;
          localObject1 = localObject4;
          localObject4 = localObject5;
        }
        label768:
        break label895;
        localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        label778:
        continue;
        paramJsonReader.beginObject();
        int j = -1;
        while (paramJsonReader.hasNext())
        {
          localObject5 = paramJsonReader.nextName();
          i = ((String)localObject5).hashCode();
          if (i != 107)
          {
            if ((i == 112) && (((String)localObject5).equals("p")))
            {
              i = 0;
              break label854;
            }
          }
          else if (((String)localObject5).equals("k"))
          {
            i = 1;
            break label854;
          }
          i = -1;
          label854:
          if (i != 0)
          {
            if (i != 1) {
              paramJsonReader.skipValue();
            } else {
              localAnimatableGradientColorValue = AnimatableValueParser.parseGradientColor(paramJsonReader, paramLottieComposition, j);
            }
          }
          else {
            j = paramJsonReader.nextInt();
          }
        }
        paramJsonReader.endObject();
        label895:
        continue;
        str1 = paramJsonReader.nextString();
      }
      localObject2 = localObject1;
      localObject1 = localObject5;
    }
    return new GradientStroke(str1, localObject4, localAnimatableGradientColorValue, localAnimatableIntegerValue, localAnimatablePointValue2, localAnimatablePointValue1, (AnimatableFloatValue)localObject2, (ShapeStroke.LineCapType)localObject1, localLineJoinType, f, localArrayList, localObject3, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.GradientStrokeParser
 * JD-Core Version:    0.7.0.1
 */