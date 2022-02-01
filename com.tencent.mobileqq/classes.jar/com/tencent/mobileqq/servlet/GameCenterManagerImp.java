package com.tencent.mobileqq.servlet;

import KQQ.PluginInfo;
import OnlinePushPack.MsgInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.common.util.ScreenshotManager;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x11c.MsgBody;

public class GameCenterManagerImp
  implements Manager
{
  private QQAppInterface a;
  private SharedPreferences b;
  private ArrayList<Long> c;
  private HashMap<Long, GameCenterManagerImp.UnreadData> d;
  private PadFaceManager e;
  
  public GameCenterManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQAppInterface.getApp().getSharedPreferences("gamecenter_prefername", 0);
    c();
    this.e = new PadFaceManager(paramQQAppInterface);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterManagerImp", 2, "loadGameCenterUnread.");
    }
    this.c = new ArrayList();
    this.d = new HashMap();
    String str = this.a.getAccount();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = this.b;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("gc_pluginid");
      localStringBuilder1.append(str);
      localObject = ((SharedPreferences)localObject).getString(localStringBuilder1.toString(), null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split("&");
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          while (i < localObject.length)
          {
            localStringBuilder1 = localObject[i];
            try
            {
              long l = Long.parseLong(localStringBuilder1);
              if (l > 0L)
              {
                GameCenterManagerImp.UnreadData localUnreadData = new GameCenterManagerImp.UnreadData(this);
                SharedPreferences localSharedPreferences = this.b;
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("gc_unread");
                localStringBuilder2.append(str);
                localStringBuilder2.append("_");
                localStringBuilder2.append(localStringBuilder1);
                localUnreadData.a = localSharedPreferences.getLong(localStringBuilder2.toString(), 0L);
                localSharedPreferences = this.b;
                localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("gc_newmsg");
                localStringBuilder2.append(str);
                localStringBuilder2.append("_");
                localStringBuilder2.append(localStringBuilder1);
                localUnreadData.b = localSharedPreferences.getBoolean(localStringBuilder2.toString(), false);
                localSharedPreferences = this.b;
                localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("gc_redpoint");
                localStringBuilder2.append(str);
                localStringBuilder2.append("_");
                localStringBuilder2.append(localStringBuilder1);
                localUnreadData.e = localSharedPreferences.getBoolean(localStringBuilder2.toString(), false);
                localSharedPreferences = this.b;
                localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("gc_tab");
                localStringBuilder2.append(str);
                localStringBuilder2.append("_");
                localStringBuilder2.append(localStringBuilder1);
                localUnreadData.f = localSharedPreferences.getBoolean(localStringBuilder2.toString(), false);
                localSharedPreferences = this.b;
                localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("gc_text");
                localStringBuilder2.append(str);
                localStringBuilder2.append("_");
                localStringBuilder2.append(localStringBuilder1);
                localUnreadData.c = localSharedPreferences.getString(localStringBuilder2.toString(), "");
                localSharedPreferences = this.b;
                localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("gc_icon");
                localStringBuilder2.append(str);
                localStringBuilder2.append("_");
                localStringBuilder2.append(localStringBuilder1);
                localUnreadData.d = localSharedPreferences.getString(localStringBuilder2.toString(), "");
                localSharedPreferences = this.b;
                localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("gc_type");
                localStringBuilder2.append(str);
                localStringBuilder2.append("_");
                localStringBuilder2.append(localStringBuilder1);
                localUnreadData.g = localSharedPreferences.getInt(localStringBuilder2.toString(), -1);
                this.c.add(Long.valueOf(l));
                this.d.put(Long.valueOf(l), localUnreadData);
              }
            }
            catch (Exception localException)
            {
              label644:
              break label644;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void d()
  {
    if ((this.c != null) && (this.d != null))
    {
      String str2 = this.a.getAccount();
      SharedPreferences.Editor localEditor = this.b.edit();
      Object localObject1 = this.c.iterator();
      String str1 = "";
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Long)((Iterator)localObject1).next()).longValue();
        if (this.d.containsKey(Long.valueOf(l)))
        {
          if (str1.length() > 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append("&");
            ((StringBuilder)localObject2).append(l);
            str1 = ((StringBuilder)localObject2).toString();
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append(l);
            str1 = ((StringBuilder)localObject2).toString();
          }
          Object localObject2 = (GameCenterManagerImp.UnreadData)this.d.get(Long.valueOf(l));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("gc_unread");
          localStringBuilder.append(str2);
          localStringBuilder.append("_");
          localStringBuilder.append(l);
          localEditor.putLong(localStringBuilder.toString(), ((GameCenterManagerImp.UnreadData)localObject2).a);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("gc_newmsg");
          localStringBuilder.append(str2);
          localStringBuilder.append("_");
          localStringBuilder.append(l);
          localEditor.putBoolean(localStringBuilder.toString(), ((GameCenterManagerImp.UnreadData)localObject2).b);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("gc_redpoint");
          localStringBuilder.append(str2);
          localStringBuilder.append("_");
          localStringBuilder.append(l);
          localEditor.putBoolean(localStringBuilder.toString(), ((GameCenterManagerImp.UnreadData)localObject2).e);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("gc_tab");
          localStringBuilder.append(str2);
          localStringBuilder.append("_");
          localStringBuilder.append(l);
          localEditor.putBoolean(localStringBuilder.toString(), ((GameCenterManagerImp.UnreadData)localObject2).f);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("gc_text");
          localStringBuilder.append(str2);
          localStringBuilder.append("_");
          localStringBuilder.append(l);
          localEditor.putString(localStringBuilder.toString(), ((GameCenterManagerImp.UnreadData)localObject2).c);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("gc_icon");
          localStringBuilder.append(str2);
          localStringBuilder.append("_");
          localStringBuilder.append(l);
          localEditor.putString(localStringBuilder.toString(), ((GameCenterManagerImp.UnreadData)localObject2).d);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("gc_type");
          localStringBuilder.append(str2);
          localStringBuilder.append("_");
          localStringBuilder.append(l);
          localEditor.putInt(localStringBuilder.toString(), ((GameCenterManagerImp.UnreadData)localObject2).g);
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("gc_pluginid");
      ((StringBuilder)localObject1).append(str2);
      localEditor.putString(((StringBuilder)localObject1).toString(), str1);
      localEditor.commit();
    }
  }
  
  public int a(String paramString)
  {
    paramString = ((IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(paramString);
    if ((paramString != null) && (paramString.iNewFlag.get() != 0)) {
      return paramString.type.get();
    }
    return -1;
  }
  
  public void a()
  {
    SharedPreferences localSharedPreferences = this.a.getApp().getSharedPreferences("check_update_sp_key", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_check_update_interval_");
    localStringBuilder.append(this.a.getCurrentAccountUin());
    int i = localSharedPreferences.getInt(localStringBuilder.toString(), 600);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_last_check_update_timestamp_");
    localStringBuilder.append(this.a.getCurrentAccountUin());
    int j = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    int k = (int)(System.currentTimeMillis() / 1000L);
    if ((k - j > i) || (k < j)) {
      ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getCheckUpdate(true, 2);
    }
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.d.containsKey(Long.valueOf(paramLong1)))
    {
      Object localObject = (GameCenterManagerImp.UnreadData)this.d.get(Long.valueOf(paramLong1));
      ((GameCenterManagerImp.UnreadData)localObject).b = paramBoolean;
      ((GameCenterManagerImp.UnreadData)localObject).a = paramLong2;
      this.d.put(Long.valueOf(paramLong1), localObject);
      d();
      localObject = new NewIntent(this.a.getApplication(), GameCenterServlet.class);
      ((NewIntent)localObject).setAction("gc_refresh_ui");
      if ((paramLong2 <= 0L) && (!paramBoolean)) {
        ((NewIntent)localObject).putExtra("gc_notify_type", 3);
      } else if (paramLong2 > 0L) {
        ((NewIntent)localObject).putExtra("gc_notify_type", 0);
      } else {
        ((NewIntent)localObject).putExtra("gc_notify_type", 1);
      }
      this.a.startServlet((NewIntent)localObject);
    }
  }
  
  public void a(MsgBody paramMsgBody, MsgInfo paramMsgInfo)
  {
    if (paramMsgBody == null) {
      return;
    }
    int i = paramMsgBody.uint32_cmd.get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("++++onReceivePushMsg cmd=");
      localStringBuilder.append(i);
      QLog.d("GameCenterManagerImp", 2, localStringBuilder.toString());
    }
    switch (i)
    {
    case 7: 
    default: 
      return;
    case 9: 
      try
      {
        paramMsgBody = new JSONObject(paramMsgBody.bytes_data.get().toStringUtf8());
        if (QLog.isColorLevel())
        {
          paramMsgInfo = new StringBuilder();
          paramMsgInfo.append("gamePaNotice: ");
          paramMsgInfo.append(paramMsgBody);
          QLog.i("GameCenterManagerImp", 2, paramMsgInfo.toString());
        }
        ((IGamePubAccountMsgService)this.a.getRuntimeService(IGamePubAccountMsgService.class, "")).startShowGamePaNoticeMsgByPush(paramMsgBody);
        return;
      }
      catch (Throwable paramMsgBody)
      {
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("onReceivePushMsg gamePaNotice push e= ");
        paramMsgInfo.append(paramMsgBody.toString());
        QLog.e("GameCenterMsg.GameMsgChatPie.strangerRecom", 1, paramMsgInfo.toString());
        return;
      }
    case 8: 
      try
      {
        paramMsgBody = new JSONObject(paramMsgBody.bytes_data.get().toStringUtf8());
        paramMsgInfo = paramMsgBody.optString("gameId");
        i = paramMsgBody.optInt("switchType");
        int j = paramMsgBody.optInt("value");
        ((IGameMsgManagerService)this.a.getRuntimeService(IGameMsgManagerService.class, "")).onGameSwitchChange(paramMsgInfo, i, j);
        return;
      }
      catch (Throwable paramMsgBody)
      {
        QLog.e("GameCenterManagerImp", 1, paramMsgBody, new Object[0]);
        return;
      }
    case 6: 
      if (this.a == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterManagerImp", 2, "onReceivePushMsg preload Hippy");
      }
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).predownloadHippy(2);
      return;
    case 5: 
      try
      {
        paramMsgBody = new JSONObject(paramMsgBody.bytes_data.get().toStringUtf8());
        GameMsgGrayTipsHandler.a(this.a, paramMsgBody, paramMsgInfo.lMsgUid);
        return;
      }
      catch (Throwable paramMsgBody)
      {
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("onReceivePushMsg gameMsgTips push e=");
        paramMsgInfo.append(paramMsgBody.toString());
        QLog.e("GameCenterMsg.GameMsgChatPie.strangerRecom", 1, paramMsgInfo.toString());
        return;
      }
    case 4: 
      paramMsgBody = paramMsgBody.bytes_data.get().toStringUtf8();
      ((IQQGameCheckService)this.a.getRuntimeService(IQQGameCheckService.class, "")).handlePushTgpa(paramMsgBody);
      return;
    case 3: 
      try
      {
        i = new JSONObject(paramMsgBody.bytes_data.get().toStringUtf8()).optInt("subCmd");
        paramMsgBody = new GameCenterManagerImp.1(this, i);
        if (i == 1)
        {
          ScreenshotManager.a().b(paramMsgBody);
          return;
        }
        if (i == 2)
        {
          ScreenshotManager.a().c(paramMsgBody);
          return;
        }
        if (i != 3) {
          return;
        }
        ScreenshotManager.a().d(paramMsgBody);
        return;
      }
      catch (JSONException paramMsgBody)
      {
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("onReceivePushMsg screenshot push e=");
        paramMsgInfo.append(paramMsgBody.toString());
        QLog.e("GameCenterManagerImp", 1, paramMsgInfo.toString());
        return;
      }
    case 2: 
      paramMsgBody = paramMsgBody.bytes_data.get().toStringUtf8();
      ((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).handlePushConfigCheck(paramMsgBody);
      return;
    }
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).getAutoDownloadApk();
    GameCenterUtils.a(this.a, "426", "205581", "", "42601", "1", "116");
  }
  
  public boolean a(long paramLong)
  {
    if (this.d.containsKey(Long.valueOf(paramLong))) {
      return ((GameCenterManagerImp.UnreadData)this.d.get(Long.valueOf(paramLong))).b;
    }
    return false;
  }
  
  public boolean a(List<PluginInfo> paramList)
  {
    int j;
    if ((paramList != null) && (paramList.size() > 0))
    {
      int k = 0;
      int i = -1;
      boolean bool3;
      for (boolean bool1 = false; k < paramList.size(); bool1 = bool3)
      {
        Object localObject1 = (PluginInfo)paramList.get(k);
        int m = i;
        bool3 = bool1;
        if (localObject1 != null) {
          if (this.d.get(Long.valueOf(((PluginInfo)localObject1).Id)) == null)
          {
            m = i;
            bool3 = bool1;
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("setNewUnread.i=");
              ((StringBuilder)localObject2).append(k);
              ((StringBuilder)localObject2).append(",plugin:");
              ((StringBuilder)localObject2).append(((PluginInfo)localObject1).toString());
              QLog.d("GameCenterManagerImp", 2, ((StringBuilder)localObject2).toString());
            }
            Object localObject2 = (GameCenterManagerImp.UnreadData)this.d.get(Long.valueOf(((PluginInfo)localObject1).Id));
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("setNewUnread.i=");
              localStringBuilder.append(k);
              localStringBuilder.append(",before unreaddata:");
              localStringBuilder.append(((GameCenterManagerImp.UnreadData)localObject2).toString());
              QLog.d("GameCenterManagerImp", 2, localStringBuilder.toString());
            }
            boolean bool2;
            if (((PluginInfo)localObject1).Count > 0L)
            {
              j = i;
              if (((GameCenterManagerImp.UnreadData)localObject2).a != ((PluginInfo)localObject1).Count)
              {
                if (((PluginInfo)localObject1).Tab) {
                  i = 0;
                }
                bool1 = true;
                j = i;
              }
              ((GameCenterManagerImp.UnreadData)localObject2).a = ((PluginInfo)localObject1).Count;
              ((GameCenterManagerImp.UnreadData)localObject2).c = ((PluginInfo)localObject1).Text;
              ((GameCenterManagerImp.UnreadData)localObject2).b = false;
              ((GameCenterManagerImp.UnreadData)localObject2).e = false;
              if (TextUtils.isEmpty(((GameCenterManagerImp.UnreadData)localObject2).c)) {
                ((GameCenterManagerImp.UnreadData)localObject2).g = 1;
              } else {
                ((GameCenterManagerImp.UnreadData)localObject2).g = 4;
              }
              ((GameCenterManagerImp.UnreadData)localObject2).f = ((PluginInfo)localObject1).Tab;
              bool2 = bool1;
            }
            else if (((PluginInfo)localObject1).Flag)
            {
              if (((GameCenterManagerImp.UnreadData)localObject2).a > 0L)
              {
                m = i;
                bool3 = bool1;
                break label764;
              }
              j = i;
              if (!((GameCenterManagerImp.UnreadData)localObject2).b)
              {
                j = i;
                if (((PluginInfo)localObject1).Tab) {
                  if (i != -1)
                  {
                    j = i;
                    if (i != 4) {}
                  }
                  else
                  {
                    j = 1;
                  }
                }
                bool1 = true;
              }
              ((GameCenterManagerImp.UnreadData)localObject2).b = ((PluginInfo)localObject1).Flag;
              ((GameCenterManagerImp.UnreadData)localObject2).e = false;
              ((GameCenterManagerImp.UnreadData)localObject2).a = 0L;
              ((GameCenterManagerImp.UnreadData)localObject2).c = ((PluginInfo)localObject1).Text;
              if (TextUtils.isEmpty(((GameCenterManagerImp.UnreadData)localObject2).c)) {
                ((GameCenterManagerImp.UnreadData)localObject2).g = 3;
              } else {
                ((GameCenterManagerImp.UnreadData)localObject2).g = 6;
              }
              ((GameCenterManagerImp.UnreadData)localObject2).f = ((PluginInfo)localObject1).Tab;
              bool2 = bool1;
            }
            else
            {
              j = i;
              bool2 = bool1;
              if (((PluginInfo)localObject1).RedPoint)
              {
                if (((GameCenterManagerImp.UnreadData)localObject2).a > 0L)
                {
                  m = i;
                  bool3 = bool1;
                  break label764;
                }
                if ((((PluginInfo)localObject1).Id == 769L) && (((GameCenterManagerImp.UnreadData)localObject2).b))
                {
                  m = i;
                  bool3 = bool1;
                  break label764;
                }
                j = i;
                if (!((GameCenterManagerImp.UnreadData)localObject2).e)
                {
                  j = i;
                  if (i == -1)
                  {
                    j = i;
                    if (((PluginInfo)localObject1).Tab) {
                      j = 4;
                    }
                  }
                  bool1 = true;
                }
                ((GameCenterManagerImp.UnreadData)localObject2).e = ((PluginInfo)localObject1).RedPoint;
                ((GameCenterManagerImp.UnreadData)localObject2).b = false;
                ((GameCenterManagerImp.UnreadData)localObject2).a = 0L;
                ((GameCenterManagerImp.UnreadData)localObject2).c = ((PluginInfo)localObject1).Text;
                ((GameCenterManagerImp.UnreadData)localObject2).d = ((PluginInfo)localObject1).PicUrl;
                if (TextUtils.isEmpty(((GameCenterManagerImp.UnreadData)localObject2).c))
                {
                  if (TextUtils.isEmpty(((GameCenterManagerImp.UnreadData)localObject2).d)) {
                    ((GameCenterManagerImp.UnreadData)localObject2).g = 2;
                  } else {
                    ((GameCenterManagerImp.UnreadData)localObject2).g = 7;
                  }
                }
                else {
                  ((GameCenterManagerImp.UnreadData)localObject2).g = 5;
                }
                ((GameCenterManagerImp.UnreadData)localObject2).f = ((PluginInfo)localObject1).Tab;
                bool2 = bool1;
              }
            }
            m = j;
            bool3 = bool2;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("setNewUnread.i=");
              ((StringBuilder)localObject1).append(k);
              ((StringBuilder)localObject1).append(",unreaddata:");
              ((StringBuilder)localObject1).append(((GameCenterManagerImp.UnreadData)localObject2).toString());
              QLog.d("GameCenterManagerImp", 2, ((StringBuilder)localObject1).toString());
              bool3 = bool2;
              m = j;
            }
          }
        }
        label764:
        k += 1;
        i = m;
      }
      d();
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("setNewUnread.changeType=");
        paramList.append(i);
        paramList.append(",ischange:");
        paramList.append(bool1);
        QLog.d("GameCenterManagerImp", 2, paramList.toString());
      }
      if (i != -1)
      {
        paramList = new NewIntent(this.a.getApplication(), GameCenterServlet.class);
        paramList.setAction("gc_refresh_ui");
        paramList.putExtra("gc_notify_type", i);
        this.a.startServlet(paramList);
        j = i;
      }
      else
      {
        j = i;
        if (bool1)
        {
          paramList = new NewIntent(this.a.getApplication(), GameCenterServlet.class);
          paramList.setAction("gc_refresh_ui");
          paramList.putExtra("gc_notify_type", 3);
          this.a.startServlet(paramList);
          j = i;
        }
      }
    }
    else
    {
      j = -1;
    }
    return j != -1;
  }
  
  public PadFaceManager b()
  {
    return this.e;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterManagerImp", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GameCenterManagerImp
 * JD-Core Version:    0.7.0.1
 */