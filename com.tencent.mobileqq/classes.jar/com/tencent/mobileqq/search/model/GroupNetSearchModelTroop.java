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
  implements ISearchResultGroupModel
{
  private String jdField_a_of_type_JavaLangString;
  private List<ISearchResultModel> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public GroupNetSearchModelTroop(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131705443);
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 80, 0, paramView);
    new Intent().putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    long l1 = Double.valueOf(NetSearchEngine.a * 1000000.0D).longValue();
    long l2 = Double.valueOf(NetSearchEngine.b * 1000000.0D).longValue();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://qqweb.qq.com/m/relativegroup/index.html?source=qun_recent_search&keyword=");
    ((StringBuilder)localObject1).append(URLEncoder.encode(this.jdField_a_of_type_JavaLangString));
    ((StringBuilder)localObject1).append("&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=");
    ((StringBuilder)localObject1).append(Long.valueOf(l2));
    ((StringBuilder)localObject1).append("&lat=");
    ((StringBuilder)localObject1).append(Long.valueOf(l1));
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (this.jdField_a_of_type_Boolean)
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
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
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
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelTroop
 * JD-Core Version:    0.7.0.1
 */