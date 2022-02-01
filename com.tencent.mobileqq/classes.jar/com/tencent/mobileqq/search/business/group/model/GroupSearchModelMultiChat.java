package com.tencent.mobileqq.search.business.group.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

public class GroupSearchModelMultiChat
  extends ISearchResultGroupModel
{
  private final List<ISearchResultModel> a;
  private final String b;
  private int c;
  
  public GroupSearchModelMultiChat(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.a = paramList;
    this.b = paramString;
    this.c = paramInt;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131903372);
  }
  
  public void a(View paramView) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelMultiChat
 * JD-Core Version:    0.7.0.1
 */