package com.tencent.mobileqq.flashshow.personal.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalFeedInfo;
import com.tencent.mobileqq.flashshow.personal.widget.FSPersonalFeedItemView;
import com.tencent.mobileqq.flashshow.widgets.FSBaseMultiViewBlock;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;

public class FSPersonalFeedAdapter
  extends FSBaseMultiViewBlock<FSFeedData>
{
  private String a = "";
  private String b = "";
  private FSPersonalFeedAdapter.OnItemClickListener c;
  
  public FSPersonalFeedAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool3 = paramRecyclerView.getLayoutManager() instanceof GridLayoutManager;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramInt1 % paramInt2 == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.getLayoutManager() instanceof GridLayoutManager)) {
      return (paramInt1 + 1) % paramInt2 == 0;
    }
    return false;
  }
  
  public void a(FSPersonalFeedAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.c = paramOnItemClickListener;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public int getItemCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (paramRecyclerView != null)
    {
      if (paramRecyclerView.getAdapter() == null) {
        return;
      }
      int i = paramRecyclerView.getChildLayoutPosition(paramView);
      boolean bool1 = a(paramRecyclerView, i, 3);
      boolean bool2 = b(paramRecyclerView, i, 3);
      int k = ViewUtils.dip2px(0.5F);
      if (bool1) {
        i = 0;
      } else if (bool2) {
        i = k * 2;
      } else {
        i = k;
      }
      int j;
      if (bool2) {
        j = 0;
      } else if (bool1) {
        j = k * 2;
      } else {
        j = k;
      }
      paramRect.set(i, 0, j, k * 3);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof FSPersonalFeedAdapter.FeedViewHolder))
    {
      paramViewHolder = (FSPersonalFeedAdapter.FeedViewHolder)paramViewHolder;
      FSPersonalFeedInfo localFSPersonalFeedInfo = new FSPersonalFeedInfo(((FSFeedData)this.mDataList.get(paramInt)).b(), this.b);
      paramViewHolder.a.setUin(this.a);
      paramViewHolder.a.setData(localFSPersonalFeedInfo, paramInt);
      paramViewHolder.a.setOnClickListener(new FSPersonalFeedAdapter.1(this, paramInt, localFSPersonalFeedInfo));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new FSPersonalFeedItemView(paramViewGroup.getContext());
    paramViewGroup.setInitParams(getInitParams());
    return new FSPersonalFeedAdapter.FeedViewHolder(paramViewGroup);
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalFeedAdapter
 * JD-Core Version:    0.7.0.1
 */