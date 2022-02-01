package com.tencent.mobileqq.search.business.contact.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelLocalContactApproximate
  extends ISearchResultGroupModel
{
  public List<ISearchResultModel> a;
  private String b;
  private int c;
  
  public GroupSearchModelLocalContactApproximate(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.a = paramList;
    this.b = paramString;
    this.c = paramInt;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131903361);
  }
  
  public void a(View paramView)
  {
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToContactSearchActivity(paramView.getContext(), this.b, this.c, true);
    SearchUtils.a(this.b, 20, 0, paramView);
  }
  
  public List<ISearchResultModel> b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int d()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.GroupSearchModelLocalContactApproximate
 * JD-Core Version:    0.7.0.1
 */