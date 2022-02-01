package com.tencent.videocut.render;

import androidx.recyclerview.widget.DiffUtil.Callback;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/render/AbsListRender$renderAllItems$callback$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AbsListRender$renderAllItems$callback$1
  extends DiffUtil.Callback
{
  AbsListRender$renderAllItems$callback$1(List paramList1, List paramList2) {}
  
  public boolean areContentsTheSame(int paramInt1, int paramInt2)
  {
    return this.a.a(this.b.get(paramInt1), this.c.get(paramInt2));
  }
  
  public boolean areItemsTheSame(int paramInt1, int paramInt2)
  {
    return this.a.c(this.b.get(paramInt1), this.c.get(paramInt2));
  }
  
  @NotNull
  public Object getChangePayload(int paramInt1, int paramInt2)
  {
    return new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public int getNewListSize()
  {
    return this.c.size();
  }
  
  public int getOldListSize()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.AbsListRender.renderAllItems.callback.1
 * JD-Core Version:    0.7.0.1
 */