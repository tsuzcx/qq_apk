package com.tencent.mobileqq.guild.live.fragment.base.module.topbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveTopBarControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;
import com.tencent.qphone.base.util.QLog;

public abstract class QQGuildLiveBaseTopBarFragment
  extends QQGuildLiveModuleBaseFragment
  implements IGuildLiveTopBarControl
{
  private View a;
  private final Handler d = new Handler(Looper.getMainLooper());
  private final Runnable e = new QQGuildLiveBaseTopBarFragment.1(this);
  private boolean f;
  
  private void b(View paramView)
  {
    this.f = true;
    paramView.setVisibility(0);
    paramView.setAlpha(0.0F);
    paramView.setTranslationY(-paramView.getHeight());
    paramView.animate().alpha(1.0F).translationY(0.0F).setDuration(180L).setListener(new QQGuildLiveBaseTopBarFragment.2(this)).start();
  }
  
  private void c(View paramView)
  {
    this.f = false;
    paramView.animate().alpha(0.0F).translationY(-paramView.getHeight()).setDuration(180L).setListener(new QQGuildLiveBaseTopBarFragment.3(this, paramView)).start();
  }
  
  private void d()
  {
    this.d.removeCallbacks(this.e);
  }
  
  protected void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.a = paramView;
  }
  
  public void cv_()
  {
    d();
    this.a.clearAnimation();
    if (this.f)
    {
      c(this.a);
      return;
    }
    b(this.a);
  }
  
  public void e()
  {
    d();
    this.a.clearAnimation();
    if (this.f) {
      c(this.a);
    }
  }
  
  public void g()
  {
    d();
    this.a.clearAnimation();
    if (!this.f) {
      b(this.a);
    }
  }
  
  protected void h()
  {
    this.d.postDelayed(this.e, 3000L);
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildLiveBaseTopBarFragment", 1, "onAttach.");
    }
    if (this.c != null) {
      this.c.a(this);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    View localView = this.a;
    if (localView != null) {
      localView.clearAnimation();
    }
    d();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildLiveBaseTopBarFragment", 1, "onDetach.");
    }
    if (this.c != null) {
      this.c.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment
 * JD-Core Version:    0.7.0.1
 */