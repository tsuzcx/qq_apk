package com.tencent.mobileqq.listentogether.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SweepGradientCircleProgress;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableImageView;
import com.tencent.widget.PatchedButton;

public class MusicPanelView
  extends RelativeLayout
  implements View.OnClickListener
{
  Drawable a;
  ImageView b;
  AlphaClickableImageView c;
  TextView d;
  TextView e;
  TextView f;
  ImageView g;
  ImageView h;
  PatchedButton i;
  SweepGradientCircleProgress j;
  int k;
  public View.OnClickListener l;
  URLDrawable m;
  private float n = 0.0F;
  private ObjectAnimator o = null;
  
  public MusicPanelView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2131627279, this, true);
    setBackgroundResource(2130846214);
    this.b = ((ImageView)findViewById(2131431326));
    this.c = ((AlphaClickableImageView)findViewById(2131446327));
    this.d = ((TextView)findViewById(2131439074));
    this.h = ((ImageView)findViewById(2131439051));
    this.g = ((ImageView)findViewById(2131442946));
    this.j = ((SweepGradientCircleProgress)findViewById(2131439067));
    this.i = ((PatchedButton)findViewById(2131436679));
    this.e = ((TextView)findViewById(2131439071));
    this.f = ((TextView)findViewById(2131439070));
    this.c.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.a = getResources().getDrawable(2130846230);
    int i1 = AIOUtils.b(8.0F, this.c.getResources());
    Object localObject = (Activity)getContext();
    AlphaClickableImageView localAlphaClickableImageView = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Activity)localObject).getWindow().getDecorView();
    }
    BaseListenTogetherPanel.a(localAlphaClickableImageView, i1, i1, i1, i1, (View)localObject);
    this.k = AIOUtils.b(31.0F, getResources());
    setMusicProgressDefaultShow();
  }
  
  public void a()
  {
    if (d()) {
      return;
    }
    ImageView localImageView = this.b;
    float f1 = this.n;
    this.o = ObjectAnimator.ofFloat(localImageView, "Rotation", new float[] { f1 - 360.0F, f1 });
    this.o.setDuration(10000L);
    this.o.setRepeatCount(-1);
    this.o.setInterpolator(new LinearInterpolator());
    this.o.addUpdateListener(new MusicPanelView.1(this));
    this.o.start();
  }
  
  public void a(int paramInt)
  {
    this.h.setVisibility(paramInt);
    this.h.setContentDescription(HardCodeUtil.a(2131904907));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c.setVisibility(paramInt1);
    if (paramInt2 == 1)
    {
      this.c.setImageResource(2130846231);
      this.c.setContentDescription(HardCodeUtil.a(2131904905));
      return;
    }
    if (paramInt2 == 2)
    {
      this.c.setImageResource(2130846232);
      this.c.setContentDescription(HardCodeUtil.a(2131904903));
    }
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    this.e.setVisibility(paramInt);
    this.e.setText(paramCharSequence);
    this.e.setContentDescription(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equals((String)this.b.getTag()))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        int i1 = this.k;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i1;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
        Drawable localDrawable = this.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTag(new int[] { this.k / 2 });
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.z);
        ((URLDrawable)localObject).startDownload();
        this.b.setImageDrawable((Drawable)localObject);
        this.b.setTag(paramString);
        this.m = ((URLDrawable)localObject);
      }
    }
    else
    {
      this.b.setImageDrawable(this.a);
      this.b.setTag("");
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.d.setText(paramString);
    this.d.setContentDescription(paramString);
    this.d.setTextColor(getResources().getColor(paramInt));
    setContentDescription(paramString);
    AIOMusicSkin.a().a(getContext(), this);
  }
  
  public void b()
  {
    ObjectAnimator localObjectAnimator = this.o;
    if (localObjectAnimator != null) {
      localObjectAnimator.end();
    }
    this.n = 0.0F;
  }
  
  public void b(int paramInt)
  {
    this.f.setVisibility(paramInt);
    this.f.setContentDescription(HardCodeUtil.a(2131904906));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.j.setVisibility(paramInt1);
    if (paramInt2 < 0)
    {
      paramInt1 = 0;
    }
    else
    {
      paramInt1 = paramInt2;
      if (paramInt2 > 100) {
        paramInt1 = 100;
      }
    }
    this.j.setProgress(paramInt1);
  }
  
  public void c()
  {
    if ((this.o != null) && (d())) {
      this.o.cancel();
    }
  }
  
  public void c(int paramInt)
  {
    this.g.setVisibility(paramInt);
    this.g.setContentDescription(HardCodeUtil.a(2131904902));
  }
  
  public void d(int paramInt)
  {
    this.i.setVisibility(paramInt);
    this.i.setContentDescription(HardCodeUtil.a(2131904904));
  }
  
  public boolean d()
  {
    ObjectAnimator localObjectAnimator = this.o;
    if (localObjectAnimator == null) {
      return false;
    }
    return localObjectAnimator.isRunning();
  }
  
  public void e(int paramInt)
  {
    this.j.setVisibility(paramInt);
  }
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.l;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ObjectAnimator localObjectAnimator = this.o;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      super.setBackgroundDrawable(null);
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setMusicProgressDefaultShow()
  {
    int i1 = getResources().getColor(2131167975);
    if ((ThemeUtil.curThemeId.equals("1103")) || (ThemeUtil.curThemeId.equals("2920"))) {
      i1 = getResources().getColor(2131167974);
    }
    this.j.setBgAndProgressColor(100, i1, 100, getResources().getColor(2131167973));
    this.j.setBgAndProgressUseAlpha(false, false);
    this.j.setStrokeWidth(1.5F);
    this.j.setmShadowColor(0);
    this.j.setNeedSweepGradient(false, 0, 0);
    this.j.setShadowRadius(AIOUtils.b(1.0F, getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.MusicPanelView
 * JD-Core Version:    0.7.0.1
 */