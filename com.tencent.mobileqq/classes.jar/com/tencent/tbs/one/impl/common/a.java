package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;

public final class a
{
  public static TBSOneRuntimeExtension a(Context paramContext, String paramString)
  {
    TBSOneManager localTBSOneManager = TBSOneManager.getInstance(paramContext, paramString);
    paramString = localTBSOneManager.getLoadedComponent("extension");
    paramContext = paramString;
    if (paramString == null) {
      try
      {
        paramContext = localTBSOneManager.loadComponentSync("extension", 30000L);
      }
      catch (TBSOneException paramContext)
      {
        paramString = new StringBuilder("Failed to load runtime extension, error: [");
        paramString.append(paramContext.getErrorCode());
        paramString.append("] ");
        paramString.append(paramContext.getMessage());
        throw new TBSOneException(503, paramString.toString(), paramContext.getCause());
      }
    }
    if ((paramContext.getEntryObject() instanceof TBSOneRuntimeExtension)) {
      return (TBSOneRuntimeExtension)paramContext.getEntryObject();
    }
    throw new TBSOneException(504, "Failed to cast the entry object of runtime extension");
  }
  
  public static void a(Context paramContext, TBSOneCallback<TBSOneDebugPlugin> paramTBSOneCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_ignore_flow_control", true);
    localBundle.putBoolean("is_ignore_wifi_state", true);
    TBSOneManager.getInstance(paramContext, "debug").loadComponentAsync("debugger", localBundle, new a.1(paramTBSOneCallback));
  }
  
  public static TBSOneRuntimeExtension b(Context paramContext, String paramString)
  {
    paramContext = TBSOneManager.getInstance(paramContext, paramString).getLoadedComponent("extension");
    if ((paramContext != null) && ((paramContext.getEntryObject() instanceof TBSOneRuntimeExtension))) {
      return (TBSOneRuntimeExtension)paramContext.getEntryObject();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.a
 * JD-Core Version:    0.7.0.1
 */