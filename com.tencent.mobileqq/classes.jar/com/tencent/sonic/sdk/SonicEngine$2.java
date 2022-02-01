package com.tencent.sonic.sdk;

import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

class SonicEngine$2
  implements SonicSession.Callback
{
  SonicEngine$2(SonicEngine paramSonicEngine) {}
  
  public void onSessionStateChange(SonicSession paramSonicSession, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onSessionStateChange:session(");
    paramBundle.append(paramSonicSession.sId);
    paramBundle.append(") from state ");
    paramBundle.append(paramInt1);
    paramBundle.append(" -> ");
    paramBundle.append(paramInt2);
    SonicUtils.log("SonicSdk_SonicEngine", 3, paramBundle.toString());
    if (paramInt2 != 1)
    {
      if (paramInt2 != 3) {
        return;
      }
      SonicEngine.access$000(this.this$0).remove(paramSonicSession.id);
      return;
    }
    SonicEngine.access$000(this.this$0).put(paramSonicSession.id, paramSonicSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicEngine.2
 * JD-Core Version:    0.7.0.1
 */