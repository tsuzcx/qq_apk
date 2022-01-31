package cooperation.qqfav;

import bgqf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static bgqf a;
  
  public static bgqf a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bgqf(BaseApplicationImpl.getApplication().getRuntime());
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a()
  {
    bgqf localbgqf = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbgqf.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbgqf);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */