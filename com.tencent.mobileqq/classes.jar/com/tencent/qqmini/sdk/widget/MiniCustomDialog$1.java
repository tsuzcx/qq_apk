package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;

class MiniCustomDialog$1
  extends BaseAdapter
{
  MiniCustomDialog$1(MiniCustomDialog paramMiniCustomDialog) {}
  
  public int getCount()
  {
    if (this.this$0.items != null) {
      return this.this$0.items.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.this$0.inflater == null)
    {
      localObject = this.this$0;
      ((MiniCustomDialog)localObject).inflater = ((LayoutInflater)((MiniCustomDialog)localObject).getContext().getSystemService("layout_inflater"));
    }
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = this.this$0.inflater.inflate(this.this$0.getDialogListItemLayout(), null);
      paramView = new MiniCustomDialog.Holder(this.this$0, null);
      paramView.text = ((TextView)((View)localObject).findViewById(R.id.item_text));
      ((View)localObject).setTag(paramView);
    }
    paramView = (MiniCustomDialog.Holder)((View)localObject).getTag();
    if (paramView.text != null)
    {
      paramView.text.setText(this.this$0.items[paramInt]);
      paramView.text.setOnClickListener(new MiniCustomDialog.CustomDialogItemOnClickListener(this.this$0, paramInt));
      int i = paramView.text.getPaddingTop();
      int j = paramView.text.getPaddingLeft();
      int k = paramView.text.getPaddingRight();
      int m = paramView.text.getPaddingBottom();
      if (this.this$0.items.length == 1) {
        paramView.text.setBackgroundResource(R.drawable.mini_sdk_custom_dialog_list_item_single_bg_selector);
      } else if (paramInt == 0) {
        paramView.text.setBackgroundResource(R.drawable.mini_sdk_custom_dialog_list_item_up_bg_selector);
      } else if (paramInt == this.this$0.items.length - 1) {
        paramView.text.setBackgroundResource(R.drawable.mini_sdk_custom_dialog_list_item_down_bg_selector);
      }
      paramView.text.setPadding(j, i, k, m);
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniCustomDialog.1
 * JD-Core Version:    0.7.0.1
 */