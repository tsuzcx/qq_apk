package com.tencent.qzonehub.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

class QZoneApiProxyImpl$1
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  QZoneApiProxyImpl$1(QZoneApiProxyImpl paramQZoneApiProxyImpl, long paramLong, QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPluginManagerLoaded: ");
    if (paramPluginManagerClient != null) {
      localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" cost ");
    localStringBuilder.append(System.nanoTime() - this.jdField_a_of_type_Long);
    QZLog.i("QZoneApiProxyImpl", localStringBuilder.toString());
    boolean bool = true;
    if (paramPluginManagerClient != null)
    {
      if (paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) {
        QZoneApiProxyImpl.sIsQzoneInstalled = true;
      }
      QZoneApiProxyImpl.access$102(new WeakReference(paramPluginManagerClient));
    }
    Object localObject = this.jdField_a_of_type_CooperationQzoneApiQZoneApiProxy$QZoneLoadCallback;
    if (localObject != null)
    {
      if ((paramPluginManagerClient == null) || (!paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) || (!QZoneApiProxyImpl.access$200(BaseApplicationImpl.getApplication()))) {
        bool = false;
      }
      ((QZoneApiProxy.QZoneLoadCallback)localObject).onLoadOver(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZoneApiProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */