package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.Group;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.ResultItem;
import com.tencent.mobileqq.ocr.TabItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SearchResultAdapter
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new SearchResultAdapter.1(this);
  SearchResultAdapter.OnResultItemClickedListener jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter$OnResultItemClickedListener;
  SearchViewBuilderFactory jdField_a_of_type_ComTencentMobileqqOcrUiSearchViewBuilderFactory = new SearchViewBuilderFactory();
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<SearchResultAdapter.ListItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public SearchResultAdapter(Context paramContext, SearchResultAdapter.OnResultItemClickedListener paramOnResultItemClickedListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter$OnResultItemClickedListener = paramOnResultItemClickedListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(TabItem paramTabItem, List<OCRTextSearchInfo.Group> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramTabItem, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(TabItem paramTabItem, List<OCRTextSearchInfo.Group> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList;
        localObject1 = (SearchResultAdapter.ListItem)((List)localObject1).get(((List)localObject1).size() - 1);
        if (((SearchResultAdapter.ListItem)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
    }
    else {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    Object localObject1 = null;
    int i = 0;
    while (i < paramList.size())
    {
      OCRTextSearchInfo.Group localGroup = (OCRTextSearchInfo.Group)paramList.get(i);
      Object localObject2;
      if (paramTabItem.jdField_a_of_type_Int == 0)
      {
        localObject1 = new SearchResultAdapter.ListItem(this);
        ((SearchResultAdapter.ListItem)localObject1).jdField_a_of_type_Int = 3;
        if (!TextUtils.isEmpty(localGroup.jdField_a_of_type_JavaLangString))
        {
          ((SearchResultAdapter.ListItem)localObject1).jdField_a_of_type_JavaLangObject = localGroup.jdField_a_of_type_JavaLangString;
          ((SearchResultAdapter.ListItem)localObject1).jdField_a_of_type_JavaLangString = localGroup.jdField_a_of_type_JavaLangString;
        }
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = null;
      }
      Object localObject3;
      if (localGroup.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramTabItem.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new SearchResultAdapter.ListItem(this);
            ((SearchResultAdapter.ListItem)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new SearchResultAdapter.ListItem(this);
          ((SearchResultAdapter.ListItem)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        while (j < localGroup.jdField_a_of_type_JavaUtilList.size())
        {
          localObject2 = (OCRTextSearchInfo.ResultItem)localGroup.jdField_a_of_type_JavaUtilList.get(j);
          localObject3 = new SearchResultAdapter.ListItem(this);
          ((SearchResultAdapter.ListItem)localObject3).jdField_a_of_type_Int = 0;
          ((SearchResultAdapter.ListItem)localObject3).jdField_a_of_type_JavaLangObject = ((OCRTextSearchInfo.ResultItem)localObject2).jdField_a_of_type_JavaLangObject;
          ((SearchResultAdapter.ListItem)localObject3).jdField_a_of_type_JavaLangString = localGroup.jdField_a_of_type_JavaLangString;
          ((SearchResultAdapter.ListItem)localObject3).jdField_b_of_type_Int = localGroup.jdField_a_of_type_Int;
          ((SearchResultAdapter.ListItem)localObject3).jdField_c_of_type_Int = j;
          this.jdField_a_of_type_JavaUtilList.add(localObject3);
          if (j != localGroup.jdField_a_of_type_JavaUtilList.size() - 1)
          {
            localObject2 = new SearchResultAdapter.ListItem(this);
            ((SearchResultAdapter.ListItem)localObject2).jdField_a_of_type_Int = 1;
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
          j += 1;
        }
      }
      if ((!TextUtils.isEmpty(localGroup.jdField_b_of_type_JavaLangString)) && (paramTabItem.jdField_a_of_type_Int == 0))
      {
        localObject2 = localGroup.jdField_b_of_type_JavaLangString;
        localObject3 = localGroup.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new SearchResultAdapter.ListItem(this);
          ((SearchResultAdapter.ListItem)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new SearchResultAdapter.ListItem(this);
          ((SearchResultAdapter.ListItem)localObject2).jdField_a_of_type_Int = 4;
          ((SearchResultAdapter.ListItem)localObject2).jdField_c_of_type_JavaLangString = localGroup.jdField_b_of_type_JavaLangString;
          ((SearchResultAdapter.ListItem)localObject2).jdField_a_of_type_JavaLangString = localGroup.jdField_a_of_type_JavaLangString;
          ((SearchResultAdapter.ListItem)localObject2).jdField_b_of_type_JavaLangString = localGroup.jdField_c_of_type_JavaLangString;
          ((SearchResultAdapter.ListItem)localObject2).jdField_b_of_type_Int = localGroup.jdField_a_of_type_Int;
          ((SearchResultAdapter.ListItem)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((SearchResultAdapter.ListItem)localObject1).jdField_b_of_type_JavaLangString = localGroup.jdField_c_of_type_JavaLangString;
            ((SearchResultAdapter.ListItem)localObject1).jdField_c_of_type_JavaLangString = localGroup.jdField_b_of_type_JavaLangString;
            ((SearchResultAdapter.ListItem)localObject1).jdField_b_of_type_Int = localGroup.jdField_a_of_type_Int;
            ((SearchResultAdapter.ListItem)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
    }
    paramTabItem = new SearchResultAdapter.ListItem(this);
    paramTabItem.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilList.add(paramTabItem);
    if (paramBoolean2)
    {
      paramTabItem = new SearchResultAdapter.ListItem(this);
      paramTabItem.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_JavaUtilList.add(paramTabItem);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((SearchResultAdapter.ListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      localObject = null;
    }
    else
    {
      SearchResultAdapter.ListItem localListItem = (SearchResultAdapter.ListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localListItem.jdField_a_of_type_Int == 0)
      {
        localObject = (SearchSougouResultItemBuilder)this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchViewBuilderFactory.a(0);
        ((SearchSougouResultItemBuilder)localObject).a(paramViewGroup);
        localObject = ((SearchSougouResultItemBuilder)localObject).a(paramInt, paramView, paramViewGroup, this, localListItem);
        ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        localObject = paramView;
        if (localListItem.jdField_a_of_type_Int == 1) {
          localObject = ((SearchResultLineItemBuilder)this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchViewBuilderFactory.a(1)).a(paramInt, paramView, paramViewGroup, this, localListItem);
        }
      }
      ((View)localObject).setTag(localListItem);
      paramView = (View)localObject;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */