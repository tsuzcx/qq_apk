package com.tencent.timi.game.liveroom.impl.live.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/live/widget/LiveTipsView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/tencent/timi/game/liveroom/impl/live/widget/LiveTipsView$LiveEndViewListener;", "hideCommonTips", "", "hideLoadFailedView", "hideLoadingView", "setListener", "setVisibility", "visibility", "shouldHide", "", "showCommonTips", "msg", "", "showLoadFailedView", "showLoadingView", "LiveEndViewListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveTipsView
  extends FrameLayout
{
  private LiveTipsView.LiveEndViewListener a;
  private HashMap b;
  
  @JvmOverloads
  public LiveTipsView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public LiveTipsView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public LiveTipsView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131629408, (ViewGroup)this);
    ((TextView)a(2131444737)).setOnClickListener((View.OnClickListener)new LiveTipsView.1(this));
  }
  
  private final boolean f()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "getChildAt(i)");
      if (localView.getVisibility() == 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public View a(int paramInt)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    View localView2 = (View)this.b.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.b.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a()
  {
    setVisibility(0);
    setBackgroundResource(2131168376);
    Object localObject = a(2131437976);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mask");
    ((View)localObject).setVisibility(8);
    localObject = (LinearLayout)a(2131437648);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loading_layout");
    ((LinearLayout)localObject).setVisibility(0);
    localObject = a(2131437645);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loading_icon");
    Drawable localDrawable = ((View)localObject).getBackground();
    localObject = localDrawable;
    if (!(localDrawable instanceof Animatable)) {
      localObject = null;
    }
    localObject = (Animatable)localObject;
    if (localObject != null) {
      ((Animatable)localObject).start();
    }
  }
  
  public final void a(@Nullable String paramString)
  {
    setVisibility(0);
    Object localObject = a(2131437976);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mask");
    ((View)localObject).setVisibility(0);
    setBackgroundResource(2131165564);
    localObject = (TextView)a(2131431159);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "common_tips");
    ((TextView)localObject).setVisibility(0);
    localObject = (TextView)a(2131431159);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "common_tips");
    if (paramString == null) {
      paramString = "";
    }
    ((TextView)localObject).setText((CharSequence)paramString);
    d();
    b();
  }
  
  public final void b()
  {
    Object localObject = (LinearLayout)a(2131437648);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loading_layout");
    ((LinearLayout)localObject).setVisibility(8);
    localObject = a(2131437976);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mask");
    ((View)localObject).setVisibility(8);
    localObject = a(2131437645);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loading_icon");
    Drawable localDrawable = ((View)localObject).getBackground();
    localObject = localDrawable;
    if (!(localDrawable instanceof Animatable)) {
      localObject = null;
    }
    localObject = (Animatable)localObject;
    if (localObject != null) {
      ((Animatable)localObject).stop();
    }
    if (f()) {
      setVisibility(8);
    }
  }
  
  public final void c()
  {
    setVisibility(0);
    Object localObject = a(2131437976);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mask");
    ((View)localObject).setVisibility(0);
    setBackgroundResource(2131165564);
    localObject = (LinearLayout)a(2131437610);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "load_failed");
    ((LinearLayout)localObject).setVisibility(0);
  }
  
  public final void d()
  {
    Object localObject = (LinearLayout)a(2131437610);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "load_failed");
    ((LinearLayout)localObject).setVisibility(8);
    localObject = a(2131437976);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mask");
    ((View)localObject).setVisibility(8);
    if (f()) {
      setVisibility(8);
    }
  }
  
  public final void e()
  {
    Object localObject = (TextView)a(2131431159);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "common_tips");
    ((TextView)localObject).setVisibility(8);
    localObject = a(2131437976);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mask");
    ((View)localObject).setVisibility(8);
    if (f()) {
      setVisibility(8);
    }
  }
  
  public final void setListener(@Nullable LiveTipsView.LiveEndViewListener paramLiveEndViewListener)
  {
    this.a = paramLiveEndViewListener;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      Object localObject = a(2131437645);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "loading_icon");
      Drawable localDrawable = ((View)localObject).getBackground();
      localObject = localDrawable;
      if (!(localDrawable instanceof Animatable)) {
        localObject = null;
      }
      localObject = (Animatable)localObject;
      if (localObject != null) {
        ((Animatable)localObject).stop();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveTipsView
 * JD-Core Version:    0.7.0.1
 */