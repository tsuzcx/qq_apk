package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.BaseSearchEntryModel;
import com.tencent.mobileqq.search.HistorySearchEntryModel;
import com.tencent.mobileqq.search.HistorySearchEntryModel.OnHistorySearchCountListener;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.SearchWordHistoryEntryModel;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchEntryFragment
  extends ReportV4Fragment
  implements HistorySearchEntryModel.OnHistorySearchCountListener, ISearchEntryFragment
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle = new Bundle(9);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<BaseSearchEntryModel> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 21;
    }
    return 25;
  }
  
  private void a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetLinearLayout.getWindowToken(), 2);
    }
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseSearchEntryModel localBaseSearchEntryModel = (BaseSearchEntryModel)localIterator.next();
      if ((localBaseSearchEntryModel instanceof HotWordSearchEntryModel)) {
        ((HotWordSearchEntryModel)localBaseSearchEntryModel).d();
      }
    }
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
      if ("kSearchWebTitle".equals(paramString)) {
        return 3;
      }
    } while (!"kSearchReadInJoyTab".equals(paramString));
    return 10;
  }
  
  public void a(int paramInt)
  {
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if ((isDetached()) || (getView() == null)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SearchEntryFragment", 2, "onHistoryCount, isNightMode = " + bool + ", count = " + paramInt + ", mTabType = " + this.jdField_a_of_type_JavaLangString);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    b();
  }
  
  @NonNull
  public Fragment getFragment()
  {
    return this;
  }
  
  @NonNull
  public Bundle getInitData()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = getActivity().getAppRuntime();
    if ((paramLayoutInflater instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramLayoutInflater);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    mIsModelsReported.clear();
    refreshDataModels(null, UniteSearchActivity.a(this.jdField_a_of_type_Int, this.b));
    paramLayoutInflater = new ScrollView(getActivity());
    paramLayoutInflater.setOverScrollMode(0);
    paramLayoutInflater.setVerticalScrollBarEnabled(false);
    paramLayoutInflater.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramLayoutInflater.setOnTouchListener(new SearchEntryFragment.1(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AbstractGifImage.pauseAll();
    b();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseSearchEntryModel)localIterator.next()).b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    b();
    if ((TextUtils.equals(SearchEntryConfigManager.b, "Recom_word")) && (!this.jdField_a_of_type_Boolean)) {
      ReadInJoyTabTopSearchHeaderController.jdField_a_of_type_Int += SearchEntryConfigManager.jdField_a_of_type_Int;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) instanceof SearchWordHistoryEntryModel)) {
          refresh();
        }
        i += 1;
      }
    }
  }
  
  public void onSoftKeyboardClosed() {}
  
  public void onSoftKeyboardOpened(int paramInt) {}
  
  public void refresh()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseSearchEntryModel)localIterator.next()).c();
    }
  }
  
  public void refreshDataModels(List<SearchEntryDataModel> paramList, boolean paramBoolean)
  {
    if (getActivity() == null) {
      QLog.e("SearchEntryFragment", 1, "in refreshDataModels() getActivity() is null.");
    }
    do
    {
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
    } while (StudyModeManager.a());
    boolean bool2 = SearchUtils.b(this.jdField_a_of_type_Int);
    if (bool2) {}
    for (boolean bool1 = SearchConfigUtils.a(this.jdField_a_of_type_Int);; bool1 = false)
    {
      Object localObject;
      int i;
      if (paramList != null)
      {
        boolean bool3 = SearchEntryConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(this.jdField_a_of_type_JavaLangString), paramBoolean);
        if (bool3)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          localObject = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((BaseSearchEntryModel)((Iterator)localObject).next()).b();
          }
          this.jdField_a_of_type_JavaUtilList.clear();
          if (("kSearchMessageTab".equals(this.jdField_a_of_type_JavaLangString)) || ("kSearchContactTab".equals(this.jdField_a_of_type_JavaLangString)) || ("kSearchDynamicTab".equals(this.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_JavaUtilList.add(new HistorySearchEntryModel(a(this.jdField_a_of_type_JavaLangString), this));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
            ((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a();
          }
          i = 0;
          if (i < paramList.size())
          {
            if ((((SearchEntryDataModel)paramList.get(i)).c == 1) && (bool2) && (!bool1)) {
              if (QLog.isColorLevel()) {
                QLog.d("SearchEntryFragment", 2, "refreshDataModels net, ignore hotWord: " + this.jdField_a_of_type_Int);
              }
            }
            for (;;)
            {
              i += 1;
              break;
              localObject = BaseSearchEntryModel.a(((SearchEntryDataModel)paramList.get(i)).c, a(this.jdField_a_of_type_JavaLangString), paramBoolean);
              if (localObject != null)
              {
                if (i == 0) {
                  ((BaseSearchEntryModel)localObject).jdField_a_of_type_Boolean = false;
                }
                this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)localObject).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
                this.jdField_a_of_type_JavaUtilList.add(localObject);
                ((BaseSearchEntryModel)localObject).a((SearchEntryDataModel)paramList.get(i));
              }
            }
          }
          if ("kSearchReadInJoyTab".equals(this.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_JavaUtilList.add(new SearchWordHistoryEntryModel(a(this.jdField_a_of_type_JavaLangString)));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
            ((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).a();
          }
          paramList = new View(getActivity());
          paramList.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(getActivity(), 80.0F)));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("SearchEntryFragment", 2, "refreshDataModels,  mModelList.size = " + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_JavaUtilList.size() + ", needRefreshModelList = " + bool3);
          return;
          paramList = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramList.hasNext()) {
            ((BaseSearchEntryModel)paramList.next()).a();
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramList.hasNext()) {
        ((BaseSearchEntryModel)paramList.next()).b();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (("kSearchMessageTab".equals(this.jdField_a_of_type_JavaLangString)) || ("kSearchContactTab".equals(this.jdField_a_of_type_JavaLangString)) || ("kSearchDynamicTab".equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilList.add(new HistorySearchEntryModel(a(this.jdField_a_of_type_JavaLangString), this));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
        ((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a();
      }
      paramList = SearchEntryConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(this.jdField_a_of_type_JavaLangString), paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("SearchEntryFragment", 2, "refreshDataModels modelIdList = " + paramList);
      }
      if ((paramList != null) && (paramList.length > 0))
      {
        i = 0;
        if (i < paramList.length)
        {
          if ((paramList[i] == 1) && (bool2) && (!bool1)) {
            if (QLog.isColorLevel()) {
              QLog.d("SearchEntryFragment", 2, "refreshDataModels local, ignore hotWord: " + this.jdField_a_of_type_Int);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if ((paramList[i] != 0) || (!"kSearchReadInJoyTab".equals(this.jdField_a_of_type_JavaLangString)))
            {
              localObject = BaseSearchEntryModel.a(paramList[i], a(this.jdField_a_of_type_JavaLangString), paramBoolean);
              if (localObject != null)
              {
                if (i == 0) {
                  ((BaseSearchEntryModel)localObject).jdField_a_of_type_Boolean = false;
                }
                this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)localObject).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
                this.jdField_a_of_type_JavaUtilList.add(localObject);
                ((BaseSearchEntryModel)localObject).a();
              }
            }
          }
        }
      }
      if ("kSearchReadInJoyTab".equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilList.add(new SearchWordHistoryEntryModel(a(this.jdField_a_of_type_JavaLangString)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
        ((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).a();
      }
      paramList = new View(getActivity());
      paramList.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(getActivity(), 80.0F)));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
      return;
    }
  }
  
  public void setApp(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void setInitData(@NonNull Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Int = paramBundle.getInt("source");
    this.b = paramBundle.getInt("from");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("tabType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SearchEntryFragment
 * JD-Core Version:    0.7.0.1
 */