package com.tencent.mobileqq.widget;

import ajjy;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bbos;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.theme.SkinnableBitmapDrawable;

public class TipsBar
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public TipsBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = getResources();
    this.jdField_a_of_type_Float = localResources.getDisplayMetrics().density;
    this.jdField_b_of_type_Int = localResources.getDimensionPixelSize(2131167169);
    this.e = localResources.getDimensionPixelSize(2131167171);
    this.f = localResources.getDimensionPixelSize(2131167173);
    this.jdField_c_of_type_Int = localResources.getDimensionPixelSize(2131167172);
    this.d = localResources.getDimensionPixelSize(2131167172);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TipsBar);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(6);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(5);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(1);
    this.jdField_a_of_type_Int = paramContext.getInt(0, 2);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(4, false);
    this.g = paramContext.getDimensionPixelSize(3, this.jdField_c_of_type_Int);
    this.h = paramContext.getDimensionPixelSize(2, this.d);
    paramContext.recycle();
    b();
  }
  
  protected static ColorStateList a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return paramResources.getColorStateList(2131101292);
    }
    return paramResources.getColorStateList(2131101292);
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return paramResources.getDrawable(2130839032);
  }
  
  protected static ColorStateList b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131101267);
    case 4: 
      return paramResources.getColorStateList(2131101403);
    }
    return paramResources.getColorStateList(2131101267);
  }
  
  private Button b()
  {
    Resources localResources = getResources();
    Button localButton = new Button(getContext());
    localButton.setText(this.jdField_b_of_type_JavaLangString);
    localButton.setContentDescription(this.jdField_b_of_type_JavaLangString);
    localButton.setTextSize(2, 14.0F);
    localButton.setTextColor(a(localResources, this.jdField_a_of_type_Int));
    localButton.setMinWidth((int)(this.jdField_a_of_type_Float * 48.0F + 0.5D));
    localButton.setMinHeight((int)(this.jdField_a_of_type_Float * 24.0F + 0.5D));
    localButton.setSingleLine(true);
    localButton.setEllipsize(TextUtils.TruncateAt.END);
    localButton.setGravity(17);
    localButton.setBackgroundDrawable(a(localResources, this.jdField_a_of_type_Int));
    int i = (int)(this.jdField_a_of_type_Float * 10.0F + 0.5D);
    localButton.setPadding(i, i / 2, i, i / 2);
    localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return localButton;
  }
  
  private ImageView b()
  {
    Object localObject = getResources();
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localObject = d((Resources)localObject, this.jdField_a_of_type_Int);
    localImageView.setPadding(15, 15, 15, 15);
    localImageView.setImageDrawable((Drawable)localObject);
    localImageView.setOnClickListener(new bbos(this));
    if (AppSetting.c) {
      localImageView.setContentDescription(ajjy.a(2131649197));
    }
    return localImageView;
  }
  
  private void b()
  {
    setFocusable(true);
    setClickable(true);
    Resources localResources = getResources();
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131311526);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.g, this.h);
    localLayoutParams.leftMargin = this.e;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131311527);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(b(localResources, this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localLayoutParams.leftMargin = this.f;
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(1, 2131311526);
      localLayoutParams.addRule(0, 2131311528);
      addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        setTipsIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.g, this.h);
      }
      this.jdField_a_of_type_AndroidWidgetButton = b();
      this.jdField_c_of_type_AndroidWidgetImageView = b();
      this.jdField_b_of_type_AndroidWidgetImageView = c();
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label366;
      }
      e();
    }
    for (;;)
    {
      setBackgroundDrawable(b(localResources, this.jdField_a_of_type_Int));
      a();
      return;
      localLayoutParams.leftMargin = this.e;
      break;
      label366:
      if (this.jdField_a_of_type_Boolean) {
        c();
      } else {
        d();
      }
    }
  }
  
  private ImageView c()
  {
    Resources localResources = getResources();
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localImageView.setImageDrawable(c(localResources, this.jdField_a_of_type_Int));
    return localImageView;
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setId(2131311528);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = this.e;
      localLayoutParams.leftMargin = this.e;
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.jdField_c_of_type_AndroidWidgetImageView, localLayoutParams);
    }
  }
  
  private Drawable d(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (paramResources = paramResources.getDrawable(2130839176);; paramResources = paramResources.getDrawable(2130839176)) {
      return a(paramResources);
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2131311528);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.e;
    localLayoutParams.leftMargin = this.e;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = this.e;
      localLayoutParams.leftMargin = this.e;
      this.jdField_a_of_type_AndroidWidgetButton.setId(2131311528);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  Drawable a(Drawable paramDrawable)
  {
    Object localObject2;
    Object localObject1;
    Bitmap localBitmap;
    Resources localResources;
    if (!(paramDrawable instanceof SkinnableBitmapDrawable))
    {
      localObject2 = paramDrawable;
      if (!(paramDrawable instanceof BitmapDrawable)) {}
    }
    else
    {
      localObject1 = null;
      if (!(paramDrawable instanceof SkinnableBitmapDrawable)) {
        break label143;
      }
      localObject1 = ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
      localBitmap = Bitmap.createBitmap((Bitmap)localObject1);
      localResources = getResources();
      localObject2 = paramDrawable;
      if (localResources != null)
      {
        if ((localObject1 == null) || (localBitmap != null)) {
          break label161;
        }
        localObject2 = localObject1;
      }
    }
    label143:
    label161:
    do
    {
      do
      {
        paramDrawable = new BitmapDrawable(localResources, (Bitmap)localObject1);
        localObject1 = new BitmapDrawable(localResources, (Bitmap)localObject2);
        ((BitmapDrawable)localObject1).setAlpha(127);
        localObject2 = new StateListDrawable();
        ((StateListDrawable)localObject2).addState(new int[] { 16842919, 16842910 }, (Drawable)localObject1);
        ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, paramDrawable);
        ((StateListDrawable)localObject2).addState(new int[0], paramDrawable);
        return localObject2;
        if (!(paramDrawable instanceof BitmapDrawable)) {
          break;
        }
        localObject1 = ((BitmapDrawable)paramDrawable).getBitmap();
        break;
        localObject2 = localBitmap;
      } while (localObject1 != null);
      localObject2 = localBitmap;
    } while (localBitmap != null);
    return paramDrawable;
  }
  
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    if (ThemeUtil.isNowThemeIsNight(null, true, null)) {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewView = new View(getContext());
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#7f000000"));
        addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      }
    }
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = c();
    }
    removeView(this.jdField_b_of_type_AndroidWidgetImageView);
    removeView(this.jdField_a_of_type_AndroidWidgetButton);
    removeView(this.jdField_c_of_type_AndroidWidgetImageView);
    if (paramBoolean) {
      d();
    }
  }
  
  protected Drawable b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramResources = paramResources.getDrawable(2130839104);
    }
    for (;;)
    {
      return a(paramResources);
      paramResources = paramResources.getDrawable(2130839104);
      continue;
      paramResources = paramResources.getDrawable(2130839172);
      continue;
      paramResources = paramResources.getDrawable(2130839168);
      continue;
      paramResources = paramResources.getDrawable(2130839105);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
      this.jdField_c_of_type_AndroidWidgetImageView = b();
    }
    removeView(this.jdField_c_of_type_AndroidWidgetImageView);
    removeView(this.jdField_a_of_type_AndroidWidgetButton);
    removeView(this.jdField_b_of_type_AndroidWidgetImageView);
    if (paramBoolean) {
      c();
    }
  }
  
  protected Drawable c(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (paramResources = paramResources.getDrawable(2130848851);; paramResources = paramResources.getDrawable(2130839167)) {
      return a(paramResources);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_b_of_type_Int);
  }
  
  public void setBarType(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    if (paramInt == this.jdField_a_of_type_Int) {}
    Resources localResources;
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      localResources = getResources();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(b(localResources, this.jdField_a_of_type_Int));
      }
      setBackgroundDrawable(b(localResources, this.jdField_a_of_type_Int));
      Drawable localDrawable;
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localDrawable = c(localResources, this.jdField_a_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        localDrawable = d(localResources, this.jdField_a_of_type_Int);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
    } while (this.jdField_a_of_type_AndroidWidgetButton == null);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(a(localResources, this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a(localResources, this.jdField_a_of_type_Int));
  }
  
  public void setButtonText(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.jdField_a_of_type_AndroidWidgetButton == null) {
        this.jdField_a_of_type_AndroidWidgetButton = b();
      }
      removeView(this.jdField_a_of_type_AndroidWidgetButton);
      removeView(this.jdField_b_of_type_AndroidWidgetImageView);
      removeView(this.jdField_c_of_type_AndroidWidgetImageView);
      this.jdField_b_of_type_JavaLangString = paramCharSequence.toString();
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_b_of_type_JavaLangString);
      e();
    }
  }
  
  public void setCloseListener(View.OnClickListener paramOnClickListener)
  {
    if ((paramOnClickListener != null) && (this.jdField_c_of_type_AndroidWidgetImageView != null)) {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidWidgetButton != null))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    super.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void setOriginalOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setTipsIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.f;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramDrawable);
    int i = paramDrawable.getIntrinsicHeight();
    paramDrawable.setBounds(0, 0, this.jdField_c_of_type_Int, this.d);
    if (i > this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setTipsIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramDrawable);
        this.g = paramInt1;
        this.h = Math.min(this.jdField_b_of_type_Int, paramInt2);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.g, this.h);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setTipsIcon(paramDrawable);
  }
  
  public void setTipsText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TipsBar
 * JD-Core Version:    0.7.0.1
 */