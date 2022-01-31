package cooperation.qqfav;

import bgqw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static bgqw a;
  
  public static bgqw a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bgqw(BaseApplicationImpl.getApplication().getRuntime());
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a()
  {
    bgqw localbgqw = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbgqw.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbgqw);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */