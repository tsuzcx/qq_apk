package com.tencent.mobileqq.guild.util.urldrawable;

import android.graphics.drawable.Drawable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class GuildLiveDataURLDrawableListener
  implements URLDrawable.URLDrawableListener
{
  private final WeakReference<MutableLiveData<Drawable>> a;
  private final int b;
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QGL.GuildLiveURLDrawableListener", 1, "avatarBg onLoadCanceled.");
    }
    if (this.a.get() != null) {
      ((MutableLiveData)this.a.get()).setValue(null);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable == null) {
        paramURLDrawable = "null";
      } else {
        paramURLDrawable = paramThrowable.getMessage();
      }
      paramThrowable = new StringBuilder();
      paramThrowable.append("avatarBg onLoadFialed:");
      paramThrowable.append(paramURLDrawable);
      QLog.e("QGL.GuildLiveURLDrawableListener", 1, paramThrowable.toString());
    }
    if (this.a.get() != null) {
      ((MutableLiveData)this.a.get()).setValue(null);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("avatarBg onLoadProgressed, ");
      paramURLDrawable.append(paramInt);
      QLog.i("QGL.GuildLiveURLDrawableListener", 1, paramURLDrawable.toString());
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QGL.GuildLiveURLDrawableListener", 1, "avatarBg onLoadSuccessed.");
    }
    paramURLDrawable.setAlpha(this.b);
    if (this.a.get() != null) {
      ((MutableLiveData)this.a.get()).setValue(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.urldrawable.GuildLiveDataURLDrawableListener
 * JD-Core Version:    0.7.0.1
 */