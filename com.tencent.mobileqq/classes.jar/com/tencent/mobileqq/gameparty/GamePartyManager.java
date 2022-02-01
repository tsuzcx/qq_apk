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
  static int jdField_a_of_type_Int = 3600;
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  protected Handler a;
  private GamePartyNotifyCenter jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter = null;
  public String a;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  public Vector<GamePartyManager.Session> a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public long b;
  public String b;
  public int c;
  private String c;
  public int d;
  public int e;
  private int f;
  
  public GamePartyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidOsHandler = new GamePartyManager.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
    this.f = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.d = jdField_a_of_type_Int;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.e = 0;
    Object localObject = paramQQAppInterface.getApp();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = ((BaseApplication)localObject).getSharedPreferences("GamePartyManger", i);
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gamePartyInfo");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject((String)localObject).getString("teamId");
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter = ((GamePartyNotifyCenter)a());
    ArkAppCenterCheckEvent.a("com.tencent.qqopen.teamup", this);
  }
  
  public static int a(int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return 0;
        }
        return 2;
      }
      i = 1;
    }
    return i;
  }
  
  private void a(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage, boolean paramBoolean)
  {
    Object localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return;
    }
    int m = paramGameTeam_TurnOverMessage.uint32_sessionType.get();
    String str3 = paramGameTeam_TurnOverMessage.str_sourceUin.get();
    String str4 = paramGameTeam_TurnOverMessage.str_actionUin.get();
    String str2 = paramGameTeam_TurnOverMessage.str_teamId.get();
    int i = paramGameTeam_TurnOverMessage.uint32_currentCount.get();
    int j = paramGameTeam_TurnOverMessage.uint32_totalCount.get();
    long l = paramGameTeam_TurnOverMessage.uint64_buildTeamTime.get();
    String str1 = paramGameTeam_TurnOverMessage.str_leaderUin.get();
    int k = paramGameTeam_TurnOverMessage.uin32_leaderStatus.get();
    Object localObject1 = null;
    if (paramGameTeam_TurnOverMessage.InviteSourceList.has()) {
      localObject1 = paramGameTeam_TurnOverMessage.InviteSourceList.get();
    }
    boolean bool2 = ((QQAppInterface)localObject2).getCurrentAccountUin().equals(str4);
    boolean bool1;
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(str2))) {
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
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject2).append(", inSameParty = ");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d("GamePartyManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramBoolean)
    {
      if (bool1) {
        b();
      }
    }
    else {
      switch (paramGameTeam_TurnOverMessage.actionType.get())
      {
      default: 
      case 6: 
        if ((bool2) && (bool1))
        {
          this.jdField_a_of_type_JavaUtilVector.clear();
          if (localObject1 == null)
          {
            this.jdField_a_of_type_JavaUtilVector.add(new GamePartyManager.Session(this, b(m), str3));
          }
          else
          {
            paramGameTeam_TurnOverMessage = ((List)localObject1).iterator();
            while (paramGameTeam_TurnOverMessage.hasNext())
            {
              localObject1 = (SubMsgType0xaa.InviteSource)paramGameTeam_TurnOverMessage.next();
              if ((((SubMsgType0xaa.InviteSource)localObject1).type.has()) && (((SubMsgType0xaa.InviteSource)localObject1).src.has()))
              {
                i = ((SubMsgType0xaa.InviteSource)localObject1).type.get();
                localObject1 = ((SubMsgType0xaa.InviteSource)localObject1).src.get();
                if ((i >= 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                {
                  localObject1 = new GamePartyManager.Session(this, b(i), (String)localObject1);
                  this.jdField_a_of_type_JavaUtilVector.add(localObject1);
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
          return;
        }
        break;
      case 5: 
        if (bool2)
        {
          this.f = b(m);
          this.jdField_c_of_type_JavaLangString = str3;
          this.jdField_a_of_type_JavaUtilVector.clear();
          if (localObject1 == null)
          {
            this.jdField_a_of_type_JavaUtilVector.add(new GamePartyManager.Session(this, this.f, this.jdField_c_of_type_JavaLangString));
          }
          else
          {
            paramGameTeam_TurnOverMessage = ((List)localObject1).iterator();
            while (paramGameTeam_TurnOverMessage.hasNext())
            {
              localObject1 = (SubMsgType0xaa.InviteSource)paramGameTeam_TurnOverMessage.next();
              if ((((SubMsgType0xaa.InviteSource)localObject1).type.has()) && (((SubMsgType0xaa.InviteSource)localObject1).src.has()))
              {
                m = ((SubMsgType0xaa.InviteSource)localObject1).type.get();
                localObject1 = ((SubMsgType0xaa.InviteSource)localObject1).src.get();
                if ((m >= 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                {
                  localObject1 = new GamePartyManager.Session(this, b(m), (String)localObject1);
                  this.jdField_a_of_type_JavaUtilVector.add(localObject1);
                }
              }
            }
          }
          this.jdField_a_of_type_JavaLangString = str2;
          this.jdField_b_of_type_Int = i;
          this.jdField_c_of_type_Int = j;
          this.jdField_a_of_type_Long = l;
          this.jdField_b_of_type_JavaLangString = str1;
          this.e = k;
          a();
          return;
        }
        break;
      case 4: 
        if (bool2)
        {
          if (bool1) {
            b();
          }
        }
        else if (bool1)
        {
          this.jdField_b_of_type_Int = i;
          this.jdField_c_of_type_Int = j;
          this.e = k;
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
          return;
        }
        break;
      case 3: 
        if (bool1)
        {
          b();
          return;
        }
        break;
      case 2: 
        if (bool2)
        {
          if (bool1) {
            b();
          }
        }
        else if (bool1)
        {
          this.jdField_b_of_type_Int = i;
          this.jdField_c_of_type_Int = j;
          this.e = k;
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
          return;
        }
        break;
      case 1: 
        if (bool2)
        {
          this.f = b(m);
          this.jdField_c_of_type_JavaLangString = str3;
          this.jdField_a_of_type_JavaLangString = str2;
          this.jdField_b_of_type_Int = i;
          this.jdField_c_of_type_Int = j;
          this.jdField_a_of_type_Long = l;
          this.jdField_b_of_type_JavaLangString = str1;
          this.e = k;
          a();
          return;
        }
        if (bool1)
        {
          this.jdField_b_of_type_Int = i;
          this.jdField_c_of_type_Int = j;
          this.e = k;
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
        }
        break;
      }
    }
  }
  
  public static int b(int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 0;
        }
        return 3000;
      }
      i = 1;
    }
    return i;
  }
  
  private void b(SubMsgType0xaa.GameTeam_TurnOverMessage paramGameTeam_TurnOverMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    int i = paramGameTeam_TurnOverMessage.uint32_sessionType.get();
    Object localObject2 = paramGameTeam_TurnOverMessage.str_sourceUin.get();
    String str1 = paramGameTeam_TurnOverMessage.str_actionUin.get();
    int j = paramGameTeam_TurnOverMessage.actionType.get();
    String str2 = paramGameTeam_TurnOverMessage.str_teamId.get();
    boolean bool = localQQAppInterface.getCurrentAccountUin().equals(str1);
    long l = NetConnInfoCenter.getServerTime();
    int k = b(i);
    if (bool) {
      paramGameTeam_TurnOverMessage = localQQAppInterface.getApp().getString(2131692802);
    } else if (k != 0)
    {
      if (k != 1)
      {
        if (k != 3000) {
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
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 5) {}
            return;
          }
          localObject1 = localQQAppInterface.getApp().getString(2131692816);
        }
        else
        {
          localObject1 = localQQAppInterface.getApp().getString(2131692808);
        }
      }
      else {
        localObject1 = localQQAppInterface.getApp().getString(2131692818);
      }
    }
    else {
      localObject1 = localQQAppInterface.getApp().getString(2131692815);
    }
    String str3 = localQQAppInterface.getApp().getString(2131692817);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramGameTeam_TurnOverMessage);
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(str3);
    paramGameTeam_TurnOverMessage = localStringBuilder.toString();
    Object localObject1 = (MessageForGrayTips)MessageRecordFactory.a(-2049);
    ((MessageForGrayTips)localObject1).init(localQQAppInterface.getAccount(), (String)localObject2, str1, paramGameTeam_TurnOverMessage, l, -2049, k, 0L);
    str1 = String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { localQQAppInterface.getAccount(), str2, Integer.valueOf(i), localObject2 });
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_action", 1);
    ((Bundle)localObject2).putString("key_action_DATA", str1);
    ((Bundle)localObject2).putString("key_a_action_DATA", str1);
    ((MessageForGrayTips)localObject1).addHightlightItem(paramGameTeam_TurnOverMessage.indexOf(str3), paramGameTeam_TurnOverMessage.length(), (Bundle)localObject2);
    ((MessageForGrayTips)localObject1).isread = true;
    localQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, localQQAppInterface.getCurrentAccountUin());
    ReportCenter.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2011", "0", false);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.f = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.e = 0;
    this.jdField_a_of_type_JavaUtilVector.clear();
  }
  
  public Object a(int paramInt, Object paramObject)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
    if (this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter = new GamePartyNotifyCenter();
    }
    return this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    long l2 = this.d;
    long l3 = NetConnInfoCenter.getServerTime();
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = l3;
    }
    long l4 = this.jdField_a_of_type_Long;
    long l1 = l2;
    if (l3 > l4) {
      l1 = l2 - (l3 - l4);
    }
    if (l1 > 0L)
    {
      this.jdField_a_of_type_Boolean = true;
      GamePartyNotifyCenter localGamePartyNotifyCenter = this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter;
      if (localGamePartyNotifyCenter != null)
      {
        localGamePartyNotifyCenter.setChanged();
        this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(1));
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1 * 1000L + 30000L);
    }
  }
  
  public void a(String paramString, GamePartyManager.AsyncRequestCallback paramAsyncRequestCallback)
  {
    ThreadManager.post(new GamePartyManager.4(this, paramString, paramAsyncRequestCallback), 5, null, false);
  }
  
  protected void a(SubMsgType0xaa.GameTeam_StartGameMessage paramGameTeam_StartGameMessage, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
        if (l1 < this.jdField_b_of_type_Long)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GamePartyManager", 2, "handlePushMsg_TurnOver, msgTime before updateTime, drop it");
          }
          return;
        }
        this.jdField_b_of_type_Long = l1;
        long l2 = paramGameTeam_TurnOverMessage.uint64_buildTeamTime.get();
        l1 = NetConnInfoCenter.getServerTime();
        if (l1 > l2) {
          l1 -= l2;
        } else {
          l1 = l2 - l1;
        }
        if (paramGameTeam_TurnOverMessage.uint32_expire.has())
        {
          this.d = paramGameTeam_TurnOverMessage.uint32_expire.get();
          if (this.d <= 0) {
            this.d = jdField_a_of_type_Int;
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handlePushMsg_TurnOver, createTime = ");
          localStringBuilder.append(l2);
          localStringBuilder.append(", expire = ");
          localStringBuilder.append(this.d);
          localStringBuilder.append(", deltaTime = ");
          localStringBuilder.append(l1);
          QLog.d("GamePartyManager", 2, localStringBuilder.toString());
        }
        if (l1 < this.d)
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
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    String str;
    int i;
    int j;
    Object localObject;
    if ((paramGameTeam_UpdateTeamMessage.str_teamId.has()) && (paramGameTeam_UpdateTeamMessage.uint32_status.has()) && (paramGameTeam_UpdateTeamMessage.uint32_current_count.has()) && (paramGameTeam_UpdateTeamMessage.uint64_buildTeamTime.has()) && (paramGameTeam_UpdateTeamMessage.uint64_createMsgTime.has()) && (paramGameTeam_UpdateTeamMessage.str_leaderUin.has()) && (paramGameTeam_UpdateTeamMessage.uin32_leaderStatus.has()))
    {
      long l = paramGameTeam_UpdateTeamMessage.uint64_buildTeamTime.get();
      str = paramGameTeam_UpdateTeamMessage.str_teamId.get();
      i = paramGameTeam_UpdateTeamMessage.uint32_status.get();
      j = paramGameTeam_UpdateTeamMessage.uint32_current_count.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlePushMsg_UpdateTeam, teamId = ");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(", status = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", member = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", createTime = ");
        ((StringBuilder)localObject).append(l);
        QLog.d("GamePartyManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("team_id", str);
      ((JSONObject)localObject).put("status", i);
      ((JSONObject)localObject).put("member_count", j);
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
      j = paramGameTeam_UpdateTeamMessage.uin32_leaderStatus.get();
      if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(str)))
      {
        if (i >= 5)
        {
          b();
          return;
        }
        if ((i > 0) && (this.e != j))
        {
          this.e = j;
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.setChanged();
          this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(2));
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
      int i = paramMsgBody.uint32_GameTeamCmd.get();
      if (i == 2000)
      {
        if (paramMsgBody.msg_turnOverMessage.has()) {
          a((SubMsgType0xaa.GameTeam_TurnOverMessage)paramMsgBody.msg_turnOverMessage.get());
        }
      }
      else if (i == 2001)
      {
        if (paramMsgBody.msg_startGameMessage.has()) {
          a((SubMsgType0xaa.GameTeam_StartGameMessage)paramMsgBody.msg_startGameMessage.get(), paramBoolean);
        }
      }
      else if ((i == 2002) && (!paramBoolean) && (paramMsgBody.msg_updateTeamMessage.has())) {
        a((SubMsgType0xaa.GameTeam_UpdateTeamMessage)paramMsgBody.msg_updateTeamMessage.get());
      }
    }
  }
  
  public boolean a(int paramInt, String paramString)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
    {
      if (((QQAppInterface)localObject).getCurrentAccountUin().equals(this.jdField_b_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_JavaUtilVector.iterator();
        GamePartyManager.Session localSession;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localSession = (GamePartyManager.Session)((Iterator)localObject).next();
        } while ((paramInt != localSession.jdField_a_of_type_Int) || (!paramString.equals(localSession.jdField_a_of_type_JavaLangString)));
        return true;
      }
      if ((paramInt == this.f) && (paramString.equals(this.jdField_c_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    GamePartyNotifyCenter localGamePartyNotifyCenter = this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter;
    if (localGamePartyNotifyCenter != null)
    {
      localGamePartyNotifyCenter.setChanged();
      this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyNotifyCenter.notifyObservers(Integer.valueOf(3));
    }
    c();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("teamId", this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gameparty.GamePartyManager
 * JD-Core Version:    0.7.0.1
 */