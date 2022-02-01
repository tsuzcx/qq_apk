package com.tencent.mobileqq.widget;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VerifyCodeView
  extends LinearLayout
  implements TextWatcher
{
  private static String a = "VerifyCodeView";
  private static int b = 2130853427;
  private static int c = 2130853428;
  private static int d = 2130853425;
  private static int e = 2130853426;
  private EditText f;
  private int g;
  private int h;
  private int i;
  private int j;
  private ArrayList<VerifyCodeView.SingleDigitView> k;
  private ArrayList<VerifyCodeView.OnVerifyCodeChangedListener> l;
  private Vibrator m;
  private boolean n;
  private int o;
  private Runnable p;
  private boolean q;
  private Runnable r = new VerifyCodeView.2(this);
  
  public VerifyCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.eX);
    this.g = paramAttributeSet.getInteger(R.styleable.ff, 6);
    this.i = paramAttributeSet.getColor(R.styleable.fb, -16777216);
    this.j = paramAttributeSet.getColor(R.styleable.fc, -65536);
    float f1 = paramAttributeSet.getFloat(R.styleable.fe, 29.0F);
    int i2 = (int)paramAttributeSet.getDimension(R.styleable.fd, 20.0F);
    int i3 = (int)paramAttributeSet.getDimension(R.styleable.eZ, 80.0F);
    int i4 = (int)paramAttributeSet.getDimension(R.styleable.eY, 80.0F);
    this.n = paramAttributeSet.getBoolean(R.styleable.fa, false);
    paramAttributeSet.recycle();
    this.k = new ArrayList();
    this.f = new EditText(paramContext);
    int i1 = 0;
    while (i1 < this.g)
    {
      paramAttributeSet = new VerifyCodeView.SingleDigitView(paramContext, f1, this.i, i3, i4, this.f);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      if (i1 != this.g - 1) {
        localLayoutParams.rightMargin = i2;
      }
      addView(paramAttributeSet, localLayoutParams);
      this.k.add(paramAttributeSet);
      i1 += 1;
    }
    this.f.setCursorVisible(true);
    this.f.setInputType(2);
    this.f.setSingleLine();
    this.f.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.g) });
    this.f.setTextSize(0.0F);
    this.f.setTextColor(0);
    this.f.setBackgroundResource(2131168376);
    addView(this.f);
    this.f.addTextChangedListener(this);
    this.f.setFocusable(true);
    this.f.setFocusableInTouchMode(true);
    this.f.requestFocus();
    e();
    this.h = 0;
    d();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VerifyCodeView.OnVerifyCodeChangedListener)((Iterator)localObject).next()).onVerifyCodeChanged(paramBoolean, getCode());
      }
    }
  }
  
  private void a(boolean paramBoolean, VerifyCodeView.SingleDigitView paramSingleDigitView)
  {
    if ((paramBoolean) && (this.h - this.o == 1))
    {
      paramSingleDigitView.a(false);
      this.p = new VerifyCodeView.1(this, paramSingleDigitView);
      postDelayed(this.p, 400L);
      return;
    }
    paramSingleDigitView.a(true);
  }
  
  private static String b(Context paramContext)
  {
    Object localObject = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (localObject == null) {
      return "";
    }
    ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject);
    localObject = ((ClipboardManager)localObject).getPrimaryClip();
    if (localObject == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < ((ClipData)localObject).getItemCount())
    {
      char[] arrayOfChar = ((ClipData)localObject).getItemAt(i1).coerceToText(paramContext).toString().toCharArray();
      int i3 = arrayOfChar.length;
      int i2 = 0;
      while (i2 < i3)
      {
        char c1 = arrayOfChar[i2];
        if (Character.isDigit(c1)) {
          localStringBuilder.append(c1);
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    int i1 = this.h;
    if ((i1 >= 0) && (i1 < this.k.size()))
    {
      VerifyCodeView.SingleDigitView localSingleDigitView = (VerifyCodeView.SingleDigitView)this.k.get(this.h);
      if (this.q) {
        i1 = e;
      } else {
        i1 = d;
      }
      localSingleDigitView.b(i1);
    }
  }
  
  private void e()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return;
      }
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext())
      {
        VerifyCodeView.SingleDigitView localSingleDigitView = (VerifyCodeView.SingleDigitView)((Iterator)localObject).next();
        localSingleDigitView.a();
        setDigitViewBgByTheme(localSingleDigitView);
      }
    }
  }
  
  private void f()
  {
    try
    {
      if (this.m == null) {
        this.m = ((Vibrator)getContext().getSystemService("vibrator"));
      }
      if (this.m != null)
      {
        this.m.vibrate(50L);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(a, 1, "exception when doVibrate.", localException);
    }
  }
  
  private void setDigitText(String paramString)
  {
    e();
    Object localObject = paramString.toCharArray();
    int i2 = localObject.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (!Character.isDigit(localObject[i1]))
      {
        QLog.e(a, 1, "setCode error: verify code not digit string");
        return;
      }
      i1 += 1;
    }
    this.h = paramString.length();
    if (this.o != this.h) {
      removeCallbacks(this.p);
    }
    for (i1 = 0;; i1 = i2)
    {
      i2 = this.h;
      if (i1 >= i2) {
        break;
      }
      localObject = (VerifyCodeView.SingleDigitView)this.k.get(i1);
      if (this.n)
      {
        boolean bool;
        if (i1 == this.h - 1) {
          bool = true;
        } else {
          bool = false;
        }
        a(bool, (VerifyCodeView.SingleDigitView)localObject);
      }
      i2 = i1 + 1;
      ((VerifyCodeView.SingleDigitView)localObject).a(paramString.substring(i1, i2));
    }
    this.o = i2;
  }
  
  private void setDigitViewBgByTheme(VerifyCodeView.SingleDigitView paramSingleDigitView)
  {
    int i1;
    if (this.q) {
      i1 = c;
    } else {
      i1 = b;
    }
    paramSingleDigitView.b(i1);
  }
  
  private void setStyle(boolean paramBoolean)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      VerifyCodeView.SingleDigitView localSingleDigitView = (VerifyCodeView.SingleDigitView)localIterator.next();
      int i1;
      if (paramBoolean) {
        i1 = this.j;
      } else {
        i1 = this.i;
      }
      localSingleDigitView.a(i1);
      if (paramBoolean) {
        localSingleDigitView.b(2130853429);
      } else {
        setDigitViewBgByTheme(localSingleDigitView);
      }
    }
  }
  
  public void a()
  {
    setStyle(true);
    startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772476));
    f();
    postDelayed(this.r, 1000L);
  }
  
  public void a(InputMethodManager paramInputMethodManager)
  {
    this.f.requestFocus();
    if (paramInputMethodManager != null) {
      paramInputMethodManager.showSoftInput(this.f, 0);
    }
  }
  
  public void a(VerifyCodeView.OnVerifyCodeChangedListener paramOnVerifyCodeChangedListener)
  {
    if (this.l == null) {
      this.l = new ArrayList();
    }
    this.l.add(paramOnVerifyCodeChangedListener);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    setDigitText(paramEditable.toString());
    d();
    boolean bool;
    if (this.h == this.g) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
  }
  
  public void b()
  {
    this.f.setText("");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public String getCode()
  {
    return this.f.getText().toString();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.r);
    removeCallbacks(this.p);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setCode(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void setContextMenuEnable(boolean paramBoolean)
  {
    this.f.setLongClickable(false);
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((VerifyCodeView.SingleDigitView)localIterator.next()).b(paramBoolean);
    }
  }
  
  public void setTheme(boolean paramBoolean)
  {
    this.q = paramBoolean;
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      setDigitViewBgByTheme((VerifyCodeView.SingleDigitView)localIterator.next());
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VerifyCodeView
 * JD-Core Version:    0.7.0.1
 */