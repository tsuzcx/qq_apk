package com.tencent.mobileqq.data;

import aloz;
import android.text.TextUtils;
import auoj;
import awbv;
import awdg;
import awdj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.FriendInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualScore;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.OneGroupInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.PrefetchMutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.RspBody;
import tencent.im.oidb.recheck_flag_info.recheck_flag_info.RecheckFlagInfo;

public class IntimateInfo
  extends awbv
{
  public int addFriendSource = -1;
  public int addFriendSubSource = -1;
  public String addFriendWording;
  public int beFriendDays = -2;
  @awdg
  public List<oidb_0xcf4.CommonBody> commonBodies;
  @awdg
  public List<IntimateInfo.CommonBody> commonBodyList;
  public String commonBodyListStr;
  @awdg
  public List<IntimateInfo.CommonTroopInfo> commonTroopInfoList;
  public String commonTroopInfoListJsonStr;
  public String commonTroopTips;
  public int currentScore;
  @awdg
  public List<IntimateInfo.DNAInfo> dnaInfoList;
  public String dnaInfoListJonStr;
  public IntimateInfo.FriendGiftInfo friendGiftInfo;
  @awdj
  public String friendUin;
  public boolean isFriend = true;
  @awdg
  public boolean isShowRedPoint;
  public int lastAnimAfterFriendDays;
  public int lastAnimAfterScore;
  @awdg
  public int mCanRecheckCount;
  @awdg
  public List<IntimateInfo.MutualMarkInfo> markInfoList;
  public String markInfoListJsonStr;
  public int maskDays;
  public int maskLevel;
  public int maskType;
  @awdg
  public List<IntimateInfo.MemoryDayInfo> memoryDayInfoList;
  public String memoryDayListJsonStr;
  @awdg
  public List<IntimateInfo.PrefetchMutualMarkInfo> prefetchMutualMarkInfoList;
  public String prefetchMutualMarkInfoListJsonStr;
  @awdg
  public IntimateInfo.CommonTroopInfo recentChatTroopInfo;
  public String recentChatTroopInfoJsonStr;
  public long updateTimeMills;
  public boolean useNewType;
  
  public static int convert0xcf4Type2MutualMaskType(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return 0;
    case 1: 
      return 6;
    case 2: 
      return 5;
    case 3: 
      return 12;
    case 4: 
      return 8;
    case 5: 
      return 7;
    case 9: 
      return 4;
    case 20: 
      return 2;
    case 21: 
      return 3;
    }
    return 1;
  }
  
  public static String convertUinKeyForGroupCard(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public static IntimateInfo copyFrom(QQAppInterface paramQQAppInterface, oidb_0xcf4.RspBody paramRspBody)
  {
    int k = 0;
    int j = -1;
    if ((paramRspBody == null) || (paramQQAppInterface == null)) {
      return null;
    }
    IntimateInfo localIntimateInfo = new IntimateInfo();
    int i;
    if (paramRspBody.uint64_to_uin.has())
    {
      localObject1 = String.valueOf(paramRspBody.uint64_to_uin.get());
      localIntimateInfo.friendUin = ((String)localObject1);
      localIntimateInfo.useNewType = true;
      if (paramRspBody.msg_cur_mutual_mark_info.has())
      {
        localObject1 = (oidb_0xcf4.MutualMarkInfo)paramRspBody.msg_cur_mutual_mark_info.get();
        if (localObject1 != null)
        {
          if (!((oidb_0xcf4.MutualMarkInfo)localObject1).eMutualMarkNewType.has()) {
            break label472;
          }
          i = ((oidb_0xcf4.MutualMarkInfo)localObject1).eMutualMarkNewType.get();
          label106:
          localIntimateInfo.maskType = i;
          if (!((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_level.has()) {
            break label477;
          }
          i = ((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_level.get();
          label132:
          localIntimateInfo.maskLevel = i;
          i = k;
          if (((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_days.has()) {
            i = ((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_days.get();
          }
          localIntimateInfo.maskDays = i;
        }
      }
      if (paramRspBody.msg_friend_info.has())
      {
        localObject1 = (oidb_0xcf4.FriendInfo)paramRspBody.msg_friend_info.get();
        if (localObject1 != null)
        {
          if (!((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_days.has()) {
            break label482;
          }
          i = ((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_days.get();
          label214:
          localIntimateInfo.beFriendDays = i;
          if (!((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_source.has()) {
            break label487;
          }
          i = ((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_source.get();
          label240:
          localIntimateInfo.addFriendSource = i;
          i = j;
          if (((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_sub_source.has()) {
            i = ((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_sub_source.get();
          }
          localIntimateInfo.addFriendSubSource = i;
          if (!((oidb_0xcf4.FriendInfo)localObject1).bytes_add_frd_wording.has()) {
            break label492;
          }
        }
      }
    }
    Object localObject2;
    Object localObject3;
    label472:
    label477:
    label482:
    label487:
    label492:
    for (Object localObject1 = ((oidb_0xcf4.FriendInfo)localObject1).bytes_add_frd_wording.get().toStringUtf8();; localObject1 = "")
    {
      localIntimateInfo.addFriendWording = ((String)localObject1);
      if (!paramRspBody.msg_common_group_chat_info.has()) {
        break label526;
      }
      localObject1 = (oidb_0xcf4.CommonGroupChatInfo)paramRspBody.msg_common_group_chat_info.get();
      if (localObject1 == null) {
        break label526;
      }
      if (((oidb_0xcf4.CommonGroupChatInfo)localObject1).msg_one_group_info.has()) {
        localIntimateInfo.recentChatTroopInfo = IntimateInfo.CommonTroopInfo.copyFrom((oidb_0xcf4.OneGroupInfo)((oidb_0xcf4.CommonGroupChatInfo)localObject1).msg_one_group_info.get());
      }
      if (!((oidb_0xcf4.CommonGroupChatInfo)localObject1).rpt_msg_one_group_info.has()) {
        break label499;
      }
      localObject2 = ((oidb_0xcf4.CommonGroupChatInfo)localObject1).rpt_msg_one_group_info.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label499;
      }
      localIntimateInfo.commonTroopInfoList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = IntimateInfo.CommonTroopInfo.copyFrom((oidb_0xcf4.OneGroupInfo)((Iterator)localObject2).next());
        if (localObject3 != null) {
          localIntimateInfo.commonTroopInfoList.add(localObject3);
        }
      }
      localObject1 = "";
      break;
      i = 0;
      break label106;
      i = 0;
      break label132;
      i = -1;
      break label214;
      i = -1;
      break label240;
    }
    label499:
    if (((oidb_0xcf4.CommonGroupChatInfo)localObject1).bytes_wording.has()) {
      localIntimateInfo.commonTroopTips = ((oidb_0xcf4.CommonGroupChatInfo)localObject1).bytes_wording.get().toStringUtf8();
    }
    label526:
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
          if ((localObject2 != null) && (auoj.b(((IntimateInfo.MutualMarkInfo)localObject2).type))) {
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
          if ((localObject2 != null) && (auoj.b(((IntimateInfo.PrefetchMutualMarkInfo)localObject2).type))) {
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
              if (QLog.isColorLevel()) {
                QLog.w("intimate_relationship", 2, "parse 0xd47 body exception:" + localException.getStackTrace());
              }
            }
          }
        }
      }
    }
    if ((paramRspBody.rpt_msg_mutual_score.has()) && (paramRspBody.rpt_msg_mutual_score.uint32_current_score.has())) {
      localIntimateInfo.currentScore = paramRspBody.rpt_msg_mutual_score.uint32_current_score.get();
    }
    localIntimateInfo.updateTimeMills = NetConnInfoCenter.getServerTimeMillis();
    localIntimateInfo.isFriend = ((aloz)paramQQAppInterface.getManager(51)).b(localIntimateInfo.friendUin);
    localIntimateInfo.commonBodies = paramRspBody.rpt_msg_common_rspbody.get();
    return localIntimateInfo;
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
  
  public void postRead()
  {
    int i;
    Object localObject;
    if (!TextUtils.isEmpty(this.commonTroopInfoListJsonStr)) {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.commonTroopInfoListJsonStr);
        i = 0;
        while (i < localJSONArray1.length())
        {
          localObject = IntimateInfo.CommonTroopInfo.copyFromJson(localJSONArray1.getJSONObject(i));
          if (localObject != null)
          {
            if (this.commonTroopInfoList == null) {
              this.commonTroopInfoList = new ArrayList();
            }
            this.commonTroopInfoList.add(localObject);
          }
          i += 1;
        }
        if (TextUtils.isEmpty(this.recentChatTroopInfoJsonStr)) {}
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    for (;;)
    {
      try
      {
        this.recentChatTroopInfo = IntimateInfo.CommonTroopInfo.copyFromJson(new JSONObject(this.recentChatTroopInfoJsonStr));
        if (TextUtils.isEmpty(this.markInfoListJsonStr)) {
          break label305;
        }
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          JSONArray localJSONArray2 = new JSONArray(this.markInfoListJsonStr);
          i = 0;
          if (i >= localJSONArray2.length()) {
            break;
          }
          localObject = IntimateInfo.MutualMarkInfo.copyFromJson(localJSONArray2.getJSONObject(i));
          if (localObject != null)
          {
            if (this.markInfoList == null) {
              this.markInfoList = new ArrayList();
            }
            this.markInfoList.add(localObject);
          }
          i += 1;
          continue;
          this.commonTroopInfoList = null;
        }
        catch (JSONException localJSONException3)
        {
          localJSONException3.printStackTrace();
        }
        localJSONException2 = localJSONException2;
        localJSONException2.printStackTrace();
        continue;
      }
      this.recentChatTroopInfo = null;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.prefetchMutualMarkInfoListJsonStr)) {
        try
        {
          JSONArray localJSONArray3 = new JSONArray(this.prefetchMutualMarkInfoListJsonStr);
          i = 0;
          while (i < localJSONArray3.length())
          {
            localObject = IntimateInfo.PrefetchMutualMarkInfo.copyFromJson(localJSONArray3.getJSONObject(i));
            if (localObject != null)
            {
              if (this.prefetchMutualMarkInfoList == null) {
                this.prefetchMutualMarkInfoList = new ArrayList();
              }
              this.prefetchMutualMarkInfoList.add(localObject);
            }
            i += 1;
            continue;
            label305:
            this.markInfoList = null;
          }
        }
        catch (JSONException localJSONException4)
        {
          localJSONException4.printStackTrace();
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.dnaInfoListJonStr)) {
        try
        {
          JSONArray localJSONArray4 = new JSONArray(this.dnaInfoListJonStr);
          i = 0;
          while (i < localJSONArray4.length())
          {
            localObject = IntimateInfo.DNAInfo.copyFromJson(localJSONArray4.getJSONObject(i));
            if (localObject != null)
            {
              if (this.dnaInfoList == null) {
                this.dnaInfoList = new ArrayList();
              }
              this.dnaInfoList.add(localObject);
            }
            i += 1;
            continue;
            this.prefetchMutualMarkInfoList = null;
          }
        }
        catch (JSONException localJSONException5)
        {
          localJSONException5.printStackTrace();
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.memoryDayListJsonStr)) {
        try
        {
          JSONArray localJSONArray5 = new JSONArray(this.memoryDayListJsonStr);
          i = 0;
          while (i < localJSONArray5.length())
          {
            localObject = IntimateInfo.MemoryDayInfo.copyFromJson(localJSONArray5.getJSONObject(i));
            if (localObject != null)
            {
              if (this.memoryDayInfoList == null) {
                this.memoryDayInfoList = new ArrayList();
              }
              this.memoryDayInfoList.add(localObject);
            }
            i += 1;
            continue;
            this.dnaInfoList = null;
          }
        }
        catch (JSONException localJSONException6)
        {
          localJSONException6.printStackTrace();
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.commonBodyListStr)) {
        try
        {
          JSONArray localJSONArray6 = new JSONArray(this.commonBodyListStr);
          i = 0;
          while (i < localJSONArray6.length())
          {
            localObject = IntimateInfo.CommonBody.copyFromJson(localJSONArray6.getJSONObject(i));
            if (localObject != null)
            {
              if (this.commonBodyList == null) {
                this.commonBodyList = new ArrayList();
              }
              this.commonBodyList.add(localObject);
              if ((((IntimateInfo.CommonBody)localObject).cmd == 3436) && (((IntimateInfo.CommonBody)localObject).rspBodyContent != null)) {
                this.friendGiftInfo = IntimateInfo.FriendGiftInfo.copyFrom((IntimateInfo.CommonBody)localObject);
              }
            }
            i += 1;
            continue;
            this.memoryDayInfoList = null;
          }
        }
        catch (JSONException localJSONException7)
        {
          localJSONException7.printStackTrace();
        }
      }
    }
    while (!this.useNewType)
    {
      this.useNewType = true;
      this.maskType = convert0xcf4Type2MutualMaskType(this.maskType);
      Iterator localIterator;
      if (this.markInfoList != null)
      {
        localIterator = this.markInfoList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (IntimateInfo.MutualMarkInfo)localIterator.next();
            ((IntimateInfo.MutualMarkInfo)localObject).type = convert0xcf4Type2MutualMaskType(((IntimateInfo.MutualMarkInfo)localObject).type);
            continue;
            this.commonBodyList = null;
            break;
          }
        }
      }
      if (this.prefetchMutualMarkInfoList != null)
      {
        localIterator = this.prefetchMutualMarkInfoList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (IntimateInfo.PrefetchMutualMarkInfo)localIterator.next();
          ((IntimateInfo.PrefetchMutualMarkInfo)localObject).type = convert0xcf4Type2MutualMaskType(((IntimateInfo.PrefetchMutualMarkInfo)localObject).type);
        }
      }
    }
  }
  
  public void prewrite()
  {
    Object localObject;
    Iterator localIterator;
    if ((this.commonTroopInfoList != null) && (this.commonTroopInfoList.size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.commonTroopInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((IntimateInfo.CommonTroopInfo)localIterator.next()).getJSONObject());
      }
    }
    for (this.commonTroopInfoListJsonStr = ((JSONArray)localObject).toString();; this.commonTroopInfoListJsonStr = "")
    {
      if (this.recentChatTroopInfo != null)
      {
        localObject = this.recentChatTroopInfo.getJSONObject();
        if (localObject != null) {
          this.recentChatTroopInfoJsonStr = ((JSONObject)localObject).toString();
        }
      }
      if ((this.markInfoList == null) || (this.markInfoList.size() <= 0)) {
        break label250;
      }
      localObject = new JSONArray();
      localIterator = this.markInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((IntimateInfo.MutualMarkInfo)localIterator.next()).getJSONObject());
      }
    }
    this.markInfoListJsonStr = ((JSONArray)localObject).toString();
    while ((this.prefetchMutualMarkInfoList != null) && (this.prefetchMutualMarkInfoList.size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.prefetchMutualMarkInfoList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((JSONArray)localObject).put(((IntimateInfo.PrefetchMutualMarkInfo)localIterator.next()).getJSONObject());
          continue;
          label250:
          this.markInfoListJsonStr = "";
          break;
        }
      }
      this.prefetchMutualMarkInfoListJsonStr = ((JSONArray)localObject).toString();
    }
    while ((this.dnaInfoList != null) && (this.dnaInfoList.size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.dnaInfoList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((JSONArray)localObject).put(((IntimateInfo.DNAInfo)localIterator.next()).getJSONObject());
          continue;
          this.prefetchMutualMarkInfoListJsonStr = "";
          break;
        }
      }
      this.dnaInfoListJonStr = ((JSONArray)localObject).toString();
    }
    while (this.memoryDayInfoList != null)
    {
      localObject = new JSONArray();
      localIterator = this.memoryDayInfoList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((JSONArray)localObject).put(((IntimateInfo.MemoryDayInfo)localIterator.next()).getJSONObject());
          continue;
          this.dnaInfoListJonStr = "";
          break;
        }
      }
      this.memoryDayListJsonStr = ((JSONArray)localObject).toString();
    }
    while ((this.commonBodyList != null) && (this.commonBodyList.size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.commonBodyList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((JSONArray)localObject).put(((IntimateInfo.CommonBody)localIterator.next()).getJSONObject());
          continue;
          this.memoryDayListJsonStr = "";
          break;
        }
      }
      this.commonBodyListStr = ((JSONArray)localObject).toString();
      return;
    }
    this.commonBodyListStr = "";
  }
  
  public String toString()
  {
    return "IntimateInfo{friendUin='" + this.friendUin + '\'' + ", maskType=" + this.maskType + ", maskLevel=" + this.maskLevel + ", maskDays=" + this.maskDays + ", useNewType=" + this.useNewType + ", beFriendDays=" + this.beFriendDays + ", lastAnimAfterFriendDays=" + this.lastAnimAfterFriendDays + ", currentScore=" + this.currentScore + ", lastAnimAfterScore=" + this.lastAnimAfterScore + ", addFriendSource=" + this.addFriendSource + ", addFriendSubSource=" + this.addFriendSubSource + ", addFriendWording=" + this.addFriendWording + ", commonTroopInfoList=" + this.commonTroopInfoList + ", recentChatTroopInfo=" + this.recentChatTroopInfo + ", commonTroopTips=" + this.commonTroopTips + ", dnaInfoList=" + this.dnaInfoList + ", memoryDayInfoList=" + this.memoryDayInfoList + ", isFriend=" + this.isFriend + ", updateTimeMills=" + this.updateTimeMills + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo
 * JD-Core Version:    0.7.0.1
 */