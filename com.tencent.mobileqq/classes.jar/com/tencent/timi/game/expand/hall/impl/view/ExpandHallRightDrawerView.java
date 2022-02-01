package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.timi.game.teamlist.view.TeamListSlideView;
import com.tencent.timi.game.ui.ViewStateChangeListener;
import com.tencent.timi.game.ui.widget.TGRightDrawerView;
import com.tencent.timi.game.utils.CommonExKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallRightDrawerView;", "Lcom/tencent/timi/game/ui/widget/TGRightDrawerView;", "Lcom/tencent/timi/game/ui/ViewStateChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "teamListSlideView", "Lcom/tencent/timi/game/teamlist/view/TeamListSlideView;", "onHide", "", "view", "Landroid/view/View;", "onShow", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallRightDrawerView
  extends TGRightDrawerView
  implements ViewStateChangeListener
{
  public static final ExpandHallRightDrawerView.Companion a = new ExpandHallRightDrawerView.Companion(null);
  private final TeamListSlideView c;
  private HashMap d;
  
  @JvmOverloads
  public ExpandHallRightDrawerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public ExpandHallRightDrawerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public ExpandHallRightDrawerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, false, 8, null);
    this.c = new TeamListSlideView(paramContext);
    paramContext = new FrameLayout.LayoutParams(CommonExKt.a(311), -1);
    a((View)this.c, paramContext);
    this.c.setOnCloseClickListener((View.OnClickListener)new ExpandHallRightDrawerView.1(this));
    a((ViewStateChangeListener)this);
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
  
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.c.c();
  }
  
  public void b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.c.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallRightDrawerView
 * JD-Core Version:    0.7.0.1
 */