package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.GuildMemberClientIdentityUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class NickLayoutGameItem
  extends AbsGuildNickLayoutItem
{
  protected TextView c;
  
  public NickLayoutGameItem(Context paramContext, AppRuntime paramAppRuntime)
  {
    super(paramContext, paramAppRuntime);
  }
  
  private void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_otherapp_id", paramString);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementParams(this.c, localHashMap);
  }
  
  public View a()
  {
    this.c = ((TextView)LayoutInflater.from(this.a).inflate(2131624976, null));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementReport(this.c, "em_sgrp_aio_otherapp_identity", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    return this.c;
  }
  
  public void a(AbsGuildNickLayoutItem.Data paramData)
  {
    if (paramData != null)
    {
      if (paramData.b == null) {
        return;
      }
      String str1 = paramData.b.getExtInfoFromExtStr("GUILD_ID");
      String str2 = paramData.b.senderuin;
      if (TextUtils.isEmpty(str1))
      {
        this.c.setVisibility(8);
        QLog.w("NickLayoutGameItem", 1, "guildId is null!");
        return;
      }
      if (!TextUtils.equals(str2, (String)this.c.getTag()))
      {
        this.c.setVisibility(8);
        this.c.setTag(str2);
      }
      Object localObject1 = this.b;
      paramData = "";
      localObject1 = (IGPSService)((AppRuntime)localObject1).getRuntimeService(IGPSService.class, "");
      Object localObject2 = ((IGPSService)localObject1).getGuildInfo(str1);
      if (localObject2 == null)
      {
        this.c.setVisibility(8);
        paramData = new StringBuilder();
        paramData.append("guildInfo is null! guildId=");
        paramData.append(str1);
        QLog.w("NickLayoutGameItem", 1, paramData.toString());
        return;
      }
      localObject2 = ((IGPSService)localObject1).getGuildMemberClientIdentity(str1, ((IGProGuildInfo)localObject2).getClientId(), str2);
      if (!GuildMemberClientIdentityUtils.a((IGProClientIdentityInfo)localObject2))
      {
        this.c.setVisibility(8);
      }
      else
      {
        a(((IGProClientIdentityInfo)localObject2).a());
        this.c.setText(((IGProClientIdentityInfo)localObject2).b());
        this.c.setVisibility(0);
      }
      if (QLog.isDebugVersion())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onLoadUserProfileInfo. guildId=");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(" tid=");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(" app desc=");
        if (localObject2 != null) {
          paramData = ((IGProClientIdentityInfo)localObject2).b();
        }
        ((StringBuilder)localObject1).append(paramData);
        QLog.d("NickLayoutGameItem", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public ViewGroup.LayoutParams b()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = ViewUtils.dpToPx(4.0F);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.NickLayoutGameItem
 * JD-Core Version:    0.7.0.1
 */