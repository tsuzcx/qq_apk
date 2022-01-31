package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportTask;

public class ContactSearchModelTroop
  extends IContactSearchModel
{
  public int a;
  private long jdField_a_of_type_Long;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long = IContactSearchable.M;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public ContactSearchModelTroop(QQAppInterface paramQQAppInterface, int paramInt, TroopInfo paramTroopInfo, long paramLong)
  {
    super(paramQQAppInterface, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    if (paramQQAppInterface.a().a().a(paramTroopInfo.troopuin)) {
      this.jdField_b_of_type_Long = IContactSearchable.C;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop())
    {
      this.jdField_b_of_type_JavaLangString = "";
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop())
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopName()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNumClient > 0))
      {
        this.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNumClient);
        return;
      }
      this.jdField_b_of_type_JavaLangString = "";
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
  }
  
  public int a()
  {
    return 4;
  }
  
  protected long a(String paramString)
  {
    this.c = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName(), IContactSearchable.f);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopName())) {}
    }
    do
    {
      return -9223372036854775808L;
      l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, IContactSearchable.o, false);
      if (l <= this.jdField_a_of_type_Long) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop()) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()));
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Int = 2;
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public TroopInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      RecentUtil.a = true;
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName(), false);
      SearchUtils.a(this.c, 20, 2, paramView);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, 1);
      SearchUtils.a(this.c, 30, paramView, false);
      SearchUtils.a(this, paramView);
    }
    for (;;)
    {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin }).a();
      return;
      SearchUtils.a(paramView, this);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public CharSequence c()
  {
    if (SearchUtils.a(this.jdField_b_of_type_Int)) {
      return "来自:群聊";
    }
    if (this.jdField_b_of_type_Int == 8) {
      return "";
    }
    return "群聊";
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ContactSearchModelTroop
 * JD-Core Version:    0.7.0.1
 */