package com.tencent.mtt.hippy.modules.nativemodules.clipboard;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="ClipboardModule")
public class ClipboardModule
  extends HippyNativeModuleBase
{
  private ClipboardManager a = null;
  
  public ClipboardModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private ClipboardManager a()
  {
    return this.a;
  }
  
  @HippyMethod(name="getString")
  public void getString(Promise paramPromise)
  {
    try
    {
      Object localObject1 = a();
      ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject1);
      Object localObject2 = ((ClipboardManager)localObject1).getPrimaryClip();
      if ((localObject2 != null) && (((ClipData)localObject2).getItemCount() >= 1))
      {
        ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject1);
        localObject1 = ((ClipboardManager)localObject1).getPrimaryClip().getItemAt(0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((ClipData.Item)localObject1).getText());
        paramPromise.resolve(((StringBuilder)localObject2).toString());
        return;
      }
      paramPromise.resolve("");
      return;
    }
    catch (Exception localException)
    {
      paramPromise.reject(localException);
    }
  }
  
  @HippyMethod(name="setString")
  public void setString(String paramString)
  {
    paramString = ClipData.newPlainText(null, paramString);
    ClipboardManager localClipboardManager = a();
    ClipboardMonitor.setPrimaryClip(localClipboardManager, paramString);
    localClipboardManager.setPrimaryClip(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.clipboard.ClipboardModule
 * JD-Core Version:    0.7.0.1
 */