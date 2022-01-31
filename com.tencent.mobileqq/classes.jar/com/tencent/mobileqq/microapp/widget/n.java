package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.qphone.base.util.QLog;

public final class n
{
  View a;
  ViewGroup b;
  Handler c = new Handler();
  Runnable d = new o(this);
  private Resources e;
  private LayoutInflater f;
  private Drawable g = null;
  private CharSequence h = null;
  private int i = 1500;
  
  public n(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext.getApplicationContext();
    this.e = paramContext.getResources();
    this.f = LayoutInflater.from(paramContext);
    this.b = paramViewGroup;
  }
  
  private int a(String paramString)
  {
    int j = 0;
    if ("success".equals(paramString)) {
      j = R.drawable.c;
    }
    do
    {
      return j;
      if ("warn".equals(paramString)) {
        return R.drawable.d;
      }
      if ("loading".equals(paramString)) {
        return R.drawable.t;
      }
    } while (!"none".equals(paramString));
    return 0;
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 0) {
      a(this.e.getDrawable(paramInt));
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    this.g = paramDrawable;
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.h = paramCharSequence;
  }
  
  private void a(boolean paramBoolean)
  {
    this.a = this.f.inflate(R.layout.i, null);
    this.a.setClickable(paramBoolean);
    ImageView localImageView = (ImageView)this.a.findViewById(R.id.ba);
    if (this.g != null)
    {
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(this.g);
    }
    for (;;)
    {
      if (this.h != null) {
        ((TextView)this.a.findViewById(R.id.bb)).setText(this.h);
      }
      return;
      localImageView.setVisibility(8);
    }
  }
  
  private void b()
  {
    QLog.d("ToastView", 4, "show mParentView=" + this.b + ",toastLayout=" + this.a);
    if ((this.b != null) && (this.a != null))
    {
      this.b.addView(this.a, new ViewGroup.LayoutParams(-1, -1));
      if (this.i > -1) {
        this.c.postDelayed(this.d, this.i);
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a()
  {
    this.c.removeCallbacks(this.d);
    QLog.d("ToastView", 4, "hide mParentView=" + this.b + ",toastLayout=" + this.a);
    if ((this.b != null) && (this.a != null)) {
      this.b.removeView(this.a);
    }
  }
  
  public void a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    QLog.d("ToastView", 4, "show iconType=" + paramString1 + ",localIconPath=" + paramString2 + ",msg=" + paramCharSequence + ",duration=" + paramInt + ",mask=" + paramBoolean);
    if (!TextUtils.isEmpty(paramString2)) {
      a(new BitmapDrawable(paramString2));
    }
    for (;;)
    {
      a(paramCharSequence);
      b(paramInt);
      a();
      a(paramBoolean);
      b();
      return;
      a(a(paramString1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.n
 * JD-Core Version:    0.7.0.1
 */