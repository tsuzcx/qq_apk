package com.tencent.timi.game.liveroom.impl.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.qav.thread.ThreadManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/live/widget/VolumeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "goneTask", "Ljava/lang/Runnable;", "onDetachedFromWindow", "", "show", "volume", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class VolumeView
  extends FrameLayout
{
  private Runnable a;
  private HashMap b;
  
  @JvmOverloads
  public VolumeView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public VolumeView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public VolumeView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131629448, (ViewGroup)this);
    this.a = ((Runnable)new VolumeView.1(this));
  }
  
  public final void a(int paramInt)
  {
    Object localObject = (ProgressBar)b(2131440728);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "progressBar1");
    ((ProgressBar)localObject).setProgress(RangesKt.coerceAtMost(paramInt, 100));
    setVisibility(0);
    ThreadManager.d(this.a);
    ThreadManager.b(this.a, 3000L);
    int i;
    if (paramInt <= 50) {
      i = 2130853140;
    } else {
      i = 2130853139;
    }
    localObject = (ImageView)b(2131449985);
    if (paramInt == 0) {
      i = 2130853138;
    }
    ((ImageView)localObject).setImageResource(i);
  }
  
  public View b(int paramInt)
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
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ThreadManager.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.VolumeView
 * JD-Core Version:    0.7.0.1
 */