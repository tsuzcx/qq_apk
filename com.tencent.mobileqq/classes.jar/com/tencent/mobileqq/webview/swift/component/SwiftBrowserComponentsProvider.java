package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class SwiftBrowserComponentsProvider
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_browser_component_map.yml", version=1)
  public static HashMap<String, Class<? extends SwiftBrowserComponentsProvider.SwiftBrowserComponent>> e = new HashMap();
  final SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext a;
  final int b;
  final ConcurrentHashMap<Integer, Object> c;
  final SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory d;
  private SwiftBrowserComponentsProvider.SwiftBrowserComponentContext f = new SwiftBrowserComponentsProvider.1(this);
  
  static
  {
    e.put("256", SwiftMiniAIOHandler.class);
    e.put("128", SwiftFileChooseHandler.class);
    e.put("64", SwiftBrowserScreenShotHandler.class);
    e.put("32", SwiftBrowserMiscHandler.class);
    e.put("16", SwiftBrowserTBSHandler.class);
    e.put("8", SwiftBrowserLongClickHandler.class);
    e.put("4", SwiftBrowserShareMenuHandler.class);
    e.put("2", SwiftBrowserUIStyleHandler.class);
    e.put("1", SwiftBrowserNavigator.class);
    e.put("-3", SwiftBrowserDebugHelper.class);
    e.put("-2", SwiftBrowserStatistics.class);
    e.put("-1", SwiftBrowserSetting.class);
  }
  
  public SwiftBrowserComponentsProvider(SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext paramSwiftBrowserComponentProviderContext, int paramInt, SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory paramSwiftBrowserComponentFactory)
  {
    this.a = paramSwiftBrowserComponentProviderContext;
    this.b = paramInt;
    this.d = paramSwiftBrowserComponentFactory;
    int i = 0;
    int k;
    for (int j = 0; i < 32; j = k)
    {
      k = j;
      if ((1 << i & paramInt) != 0) {
        k = j + 1;
      }
      i += 1;
    }
    this.c = new ConcurrentHashMap(j);
  }
  
  public <T> T a(int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      int i = this.b;
      if ((i & paramInt) == 0) {
        return null;
      }
      Object localObject1 = this.c.get(Integer.valueOf(paramInt));
      Object localObject3 = localObject1;
      Object localObject5;
      if (localObject1 == null)
      {
        if (this.d != null) {
          localObject1 = this.d.a(paramInt);
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          Class localClass = (Class)e.get(String.valueOf(paramInt));
          if (localClass != null)
          {
            localObject3 = localObject1;
            if (paramInt != -3) {
              try
              {
                localObject3 = localClass.newInstance();
              }
              catch (IllegalAccessException localIllegalAccessException)
              {
                localIllegalAccessException.printStackTrace();
                Object localObject4 = localObject1;
              }
              catch (InstantiationException localInstantiationException)
              {
                localInstantiationException.printStackTrace();
                localObject5 = localObject1;
              }
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("componentFlag:");
            ((StringBuilder)localObject1).append(paramInt);
            ((StringBuilder)localObject1).append(" cannot create, please check!");
            throw new InvalidParameterException(((StringBuilder)localObject1).toString());
          }
        }
        if ((localObject5 instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponent))
        {
          localObject1 = (SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject5;
          ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject1).b = this.f;
          ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject1).a();
        }
        this.c.put(Integer.valueOf(paramInt), localObject5);
      }
      return localObject5;
    }
    finally {}
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = this.c.values().iterator();
    while (paramBundle.hasNext())
    {
      Object localObject = paramBundle.next();
      if ((localObject instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponent)) {
        ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject).a(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider
 * JD-Core Version:    0.7.0.1
 */