package com.tencent.mobileqq.vas;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;

public class ApngQueuePlayer
  extends URLDrawableHelper.Adapter
{
  private static ColorDrawable c = new ColorDrawable(0);
  ApngQueuePlayer.RepeatListener a = new ApngQueuePlayer.RepeatListener(this);
  URLDrawableDownListener.Adapter b = new ApngQueuePlayer.1(this);
  private boolean d = true;
  private ImageView e;
  private ArrayDeque<ApngQueuePlayer.DrawableBuilder> f = new ArrayDeque();
  
  public ApngQueuePlayer(ImageView paramImageView)
  {
    this.e = paramImageView;
    if ((paramImageView instanceof URLImageView)) {
      ((URLImageView)paramImageView).setURLDrawableDownListener(this.b);
    }
  }
  
  private void b()
  {
    Object localObject = (ApngQueuePlayer.DrawableBuilder)this.f.poll();
    if (localObject == null)
    {
      this.d = true;
      return;
    }
    this.d = false;
    localObject = ((ApngQueuePlayer.DrawableBuilder)localObject).a(c());
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      b();
      return;
    }
    this.e.setImageDrawable((Drawable)localObject);
    if (!(this.e instanceof URLImageView)) {
      ((URLDrawable)localObject).setURLDrawableListener(this);
    }
  }
  
  private Drawable c()
  {
    Object localObject = c;
    Drawable localDrawable = this.e.getDrawable();
    if (localDrawable != null)
    {
      if ((localDrawable instanceof URLDrawable)) {
        return ((URLDrawable)localDrawable).getCurrDrawable();
      }
      localObject = localDrawable;
    }
    return localObject;
  }
  
  public void a()
  {
    this.f.clear();
    this.e.setImageDrawable(null);
    this.d = true;
  }
  
  public void a(ApngQueuePlayer.DrawableBuilder paramDrawableBuilder)
  {
    this.f.add(paramDrawableBuilder);
    if (this.d) {
      b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    a(new ApngQueuePlayer.LocalDrawableBuilder(paramString, paramInt));
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("ApngQueuePlayer", 1, "onLoadFialed: ", paramThrowable);
    b();
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage();
    if (paramURLDrawable.mFrameCount <= 1)
    {
      b();
      return;
    }
    if ((paramURLDrawable.apngLoop > 0) && (paramURLDrawable.currentApngLoop >= paramURLDrawable.apngLoop)) {
      paramURLDrawable.replay();
    }
    if (paramURLDrawable.apngLoop != 0)
    {
      this.a.a(paramURLDrawable);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ApngQueuePlayer
 * JD-Core Version:    0.7.0.1
 */