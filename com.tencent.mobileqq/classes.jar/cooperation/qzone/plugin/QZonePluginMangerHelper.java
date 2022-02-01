package cooperation.qzone.plugin;

import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class QZonePluginMangerHelper
{
  private static final String TAG = "QZonePluginManger";
  static QZonePluginClient sClient;
  private static WeakReference<QZonePluginMangerHelper.OnQzonePluginClientReadyListner> sListener;
  private static ServiceConnection sSc = new QZonePluginMangerHelper.1();
  
  private static void clear()
  {
    if (sListener != null)
    {
      sListener.clear();
      sListener = null;
    }
  }
  
  public static void getQzonePluginClient(Context paramContext, QZonePluginMangerHelper.OnQzonePluginClientReadyListner paramOnQzonePluginClientReadyListner)
  {
    if ((sClient != null) && (sClient.isAlive()))
    {
      if (paramOnQzonePluginClientReadyListner != null) {
        paramOnQzonePluginClientReadyListner.onQzonePluginClientReady(sClient);
      }
      return;
    }
    sListener = new WeakReference(paramOnQzonePluginClientReadyListner);
    QZoneConnectProcessor.get().process(paramContext, sSc, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginMangerHelper
 * JD-Core Version:    0.7.0.1
 */