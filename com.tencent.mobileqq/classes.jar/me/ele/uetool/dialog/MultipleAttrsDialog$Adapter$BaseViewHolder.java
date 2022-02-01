package me.ele.uetool.dialog;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import me.ele.uetool.base.item.Item;

public abstract class MultipleAttrsDialog$Adapter$BaseViewHolder<T extends Item>
  extends RecyclerView.ViewHolder
{
  protected T item;
  
  public MultipleAttrsDialog$Adapter$BaseViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public void bindView(T paramT)
  {
    this.item = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */