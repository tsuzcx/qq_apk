package com.tencent.qzonehub.api.impl;

import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

class QZoneApiProxyImpl$2
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  QZoneApiProxyImpl$2(QZoneApiProxyImpl paramQZoneApiProxyImpl) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isQzoneInstalled: ");
    Object localObject;
    if (paramPluginManagerClient != null) {
      localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    QZLog.i("QZoneApiProxyImpl", localStringBuilder.toString());
    if ((paramPluginManagerClient != null) && (paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"))) {
      QZoneApiProxyImpl.sIsQzoneInstalled = true;
    }
    QZoneApiProxyImpl.access$102(new WeakReference(paramPluginManagerClient));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZoneApiProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */