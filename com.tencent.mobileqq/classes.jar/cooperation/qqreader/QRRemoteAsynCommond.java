package cooperation.qqreader;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import mqq.app.AppRuntime;

public class QRRemoteAsynCommond
  extends RemoteCommand
{
  public QRRemoteAsynCommond()
  {
    super("qqreader_plugin_asyn_cmd");
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    switch (paramBundle.getInt("CommondType"))
    {
    }
    for (;;)
    {
      return null;
      if (a() != null)
      {
        paramBundle = paramBundle.getString("publicaccount_uin");
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin(a(), a().getApp(), paramBundle, new QRRemoteAsynCommond.1(this, paramOnInvokeFinishLinstener));
        continue;
        QWalletHelperImpl.preloadQWallet(a());
      }
    }
  }
  
  public boolean isSynchronized()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRRemoteAsynCommond
 * JD-Core Version:    0.7.0.1
 */