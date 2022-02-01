package com.tencent.mobileqq.search.business.group.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelMessage
  extends ISearchResultGroupModel
{
  public static final String a = HardCodeUtil.a(2131903375);
  private List<ISearchResultModel> b;
  private String c;
  
  public GroupSearchModelMessage(List<ISearchResultModel> paramList, String paramString)
  {
    this.b = paramList;
    this.c = paramString;
  }
  
  public String a()
  {
    return a;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.c, 40, 0, paramView);
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToMessageSearchActivity(paramView.getContext(), this.c);
  }
  
  public List<ISearchResultModel> b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelMessage
 * JD-Core Version:    0.7.0.1
 */