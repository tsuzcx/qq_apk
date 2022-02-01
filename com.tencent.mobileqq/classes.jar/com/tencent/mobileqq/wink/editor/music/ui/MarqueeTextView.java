package com.tencent.mobileqq.wink.editor.music.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/ui/MarqueeTextView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeView", "Landroidx/appcompat/widget/AppCompatImageView;", "iconView", "progressView", "Landroid/widget/ProgressBar;", "state", "Lcom/tencent/mobileqq/wink/editor/music/ui/MarqueeTextView$State;", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "applyState", "", "marquee", "name", "", "initCloseBtn", "initIcon", "initMarquee", "initProgress", "isAnimating", "", "setCloseBtnVisible", "visible", "setCloseButtonListener", "listener", "Landroid/view/View$OnClickListener;", "setOnClickListener", "l", "showIcon", "show", "startMarquee", "stopMarquee", "Companion", "State", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MarqueeTextView
  extends LinearLayoutCompat
{
  public static final MarqueeTextView.Companion a = new MarqueeTextView.Companion(null);
  private AppCompatImageView b;
  private AppCompatTextView c;
  private AppCompatImageView d;
  private ProgressBar e;
  private MarqueeTextView.State f;
  
  public MarqueeTextView(@NotNull Context paramContext)
  {
    super(paramContext);
    setOrientation(0);
    setGravity(17);
    setBackgroundResource(2130848749);
    b();
    c();
    d();
    e();
    a(this, MarqueeTextView.State.IDLE, null, 2, null);
    this.f = MarqueeTextView.State.IDLE;
  }
  
  public MarqueeTextView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    setGravity(17);
    setBackgroundResource(2130848749);
    b();
    c();
    d();
    e();
    a(this, MarqueeTextView.State.IDLE, null, 2, null);
    this.f = MarqueeTextView.State.IDLE;
  }
  
  public MarqueeTextView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    setGravity(17);
    setBackgroundResource(2130848749);
    b();
    c();
    d();
    e();
    a(this, MarqueeTextView.State.IDLE, null, 2, null);
    this.f = MarqueeTextView.State.IDLE;
  }
  
  private final void a(MarqueeTextView.State paramState, String paramString)
  {
    this.f = paramState;
    AppCompatImageView localAppCompatImageView = this.d;
    if (localAppCompatImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeView");
    }
    int i;
    if (paramState == MarqueeTextView.State.IDLE) {
      i = 8;
    } else {
      i = 0;
    }
    localAppCompatImageView.setVisibility(i);
    paramState = this.c;
    if (paramState == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textView");
    }
    paramState.setText((CharSequence)paramString);
    requestLayout();
  }
  
  private final void b()
  {
    AppCompatImageView localAppCompatImageView = new AppCompatImageView(getContext());
    localAppCompatImageView.setImageResource(2130853679);
    int i = DisplayUtil.a(localAppCompatImageView.getContext(), 16.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    addView((View)localAppCompatImageView, (ViewGroup.LayoutParams)localLayoutParams);
    this.b = localAppCompatImageView;
  }
  
  private final void c()
  {
    ProgressBar localProgressBar = new ProgressBar(getContext());
    int i = DisplayUtil.a(localProgressBar.getContext(), 16.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    addView((View)localProgressBar, (ViewGroup.LayoutParams)localLayoutParams);
    localProgressBar.setVisibility(8);
    this.e = localProgressBar;
  }
  
  private final void d()
  {
    AppCompatTextView localAppCompatTextView = new AppCompatTextView(getContext());
    localAppCompatTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    localAppCompatTextView.setMaxLines(1);
    localAppCompatTextView.setMarqueeRepeatLimit(-1);
    localAppCompatTextView.setSingleLine(true);
    localAppCompatTextView.setMaxWidth(DisplayUtil.a(localAppCompatTextView.getContext(), 92.0F));
    localAppCompatTextView.setTextSize(12.0F);
    localAppCompatTextView.setTextColor(Color.parseColor("#FFFFFF"));
    LinearLayoutCompat.LayoutParams localLayoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = DisplayUtil.a(localAppCompatTextView.getContext(), 6.0F);
    localLayoutParams.rightMargin = DisplayUtil.a(localAppCompatTextView.getContext(), 6.0F);
    addView((View)localAppCompatTextView, (ViewGroup.LayoutParams)localLayoutParams);
    this.c = localAppCompatTextView;
  }
  
  private final void e()
  {
    AppCompatImageView localAppCompatImageView = new AppCompatImageView(getContext());
    localAppCompatImageView.setImageResource(2130848869);
    int i = DisplayUtil.a(localAppCompatImageView.getContext(), 16.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    addView((View)localAppCompatImageView, (ViewGroup.LayoutParams)localLayoutParams);
    this.d = localAppCompatImageView;
  }
  
  public final void a()
  {
    setSelected(false);
    a(this, MarqueeTextView.State.IDLE, null, 2, null);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    a(true);
    setSelected(true);
    a(MarqueeTextView.State.ANIMATING, paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
      }
      ((AppCompatImageView)localObject).setVisibility(0);
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
      }
      ((ProgressBar)localObject).setVisibility(8);
      return;
    }
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("iconView");
    }
    ((AppCompatImageView)localObject).setVisibility(8);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("progressView");
    }
    ((ProgressBar)localObject).setVisibility(0);
  }
  
  public final void setCloseBtnVisible(boolean paramBoolean)
  {
    AppCompatImageView localAppCompatImageView;
    if (paramBoolean)
    {
      localAppCompatImageView = this.d;
      if (localAppCompatImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
      }
      if (localAppCompatImageView != null) {
        localAppCompatImageView.setVisibility(0);
      }
    }
    else
    {
      localAppCompatImageView = this.d;
      if (localAppCompatImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
      }
      if (localAppCompatImageView != null) {
        localAppCompatImageView.setVisibility(8);
      }
    }
  }
  
  public final void setCloseButtonListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    AppCompatImageView localAppCompatImageView = this.d;
    if (localAppCompatImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeView");
    }
    localAppCompatImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    AppCompatTextView localAppCompatTextView = this.c;
    if (localAppCompatTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textView");
    }
    localAppCompatTextView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.ui.MarqueeTextView
 * JD-Core Version:    0.7.0.1
 */