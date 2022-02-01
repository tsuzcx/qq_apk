package com.tencent.mobileqq.search.fragment;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.kandian.biz.search.api.OnTipClickListener;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.BusinessGroupWord.ClueWordItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord.GroupID;
import com.tencent.mobileqq.search.model.BusinessGroupWord.HotWordItem;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.HotWordForSubTipsContainer;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HotWordsForSubBussFragment
  extends BaseFragment
{
  protected static int a;
  public static final String a;
  protected View a;
  protected TextView a;
  protected QQAppInterface a;
  protected UnifySearchHandler a;
  protected UnifySearchObserver a;
  protected UniteSearchHandler a;
  protected UniteSearchObserver a;
  OnTipClickListener jdField_a_of_type_ComTencentMobileqqKandianBizSearchApiOnTipClickListener = new HotWordsForSubBussFragment.5(this);
  protected HotWordForSubTipsContainer a;
  private boolean jdField_a_of_type_Boolean = false;
  protected long[] a;
  private int b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unify_search");
    localStringBuilder.append(HotWordsForSubBussFragment.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Int = -1;
  }
  
  public HotWordsForSubBussFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver = new HotWordsForSubBussFragment.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new HotWordsForSubBussFragment.4(this);
  }
  
  private void a(List<BusinessGroupWord.HotWordItem> paramList)
  {
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a(paramList, 2130840377, getResources().getColor(2131166989), getResources().getColor(2131166988));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a(paramList, 2130840374, getResources().getColor(2131165327), getResources().getColor(2131166987));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "update BusiHotWords results is null");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void b(List<BusinessGroupWord> paramList)
  {
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      return;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateBusiHotWords results is null");
      }
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (BusinessGroupWord)paramList.next();
      Object localObject2 = SearchUtils.a(((BusinessGroupWord)localObject1).groupID.a);
      if ((localObject2 != null) && (Arrays.equals((long[])localObject2, this.jdField_a_of_type_ArrayOfLong)))
      {
        localObject2 = ((BusinessGroupWord)localObject1).clueWordItem;
        BaseActivity localBaseActivity = getBaseActivity();
        if ((localBaseActivity instanceof ActiveEntitySearchActivity)) {
          ((ActiveEntitySearchActivity)localBaseActivity).d(((BusinessGroupWord.ClueWordItem)localObject2).b);
        }
        localObject1 = ((BusinessGroupWord)localObject1).hotWordItemList;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a((List)localObject1, 2130840377, getResources().getColor(2131166989), getResources().getColor(2131166988));
          } else {
            this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a((List)localObject1, 2130840374, getResources().getColor(2131165327), getResources().getColor(2131166987));
          }
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler;
    long l1 = -1L;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject != null)
    {
      localObject = BaseApplication.getContext().getSharedPreferences(UniteSearchHandler.jdField_a_of_type_JavaLangString, 0).getString(UniteSearchHandler.b, "");
      l2 = l1;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      l2 = Long.parseLong((String)localObject);
    }
    catch (Exception localException1)
    {
      label64:
      int i;
      break label64;
    }
    long l2 = l1;
    if (QLog.isColorLevel())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "reqTimeStr number format error");
      l2 = l1;
    }
    l1 = System.currentTimeMillis();
    i = jdField_a_of_type_Int;
    if ((i == -1) || (l1 - l2 > i * 1000)) {
      bool1 = true;
    }
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "requestData, send netWork request");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a();
    }
    ThreadManager.post(new HotWordsForSubBussFragment.1(this, bool1), 5, null, true);
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler != null)
    {
      localObject = BaseApplication.getContext().getSharedPreferences(UnifySearchHandler.jdField_a_of_type_JavaLangString, 0).getString(UnifySearchHandler.b, "");
      l2 = l1;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      l2 = Long.parseLong((String)localObject);
    }
    catch (Exception localException2)
    {
      label209:
      break label209;
    }
    l2 = l1;
    if (QLog.isColorLevel())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "UnifySearchHandler reqTimeStr number format error");
      l2 = l1;
    }
    l1 = System.currentTimeMillis();
    i = jdField_a_of_type_Int;
    if (i != -1)
    {
      bool1 = bool2;
      if (l1 - l2 <= i * 1000) {}
    }
    else
    {
      bool1 = true;
    }
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "UnifySearchHandler requestData, send netWork request");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler.a();
    }
    ThreadManager.post(new HotWordsForSubBussFragment.2(this, bool1), 5, null, true);
    return;
    QLog.e(jdField_a_of_type_JavaLangString, 2, "requestData HANDLE is null");
  }
  
  protected void a()
  {
    if (this.b == 10)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = ((UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler = ((UnifySearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
  }
  
  protected void b()
  {
    if (this.b == 10)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.jdField_a_of_type_ArrayOfLong = ((Bundle)localObject).getLongArray("group_masks");
      this.b = ((Bundle)localObject).getInt("fromType", -1);
    }
    localObject = getBaseActivity();
    if ((localObject instanceof BaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)localObject).app;
      a();
      c();
      super.onCreate(paramBundle);
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561622, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379729));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer = ((HotWordForSubTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131378745));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchApiOnTipClickListener);
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#44608A"));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839385);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#999999"));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839384);
    }
    a((List)FunctionModuleConfigManager.a.get(FunctionModuleConfigManager.a(this.jdField_a_of_type_ArrayOfLong)));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment
 * JD-Core Version:    0.7.0.1
 */