package com.tencent.mobileqq.mini.ui;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.mini.model.SubscribeItemModel;
import com.tencent.mobileqq.mini.model.SubscribeItemModel.SubscribeViewType;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.List;

public class SubscribePermissionAdapter
  extends RecyclerView.Adapter
{
  private final SubscribePermissionAdapter.InteractiveListener interactiveListener;
  private List<SubscribeItemModel> subscribeItemList;
  
  public SubscribePermissionAdapter(List<SubscribeItemModel> paramList, SubscribePermissionAdapter.InteractiveListener paramInteractiveListener)
  {
    this.subscribeItemList = paramList;
    this.interactiveListener = paramInteractiveListener;
  }
  
  public int getItemCount()
  {
    if (this.subscribeItemList != null) {
      return this.subscribeItemList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.subscribeItemList == null) || (this.subscribeItemList.size() <= 0)) {
      return SubscribeItemModel.SubscribeViewType.TITLE.ordinal();
    }
    return ((SubscribeItemModel)this.subscribeItemList.get(paramInt)).getViewType().ordinal();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.subscribeItemList == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      SubscribeItemModel localSubscribeItemModel = (SubscribeItemModel)this.subscribeItemList.get(paramInt);
      if ((localSubscribeItemModel != null) && (paramViewHolder != null))
      {
        int i = localSubscribeItemModel.getViewType().ordinal();
        if (i == SubscribeItemModel.SubscribeViewType.TITLE.ordinal()) {
          ((SubscribePermissionAdapter.TitleViewHolder)paramViewHolder).titleTextView.setText(localSubscribeItemModel.getContent());
        }
        if (i == SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE.ordinal())
        {
          ((SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder).contentTextView.setText(localSubscribeItemModel.getContent());
          ((SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder).detailImageView.setVisibility(8);
          ((SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder).authSwitch.setChecked(localSubscribeItemModel.isChecked());
          int j = paramViewHolder.getAdapterPosition();
          ((SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder).authSwitch.setOnCheckedChangeListener(new SubscribePermissionAdapter.1(this, j));
        }
        if ((i == SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE.ordinal()) || (i == SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE.ordinal()))
        {
          ((SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder).contentTextView.setText(localSubscribeItemModel.getContent());
          i = paramViewHolder.getAdapterPosition();
          ((SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder).detailImageView.setVisibility(0);
          ((SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder).detailImageView.setOnClickListener(new SubscribePermissionAdapter.2(this, i));
          ((SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder).authSwitch.setChecked(localSubscribeItemModel.isChecked());
          ((SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder).authSwitch.setOnCheckedChangeListener(new SubscribePermissionAdapter.3(this, i));
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == SubscribeItemModel.SubscribeViewType.TITLE.ordinal()) {
      return new SubscribePermissionAdapter.TitleViewHolder(localLayoutInflater.inflate(2131559445, paramViewGroup, false));
    }
    if ((paramInt == SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE.ordinal()) || (paramInt == SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE.ordinal()) || (paramInt == SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE.ordinal())) {
      return new SubscribePermissionAdapter.SubscribeViewHolder(localLayoutInflater.inflate(2131559444, paramViewGroup, false));
    }
    return null;
  }
  
  public void setData(List<SubscribeItemModel> paramList)
  {
    this.subscribeItemList = paramList;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter
 * JD-Core Version:    0.7.0.1
 */