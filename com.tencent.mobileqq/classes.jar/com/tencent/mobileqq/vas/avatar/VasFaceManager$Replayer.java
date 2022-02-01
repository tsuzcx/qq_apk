package com.tencent.mobileqq.vas.avatar;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VasFaceManager$Replayer
  implements ApngDrawable.OnPlayRepeatListener, Runnable
{
  public WeakReference<ApngImage> a;
  private long b;
  private long c;
  private Handler d;
  private boolean e;
  private String f;
  
  public VasFaceManager$Replayer(String paramString, ApngDrawable paramApngDrawable, Handler paramHandler)
  {
    this.a = new WeakReference(paramApngDrawable.getImage());
    this.d = paramHandler;
    paramApngDrawable.setOnPlayRepeatListener(this);
    this.f = paramString;
  }
  
  public void a()
  {
    if (this.e)
    {
      long l = SystemClock.uptimeMillis();
      this.c += l - this.b;
      this.d.removeCallbacks(this);
    }
  }
  
  public void b()
  {
    if (this.e)
    {
      this.b = SystemClock.uptimeMillis();
      long l = this.c;
      if (l >= 5000L)
      {
        this.d.post(this);
        return;
      }
      this.d.postDelayed(this, 5000L - l);
    }
  }
  
  public void c()
  {
    this.d.post(this);
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt == 3)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPlayRepeat: ");
        localStringBuilder.append(this.f);
        localStringBuilder.append(" image: ");
        localStringBuilder.append(this.a.get());
        QLog.e("Q.qqhead.VasFaceManager", 1, localStringBuilder.toString());
      }
      this.b = SystemClock.uptimeMillis();
      this.c = 0L;
      this.e = true;
      this.d.postDelayed(this, 5000L);
    }
  }
  
  public void run()
  {
    this.e = false;
    this.d.removeCallbacks(this);
    ApngImage localApngImage = (ApngImage)this.a.get();
    if (localApngImage != null)
    {
      localApngImage.replay();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("replay ");
        localStringBuilder.append(localApngImage);
        localStringBuilder.append(" in ");
        localStringBuilder.append(this);
        QLog.i("Q.qqhead.VasFaceManager", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager.Replayer
 * JD-Core Version:    0.7.0.1
 */