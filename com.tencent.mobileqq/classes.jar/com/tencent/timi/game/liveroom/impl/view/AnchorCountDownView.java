package com.tencent.timi.game.liveroom.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/AnchorCountDownView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "composition", "Lorg/libpag/PAGComposition;", "countDownTimerListener", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorCountDownView$CountdownListener;", "getCountDownTimerListener", "()Lcom/tencent/timi/game/liveroom/impl/view/AnchorCountDownView$CountdownListener;", "setCountDownTimerListener", "(Lcom/tencent/timi/game/liveroom/impl/view/AnchorCountDownView$CountdownListener;)V", "onAttachedToWindow", "", "playCountDown", "CountdownListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorCountDownView
  extends FrameLayout
{
  private final String a = "AnchorCountDownView";
  private PAGComposition b;
  @Nullable
  private AnchorCountDownView.CountdownListener c;
  private HashMap d;
  
  @JvmOverloads
  public AnchorCountDownView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorCountDownView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorCountDownView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131629405, (ViewGroup)this);
    setAlpha(0.0F);
    setOnClickListener((View.OnClickListener)new AnchorCountDownView.1(this));
  }
  
  public View a(int paramInt)
  {
    if (this.d == null) {
      this.d = new HashMap();
    }
    View localView2 = (View)this.d.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.d.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a()
  {
    post((Runnable)new AnchorCountDownView.playCountDown.1(this));
  }
  
  @Nullable
  public final AnchorCountDownView.CountdownListener getCountDownTimerListener()
  {
    return this.c;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public final void setCountDownTimerListener(@Nullable AnchorCountDownView.CountdownListener paramCountdownListener)
  {
    this.c = paramCountdownListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorCountDownView
 * JD-Core Version:    0.7.0.1
 */