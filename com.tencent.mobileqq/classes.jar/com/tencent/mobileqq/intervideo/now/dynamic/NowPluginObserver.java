package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import android.view.View;

public abstract interface NowPluginObserver
{
  public abstract void onCloseLoadingView();
  
  public abstract void onEnterAvPlugin(Bundle paramBundle);
  
  public abstract void onEnterRoom(Bundle paramBundle);
  
  public abstract void onExitRoom(Bundle paramBundle);
  
  public abstract void onLoadingViewCreated(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowPluginObserver
 * JD-Core Version:    0.7.0.1
 */