package com.tencent.mobileqq.triton.bridge;

import android.content.Context;
import com.tencent.mobileqq.triton.bridge.plugins.AudioPlugin;
import com.tencent.mobileqq.triton.bridge.plugins.FontPlugin;
import com.tencent.mobileqq.triton.bridge.plugins.SystemPlugin;
import com.tencent.mobileqq.triton.bridge.plugins.TTInnerJSAbsPlugin;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSPlugin;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TTJSInnerEngine
  implements IJSEngine, GameLifecycle
{
  private List<? extends TTInnerJSAbsPlugin> PLUGIN_LIST;
  private TTEngine mTritonEngine;
  
  public TTJSInnerEngine(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
    this.PLUGIN_LIST = Arrays.asList(new TTInnerJSAbsPlugin[] { new FontPlugin(paramTTEngine), new SystemPlugin(paramTTEngine), new AudioPlugin(paramTTEngine) });
  }
  
  public boolean canHandleEvent(String paramString)
  {
    Iterator localIterator = this.PLUGIN_LIST.iterator();
    while (localIterator.hasNext()) {
      if (((ITTJSPlugin)localIterator.next()).getEventMap().contains(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    return this.mTritonEngine.getJsRuntime(paramInt);
  }
  
  public <T extends TTInnerJSAbsPlugin> T getPlugin(Class<T> paramClass)
  {
    if (paramClass != null)
    {
      Iterator localIterator = this.PLUGIN_LIST.iterator();
      while (localIterator.hasNext())
      {
        TTInnerJSAbsPlugin localTTInnerJSAbsPlugin = (TTInnerJSAbsPlugin)localIterator.next();
        if (paramClass.isInstance(localTTInnerJSAbsPlugin)) {
          return localTTInnerJSAbsPlugin;
        }
      }
    }
    return null;
  }
  
  public void onCreate(Context paramContext)
  {
    Iterator localIterator = this.PLUGIN_LIST.iterator();
    while (localIterator.hasNext()) {
      ((TTInnerJSAbsPlugin)localIterator.next()).onCreate(paramContext);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.PLUGIN_LIST.iterator();
    while (localIterator.hasNext()) {
      ((TTInnerJSAbsPlugin)localIterator.next()).onDestroy();
    }
  }
  
  public void onGameLaunched() {}
  
  public void onPause()
  {
    Iterator localIterator = this.PLUGIN_LIST.iterator();
    while (localIterator.hasNext()) {
      ((TTInnerJSAbsPlugin)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.PLUGIN_LIST.iterator();
    while (localIterator.hasNext()) {
      ((TTInnerJSAbsPlugin)localIterator.next()).onResume();
    }
  }
  
  public String onScriptCall(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.PLUGIN_LIST.iterator();
    while (localIterator.hasNext())
    {
      ITTJSPlugin localITTJSPlugin = (ITTJSPlugin)localIterator.next();
      if (localITTJSPlugin.getEventMap().contains(paramString1)) {
        return localITTJSPlugin.handleScriptRequest(paramString1, paramString2, paramInt1, getJsRuntime(paramInt2));
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.TTJSInnerEngine
 * JD-Core Version:    0.7.0.1
 */