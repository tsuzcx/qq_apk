package com.tencent.mobileqq.troop.homework.recite.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class SearchReciteArticleFragment$SearchResultListAdapter
  extends BaseAdapter
{
  protected SearchReciteArticleFragment a;
  protected String a;
  protected List<SearchReciteArticleFragment.SearchArticle> a;
  
  public SearchReciteArticleFragment$SearchResultListAdapter(SearchReciteArticleFragment paramSearchReciteArticleFragment)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment = paramSearchReciteArticleFragment;
  }
  
  public SearchReciteArticleFragment.SearchArticle a(int paramInt)
  {
    return (SearchReciteArticleFragment.SearchArticle)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(SearchReciteArticleFragment.SearchArticle paramSearchArticle)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramSearchArticle);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560797, null, false);
      paramView = new SearchReciteArticleFragment.SearchResultListAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380651));
      paramView.b = ((TextView)localView.findViewById(2131380283));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_Int = paramInt;
      Object localObject = a(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(SearchReciteArticleFragment.a(this.jdField_a_of_type_JavaLangString, ((SearchReciteArticleFragment.SearchArticle)localObject).jdField_a_of_type_JavaLangString, Color.parseColor("#00B6F9")));
      paramView.b.setText(((SearchReciteArticleFragment.SearchArticle)localObject).b);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (SearchReciteArticleFragment.SearchResultListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.SearchResultListAdapter
 * JD-Core Version:    0.7.0.1
 */