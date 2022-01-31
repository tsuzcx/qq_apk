package com.tencent.mobileqq.search.fragment;

import ahew;
import ahex;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.PhoneContactBinedSearchEngine;
import com.tencent.mobileqq.search.searchengine.PhoneContactMultiBindSearchEngine;
import com.tencent.mobileqq.search.searchengine.TroopBatchAddFrdsMultipleSearchEngine;
import com.tencent.mobileqq.search.searchengine.TroopBatchAddFrdsSearchEngine;
import com.tencent.mobileqq.search.util.ObjectTransfer;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ContactSearchFragment
  extends BaseSearchFragment
{
  private ContactSearchResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet;
  private int jdField_b_of_type_Int;
  private Set jdField_b_of_type_JavaUtilSet = new HashSet();
  private int jdField_c_of_type_Int;
  private Set jdField_c_of_type_JavaUtilSet = new HashSet();
  private boolean e;
  private boolean f;
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List paramList, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    return a(paramInt1, paramInt2, paramString, paramList, paramOnActionListener, false);
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List paramList, ContactSearchResultPresenter.OnActionListener paramOnActionListener, boolean paramBoolean)
  {
    ContactSearchFragment localContactSearchFragment = new ContactSearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("contactSearchSource", paramInt2);
    localBundle.putString("specifiedTroopUin", paramString);
    localBundle.putBoolean("isApproximate", paramBoolean);
    if (paramList != null) {
      localBundle.putStringArray("hiddenUinSet", (String[])paramList.toArray(new String[paramList.size()]));
    }
    if (paramOnActionListener != null) {
      localBundle.putLong("contactSearchOnActionListener", ObjectTransfer.a().a(paramOnActionListener));
    }
    localContactSearchFragment.setArguments(localBundle);
    return localContactSearchFragment;
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, null, null, null, paramBoolean);
  }
  
  protected int a()
  {
    return 20;
  }
  
  protected BaseMvpAdapter a()
  {
    return new ahex(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    if (this.jdField_b_of_type_Int == 524288)
    {
      if (this.jdField_c_of_type_Int == 19) {
        return new PhoneContactMultiBindSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
      }
      return new PhoneContactBinedSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
    }
    if (this.e) {
      return new ApproximateSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
    }
    if (this.jdField_b_of_type_Int == 1048576)
    {
      if (this.jdField_c_of_type_Int == 23) {
        return new TroopBatchAddFrdsSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
      }
      return new TroopBatchAddFrdsMultipleSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
    }
    return new ContactSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
  }
  
  protected String a()
  {
    return "联系人";
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (((!SearchUtils.a(this.jdField_c_of_type_Int)) || (this.jdField_c_of_type_Int == -1)) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label71;
      }
      this.f = false;
      if (this.jdField_c_of_type_Int == -1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131492923);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131493240);
    return;
    label71:
    this.f = true;
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838210);
  }
  
  public void a(List paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    String str;
    StringBuilder localStringBuilder;
    if ((SearchUtils.a(this.jdField_c_of_type_Int)) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      str = "" + this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("");
      if (paramList != null) {
        break label138;
      }
    }
    label138:
    for (paramInt = 0;; paramInt = paramList.size())
    {
      SearchUtils.a("contact", "exp_page", new String[] { str, paramInt });
      if (this.e)
      {
        this.e = false;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine = a();
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a();
        this.jdField_c_of_type_Boolean = true;
      }
      return;
    }
  }
  
  public void a(List paramList1, List paramList2)
  {
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_c_of_type_JavaUtilSet.clear();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        this.jdField_b_of_type_JavaUtilSet.add(str);
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        this.jdField_c_of_type_JavaUtilSet.add(paramList2);
      }
    }
  }
  
  protected boolean b()
  {
    return SearchUtils.a(this.jdField_c_of_type_Int);
  }
  
  protected void c(List paramList)
  {
    super.c(paramList);
    if ((SearchUtils.a(this.jdField_c_of_type_Int)) && (paramList != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      SearchUtils.a("contact", "exp_page", new String[] { "" + this.jdField_b_of_type_JavaLangString, "" + paramList.size() });
    }
  }
  
  public void e(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_b_of_type_Int = localBundle.getInt("contactSearchSource", 197437);
      this.jdField_c_of_type_Int = localBundle.getInt("fromType", -1);
      this.e = localBundle.getBoolean("isApproximate", false);
      this.jdField_a_of_type_JavaLangString = localBundle.getString("specifiedTroopUin");
      String[] arrayOfString = localBundle.getStringArray("hiddenUinSet");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.jdField_a_of_type_JavaUtilSet.add(str);
          i += 1;
        }
      }
      long l = localBundle.getLong("contactSearchOnActionListener", -1L);
      if (l != -1L) {
        this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener = ((ContactSearchResultPresenter.OnActionListener)ObjectTransfer.a().a(l));
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!SearchUtils.a(this.jdField_c_of_type_Int))
    {
      if (this.jdField_c_of_type_Int != -1) {
        break label54;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131492923);
    }
    for (;;)
    {
      this.f = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new ahew(this));
      return;
      label54:
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131493240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */