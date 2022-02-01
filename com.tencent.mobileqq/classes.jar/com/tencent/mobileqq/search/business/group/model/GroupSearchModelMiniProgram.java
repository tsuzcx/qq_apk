package com.tencent.mobileqq.search.business.group.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelMiniProgram
  extends ISearchResultGroupModel
{
  public List<ISearchResultModel> a;
  protected int b;
  private String c;
  
  public GroupSearchModelMiniProgram(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.a = paramList;
    this.c = paramString;
    this.b = paramInt;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131903373);
  }
  
  public void a(View paramView)
  {
    ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onReportClick898(null, 0, this.b, "0X8009D47", 0, 0, null, null);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pages/search-results/search-results?mode=search&q=");
    ((StringBuilder)localObject).append(this.c);
    localObject = SearchUtils.h(((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://m.q.qq.com/a/p/1108291530?via=2005_2&referer=2005&s=");
    localStringBuilder.append((String)localObject);
    localObject = SearchUtils.h(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://microapp/open?url=");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramView.getContext(), (String)localObject, 2005, null);
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
    return 3;
  }
  
  public int e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelMiniProgram
 * JD-Core Version:    0.7.0.1
 */