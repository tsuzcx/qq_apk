package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import avhn;
import avhw;
import avib;
import avic;
import avis;
import avje;
import avpu;
import avwc;
import avwf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vms;

public class SearchEntryFragment
  extends Fragment
  implements avib
{
  public static Map<Integer, Boolean> a;
  public int a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public QQAppInterface a;
  public String a;
  private List<avhn> jdField_a_of_type_JavaUtilList = new ArrayList();
  public int b;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
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
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      avhn localavhn = (avhn)localIterator.next();
      if ((localavhn instanceof avic)) {
        ((avic)localavhn).d();
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
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avhn)localIterator.next()).c();
    }
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
  
  public void a(Editable paramEditable)
  {
    b();
  }
  
  public void a(List<avpu> paramList, boolean paramBoolean)
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
    boolean bool2 = avwf.b(this.jdField_a_of_type_Int);
    if (bool2) {}
    for (boolean bool1 = avwc.a(this.jdField_a_of_type_Int);; bool1 = false)
    {
      Object localObject;
      if (paramList != null)
      {
        boolean bool3 = avis.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(this.jdField_a_of_type_JavaLangString), paramBoolean);
        if (bool3)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          localObject = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((avhn)((Iterator)localObject).next()).b();
          }
          this.jdField_a_of_type_JavaUtilList.clear();
          if ((!"kSearchMessageTab".equals(this.jdField_a_of_type_JavaLangString)) && (!"kSearchContactTab".equals(this.jdField_a_of_type_JavaLangString)))
          {
            i = j;
            if (!"kSearchDynamicTab".equals(this.jdField_a_of_type_JavaLangString)) {}
          }
          else
          {
            this.jdField_a_of_type_JavaUtilList.add(new avhw(a(this.jdField_a_of_type_JavaLangString), this));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((avhn)this.jdField_a_of_type_JavaUtilList.get(0)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
            ((avhn)this.jdField_a_of_type_JavaUtilList.get(0)).a();
            i = j;
          }
          if (i < paramList.size())
          {
            if ((((avpu)paramList.get(i)).jdField_a_of_type_Int == 1) && (bool2) && (!bool1)) {
              if (QLog.isColorLevel()) {
                QLog.d("SearchEntryFragment", 2, "refreshDataModels net, ignore hotWord: " + this.jdField_a_of_type_Int);
              }
            }
            for (;;)
            {
              i += 1;
              break;
              localObject = avhn.a(((avpu)paramList.get(i)).jdField_a_of_type_Int, a(this.jdField_a_of_type_JavaLangString), paramBoolean);
              if (localObject != null)
              {
                this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((avhn)localObject).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
                this.jdField_a_of_type_JavaUtilList.add(localObject);
                ((avhn)localObject).a((avpu)paramList.get(i));
              }
            }
          }
          if ("kSearchReadInJoyTab".equals(this.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_JavaUtilList.add(new avje(a(this.jdField_a_of_type_JavaLangString)));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((avhn)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
            ((avhn)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).a();
          }
          paramList = new View(getActivity());
          paramList.setLayoutParams(new LinearLayout.LayoutParams(-1, vms.a(getActivity(), 80.0F)));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("SearchEntryFragment", 2, "refreshDataModels,  mModelList.size = " + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_JavaUtilList.size() + ", needRefreshModelList = " + bool3);
          return;
          paramList = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramList.hasNext()) {
            ((avhn)paramList.next()).a();
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramList.hasNext()) {
        ((avhn)paramList.next()).b();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (("kSearchMessageTab".equals(this.jdField_a_of_type_JavaLangString)) || ("kSearchContactTab".equals(this.jdField_a_of_type_JavaLangString)) || ("kSearchDynamicTab".equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilList.add(new avhw(a(this.jdField_a_of_type_JavaLangString), this));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((avhn)this.jdField_a_of_type_JavaUtilList.get(0)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
        ((avhn)this.jdField_a_of_type_JavaUtilList.get(0)).a();
      }
      paramList = avis.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(this.jdField_a_of_type_JavaLangString), paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("SearchEntryFragment", 2, "refreshDataModels modelIdList = " + paramList);
      }
      if ((paramList != null) && (paramList.length > 0)) {
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
            localObject = avhn.a(paramList[i], a(this.jdField_a_of_type_JavaLangString), paramBoolean);
            if (localObject != null)
            {
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((avhn)localObject).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
              this.jdField_a_of_type_JavaUtilList.add(localObject);
              ((avhn)localObject).a();
            }
          }
        }
      }
      if ("kSearchReadInJoyTab".equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilList.add(new avje(a(this.jdField_a_of_type_JavaLangString)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((avhn)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, null));
        ((avhn)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).a();
      }
      paramList = new View(getActivity());
      paramList.setLayoutParams(new LinearLayout.LayoutParams(-1, vms.a(getActivity(), 80.0F)));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
      return;
    }
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
    a(null, UniteSearchActivity.a(this.jdField_a_of_type_Int, this.b));
    paramLayoutInflater = new ScrollView(getActivity());
    paramLayoutInflater.setOverScrollMode(0);
    paramLayoutInflater.setVerticalScrollBarEnabled(false);
    paramLayoutInflater.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
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
      ((avhn)localIterator.next()).b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    b();
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
        if ((this.jdField_a_of_type_JavaUtilList.get(i) instanceof avje)) {
          a();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SearchEntryFragment
 * JD-Core Version:    0.7.0.1
 */