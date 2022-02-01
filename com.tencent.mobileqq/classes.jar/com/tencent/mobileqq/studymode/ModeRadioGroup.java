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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.mvvm.ResourcesExtKt;
import com.tencent.mobileqq.mvvm.ViewExtKt;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  private ModeRadioGroup.OnCheckChangeListener jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup$OnCheckChangeListener;
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
    paramAttributeSet = ThemeUtil.getCurrentThemeId();
    paramContext = (CharSequence)"1000";
    paramAttributeSet = (CharSequence)paramAttributeSet;
    if ((!TextUtils.equals(paramContext, paramAttributeSet)) && (!TextUtils.equals((CharSequence)"999", paramAttributeSet))) {
      break label75;
    }
    label75:
    setBackgroundResource(2130850703);
    b(0);
    b(1);
    b(2);
  }
  
  private final Drawable a()
  {
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setCornerRadius(AIOUtils.b(6.0F, getResources()));
    Object localObject2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
    ((GradientDrawable)localObject1).setColor(ResourcesExtKt.a((Resources)localObject2, 2131167164));
    int i = AIOUtils.b(1.5F, getResources());
    localObject2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
    ((GradientDrawable)localObject1).setStroke(i, ResourcesExtKt.a((Resources)localObject2, 2131167166));
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.b(6.0F, getResources()));
    Object localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((GradientDrawable)localObject2).setColor(ResourcesExtKt.a((Resources)localObject3, 2131167164));
    i = AIOUtils.b(1.5F, getResources());
    localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((GradientDrawable)localObject2).setStroke(i, ResourcesExtKt.a((Resources)localObject3, 2131167165));
    localObject3 = new StateListDrawable();
    localObject1 = (Drawable)localObject1;
    ((StateListDrawable)localObject3).addState(new int[] { 16842913 }, (Drawable)localObject1);
    localObject1 = (Drawable)localObject2;
    ((StateListDrawable)localObject3).addState(new int[0], (Drawable)localObject1);
    return (Drawable)localObject3;
  }
  
  private final String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        return localContext.getResources().getString(2131692873);
      }
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131692880);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131692877);
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
    localObject = ResourcesExtKt.a((Resources)localObject, 2130839372);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = AIOUtils.b(20.0F, localContext.getResources());
    paramView = (ImageView)paramView.findViewById(2131367609);
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        return localContext.getResources().getString(2131692872);
      }
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131692879);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131692876);
  }
  
  private final void b(int paramInt)
  {
    Object localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    int i = AIOUtils.b(16.0F, ((Context)localObject1).getResources());
    localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    localObject1 = ((Context)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources");
    int j = (((Resources)localObject1).getDisplayMetrics().widthPixels - i * 4) / 3;
    localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    Object localObject2 = new LinearLayout.LayoutParams(j, AIOUtils.b(115.0F, ((Context)localObject1).getResources()));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
    localObject1 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject1).setTag(Integer.valueOf(paramInt));
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = AIOUtils.b(8.0F, ((Context)localObject2).getResources());
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    ((RelativeLayout)localObject1).setPadding(i, AIOUtils.b(12.0F, ((Context)localObject2).getResources()), i, i);
    localObject2 = (View)localObject1;
    ViewExtKt.a((View)localObject2, a());
    addView((View)localObject2);
    localObject2 = new TextView(getContext());
    Object localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((TextView)localObject2).setTextColor(ResourcesExtKt.a((Resources)localObject3, 2131167056));
    ((TextView)localObject2).setTextSize(1, 16.0F);
    ((TextView)localObject2).setText((CharSequence)a(paramInt));
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setId(2131367612);
    localObject3 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "context");
    ((TextView)localObject2).setCompoundDrawablePadding(AIOUtils.b(5.0F, ((Context)localObject3).getResources()));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = AIOUtils.b(16.0F, ((Context)localObject2).getResources());
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject3).setId(2131367611);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = AIOUtils.b(20.0F, ((Context)localObject2).getResources());
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject3).setId(2131367609);
    ((ImageView)localObject3).setVisibility(4);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    localObject2 = new TextView(getContext());
    localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((TextView)localObject2).setTextColor(ResourcesExtKt.a((Resources)localObject3, 2131167140));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setMaxLines(3);
    ((TextView)localObject2).setText((CharSequence)b(paramInt));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131367612);
    ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131367611);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(4.0F, localContext.getResources());
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.b(4.0F, localContext.getResources());
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setId(2131367610);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new ModeRadioGroup.createItemView.1(this, paramInt));
  }
  
  private final void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "cancelLoading");
    }
    paramView = (ImageView)paramView.findViewById(2131367609);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "loadingImageView");
    Drawable localDrawable = paramView.getDrawable();
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    paramView.setVisibility(4);
  }
  
  private final void c(int paramInt)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getContext(), 230);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog = localQQCustomDialog.setNegativeButton(localContext.getResources().getString(2131693562), (DialogInterface.OnClickListener)ModeRadioGroup.showKidModeDialog.dialog.1.a);
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog = localQQCustomDialog.setPositiveButton(localContext.getResources().getString(2131693544), (DialogInterface.OnClickListener)new ModeRadioGroup.showKidModeDialog.dialog.2(this, paramInt));
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog = localQQCustomDialog.setTitle(localContext.getResources().getString(2131693546));
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog.setMessage((CharSequence)localContext.getResources().getString(2131693545)).show();
  }
  
  public final void a(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("selectByType type : ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", old type : ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(", needCallback : ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(", showLoading : ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      QLog.d("GeneralModeRadioGroup", 2, ((StringBuilder)localObject1).toString());
      QLog.d("GeneralModeRadioGroup", 2, "stack: ", new Throwable("selectByType"));
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject1 = getChildAt(i);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131367611);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "child");
      Object localObject2 = ((View)localObject1).getTag();
      if (((localObject2 instanceof Integer)) && (Intrinsics.areEqual(localObject2, Integer.valueOf(paramInt))))
      {
        if (paramBoolean2) {
          a((View)localObject1);
        }
        localImageView.setImageResource(2130839370);
        ((View)localObject1).setSelected(true);
      }
      else
      {
        localImageView.setImageResource(2130839371);
        ((View)localObject1).setSelected(false);
        b((View)localObject1);
      }
      i += 1;
    }
    if (paramBoolean1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup$OnCheckChangeListener;
      if (localObject1 != null) {
        ((ModeRadioGroup.OnCheckChangeListener)localObject1).a(paramInt, this.jdField_a_of_type_Int);
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
    int j = AIOUtils.b(16.0F, paramConfiguration.getResources());
    int k = getChildCount();
    int i = 0;
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
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "getChildAt(index)");
      ViewExtKt.a(localView, null);
      localView = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "getChildAt(index)");
      ViewExtKt.a(localView, a());
      i += 1;
    }
  }
  
  public final void setOnCheckChangeListener(@Nullable ModeRadioGroup.OnCheckChangeListener paramOnCheckChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup$OnCheckChangeListener = paramOnCheckChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeRadioGroup
 * JD-Core Version:    0.7.0.1
 */