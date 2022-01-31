package cooperation.qqfav;

import birv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static birv a;
  
  public static birv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new birv(BaseApplicationImpl.getApplication().getRuntime());
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a()
  {
    birv localbirv = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbirv.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbirv);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */