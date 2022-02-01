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
  private int a;
  
  public FTSGroupSearchModelMessage(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return SearchEntryConfigManager.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131705050);
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      SearchUtils.a("all_result", "more_talk", new String[] { localStringBuilder.toString() });
      UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.d = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 0;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.g = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.h = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.i = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.j = -1;
    SQLiteFTSUtils.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage
 * JD-Core Version:    0.7.0.1
 */