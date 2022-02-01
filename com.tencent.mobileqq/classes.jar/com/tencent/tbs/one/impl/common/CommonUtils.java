package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;

public final class CommonUtils
{
  private static final String DEBUGGER_COMPONENT_NAME = "debugger";
  private static final String DEBUG_CATEGORY_NAME = "debug";
  private static final String EXTENSION_NAME = "extension";
  
  public static TBSOneRuntimeExtension getRuntimeExtension(Context paramContext, String paramString)
  {
    paramContext = TBSOneManager.getInstance(paramContext, paramString).getLoadedComponent("extension");
    if ((paramContext != null) && ((paramContext.getEntryObject() instanceof TBSOneRuntimeExtension))) {
      return (TBSOneRuntimeExtension)paramContext.getEntryObject();
    }
    return null;
  }
  
  public static void loadDebugPlugin(Context paramContext, TBSOneCallback<TBSOneDebugPlugin> paramTBSOneCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_ignore_flow_control", true);
    localBundle.putBoolean("is_ignore_frequency_limitation", true);
    localBundle.putBoolean("is_ignore_wifi_state", true);
    TBSOneManager localTBSOneManager = TBSOneManager.getInstance(paramContext, "debug");
    if (paramTBSOneCallback == null) {}
    for (paramContext = null;; paramContext = new CommonUtils.1(paramTBSOneCallback))
    {
      localTBSOneManager.loadComponentAsync("debugger", localBundle, paramContext);
      return;
    }
  }
  
  public static TBSOneRuntimeExtension loadRuntimeExtensionSync(Context paramContext, String paramString)
  {
    TBSOneManager localTBSOneManager = TBSOneManager.getInstance(paramContext, paramString);
    paramString = localTBSOneManager.getLoadedComponent("extension");
    paramContext = paramString;
    if (paramString == null) {}
    try
    {
      paramContext = localTBSOneManager.loadComponentSync("extension");
      if (!(paramContext.getEntryObject() instanceof TBSOneRuntimeExtension)) {
        throw new TBSOneException(504, "Failed to cast the entry object of runtime extension");
      }
    }
    catch (TBSOneException paramContext)
    {
      throw new TBSOneException(503, "Failed to load runtime extension, caused by: [" + paramContext.getErrorCode() + "] " + paramContext.getMessage(), paramContext.getCause());
    }
    return (TBSOneRuntimeExtension)paramContext.getEntryObject();
  }
  
  public static void preloadRuntimeExtension(Context paramContext, String paramString)
  {
    TBSOneManager.getInstance(paramContext, paramString).loadComponentAsync("extension", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.CommonUtils
 * JD-Core Version:    0.7.0.1
 */