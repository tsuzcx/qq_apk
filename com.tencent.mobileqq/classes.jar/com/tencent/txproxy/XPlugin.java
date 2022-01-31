package com.tencent.txproxy;

import android.content.Context;
import android.os.Bundle;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.Downloader.UpdateParam;
import com.tencent.proxyinner.plugin.XPluginImp;
import com.tencent.proxyinner.report.DataReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XPlugin
{
  public static final String TAG = "XProxy|XPlugin";
  static Map<String, XPlugin> mLoaderMap = new HashMap();
  Context mContext;
  boolean mInit = false;
  InitParam mInitParam;
  String mPluginId;
  XPluginImp mPluginImp;
  
  private XPlugin(String paramString)
  {
    this.mPluginId = paramString;
    this.mPluginImp = null;
    this.mPluginImp = new XPluginImp();
  }
  
  /* Error */
  public static XPlugin getPlugin(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	com/tencent/txproxy/XPlugin:mLoaderMap	Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface 49 2 0
    //   12: ifeq +21 -> 33
    //   15: getstatic 29	com/tencent/txproxy/XPlugin:mLoaderMap	Ljava/util/Map;
    //   18: aload_0
    //   19: invokeinterface 53 2 0
    //   24: checkcast 2	com/tencent/txproxy/XPlugin
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: new 2	com/tencent/txproxy/XPlugin
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 55	com/tencent/txproxy/XPlugin:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: getstatic 29	com/tencent/txproxy/XPlugin:mLoaderMap	Ljava/util/Map;
    //   45: aload_0
    //   46: aload_1
    //   47: invokeinterface 59 3 0
    //   52: pop
    //   53: aload_1
    //   54: astore_0
    //   55: goto -27 -> 28
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramString	String
    //   41	13	1	localXPlugin	XPlugin
    // Exception table:
    //   from	to	target	type
    //   3	28	58	finally
    //   33	53	58	finally
  }
  
  public void addEventListener(XEventListener paramXEventListener)
  {
    this.mPluginImp.addListener(paramXEventListener);
  }
  
  public void cancelRunPlugin(String paramString)
  {
    this.mPluginImp.cancelRun(paramString);
  }
  
  public boolean clearAllLocalData()
  {
    return this.mPluginImp.clearAllLocalData();
  }
  
  public UpdateParam getCheckVersionInfo()
  {
    if (!this.mPluginImp.isCheckedVersion()) {
      return null;
    }
    return this.mPluginImp.getCheckVersionInfo();
  }
  
  public int getPluginSize()
  {
    return this.mPluginImp.getPluginSize();
  }
  
  public int getStatus()
  {
    return this.mPluginImp.getStatus();
  }
  
  public boolean hasLocalPlugin()
  {
    return this.mPluginImp.haslocalOdexedPlugin();
  }
  
  public boolean install(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("force_install_new");
    }
    this.mPluginImp.updatePluginAndPreInstall(bool);
    return true;
  }
  
  public boolean isPluginLoaded()
  {
    return this.mPluginImp.isPluginLoaded();
  }
  
  public boolean isSilentUpdateComplete()
  {
    return this.mPluginImp.isSilentUpdateComplete();
  }
  
  public boolean isTestEnv()
  {
    return this.mPluginImp.isTestEnv();
  }
  
  public boolean loadPlugin(Bundle paramBundle)
  {
    this.mPluginImp.loadplugin(paramBundle);
    return true;
  }
  
  public void registerPluginMsgCmd(String paramString)
  {
    this.mPluginImp.registerPluginMsg(paramString);
  }
  
  public void removeListener(XEventListener paramXEventListener)
  {
    if (this.mPluginImp != null) {
      this.mPluginImp.removeListener(paramXEventListener);
    }
  }
  
  public boolean runPlugin(RunPluginParams paramRunPluginParams)
  {
    XLog.i("XProxy|XPlugin", "runPlugin pluginid = " + this.mPluginId);
    this.mPluginImp.runPlugin(paramRunPluginParams);
    return true;
  }
  
  public void sendMessage(String paramString, Bundle paramBundle)
  {
    this.mPluginImp.sendMessage(paramString, paramBundle);
  }
  
  public void setDownloadInHost(boolean paramBoolean)
  {
    this.mPluginImp.setDownloadInHost(paramBoolean);
  }
  
  public void setHostInterface(HostInterface paramHostInterface)
  {
    if (this.mPluginImp != null) {
      this.mPluginImp.setHostInterface(paramHostInterface);
    }
  }
  
  public void setInitData(Context paramContext, InitParam paramInitParam)
  {
    if (!this.mInit)
    {
      this.mPluginImp.initParam(this.mPluginId, paramContext, paramInitParam);
      this.mInitParam = paramInitParam;
      this.mContext = paramContext;
      this.mInit = true;
    }
  }
  
  public void setLogInHost(boolean paramBoolean)
  {
    this.mPluginImp.setLogInHost(paramBoolean);
  }
  
  public void setMutexPluginList(ArrayList<String> paramArrayList)
  {
    this.mPluginImp.setMutexPluginList(paramArrayList);
  }
  
  public void setUid(String paramString)
  {
    if (this.mInitParam != null) {
      this.mInitParam.mSourceId = paramString;
    }
    DataReport.getInstance(this.mPluginId).setUid(paramString);
  }
  
  public boolean unload(Boolean paramBoolean)
  {
    try
    {
      this.mPluginImp.unload(paramBoolean);
      this.mPluginImp = null;
      mLoaderMap.remove(this.mPluginId);
      this.mInit = false;
      return true;
    }
    catch (Exception paramBoolean) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.txproxy.XPlugin
 * JD-Core Version:    0.7.0.1
 */