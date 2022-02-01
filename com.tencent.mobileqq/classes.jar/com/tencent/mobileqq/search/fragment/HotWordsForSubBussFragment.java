package com.tencent.mobileqq.search.fragment;

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
import aogg;
import aogh;
import aogi;
import aogk;
import bbyl;
import bcci;
import bccj;
import bcck;
import bcdl;
import bcdm;
import bcdn;
import bcnc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.view.HotWordForSubTipsContainer;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbk;

public class HotWordsForSubBussFragment
  extends ReportV4Fragment
{
  public static int a;
  public static final String a;
  protected View a;
  protected TextView a;
  protected aogg a;
  protected aogh a;
  protected aogi a;
  protected aogk a;
  protected QQAppInterface a;
  protected HotWordForSubTipsContainer a;
  tbk jdField_a_of_type_Tbk = new bcck(this);
  private boolean jdField_a_of_type_Boolean;
  public long[] a;
  private int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "unify_search" + HotWordsForSubBussFragment.class.getSimpleName();
    jdField_a_of_type_Int = -1;
  }
  
  public HotWordsForSubBussFragment()
  {
    this.jdField_a_of_type_Aogh = new bcci(this);
    this.jdField_a_of_type_Aogk = new bccj(this);
  }
  
  private void a(List<bcdn> paramList)
  {
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      return;
    }
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "update BusiHotWords results is null");
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a(paramList, 2130840395, getResources().getColor(2131166965), getResources().getColor(2131166964));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a(paramList, 2130840392, getResources().getColor(2131165357), getResources().getColor(2131166963));
  }
  
  private void b(List<BusinessGroupWord> paramList)
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
          Object localObject2 = bcnc.a(((BusinessGroupWord)localObject1).groupID.a);
          if ((localObject2 != null) && (Arrays.equals((long[])localObject2, this.jdField_a_of_type_ArrayOfLong)))
          {
            localObject2 = ((BusinessGroupWord)localObject1).clueWordItem;
            FragmentActivity localFragmentActivity = getActivity();
            if ((localFragmentActivity instanceof ActiveEntitySearchActivity)) {
              ((ActiveEntitySearchActivity)localFragmentActivity).d(((bcdl)localObject2).b);
            }
            localObject1 = ((BusinessGroupWord)localObject1).hotWordItemList;
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              if (this.jdField_a_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a((List)localObject1, 2130840395, getResources().getColor(2131166965), getResources().getColor(2131166964));
              } else {
                this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.a((List)localObject1, 2130840392, getResources().getColor(2131165357), getResources().getColor(2131166963));
              }
            }
          }
        }
      }
    }
  }
  
  private void c()
  {
    boolean bool = false;
    long l2;
    long l1;
    if (this.jdField_a_of_type_Aogi != null)
    {
      String str1 = BaseApplication.getContext().getSharedPreferences(aogi.jdField_a_of_type_JavaLangString, 0).getString(aogi.b, "");
      l2 = -1L;
      l1 = l2;
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        l1 = Long.parseLong(str1);
        l2 = System.currentTimeMillis();
        if ((jdField_a_of_type_Int == -1) || (l2 - l1 > jdField_a_of_type_Int * 1000)) {
          bool = true;
        }
        if (bool)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "requestData, send netWork request");
          }
          this.jdField_a_of_type_Aogi.a();
        }
        ThreadManager.post(new HotWordsForSubBussFragment.1(this, bool), 5, null, true);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "reqTimeStr number format error");
            l1 = l2;
          }
        }
      }
    }
    if (this.jdField_a_of_type_Aogg != null)
    {
      String str2 = BaseApplication.getContext().getSharedPreferences(aogg.jdField_a_of_type_JavaLangString, 0).getString(aogg.b, "");
      l2 = -1L;
      l1 = l2;
      if (!TextUtils.isEmpty(str2)) {}
      try
      {
        l1 = Long.parseLong(str2);
        l2 = System.currentTimeMillis();
        if ((jdField_a_of_type_Int == -1) || (l2 - l1 > jdField_a_of_type_Int * 1000))
        {
          bool = true;
          if (bool)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "UnifySearchHandler requestData, send netWork request");
            }
            this.jdField_a_of_type_Aogg.a();
          }
          ThreadManager.post(new HotWordsForSubBussFragment.2(this, bool), 5, null, true);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "UnifySearchHandler reqTimeStr number format error");
            l1 = l2;
            continue;
            bool = false;
          }
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "requestData HANDLE is null");
  }
  
  protected void a()
  {
    if (this.b == 10)
    {
      this.jdField_a_of_type_Aogi = ((aogi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      this.jdField_a_of_type_Aogg = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogk);
      return;
    }
    this.jdField_a_of_type_Aogg = ((aogg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    this.jdField_a_of_type_Aogi = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogh);
  }
  
  protected void b()
  {
    if (this.b == 10)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogk);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogh);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.jdField_a_of_type_ArrayOfLong = ((Bundle)localObject).getLongArray("group_masks");
      this.b = ((Bundle)localObject).getInt("fromType", -1);
    }
    localObject = getActivity();
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561627, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379984));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer = ((HotWordForSubTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131378963));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_Tbk);
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#44608A"));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839450);
    }
    for (;;)
    {
      a((List)bbyl.a.get(bbyl.a(this.jdField_a_of_type_ArrayOfLong)));
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#999999"));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839449);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment
 * JD-Core Version:    0.7.0.1
 */