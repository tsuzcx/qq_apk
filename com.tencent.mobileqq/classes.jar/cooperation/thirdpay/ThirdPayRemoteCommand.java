package cooperation.thirdpay;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.CardPayObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import cooperation.qwallet.plugin.QWalletHelper;

public class ThirdPayRemoteCommand
  extends RemoteCommand
{
  boolean a;
  
  public ThirdPayRemoteCommand(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.a = paramBoolean;
  }
  
  public static void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null)
    {
      localPluginCommunicationHandler.register(new ThirdPayRemoteCommand("cardpay.reqchannel", false));
      localPluginCommunicationHandler.register(new ThirdPayRemoteCommand("cardpay.ReqPayOrder", false));
      localPluginCommunicationHandler.register(new ThirdPayRemoteCommand("cardpay.QueryPluginInfo", true));
      localPluginCommunicationHandler.register(new ThirdPayRemoteCommand("cardpay.installplugin", true));
      localPluginCommunicationHandler.register(new ThirdPayRemoteCommand("cardpay.cancleinstallplugin", true));
      localPluginCommunicationHandler.register(new ThirdPayRemoteCommand("cardpay.out", true));
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardPayRemoteCommand", 2, "received:" + getCmd());
    }
    QQAppInterface localQQAppInterface = QWalletHelper.getAppInterface();
    Bundle localBundle = new Bundle();
    if (localQQAppInterface == null) {
      localBundle.putString("processe_erro", "QQAppInterface is null");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return localBundle;
            if ("cardpay.reqchannel".equals(getCmd()))
            {
              if (!isSynchronized()) {
                CardPayObserver.a("CardPayControl.queryChannel", paramOnInvokeFinishLinstener);
              }
              ThirdPayManager.a(localQQAppInterface);
              return localBundle;
            }
            if ("cardpay.ReqPayOrder".equals(getCmd()))
            {
              if (!isSynchronized()) {
                CardPayObserver.a("CardPayControl.queryPayOrder", paramOnInvokeFinishLinstener);
              }
              ThirdPayManager.a(localQQAppInterface, paramBundle, paramOnInvokeFinishLinstener);
              return localBundle;
            }
            if (!"cardpay.QueryPluginInfo".equals(getCmd())) {
              break;
            }
            paramBundle = paramBundle.getString("pluginid");
          } while (TextUtils.isEmpty(paramBundle));
          paramBundle = ((IPluginManager)localQQAppInterface.getManager(26)).a(paramBundle);
          if (paramBundle != null)
          {
            localBundle.putBoolean("plugininfo", true);
            localBundle.putInt("pluginstate", paramBundle.mState);
            localBundle.putFloat("pluginprogress", paramBundle.mDownloadProgress);
            return localBundle;
          }
          localBundle.putBoolean("plugininfo", false);
          return localBundle;
          if (!"cardpay.installplugin".equals(getCmd())) {
            break;
          }
          paramBundle = paramBundle.getString("pluginid");
        } while (TextUtils.isEmpty(paramBundle));
        ((IPluginManager)localQQAppInterface.getManager(26)).a(paramBundle);
        return localBundle;
        if (!"cardpay.cancleinstallplugin".equals(getCmd())) {
          break;
        }
        paramBundle = paramBundle.getString("pluginid");
      } while (TextUtils.isEmpty(paramBundle));
      ((IPluginManager)localQQAppInterface.getManager(26)).cancelInstall(paramBundle);
      return localBundle;
    } while (!"cardpay.out".equals(getCmd()));
    ThirdPayManager.b(localQQAppInterface);
    return localBundle;
  }
  
  public boolean isSynchronized()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.thirdpay.ThirdPayRemoteCommand
 * JD-Core Version:    0.7.0.1
 */