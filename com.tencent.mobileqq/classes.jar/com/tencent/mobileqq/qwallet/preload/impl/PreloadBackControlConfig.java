package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.ResInfo;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class PreloadBackControlConfig
  implements Serializable
{
  public static final String CONFIG_NAME = "back_config";
  private static final long serialVersionUID = 1L;
  private transient AppRuntime a;
  private int mConfigVersion;
  private ArrayList<ResInfo> mLastBackResInfos;
  
  public PreloadBackControlConfig(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
    this.mConfigVersion = 0;
  }
  
  public static String getConfigPath(AppRuntime paramAppRuntime)
  {
    return PreloadStaticApi.a(paramAppRuntime) + "back_config";
  }
  
  public static PreloadBackControlConfig readBackControlConfig(AppRuntime paramAppRuntime)
  {
    try
    {
      PreloadBackControlConfig localPreloadBackControlConfig = (PreloadBackControlConfig)QWalletTools.a(getConfigPath(paramAppRuntime));
      if (localPreloadBackControlConfig == null)
      {
        localPreloadBackControlConfig = new PreloadBackControlConfig(paramAppRuntime);
        if (QLog.isColorLevel()) {
          QLog.d("BackControlConfig", 2, "readBackControlConfig:" + localPreloadBackControlConfig);
        }
        return localPreloadBackControlConfig;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        localObject.a = paramAppRuntime;
      }
    }
  }
  
  public ArrayList<ResInfo> getLastBackResInfos()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (this.mLastBackResInfos != null)
      {
        Iterator localIterator = this.mLastBackResInfos.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((ResInfo)localIterator.next());
        }
      }
    }
    finally {}
    return localArrayList1;
  }
  
  /* Error */
  public boolean isLocalResNewest()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 112	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   5: bipush 68
    //   7: aload_0
    //   8: getfield 28	com/tencent/mobileqq/qwallet/preload/impl/PreloadBackControlConfig:a	Lmqq/app/AppRuntime;
    //   11: invokevirtual 118	mqq/app/AppRuntime:getLongAccountUin	()J
    //   14: invokevirtual 121	com/tencent/mobileqq/config/QConfigManager:a	(IJ)I
    //   17: istore_1
    //   18: aload_0
    //   19: getfield 30	com/tencent/mobileqq/qwallet/preload/impl/PreloadBackControlConfig:mConfigVersion	I
    //   22: istore_2
    //   23: iload_1
    //   24: iload_2
    //   25: if_icmpeq +9 -> 34
    //   28: iconst_0
    //   29: istore_3
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_3
    //   33: ireturn
    //   34: iconst_1
    //   35: istore_3
    //   36: goto -6 -> 30
    //   39: astore 4
    //   41: aload_0
    //   42: monitorexit
    //   43: aload 4
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	PreloadBackControlConfig
    //   17	9	1	i	int
    //   22	4	2	j	int
    //   29	7	3	bool	boolean
    //   39	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	39	finally
  }
  
  public String toString()
  {
    return "BackControlConfig [mVersion=" + this.mConfigVersion + ", mLastRes=" + this.mLastBackResInfos + "]";
  }
  
  public void update(ArrayList<ResInfo> paramArrayList)
  {
    try
    {
      this.mConfigVersion = QConfigManager.a().a(68, this.a.getLongAccountUin());
      this.mLastBackResInfos = paramArrayList;
      QWalletTools.a(this, getConfigPath(this.a));
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadBackControlConfig
 * JD-Core Version:    0.7.0.1
 */