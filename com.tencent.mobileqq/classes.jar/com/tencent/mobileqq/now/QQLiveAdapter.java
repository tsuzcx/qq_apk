package com.tencent.mobileqq.now;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
  private int jdField_a_of_type_Int = 3;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private MessageReceivingHolder jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder;
  private final List<RecommendAnchorInfo> jdField_a_of_type_JavaUtilList;
  
  public QQLiveAdapter(FragmentActivity paramFragmentActivity, RecyclerView paramRecyclerView, List<RecommendAnchorInfo> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public RecyclerHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return new VideoCardHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559647, paramViewGroup, false));
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder == null)
      {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559644, paramViewGroup, false);
        this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder = new MessageReceivingHolder(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewGroup);
      }
      return this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder;
    case 1: 
      return new NowQQFocusViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559639, paramViewGroup, false));
    }
    return new NoDataViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559648, paramViewGroup, false));
  }
  
  public void a()
  {
    notifyItemChanged(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramRecyclerHolder, paramInt, getItemId(paramInt));
      return;
      this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder.a();
      continue;
      NowQQFocusHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramRecyclerHolder);
      continue;
      if (paramInt - 2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        NowQQLiveRecommendAnchorHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramRecyclerHolder, (RecommendAnchorInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt - 2), paramInt);
        continue;
        NowQQLiveRecommendAnchorHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramRecyclerHolder, this.jdField_a_of_type_Int);
      }
    }
  }
  
  protected boolean a(int paramInt)
  {
    return getItemViewType(paramInt) != 2;
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_Int != 1) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))) {
      return 3;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    if ((this.jdField_a_of_type_Int != 1) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))) {
      return 3;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.QQLiveAdapter
 * JD-Core Version:    0.7.0.1
 */