package com.tencent.mtt.hippy.modules.nativemodules.clipboard;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
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
      Object localObject = a();
      ClipData localClipData = ((ClipboardManager)localObject).getPrimaryClip();
      if ((localClipData != null) && (localClipData.getItemCount() >= 1))
      {
        localObject = ((ClipboardManager)localObject).getPrimaryClip().getItemAt(0);
        paramPromise.resolve("" + ((ClipData.Item)localObject).getText());
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
    a().setPrimaryClip(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.clipboard.ClipboardModule
 * JD-Core Version:    0.7.0.1
 */