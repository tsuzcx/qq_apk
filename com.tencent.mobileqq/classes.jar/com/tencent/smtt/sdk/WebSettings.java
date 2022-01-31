package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings.PluginState;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity;
import com.tencent.smtt.utils.ReflectionUtils;

public class WebSettings
{
  public static final int LOAD_CACHE_ELSE_NETWORK = 1;
  public static final int LOAD_CACHE_ONLY = 3;
  public static final int LOAD_DEFAULT = -1;
  public static final int LOAD_NORMAL = 0;
  public static final int LOAD_NO_CACHE = 2;
  private static final String LOGTAG = "WebSettings";
  private boolean isUseX5 = false;
  private android.webkit.WebSettings mSystemWebSettings = null;
  private IX5WebSettings mWebSettingsImpl = null;
  
  WebSettings(android.webkit.WebSettings paramWebSettings)
  {
    this.mWebSettingsImpl = null;
    this.mSystemWebSettings = paramWebSettings;
    this.isUseX5 = false;
  }
  
  WebSettings(IX5WebSettings paramIX5WebSettings)
  {
    this.mWebSettingsImpl = paramIX5WebSettings;
    this.mSystemWebSettings = null;
    this.isUseX5 = true;
  }
  
  @TargetApi(17)
  public static String getDefaultUserAgent(Context paramContext)
  {
    String str = null;
    if (X5CoreEngine.getInstance().isX5Core()) {
      str = X5CoreEngine.getInstance().wizard().getDefaultUserAgent(paramContext);
    }
    while (Build.VERSION.SDK_INT < 17) {
      return str;
    }
    paramContext = ReflectionUtils.invokeStatic(android.webkit.WebSettings.class, "getDefaultUserAgent", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = (String)paramContext) {
      return paramContext;
    }
  }
  
