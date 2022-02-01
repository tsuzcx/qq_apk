package com.tencent.mobileqq.mini.ui;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.mini.model.SubscribeItemModel;
import com.tencent.mobileqq.mini.model.SubscribeItemModel.SubscribeViewType;
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
    List localList = this.subscribeItemList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    List localList = this.subscribeItemList;
    if ((localList != null) && (localList.size() > 0)) {
      return ((SubscribeItemModel)this.subscribeItemList.get(paramInt)).getViewType().ordinal();
    }
    return SubscribeItemModel.SubscribeViewType.TITLE.ordinal();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = this.subscribeItemList;
    if (localObject == null) {
      return;
    }
    localObject = (SubscribeItemModel)((List)localObject).get(paramInt);
    if ((localObject != null) && (paramViewHolder != null))
    {
      paramInt = ((SubscribeItemModel)localObject).getViewType().ordinal();
      if (paramInt == SubscribeItemModel.SubscribeViewType.TITLE.ordinal()) {
        ((SubscribePermissionAdapter.TitleViewHolder)paramViewHolder).titleTextView.setText(((SubscribeItemModel)localObject).getContent());
      }
      SubscribePermissionAdapter.SubscribeViewHolder localSubscribeViewHolder;
      if (paramInt == SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE.ordinal())
      {
        localSubscribeViewHolder = (SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder;
        localSubscribeViewHolder.contentTextView.setText(((SubscribeItemModel)localObject).getContent());
        localSubscribeViewHolder.detailImageView.setVisibility(8);
        localSubscribeViewHolder.authSwitch.setChecked(((SubscribeItemModel)localObject).isChecked());
        int i = paramViewHolder.getAdapterPosition();
        localSubscribeViewHolder.authSwitch.setOnCheckedChangeListener(new SubscribePermissionAdapter.1(this, i));
      }
      if ((paramInt == SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE.ordinal()) || (paramInt == SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE.ordinal()))
      {
        localSubscribeViewHolder = (SubscribePermissionAdapter.SubscribeViewHolder)paramViewHolder;
        localSubscribeViewHolder.contentTextView.setText(((SubscribeItemModel)localObject).getContent());
        paramInt = paramViewHolder.getAdapterPosition();
        localSubscribeViewHolder.detailImageView.setVisibility(0);
        localSubscribeViewHolder.detailImageView.setOnClickListener(new SubscribePermissionAdapter.2(this, paramInt));
        localSubscribeViewHolder.authSwitch.setChecked(((SubscribeItemModel)localObject).isChecked());
        localSubscribeViewHolder.authSwitch.setOnCheckedChangeListener(new SubscribePermissionAdapter.3(this, paramInt));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == SubscribeItemModel.SubscribeViewType.TITLE.ordinal()) {
      return new SubscribePermissionAdapter.TitleViewHolder(localLayoutInflater.inflate(2131559386, paramViewGroup, false));
    }
    if ((paramInt != SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE.ordinal()) && (paramInt != SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE.ordinal()) && (paramInt != SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE.ordinal())) {
      return null;
    }
    return new SubscribePermissionAdapter.SubscribeViewHolder(localLayoutInflater.inflate(2131559385, paramViewGroup, false));
  }
  
  public void setData(List<SubscribeItemModel> paramList)
  {
    this.subscribeItemList = paramList;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter
 * JD-Core Version:    0.7.0.1
 */