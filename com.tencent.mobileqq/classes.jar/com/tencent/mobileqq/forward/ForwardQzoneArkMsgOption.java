package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.report.ReportCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForwardQzoneArkMsgOption
  extends ForwardBaseOption
{
  public ForwardQzoneArkMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType())))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if (!this.t.getBoolean("is_ark_display_share")) {
      super.a(paramQQCustomDialog);
    }
    return true;
  }
  
  protected boolean a(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = paramInt;
    localSessionInfo.b = paramString1;
    localSessionInfo.c = paramString2;
    if ((localSessionInfo.a >= 0) && (!TextUtils.isEmpty(localSessionInfo.b)))
    {
      Object localObject2 = this.t.getString("forward_ark_app_name");
      String str2 = this.t.getString("forward_ark_app_view");
      String str3 = this.t.getString("forward_ark_app_meta");
      String str4 = this.t.getString("forward_ark_app_config");
      String str5 = this.t.getString("forward_ark_app_prompt");
      String str1 = "0.0.0.1";
      Map localMap = ArkAppCacheMgr.getApplicationFromManifest((String)localObject2, "0.0.0.1");
      paramString2 = null;
      Object localObject1 = str1;
      if (localMap != null)
      {
        if (localMap.containsKey("desc")) {
          paramString1 = (String)localMap.get("desc");
        } else {
          paramString1 = "";
        }
        localObject1 = str1;
        paramString2 = paramString1;
        if (localMap.containsKey("version"))
        {
          localObject1 = (String)localMap.get("version");
          paramString2 = paramString1;
        }
      }
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = (String)localObject2;
      } else {
        paramString1 = paramString2;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str2)))
      {
        if (this.t.getBoolean("forward_ark_app_direct")) {
          ReportCenter.a().a(this.q.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
        }
        paramString2 = new ArkAppMessage(str5, (String)localObject2, paramString1, str2, (String)localObject1, str3, str4, "");
        localObject1 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, (String)localObject2, this.t, paramString2);
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
        paramInt = this.t.getInt("KEY_MSG_FORWARD_ID");
        ChatActivityFacade.a(this.q, localSessionInfo, paramString1, paramInt);
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
  
  protected void c()
  {
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
  }
  
  public boolean e()
  {
    super.e();
    if (this.t.getBoolean("forward_ark_app_direct"))
    {
      o();
      this.s.finish();
    }
    return true;
  }
  
  protected boolean f()
  {
    if (K())
    {
      Iterator localIterator = M().iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        a(localResultRecord.uin, localResultRecord.getUinType(), localResultRecord.groupUin);
      }
      return super.f();
    }
    o();
    return super.f();
  }
  
  public String n()
  {
    if (TextUtils.isEmpty(this.u))
    {
      this.u = this.t.getString("forward_ark_app_prompt");
      if (TextUtils.isEmpty(this.u)) {
        this.u = this.t.getString("forward_ark_app_desc");
      }
    }
    return this.u;
  }
  
  protected boolean o()
  {
    int i = this.t.getInt("uintype");
    return a(this.t.getString("uin"), i, this.t.getString("troop_uin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQzoneArkMsgOption
 * JD-Core Version:    0.7.0.1
 */