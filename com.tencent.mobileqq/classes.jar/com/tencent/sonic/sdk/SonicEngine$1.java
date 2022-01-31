package com.tencent.sonic.sdk;

import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

class SonicEngine$1
  implements SonicSession.Callback
{
  SonicEngine$1(SonicEngine paramSonicEngine) {}
  
  public void onSessionStateChange(SonicSession paramSonicSession, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    SonicUtils.log("SonicSdk_SonicEngine", 3, "onSessionStateChange:session(" + paramSonicSession.sId + ") from state " + paramInt1 + " -> " + paramInt2);
    switch (paramInt2)
    {
    case 2: 
    default: 
      return;
    case 1: 
      SonicEngine.access$000(this.this$0).put(paramSonicSession.id, paramSonicSession);
      return;
    }
    SonicEngine.access$000(this.this$0).remove(paramSonicSession.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicEngine.1
 * JD-Core Version:    0.7.0.1
 */