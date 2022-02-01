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
  protected int a;
  
  public TroopEmptyViewItemBuilder(AppInterface paramAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559214, null);
      paramICloudFile = new TroopEmptyViewItemBuilder.Holder(null);
      paramICloudFile.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367874));
      paramICloudFile.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367875));
      paramView.setTag(paramICloudFile);
    }
    else
    {
      paramICloudFile = (TroopEmptyViewItemBuilder.Holder)paramView.getTag();
    }
    paramICloudFile.jdField_a_of_type_AndroidWidgetTextView.setText(2131693083);
    paramICloudFile.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840311);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopEmptyViewItemBuilder
 * JD-Core Version:    0.7.0.1
 */