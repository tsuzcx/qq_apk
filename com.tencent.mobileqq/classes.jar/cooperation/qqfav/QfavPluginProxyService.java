package cooperation.qqfav;

import biwc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static biwc a;
  
  public static biwc a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new biwc(BaseApplicationImpl.getApplication().getRuntime());
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a()
  {
    biwc localbiwc = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbiwc.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbiwc);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */