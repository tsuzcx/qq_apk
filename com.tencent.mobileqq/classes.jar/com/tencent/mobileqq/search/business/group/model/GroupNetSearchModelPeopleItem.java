package com.tencent.mobileqq.search.business.group.model;

import addcontacts.AccountSearchPb.record;
import android.app.Activity;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.util.SearchUtils;
import mqq.app.MobileQQ;

public class GroupNetSearchModelPeopleItem
  extends ISearchResultPositionModel
{
  private AccountSearchPb.record jdField_a_of_type_AddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  
  public GroupNetSearchModelPeopleItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get() != 0L) {
      return 1;
    }
    return 11;
  }
  
  public CharSequence a()
  {
    return HardCodeUtil.a(2131705446);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get() != 0L) {
      return String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get());
    }
    return this.jdField_a_of_type_AddcontactsAccountSearchPb$record.mobile.get();
  }
  
  public void a(View paramView)
  {
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToProfileCardActivity((Activity)paramView.getContext(), new SearchResultItem(this.jdField_a_of_type_AddcontactsAccountSearchPb$record), (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), true, 1);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 70, 0, paramView);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 70, paramView, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    if (this.b == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      String str;
      if (this.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get() != 0L) {
        str = String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get());
      } else {
        str = this.jdField_a_of_type_AddcontactsAccountSearchPb$record.mobile.get();
      }
      localStringBuilder.append(str);
      localStringBuilder.append(")");
      this.b = SearchUtils.a(localStringBuilder.toString(), this.jdField_a_of_type_JavaLangString);
    }
    return this.b;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupNetSearchModelPeopleItem
 * JD-Core Version:    0.7.0.1
 */