package com.tencent.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class AutoVerticalScrollTextView
  extends TextSwitcher
  implements Handler.Callback, ViewSwitcher.ViewFactory
{
  private Context a;
  private AutoVerticalScrollTextView.Rotate3dAnimation b;
  private AutoVerticalScrollTextView.Rotate3dAnimation c;
  private int d = 0;
  private long e = 1000L;
  private long f = 800L;
  private String[] g;
  private Handler h;
  
  public AutoVerticalScrollTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoVerticalScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    c();
  }
  
  private AutoVerticalScrollTextView.Rotate3dAnimation a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AutoVerticalScrollTextView.Rotate3dAnimation localRotate3dAnimation = new AutoVerticalScrollTextView.Rotate3dAnimation(this, paramBoolean1, paramBoolean2);
    localRotate3dAnimation.setDuration(this.f);
    localRotate3dAnimation.setFillAfter(false);
    localRotate3dAnimation.setInterpolator(new AccelerateInterpolator());
    return localRotate3dAnimation;
  }
  
  private void c()
  {
    this.h = new Handler(Looper.getMainLooper(), this);
    setFactory(this);
    this.b = a(true, true);
    this.c = a(false, true);
    setInAnimation(this.b);
    setOutAnimation(this.c);
  }
  
  public void a()
  {
    Animation localAnimation = getInAnimation();
    AutoVerticalScrollTextView.Rotate3dAnimation localRotate3dAnimation = this.b;
    if (localAnimation != localRotate3dAnimation) {
      setInAnimation(localRotate3dAnimation);
    }
    localAnimation = getOutAnimation();
    localRotate3dAnimation = this.c;
    if (localAnimation != localRotate3dAnimation) {
      setOutAnimation(localRotate3dAnimation);
    }
  }
  
  public void b()
  {
    this.a = null;
    Handler localHandler = this.h;
    if (localHandler != null)
    {
      localHandler.removeMessages(9001);
      this.h = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 9001) {
      return true;
    }
    if (this.g != null)
    {
      a();
      this.d += 1;
      if (this.d >= this.g.length) {
        this.d = 0;
      }
      setText(this.g[this.d]);
    }
    this.h.removeMessages(9001);
    this.h.sendEmptyMessageDelayed(9001, this.e);
    return true;
  }
  
  public View makeView()
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setTextSize(14.0F);
    localTextView.setSingleLine(true);
    localTextView.setGravity(17);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(Color.parseColor("#777777"));
    return localTextView;
  }
  
  public void setAnimationTime(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void setInterSwitcTime(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void setTextArray(String[] paramArrayOfString)
  {
    this.g = paramArrayOfString;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      this.d = 0;
      setText(paramArrayOfString[this.d]);
      this.h.sendEmptyMessageDelayed(9001, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AutoVerticalScrollTextView
 * JD-Core Version:    0.7.0.1
 */