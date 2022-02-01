package com.tencent.mobileqq.kandian.biz.ugc.selectmember.search;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;

public class FollowingSearchResultModel
  implements ISearchResultModel
{
  private FollowingMember jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowingMember;
  private String jdField_a_of_type_JavaLangString;
  
  public FollowingSearchResultModel(FollowingMember paramFollowingMember)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowingMember = paramFollowingMember;
  }
  
  public int a()
  {
    return 0;
  }
  
  public FollowingMember a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowingMember;
  }
  
  public CharSequence a()
  {
    return HardCodeUtil.a(2131704771);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowingMember.a().toString();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(View paramView) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowingMember.a().contains(paramString);
  }
  
  public int b()
  {
    return 0;
  }
  
  public CharSequence b()
  {
    return SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowFollowingMember.a(), this.jdField_a_of_type_JavaLangString, 6, true);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    return "";
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public int f_()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.FollowingSearchResultModel
 * JD-Core Version:    0.7.0.1
 */