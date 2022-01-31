package cooperation.qqreader.host.binder;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper;

public class HostBinderInterfaceHelper
{
  public static void getPluginInterface(Context paramContext, HostBinderInterfaceHelper.OnHostBinderInterfaceLoadedCallback paramOnHostBinderInterfaceLoadedCallback)
  {
    PluginInterfaceHelper.getPluginInterface(paramContext, new HostBinderInterfaceHelper.1(paramOnHostBinderInterfaceLoadedCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.binder.HostBinderInterfaceHelper
 * JD-Core Version:    0.7.0.1
 */