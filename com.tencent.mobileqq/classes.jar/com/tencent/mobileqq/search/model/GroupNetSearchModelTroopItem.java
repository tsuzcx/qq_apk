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
  private AccountSearchPb.record a;
  private String b;
  private CharSequence c;
  
  public GroupNetSearchModelTroopItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.a = paramrecord;
    this.b = paramString;
    this.c = paramCharSequence;
  }
  
  public CharSequence a()
  {
    return HardCodeUtil.a(2131903329);
  }
  
  public void a(View paramView)
  {
    Bundle localBundle = TroopInfoUIUtil.a(String.valueOf(this.a.code.get()), 2);
    localBundle.putInt("exposureSource", 3);
    TroopUtils.a((Activity)paramView.getContext(), localBundle, 2);
    SearchUtils.a(this.b, 80, 0, paramView);
    SearchUtils.a(this.b, 80, paramView, false);
  }
  
  public int b()
  {
    return 4;
  }
  
  public String c()
  {
    return String.valueOf(this.a.code.get());
  }
  
  public CharSequence d()
  {
    return this.c;
  }
  
  public CharSequence e()
  {
    return null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelTroopItem
 * JD-Core Version:    0.7.0.1
 */