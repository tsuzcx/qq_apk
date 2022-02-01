package com.tencent.mobileqq.search.business.contact.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;

public class TroopBatchAddFrdsSearchModelMember
  extends ContactSearchModelTroopMember
{
  TroopMemberInfo a;
  String b;
  
  public TroopBatchAddFrdsSearchModelMember(AppInterface paramAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo, String paramString)
  {
    super(paramAppInterface, paramInt, paramTroopMemberInfo);
    this.a = paramTroopMemberInfo;
    this.b = paramString;
  }
  
  public CharSequence a()
  {
    if (SearchUtils.b(this.m, this.a.memberuin)) {
      return HardCodeUtil.a(2131912524);
    }
    if (SearchUtils.a(this.m, this.a.memberuin, false)) {
      return HardCodeUtil.a(2131912525);
    }
    return null;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((paramView.getId() == 2131444718) && (this.n == 23))
    {
      ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).addFriend(localContext, this.a, this.b, false);
      return;
    }
    if (this.n == 23)
    {
      Intent localIntent = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(localContext, null);
      localIntent.putExtra("troopUin", this.a.troopuin);
      localIntent.putExtra("memberUin", this.a.memberuin);
      localIntent.putExtra("fromFlag", 1);
      localIntent.putExtra("selfSet_leftViewText", paramView.getContext().getString(2131917557));
      localIntent.putExtra("custom_leftbackbutton_name", paramView.getContext().getString(2131887625));
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).joinFriendProfileIntentWithTroopMemberCardIntent(localContext, this.m, localIntent, 9);
    }
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String m()
  {
    return SearchUtils.a(this.m, this.a.troopuin, this.a.memberuin);
  }
  
  public String n()
  {
    if (this.a.commonFrdCnt <= 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.commonFrdCnt);
    localStringBuilder.append(HardCodeUtil.a(2131912526));
    return localStringBuilder.toString();
  }
  
  public int s()
  {
    if (this.a.commonFrdCnt < 0) {
      return 0;
    }
    return this.a.commonFrdCnt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.TroopBatchAddFrdsSearchModelMember
 * JD-Core Version:    0.7.0.1
 */