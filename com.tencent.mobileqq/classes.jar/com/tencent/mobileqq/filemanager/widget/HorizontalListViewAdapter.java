package com.tencent.mobileqq.filemanager.widget;

import adqz;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class HorizontalListViewAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public static HorizontalListViewAdapter.MenuData a(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    HorizontalListViewAdapter.MenuData localMenuData = new HorizontalListViewAdapter.MenuData();
    localMenuData.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    localMenuData.jdField_a_of_type_Int = paramInt;
    localMenuData.jdField_a_of_type_JavaLangString = paramString;
    return localMenuData;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new HorizontalListViewAdapter.HlistViewHolder();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970019, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368763));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368764));
      paramView.setTag(paramViewGroup);
      if (paramInt != this.jdField_a_of_type_Int) {
        break label147;
      }
      paramView.setSelected(true);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((HorizontalListViewAdapter.MenuData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext, ((HorizontalListViewAdapter.MenuData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(new adqz(this, paramInt));
      return paramView;
      paramViewGroup = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      break;
      label147:
      paramView.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter
 * JD-Core Version:    0.7.0.1
 */