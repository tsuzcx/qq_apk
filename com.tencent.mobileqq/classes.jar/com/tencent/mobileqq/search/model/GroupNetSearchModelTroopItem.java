package com.tencent.mobileqq.search.model;

import addcontacts.AccountSearchPb.record;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;

public class GroupNetSearchModelTroopItem
  extends ISearchResultPositionModel
{
  private AccountSearchPb.record jdField_a_of_type_AddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  
  public GroupNetSearchModelTroopItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int a()
  {
    return 4;
  }
  
  public CharSequence a()
  {
    return HardCodeUtil.a(2131705441);
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$record.code.get());
  }
  
  public void a(View paramView)
  {
    Bundle localBundle = TroopInfoUIUtil.a(String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$record.code.get()), 2);
    localBundle.putInt("exposureSource", 3);
    TroopUtils.a((Activity)paramView.getContext(), localBundle, 2);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 80, 0, paramView);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 80, paramView, false);
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
    return null;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelTroopItem
 * JD-Core Version:    0.7.0.1
 */