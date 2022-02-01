package com.tencent.mobileqq.guild.window;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/window/GuildLiveFloatView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeView", "Landroid/view/View;", "containerView", "initFloatWindowView", "", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildLiveFloatView
  extends FrameLayout
{
  private View a;
  private View b;
  
  public GuildLiveFloatView(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuildLiveFloatView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuildLiveFloatView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public final void a()
  {
    View.inflate((Context)BaseApplication.getContext(), 2131625065, (ViewGroup)this);
    View localView = findViewById(2131430833);
    Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById(R.id.close_iv)");
    this.a = localView;
    localView = findViewById(2131437359);
    Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById(R.id.live_container)");
    this.b = localView;
    localView = this.a;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeView");
    }
    localView.setOnClickListener((View.OnClickListener)GuildLiveFloatView.initFloatWindowView.1.a);
    localView = this.b;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("containerView");
    }
    localView.setOnClickListener((View.OnClickListener)GuildLiveFloatView.initFloatWindowView.2.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.window.GuildLiveFloatView
 * JD-Core Version:    0.7.0.1
 */