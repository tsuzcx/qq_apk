package com.tencent.mobileqq.managers;

import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.recent.msgbox.RecentUserCacheHelper;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxObserver;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.receiver.TempGameMsgSettingReceiver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TempMsgInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class TempMsgManager
  implements Manager
{
  private final String[] a = { "temp_msg_setting_consult_", "temp_msg_setting_contact_", "temp_msg_setting_troop_", "temp_msg_setting_circle_v2", "temp_msg_setting_company_" };
  private final List<String> b = new ArrayList();
  private QQAppInterface c;
  private String d;
  private Map<String, Boolean> e = new HashMap(8);
  private Map<String, Boolean> f = new HashMap(8);
  private TempMsgManager.OnTempMsgSettingChangeListener g;
  private EntityManager h;
  private TempGameMsgSettingReceiver i;
  
  public TempMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.d = paramQQAppInterface.getCurrentUin();
    this.e.clear();
    this.f.clear();
    this.h = this.c.getEntityManagerFactory().createEntityManager();
    this.i = new TempGameMsgSettingReceiver(this.c);
    c();
    d();
  }
  
  private DialogInterface.OnClickListener a(BaseChatPie paramBaseChatPie, short paramShort)
  {
    return new TempMsgManager.2(this, paramBaseChatPie, paramShort);
  }
  
  private short a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      return 2;
    }
    if (paramBoolean1) {
      return 0;
    }
    if (paramBoolean2) {
      return 3;
    }
    return 1;
  }
  
  private void a(SessionInfo paramSessionInfo, short paramShort, String paramString, int paramInt, BaseChatPie paramBaseChatPie)
  {
    if (!a(f(paramShort)))
    {
      paramSessionInfo = String.format(this.c.getApplication().getResources().getString(2131917146), new Object[] { paramString, paramString });
      paramSessionInfo = DialogUtil.a(paramBaseChatPie.e, 230, HardCodeUtil.a(2131912135), paramSessionInfo, 2131917144, 2131917145, a(paramBaseChatPie, paramShort), a(paramBaseChatPie, paramShort));
      paramSessionInfo.setOnCancelListener(new TempMsgManager.1(this, paramBaseChatPie));
      paramSessionInfo.setCanceledOnTouchOutside(false);
      paramSessionInfo.show();
      ReportController.b(this.c, "dc00898", "", "", "0X8009977", "0X8009977", d(paramShort), d(paramShort), "", "", "", "");
      return;
    }
    if ((a(paramSessionInfo)) && (a(f(paramShort), paramSessionInfo))) {
      a(paramSessionInfo, paramString, paramInt, paramShort);
    }
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = this.c.getMessageFacade().o(paramSessionInfo.b, paramSessionInfo.a);
    int j = paramSessionInfo.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (j > 0)
    {
      j = paramSessionInfo.size();
      paramSessionInfo = paramSessionInfo.iterator();
      while (paramSessionInfo.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramSessionInfo.next();
        if (localChatMessage.isSend()) {
          return false;
        }
        if (localChatMessage.senderuin == null) {}
        while ((localChatMessage.senderuin.compareTo(this.c.getCurrentUin()) == 0) || (localChatMessage.msgtype == -1034))
        {
          j -= 1;
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TempMsgManager", 2, localChatMessage.toString());
        }
      }
      bool1 = bool2;
      if (j > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.c.getApplication());
    boolean bool = e(paramString);
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(this.d);
      localStringBuilder.append("_setting");
      return ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), bool);
    }
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(this.d);
      localStringBuilder.append("_show");
      bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), bool);
      if (bool)
      {
        localObject = ((SharedPreferences)localObject).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(this.d);
        localStringBuilder.append("_show");
        ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).apply();
      }
      return bool;
    }
    return false;
  }
  
  private int b(SessionInfo paramSessionInfo)
  {
    Object localObject = this.c.getMessageFacade().o(paramSessionInfo.b, paramSessionInfo.a);
    if ((1000 != paramSessionInfo.a) && (1004 != paramSessionInfo.a) && (1022 != paramSessionInfo.a)) {
      localObject = ChatActivityUtils.a((List)localObject, paramSessionInfo, this.c);
    } else {
      localObject = ChatActivityUtils.b((List)localObject, paramSessionInfo, this.c);
    }
    if (localObject == null) {
      return paramSessionInfo.a;
    }
    return ((MessageRecord)localObject).istroop;
  }
  
  private void c()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_toggle_change");
    BaseApplicationImpl.getApplication().registerReceiver(this.i, localIntentFilter);
  }
  
  private boolean c(String paramString)
  {
    if (this.f.containsKey(paramString)) {
      return ((Boolean)this.f.get(paramString)).booleanValue();
    }
    boolean bool = d(paramString);
    this.f.put(paramString, Boolean.valueOf(bool));
    return bool;
  }
  
  private void d()
  {
    this.b.add("temp_msg_setting_circle_v2");
  }
  
  private boolean d(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.c.getApplication());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(this.d);
    localStringBuilder.append("_in_box_setting");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private boolean e(String paramString)
  {
    return this.b.contains(paramString) ^ true;
  }
  
  private String f(short paramShort)
  {
    if (paramShort != -23312)
    {
      if (paramShort != -23168)
      {
        if (paramShort != -23166)
        {
          if (paramShort != -23161)
          {
            if (paramShort != -23158)
            {
              if ((paramShort != -20457) && (paramShort != -20455))
              {
                switch (paramShort)
                {
                default: 
                  switch (paramShort)
                  {
                  default: 
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("getTypeStringFromType failed ");
                    localStringBuilder.append(paramShort);
                    throw new RuntimeException(localStringBuilder.toString());
                  }
                case -23308: 
                  return "temp_msg_setting_troop_";
                case -23309: 
                  return "temp_msg_setting_consult_";
                }
                return "temp_msg_setting_contact_";
              }
              return "temp_msg_setting_company_";
            }
            return "temp_msg_setting_game_buddy_";
          }
          return "temp_msg_setting_audio_room";
        }
        return "temp_msg_setting_interest_v2";
      }
      return "temp_msg_setting_circle_v2";
    }
    return "temp_msg_setting_nearby_";
  }
  
  private short g(short paramShort)
  {
    if (paramShort != -20457)
    {
      switch (paramShort)
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getInBoxTypeByBlockType failed ");
        localStringBuilder.append(paramShort);
        throw new RuntimeException(localStringBuilder.toString());
      case -23308: 
        return -20461;
      case -23309: 
        return -20459;
      }
      return -20460;
    }
    return -20455;
  }
  
  public String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "";
        }
        return "0X800BB8D";
      }
      return "0X800BB8C";
    }
    return "0X800BB8B";
  }
  
  public Map<String, Boolean> a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.c.getApplication());
    String[] arrayOfString = this.a;
    int k = arrayOfString.length;
    int j = 0;
    while (j < k)
    {
      String str = arrayOfString[j];
      if (!this.e.containsKey(str))
      {
        boolean bool = e(str);
        Map localMap = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(this.d);
        localStringBuilder.append("_setting");
        localMap.put(str, Boolean.valueOf(localSharedPreferences.getBoolean(localStringBuilder.toString(), bool)));
      }
      j += 1;
    }
    return this.e;
  }
  
  public void a(SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterChat");
      localStringBuilder.append(paramSessionInfo.a);
      QLog.d("TempMsgManager", 2, localStringBuilder.toString());
    }
    int k = paramSessionInfo.a;
    int j = k;
    if (k == 1000) {
      j = b(paramSessionInfo);
    }
    if (j != 1000) {
      if (j != 1001)
      {
        if ((j == 1009) || (j == 1010) || (j == 1020)) {
          return;
        }
        if (j != 10002)
        {
          if (j == 10004) {
            return;
          }
          if (j != 10008) {
            if (j != 10010) {
              if (j != 1024) {
                if (j == 1025) {
                  return;
                }
              }
            }
          }
        }
      }
    }
    switch (j)
    {
    default: 
    case 1006: 
      a(paramSessionInfo, (short)-23310, HardCodeUtil.a(2131912132), j, paramBaseChatPie);
      return;
    case 1005: 
      a(paramSessionInfo, (short)-23309, "QQ咨询", j, paramBaseChatPie);
      return;
      if (((ITempMsgBoxManager)this.c.getRuntimeService(ITempMsgBoxManager.class, "")).configContains(1024))
      {
        a(paramSessionInfo, (short)-20457, HardCodeUtil.a(2131917141), j, paramBaseChatPie);
        return;
        a(paramSessionInfo, (short)-23161, HardCodeUtil.a(2131891942), j, paramBaseChatPie);
        return;
        a(paramSessionInfo, (short)-23168, HardCodeUtil.a(2131916998), j, paramBaseChatPie);
        return;
        a(paramSessionInfo, (short)-23166, HardCodeUtil.a(2131912133), j, paramBaseChatPie);
        return;
      }
      break;
    case 1003: 
      a(paramSessionInfo, (short)-23312, HardCodeUtil.a(2131912131), j, paramBaseChatPie);
      return;
      a(paramSessionInfo, (short)-23308, HardCodeUtil.a(2131912134), j, paramBaseChatPie);
    }
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, int paramInt, short paramShort)
  {
    Object localObject2;
    if (paramInt == 1000)
    {
      paramString = ContactUtils.i(this.c, paramSessionInfo.d);
      localObject2 = ContactUtils.a(this.c, paramSessionInfo.d, true);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTroopNickName:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" new From:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("TempMsgManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = String.format(this.c.getApplication().getResources().getString(2131917158), new Object[] { localObject2 });
      paramString = new UniteGrayTipParam(paramSessionInfo.b, this.c.getCurrentAccountUin(), (String)localObject1, paramSessionInfo.a, -5023, 655381, MessageCache.c());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 39);
      localBundle.putString("textColor", "");
      localBundle.putString("image_resource", null);
      localBundle.putString("key_action_DATA", paramSessionInfo.d);
      paramString.a(5, ((String)localObject2).length() + 5, localBundle);
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("key_action", 38);
      paramSessionInfo.putString("textColor", "");
      paramSessionInfo.putString("image_resource", null);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(d(paramShort));
      ((StringBuilder)localObject2).append("");
      paramSessionInfo.putString("key_action_DATA", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(e(paramShort));
      ((StringBuilder)localObject2).append("");
      paramSessionInfo.putString("key_a_action_DATA", ((StringBuilder)localObject2).toString());
      paramString.a(((String)localObject1).length() - 5, ((String)localObject1).length() - 1, paramSessionInfo);
      paramSessionInfo = (SessionInfo)localObject1;
    }
    else
    {
      localObject1 = String.format(this.c.getApplication().getResources().getString(2131917157), new Object[] { paramString });
      paramString = new UniteGrayTipParam(paramSessionInfo.b, this.c.getCurrentAccountUin(), (String)localObject1, paramSessionInfo.a, -5023, 655381, MessageCache.c());
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("key_action", 38);
      paramSessionInfo.putString("textColor", "");
      paramSessionInfo.putString("image_resource", null);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(d(paramShort));
      ((StringBuilder)localObject2).append("");
      paramSessionInfo.putString("key_action_DATA", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(e(paramShort));
      ((StringBuilder)localObject2).append("");
      paramSessionInfo.putString("key_a_action_DATA", ((StringBuilder)localObject2).toString());
      paramString.a(((String)localObject1).length() - 5, ((String)localObject1).length() - 1, paramSessionInfo);
      paramSessionInfo = (SessionInfo)localObject1;
    }
    Object localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.c, paramString);
    UniteGrayTipMsgUtil.a(this.c, (MessageForUniteGrayTip)localObject1);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("add gray tip =");
      paramString.append(paramSessionInfo);
      QLog.d("TempMsgManager", 2, paramString.toString());
    }
  }
  
  public void a(TempMsgManager.OnTempMsgSettingChangeListener paramOnTempMsgSettingChangeListener)
  {
    this.g = paramOnTempMsgSettingChangeListener;
  }
  
  public void a(short paramShort, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeTempSetting type=");
      ((StringBuilder)localObject).append(paramShort);
      ((StringBuilder)localObject).append(" switchAfter=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" switchBefore");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("sync=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TempMsgManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramShort, paramInt1);
    boolean[] arrayOfBoolean = a(paramShort, paramInt2);
    int j = arrayOfBoolean[0];
    int k = arrayOfBoolean[1];
    int m = localObject[0];
    int n = localObject[1];
    a(paramShort, m, false);
    a(paramShort, n);
    short s = a(m, n);
    if (paramBoolean)
    {
      localObject = (CardHandler)this.c.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localObject != null) {
        ((CardHandler)localObject).a(paramShort, g(paramShort), s, j, k);
      }
    }
  }
  
  public void a(short paramShort, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeInBoxSetting t=");
      ((StringBuilder)localObject).append(paramShort);
      ((StringBuilder)localObject).append(" isInBox=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TempMsgManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = f(paramShort);
    this.f.put(localObject, Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.c.getApplication()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(this.d);
    localStringBuilder.append("_in_box_setting");
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).apply();
  }
  
  public void a(short paramShort, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetResult t=");
      localStringBuilder.append(paramShort);
      localStringBuilder.append(" result=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" fm=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" value=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("TempMsgManager", 2, localStringBuilder.toString());
    }
    if (!paramBoolean1)
    {
      a(paramShort, paramBoolean2, false);
      b(paramString);
    }
    ThreadManager.getUIHandler().post(new TempMsgManager.3(this, paramShort, paramBoolean1));
  }
  
  public void a(short paramShort, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetInBoxResult t=");
      localStringBuilder.append(paramShort);
      localStringBuilder.append(" result=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" fm=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isAllowedToReceiveMessage=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" isInBox=");
      localStringBuilder.append(paramBoolean3);
      QLog.d("TempMsgManager", 2, localStringBuilder.toString());
    }
    boolean bool = b(paramShort);
    if (!paramBoolean1)
    {
      a(paramShort, paramBoolean2, false);
      a(paramShort, paramBoolean3);
      b(paramString);
    }
    if (((paramBoolean1) || (TextUtils.isEmpty(paramString))) && ((bool ^ paramBoolean3)))
    {
      new RecentUserCacheHelper().a(this.c);
      ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).removeMsgBoxIfNecessary(this.c, true);
      ((ITempMsgBoxManager)this.c.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(false);
      this.c.notifyObservers(TempMsgBoxObserver.class, 1, true, new Bundle());
    }
    ThreadManager.getUIHandler().post(new TempMsgManager.4(this, paramShort, paramBoolean1));
  }
  
  public void a(short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeSetting t=");
      ((StringBuilder)localObject).append(paramShort);
      ((StringBuilder)localObject).append(" s=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("sync=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("TempMsgManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = f(paramShort);
    if (this.e.containsKey(localObject))
    {
      this.e.remove(localObject);
      this.e.put(localObject, Boolean.valueOf(paramBoolean1));
    }
    else
    {
      this.e.put(localObject, Boolean.valueOf(paramBoolean1));
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.c.getApplication()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(this.d);
    localStringBuilder.append("_setting");
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).apply();
    if (paramBoolean2)
    {
      localObject = (CardHandler)this.c.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localObject != null) {
        ((CardHandler)localObject).a(paramShort, paramBoolean1 ^ true);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.e.containsKey(paramString)) {
      return ((Boolean)this.e.get(paramString)).booleanValue();
    }
    boolean bool = a(paramString, 0);
    this.e.put(paramString, Boolean.valueOf(bool));
    return bool;
  }
  
  public boolean a(String paramString, SessionInfo paramSessionInfo)
  {
    try
    {
      Object localObject = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramSessionInfo.b);
      if ((((EntityManager)localObject).find(TempMsgInfo.class, localStringBuilder.toString()) instanceof TempMsgInfo)) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("can't tempMsgInfo, insert a new tempMsgInfo! type=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("curFriendUin=");
        ((StringBuilder)localObject).append(paramSessionInfo.b);
        QLog.d("TempMsgManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.h;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramSessionInfo.b);
      ((EntityManager)localObject).persist(new TempMsgInfo(localStringBuilder.toString(), System.currentTimeMillis()));
      return true;
    }
    finally {}
  }
  
  public boolean a(short paramShort)
  {
    return a(f(paramShort));
  }
  
  public boolean[] a(short paramShort, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return new boolean[] { 1, 0 };
      }
      return new boolean[] { false, b(paramShort) };
    }
    return new boolean[] { 1, 1 };
  }
  
  public Map<String, Boolean> b()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.c.getApplication());
    String[] arrayOfString = this.a;
    int k = arrayOfString.length;
    int j = 0;
    while (j < k)
    {
      String str = arrayOfString[j];
      if (!this.f.containsKey(str))
      {
        Map localMap = this.f;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(this.d);
        localStringBuilder.append("_in_box_setting");
        localMap.put(str, Boolean.valueOf(localSharedPreferences.getBoolean(localStringBuilder.toString(), false)));
      }
      j += 1;
    }
    return this.f;
  }
  
  public void b(String paramString)
  {
    if (!StringUtil.isEmpty(paramString)) {
      ThreadManager.getUIHandler().post(new TempMsgManager.5(this, paramString));
    }
  }
  
  public boolean b(short paramShort)
  {
    return c(f(paramShort));
  }
  
  public boolean c(short paramShort)
  {
    String str = f(paramShort);
    return this.b.contains(str);
  }
  
  public int d(short paramShort)
  {
    if (paramShort != -23312)
    {
      if (paramShort != -23168)
      {
        if (paramShort != -23166)
        {
          if (paramShort != -23161)
          {
            if (paramShort != -23158)
            {
              switch (paramShort)
              {
              default: 
                return 0;
              case -23308: 
                return 1;
              case -23309: 
                return 5;
              }
              return 4;
            }
            return 7;
          }
          return 8;
        }
        return 3;
      }
      return 6;
    }
    return 2;
  }
  
  public int e(short paramShort)
  {
    if (paramShort != -20457)
    {
      switch (paramShort)
      {
      default: 
        return 0;
      case -23308: 
        return 1;
      case -23309: 
        return 3;
      }
      return 2;
    }
    return 4;
  }
  
  public void onDestroy()
  {
    this.c = null;
    this.g = null;
    EntityManager localEntityManager = this.h;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
    if (this.i != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TempMsgManager
 * JD-Core Version:    0.7.0.1
 */