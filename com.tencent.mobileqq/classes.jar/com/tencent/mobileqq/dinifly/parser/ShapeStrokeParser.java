package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import java.util.ArrayList;
import java.util.List;

class ShapeStrokeParser
{
  static ShapeStroke parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    Object localObject1 = null;
    AnimatableColorValue localAnimatableColorValue = null;
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    AnimatableFloatValue localAnimatableFloatValue = null;
    ShapeStroke.LineCapType localLineCapType = null;
    ShapeStroke.LineJoinType localLineJoinType = null;
    float f = 0.0F;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      Object localObject2 = paramJsonReader.nextName();
      int i = ((String)localObject2).hashCode();
      if (i != 99)
      {
        if (i != 100)
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
                      if ((i == 3519) && (((String)localObject2).equals("nm")))
                      {
                        i = 0;
                        break label256;
                      }
                    }
                    else if (((String)localObject2).equals("ml"))
                    {
                      i = 6;
                      break label256;
                    }
                  }
                  else if (((String)localObject2).equals("lj"))
                  {
                    i = 5;
                    break label256;
                  }
                }
                else if (((String)localObject2).equals("lc"))
                {
                  i = 4;
                  break label256;
                }
              }
              else if (((String)localObject2).equals("hd"))
              {
                i = 7;
                break label256;
              }
            }
            else if (((String)localObject2).equals("w"))
            {
              i = 2;
              break label256;
            }
          }
          else if (((String)localObject2).equals("o"))
          {
            i = 3;
            break label256;
          }
        }
        else if (((String)localObject2).equals("d"))
        {
          i = 8;
          break label256;
        }
      }
      else if (((String)localObject2).equals("c"))
      {
        i = 1;
        break label256;
      }
      i = -1;
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 8: 
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          paramJsonReader.beginObject();
          String str2 = null;
          localObject2 = null;
          while (paramJsonReader.hasNext())
          {
            String str3 = paramJsonReader.nextName();
            i = str3.hashCode();
            if (i != 110)
            {
              if ((i == 118) && (str3.equals("v")))
              {
                i = 1;
                break label402;
              }
            }
            else if (str3.equals("n"))
            {
              i = 0;
              break label402;
            }
            i = -1;
            if (i != 0)
            {
              if (i != 1) {
                paramJsonReader.skipValue();
              } else {
                localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
              }
            }
            else {
              str2 = paramJsonReader.nextString();
            }
          }
          paramJsonReader.endObject();
          i = str2.hashCode();
          if (i != 100)
          {
            if (i != 103)
            {
              if ((i == 111) && (str2.equals("o")))
              {
                i = 0;
                break label515;
              }
            }
            else if (str2.equals("g"))
            {
              i = 2;
              break label515;
            }
          }
          else if (str2.equals("d"))
          {
            i = 1;
            break label515;
          }
          i = -1;
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2) {}
            }
            else
            {
              for (;;)
              {
                break;
              }
              paramLottieComposition.setHasDashPattern(true);
              localArrayList.add(localObject2);
            }
          }
          else {
            localObject1 = localObject2;
          }
        }
        paramJsonReader.endArray();
        if (localArrayList.size() == 1) {
          localArrayList.add(localArrayList.get(0));
        }
        break;
      case 7: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 6: 
        f = (float)paramJsonReader.nextDouble();
        break;
      case 5: 
        localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJsonReader.nextInt() - 1)];
        break;
      case 4: 
        localLineCapType = ShapeStroke.LineCapType.values()[(paramJsonReader.nextInt() - 1)];
        break;
      case 3: 
        localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        break;
      case 2: 
        localAnimatableFloatValue = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        label515:
        localAnimatableColorValue = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
        break;
      case 0: 
        label256:
        label402:
        str1 = paramJsonReader.nextString();
      }
    }
    return new ShapeStroke(str1, localObject1, localArrayList, localAnimatableColorValue, localAnimatableIntegerValue, localAnimatableFloatValue, localLineCapType, localLineJoinType, f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeStrokeParser
 * JD-Core Version:    0.7.0.1
 */