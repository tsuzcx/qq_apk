package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class GroupNetSearchModelTroopItem
  extends ISearchResultPositionModel
{
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  
  public GroupNetSearchModelTroopItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int a()
  {
    return 4;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
  }
  
  public void a(View paramView)
  {
    Bundle localBundle = TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get()), 2);
    localBundle.putInt("exposureSource", 3);
    ChatSettingForTroop.a((Activity)paramView.getContext(), localBundle, 2);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 80, 0, paramView);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 80, paramView, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return null;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    return "来自:网络查找";
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelTroopItem
 * JD-Core Version:    0.7.0.1
 */