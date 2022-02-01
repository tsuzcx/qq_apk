package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.search.entity.ReadInJoySearchWord;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.BaseSearchEntryModel;
import com.tencent.mobileqq.search.HistorySearchEntryModel;
import com.tencent.mobileqq.search.HistorySearchEntryModel.OnHistorySearchCountListener;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.SearchWordHistoryEntryModel;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchEntryFragment
  extends BaseFragment
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
    int i = 2;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 10) {
            return 0;
          }
          return 25;
        }
        return 21;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  private void a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getBaseActivity().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetLinearLayout.getWindowToken(), 2);
    }
  }
  
  private void a(SearchEntryDataModel paramSearchEntryDataModel)
  {
    if ((paramSearchEntryDataModel instanceof HotWordSearchEntryDataModel))
    {
      paramSearchEntryDataModel = ((HotWordSearchEntryDataModel)paramSearchEntryDataModel).a;
      int i = 0;
      while (i < paramSearchEntryDataModel.size())
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(((HotWordSearchEntryDataModel.HotSearchItem)paramSearchEntryDataModel.get(i)).sExtInfo);
          HashMap localHashMap = new HashMap();
          localHashMap.put("ext5", localJSONObject.optString("ext5"));
          localHashMap.put("ext6", localJSONObject.optString("ext6"));
          localHashMap.put("ext7", localJSONObject.optString("ext7"));
          localHashMap.put("ext8", localJSONObject.optString("ext8"));
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 104, 1, 1, localHashMap, null, null);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        i += 1;
      }
    }
  }
  
  private void a(List<SearchEntryDataModel> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = SearchEntryConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(this.jdField_a_of_type_JavaLangString), paramBoolean1);
    int j = 0;
    int i;
    Object localObject;
    if (bool)
    {
      b();
      i = 0;
      while (i < paramList.size())
      {
        if (((((SearchEntryDataModel)paramList.get(i)).c == 1) || (((SearchEntryDataModel)paramList.get(i)).c == 8)) && (paramBoolean2) && (!paramBoolean3))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("refreshDataModels net, ignore hotWord: ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
            QLog.d("SearchEntryFragment", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = BaseSearchEntryModel.a(((SearchEntryDataModel)paramList.get(i)).c, a(this.jdField_a_of_type_JavaLangString), paramBoolean1);
          if (localObject != null)
          {
            if (i == 0) {
              ((BaseSearchEntryModel)localObject).jdField_a_of_type_Boolean = false;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)localObject).a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
            this.jdField_a_of_type_JavaUtilList.add(localObject);
            ((BaseSearchEntryModel)localObject).a((SearchEntryDataModel)paramList.get(i));
          }
        }
        i += 1;
      }
      if ("kSearchReadInJoyTab".equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilList.add(new SearchWordHistoryEntryModel(a(this.jdField_a_of_type_JavaLangString)));
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        List localList = this.jdField_a_of_type_JavaUtilList;
        ((LinearLayout)localObject).addView(((BaseSearchEntryModel)localList.get(localList.size() - 1)).a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
        localObject = this.jdField_a_of_type_JavaUtilList;
        ((BaseSearchEntryModel)((List)localObject).get(((List)localObject).size() - 1)).a();
      }
      localObject = new View(getBaseActivity());
      ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(getBaseActivity(), 80.0F)));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      i = j;
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ((BaseSearchEntryModel)((Iterator)localObject).next()).a();
      }
    }
    while (i < paramList.size())
    {
      if (((SearchEntryDataModel)paramList.get(i)).c == 8) {
        a((SearchEntryDataModel)paramList.get(i));
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("refreshDataModels,  mModelList.size = ");
      paramList.append(this.jdField_a_of_type_JavaLangString);
      paramList.append(this.jdField_a_of_type_JavaUtilList.size());
      paramList.append(", needRefreshModelList = ");
      paramList.append(bool);
      QLog.d("SearchEntryFragment", 2, paramList.toString());
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    b();
    Object localObject1 = SearchEntryConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(this.jdField_a_of_type_JavaLangString), paramBoolean1);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshDataModels modelIdList = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("SearchEntryFragment", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int i = 0;
      while (i < localObject1.length)
      {
        if (((localObject1[i] == 1) || (localObject1[i] == 8)) && (paramBoolean2) && (!paramBoolean3))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("refreshDataModels local, ignore hotWord: ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
            QLog.d("SearchEntryFragment", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else if ((localObject1[i] != 0) || (!"kSearchReadInJoyTab".equals(this.jdField_a_of_type_JavaLangString)))
        {
          localObject2 = BaseSearchEntryModel.a(localObject1[i], a(this.jdField_a_of_type_JavaLangString), paramBoolean1);
          if (localObject2 != null)
          {
            if (i == 0) {
              ((BaseSearchEntryModel)localObject2).jdField_a_of_type_Boolean = false;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)localObject2).a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
            ((BaseSearchEntryModel)localObject2).a();
          }
        }
        i += 1;
      }
    }
    if ("kSearchReadInJoyTab".equals(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilList.add(new SearchWordHistoryEntryModel(a(this.jdField_a_of_type_JavaLangString)));
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      localObject2 = this.jdField_a_of_type_JavaUtilList;
      ((LinearLayout)localObject1).addView(((BaseSearchEntryModel)((List)localObject2).get(((List)localObject2).size() - 1)).a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      ((BaseSearchEntryModel)((List)localObject1).get(((List)localObject1).size() - 1)).a();
    }
    localObject1 = new View(getBaseActivity());
    ((View)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(getBaseActivity(), 80.0F)));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseSearchEntryModel)localIterator.next()).b();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (("kSearchMessageTab".equals(this.jdField_a_of_type_JavaLangString)) || ("kSearchContactTab".equals(this.jdField_a_of_type_JavaLangString)) || ("kSearchDynamicTab".equals(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaUtilList.add(new HistorySearchEntryModel(a(this.jdField_a_of_type_JavaLangString), this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
      ((BaseSearchEntryModel)this.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
  }
  
  private void c()
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
    if ("kSearchMessageTab".equals(paramString)) {
      return 1;
    }
    if ("kSearchContactTab".equals(paramString)) {
      return 2;
    }
    if ("kSearchDynamicTab".equals(paramString)) {
      return 3;
    }
    if ("kSearchWebTitle".equals(paramString)) {
      return 3;
    }
    if ("kSearchReadInJoyTab".equals(paramString)) {
      return 10;
    }
    return 1;
  }
  
  public void a(int paramInt)
  {
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (!isDetached())
    {
      if (getView() == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onHistoryCount, isNightMode = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", count = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", mTabType = ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("SearchEntryFragment", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    c();
  }
  
  @NonNull
  public QBaseFragment getFragment()
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
    paramLayoutInflater = getBaseActivity().getAppRuntime();
    if ((paramLayoutInflater instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramLayoutInflater);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getBaseActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    mIsModelsReported.clear();
    refreshDataModels(null, UniteSearchActivity.a(this.jdField_a_of_type_Int, this.b));
    paramLayoutInflater = new ScrollView(getBaseActivity());
    paramLayoutInflater.setOverScrollMode(0);
    paramLayoutInflater.setVerticalScrollBarEnabled(false);
    paramLayoutInflater.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramLayoutInflater.setOnTouchListener(new SearchEntryFragment.1(this));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AbstractGifImage.pauseAll();
    c();
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
    c();
    if ((TextUtils.equals(SearchEntryConfigManager.b, "Recom_word")) && (!this.jdField_a_of_type_Boolean)) {
      ReadInJoySearchWord.jdField_a_of_type_Int += SearchEntryConfigManager.jdField_a_of_type_Int;
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
    if (getBaseActivity() == null)
    {
      QLog.e("SearchEntryFragment", 1, "in refreshDataModels() getActivity() is null.");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshDataModels,  mTabType = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(paramList);
      QLog.d("SearchEntryFragment", 2, localStringBuilder.toString());
    }
    if ((getBaseActivity() != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (!isDetached()))
    {
      if (StudyModeManager.a()) {
        return;
      }
      boolean bool2 = SearchUtils.b(this.jdField_a_of_type_Int);
      boolean bool1 = false;
      if (bool2) {
        bool1 = SearchConfigUtils.a(this.jdField_a_of_type_Int);
      }
      if (paramList != null)
      {
        a(paramList, paramBoolean, bool2, bool1);
        return;
      }
      a(paramBoolean, bool2, bool1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryFragment", 2, "refreshDataModels,  fragment is in a invalid state");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SearchEntryFragment
 * JD-Core Version:    0.7.0.1
 */