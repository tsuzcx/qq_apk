package com.tencent.mobileqq.troop.homework.recite.ui;

import ajjt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class SearchReciteArticleFragment$FlowLayoutKeywordsListAdapter
  extends BaseAdapter
{
  public SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter.OnItemClickListener a;
  private List a = new ArrayList();
  
  public String a(int paramInt)
  {
    return (String)this.a.get(paramInt);
  }
  
  public void a(String paramString)
  {
    this.a.add(paramString);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969925, null, false);
      paramViewGroup = new ajjt(this, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361928));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = a(paramInt);
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return paramView;
      paramViewGroup = (ajjt)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter
 * JD-Core Version:    0.7.0.1
 */