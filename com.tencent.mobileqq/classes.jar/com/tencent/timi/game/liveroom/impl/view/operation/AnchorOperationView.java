package com.tencent.timi.game.liveroom.impl.view.operation;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.widget.ChildViewPager;
import com.tencent.timi.game.utils.CommonExKt;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/operation/AnchorOperationView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/liveroom/impl/view/operation/BaseOperationalOpt;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "pos", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "defaultColorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "mCurrentIndex", "mData", "Lcom/tencent/timi/game/liveroom/impl/view/operation/OperationData;", "mIndicatorViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "mLoopTask", "Ljava/lang/Runnable;", "mPageAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "getURLDrawableOptions", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "igv", "Lcom/tencent/image/URLImageView;", "initViews", "", "refreshUI", "renderIndicatorViews", "setData", "data", "setViewPagerScroller", "updateIndicator", "reCreate", "", "Companion", "CubicBezierInterpolator", "ViewPagerScroller", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorOperationView
  extends RelativeLayout
  implements BaseOperationalOpt
{
  public static final AnchorOperationView.Companion a = new AnchorOperationView.Companion(null);
  private ColorDrawable b = new ColorDrawable(Color.parseColor("#00000000"));
  private OperationData c = new OperationData(0, null, 3, null);
  private final PagerAdapter d;
  private int e;
  private final ArrayList<View> f = new ArrayList();
  private final Runnable g = (Runnable)new AnchorOperationView.mLoopTask.1(this);
  private HashMap h;
  
  @JvmOverloads
  public AnchorOperationView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 0, 14, null);
  }
  
  @JvmOverloads
  public AnchorOperationView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 0, 12, null);
  }
  
  @JvmOverloads
  public AnchorOperationView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0, 8, null);
  }
  
  @JvmOverloads
  public AnchorOperationView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    View.inflate(paramContext, 2131629414, (ViewGroup)this);
    this.d = ((PagerAdapter)new AnchorOperationView.1(this, paramContext, paramInt2));
    a();
  }
  
  private final URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable;
    if (paramURLImageView.getDrawable() != null) {
      localDrawable = paramURLImageView.getDrawable();
    } else {
      localDrawable = (Drawable)this.b;
    }
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    if (paramURLImageView.getDrawable() != null) {
      paramURLImageView = paramURLImageView.getDrawable();
    } else {
      paramURLImageView = (Drawable)this.b;
    }
    localURLDrawableOptions.mFailedDrawable = paramURLImageView;
    localURLDrawableOptions.mPlayGifImage = true;
    Intrinsics.checkExpressionValueIsNotNull(localURLDrawableOptions, "options");
    return localURLDrawableOptions;
  }
  
  private final void a()
  {
    ChildViewPager localChildViewPager = (ChildViewPager)a(2131439657);
    Intrinsics.checkExpressionValueIsNotNull(localChildViewPager, "operationViewPager");
    localChildViewPager.setAdapter(this.d);
    localChildViewPager = (ChildViewPager)a(2131439657);
    Intrinsics.checkExpressionValueIsNotNull(localChildViewPager, "operationViewPager");
    localChildViewPager.setOffscreenPageLimit(3);
    localChildViewPager = (ChildViewPager)a(2131439657);
    Intrinsics.checkExpressionValueIsNotNull(localChildViewPager, "operationViewPager");
    localChildViewPager.setPageMargin(CommonExKt.a(16));
    ((ChildViewPager)a(2131439657)).addOnPageChangeListener((ViewPager.OnPageChangeListener)new AnchorOperationView.initViews.1(this));
    d();
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.c.b().size() <= 1)
    {
      c();
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      this.f.clear();
      localIterator = this.c.b().iterator();
      while (localIterator.hasNext())
      {
        localObject = (OperationItem)localIterator.next();
        this.f.add(new View(getContext()));
      }
      c();
      return;
    }
    int i = 0;
    Iterator localIterator = ((Iterable)this.f).iterator();
    while (localIterator.hasNext())
    {
      localObject = (View)localIterator.next();
      int j;
      if (i == this.e) {
        j = 2130852902;
      } else {
        j = 2130852901;
      }
      ((View)localObject).setBackgroundResource(j);
      i += 1;
    }
  }
  
  private final void b()
  {
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.g);
    this.d.notifyDataSetChanged();
    ChildViewPager localChildViewPager = (ChildViewPager)a(2131439657);
    Intrinsics.checkExpressionValueIsNotNull(localChildViewPager, "operationViewPager");
    this.e = localChildViewPager.getCurrentItem();
    a(true);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.g, 5000L);
  }
  
  private final void c()
  {
    if (this.f.size() <= 1)
    {
      localObject = (LinearLayout)a(2131435687);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "indicatorView");
      ((LinearLayout)localObject).setVisibility(8);
      return;
    }
    ((LinearLayout)a(2131435687)).removeAllViews();
    Object localObject = ((Iterable)this.f).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      View localView = (View)((Iterator)localObject).next();
      int j;
      if (i == this.e) {
        j = 2130852902;
      } else {
        j = 2130852901;
      }
      localView.setBackgroundResource(j);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(CommonExKt.a(4), CommonExKt.a(4));
      localLayoutParams.leftMargin = CommonExKt.a(2);
      localLayoutParams.rightMargin = CommonExKt.a(2);
      ((LinearLayout)a(2131435687)).addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
      i += 1;
    }
    localObject = (LinearLayout)a(2131435687);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "indicatorView");
    ((LinearLayout)localObject).setVisibility(0);
  }
  
  private final void d()
  {
    try
    {
      Field localField = Class.forName("androidx.viewpager.widget.ViewPager").getDeclaredField("mScroller");
      Object localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = new AnchorOperationView.ViewPagerScroller((Context)localObject, (Interpolator)new AnchorOperationView.CubicBezierInterpolator(0.25F, 0.1F, 0.25F, 1.0F));
      Intrinsics.checkExpressionValueIsNotNull(localField, "f");
      localField.setAccessible(true);
      localField.set((ChildViewPager)a(2131439657), localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AnchorOperationView_", 1, "initViewPager error:", (Throwable)localException);
    }
  }
  
  public View a(int paramInt)
  {
    if (this.h == null) {
      this.h = new HashMap();
    }
    View localView2 = (View)this.h.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.h.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(@NotNull OperationItem paramOperationItem)
  {
    Intrinsics.checkParameterIsNotNull(paramOperationItem, "data");
    BaseOperationalOpt.DefaultImpls.a(this, paramOperationItem);
  }
  
  public final void setData(@NotNull OperationData paramOperationData)
  {
    Intrinsics.checkParameterIsNotNull(paramOperationData, "data");
    this.c = paramOperationData;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationView
 * JD-Core Version:    0.7.0.1
 */