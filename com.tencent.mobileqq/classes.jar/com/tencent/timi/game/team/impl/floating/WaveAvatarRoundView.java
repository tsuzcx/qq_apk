package com.tencent.timi.game.team.impl.floating;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.av.utils.UITools;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.utils.Logger;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import trpc.yes.common.CommonOuterClass.QQUserId;

public class WaveAvatarRoundView
  extends RelativeLayout
{
  private TimiGamePAGView a;
  private View b;
  private AvatarRoundImageView c;
  private View d;
  private TextView e;
  
  public WaveAvatarRoundView(@NonNull @NotNull Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public WaveAvatarRoundView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public WaveAvatarRoundView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private PAGFile a(PAGFile paramPAGFile, int paramInt)
  {
    if (paramPAGFile == null) {
      return null;
    }
    Matrix localMatrix = paramPAGFile.getTotalMatrix();
    float f = UITools.a(getContext(), paramInt) * 1.0F / paramPAGFile.width();
    localMatrix.setScale(f, f);
    paramPAGFile.setMatrix(localMatrix);
    return paramPAGFile;
  }
  
  private void a(View paramView)
  {
    paramView.setAlpha(0.0F);
    paramView = paramView.animate().alpha(1.0F);
    paramView.setDuration(400L);
    paramView.start();
  }
  
  private void e()
  {
    f();
  }
  
  private void f()
  {
    g();
    h();
    i();
    j();
    k();
  }
  
  private void g()
  {
    int i = (int)UITools.a(getContext(), 75.0F);
    int j = (int)UITools.a(getContext(), 75.0F);
    this.a = new TimiGamePAGView(getContext());
    this.a.setLayoutParams(new ViewGroup.LayoutParams(i, j));
    addView(this.a);
  }
  
  private void h()
  {
    int i = (int)UITools.a(getContext(), 99.0F);
    int j = (int)UITools.a(getContext(), 99.0F);
    this.b = new View(getContext());
    this.b.setBackgroundResource(2130853088);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
    localLayoutParams.addRule(13, -1);
    this.b.setLayoutParams(localLayoutParams);
    addView(this.b);
  }
  
  private void i()
  {
    int i = (int)UITools.a(getContext(), 50.0F);
    int j = (int)UITools.a(getContext(), 50.0F);
    this.c = new AvatarRoundImageView(getContext());
    this.c.setBackgroundResource(2130853089);
    int k = (int)UITools.a(getContext(), 2.0F);
    this.c.setPadding(k, k, k, k);
    this.c.setId(2131446865);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
    localLayoutParams.addRule(13, -1);
    if (Build.VERSION.SDK_INT >= 21) {
      this.c.setElevation(8.0F);
    }
    this.c.setLayoutParams(localLayoutParams);
    addView(this.c);
  }
  
  private void j()
  {
    int i = (int)UITools.a(getContext(), 46.0F);
    int j = (int)UITools.a(getContext(), 46.0F);
    this.d = new View(getContext());
    this.d.setBackgroundResource(2130853091);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
    localLayoutParams.addRule(13, -1);
    this.d.setLayoutParams(localLayoutParams);
    this.d.setVisibility(8);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.d.setElevation(10.0F);
      if (Build.VERSION.SDK_INT >= 28) {
        this.d.setOutlineSpotShadowColor(0);
      }
    }
    addView(this.d);
  }
  
  private void k()
  {
    this.e = new TextView(getContext());
    this.e.setTextSize(14.0F);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131446865);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)UITools.a(getContext(), 27.0F));
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.e.setTextColor(-1711276033);
    localObject = Typeface.createFromAsset(getContext().getResources().getAssets(), "fonts/DIN Alternate.ttf");
    this.e.setTypeface((Typeface)localObject);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.e.setElevation(10.0F);
      if (Build.VERSION.SDK_INT >= 28) {
        this.e.setOutlineSpotShadowColor(0);
      }
    }
    addView(this.e);
  }
  
  private void l()
  {
    if (this.a.getVisibility() == 8) {
      return;
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setDuration(500L);
    localAnimationSet.setAnimationListener(new WaveAvatarRoundView.2(this));
    this.a.startAnimation(localAnimationSet);
  }
  
  private void m()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new WaveAvatarRoundView.3(this));
    localObjectAnimator.start();
  }
  
  private void n()
  {
    if (!((IniterService)ServiceCenter.a(IniterService.class)).c()) {
      return;
    }
    if (this.a.b()) {
      return;
    }
    PAGComposition localPAGComposition = PAGComposition.Make((int)UITools.a(getContext(), 75.0F), (int)UITools.a(getContext(), 75.0F));
    if (localPAGComposition == null) {
      return;
    }
    PAGFile localPAGFile = a(TimiPAGResourceLoader.a.a("https://cdn.yes.qq.com/client_business/tg_team_wave.pag", null), 75);
    if (localPAGFile == null) {
      return;
    }
    localPAGComposition.addLayer(localPAGFile);
    this.a.setComposition(localPAGComposition);
    this.a.setRepeatCount(0);
    this.a.a(new WaveAvatarRoundView.4(this));
    this.a.c();
  }
  
  private void o()
  {
    try
    {
      Vibrator localVibrator = (Vibrator)getContext().getSystemService("vibrator");
      if (Build.VERSION.SDK_INT >= 26)
      {
        localVibrator.vibrate(VibrationEffect.createOneShot(20L, -1));
        return;
      }
      localVibrator.vibrate(20L);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a()
  {
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(-(int)UITools.a(getContext(), 0.5F), (int)UITools.a(getContext(), 0.5F), -(int)UITools.a(getContext(), 0.5F), (int)UITools.a(getContext(), 0.5F));
    localTranslateAnimation1.setDuration(250L);
    localTranslateAnimation1.setInterpolator(new CycleInterpolator(10.0F));
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(-(int)UITools.a(getContext(), 0.2F), (int)UITools.a(getContext(), 0.2F), (int)UITools.a(getContext(), 0.2F), -(int)UITools.a(getContext(), 0.2F));
    localTranslateAnimation2.setDuration(500L);
    localTranslateAnimation2.setInterpolator(new CycleInterpolator(8.0F));
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localTranslateAnimation1);
    localAnimationSet.addAnimation(localTranslateAnimation2);
    o();
    this.c.startAnimation(localAnimationSet);
  }
  
  public void a(CommonOuterClass.QQUserId paramQQUserId)
  {
    if (paramQQUserId != null) {
      this.c.setUserId(paramQQUserId);
    }
  }
  
  public void b()
  {
    if (!((IniterService)ServiceCenter.a(IniterService.class)).c())
    {
      Logger.a("Timi_Float", "pag is not ready, init pag now");
      ((IniterService)ServiceCenter.a(IniterService.class)).a(new WaveAvatarRoundView.1(this));
      return;
    }
    Logger.a("Timi_Float", "pag is loaded,just play anim");
    n();
  }
  
  public void c()
  {
    l();
  }
  
  public void d()
  {
    a(this.d);
    a(this.e);
  }
  
  public void setAvatarClickListener(View.OnClickListener paramOnClickListener)
  {
    this.c.setClickJumpPersonalPage(true);
    this.c.a(paramOnClickListener);
  }
  
  public void setTeamCountText(CharSequence paramCharSequence)
  {
    this.e.setText(paramCharSequence);
  }
  
  public void setTeamCountVisible(int paramInt)
  {
    this.e.setVisibility(paramInt);
    this.d.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.WaveAvatarRoundView
 * JD-Core Version:    0.7.0.1
 */