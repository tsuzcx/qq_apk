package com.tencent.mobileqq.search.business.contact.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.base.util.ObjectTransfer;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.business.contact.ApproximateSearchEngine;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.PhoneContactBinedSearchEngine;
import com.tencent.mobileqq.search.business.contact.PhoneContactMultiBindSearchEngine;
import com.tencent.mobileqq.search.business.contact.TroopBatchAddFrdsMultipleSearchEngine;
import com.tencent.mobileqq.search.business.contact.TroopBatchAddFrdsSearchEngine;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ContactSearchFragment
  extends BaseSearchFragment
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private ContactSearchResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = null;
  private String jdField_a_of_type_JavaLangString;
  private List<PhoneContact> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private int jdField_c_of_type_Int = 0;
  private Set<String> jdField_c_of_type_JavaUtilSet = new HashSet();
  private boolean g = false;
  private boolean h = false;
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List<String> paramList, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    return a(paramInt1, paramInt2, paramString, paramList, paramOnActionListener, false, 0, -1L);
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List<String> paramList, ContactSearchResultPresenter.OnActionListener paramOnActionListener, boolean paramBoolean, int paramInt3, long paramLong)
  {
    ContactSearchFragment localContactSearchFragment = new ContactSearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("contactSearchSource", paramInt2);
    localBundle.putString("specifiedTroopUin", paramString);
    localBundle.putBoolean("isApproximate", paramBoolean);
    localBundle.putInt("ContactCombineType", paramInt3);
    if (paramList != null) {
      localBundle.putStringArray("hiddenUinSet", (String[])paramList.toArray(new String[paramList.size()]));
    }
    if (paramOnActionListener != null) {
      localBundle.putLong("contactSearchOnActionListener", ObjectTransfer.a().a(paramOnActionListener));
    }
    if (paramLong > 0L) {
      localBundle.putLong("contactSearchResultFilterType", paramLong);
    }
    localContactSearchFragment.setArguments(localBundle);
    return localContactSearchFragment;
  }
  
  protected int a()
  {
    return 20;
  }
  
  protected BaseMvpAdapter a()
  {
    return new ContactSearchFragment.2(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 524288)
    {
      if (this.jdField_b_of_type_Int == 19) {
        return new PhoneContactMultiBindSearchEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
      }
      return new PhoneContactBinedSearchEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
    }
    if (this.jdField_a_of_type_Boolean) {
      return new ApproximateSearchEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
    }
    if (i == 1048576)
    {
      if (this.jdField_b_of_type_Int == 23) {
        return new TroopBatchAddFrdsSearchEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
      }
      return new TroopBatchAddFrdsMultipleSearchEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
    }
    return new ContactSearchEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
  }
  
  protected String a()
  {
    if (this.jdField_c_of_type_Int == 2) {
      return HardCodeUtil.a(2131702703);
    }
    return HardCodeUtil.a(2131702706);
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (((!SearchUtils.a(this.jdField_b_of_type_Int)) || (this.jdField_b_of_type_Int == -1)) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.g = false;
        if (this.jdField_b_of_type_Int == -1)
        {
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131167333);
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165433);
        return;
      }
      this.g = true;
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838739);
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish with status:", Integer.valueOf(paramInt) });
    }
    Object localObject1 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(2048);
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        Object localObject3;
        if ((QLog.isColorLevel()) && ((localObject2 instanceof IContactSearchModel)))
        {
          localObject3 = (IContactSearchModel)localObject2;
          localStringBuilder.append("model name:");
          localStringBuilder.append(((IContactSearchModel)localObject3).c());
          localStringBuilder.append(" clss:");
          localStringBuilder.append(localObject3.getClass().getSimpleName());
          localStringBuilder.append(" degree:");
          localStringBuilder.append(((IContactSearchModel)localObject3).b());
          localStringBuilder.append(" second:");
          localStringBuilder.append(((IContactSearchModel)localObject3).a());
          localStringBuilder.append("\n");
        }
        if ((localObject2 instanceof ISearchResultModel))
        {
          localObject3 = (ISearchResultModel)localObject2;
          if ((!this.h) || (!((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isQQAppInterface(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) || (!SearchViewUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((ISearchResultModel)localObject3).a())))
          {
            long l = this.jdField_a_of_type_Long;
            if ((l > 0L) && ((l & 1L) != 0L) && ((localObject3 instanceof ContactSearchModelRecentUser)))
            {
              localObject2 = (ContactSearchModelRecentUser)localObject3;
              if ((((ContactSearchModelRecentUser)localObject2).d() == 1000) || (((ContactSearchModelRecentUser)localObject2).d() == 1004) || (((ContactSearchModelRecentUser)localObject2).d() == 1003) || (((ContactSearchModelRecentUser)localObject2).d() == 1006) || (((ContactSearchModelRecentUser)localObject2).d() == 2016))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("onFinish filter a result ,uintype = ");
                ((StringBuilder)localObject3).append(((ContactSearchModelRecentUser)localObject2).d());
                QLog.d("ContactSearchFragment", 2, ((StringBuilder)localObject3).toString());
                continue;
              }
            }
            if ((this.jdField_c_of_type_Int == 2) && (SearchUtils.a((ISearchResultModel)localObject3))) {
              ((List)localObject1).add(localObject3);
            } else if ((this.jdField_c_of_type_Int == 1) && (!SearchUtils.a((ISearchResultModel)localObject3))) {
              ((List)localObject1).add(localObject3);
            } else if (this.jdField_c_of_type_Int == 0) {
              ((List)localObject1).add(localObject3);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, localStringBuilder.toString());
    }
    super.a((List)localObject1, paramInt);
    if ((SearchUtils.a(this.jdField_b_of_type_Int)) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
      localObject1 = ((StringBuilder)localObject1).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      if (paramList == null) {
        paramInt = 0;
      } else {
        paramInt = paramList.size();
      }
      localStringBuilder.append(paramInt);
      SearchUtils.a("contact", "exp_page", new String[] { localObject1, localStringBuilder.toString() });
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.d = false;
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine = a();
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.a();
      this.d = true;
    }
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish with respData:", paramSearchRespData.toString() });
    }
    if (paramSearchRespData.a(this.jdField_c_of_type_JavaLangString))
    {
      a(paramList, paramSearchRespData.jdField_a_of_type_Int);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
    }
  }
  
  public void a(List<String> paramList1, List<String> paramList2)
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
  
  protected boolean a()
  {
    return SearchUtils.a(this.jdField_b_of_type_Int);
  }
  
  protected String b()
  {
    return HardCodeUtil.a(2131701273);
  }
  
  protected void c(List paramList)
  {
    super.c(paramList);
    if ((SearchUtils.a(this.jdField_b_of_type_Int)) && (paramList != null) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramList.size());
      SearchUtils.a("contact", "exp_page", new String[] { localObject, localStringBuilder.toString() });
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void e(List<PhoneContact> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_a_of_type_Int = localBundle.getInt("contactSearchSource", 197437);
      this.jdField_b_of_type_Int = localBundle.getInt("fromType", -1);
      this.jdField_a_of_type_Long = localBundle.getLong("contactSearchResultFilterType", -1L);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onCreate searchSource = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(",fromType = ");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject1).append(",filterType = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
        QLog.d("ContactSearchFragment", 2, ((StringBuilder)localObject1).toString());
      }
      int i = 0;
      this.jdField_a_of_type_Boolean = localBundle.getBoolean("isApproximate", false);
      this.jdField_c_of_type_Int = localBundle.getInt("ContactCombineType", 0);
      this.jdField_a_of_type_JavaLangString = localBundle.getString("specifiedTroopUin");
      Object localObject1 = localBundle.getStringArray("hiddenUinSet");
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          this.jdField_a_of_type_JavaUtilSet.add(localObject2);
          i += 1;
        }
      }
      long l = localBundle.getLong("contactSearchOnActionListener", -1L);
      if (l != -1L) {
        this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = ((ContactSearchResultPresenter.OnActionListener)ObjectTransfer.a().a(l));
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!SearchUtils.a(this.jdField_b_of_type_Int))
    {
      if (this.jdField_b_of_type_Int == -1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131167333);
      } else {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165433);
      }
      this.g = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new ContactSearchFragment.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */