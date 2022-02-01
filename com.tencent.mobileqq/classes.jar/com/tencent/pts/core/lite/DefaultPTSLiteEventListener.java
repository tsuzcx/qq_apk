package com.tencent.pts.core.lite;

import android.text.TextUtils;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DefaultPTSLiteEventListener
  implements IPTSLiteEventListener
{
  protected String getLogString(String paramString, HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("identifier = ");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    localStringBuilder2.append(str).append("\n");
    if (paramHashMap != null)
    {
      paramString = paramHashMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (Map.Entry)paramString.next();
        localStringBuilder1.append("dataSet [ ").append((String)paramHashMap.getKey()).append(" ] = ").append((String)paramHashMap.getValue()).append("\n");
      }
    }
    return localStringBuilder1.toString();
  }
  
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onScrollViewItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onSwiperDragTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onSwiperItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.lite.DefaultPTSLiteEventListener
 * JD-Core Version:    0.7.0.1
 */