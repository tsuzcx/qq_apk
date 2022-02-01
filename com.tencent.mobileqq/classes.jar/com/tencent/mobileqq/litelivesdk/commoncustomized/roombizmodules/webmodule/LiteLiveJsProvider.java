package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.LiteJsModuleProvider;
import java.util.Map;

public class LiteLiveJsProvider
{
  private LiteJsModuleProvider mLiteJsModuleProvider = new LiteJsModuleProvider();
  
  public boolean callFunction(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return this.mLiteJsModuleProvider.callFunction(paramString1, paramString2, paramMap);
  }
  
  public void registerJsModule(BaseLiteJSModule paramBaseLiteJSModule)
  {
    if (paramBaseLiteJSModule == null) {
      return;
    }
    this.mLiteJsModuleProvider.registerJsModule(paramBaseLiteJSModule);
  }
  
  public void removeAllJsModule()
  {
    this.mLiteJsModuleProvider.removeAllJsModule();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider
 * JD-Core Version:    0.7.0.1
 */