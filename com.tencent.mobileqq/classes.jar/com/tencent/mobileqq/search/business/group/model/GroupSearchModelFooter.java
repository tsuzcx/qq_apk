package com.tencent.mobileqq.search.business.group.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchModelFooter
  extends SearchResultGroupModelImpl
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  public String c = "xiaoweiba";
  
  public GroupSearchModelFooter(String paramString1, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(View paramView)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      Object localObject1 = JumpParser.a((BaseQQAppInterface)localAppInterface, paramView.getContext(), this.b);
      if (localObject1 != null)
      {
        ((JumpAction)localObject1).a();
      }
      else if ((this.b.startsWith("http://")) || (this.b.startsWith("https://")))
      {
        paramView = paramView.getContext();
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("url", this.b);
        ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(paramView, (Map)localObject1);
      }
      paramView = new JSONObject();
      try
      {
        paramView.put("project", UniteSearchReportController.a());
        paramView.put("event_src", "client");
        paramView.put("get_src", "web");
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, localStringBuilder.toString());
      }
      Object localObject2 = new ReportModelDC02528().module("all_result").action("clk_tail");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("");
      paramView = ((ReportModelDC02528)localObject2).obj1(localStringBuilder.toString()).ver1(((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getCurrKeyword()).ver2(UniteSearchReportController.a(((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getFromForHistoryCode())).ver7(paramView.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append(SearchUtils.d);
      UniteSearchReportController.a(null, paramView.session_id(((StringBuilder)localObject2).toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelFooter
 * JD-Core Version:    0.7.0.1
 */