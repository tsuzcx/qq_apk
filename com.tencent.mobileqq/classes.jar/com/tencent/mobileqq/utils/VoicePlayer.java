package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AmrPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioFileDataListener;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioFilePlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioFilePlayerListener;
import com.tencent.mobileqq.qqaudio.audioplayer.SilkPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer
  implements IAudioFilePlayerListener
{
  private String a;
  private Handler b;
  private IAudioFilePlayer c;
  private int d;
  private int e;
  private ArrayList<VoicePlayer.VoicePlayerListener> f = new ArrayList();
  private boolean g = false;
  private boolean h = false;
  private Context i;
  private Runnable j = new VoicePlayer.1(this);
  
  public VoicePlayer(Context paramContext, int paramInt)
  {
    this.c = new AmrPlayer(paramContext, paramInt);
    this.d = 1;
    this.e = 1;
  }
  
  public VoicePlayer(String paramString, Handler paramHandler)
  {
    this(paramString, paramHandler, 0);
  }
  
  public VoicePlayer(String paramString, Handler paramHandler, int paramInt)
  {
    this.a = paramString;
    this.b = paramHandler;
    if (paramInt == 0)
    {
      this.c = new AmrPlayer();
      this.e = 2;
    }
    else
    {
      this.c = new SilkPlayer();
      this.e = 3;
    }
    this.d = 1;
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = this.h;
    int k = 0;
    int m = 0;
    if (bool) {
      QQAudioUtils.a(this.i, false);
    }
    if (paramBoolean) {
      this.d = 8;
    } else {
      this.d = 4;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      k = m;
      if (this.d == 4) {
        k = ((IAudioFilePlayer)localObject).i();
      }
      this.c.e();
      this.c = null;
    }
    localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VoicePlayer.VoicePlayerListener)((Iterator)localObject).next()).a(this.d, this.a, k);
    }
  }
  
  private int i()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.c;
    if (localIAudioFilePlayer != null) {
      return localIAudioFilePlayer.h();
    }
    return 0;
  }
  
  private int k()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.c;
    if (localIAudioFilePlayer != null) {
      return localIAudioFilePlayer.i();
    }
    return 0;
  }
  
  private void l()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCompletion duration=");
      ((StringBuilder)localObject).append(k());
      ((StringBuilder)localObject).append(" current=");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append(" enableEndBuffer=");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(" thread=");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      QLog.d("Q.profilecard.VoicePlayer", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g)
    {
      localObject = this.b;
      if (localObject != null)
      {
        this.d = 7;
        ((Handler)localObject).postDelayed(new VoicePlayer.2(this), 500L);
        return;
      }
      a(false);
      return;
    }
    a(false);
  }
  
  public void a()
  {
    l();
  }
  
  public void a(int paramInt)
  {
    this.c.b(paramInt);
  }
  
  public void a(IAudioFileDataListener paramIAudioFileDataListener)
  {
    if (b()) {
      ((SilkPlayer)this.c).a(paramIAudioFileDataListener);
    }
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramIAudioFilePlayer = new StringBuilder();
      paramIAudioFilePlayer.append("onError what=");
      paramIAudioFilePlayer.append(paramInt1);
      paramIAudioFilePlayer.append(" extra=");
      paramIAudioFilePlayer.append(paramInt2);
      QLog.d("Q.profilecard.VoicePlayer", 2, paramIAudioFilePlayer.toString());
    }
    a(true);
  }
  
  public void a(VoicePlayer.VoicePlayerListener paramVoicePlayerListener)
  {
    if (!this.f.contains(paramVoicePlayerListener)) {
      this.f.add(paramVoicePlayerListener);
    }
  }
  
  public boolean a(Context paramContext)
  {
    this.i = paramContext;
    if (this.i != null) {
      this.h = true;
    }
    return this.h;
  }
  
  public void b(int paramInt) {}
  
  public boolean b()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.c;
    return (localIAudioFilePlayer != null) && ((localIAudioFilePlayer instanceof SilkPlayer));
  }
  
  public void c()
  {
    int k = this.d;
    if (k == 1)
    {
      try
      {
        this.d = 2;
        if (this.e != 1)
        {
          this.c.a(this.a);
          this.c.j();
        }
        this.c.a(this);
        this.c.a();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a(true);
      }
      if (this.h) {
        QQAudioUtils.a(this.i, true);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start to play...  for test time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Q.profilecard.VoicePlayer", 2, ((StringBuilder)localObject).toString());
    }
    else if (k == 3)
    {
      this.d = 2;
      this.c.a();
      if (this.h) {
        QQAudioUtils.a(this.i, true);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("continue to play... for test time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Q.profilecard.VoicePlayer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((Handler)localObject).post(this.j);
    }
  }
  
  public void d()
  {
    Object localObject = this.c;
    if ((localObject instanceof AmrPlayer))
    {
      this.d = 2;
      ((AmrPlayer)localObject).b();
      if (this.h) {
        QQAudioUtils.a(this.i, true);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("continue to play... for test time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Q.profilecard.VoicePlayer", 2, ((StringBuilder)localObject).toString());
      localObject = this.b;
      if (localObject != null) {
        ((Handler)localObject).post(this.j);
      }
    }
  }
  
  public void e()
  {
    if (this.d == 7) {
      return;
    }
    if (this.h) {
      QQAudioUtils.a(this.i, false);
    }
    this.d = 3;
    this.c.g();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((VoicePlayer.VoicePlayerListener)localIterator.next()).b(this.a, k(), i());
    }
  }
  
  public void f()
  {
    if (this.h) {
      QQAudioUtils.a(this.i, false);
    }
    this.d = 6;
    IAudioFilePlayer localIAudioFilePlayer = this.c;
    if (localIAudioFilePlayer != null)
    {
      localIAudioFilePlayer.c();
      this.c.e();
      this.c = null;
    }
  }
  
  public int g()
  {
    return this.d;
  }
  
  public boolean h()
  {
    if (this.b == null)
    {
      this.g = false;
      return false;
    }
    this.g = true;
    return true;
  }
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer
 * JD-Core Version:    0.7.0.1
 */