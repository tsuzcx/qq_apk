package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.api.IArkSecure;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.guild.forwardshare.api.IGuildShareForwardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ForwardArkH5StructOption
  extends ForwardPluginShareStructMsgOption
{
  public ForwardArkH5StructOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if ((!this.t.getBoolean("is_ark_display_share")) || (!this.t.getBoolean("forward_ark_from_h5_parse_meta_success"))) {
      super.a(paramQQCustomDialog);
    }
    return true;
  }
  
  protected boolean a(String paramString1, String paramString2, int paramInt)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = paramInt;
    localSessionInfo.b = paramString1;
    localSessionInfo.c = paramString2;
    if ((localSessionInfo.a >= 0) && (!TextUtils.isEmpty(localSessionInfo.b)))
    {
      String str1 = this.t.getString("forward_ark_app_name");
      String str2 = this.t.getString("forward_ark_app_view");
      Object localObject1 = this.t.getString("forward_ark_app_desc", "");
      String str3 = this.t.getString("forward_ark_app_meta");
      String str4 = this.t.getString("forward_ark_app_config");
      Object localObject2 = this.t.getString("forward_ark_app_prompt");
      paramString2 = "0.0.0.1";
      Map localMap = ArkAppCacheMgr.getApplicationFromManifest(str1, "0.0.0.1");
      paramString1 = paramString2;
      if (localMap != null)
      {
        paramString1 = paramString2;
        if (localMap.containsKey("version")) {
          paramString1 = (String)localMap.get("version");
        }
      }
      paramString2 = (String)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        paramString2 = String.format(HardCodeUtil.a(2131902729), new Object[] { "" });
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = "";
      }
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        if (this.t.getBoolean("forward_ark_app_direct")) {
          ReportCenter.a().a(this.q.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
        }
        paramString2 = new ArkAppMessage(paramString2, str1, (String)localObject1, str2, paramString1, str3, str4, "");
        localObject1 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, str1, this.t, paramString2);
        paramString1 = (String)localObject1;
        if (localObject1 == null) {
          paramString1 = paramString2;
        }
        localObject1 = StructMsgFactory.a(this.t);
        paramString2 = this.t.getString("forward_appId_ark_from_sdk");
        localObject2 = this.t.getString("struct_share_key_source_name");
        str1 = this.t.getString("struct_share_key_source_action_data");
        str2 = this.t.getString("struct_share_key_source_a_action_data_from_h5");
        str3 = this.t.getString("struct_share_key_source_url");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1.appId = paramString2;
          paramString1.mSourceName = ((String)localObject2);
          paramString1.mSourceActionData = str1;
          paramString1.mSource_A_ActionData = str2;
          paramString1.mSourceUrl = str3;
        }
        if (localObject1 != null)
        {
          paramInt = localSessionInfo.a;
          if ((paramInt != 1000) && (paramInt != 1004) && (paramInt != 1020)) {}
          for (paramString2 = this.q.getCurrentAccountUin();; paramString2 = localSessionInfo.c) {
            break;
          }
          localObject2 = this.q;
          str1 = this.q.getCurrentAccountUin();
          str2 = localSessionInfo.b;
          paramInt = localSessionInfo.a;
          int i = MobileQQService.seq;
          MobileQQService.seq = i + 1;
          paramString1.containStructMsg = MessageRecordFactory.c((QQAppInterface)localObject2, str1, str2, paramString2, paramInt, i, (AbsStructMsg)localObject1);
        }
        ChatActivityFacade.a(this.q, localSessionInfo, paramString1);
        return true;
      }
      if (this.t.getBoolean("forward_ark_app_direct")) {
        ReportCenter.a().a(this.q.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    if (this.t.getBoolean("forward_ark_app_direct")) {
      ReportCenter.a().a(this.q.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
    }
    return false;
  }
  
  protected void b()
  {
    Object localObject2;
    Object localObject1;
    if (this.t.getInt("uintype") == 10014)
    {
      localObject2 = this.t.getString("uin");
      String str = this.t.getString("guild_id");
      if (F() != 0) {
        localObject1 = this.A.getInputValue();
      } else {
        localObject1 = "";
      }
      this.t.putString("share_leave_message", (String)localObject1);
      ((IGuildShareForwardApi)this.q.getRuntimeService(IGuildShareForwardApi.class)).ShareForwardMsg((String)localObject2, str, this.t);
      return;
    }
    boolean bool1 = this.t.getBoolean("forward_ark_from_h5_success");
    boolean bool2 = this.t.getBoolean("forward_ark_from_h5_parse_meta_success");
    QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 1, new Object[] { "ShareArkFromH5 before sendArkMag isUrlLegal=", Boolean.valueOf(bool1), ", isMetaLegal=", Boolean.valueOf(bool2) });
    if (K())
    {
      if ((bool1) && (bool2))
      {
        ar();
        localObject1 = M().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          a(((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).groupUin, ((ResultRecord)localObject2).getUinType());
        }
      }
      super.b();
      return;
    }
    if ((bool1) && (bool2))
    {
      ar();
      o();
      return;
    }
    super.b();
  }
  
  public boolean e()
  {
    p();
    J();
    return super.e();
  }
  
  protected boolean o()
  {
    int i = this.t.getInt("uintype");
    boolean bool = a(this.t.getString("uin"), this.t.getString("troop_uin"), i);
    this.s.finish();
    return bool;
  }
  
  protected void p()
  {
    String str1 = this.t.getString("forward_ark_app_name");
    String str2 = this.t.getString("forward_ark_h5_from_normal");
    String str3 = this.t.getString("forward_ark_app_view");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      ((IArkSecure)QRoute.api(IArkSecure.class)).checkShareUrl(str1, str3, str2, new ForwardArkH5StructOption.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkH5StructOption
 * JD-Core Version:    0.7.0.1
 */