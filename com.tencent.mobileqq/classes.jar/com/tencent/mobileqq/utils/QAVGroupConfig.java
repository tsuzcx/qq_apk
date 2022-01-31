package com.tencent.mobileqq.utils;

import ajpk;
import ajpl;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class QAVGroupConfig
{
  private static QAVGroupConfig.ConfigInfo a;
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return Math.min(SharedPreUtils.ah(paramQQAppInterface.getApp(), paramString), a().c);
  }
  
  static int a(TroopInfo paramTroopInfo)
  {
    int i = paramTroopInfo.wMemberNumClient;
    if (AudioHelper.e()) {
      QLog.w("QAVGroupConfig", 1, "getMemberNum, troopuin[" + paramTroopInfo.troopuin + "], wMemberNumClient[" + paramTroopInfo.wMemberNumClient + "], wMemberNum[" + paramTroopInfo.wMemberNum + "], uin[" + paramTroopInfo.uin + "], troopcode[" + paramTroopInfo.troopcode + "]");
    }
    return i;
  }
  
  static SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.qavgroup", 4);
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    int i = paramQQAppInterface.b(paramBundle);
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("mask", i);
    QLog.w("QAVGroupConfig", 1, "getGroupMask, uin[" + paramBundle + "], mask[" + i + "]");
    return paramQQAppInterface;
  }
  
  public static QAVGroupConfig.ConfigInfo a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a = QAVGroupConfig.ConfigInfo.a(a().getString("config", null));
        if (a == null) {
          a = new QAVGroupConfig.ConfigInfo();
        }
      }
      return a;
    }
    finally {}
  }
  
  public static void a(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null)
    {
      QLog.d("QAVGroupConfig", 1, "handleResp_Config, config is null");
      return;
    }
    SharedPreferences localSharedPreferences = a();
    if (!TextUtils.isEmpty(localSharedPreferences.getString("config", null))) {}
    for (int j = localSharedPreferences.getInt("ver", 0);; j = 0)
    {
      if (paramConfig.msg_content_list != null) {}
      int i2;
      for (int k = paramConfig.msg_content_list.size();; k = -1)
      {
        i2 = paramConfig.version.get();
        if (QLog.isColorLevel()) {
          QLog.w("QAVGroupConfig", 1, "handleResp_Config, serverVersion[" + i2 + "], localVersion[" + j + "], size[" + k + "]");
        }
        if (i2 == j) {
          break;
        }
        if ((k > 0) || (i2 == 0)) {
          break label196;
        }
        localSharedPreferences.edit().putString("config", "");
        localSharedPreferences.edit().putInt("ver", i2);
        localSharedPreferences.edit().commit();
        return;
      }
      label196:
      Object localObject3 = null;
      Object localObject4 = null;
      int i = 0;
      int m = 0;
      int i1;
      Object localObject5;
      label428:
      label557:
      Object localObject2;
      if (m < k)
      {
        paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(m);
        if (paramIntent != null)
        {
          i1 = paramIntent.task_id.get();
          localObject5 = paramIntent.content.get();
          if (localObject5 != null)
          {
            Object localObject1 = "";
            if (paramIntent.compress.get() == 1)
            {
              localObject5 = OlympicUtil.a(((ByteStringMicro)localObject5).toByteArray());
              if (localObject5 == null) {}
            }
            for (;;)
            {
              try
              {
                paramIntent = new String((byte[])localObject5, "UTF-8");
                if (TextUtils.isEmpty(paramIntent)) {
                  break label745;
                }
                localObject1 = QAVGroupConfig.ConfigInfo.a(paramIntent);
                if (QLog.isColorLevel()) {
                  QLog.w("QAVGroupConfig", 1, "handleResp_Config, index[" + m + "], task_id[" + i1 + "], serverVersion[" + i2 + "], localVersion[" + j + "], size[" + k + "], ConfigInfo[" + localObject1 + "], jsonContent[" + AudioHelper.a(paramIntent) + "]");
                }
                if (localObject1 == null) {
                  break label712;
                }
                if (i1 != ((QAVGroupConfig.ConfigInfo)localObject1).a) {
                  break label982;
                }
                if ((localObject1 == null) || (TextUtils.isEmpty(paramIntent))) {
                  break;
                }
                try
                {
                  a = (QAVGroupConfig.ConfigInfo)localObject1;
                  localSharedPreferences.edit().putString("config", paramIntent);
                  localSharedPreferences.edit().putInt("ver", i2);
                  localSharedPreferences.edit().putInt("taskid", i1);
                  localSharedPreferences.edit().commit();
                  return;
                }
                finally {}
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break label963;
                }
                paramIntent.printStackTrace();
                paramIntent = "编码失败." + paramIntent.getMessage();
                localObject5 = null;
                localObject1 = paramIntent;
                paramIntent = (Intent)localObject5;
                continue;
              }
              catch (OutOfMemoryError paramIntent)
              {
                if (QLog.isColorLevel())
                {
                  paramIntent.printStackTrace();
                  localObject1 = "内存不足." + paramIntent.getMessage();
                }
                System.gc();
                try
                {
                  paramIntent = new String((byte[])localObject5, "UTF-8");
                }
                catch (Throwable localThrowable)
                {
                  paramIntent = null;
                  localObject2 = "异常1." + localThrowable.getMessage();
                }
                continue;
              }
              catch (Exception paramIntent)
              {
                localObject2 = "异常2." + paramIntent.getMessage();
                paramIntent = null;
                continue;
              }
              localObject2 = "解压失败";
              paramIntent = null;
              continue;
              paramIntent = ((ByteStringMicro)localObject5).toStringUtf8();
              localObject2 = "无压缩";
            }
            label712:
            localObject2 = localObject4;
          }
        }
      }
      for (paramIntent = (Intent)localObject3;; paramIntent = (Intent)localObject3)
      {
        localObject5 = localObject2;
        int n = i;
        for (;;)
        {
          m += 1;
          i = n;
          localObject4 = localObject5;
          localObject3 = paramIntent;
          break;
          label745:
          n = i;
          localObject5 = localObject4;
          paramIntent = (Intent)localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("QAVGroupConfig", 2, String.format("handleResp_Config, err, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s], %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(k), localObject2 }));
            n = i;
            localObject5 = localObject4;
            paramIntent = (Intent)localObject3;
            continue;
            QLog.d("QAVGroupConfig", 1, String.format("handleResp_Config, sub_content为空, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(k) }));
            n = i;
            localObject5 = localObject4;
            paramIntent = (Intent)localObject3;
            continue;
            QLog.d("QAVGroupConfig", 1, String.format("handleResp_Config, content为空, index[%s], serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(k) }));
            n = i;
            localObject5 = localObject4;
            paramIntent = (Intent)localObject3;
          }
        }
        label963:
        paramIntent = "";
        break label557;
        paramIntent = localObject4;
        localObject2 = localObject3;
        i1 = i;
        break label428;
        label982:
        localObject3 = localObject2;
        i = i1;
        localObject2 = paramIntent;
      }
    }
  }
  
  public static void a(ConfigurationService.ConfigSeq paramConfigSeq)
  {
    SharedPreferences localSharedPreferences = a();
    String str = localSharedPreferences.getString("config", null);
    if (!TextUtils.isEmpty(str)) {}
    for (int i = localSharedPreferences.getInt("ver", 0);; i = 0)
    {
      int j = localSharedPreferences.getInt("taskid", 0);
      paramConfigSeq.version.set(i);
      paramConfigSeq.compress.set(1);
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVGroupConfig", 1, "fillVersion, localVersion[" + i + "], configText[" + AudioHelper.a(str) + "], taskid[" + j + "]");
      }
      return;
    }
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    TroopHandler localTroopHandler = (TroopHandler)paramQQAppInterface.a(20);
    if (localTroopHandler == null) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(paramString2);
        if (l == 0L) {
          continue;
        }
        paramString1 = paramString1 + "_" + AudioHelper.a();
        String str = String.valueOf(l);
        paramQQAppInterface.addObserver(new ajpk(l, paramString1, paramQQAppInterface, str));
        localTroopHandler.a(l, 480, 0);
        paramString2 = ((TroopManager)paramQQAppInterface.getManager(51)).b(paramString2);
        if (paramString2.maxInviteMemNum == 0)
        {
          paramQQAppInterface.addObserver(new ajpl(str, paramQQAppInterface, paramString1));
          localTroopHandler.a(str, (byte)1, paramString2.dwTimeStamp, 0);
        }
        QLog.w("QAVGroupConfig", 1, "getGroupInfo[" + paramString1 + "], troopuin[" + l + "], maxInviteMemNum[" + paramString2.maxInviteMemNum + "]");
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, long paramLong)
  {
    boolean bool = false;
    int j = paramVideoAppInterface.a(1, Long.toString(paramLong));
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", String.valueOf(paramLong));
    paramVideoAppInterface = paramVideoAppInterface.a(6, 0, 0, localBundle, null);
    if (paramVideoAppInterface != null) {}
    for (int i = paramVideoAppInterface.getInt("mask", 1);; i = 1)
    {
      if (1 == i)
      {
        if (AudioHelper.d())
        {
          i = AudioHelper.a(6);
          if (i == 1) {
            bool = true;
          }
          while (i == 0) {
            return bool;
          }
        }
        paramVideoAppInterface = a();
        if (j > paramVideoAppInterface.d)
        {
          QLog.w("QAVGroupConfig", 1, "onGAudioInvite, 成员太多, relationId[" + paramLong + "], show_invite_box[" + paramVideoAppInterface.d + "], MemberNum[" + j + "]");
          return false;
        }
        return true;
      }
      QAVGroupConfig.Report.a(i);
      return false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    QAVGroupConfig.ConfigInfo localConfigInfo = a();
    int i;
    boolean bool1;
    if (localConfigInfo.b != 0)
    {
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).b(paramSessionInfo.a);
      if (paramQQAppInterface != null)
      {
        i = a(paramQQAppInterface);
        if (i > localConfigInfo.b) {
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      QLog.w("QAVGroupConfig", 1, "canDirectStart, sessionInfo.curFriendUin[" + paramSessionInfo.a + "], wMemberNum[" + i + "], direct[" + bool1 + "], configInfo[" + localConfigInfo + "]");
      boolean bool2 = bool1;
      if (AudioHelper.d())
      {
        i = AudioHelper.a(7);
        if (i != 1) {
          break label146;
        }
        AudioHelper.a("直接全员发起");
        bool2 = true;
      }
      label146:
      do
      {
        return bool2;
        bool2 = bool1;
      } while (i != 0);
      AudioHelper.a("直接部分发起");
      return false;
      bool1 = true;
      continue;
      bool1 = true;
      i = 0;
    }
  }
  
  public static boolean a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(51)).b(paramString2);
    boolean bool1 = false;
    boolean bool3;
    boolean bool4;
    label53:
    int i;
    label88:
    boolean bool5;
    Object localObject2;
    boolean bool2;
    if (localTroopInfo != null)
    {
      if ((localTroopInfo.dwAdditionalFlag & 1L) != 1L) {
        break label612;
      }
      bool3 = true;
      if ((localTroopInfo.dwCmdUinUinFlag & 1L) != 1L) {
        break label618;
      }
      bool4 = true;
      localObject1 = "";
      i = a(localTroopInfo);
      bool1 = false;
      if ((localTroopInfo.troopPrivilegeFlag & 0x6100000) != 0L) {
        break label624;
      }
      bool1 = true;
      localObject1 = "成员权限-需要管理员审核。";
      bool5 = bool1;
      localObject2 = localObject1;
      if (bool1)
      {
        bool5 = bool1;
        localObject2 = localObject1;
        if (localTroopInfo.isAdmin())
        {
          localObject2 = (String)localObject1 + "但自己是管理员。管理员邀请不需要审批。";
          bool5 = false;
        }
      }
      bool2 = false;
      if (localTroopInfo.maxInviteMemNum < 0) {
        break label745;
      }
      if (0 + i <= Math.min(localTroopInfo.maxInviteMemNum, a().c)) {
        break label733;
      }
      bool1 = true;
      label177:
      bool2 = bool1;
      if (!bool1) {
        break label745;
      }
    }
    for (Object localObject1 = (String)localObject2 + "邀请的人数大于阀值，就需要对方同意。";; localObject1 = localObject2)
    {
      if ((!bool5) && (!bool1)) {}
      for (bool2 = true;; bool2 = false)
      {
        i = a().c;
        boolean bool6 = localTroopInfo.canAutoInviteMemIntoTroop(paramQQAppInterface, i);
        QLog.w("QAVGroupConfig", 1, "getInviteFlag[" + paramString1 + "], groupUin[" + paramString2 + "][" + localTroopInfo.troopname + "], 群禁言时间戳[" + localTroopInfo.dwGagTimeStamp + "], 被禁言到期时间戳[" + localTroopInfo.dwGagTimeStamp_me + "], 群成员数量[" + localTroopInfo.wMemberNum + "], 群成员数量Client[" + localTroopInfo.wMemberNumClient + "], maxInviteMemNum[" + localTroopInfo.maxInviteMemNum + "], 后台配置的最大邀请[" + i + "], mMemberInvitingFlag[" + localTroopInfo.mMemberInvitingFlag + "], isOnlyTroopMemberInviteOption[" + localTroopInfo.isOnlyTroopMemberInviteOption() + "], 允许普通群成员发起临时会话[" + localTroopInfo.isAllowCreateTempConv() + "], 允许普通群成员发起新的群聊[" + localTroopInfo.isAllowCreateDiscuss() + "], 群能力标记位troopPrivilegeFlag[" + localTroopInfo.troopPrivilegeFlag + "], 群标记位dwGroupFlagExt3[" + localTroopInfo.dwGroupFlagExt3 + "], 群的加入方式cGroupOption[" + localTroopInfo.cGroupOption + "], needAdminCheck[" + bool5 + "], needAgree[" + bool1 + "], bOwner[" + bool3 + "_" + localTroopInfo.dwAdditionalFlag + "], bAdmin[" + bool4 + "_" + localTroopInfo.dwCmdUinUinFlag + "], isAdmin[" + localTroopInfo.isAdmin() + "], control[" + bool2 + "], log[" + (String)localObject1 + "], 是否显示邀请入口[" + bool6 + "], 可邀请的最大人数[" + localTroopInfo.getMemNumForAutoInviteIntoGroup(paramQQAppInterface) + "]");
        bool1 = bool6;
        return bool1;
        label612:
        bool3 = false;
        break;
        label618:
        bool4 = false;
        break label53;
        label624:
        if ((localTroopInfo.troopPrivilegeFlag & 0x2000000) == 33554432L)
        {
          if (i + 0 > 50) {}
          for (bool1 = true;; bool1 = false)
          {
            localObject1 = "成员权限-成员数50人内无需审核。";
            break;
          }
        }
        if ((localTroopInfo.troopPrivilegeFlag & 0x4000000) == 67108864L)
        {
          if (i + 0 > 100) {}
          for (bool1 = true;; bool1 = false)
          {
            localObject1 = "成员权限-成员数100人内无需审核。";
            break;
          }
        }
        if ((localTroopInfo.troopPrivilegeFlag & 0x100000) != 1048576L) {
          break label88;
        }
        bool1 = false;
        localObject1 = " 成员权限-无需审核直接进群。";
        break label88;
        label733:
        bool1 = false;
        break label177;
      }
      label745:
      bool1 = bool2;
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((TroopManager)paramQQAppInterface.getManager(51)).b(paramString).getMemNumForAutoInviteIntoGroup(paramQQAppInterface);
  }
  
  public static int c(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(((TroopManager)paramQQAppInterface.getManager(51)).b(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVGroupConfig
 * JD-Core Version:    0.7.0.1
 */