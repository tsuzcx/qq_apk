package com.tencent.wifisdk;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import wf7.hl;

public class TMSDKCustomConfig
{
  private Drawable qc = null;
  private int qd = -1;
  private TMSDKCustomConfig.IInstaller qe = null;
  private TMSDKCustomConfig.IToast qf = null;
  private TMSDKCustomConfig.IThreadPoolManager qg = null;
  private TMSDKCustomConfig.ICustomReporter qh = null;
  private SparseArray<String> qi = null;
  
  public void apply()
  {
    hl.a(this.qc, this.qd);
  }
  
  public TMSDKCustomConfig.IInstaller getCustomInstaller()
  {
    try
    {
      TMSDKCustomConfig.IInstaller localIInstaller = this.qe;
      return localIInstaller;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public TMSDKCustomConfig.IThreadPoolManager getCustomThreadPool()
  {
    try
    {
      TMSDKCustomConfig.IThreadPoolManager localIThreadPoolManager = this.qg;
      return localIThreadPoolManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public TMSDKCustomConfig.IToast getCustomToast()
  {
    try
    {
      TMSDKCustomConfig.IToast localIToast = this.qf;
      return localIToast;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void onCustomReport(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/wifisdk/TMSDKCustomConfig:qh	Lcom/tencent/wifisdk/TMSDKCustomConfig$ICustomReporter;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 37	com/tencent/wifisdk/TMSDKCustomConfig:qi	Landroid/util/SparseArray;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 37	com/tencent/wifisdk/TMSDKCustomConfig:qi	Landroid/util/SparseArray;
    //   25: iload_1
    //   26: invokevirtual 59	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   29: checkcast 61	java/lang/String
    //   32: astore_3
    //   33: aload_3
    //   34: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne -19 -> 18
    //   40: aload_0
    //   41: getfield 35	com/tencent/wifisdk/TMSDKCustomConfig:qh	Lcom/tencent/wifisdk/TMSDKCustomConfig$ICustomReporter;
    //   44: aload_3
    //   45: iload_2
    //   46: invokeinterface 73 3 0
    //   51: goto -33 -> 18
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	TMSDKCustomConfig
    //   0	59	1	paramInt1	int
    //   0	59	2	paramInt2	int
    //   13	32	3	localObject1	Object
    //   54	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	54	finally
    //   21	51	54	finally
  }
  
  public TMSDKCustomConfig setConnectingView(Drawable paramDrawable, int paramInt)
  {
    this.qc = paramDrawable;
    this.qd = paramInt;
    return this;
  }
  
  public TMSDKCustomConfig setCustomInstaller(TMSDKCustomConfig.IInstaller paramIInstaller)
  {
    try
    {
      this.qe = paramIInstaller;
      return this;
    }
    finally
    {
      paramIInstaller = finally;
      throw paramIInstaller;
    }
  }
  
  public TMSDKCustomConfig setCustomReporter(TMSDKCustomConfig.ICustomReporter paramICustomReporter)
  {
    try
    {
      this.qh = paramICustomReporter;
      this.qi = new SparseArray();
      this.qi.put(398667, "0X8009616");
      this.qi.put(398668, "0X800961B");
      this.qi.put(398689, "0X8009612");
      this.qi.put(398690, "0X8009618");
      this.qi.put(398670, "0X8009611");
      this.qi.put(398671, "0X8009614");
      this.qi.put(398676, "0X800962F");
      this.qi.put(398680, "0X8009632");
      this.qi.put(398677, "0X8009631");
      this.qi.put(398505, "0X8009633");
      this.qi.put(500760, "0X8009643");
      this.qi.put(500761, "0X8009634");
      this.qi.put(500762, "0X800963B");
      this.qi.put(500763, "0X800963A");
      this.qi.put(500622, "0X8009636");
      this.qi.put(398606, "0X8009644");
      this.qi.put(398607, "0X800961A");
      this.qi.put(398608, "0X8009625");
      this.qi.put(398610, "0X8009627");
      this.qi.put(398611, "0X800962E");
      this.qi.put(398612, "0X800962D");
      this.qi.put(398664, "0X800962B");
      this.qi.put(398665, "0X8009630");
      this.qi.put(500623, "0X8009639");
      this.qi.put(398521, "0X8009617");
      this.qi.put(398522, "0X8009626");
      this.qi.put(398523, "0X8009621");
      this.qi.put(398524, "0X8009629");
      this.qi.put(398536, "0X800961C");
      this.qi.put(398537, "0X800961F");
      this.qi.put(398538, "0X8009624");
      this.qi.put(398539, "0X8009628");
      this.qi.put(398623, "0X800961D");
      this.qi.put(500774, "0X800961E");
      this.qi.put(398672, "0X8009623");
      this.qi.put(398673, "0X8009620");
      this.qi.put(500101, "0X8009645");
      this.qi.put(500102, "0X8009646");
      this.qi.put(500103, "0X8009647");
      this.qi.put(500104, "0X8009648");
      this.qi.put(500105, "0X8009649");
      return this;
    }
    finally
    {
      paramICustomReporter = finally;
      throw paramICustomReporter;
    }
  }
  
  public TMSDKCustomConfig setCustomThreadPool(TMSDKCustomConfig.IThreadPoolManager paramIThreadPoolManager)
  {
    try
    {
      this.qg = paramIThreadPoolManager;
      return this;
    }
    finally
    {
      paramIThreadPoolManager = finally;
      throw paramIThreadPoolManager;
    }
  }
  
  public TMSDKCustomConfig setCustomToast(TMSDKCustomConfig.IToast paramIToast)
  {
    try
    {
      this.qf = paramIToast;
      return this;
    }
    finally
    {
      paramIToast = finally;
      throw paramIToast;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.wifisdk.TMSDKCustomConfig
 * JD-Core Version:    0.7.0.1
 */