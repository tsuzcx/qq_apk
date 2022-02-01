package com.tencent.mobileqq.search.business.group.model;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;
import mqq.app.MobileQQ;

public class GroupSearchModelPublicAcnt
  implements ISearchResultGroupModel
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private final List<ISearchResultModel> jdField_a_of_type_JavaUtilList;
  private final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705458);
  }
  
  public GroupSearchModelPublicAcnt(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return SearchEntryConfigManager.a("pref_fts_native_search_public_account_max_num", 3);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int == 12)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131705483));
      localStringBuilder.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), MobileQQ.sMobileQQ));
      return localStringBuilder.toString();
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.b, 50, 0, paramView);
    Object localObject = paramView.getContext();
    if ((localObject != null) && ((localObject instanceof QBaseActivity))) {
      ReportController.b((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1C", "0X8005D1C", 0, 1, 0, "0", "", this.b, "");
    }
    if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.b);
      SearchUtils.a("all_result", "clk_public_uin_more", new String[] { ((StringBuilder)localObject).toString() });
      UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D53", 0, 0, null, null);
    }
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToPublicAcntSearchActivity(paramView.getContext(), this.b, this.jdField_a_of_type_Int);
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelPublicAcnt
 * JD-Core Version:    0.7.0.1
 */