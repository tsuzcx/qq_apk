package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class IPublicAccountBrowser$ActionSheetItemAdapter
  extends ArrayAdapter<IPublicAccountBrowser.ActionSheetItem>
{
  private List<IPublicAccountBrowser.ActionSheetItem> a;
  private LayoutInflater b;
  
  public IPublicAccountBrowser$ActionSheetItemAdapter(Context paramContext, int paramInt, List<IPublicAccountBrowser.ActionSheetItem> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.a = paramList;
    this.b = LayoutInflater.from(paramContext);
  }
  
  public IPublicAccountBrowser.ActionSheetItem a(int paramInt)
  {
    return (IPublicAccountBrowser.ActionSheetItem)this.a.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.b.inflate(2131624761, null);
      paramView = new IPublicAccountBrowser.ActionSheetItemViewHolder();
      paramView.b = ((ImageView)localView.findViewById(2131440807));
      paramView.a = ((TextView)localView.findViewById(2131440808));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (IPublicAccountBrowser.ActionSheetItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = a(paramInt);
    paramView.c = ((IPublicAccountBrowser.ActionSheetItem)localObject);
    paramView.a.setText(((IPublicAccountBrowser.ActionSheetItem)localObject).c);
    paramView.b.setBackgroundResource(((IPublicAccountBrowser.ActionSheetItem)localObject).a);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.IPublicAccountBrowser.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */