package com.tencent.mobileqq.search.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchConfig
{
  public static int contactSearchFieldBaseBit = 24;
  public static int contactSearchIndexBaseBit = 40;
  public static int contactSearchPinyinBaseBit = 58;
  public static int contactSearchRecentBaseBit = 48;
  public static int contactSearchTypeBaseBit = 32;
  public static int engineOrderFavorite = 3;
  public static int engineOrderFeature = 6;
  public static int engineOrderFile = 2;
  public static int engineOrderFunction = 0;
  public static int engineOrderMessage = 5;
  public static int engineOrderNetSearch = 1;
  public static int engineOrderPeople = 7;
  public static int engineOrderPublicAccount = 4;
  public static long fieldAlias = 3L;
  public static long fieldDiscussionMemberRemark = 7L;
  public static long fieldInteRemark = 6L;
  public static long fieldMobileNo = 1L;
  public static long fieldNewTroopCard = 8L;
  public static long fieldNewTroopNickName = 8L;
  public static long fieldNickName = 5L;
  public static long fieldPhoneContactName = 4L;
  public static long fieldPublicAccountDisplayName = 9L;
  public static long fieldPublicAccountMark = 11L;
  public static long fieldPublicAccountName = 12L;
  public static long fieldPublicAccountSummary = 10L;
  public static long fieldRemark = 8L;
  public static long fieldTroopCard = 6L;
  public static long fieldTroopName = 8L;
  public static long fieldUin = 2L;
  public static long filedDiscussionName = 8L;
  public static long indexEqual = 3L;
  public static long indexMiddle = 1L;
  public static long indexStart = 2L;
  public static volatile boolean isConfigLoaded = false;
  public static boolean isUseOptimize = true;
  public static int mStructMsgPicSwitch = 0;
  public static boolean needSeparate = false;
  public static long recentTrue = 1L;
  public static int sReduceDiscussionWeight = 0;
  public static Map<String, Integer> searchEngineOrder = new HashMap();
  public static long stringOrigin = 2L;
  public static long stringPinyin = 1L;
  public static int troopDurationUnderNotWifi = 72;
  public static int troopDurationUnderWifi = 24;
  public static int troopMemberLimit = 70;
  public static String troopMemberUpdateConfigStr = "0|100|1|3,101|500|7|15";
  public static ArrayList<SearchConfig.TroopMemberSetting> troopMemberUpdateConfigs = a("0|100|1|3,101|500|7|15");
  public static long typeCircleContact = 1L;
  public static long typeDiscussion = 7L;
  public static long typeDiscussionConversation = 15L;
  public static long typeDiscussionConversationMatchMember = 8L;
  public static long typeDiscussionConversationMatchTitle = 15L;
  public static long typeDiscussionMatchMemberFull = 9L;
  public static long typeDiscussionMember = 11L;
  public static long typeFriend = 13L;
  public static long typeFriendConversation = 15L;
  public static long typeFriendNotOftenContact = 12L;
  public static long typeFriendSpecialCare = 14L;
  public static long typeGameMsgBox = 0L;
  public static long typeGlobalTroop = 7L;
  public static long typeGlobalTroopConversation = 8L;
  public static long typeGlobalTroopMember = 9L;
  public static long typeNewTroop = 8L;
  public static long typeNewTroopMember = 12L;
  public static long typePhoneContact = 10L;
  public static long typePublicAccount = 3L;
  public static long typePublicAccountConversation = 4L;
  public static long typeQidianMaster = 6L;
  public static long typeTool = 4L;
  public static long typeTroop = 7L;
  public static long typeTroopConversation = 15L;
  public static long typeTroopMember = 6L;
  public static long typeUnbindPhoneContact = 2L;
  public static int voiceSearchSwitch = 0;
  
  static
  {
    sReduceDiscussionWeight = 1;
    needSeparate = false;
  }
  
  protected static ArrayList<SearchConfig.TroopMemberSetting> a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseTroopMemberUpdateSetting, config: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SearchConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    localObject = new ArrayList();
    try
    {
      String[] arrayOfString1 = paramString.split(",");
      if ((arrayOfString1 != null) && (arrayOfString1.length > 0))
      {
        int j = arrayOfString1.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].trim().split("\\|");
          if ((arrayOfString2 != null) && (arrayOfString2.length == 4))
          {
            SearchConfig.TroopMemberSetting localTroopMemberSetting = new SearchConfig.TroopMemberSetting();
            localTroopMemberSetting.a = Integer.valueOf(arrayOfString2[0]).intValue();
            localTroopMemberSetting.b = Integer.valueOf(arrayOfString2[1]).intValue();
            localTroopMemberSetting.c = (Integer.valueOf(arrayOfString2[2]).intValue() * 24);
            localTroopMemberSetting.d = (Integer.valueOf(arrayOfString2[3]).intValue() * 24);
            ((ArrayList)localObject).add(localTroopMemberSetting);
          }
          i += 1;
        }
      }
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "parseTroopMemberUpdateSetting error");
      }
      if (!paramString.equals("0|100|1|3,101|500|7|15")) {
        return a("0|100|1|3,101|500|7|15");
      }
    }
  }
  
  protected static void a()
  {
    engineOrderPeople = 6;
    engineOrderMessage = 5;
    engineOrderPublicAccount = 4;
    engineOrderFavorite = 3;
    engineOrderFile = 2;
    engineOrderNetSearch = 1;
    contactSearchPinyinBaseBit = 58;
    contactSearchRecentBaseBit = 48;
    contactSearchIndexBaseBit = 40;
    contactSearchTypeBaseBit = 32;
    contactSearchFieldBaseBit = 24;
    stringOrigin = 2L;
    stringPinyin = 1L;
    recentTrue = 1L;
    indexEqual = 3L;
    indexStart = 2L;
    indexMiddle = 1L;
    fieldPublicAccountName = 12L;
    fieldPublicAccountMark = 11L;
    fieldPublicAccountSummary = 10L;
    fieldPublicAccountDisplayName = 9L;
    filedDiscussionName = 8L;
    fieldTroopName = 8L;
    fieldRemark = 8L;
    fieldNewTroopNickName = 8L;
    fieldNewTroopCard = 8L;
    fieldDiscussionMemberRemark = 7L;
    fieldInteRemark = 6L;
    fieldNickName = 5L;
    fieldPhoneContactName = 4L;
    fieldAlias = 3L;
    fieldUin = 2L;
    fieldMobileNo = 1L;
    fieldTroopCard = 6L;
    typeFriendConversation = 15L;
    typeTroopConversation = 15L;
    typeDiscussionConversationMatchTitle = 15L;
    typeDiscussionConversation = 15L;
    typeFriendSpecialCare = 14L;
    typeFriend = 13L;
    typeFriendNotOftenContact = 12L;
    typeNewTroopMember = 12L;
    typeDiscussionMember = 11L;
    typePhoneContact = 10L;
    typeDiscussionMatchMemberFull = 9L;
    typeDiscussionConversationMatchMember = 8L;
    typeNewTroop = 8L;
    typeDiscussion = 7L;
    typeTroop = 7L;
    typeTroopMember = 6L;
    typeTool = 4L;
    typePublicAccountConversation = 4L;
    typePublicAccount = 3L;
    typeUnbindPhoneContact = 2L;
    typeCircleContact = 1L;
    typeGlobalTroopMember = 9L;
    typeGlobalTroop = 7L;
    typeGlobalTroopConversation = 8L;
    troopMemberLimit = 70;
    troopDurationUnderWifi = 24;
    troopDurationUnderNotWifi = 72;
    sReduceDiscussionWeight = 1;
    troopMemberUpdateConfigStr = "0|100|1|3,101|500|7|15";
    troopMemberUpdateConfigs = a("0|100|1|3,101|500|7|15");
    searchEngineOrder = new HashMap();
    voiceSearchSwitch = 0;
    needSeparate = false;
    isUseOptimize = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.config.SearchConfig
 * JD-Core Version:    0.7.0.1
 */