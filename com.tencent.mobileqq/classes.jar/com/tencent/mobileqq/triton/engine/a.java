package com.tencent.mobileqq.triton.engine;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;

class a
  implements GameLifecycle
{
  private TTEngine a;
  private long b = 9223372036854775807L;
  private boolean c;
  
  a(TTEngine paramTTEngine)
  {
    this.a = paramTTEngine;
  }
  
  public void onCreate(Context paramContext, ITTEngine paramITTEngine) {}
  
  public void onDestroy() {}
  
  public void onGameLaunched()
  {
    this.c = true;
    this.b = SystemClock.uptimeMillis();
  }
  
  public void onPause()
  {
    if ((this.c) && (SystemClock.uptimeMillis() - this.b > 60000L)) {
      this.a.p();
    }
  }
  
  public void onResume()
  {
    this.b = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.a
 * JD-Core Version:    0.7.0.1
 */