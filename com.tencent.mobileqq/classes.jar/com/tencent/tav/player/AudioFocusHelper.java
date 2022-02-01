package com.tencent.tav.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

public class AudioFocusHelper
{
  private AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
  private AudioManager mAudioManager;
  private Context mContext;
  private boolean mIsAudioFocus;
  private Player mPlayer;
  
  public AudioFocusHelper(Context paramContext, Player paramPlayer)
  {
    this.mContext = paramContext;
    this.mPlayer = paramPlayer;
  }
  
  private void ensureAudioManager()
  {
    if (this.mAudioManager == null) {
      this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    }
  }
  
  private AudioManager.OnAudioFocusChangeListener getAudioFocusChangeListener()
  {
    if (this.mAudioFocusListener == null) {
      this.mAudioFocusListener = new AudioFocusHelper.1(this);
    }
    return this.mAudioFocusListener;
  }
  
  private void onAudioFocusLoss(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
      this.mIsAudioFocus = false;
    }
    Player localPlayer = this.mPlayer;
    if ((localPlayer != null) && (localPlayer.isPlaying())) {
      this.mPlayer.pause();
    }
  }
  
  public void release()
  {
    AudioManager localAudioManager = this.mAudioManager;
    if (localAudioManager != null)
    {
      localAudioManager.abandonAudioFocus(this.mAudioFocusListener);
      this.mAudioManager = null;
      this.mAudioFocusListener = null;
      this.mIsAudioFocus = false;
    }
    if (this.mPlayer != null) {
      this.mPlayer = null;
    }
  }
  
  public void requestFocus()
  {
    ensureAudioManager();
    if (!this.mIsAudioFocus)
    {
      AudioManager localAudioManager = this.mAudioManager;
      AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = getAudioFocusChangeListener();
      boolean bool = true;
      if (localAudioManager.requestAudioFocus(localOnAudioFocusChangeListener, 3, 1) != 1) {
        bool = false;
      }
      this.mIsAudioFocus = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.AudioFocusHelper
 * JD-Core Version:    0.7.0.1
 */