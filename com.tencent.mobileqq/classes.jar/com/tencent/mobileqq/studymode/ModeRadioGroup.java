package com.tencent.mobileqq.studymode;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awhe;
import awhf;
import bcob;
import bcoc;
import bcod;
import bcoe;
import bfur;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeRadioGroup;", "Landroid/widget/LinearLayout;", "Lcom/tencent/theme/SkinnableView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableCheck", "", "oldType", "onCheckChangeListener", "Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;", "getOnCheckChangeListener", "()Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;", "setOnCheckChangeListener", "(Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;)V", "cancelLoading", "", "item", "Landroid/view/View;", "cancelLoadingByType", "type", "createItemBackGround", "Landroid/graphics/drawable/Drawable;", "createItemView", "getContentStringByType", "", "kotlin.jvm.PlatformType", "getTitleStringByType", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onThemeChanged", "selectByType", "needCallback", "showLoading", "showKidModeDialog", "OnCheckChangeListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ModeRadioGroup
  extends LinearLayout
  implements SkinnableView
{
  private int jdField_a_of_type_Int = -1;
  @Nullable
  private bcob jdField_a_of_type_Bcob;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ModeRadioGroup(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ModeRadioGroup(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ModeRadioGroup(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    setGravity(16);
    paramContext = ThemeUtil.getCurrentThemeId();
    if ((TextUtils.equals((CharSequence)"1000", (CharSequence)paramContext)) || (TextUtils.equals((CharSequence)"999", (CharSequence)paramContext))) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {}
      setBackgroundResource(2130850271);
      b(0);
      b(1);
      b(2);
      return;
    }
  }
  
  private final Drawable a()
  {
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setCornerRadius(AIOUtils.dp2px(6.0F, getResources()));
    Object localObject2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
    ((GradientDrawable)localObject1).setColor(awhe.a((Resources)localObject2, 2131167118));
    int i = AIOUtils.dp2px(1.5F, getResources());
    localObject2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
    ((GradientDrawable)localObject1).setStroke(i, awhe.a((Resources)localObject2, 2131167120));
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.dp2px(6.0F, getResources()));
    Object localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((GradientDrawable)localObject2).setColor(awhe.a((Resources)localObject3, 2131167118));
    i = AIOUtils.dp2px(1.5F, getResources());
    localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((GradientDrawable)localObject2).setStroke(i, awhe.a((Resources)localObject3, 2131167119));
    localObject3 = new StateListDrawable();
    localObject1 = (Drawable)localObject1;
    ((StateListDrawable)localObject3).addState(new int[] { 16842913 }, (Drawable)localObject1);
    localObject1 = (Drawable)localObject2;
    ((StateListDrawable)localObject3).addState(new int[0], (Drawable)localObject1);
    return (Drawable)localObject3;
  }
  
  private final String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131692667);
    case 2: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131692674);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131692671);
  }
  
  private final void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "showLoading");
    }
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
    localObject = awhe.a((Resources)localObject, 2130839416);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = AIOUtils.dp2px(20.0F, localContext.getResources());
    paramView = (ImageView)paramView.findViewById(2131367503);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "loadingImageView");
    paramView.setVisibility(0);
    paramView.setImageDrawable((Drawable)localObject);
    if ((localObject instanceof Animatable)) {
      ((Animatable)localObject).start();
    }
  }
  
  private final String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131692666);
    case 2: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131692673);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131692670);
  }
  
  private final void b(int paramInt)
  {
    Object localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    int i = AIOUtils.dp2px(16.0F, ((Context)localObject1).getResources());
    localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    localObject1 = ((Context)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources");
    int j = (((Resources)localObject1).getDisplayMetrics().widthPixels - i * 4) / 3;
    localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    Object localObject2 = new LinearLayout.LayoutParams(j, AIOUtils.dp2px(115.0F, ((Context)localObject1).getResources()));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
    localObject1 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject1).setTag(Integer.valueOf(paramInt));
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = AIOUtils.dp2px(8.0F, ((Context)localObject2).getResources());
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    ((RelativeLayout)localObject1).setPadding(i, AIOUtils.dp2px(12.0F, ((Context)localObject2).getResources()), i, i);
    awhf.a((View)localObject1, a());
    addView((View)localObject1);
    localObject2 = new TextView(getContext());
    Object localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((TextView)localObject2).setTextColor(awhe.a((Resources)localObject3, 2131167012));
    ((TextView)localObject2).setTextSize(1, 16.0F);
    ((TextView)localObject2).setText((CharSequence)a(paramInt));
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setId(2131367506);
    localObject3 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "context");
    ((TextView)localObject2).setCompoundDrawablePadding(AIOUtils.dp2px(5.0F, ((Context)localObject3).getResources()));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = AIOUtils.dp2px(16.0F, ((Context)localObject2).getResources());
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject3).setId(2131367505);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = AIOUtils.dp2px(20.0F, ((Context)localObject2).getResources());
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject3).setId(2131367503);
    ((ImageView)localObject3).setVisibility(4);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    localObject2 = new TextView(getContext());
    localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((TextView)localObject2).setTextColor(awhe.a((Resources)localObject3, 2131167094));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setMaxLines(3);
    ((TextView)localObject2).setText((CharSequence)b(paramInt));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131367506);
    ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131367505);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(4.0F, localContext.getResources());
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.dp2px(4.0F, localContext.getResources());
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setId(2131367504);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new bcoc(this, paramInt));
  }
  
  private final void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "cancelLoading");
    }
    paramView = (ImageView)paramView.findViewById(2131367503);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "loadingImageView");
    Drawable localDrawable = paramView.getDrawable();
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    paramView.setVisibility(4);
  }
  
  private final void c(int paramInt)
  {
    QQCustomDialog localQQCustomDialog = bfur.a(getContext(), 230);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog = localQQCustomDialog.setNegativeButton(localContext.getResources().getString(2131693274), (DialogInterface.OnClickListener)bcod.a);
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog = localQQCustomDialog.setPositiveButton(localContext.getResources().getString(2131693256), (DialogInterface.OnClickListener)new bcoe(this, paramInt));
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog = localQQCustomDialog.setTitle(localContext.getResources().getString(2131693258));
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog.setMessage((CharSequence)localContext.getResources().getString(2131693257)).show();
  }
  
  public final void a(int paramInt)
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "child");
      Object localObject = localView.getTag();
      if (((localObject instanceof Integer)) && (Intrinsics.areEqual(localObject, Integer.valueOf(paramInt)))) {
        b(localView);
      }
      i += 1;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "selectByType type : " + paramInt + ", old type : " + this.jdField_a_of_type_Int + ", needCallback : " + paramBoolean1 + ", showLoading : " + paramBoolean2);
    }
    int j = getChildCount();
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = getChildAt(i);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131367505);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "child");
      Object localObject2 = ((View)localObject1).getTag();
      if (((localObject2 instanceof Integer)) && (Intrinsics.areEqual(localObject2, Integer.valueOf(paramInt))))
      {
        if (paramBoolean2) {
          a((View)localObject1);
        }
        localImageView.setImageResource(2130839414);
        ((View)localObject1).setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setImageResource(2130839415);
        ((View)localObject1).setSelected(false);
        b((View)localObject1);
      }
    }
    if (paramBoolean1)
    {
      localObject1 = this.jdField_a_of_type_Bcob;
      if (localObject1 != null) {
        ((bcob)localObject1).a(paramInt, this.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void onConfigurationChanged(@Nullable Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramConfiguration, "context");
    int j = AIOUtils.dp2px(16.0F, paramConfiguration.getResources());
    int i = 0;
    int k = getChildCount();
    while (i < k)
    {
      paramConfiguration = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(paramConfiguration, "child");
      paramConfiguration = paramConfiguration.getLayoutParams();
      Object localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
      paramConfiguration.width = ((((Resources)localObject).getDisplayMetrics().widthPixels - j * 4) / 3);
      i += 1;
    }
    requestLayout();
  }
  
  public void onThemeChanged()
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "getChildAt(index)");
      awhf.a(localView, null);
      localView = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "getChildAt(index)");
      awhf.a(localView, a());
      i += 1;
    }
  }
  
  public final void setOnCheckChangeListener(@Nullable bcob parambcob)
  {
    this.jdField_a_of_type_Bcob = parambcob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeRadioGroup
 * JD-Core Version:    0.7.0.1
 */