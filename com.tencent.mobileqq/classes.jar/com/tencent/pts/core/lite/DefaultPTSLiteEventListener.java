package com.tencent.pts.core.lite;

import android.text.TextUtils;
import android.view.View;
import com.tencent.pts.core.PTSComposer;
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
  
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer) {}
  
  public void onScrollViewItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer) {}
  
  public void onSwiperDragTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer) {}
  
  public void onSwiperItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.core.lite.DefaultPTSLiteEventListener
 * JD-Core Version:    0.7.0.1
 */