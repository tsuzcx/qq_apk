package me.ele.uetool.recyclerview;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.util.JarResource;

public class UniversalAdapter
  extends RecyclerView.Adapter<UniversalAdapter.ViewPool>
  implements View.OnClickListener, View.OnLongClickListener
{
  private List<BaseItem> data = new ArrayList();
  private UniversalAdapter.OnItemClickListener listener;
  private UniversalAdapter.OnItemLongClickListener longListener;
  
  public void clearItems()
  {
    this.data.clear();
    notifyDataSetChanged();
  }
  
  public <T extends BaseItem> T getItem(int paramInt)
  {
    return (BaseItem)this.data.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.data.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((BaseItem)this.data.get(paramInt)).getLayout();
  }
  
  public List<BaseItem> getItems()
  {
    return this.data;
  }
  
  public void insertItem(BaseItem paramBaseItem)
  {
    this.data.add(paramBaseItem);
    notifyDataSetChanged();
  }
  
  public void insertItem(BaseItem paramBaseItem, int paramInt)
  {
    this.data.add(paramInt, paramBaseItem);
    notifyDataSetChanged();
  }
  
  public void insertItems(List<? extends BaseItem> paramList, int paramInt)
  {
    this.data.addAll(paramInt, paramList);
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(UniversalAdapter.ViewPool paramViewPool, int paramInt)
  {
    paramViewPool.itemView.setTag(JarResource.getIdByName("id", "pd_recycler_adapter_id"), Integer.valueOf(paramInt));
    ((BaseItem)this.data.get(paramInt)).onBinding(paramInt, paramViewPool, ((BaseItem)this.data.get(paramInt)).data);
  }
  
  public void onClick(View paramView)
  {
    if (this.listener != null)
    {
      int i = ((Integer)paramView.getTag(JarResource.getIdByName("id", "pd_recycler_adapter_id"))).intValue();
      this.listener.onItemClick(i, (BaseItem)this.data.get(i));
    }
  }
  
  public UniversalAdapter.ViewPool onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setOnLongClickListener(this);
    return new UniversalAdapter.ViewPool(paramViewGroup);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.longListener != null)
    {
      int i = ((Integer)paramView.getTag(JarResource.getIdByName("id", "pd_recycler_adapter_id"))).intValue();
      return this.longListener.onItemLongClick(i, (BaseItem)this.data.get(i));
    }
    return false;
  }
  
  public void performClick(int paramInt)
  {
    if (this.listener != null) {
      this.listener.onItemClick(paramInt, (BaseItem)this.data.get(paramInt));
    }
  }
  
  public void removeItem(int paramInt)
  {
    this.data.remove(paramInt);
    notifyItemRemoved(paramInt);
    notifyItemRangeChanged(paramInt, getItemCount() - paramInt);
  }
  
  public void setItems(List<? extends BaseItem> paramList)
  {
    this.data.clear();
    this.data.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void setListener(UniversalAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.listener = paramOnItemClickListener;
  }
  
  public void setLongClickListener(UniversalAdapter.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.longListener = paramOnItemLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.recyclerview.UniversalAdapter
 * JD-Core Version:    0.7.0.1
 */