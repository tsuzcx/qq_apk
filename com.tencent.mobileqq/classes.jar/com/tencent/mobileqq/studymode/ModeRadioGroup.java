package com.tencent.mobileqq.studymode;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeRadioGroup;", "Landroid/widget/LinearLayout;", "Lcom/tencent/theme/SkinnableView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultItem", "Landroid/widget/RelativeLayout;", "enableCheck", "", "oldType", "onCheckChangeListener", "Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;", "getOnCheckChangeListener", "()Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;", "setOnCheckChangeListener", "(Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;)V", "simpleItem", "studyItem", "cancelLoading", "", "item", "Landroid/view/View;", "cancelLoadingByType", "type", "createItemBackGround", "Landroid/graphics/drawable/Drawable;", "createItemView", "getContentStringByType", "", "kotlin.jvm.PlatformType", "getTitleStringByType", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPostThemeChanged", "onThemeChanged", "selectByType", "needCallback", "showLoading", "showKidModeDialog", "OnCheckChangeListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ModeRadioGroup
  extends LinearLayout
  implements SkinnableView
{
  @Nullable
  private ModeRadioGroup.OnCheckChangeListener a;
  private int b = -1;
  private boolean c = true;
  private RelativeLayout d;
  private RelativeLayout e;
  private RelativeLayout f;
  
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
    Object localObject = ThemeUtil.getCurrentThemeId();
    paramAttributeSet = (CharSequence)"1000";
    localObject = (CharSequence)localObject;
    if ((!TextUtils.equals(paramAttributeSet, (CharSequence)localObject)) && (!TextUtils.equals((CharSequence)"999", (CharSequence)localObject))) {
      break label74;
    }
    label74:
    setBackgroundResource(2130852507);
    setPadding(0, 0, 0, AIOUtils.b(18.0F, paramContext.getResources()));
    this.d = b(0);
    this.e = b(1);
    this.f = b(2);
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
    localObject = ResourcesExtKt.a((Resources)localObject, 2130839554);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = AIOUtils.b(20.0F, localContext.getResources());
    paramView = (ImageView)paramView.findViewById(2131434152);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "loadingImageView");
    paramView.setVisibility(0);
    paramView.setImageDrawable((Drawable)localObject);
    if ((localObject instanceof Animatable)) {
      ((Animatable)localObject).start();
    }
  }
  
  private final Drawable b()
  {
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setCornerRadius(AIOUtils.b(6.0F, getResources()));
    Object localObject2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
    ((GradientDrawable)localObject1).setColor(ResourcesExtKt.b((Resources)localObject2, 2131168147));
    if (QQTheme.isNowThemeIsNight()) {
      ((GradientDrawable)localObject1).setStroke(AIOUtils.b(1.5F, getResources()), Color.parseColor("#0066CC"));
    } else {
      ((GradientDrawable)localObject1).setStroke(AIOUtils.b(1.5F, getResources()), Color.parseColor("#0099ff"));
    }
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.b(6.0F, getResources()));
    Object localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((GradientDrawable)localObject2).setColor(ResourcesExtKt.b((Resources)localObject3, 2131168147));
    int i = AIOUtils.b(1.5F, getResources());
    localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((GradientDrawable)localObject2).setStroke(i, ResourcesExtKt.b((Resources)localObject3, 2131168148));
    localObject3 = new StateListDrawable();
    localObject1 = (Drawable)localObject1;
    ((StateListDrawable)localObject3).addState(new int[] { 16842913 }, (Drawable)localObject1);
    localObject1 = (Drawable)localObject2;
    ((StateListDrawable)localObject3).addState(new int[0], (Drawable)localObject1);
    return (Drawable)localObject3;
  }
  
  private final RelativeLayout b(int paramInt)
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
    ViewExtKt.a((View)localObject2, b());
    addView((View)localObject2);
    localObject2 = new TextView(getContext());
    Object localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((TextView)localObject2).setTextColor(ResourcesExtKt.c((Resources)localObject3, 2131167993));
    ((TextView)localObject2).setTextSize(1, 16.0F);
    ((TextView)localObject2).setText((CharSequence)d(paramInt));
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setId(2131434155);
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
    ((ImageView)localObject3).setId(2131434154);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = AIOUtils.b(20.0F, ((Context)localObject2).getResources());
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject3).setId(2131434152);
    ((ImageView)localObject3).setVisibility(4);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    localObject2 = new TextView(getContext());
    localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((TextView)localObject2).setTextColor(ResourcesExtKt.c((Resources)localObject3, 2131168120));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setMaxLines(3);
    ((TextView)localObject2).setText((CharSequence)e(paramInt));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131434155);
    ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131434154);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(4.0F, localContext.getResources());
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.b(4.0F, localContext.getResources());
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setId(2131434153);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new ModeRadioGroup.createItemView.1(this, paramInt));
    return localObject1;
  }
  
  private final void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "cancelLoading");
    }
    paramView = (ImageView)paramView.findViewById(2131434152);
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
    localQQCustomDialog = localQQCustomDialog.setNegativeButton(localContext.getResources().getString(2131891126), (DialogInterface.OnClickListener)ModeRadioGroup.showKidModeDialog.dialog.1.a);
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog = localQQCustomDialog.setPositiveButton(localContext.getResources().getString(2131891108), (DialogInterface.OnClickListener)new ModeRadioGroup.showKidModeDialog.dialog.2(this, paramInt));
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog = localQQCustomDialog.setTitle(localContext.getResources().getString(2131891110));
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localQQCustomDialog.setMessage((CharSequence)localContext.getResources().getString(2131891109)).show();
  }
  
  private final String d(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        return localContext.getResources().getString(2131889984);
      }
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131889991);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131889988);
  }
  
  private final String e(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        return localContext.getResources().getString(2131889983);
      }
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131889990);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131889987);
  }
  
  public final void a()
  {
    RelativeLayout localRelativeLayout = this.d;
    if (localRelativeLayout != null) {
      ViewExtKt.a((View)localRelativeLayout, b());
    }
    localRelativeLayout = this.e;
    if (localRelativeLayout != null) {
      ViewExtKt.a((View)localRelativeLayout, b());
    }
    localRelativeLayout = this.d;
    if (localRelativeLayout != null) {
      ViewExtKt.a((View)localRelativeLayout, b());
    }
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
      ((StringBuilder)localObject1).append(this.b);
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
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131434154);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "child");
      Object localObject2 = ((View)localObject1).getTag();
      if (((localObject2 instanceof Integer)) && (Intrinsics.areEqual(localObject2, Integer.valueOf(paramInt))))
      {
        if (paramBoolean2) {
          a((View)localObject1);
        }
        localImageView.setImageResource(2130839552);
        ((View)localObject1).setSelected(true);
      }
      else
      {
        localImageView.setImageResource(2130839553);
        ((View)localObject1).setSelected(false);
        b((View)localObject1);
      }
      i += 1;
    }
    if (paramBoolean1)
    {
      localObject1 = this.a;
      if (localObject1 != null) {
        ((ModeRadioGroup.OnCheckChangeListener)localObject1).e(paramInt, this.b);
      }
    }
    this.b = paramInt;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  @Nullable
  public final ModeRadioGroup.OnCheckChangeListener getOnCheckChangeListener()
  {
    return this.a;
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
      ViewExtKt.a(localView, b());
      i += 1;
    }
  }
  
  public final void setOnCheckChangeListener(@Nullable ModeRadioGroup.OnCheckChangeListener paramOnCheckChangeListener)
  {
    this.a = paramOnCheckChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeRadioGroup
 * JD-Core Version:    0.7.0.1
 */