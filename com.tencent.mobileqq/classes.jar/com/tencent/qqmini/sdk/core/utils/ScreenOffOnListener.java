package com.tencent.qqmini.sdk.core.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;

public class ScreenOffOnListener
{
  private static volatile ScreenOffOnListener instance;
  private final BroadcastReceiver mReceiver = new ScreenOffOnListener.1(this);
  private ScreenOffOnListener.ReceiveListener receiveListener;
  
  public static ScreenOffOnListener getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ScreenOffOnListener();
      }
      return instance;
    }
    finally {}
  }
  
  public void registListener(ScreenOffOnListener.ReceiveListener paramReceiveListener)
  {
    this.receiveListener = paramReceiveListener;
    paramReceiveListener = new IntentFilter();
    paramReceiveListener.addAction("android.intent.action.SCREEN_ON");
    paramReceiveListener.addAction("android.intent.action.SCREEN_OFF");
    AppLoaderFactory.g().getContext().registerReceiver(this.mReceiver, paramReceiveListener);
  }
  
  public void unRegistListener()
  {
    if ((this.mReceiver != null) && (this.receiveListener != null))
    {
      AppLoaderFactory.g().getContext().unregisterReceiver(this.mReceiver);
      this.receiveListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener
 * JD-Core Version:    0.7.0.1
 */