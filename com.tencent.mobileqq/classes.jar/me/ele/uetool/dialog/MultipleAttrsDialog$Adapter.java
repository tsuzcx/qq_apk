package me.ele.uetool.dialog;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.ItemArrayList;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.BriefDescItem;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;

public class MultipleAttrsDialog$Adapter
  extends RecyclerView.Adapter
{
  private static List<Element> elementList;
  private MultipleAttrsDialog.ValidCallBack callBack;
  private List<Item> items = new ItemArrayList();
  private List<Item> validItems = new ArrayList();
  
  protected <T extends Item> T getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.items.size())) {
      return null;
    }
    return (Item)this.items.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.items.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    Item localItem = getItem(paramInt);
    if (localItem.getClass() == EditTextItem.class) {
      return 3;
    }
    if (localItem.getClass() == SwitchItem.class) {
      return 4;
    }
    if (localItem.getClass() == AddMinusEditItem.class) {
      return 5;
    }
    if (localItem.getClass() == BriefDescItem.class) {
      return 7;
    }
    throw new RuntimeException("Unknown item type.");
  }
  
  public void notifyDataSetChanged(Element paramElement)
  {
    this.items.clear();
    try
    {
      this.items.addAll(MultipleAttrsDialog.getAttrs(paramElement));
      notifyDataSetChanged();
      return;
    }
    catch (Exception paramElement)
    {
      for (;;)
      {
        paramElement.printStackTrace();
      }
    }
  }
  
  public void notifyValidViewItemInserted(int paramInt, List<Item> paramList)
  {
    this.validItems.addAll(paramList);
    this.items.addAll(paramInt, paramList);
    notifyItemRangeInserted(paramInt, paramList.size());
  }
  
  public void notifyValidViewItemRemoved(int paramInt)
  {
    this.items.removeAll(this.validItems);
    notifyItemRangeRemoved(paramInt, this.validItems.size());
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.getClass() == MultipleAttrsDialog.Adapter.EditTextViewHolder.class) {
      ((MultipleAttrsDialog.Adapter.EditTextViewHolder)paramViewHolder).bindView((EditTextItem)getItem(paramInt));
    }
    do
    {
      return;
      if (paramViewHolder.getClass() == MultipleAttrsDialog.Adapter.SwitchViewHolder.class)
      {
        ((MultipleAttrsDialog.Adapter.SwitchViewHolder)paramViewHolder).bindView((SwitchItem)getItem(paramInt));
        return;
      }
      if (paramViewHolder.getClass() == MultipleAttrsDialog.Adapter.AddMinusEditViewHolder.class)
      {
        ((MultipleAttrsDialog.Adapter.AddMinusEditViewHolder)paramViewHolder).bindView((AddMinusEditItem)getItem(paramInt));
        ((MultipleAttrsDialog.Adapter.AddMinusEditViewHolder)paramViewHolder).setAddMin(((AddMinusEditItem)getItem(paramInt)).getAddMin());
        return;
      }
    } while (paramViewHolder.getClass() != MultipleAttrsDialog.BriefDescViewHolder.class);
    ((MultipleAttrsDialog.BriefDescViewHolder)paramViewHolder).bindView((BriefDescItem)getItem(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      throw new RuntimeException(paramInt + " is an unknown view type!");
    case 3: 
      return MultipleAttrsDialog.Adapter.EditTextViewHolder.newInstance(paramViewGroup);
    case 4: 
      paramViewGroup = MultipleAttrsDialog.Adapter.SwitchViewHolder.newInstance(paramViewGroup);
      paramViewGroup.setCallBack(this.callBack);
      return paramViewGroup;
    case 5: 
      return MultipleAttrsDialog.Adapter.AddMinusEditViewHolder.newInstance(paramViewGroup);
    }
    paramViewGroup = MultipleAttrsDialog.BriefDescViewHolder.newInstance(paramViewGroup);
    paramViewGroup.setCallBack(this.callBack);
    return paramViewGroup;
  }
  
  public void setCallBack(MultipleAttrsDialog.ValidCallBack paramValidCallBack)
  {
    this.callBack = paramValidCallBack;
  }
  
  public void setElementList(List<Element> paramList)
  {
    elementList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter
 * JD-Core Version:    0.7.0.1
 */