package com.tencent.mobileqq.search.fragment;

import ahtg;
import ahti;
import ahtj;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.OnTipClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.BusinessGroupWord.ClueWordItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord.GroupID;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.HotWordForSubTipsContainer;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HotWordsForSubBussFragment
  extends Fragment
{
  public static int a;
  public static final String a;
  protected View a;
  protected TextView a;
  ReadInJoySearchTipsContainer.OnTipClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener = new ahtj(this);
  protected QQAppInterface a;
  public UniteSearchHandler a;
  protected UniteSearchObserver a;
  protected HotWordForSubTipsContainer a;
  private boolean jdField_a_of_type_Boolean;
  public long[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.uniteSearch." + HotWordsForSubBussFragment.class.getSimpleName();
    jdField_a_of_type_Int = -1;
  }
  
  public HotWordsForSubBussFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ahti(this);
  }
  
  private void a()
  {
    String str = BaseApplication.getContext().getSharedPreferences(UniteSearchHandler.jdField_a_of_type_JavaLangString, 0).getString(UniteSearchHandler.b, "");
    long l2 = -1L;
    long l1 = l2;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      l1 = Long.parseLong(str);
      l2 = System.currentTimeMillis();
      if ((jdField_a_of_type_Int == -1) || (l2 - l1 > jdField_a_of_type_Int * 1000))
      {
        bool = true;
        if (bool)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "requestData, send netWork request");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.b();
        }
        ThreadManager.post(new ahtg(this, bool), 5, null, true);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "reqTimeStr number format error");
          l1 = l2;
          continue;
          bool = false;
        }
      }
    }
  }
  
  private void a(List paramList)
  {
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      return;
    }
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateBusiHotWords results is null");
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a(paramList, 2130839166, getResources().getColor(2131492954), getResources().getColor(2131492953));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a(paramList, 2130839163, getResources().getColor(2131492971), getResources().getColor(2131492952));
  }
  
  private void b(List paramList)
  {
    if (this.jdField_a_of_type_ArrayOfLong == null) {}
    for (;;)
    {
      return;
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateBusiHotWords results is null");
        }
      }
      else
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (BusinessGroupWord)paramList.next();
          Object localObject2 = SearchUtils.a(((BusinessGroupWord)localObject1).groupID.a);
          if ((localObject2 != null) && (Arrays.equals((long[])localObject2, this.jdField_a_of_type_ArrayOfLong)))
          {
            localObject2 = ((BusinessGroupWord)localObject1).clueWordItem;
            FragmentActivity localFragmentActivity = getActivity();
            if ((localFragmentActivity instanceof ActiveEntitySearchActivity)) {
              ((ActiveEntitySearchActivity)localFragmentActivity).b(((BusinessGroupWord.ClueWordItem)localObject2).b);
            }
            localObject1 = ((BusinessGroupWord)localObject1).hotWordItemList;
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              if (this.jdField_a_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a((List)localObject1, 2130839166, getResources().getColor(2131492954), getResources().getColor(2131492953));
              } else {
                this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a((List)localObject1, 2130839163, getResources().getColor(2131492971), getResources().getColor(2131492952));
              }
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ArrayOfLong = getArguments().getLongArray("group_masks");
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof BaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)localFragmentActivity).app;
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = ((UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111));
      a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      super.onCreate(paramBundle);
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130970682, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371635));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer = ((HotWordForSubTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131362728));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener);
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#44608A"));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838580);
    }
    for (;;)
    {
      a((List)FunctionModuleConfigManager.a.get(FunctionModuleConfigManager.a(this.jdField_a_of_type_ArrayOfLong)));
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#999999"));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838579);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment
 * JD-Core Version:    0.7.0.1
 */