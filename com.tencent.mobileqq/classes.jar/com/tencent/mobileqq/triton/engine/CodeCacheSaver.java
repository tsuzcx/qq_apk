package com.tencent.mobileqq.triton.engine;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;

class CodeCacheSaver
  implements GameLifecycle
{
  private static final long RUN_DURATION_TO_SAVE_CODE_CACHE_MS = 60000L;
  private boolean mGameLaunched;
  private long mLastOnResumeTime = 9223372036854775807L;
  private TTEngine mTritonEngine;
  
  CodeCacheSaver(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void onGameLaunched()
  {
    this.mGameLaunched = true;
    this.mLastOnResumeTime = SystemClock.uptimeMillis();
  }
  
  public void onPause()
  {
    if ((this.mGameLaunched) && (SystemClock.uptimeMillis() - this.mLastOnResumeTime > 60000L)) {
      this.mTritonEngine.saveScriptCodeCache();
    }
  }
  
  public void onResume()
  {
    this.mLastOnResumeTime = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.CodeCacheSaver
 * JD-Core Version:    0.7.0.1
 */