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
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
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
  private TempGameMsgSettingReceiver jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxReceiverTempGameMsgSettingReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TempMsgManager.OnTempMsgSettingChangeListener jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager$OnTempMsgSettingChangeListener;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap(8);
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "temp_msg_setting_consult_", "temp_msg_setting_contact_", "temp_msg_setting_troop_", "temp_msg_setting_circle_v2", "temp_msg_setting_company_" };
  private Map<String, Boolean> b = new HashMap(8);
  
  public TempMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentUin();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.b.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxReceiverTempGameMsgSettingReceiver = new TempGameMsgSettingReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a();
    b();
  }
  
  private int a(SessionInfo paramSessionInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    if ((1000 != paramSessionInfo.jdField_a_of_type_Int) && (1004 != paramSessionInfo.jdField_a_of_type_Int) && (1022 != paramSessionInfo.jdField_a_of_type_Int)) {
      localObject = ChatActivityUtils.a((List)localObject, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } else {
      localObject = ChatActivityUtils.b((List)localObject, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (localObject == null) {
      return paramSessionInfo.jdField_a_of_type_Int;
    }
    return ((MessageRecord)localObject).istroop;
  }
  
  private DialogInterface.OnClickListener a(BaseChatPie paramBaseChatPie, short paramShort)
  {
    return new TempMsgManager.2(this, paramBaseChatPie, paramShort);
  }
  
  private String a(short paramShort)
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
  
  private short a(short paramShort)
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
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_toggle_change");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxReceiverTempGameMsgSettingReceiver, localIntentFilter);
  }
  
  private void a(SessionInfo paramSessionInfo, short paramShort, String paramString, int paramInt, BaseChatPie paramBaseChatPie)
  {
    if (!a(a(paramShort)))
    {
      paramSessionInfo = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131719583), new Object[] { paramString, paramString });
      paramSessionInfo = DialogUtil.a(paramBaseChatPie.a, 230, HardCodeUtil.a(2131714626), paramSessionInfo, 2131719581, 2131719582, a(paramBaseChatPie, paramShort), a(paramBaseChatPie, paramShort));
      paramSessionInfo.setOnCancelListener(new TempMsgManager.1(this, paramBaseChatPie));
      paramSessionInfo.setCanceledOnTouchOutside(false);
      paramSessionInfo.show();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009977", "0X8009977", a(paramShort), a(paramShort), "", "", "", "");
      return;
    }
    if ((a(paramSessionInfo)) && (a(a(paramShort), paramSessionInfo))) {
      a(paramSessionInfo, paramString, paramInt, paramShort);
    }
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    int i = paramSessionInfo.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      i = paramSessionInfo.size();
      paramSessionInfo = paramSessionInfo.iterator();
      while (paramSessionInfo.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramSessionInfo.next();
        if (localChatMessage.isSend()) {
          return false;
        }
        if (localChatMessage.senderuin == null) {}
        while ((localChatMessage.senderuin.compareTo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 0) || (localChatMessage.msgtype == -1034))
        {
          i -= 1;
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TempMsgManager", 2, localChatMessage.toString());
        }
      }
      bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    boolean bool = d(paramString);
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("_setting");
      return ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), bool);
    }
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("_show");
      bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), bool);
      if (bool)
      {
        localObject = ((SharedPreferences)localObject).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("_show");
        ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).apply();
      }
      return bool;
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add("temp_msg_setting_circle_v2");
  }
  
  private boolean b(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return ((Boolean)this.b.get(paramString)).booleanValue();
    }
    boolean bool = c(paramString);
    this.b.put(paramString, Boolean.valueOf(bool));
    return bool;
  }
  
  private boolean c(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_in_box_setting");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private boolean d(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramString) ^ true;
  }
  
  public int a(short paramShort)
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
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str))
      {
        boolean bool = d(str);
        Map localMap = this.jdField_a_of_type_JavaUtilMap;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("_setting");
        localMap.put(str, Boolean.valueOf(localSharedPreferences.getBoolean(localStringBuilder.toString(), bool)));
      }
      i += 1;
    }
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterChat");
      localStringBuilder.append(paramSessionInfo.jdField_a_of_type_Int);
      QLog.d("TempMsgManager", 2, localStringBuilder.toString());
    }
    int j = paramSessionInfo.jdField_a_of_type_Int;
    int i = j;
    if (j == 1000) {
      i = a(paramSessionInfo);
    }
    if (i != 1000) {
      if (i != 1001)
      {
        if ((i == 1009) || (i == 1010) || (i == 1020)) {
          return;
        }
        if (i != 10002)
        {
          if (i == 10004) {
            return;
          }
          if (i != 1024) {
            if (i == 1025) {
              return;
            }
          }
        }
      }
    }
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        return;
      case 10010: 
        a(paramSessionInfo, (short)-23161, HardCodeUtil.a(2131694304), i, paramBaseChatPie);
        return;
      case 10009: 
        a(paramSessionInfo, (short)-23158, ((IGameMsgManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getGameBuddyAppName(), i, paramBaseChatPie);
        return;
      }
      a(paramSessionInfo, (short)-23168, HardCodeUtil.a(2131719438), i, paramBaseChatPie);
      return;
    case 1006: 
      a(paramSessionInfo, (short)-23310, HardCodeUtil.a(2131714623), i, paramBaseChatPie);
      return;
    case 1005: 
      a(paramSessionInfo, (short)-23309, "QQ咨询", i, paramBaseChatPie);
      return;
      if (((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).configContains(1024))
      {
        a(paramSessionInfo, (short)-20457, HardCodeUtil.a(2131719578), i, paramBaseChatPie);
        return;
        a(paramSessionInfo, (short)-23166, HardCodeUtil.a(2131714624), i, paramBaseChatPie);
        return;
      }
      break;
    case 1003: 
      a(paramSessionInfo, (short)-23312, HardCodeUtil.a(2131714622), i, paramBaseChatPie);
      return;
      a(paramSessionInfo, (short)-23308, HardCodeUtil.a(2131714625), i, paramBaseChatPie);
    }
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, int paramInt, short paramShort)
  {
    Object localObject2;
    if (paramInt == 1000)
    {
      paramString = ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo.c);
      localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo.c, true);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTroopNickName:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" new From:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("TempMsgManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131719595), new Object[] { localObject2 });
      paramString = new UniteGrayTipParam(paramSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject1, paramSessionInfo.jdField_a_of_type_Int, -5023, 655381, MessageCache.a());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 39);
      localBundle.putString("textColor", "");
      localBundle.putString("image_resource", null);
      localBundle.putString("key_action_DATA", paramSessionInfo.c);
      paramString.a(5, ((String)localObject2).length() + 5, localBundle);
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("key_action", 38);
      paramSessionInfo.putString("textColor", "");
      paramSessionInfo.putString("image_resource", null);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a(paramShort));
      ((StringBuilder)localObject2).append("");
      paramSessionInfo.putString("key_action_DATA", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(b(paramShort));
      ((StringBuilder)localObject2).append("");
      paramSessionInfo.putString("key_a_action_DATA", ((StringBuilder)localObject2).toString());
      paramString.a(((String)localObject1).length() - 5, ((String)localObject1).length() - 1, paramSessionInfo);
      paramSessionInfo = (SessionInfo)localObject1;
    }
    else
    {
      localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131719594), new Object[] { paramString });
      paramString = new UniteGrayTipParam(paramSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject1, paramSessionInfo.jdField_a_of_type_Int, -5023, 655381, MessageCache.a());
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("key_action", 38);
      paramSessionInfo.putString("textColor", "");
      paramSessionInfo.putString("image_resource", null);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a(paramShort));
      ((StringBuilder)localObject2).append("");
      paramSessionInfo.putString("key_action_DATA", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(b(paramShort));
      ((StringBuilder)localObject2).append("");
      paramSessionInfo.putString("key_a_action_DATA", ((StringBuilder)localObject2).toString());
      paramString.a(((String)localObject1).length() - 5, ((String)localObject1).length() - 1, paramSessionInfo);
      paramSessionInfo = (SessionInfo)localObject1;
    }
    Object localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
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
    this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager$OnTempMsgSettingChangeListener = paramOnTempMsgSettingChangeListener;
  }
  
  public void a(String paramString)
  {
    if (!StringUtil.a(paramString)) {
      ThreadManager.getUIHandler().post(new TempMsgManager.5(this, paramString));
    }
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
    int i = arrayOfBoolean[0];
    int j = arrayOfBoolean[1];
    int k = localObject[0];
    int m = localObject[1];
    a(paramShort, k, false);
    a(paramShort, m);
    short s = a(k, m);
    if (paramBoolean)
    {
      localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localObject != null) {
        ((CardHandler)localObject).a(paramShort, a(paramShort), s, i, j);
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
    Object localObject = a(paramShort);
    this.b.put(localObject, Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
      a(paramString);
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
      a(paramString);
    }
    if (((paramBoolean1) || (TextUtils.isEmpty(paramString))) && ((bool ^ paramBoolean3)))
    {
      new RecentUserCacheHelper().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).removeMsgBoxIfNecessary(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      ((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(TempMsgBoxObserver.class, 1, true, new Bundle());
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
    Object localObject = a(paramShort);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(localObject);
      this.jdField_a_of_type_JavaUtilMap.put(localObject, Boolean.valueOf(paramBoolean1));
    }
    else
    {
      this.jdField_a_of_type_JavaUtilMap.put(localObject, Boolean.valueOf(paramBoolean1));
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_setting");
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).apply();
    if (paramBoolean2)
    {
      localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localObject != null) {
        ((CardHandler)localObject).a(paramShort, paramBoolean1 ^ true);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramString)).booleanValue();
    }
    boolean bool = a(paramString, 0);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Boolean.valueOf(bool));
    return bool;
  }
  
  public boolean a(String paramString, SessionInfo paramSessionInfo)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if ((((EntityManager)localObject).find(TempMsgInfo.class, localStringBuilder.toString()) instanceof TempMsgInfo)) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("can't tempMsgInfo, insert a new tempMsgInfo! type=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("curFriendUin=");
        ((StringBuilder)localObject).append(paramSessionInfo.jdField_a_of_type_JavaLangString);
        QLog.d("TempMsgManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramSessionInfo.jdField_a_of_type_JavaLangString);
      ((EntityManager)localObject).persist(new TempMsgInfo(localStringBuilder.toString(), System.currentTimeMillis()));
      return true;
    }
    finally {}
  }
  
  public boolean a(short paramShort)
  {
    return a(a(paramShort));
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
  
  public int b(short paramShort)
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
  
  public Map<String, Boolean> b()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (!this.b.containsKey(str))
      {
        Map localMap = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("_in_box_setting");
        localMap.put(str, Boolean.valueOf(localSharedPreferences.getBoolean(localStringBuilder.toString(), false)));
      }
      i += 1;
    }
    return this.b;
  }
  
  public boolean b(short paramShort)
  {
    return b(a(paramShort));
  }
  
  public boolean c(short paramShort)
  {
    String str = a(paramShort);
    return this.jdField_a_of_type_JavaUtilList.contains(str);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager$OnTempMsgSettingChangeListener = null;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxReceiverTempGameMsgSettingReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxReceiverTempGameMsgSettingReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TempMsgManager
 * JD-Core Version:    0.7.0.1
 */