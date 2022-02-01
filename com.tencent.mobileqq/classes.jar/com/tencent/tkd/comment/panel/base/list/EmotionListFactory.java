package com.tencent.tkd.comment.panel.base.list;

import android.support.v7.widget.RecyclerView.RecycledViewPool;

public class EmotionListFactory
{
  public static RecyclerView.RecycledViewPool a()
  {
    RecyclerView.RecycledViewPool localRecycledViewPool = new RecyclerView.RecycledViewPool();
    localRecycledViewPool.setMaxRecycledViews(0, 42);
    return localRecycledViewPool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.list.EmotionListFactory
 * JD-Core Version:    0.7.0.1
 */