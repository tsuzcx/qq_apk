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
    if (paramExtensionInfo == null) {
      return;
    }
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
    if (paramExtensionInfo != null)
    {
      paramExtensionInfo = paramExtensionInfo.a;
      if (paramExtensionInfo != null) {
        paramExtensionInfo.clear();
      }
    }
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
    if ((paramExtensionInfo.qzoneVisitType >= 1) && (paramExtensionInfo.qzoneVisitType <= 2))
    {
      Object localObject = this.a;
      if ((localObject == null) || (((ConcurrentHashMap)localObject).get(Long.valueOf(8L)) == null))
      {
        if (this.a == null) {
          this.a = new ConcurrentHashMap();
        }
        localObject = new MutualMarkInfo();
        ((MutualMarkInfo)localObject).a = 8L;
        ((MutualMarkInfo)localObject).b = paramExtensionInfo.qzoneVisitType;
        ((MutualMarkInfo)localObject).e = paramExtensionInfo.lastQzoneVisitTime;
        ((MutualMarkInfo)localObject).d = paramExtensionInfo.qzoneHotDays;
        ((MutualMarkInfo)localObject).n = paramExtensionInfo.hasRemindQzoneVisit;
        this.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
      }
    }
  }
  
  private void f(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo.friendshipLevel >= 1) && (paramExtensionInfo.friendshipLevel <= 3))
    {
      Object localObject = this.a;
      if ((localObject == null) || (((ConcurrentHashMap)localObject).get(Long.valueOf(4L)) == null))
      {
        if (this.a == null) {
          this.a = new ConcurrentHashMap();
        }
        localObject = new MutualMarkInfo();
        ((MutualMarkInfo)localObject).a = 4L;
        ((MutualMarkInfo)localObject).b = paramExtensionInfo.friendshipLevel;
        ((MutualMarkInfo)localObject).e = paramExtensionInfo.lastFriendshipTime;
        ((MutualMarkInfo)localObject).d = paramExtensionInfo.friendshipChatDays;
        ((MutualMarkInfo)localObject).n = paramExtensionInfo.hasRemindFrdship;
        ((MutualMarkInfo)localObject).o = paramExtensionInfo.frdshipAnimStartTime;
        this.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
      }
    }
  }
  
  private void g(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo.chatHotLevel >= 1) && (paramExtensionInfo.chatHotLevel <= 2))
    {
      Object localObject = this.a;
      if ((localObject == null) || (((ConcurrentHashMap)localObject).get(Long.valueOf(5L)) == null))
      {
        if (this.a == null) {
          this.a = new ConcurrentHashMap();
        }
        localObject = new MutualMarkInfo();
        ((MutualMarkInfo)localObject).a = 5L;
        ((MutualMarkInfo)localObject).b = paramExtensionInfo.chatHotLevel;
        ((MutualMarkInfo)localObject).e = paramExtensionInfo.lastChatTime;
        ((MutualMarkInfo)localObject).d = paramExtensionInfo.chatDays;
        ((MutualMarkInfo)localObject).n = paramExtensionInfo.hasRemindChat;
        ((MutualMarkInfo)localObject).o = paramExtensionInfo.chatAnimStartTime;
        this.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
      }
    }
  }
  
  private void h(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo.loverChatLevel >= 1) && (paramExtensionInfo.loverChatLevel <= 2))
    {
      Object localObject = this.a;
      if ((localObject == null) || (((ConcurrentHashMap)localObject).get(Long.valueOf(7L)) == null))
      {
        if (this.a == null) {
          this.a = new ConcurrentHashMap();
        }
        localObject = new MutualMarkInfo();
        ((MutualMarkInfo)localObject).a = 7L;
        ((MutualMarkInfo)localObject).b = paramExtensionInfo.loverChatLevel;
        ((MutualMarkInfo)localObject).e = paramExtensionInfo.loverLastChatTime;
        ((MutualMarkInfo)localObject).d = paramExtensionInfo.loverChatDays;
        if (paramExtensionInfo.loverTransFlag)
        {
          ((MutualMarkInfo)localObject).g = 2L;
          ((MutualMarkInfo)localObject).h = (NetConnInfoCenter.getServerTimeMillis() / 1000L + 86400L);
        }
        this.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
      }
    }
  }
  
  private void i(ExtensionInfo paramExtensionInfo)
  {
    boolean bool = HotReactiveHelper.g();
    Object localObject = Long.valueOf(12L);
    ConcurrentHashMap localConcurrentHashMap;
    if (bool)
    {
      if ((paramExtensionInfo.newBestIntimacyType >= 1) && (paramExtensionInfo.newBestIntimacyType <= 2))
      {
        localConcurrentHashMap = this.a;
        if ((localConcurrentHashMap == null) || (localConcurrentHashMap.get(localObject) == null))
        {
          if (this.a == null) {
            this.a = new ConcurrentHashMap();
          }
          localObject = new MutualMarkInfo();
          ((MutualMarkInfo)localObject).a = 12L;
          ((MutualMarkInfo)localObject).b = paramExtensionInfo.newBestIntimacyType;
          this.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
        }
      }
    }
    else if ((paramExtensionInfo.bestIntimacyType >= 1) && (paramExtensionInfo.bestIntimacyType <= 2))
    {
      localConcurrentHashMap = this.a;
      if ((localConcurrentHashMap == null) || (localConcurrentHashMap.get(localObject) == null))
      {
        if (this.a == null) {
          this.a = new ConcurrentHashMap();
        }
        localObject = new MutualMarkInfo();
        ((MutualMarkInfo)localObject).a = 12L;
        ((MutualMarkInfo)localObject).b = paramExtensionInfo.bestIntimacyType;
        this.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
      }
    }
  }
  
  private void j(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo.praiseHotLevel >= 1) && (paramExtensionInfo.praiseHotLevel <= 2))
    {
      Object localObject = this.a;
      if ((localObject == null) || (((ConcurrentHashMap)localObject).get(Long.valueOf(6L)) == null))
      {
        if (this.a == null) {
          this.a = new ConcurrentHashMap();
        }
        localObject = new MutualMarkInfo();
        ((MutualMarkInfo)localObject).a = 6L;
        ((MutualMarkInfo)localObject).b = paramExtensionInfo.praiseHotLevel;
        ((MutualMarkInfo)localObject).e = paramExtensionInfo.lastpraiseTime;
        ((MutualMarkInfo)localObject).n = paramExtensionInfo.hasRemindPraise;
        ((MutualMarkInfo)localObject).o = paramExtensionInfo.praiseAnimStartTime;
        this.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
      }
    }
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if (!TextUtils.isEmpty(paramExtensionInfo.mutual_marks_store_json)) {
      this.a = MutualMarkInfo.a(paramExtensionInfo.mutual_marks_store_json);
    } else {
      this.a = null;
    }
    d(paramExtensionInfo);
  }
  
  public void a(ExtensionInfo paramExtensionInfo, Object... paramVarArgs) {}
  
  public void b(ExtensionInfo paramExtensionInfo)
  {
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.size() > 0))
    {
      paramExtensionInfo.mutual_marks_store_json = MutualMarkInfo.a(this.a);
      return;
    }
    paramExtensionInfo.mutual_marks_store_json = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtensionMutualMarkData{mutualMarks=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.ExtensionMutualMarkData
 * JD-Core Version:    0.7.0.1
 */