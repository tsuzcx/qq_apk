package com.tencent.mobileqq.triton.bridge;

import android.content.Context;
import com.tencent.mobileqq.triton.bridge.d.a;
import com.tencent.mobileqq.triton.bridge.d.c;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSPlugin;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b
  implements IJSEngine, GameLifecycle
{
  private List<? extends c> a;
  private TTEngine b;
  
  public b(TTEngine paramTTEngine)
  {
    this.b = paramTTEngine;
    this.a = Arrays.asList(new c[] { new com.tencent.mobileqq.triton.bridge.d.b(paramTTEngine), new a(paramTTEngine) });
  }
  
  public <T extends c> T a(Class<T> paramClass)
  {
    if (paramClass != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (paramClass.isInstance(localc)) {
          return localc;
        }
      }
    }
    return null;
  }
  
  public boolean canHandleEvent(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((ITTJSPlugin)localIterator.next()).getEventMap().contains(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    return this.b.getJsRuntime(paramInt);
  }
  
  public void onCreate(Context paramContext, ITTEngine paramITTEngine)
  {
    paramITTEngine = this.a.iterator();
    while (paramITTEngine.hasNext()) {
      ((c)paramITTEngine.next()).onCreate(paramContext, this.b);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).onDestroy();
    }
  }
  
  public void onGameLaunched() {}
  
  public void onPause()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).b();
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).c();
    }
  }
  
  public String onScriptCall(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.b
 * JD-Core Version:    0.7.0.1
 */