package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigManager;
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
  
  public ContactSearchModelTroopMember(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = paramTroopMemberInfo;
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick;
      this.c = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin });
      return;
    case 3: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark;
      this.c = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin });
      return;
    case 1: 
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
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += IContactSearchable.z;
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      RecentUtil.a = true;
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin, 1000, c(), false, null, null);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
        }
      }
      else {
        return;
      }
      UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      return;
    }
    SearchUtils.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    if (SearchUtils.a(this.jdField_b_of_type_Int)) {
      return HardCodeUtil.a(2131702579);
    }
    return HardCodeUtil.a(2131702570);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ContactSearchModelTroopMember
 * JD-Core Version:    0.7.0.1
 */