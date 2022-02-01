package com.tencent.mobileqq.guild.message.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.FocusChannelReqInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class GuildFocusChannelServiceImpl
  implements IGuildFocusChannelService
{
  private static final String GUILD_FOCUS_CHANNEL_LIST_SP_NAME = "guildFocusChannelListSpName";
  private static final String TAG = "GuildFocusChannelServiceImpl";
  private AppRuntime mApp;
  private String mCurActiveChannelId;
  private String mCurActiveGuildId;
  private HashSet<String> mCurFocusChanelIdSet = new HashSet();
  private HashSet<String> mHugeChannelIdSet = new HashSet();
  
  public String getCurActiveChannelId()
  {
    return this.mCurActiveChannelId;
  }
  
  public boolean isHugeChannel(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject = this.mHugeChannelIdSet;
    if ((localObject != null) && (((HashSet)localObject).contains(paramString)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isHugeChannel, channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isHugeChannel = true");
      QLog.d("GuildFocusChannelServiceImpl", 2, ((StringBuilder)localObject).toString());
      return true;
    }
    int i = this.mApp.getApp().getSharedPreferences("guildFocusChannelListSpName", 0).getInt(paramString, 0);
    if (i == 1) {
      this.mHugeChannelIdSet.add(paramString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isHugeChannel, channelId = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", hugeFlag = ");
    ((StringBuilder)localObject).append(i);
    QLog.d("GuildFocusChannelServiceImpl", 2, ((StringBuilder)localObject).toString());
    if (i == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void updateCurChannelId(String paramString1, String paramString2)
  {
    this.mCurActiveGuildId = paramString1;
    this.mCurActiveChannelId = paramString2;
  }
  
  public void updateFocusChannel(HashSet<String> paramHashSet)
  {
    this.mCurFocusChanelIdSet = paramHashSet;
    boolean bool = isHugeChannel(this.mCurActiveChannelId);
    Object localObject;
    if (bool)
    {
      paramHashSet = this.mCurFocusChanelIdSet;
      if ((paramHashSet == null) || (!paramHashSet.contains(this.mCurActiveChannelId)))
      {
        paramHashSet = new ArrayList();
        paramHashSet.add(this.mCurActiveChannelId);
        paramHashSet = new FocusChannelReqInfo(this.mCurActiveGuildId, paramHashSet);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramHashSet);
        ((IGPSService)this.mApp.getRuntimeService(IGPSService.class, "")).setFocusChannel((List)localObject, new GuildFocusChannelServiceImpl.1(this));
        break label168;
      }
    }
    paramHashSet = this.mCurFocusChanelIdSet;
    if ((paramHashSet != null) && (paramHashSet.size() > 0))
    {
      paramHashSet = new ArrayList();
      ((IGPSService)this.mApp.getRuntimeService(IGPSService.class, "")).setFocusChannel(paramHashSet, new GuildFocusChannelServiceImpl.2(this));
    }
    label168:
    if (QLog.isColorLevel())
    {
      paramHashSet = new StringBuilder();
      paramHashSet.append("updateFocusChannel, channelId = ");
      paramHashSet.append(this.mCurActiveChannelId);
      paramHashSet.append(", isHuge = ");
      paramHashSet.append(bool);
      paramHashSet.append(", mCurFocusChanelIdSet size = ");
      localObject = this.mCurFocusChanelIdSet;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((HashSet)localObject).size();
      }
      paramHashSet.append(i);
      QLog.d("GuildFocusChannelServiceImpl", 2, paramHashSet.toString());
    }
  }
  
  public void updateHugeChannel(HashSet<String> paramHashSet)
  {
    if (paramHashSet == null) {
      return;
    }
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      String str = (String)paramHashSet.next();
      if (str != null)
      {
        this.mApp.getApp().getSharedPreferences("guildFocusChannelListSpName", 0).edit().putInt(str, 1);
        this.mHugeChannelIdSet.add(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildFocusChannelServiceImpl
 * JD-Core Version:    0.7.0.1
 */