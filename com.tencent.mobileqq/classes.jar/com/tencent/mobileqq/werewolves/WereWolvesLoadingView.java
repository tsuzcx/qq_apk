package com.tencent.mobileqq.werewolves;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class WereWolvesLoadingView
  extends FrameLayout
{
  View a;
  int b;
  public TextView c = null;
  public View d;
  TextView e;
  boolean f;
  WereWolvesLoadingView.LoadingCallback g;
  Handler h = new Handler(Looper.getMainLooper());
  int i = 0;
  Runnable j = new WereWolvesLoadingView.1(this);
  Runnable k = new WereWolvesLoadingView.2(this);
  boolean l = false;
  
  public WereWolvesLoadingView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WereWolvesLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  void a()
  {
    this.d = LayoutInflater.from(getContext()).inflate(2131625507, this);
    this.b = findViewById(2131440740).getLayoutParams().width;
    this.a = findViewById(2131440737);
    this.e = ((TextView)findViewById(2131440768));
    setProgress(0);
    this.c = ((TextView)findViewById(2131447419));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.d.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void b()
  {
    this.l = false;
    this.h.postDelayed(this.k, 10L);
  }
  
  public void c()
  {
    this.l = true;
  }
  
  public void setComplete(WereWolvesLoadingView.LoadingCallback paramLoadingCallback)
  {
    this.l = true;
    this.h.removeCallbacks(this.k);
    this.g = paramLoadingCallback;
    this.h.post(this.j);
  }
  
  public void setProgress(int paramInt)
  {
    int m;
    if (paramInt < 0)
    {
      m = 0;
    }
    else
    {
      m = paramInt;
      if (paramInt > 100) {
        m = 100;
      }
    }
    paramInt = this.b * m / 100;
    Object localObject;
    if (paramInt != 0)
    {
      localObject = this.a.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = paramInt;
      this.a.setVisibility(0);
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      this.a.setVisibility(8);
    }
    this.i = m;
    this.e.setText(String.format("%d%%", new Object[] { Integer.valueOf(m) }));
    if (this.i >= 100)
    {
      localObject = this.g;
      if ((localObject != null) && (!this.f))
      {
        ((WereWolvesLoadingView.LoadingCallback)localObject).a();
        this.f = true;
      }
    }
    else
    {
      this.f = false;
    }
  }
  
  public void setTips(String paramString)
  {
    this.c.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView
 * JD-Core Version:    0.7.0.1
 */