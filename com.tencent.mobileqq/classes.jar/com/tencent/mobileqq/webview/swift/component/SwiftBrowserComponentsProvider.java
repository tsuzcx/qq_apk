package com.tencent.mobileqq.webview.swift.component;

import akob;
import android.os.Bundle;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class SwiftBrowserComponentsProvider
{
  final int jdField_a_of_type_Int;
  private SwiftBrowserComponentsProvider.SwiftBrowserComponentContext jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext = new akob(this);
  final SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory;
  public final SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext a;
  final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public SwiftBrowserComponentsProvider(SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext paramSwiftBrowserComponentProviderContext, int paramInt, SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory paramSwiftBrowserComponentFactory)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderContext = paramSwiftBrowserComponentProviderContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory = paramSwiftBrowserComponentFactory;
    int i = 0;
    while (i < 32)
    {
      int k = j;
      if ((1 << i & paramInt) != 0) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(j);
  }
  
  public Object a(int paramInt)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      Object localObject4;
      try
      {
        if ((this.jdField_a_of_type_Int & paramInt) == 0) {
          break label250;
        }
        localObject4 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        Object localObject1 = localObject4;
        if (localObject4 != null) {
          break label136;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new SwiftBrowserSetting();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponent))
        {
          localObject4 = (SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject3;
          ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject4).jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext;
          ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject4).b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new SwiftBrowserNavigator(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext);
          break;
          localObject3 = new SwiftBrowserUIStyleHandler();
          break;
          localObject3 = new SwiftBrowserShareMenuHandler();
          break;
          localObject3 = new SwiftBrowserLongClickHandler(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
          break;
          localObject3 = new SwiftBrowserStatistics();
          break;
          localObject3 = new SwiftBrowserTBSHandler(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
          break;
          localObject3 = new SwiftBrowserMiscHandler();
          break;
          localObject3 = new SwiftBrowserScreenShotHandler();
          break;
          localObject3 = null;
        }
        localObject3 = localObject4;
      } while (localObject4 != null);
      localObject3 = localObject4;
      switch (paramInt)
      {
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider
 * JD-Core Version:    0.7.0.1
 */