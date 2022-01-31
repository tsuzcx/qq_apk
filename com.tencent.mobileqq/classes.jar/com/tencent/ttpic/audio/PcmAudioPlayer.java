package com.tencent.ttpic.audio;

import android.media.AudioTrack;
import android.util.Log;

public class PcmAudioPlayer
{
  private static final int DEFAULT_AUDIO_FORMAT = 2;
  private static final int DEFAULT_CHANNEL_CONFIG = 4;
  private static final int DEFAULT_PLAY_MODE = 1;
  private static final int DEFAULT_SAMPLE_RATE = 44100;
  private static final int DEFAULT_STREAM_TYPE = 3;
  private static final String TAG = PcmAudioPlayer.class.getSimpleName();
  private AudioTrack mAudioTrack;
  private volatile boolean mIsPlayStarted = false;
  
  public boolean play(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.mIsPlayStarted)
    {
      Log.e(TAG, "Player not started !");
      return false;
    }
    if (this.mAudioTrack.write(paramArrayOfByte, paramInt1, paramInt2) != paramInt2) {
      Log.e(TAG, "Could not write all the samples to the audio device !");
    }
    this.mAudioTrack.play();
    Log.d(TAG, "OK, Played " + paramInt2 + " bytes !");
    return true;
  }
  
  public boolean startPlayer()
  {
    return startPlayer(3, 44100, 4, 2);
  }
  
  public boolean startPlayer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mIsPlayStarted)
    {
      Log.e(TAG, "Player already started !");
      return false;
    }
    int i = AudioTrack.getMinBufferSize(paramInt2, paramInt3, paramInt4);
    if (i == -2)
    {
      Log.e(TAG, "Invalid parameter !");
      return false;
    }
    Log.i(TAG, "getMinBufferSize = " + i + " bytes !");
    this.mAudioTrack = new AudioTrack(paramInt1, paramInt2, paramInt3, paramInt4, i, 1);
    if (this.mAudioTrack.getState() == 0)
    {
      Log.e(TAG, "AudioTrack initialize fail !");
      return false;
    }
    this.mIsPlayStarted = true;
    Log.i(TAG, "Start audio player success !");
    return true;
  }
  
  public void stopPlayer()
  {
    if (!this.mIsPlayStarted) {
      return;
    }
    if (this.mAudioTrack.getPlayState() == 3) {
      this.mAudioTrack.stop();
    }
    this.mAudioTrack.release();
    this.mIsPlayStarted = false;
    Log.i(TAG, "Stop audio player success !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.audio.PcmAudioPlayer
 * JD-Core Version:    0.7.0.1
 */