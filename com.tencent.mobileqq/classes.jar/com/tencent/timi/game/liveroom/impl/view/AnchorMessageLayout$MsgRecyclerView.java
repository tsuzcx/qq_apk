package com.tencent.timi.game.liveroom.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$MsgRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorMessageLayout$MsgRecyclerView
  extends RecyclerView
{
  @JvmOverloads
  public AnchorMessageLayout$MsgRecyclerView(Context paramContext, @NotNull AttributeSet paramAttributeSet, @Nullable int paramInt)
  {
    super(paramAttributeSet, paramInt, i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((AnchorMessageLayout.a(this.a) > 0) && (View.MeasureSpec.getSize(paramInt2) > paramInt2))
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(AnchorMessageLayout.a(this.a), -2147483648));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MsgRecyclerView onSizeChanged w = [");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("], h = [");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("], oldw = [");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("], oldh = [");
    ((StringBuilder)localObject).append(paramInt4);
    ((StringBuilder)localObject).append(']');
    Logger.b("AnchorMessageLayout", ((StringBuilder)localObject).toString());
    if (paramInt2 >= AnchorMessageLayout.a(this.a))
    {
      localObject = getLayoutParams();
      if (localObject != null)
      {
        ((ViewGroup.LayoutParams)localObject).height = getHeight();
        setLayoutParams((ViewGroup.LayoutParams)localObject);
        AnchorMessageLayout.b(this.a).setAutoMeasureEnabled(false);
        setHasFixedSize(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.MsgRecyclerView
 * JD-Core Version:    0.7.0.1
 */