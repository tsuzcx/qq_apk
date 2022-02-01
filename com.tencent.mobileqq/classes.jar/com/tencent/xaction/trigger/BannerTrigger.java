package com.tencent.xaction.trigger;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.Keep;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.LayoutParams;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/BannerTrigger;", "Lcom/tencent/xaction/trigger/BaseTrigger;", "()V", "firstItem", "", "lastItem", "ptype", "", "getPtype", "()Ljava/lang/String;", "setPtype", "(Ljava/lang/String;)V", "computeTransformPage", "", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "depthPageTransform", "view", "Landroid/view/View;", "position", "", "getClientWidth", "monitor", "data", "Lcom/tencent/xaction/api/data/ViewData;", "iview", "Lcom/tencent/xaction/api/IView;", "transformPage", "zoomPageTransform", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class BannerTrigger
  extends BaseTrigger
{
  public static final BannerTrigger.Companion Companion = new BannerTrigger.Companion(null);
  private static final float MIN_ALPHA = 0.5F;
  private static final float MIN_SCALE = 0.85F;
  @NotNull
  private static final String[] SUPPORT_PTYPE = { "depth", "zoom" };
  private transient int firstItem;
  private transient int lastItem;
  @Nullable
  private String ptype;
  
  private final void computeTransformPage(ViewPager paramViewPager)
  {
    int j = paramViewPager.getScrollX();
    int k = paramViewPager.getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView = paramViewPager.getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "child");
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      if (localLayoutParams != null)
      {
        if (!((ViewPager.LayoutParams)localLayoutParams).isDecor) {
          transformPage(paramViewPager, localView, (localView.getLeft() - j) / getClientWidth(paramViewPager));
        }
        i += 1;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager.LayoutParams");
      }
    }
  }
  
  private final void depthPageTransform(View paramView, float paramFloat)
  {
    int i = paramView.getWidth();
    if (paramFloat < -1)
    {
      paramView.setAlpha(0.0F);
      return;
    }
    if (paramFloat <= 0)
    {
      paramView.setAlpha(1.0F);
      paramView.setTranslationX(0.0F);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
      return;
    }
    float f = 1;
    if (paramFloat <= f)
    {
      paramView.setAlpha(f - paramFloat);
      paramView.setTranslationX(i * -paramFloat);
      paramFloat = (f - Math.abs(paramFloat)) * 0.25F + 0.75F;
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
      return;
    }
    paramView.setAlpha(0.0F);
  }
  
  private final int getClientWidth(ViewPager paramViewPager)
  {
    return paramViewPager.getMeasuredWidth() - paramViewPager.getPaddingLeft() - paramViewPager.getPaddingRight();
  }
  
  private final void transformPage(ViewPager paramViewPager, View paramView, float paramFloat)
  {
    if (Intrinsics.areEqual(this.ptype, SUPPORT_PTYPE[0]))
    {
      depthPageTransform(paramView, paramFloat);
      return;
    }
    if (Intrinsics.areEqual(this.ptype, SUPPORT_PTYPE[1])) {
      zoomPageTransform(paramView, paramFloat);
    }
  }
  
  private final void zoomPageTransform(View paramView, float paramFloat)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if (paramFloat < -1)
    {
      paramView.setAlpha(0.0F);
      return;
    }
    float f2 = 1;
    if (paramFloat <= f2)
    {
      float f1 = RangesKt.coerceAtLeast(0.85F, f2 - Math.abs(paramFloat));
      float f3 = j;
      float f4 = f2 - f1;
      f2 = 2;
      f3 = f3 * f4 / f2;
      f4 = i * f4 / f2;
      if (paramFloat < 0) {
        paramView.setTranslationX(f4 - f3 / f2);
      } else {
        paramView.setTranslationX(-f4 + f3 / f2);
      }
      paramView.setScaleX(f1);
      paramView.setScaleY(f1);
      paramView.setAlpha((f1 - 0.85F) / 0.15F * 0.5F + 0.5F);
      return;
    }
    paramView.setAlpha(0.0F);
  }
  
  @Nullable
  public final String getPtype()
  {
    return this.ptype;
  }
  
  public void monitor(@NotNull ViewData paramViewData, @NotNull IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    super.monitor(paramViewData, paramIView);
    paramViewData = paramIView.getDecor().getProxy();
    if (paramViewData != null)
    {
      if ((paramViewData instanceof ViewPager))
      {
        if (Build.VERSION.SDK_INT < 23) {
          return;
        }
        paramViewData = (ViewPager)paramViewData;
        this.firstItem = paramViewData.getCurrentItem();
        this.lastItem = paramViewData.getCurrentItem();
        paramViewData.addOnPageChangeListener((ViewPager.OnPageChangeListener)new BannerTrigger.monitor.1(this, paramViewData));
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public final void setPtype(@Nullable String paramString)
  {
    this.ptype = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.BannerTrigger
 * JD-Core Version:    0.7.0.1
 */