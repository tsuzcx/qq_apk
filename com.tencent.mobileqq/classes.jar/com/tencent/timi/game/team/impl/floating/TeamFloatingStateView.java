package com.tencent.timi.game.team.impl.floating;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.widget.MediumBoldTextView;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;

public class TeamFloatingStateView
  extends RelativeLayout
{
  private TimiGamePAGView a;
  private TimiGamePAGView b;
  private MediumBoldTextView c;
  private View d;
  private String e = "";
  
  public TeamFloatingStateView(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public TeamFloatingStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  public TeamFloatingStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
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
  
  private void a(String paramString)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, -UITools.a(getContext(), 10.0F), 0.0F, 0.0F);
    localTranslateAnimation.setAnimationListener(new TeamFloatingStateView.1(this, paramString));
    localTranslateAnimation.setDuration(350L);
    paramString = new AlphaAnimation(1.0F, 0.0F);
    paramString.setDuration(350L);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(paramString);
    localAnimationSet.setInterpolator(new DecelerateInterpolator(3.0F));
    this.c.startAnimation(localAnimationSet);
  }
  
  private void b(String paramString)
  {
    this.c.setVisibility(0);
    this.c.setText(paramString);
    paramString = new AnimationSet(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(UITools.a(getContext(), 10.0F), 0.0F, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(350L);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(350L);
    paramString.addAnimation(localTranslateAnimation);
    paramString.addAnimation(localAlphaAnimation);
    paramString.setInterpolator(new AccelerateInterpolator(3.0F));
    this.c.startAnimation(paramString);
  }
  
  private void f()
  {
    g();
    h();
    i();
    k();
    j();
    l();
  }
  
  private void g()
  {
    setClipChildren(false);
    setLayoutParams(new RelativeLayout.LayoutParams((int)UITools.a(getContext(), 73.0F), -2));
  }
  
  private void h()
  {
    int i = (int)UITools.a(getContext(), 60.0F);
    int j = (int)UITools.a(getContext(), 19.0F);
    View localView = new View(getContext());
    localView.setId(2131446867);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
    localLayoutParams.addRule(13, -1);
    localView.setLayoutParams(localLayoutParams);
    localView.setBackgroundResource(2130853092);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localView.setElevation(8.0F);
      if (Build.VERSION.SDK_INT >= 28) {
        localView.setOutlineSpotShadowColor(-2147483648);
      }
    }
    addView(localView);
  }
  
  private void i()
  {
    int i = (int)UITools.a(getContext(), 32.0F);
    int j = (int)UITools.a(getContext(), 32.0F);
    this.a = new TimiGamePAGView(getContext());
    this.a.setId(2131446866);
    this.a.setLayoutParams(new ViewGroup.LayoutParams(i, j));
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.a.setElevation(13.0F);
      if (Build.VERSION.SDK_INT >= 28) {
        this.a.setOutlineSpotShadowColor(0);
      }
    }
    addView(this.a);
    if (!((IniterService)ServiceCenter.a(IniterService.class)).c()) {
      return;
    }
    PAGComposition localPAGComposition = PAGComposition.Make(i, j);
    if (localPAGComposition == null) {
      return;
    }
    PAGFile localPAGFile = a(TimiPAGResourceLoader.a.a("https://cdn.yes.qq.com/client_business/tg_smoba_icon.pag", null), 32);
    if (localPAGFile == null) {
      return;
    }
    localPAGComposition.addLayer(localPAGFile);
    this.a.setComposition(localPAGComposition);
    this.a.setProgress(0.0D);
  }
  
  private void j()
  {
    int i = (int)UITools.a(getContext(), 26.0F);
    int j = (int)UITools.a(getContext(), 26.0F);
    this.b = new TimiGamePAGView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(i, j);
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131446867);
    ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131446867);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = (-i / 2);
    ((RelativeLayout.LayoutParams)localObject).topMargin = (-j / 2);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.b.setElevation(12.0F);
      if (Build.VERSION.SDK_INT >= 28) {
        this.b.setOutlineSpotShadowColor(0);
      }
    }
    this.b.setVisibility(8);
    addView(this.b);
    if (!((IniterService)ServiceCenter.a(IniterService.class)).c()) {
      return;
    }
    localObject = PAGComposition.Make(i, j);
    if (localObject == null) {
      return;
    }
    PAGFile localPAGFile = a(PAGFile.Load(Env.a().getResources().getAssets(), "pag/tg_red_point.pag"), 26);
    if (localPAGFile == null) {
      return;
    }
    ((PAGComposition)localObject).addLayer(localPAGFile);
    this.b.setComposition((PAGComposition)localObject);
  }
  
  private void k()
  {
    this.c = new MediumBoldTextView(getContext());
    this.c.setGravity(17);
    this.c.setVisibility(8);
    this.c.setMaxLines(1);
    this.c.setSingleLine(true);
    this.c.setTextColor(-16777216);
    this.c.setTextSize(10.0F);
    this.c.setIncludeFontPadding(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(7, 2131446867);
    localLayoutParams.addRule(5, 2131446867);
    localLayoutParams.leftMargin = ((int)UITools.a(getContext(), 17.0F));
    this.c.setLayoutParams(localLayoutParams);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.c.setElevation(11.0F);
      if (Build.VERSION.SDK_INT >= 28) {
        this.c.setOutlineSpotShadowColor(0);
      }
    }
    addView(this.c);
  }
  
  private void l()
  {
    int i = (int)UITools.a(getContext(), 9.0F);
    int j = (int)UITools.a(getContext(), 9.0F);
    this.d = new View(getContext());
    this.d.setBackgroundResource(2130852961);
    this.d.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
    localLayoutParams.addRule(6, 2131446867);
    localLayoutParams.addRule(7, 2131446867);
    localLayoutParams.rightMargin = (-i / 2);
    localLayoutParams.topMargin = (-j / 2);
    this.d.setLayoutParams(localLayoutParams);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.d.setElevation(9.0F);
      if (Build.VERSION.SDK_INT >= 28) {
        this.d.setOutlineSpotShadowColor(0);
      }
    }
    addView(this.d);
  }
  
  private void m()
  {
    this.a.setRepeatCount(0);
    this.a.c();
  }
  
  private void n()
  {
    this.b.setVisibility(0);
    this.b.setRepeatCount(0);
    this.b.c();
  }
  
  public void a()
  {
    this.c.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.c.animate().alpha(1.0F);
    localViewPropertyAnimator.setDuration(400L);
    localViewPropertyAnimator.start();
  }
  
  public void b()
  {
    if (!((IniterService)ServiceCenter.a(IniterService.class)).c())
    {
      Logger.a("Timi_Float", "pag is not ready, init pag now");
      ((IniterService)ServiceCenter.a(IniterService.class)).a(new TeamFloatingStateView.2(this));
      return;
    }
    Logger.a("Timi_Float", "pag is loaded,just play anim");
    m();
  }
  
  public void c()
  {
    if (!((IniterService)ServiceCenter.a(IniterService.class)).c())
    {
      Logger.a("Timi_Float", "pag is not ready, init pag now");
      ((IniterService)ServiceCenter.a(IniterService.class)).a(new TeamFloatingStateView.3(this));
      return;
    }
    Logger.a("Timi_Float", "pag is loaded,just play anim");
    n();
  }
  
  public void d()
  {
    this.a.d();
    this.a.setProgress(0.0D);
  }
  
  public void e()
  {
    this.b.setVisibility(8);
    this.b.d();
    this.b.setProgress(0.0D);
  }
  
  public String getTeamState()
  {
    return this.e;
  }
  
  public void setRedPointVisible(int paramInt)
  {
    this.d.setVisibility(paramInt);
    this.b.setVisibility(paramInt);
  }
  
  public void setTeamStateWithAnim(String paramString)
  {
    if (TextUtils.isEmpty(this.e)) {
      b(paramString);
    } else {
      a(paramString);
    }
    this.e = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingStateView
 * JD-Core Version:    0.7.0.1
 */