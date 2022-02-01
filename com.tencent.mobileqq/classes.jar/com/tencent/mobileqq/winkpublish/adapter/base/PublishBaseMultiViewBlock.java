package com.tencent.mobileqq.winkpublish.adapter.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;

public abstract class PublishBaseMultiViewBlock<E>
  extends MultiViewBlock<E>
{
  private RecyclerView a;
  
  public PublishBaseMultiViewBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.a = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.adapter.base.PublishBaseMultiViewBlock
 * JD-Core Version:    0.7.0.1
 */