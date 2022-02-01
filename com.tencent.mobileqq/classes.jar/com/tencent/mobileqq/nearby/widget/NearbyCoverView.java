package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.mvvm.ViewExtKt;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/widget/NearbyCoverView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isDarkMode", "", "()Z", "value", "isLoading", "setLoading", "(Z)V", "loadingView", "Landroid/view/View;", "rootView", "Landroid/view/ViewGroup;", "setRootViewColor", "", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyCoverView
  extends FrameLayout
{
  private final ViewGroup a;
  private final View b;
  private final boolean c;
  private boolean d;
  
  @JvmOverloads
  public NearbyCoverView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public NearbyCoverView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public NearbyCoverView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(1946484743, (ViewGroup)this);
    paramContext = findViewById(1946419226);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.root)");
    this.a = ((ViewGroup)paramContext);
    paramContext = findViewById(1946419206);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.loading)");
    this.b = paramContext;
    this.c = ThemeUtil.isNowThemeIsNight(null, false, null);
    a();
  }
  
  private final void a()
  {
    int i;
    if ((this.c) && (this.d)) {
      i = -7829368;
    } else if (this.c) {
      i = Color.parseColor("#77000000");
    } else if (this.d) {
      i = -1;
    } else {
      i = 0;
    }
    ViewExtKt.a((View)this.a, (Drawable)new ColorDrawable(i));
  }
  
  public final void setLoading(boolean paramBoolean)
  {
    if (paramBoolean == this.d) {
      return;
    }
    this.d = paramBoolean;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    this.b.setVisibility(i);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyCoverView
 * JD-Core Version:    0.7.0.1
 */