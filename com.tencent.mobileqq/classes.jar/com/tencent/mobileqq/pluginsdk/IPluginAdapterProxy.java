package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public class IPluginAdapterProxy
{
  static IPluginAdapterProxy sProxy;
  public String currentUin;
  private IPluginAdapter mPluginAdapter;
  
  private IPluginAdapterProxy(IPluginAdapter paramIPluginAdapter)
  {
    this.mPluginAdapter = paramIPluginAdapter;
  }
  
  public static IPluginAdapterProxy getProxy()
  {
    return sProxy;
  }
  
  public static void setProxy(IPluginAdapter paramIPluginAdapter)
  {
    sProxy = new IPluginAdapterProxy(paramIPluginAdapter);
  }
  
  public Looper getSubThreadLooper()
  {
    IPluginAdapter localIPluginAdapter = this.mPluginAdapter;
    if (localIPluginAdapter == null)
    {
      QLog.d("plugin_tag", 1, "IPluginAdapter null");
      return null;
    }
    return (Looper)localIPluginAdapter.invoke(2, null);
  }
  
  public void initSkin(Context paramContext)
  {
    this.mPluginAdapter.initSkin(paramContext);
  }
  
  public void initSkinEngine(Context paramContext)
  {
    this.mPluginAdapter.initSkinEngine(paramContext);
  }
  
  public boolean isBuiltinPluginAndUpToDay(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    return this.mPluginAdapter.isBuiltinPluginAndUpToDay(paramString, paramPluginBaseInfo);
  }
  
  public boolean isDefaultMode()
  {
    Object localObject = this.mPluginAdapter;
    if (localObject == null)
    {
      QLog.d("plugin_tag", 1, "IPluginAdapter null");
      return false;
    }
    boolean bool = ((Boolean)((IPluginAdapter)localObject).invoke(3, null)).booleanValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isDefaultMode = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("plugin_tag", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean isNightMode()
  {
    IPluginAdapter localIPluginAdapter = this.mPluginAdapter;
    if (localIPluginAdapter == null)
    {
      QLog.d("plugin_tag", 1, "IPluginAdapter null");
      return false;
    }
    return ((Boolean)localIPluginAdapter.invoke(1, null)).booleanValue();
  }
  
  public int isSupportImmersive()
  {
    try
    {
      IPluginAdapter localIPluginAdapter = this.mPluginAdapter;
      if (localIPluginAdapter == null)
      {
        QLog.d("plugin_tag", 1, "IPluginAdapter null");
        return -1;
      }
      int i = ((Integer)localIPluginAdapter.invoke(5, null)).intValue();
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public boolean isSupportMultiDex(String paramString)
  {
    IPluginAdapter localIPluginAdapter = this.mPluginAdapter;
    if (localIPluginAdapter == null)
    {
      QLog.d("plugin_tag", 1, "IPluginAdapter null");
      return false;
    }
    return ((Boolean)localIPluginAdapter.invoke(4, paramString)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy
 * JD-Core Version:    0.7.0.1
 */