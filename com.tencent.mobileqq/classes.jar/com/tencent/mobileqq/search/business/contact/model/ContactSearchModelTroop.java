package com.tencent.mobileqq.search.business.contact.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.ReportTask;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ContactSearchModelTroop
  extends IContactSearchModel
{
  public int a;
  private long jdField_a_of_type_Long;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long = IContactSearchable.M;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public ContactSearchModelTroop(AppInterface paramAppInterface, int paramInt, TroopInfo paramTroopInfo, long paramLong)
  {
    super(paramAppInterface, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    if (((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(paramTroopInfo.troopuin))
    {
      this.jdField_b_of_type_Long = IContactSearchable.C;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmask == 2) && (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUinInAssist(paramTroopInfo.troopuin))) {
      this.jdField_b_of_type_Long = IContactSearchable.C;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getNewTroopNameOrTroopName();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isQidianPrivateTroop())
    {
      this.jdField_b_of_type_JavaLangString = "";
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNumClient);
      localStringBuilder.append(HardCodeUtil.a(2131702697));
      this.jdField_b_of_type_JavaLangString = String.valueOf(localStringBuilder.toString());
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
  }
  
  public int a()
  {
    return 4;
  }
  
  protected long a(String paramString)
  {
    this.c = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark))
    {
      l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark, IContactSearchable.f);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 3;
      }
    }
    long l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getNewTroopNameOrTroopName(), IContactSearchable.f);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopName())) {
        return -9223372036854775808L;
      }
    }
    l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, IContactSearchable.o, false);
    if (l > this.jdField_a_of_type_Long)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isQidianPrivateTroop()) {
        return -9223372036854775808L;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) {
        return -9223372036854775808L;
      }
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 2;
    }
    l = this.jdField_a_of_type_Long;
    if (l != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long = (l + this.jdField_b_of_type_Long);
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public TroopInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  }
  
  public CharSequence a()
  {
    if ((this.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark)) && (this.jdField_b_of_type_Int != -1) && (this.jdField_b_of_type_Int != 7)) {
      return f();
    }
    if (SearchUtils.a(this.jdField_b_of_type_Int)) {
      return "";
    }
    if (this.jdField_b_of_type_Int == 8) {
      return "";
    }
    return HardCodeUtil.a(2131702739);
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName(), false);
      SearchUtils.a(this.c, 20, 2, paramView);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.c);
      SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode, 1);
      SearchUtils.a(this.c, 30, paramView, false);
      SearchUtils.a(this, paramView);
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.c, this.i, (String)a(), e());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 2, 0, null, null);
        } else {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D3B", 0, 0, null, null);
        }
      }
    }
    else
    {
      SearchUtils.a(paramView, this);
    }
    new ReportTask(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin }).a();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int d()
  {
    return 1;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int e()
  {
    return 2;
  }
  
  public CharSequence f()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(HardCodeUtil.a(2131702718));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark)) {
      localSpannableStringBuilder.append(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark, this.c, 6, false));
    }
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop
 * JD-Core Version:    0.7.0.1
 */