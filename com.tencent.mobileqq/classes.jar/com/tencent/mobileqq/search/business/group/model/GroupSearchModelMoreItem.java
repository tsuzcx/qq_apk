package com.tencent.mobileqq.search.business.group.model;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class GroupSearchModelMoreItem
  implements ISearchResultGroupModel
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public GroupSearchModelMoreItem(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 0;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131705469);
  }
  
  public List<ISearchResultModel> a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToSearchBaseActivity((Activity)paramView.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 0, 0, paramView);
    ReportController.b(null, "CliOper", "", "", "0X80061B7", "0X80061B7", 0, 0, "", "", "", "");
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelMoreItem
 * JD-Core Version:    0.7.0.1
 */