package com.tencent.qqmini.minigame.utils;

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
    GameActivityStatusWatcher.InnerRecevier localInnerRecevier = this.mRecevier;
    if (localInnerRecevier != null) {
      this.mContext.registerReceiver(localInnerRecevier, this.mFilter);
    }
  }
  
  public void stopWatch()
  {
    GameActivityStatusWatcher.InnerRecevier localInnerRecevier = this.mRecevier;
    if (localInnerRecevier != null) {
      this.mContext.unregisterReceiver(localInnerRecevier);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher
 * JD-Core Version:    0.7.0.1
 */