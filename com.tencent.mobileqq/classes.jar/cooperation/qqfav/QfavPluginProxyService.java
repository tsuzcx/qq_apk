package cooperation.qqfav;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.qqfav.ipc.FavoritesRemoteCommand;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static FavoritesRemoteCommand a;
  
  public static FavoritesRemoteCommand a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new FavoritesRemoteCommand(BaseApplicationImpl.getApplication().getRuntime());
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a()
  {
    FavoritesRemoteCommand localFavoritesRemoteCommand = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localFavoritesRemoteCommand.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localFavoritesRemoteCommand);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */