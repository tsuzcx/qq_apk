package com.tencent.mobileqq.search.business.group.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

public class GroupSearchModelMostUsed
  extends ISearchResultGroupModel
{
  public static final String a = HardCodeUtil.a(2131903370);
  private final List<ISearchResultModel> b;
  private final String c;
  
  public GroupSearchModelMostUsed(List<ISearchResultModel> paramList, String paramString)
  {
    this.b = paramList;
    this.c = paramString;
  }
  
  public String a()
  {
    return a;
  }
  
  public void a(View paramView) {}
  
  public List<ISearchResultModel> b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelMostUsed
 * JD-Core Version:    0.7.0.1
 */