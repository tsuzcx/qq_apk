package com.tencent.mobileqq.search.business.group.model;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

public class GroupSearchModelFunction
  extends ISearchResultGroupModel
{
  public final List<ISearchResultModel> a;
  private final String b;
  private int c;
  
  public GroupSearchModelFunction(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.a = paramList;
    this.b = paramString;
    this.c = paramInt;
  }
  
  public String a()
  {
    return SearchEntryConfigManager.b();
  }
  
  public void a(View paramView)
  {
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToFunctionSearchActivity(paramView.getContext(), this.b);
    ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onReportClick898(null, 0, this.c, "0X8009D4B", 0, 0, null, null);
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
    return SearchEntryConfigManager.a("fts_native_function_maxnum", 3);
  }
  
  public int e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelFunction
 * JD-Core Version:    0.7.0.1
 */