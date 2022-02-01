package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity;
import com.tencent.smtt.utils.i;

public class WebSettings
{
  public static final int LOAD_CACHE_ELSE_NETWORK = 1;
  public static final int LOAD_CACHE_ONLY = 3;
  public static final int LOAD_DEFAULT = -1;
  public static final int LOAD_NORMAL = 0;
  public static final int LOAD_NO_CACHE = 2;
  private IX5WebSettings a = null;
  private android.webkit.WebSettings b = null;
  private boolean c = false;
  
  WebSettings(android.webkit.WebSettings paramWebSettings)
  {
    this.a = null;
    this.b = paramWebSettings;
    this.c = false;
  }
  
  WebSettings(IX5WebSettings paramIX5WebSettings)
  {
    this.a = paramIX5WebSettings;
    this.b = null;
    this.c = true;
  }
  
  @TargetApi(17)
  public static String getDefaultUserAgent(Context paramContext)
  {
    if (x.a().b()) {
      return x.a().c().i(paramContext);
    }
    if (Build.VERSION.SDK_INT < 17) {
      return null;
    }
    paramContext = i.a(android.webkit.WebSettings.class, "getDefaultUserAgent", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  @Deprecated
  public boolean enableSmoothTransition()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).enableSmoothTransition();
      }
    }
    boolean bool3 = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (this.b != null)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 11)
        {
          localObject = i.a(this.b, "enableSmoothTransition");
          if (localObject == null) {
            return false;
          }
          bool1 = ((Boolean)localObject).booleanValue();
        }
      }
    }
    return bool1;
  }
  
  @TargetApi(11)
  public boolean getAllowContentAccess()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getAllowContentAccess();
      }
    }
    boolean bool3 = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (this.b != null)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 11)
        {
          localObject = i.a(this.b, "getAllowContentAccess");
          if (localObject == null) {
            return false;
          }
          bool1 = ((Boolean)localObject).booleanValue();
        }
      }
    }
    return bool1;
  }
  
  @TargetApi(3)
  public boolean getAllowFileAccess()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getAllowFileAccess();
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((android.webkit.WebSettings)localObject).getAllowFileAccess();
      }
    }
    return false;
  }
  
  public boolean getBlockNetworkImage()
  {
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getBlockNetworkImage();
        return bool;
      }
      if ((!this.c) && (this.b != null))
      {
        bool = this.b.getBlockNetworkImage();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  @TargetApi(8)
  public boolean getBlockNetworkLoads()
  {
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getBlockNetworkLoads();
        return bool;
      }
      if ((!this.c) && (this.b != null))
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          bool = this.b.getBlockNetworkLoads();
          return bool;
        }
        return false;
      }
      return false;
    }
    finally {}
  }
  
  @TargetApi(3)
  public boolean getBuiltInZoomControls()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getBuiltInZoomControls();
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((android.webkit.WebSettings)localObject).getBuiltInZoomControls();
      }
    }
    return false;
  }
  
  public int getCacheMode()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getCacheMode();
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((android.webkit.WebSettings)localObject).getCacheMode();
      }
    }
    return 0;
  }
  
  public String getCursiveFontFamily()
  {
    try
    {
      String str;
      if ((this.c) && (this.a != null))
      {
        str = this.a.getCursiveFontFamily();
        return str;
      }
      if ((!this.c) && (this.b != null))
      {
        str = this.b.getCursiveFontFamily();
        return str;
      }
      return "";
    }
    finally {}
  }
  
  @TargetApi(5)
  public boolean getDatabaseEnabled()
  {
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getDatabaseEnabled();
        return bool;
      }
      if ((!this.c) && (this.b != null))
      {
        bool = this.b.getDatabaseEnabled();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  @Deprecated
  @TargetApi(5)
  public String getDatabasePath()
  {
    try
    {
      String str;
      if ((this.c) && (this.a != null))
      {
        str = this.a.getDatabasePath();
        return str;
      }
      if ((!this.c) && (this.b != null))
      {
        str = this.b.getDatabasePath();
        return str;
      }
      return "";
    }
    finally {}
  }
  
  public int getDefaultFixedFontSize()
  {
    try
    {
      int i;
      if ((this.c) && (this.a != null))
      {
        i = this.a.getDefaultFixedFontSize();
        return i;
      }
      if ((!this.c) && (this.b != null))
      {
        i = this.b.getDefaultFixedFontSize();
        return i;
      }
      return 0;
    }
    finally {}
  }
  
  public int getDefaultFontSize()
  {
    try
    {
      int i;
      if ((this.c) && (this.a != null))
      {
        i = this.a.getDefaultFontSize();
        return i;
      }
      if ((!this.c) && (this.b != null))
      {
        i = this.b.getDefaultFontSize();
        return i;
      }
      return 0;
    }
    finally {}
  }
  
  public String getDefaultTextEncodingName()
  {
    try
    {
      String str;
      if ((this.c) && (this.a != null))
      {
        str = this.a.getDefaultTextEncodingName();
        return str;
      }
      if ((!this.c) && (this.b != null))
      {
        str = this.b.getDefaultTextEncodingName();
        return str;
      }
      return "";
    }
    finally {}
  }
  
  @Deprecated
  @TargetApi(7)
  public WebSettings.ZoomDensity getDefaultZoom()
  {
    if (this.c)
    {
      localObject = this.a;
      if (localObject == null) {}
    }
    for (Object localObject = ((IX5WebSettings)localObject).getDefaultZoom().name();; localObject = ((android.webkit.WebSettings)localObject).getDefaultZoom().name())
    {
      return WebSettings.ZoomDensity.valueOf((String)localObject);
      if (this.c) {
        break;
      }
      localObject = this.b;
      if (localObject == null) {
        break;
      }
    }
    return null;
  }
  
  @TargetApi(11)
  public boolean getDisplayZoomControls()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getDisplayZoomControls();
      }
    }
    boolean bool3 = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (this.b != null)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 11)
        {
          localObject = i.a(this.b, "getDisplayZoomControls");
          if (localObject == null) {
            return false;
          }
          bool1 = ((Boolean)localObject).booleanValue();
        }
      }
    }
    return bool1;
  }
  
  @TargetApi(7)
  public boolean getDomStorageEnabled()
  {
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getDomStorageEnabled();
        return bool;
      }
      if ((!this.c) && (this.b != null))
      {
        bool = this.b.getDomStorageEnabled();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public String getFantasyFontFamily()
  {
    try
    {
      String str;
      if ((this.c) && (this.a != null))
      {
        str = this.a.getFantasyFontFamily();
        return str;
      }
      if ((!this.c) && (this.b != null))
      {
        str = this.b.getFantasyFontFamily();
        return str;
      }
      return "";
    }
    finally {}
  }
  
  public String getFixedFontFamily()
  {
    try
    {
      String str;
      if ((this.c) && (this.a != null))
      {
        str = this.a.getFixedFontFamily();
        return str;
      }
      if ((!this.c) && (this.b != null))
      {
        str = this.b.getFixedFontFamily();
        return str;
      }
      return "";
    }
    finally {}
  }
  
  public boolean getJavaScriptCanOpenWindowsAutomatically()
  {
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getJavaScriptCanOpenWindowsAutomatically();
        return bool;
      }
      if ((!this.c) && (this.b != null))
      {
        bool = this.b.getJavaScriptCanOpenWindowsAutomatically();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public boolean getJavaScriptEnabled()
  {
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getJavaScriptEnabled();
        return bool;
      }
      if ((!this.c) && (this.b != null))
      {
        bool = this.b.getJavaScriptEnabled();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public WebSettings.LayoutAlgorithm getLayoutAlgorithm()
  {
    try
    {
      WebSettings.LayoutAlgorithm localLayoutAlgorithm;
      if ((this.c) && (this.a != null))
      {
        localLayoutAlgorithm = WebSettings.LayoutAlgorithm.valueOf(this.a.getLayoutAlgorithm().name());
        return localLayoutAlgorithm;
      }
      if ((!this.c) && (this.b != null))
      {
        localLayoutAlgorithm = WebSettings.LayoutAlgorithm.valueOf(this.b.getLayoutAlgorithm().name());
        return localLayoutAlgorithm;
      }
      return null;
    }
    finally {}
  }
  
  @Deprecated
  public boolean getLightTouchEnabled()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getLightTouchEnabled();
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((android.webkit.WebSettings)localObject).getLightTouchEnabled();
      }
    }
    return false;
  }
  
  @TargetApi(7)
  public boolean getLoadWithOverviewMode()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getLoadWithOverviewMode();
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((android.webkit.WebSettings)localObject).getLoadWithOverviewMode();
      }
    }
    return false;
  }
  
  public boolean getLoadsImagesAutomatically()
  {
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getLoadsImagesAutomatically();
        return bool;
      }
      if ((!this.c) && (this.b != null))
      {
        bool = this.b.getLoadsImagesAutomatically();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  @TargetApi(17)
  public boolean getMediaPlaybackRequiresUserGesture()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getMediaPlaybackRequiresUserGesture();
      }
    }
    boolean bool3 = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (this.b != null)
      {
        if (Build.VERSION.SDK_INT < 17) {
          return false;
        }
        localObject = i.a(this.b, "getMediaPlaybackRequiresUserGesture");
        if (localObject == null) {
          return false;
        }
        bool1 = ((Boolean)localObject).booleanValue();
      }
    }
    return bool1;
  }
  
  public int getMinimumFontSize()
  {
    try
    {
      int i;
      if ((this.c) && (this.a != null))
      {
        i = this.a.getMinimumFontSize();
        return i;
      }
      if ((!this.c) && (this.b != null))
      {
        i = this.b.getMinimumFontSize();
        return i;
      }
      return 0;
    }
    finally {}
  }
  
  public int getMinimumLogicalFontSize()
  {
    try
    {
      int i;
      if ((this.c) && (this.a != null))
      {
        i = this.a.getMinimumLogicalFontSize();
        return i;
      }
      if ((!this.c) && (this.b != null))
      {
        i = this.b.getMinimumLogicalFontSize();
        return i;
      }
      return 0;
    }
    finally {}
  }
  
  public int getMixedContentMode()
  {
    try
    {
      boolean bool = this.c;
      int i = -1;
      if (bool)
      {
        IX5WebSettings localIX5WebSettings = this.a;
        if (localIX5WebSettings != null) {
          try
          {
            i = this.a.getMixedContentMode();
            return i;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            return -1;
          }
        }
      }
      int j = Build.VERSION.SDK_INT;
      if (j < 21) {
        return -1;
      }
      Object localObject1 = i.a(this.b, "getMixedContentMode", new Class[0], new Object[0]);
      if (localObject1 != null) {
        i = ((Integer)localObject1).intValue();
      }
      return i;
    }
    finally {}
  }
  
  @Deprecated
  public boolean getNavDump()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getNavDump();
      }
    }
    boolean bool3 = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      localObject = this.b;
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = i.a(localObject, "getNavDump");
        if (localObject == null) {
          return false;
        }
        bool1 = ((Boolean)localObject).booleanValue();
      }
    }
    return bool1;
  }
  
  @Deprecated
  @TargetApi(8)
  public WebSettings.PluginState getPluginState()
  {
    try
    {
      Object localObject1;
      if ((this.c) && (this.a != null))
      {
        localObject1 = WebSettings.PluginState.valueOf(this.a.getPluginState().name());
        return localObject1;
      }
      if ((!this.c) && (this.b != null))
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          localObject1 = i.a(this.b, "getPluginState");
          if (localObject1 == null) {
            return null;
          }
          localObject1 = WebSettings.PluginState.valueOf(((android.webkit.WebSettings.PluginState)localObject1).name());
          return localObject1;
        }
        return null;
      }
      return null;
    }
    finally {}
  }
  
  @Deprecated
  @TargetApi(8)
  public boolean getPluginsEnabled()
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        bool1 = this.a.getPluginsEnabled();
        return bool1;
      }
      boolean bool3 = this.c;
      boolean bool2 = false;
      boolean bool1 = false;
      if ((!bool3) && (this.b != null))
      {
        Object localObject1;
        if (Build.VERSION.SDK_INT <= 17)
        {
          localObject1 = i.a(this.b, "getPluginsEnabled");
          if (localObject1 != null) {
            bool1 = ((Boolean)localObject1).booleanValue();
          }
          return bool1;
        }
        if (Build.VERSION.SDK_INT == 18)
        {
          localObject1 = this.b.getPluginState();
          android.webkit.WebSettings.PluginState localPluginState = android.webkit.WebSettings.PluginState.ON;
          bool1 = bool2;
          if (localPluginState == localObject1) {
            bool1 = true;
          }
          return bool1;
        }
        return false;
      }
      return false;
    }
    finally {}
  }
  
  @Deprecated
  public String getPluginsPath()
  {
    try
    {
      Object localObject1;
      if ((this.c) && (this.a != null))
      {
        localObject1 = this.a.getPluginsPath();
        return localObject1;
      }
      if ((!this.c) && (this.b != null))
      {
        if (Build.VERSION.SDK_INT <= 17)
        {
          localObject1 = i.a(this.b, "getPluginsPath");
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = (String)localObject1;
          }
          return localObject1;
        }
        return "";
      }
      return "";
    }
    finally {}
  }
  
  public boolean getSafeBrowsingEnabled()
  {
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 26) {
        return this.b.getSafeBrowsingEnabled();
      }
    }
    else if (this.c)
    {
      IX5WebSettings localIX5WebSettings = this.a;
      if (localIX5WebSettings != null) {
        try
        {
          boolean bool = localIX5WebSettings.getSafeBrowsingEnabled();
          return bool;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public String getSansSerifFontFamily()
  {
    try
    {
      String str;
      if ((this.c) && (this.a != null))
      {
        str = this.a.getSansSerifFontFamily();
        return str;
      }
      if ((!this.c) && (this.b != null))
      {
        str = this.b.getSansSerifFontFamily();
        return str;
      }
      return "";
    }
    finally {}
  }
  
  @Deprecated
  public boolean getSaveFormData()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getSaveFormData();
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((android.webkit.WebSettings)localObject).getSaveFormData();
      }
    }
    return false;
  }
  
  @Deprecated
  public boolean getSavePassword()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getSavePassword();
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((android.webkit.WebSettings)localObject).getSavePassword();
      }
    }
    return false;
  }
  
  public String getSerifFontFamily()
  {
    try
    {
      String str;
      if ((this.c) && (this.a != null))
      {
        str = this.a.getSerifFontFamily();
        return str;
      }
      if ((!this.c) && (this.b != null))
      {
        str = this.b.getSerifFontFamily();
        return str;
      }
      return "";
    }
    finally {}
  }
  
  public String getStandardFontFamily()
  {
    try
    {
      String str;
      if ((this.c) && (this.a != null))
      {
        str = this.a.getStandardFontFamily();
        return str;
      }
      if ((!this.c) && (this.b != null))
      {
        str = this.b.getStandardFontFamily();
        return str;
      }
      return "";
    }
    finally {}
  }
  
  @Deprecated
  public WebSettings.TextSize getTextSize()
  {
    if (this.c)
    {
      localObject = this.a;
      if (localObject == null) {}
    }
    for (Object localObject = ((IX5WebSettings)localObject).getTextSize().name();; localObject = ((android.webkit.WebSettings)localObject).getTextSize().name())
    {
      return WebSettings.TextSize.valueOf((String)localObject);
      if (this.c) {
        break;
      }
      localObject = this.b;
      if (localObject == null) {
        break;
      }
    }
    return null;
  }
  
  @TargetApi(14)
  public int getTextZoom()
  {
    int i;
    int j;
    label74:
    try
    {
      if ((this.c) && (this.a != null))
      {
        i = this.a.getTextZoom();
        return i;
      }
      boolean bool = this.c;
      i = 0;
      if ((!bool) && (this.b != null))
      {
        j = Build.VERSION.SDK_INT;
        if (j < 14) {
          return 0;
        }
      }
    }
    finally {}
    try
    {
      j = this.b.getTextZoom();
      return j;
    }
    catch (Exception localException)
    {
      break label74;
    }
    Object localObject1 = i.a(this.b, "getTextZoom");
    if (localObject1 != null) {
      i = ((Integer)localObject1).intValue();
    }
    return i;
    return 0;
  }
  
  @Deprecated
  public boolean getUseWebViewBackgroundForOverscrollBackground()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getUseWebViewBackgroundForOverscrollBackground();
      }
    }
    boolean bool3 = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      localObject = this.b;
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = i.a(localObject, "getUseWebViewBackgroundForOverscrollBackground");
        if (localObject == null) {
          return false;
        }
        bool1 = ((Boolean)localObject).booleanValue();
      }
    }
    return bool1;
  }
  
  public boolean getUseWideViewPort()
  {
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getUseWideViewPort();
        return bool;
      }
      if ((!this.c) && (this.b != null))
      {
        bool = this.b.getUseWideViewPort();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  @TargetApi(3)
  public String getUserAgentString()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).getUserAgentString();
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((android.webkit.WebSettings)localObject).getUserAgentString();
      }
    }
    return "";
  }
  
  @TargetApi(11)
  public void setAllowContentAccess(boolean paramBoolean)
  {
    if (this.c)
    {
      IX5WebSettings localIX5WebSettings = this.a;
      if (localIX5WebSettings != null)
      {
        localIX5WebSettings.setAllowContentAccess(paramBoolean);
        return;
      }
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 11) {
        return;
      }
      i.a(this.b, "setAllowContentAccess", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  @TargetApi(3)
  public void setAllowFileAccess(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setAllowFileAccess(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setAllowFileAccess(paramBoolean);
      }
    }
  }
  
  @TargetApi(16)
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setAllowFileAccessFromFileURLs(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        i.a(localObject, "setAllowFileAccessFromFileURLs", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  @TargetApi(16)
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setAllowUniversalAccessFromFileURLs(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        i.a(localObject, "setAllowUniversalAccessFromFileURLs", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  @TargetApi(7)
  public void setAppCacheEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setAppCacheEnabled(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setAppCacheEnabled(paramBoolean);
      }
    }
  }
  
  @Deprecated
  @TargetApi(7)
  public void setAppCacheMaxSize(long paramLong)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setAppCacheMaxSize(paramLong);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setAppCacheMaxSize(paramLong);
      }
    }
  }
  
  @TargetApi(7)
  public void setAppCachePath(String paramString)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setAppCachePath(paramString);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setAppCachePath(paramString);
      }
    }
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setBlockNetworkImage(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setBlockNetworkImage(paramBoolean);
      }
    }
  }
  
  @TargetApi(8)
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setBlockNetworkLoads(paramBoolean);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label62;
        }
        if (Build.VERSION.SDK_INT >= 8) {
          this.b.setBlockNetworkLoads(paramBoolean);
        }
      }
      return;
      label62:
      return;
    }
    finally {}
  }
  
  @TargetApi(3)
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setBuiltInZoomControls(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setBuiltInZoomControls(paramBoolean);
      }
    }
  }
  
  public void setCacheMode(int paramInt)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setCacheMode(paramInt);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setCacheMode(paramInt);
      }
    }
  }
  
  public void setCursiveFontFamily(String paramString)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setCursiveFontFamily(paramString);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setCursiveFontFamily(paramString);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  @TargetApi(5)
  public void setDatabaseEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setDatabaseEnabled(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setDatabaseEnabled(paramBoolean);
      }
    }
  }
  
  @Deprecated
  @TargetApi(5)
  public void setDatabasePath(String paramString)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setDatabasePath(paramString);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        i.a(localObject, "setDatabasePath", new Class[] { String.class }, new Object[] { paramString });
      }
    }
  }
  
  public void setDefaultFixedFontSize(int paramInt)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setDefaultFixedFontSize(paramInt);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setDefaultFixedFontSize(paramInt);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  public void setDefaultFontSize(int paramInt)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setDefaultFontSize(paramInt);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setDefaultFontSize(paramInt);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  public void setDefaultTextEncodingName(String paramString)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setDefaultTextEncodingName(paramString);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setDefaultTextEncodingName(paramString);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  @Deprecated
  @TargetApi(7)
  public void setDefaultZoom(WebSettings.ZoomDensity paramZoomDensity)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(paramZoomDensity.name()));
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(paramZoomDensity.name()));
      }
    }
  }
  
  @TargetApi(11)
  public void setDisplayZoomControls(boolean paramBoolean)
  {
    if (this.c)
    {
      IX5WebSettings localIX5WebSettings = this.a;
      if (localIX5WebSettings != null)
      {
        localIX5WebSettings.setDisplayZoomControls(paramBoolean);
        return;
      }
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 11) {
        return;
      }
      i.a(this.b, "setDisplayZoomControls", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  @TargetApi(7)
  public void setDomStorageEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setDomStorageEnabled(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setDomStorageEnabled(paramBoolean);
      }
    }
  }
  
  @Deprecated
  @TargetApi(11)
  public void setEnableSmoothTransition(boolean paramBoolean)
  {
    if (this.c)
    {
      IX5WebSettings localIX5WebSettings = this.a;
      if (localIX5WebSettings != null)
      {
        localIX5WebSettings.setEnableSmoothTransition(paramBoolean);
        return;
      }
    }
    if ((!this.c) && (this.b != null) && (Build.VERSION.SDK_INT >= 11)) {
      i.a(this.b, "setEnableSmoothTransition", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void setFantasyFontFamily(String paramString)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setFantasyFontFamily(paramString);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setFantasyFontFamily(paramString);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  public void setFixedFontFamily(String paramString)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setFixedFontFamily(paramString);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setFixedFontFamily(paramString);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  @Deprecated
  @TargetApi(5)
  public void setGeolocationDatabasePath(String paramString)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setGeolocationDatabasePath(paramString);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setGeolocationDatabasePath(paramString);
      }
    }
  }
  
  @TargetApi(5)
  public void setGeolocationEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setGeolocationEnabled(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setGeolocationEnabled(paramBoolean);
      }
    }
  }
  
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setJavaScriptEnabled(paramBoolean);
        return;
      }
      if ((!this.c) && (this.b != null))
      {
        this.b.setJavaScriptEnabled(paramBoolean);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(paramLayoutAlgorithm.name()));
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(paramLayoutAlgorithm.name()));
      }
    }
  }
  
  @Deprecated
  public void setLightTouchEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setLightTouchEnabled(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setLightTouchEnabled(paramBoolean);
      }
    }
  }
  
  @TargetApi(7)
  public void setLoadWithOverviewMode(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setLoadWithOverviewMode(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setLoadWithOverviewMode(paramBoolean);
      }
    }
  }
  
  public void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setLoadsImagesAutomatically(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setLoadsImagesAutomatically(paramBoolean);
      }
    }
  }
  
  @TargetApi(17)
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    if (this.c)
    {
      IX5WebSettings localIX5WebSettings = this.a;
      if (localIX5WebSettings != null)
      {
        localIX5WebSettings.setMediaPlaybackRequiresUserGesture(paramBoolean);
        return;
      }
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 17) {
        return;
      }
      i.a(this.b, "setMediaPlaybackRequiresUserGesture", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void setMinimumFontSize(int paramInt)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setMinimumFontSize(paramInt);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setMinimumFontSize(paramInt);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  public void setMinimumLogicalFontSize(int paramInt)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setMinimumLogicalFontSize(paramInt);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setMinimumLogicalFontSize(paramInt);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  @TargetApi(21)
  public void setMixedContentMode(int paramInt)
  {
    if ((this.c) && (this.a != null)) {
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        return;
      }
      i.a(this.b, "setMixedContentMode", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  @Deprecated
  public void setNavDump(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setNavDump(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        i.a(localObject, "setNavDump", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  public void setNeedInitialFocus(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setNeedInitialFocus(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setNeedInitialFocus(paramBoolean);
      }
    }
  }
  
  @Deprecated
  @TargetApi(8)
  public void setPluginState(WebSettings.PluginState paramPluginState)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setPluginState(IX5WebSettings.PluginState.valueOf(paramPluginState.name()));
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label97;
        }
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramPluginState = android.webkit.WebSettings.PluginState.valueOf(paramPluginState.name());
          i.a(this.b, "setPluginState", new Class[] { android.webkit.WebSettings.PluginState.class }, new Object[] { paramPluginState });
        }
      }
      return;
      label97:
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void setPluginsEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setPluginsEnabled(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        i.a(localObject, "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  @Deprecated
  public void setPluginsPath(String paramString)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setPluginsPath(paramString);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label74;
        }
        i.a(this.b, "setPluginsPath", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
      label74:
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setRenderPriority(IX5WebSettings.RenderPriority.valueOf(paramRenderPriority.name()));
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(paramRenderPriority.name()));
      }
    }
  }
  
  public void setSafeBrowsingEnabled(boolean paramBoolean)
  {
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 26) {
        this.b.setSafeBrowsingEnabled(paramBoolean);
      }
    }
    else if (this.c)
    {
      IX5WebSettings localIX5WebSettings = this.a;
      if (localIX5WebSettings != null) {
        try
        {
          localIX5WebSettings.setSafeBrowsingEnabled(paramBoolean);
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void setSansSerifFontFamily(String paramString)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setSansSerifFontFamily(paramString);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setSansSerifFontFamily(paramString);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void setSaveFormData(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setSaveFormData(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setSaveFormData(paramBoolean);
      }
    }
  }
  
  @Deprecated
  public void setSavePassword(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setSavePassword(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setSavePassword(paramBoolean);
      }
    }
  }
  
  public void setSerifFontFamily(String paramString)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setSerifFontFamily(paramString);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setSerifFontFamily(paramString);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  public void setStandardFontFamily(String paramString)
  {
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setStandardFontFamily(paramString);
      }
      else
      {
        if ((this.c) || (this.b == null)) {
          break label54;
        }
        this.b.setStandardFontFamily(paramString);
      }
      return;
      label54:
      return;
    }
    finally {}
  }
  
  public void setSupportMultipleWindows(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setSupportMultipleWindows(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setSupportMultipleWindows(paramBoolean);
      }
    }
  }
  
  public void setSupportZoom(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setSupportZoom(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setSupportZoom(paramBoolean);
      }
    }
  }
  
  @Deprecated
  public void setTextSize(WebSettings.TextSize paramTextSize)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setTextSize(IX5WebSettings.TextSize.valueOf(paramTextSize.name()));
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setTextSize(android.webkit.WebSettings.TextSize.valueOf(paramTextSize.name()));
      }
    }
  }
  
  @TargetApi(14)
  public void setTextZoom(int paramInt)
  {
    label67:
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setTextZoom(paramInt);
      }
      else if ((!this.c) && (this.b != null))
      {
        int i = Build.VERSION.SDK_INT;
        if (i < 14) {
          return;
        }
      }
    }
    finally {}
    try
    {
      this.b.setTextZoom(paramInt);
    }
    catch (Exception localException)
    {
      break label67;
    }
    i.a(this.b, "setTextZoom", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  @Deprecated
  public void setUseWebViewBackgroundForOverscrollBackground(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setUseWebViewBackgroundForOverscrollBackground(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        i.a(localObject, "setUseWebViewBackgroundForOverscrollBackground", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  public void setUseWideViewPort(boolean paramBoolean)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setUseWideViewPort(paramBoolean);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setUseWideViewPort(paramBoolean);
      }
    }
  }
  
  public void setUserAgent(String paramString)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setUserAgent(paramString);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setUserAgentString(paramString);
      }
    }
  }
  
  @TargetApi(3)
  public void setUserAgentString(String paramString)
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((IX5WebSettings)localObject).setUserAgentString(paramString);
        return;
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        ((android.webkit.WebSettings)localObject).setUserAgentString(paramString);
      }
    }
  }
  
  public boolean supportMultipleWindows()
  {
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.supportMultipleWindows();
        return bool;
      }
      if ((!this.c) && (this.b != null))
      {
        bool = this.b.supportMultipleWindows();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public boolean supportZoom()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((IX5WebSettings)localObject).supportZoom();
      }
    }
    if (!this.c)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((android.webkit.WebSettings)localObject).supportZoom();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebSettings
 * JD-Core Version:    0.7.0.1
 */