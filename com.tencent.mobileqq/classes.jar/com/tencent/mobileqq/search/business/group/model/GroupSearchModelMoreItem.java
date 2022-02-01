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
  extends ISearchResultGroupModel
{
  private String a;
  private int b;
  
  public GroupSearchModelMoreItem(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131903357);
  }
  
  public void a(View paramView)
  {
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToSearchBaseActivity((Activity)paramView.getContext(), this.a, this.b);
    SearchUtils.a(this.a, 0, 0, paramView);
    ReportController.b(null, "CliOper", "", "", "0X80061B7", "0X80061B7", 0, 0, "", "", "", "");
  }
  
  public List<ISearchResultModel> b()
  {
    return null;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelMoreItem
 * JD-Core Version:    0.7.0.1
 */