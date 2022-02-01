package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class FormSwitchItem
  extends RelativeLayout
  implements FormItemConstants
{
  private CharSequence a;
  private int b;
  private boolean c;
  protected Switch d;
  protected boolean e;
  private int f;
  private int l;
  private TextView m;
  private Drawable n;
  private int o;
  private int p;
  private Drawable q;
  private int r;
  private int s;
  private final Rect t = new Rect();
  private final Paint u = new Paint();
  private ColorStateList v = getResources().getColorStateList(2131167993);
  
  public FormSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(2131298976);
    int j = getResources().getDimensionPixelSize(2131297097);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aS);
    this.l = paramContext.getDimensionPixelSize(R.styleable.aV, i);
    this.f = paramContext.getDimensionPixelSize(R.styleable.aU, j);
    this.a = paramContext.getString(R.styleable.bm);
    this.n = paramContext.getDrawable(R.styleable.aY);
    this.o = paramContext.getDimensionPixelSize(R.styleable.ba, 0);
    this.p = paramContext.getDimensionPixelSize(R.styleable.aZ, 0);
    this.p = Math.min(this.f, this.p);
    this.q = paramContext.getDrawable(R.styleable.bf);
    this.r = paramContext.getDimensionPixelSize(R.styleable.bh, 0);
    this.s = paramContext.getDimensionPixelSize(R.styleable.bg, 0);
    this.s = Math.min(this.f, this.s);
    this.c = paramContext.getBoolean(R.styleable.bl, false);
    this.b = paramContext.getInt(R.styleable.aT, 0);
    paramContext.recycle();
    this.e = true;
    this.u.setAntiAlias(true);
    this.u.setColor(FormItemConstants.h);
    c();
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramResources.getDrawable(2130852507);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramResources.getDrawable(2130852507);
          }
          return paramResources.getDrawable(2130852512);
        }
        return paramResources.getDrawable(2130852521);
      }
      return paramResources.getDrawable(2130852527);
    }
    return paramResources.getDrawable(2130852507);
  }
  
  private boolean b()
  {
    return QQUIDelegate.a();
  }
  
  private void c()
  {
    this.m = new TextView(getContext());
    this.m.setId(2131433633);
    if (!TextUtils.isEmpty(this.a)) {
      this.m.setText(this.a);
    }
    this.m.setSingleLine(true);
    int i = getContext().getResources().getDimensionPixelSize(2131297095);
    this.m.setTextSize(0, i);
    this.m.setTextColor(this.v);
    this.m.setGravity(19);
    this.m.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.n, this.o, this.p);
    setRightIcon(this.q, this.r, this.s);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.l;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.m, localLayoutParams);
    this.d = new Switch(getContext());
    this.d.setChecked(this.c);
    if ((QQUIDelegate.b) && (Build.VERSION.SDK_INT >= 16))
    {
      AccessibilityUtil.a(this.m, false);
      AccessibilityUtil.a(this.d, false);
      if (TextUtils.isEmpty(getContentDescription())) {
        setContentDescription(this.m.getText());
      }
    }
    this.d.setId(2131433632);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.l;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.d, localLayoutParams);
    setBackgroundDrawable(a(getResources(), this.b, b()));
  }
  
  public boolean a()
  {
    Switch localSwitch = this.d;
    if (localSwitch != null) {
      return localSwitch.isChecked();
    }
    return false;
  }
  
  public Switch getSwitch()
  {
    return this.d;
  }
  
  public TextView getTextView()
  {
    return this.m;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = this.b;
    if ((i == 1) || (i == 2))
    {
      if (b()) {
        this.u.setColor(FormItemConstants.h);
      } else {
        this.u.setColor(0);
      }
      i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.t.set(FormItemConstants.i, j - FormItemConstants.g, i, j);
      paramCanvas.drawRect(this.t, this.u);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Switch localSwitch = this.d;
    if ((localSwitch != null) && (localSwitch.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.d.isChecked());
      paramAccessibilityNodeInfo.setClassName(Switch.class.getName());
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.e) {
      try
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.f);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FormSwitchItem", 2, localException.toString());
        }
        setMinimumHeight(this.f);
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QQUIDelegate.b)
    {
      Switch localSwitch = this.d;
      if ((localSwitch != null) && (localSwitch.getVisibility() == 0))
      {
        if (paramMotionEvent.getAction() == 0)
        {
          super.onTouchEvent(paramMotionEvent);
          return true;
        }
        if (paramMotionEvent.getAction() == 1)
        {
          paramMotionEvent = this.d;
          paramMotionEvent.setChecked(paramMotionEvent.isChecked() ^ true);
        }
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.b = paramInt;
    setBackgroundDrawable(a(getResources(), this.b, b()));
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Switch localSwitch = this.d;
    if (localSwitch != null)
    {
      localSwitch.setChecked(paramBoolean);
      sendAccessibilityEvent(1);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.f = paramInt;
      requestLayout();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(false);
    Object localObject = this.m;
    if (localObject != null) {
      ((TextView)localObject).setEnabled(paramBoolean);
    }
    localObject = this.d;
    if (localObject != null) {
      ((Switch)localObject).setEnabled(paramBoolean);
    }
  }
  
  public void setLeftIcon(int paramInt)
  {
    setLeftIcon(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.m;
    if (localTextView != null)
    {
      this.n = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.f)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.f);
        this.m.setCompoundDrawables(paramDrawable, null, null, null);
      }
      else
      {
        this.m.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      }
      this.m.setCompoundDrawablePadding(this.l);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.m != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.n = paramDrawable;
        this.o = paramInt1;
        this.p = Math.min(this.f, paramInt2);
        paramDrawable.setBounds(0, 0, this.o, this.p);
        this.m.setCompoundDrawables(paramDrawable, null, null, null);
        this.m.setCompoundDrawablePadding(this.l);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setRightIcon(paramDrawable);
      }
    }
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    Switch localSwitch = this.d;
    if (localSwitch != null) {
      localSwitch.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.m;
    if (localTextView != null)
    {
      this.q = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.f)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.f);
        this.m.setCompoundDrawables(null, null, paramDrawable, null);
      }
      else
      {
        this.m.setCompoundDrawablesWithIntrinsicBounds(null, null, paramDrawable, null);
      }
      this.m.setCompoundDrawablePadding(this.l);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.m != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.q = paramDrawable;
        this.r = paramInt1;
        this.s = Math.min(this.f, paramInt2);
        paramDrawable.setBounds(0, 0, this.r, this.s);
        this.m.setCompoundDrawables(null, null, paramDrawable, null);
        this.m.setCompoundDrawablePadding(this.l);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setRightIcon(paramDrawable);
      }
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.m != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        this.a = paramCharSequence;
        this.m.setText(this.a);
        this.m.setTextColor(this.v);
        return;
      }
      this.m.setVisibility(8);
    }
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.v = paramColorStateList;
    this.m.setTextColor(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSwitchItem
 * JD-Core Version:    0.7.0.1
 */