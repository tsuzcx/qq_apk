package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;

public class TroopEmptyViewItemBuilder
  extends CloudFileItemBuilder
{
  protected int a = 0;
  
  public TroopEmptyViewItemBuilder(AppInterface paramAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  public View a(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.g).inflate(2131624971, null);
      paramICloudFile = new TroopEmptyViewItemBuilder.Holder(null);
      paramICloudFile.a = ((TextView)paramView.findViewById(2131434454));
      paramICloudFile.b = ((ImageView)paramView.findViewById(2131434455));
      paramView.setTag(paramICloudFile);
    }
    else
    {
      paramICloudFile = (TroopEmptyViewItemBuilder.Holder)paramView.getTag();
    }
    paramICloudFile.a.setText(2131890197);
    paramICloudFile.b.setImageResource(2130840632);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopEmptyViewItemBuilder
 * JD-Core Version:    0.7.0.1
 */