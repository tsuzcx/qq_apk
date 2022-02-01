package com.tencent.mobileqq.qshadow.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qshadow.constant.QShadowConstant;
import com.tencent.mobileqq.qshadow.interfaces.IPluginOpenListener;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
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
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        Object localObject1 = this.mContext.getAssets();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("qshadow-plugins");
        localStringBuilder1.append(File.separator);
        localStringBuilder1.append("plugins");
        localObject1 = QShadowRepository.getStringFromStream(((AssetManager)localObject1).open(localStringBuilder1.toString())).split(",");
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          localStringBuilder1 = localObject1[i];
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(QShadowConstant.getAssetRootPath(localStringBuilder1));
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append("config.json");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder1;
        int i;
        Object localObject2;
        Object localObject3;
        StringBuilder localStringBuilder2;
        this.mLogger.error("plugin_tag 获取本地插件asset列表失败", localException);
      }
      try
      {
        localObject3 = this.mContext.getAssets().open((String)localObject2);
        localObject2 = new PluginBaseInfo();
        ((PluginBaseInfo)localObject2).mID = PluginIdUtil.convertQShadowId2QPluginId(localStringBuilder1);
        ((PluginBaseInfo)localObject2).mMD5 = QShadowRepository.getUuidFromStream((InputStream)localObject3);
        ((PluginBaseInfo)localObject2).mUpdateType = 1;
        ((PluginBaseInfo)localObject2).mInstallType = 0;
        localHashMap.put(((PluginBaseInfo)localObject2).mID, localObject2);
      }
      catch (IOException localIOException)
      {
        continue;
      }
      localObject3 = this.mLogger;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("plugin ");
      localStringBuilder2.append(localStringBuilder1);
      localStringBuilder2.append(" not found in asset ");
      localStringBuilder2.append((String)localObject2);
      ((Logger)localObject3).warn(localStringBuilder2.toString());
      i += 1;
    }
    return localHashMap;
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    paramContext = new StringBuilder();
    paramContext.append(this.mContext.getFilesDir().getAbsolutePath());
    paramContext.append(File.separator);
    paramContext.append("qshadow-plugins");
    paramContext.append(File.separator);
    paramContext = new File(paramContext.toString());
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
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
  
  public void startActivity(String paramString1, String paramString2, Bundle paramBundle, IPluginOpenListener paramIPluginOpenListener)
  {
    paramString2 = wrapperBundle(paramBundle, paramString1, paramString2);
    getPluginManager(paramString1).enter(this.mContext, 1003L, paramString2, paramIPluginOpenListener);
  }
  
  public void startService(String paramString1, String paramString2, Bundle paramBundle, IPluginOpenListener paramIPluginOpenListener)
  {
    paramString2 = wrapperBundle(paramBundle, paramString1, paramString2);
    getPluginManager(paramString1).enter(this.mContext, 1004L, paramString2, paramIPluginOpenListener);
  }
  
  public boolean uninstallPlugin(String paramString)
  {
    return getPluginManager(paramString).uninstallPlugin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.core.QShadow
 * JD-Core Version:    0.7.0.1
 */