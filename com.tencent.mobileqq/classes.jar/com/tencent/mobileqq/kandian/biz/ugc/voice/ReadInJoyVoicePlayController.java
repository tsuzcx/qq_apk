package com.tencent.mobileqq.kandian.biz.ugc.voice;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.repo.handler.UGCVoiceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class ReadInJoyVoicePlayController
{
  public static final String a = "ReadInJoyVoicePlayController";
  private static ReadInJoyVoicePlayController b;
  private MediaPlayer c;
  private AudioManager d = (AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio");
  private WeakReference<ReadInJoyVoicePlayController.IPlayCallback> e;
  private UGCVoiceInfo f;
  private boolean g = false;
  private Handler h = new Handler(Looper.getMainLooper());
  private Runnable i = new ReadInJoyVoicePlayController.3(this);
  
  public static ReadInJoyVoicePlayController a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new ReadInJoyVoicePlayController();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(ReadInJoyVoicePlayController.IPlayCallback paramIPlayCallback, UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (this.c == null) {
      this.c = new MediaPlayer();
    }
    b();
    this.c.reset();
    this.e = new WeakReference(paramIPlayCallback);
    this.f = paramUGCVoiceInfo;
    this.c.setOnPreparedListener(new ReadInJoyVoicePlayController.1(this));
    this.c.setOnCompletionListener(new ReadInJoyVoicePlayController.2(this));
    try
    {
      this.c.setDataSource(paramUGCVoiceInfo.voiceUrl);
      this.c.prepareAsync();
      return;
    }
    catch (IOException paramIPlayCallback)
    {
      paramIPlayCallback.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      this.g = paramBoolean;
      if ((this.h != null) && (this.i != null))
      {
        if (QLog.isColorLevel())
        {
          String str = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestOrAbandonAudioFocus isFocus:");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(" ;what:");
          localStringBuilder.append(paramString);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.h.removeCallbacks(this.i);
        if (this.g) {
          this.h.post(this.i);
        } else {
          this.h.postDelayed(this.i, 2000L);
        }
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    MediaPlayer localMediaPlayer = this.c;
    if (localMediaPlayer != null)
    {
      try
      {
        localMediaPlayer.stop();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject = this.f;
      if (localObject != null)
      {
        ((UGCVoiceInfo)localObject).isPlaying = false;
        localObject = this.e;
        if (localObject != null)
        {
          localObject = (ReadInJoyVoicePlayController.IPlayCallback)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((ReadInJoyVoicePlayController.IPlayCallback)localObject).b(this.f);
            a(false, "ugc voice play");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController
 * JD-Core Version:    0.7.0.1
 */