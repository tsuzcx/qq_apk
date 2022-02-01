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
  private int jdField_a_of_type_Int = 3;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private MessageReceivingHolder jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder;
  private final List<RecommendAnchorInfo> jdField_a_of_type_JavaUtilList;
  
  public QQLiveAdapter(BaseActivity paramBaseActivity, RecyclerView paramRecyclerView, List<RecommendAnchorInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public RecyclerHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3) {
          return new VideoCardHolder(LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559525, paramViewGroup, false));
        }
        return new NoDataViewHolder(LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559526, paramViewGroup, false));
      }
      return new NowQQFocusViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559516, paramViewGroup, false));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559521, paramViewGroup, false);
      this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder = new MessageReceivingHolder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewGroup);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder;
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
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            NowQQLiveRecommendAnchorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramRecyclerHolder, this.jdField_a_of_type_Int);
          }
        }
        else
        {
          i = paramInt - 2;
          if (i < this.jdField_a_of_type_JavaUtilList.size()) {
            NowQQLiveRecommendAnchorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramRecyclerHolder, (RecommendAnchorInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramInt);
          }
        }
      }
      else {
        NowQQFocusHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramRecyclerHolder);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder.a();
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramRecyclerHolder, paramInt, getItemId(paramInt));
  }
  
  protected boolean a(int paramInt)
  {
    return getItemViewType(paramInt) != 2;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Int != 1)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if ((localList == null) || (localList.size() == 0)) {
        return 3;
      }
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (this.jdField_a_of_type_Int != 1)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if ((localList == null) || (localList.size() == 0)) {
        return 3;
      }
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.QQLiveAdapter
 * JD-Core Version:    0.7.0.1
 */