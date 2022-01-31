package com.tencent.mobileqq.utils.confighandler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bake;
import bavz;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class QAVFunCallHandler
  extends NormalConfigHandler<QAVFunCallConfig>
{
  NormalConfigHandler.GetConfigListen<QAVFunCallConfig> mGetConfigListen = new bake(this);
  
  public QAVFunCallHandler(String paramString)
  {
    super("QAVConfig_382", paramString, null, null, null);
  }
  
  public void doOnReconnect(QQAppInterface paramQQAppInterface)
  {
    if (!isConfigReady())
    {
      syncGetConfigInfo(paramQQAppInterface, this.mGetConfigListen);
      return;
    }
    requestPreDownload("doOnReconnect", paramQQAppInterface);
  }
  
  public QAVFunCallConfig getConfigDirect()
  {
    if (this.mConfig == null) {
      setConfig((QAVFunCallConfig)ConfigHandler.getConfigInfoNew(this.TAG, null, getConfigID(), getConfigInfoClass(), this.mUin));
    }
    return (QAVFunCallConfig)this.mConfig;
  }
  
  protected int getConfigID()
  {
    return 382;
  }
  
  public void onGetConfig(AppInterface paramAppInterface)
  {
    QAVFunCallConfig localQAVFunCallConfig = (QAVFunCallConfig)getConfig();
    if (localQAVFunCallConfig == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localQAVFunCallConfig.fcItems.values().iterator();
      while (localIterator.hasNext())
      {
        QAVFunCallConfig.FCItem localFCItem = (QAVFunCallConfig.FCItem)localIterator.next();
        if (!ConfigUtil.isExpired(localFCItem.end))
        {
          int i = localFCItem.fcid;
          if ((i != 0) && (!TextUtils.isEmpty(localFCItem.media)))
          {
            Object localObject = bavz.a(paramAppInterface, 0, String.valueOf(i));
            if ((localObject != null) && ((((SharedPreferences)localObject).getLong("local_version", 0L) != localQAVFunCallConfig.serverVer) || (TextUtils.isEmpty(((SharedPreferences)localObject).getString("_6", null)))))
            {
              localObject = ((SharedPreferences)localObject).edit();
              ((SharedPreferences.Editor)localObject).putInt("callId", i);
              ((SharedPreferences.Editor)localObject).putLong("local_version", localQAVFunCallConfig.serverVer);
              ((SharedPreferences.Editor)localObject).putString("_6", localFCItem.media);
              ((SharedPreferences.Editor)localObject).commit();
            }
          }
        }
      }
    }
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, QAVFunCallConfig paramQAVFunCallConfig)
  {
    if (paramQAVFunCallConfig != null) {
      setConfig(paramQAVFunCallConfig);
    }
    if (!isConfigReady())
    {
      syncGetConfigInfo(paramQQAppInterface, this.mGetConfigListen);
      return;
    }
    onGetConfig(paramQQAppInterface);
    requestPreDownload("onGetConfigFinish", paramQQAppInterface);
  }
  
  public void requestPreDownload(String paramString, AppInterface paramAppInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler
 * JD-Core Version:    0.7.0.1
 */