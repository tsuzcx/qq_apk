package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelMiniProgram
  implements ISearchResultGroupModel
{
  protected int a;
  private String a;
  public List<ISearchResultModel> a;
  
  public GroupSearchModelMiniProgram(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 3;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131705412);
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D47", 0, 0, null, null);
    String str = SearchUtils.b("pages/search-results/search-results?mode=search&q=" + this.jdField_a_of_type_JavaLangString);
    str = SearchUtils.b("https://m.q.qq.com/a/p/1108291530?via=2005_2&referer=2005&s=" + str);
    str = "mqqapi://microapp/open?url=" + str;
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramView.getContext(), str, 2005, null);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelMiniProgram
 * JD-Core Version:    0.7.0.1
 */