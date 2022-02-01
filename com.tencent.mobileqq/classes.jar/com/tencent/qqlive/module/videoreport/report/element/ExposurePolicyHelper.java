package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
  
  @Nullable
  public static EleExposeInfo getEleExposeInfo(Object paramObject, View paramView, String paramString)
  {
    paramObject = getPageOrContainer(paramObject, paramView);
    if (paramObject == null) {
      return null;
    }
    return getEleExposeInfo(paramObject, paramString);
  }
  
  private static EleExposeInfo getEleExposeInfo(Object paramObject, String paramString)
  {
    paramString = getReExposeKey(paramObject, paramString);
    paramObject = getEleExposureMap(paramObject).get(paramString);
    if ((paramObject instanceof EleExposeInfo)) {
      return (EleExposeInfo)paramObject;
    }
    return null;
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
      if (paramView != null) {
        break label14;
      }
      localObject = null;
    }
    label14:
    do
    {
      return localObject;
      paramObject = ViewContainerBinder.getInstance().getBoundContainer(paramView.getRootView());
      localObject = paramObject;
    } while (paramObject != null);
    return null;
  }
  
  public static String getReExposeKey(Object paramObject, String paramString)
  {
    return paramObject.hashCode() + paramString;
  }
  
  public static void putEleExposeInfo(Object paramObject, View paramView, String paramString, EleExposeInfo paramEleExposeInfo)
  {
    paramObject = getPageOrContainer(paramObject, paramView);
    if (paramObject == null) {
      return;
    }
    putEleExposeInfo(paramObject, getReExposeKey(paramObject, paramString), paramEleExposeInfo);
  }
  
  private static void putEleExposeInfo(Object paramObject, String paramString, EleExposeInfo paramEleExposeInfo)
  {
    getEleExposureMap(paramObject).put(paramString, paramEleExposeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ExposurePolicyHelper
 * JD-Core Version:    0.7.0.1
 */