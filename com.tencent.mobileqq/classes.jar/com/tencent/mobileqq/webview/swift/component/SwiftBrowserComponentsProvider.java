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
  public static HashMap<String, Class<? extends SwiftBrowserComponentsProvider.SwiftBrowserComponent>> a;
  final int jdField_a_of_type_Int;
  private SwiftBrowserComponentsProvider.SwiftBrowserComponentContext jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext = new SwiftBrowserComponentsProvider.1(this);
  final SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory;
  final SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderContext;
  final ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("256", SwiftMiniAIOHandler.class);
    jdField_a_of_type_JavaUtilHashMap.put("128", SwiftFileChooseHandler.class);
    jdField_a_of_type_JavaUtilHashMap.put("64", SwiftBrowserScreenShotHandler.class);
    jdField_a_of_type_JavaUtilHashMap.put("32", SwiftBrowserMiscHandler.class);
    jdField_a_of_type_JavaUtilHashMap.put("16", SwiftBrowserTBSHandler.class);
    jdField_a_of_type_JavaUtilHashMap.put("8", SwiftBrowserLongClickHandler.class);
    jdField_a_of_type_JavaUtilHashMap.put("4", SwiftBrowserShareMenuHandler.class);
    jdField_a_of_type_JavaUtilHashMap.put("2", SwiftBrowserUIStyleHandler.class);
    jdField_a_of_type_JavaUtilHashMap.put("1", SwiftBrowserNavigator.class);
    jdField_a_of_type_JavaUtilHashMap.put("-3", SwiftBrowserDebugHelper.class);
    jdField_a_of_type_JavaUtilHashMap.put("-2", SwiftBrowserStatistics.class);
    jdField_a_of_type_JavaUtilHashMap.put("-1", SwiftBrowserSetting.class);
  }
  
  public SwiftBrowserComponentsProvider(SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext paramSwiftBrowserComponentProviderContext, int paramInt, SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory paramSwiftBrowserComponentFactory)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderContext = paramSwiftBrowserComponentProviderContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory = paramSwiftBrowserComponentFactory;
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
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(j);
  }
  
  public <T> T a(int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      int i = this.jdField_a_of_type_Int;
      if ((i & paramInt) == 0) {
        return null;
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      Object localObject3 = localObject1;
      Object localObject5;
      if (localObject1 == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory.a(paramInt);
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          Class localClass = (Class)jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramInt));
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
          ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext;
          ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject1).a();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject5);
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
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (paramBundle.hasNext())
    {
      Object localObject = paramBundle.next();
      if ((localObject instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponent)) {
        ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject).a(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider
 * JD-Core Version:    0.7.0.1
 */