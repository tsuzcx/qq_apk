package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.BaseSearchEntryModel;
import com.tencent.mobileqq.search.ContentRecommendModel;
import com.tencent.mobileqq.search.HistorySearchEntryModel;
import com.tencent.mobileqq.search.HistorySearchEntryModel.OnHistorySearchCountListener;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchEntryFragment
  extends Fragment
  implements HistorySearchEntryModel.OnHistorySearchCountListener
{
  public static Map a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public QQAppInterface a;
  public String a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public int a(String paramString)
  {
    if ("kSearchMessageTab".equals(paramString)) {}
    do
    {
      return 1;
      if ("kSearchContactTab".equals(paramString)) {
        return 2;
      }
      if ("kSearchDynamicTab".equals(paramString)) {
        return 3;
      }
    } while (!"kSearchWebTitle".equals(paramString));
    return 3;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseSearchEntryModel)localIterator.next()).c();
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if ((isDetached()) || (getView() == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SearchEntryFragment", 2, "onHistoryCount, isNightMode = " + bool + ", count = " + paramInt + ", mTabType = " + this.jdField_a_of_type_JavaLangString);
      }
    } while ((!"kSearchMessageTab".equals(this.jdField_a_of_type_JavaLangString)) && (!"kSearchContactTab".equals(this.jdField_a_of_type_JavaLangString)));
    if (paramInt <= 0)
    {
      if (bool)
      {
        getView().setBackgroundResource(2130838576);
        return;
      }
      getView().setBackgroundResource(2130838575);
      return;
    }
    getView().setBackgroundResource(0);
  }
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel)
  {
    int j = 0;
    if (getActivity() == null) {
      QLog.e("SearchEntryFragment", 1, "in refreshContentRecommendModel() getActivity() is null.");
    }
    int[] arrayOfInt;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0));
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) instanceof ContentRecommendModel))
        {
          ((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramSearchEntryDataModel);
          return;
        }
        i += 1;
      }
      arrayOfInt = SearchEntryConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(this.jdField_a_of_type_JavaLangString));
      if (QLog.isColorLevel()) {
        QLog.d("SearchEntryFragment", 2, "refreshContentRecommendModel modelIdList = " + arrayOfInt);
      }
    } while ((arrayOfInt == null) || (arrayOfInt.length <= 0));
    int i = j;
    label155:
    BaseSearchEntryModel localBaseSearchEntryModel;
    if (i < arrayOfInt.length) {
      if (arrayOfInt[i] == 4)
      {
        localBaseSearchEntryModel = BaseSearchEntryModel.a(4, a(this.jdField_a_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("SearchEntryFragment", 2, "mModelList.size = " + this.jdField_a_of_type_JavaUtilList.size() + " , i = " + i);
        }
        if (this.jdField_a_of_type_JavaUtilList.size() < i) {
          break label293;
        }
        this.jdField_a_of_type_JavaUtilList.add(i, localBaseSearchEntryModel);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localBaseSearchEntryModel.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null), i);
      localBaseSearchEntryModel.a(paramSearchEntryDataModel);
      i += 1;
      break label155;
      break;
      label293:
      this.jdField_a_of_type_JavaUtilList.add(localBaseSearchEntryModel);
    }
  }
  
  public void a(List paramList)
  {
    int i = 0;
    int j = 0;
    if (getActivity() == null) {
      QLog.e("SearchEntryFragment", 1, "in refreshDataModels() getActivity() is null.");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SearchEntryFragment", 2, "refreshDataModels,  mTabType = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramList);
      }
      if ((getActivity() != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (!isDetached())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SearchEntryFragment", 2, "refreshDataModels,  fragment is in a invalid state");
    return;
    BaseSearchEntryModel localBaseSearchEntryModel;
    if (paramList != null)
    {
      boolean bool = SearchEntryConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(this.jdField_a_of_type_JavaLangString));
      if (bool)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_JavaUtilList.clear();
        if (!"kSearchMessageTab".equals(this.jdField_a_of_type_JavaLangString))
        {
          i = j;
          if (!"kSearchContactTab".equals(this.jdField_a_of_type_JavaLangString)) {}
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList.add(new HistorySearchEntryModel(a(this.jdField_a_of_type_JavaLangString), this));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
          ((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a();
          i = j;
        }
        while (i < paramList.size())
        {
          localBaseSearchEntryModel = BaseSearchEntryModel.a(((SearchEntryDataModel)paramList.get(i)).a, a(this.jdField_a_of_type_JavaLangString));
          if (localBaseSearchEntryModel != null)
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localBaseSearchEntryModel.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
            this.jdField_a_of_type_JavaUtilList.add(localBaseSearchEntryModel);
            localBaseSearchEntryModel.a((SearchEntryDataModel)paramList.get(i));
          }
          i += 1;
        }
        paramList = new View(getActivity());
        paramList.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(getActivity(), 80.0F)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SearchEntryFragment", 2, "refreshDataModels,  mModelList.size = " + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_JavaUtilList.size() + ", needRefreshModelList = " + bool);
        return;
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext()) {
          ((BaseSearchEntryModel)paramList.next()).a();
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_JavaUtilList.clear();
    if (("kSearchMessageTab".equals(this.jdField_a_of_type_JavaLangString)) || ("kSearchContactTab".equals(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaUtilList.add(new HistorySearchEntryModel(a(this.jdField_a_of_type_JavaLangString), this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
      ((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
    paramList = SearchEntryConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(this.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryFragment", 2, "refreshDataModels modelIdList = " + paramList);
    }
    if ((paramList != null) && (paramList.length > 0)) {
      while (i < paramList.length)
      {
        localBaseSearchEntryModel = BaseSearchEntryModel.a(paramList[i], a(this.jdField_a_of_type_JavaLangString));
        if (localBaseSearchEntryModel != null)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localBaseSearchEntryModel.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
          this.jdField_a_of_type_JavaUtilList.add(localBaseSearchEntryModel);
          localBaseSearchEntryModel.a();
        }
        i += 1;
      }
    }
    paramList = new View(getActivity());
    paramList.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(getActivity(), 80.0F)));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = getActivity().getAppRuntime();
    if ((paramLayoutInflater instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramLayoutInflater);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    jdField_a_of_type_JavaUtilMap.clear();
    a(null);
    paramLayoutInflater = new ScrollView(getActivity());
    paramLayoutInflater.setOverScrollMode(0);
    paramLayoutInflater.setVerticalScrollBarEnabled(false);
    paramLayoutInflater.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseSearchEntryModel)localIterator.next()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SearchEntryFragment
 * JD-Core Version:    0.7.0.1
 */