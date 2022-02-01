package com.tencent.timi.game.component.chat.message;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/MessageLayoutImpl$7", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageLayoutImpl$7
  extends RecyclerView.ItemDecoration
{
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "outRect");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Intrinsics.checkParameterIsNotNull(paramState, "state");
    if (paramRecyclerView.getChildAdapterPosition(paramView) == 0) {
      paramRect.top = LayoutExKt.b(10);
    }
    paramRect.bottom = LayoutExKt.b(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl.7
 * JD-Core Version:    0.7.0.1
 */