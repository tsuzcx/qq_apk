package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelLocalTroop
  extends ISearchResultGroupModel
{
  public static final String b = HardCodeUtil.a(2131903367);
  public List<ISearchResultModel> a;
  private String c;
  private int d;
  
  public GroupSearchModelLocalTroop(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.a = paramList;
    this.c = paramString;
    this.d = paramInt;
  }
  
  public String a()
  {
    return b;
  }
  
  public void a(View paramView)
  {
    ContactSearchActivity.a(paramView.getContext(), this.c, this.d, 33751869, 2);
    SearchUtils.a(this.c, 20, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      paramView = new StringBuilder();
      paramView.append("");
      paramView.append(this.c);
      SearchUtils.a("all_result", "more_contact", new String[] { paramView.toString() });
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "group", "more", 0, 0, new String[] { SearchUtils.a(this.d) });
      }
      UniteSearchReportController.a(null, 0, this.d, "0X8009D3D", 0, 0, null, null);
    }
  }
  
  public List<ISearchResultModel> b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return SearchEntryConfigManager.a("fts_native_contactor_maxnum", 3);
  }
  
  public int f()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop
 * JD-Core Version:    0.7.0.1
 */