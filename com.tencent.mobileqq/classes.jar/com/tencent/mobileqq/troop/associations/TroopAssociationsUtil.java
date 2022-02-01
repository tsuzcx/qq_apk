package com.tencent.mobileqq.troop.associations;

import NearbyGroup.GroupInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopAssociationsUtil
{
  public static void a(Context paramContext, AssociatedTroopItem paramAssociatedTroopItem)
  {
    if ((paramContext == null) || (paramAssociatedTroopItem == null)) {
      return;
    }
    paramAssociatedTroopItem = String.format("mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=%s&subsource_id=12001", new Object[] { paramAssociatedTroopItem.uin });
    Intent localIntent = new Intent(paramContext, JoinGroupTransitActivity.class);
    localIntent.putExtra("source_scheme", paramAssociatedTroopItem);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    Intent localIntent;
    do
    {
      return;
      paramString = "https://qun.qq.com/v2/associate/index?gc=$GC&_wv=16777216&cwv=1&_wwv=128".replace("$GC", paramString);
      localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).startActivityForResult(localIntent, 4);
  }
  
  public static void b(Context paramContext, AssociatedTroopItem paramAssociatedTroopItem)
  {
    boolean bool = true;
    if ((paramContext == null) || (paramAssociatedTroopItem == null)) {
      return;
    }
    GroupInfo localGroupInfo = new GroupInfo();
    for (;;)
    {
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
        if (paramAssociatedTroopItem.privilege != 3)
        {
          TroopUtils.a(paramContext, TroopUtils.a(116, localGroupInfo, 12001, bool), 2);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("TroopAssociationsUtil", 1, "cast string2long error");
        return;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.associations.TroopAssociationsUtil
 * JD-Core Version:    0.7.0.1
 */