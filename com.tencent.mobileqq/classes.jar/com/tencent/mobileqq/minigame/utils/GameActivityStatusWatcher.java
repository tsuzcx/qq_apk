package com.tencent.mobileqq.minigame.utils;

import android.content.Context;
import android.content.IntentFilter;

public class GameActivityStatusWatcher
{
  static final String TAG = "GameActivityStatusWatcher";
  private Context mContext;
  private IntentFilter mFilter;
  private GameActivityStatusWatcher.OnWatcherActionListener mListener;
  private GameActivityStatusWatcher.InnerRecevier mRecevier;
  
  public GameActivityStatusWatcher(Context paramContext)
  {
    this.mContext = paramContext;
    this.mFilter = new IntentFilter();
    this.mFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.mFilter.addAction("action.qq.miniapp.show.monitorview");
    this.mFilter.addAction("android.intent.action.SCREEN_OFF");
  }
  
  public void setOnHomePressedListener(GameActivityStatusWatcher.OnWatcherActionListener paramOnWatcherActionListener)
  {
    this.mListener = paramOnWatcherActionListener;
    this.mRecevier = new GameActivityStatusWatcher.InnerRecevier(this);
  }
  
  public void startWatch()
  {
    if (this.mRecevier != null) {
      this.mContext.registerReceiver(this.mRecevier, this.mFilter);
    }
  }
  
  public void stopWatch()
  {
    if (this.mRecevier != null) {
      this.mContext.unregisterReceiver(this.mRecevier);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.GameActivityStatusWatcher
 * JD-Core Version:    0.7.0.1
 */