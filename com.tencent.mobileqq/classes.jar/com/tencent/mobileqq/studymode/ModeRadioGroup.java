package com.tencent.mobileqq.studymode;

import aekt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
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
import azwj;
import azwk;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeRadioGroup;", "Landroid/widget/LinearLayout;", "Lcom/tencent/theme/SkinnableView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableCheck", "", "oldType", "onCheckChangeListener", "Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;", "getOnCheckChangeListener", "()Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;", "setOnCheckChangeListener", "(Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;)V", "cancelLoading", "", "item", "Landroid/view/View;", "cancelLoadingByType", "type", "createItemBackGround", "Landroid/graphics/drawable/Drawable;", "createItemView", "getContentStringByType", "", "kotlin.jvm.PlatformType", "getTitleStringByType", "onThemeChanged", "selectByType", "needCallback", "showLoading", "OnCheckChangeListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ModeRadioGroup
  extends LinearLayout
  implements SkinnableView
{
  private int jdField_a_of_type_Int = -1;
  @Nullable
  private azwj jdField_a_of_type_Azwj;
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
      setBackgroundResource(2130849679);
      b(0);
      b(1);
      b(2);
      return;
    }
  }
  
  private final Drawable a()
  {
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(aekt.a(6.0F, getResources()));
    ((GradientDrawable)localObject2).setColor(getResources().getColor(2131167001));
    ((GradientDrawable)localObject2).setStroke(aekt.a(1.5F, getResources()), getResources().getColor(2131167003));
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setCornerRadius(aekt.a(6.0F, getResources()));
    ((GradientDrawable)localObject1).setColor(getResources().getColor(2131167001));
    ((GradientDrawable)localObject1).setStroke(aekt.a(1.5F, getResources()), getResources().getColor(2131167002));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localObject2 = (Drawable)localObject2;
    localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject2);
    localObject1 = (Drawable)localObject1;
    localStateListDrawable.addState(new int[0], (Drawable)localObject1);
    return (Drawable)localStateListDrawable;
  }
  
  private final String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131693077);
    case 2: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131693082);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131693080);
  }
  
  private final void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "showLoading");
    }
    paramView = (TextView)paramView.findViewById(2131367113);
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getDrawable(2130839196);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = aekt.a(20.0F, localContext.getResources());
    ((Drawable)localObject).setBounds(0, 0, i, i);
    paramView.setCompoundDrawables(null, null, (Drawable)localObject, null);
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
      return localContext.getResources().getString(2131693076);
    case 2: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131693081);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131693079);
  }
  
  private final void b(int paramInt)
  {
    Object localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    int i = aekt.a(16.0F, ((Context)localObject1).getResources());
    localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    localObject1 = ((Context)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources");
    int j = (((Resources)localObject1).getDisplayMetrics().widthPixels - i * 4) / 3;
    localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    Object localObject2 = new LinearLayout.LayoutParams(j, aekt.a(115.0F, ((Context)localObject1).getResources()));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
    localObject1 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject1).setTag(Integer.valueOf(paramInt));
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = aekt.a(8.0F, ((Context)localObject2).getResources());
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    ((RelativeLayout)localObject1).setPadding(i, aekt.a(12.0F, ((Context)localObject2).getResources()), i, i);
    ((RelativeLayout)localObject1).setBackgroundDrawable(a());
    addView((View)localObject1);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setTextColor(getResources().getColorStateList(2131166901));
    ((TextView)localObject2).setTextSize(1, 16.0F);
    ((TextView)localObject2).setText((CharSequence)a(paramInt));
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setId(2131367113);
    Object localObject3 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "context");
    ((TextView)localObject2).setCompoundDrawablePadding(aekt.a(5.0F, ((Context)localObject3).getResources()));
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setTextColor(getResources().getColorStateList(2131166977));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    ((TextView)localObject2).setText((CharSequence)b(paramInt));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131367113);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RelativeLayout.LayoutParams)localObject3).topMargin = aekt.a(4.0F, localContext.getResources());
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setId(2131367111);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = aekt.a(16.0F, ((Context)localObject2).getResources());
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject3).setId(2131367112);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new azwk(this, paramInt));
  }
  
  private final void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "cancelLoading");
    }
    paramView = (TextView)paramView.findViewById(2131367113);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "titleText");
    Drawable localDrawable = paramView.getCompoundDrawables()[2];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    paramView.setCompoundDrawables(null, null, null, null);
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
      QLog.d("GeneralModeRadioGroup", 2, "selectByType type : " + paramInt + ", needCallback : " + paramBoolean1 + ", showLoading : " + paramBoolean2);
    }
    int j = getChildCount();
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = getChildAt(i);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131367112);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "child");
      Object localObject2 = ((View)localObject1).getTag();
      if (((localObject2 instanceof Integer)) && (Intrinsics.areEqual(localObject2, Integer.valueOf(paramInt))))
      {
        if (paramBoolean2) {
          a((View)localObject1);
        }
        localImageView.setImageResource(2130839194);
        ((View)localObject1).setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setImageResource(2130839195);
        ((View)localObject1).setSelected(false);
        b((View)localObject1);
      }
    }
    if (paramBoolean1)
    {
      localObject1 = this.jdField_a_of_type_Azwj;
      if (localObject1 != null) {
        ((azwj)localObject1).a(paramInt, this.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onThemeChanged()
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      getChildAt(i).setBackgroundDrawable(null);
      getChildAt(i).setBackgroundDrawable(a());
      i += 1;
    }
  }
  
  public final void setOnCheckChangeListener(@Nullable azwj paramazwj)
  {
    this.jdField_a_of_type_Azwj = paramazwj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeRadioGroup
 * JD-Core Version:    0.7.0.1
 */