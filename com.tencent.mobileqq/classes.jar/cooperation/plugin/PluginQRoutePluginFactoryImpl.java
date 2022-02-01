package cooperation.plugin;

import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.IQRoutePluginFactory;
import java.util.concurrent.ConcurrentHashMap;

public class PluginQRoutePluginFactoryImpl
  implements IQRoutePluginFactory
{
  private ConcurrentHashMap<String, IQRoutePlugin> a = new ConcurrentHashMap();
  
  public IQRoutePlugin createSingleton(String paramString)
  {
    Object localObject;
    if ((paramString == null) || ("".endsWith(paramString))) {
      localObject = null;
    }
    IQRoutePlugin localIQRoutePlugin;
    do
    {
      return localObject;
      localIQRoutePlugin = (IQRoutePlugin)this.a.get(paramString);
      localObject = localIQRoutePlugin;
    } while (localIQRoutePlugin != null);
    synchronized (this.a)
    {
      localIQRoutePlugin = (IQRoutePlugin)this.a.get(paramString);
      localObject = localIQRoutePlugin;
      if (localIQRoutePlugin == null)
      {
        localObject = new QPluginAsQRoutePlugin(paramString);
        this.a.put(paramString, localObject);
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginQRoutePluginFactoryImpl
 * JD-Core Version:    0.7.0.1
 */