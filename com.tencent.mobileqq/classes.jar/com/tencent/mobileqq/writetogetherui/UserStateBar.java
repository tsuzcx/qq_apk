package com.tencent.mobileqq.writetogetherui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class UserStateBar
{
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private SavingAnimView g;
  private View h;
  private boolean i;
  private int j;
  
  public UserStateBar(Context paramContext, View paramView, TextView paramTextView)
  {
    this.a = paramContext;
    this.h = paramView;
    this.f = paramTextView;
    a(paramView);
    s();
  }
  
  private void a(View paramView)
  {
    this.b = ((TextView)paramView.findViewById(2131450311));
    this.c = ((TextView)paramView.findViewById(2131450313));
    this.d = ((TextView)paramView.findViewById(2131450315));
    this.e = ((TextView)paramView.findViewById(2131450312));
    this.g = ((SavingAnimView)paramView.findViewById(2131450316));
    paramView = paramView.getParent();
    if ((paramView instanceof RelativeLayout))
    {
      paramView = (RelativeLayout)paramView;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      paramView.setLayoutParams(localLayoutParams);
    }
    this.g.setOnAnimationStateListener(new UserStateBar.1(this));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    Object localObject = this.e;
    int m = 0;
    int k;
    if (paramBoolean1) {
      k = 0;
    } else {
      k = 8;
    }
    ((TextView)localObject).setVisibility(k);
    localObject = this.g;
    if (paramBoolean2) {
      k = 0;
    } else {
      k = 8;
    }
    ((SavingAnimView)localObject).setVisibility(k);
    localObject = this.b;
    if (paramBoolean3) {
      k = 0;
    } else {
      k = 8;
    }
    ((TextView)localObject).setVisibility(k);
    localObject = this.c;
    if (paramBoolean4) {
      k = 0;
    } else {
      k = 8;
    }
    ((TextView)localObject).setVisibility(k);
    localObject = this.d;
    if (paramBoolean5) {
      k = 0;
    } else {
      k = 8;
    }
    ((TextView)localObject).setVisibility(k);
    localObject = this.f;
    if (paramBoolean6) {
      k = m;
    } else {
      k = 8;
    }
    ((TextView)localObject).setVisibility(k);
  }
  
  private void b(boolean paramBoolean)
  {
    a(false, false, true, false, false, paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    a(paramBoolean ^ true, paramBoolean, false, true, paramBoolean, true);
  }
  
  private void s()
  {
    this.j = DisplayUtil.a(this.a).a;
  }
  
  private void t()
  {
    float f1 = this.c.getTextSize();
    this.c.setTranslationY(f1);
    ViewPropertyAnimator localViewPropertyAnimator = this.d.animate().alpha(0.0F);
    f1 = -f1;
    localViewPropertyAnimator.translationY(f1).setDuration(500L).start();
    this.c.animate().alpha(1.0F).translationYBy(f1).setDuration(500L).setStartDelay(100L).setListener(new UserStateBar.2(this)).start();
  }
  
  private void u()
  {
    float f1 = this.c.getTextSize();
    this.c.animate().setListener(null);
    this.c.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.c.animate().alpha(0.0F);
    float f2 = -f1;
    localViewPropertyAnimator.translationY(f2).setDuration(500L).start();
    this.d.setTranslationY(f1);
    this.d.animate().alpha(1.0F).translationYBy(f2).setDuration(500L).setStartDelay(100L).start();
  }
  
  private void v()
  {
    a(false, false, true, false, false, false);
  }
  
  private void w()
  {
    a(false, true, false, true, true, true);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 1, "[onChangesetCommitting]");
    }
    w();
  }
  
  public void a(String paramString)
  {
    this.f.setText(paramString);
    if (this.f.getCompoundDrawables()[3] == null)
    {
      paramString = this.a.getResources();
      Drawable localDrawable = paramString.getDrawable(2130852617);
      int k = paramString.getDimensionPixelSize(2131300111);
      localDrawable.setBounds(0, 0, k, k);
      this.f.setCompoundDrawables(null, null, localDrawable, null);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt != 1)
    {
      this.c.setText(paramString);
      this.c.getParent().requestLayout();
      this.e.setVisibility(8);
      return;
    }
    this.e.setText(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(false, false, true, false, false, paramBoolean ^ true);
    this.b.setText(paramString);
    this.b.setTextColor(this.a.getResources().getColor(2131167990));
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    this.b.setText(2131917794);
    this.b.setTextColor(this.a.getResources().getColor(2131167990));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 1, "[onChangesetCommitted]");
    }
    k();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(true);
    this.b.setText(paramString);
    this.b.setTextColor(this.a.getResources().getColor(2131167990));
  }
  
  public boolean c()
  {
    return this.i;
  }
  
  public void d()
  {
    this.i = true;
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 2, "[startAnimation]");
    }
    this.g.a();
    u();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 2, "[stopAnimation]");
    }
    this.g.b();
  }
  
  public void f()
  {
    b(true);
    this.b.setText(2131917810);
    this.b.setTextColor(this.a.getResources().getColor(2131167990));
  }
  
  public void g()
  {
    b(true);
    this.b.setText(2131917811);
    this.b.setTextColor(this.a.getResources().getColor(2131167990));
  }
  
  public void h()
  {
    v();
    this.b.setText(2131917795);
    this.b.setTextColor(this.a.getResources().getColor(2131167990));
  }
  
  public void i()
  {
    b(true);
    this.b.setText(2131918148);
    this.b.setTextColor(this.a.getResources().getColor(2131167990));
  }
  
  public void j()
  {
    c(false);
  }
  
  public void k()
  {
    c(true);
  }
  
  public TextView l()
  {
    return this.f;
  }
  
  public TextPaint m()
  {
    return this.c.getPaint();
  }
  
  public TextPaint n()
  {
    return this.f.getPaint();
  }
  
  public int o()
  {
    return this.a.getResources().getDimensionPixelSize(2131300103);
  }
  
  public int p()
  {
    Resources localResources = this.a.getResources();
    int k = this.j - localResources.getDimensionPixelSize(2131300108) * 2 - localResources.getDimensionPixelSize(2131300110);
    int m = localResources.getDimensionPixelSize(2131300109);
    if (k < m) {
      return m;
    }
    return k;
  }
  
  public int q()
  {
    return this.j - this.a.getResources().getDimensionPixelSize(2131300104) * 2;
  }
  
  public int r()
  {
    return this.a.getResources().getDimensionPixelSize(2131300102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.UserStateBar
 * JD-Core Version:    0.7.0.1
 */