  @Deprecated
  public boolean enableSmoothTransition()
  {
    boolean bool2 = false;
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      bool1 = this.mWebSettingsImpl.enableSmoothTransition();
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.isUseX5);
        bool1 = bool2;
      } while (this.mSystemWebSettings == null);
      bool1 = bool2;
    } while (Build.VERSION.SDK_INT < 11);
    Object localObject = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "enableSmoothTransition");
    if (localObject == null) {}
    for (boolean bool1 = false;; bool1 = ((Boolean)localObject).booleanValue()) {
      return bool1;
    }
  }
  
  @TargetApi(11)
  public boolean getAllowContentAccess()
  {
    boolean bool2 = false;
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      bool1 = this.mWebSettingsImpl.getAllowContentAccess();
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.isUseX5);
        bool1 = bool2;
      } while (this.mSystemWebSettings == null);
      bool1 = bool2;
    } while (Build.VERSION.SDK_INT < 11);
    Object localObject = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "getAllowContentAccess");
    if (localObject == null) {}
    for (boolean bool1 = false;; bool1 = ((Boolean)localObject).booleanValue()) {
      return bool1;
    }
  }
  
  @TargetApi(3)
  public boolean getAllowFileAccess()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getAllowFileAccess();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return this.mSystemWebSettings.getAllowFileAccess();
    }
    return false;
  }
  
  /* Error */
  public boolean getBlockNetworkImage()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 111 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 112	android/webkit/WebSettings:getBlockNetworkImage	()Z
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	bool	boolean
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  /* Error */
  @TargetApi(8)
  public boolean getBlockNetworkLoads()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   8: ifeq +24 -> 32
    //   11: aload_0
    //   12: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   22: invokeinterface 116 1 0
    //   27: istore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: iload_2
    //   33: istore_1
    //   34: aload_0
    //   35: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   38: ifne -10 -> 28
    //   41: iload_2
    //   42: istore_1
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: ifnull -19 -> 28
    //   50: iload_2
    //   51: istore_1
    //   52: getstatic 66	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 8
    //   57: if_icmplt -29 -> 28
    //   60: aload_0
    //   61: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   64: invokevirtual 117	android/webkit/WebSettings:getBlockNetworkLoads	()Z
    //   67: istore_1
    //   68: goto -40 -> 28
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	WebSettings
    //   27	41	1	bool1	boolean
    //   1	50	2	bool2	boolean
    //   71	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	28	71	finally
    //   34	41	71	finally
    //   43	50	71	finally
    //   52	68	71	finally
  }
  
  @TargetApi(3)
  public boolean getBuiltInZoomControls()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getBuiltInZoomControls();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return this.mSystemWebSettings.getBuiltInZoomControls();
    }
    return false;
  }
  
  public int getCacheMode()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getCacheMode();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return this.mSystemWebSettings.getCacheMode();
    }
    return 0;
  }
  
  /* Error */
  public String getCursiveFontFamily()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 130 1 0
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 131	android/webkit/WebSettings:getCursiveFontFamily	()Ljava/lang/String;
    //   51: astore_1
    //   52: goto -26 -> 26
    //   55: ldc 133
    //   57: astore_1
    //   58: goto -32 -> 26
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	WebSettings
    //   25	33	1	str	String
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   30	52	61	finally
  }
  
  /* Error */
  @TargetApi(5)
  public boolean getDatabaseEnabled()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 137 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 138	android/webkit/WebSettings:getDatabaseEnabled	()Z
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	bool	boolean
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  /* Error */
  @TargetApi(5)
  public String getDatabasePath()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 141 1 0
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 142	android/webkit/WebSettings:getDatabasePath	()Ljava/lang/String;
    //   51: astore_1
    //   52: goto -26 -> 26
    //   55: ldc 133
    //   57: astore_1
    //   58: goto -32 -> 26
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	WebSettings
    //   25	33	1	str	String
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   30	52	61	finally
  }
  
  /* Error */
  public int getDefaultFixedFontSize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 145 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 146	android/webkit/WebSettings:getDefaultFixedFontSize	()I
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	i	int
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  /* Error */
  public int getDefaultFontSize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 149 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 150	android/webkit/WebSettings:getDefaultFontSize	()I
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	i	int
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  /* Error */
  public String getDefaultTextEncodingName()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 153 1 0
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 154	android/webkit/WebSettings:getDefaultTextEncodingName	()Ljava/lang/String;
    //   51: astore_1
    //   52: goto -26 -> 26
    //   55: ldc 133
    //   57: astore_1
    //   58: goto -32 -> 26
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	WebSettings
    //   25	33	1	str	String
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   30	52	61	finally
  }
  
  @TargetApi(7)
  public WebSettings.ZoomDensity getDefaultZoom()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return WebSettings.ZoomDensity.valueOf(this.mWebSettingsImpl.getDefaultZoom().name());
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return WebSettings.ZoomDensity.valueOf(this.mSystemWebSettings.getDefaultZoom().name());
    }
    return null;
  }
  
  @TargetApi(11)
  public boolean getDisplayZoomControls()
  {
    boolean bool2 = false;
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      bool1 = this.mWebSettingsImpl.getDisplayZoomControls();
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.isUseX5);
        bool1 = bool2;
      } while (this.mSystemWebSettings == null);
      bool1 = bool2;
    } while (Build.VERSION.SDK_INT < 11);
    Object localObject = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "getDisplayZoomControls");
    if (localObject == null) {}
    for (boolean bool1 = false;; bool1 = ((Boolean)localObject).booleanValue()) {
      return bool1;
    }
  }
  
  /* Error */
  @TargetApi(7)
  public boolean getDomStorageEnabled()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 184 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 185	android/webkit/WebSettings:getDomStorageEnabled	()Z
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	bool	boolean
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  /* Error */
  public String getFantasyFontFamily()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 188 1 0
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 189	android/webkit/WebSettings:getFantasyFontFamily	()Ljava/lang/String;
    //   51: astore_1
    //   52: goto -26 -> 26
    //   55: ldc 133
    //   57: astore_1
    //   58: goto -32 -> 26
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	WebSettings
    //   25	33	1	str	String
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   30	52	61	finally
  }
  
  /* Error */
  public String getFixedFontFamily()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 192 1 0
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 193	android/webkit/WebSettings:getFixedFontFamily	()Ljava/lang/String;
    //   51: astore_1
    //   52: goto -26 -> 26
    //   55: ldc 133
    //   57: astore_1
    //   58: goto -32 -> 26
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	WebSettings
    //   25	33	1	str	String
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   30	52	61	finally
  }
  
  /* Error */
  public boolean getJavaScriptCanOpenWindowsAutomatically()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 196 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 197	android/webkit/WebSettings:getJavaScriptCanOpenWindowsAutomatically	()Z
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	bool	boolean
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  /* Error */
  public boolean getJavaScriptEnabled()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 200 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 201	android/webkit/WebSettings:getJavaScriptEnabled	()Z
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	bool	boolean
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  /* Error */
  public WebSettings.LayoutAlgorithm getLayoutAlgorithm()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +30 -> 36
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +23 -> 36
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 206 1 0
    //   25: invokevirtual 209	com/tencent/smtt/export/external/interfaces/IX5WebSettings$LayoutAlgorithm:name	()Ljava/lang/String;
    //   28: invokestatic 214	com/tencent/smtt/sdk/WebSettings$LayoutAlgorithm:valueOf	(Ljava/lang/String;)Lcom/tencent/smtt/sdk/WebSettings$LayoutAlgorithm;
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: aload_0
    //   37: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   40: ifne +27 -> 67
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: ifnull +20 -> 67
    //   50: aload_0
    //   51: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   54: invokevirtual 217	android/webkit/WebSettings:getLayoutAlgorithm	()Landroid/webkit/WebSettings$LayoutAlgorithm;
    //   57: invokevirtual 220	android/webkit/WebSettings$LayoutAlgorithm:name	()Ljava/lang/String;
    //   60: invokestatic 214	com/tencent/smtt/sdk/WebSettings$LayoutAlgorithm:valueOf	(Ljava/lang/String;)Lcom/tencent/smtt/sdk/WebSettings$LayoutAlgorithm;
    //   63: astore_1
    //   64: goto -32 -> 32
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -37 -> 32
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	WebSettings
    //   31	38	1	localLayoutAlgorithm	WebSettings.LayoutAlgorithm
    //   72	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	32	72	finally
    //   36	64	72	finally
  }
  
  public boolean getLightTouchEnabled()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getLightTouchEnabled();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return this.mSystemWebSettings.getLightTouchEnabled();
    }
    return false;
  }
  
  @TargetApi(7)
  public boolean getLoadWithOverviewMode()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getLoadWithOverviewMode();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return this.mSystemWebSettings.getLoadWithOverviewMode();
    }
    return false;
  }
  
  /* Error */
  public boolean getLoadsImagesAutomatically()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 231 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 232	android/webkit/WebSettings:getLoadsImagesAutomatically	()Z
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	bool	boolean
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  @TargetApi(17)
  public boolean getMediaPlaybackRequiresUserGesture()
  {
    boolean bool2 = false;
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      bool1 = this.mWebSettingsImpl.getMediaPlaybackRequiresUserGesture();
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.isUseX5);
        bool1 = bool2;
      } while (this.mSystemWebSettings == null);
      bool1 = bool2;
    } while (Build.VERSION.SDK_INT < 17);
    Object localObject = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "getMediaPlaybackRequiresUserGesture");
    if (localObject == null) {}
    for (boolean bool1 = false;; bool1 = ((Boolean)localObject).booleanValue()) {
      return bool1;
    }
  }
  
  /* Error */
  public int getMinimumFontSize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 239 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 240	android/webkit/WebSettings:getMinimumFontSize	()I
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	i	int
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  /* Error */
  public int getMinimumLogicalFontSize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 243 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 244	android/webkit/WebSettings:getMinimumLogicalFontSize	()I
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	i	int
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  public int getMixedContentMode()
  {
    int i = -1;
    for (;;)
    {
      try
      {
        if (this.isUseX5)
        {
          IX5WebSettings localIX5WebSettings = this.mWebSettingsImpl;
          if (localIX5WebSettings != null)
          {
            try
            {
              int j = this.mWebSettingsImpl.getMixedContentMode();
              i = j;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              continue;
            }
            return i;
          }
        }
      }
      finally {}
      if (Build.VERSION.SDK_INT >= 21)
      {
        Object localObject2 = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "getMixedContentMode", new Class[0], new Object[0]);
        if (localObject2 == null) {
          i = -1;
        } else {
          i = ((Integer)localObject2).intValue();
        }
      }
    }
  }
  
  public boolean getNavDump()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getNavDump();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null))
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "getNavDump");
      if (localObject == null) {
        return false;
      }
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  /* Error */
  @Deprecated
  @TargetApi(8)
  public WebSettings.PluginState getPluginState()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +30 -> 36
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +23 -> 36
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 270 1 0
    //   25: invokevirtual 273	com/tencent/smtt/export/external/interfaces/IX5WebSettings$PluginState:name	()Ljava/lang/String;
    //   28: invokestatic 278	com/tencent/smtt/sdk/WebSettings$PluginState:valueOf	(Ljava/lang/String;)Lcom/tencent/smtt/sdk/WebSettings$PluginState;
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: aload_0
    //   37: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   40: ifne +57 -> 97
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: ifnull +50 -> 97
    //   50: getstatic 66	android/os/Build$VERSION:SDK_INT	I
    //   53: bipush 8
    //   55: if_icmplt +37 -> 92
    //   58: aload_0
    //   59: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   62: ldc_w 279
    //   65: invokestatic 93	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   68: astore_1
    //   69: aload_1
    //   70: ifnonnull +8 -> 78
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -43 -> 32
    //   78: aload_1
    //   79: checkcast 281	android/webkit/WebSettings$PluginState
    //   82: invokevirtual 282	android/webkit/WebSettings$PluginState:name	()Ljava/lang/String;
    //   85: invokestatic 278	com/tencent/smtt/sdk/WebSettings$PluginState:valueOf	(Ljava/lang/String;)Lcom/tencent/smtt/sdk/WebSettings$PluginState;
    //   88: astore_1
    //   89: goto -57 -> 32
    //   92: aconst_null
    //   93: astore_1
    //   94: goto -62 -> 32
    //   97: aconst_null
    //   98: astore_1
    //   99: goto -67 -> 32
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	WebSettings
    //   31	68	1	localObject1	Object
    //   102	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	32	102	finally
    //   36	69	102	finally
    //   78	89	102	finally
  }
  
  @Deprecated
  @TargetApi(8)
  public boolean getPluginsEnabled()
  {
    boolean bool2 = false;
    try
    {
      boolean bool1;
      if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
        bool1 = this.mWebSettingsImpl.getPluginsEnabled();
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if (!this.isUseX5)
        {
          bool1 = bool2;
          if (this.mSystemWebSettings != null)
          {
            Object localObject1;
            if (Build.VERSION.SDK_INT <= 17)
            {
              localObject1 = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "getPluginsEnabled");
              if (localObject1 == null) {
                bool1 = false;
              } else {
                bool1 = ((Boolean)localObject1).booleanValue();
              }
            }
            else
            {
              bool1 = bool2;
              if (Build.VERSION.SDK_INT == 18)
              {
                localObject1 = this.mSystemWebSettings.getPluginState();
                WebSettings.PluginState localPluginState = WebSettings.PluginState.ON;
                bool1 = bool2;
                if (localPluginState == localObject1) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    finally {}
  }
  
  @Deprecated
  public String getPluginsPath()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((this.isUseX5) && (this.mWebSettingsImpl != null))
        {
          localObject1 = this.mWebSettingsImpl.getPluginsPath();
          return localObject1;
        }
        if ((!this.isUseX5) && (this.mSystemWebSettings != null))
        {
          if (Build.VERSION.SDK_INT <= 17)
          {
            localObject1 = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "getPluginsPath");
            if (localObject1 == null)
            {
              localObject1 = null;
              continue;
            }
            localObject1 = (String)localObject1;
          }
        }
        else
        {
          localObject1 = "";
          continue;
        }
        String str = "";
      }
      finally {}
    }
  }
  
  /* Error */
  public String getSansSerifFontFamily()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 300 1 0
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 301	android/webkit/WebSettings:getSansSerifFontFamily	()Ljava/lang/String;
    //   51: astore_1
    //   52: goto -26 -> 26
    //   55: ldc 133
    //   57: astore_1
    //   58: goto -32 -> 26
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	WebSettings
    //   25	33	1	str	String
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   30	52	61	finally
  }
  
  public boolean getSaveFormData()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getSaveFormData();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return this.mSystemWebSettings.getSaveFormData();
    }
    return false;
  }
  
  public boolean getSavePassword()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getSavePassword();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return this.mSystemWebSettings.getSavePassword();
    }
    return false;
  }
  
  /* Error */
  public String getSerifFontFamily()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 312 1 0
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 313	android/webkit/WebSettings:getSerifFontFamily	()Ljava/lang/String;
    //   51: astore_1
    //   52: goto -26 -> 26
    //   55: ldc 133
    //   57: astore_1
    //   58: goto -32 -> 26
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	WebSettings
    //   25	33	1	str	String
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   30	52	61	finally
  }
  
  /* Error */
  public String getStandardFontFamily()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 316 1 0
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 317	android/webkit/WebSettings:getStandardFontFamily	()Ljava/lang/String;
    //   51: astore_1
    //   52: goto -26 -> 26
    //   55: ldc 133
    //   57: astore_1
    //   58: goto -32 -> 26
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	WebSettings
    //   25	33	1	str	String
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   30	52	61	finally
  }
  
  public WebSettings.TextSize getTextSize()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return WebSettings.TextSize.valueOf(this.mWebSettingsImpl.getTextSize().name());
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return WebSettings.TextSize.valueOf(this.mSystemWebSettings.getTextSize().name());
    }
    return null;
  }
  
  @TargetApi(14)
  public int getTextZoom()
  {
    int j = 0;
    try
    {
      int i;
      if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
        i = this.mWebSettingsImpl.getTextZoom();
      }
      for (;;)
      {
        return i;
        i = j;
        if (!this.isUseX5)
        {
          i = j;
          if (this.mSystemWebSettings != null)
          {
            int k = Build.VERSION.SDK_INT;
            i = j;
            if (k >= 14) {
              try
              {
                i = this.mSystemWebSettings.getTextZoom();
              }
              catch (Exception localException)
              {
                Object localObject1 = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "getTextZoom");
                if (localObject1 == null) {
                  i = 0;
                } else {
                  i = ((Integer)localObject1).intValue();
                }
              }
            }
          }
        }
      }
    }
    finally {}
  }
  
  @Deprecated
  public boolean getUseWebViewBackgroundForOverscrollBackground()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getUseWebViewBackgroundForOverscrollBackground();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null))
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSystemWebSettings, "getUseWebViewBackgroundForOverscrollBackground");
      if (localObject == null) {
        return false;
      }
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  /* Error */
  public boolean getUseWideViewPort()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 351 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 352	android/webkit/WebSettings:getUseWideViewPort	()Z
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	bool	boolean
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  @TargetApi(3)
  public String getUserAgentString()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.getUserAgentString();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return this.mSystemWebSettings.getUserAgentString();
    }
    return "";
  }
  
  @TargetApi(11)
  public void setAllowContentAccess(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setAllowContentAccess(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null) || (Build.VERSION.SDK_INT < 11)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setAllowContentAccess", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  @TargetApi(3)
  public void setAllowFileAccess(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setAllowFileAccess(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setAllowFileAccess(paramBoolean);
  }
  
  @TargetApi(16)
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setAllowFileAccessFromFileURLs(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setAllowFileAccessFromFileURLs", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  @TargetApi(16)
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setAllowUniversalAccessFromFileURLs(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setAllowUniversalAccessFromFileURLs", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  @TargetApi(7)
  public void setAppCacheEnabled(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setAppCacheEnabled(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setAppCacheEnabled(paramBoolean);
  }
  
  @TargetApi(7)
  public void setAppCacheMaxSize(long paramLong)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setAppCacheMaxSize(paramLong);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setAppCacheMaxSize(paramLong);
  }
  
  @TargetApi(7)
  public void setAppCachePath(String paramString)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setAppCachePath(paramString);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setAppCachePath(paramString);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setBlockNetworkImage(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setBlockNetworkImage(paramBoolean);
  }
  
  /* Error */
  @TargetApi(8)
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: iload_1
    //   21: invokeinterface 402 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: getstatic 66	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 8
    //   48: if_icmplt -22 -> 26
    //   51: aload_0
    //   52: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   55: iload_1
    //   56: invokevirtual 403	android/webkit/WebSettings:setBlockNetworkLoads	(Z)V
    //   59: goto -33 -> 26
    //   62: astore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	WebSettings
    //   0	67	1	paramBoolean	boolean
    //   62	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	62	finally
    //   29	59	62	finally
  }
  
  @TargetApi(3)
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setBuiltInZoomControls(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setBuiltInZoomControls(paramBoolean);
  }
  
  public void setCacheMode(int paramInt)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setCacheMode(paramInt);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setCacheMode(paramInt);
  }
  
  /* Error */
  public void setCursiveFontFamily(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: aload_1
    //   21: invokeinterface 415 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: aload_1
    //   48: invokevirtual 416	android/webkit/WebSettings:setCursiveFontFamily	(Ljava/lang/String;)V
    //   51: goto -25 -> 26
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  @TargetApi(5)
  public void setDatabaseEnabled(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setDatabaseEnabled(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setDatabaseEnabled(paramBoolean);
  }
  
  @Deprecated
  @TargetApi(5)
  public void setDatabasePath(String paramString)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setDatabasePath(paramString);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setDatabasePath", new Class[] { String.class }, new Object[] { paramString });
  }
  
  /* Error */
  public void setDefaultFixedFontSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: iload_1
    //   21: invokeinterface 427 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: iload_1
    //   48: invokevirtual 428	android/webkit/WebSettings:setDefaultFixedFontSize	(I)V
    //   51: goto -25 -> 26
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramInt	int
    //   54	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  /* Error */
  public void setDefaultFontSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: iload_1
    //   21: invokeinterface 431 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: iload_1
    //   48: invokevirtual 432	android/webkit/WebSettings:setDefaultFontSize	(I)V
    //   51: goto -25 -> 26
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramInt	int
    //   54	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  /* Error */
  public void setDefaultTextEncodingName(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: aload_1
    //   21: invokeinterface 435 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: aload_1
    //   48: invokevirtual 436	android/webkit/WebSettings:setDefaultTextEncodingName	(Ljava/lang/String;)V
    //   51: goto -25 -> 26
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  @TargetApi(7)
  public void setDefaultZoom(WebSettings.ZoomDensity paramZoomDensity)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(paramZoomDensity.name()));
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(paramZoomDensity.name()));
  }
  
  @TargetApi(11)
  public void setDisplayZoomControls(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setDisplayZoomControls(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null) || (Build.VERSION.SDK_INT < 11)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setDisplayZoomControls", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  @TargetApi(7)
  public void setDomStorageEnabled(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setDomStorageEnabled(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setDomStorageEnabled(paramBoolean);
  }
  
  @Deprecated
  @TargetApi(11)
  public void setEnableSmoothTransition(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setEnableSmoothTransition(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null) || (Build.VERSION.SDK_INT < 11)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setEnableSmoothTransition", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  /* Error */
  public void setFantasyFontFamily(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: aload_1
    //   21: invokeinterface 466 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: aload_1
    //   48: invokevirtual 467	android/webkit/WebSettings:setFantasyFontFamily	(Ljava/lang/String;)V
    //   51: goto -25 -> 26
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  /* Error */
  public void setFixedFontFamily(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: aload_1
    //   21: invokeinterface 470 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: aload_1
    //   48: invokevirtual 471	android/webkit/WebSettings:setFixedFontFamily	(Ljava/lang/String;)V
    //   51: goto -25 -> 26
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  @TargetApi(5)
  public void setGeolocationDatabasePath(String paramString)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setGeolocationDatabasePath(paramString);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setGeolocationDatabasePath(paramString);
  }
  
  @TargetApi(5)
  public void setGeolocationEnabled(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setGeolocationEnabled(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setGeolocationEnabled(paramBoolean);
  }
  
  /* Error */
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: iload_1
    //   21: invokeinterface 482 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: iload_1
    //   48: invokevirtual 483	android/webkit/WebSettings:setJavaScriptCanOpenWindowsAutomatically	(Z)V
    //   51: goto -25 -> 26
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramBoolean	boolean
    //   54	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  @Deprecated
  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    try
    {
      if ((this.isUseX5) && (this.mWebSettingsImpl != null))
      {
        this.mWebSettingsImpl.setJavaScriptEnabled(paramBoolean);
        return;
      }
      if ((!this.isUseX5) && (this.mSystemWebSettings != null))
      {
        this.mSystemWebSettings.setJavaScriptEnabled(paramBoolean);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(paramLayoutAlgorithm.name()));
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(paramLayoutAlgorithm.name()));
  }
  
  public void setLightTouchEnabled(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setLightTouchEnabled(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setLightTouchEnabled(paramBoolean);
  }
  
  @TargetApi(7)
  public void setLoadWithOverviewMode(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setLoadWithOverviewMode(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setLoadWithOverviewMode(paramBoolean);
  }
  
  public void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setLoadsImagesAutomatically(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setLoadsImagesAutomatically(paramBoolean);
  }
  
  @TargetApi(17)
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setMediaPlaybackRequiresUserGesture(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null) || (Build.VERSION.SDK_INT < 17)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setMediaPlaybackRequiresUserGesture", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  /* Error */
  public void setMinimumFontSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: iload_1
    //   21: invokeinterface 521 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: iload_1
    //   48: invokevirtual 522	android/webkit/WebSettings:setMinimumFontSize	(I)V
    //   51: goto -25 -> 26
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramInt	int
    //   54	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  /* Error */
  public void setMinimumLogicalFontSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: iload_1
    //   21: invokeinterface 525 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: iload_1
    //   48: invokevirtual 526	android/webkit/WebSettings:setMinimumLogicalFontSize	(I)V
    //   51: goto -25 -> 26
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramInt	int
    //   54	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  @TargetApi(21)
  public void setMixedContentMode(int paramInt)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {}
    while ((this.isUseX5) || (this.mSystemWebSettings == null) || (Build.VERSION.SDK_INT < 21)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setMixedContentMode", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setNavDump(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setNavDump(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setNavDump", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setNeedInitialFocus(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setNeedInitialFocus(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setNeedInitialFocus(paramBoolean);
  }
  
  /* Error */
  @Deprecated
  @TargetApi(8)
  public void setPluginState(WebSettings.PluginState paramPluginState)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +29 -> 35
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +22 -> 35
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: aload_1
    //   21: invokevirtual 544	com/tencent/smtt/sdk/WebSettings$PluginState:name	()Ljava/lang/String;
    //   24: invokestatic 547	com/tencent/smtt/export/external/interfaces/IX5WebSettings$PluginState:valueOf	(Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings$PluginState;
    //   27: invokeinterface 550 2 0
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   39: ifne -7 -> 32
    //   42: aload_0
    //   43: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   46: ifnull -14 -> 32
    //   49: getstatic 66	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 8
    //   54: if_icmplt -22 -> 32
    //   57: aload_1
    //   58: invokevirtual 544	com/tencent/smtt/sdk/WebSettings$PluginState:name	()Ljava/lang/String;
    //   61: invokestatic 553	android/webkit/WebSettings$PluginState:valueOf	(Ljava/lang/String;)Landroid/webkit/WebSettings$PluginState;
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   69: ldc_w 554
    //   72: iconst_1
    //   73: anewarray 71	java/lang/Class
    //   76: dup
    //   77: iconst_0
    //   78: ldc_w 281
    //   81: aastore
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: aastore
    //   90: invokestatic 256	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: goto -62 -> 32
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	WebSettings
    //   0	102	1	paramPluginState	WebSettings.PluginState
    // Exception table:
    //   from	to	target	type
    //   2	32	97	finally
    //   35	94	97	finally
  }
  
  @Deprecated
  public void setPluginsEnabled(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setPluginsEnabled(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  /* Error */
  @Deprecated
  public void setPluginsPath(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: aload_1
    //   21: invokeinterface 561 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: ldc_w 562
    //   50: iconst_1
    //   51: anewarray 71	java/lang/Class
    //   54: dup
    //   55: iconst_0
    //   56: ldc 81
    //   58: aastore
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_1
    //   66: aastore
    //   67: invokestatic 256	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: goto -45 -> 26
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	WebSettings
    //   0	79	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	74	finally
    //   29	71	74	finally
  }
  
  public void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(paramRenderPriority.name()));
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(paramRenderPriority.name()));
  }
  
  /* Error */
  public void setSansSerifFontFamily(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: aload_1
    //   21: invokeinterface 586 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: aload_1
    //   48: invokevirtual 587	android/webkit/WebSettings:setSansSerifFontFamily	(Ljava/lang/String;)V
    //   51: goto -25 -> 26
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  public void setSaveFormData(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setSaveFormData(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setSaveFormData(paramBoolean);
  }
  
  public void setSavePassword(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setSavePassword(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setSavePassword(paramBoolean);
  }
  
  /* Error */
  public void setSerifFontFamily(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: aload_1
    //   21: invokeinterface 598 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: aload_1
    //   48: invokevirtual 599	android/webkit/WebSettings:setSerifFontFamily	(Ljava/lang/String;)V
    //   51: goto -25 -> 26
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  /* Error */
  public void setStandardFontFamily(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: aload_1
    //   21: invokeinterface 602 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: aload_0
    //   44: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   47: aload_1
    //   48: invokevirtual 603	android/webkit/WebSettings:setStandardFontFamily	(Ljava/lang/String;)V
    //   51: goto -25 -> 26
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	WebSettings
    //   0	59	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   29	51	54	finally
  }
  
  public void setSupportMultipleWindows(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setSupportMultipleWindows(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setSupportMultipleWindows(paramBoolean);
  }
  
  public void setSupportZoom(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setSupportZoom(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setSupportZoom(paramBoolean);
  }
  
  public void setTextSize(WebSettings.TextSize paramTextSize)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setTextSize(IX5WebSettings.TextSize.valueOf(paramTextSize.name()));
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setTextSize(android.webkit.WebSettings.TextSize.valueOf(paramTextSize.name()));
  }
  
  /* Error */
  @TargetApi(14)
  public void setTextZoom(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +23 -> 29
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: iload_1
    //   21: invokeinterface 629 2 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   40: ifnull -14 -> 26
    //   43: getstatic 66	android/os/Build$VERSION:SDK_INT	I
    //   46: istore_2
    //   47: iload_2
    //   48: bipush 14
    //   50: if_icmplt -24 -> 26
    //   53: aload_0
    //   54: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   57: iload_1
    //   58: invokevirtual 630	android/webkit/WebSettings:setTextZoom	(I)V
    //   61: goto -35 -> 26
    //   64: astore_3
    //   65: aload_0
    //   66: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   69: ldc_w 631
    //   72: iconst_1
    //   73: anewarray 71	java/lang/Class
    //   76: dup
    //   77: iconst_0
    //   78: getstatic 530	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   81: aastore
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: iload_1
    //   89: invokestatic 533	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: invokestatic 256	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   96: pop
    //   97: goto -71 -> 26
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	WebSettings
    //   0	105	1	paramInt	int
    //   46	5	2	i	int
    //   64	1	3	localException	Exception
    //   100	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   53	61	64	java/lang/Exception
    //   2	26	100	finally
    //   29	47	100	finally
    //   53	61	100	finally
    //   65	97	100	finally
  }
  
  @Deprecated
  public void setUseWebViewBackgroundForOverscrollBackground(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setUseWebViewBackgroundForOverscrollBackground(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    ReflectionUtils.invokeInstance(this.mSystemWebSettings, "setUseWebViewBackgroundForOverscrollBackground", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setUseWideViewPort(boolean paramBoolean)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setUseWideViewPort(paramBoolean);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setUseWideViewPort(paramBoolean);
  }
  
  public void setUserAgent(String paramString)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setUserAgent(paramString);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setUserAgentString(paramString);
  }
  
  @TargetApi(3)
  public void setUserAgentString(String paramString)
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      this.mWebSettingsImpl.setUserAgentString(paramString);
    }
    while ((this.isUseX5) || (this.mSystemWebSettings == null)) {
      return;
    }
    this.mSystemWebSettings.setUserAgentString(paramString);
  }
  
  /* Error */
  public boolean supportMultipleWindows()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/smtt/sdk/WebSettings:mWebSettingsImpl	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   20: invokeinterface 649 1 0
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 36	com/tencent/smtt/sdk/WebSettings:isUseX5	Z
    //   34: ifne +21 -> 55
    //   37: aload_0
    //   38: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   41: ifnull +14 -> 55
    //   44: aload_0
    //   45: getfield 34	com/tencent/smtt/sdk/WebSettings:mSystemWebSettings	Landroid/webkit/WebSettings;
    //   48: invokevirtual 650	android/webkit/WebSettings:supportMultipleWindows	()Z
    //   51: istore_1
    //   52: goto -26 -> 26
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -31 -> 26
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	WebSettings
    //   25	32	1	bool	boolean
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	60	finally
    //   30	52	60	finally
  }
  
  public boolean supportZoom()
  {
    if ((this.isUseX5) && (this.mWebSettingsImpl != null)) {
      return this.mWebSettingsImpl.supportZoom();
    }
    if ((!this.isUseX5) && (this.mSystemWebSettings != null)) {
      return this.mSystemWebSettings.supportZoom();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebSettings
 * JD-Core Version:    0.7.0.1
 */