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
  
  protected void addView(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    Log.d("Navigator", "addView");
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new Navigator(paramContext);
  }
  
  protected void deleteChild(ViewGroup paramViewGroup, View paramView)
  {
    destroyInstance(paramView);
    Log.d("Navigator", "deleteChild");
  }
  
  public void dispatchFunction(Navigator paramNavigator, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramNavigator, paramString, paramHippyArray);
    int i = paramString.hashCode();
    boolean bool2 = false;
    if (i != 111185)
    {
      if ((i == 3452698) && (paramString.equals("push")))
      {
        i = 1;
        break label66;
      }
    }
    else if (paramString.equals("pop"))
    {
      i = 0;
      break label66;
    }
    i = -1;
    label66:
    Object localObject;
    boolean bool1;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if (paramHippyArray != null)
      {
        localObject = paramHippyArray.getMap(0);
        if (localObject != null)
        {
          paramString = ((HippyMap)localObject).getString("routeName");
          paramHippyArray = ((HippyMap)localObject).getMap("initProps");
          bool1 = ((HippyMap)localObject).getBoolean("animated");
          localObject = ((HippyMap)localObject).getString("fromDirection");
          paramNavigator.push(loadNavPage(paramNavigator, paramString, paramHippyArray), bool1, (String)localObject);
        }
      }
    }
    else
    {
      localObject = null;
      bool1 = bool2;
      paramString = (String)localObject;
      if (paramHippyArray != null)
      {
        paramHippyArray = paramHippyArray.getMap(0);
        bool1 = bool2;
        paramString = (String)localObject;
        if (paramHippyArray != null)
        {
          bool1 = paramHippyArray.getBoolean("animated");
          paramString = paramHippyArray.getString("toDirection");
        }
      }
      paramNavigator.pop(bool1, paramString);
    }
  }
  
  @HippyControllerProps(defaultType="map", name="initialRoute")
  public void initPage(Navigator paramNavigator, HippyMap paramHippyMap)
  {
    paramNavigator.init(loadNavPage(paramNavigator, paramHippyMap.getString("routeName"), paramHippyMap.getMap("initProps")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.navigator.NavigatorController
 * JD-Core Version:    0.7.0.1
 */