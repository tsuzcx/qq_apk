package com.tencent.mobileqq.triton.sdk.game;

import android.content.Context;

public abstract interface GameLifecycle
{
  public abstract void onCreate(Context paramContext);
  
  public abstract void onDestroy();
  
  public abstract void onGameLaunched();
  
  public abstract void onPause();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.game.GameLifecycle
 * JD-Core Version:    0.7.0.1
 */