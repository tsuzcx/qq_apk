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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SavingAnimView jdField_a_of_type_ComTencentMobileqqWritetogetheruiSavingAnimView;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public UserStateBar(Context paramContext, View paramView, TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.e = paramTextView;
    a(paramView);
    k();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381263));
    this.b = ((TextView)paramView.findViewById(2131381265));
    this.c = ((TextView)paramView.findViewById(2131381267));
    this.d = ((TextView)paramView.findViewById(2131381264));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiSavingAnimView = ((SavingAnimView)paramView.findViewById(2131381268));
    paramView = paramView.getParent();
    if ((paramView instanceof RelativeLayout))
    {
      paramView = (RelativeLayout)paramView;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      paramView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiSavingAnimView.setOnAnimationStateListener(new UserStateBar.1(this));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    Object localObject = this.d;
    int j = 0;
    int i;
    if (paramBoolean1) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiSavingAnimView;
    if (paramBoolean2) {
      i = 0;
    } else {
      i = 8;
    }
    ((SavingAnimView)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean3) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.b;
    if (paramBoolean4) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.c;
    if (paramBoolean5) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.e;
    if (paramBoolean6) {
      i = j;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
  }
  
  private void b(boolean paramBoolean)
  {
    a(false, false, true, false, false, paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    a(paramBoolean ^ true, paramBoolean, false, true, paramBoolean, true);
  }
  
  private void k()
  {
    this.jdField_a_of_type_Int = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext).jdField_a_of_type_Int;
  }
  
  private void l()
  {
    float f = this.b.getTextSize();
    this.b.setTranslationY(f);
    ViewPropertyAnimator localViewPropertyAnimator = this.c.animate().alpha(0.0F);
    f = -f;
    localViewPropertyAnimator.translationY(f).setDuration(500L).start();
    this.b.animate().alpha(1.0F).translationYBy(f).setDuration(500L).setStartDelay(100L).setListener(new UserStateBar.2(this)).start();
  }
  
  private void m()
  {
    float f1 = this.b.getTextSize();
    this.b.animate().setListener(null);
    this.b.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.b.animate().alpha(0.0F);
    float f2 = -f1;
    localViewPropertyAnimator.translationY(f2).setDuration(500L).start();
    this.c.setTranslationY(f1);
    this.c.animate().alpha(1.0F).translationYBy(f2).setDuration(500L).setStartDelay(100L).start();
  }
  
  private void n()
  {
    a(false, false, true, false, false, false);
  }
  
  private void o()
  {
    a(false, true, false, true, true, true);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299308);
  }
  
  public TextPaint a()
  {
    return this.b.getPaint();
  }
  
  public TextView a()
  {
    return this.e;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 1, "[onChangesetCommitting]");
    }
    o();
  }
  
  public void a(String paramString)
  {
    this.e.setText(paramString);
    if (this.e.getCompoundDrawables()[3] == null)
    {
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources();
      Drawable localDrawable = paramString.getDrawable(2130850795);
      int i = paramString.getDimensionPixelSize(2131299316);
      localDrawable.setBounds(0, 0, i, i);
      this.e.setCompoundDrawables(null, null, localDrawable, null);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt != 1)
    {
      this.b.setText(paramString);
      this.b.getParent().requestLayout();
      this.d.setVisibility(8);
      return;
    }
    this.d.setText(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(false, false, true, false, false, paramBoolean ^ true);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720164);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = this.jdField_a_of_type_Int - localResources.getDimensionPixelSize(2131299313) * 2 - localResources.getDimensionPixelSize(2131299315);
    int j = localResources.getDimensionPixelSize(2131299314);
    if (i < j) {
      return j;
    }
    return i;
  }
  
  public TextPaint b()
  {
    return this.e.getPaint();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 1, "[onChangesetCommitted]");
    }
    j();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299309) * 2;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 2, "[startAnimation]");
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiSavingAnimView.a();
    m();
  }
  
  public int d()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299307);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateBar", 2, "[stopAnimation]");
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiSavingAnimView.b();
  }
  
  public void e()
  {
    b(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720180);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
  }
  
  public void f()
  {
    b(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720181);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
  }
  
  public void g()
  {
    n();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720165);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
  }
  
  public void h()
  {
    b(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720472);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
  }
  
  public void i()
  {
    c(false);
  }
  
  public void j()
  {
    c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.UserStateBar
 * JD-Core Version:    0.7.0.1
 */