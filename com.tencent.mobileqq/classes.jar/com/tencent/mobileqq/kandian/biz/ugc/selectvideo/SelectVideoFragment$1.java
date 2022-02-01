package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.LocalMediaGridAdapter;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.UniversalItemDecoration;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.UniversalItemDecoration.Decoration;
import com.tencent.mobileqq.util.DisplayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class SelectVideoFragment$1
  extends UniversalItemDecoration
{
  SelectVideoFragment$1(SelectVideoFragment paramSelectVideoFragment) {}
  
  @Nullable
  public UniversalItemDecoration.Decoration a(int paramInt, @NotNull RecyclerView paramRecyclerView)
  {
    return a(paramInt, SelectVideoFragment.a(this.a).getItemCount(), 3, DisplayUtil.a(SelectVideoFragment.b(this.a), 8.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */