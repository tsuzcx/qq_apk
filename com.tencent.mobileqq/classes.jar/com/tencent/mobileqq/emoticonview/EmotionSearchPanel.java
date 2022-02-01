package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aryb;
import aryi;
import arze;
import asan;
import asao;
import asap;
import asaq;
import asar;
import asas;
import asat;
import asau;
import asav;
import asaw;
import bclx;
import bgsp;
import bgtn;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class EmotionSearchPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  public static int a;
  float jdField_a_of_type_Float;
  View jdField_a_of_type_AndroidViewView;
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
  public EditText a;
  public FrameLayout a;
  public ImageView a;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aryi jdField_a_of_type_Aryi;
  public BaseChatPie a;
  public QQAppInterface a;
  public boolean a;
  public int b;
  public View b;
  RelativeLayout b;
  public boolean b;
  public int c;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = bclx.a(60.0F) / 2;
  private boolean jdField_f_of_type_Boolean;
  
  public EmotionSearchPanel(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
  }
  
  public EmotionSearchPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
  }
  
  public EmotionSearchPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
  }
  
  private int a()
  {
    return this.jdField_b_of_type_Int / 2 - c() - bclx.a(24.0F);
  }
  
  private void a(float paramFloat)
  {
    if ((paramFloat > 0.99F) && (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = true;
      ((aryi)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7)).c(0);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Float = bclx.e(getContext());
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (!bgsp.a(paramString))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_Int = paramInt2;
      if ((this.jdField_b_of_type_Int <= 0) || (a(false))) {
        this.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Float - this.jdField_f_of_type_Int);
      }
      if (!a(false))
      {
        d(0);
        c(this.jdField_b_of_type_Int);
      }
      this.jdField_d_of_type_Int = (bclx.a(10.0F) + paramInt1);
      if (jdField_a_of_type_Int <= 0) {
        break label232;
      }
      paramString = (aryb)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(1);
    }
    label232:
    for (this.jdField_e_of_type_Int = (jdField_a_of_type_Int - paramString.a());; this.jdField_e_of_type_Int = (paramInt3 - bclx.a(12.0F)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "init initAnimStartParam =" + this.jdField_e_of_type_Int + " exitWidth =" + this.jdField_b_of_type_Int);
      }
      return;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean)) {}
    }
    else {
      while ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
        return false;
      }
    }
    return true;
  }
  
  private int b()
  {
    return this.jdField_b_of_type_Int / 2 - c();
  }
  
  private void b(int paramInt)
  {
    if (bgsp.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))
    {
      arze.a("0X800AE27", paramInt);
      return;
    }
    arze.a("0X800AE29", paramInt);
  }
  
  private int c()
  {
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Object localObject1 = localObject2;
    if (bgsp.a((String)localObject2)) {
      localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getHint().toString();
    }
    localObject2 = new Rect();
    this.jdField_a_of_type_AndroidWidgetEditText.getPaint().getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
    return ((Rect)localObject2).width() / 2;
  }
  
  private void c(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  private void d(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams();
    localLayoutParams.leftMargin = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
  }
  
  private void e(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365961));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365960));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365962));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365959));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370535);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getContext().getResources().getColor(2131165623));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getContext().getResources().getColor(2131165623));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365948));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369274));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131370529));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = ((Activity)getContext()).getWindow().getDecorView();
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundDrawable(a(18));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(18));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new asan(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new asap(this));
  }
  
  private void h()
  {
    a(3);
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    l();
    aryi localaryi = (aryi)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7);
    if (this.jdField_f_of_type_Boolean)
    {
      localaryi.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      localaryi.b(true);
    }
    localaryi.c(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.t(12);
  }
  
  private void i()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i = a();
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new asaq(this, i));
    d(i);
    localValueAnimator.start();
  }
  
  private void j()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i = this.jdField_a_of_type_AndroidWidgetEditText.getWidth();
    int j = bclx.a(27.0F);
    int k = this.jdField_b_of_type_Int;
    int m = b();
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new asar(this, i, k - i, m - j));
    localValueAnimator.addListener(new asas(this));
    localValueAnimator.start();
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "onExitAnimEnd");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, 0, false, null, 0);
    aryi localaryi = (aryi)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7);
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      localaryi.d(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  private void l()
  {
    if ((getContext() != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionSearchPanel", 2, new Object[] { "hideSoftInput, ", this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken() });
        }
      }
    }
  }
  
  private void m()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_b_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  protected Drawable a(int paramInt)
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {}
    for (String str = "#1C1C1C";; str = "#F5F6FA") {
      return bgtn.a(Color.parseColor(str), bgtn.a(paramInt));
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "startEntryAinm =" + this.jdField_e_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight() == 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.measure(0, 0);
    }
    int j = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
    Object localObject = (aryb)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(1);
    int i;
    if (((aryb)localObject).c()) {
      if ((jdField_a_of_type_Int > 0) && (Math.abs(jdField_a_of_type_Int - ((aryb)localObject).a()) > 1))
      {
        i = 0;
        i = -((aryb)localObject).a(i) + j;
      }
    }
    for (;;)
    {
      localObject = ValueAnimator.ofInt(new int[] { 0, i });
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
      ((ValueAnimator)localObject).addUpdateListener(new asat(this));
      ((ValueAnimator)localObject).addListener(new asau(this));
      ((ValueAnimator)localObject).start();
      if (a(false)) {
        i();
      }
      return;
      i = jdField_a_of_type_Int;
      break;
      if (jdField_a_of_type_Int <= 0) {
        i = this.jdField_e_of_type_Int;
      } else {
        i = bclx.a(3.5F) + j;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, new Object[] { "setEmotionStatus,status ", Integer.valueOf(paramInt) });
    }
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3, aryi paramaryi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "init start searchRootStartBottomMargin=" + this.jdField_d_of_type_Int + " upDis=" + paramInt2 + " width=" + paramInt3 + " hasWord=" + this.jdField_c_of_type_Boolean + " keyboardHeight= " + jdField_a_of_type_Int);
    }
    a(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_d_of_type_Boolean = paramBoolean;
    g();
    if (paramBoolean)
    {
      paramString = "";
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
    a(paramString, paramInt1, paramInt3, paramInt2);
    this.jdField_a_of_type_Aryi = paramaryi;
    a();
  }
  
  public void b()
  {
    Object localObject = (aryb)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(1);
    int j = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
    int i;
    if (this.jdField_f_of_type_Boolean) {
      if ((jdField_a_of_type_Int > 0) && (Math.abs(jdField_a_of_type_Int - ((aryb)localObject).a()) > 1))
      {
        i = 0;
        i = ((aryb)localObject).a(i) - j;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "startExitAinm isExitNeedSearch =" + this.jdField_f_of_type_Boolean + " upDis=" + i + " upAndDownDistance=" + this.jdField_e_of_type_Int);
      }
      localObject = ValueAnimator.ofInt(new int[] { 0, i });
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
      ((ValueAnimator)localObject).addUpdateListener(new asav(this));
      ((ValueAnimator)localObject).addListener(new asaw(this));
      ((ValueAnimator)localObject).start();
      if (this.jdField_e_of_type_Int < 0) {
        ((aryi)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7)).c(4);
      }
      if (a(true)) {
        j();
      }
      return;
      i = jdField_a_of_type_Int;
      break;
      if (jdField_a_of_type_Int <= 0) {
        i = ((aryb)localObject).a() + j;
      } else {
        i = bclx.a(3.5F) + j;
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new asao(this);
    this.jdField_b_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this, -1, -1);
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setSoftInputMode(16);
    try
    {
      if (Build.VERSION.SDK_INT >= 22) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setAttachedInDecor(false);
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setClippingEnabled(false);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this, 0, 0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, new Object[] { "showEmotionSearchWindow,height ", Integer.valueOf(this.jdField_a_of_type_AndroidWidgetPopupWindow.getHeight()) });
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmotionSearchPanel", 2, localThrowable, new Object[0]);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, new Object[] { "setEmotionStatus,dispatchKeyEvent code=", Integer.valueOf(paramKeyEvent.getKeyCode()) });
    }
    if (paramKeyEvent.getKeyCode() == 4) {
      h();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = true;
    m();
    e();
    a(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(1);
      this.jdField_f_of_type_Boolean = false;
      h();
      continue;
      b(2);
      this.jdField_f_of_type_Boolean = false;
      h();
      continue;
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel
 * JD-Core Version:    0.7.0.1
 */