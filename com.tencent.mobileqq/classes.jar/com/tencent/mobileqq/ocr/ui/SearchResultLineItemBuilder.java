package com.tencent.mobileqq.ocr.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SearchResultLineItemBuilder
  extends SearchResultBaseBuilder
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, SearchResultAdapter paramSearchResultAdapter, SearchResultAdapter.ListItem paramListItem)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((SearchResultAdapter.ListItem)paramView.getTag()).a == paramListItem.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131559802, null);
    paramView.setTag(paramListItem);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultLineItemBuilder
 * JD-Core Version:    0.7.0.1
 */