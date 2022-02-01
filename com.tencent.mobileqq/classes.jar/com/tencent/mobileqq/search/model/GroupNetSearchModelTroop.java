package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;

public class GroupNetSearchModelTroop
  extends ISearchResultGroupModel
{
  private List<ISearchResultModel> a;
  private String b;
  private boolean c;
  
  public GroupNetSearchModelTroop(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString, boolean paramBoolean)
  {
    this.a = paramList;
    this.b = paramString;
    this.c = paramBoolean;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131903331);
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.b, 80, 0, paramView);
    new Intent().putExtra("last_key_words", this.b);
    long l1 = Double.valueOf(NetSearchEngine.a * 1000000.0D).longValue();
    long l2 = Double.valueOf(NetSearchEngine.b * 1000000.0D).longValue();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://qqweb.qq.com/m/relativegroup/index.html?source=qun_recent_search&keyword=");
    ((StringBuilder)localObject1).append(URLEncoder.encode(this.b));
    ((StringBuilder)localObject1).append("&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=");
    ((StringBuilder)localObject1).append(Long.valueOf(l2));
    ((StringBuilder)localObject1).append("&lat=");
    ((StringBuilder)localObject1).append(Long.valueOf(l1));
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (this.c)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&show_tab=hot");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("lastKeywords = ");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" jump url is : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("search", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("uin", ((BaseActivity)paramView.getContext()).app.getCurrentAccountUin());
    ((Intent)localObject2).putExtra("portraitOnly", true);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("isShowAd", false);
    paramView.getContext().startActivity((Intent)localObject2);
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
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelTroop
 * JD-Core Version:    0.7.0.1
 */