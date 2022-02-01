package com.tencent.mobileqq.kandian.biz.xtab;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabLayout;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "badgeHandler", "Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabBadgeHandler;", "downLoadListener", "Lcom/tencent/image/URLDrawable$DownloadListener;", "immersiveMode", "", "indicator", "Landroid/view/View;", "itemList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "lastOffset", "", "needDeferAnimation", "scrollState", "selectedIndex", "tabLayout", "Landroid/widget/LinearLayout;", "viewPagerController", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;", "addTab", "", "tabChannelInfo", "animateSelectedTab", "iconView", "animateTabTitle", "animateUnselectedTab", "doOnPageSelected", "index", "getTargetTranslateX", "handleTabClick", "data", "position", "init", "layoutInflater", "Landroid/view/LayoutInflater;", "isOutOfIndex", "moveIndicatorByOffset", "currentIndex", "targetIndex", "offset", "moveIndicatorToTargetIndex", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPageScrollStateChanged", "state", "onPageScrolled", "positionOffsetPixels", "onPageSelected", "setLoadingDrawable", "options", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "tabInfo", "settleIndicator", "switchImmersiveMode", "immersive", "updateBadge", "updateIconItem", "tabIconView", "updateItem", "itemView", "updateNormalItem", "updateUI", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabLayout
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  public static final RIJXTabLayout.Companion a = new RIJXTabLayout.Companion(null);
  private static final int m = Color.parseColor("#FFFFFF");
  private static final int n = Color.parseColor("#737373");
  private static final int o = Color.parseColor("#00CAFB");
  private LinearLayout b;
  private View c;
  private RIJXTabViewPagerController d;
  private float e;
  private int f;
  private boolean g;
  private List<TabChannelCoverInfo> h = (List)new ArrayList();
  private final KDXTabBadgeHandler i = new KDXTabBadgeHandler();
  private boolean j;
  private int k;
  private final URLDrawable.DownloadListener l = (URLDrawable.DownloadListener)new RIJXTabLayout.downLoadListener.1();
  
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
  
  private final void a(int paramInt1, int paramInt2, float paramFloat)
  {
    if (!d(paramInt1))
    {
      if (d(paramInt2)) {
        return;
      }
      View localView = this.c;
      if (localView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      if (localView.getVisibility() != 0)
      {
        localView = this.c;
        if (localView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("indicator");
        }
        localView.setVisibility(0);
      }
      paramInt1 = e(paramInt1);
      paramInt2 = e(paramInt2);
      localView = this.c;
      if (localView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      localView.setTranslationX(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
    }
  }
  
  private final void a(View paramView)
  {
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setTypeface(Typeface.defaultFromStyle(1));
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramView.getScaleX(), 1.2F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new RIJXTabLayout.animateSelectedTab..inlined.apply.lambda.1(paramView));
    localValueAnimator.start();
  }
  
  private final void a(URLDrawable.URLDrawableOptions paramURLDrawableOptions, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (!TextUtils.isEmpty((CharSequence)paramTabChannelCoverInfo.defaultIcon))
    {
      int i1 = 2130842687;
      try
      {
        paramTabChannelCoverInfo = ImageCommon.getDrawableResourceId(paramTabChannelCoverInfo.defaultIcon);
        Intrinsics.checkExpressionValueIsNotNull(paramTabChannelCoverInfo, "ImageCommon.getDrawableR…ceId(tabInfo.defaultIcon)");
        int i2 = paramTabChannelCoverInfo.intValue();
        i1 = i2;
      }
      catch (Exception paramTabChannelCoverInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setLoadingDrawable error!  msg=");
        localStringBuilder.append(paramTabChannelCoverInfo);
        QLog.d("RIJXTabLayout", 1, localStringBuilder.toString());
      }
      paramTabChannelCoverInfo = getResources().getDrawable(i1);
      paramURLDrawableOptions.mLoadingDrawable = paramTabChannelCoverInfo;
      paramURLDrawableOptions.mFailedDrawable = paramTabChannelCoverInfo;
    }
  }
  
  private final void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int i1;
    if (paramTabChannelCoverInfo.isIconTab) {
      i1 = 2131629151;
    } else {
      i1 = 2131629152;
    }
    paramTabChannelCoverInfo = this.b;
    if (paramTabChannelCoverInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    LinearLayout localLinearLayout = this.b;
    if (localLinearLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramTabChannelCoverInfo.addView(localLayoutInflater.inflate(i1, (ViewGroup)localLinearLayout, false));
  }
  
  private final void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((RIJXTabViewPagerController)localObject1).f() == paramInt))
    {
      localObject1 = this.d;
      if (localObject1 != null) {
        localObject1 = ((RIJXTabViewPagerController)localObject1).e();
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
    localObject1 = this.d;
    if (localObject1 != null) {
      ((RIJXTabViewPagerController)localObject1).b(paramInt);
    }
    RIJChannelReporter.a(paramTabChannelCoverInfo.mChannelCoverId, "302");
    RIJChannelReporter.a("0X8009496", new RIJTransMergeKanDianReport.ReportR5Builder().addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addFolderStatus().addGuideRedStyle(paramTabChannelCoverInfo).addChannelTabType(paramTabChannelCoverInfo.isIconTab).addKandianModeNew().build());
  }
  
  private final void a(TabChannelCoverInfo paramTabChannelCoverInfo, View paramView, int paramInt)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      paramView.setText((CharSequence)paramTabChannelCoverInfo.mChannelCoverName);
      int i1;
      if (this.j) {
        i1 = m;
      } else {
        i1 = n;
      }
      float f1;
      if (this.j) {
        f1 = 0.8F;
      } else {
        f1 = 1.0F;
      }
      if (paramInt == this.k)
      {
        if (this.j) {
          paramInt = m;
        } else {
          paramInt = o;
        }
        f1 = 1.0F;
        i1 = paramInt;
      }
      paramView.setTextColor(i1);
      paramView.setAlpha(f1);
    }
  }
  
  private final void b()
  {
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    int i2 = ((LinearLayout)localObject).getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      localObject = ((LinearLayout)localObject).getChildAt(i1);
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.h.get(i1);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "itemView");
      c(localTabChannelCoverInfo, (View)localObject, i1);
      ((View)localObject).setOnClickListener((View.OnClickListener)new RIJXTabLayout.updateItem.2(this, localTabChannelCoverInfo, i1));
      this.i.a((View)localObject, localTabChannelCoverInfo);
      i1 += 1;
    }
  }
  
  private final void b(View paramView)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramView.getScaleX(), 1.0F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new RIJXTabLayout.animateUnselectedTab..inlined.apply.lambda.1(paramView));
    localValueAnimator.addListener((Animator.AnimatorListener)new RIJXTabLayout.animateUnselectedTab..inlined.apply.lambda.2(paramView));
    localValueAnimator.start();
  }
  
  private final void b(TabChannelCoverInfo paramTabChannelCoverInfo, View paramView, int paramInt)
  {
    if (((paramView instanceof URLImageView)) && (!TextUtils.isEmpty((CharSequence)paramTabChannelCoverInfo.iconUrl)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Intrinsics.checkExpressionValueIsNotNull(localURLDrawableOptions, "options");
      a(localURLDrawableOptions, paramTabChannelCoverInfo);
      paramTabChannelCoverInfo = URLDrawable.getDrawable(paramTabChannelCoverInfo.iconUrl, localURLDrawableOptions);
      paramTabChannelCoverInfo.setDownloadListener(this.l);
      ((URLImageView)paramView).setImageDrawable((Drawable)paramTabChannelCoverInfo);
    }
  }
  
  private final void c(TabChannelCoverInfo paramTabChannelCoverInfo, View paramView, int paramInt)
  {
    paramView = paramView.findViewById(2131448814);
    if (paramView != null)
    {
      if (paramTabChannelCoverInfo.isIconTab)
      {
        b(paramTabChannelCoverInfo, paramView, paramInt);
        return;
      }
      a(paramTabChannelCoverInfo, paramView, paramInt);
    }
  }
  
  private final boolean d(int paramInt)
  {
    boolean bool = true;
    if (paramInt >= 0)
    {
      LinearLayout localLinearLayout = this.b;
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
  
  private final int e(int paramInt)
  {
    int i2 = 0;
    int i1 = 0;
    while (i2 < paramInt)
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      localObject = ((LinearLayout)localObject).getChildAt(i2);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "tabLayout.getChildAt(i)");
      i1 += ((View)localObject).getWidth();
      i2 += 1;
    }
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localObject = ((LinearLayout)localObject).getChildAt(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tabLayout.getChildAt(index)");
    paramInt = ((View)localObject).getWidth() / 2;
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    return i1 + (paramInt - ((View)localObject).getMeasuredWidth() / 2);
  }
  
  public final void a()
  {
    b();
  }
  
  @VisibleForTesting
  public final void a(int paramInt)
  {
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    if (((LinearLayout)localObject).getChildCount() == 0)
    {
      this.g = true;
    }
    else
    {
      this.g = false;
      settleIndicator(paramInt);
      b(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPageSelected:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" needDeferAnimation:");
    ((StringBuilder)localObject).append(this.g);
    QLog.d("RIJXTabLayout", 1, ((StringBuilder)localObject).toString());
  }
  
  @VisibleForTesting
  public final void a(@NotNull Context paramContext, @NotNull LayoutInflater paramLayoutInflater)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "layoutInflater");
    paramLayoutInflater.inflate(2131629153, (ViewGroup)this, true);
    paramContext = findViewById(2131446755);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.tab_layout)");
    this.b = ((LinearLayout)paramContext);
    paramContext = findViewById(2131446750);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.tab_indicator)");
    this.c = paramContext;
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramContext.setHorizontalFadingEdgeEnabled(false);
    paramContext = this.b;
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
    this.d = paramRIJXTabViewPagerController;
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramContext.removeAllViews();
    this.h.clear();
    this.h.addAll((Collection)paramList);
    int i2 = this.h.size();
    int i1 = 0;
    while (i1 < i2)
    {
      a((TabChannelCoverInfo)paramList.get(i1));
      i1 += 1;
    }
    b();
    paramContext = ((Iterable)this.h).iterator();
    while (paramContext.hasNext())
    {
      paramList = (TabChannelCoverInfo)paramContext.next();
      RIJChannelReporter.a("0X8009495", new RIJTransMergeKanDianReport.ReportR5Builder().addChannelId(paramList.mChannelCoverId).addChannelTabType(paramList.isIconTab).addGuideRedStyle(paramList).addFolderStatus().addKandianModeNew().build());
    }
    if (this.g)
    {
      paramContext = this.b;
      if (paramContext == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      paramContext.postDelayed((Runnable)new RIJXTabLayout.updateUI.3(this, paramRIJXTabViewPagerController), 50L);
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    int i1;
    if (paramBoolean) {
      i1 = 2130851546;
    } else {
      i1 = 2130851545;
    }
    View localView = this.c;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localView.setBackgroundResource(i1);
    this.j = paramBoolean;
    this.k = paramInt;
    b();
  }
  
  @VisibleForTesting
  public final void b(int paramInt)
  {
    if (d(paramInt)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("animateTabTitle:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("RIJXTabLayout", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localObject = ((LinearLayout)localObject).getChildAt(paramInt);
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(2131448814);
      if (localObject != null)
      {
        a((View)localObject);
        int i1 = 0;
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        int i2 = ((LinearLayout)localObject).getChildCount();
        while (i1 < i2)
        {
          localObject = this.b;
          if (localObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
          }
          localObject = ((LinearLayout)localObject).getChildAt(i1);
          if (localObject != null)
          {
            localObject = ((View)localObject).findViewById(2131448814);
            if (localObject != null) {
              if (i1 == paramInt) {
                a((View)localObject);
              } else {
                b((View)localObject);
              }
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  @VisibleForTesting
  public final void c(int paramInt)
  {
    if (d(paramInt)) {
      return;
    }
    View localView = this.c;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    if (localView.getVisibility() != 0)
    {
      localView = this.c;
      if (localView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      localView.setVisibility(0);
    }
    paramInt = e(paramInt);
    localView = this.c;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localView.setTranslationX(paramInt);
  }
  
  protected void onConfigurationChanged(@Nullable Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b();
    paramConfiguration = this.d;
    if (paramConfiguration != null) {
      onPageSelected(paramConfiguration.f());
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.f = paramInt;
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.d;
    if (localRIJXTabViewPagerController != null) {
      settleIndicator(localRIJXTabViewPagerController.f());
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat < this.e) {
      a(paramInt1 + 1, paramInt1, 1 - paramFloat);
    } else {
      a(paramInt1, paramInt1 + 1, paramFloat);
    }
    this.e = paramFloat;
  }
  
  public void onPageSelected(int paramInt)
  {
    LinearLayout localLinearLayout = this.b;
    if (localLinearLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localLinearLayout.post((Runnable)new RIJXTabLayout.onPageSelected.1(this, paramInt));
  }
  
  @VisibleForTesting
  public final void settleIndicator(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("settleIndicator:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" scrollState:");
    localStringBuilder.append(this.f);
    QLog.d("RIJXTabLayout", 1, localStringBuilder.toString());
    if (this.f == 0) {
      c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabLayout
 * JD-Core Version:    0.7.0.1
 */