package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.process.audio.ICmGameAudioPlayer;
import java.lang.ref.WeakReference;

class ApolloCmdChannel$PlayMusicTask
  implements Runnable
{
  private final String a;
  private final int b;
  private final int c;
  private final long d;
  private final float e;
  private final int f;
  private int g;
  private WeakReference<IRenderRunner> h;
  private WeakReference<ICmGameAudioPlayer> i;
  private WeakReference<ApolloCmdChannel> j;
  
  ApolloCmdChannel$PlayMusicTask(int paramInt1, ApolloCmdChannel paramApolloCmdChannel, IRenderRunner paramIRenderRunner, ICmGameAudioPlayer paramICmGameAudioPlayer, long paramLong, int paramInt2, int paramInt3, String paramString, float paramFloat, int paramInt4)
  {
    this.j = new WeakReference(paramApolloCmdChannel);
    this.h = new WeakReference(paramIRenderRunner);
    this.i = new WeakReference(paramICmGameAudioPlayer);
    this.b = paramInt2;
    this.c = paramInt3;
    this.a = paramString;
    this.d = paramLong;
    this.g = paramInt1;
    this.f = paramInt4;
    this.e = paramFloat;
  }
  
  public void run()
  {
    ApolloCmdChannel localApolloCmdChannel = (ApolloCmdChannel)this.j.get();
    IRenderRunner localIRenderRunner = (IRenderRunner)this.h.get();
    ICmGameAudioPlayer localICmGameAudioPlayer = (ICmGameAudioPlayer)this.i.get();
    if ((localApolloCmdChannel != null) && (localICmGameAudioPlayer != null) && (localIRenderRunner != null))
    {
      if (TextUtils.isEmpty(this.a)) {
        return;
      }
      localICmGameAudioPlayer.a(localIRenderRunner, this.b, this.c, this.a, this.d, this.f, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel.PlayMusicTask
 * JD-Core Version:    0.7.0.1
 */