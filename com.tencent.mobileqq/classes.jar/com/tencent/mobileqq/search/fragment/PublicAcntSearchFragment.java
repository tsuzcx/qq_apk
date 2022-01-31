package com.tencent.mobileqq.search.fragment;

import alud;
import alzl;
import amfe;
import amfg;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ayjn;
import ayju;
import ayky;
import aynb;
import ayns;
import aynu;
import ayoy;
import ayug;
import ayuv;
import ayvm;
import ayvp;
import bhtv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import swy;

public class PublicAcntSearchFragment
  extends BaseSearchFragment
  implements bhtv
{
  private static int b;
  protected int a;
  private long a;
  protected amfg a;
  public String a;
  public boolean a;
  public byte[] a;
  public boolean f;
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  public PublicAcntSearchFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Amfg = new ayky(this);
  }
  
  public static PublicAcntSearchFragment a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
    return new PublicAcntSearchFragment();
  }
  
  protected int a()
  {
    return 50;
  }
  
  protected ayjn a()
  {
    return new ayju(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bdbb, this, 0);
  }
  
  protected ayug a()
  {
    return new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_b_of_type_Int);
  }
  
  protected String a()
  {
    if (jdField_b_of_type_Int == 12) {
      return swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    }
    return alud.a(2131709184);
  }
  
  public void a(List paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    String str;
    if ((ayvm.a(jdField_b_of_type_Int)) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      str = "" + this.jdField_c_of_type_JavaLangString;
      if (paramList != null) {
        break label143;
      }
    }
    label143:
    for (paramList = "0";; paramList = "" + paramList.size())
    {
      ayvm.a("all_result", "exp_public_uin_page", new String[] { str, paramList });
      if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) {
        break label197;
      }
      paramInt = 0;
      while (paramInt < this.jdField_c_of_type_JavaUtilList.size())
      {
        ayvp.a((aynu)this.jdField_c_of_type_JavaUtilList.get(paramInt), this.jdField_c_of_type_JavaUtilList.size(), paramInt);
        paramInt += 1;
      }
    }
    this.jdField_c_of_type_JavaUtilList.add(0, new aynb(alud.a(2131709134), "", ""));
    label197:
    this.jdField_a_of_type_ArrayOfByte = null;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PublicAcntSearchFragment", 2, "onFinish, search net result ,keyword = " + this.jdField_c_of_type_JavaLangString);
      }
      e(this.jdField_c_of_type_JavaUtilList);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("PublicAcntSearchFragment", 2, "keyword is empty ");
  }
  
  public void a(List paramList, ayuv paramayuv)
  {
    if (paramayuv.a(this.jdField_c_of_type_JavaLangString)) {
      a(paramList, paramayuv.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PublicAcntSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramayuv.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected void d(List paramList)
  {
    super.d(paramList);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    g_(false);
    h_(false);
  }
  
  protected void e(List paramList)
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "sendNetPublicAcntRequest ,keyword=" + this.jdField_c_of_type_JavaLangString);
    }
    ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.1(this));
    Object localObject1 = ((alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a();
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAcntSearchFragment", 2, "all publicAccountInfoList is null or empty");
      }
    }
    for (;;)
    {
      paramList = (amfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isLoadMore", true);
      ((Bundle)localObject1).putInt("fromType", jdField_b_of_type_Int);
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(Long.valueOf(1003L));
      paramList.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 20, (List)localObject2, localArrayList, this.jdField_a_of_type_ArrayOfByte, 0.0D, 0.0D, (Bundle)localObject1);
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i = 0;
        while (i < paramList.size())
        {
          localObject2 = (ayns)paramList.get(i);
          if ((localObject2 instanceof ayoy))
          {
            localObject2 = (ayoy)localObject2;
            int j = 0;
            while (j < ((List)localObject1).size())
            {
              PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((List)localObject1).get(j);
              if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(((ayoy)localObject2).a.uin))) {
                localArrayList.add(Long.valueOf(localPublicAccountInfo.uin));
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amfg);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = (System.currentTimeMillis() + "");
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Ayug instanceof PublicAccountSearchEngine)) {
      ((PublicAccountSearchEngine)this.jdField_a_of_type_Ayug).e();
    }
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amfg);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Ayug.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Ayug.d();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Ayjn == null) || (this.jdField_a_of_type_Ayjn.getCount() == 0) || (this.jdField_a_of_type_Int == 0)) {}
    while ((paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_a_of_type_Boolean) || (this.f)) {
      return;
    }
    e(this.jdField_c_of_type_JavaUtilList);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment
 * JD-Core Version:    0.7.0.1
 */