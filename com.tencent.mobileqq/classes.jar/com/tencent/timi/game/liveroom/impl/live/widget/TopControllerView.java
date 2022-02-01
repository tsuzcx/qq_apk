package com.tencent.timi.game.liveroom.impl.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/live/widget/TopControllerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAnchor", "", "isVerMode", "onEnterRoom", "", "roomId", "", "onExitRoom", "setIsVerMode", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TopControllerView
  extends FrameLayout
{
  private boolean a;
  private boolean b;
  private HashMap c;
  
  @JvmOverloads
  public TopControllerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TopControllerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TopControllerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131629458, (ViewGroup)this);
  }
  
  public View a(int paramInt)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    View localView2 = (View)this.c.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.c.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(long paramLong)
  {
    ((AnchorTopHeadView)a(2131428309)).c(paramLong);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    this.b = paramBoolean;
    ((AnchorTopHeadView)a(2131428309)).a(paramLong, paramBoolean);
  }
  
  public final void setIsVerMode(boolean paramBoolean)
  {
    this.a = paramBoolean;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.TopControllerView
 * JD-Core Version:    0.7.0.1
 */