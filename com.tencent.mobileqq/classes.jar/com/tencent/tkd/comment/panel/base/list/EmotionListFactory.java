package com.tencent.tkd.comment.panel.base.list;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import com.tencent.tkd.comment.panel.model.Emotion;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class EmotionListFactory
{
  public static RecyclerView.RecycledViewPool a()
  {
    RecyclerView.RecycledViewPool localRecycledViewPool = new RecyclerView.RecycledViewPool();
    localRecycledViewPool.setMaxRecycledViews(0, 42);
    return localRecycledViewPool;
  }
  
  public static RecyclerView a(@NotNull Context paramContext, int paramInt, @NotNull BaseEmotionPanelAdapter paramBaseEmotionPanelAdapter, @NotNull List<Emotion> paramList, RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    RecyclerView localRecyclerView = new RecyclerView(paramContext);
    localRecyclerView.setLayoutParams(new GridLayoutManager.LayoutParams(-1, -1));
    if (paramRecycledViewPool != null) {
      localRecyclerView.setRecycledViewPool(paramRecycledViewPool);
    }
    paramContext = new GridLayoutManager(paramContext, paramInt);
    paramContext.setRecycleChildrenOnDetach(true);
    localRecyclerView.setLayoutManager(paramContext);
    localRecyclerView.setAdapter(paramBaseEmotionPanelAdapter);
    paramBaseEmotionPanelAdapter.a(paramList);
    return localRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.list.EmotionListFactory
 * JD-Core Version:    0.7.0.1
 */