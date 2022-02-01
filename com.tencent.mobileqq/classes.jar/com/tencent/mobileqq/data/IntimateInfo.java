package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.intimate.info.EmptyStatusInfo;
import com.tencent.mobileqq.activity.aio.intimate.info.LoveAchievementInfo;
import com.tencent.mobileqq.activity.aio.intimate.info.LoveTreeInfo;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DateTips;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.EmptyStatusInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.FriendInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveAchievementInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveTreeInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualScoreCard;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.OneGroupInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.PrefetchMutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.RspBody;
import tencent.im.oidb.recheck_flag_info.recheck_flag_info.RecheckFlagInfo;

public class IntimateInfo
  extends Entity
{
  public static final String TAG = "IntimateInfo";
  public int addFriendSource = -1;
  public int addFriendSubSource = -1;
  public String addFriendWording;
  public int beFriendDays = -2;
  @notColumn
  public List<oidb_0xcf4.CommonBody> commonBodies;
  @notColumn
  public List<IntimateInfo.CommonBody> commonBodyList;
  public String commonBodyListStr;
  @notColumn
  public List<IntimateInfo.CommonTroopInfo> commonTroopInfoList;
  public String commonTroopInfoListJsonStr;
  public String commonTroopTips;
  public int currentScore = 0;
  @notColumn
  public List<IntimateInfo.DNAInfo> dnaInfoList;
  public String dnaInfoListJonStr;
  @notColumn
  public EmptyStatusInfo emptyStatusInfo;
  public IntimateInfo.FriendGiftInfo friendGiftInfo;
  @unique
  public String friendUin;
  public boolean isFriend = true;
  @notColumn
  public boolean isShowRedPoint;
  public int lastAnimAfterFriendDays = 0;
  public int lastAnimAfterScore = 0;
  @notColumn
  public LoveAchievementInfo loveAchievementInfo;
  @notColumn
  public LoveTreeInfo loveTreeInfo;
  public String loveTreeJsonStr;
  @notColumn
  public int mCanRecheckCount;
  @notColumn
  public List<IntimateInfo.MutualMarkInfo> markInfoList;
  public String markInfoListJsonStr;
  public int maskDays;
  public int maskLevel;
  public int maskType;
  @notColumn
  public List<IntimateInfo.MemoryDayInfo> memoryDayInfoList;
  public String memoryDayListJsonStr;
  @notColumn
  public ArrayList<NewDnaInfo> newDnaInfos;
  @notColumn
  public List<IntimateInfo.PrefetchMutualMarkInfo> prefetchMutualMarkInfoList;
  public String prefetchMutualMarkInfoListJsonStr;
  @notColumn
  public IntimateInfo.CommonTroopInfo recentChatTroopInfo;
  public String recentChatTroopInfoJsonStr;
  @notColumn
  public IntimateInfo.IntimateScoreCardInfo scoreCardInfo;
  public String scoreCardInfoJsonStr;
  public long updateTimeMills;
  public boolean useNewType;
  
  public static int convert0xcf4Type2MutualMaskType(int paramInt)
  {
    int i = 5;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return i;
        }
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 9) {
                switch (paramInt)
                {
                default: 
                  break;
                case 22: 
                  return 1;
                case 21: 
                  return 3;
                case 20: 
                  return 2;
                }
              } else {
                return 4;
              }
            }
            else {
              return 7;
            }
          }
          else {
            return 8;
          }
        }
        else {
          return 12;
        }
      }
      else
      {
        return 6;
      }
    }
    i = 0;
    return i;
  }
  
  public static String convertUinKeyForGroupCard(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static IntimateInfo copyFrom(QQAppInterface paramQQAppInterface, oidb_0xcf4.RspBody paramRspBody)
  {
    if ((paramRspBody != null) && (paramQQAppInterface != null))
    {
      IntimateInfo localIntimateInfo = new IntimateInfo();
      boolean bool = paramRspBody.uint64_to_uin.has();
      Object localObject2 = "";
      Object localObject1;
      if (bool) {
        localObject1 = String.valueOf(paramRspBody.uint64_to_uin.get());
      } else {
        localObject1 = "";
      }
      localIntimateInfo.friendUin = ((String)localObject1);
      localIntimateInfo.useNewType = true;
      int j;
      int i;
      if (paramRspBody.msg_cur_mutual_mark_info.has())
      {
        localObject1 = (oidb_0xcf4.MutualMarkInfo)paramRspBody.msg_cur_mutual_mark_info.get();
        if (localObject1 != null)
        {
          bool = ((oidb_0xcf4.MutualMarkInfo)localObject1).eMutualMarkNewType.has();
          j = 0;
          if (bool) {
            i = ((oidb_0xcf4.MutualMarkInfo)localObject1).eMutualMarkNewType.get();
          } else {
            i = 0;
          }
          localIntimateInfo.maskType = i;
          if (((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_level.has()) {
            i = ((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_level.get();
          } else {
            i = 0;
          }
          localIntimateInfo.maskLevel = i;
          i = j;
          if (((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_days.has()) {
            i = ((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_days.get();
          }
          localIntimateInfo.maskDays = i;
        }
      }
      Object localObject3;
      if (paramRspBody.msg_friend_info.has())
      {
        localObject3 = (oidb_0xcf4.FriendInfo)paramRspBody.msg_friend_info.get();
        if (localObject3 != null)
        {
          bool = ((oidb_0xcf4.FriendInfo)localObject3).uint32_add_frd_days.has();
          j = -1;
          if (bool) {
            i = ((oidb_0xcf4.FriendInfo)localObject3).uint32_add_frd_days.get();
          } else {
            i = -1;
          }
          localIntimateInfo.beFriendDays = i;
          if (((oidb_0xcf4.FriendInfo)localObject3).uint32_add_frd_source.has()) {
            i = ((oidb_0xcf4.FriendInfo)localObject3).uint32_add_frd_source.get();
          } else {
            i = -1;
          }
          localIntimateInfo.addFriendSource = i;
          i = j;
          if (((oidb_0xcf4.FriendInfo)localObject3).uint32_add_frd_sub_source.has()) {
            i = ((oidb_0xcf4.FriendInfo)localObject3).uint32_add_frd_sub_source.get();
          }
          localIntimateInfo.addFriendSubSource = i;
          localObject1 = localObject2;
          if (((oidb_0xcf4.FriendInfo)localObject3).bytes_add_frd_wording.has()) {
            localObject1 = ((oidb_0xcf4.FriendInfo)localObject3).bytes_add_frd_wording.get().toStringUtf8();
          }
          localIntimateInfo.addFriendWording = ((String)localObject1);
        }
      }
      if (paramRspBody.msg_common_group_chat_info.has())
      {
        localObject1 = (oidb_0xcf4.CommonGroupChatInfo)paramRspBody.msg_common_group_chat_info.get();
        if (localObject1 != null)
        {
          if (((oidb_0xcf4.CommonGroupChatInfo)localObject1).msg_one_group_info.has()) {
            localIntimateInfo.recentChatTroopInfo = IntimateInfo.CommonTroopInfo.copyFrom((oidb_0xcf4.OneGroupInfo)((oidb_0xcf4.CommonGroupChatInfo)localObject1).msg_one_group_info.get());
          }
          if (((oidb_0xcf4.CommonGroupChatInfo)localObject1).rpt_msg_one_group_info.has())
          {
            localObject2 = ((oidb_0xcf4.CommonGroupChatInfo)localObject1).rpt_msg_one_group_info.get();
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              localIntimateInfo.commonTroopInfoList = new ArrayList();
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = IntimateInfo.CommonTroopInfo.copyFrom((oidb_0xcf4.OneGroupInfo)((Iterator)localObject2).next());
                if (localObject3 != null) {
                  localIntimateInfo.commonTroopInfoList.add(localObject3);
                }
              }
            }
          }
          if (((oidb_0xcf4.CommonGroupChatInfo)localObject1).bytes_wording.has()) {
            localIntimateInfo.commonTroopTips = ((oidb_0xcf4.CommonGroupChatInfo)localObject1).bytes_wording.get().toStringUtf8();
          }
        }
      }
      if (paramRspBody.rpt_msg_mutual_mark_info.has())
      {
        localObject1 = paramRspBody.rpt_msg_mutual_mark_info.get();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localIntimateInfo.markInfoList = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = IntimateInfo.MutualMarkInfo.copyFrom((oidb_0xcf4.MutualMarkInfo)((Iterator)localObject1).next());
            if ((localObject2 != null) && (MutualMarkUtils.b(((IntimateInfo.MutualMarkInfo)localObject2).type))) {
              localIntimateInfo.markInfoList.add(localObject2);
            }
          }
        }
      }
      if (paramRspBody.rpt_msg_prefetch_mutual_mark_info.has())
      {
        localObject1 = paramRspBody.rpt_msg_prefetch_mutual_mark_info.get();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localIntimateInfo.prefetchMutualMarkInfoList = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = IntimateInfo.PrefetchMutualMarkInfo.copyFrom((oidb_0xcf4.PrefetchMutualMarkInfo)((Iterator)localObject1).next());
            if ((localObject2 != null) && (MutualMarkUtils.b(((IntimateInfo.PrefetchMutualMarkInfo)localObject2).type))) {
              localIntimateInfo.prefetchMutualMarkInfoList.add(localObject2);
            }
          }
        }
      }
      if (paramRspBody.rpt_msg_dna_info.has())
      {
        localIntimateInfo.dnaInfoList = new ArrayList();
        localObject1 = paramRspBody.rpt_msg_dna_info.get();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = IntimateInfo.DNAInfo.copyFrom((oidb_0xcf4.DnaInfo)((Iterator)localObject1).next());
            if (localObject2 != null) {
              localIntimateInfo.dnaInfoList.add(localObject2);
            }
          }
        }
      }
      if (paramRspBody.rpt_msg_data_tips.has())
      {
        localIntimateInfo.memoryDayInfoList = new ArrayList();
        localObject1 = paramRspBody.rpt_msg_data_tips.get();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = IntimateInfo.MemoryDayInfo.copyFrom((oidb_0xcf4.DateTips)((Iterator)localObject1).next());
            if (localObject2 != null) {
              localIntimateInfo.memoryDayInfoList.add(localObject2);
            }
          }
        }
      }
      if (paramRspBody.rpt_msg_common_rspbody.has())
      {
        localIntimateInfo.commonBodyList = new ArrayList();
        localObject1 = paramRspBody.rpt_msg_common_rspbody.get();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (oidb_0xcf4.CommonBody)((Iterator)localObject1).next();
            localObject3 = IntimateInfo.CommonBody.copyFrom((oidb_0xcf4.CommonBody)localObject2);
            if (localObject3 != null)
            {
              localIntimateInfo.commonBodyList.add(localObject3);
              if (((IntimateInfo.CommonBody)localObject3).cmd == 3436)
              {
                localIntimateInfo.friendGiftInfo = IntimateInfo.FriendGiftInfo.copyFrom((IntimateInfo.CommonBody)localObject3);
              }
              else if (((IntimateInfo.CommonBody)localObject3).cmd == 3399)
              {
                localObject2 = ((oidb_0xcf4.CommonBody)localObject2).string_oidb_body.get().toByteArray();
                try
                {
                  localObject3 = new recheck_flag_info.RecheckFlagInfo();
                  ((recheck_flag_info.RecheckFlagInfo)localObject3).mergeFrom((byte[])localObject2);
                  localIntimateInfo.isShowRedPoint = ((recheck_flag_info.RecheckFlagInfo)localObject3).bool_has_redtouch.get();
                  localIntimateInfo.mCanRecheckCount = ((recheck_flag_info.RecheckFlagInfo)localObject3).uint32_recheck_num.get();
                }
                catch (Exception localException) {}
                if (QLog.isColorLevel())
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("parse 0xd47 body exception:");
                  ((StringBuilder)localObject3).append(localException.getStackTrace());
                  QLog.w("intimate_relationship", 2, ((StringBuilder)localObject3).toString());
                }
              }
            }
          }
        }
      }
      if (paramRspBody.rpt_msg_mutual_score_card.has())
      {
        localIntimateInfo.scoreCardInfo = IntimateInfo.IntimateScoreCardInfo.copyFrom((oidb_0xcf4.MutualScoreCard)paramRspBody.rpt_msg_mutual_score_card.get());
        localObject1 = localIntimateInfo.scoreCardInfo;
        if (localObject1 != null) {
          localIntimateInfo.currentScore = ((IntimateInfo.IntimateScoreCardInfo)localObject1).score;
        }
      }
      localIntimateInfo.updateTimeMills = NetConnInfoCenter.getServerTimeMillis();
      localIntimateInfo.isFriend = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localIntimateInfo.friendUin);
      localIntimateInfo.commonBodies = paramRspBody.rpt_msg_common_rspbody.get();
      copyFrom848NewInfo(paramQQAppInterface, paramRspBody, localIntimateInfo);
      localIntimateInfo.loveTreeInfo = LoveTreeInfo.a((oidb_0xcf4.LoveTreeInfo)paramRspBody.msg_love_tree_info.get());
      return localIntimateInfo;
    }
    return null;
  }
  
  private static void copyFrom848NewInfo(QQAppInterface paramQQAppInterface, oidb_0xcf4.RspBody paramRspBody, IntimateInfo paramIntimateInfo)
  {
    if (paramRspBody.msg_love_ach_info.has()) {
      paramIntimateInfo.loveAchievementInfo = LoveAchievementInfo.a((oidb_0xcf4.LoveAchievementInfo)paramRspBody.msg_love_ach_info.get());
    }
    if (paramRspBody.rpt_new_dna_info.has()) {
      paramIntimateInfo.newDnaInfos = NewDnaInfo.a(paramRspBody.rpt_new_dna_info.get());
    }
    if (paramRspBody.msg_empty_status.has()) {
      paramIntimateInfo.emptyStatusInfo = EmptyStatusInfo.a((oidb_0xcf4.EmptyStatusInfo)paramRspBody.msg_empty_status.get());
    }
  }
  
  public static String getUinFromGroupCardKey(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      String[] arrayOfString = paramString.split("_");
      str = paramString;
      if (arrayOfString != null)
      {
        str = paramString;
        if (arrayOfString.length >= 2) {
          str = arrayOfString[1];
        }
      }
    }
    return str;
  }
  
  protected void postRead()
  {
    boolean bool = TextUtils.isEmpty(this.commonTroopInfoListJsonStr);
    int j = 0;
    int i;
    Object localObject2;
    if (!bool) {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.commonTroopInfoListJsonStr);
        i = 0;
        while (i < localJSONArray1.length())
        {
          localObject2 = IntimateInfo.CommonTroopInfo.copyFromJson(localJSONArray1.getJSONObject(i));
          if (localObject2 != null)
          {
            if (this.commonTroopInfoList == null) {
              this.commonTroopInfoList = new ArrayList();
            }
            this.commonTroopInfoList.add(localObject2);
          }
          i += 1;
          continue;
          this.commonTroopInfoList = null;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(this.recentChatTroopInfoJsonStr)) {
      try
      {
        this.recentChatTroopInfo = IntimateInfo.CommonTroopInfo.copyFromJson(new JSONObject(this.recentChatTroopInfoJsonStr));
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    } else {
      this.recentChatTroopInfo = null;
    }
    if (!TextUtils.isEmpty(this.markInfoListJsonStr)) {
      try
      {
        JSONArray localJSONArray2 = new JSONArray(this.markInfoListJsonStr);
        i = 0;
        while (i < localJSONArray2.length())
        {
          localObject2 = IntimateInfo.MutualMarkInfo.copyFromJson(localJSONArray2.getJSONObject(i));
          if (localObject2 != null)
          {
            if (this.markInfoList == null) {
              this.markInfoList = new ArrayList();
            }
            this.markInfoList.add(localObject2);
          }
          i += 1;
          continue;
          this.markInfoList = null;
        }
      }
      catch (JSONException localJSONException3)
      {
        localJSONException3.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(this.prefetchMutualMarkInfoListJsonStr)) {
      try
      {
        JSONArray localJSONArray3 = new JSONArray(this.prefetchMutualMarkInfoListJsonStr);
        i = 0;
        while (i < localJSONArray3.length())
        {
          localObject2 = IntimateInfo.PrefetchMutualMarkInfo.copyFromJson(localJSONArray3.getJSONObject(i));
          if (localObject2 != null)
          {
            if (this.prefetchMutualMarkInfoList == null) {
              this.prefetchMutualMarkInfoList = new ArrayList();
            }
            this.prefetchMutualMarkInfoList.add(localObject2);
          }
          i += 1;
          continue;
          this.prefetchMutualMarkInfoList = null;
        }
      }
      catch (JSONException localJSONException4)
      {
        localJSONException4.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(this.dnaInfoListJonStr)) {
      try
      {
        JSONArray localJSONArray4 = new JSONArray(this.dnaInfoListJonStr);
        i = 0;
        while (i < localJSONArray4.length())
        {
          localObject2 = IntimateInfo.DNAInfo.copyFromJson(localJSONArray4.getJSONObject(i));
          if (localObject2 != null)
          {
            if (this.dnaInfoList == null) {
              this.dnaInfoList = new ArrayList();
            }
            this.dnaInfoList.add(localObject2);
          }
          i += 1;
          continue;
          this.dnaInfoList = null;
        }
      }
      catch (JSONException localJSONException5)
      {
        localJSONException5.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(this.memoryDayListJsonStr)) {
      try
      {
        JSONArray localJSONArray5 = new JSONArray(this.memoryDayListJsonStr);
        i = 0;
        while (i < localJSONArray5.length())
        {
          localObject2 = IntimateInfo.MemoryDayInfo.copyFromJson(localJSONArray5.getJSONObject(i));
          if (localObject2 != null)
          {
            if (this.memoryDayInfoList == null) {
              this.memoryDayInfoList = new ArrayList();
            }
            this.memoryDayInfoList.add(localObject2);
          }
          i += 1;
          continue;
          this.memoryDayInfoList = null;
        }
      }
      catch (JSONException localJSONException6)
      {
        localJSONException6.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(this.commonBodyListStr)) {
      try
      {
        JSONArray localJSONArray6 = new JSONArray(this.commonBodyListStr);
        i = j;
        while (i < localJSONArray6.length())
        {
          localObject2 = IntimateInfo.CommonBody.copyFromJson(localJSONArray6.getJSONObject(i));
          if (localObject2 != null)
          {
            if (this.commonBodyList == null) {
              this.commonBodyList = new ArrayList();
            }
            this.commonBodyList.add(localObject2);
            if ((((IntimateInfo.CommonBody)localObject2).cmd == 3436) && (((IntimateInfo.CommonBody)localObject2).rspBodyContent != null)) {
              this.friendGiftInfo = IntimateInfo.FriendGiftInfo.copyFrom((IntimateInfo.CommonBody)localObject2);
            }
          }
          i += 1;
          continue;
          this.commonBodyList = null;
        }
      }
      catch (JSONException localJSONException7)
      {
        localJSONException7.printStackTrace();
      }
    }
    if (!this.useNewType)
    {
      this.useNewType = true;
      this.maskType = convert0xcf4Type2MutualMaskType(this.maskType);
      Object localObject1 = this.markInfoList;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (IntimateInfo.MutualMarkInfo)((Iterator)localObject1).next();
          ((IntimateInfo.MutualMarkInfo)localObject2).type = convert0xcf4Type2MutualMaskType(((IntimateInfo.MutualMarkInfo)localObject2).type);
        }
      }
      localObject1 = this.prefetchMutualMarkInfoList;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (IntimateInfo.PrefetchMutualMarkInfo)((Iterator)localObject1).next();
          ((IntimateInfo.PrefetchMutualMarkInfo)localObject2).type = convert0xcf4Type2MutualMaskType(((IntimateInfo.PrefetchMutualMarkInfo)localObject2).type);
        }
      }
    }
    if (!TextUtils.isEmpty(this.scoreCardInfoJsonStr)) {
      try
      {
        this.scoreCardInfo = IntimateInfo.IntimateScoreCardInfo.copyFromJson(new JSONObject(this.scoreCardInfoJsonStr));
      }
      catch (JSONException localJSONException8)
      {
        localJSONException8.printStackTrace();
      }
    } else {
      this.scoreCardInfo = null;
    }
    this.loveTreeInfo = LoveTreeInfo.a(this.loveTreeJsonStr);
  }
  
  protected void prewrite()
  {
    Object localObject = this.commonTroopInfoList;
    Iterator localIterator;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.commonTroopInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((IntimateInfo.CommonTroopInfo)localIterator.next()).getJSONObject());
      }
      this.commonTroopInfoListJsonStr = ((JSONArray)localObject).toString();
    }
    else
    {
      this.commonTroopInfoListJsonStr = "";
    }
    localObject = this.recentChatTroopInfo;
    if (localObject != null)
    {
      localObject = ((IntimateInfo.CommonTroopInfo)localObject).getJSONObject();
      if (localObject != null) {
        this.recentChatTroopInfoJsonStr = ((JSONObject)localObject).toString();
      }
    }
    localObject = this.markInfoList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.markInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((IntimateInfo.MutualMarkInfo)localIterator.next()).getJSONObject());
      }
      this.markInfoListJsonStr = ((JSONArray)localObject).toString();
    }
    else
    {
      this.markInfoListJsonStr = "";
    }
    localObject = this.prefetchMutualMarkInfoList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.prefetchMutualMarkInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((IntimateInfo.PrefetchMutualMarkInfo)localIterator.next()).getJSONObject());
      }
      this.prefetchMutualMarkInfoListJsonStr = ((JSONArray)localObject).toString();
    }
    else
    {
      this.prefetchMutualMarkInfoListJsonStr = "";
    }
    localObject = this.dnaInfoList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.dnaInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((IntimateInfo.DNAInfo)localIterator.next()).getJSONObject());
      }
      this.dnaInfoListJonStr = ((JSONArray)localObject).toString();
    }
    else
    {
      this.dnaInfoListJonStr = "";
    }
    if (this.memoryDayInfoList != null)
    {
      localObject = new JSONArray();
      localIterator = this.memoryDayInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((IntimateInfo.MemoryDayInfo)localIterator.next()).getJSONObject());
      }
      this.memoryDayListJsonStr = ((JSONArray)localObject).toString();
    }
    else
    {
      this.memoryDayListJsonStr = "";
    }
    localObject = this.commonBodyList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.commonBodyList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((IntimateInfo.CommonBody)localIterator.next()).getJSONObject());
      }
      this.commonBodyListStr = ((JSONArray)localObject).toString();
    }
    else
    {
      this.commonBodyListStr = "";
    }
    localObject = this.scoreCardInfo;
    if (localObject != null) {
      this.scoreCardInfoJsonStr = ((IntimateInfo.IntimateScoreCardInfo)localObject).getJSONObject().toString();
    } else {
      this.scoreCardInfoJsonStr = "";
    }
    localObject = this.loveTreeInfo;
    if (localObject != null) {
      this.loveTreeJsonStr = ((LoveTreeInfo)localObject).a();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IntimateInfo{friendUin='");
    localStringBuilder.append(this.friendUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", maskType=");
    localStringBuilder.append(this.maskType);
    localStringBuilder.append(", maskLevel=");
    localStringBuilder.append(this.maskLevel);
    localStringBuilder.append(", maskDays=");
    localStringBuilder.append(this.maskDays);
    localStringBuilder.append(", useNewType=");
    localStringBuilder.append(this.useNewType);
    localStringBuilder.append(", beFriendDays=");
    localStringBuilder.append(this.beFriendDays);
    localStringBuilder.append(", lastAnimAfterFriendDays=");
    localStringBuilder.append(this.lastAnimAfterFriendDays);
    localStringBuilder.append(", currentScore=");
    localStringBuilder.append(this.currentScore);
    localStringBuilder.append(", lastAnimAfterScore=");
    localStringBuilder.append(this.lastAnimAfterScore);
    localStringBuilder.append(", addFriendSource=");
    localStringBuilder.append(this.addFriendSource);
    localStringBuilder.append(", addFriendSubSource=");
    localStringBuilder.append(this.addFriendSubSource);
    localStringBuilder.append(", addFriendWording=");
    localStringBuilder.append(this.addFriendWording);
    localStringBuilder.append(", markInfoListJsonStr=");
    localStringBuilder.append(this.markInfoListJsonStr);
    localStringBuilder.append(", prefetchMutualMarkInfoListJsonStr=");
    localStringBuilder.append(this.prefetchMutualMarkInfoListJsonStr);
    localStringBuilder.append(", commonTroopInfoList=");
    localStringBuilder.append(this.commonTroopInfoList);
    localStringBuilder.append(", recentChatTroopInfo=");
    localStringBuilder.append(this.recentChatTroopInfo);
    localStringBuilder.append(", commonTroopTips=");
    localStringBuilder.append(this.commonTroopTips);
    localStringBuilder.append(", dnaInfoList=");
    localStringBuilder.append(this.dnaInfoList);
    localStringBuilder.append(", memoryDayInfoList=");
    localStringBuilder.append(this.memoryDayInfoList);
    localStringBuilder.append(", isFriend=");
    localStringBuilder.append(this.isFriend);
    localStringBuilder.append(", updateTimeMills=");
    localStringBuilder.append(this.updateTimeMills);
    localStringBuilder.append(", scoreCardInfo=");
    localStringBuilder.append(this.scoreCardInfo);
    localStringBuilder.append(", newDnaInfos=");
    localStringBuilder.append(this.newDnaInfos);
    localStringBuilder.append(", loveAchievementInfo=");
    localStringBuilder.append(this.loveAchievementInfo);
    localStringBuilder.append(", emptyStatusInfo=");
    localStringBuilder.append(this.emptyStatusInfo);
    localStringBuilder.append(", loveTreeInfo, ");
    localStringBuilder.append(this.loveTreeInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo
 * JD-Core Version:    0.7.0.1
 */