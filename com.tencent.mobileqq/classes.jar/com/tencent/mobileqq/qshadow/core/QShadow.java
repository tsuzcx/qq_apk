package com.tencent.mobileqq.qshadow.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qshadow.constant.Constant;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.ShadowTag;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class QShadow
{
  private Context mContext;
  private Logger mLogger = LoggerFactory.getLogger(ShadowTag.class);
  private Map<String, DefaultPluginManager> mPluginManagerMap = new HashMap();
  
  public static QShadow getInstance()
  {
    return QShadow.Holder.access$100();
  }
  
  private DefaultPluginManager getPluginManager(String paramString)
  {
    String str = PluginIdUtil.getGroupId(paramString);
    DefaultPluginManager localDefaultPluginManager2 = (DefaultPluginManager)this.mPluginManagerMap.get(str);
    DefaultPluginManager localDefaultPluginManager1 = localDefaultPluginManager2;
    if (localDefaultPluginManager2 == null)
    {
      localDefaultPluginManager1 = new DefaultPluginManager(paramString, this.mContext);
      this.mPluginManagerMap.put(str, localDefaultPluginManager1);
    }
    return localDefaultPluginManager1;
  }
  
  private Bundle wrapperBundle(Bundle paramBundle, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBundle("KEY_EXTRAS", paramBundle);
    localBundle.putString("pluginZipPath", getPluginManager(paramString1).getPluginZipPath());
    localBundle.putString("KEY_PLUGIN_PART_KEY", paramString1);
    localBundle.putString("KEY_ACTIVITY_CLASSNAME", paramString2);
    return localBundle;
  }
  
  public Map<String, PluginBaseInfo> getQShadowBuildInPlugins()
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String[] arrayOfString = QShadowRepository.getStringFromStream(this.mContext.getAssets().open("qshadow-plugins" + File.separator + "plugins")).split(",");
        int j = arrayOfString.length;
        if (i < j)
        {
          String str = arrayOfString[i];
          Object localObject = Constant.getAssetRootPath(str) + File.separator + "config.json";
          try
          {
            InputStream localInputStream = this.mContext.getAssets().open((String)localObject);
            localObject = new PluginBaseInfo();
            ((PluginBaseInfo)localObject).mID = PluginIdUtil.convertQShadowId2QPluginId(str);
            ((PluginBaseInfo)localObject).mMD5 = QShadowRepository.getUuidFromStream(localInputStream);
            ((PluginBaseInfo)localObject).mUpdateType = 1;
            ((PluginBaseInfo)localObject).mInstallType = 0;
            localHashMap.put(((PluginBaseInfo)localObject).mID, localObject);
          }
          catch (IOException localIOException2)
          {
            this.mLogger.warn("plugin " + str + " not found in asset " + (String)localObject);
          }
        }
        else
        {
          return localHashMap;
        }
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
      i += 1;
    }
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public boolean installPlugin(String paramString)
  {
    return getPluginManager(paramString).installPlugin();
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    return getPluginManager(paramString).isPluginInstalled();
  }
  
  public boolean isPluginRunning(String paramString)
  {
    return (!TextUtils.isEmpty(QShadowRepository.getInstalledPlugin(this.mContext, paramString, ""))) && (getPluginManager(paramString).isPluginRunning());
  }
  
  public boolean preInstall(String paramString, File paramFile)
  {
    return getPluginManager(paramString).preInstall(paramFile);
  }
  
  public void registerPluginManager(String paramString, DefaultPluginManager paramDefaultPluginManager)
  {
    this.mPluginManagerMap.put(PluginIdUtil.getGroupId(paramString), paramDefaultPluginManager);
  }
  
  public void startActivity(String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    paramString2 = wrapperBundle(paramBundle, paramString1, paramString2);
    getPluginManager(paramString1).enter(this.mContext, 1003L, paramString2, paramEnterCallback);
  }
  
  public void startService(String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    paramString2 = wrapperBundle(paramBundle, paramString1, paramString2);
    getPluginManager(paramString1).enter(this.mContext, 1004L, paramString2, paramEnterCallback);
  }
  
  public boolean uninstallPlugin(String paramString)
  {
    return getPluginManager(paramString).uninstallPlugin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.core.QShadow
 * JD-Core Version:    0.7.0.1
 */