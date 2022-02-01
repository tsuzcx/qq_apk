package com.tencent.mobileqq.search.business.group.model;

import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class GroupSearchModelLocalGuild
  extends ISearchResultGroupModel
{
  private List<ISearchResultModel> a;
  private String b;
  private int c;
  
  public String a()
  {
    return BaseApplication.getContext().getResources().getString(2131897857);
  }
  
  public void a(View paramView)
  {
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToContactSearchActivity(paramView.getContext(), this.b, this.c, 3);
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
    return SearchEntryConfigManager.a("fts_native_contactor_maxnum", 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalGuild
 * JD-Core Version:    0.7.0.1
 */