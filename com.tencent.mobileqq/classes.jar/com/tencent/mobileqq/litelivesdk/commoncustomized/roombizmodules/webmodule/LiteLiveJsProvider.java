package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.LiteJsModuleProvider;
import java.util.Map;

public class LiteLiveJsProvider
{
  private LiteJsModuleProvider a = new LiteJsModuleProvider();
  
  public void a()
  {
    this.a.removeAllJsModule();
  }
  
  public void a(BaseLiteJSModule paramBaseLiteJSModule)
  {
    if (paramBaseLiteJSModule == null) {
      return;
    }
    this.a.registerJsModule(paramBaseLiteJSModule);
  }
  
  public boolean a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return this.a.callFunction(paramString1, paramString2, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider
 * JD-Core Version:    0.7.0.1
 */