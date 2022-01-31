package cooperation.qqfav;

import bfin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static bfin a;
  
  public static bfin a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bfin(BaseApplicationImpl.getApplication().getRuntime());
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a()
  {
    bfin localbfin = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbfin.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbfin);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */