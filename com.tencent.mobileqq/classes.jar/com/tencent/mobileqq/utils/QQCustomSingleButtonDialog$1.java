package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomSingleButtonDialog$1
  extends BaseAdapter
{
  QQCustomSingleButtonDialog$1(QQCustomSingleButtonDialog paramQQCustomSingleButtonDialog) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString != null) {
      return this.a.jdField_a_of_type_ArrayOfJavaLangString.length;
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
    if (this.a.jdField_a_of_type_AndroidViewLayoutInflater == null) {
      this.a.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)this.a.getContext().getSystemService("layout_inflater"));
    }
    QQCustomSingleButtonDialog.Holder localHolder;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559072, null);
      localHolder = new QQCustomSingleButtonDialog.Holder(this.a, null);
      localHolder.a = ((TextView)paramView.findViewById(2131369433));
      paramView.setTag(localHolder);
    }
    for (;;)
    {
      localHolder = (QQCustomSingleButtonDialog.Holder)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localHolder.a != null)
      {
        localHolder.a.setText(this.a.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        localHolder.a.setOnClickListener(new QQCustomSingleButtonDialog.CustomDialogItemOnClickListener(this.a, paramInt));
        i = localHolder.a.getPaddingTop();
        j = localHolder.a.getPaddingLeft();
        k = localHolder.a.getPaddingRight();
        m = localHolder.a.getPaddingBottom();
        if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 1) {
          break label232;
        }
        localHolder.a.setBackgroundResource(2130839683);
      }
      for (;;)
      {
        localHolder.a.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label232:
        if (paramInt == 0) {
          localHolder.a.setBackgroundResource(2130839684);
        } else if (paramInt == this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
          localHolder.a.setBackgroundResource(2130839682);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomSingleButtonDialog.1
 * JD-Core Version:    0.7.0.1
 */