package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import java.util.HashMap;
import java.util.Map;

public class ExposurePolicyHelper
{
  public static final String TAG = "ExposurePolicy";
  
  public static void clearEleExposureMap(Object paramObject)
  {
    getEleExposureMap(paramObject).clear();
  }
  
  private static EleExposeInfo getCacheEleExposeInfo(Object paramObject, View paramView, String paramString, boolean paramBoolean)
  {
    paramView = getReExposeKey(paramObject, paramView, paramString, paramBoolean);
    paramObject = getEleExposureMap(paramObject).get(paramView);
    if ((paramObject instanceof EleExposeInfo)) {
      return (EleExposeInfo)paramObject;
    }
    return null;
  }
  
  @Nullable
  public static EleExposeInfo getEleExposeInfo(Object paramObject, View paramView, String paramString, boolean paramBoolean)
  {
    paramObject = getPageOrContainer(paramObject, paramView);
    if (paramObject == null) {
      return null;
    }
    return getCacheEleExposeInfo(paramObject, paramView, paramString, paramBoolean);
  }
  
  @NonNull
  private static Map<String, Object> getEleExposureMap(Object paramObject)
  {
    Object localObject = DataRWProxy.getInnerParam(paramObject, "element_exposure_map");
    if (!(localObject instanceof Map))
    {
      localObject = new HashMap();
      DataRWProxy.setInnerParam(paramObject, "element_exposure_map", localObject);
      return localObject;
    }
    return (Map)localObject;
  }
  
  private static Object getPageOrContainer(Object paramObject, View paramView)
  {
    Object localObject = paramObject;
    if (paramObject == null)
    {
      if (paramView == null) {
        return null;
      }
      localObject = ViewContainerBinder.getInstance().getBoundContainer(paramView.getRootView());
      if (localObject == null) {
        return null;
      }
    }
    return localObject;
  }
  
  public static String getReExposeKey(Object paramObject, View paramView, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      if (paramView != null)
      {
        paramString = new StringBuilder();
        paramString.append(paramView.hashCode());
        paramString.append("");
        str = paramString.toString();
      }
    }
    paramView = str;
    if (paramBoolean)
    {
      paramView = new StringBuilder();
      paramView.append("identifier_scroll");
      paramView.append(str);
      paramView = paramView.toString();
    }
    paramString = new StringBuilder();
    paramString.append(paramObject.hashCode());
    paramString.append(paramView);
    return paramString.toString();
  }
  
  public static void putEleExposeInfo(Object paramObject, View paramView, String paramString, EleExposeInfo paramEleExposeInfo, boolean paramBoolean)
  {
    paramObject = getPageOrContainer(paramObject, paramView);
    if (paramObject == null) {
      return;
    }
    putEleExposeInfo(paramObject, getReExposeKey(paramObject, paramView, paramString, paramBoolean), paramEleExposeInfo);
  }
  
  private static void putEleExposeInfo(Object paramObject, String paramString, EleExposeInfo paramEleExposeInfo)
  {
    getEleExposureMap(paramObject).put(paramString, paramEleExposeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ExposurePolicyHelper
 * JD-Core Version:    0.7.0.1
 */