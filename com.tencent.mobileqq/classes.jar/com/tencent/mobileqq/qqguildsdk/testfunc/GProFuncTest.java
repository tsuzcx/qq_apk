package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildJoinInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class GProFuncTest
{
  private static String a = "gpro_sdk_android";
  private Map<String, String> b = b();
  private String c = "33863181616406589";
  private String d = "1423262037";
  
  private void a(IAudioChannelMemberInfos paramIAudioChannelMemberInfos)
  {
    Object localObject = "";
    if (paramIAudioChannelMemberInfos != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramIAudioChannelMemberInfos.b());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramIAudioChannelMemberInfos.c());
      localObject = ((StringBuilder)localObject).toString();
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelMemberInfos： ");
    localStringBuilder.append((String)localObject);
    QLog.d(str, 2, localStringBuilder.toString());
    if ((paramIAudioChannelMemberInfos != null) && (paramIAudioChannelMemberInfos.d() != null))
    {
      paramIAudioChannelMemberInfos = paramIAudioChannelMemberInfos.d().iterator();
      while (paramIAudioChannelMemberInfos.hasNext()) {
        a((IGProUserInfo)paramIAudioChannelMemberInfos.next());
      }
    }
  }
  
  private void a(IGProChannelInfo paramIGProChannelInfo)
  {
    if (paramIGProChannelInfo == null)
    {
      QLog.d(a, 2, "IGProChannelInfo : null");
      return;
    }
    QLog.d(a, 2, "IGProChannelInfo -------------------");
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getChannelName : ");
    localStringBuilder.append(paramIGProChannelInfo.getChannelName());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getChannelUin : ");
    localStringBuilder.append(paramIGProChannelInfo.getChannelUin());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMsgNotify : ");
    localStringBuilder.append(paramIGProChannelInfo.getMyMsgNotify());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTalkPermission : ");
    localStringBuilder.append(paramIGProChannelInfo.getTalkPermission());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getType : ");
    localStringBuilder.append(paramIGProChannelInfo.getType());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGuildId : ");
    localStringBuilder.append(paramIGProChannelInfo.getGuildId());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCreatorId : ");
    localStringBuilder.append(paramIGProChannelInfo.getCreatorId());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCategoryId : ");
    localStringBuilder.append(paramIGProChannelInfo.getCategoryId());
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  private void a(IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramIGProGuildInfo == null)
    {
      QLog.d(a, 2, "IGProGuildInfo : null");
      return;
    }
    QLog.d(a, 2, "IGProGuildInfo -------------------");
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGuildName : ");
    localStringBuilder.append(paramIGProGuildInfo.getGuildName());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShowNumber : ");
    localStringBuilder.append(paramIGProGuildInfo.getShowNumber());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGuildID : ");
    localStringBuilder.append(paramIGProGuildInfo.getGuildID());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAvatarUrl : ");
    localStringBuilder.append(paramIGProGuildInfo.getAvatarUrl(0));
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDescribe : ");
    localStringBuilder.append(paramIGProGuildInfo.getProfile());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUserType : ");
    localStringBuilder.append(paramIGProGuildInfo.getUserType());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCreatorId : ");
    localStringBuilder.append(paramIGProGuildInfo.getCreatorId());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTop : ");
    localStringBuilder.append(paramIGProGuildInfo.isTop());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("isMember : ");
    localStringBuilder.append(paramIGProGuildInfo.isMember());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCoverUrl : ");
    localStringBuilder.append(paramIGProGuildInfo.getCoverUrl(1, 1));
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  private void a(IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramIGProSecurityResult == null)
    {
      QLog.d(a, 2, "IGProSecurityResult : null");
      return;
    }
    QLog.d(a, 2, "IGProSecurityResult -------------------");
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getActionCode : ");
    localStringBuilder.append(paramIGProSecurityResult.a());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getStrDetail : ");
    localStringBuilder.append(paramIGProSecurityResult.c());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getStrPrompt : ");
    localStringBuilder.append(paramIGProSecurityResult.b());
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  private void a(IGProUserInfo paramIGProUserInfo)
  {
    if (paramIGProUserInfo == null)
    {
      QLog.d(a, 2, "IGProUserInfo : null");
      return;
    }
    QLog.d(a, 2, "IGProUserInfo -------------------");
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getNickName : ");
    localStringBuilder.append(paramIGProUserInfo.c());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRemark : ");
    localStringBuilder.append(paramIGProUserInfo.b());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTID : ");
    localStringBuilder.append(paramIGProUserInfo.a());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRobotType : ");
    localStringBuilder.append(paramIGProUserInfo.f());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUserJoinTime : ");
    localStringBuilder.append(paramIGProUserInfo.e());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUserType : ");
    localStringBuilder.append(paramIGProUserInfo.d());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("isMuteSeat : ");
    localStringBuilder.append(paramIGProUserInfo.g());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("isVoiceless : ");
    localStringBuilder.append(paramIGProUserInfo.h());
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  private void a(IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    if (paramIGProUserProfileInfo == null)
    {
      QLog.d(a, 2, "IGProUserInfo : null");
      return;
    }
    QLog.d(a, 2, "IGProUserProfileInfo -------------------");
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getNickName : ");
    localStringBuilder.append(paramIGProUserProfileInfo.c());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAvatarUrl : ");
    localStringBuilder.append(paramIGProUserProfileInfo.b());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTID : ");
    localStringBuilder.append(paramIGProUserProfileInfo.a());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAge : ");
    localStringBuilder.append(paramIGProUserProfileInfo.f());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getBirthday : ");
    localStringBuilder.append(paramIGProUserProfileInfo.e());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGender : ");
    localStringBuilder.append(paramIGProUserProfileInfo.d());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCountry : ");
    localStringBuilder.append(paramIGProUserProfileInfo.g());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCity : ");
    localStringBuilder.append(paramIGProUserProfileInfo.i());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getProvince : ");
    localStringBuilder.append(paramIGProUserProfileInfo.h());
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  private void a(IGuildJoinInfo paramIGuildJoinInfo)
  {
    if (paramIGuildJoinInfo == null)
    {
      QLog.d(a, 2, "IGuildJoinInfo : null");
      return;
    }
    QLog.d(a, 2, "IGuildJoinInfo -------------------");
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGuildName : ");
    localStringBuilder.append(paramIGuildJoinInfo.b());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGuildID : ");
    localStringBuilder.append(paramIGuildJoinInfo.a());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAvatarUrl : ");
    localStringBuilder.append(paramIGuildJoinInfo.c());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getJoinSig : ");
    localStringBuilder.append(paramIGuildJoinInfo.d());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUserUin : ");
    localStringBuilder.append(paramIGuildJoinInfo.e());
    QLog.d(str, 2, localStringBuilder.toString());
    str = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUserType : ");
    localStringBuilder.append(paramIGuildJoinInfo.f());
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  private void a(AppRuntime paramAppRuntime, IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramIGProGuildInfo == null) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildlist getGuildID: ");
    localStringBuilder.append(paramIGProGuildInfo.getGuildID());
    QLog.d(str, 2, localStringBuilder.toString());
    paramAppRuntime = b(paramAppRuntime).getChannelList(paramIGProGuildInfo.getGuildID());
    if (paramAppRuntime == null) {
      return;
    }
    b(paramAppRuntime);
  }
  
  private static IGPSService b(AppRuntime paramAppRuntime)
  {
    return (IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "");
  }
  
  private Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    Field[] arrayOfField = GProFuncTest.funcname.class.getFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      localHashMap.put(String.valueOf(((Integer)localField.get(GProFuncTest.funcname.class)).intValue()), localField.getName());
      i += 1;
    }
    return localHashMap;
  }
  
  private void b(List<IGProChannelInfo> paramList)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelList size: ");
    localStringBuilder.append(paramList.size());
    QLog.d(str, 2, localStringBuilder.toString());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((IGProChannelInfo)paramList.next());
    }
  }
  
  void a(ICategoryInfo paramICategoryInfo)
  {
    QLog.d(a, 2, "ICategoryInfo -------------------");
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCategoryName : ");
    localStringBuilder.append(paramICategoryInfo.a());
    localStringBuilder.append("， ");
    localStringBuilder.append(paramICategoryInfo.b());
    QLog.d(str, 2, localStringBuilder.toString());
    paramICategoryInfo = paramICategoryInfo.c().iterator();
    while (paramICategoryInfo.hasNext()) {
      a((IGProChannelInfo)paramICategoryInfo.next());
    }
  }
  
  void a(List<ICategoryInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ICategoryInfo)paramList.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest
 * JD-Core Version:    0.7.0.1
 */