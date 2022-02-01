package com.tencent.mobileqq.vas.hippyhelper;

import com.tencent.mtt.hippy.common.HippyMap;
import org.jetbrains.annotations.NotNull;

public abstract interface IHippyJsbInvokeAdapter
{
  public abstract Object createFakeWebView(Object paramObject);
  
  public abstract Object createWebViewPlugin(String paramString);
  
  public abstract String[] getDispatchArgsNameList(String paramString);
  
  public abstract String getDispatchMethodName(String paramString);
  
  public abstract Object getInvokeArgs(int paramInt, Class<?> paramClass, @NotNull Object paramObject, String paramString);
  
  public abstract String getJsbMethod(HippyMap paramHippyMap);
  
  public abstract String getJsbNameSpace(HippyMap paramHippyMap);
  
  public abstract boolean isNeedIntercept(HippyMap paramHippyMap);
  
  public abstract void onCallError(String paramString);
  
  public abstract void onCallJs(Object paramObject);
  
  public abstract void onUpdateActivity(Object paramObject);
  
  public abstract void setWebViewInternal(Object paramObject1, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippyhelper.IHippyJsbInvokeAdapter
 * JD-Core Version:    0.7.0.1
 */