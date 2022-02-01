package com.tencent.mobileqq.mutualmark.info;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.friend.IExtensionBusinessData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import java.util.concurrent.ConcurrentHashMap;

public class ExtensionMutualMarkData
  implements IExtensionBusinessData
{
  public ConcurrentHashMap<Long, MutualMarkInfo> a;
  
  public static void c(ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo == null) {}
    do
    {
      return;
      paramExtensionInfo.bestIntimacyType = 0;
      paramExtensionInfo.bestIntimacyDays = 0;
      paramExtensionInfo.praiseHotLevel = 0;
      paramExtensionInfo.chatHotLevel = 0;
      paramExtensionInfo.loverChatLevel = 0;
      paramExtensionInfo.loverTransFlag = false;
      paramExtensionInfo.qzoneVisitType = 0;
      paramExtensionInfo.hiddenChatSwitch = 0;
      paramExtensionInfo.qzoneHotDays = 0;
      paramExtensionInfo.lastQzoneVisitTime = 0L;
      paramExtensionInfo.newBestIntimacyType = 0;
      paramExtensionInfo.localChatSendTs = 0L;
      paramExtensionInfo.localChatRecTs = 0L;
      paramExtensionInfo.lastIceBreakChatTs = 0L;
      paramExtensionInfo.friendshipLevel = 0;
      paramExtensionInfo.friendshipChatDays = 0;
      paramExtensionInfo.lastFriendshipTime = 0L;
      paramExtensionInfo.intimate_type = 0;
      paramExtensionInfo.intimate_level = 0;
      paramExtensionInfo.intimate_chatDays = 0;
      paramExtensionInfo.last_intimate_chatTime = 0L;
      paramExtensionInfo.isExtinguish = false;
      paramExtensionInfo = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
    } while ((paramExtensionInfo == null) || (paramExtensionInfo.a == null));
    paramExtensionInfo.a.clear();
  }
  
  private void d(ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo.mutual_mark_version < 818)
    {
      e(paramExtensionInfo);
      paramExtensionInfo.mutual_mark_version = 818;
    }
    if (paramExtensionInfo.mutual_mark_version < 845)
    {
      f(paramExtensionInfo);
      g(paramExtensionInfo);
      h(paramExtensionInfo);
      i(paramExtensionInfo);
      j(paramExtensionInfo);
      paramExtensionInfo.mutual_mark_version = 845;
    }
  }
  
  private void e(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo.qzoneVisitType >= 1) && (paramExtensionInfo.qzoneVisitType <= 2) && ((this.a == null) || (this.a.get(Long.valueOf(8L)) == null)))
    {
      if (this.a == null) {
        this.a = new ConcurrentHashMap();
      }
      MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
      localMutualMarkInfo.a = 8L;
      localMutualMarkInfo.jdField_b_of_type_Long = paramExtensionInfo.qzoneVisitType;
      localMutualMarkInfo.d = paramExtensionInfo.lastQzoneVisitTime;
      localMutualMarkInfo.c = paramExtensionInfo.qzoneHotDays;
      localMutualMarkInfo.jdField_b_of_type_Boolean = paramExtensionInfo.hasRemindQzoneVisit;
      this.a.put(Long.valueOf(localMutualMarkInfo.a), localMutualMarkInfo);
    }
  }
  
  private void f(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo.friendshipLevel >= 1) && (paramExtensionInfo.friendshipLevel <= 3) && ((this.a == null) || (this.a.get(Long.valueOf(4L)) == null)))
    {
      if (this.a == null) {
        this.a = new ConcurrentHashMap();
      }
      MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
      localMutualMarkInfo.a = 4L;
      localMutualMarkInfo.jdField_b_of_type_Long = paramExtensionInfo.friendshipLevel;
      localMutualMarkInfo.d = paramExtensionInfo.lastFriendshipTime;
      localMutualMarkInfo.c = paramExtensionInfo.friendshipChatDays;
      localMutualMarkInfo.jdField_b_of_type_Boolean = paramExtensionInfo.hasRemindFrdship;
      localMutualMarkInfo.i = paramExtensionInfo.frdshipAnimStartTime;
      this.a.put(Long.valueOf(localMutualMarkInfo.a), localMutualMarkInfo);
    }
  }
  
  private void g(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo.chatHotLevel >= 1) && (paramExtensionInfo.chatHotLevel <= 2) && ((this.a == null) || (this.a.get(Long.valueOf(5L)) == null)))
    {
      if (this.a == null) {
        this.a = new ConcurrentHashMap();
      }
      MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
      localMutualMarkInfo.a = 5L;
      localMutualMarkInfo.jdField_b_of_type_Long = paramExtensionInfo.chatHotLevel;
      localMutualMarkInfo.d = paramExtensionInfo.lastChatTime;
      localMutualMarkInfo.c = paramExtensionInfo.chatDays;
      localMutualMarkInfo.jdField_b_of_type_Boolean = paramExtensionInfo.hasRemindChat;
      localMutualMarkInfo.i = paramExtensionInfo.chatAnimStartTime;
      this.a.put(Long.valueOf(localMutualMarkInfo.a), localMutualMarkInfo);
    }
  }
  
  private void h(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo.loverChatLevel >= 1) && (paramExtensionInfo.loverChatLevel <= 2) && ((this.a == null) || (this.a.get(Long.valueOf(7L)) == null)))
    {
      if (this.a == null) {
        this.a = new ConcurrentHashMap();
      }
      MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
      localMutualMarkInfo.a = 7L;
      localMutualMarkInfo.jdField_b_of_type_Long = paramExtensionInfo.loverChatLevel;
      localMutualMarkInfo.d = paramExtensionInfo.loverLastChatTime;
      localMutualMarkInfo.c = paramExtensionInfo.loverChatDays;
      if (paramExtensionInfo.loverTransFlag)
      {
        localMutualMarkInfo.f = 2L;
        localMutualMarkInfo.g = (NetConnInfoCenter.getServerTimeMillis() / 1000L + 86400L);
      }
      this.a.put(Long.valueOf(localMutualMarkInfo.a), localMutualMarkInfo);
    }
  }
  
  private void i(ExtensionInfo paramExtensionInfo)
  {
    if (HotReactiveHelper.a()) {
      if ((paramExtensionInfo.newBestIntimacyType >= 1) && (paramExtensionInfo.newBestIntimacyType <= 2) && ((this.a == null) || (this.a.get(Long.valueOf(12L)) == null)))
      {
        if (this.a == null) {
          this.a = new ConcurrentHashMap();
        }
        localMutualMarkInfo = new MutualMarkInfo();
        localMutualMarkInfo.a = 12L;
        localMutualMarkInfo.jdField_b_of_type_Long = paramExtensionInfo.newBestIntimacyType;
        this.a.put(Long.valueOf(localMutualMarkInfo.a), localMutualMarkInfo);
      }
    }
    while ((paramExtensionInfo.bestIntimacyType < 1) || (paramExtensionInfo.bestIntimacyType > 2) || ((this.a != null) && (this.a.get(Long.valueOf(12L)) != null))) {
      return;
    }
    if (this.a == null) {
      this.a = new ConcurrentHashMap();
    }
    MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
    localMutualMarkInfo.a = 12L;
    localMutualMarkInfo.jdField_b_of_type_Long = paramExtensionInfo.bestIntimacyType;
    this.a.put(Long.valueOf(localMutualMarkInfo.a), localMutualMarkInfo);
  }
  
  private void j(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo.praiseHotLevel >= 1) && (paramExtensionInfo.praiseHotLevel <= 2) && ((this.a == null) || (this.a.get(Long.valueOf(6L)) == null)))
    {
      if (this.a == null) {
        this.a = new ConcurrentHashMap();
      }
      MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
      localMutualMarkInfo.a = 6L;
      localMutualMarkInfo.jdField_b_of_type_Long = paramExtensionInfo.praiseHotLevel;
      localMutualMarkInfo.d = paramExtensionInfo.lastpraiseTime;
      localMutualMarkInfo.jdField_b_of_type_Boolean = paramExtensionInfo.hasRemindPraise;
      localMutualMarkInfo.i = paramExtensionInfo.praiseAnimStartTime;
      this.a.put(Long.valueOf(localMutualMarkInfo.a), localMutualMarkInfo);
    }
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if (!TextUtils.isEmpty(paramExtensionInfo.mutual_marks_store_json)) {}
    for (this.a = MutualMarkInfo.a(paramExtensionInfo.mutual_marks_store_json);; this.a = null)
    {
      d(paramExtensionInfo);
      return;
    }
  }
  
  public void a(ExtensionInfo paramExtensionInfo, Object... paramVarArgs) {}
  
  public void b(ExtensionInfo paramExtensionInfo)
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      paramExtensionInfo.mutual_marks_store_json = MutualMarkInfo.a(this.a);
      return;
    }
    paramExtensionInfo.mutual_marks_store_json = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.ExtensionMutualMarkData
 * JD-Core Version:    0.7.0.1
 */