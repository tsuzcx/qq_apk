package com.tencent.mobileqq.ocr.ui;

import aghp;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.Group;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.ResultItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SearchResultAdapter
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aghp(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public SearchResultAdapter.OnResultItemClickedListener a;
  SearchViewBuilderFactory jdField_a_of_type_ComTencentMobileqqOcrUiSearchViewBuilderFactory = new SearchViewBuilderFactory();
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public SearchResultAdapter(Context paramContext, QQAppInterface paramQQAppInterface, SearchResultAdapter.OnResultItemClickedListener paramOnResultItemClickedListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter$OnResultItemClickedListener = paramOnResultItemClickedListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(SearchResultViewPagerAdapter.TabItem paramTabItem, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramTabItem, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(SearchResultViewPagerAdapter.TabItem paramTabItem, List paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    OCRTextSearchInfo.Group localGroup;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (SearchResultAdapter.ListItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((SearchResultAdapter.ListItem)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localGroup = (OCRTextSearchInfo.Group)paramList.get(i);
      if (paramTabItem.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new SearchResultAdapter.ListItem(this);
      ((SearchResultAdapter.ListItem)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localGroup.jdField_a_of_type_JavaLangString))
      {
        ((SearchResultAdapter.ListItem)localObject2).jdField_a_of_type_JavaLangObject = localGroup.jdField_a_of_type_JavaLangString;
        ((SearchResultAdapter.ListItem)localObject2).jdField_a_of_type_JavaLangString = localGroup.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
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
        for (;;)
        {
          if (j < localGroup.jdField_a_of_type_JavaUtilList.size())
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
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
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
      break label68;
      label606:
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
      return;
      label666:
      localObject2 = null;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    SearchResultAdapter.ListItem localListItem = (SearchResultAdapter.ListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localListItem.jdField_a_of_type_Int == 0)
    {
      localObject = (SearchSougouResultItemBuilder)this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchViewBuilderFactory.a(0);
      ((SearchSougouResultItemBuilder)localObject).a(paramViewGroup);
      localObject = ((SearchSougouResultItemBuilder)localObject).a(paramInt, paramView, paramViewGroup, this, localListItem);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localListItem);
      return localObject;
      localObject = paramView;
      if (localListItem.jdField_a_of_type_Int == 1) {
        localObject = ((SearchResultLineItemBuilder)this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchViewBuilderFactory.a(1)).a(paramInt, paramView, paramViewGroup, this, localListItem);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */