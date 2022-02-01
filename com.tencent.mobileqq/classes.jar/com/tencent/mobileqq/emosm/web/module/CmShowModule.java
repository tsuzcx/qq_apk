package com.tencent.mobileqq.emosm.web.module;

import amme;
import amtm;
import amts;
import amub;
import amwf;
import amwn;
import amyt;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import anex;
import anjb;
import ankc;
import anvk;
import anvx;
import aozm;
import ashy;
import asic;
import bbbq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CmShowModule
{
  private static final String TAG = "CmShowHandler";
  
  private void startApolloGameInner(MessengerService paramMessengerService, QQAppInterface paramQQAppInterface, Bundle paramBundle1, Bundle paramBundle2, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramMessengerService == null) || (paramQQAppInterface == null) || (paramBundle1 == null) || (paramBundle2 == null) || (paramStartCheckParam == null)) {
      return;
    }
    Activity localActivity = ApolloGameUtil.a();
    if (paramStartCheckParam.gameId == 1000)
    {
      amme localamme = (amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
      ApolloGameData localApolloGameData = ((ankc)paramQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(paramStartCheckParam.gameId);
      if (localApolloGameData != null)
      {
        paramStartCheckParam.game = localApolloGameData;
        paramStartCheckParam.startT = System.currentTimeMillis();
        paramStartCheckParam.version = localamme.a(paramStartCheckParam.gameId);
        paramQQAppInterface = amwf.a().a(paramStartCheckParam.gameId);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(localActivity, paramStartCheckParam);
        }
        if (localActivity != null) {
          break label244;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = BaseApplicationImpl.getContext();
        paramQQAppInterface = new Intent(paramQQAppInterface, ApolloWebGameActivity.class);
        paramQQAppInterface.setFlags(196608);
        paramQQAppInterface.putExtra("extra_startcheckparam", paramStartCheckParam);
        localActivity.startActivity(paramQQAppInterface);
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("CmShowHandler", 1, "[startApolloGameInner] exception=", paramQQAppInterface);
        continue;
      }
      paramBundle2.putInt("result", 0);
      paramBundle1.putBundle("response", paramBundle2);
      paramMessengerService.a(paramBundle1);
      return;
      ApolloGameUtil.a(paramQQAppInterface, 0L);
      paramBundle2.putInt("result", 1);
      paramBundle1.putBundle("response", paramBundle2);
      paramMessengerService.a(paramBundle1);
      return;
      ApolloGameUtil.a(localActivity, paramStartCheckParam);
      continue;
      label244:
      paramQQAppInterface = localActivity;
    }
  }
  
  @asic(a="ipc_apollo_add_cm_face")
  public void addCmFace(@NonNull ashy paramashy)
  {
    int i = 0;
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = localBundle.getBundle("request").getString("faceIdList");
    paramashy = new Bundle();
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      Object localObject2;
      ArrayList localArrayList;
      try
      {
        localObject2 = new JSONArray((String)localObject1);
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          localObject1 = new ArrayList();
          localArrayList = ApolloUtil.a(localQQAppInterface);
          int j = ((JSONArray)localObject2).length();
          if (i < j)
          {
            int k = QQSysFaceUtil.convertToLocal(((JSONArray)localObject2).getInt(i));
            if (!com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(k)) {
              break label538;
            }
            ((ArrayList)localObject1).add(Integer.valueOf(k));
            if ((localArrayList == null) || (!localArrayList.contains(Integer.valueOf(k)))) {
              break label538;
            }
            k = localArrayList.indexOf(Integer.valueOf(k));
            if (k == -1) {
              break label538;
            }
            localArrayList.remove(k);
            break label538;
          }
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            if (localQQAppInterface == null) {
              break label469;
            }
            localObject2 = (CommonUsedSystemEmojiManager)localQQAppInterface.getManager(QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT);
            if (localObject2 == null) {
              break label446;
            }
            Iterator localIterator = ((ArrayList)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Integer localInteger = (Integer)localIterator.next();
              EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
              localSmallYellowItem.id.set(localInteger.intValue());
              localSmallYellowItem.type.set(1);
              localSmallYellowItem.ts.set(System.currentTimeMillis());
              ((CommonUsedSystemEmojiManager)localObject2).saveSystemEmojiInfoToCahce(localSmallYellowItem);
              continue;
            }
          }
          else
          {
            localBundle.putBundle("response", paramashy);
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("CmShowHandler", 1, "IPC_APOLLO_ADD_CM_FACE, exception=", localException);
        paramashy.putInt("result", 1);
        paramashy.putString("msg", anvx.a(2131706145) + localException.getMessage());
      }
      for (;;)
      {
        localMessengerService.a(localBundle);
        return;
        ((CommonUsedSystemEmojiManager)localObject2).saveSystemEmojiInfoToFile();
        localObject2 = localException.getHandler(ChatActivity.class);
        if (localObject2 != null) {
          ((MqqHandler)localObject2).obtainMessage(10).sendToTarget();
        }
        paramashy.putInt("result", 0);
        paramashy.putString("msg", anvx.a(2131706138));
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          ((ArrayList)localObject1).addAll(localArrayList);
        }
        ApolloUtil.a(localException, (ArrayList)localObject1);
        continue;
        label446:
        paramashy.putInt("result", 1);
        paramashy.putString("msg", anvx.a(2131706155));
        continue;
        label469:
        paramashy.putInt("result", 1);
        paramashy.putString("msg", anvx.a(2131706151));
        continue;
        paramashy.putInt("result", 1);
        paramashy.putString("msg", anvx.a(2131706154));
        continue;
        paramashy.putInt("result", 1);
        paramashy.putString("msg", anvx.a(2131706156));
      }
      label538:
      i += 1;
    }
  }
  
  @asic(a="ipc_apollo_add_fav_action")
  public void addFavAction(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Bundle localBundle2 = localBundle1.getBundle("request");
    ThreadManager.post(new CmShowModule.9(this, paramashy, localBundle2.getInt("actionId"), localBundle2.getString("actionText"), localBundle2.getInt("textType"), localBundle2.getInt("audioId"), localBundle2.getInt("playOriginalAudio"), localBundle2.getFloat("audioStartTime"), localBundle1, localMessengerService), 5, null, false);
  }
  
  @asic(a="ipc_apollo_add_game")
  public void addGame(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ThreadManager.post(new CmShowModule.13(this, localBundle.getBundle("request").getString("gameListJson"), localBundle, localMessengerService, paramashy), 5, null, false);
  }
  
  @asic(a="ipc_apollo_clear_bubble")
  public void apolloClearBubble(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l = localBundle.getBundle("request").getLong("bubble_id");
    paramashy = (amme)paramashy.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (l == 0L)
    {
      paramashy.i();
      return;
    }
    paramashy.b(String.valueOf(l));
  }
  
  @asic(a="ipc_apollo_changerole")
  public void changeRole(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramashy.b;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramashy = localBundle2.getIntArray("apollo_dressIds");
    int j = localBundle2.getInt("apollo_roleId");
    int k = localBundle2.getInt("apollo_fromSelf");
    if (j > 0)
    {
      if (k != 1) {
        ApolloBaseInfo.saveSelfApolloDress(localQQAppInterface, localBundle2.getString("apollo_userData"));
      }
      boolean bool2;
      if ((j > 0) && (paramashy != null) && (paramashy.length > 0))
      {
        boolean bool1 = ApolloUtil.d(j);
        int m = paramashy.length;
        int i = 0;
        bool2 = bool1;
        if (i < m)
        {
          int n = paramashy[i];
          if ((bool1) && (ApolloUtil.c(n))) {}
          for (bool1 = true;; bool1 = false)
          {
            i += 1;
            break;
          }
        }
      }
      else
      {
        bool2 = false;
      }
      if (bool2)
      {
        localBundle2 = new Bundle();
        localBundle2.putInt("apollo_result", 0);
        localBundle2.putInt("apollo_roleId", j);
        localBundle2.putInt("apollo_fromSelf", k);
        localBundle2.putIntArray("apollo_dressIds", paramashy);
        localBundle1.putBundle("response", localBundle2);
        localMessengerService.a(localBundle1);
        return;
      }
      anex.a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), new CmShowModule.7(this, k, localBundle1, localMessengerService), j, paramashy, -1, -1, false);
      return;
    }
    paramashy = new Bundle();
    paramashy.putInt("apollo_result", 1);
    paramashy.putInt("apollo_fromSelf", k);
    localBundle1.putBundle("response", paramashy);
    localMessengerService.a(localBundle1);
  }
  
  @asic(a="ipc_apollo_check_action")
  public void checkAction(@NonNull ashy paramashy)
  {
    aozm.a(paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, "ipc call check_action");
    }
  }
  
  @asic(a="ipc_apollo_check_avatar_res")
  public void checkAvatarRes(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    Object localObject1 = paramashy.b;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, "IPC_APOLLO_CHECK_AVATAR_RES");
    }
    paramashy = (ArrayList)((Bundle)localObject1).getSerializable("apolloList");
    if ((paramashy == null) || (paramashy.size() == 0))
    {
      QLog.e("CmShowHandler", 1, "IPC_APOLLO_CHECK_AVATAR_RES, no avatar params");
      paramashy = new Bundle();
      paramashy.putInt("result", 1);
      paramashy.putString("msg", anvx.a(2131706152));
      localBundle.putBundle("response", paramashy);
      localMessengerService.a(localBundle);
      return;
    }
    int j = ((Bundle)localObject1).getInt("from");
    Iterator localIterator = paramashy.iterator();
    while (localIterator.hasNext())
    {
      ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)localIterator.next();
      if (android.text.TextUtils.isEmpty(localApolloWebAvatarParam.uin))
      {
        paramashy = new Bundle();
        paramashy.putInt("result", 1);
        paramashy.putString("msg", "uin为空");
        localBundle.putBundle("response", paramashy);
        localMessengerService.a(localBundle);
        return;
      }
      Object localObject3;
      Object localObject4;
      if ((localApolloWebAvatarParam.roleId <= 0) || (localApolloWebAvatarParam.dressIds == null) || (localApolloWebAvatarParam.dressIds.length <= 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmShowHandler", 2, "IPC_APOLLO_CHECK_AVATAR_RES, roleId=0 or no dressIds");
        }
        localObject3 = (amme)((QQAppInterface)localObject2).getManager(QQManagerFactory.APOLLO_MANAGER);
        localObject4 = ((amme)localObject3).b(localApolloWebAvatarParam.uin);
        int i;
        if (localObject4 != null)
        {
          localObject4 = ((ApolloBaseInfo)localObject4).getApolloDress();
          if (localObject4 != null)
          {
            localApolloWebAvatarParam.roleId = ((ApolloDress)localObject4).jdField_a_of_type_Int;
            localApolloWebAvatarParam.dressIds = ((ApolloDress)localObject4).a();
          }
        }
        else
        {
          if (localApolloWebAvatarParam.roleId == 0)
          {
            localObject3 = ((anvk)((QQAppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localApolloWebAvatarParam.uin);
            if (localObject3 != null)
            {
              if ((((Friends)localObject3).gender != 1) && (((Friends)localObject3).gender != 0)) {
                break label510;
              }
              i = 1;
              label359:
              localApolloWebAvatarParam.roleId = i;
              if (QLog.isColorLevel()) {
                QLog.d("CmShowHandler", 2, new Object[] { "IPC_APOLLO_CHECK_AVATAR_RES, roleId=", Integer.valueOf(localApolloWebAvatarParam.roleId), ", apolloId=", localApolloWebAvatarParam.apolloId });
              }
            }
          }
          if ((localApolloWebAvatarParam.roleId <= 0) || (localApolloWebAvatarParam.dressIds == null) || (localApolloWebAvatarParam.dressIds.length <= 0)) {
            continue;
          }
          bool = ApolloUtil.d(localApolloWebAvatarParam.roleId);
          localObject3 = localApolloWebAvatarParam.dressIds;
          int k = localObject3.length;
          i = 0;
          label461:
          if (i >= k) {
            break label521;
          }
          int m = localObject3[i];
          if ((!bool) || (!ApolloUtil.c(m))) {
            break label515;
          }
        }
        label515:
        for (boolean bool = true;; bool = false)
        {
          i += 1;
          break label461;
          ((amme)localObject3).a(localApolloWebAvatarParam.uin, 2);
          break;
          label510:
          i = 2;
          break label359;
        }
        label521:
        localApolloWebAvatarParam.isResExist = bool;
      }
      else
      {
        localObject3 = (amme)((QQAppInterface)localObject2).getManager(QQManagerFactory.APOLLO_MANAGER);
        localObject4 = ((amme)localObject3).b(localApolloWebAvatarParam.uin);
        if ((localObject4 != null) && (((ApolloBaseInfo)localObject4).getApolloDress() == null)) {
          ((amme)localObject3).a(localApolloWebAvatarParam.uin, 2);
        }
      }
    }
    localObject2 = new Bundle();
    localObject1 = ((Bundle)localObject1).getString("reqUrl");
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      ((Bundle)localObject2).putString("reqUrl", (String)localObject1);
    }
    ((Bundle)localObject2).putInt("result", 0);
    ((Bundle)localObject2).putInt("from", j);
    ((Bundle)localObject2).putSerializable("apolloList", paramashy);
    localBundle.putBundle("response", (Bundle)localObject2);
    localMessengerService.a(localBundle);
  }
  
  @asic(a="ipc_apollo_choose_friend_play_game")
  public void chooseFriendPlayGame(@NonNull ashy paramashy) {}
  
  @asic(a="ipc_apollo_clean_mine_redtouch")
  public void cleanMineRedTouch(@NonNull ashy paramashy)
  {
    ((bbbq)paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf("103100.103200.103201.103204"));
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, "IPC_APOLLO_CLEAN_MINE_REDTOUCH cmd get");
    }
  }
  
  @asic(a="ipc_cm_game_conn_connected")
  public void cmGameConnConnected(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn", 2, "IPC_CM_GAME_CONN_CONNECTED");
    }
    boolean bool = ((amme)paramashy.getManager(QQManagerFactory.APOLLO_MANAGER)).a().a();
    paramashy = new Bundle();
    paramashy.putInt("result", 0);
    paramashy.putBoolean("isConnected", bool);
    localBundle.putBundle("response", paramashy);
    localMessengerService.a(localBundle);
  }
  
  @asic(a="ipc_open_cm_game_match_page")
  public void cmGameMatchPage(@NonNull ashy paramashy)
  {
    int i = 0;
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramashy = localBundle.getBundle("request").getString("url");
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn", 2, new Object[] { "IPC_OPEN_CM_GAME_MATCH_PAGE, url=", paramashy });
    }
    if (!android.text.TextUtils.isEmpty(paramashy)) {
      amwn.a(localMessengerService, paramashy);
    }
    for (;;)
    {
      paramashy = new Bundle();
      paramashy.putInt("result", i);
      localBundle.putBundle("response", paramashy);
      localMessengerService.a(localBundle);
      return;
      i = 1;
    }
  }
  
  @asic(a="ipc_cm_game_match_page_report_status")
  public void cmGameMatchPageReportStatus(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localBundle = localBundle.getBundle("request");
    boolean bool1 = localBundle.getBoolean("isAlive");
    boolean bool2 = localBundle.getBoolean("wakeup");
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn", 2, new Object[] { "IPC_CM_GAME_MATCH_PAGE_REPORT_STATUS, isAlive=", Boolean.valueOf(bool1), ", wakeup=", Boolean.valueOf(bool2) });
    }
    ((amme)paramashy.getManager(QQManagerFactory.APOLLO_MANAGER)).a().a(bool1, bool2);
  }
  
  @asic(a="ipc_open_cm_game_send_game_app_ark_msg")
  public void cmGameSendAppApkMsg(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = localBundle.getBundle("request");
    String str = ((Bundle)localObject).getString("friendUin");
    localObject = ((Bundle)localObject).getString("arkInfo");
    if (QLog.isColorLevel()) {
      QLog.d("CmGame", 2, "IPC_OPEN_CM_GAME_SEND_GAME_APP_ARK_MSG");
    }
    boolean bool = amub.a(paramashy, str, (String)localObject);
    paramashy = new Bundle();
    if (bool) {}
    for (int i = 0;; i = 1)
    {
      paramashy.putInt("result", i);
      localBundle.putBundle("response", paramashy);
      localMessengerService.a(localBundle);
      return;
    }
  }
  
  @asic(a="ipc_trace_report")
  public void cmsTraceReport(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramashy = localBundle.getBundle("request");
    anjb.a(paramashy.getString("action"), paramashy);
  }
  
  @asic(a="ipc_apollo_del_fav_action")
  public void delFavAction(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Bundle localBundle2 = localBundle1.getBundle("request");
    int i = localBundle2.getInt("actionId");
    ThreadManager.post(new CmShowModule.10(this, paramashy, localBundle2.getLong("seq"), i, localBundle1, localMessengerService), 5, null, false);
  }
  
  @asic(a="ipc_apollo_del_fav_list")
  public void delFavList(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManager.post(new CmShowModule.11(this, paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle.getBundle("request").getString("delJson"), localBundle, localMessengerService), 5, null, false);
  }
  
  @asic(a="ipc_apollo_del_game")
  public void delGame(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ThreadManager.post(new CmShowModule.16(this, localBundle.getBundle("request").getString("gameListJson"), localBundle, localMessengerService, paramashy), 5, null, false);
  }
  
  @asic(a="IPC_APOLLO_DOWNLOAD_GAME")
  public void downloadGame(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = localBundle.getBundle("request").getInt("gameId");
    Object localObject1 = (amme)((QQAppInterface)localObject2).getManager(QQManagerFactory.APOLLO_MANAGER);
    paramashy = new CmGameStartChecker.StartCheckParam(i, false, "check", 0L, 4, 1, 0, 0, "", 0, null);
    localObject2 = ((ankc)((QQAppInterface)localObject2).getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(i);
    if (localObject2 != null) {
      paramashy.game = ((ApolloGameData)localObject2);
    }
    for (;;)
    {
      paramashy.version = ((amme)localObject1).a(paramashy.game.gameId);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putSerializable("StartCheckParam", paramashy);
      localBundle.putBundle("response", (Bundle)localObject1);
      localMessengerService.a(localBundle);
      return;
      paramashy.game = new ApolloGameData();
      paramashy.game.gameId = i;
    }
  }
  
  @asic(a="ipc_apollo_downloadImageOnFrame")
  public void downloadIPC(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramashy.b;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Bundle localBundle3 = new Bundle();
    localBundle3.putInt("apollo_previewAction", localBundle2.getInt("apollo_previewAction"));
    localBundle1.putBundle("response", localBundle3);
    paramashy.a(localBundle1);
  }
  
  @asic(a="ipc_apollo_get_apollo_data")
  public void getApolloData(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramashy.b;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    aozm.a(localQQAppInterface, 1);
    paramashy = ((amme)localQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).b(localQQAppInterface.getCurrentAccountUin());
    int j;
    int k;
    int i;
    if (paramashy != null)
    {
      j = paramashy.apolloStatus;
      ApolloDress localApolloDress = paramashy.getApolloDress();
      if (localApolloDress != null)
      {
        k = localApolloDress.jdField_a_of_type_Int;
        i = localApolloDress.b;
        paramashy = localApolloDress.a();
        boolean bool = localApolloDress.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      int m = localBundle2.getInt("apollo_initFrom");
      localBundle2 = new Bundle();
      localBundle2.putInt("apollo_result", 0);
      localBundle2.putInt("apollo_initFrom", m);
      localBundle2.putInt("apollo_roleId", k);
      localBundle2.putIntArray("apollo_dressIds", paramashy);
      localBundle2.putInt("apollo_apolloStatus", j);
      if (k == 0)
      {
        paramashy = ((anvk)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localQQAppInterface.getCurrentAccountUin());
        if (paramashy == null) {}
      }
      for (j = paramashy.gender;; j = 1)
      {
        k = i;
        if (i == 0) {
          k = j;
        }
        localBundle2.putInt("apollo_roleGender", k);
        localBundle2.putInt("apollo_gender", j);
        localBundle1.putBundle("response", localBundle2);
        localMessengerService.a(localBundle1);
        return;
      }
      paramashy = null;
      k = 0;
      i = 0;
      continue;
      i = 0;
      paramashy = null;
      k = 0;
      j = 0;
    }
  }
  
  @asic(a="ipc_apollo_getfav_action")
  public void getFavAction(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManager.post(new CmShowModule.8(this, paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle, localMessengerService), 5, null, true);
  }
  
  @asic(a="ipc_apollo_get_openapollo_friends")
  public void getOpenApolloFriends(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((QQAppInterface)localObject2).isLogin())
    {
      paramashy = ((QQAppInterface)localObject2).getEntityManagerFactory().createEntityManager().query(true, "ApolloBaseInfo", new String[] { "uin" }, "apolloStatus=? ", new String[] { "1" }, null, null, null, null);
      if ((paramashy == null) || (!paramashy.moveToFirst())) {
        break label405;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        Object localObject3 = (anvk)((QQAppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER);
        int k = paramashy.getColumnIndex("uin");
        if (k >= 0)
        {
          localObject2 = new JSONArray();
          int i = 0;
          Object localObject4 = paramashy.getString(k);
          Friends localFriends = ((anvk)localObject3).b((String)localObject4);
          j = i;
          if (localFriends == null) {
            break label423;
          }
          j = i;
          if (!localFriends.isFriend()) {
            break label423;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", localObject4);
          localJSONObject.put("nick", localFriends.name);
          ((JSONArray)localObject2).put(localJSONObject);
          j = i + 1;
          break label423;
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("apollo_result", 0);
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("friends", localObject2);
          ((Bundle)localObject3).putString("apollo_data", ((JSONObject)localObject4).toString());
          localBundle.putBundle("response", (Bundle)localObject3);
          localMessengerService.a(localBundle);
          if (QLog.isColorLevel()) {
            QLog.d("CmShowHandler", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS array is:" + ((JSONArray)localObject2).toString());
          }
          return;
          boolean bool = paramashy.moveToNext();
          i = j;
          if (bool) {
            continue;
          }
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CmShowHandler", 2, localException.getMessage());
        paramashy.close();
        continue;
      }
      finally
      {
        paramashy.close();
      }
      paramashy = new Bundle();
      paramashy.putInt("apollo_result", 1);
      localBundle.putBundle("response", paramashy);
      return;
      label405:
      if (QLog.isColorLevel())
      {
        QLog.d("CmShowHandler", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS cursor is null");
        continue;
        label423:
        if (j < 10) {}
      }
    }
  }
  
  @asic(a="ipc_apollo_get_playmate_msg")
  public void getPlayMateMsg(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramashy.b;
    localObject = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramashy = localBundle.getBundle("request").getString("uinList");
    if (android.text.TextUtils.isEmpty(paramashy)) {}
    for (;;)
    {
      return;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramashy);
        if (localJSONArray.length() >= 1)
        {
          ThreadManagerV2.excute(new CmShowModule.15(this, localJSONArray, localQQAppInterface, localBundle, (MessengerService)localObject), 16, null, false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("CmShowHandler", 1, "getPlayMateMsg uinList to json error:  " + localJSONException + " uinList: " + paramashy);
      }
    }
  }
  
  @asic(a="ipc_apollo_is_cm_face_added")
  public void isCmFaceAdded(@NonNull ashy paramashy)
  {
    int i = 0;
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = localBundle.getBundle("request").getString("faceIdList");
    paramashy = new Bundle();
    JSONArray localJSONArray;
    int k;
    JSONObject localJSONObject;
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          localJSONArray = new JSONArray();
          localObject2 = ApolloUtil.a((QQAppInterface)localObject2);
          int j = ((JSONArray)localObject1).length();
          if (i < j)
          {
            k = ((JSONArray)localObject1).getInt(i);
            localJSONObject = new JSONObject();
            int m = QQSysFaceUtil.convertToLocal(k);
            if (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(m))
            {
              if ((localObject2 != null) && (((ArrayList)localObject2).contains(Integer.valueOf(m))))
              {
                localJSONObject.put("id", k);
                localJSONObject.put("status", 2);
              }
              for (;;)
              {
                localJSONArray.put(i, localJSONObject);
                i += 1;
                break;
                localJSONObject.put("id", k);
                localJSONObject.put("status", 1);
              }
              localBundle.putBundle("response", paramashy);
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("CmShowHandler", 1, "IPC_APOLLO_IS_CM_FACE_ADDED, exception=", localException);
        paramashy.putInt("result", 1);
        paramashy.putString("msg", anvx.a(2131706146) + localException.getMessage());
      }
    }
    for (;;)
    {
      localMessengerService.a(localBundle);
      return;
      localJSONObject.put("id", k);
      localJSONObject.put("status", 0);
      break;
      paramashy.putInt("result", 0);
      paramashy.putString("status", localJSONArray.toString());
      paramashy.putString("msg", anvx.a(2131706160));
      continue;
      paramashy.putInt("result", 1);
      paramashy.putString("msg", anvx.a(2131706144));
      continue;
      paramashy.putInt("result", 1);
      paramashy.putString("msg", anvx.a(2131706150));
    }
  }
  
  @asic(a="ipc_apollo_open_cmgame_aio")
  public void openCmGameAio(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localBundle = localBundle.getBundle("request");
    amub.a(paramashy, localBundle.getString("friendUin"), localBundle.getString("nickName"), localBundle.getInt("src"));
  }
  
  @asic(a="ipc_apollo_play_last_record_msg")
  public void playLastRecordMsg(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramashy.b;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManagerV2.executeOnSubThread(new CmShowModule.3(this, paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle2, localBundle1, localMessengerService));
  }
  
  @asic(a="ipc_apollo_preview")
  public void preview(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramashy.b;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((Bundle)localObject).getIntArray("apollo_dressIds");
    if ((localObject != null) && (localObject.length > 0))
    {
      anex.b(paramashy, paramashy.getCurrentUin(), new CmShowModule.4(this, localBundle, localMessengerService), -1, (int[])localObject, -1, -1, false);
      return;
    }
    paramashy = new Bundle();
    paramashy.putInt("apollo_result", 1);
    localBundle.putBundle("response", paramashy);
    localMessengerService.a(localBundle);
  }
  
  @asic(a="ipc_apollo_preview_action")
  public void previewAction(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    Object localObject1 = paramashy.b;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = ((Bundle)localObject1).getInt("apollo_previewAction");
    paramashy = ((Bundle)localObject1).getString("apollo_json");
    int k = ((Bundle)localObject1).getInt("apollo_type");
    int m = ((Bundle)localObject1).getInt("apollo_isSpecial");
    boolean bool = ((Bundle)localObject1).getBoolean("apollo_previewOnFrame");
    String str2 = ((Bundle)localObject1).getString("apollo_id");
    int i = ((Bundle)localObject1).getInt("apollo_partnerRoleId");
    String str1 = ((Bundle)localObject1).getString("title");
    localObject1 = ((Bundle)localObject1).getString("subTitle");
    if (i == 0) {
      i = -1;
    }
    for (;;)
    {
      if (j > 0)
      {
        anex.a((AppInterface)localObject2, "", new CmShowModule.5(this, m, (QQAppInterface)localObject2, paramashy, j, bool, str2, str1, (String)localObject1, localBundle, localMessengerService), i, null, j, k, false);
        return;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("apollo_result", 1);
      ((Bundle)localObject2).putString("apollo_json", paramashy);
      ((Bundle)localObject2).putString("title", str1);
      ((Bundle)localObject2).putString("subTitle", (String)localObject1);
      localBundle.putBundle("response", (Bundle)localObject2);
      localMessengerService.a(localBundle);
      return;
    }
  }
  
  @asic(a="ipc_apollo_preview_audio_action")
  public void previewAudioAction(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    Object localObject1 = paramashy.b;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = ((Bundle)localObject1).getInt("apollo_audioId");
    paramashy = ((Bundle)localObject1).getString("apollo_json");
    int j = ((Bundle)localObject1).getInt("apollo_previewAction");
    boolean bool = ((Bundle)localObject1).getBoolean("apollo_previewOnFrame");
    int k = ((Bundle)localObject1).getInt("apollo_partnerRoleId");
    int m = ((Bundle)localObject1).getInt("apollo_apolloVipFlag");
    int n = ((Bundle)localObject1).getInt("apollo_apolloVipLevel");
    String str2 = ((Bundle)localObject1).getString("apollo_id");
    String str1 = ((Bundle)localObject1).getString("title");
    localObject1 = ((Bundle)localObject1).getString("subTitle");
    if (i > 0)
    {
      anex.a((AppInterface)localObject2, new CmShowModule.6(this, m, n, k, paramashy, j, bool, str2, str1, (String)localObject1, localBundle, localMessengerService), i, false);
      return;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("apollo_result", 1);
    ((Bundle)localObject2).putInt("apollo_audioId", i);
    ((Bundle)localObject2).putString("apollo_json", paramashy);
    ((Bundle)localObject2).putString("title", str1);
    ((Bundle)localObject2).putString("subTitle", (String)localObject1);
    localBundle.putBundle("response", (Bundle)localObject2);
    localMessengerService.a(localBundle);
  }
  
  @asic(a="ipc_apollo_query_mine_redinfo")
  public void queryMineRedInfo(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = ((bbbq)paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("103100.103200.103201.103204");
    if ((paramashy == null) || (localBundle1 == null)) {}
    do
    {
      return;
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("isNewFlag", paramashy.iNewFlag.get());
      localBundle1.putBundle("response", localBundle2);
      localMessengerService.a(localBundle1);
    } while (!QLog.isColorLevel());
    QLog.d("CmShowHandler", 2, "IPC_APOLLO_QUERY_MINE_REDINFO cmd get and isNewFlag=" + paramashy.iNewFlag.get());
  }
  
  @asic(a="ipc_apollo_refresh_action")
  public void refreshAction(@NonNull ashy paramashy)
  {
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ((VasExtensionHandler)paramashy.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(paramashy.getCurrentUin(), 128, "refreshAction");
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, "ipc call refreshAction");
    }
  }
  
  @asic(a="ipc_apollo_save_3d_face")
  public void save3DFaceData(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.b;
    Bundle localBundle2 = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManagerV2.executeOnSubThread(new CmShowModule.18(this, localBundle1, paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle2, localMessengerService));
  }
  
  @asic(a="ipc_apollo_setcapsule")
  public void setCapule(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramashy.b;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((Bundle)localObject).getString("apollo_uin");
    ((amme)paramashy.getManager(QQManagerFactory.APOLLO_MANAGER)).a((String)localObject);
    paramashy = new Bundle();
    paramashy.putInt("result", 0);
    localBundle.putBundle("response", paramashy);
    localMessengerService.a(localBundle);
  }
  
  @asic(a="ipc_apollo_setup")
  public void setupUser(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.b;
    ApolloBaseInfo.saveSelfApolloDress(paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle.getString("apollo_userData"));
  }
  
  @asic(a="ipc_apollo_start_apollo_game")
  public void startApolloGame(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = localBundle1.getBundle("request");
    Bundle localBundle2 = new Bundle();
    localObject = (CmGameStartChecker.StartCheckParam)((Bundle)localObject).getSerializable("StartCheckParam");
    if (localObject == null)
    {
      QLog.e("ApolloGameActivity", 1, "IPC_APOLLO_START_APOLLO_GAME startCheckParam == null || startCheckParam.game == null");
      localBundle2.putInt("result", 1);
      localBundle1.putBundle("response", localBundle2);
      localMessengerService.a(localBundle1);
      return;
    }
    if (ApolloGameUtil.a() == null)
    {
      Intent localIntent = new Intent(BaseApplication.getContext(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.addFlags(268500992);
      BaseApplication.getContext().startActivity(localIntent);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CmShowModule.14(this, localMessengerService, paramashy, localBundle1, localBundle2, (CmGameStartChecker.StartCheckParam)localObject), 1000L);
      return;
    }
    startApolloGameInner(localMessengerService, paramashy, localBundle1, localBundle2, (CmGameStartChecker.StartCheckParam)localObject);
  }
  
  @asic(a="ipc_apollo_start_record_msg")
  public void startRecordMsg(@NonNull ashy paramashy)
  {
    Bundle localBundle1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramashy.b;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = localBundle2.getInt("maxDuration");
    int i = j;
    if (j < 5) {
      i = 5;
    }
    localBundle2 = new Bundle();
    ((amme)paramashy.getManager(QQManagerFactory.APOLLO_MANAGER)).a().a(i, new CmShowModule.1(this, localBundle2, localBundle1, localMessengerService));
  }
  
  @asic(a="ipc_apollo_stop_last_record_msg")
  public void stopLastRecordMsg(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    boolean bool = ((amme)paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a().d();
    paramashy = new Bundle();
    if (bool) {}
    for (int i = 0;; i = -1)
    {
      paramashy.putInt("result", i);
      localBundle.putBundle("response", paramashy);
      localMessengerService.a(localBundle);
      return;
    }
  }
  
  @asic(a="ipc_apollo_stop_record_msg")
  public void stopRecordMsg(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    boolean bool = ((amme)paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a().c();
    paramashy = new Bundle();
    if (bool) {}
    for (int i = 0;; i = 1)
    {
      paramashy.putInt("result", i);
      localBundle.putBundle("response", paramashy);
      localMessengerService.a(localBundle);
      return;
    }
  }
  
  @asic(a="ipc_apollo_update_apollopandora")
  public void updateApolloPandora(@NonNull ashy paramashy)
  {
    Object localObject1 = paramashy.jdField_a_of_type_AndroidOsBundle;
    localObject1 = paramashy.b;
    Object localObject2 = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = (amme)paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    localObject2 = ((Bundle)localObject1).getString("apollo_uin");
    long l = ((Bundle)localObject1).getLong("apollo_checkPoint");
    short s = ((Bundle)localObject1).getShort("apollo_hadStolen");
    localObject1 = paramashy.a((String)localObject2, true);
    if (localObject1 != null)
    {
      ((ApolloPandora)localObject1).checkPoint = l;
      ((ApolloPandora)localObject1).updateTime = System.currentTimeMillis();
      ((ApolloPandora)localObject1).hadStolen = s;
      paramashy.a((ApolloPandora)localObject1);
    }
  }
  
  @asic(a="ipc_apollo_update_game_list")
  public void updateGameList(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramashy.b;
    localObject = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = localBundle.getBundle("request").getString("gameListJson");
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, new Object[] { "IPC_APOLLO_UPDATE_GAME_LIST, update game list, gameListStr=", str });
    }
    if (!android.text.TextUtils.isEmpty(str)) {
      ThreadManager.post(new CmShowModule.17(this, str, paramashy, localBundle, (MessengerService)localObject), 5, null, false);
    }
  }
  
  @asic(a="ipc_apollo_update_avatar_info")
  public void updateUseAvatarInfo(@NonNull ashy paramashy)
  {
    Object localObject1 = paramashy.b;
    Object localObject2 = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramashy = ((Bundle)localObject1).getString("uin");
    long l = ((Bundle)localObject1).getLong("avatarTs", 0L);
    localObject1 = ((Bundle)localObject1).getIntArray("dressId");
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder("apollo info uin: ").append(paramashy).append(", avatarTs: ").append(l);
    Object localObject3;
    int i;
    if (!android.text.TextUtils.isEmpty(paramashy))
    {
      localObject2 = (amme)((QQAppInterface)localObject2).getManager(QQManagerFactory.APOLLO_MANAGER);
      localObject3 = ((amme)localObject2).b(paramashy);
      if ((localObject3 != null) && (((ApolloBaseInfo)localObject3).getApolloDress() != null) && (((ApolloBaseInfo)localObject3).apolloLocalTS == ((ApolloBaseInfo)localObject3).apolloServerTS)) {
        break label160;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        ((amme)localObject2).a(paramashy, 2);
        localStringBuilder.append(", sendReq");
      }
      QLog.d("CmShowHandler", 2, localStringBuilder.toString());
      return;
      label160:
      if ((l != 0L) && (l != ((ApolloBaseInfo)localObject3).apolloServerTS))
      {
        i = 1;
      }
      else
      {
        i = j;
        if (localObject1 != null)
        {
          localObject3 = ((ApolloBaseInfo)localObject3).getApolloDress().a();
          i = j;
          if (localObject3 != null)
          {
            i = j;
            if (!ApolloUtil.a((int[])localObject3, (int[])localObject1)) {
              i = 1;
            }
          }
        }
      }
    }
  }
  
  @asic(a="ipc_apollo_upload_record_msg")
  public void uploadRecordMsg(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramashy = paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ThreadManagerV2.getUIHandlerV2().post(new CmShowModule.2(this, paramashy, localBundle, localMessengerService));
  }
  
  @asic(a="ipc_apollo_write_local")
  public void writeLocal(@NonNull ashy paramashy)
  {
    Bundle localBundle = paramashy.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramashy.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManager.post(new CmShowModule.12(this, paramashy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle.getBundle("request").getString("writeData"), localBundle, localMessengerService), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule
 * JD-Core Version:    0.7.0.1
 */