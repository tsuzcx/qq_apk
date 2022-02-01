package com.tencent.viola.ui.animation;

import android.app.Application;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.View;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.DataStructureUtil;
import com.tencent.viola.utils.FunctionParser.Mapper;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class TransformParser$1
  implements FunctionParser.Mapper<Property<View, Float>, Float>
{
  TransformParser$1(int paramInt1, int paramInt2, int paramInt3) {}
  
  private Map<Property<View, Float>, Float> convertParam(int paramInt1, int paramInt2, int paramInt3, @NonNull List<Property<View, Float>> paramList, @NonNull List<String> paramList1)
  {
    HashMap localHashMap = DataStructureUtil.newHashMapWithExpectedSize(paramList.size());
    ArrayList localArrayList = new ArrayList(paramList.size());
    if ((paramList.contains(View.ROTATION)) || (paramList.contains(View.ROTATION_X)) || (paramList.contains(View.ROTATION_Y))) {
      localArrayList.addAll(parseRotationZ(paramList1));
    }
    while (paramList.size() == localArrayList.size())
    {
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        localHashMap.put(paramList.get(paramInt1), localArrayList.get(paramInt1));
        paramInt1 += 1;
      }
      if ((paramList.contains(View.TRANSLATION_X)) || (paramList.contains(View.TRANSLATION_Y))) {
        localArrayList.addAll(parseTranslation(paramList, paramInt1, paramInt2, paramList1, paramInt3));
      } else if ((paramList.contains(View.SCALE_X)) || (paramList.contains(View.SCALE_Y))) {
        localArrayList.addAll(parseScale(paramList.size(), paramList1));
      } else if (paramList.contains(CameraDistanceProperty.getInstance())) {
        localArrayList.add(parseCameraDistance(paramList1));
      }
    }
    return localHashMap;
  }
  
  private Float parseCameraDistance(List<String> paramList)
  {
    float f2 = 3.4028235E+38F;
    float f1 = f2;
    if (paramList.size() == 1)
    {
      float f3 = FlexConvertUtils.converPxByViewportToRealPx(paramList.get(0), this.val$viewportW);
      float f4 = ViolaEnvironment.getApplication().getResources().getDisplayMetrics().density;
      f1 = f2;
      if (!Float.isNaN(f3))
      {
        f1 = f2;
        if (f3 > 0.0F) {
          f1 = f3 * f4;
        }
      }
    }
    return Float.valueOf(f1);
  }
  
  private void parseDoubleTranslation(int paramInt1, int paramInt2, @NonNull List<String> paramList, List<Float> paramList1, String paramString, int paramInt3)
  {
    if (paramList.size() == 1) {}
    for (paramList = paramString;; paramList = (String)paramList.get(1))
    {
      paramList1.add(Float.valueOf(TransformParser.access$000(paramString, paramInt1, paramInt3)));
      paramList1.add(Float.valueOf(TransformParser.access$000(paramList, paramInt2, paramInt3)));
      return;
    }
  }
  
  @NonNull
  private List<Float> parseRotationZ(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      int i = str.lastIndexOf("deg");
      if (i != -1) {
        localArrayList.add(Float.valueOf(ViolaUtils.fastGetFloat(str.substring(0, i))));
      } else {
        localArrayList.add(Float.valueOf((float)Math.toDegrees(Double.parseDouble(str))));
      }
    }
    return localArrayList;
  }
  
  private List<Float> parseScale(int paramInt, @NonNull List<String> paramList)
  {
    ArrayList localArrayList1 = new ArrayList(paramList.size() * 2);
    ArrayList localArrayList2 = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localArrayList2.add(Float.valueOf(ViolaUtils.fastGetFloat((String)localIterator.next())));
    }
    localArrayList1.addAll(localArrayList2);
    if ((paramInt != 1) && (paramList.size() == 1)) {
      localArrayList1.addAll(localArrayList2);
    }
    return localArrayList1;
  }
  
  private void parseSingleTranslation(List<Property<View, Float>> paramList, int paramInt1, int paramInt2, List<Float> paramList1, String paramString, int paramInt3)
  {
    if (paramList.contains(View.TRANSLATION_X)) {
      paramList1.add(Float.valueOf(TransformParser.access$000(paramString, paramInt1, paramInt3)));
    }
    while (!paramList.contains(View.TRANSLATION_Y)) {
      return;
    }
    paramList1.add(Float.valueOf(TransformParser.access$000(paramString, paramInt2, paramInt3)));
  }
  
  private List<Float> parseTranslation(List<Property<View, Float>> paramList, int paramInt1, int paramInt2, @NonNull List<String> paramList1, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList(2);
    String str = (String)paramList1.get(0);
    if (paramList.size() == 1)
    {
      parseSingleTranslation(paramList, paramInt1, paramInt2, localArrayList, str, paramInt3);
      return localArrayList;
    }
    parseDoubleTranslation(paramInt1, paramInt2, paramList1, localArrayList, str, paramInt3);
    return localArrayList;
  }
  
  public Map<Property<View, Float>, Float> map(String paramString, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (TransformParser.toAndroidMap.containsKey(paramString))) {
      return convertParam(this.val$width, this.val$height, this.val$viewportW, (List)TransformParser.toAndroidMap.get(paramString), paramList);
    }
    return new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.animation.TransformParser.1
 * JD-Core Version:    0.7.0.1
 */