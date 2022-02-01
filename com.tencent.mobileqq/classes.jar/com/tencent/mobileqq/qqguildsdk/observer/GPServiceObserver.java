package com.tencent.mobileqq.qqguildsdk.observer;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildMemberCountInfos;
import com.tencent.mobileqq.qqguildsdk.data.ILiveChannelMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.MemberNickNameInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class GPServiceObserver
  implements Observer
{
  private Map<Integer, String> a = c();
  
  private void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【sdk-ui notify】：");
    String str;
    if (this.a.containsKey(Integer.valueOf(paramInt))) {
      str = (String)this.a.get(Integer.valueOf(paramInt));
    } else {
      str = "error";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" from ");
    localStringBuilder.append(paramString);
    QLog.d("【gpro_sdk】", 1, localStringBuilder.toString());
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    int i = ((Integer)arrayOfObject[0]).intValue();
    paramObject = (String)arrayOfObject[1];
    arrayOfObject = (Object[])arrayOfObject[2];
    if (arrayOfObject == null) {
      return;
    }
    a(i, paramObject);
    if (i != 51)
    {
      if (i != 52)
      {
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              switch (i)
              {
              default: 
                switch (i)
                {
                default: 
                  return;
                case 74: 
                  a((GuildNoticeRedPoint)arrayOfObject[0], (byte[])arrayOfObject[1]);
                  return;
                case 73: 
                  a((String)arrayOfObject[0], (String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue(), ((Integer)arrayOfObject[3]).intValue());
                  return;
                case 72: 
                  b((String)arrayOfObject[0], (String)arrayOfObject[1], (List)arrayOfObject[2]);
                  return;
                }
                a((String)arrayOfObject[0], (String)arrayOfObject[1], (List)arrayOfObject[2]);
                return;
              case 62: 
                c((String)arrayOfObject[0], (List)arrayOfObject[1]);
                return;
              case 61: 
                a((List)arrayOfObject[0]);
                return;
              }
              b((List)arrayOfObject[0]);
              return;
            case 47: 
              a((String)arrayOfObject[0], (String)arrayOfObject[1], (String)arrayOfObject[2], ((Integer)arrayOfObject[3]).intValue());
              return;
            case 46: 
              a((String)arrayOfObject[0], (String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
              return;
            case 45: 
              a((String)arrayOfObject[0], (String)arrayOfObject[1], (List)arrayOfObject[2], ((Integer)arrayOfObject[3]).intValue());
              return;
            case 44: 
              a((String)arrayOfObject[0], (String)arrayOfObject[1], (String)arrayOfObject[2], (String)arrayOfObject[3], (String)arrayOfObject[4], ((Integer)arrayOfObject[5]).intValue());
              return;
            case 43: 
              a((IGProGuildInfo)arrayOfObject[0]);
              return;
            case 42: 
              a((String)arrayOfObject[0], (String)arrayOfObject[1], (IGProClientIdentityInfo)arrayOfObject[2]);
              return;
            case 41: 
              c((String)arrayOfObject[0], (String)arrayOfObject[1], (String)arrayOfObject[2]);
              return;
            }
            a((IGuildMemberCountInfos)arrayOfObject[0]);
            return;
          case 37: 
            b((String)arrayOfObject[0], (String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
            return;
          case 36: 
            a((String)arrayOfObject[0], ((Boolean)arrayOfObject[1]).booleanValue());
            return;
          case 35: 
            paramObject = (Object[])arrayOfObject[3];
            a((String)arrayOfObject[0], (String)arrayOfObject[1], (String)arrayOfObject[2], (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
            return;
          case 34: 
            b((String)arrayOfObject[0], (String)arrayOfObject[1], (String)arrayOfObject[2]);
            return;
          case 33: 
            a((String)arrayOfObject[0], (String)arrayOfObject[1], (String)arrayOfObject[2]);
            return;
          case 32: 
            a((String)arrayOfObject[0], (String)arrayOfObject[1], (IGProUserInfo)arrayOfObject[2]);
            return;
          }
          b((String)arrayOfObject[0], (List)arrayOfObject[1]);
          return;
        case 19: 
          c((List)arrayOfObject[0]);
          return;
        case 18: 
          b((String)arrayOfObject[0]);
          return;
        case 17: 
          a((String)arrayOfObject[0], (List)arrayOfObject[1]);
          return;
        case 16: 
          a(((Integer)arrayOfObject[0]).intValue(), (String)arrayOfObject[1], (String)arrayOfObject[2], (String)arrayOfObject[3], (IGProUserProfileInfo)arrayOfObject[4]);
          return;
        case 15: 
          a((String)arrayOfObject[0], (GuildUserAvatar)arrayOfObject[1]);
          return;
        case 14: 
          a((String)arrayOfObject[0], (String)arrayOfObject[1]);
          return;
        case 13: 
          a((String)arrayOfObject[0], (String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
          return;
        case 12: 
          b((String)arrayOfObject[0], (String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
          return;
        case 11: 
          d((String)arrayOfObject[0]);
          return;
        case 10: 
          a((String)arrayOfObject[0], ((Integer)arrayOfObject[1]).intValue());
          return;
        case 9: 
          c((String)arrayOfObject[0]);
          return;
        case 8: 
          g((String)arrayOfObject[0]);
          return;
        case 7: 
          b((IGProGuildInfo)arrayOfObject[0]);
          return;
        case 6: 
          a((IGProChannelInfo)arrayOfObject[0]);
          return;
        case 5: 
          e((String)arrayOfObject[0]);
          return;
        case 4: 
          a((String)arrayOfObject[0]);
          return;
        case 3: 
          h((String)arrayOfObject[0]);
          return;
        case 2: 
          f((String)arrayOfObject[0]);
          return;
        }
        a();
        return;
      }
      a((String)arrayOfObject[0], (List)arrayOfObject[1], (List)arrayOfObject[2]);
      return;
    }
    b();
  }
  
  private Map<Integer, String> c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1), "onGuildListUpdated");
    localHashMap.put(Integer.valueOf(2), "onChannelListUpdated");
    localHashMap.put(Integer.valueOf(4), "onGuildInfoUpdated");
    localHashMap.put(Integer.valueOf(5), "onChannelInfoUpdated");
    localHashMap.put(Integer.valueOf(3), "onUserListUpdated");
    localHashMap.put(Integer.valueOf(6), "onCreateChannel");
    localHashMap.put(Integer.valueOf(7), "onCreateGuild");
    localHashMap.put(Integer.valueOf(8), "onAddGuildNotInfo");
    localHashMap.put(Integer.valueOf(43), "onAddGuildWithInfo");
    localHashMap.put(Integer.valueOf(9), "onRemoveGuild");
    localHashMap.put(Integer.valueOf(10), "onBeKickFromGuild");
    localHashMap.put(Integer.valueOf(11), "onDestoryGuild");
    localHashMap.put(Integer.valueOf(12), "onMsgRecvTypeChanged");
    localHashMap.put(Integer.valueOf(13), "onAdminChanged");
    localHashMap.put(Integer.valueOf(14), "onUserNickUpdate");
    localHashMap.put(Integer.valueOf(15), "onGetUserAvatarUrl");
    localHashMap.put(Integer.valueOf(16), "onUserProfileInfoUpdate");
    localHashMap.put(Integer.valueOf(17), "onPushChannelDestroy");
    localHashMap.put(Integer.valueOf(18), "onDeleteGuild");
    localHashMap.put(Integer.valueOf(19), "onGetFinalGuildList");
    localHashMap.put(Integer.valueOf(31), "onAudioChannelSimpleInfoUpdate");
    localHashMap.put(Integer.valueOf(32), "onAudioChannelUserAdd");
    localHashMap.put(Integer.valueOf(33), "onAudioChannelUserExit");
    localHashMap.put(Integer.valueOf(34), "onAudioChannelUserPlatSwith");
    localHashMap.put(Integer.valueOf(35), "onPushKickOutAudioChannel");
    localHashMap.put(Integer.valueOf(36), "onSetUserVoicelessToMe");
    localHashMap.put(Integer.valueOf(37), "onUserMuteSeatInGuild");
    localHashMap.put(Integer.valueOf(40), "onMemberCountUpdate");
    localHashMap.put(Integer.valueOf(41), "onGuildMemberNameUpdate");
    localHashMap.put(Integer.valueOf(42), "onGuildMemberClientIdentityUpdate");
    localHashMap.put(Integer.valueOf(74), "GUILD_NOTICE_LIST_UPDATE");
    localHashMap.put(Integer.valueOf(51), "onAppInfoListUpdated");
    localHashMap.put(Integer.valueOf(52), "onAppChnnPreInfoListUpdated");
    localHashMap.put(Integer.valueOf(44), "onLiveRoomStatusChange");
    localHashMap.put(Integer.valueOf(45), "onLiveRoomUserChange");
    localHashMap.put(Integer.valueOf(46), "onLiveChannelAnchorIdentifyChange");
    localHashMap.put(Integer.valueOf(47), "onSelfBannedSpeakChange");
    localHashMap.put(Integer.valueOf(61), "onBatchGetUserAvatarUrl");
    localHashMap.put(Integer.valueOf(60), "onBatchGuildUserNickUpdate");
    localHashMap.put(Integer.valueOf(62), "onBatchGuildMemberNameUpdate");
    localHashMap.put(Integer.valueOf(71), "onJoinChannel");
    localHashMap.put(Integer.valueOf(72), "onLeaveChannel");
    localHashMap.put(Integer.valueOf(73), "onChannelVisibleChanged");
    return localHashMap;
  }
  
  protected void a() {}
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3, IGProUserProfileInfo paramIGProUserProfileInfo) {}
  
  protected void a(GuildNoticeRedPoint paramGuildNoticeRedPoint, byte[] paramArrayOfByte) {}
  
  protected void a(IGProChannelInfo paramIGProChannelInfo) {}
  
  protected void a(IGProGuildInfo paramIGProGuildInfo) {}
  
  protected void a(IGuildMemberCountInfos paramIGuildMemberCountInfos) {}
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(String paramString, GuildUserAvatar paramGuildUserAvatar) {}
  
  protected void a(String paramString1, String paramString2) {}
  
  protected void a(String paramString1, String paramString2, int paramInt) {}
  
  protected void a(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(String paramString1, String paramString2, IGProClientIdentityInfo paramIGProClientIdentityInfo) {}
  
  protected void a(String paramString1, String paramString2, IGProUserInfo paramIGProUserInfo) {}
  
  protected void a(String paramString1, String paramString2, String paramString3) {}
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5) {}
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {}
  
  protected void a(String paramString1, String paramString2, List<String> paramList) {}
  
  protected void a(String paramString1, String paramString2, List<ILiveChannelMemberInfo> paramList, int paramInt) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void a(String paramString, List<String> paramList) {}
  
  protected void a(String paramString, List<String> paramList1, List<String> paramList2) {}
  
  @Deprecated
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(List<GuildUserAvatar> paramList) {}
  
  protected void b() {}
  
  protected void b(IGProGuildInfo paramIGProGuildInfo) {}
  
  protected void b(String paramString) {}
  
  protected void b(String paramString1, String paramString2, int paramInt) {}
  
  protected void b(String paramString1, String paramString2, String paramString3) {}
  
  protected void b(String paramString1, String paramString2, List<String> paramList) {}
  
  protected void b(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void b(String paramString, List<String> paramList) {}
  
  protected void b(List<MemberNickNameInfo> paramList) {}
  
  protected void c(String paramString) {}
  
  protected void c(String paramString1, String paramString2, String paramString3) {}
  
  protected void c(String paramString, List<MemberNickNameInfo> paramList) {}
  
  protected void c(List<String> paramList) {}
  
  protected void d(String paramString) {}
  
  protected void e(String paramString) {}
  
  protected void f(String paramString) {}
  
  protected void g(String paramString) {}
  
  protected void h(String paramString) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new GPServiceObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
 * JD-Core Version:    0.7.0.1
 */