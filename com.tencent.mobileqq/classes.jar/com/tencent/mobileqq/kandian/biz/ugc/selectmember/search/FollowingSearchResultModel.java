package com.tencent.mobileqq.kandian.biz.ugc.selectmember.search;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;

public class FollowingSearchResultModel
  extends ISearchResultModel
{
  private FollowingMember a;
  private String b;
  
  public FollowingSearchResultModel(FollowingMember paramFollowingMember)
  {
    this.a = paramFollowingMember;
  }
  
  public CharSequence a()
  {
    return HardCodeUtil.a(2131902673);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(View paramView) {}
  
  public boolean a(String paramString)
  {
    this.b = paramString;
    return this.a.b().contains(paramString);
  }
  
  public int b()
  {
    return 0;
  }
  
  public String c()
  {
    return this.a.a().toString();
  }
  
  public int ck_()
  {
    return 0;
  }
  
  public int cl_()
  {
    return 0;
  }
  
  public CharSequence d()
  {
    return SearchUtils.b(this.a.b(), this.b, 6, true);
  }
  
  public CharSequence e()
  {
    return "";
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public FollowingMember i()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.FollowingSearchResultModel
 * JD-Core Version:    0.7.0.1
 */