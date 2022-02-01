package com.tencent.mobileqq.kandian.biz.xtab;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabLayout;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "immersiveColor", "immersiveMode", "", "indicator", "Landroid/view/View;", "itemList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "lastOffset", "", "needDeferAnimation", "normalSelectedTextColor", "normalTextColor", "redPointHandler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "itemView", "tabChannelInfo", "", "getRedPointHandler", "()Lkotlin/jvm/functions/Function2;", "setRedPointHandler", "(Lkotlin/jvm/functions/Function2;)V", "scrollState", "selectedIndex", "tabLayout", "Landroid/widget/LinearLayout;", "viewPagerController", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;", "animateSelectedTab", "textView", "Landroid/widget/TextView;", "animateTabTitle", "animateUnselectedTab", "doOnPageSelected", "index", "getTargetTranslateX", "handleTabClick", "data", "position", "init", "layoutInflater", "Landroid/view/LayoutInflater;", "isOutOfIndex", "moveIndicatorByOffset", "currentIndex", "targetIndex", "offset", "moveIndicatorToTargetIndex", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPageScrollStateChanged", "state", "onPageScrolled", "positionOffsetPixels", "onPageSelected", "settleIndicator", "switchImmersiveMode", "immersive", "updateBadge", "updateItem", "updateUI", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabLayout
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  public static final RIJXTabLayout.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RIJXTabViewPagerController jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList = (List)new ArrayList();
  @Nullable
  private Function2<? super View, ? super TabChannelCoverInfo, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = Color.parseColor("#FFFFFF");
  private boolean jdField_b_of_type_Boolean;
  private final int c = Color.parseColor("#737373");
  private final int d = Color.parseColor("#00CAFB");
  private int e;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabLayout$Companion = new RIJXTabLayout.Companion(null);
  }
  
  public RIJXTabLayout(@NotNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(localLayoutInflater, "LayoutInflater.from(context)");
    a(paramContext, localLayoutInflater);
  }
  
  public RIJXTabLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "LayoutInflater.from(context)");
    a(paramContext, paramAttributeSet);
  }
  
  public RIJXTabLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "LayoutInflater.from(context)");
    a(paramContext, paramAttributeSet);
  }
  
  private final int a(int paramInt)
  {
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      localObject = ((LinearLayout)localObject).getChildAt(j);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "tabLayout.getChildAt(i)");
      i += ((View)localObject).getWidth();
      j += 1;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localObject = ((LinearLayout)localObject).getChildAt(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tabLayout.getChildAt(index)");
    paramInt = ((View)localObject).getWidth() / 2;
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    return i + (paramInt - ((View)localObject).getMeasuredWidth() / 2);
  }
  
  private final void a(int paramInt1, int paramInt2, float paramFloat)
  {
    if (!a(paramInt1))
    {
      if (a(paramInt2)) {
        return;
      }
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      if (localView.getVisibility() != 0)
      {
        localView = this.jdField_a_of_type_AndroidViewView;
        if (localView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("indicator");
        }
        localView.setVisibility(0);
      }
      paramInt1 = a(paramInt1);
      paramInt2 = a(paramInt2);
      localView = this.jdField_a_of_type_AndroidViewView;
      if (localView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      localView.setTranslationX(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
    }
  }
  
  private final void a(TextView paramTextView)
  {
    paramTextView.setTypeface(Typeface.defaultFromStyle(1));
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramTextView.getScaleX(), 1.2F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new RIJXTabLayout.animateSelectedTab..inlined.apply.lambda.1(paramTextView));
    localValueAnimator.start();
  }
  
  private final void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if ((localObject1 != null) && (((RIJXTabViewPagerController)localObject1).a() == paramInt))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
      if (localObject1 != null) {
        localObject1 = ((RIJXTabViewPagerController)localObject1).a();
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof ReadInJoyBaseFragment)) {
        localObject2 = null;
      }
      localObject1 = (ReadInJoyBaseFragment)localObject2;
      if (localObject1 != null) {
        ((ReadInJoyBaseFragment)localObject1).a(5);
      }
    }
    localObject1 = RIJChannelViewpagerEnterPathHelper.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "RIJChannelViewpagerEnter…per.getChannelEntryPath()");
    ((Map)localObject1).put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), Integer.valueOf(1));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (localObject1 != null) {
      ((RIJXTabViewPagerController)localObject1).b(paramInt);
    }
    RIJChannelReporter.a(paramTabChannelCoverInfo.mChannelCoverId, "302");
    RIJChannelReporter.a("0X8009496", new RIJTransMergeKanDianReport.ReportR5Builder().addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addKandianModeNew().build());
  }
  
  private final boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt >= 0)
    {
      LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localLinearLayout == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      if (paramInt > localLinearLayout.getChildCount() - 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private final void b()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    int k = ((LinearLayout)localObject1).getChildCount();
    int j = 0;
    while (j < k)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      localObject1 = ((LinearLayout)localObject1).getChildAt(j);
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(j);
      Object localObject2 = (TextView)((View)localObject1).findViewById(2131379930);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "title");
      ((TextView)localObject2).setText((CharSequence)localTabChannelCoverInfo.mChannelCoverName);
      int i;
      if (this.jdField_b_of_type_Boolean) {
        i = this.jdField_b_of_type_Int;
      } else {
        i = this.c;
      }
      float f;
      if (this.jdField_b_of_type_Boolean) {
        f = 0.8F;
      } else {
        f = 1.0F;
      }
      if (j == this.e)
      {
        if (this.jdField_b_of_type_Boolean) {
          i = this.jdField_b_of_type_Int;
        } else {
          i = this.d;
        }
        f = 1.0F;
      }
      ((TextView)localObject2).setTextColor(i);
      ((TextView)localObject2).setAlpha(f);
      ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJXTabLayout.updateItem.1(this, localTabChannelCoverInfo, j));
      localObject2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
      if (localObject2 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "itemView");
        localObject1 = (Unit)((Function2)localObject2).invoke(localObject1, localTabChannelCoverInfo);
      }
      j += 1;
    }
  }
  
  private final void b(TextView paramTextView)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramTextView.getScaleX(), 1.0F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new RIJXTabLayout.animateUnselectedTab..inlined.apply.lambda.1(paramTextView));
    localValueAnimator.addListener((Animator.AnimatorListener)new RIJXTabLayout.animateUnselectedTab..inlined.apply.lambda.2(paramTextView));
    localValueAnimator.start();
  }
  
  public final void a()
  {
    b();
  }
  
  @VisibleForTesting
  public final void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    if (((LinearLayout)localObject).getChildCount() == 0)
    {
      this.jdField_a_of_type_Boolean = true;
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      settleIndicator(paramInt);
      b(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPageSelected:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" needDeferAnimation:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    QLog.d("RIJXTabLayout", 1, ((StringBuilder)localObject).toString());
  }
  
  @VisibleForTesting
  public final void a(@NotNull Context paramContext, @NotNull LayoutInflater paramLayoutInflater)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "layoutInflater");
    paramLayoutInflater.inflate(2131562719, (ViewGroup)this, true);
    paramContext = findViewById(2131378236);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.tab_layout)");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext);
    paramContext = findViewById(2131378231);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.tab_indicator)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramContext.setHorizontalFadingEdgeEnabled(false);
    paramContext = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramContext.setOverScrollMode(2);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull List<? extends TabChannelCoverInfo> paramList, @NotNull RIJXTabViewPagerController paramRIJXTabViewPagerController)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramList, "itemList");
    Intrinsics.checkParameterIsNotNull(paramRIJXTabViewPagerController, "viewPagerController");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController = paramRIJXTabViewPagerController;
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    ((LinearLayout)localObject).removeAllViews();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramList);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      paramList = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      localObject = LayoutInflater.from(paramContext);
      LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localLinearLayout == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      paramList.addView(((LayoutInflater)localObject).inflate(2131562718, (ViewGroup)localLinearLayout, false));
      i += 1;
    }
    b();
    paramContext = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
    while (paramContext.hasNext())
    {
      paramList = (TabChannelCoverInfo)paramContext.next();
      RIJChannelReporter.a("0X8009495", new RIJTransMergeKanDianReport.ReportR5Builder().addChannelId(paramList.mChannelCoverId).addKandianModeNew().build());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramContext = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramContext == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      paramContext.postDelayed((Runnable)new RIJXTabLayout.updateUI.3(this, paramRIJXTabViewPagerController), 50L);
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = 2130849841;
    } else {
      i = 2130849840;
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localView.setBackgroundResource(i);
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.e = paramInt;
    b();
  }
  
  @VisibleForTesting
  public final void b(int paramInt)
  {
    if (a(paramInt)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("animateTabTitle:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("RIJXTabLayout", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localObject = ((LinearLayout)localObject).getChildAt(paramInt);
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131379930);
      if (localObject != null)
      {
        a((TextView)localObject);
        int i = 0;
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        int j = ((LinearLayout)localObject).getChildCount();
        while (i < j)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (localObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
          }
          localObject = ((LinearLayout)localObject).getChildAt(i);
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131379930);
            if (localObject != null) {
              if (i == paramInt) {
                a((TextView)localObject);
              } else {
                b((TextView)localObject);
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  @VisibleForTesting
  public final void c(int paramInt)
  {
    if (a(paramInt)) {
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    if (localView.getVisibility() != 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (localView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      localView.setVisibility(0);
    }
    paramInt = a(paramInt);
    localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localView.setTranslationX(paramInt);
  }
  
  protected void onConfigurationChanged(@Nullable Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b();
    paramConfiguration = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (paramConfiguration != null) {
      onPageSelected(paramConfiguration.a());
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (localRIJXTabViewPagerController != null) {
      settleIndicator(localRIJXTabViewPagerController.a());
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat < this.jdField_a_of_type_Float) {
      a(paramInt1 + 1, paramInt1, 1 - paramFloat);
    } else {
      a(paramInt1, paramInt1 + 1, paramFloat);
    }
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void onPageSelected(int paramInt)
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localLinearLayout.post((Runnable)new RIJXTabLayout.onPageSelected.1(this, paramInt));
  }
  
  public final void setRedPointHandler(@Nullable Function2<? super View, ? super TabChannelCoverInfo, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  @VisibleForTesting
  public final void settleIndicator(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("settleIndicator:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" scrollState:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("RIJXTabLayout", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Int == 0) {
      c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabLayout
 * JD-Core Version:    0.7.0.1
 */