package com.tencent.mobileqq.vastrash;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;

class ColorRingPlayer$8
  implements Runnable
{
  ColorRingPlayer$8(ColorRingPlayer paramColorRingPlayer, String paramString1, String paramString2, long paramLong, int paramInt) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("subAction", this.a);
    localBundle.putString("actionName", this.b);
    localBundle.putLong("id", this.c);
    localBundle.putInt("result", this.d);
    localBundle = DataFactory.a("reportColorRing", "", this.this$0.v.key, localBundle);
    this.this$0.a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer.8
 * JD-Core Version:    0.7.0.1
 */