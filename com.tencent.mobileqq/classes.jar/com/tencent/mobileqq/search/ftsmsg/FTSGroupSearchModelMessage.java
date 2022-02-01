package com.tencent.mobileqq.search.ftsmsg;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.business.group.model.FTSGroupSearchModelEntity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.List;

public class FTSGroupSearchModelMessage
  extends FTSGroupSearchModelEntity
{
  private int c;
  
  public FTSGroupSearchModelMessage(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.c = paramInt;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131902940);
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.b, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.b);
      SearchUtils.a("all_result", "more_talk", new String[] { localStringBuilder.toString() });
      UniteSearchReportController.a(null, 0, this.c, "0X8009D4F", 0, 0, null, null);
    }
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.d = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 0;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.g = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.j = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.k = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.l = -1;
    SQLiteFTSUtils.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.b, 1);
  }
  
  public int d()
  {
    return SearchEntryConfigManager.a("fts_native_chathistory_maxnum", 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage
 * JD-Core Version:    0.7.0.1
 */