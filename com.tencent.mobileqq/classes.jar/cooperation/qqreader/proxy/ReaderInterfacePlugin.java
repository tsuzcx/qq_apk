package cooperation.qqreader.proxy;

import android.os.Bundle;
import cooperation.qqreader.QRPluginManagerClient;
import cooperation.qqreader.utils.Log;

public class ReaderInterfacePlugin
{
  private static ReaderInterfacePlugin a = null;
  
  public static ReaderInterfacePlugin a()
  {
    try
    {
      if (a == null) {
        a = new ReaderInterfacePlugin();
      }
      ReaderInterfacePlugin localReaderInterfacePlugin = a;
      return localReaderInterfacePlugin;
    }
    finally {}
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (!QRPluginManagerClient.a().a())
    {
      Log.d("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      QRPluginManagerClient.a().a();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = QRPluginManagerClient.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.proxy.ReaderInterfacePlugin
 * JD-Core Version:    0.7.0.1
 */