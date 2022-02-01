package me.ele.uetool.dialog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.ele.uetool.UETool;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.IAttrs;
import me.ele.uetool.base.ItemArrayList;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.BitmapItem;
import me.ele.uetool.base.item.BriefDescItem;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.base.item.TextItem;
import me.ele.uetool.base.item.TitleItem;

public class AttrsDialog$Adapter
  extends RecyclerView.Adapter
{
  private AttrsDialog.AttrDialogCallback callback;
  private List<Item> items = new ItemArrayList();
  private List<Item> validItems = new ArrayList();
  
  @Nullable
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
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Item localItem = getItem(paramInt);
    if (localItem.getClass() == TitleItem.class) {
      return 1;
    }
    if (localItem.getClass() == TextItem.class) {
      return 2;
    }
    if (localItem.getClass() == EditTextItem.class) {
      return 3;
    }
    if (localItem.getClass() == SwitchItem.class) {
      return 4;
    }
    if (localItem.getClass() == AddMinusEditItem.class) {
      return 5;
    }
    if (localItem.getClass() == BitmapItem.class) {
      return 6;
    }
    if (localItem.getClass() == BriefDescItem.class) {
      return 7;
    }
    throw new RuntimeException("Unknown item type.");
  }
  
  public void notifyDataSetChanged(Element paramElement)
  {
    this.items.clear();
    Iterator localIterator = UETool.getInstance().getAttrsProvider().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      try
      {
        localObject = (IAttrs)Class.forName((String)localObject).newInstance();
        this.items.addAll(((IAttrs)localObject).getAttrs(paramElement));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    notifyDataSetChanged();
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
    if (paramViewHolder.getClass() == AttrsDialog.Adapter.TitleViewHolder.class) {
      ((AttrsDialog.Adapter.TitleViewHolder)paramViewHolder).bindView((TitleItem)getItem(paramInt));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (paramViewHolder.getClass() == AttrsDialog.Adapter.TextViewHolder.class)
      {
        ((AttrsDialog.Adapter.TextViewHolder)paramViewHolder).bindView((TextItem)getItem(paramInt));
      }
      else if (paramViewHolder.getClass() == AttrsDialog.Adapter.EditTextViewHolder.class)
      {
        ((AttrsDialog.Adapter.EditTextViewHolder)paramViewHolder).bindView((EditTextItem)getItem(paramInt));
      }
      else if (paramViewHolder.getClass() == AttrsDialog.Adapter.SwitchViewHolder.class)
      {
        ((AttrsDialog.Adapter.SwitchViewHolder)paramViewHolder).bindView((SwitchItem)getItem(paramInt));
      }
      else if (paramViewHolder.getClass() == AttrsDialog.Adapter.AddMinusEditViewHolder.class)
      {
        ((AttrsDialog.Adapter.AddMinusEditViewHolder)paramViewHolder).bindView((AddMinusEditItem)getItem(paramInt));
        ((AttrsDialog.Adapter.AddMinusEditViewHolder)paramViewHolder).setAddMin(((AddMinusEditItem)getItem(paramInt)).getAddMin());
      }
      else if (paramViewHolder.getClass() == AttrsDialog.Adapter.BitmapInfoViewHolder.class)
      {
        ((AttrsDialog.Adapter.BitmapInfoViewHolder)paramViewHolder).bindView((BitmapItem)getItem(paramInt));
      }
      else if (paramViewHolder.getClass() == AttrsDialog.Adapter.BriefDescViewHolder.class)
      {
        ((AttrsDialog.Adapter.BriefDescViewHolder)paramViewHolder).bindView((BriefDescItem)getItem(paramInt));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new RuntimeException(paramInt + " is an unknown view type!");
    case 1: 
      paramViewGroup = AttrsDialog.Adapter.TitleViewHolder.newInstance(paramViewGroup);
      paramViewGroup.setIsRecyclable(false);
      return paramViewGroup;
    case 2: 
      paramViewGroup = AttrsDialog.Adapter.TextViewHolder.newInstance(paramViewGroup);
      paramViewGroup.setIsRecyclable(false);
      return paramViewGroup;
    case 3: 
      paramViewGroup = AttrsDialog.Adapter.EditTextViewHolder.newInstance(paramViewGroup);
      paramViewGroup.setIsRecyclable(false);
      return paramViewGroup;
    case 4: 
      paramViewGroup = AttrsDialog.Adapter.SwitchViewHolder.newInstance(paramViewGroup, this.callback);
      paramViewGroup.setIsRecyclable(false);
      return paramViewGroup;
    case 5: 
      paramViewGroup = AttrsDialog.Adapter.AddMinusEditViewHolder.newInstance(paramViewGroup);
      paramViewGroup.setIsRecyclable(false);
      return paramViewGroup;
    case 6: 
      paramViewGroup = AttrsDialog.Adapter.BitmapInfoViewHolder.newInstance(paramViewGroup);
      paramViewGroup.setIsRecyclable(false);
      return paramViewGroup;
    }
    paramViewGroup = AttrsDialog.Adapter.BriefDescViewHolder.newInstance(paramViewGroup, this.callback);
    paramViewGroup.setIsRecyclable(false);
    return paramViewGroup;
  }
  
  public void setAttrDialogCallback(AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
  {
    this.callback = paramAttrDialogCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter
 * JD-Core Version:    0.7.0.1
 */