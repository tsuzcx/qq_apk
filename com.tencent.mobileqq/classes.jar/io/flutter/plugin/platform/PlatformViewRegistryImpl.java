package io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

class PlatformViewRegistryImpl
  implements PlatformViewRegistry
{
  private final Map<String, PlatformViewFactory> viewFactories = new HashMap();
  
  PlatformViewFactory getFactory(String paramString)
  {
    return (PlatformViewFactory)this.viewFactories.get(paramString);
  }
  
  public boolean registerViewFactory(String paramString, PlatformViewFactory paramPlatformViewFactory)
  {
    if (this.viewFactories.containsKey(paramString)) {
      return false;
    }
    this.viewFactories.put(paramString, paramPlatformViewFactory);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewRegistryImpl
 * JD-Core Version:    0.7.0.1
 */