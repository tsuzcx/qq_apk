package com.tencent.mtt.hippy.views.navigator;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;

@HippyController(name="Navigator")
public class NavigatorController
  extends HippyGroupController<Navigator>
{
  public static final String CLASS = "Navigator";
  private static final String POP = "pop";
  private static final String PUSH = "push";
  
  public static void destroyInstance(View paramView)
  {
    if ((paramView instanceof HippyRootView))
    {
      HippyInstanceContext localHippyInstanceContext = (HippyInstanceContext)paramView.getContext();
      paramView = (HippyRootView)paramView;
      localHippyInstanceContext.getEngineManager().destroyModule(paramView);
    }
  }
  
  private HippyRootView loadNavPage(Navigator paramNavigator, String paramString, HippyMap paramHippyMap)
  {
    paramNavigator = (HippyInstanceContext)paramNavigator.getContext();
    HippyEngine.ModuleLoadParams localModuleLoadParams = new HippyEngine.ModuleLoadParams(paramNavigator.getModuleParams());
    localModuleLoadParams.componentName = paramString;
    localModuleLoadParams.jsParams = paramHippyMap;
    return paramNavigator.getEngineManager().loadModule(localModuleLoadParams);
  }
  
  public void addView(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    Log.d("Navigator", "addView");
  }
  
  public View createViewImpl(Context paramContext)
  {
    return new Navigator(paramContext);
  }
  
  public void deleteChild(ViewGroup paramViewGroup, View paramView)
  {
    destroyInstance(paramView);
    Log.d("Navigator", "deleteChild");
  }
  
  public void dispatchFunction(Navigator paramNavigator, String paramString, HippyArray paramHippyArray)
  {
    boolean bool2 = false;
    super.dispatchFunction(paramNavigator, paramString, paramHippyArray);
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        if (!paramString.equals("pop")) {
          break;
        }
        i = 0;
        break;
        if (!paramString.equals("push")) {
          break;
        }
        i = 1;
        break;
        localObject = null;
        paramString = (String)localObject;
        bool1 = bool2;
        if (paramHippyArray != null)
        {
          paramHippyArray = paramHippyArray.getMap(0);
          paramString = (String)localObject;
          bool1 = bool2;
          if (paramHippyArray != null)
          {
            bool1 = paramHippyArray.getBoolean("animated");
            paramString = paramHippyArray.getString("toDirection");
          }
        }
        paramNavigator.pop(bool1, paramString);
        return;
      } while (paramHippyArray == null);
      localObject = paramHippyArray.getMap(0);
    } while (localObject == null);
    paramString = ((HippyMap)localObject).getString("routeName");
    paramHippyArray = ((HippyMap)localObject).getMap("initProps");
    boolean bool1 = ((HippyMap)localObject).getBoolean("animated");
    Object localObject = ((HippyMap)localObject).getString("fromDirection");
    paramNavigator.push(loadNavPage(paramNavigator, paramString, paramHippyArray), bool1, (String)localObject);
  }
  
  @HippyControllerProps(defaultType="map", name="initialRoute")
  public void initPage(Navigator paramNavigator, HippyMap paramHippyMap)
  {
    paramNavigator.init(loadNavPage(paramNavigator, paramHippyMap.getString("routeName"), paramHippyMap.getMap("initProps")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.navigator.NavigatorController
 * JD-Core Version:    0.7.0.1
 */