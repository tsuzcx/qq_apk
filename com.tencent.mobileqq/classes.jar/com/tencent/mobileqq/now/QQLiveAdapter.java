package com.tencent.mobileqq.now;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.now.focusanchor.NowQQFocusHandler;
import com.tencent.mobileqq.now.focusanchor.NowQQFocusViewHolder;
import com.tencent.mobileqq.now.message.MessageReceivingHolder;
import com.tencent.mobileqq.now.recommend.NoDataViewHolder;
import com.tencent.mobileqq.now.recommend.NowQQLiveRecommendAnchorHandler;
import com.tencent.mobileqq.now.recommend.RecommendAnchorInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class QQLiveAdapter
  extends RecyclerView.Adapter<RecyclerHolder>
{
  private BaseActivity a;
  private MessageReceivingHolder b;
  private RecyclerView c;
  private int d = 3;
  private final List<RecommendAnchorInfo> e;
  
  public QQLiveAdapter(BaseActivity paramBaseActivity, RecyclerView paramRecyclerView, List<RecommendAnchorInfo> paramList)
  {
    this.a = paramBaseActivity;
    this.c = paramRecyclerView;
    this.e = paramList;
  }
  
  public RecyclerHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3) {
          return new VideoCardHolder(LayoutInflater.from(this.a).inflate(2131625547, paramViewGroup, false));
        }
        return new NoDataViewHolder(LayoutInflater.from(this.a).inflate(2131625548, paramViewGroup, false));
      }
      return new NowQQFocusViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625538, paramViewGroup, false));
    }
    if (this.b == null)
    {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131625543, paramViewGroup, false);
      this.b = new MessageReceivingHolder(this.a, this.c, paramViewGroup);
    }
    return this.b;
  }
  
  public void a()
  {
    notifyItemChanged(0);
  }
  
  public void a(RecyclerHolder paramRecyclerHolder)
  {
    super.onViewAttachedToWindow(paramRecyclerHolder);
    ViewGroup.LayoutParams localLayoutParams = paramRecyclerHolder.itemView.getLayoutParams();
    if ((localLayoutParams != null) && ((localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) && (a(paramRecyclerHolder.getLayoutPosition()))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
  }
  
  public void a(RecyclerHolder paramRecyclerHolder, int paramInt)
  {
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            NowQQLiveRecommendAnchorHandler.a(this.a, paramRecyclerHolder, this.d);
          }
        }
        else
        {
          i = paramInt - 2;
          if (i < this.e.size()) {
            NowQQLiveRecommendAnchorHandler.a(this.a, paramRecyclerHolder, (RecommendAnchorInfo)this.e.get(i), paramInt);
          }
        }
      }
      else {
        NowQQFocusHandler.a(this.a, paramRecyclerHolder);
      }
    }
    else {
      this.b.a();
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramRecyclerHolder, paramInt, getItemId(paramInt));
  }
  
  protected boolean a(int paramInt)
  {
    return getItemViewType(paramInt) != 2;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int getItemCount()
  {
    if (this.d != 1)
    {
      List localList = this.e;
      if ((localList == null) || (localList.size() == 0)) {
        return 3;
      }
    }
    return this.e.size() + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (this.d != 1)
    {
      List localList = this.e;
      if ((localList == null) || (localList.size() == 0)) {
        return 3;
      }
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.QQLiveAdapter
 * JD-Core Version:    0.7.0.1
 */