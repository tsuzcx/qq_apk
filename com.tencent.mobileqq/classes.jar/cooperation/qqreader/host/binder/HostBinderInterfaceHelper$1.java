package cooperation.qqreader.host.binder;

import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.OnPluginInterfaceLoadedListener;

final class HostBinderInterfaceHelper$1
  implements PluginInterfaceHelper.OnPluginInterfaceLoadedListener
{
  HostBinderInterfaceHelper$1(HostBinderInterfaceHelper.OnHostBinderInterfaceLoadedCallback paramOnHostBinderInterfaceLoadedCallback) {}
  
  public void onPluginInterfaceLoaded(PluginInterface paramPluginInterface)
  {
    if (paramPluginInterface != null) {}
    for (paramPluginInterface = new HostBinderInterface(paramPluginInterface);; paramPluginInterface = null)
    {
      if (this.a != null) {
        this.a.onHostBinderInterfaceLoaded(paramPluginInterface);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.binder.HostBinderInterfaceHelper.1
 * JD-Core Version:    0.7.0.1
 */