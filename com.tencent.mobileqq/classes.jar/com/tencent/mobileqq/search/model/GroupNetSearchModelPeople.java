package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupNetSearchModelPeople
  extends ISearchResultGroupModel
{
  private List<ISearchResultModel> a;
  private String b;
  private SearchResult c;
  
  public GroupNetSearchModelPeople(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString)
  {
    this.a = paramList;
    this.b = paramString;
    this.c = paramSearchResult;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131903330);
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.b, 70, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("last_key_words", this.b);
    localIntent.putExtra("from_key", 0);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.c);
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
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelPeople
 * JD-Core Version:    0.7.0.1
 */