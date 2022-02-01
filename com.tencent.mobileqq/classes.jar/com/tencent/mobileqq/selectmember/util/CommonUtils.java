package com.tencent.mobileqq.selectmember.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qidian.api.IQidianManagerApi;
import java.util.ArrayList;

public class CommonUtils
{
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static String a(Context paramContext, DiscussionInfo paramDiscussionInfo)
  {
    if (paramDiscussionInfo != null) {
      paramDiscussionInfo = paramDiscussionInfo.discussionName;
    } else {
      paramDiscussionInfo = "";
    }
    Object localObject;
    if (paramDiscussionInfo != null)
    {
      localObject = paramDiscussionInfo;
      if (paramDiscussionInfo.length() != 0) {}
    }
    else
    {
      localObject = paramContext.getResources().getString(2131888722);
    }
    return localObject;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)paramAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2);
  }
  
  public static String a(DiscussionMemberInfo paramDiscussionMemberInfo, AppInterface paramAppInterface)
  {
    paramAppInterface = SearchUtils.d(paramAppInterface, paramDiscussionMemberInfo.memberUin);
    if ((paramAppInterface != null) && (paramAppInterface.isFriend())) {
      localObject = paramAppInterface.getFriendNick();
    } else {
      localObject = paramDiscussionMemberInfo.inteRemark;
    }
    paramAppInterface = (AppInterface)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramAppInterface = paramDiscussionMemberInfo.memberName;
    }
    Object localObject = paramAppInterface;
    if (TextUtils.isEmpty(paramAppInterface)) {
      localObject = paramDiscussionMemberInfo.memberUin;
    }
    return localObject;
  }
  
  public static String a(Friends paramFriends)
  {
    return paramFriends.getFriendNickWithAlias();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.trim().substring(0, 1).toUpperCase();
  }
  
  public static ArrayList<Entity> a(AppInterface paramAppInterface)
  {
    return ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getUiTroopListWithoutBlockedTroop();
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    return ((IQidianManagerApi)paramAppInterface.getRuntimeService(IQidianManagerApi.class, "")).isQidianMaster(paramString);
  }
  
  public static Friends b(AppInterface paramAppInterface, String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    return ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
  }
  
  public static boolean c(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopRobotService)paramAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString);
  }
  
  public static TroopInfo d(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
  }
  
  public static TroopInfo e(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.util.CommonUtils
 * JD-Core Version:    0.7.0.1
 */