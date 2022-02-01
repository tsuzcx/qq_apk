package com.tencent.mobileqq.qqexpand.widget.voice;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

@Deprecated
public class FrameAnimationDrawable
  extends Drawable
  implements Handler.Callback
{
  private final Paint a = new Paint(1);
  private final Handler b;
  private Bitmap c;
  private Rect d;
  private String[] e;
  private long f = 1000L;
  private boolean g;
  private int h;
  private int i;
  private long j;
  private volatile boolean k;
  
  public FrameAnimationDrawable()
  {
    this.a.setAntiAlias(true);
    this.b = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void c()
  {
    int m = this.h;
    if ((m >= 0) && (m < this.i))
    {
      Object localObject = this.e[m];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = ExpandResourceUtil.a((String)localObject, localOptions);
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
          {
            this.c = ((Bitmap)localObject);
            ThreadManager.getUIHandler().post(new FrameAnimationDrawable.1(this));
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.e("FrameAnimationDrawable", 2, "updateCurBitmap fail.", localException);
        }
      }
    }
  }
  
  public void a()
  {
    if (!this.k)
    {
      this.k = true;
      this.b.removeMessages(10);
      this.b.sendEmptyMessage(10);
    }
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
    String[] arrayOfString = this.e;
    if (arrayOfString == null) {
      m = 0;
    } else {
      m = arrayOfString.length;
    }
    this.i = m;
    int m = this.i;
    if (m == 0) {
      paramLong = 0L;
    } else {
      paramLong = this.f / m;
    }
    this.j = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    b();
    this.e = paramArrayOfString;
    int m = 0;
    this.h = 0;
    paramArrayOfString = this.e;
    if (paramArrayOfString != null) {
      m = paramArrayOfString.length;
    }
    this.i = m;
    m = this.i;
    long l;
    if (m == 0) {
      l = 0L;
    } else {
      l = this.f / m;
    }
    this.j = l;
    c();
  }
  
  public void b()
  {
    if (this.k)
    {
      this.k = false;
      this.b.removeMessages(10);
      this.h = 0;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (paramCanvas != null)
    {
      Bitmap localBitmap = this.c;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        if (this.d == null) {
          this.d = new Rect();
        }
        this.d.set(0, 0, this.c.getWidth(), this.c.getHeight());
        paramCanvas.drawBitmap(this.c, this.d, getBounds(), this.a);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10) {
      return true;
    }
    this.h += 1;
    if (this.g) {
      this.h %= this.i;
    }
    int m = this.h;
    if ((m >= 0) && (m < this.i))
    {
      long l1 = System.currentTimeMillis();
      c();
      if (this.k)
      {
        long l2 = System.currentTimeMillis();
        l1 = Math.max(this.j - (l2 - l1), 0L);
        this.b.sendEmptyMessageDelayed(10, l1);
        return true;
      }
    }
    else
    {
      this.k = false;
    }
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.FrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */