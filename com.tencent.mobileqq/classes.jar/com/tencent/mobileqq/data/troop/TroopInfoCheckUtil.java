package com.tencent.mobileqq.data.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopInfoCheckUtil
{
  protected static int a = 5000;
  
  public static void a() {}
  
  private static void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new TroopInfoCheckUtil.2(paramString));
  }
  
  private static void d()
  {
    Object localObject = new HashSet(Arrays.asList(new String[] { "Administrator", "adminNameShow", "allowMemberAtAll", "allowMemberKick", "allowMemberModifTroopName", "appealDeadline", "associatePubAccount", "cAlbumResult", "cGroupLevel", "cGroupOption", "cGroupRankSysFlag", "cGroupRankUserFlag", "cNewGroupRankUserFlag", "cmdUinFlagEx2", "cmduinFlagEx3Grocery", "dailyNewMemberUins", "dwAdditionalFlag", "dwAppPrivilegeFlag", "dwAuthGroupType", "dwCmdUinJoinTime", "dwCmdUinUinFlag", "dwGagTimeStamp", "dwGagTimeStamp_me", "dwGroupClassExt", "dwGroupFlag", "dwGroupFlagExt", "dwGroupFlagExt3", "dwGroupInfoSeq", "dwGroupLevelSeq", "dwLastBAFTipMsgUniSeq", "dwLastBAFTipMsgUniSeq2", "dwLastInsertBAFTipTime", "dwOfficeMode", "dwTimeStamp", "eliminated", "exitTroopReason", "feeds_id", "fingertroopmemo", "gameSwitchStatus", "grade", "groupCardPrefixIntro", "groupCardPrefixJson", "groupFlagExt4", "groupFreezeReason", "hasSetNewTroopHead", "hasSetNewTroopName", "hlGuildAppid", "hlGuildBinary", "hlGuildOrgid", "hlGuildSubType", "isAllowHistoryMsgFlag", "isNewTroop", "isShowInNearbyTroops", "isTroopBlocked", "joinTroopAnswer", "joinTroopQuestion", "lastMsgTime", "lastShareLbsMsgUniseq", "location", "mAtOrReplyMeUins", "mCanSearchByKeywords", "mCanSearchByTroopUin", "mComparePartInt", "mCompareSpell", "mGroupClassExtText", "mHeaderUinsNew", "mHeaderUinsOld", "mIsFreezed", "mMemberCardSeq", "mMemberInvitingFlag", "mMemberNumSeq", "mOldMemberCardSeq", "mOldMemberNumSeq", "mQZonePhotoNum", "mRichFingerMemo", "mSomeMemberUins", "mTags", "mTribeStatus", "mTroopAvatarId", "mTroopFileVideoIsWhite", "mTroopFileVideoReqInterval", "mTroopNeedPayNumber", "mTroopPicListJson", "maxAdminNum", "maxInviteMemNum", "memberListToShow", "myHonorList", "myHonorRichFlag", "lastMsgUpdateMyHonorRichTime", "nMsgLimitFreq", "nTroopGrade", "newTroopLevelMap", "newTroopName", "newTroopNameTimeStamp", "oldTroopName", "ownerNameShow", "school", "showGameSwitchStatus", "strLastAnnouncement", "strLocation", "strQZonePhotoUrls", "timeSec", "topicId", "troopAuthenticateInfo", "troopCreateTime", "troopCreditLevel", "troopCreditLevelInfo", "troopHonorGrayFlag", "troopInfoExtByte", "troopLat", "troopLevelMap", "troopLon", "troopPrivilegeFlag", "troopRepeatType", "troopTypeExt", "troopcode", "troopface", "troopmask", "troopmemo", "troopname", "troopowneruin", "trooptype", "troopuin", "udwCmdUinRingtoneID", "uin", "wClickBAFTipCount", "wInsertBAFTipCount", "wMemberMax", "wMemberNum", "wMemberNumClient", "wSpecialClass", "troopRemark" }));
    List localList = TableBuilder.getValidField(TroopInfo.class);
    for (;;)
    {
      try
      {
        int j = localList.size();
        i = 0;
        if (i >= j) {
          continue;
        }
        Field localField = (Field)localList.get(i);
        if (((HashSet)localObject).contains(localField.getName())) {
          continue;
        }
        localObject = localField.getName();
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        String str = "";
        continue;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a("TroopInfo新加字段" + (String)localObject + ",是否需要修改TroopHandler.getTroopList中loadall。");
      }
      return;
      i += 1;
    }
  }
  
  private static void e()
  {
    int i = 0;
    HashSet localHashSet = new HashSet(Arrays.asList(new String[] { "groupInfoExtSeq", "luckyWordId", "lightCharNum", "luckyWord", "starId", "essenceSwitch" }));
    String str2 = "";
    try
    {
      Field[] arrayOfField = TroopInfoExt.class.getDeclaredFields();
      int j = arrayOfField.length;
      Object localObject = str2;
      if (i < j)
      {
        localObject = arrayOfField[i];
        int k = ((Field)localObject).getModifiers();
        if (((!Modifier.isStatic(k)) || (!Modifier.isFinal(k))) && (!((Field)localObject).isSynthetic()) && (!localHashSet.contains(((Field)localObject).getName()))) {
          localObject = ((Field)localObject).getName();
        }
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          a("TroopInfoExt新加字段" + (String)localObject + ",是否需要修改TroopHandler.getTroopList中loadall。");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str1 = str2;
        continue;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopInfoCheckUtil
 * JD-Core Version:    0.7.0.1
 */