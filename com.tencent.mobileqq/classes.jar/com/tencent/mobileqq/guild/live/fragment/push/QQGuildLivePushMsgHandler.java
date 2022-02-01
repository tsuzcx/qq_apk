package com.tencent.mobileqq.guild.live.fragment.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.live.QQGuildLiveLauncher;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGuildLivePushMsgHandler
  extends QPublicBaseFragment
{
  public static Intent a(@NonNull String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(BaseApplication.getContext(), QPublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QQGuildLivePushMsgHandler.class.getName());
    localIntent.putExtra("guild_live_channel_uin", paramString);
    localIntent.addFlags(268435456);
    return localIntent;
  }
  
  private void a(@NonNull IGProChannelInfo paramIGProChannelInfo, @NonNull IGProGuildInfo paramIGProGuildInfo)
  {
    QQGuildLiveRoomStartParams localQQGuildLiveRoomStartParams = new QQGuildLiveRoomStartParams();
    localQQGuildLiveRoomStartParams.setChannelInfo(paramIGProChannelInfo);
    localQQGuildLiveRoomStartParams.setGuildInfo(paramIGProGuildInfo);
    QQGuildLiveLauncher.a(localQQGuildLiveRoomStartParams, null, false, null);
    a();
  }
  
  private void b(@NonNull String paramString)
  {
    Object localObject = (IGPSService)b().getRuntimeService(IGPSService.class, "");
    paramString = ((IGPSService)localObject).getChannelInfo(paramString);
    if (paramString == null)
    {
      QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "channelInfo == null, ignore.");
      a();
      return;
    }
    if (paramString.getType() != 5)
    {
      QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "channel type != IChannelType.CHANNEL_TYPE_LIVE, ignore.");
      a();
      return;
    }
    localObject = ((IGPSService)localObject).getGuildInfo(paramString.getGuildId());
    if (localObject == null)
    {
      QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "guildInfo == null, ignore.");
      a();
      return;
    }
    a(paramString, (IGProGuildInfo)localObject);
  }
  
  public void a()
  {
    if (getActivity() != null)
    {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public AppRuntime b()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null)
    {
      QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "arguments == null, ignore.");
      a();
      return;
    }
    paramBundle = paramBundle.getString("guild_live_channel_uin", null);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "channelUin == null, ignore.");
      a();
      return;
    }
    b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.push.QQGuildLivePushMsgHandler
 * JD-Core Version:    0.7.0.1
 */