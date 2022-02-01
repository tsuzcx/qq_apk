package com.tencent.mobileqq.troop.associations;

import NearbyGroup.GroupInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopAssociationsUtil
{
  public static void a(Context paramContext, AssociatedTroopItem paramAssociatedTroopItem)
  {
    if (paramContext != null)
    {
      if (paramAssociatedTroopItem == null) {
        return;
      }
      paramAssociatedTroopItem = String.format("mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=%s&subsource_id=12001", new Object[] { paramAssociatedTroopItem.uin });
      Intent localIntent = new Intent(paramContext, JoinGroupTransitActivity.class);
      localIntent.putExtra("source_scheme", paramAssociatedTroopItem);
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = "https://qun.qq.com/v2/associate/index?gc=$GC&_wv=16777216&cwv=1&_wwv=128".replace("$GC", paramString);
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(localIntent, 4);
      }
    }
  }
  
  public static void b(Context paramContext, AssociatedTroopItem paramAssociatedTroopItem)
  {
    GroupInfo localGroupInfo;
    boolean bool;
    if (paramContext != null)
    {
      if (paramAssociatedTroopItem == null) {
        return;
      }
      localGroupInfo = new GroupInfo();
      bool = true;
    }
    try
    {
      localGroupInfo.lCode = Long.valueOf(paramAssociatedTroopItem.uin).longValue();
      localGroupInfo.strName = paramAssociatedTroopItem.name;
      localGroupInfo.strIntro = paramAssociatedTroopItem.intro;
      localGroupInfo.iMemberCnt = paramAssociatedTroopItem.memberNum;
      if (paramAssociatedTroopItem.labelList != null) {
        localGroupInfo.labels = paramAssociatedTroopItem.labelList;
      }
      localGroupInfo.strJoinSig = paramAssociatedTroopItem.joinAuth;
      if (paramAssociatedTroopItem.privilege == 3) {
        bool = false;
      }
      TroopUtils.a(paramContext, TroopUtils.a(116, localGroupInfo, 12001, bool), 2);
      return;
    }
    catch (Exception paramContext)
    {
      label109:
      break label109;
    }
    QLog.d("TroopAssociationsUtil", 1, "cast string2long error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.associations.TroopAssociationsUtil
 * JD-Core Version:    0.7.0.1
 */