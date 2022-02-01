package com.tencent.mobileqq.gameparty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent.Callback;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Vector;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_StartGameMessage;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_TurnOverMessage;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_UpdateTeamMessage;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.InviteSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class GamePartyManager
  implements ArkAppCenterCheckEvent.Callback, Manager
{
  static int a = 3600;
  public String b;
  public int c;
  public int d;
  public long e;
  public int f;
  public long g;
  public String h;
  public int i;
  public Vector<GamePartyManager.Session> j = new Vector();
  protected Handler k = new GamePartyManager.1(this, Looper.getMainLooper());
  private WeakReference<QQAppInterface> l;
  private SharedPreferences m;
  private boolean n;
  private int o;
  private String p;
  private GamePartyNotifyCenter q = null;
  
  public GamePartyManager(QQAppInterface paramQQAppInterface)
  {
    this.l = new WeakReference(paramQQAppInterface);
    this.n = false;
    this.o = -1;
    this.c = 0;
    this.d = 0;
    this.e = 0L;
    this.f = a;
    this.g = 0L;
    this.h = "";
    this.i = 0;
    Object localObject = paramQQAppInterface.getApp();
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    this.m = ((BaseApplication)localObject).getSharedPreferences("GamePartyManger", i1);
    localObject = this.m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gamePartyInfo");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      this.b = new JSONObject((String)localObject).getString("teamId");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://openmobile.qq.com/gameteam/get_team_context?uin=");
      ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentAccountUin());
      a(((StringBuilder)localObject).toString(), new GamePartyManager.2(this));
    }
    catch (JSONException paramQQAppInterface)
    {
      label239:
      break label239;
    }
    this.n = false;
    this.q = ((GamePartyNotifyCenter)a());
    ArkAppCenterCheckEvent.a("com.tencent.qqopen.teamup", this);
  }
  
  public static int a(int paramInt)
  {
    int i1 = 0;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return 0;
        }
        return 2;
      }
      i1 = 1;
    }
    return i1;
  }
  
  private void a(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage, boolean paramBoolean)
  {
    Object localObject2 = (QQAppInterface)this.l.get();
    if (localObject2 == null) {
      return;
    }
    int i4 = paramGameTeam_TurnOverMessage.uint32_sessionType.get();
    String str3 = paramGameTeam_TurnOverMessage.str_sourceUin.get();
    String str4 = paramGameTeam_TurnOverMessage.str_actionUin.get();
    String str2 = paramGameTeam_TurnOverMessage.str_teamId.get();
    int i1 = paramGameTeam_TurnOverMessage.uint32_currentCount.get();
    int i2 = paramGameTeam_TurnOverMessage.uint32_totalCount.get();
    long l1 = paramGameTeam_TurnOverMessage.uint64_buildTeamTime.get();
    String str1 = paramGameTeam_TurnOverMessage.str_leaderUin.get();
    int i3 = paramGameTeam_TurnOverMessage.uin32_leaderStatus.get();
    Object localObject1 = null;
    if (paramGameTeam_TurnOverMessage.InviteSourceList.has()) {
      localObject1 = paramGameTeam_TurnOverMessage.InviteSourceList.get();
    }
    boolean bool2 = ((QQAppInterface)localObject2).getCurrentAccountUin().equals(str4);
    boolean bool1;
    if ((this.n) && (!TextUtils.isEmpty(this.b)) && (this.b.equals(str2))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handlePushMsg_TurnOver_BlueBar, self = ");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(", expired = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", inParty = ");
      ((StringBuilder)localObject2).append(this.n);
      ((StringBuilder)localObject2).append(", inSameParty = ");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d("GamePartyManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramBoolean)
    {
      if (bool1) {
        c();
      }
    }
    else {
      switch (paramGameTeam_TurnOverMessage.actionType.get())
      {
      default: 
      case 6: 
        if ((bool2) && (bool1))
        {
          this.j.clear();
          if (localObject1 == null)
          {
            this.j.add(new GamePartyManager.Session(this, b(i4), str3));
          }
          else
          {
            paramGameTeam_TurnOverMessage = ((List)localObject1).iterator();
            while (paramGameTeam_TurnOverMessage.hasNext())
            {
              localObject1 = (SubMsgType0xaa.InviteSource)paramGameTeam_TurnOverMessage.next();
              if ((((SubMsgType0xaa.InviteSource)localObject1).type.has()) && (((SubMsgType0xaa.InviteSource)localObject1).src.has()))
              {
                i1 = ((SubMsgType0xaa.InviteSource)localObject1).type.get();
                localObject1 = ((SubMsgType0xaa.InviteSource)localObject1).src.get();
                if ((i1 >= 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                {
                  localObject1 = new GamePartyManager.Session(this, b(i1), (String)localObject1);
                  this.j.add(localObject1);
                }
              }
            }
          }
          this.q.setChanged();
          this.q.notifyObservers(Integer.valueOf(2));
          return;
        }
        break;
      case 5: 
        if (bool2)
        {
          this.o = b(i4);
          this.p = str3;
          this.j.clear();
          if (localObject1 == null)
          {
            this.j.add(new GamePartyManager.Session(this, this.o, this.p));
          }
          else
          {
            paramGameTeam_TurnOverMessage = ((List)localObject1).iterator();
            while (paramGameTeam_TurnOverMessage.hasNext())
            {
              localObject1 = (SubMsgType0xaa.InviteSource)paramGameTeam_TurnOverMessage.next();
              if ((((SubMsgType0xaa.InviteSource)localObject1).type.has()) && (((SubMsgType0xaa.InviteSource)localObject1).src.has()))
              {
                i4 = ((SubMsgType0xaa.InviteSource)localObject1).type.get();
                localObject1 = ((SubMsgType0xaa.InviteSource)localObject1).src.get();
                if ((i4 >= 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                {
                  localObject1 = new GamePartyManager.Session(this, b(i4), (String)localObject1);
                  this.j.add(localObject1);
                }
              }
            }
          }
          this.b = str2;
          this.c = i1;
          this.d = i2;
          this.e = l1;
          this.h = str1;
          this.i = i3;
          b();
          return;
        }
        break;
      case 4: 
        if (bool2)
        {
          if (bool1) {
            c();
          }
        }
        else if (bool1)
        {
          this.c = i1;
          this.d = i2;
          this.i = i3;
          this.q.setChanged();
          this.q.notifyObservers(Integer.valueOf(2));
          return;
        }
        break;
      case 3: 
        if (bool1)
        {
          c();
          return;
        }
        break;
      case 2: 
        if (bool2)
        {
          if (bool1) {
            c();
          }
        }
        else if (bool1)
        {
          this.c = i1;
          this.d = i2;
          this.i = i3;
          this.q.setChanged();
          this.q.notifyObservers(Integer.valueOf(2));
          return;
        }
        break;
      case 1: 
        if (bool2)
        {
          this.o = b(i4);
          this.p = str3;
          this.b = str2;
          this.c = i1;
          this.d = i2;
          this.e = l1;
          this.h = str1;
          this.i = i3;
          b();
          return;
        }
        if (bool1)
        {
          this.c = i1;
          this.d = i2;
          this.i = i3;
          this.q.setChanged();
          this.q.notifyObservers(Integer.valueOf(2));
        }
        break;
      }
    }
  }
  
  public static int b(int paramInt)
  {
    int i1 = 0;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 0;
        }
        return 3000;
      }
      i1 = 1;
    }
    return i1;
  }
  
  private void b(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.l.get();
    if (localQQAppInterface == null) {
      return;
    }
    int i1 = paramGameTeam_TurnOverMessage.uint32_sessionType.get();
    Object localObject2 = paramGameTeam_TurnOverMessage.str_sourceUin.get();
    String str1 = paramGameTeam_TurnOverMessage.str_actionUin.get();
    int i2 = paramGameTeam_TurnOverMessage.actionType.get();
    String str2 = paramGameTeam_TurnOverMessage.str_teamId.get();
    boolean bool = localQQAppInterface.getCurrentAccountUin().equals(str1);
    long l1 = NetConnInfoCenter.getServerTime();
    int i3 = b(i1);
    if (bool) {
      paramGameTeam_TurnOverMessage = localQQAppInterface.getApp().getString(2131889906);
    } else if (i3 != 0)
    {
      if (i3 != 1)
      {
        if (i3 != 3000) {
          paramGameTeam_TurnOverMessage = str1;
        } else {
          paramGameTeam_TurnOverMessage = ContactUtils.a(localQQAppInterface, str1, (String)localObject2, 2, 0);
        }
      }
      else {
        paramGameTeam_TurnOverMessage = ContactUtils.a(localQQAppInterface, str1, (String)localObject2, 1, 0);
      }
    }
    else {
      paramGameTeam_TurnOverMessage = ContactUtils.a(localQQAppInterface, str1, (String)localObject2, 0, 0);
    }
    if (i2 != 1)
    {
      if (i2 != 2)
      {
        if (i2 != 3)
        {
          if (i2 != 4)
          {
            if (i2 != 5) {}
            return;
          }
          localObject1 = localQQAppInterface.getApp().getString(2131889920);
        }
        else
        {
          localObject1 = localQQAppInterface.getApp().getString(2131889912);
        }
      }
      else {
        localObject1 = localQQAppInterface.getApp().getString(2131889922);
      }
    }
    else {
      localObject1 = localQQAppInterface.getApp().getString(2131889919);
    }
    String str3 = localQQAppInterface.getApp().getString(2131889921);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramGameTeam_TurnOverMessage);
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(str3);
    paramGameTeam_TurnOverMessage = localStringBuilder.toString();
    Object localObject1 = (MessageForGrayTips)MessageRecordFactory.a(-2049);
    ((MessageForGrayTips)localObject1).init(localQQAppInterface.getAccount(), (String)localObject2, str1, paramGameTeam_TurnOverMessage, l1, -2049, i3, 0L);
    str1 = String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { localQQAppInterface.getAccount(), str2, Integer.valueOf(i1), localObject2 });
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_action", 1);
    ((Bundle)localObject2).putString("key_action_DATA", str1);
    ((Bundle)localObject2).putString("key_a_action_DATA", str1);
    ((MessageForGrayTips)localObject1).addHightlightItem(paramGameTeam_TurnOverMessage.indexOf(str3), paramGameTeam_TurnOverMessage.length(), (Bundle)localObject2);
    ((MessageForGrayTips)localObject1).isread = true;
    localQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, localQQAppInterface.getCurrentAccountUin());
    ReportCenter.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2011", "0", false);
  }
  
  private void d()
  {
    this.n = false;
    this.o = -1;
    this.p = "";
    this.b = "";
    this.c = 0;
    this.d = 0;
    this.e = 0L;
    this.g = 0L;
    this.h = "";
    this.i = 0;
    this.j.clear();
  }
  
  public Object a(int paramInt, Object paramObject)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.l.get();
    Object localObject1 = null;
    if (localQQAppInterface == null) {
      return null;
    }
    Object localObject2;
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        return Boolean.valueOf(false);
      }
      localObject2 = (Bundle)paramObject;
      paramObject = localObject1;
      if (localObject2 != null)
      {
        paramInt = ((Bundle)localObject2).getInt("uintype");
        paramObject = ((Bundle)localObject2).getString("uin");
        Object localObject3 = ((Bundle)localObject2).getString("forward_ark_app_name");
        String str1 = ((Bundle)localObject2).getString("forward_ark_app_view");
        String str2 = ((Bundle)localObject2).getString("forward_ark_app_desc");
        String str3 = ((Bundle)localObject2).getString("forward_ark_app_ver");
        String str4 = ((Bundle)localObject2).getString("forward_ark_app_prompt");
        localObject1 = ((Bundle)localObject2).getString("forward_ark_app_meta");
        localObject2 = new ArkAppMessage(str4, (String)localObject3, str2, str1, str3, (String)localObject1, ((Bundle)localObject2).getString("forward_ark_app_config"), ((Bundle)localObject2).getString("forward_ark_app_compat"));
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          localObject3 = ((JSONObject)localObject1).getJSONObject("teamup").getJSONObject("misc");
          ((JSONObject)localObject3).put("forwardUin", localQQAppInterface.getCurrentAccountUin());
          ((JSONObject)localObject3).put("forwardDstType", a(paramInt));
          ((JSONObject)localObject3).put("forwardDstUin", paramObject);
          ((ArkAppMessage)localObject2).metaList = ((JSONObject)localObject1).toString();
        }
        catch (JSONException paramObject)
        {
          paramObject.printStackTrace();
        }
        return localObject2;
      }
    }
    else
    {
      localObject1 = Boolean.valueOf(false);
      localObject2 = (MessageForArkApp)paramObject;
      paramObject = localObject1;
      if (localObject2 != null)
      {
        paramObject = localObject1;
        if (((MessageForArkApp)localObject2).ark_app_message != null) {
          try
          {
            paramObject = new JSONObject(((MessageForArkApp)localObject2).ark_app_message.metaList).getJSONObject("teamup").getJSONObject("invitation");
            paramInt = paramObject.optInt("forward");
            paramObject = paramObject.optString("leader");
            if (paramInt != 0)
            {
              if (paramInt != 1)
              {
                if (paramInt != 2) {
                  paramObject = localObject1;
                } else {
                  paramObject = Boolean.valueOf(true);
                }
              }
              else if (localQQAppInterface.getCurrentAccountUin().equals(paramObject)) {
                paramObject = Boolean.valueOf(true);
              } else {
                paramObject = Boolean.valueOf(false);
              }
            }
            else {
              paramObject = Boolean.valueOf(false);
            }
          }
          catch (JSONException paramObject)
          {
            paramObject.printStackTrace();
            paramObject = localObject1;
          }
        }
      }
    }
    return paramObject;
  }
  
  public Observable a()
  {
    if (this.q == null) {
      this.q = new GamePartyNotifyCenter();
    }
    return this.q;
  }
  
  public void a(String paramString, GamePartyManager.AsyncRequestCallback paramAsyncRequestCallback)
  {
    ThreadManager.post(new GamePartyManager.4(this, paramString, paramAsyncRequestCallback), 5, null, false);
  }
  
  protected void a(SubMsgType0xaa.GameTeam_StartGameMessage paramGameTeam_StartGameMessage, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.l.get();
    if (localQQAppInterface == null) {
      return;
    }
    if ((paramGameTeam_StartGameMessage.str_appid.has()) && (paramGameTeam_StartGameMessage.str_packageName.has()) && (paramGameTeam_StartGameMessage.str_gamedata.has()) && (paramGameTeam_StartGameMessage.str_title.has()) && (paramGameTeam_StartGameMessage.str_summary.has()) && (paramGameTeam_StartGameMessage.str_picUrl.has()) && (paramGameTeam_StartGameMessage.uint64_buildTeamTime.has()) && (paramGameTeam_StartGameMessage.uint64_createMsgTime.has()) && (paramGameTeam_StartGameMessage.uint32_platformType.has()))
    {
      Object localObject1 = paramGameTeam_StartGameMessage.str_gamedata.get().split("_");
      if (localObject1.length > 2)
      {
        localObject1 = localObject1[2];
        long l2 = paramGameTeam_StartGameMessage.uint64_buildTeamTime.get();
        long l1 = NetConnInfoCenter.getServerTime();
        if (l1 > l2) {
          l1 -= l2;
        } else {
          l1 = l2 - l1;
        }
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handlePushMsg_StartGame, createTime = ");
          ((StringBuilder)localObject2).append(l2);
          QLog.d("GamePartyManager", 2, ((StringBuilder)localObject2).toString());
        }
        if ((paramGameTeam_StartGameMessage.uint32_platformType.get() & 0x2) == 2)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[\"");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("\"]");
          localObject1 = ((StringBuilder)localObject2).toString();
          try
          {
            localObject2 = URLEncoder.encode((String)localObject1, "utf-8");
            localObject1 = localObject2;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://openmobile.qq.com/gameteam/get_team_info?uin=");
          localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
          localStringBuilder.append("&team_list=");
          localStringBuilder.append((String)localObject1);
          a(localStringBuilder.toString(), new GamePartyManager.3(this, l1, paramGameTeam_StartGameMessage, l2, paramBoolean));
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GamePartyManager", 2, "handlePushMsg_StartGame, parse gamedata failed");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GamePartyManager", 2, "handlePushMsg_StartGame, parse param failed");
    }
  }
  
  protected void a(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage)
  {
    if ((paramGameTeam_TurnOverMessage.uint32_sessionType.has()) && (paramGameTeam_TurnOverMessage.actionType.has()) && (paramGameTeam_TurnOverMessage.str_sourceUin.has()) && (paramGameTeam_TurnOverMessage.str_actionUin.has()) && (paramGameTeam_TurnOverMessage.str_teamId.has()) && (paramGameTeam_TurnOverMessage.uint32_currentCount.has()) && (paramGameTeam_TurnOverMessage.uint32_totalCount.has()) && (paramGameTeam_TurnOverMessage.uint64_buildTeamTime.has()) && (paramGameTeam_TurnOverMessage.uint64_createMsgTime.has()) && (paramGameTeam_TurnOverMessage.str_leaderUin.has()) && (paramGameTeam_TurnOverMessage.uin32_leaderStatus.has()))
    {
      long l1 = paramGameTeam_TurnOverMessage.uint64_createMsgTime.get();
      try
      {
        if (l1 < this.g)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GamePartyManager", 2, "handlePushMsg_TurnOver, msgTime before updateTime, drop it");
          }
          return;
        }
        this.g = l1;
        long l2 = paramGameTeam_TurnOverMessage.uint64_buildTeamTime.get();
        l1 = NetConnInfoCenter.getServerTime();
        if (l1 > l2) {
          l1 -= l2;
        } else {
          l1 = l2 - l1;
        }
        if (paramGameTeam_TurnOverMessage.uint32_expire.has())
        {
          this.f = paramGameTeam_TurnOverMessage.uint32_expire.get();
          if (this.f <= 0) {
            this.f = a;
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handlePushMsg_TurnOver, createTime = ");
          localStringBuilder.append(l2);
          localStringBuilder.append(", expire = ");
          localStringBuilder.append(this.f);
          localStringBuilder.append(", deltaTime = ");
          localStringBuilder.append(l1);
          QLog.d("GamePartyManager", 2, localStringBuilder.toString());
        }
        if (l1 < this.f)
        {
          a(paramGameTeam_TurnOverMessage, false);
          b(paramGameTeam_TurnOverMessage);
          return;
        }
        a(paramGameTeam_TurnOverMessage, true);
        return;
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("GamePartyManager", 2, "handlePushMsg_TurnOver, parse param failed");
    }
  }
  
  protected void a(SubMsgType0xaa.GameTeam_UpdateTeamMessage paramGameTeam_UpdateTeamMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.l.get();
    if (localQQAppInterface == null) {
      return;
    }
    String str;
    int i1;
    int i2;
    Object localObject;
    if ((paramGameTeam_UpdateTeamMessage.str_teamId.has()) && (paramGameTeam_UpdateTeamMessage.uint32_status.has()) && (paramGameTeam_UpdateTeamMessage.uint32_current_count.has()) && (paramGameTeam_UpdateTeamMessage.uint64_buildTeamTime.has()) && (paramGameTeam_UpdateTeamMessage.uint64_createMsgTime.has()) && (paramGameTeam_UpdateTeamMessage.str_leaderUin.has()) && (paramGameTeam_UpdateTeamMessage.uin32_leaderStatus.has()))
    {
      long l1 = paramGameTeam_UpdateTeamMessage.uint64_buildTeamTime.get();
      str = paramGameTeam_UpdateTeamMessage.str_teamId.get();
      i1 = paramGameTeam_UpdateTeamMessage.uint32_status.get();
      i2 = paramGameTeam_UpdateTeamMessage.uint32_current_count.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlePushMsg_UpdateTeam, teamId = ");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(", status = ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", member = ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(", createTime = ");
        ((StringBuilder)localObject).append(l1);
        QLog.d("GamePartyManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("team_id", str);
      ((JSONObject)localObject).put("status", i1);
      ((JSONObject)localObject).put("member_count", i2);
      label258:
      localObject = ((JSONObject)localObject).toString();
      try
      {
        ((IArkAPIService)QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.qqopen.teamup", "update_team_info", (String)localObject);
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        label289:
        break label289;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GamePartyManager", 2, "arkNotify failed, .so not loaded");
      }
      localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.gameparty.notify");
      ((Intent)localObject).putExtra("uin", localQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject).putExtra("teamId", str);
      localQQAppInterface.getApp().sendBroadcast((Intent)localObject);
      i2 = paramGameTeam_UpdateTeamMessage.uin32_leaderStatus.get();
      if ((this.n) && (!TextUtils.isEmpty(this.b)) && (this.b.equals(str)))
      {
        if (i1 >= 5)
        {
          c();
          return;
        }
        if ((i1 > 0) && (this.i != i2))
        {
          this.i = i2;
          this.q.setChanged();
          this.q.notifyObservers(Integer.valueOf(2));
        }
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GamePartyManager", 2, "handlePushMsg_UpdateTeam, parse param failed");
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      break label258;
    }
  }
  
  public void a(SubMsgType0xaa.MsgBody paramMsgBody, boolean paramBoolean)
  {
    if (!paramMsgBody.cmd.has()) {
      return;
    }
    if ((paramMsgBody.cmd.get() == 1) && (paramMsgBody.msg_gameTeamMsg.has()))
    {
      paramMsgBody = (SubMsgType0xaa.GameTeam_MsgBody)paramMsgBody.msg_gameTeamMsg.get();
      if (!paramMsgBody.uint32_GameTeamCmd.has()) {
        return;
      }
      int i1 = paramMsgBody.uint32_GameTeamCmd.get();
      if (i1 == 2000)
      {
        if (paramMsgBody.msg_turnOverMessage.has()) {
          a((SubMsgType0xaa.GameTeam_TurnOverMessage)paramMsgBody.msg_turnOverMessage.get());
        }
      }
      else if (i1 == 2001)
      {
        if (paramMsgBody.msg_startGameMessage.has()) {
          a((SubMsgType0xaa.GameTeam_StartGameMessage)paramMsgBody.msg_startGameMessage.get(), paramBoolean);
        }
      }
      else if ((i1 == 2002) && (!paramBoolean) && (paramMsgBody.msg_updateTeamMessage.has())) {
        a((SubMsgType0xaa.GameTeam_UpdateTeamMessage)paramMsgBody.msg_updateTeamMessage.get());
      }
    }
  }
  
  public boolean a(int paramInt, String paramString)
  {
    Object localObject = (QQAppInterface)this.l.get();
    if (localObject == null) {
      return false;
    }
    if ((this.n) && (paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
    {
      if (((QQAppInterface)localObject).getCurrentAccountUin().equals(this.h))
      {
        localObject = this.j.iterator();
        GamePartyManager.Session localSession;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localSession = (GamePartyManager.Session)((Iterator)localObject).next();
        } while ((paramInt != localSession.a) || (!paramString.equals(localSession.b)));
        return true;
      }
      if ((paramInt == this.o) && (paramString.equals(this.p))) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.k.removeMessages(1);
    Message localMessage = this.k.obtainMessage(1);
    long l2 = this.f;
    long l3 = NetConnInfoCenter.getServerTime();
    if (this.e == 0L) {
      this.e = l3;
    }
    long l4 = this.e;
    long l1 = l2;
    if (l3 > l4) {
      l1 = l2 - (l3 - l4);
    }
    if (l1 > 0L)
    {
      this.n = true;
      GamePartyNotifyCenter localGamePartyNotifyCenter = this.q;
      if (localGamePartyNotifyCenter != null)
      {
        localGamePartyNotifyCenter.setChanged();
        this.q.notifyObservers(Integer.valueOf(1));
      }
      this.k.sendMessageDelayed(localMessage, l1 * 1000L + 30000L);
    }
  }
  
  public void c()
  {
    GamePartyNotifyCenter localGamePartyNotifyCenter = this.q;
    if (localGamePartyNotifyCenter != null)
    {
      localGamePartyNotifyCenter.setChanged();
      this.q.notifyObservers(Integer.valueOf(3));
    }
    d();
    this.k.removeMessages(1);
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.l.get();
    if (localQQAppInterface == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.m.edit();
    Object localObject;
    if (this.n)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("teamId", this.b);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gamePartyInfo");
      localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
      localEditor.putString(localStringBuilder.toString(), ((JSONObject)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gamePartyInfo");
      ((StringBuilder)localObject).append(localQQAppInterface.getCurrentAccountUin());
      localEditor.putString(((StringBuilder)localObject).toString(), "");
    }
    localEditor.commit();
    ArkAppCenterCheckEvent.a("com.tencent.qqopen.teamup");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gameparty.GamePartyManager
 * JD-Core Version:    0.7.0.1
 */