package com.tencent.mobileqq.search.business.contact.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ContactSearchModelTroopMember
  extends IContactSearchModel
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public ContactSearchModelTroopMember(AppInterface paramAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo)
  {
    super(paramAppInterface, paramInt, 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = paramTroopMemberInfo;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark;
          this.c = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin });
          return;
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick;
        this.c = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin });
        return;
      }
      this.jdField_b_of_type_JavaLangString = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark });
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick;
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick;
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
      return;
    }
    this.jdField_b_of_type_JavaLangString = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick });
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick, IContactSearchable.g);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 2;
    }
    l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark, IContactSearchable.k);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 3;
    }
    l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, IContactSearchable.l);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
    }
    l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin, IContactSearchable.o, false);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 0;
    }
    l = this.jdField_a_of_type_Long;
    if (l != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long = (l + IContactSearchable.z);
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public CharSequence a()
  {
    if (SearchUtils.a(this.jdField_b_of_type_Int)) {
      return HardCodeUtil.a(2131702711);
    }
    return HardCodeUtil.a(2131702702);
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin, 1000, c(), false, null, null);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i)))
        {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
          return;
        }
        UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      }
    }
    else
    {
      SearchUtils.a(paramView, this);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int d()
  {
    return 1000;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public int e()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroopMember
 * JD-Core Version:    0.7.0.1
 */