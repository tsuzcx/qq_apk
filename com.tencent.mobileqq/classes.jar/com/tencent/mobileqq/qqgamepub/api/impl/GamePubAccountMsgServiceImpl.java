package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameMsgParser;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreloadConfBean;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreloadConfProcessor;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountMessage;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class GamePubAccountMsgServiceImpl
  extends Observable
  implements IGamePubAccountMsgService
{
  public static final String KEY_MESSAGE_NOTICE_FLAG = "game_pa_notice_msg_flag";
  private static final String MESSAGE_NOTICE_FLAG = "1";
  private static final int MSG_NOTICE_DISPLAY = 1;
  private static final int MSG_TYPE_ALL = 0;
  private static final int MSG_TYPE_ARK = 1;
  private static final int MSG_TYPE_STRUCT = 2;
  public static final String TAG = "QQGamePub_GamePubAccountMsgServiceImpl";
  private AppRuntime mApp;
  
  private boolean canShowMsgSummary(JSONObject paramJSONObject)
  {
    boolean bool3 = false;
    for (;;)
    {
      try
      {
        boolean bool4 = GamePubAccountHelper.b();
        if (paramJSONObject.optJSONObject("outer").optInt("display") == 1)
        {
          bool1 = true;
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("canHandle--->is hippy v2 : ");
          paramJSONObject.append(bool4);
          paramJSONObject.append(" isDisplay: ");
          paramJSONObject.append(bool1);
          QLog.i("QQGamePub_GamePubAccountMsgServiceImpl", 1, paramJSONObject.toString());
          boolean bool2 = bool3;
          if (bool4)
          {
            bool2 = bool3;
            if (bool1) {
              bool2 = true;
            }
          }
          return bool2;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("QQGamePub_GamePubAccountMsgServiceImpl", 1, paramJSONObject, new Object[0]);
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  private ArrayList<QQGameMsgInfo> findMessageFromCache(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    Object localObject1;
    if (paramInt1 == 1) {
      localObject1 = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getAllMessages(paramString, 1008, new int[] { -5008 }, paramInt3);
    } else if (paramInt1 == 2) {
      localObject1 = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getAllMessages(paramString, 1008, new int[] { -2011 }, paramInt3);
    } else {
      localObject1 = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getMessages(paramString, 1008, paramInt3);
    }
    if (localObject1 != null) {
      paramInt3 = ((List)localObject1).size();
    } else {
      paramInt3 = 0;
    }
    if (paramInt3 > 0)
    {
      j = paramInt3 - 1;
      paramInt1 = i;
      i = j;
      for (;;)
      {
        j = paramInt1;
        if (paramInt2 <= paramInt1) {
          break;
        }
        j = paramInt1;
        if (i < 0) {
          break;
        }
        Object localObject2 = (MessageRecord)((List)localObject1).get(i);
        j = paramInt1;
        if ("2747277822".equals(((MessageRecord)localObject2).frienduin))
        {
          localObject2 = ((IQQGameMsgParser)QRoute.api(IQQGameMsgParser.class)).parseMessageRecord((MessageRecord)localObject2);
          j = paramInt1;
          if (localObject2 != null) {
            if (!isInterceptMsg((QQGameMsgInfo)localObject2))
            {
              localArrayList.add(localObject2);
              j = paramInt1 + 1;
            }
            else
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("qqGameMsgInfo adid=");
              localStringBuilder.append(((QQGameMsgInfo)localObject2).advId);
              localStringBuilder.append(" intercept!!!!");
              QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, localStringBuilder.toString());
              j = paramInt1;
            }
          }
        }
        i -= 1;
        paramInt1 = j;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("findMessage gameTroopUin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",listSize=");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(",size=");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  private boolean isInterceptMsg(QQGameMsgInfo paramQQGameMsgInfo)
  {
    if (paramQQGameMsgInfo == null) {
      return true;
    }
    Object localObject = QQGamePreloadConfProcessor.a();
    if (((QQGamePreloadConfBean)localObject).f != null)
    {
      Iterator localIterator = ((QQGamePreloadConfBean)localObject).f.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (paramQQGameMsgInfo.advId.equals(localObject))
        {
          paramQQGameMsgInfo = new StringBuilder();
          paramQQGameMsgInfo.append("adid:");
          paramQQGameMsgInfo.append((String)localObject);
          paramQQGameMsgInfo.append(" is intercept msg");
          QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, paramQQGameMsgInfo.toString());
          return true;
        }
      }
    }
    return false;
  }
  
  private void showNoticeMsgSummaryAndRedPoint(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("outer");
    MessageRecord localMessageRecord = new MessageRecord();
    localMessageRecord.selfuin = this.mApp.getCurrentAccountUin();
    localMessageRecord.frienduin = "2747277822";
    localMessageRecord.senderuin = "";
    localMessageRecord.time = paramJSONObject.optLong("ts");
    localMessageRecord.msg = localJSONObject.optString("text");
    localMessageRecord.saveExtInfoToExtStr("game_pa_notice_msg_flag", "1");
    paramJSONObject = new ArrayList();
    paramJSONObject.add(localMessageRecord);
    ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).addMessage(paramJSONObject, this.mApp.getCurrentAccountUin(), this.mApp.isBackgroundStop);
  }
  
  public void clearUnreadMsg(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearUnreadMsg gameTroopUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = (IConversationFacade)this.mApp.getRuntimeService(IConversationFacade.class, "");
    ((IConversationFacade)localObject).cleanUnread(paramString, 1008, ((IConversationFacade)localObject).getLastRead(paramString, 1008), false);
  }
  
  public void deleteMsg(String paramString, int paramInt, long paramLong)
  {
    ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(paramString, paramInt, paramLong);
  }
  
  public ArrayList<QQGameMsgInfo> findArkMessage(String paramString, int paramInt1, int paramInt2)
  {
    return findMessageFromCache(paramString, 1, paramInt1, paramInt2);
  }
  
  public ArrayList<QQGameMsgInfo> findMessage(String paramString, int paramInt)
  {
    return findMessage(paramString, paramInt, 15);
  }
  
  public ArrayList<QQGameMsgInfo> findMessage(String paramString, int paramInt1, int paramInt2)
  {
    return findMessageFromCache(paramString, 0, paramInt1, paramInt2);
  }
  
  public ArrayList<QQGameMsgInfo> findStructMessage(String paramString, int paramInt1, int paramInt2)
  {
    return findMessageFromCache(paramString, 2, paramInt1, paramInt2);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    deleteObservers();
  }
  
  public void onGameNewMsg(List<MessageRecord> paramList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGameNewMsg mrList=");
      ((StringBuilder)localObject1).append(paramList);
      QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, ((StringBuilder)localObject1).toString());
    }
    if (paramList != null) {
      try
      {
        if (paramList.size() > 0)
        {
          localObject1 = new ArrayList();
          paramList = paramList.iterator();
          Object localObject2;
          while (paramList.hasNext())
          {
            localObject2 = (MessageRecord)paramList.next();
            if ("2747277822".equals(((MessageRecord)localObject2).frienduin))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, "enter qqgame message handle");
              }
              paramList = ((IQQGameMsgParser)QRoute.api(IQQGameMsgParser.class)).parseMessageRecord((MessageRecord)localObject2);
              if (!isInterceptMsg(paramList))
              {
                if (paramList != null) {
                  ((ArrayList)localObject1).add(paramList);
                } else if (QLog.isColorLevel()) {
                  QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, "parse qqgame message fail");
                }
              }
              else if (paramList != null)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("delete qqgame message adid=");
                ((StringBuilder)localObject2).append(paramList.advId);
                QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, ((StringBuilder)localObject2).toString());
                deleteMsg(paramList.frienduin, paramList.istroop, paramList.uniseq);
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramList = new StringBuilder();
            paramList.append("onGameNewMsg qqGameMsgInfoList=");
            paramList.append(localObject1);
            QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, paramList.toString());
          }
          if (((ArrayList)localObject1).size() > 0)
          {
            setChanged();
            notifyObservers(new GamePubAccountMessage("action_qgame_tool_messgae", localObject1));
            paramList = new Intent("action_qgame_tool_messgae");
            paramList.setPackage(MobileQQ.sMobileQQ.getPackageName());
            localObject2 = new Bundle();
            ((Bundle)localObject2).putSerializable("key_get_msg", (Serializable)localObject1);
            paramList.putExtras((Bundle)localObject2);
            MobileQQ.sMobileQQ.sendBroadcast(paramList);
            paramList = (QQGameMsgInfo)((ArrayList)localObject1).get(0);
            if ((paramList.isAdMsg) && (paramList.adJson != null)) {
              ((IQQGameAdService)QRoute.api(IQQGameAdService.class)).reportGdt(paramList, 1);
            }
            ((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).preDownloadPubPushRes((List)localObject1);
            return;
          }
        }
      }
      catch (Throwable paramList)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("send qqgame message fail by:");
          ((StringBuilder)localObject1).append(paramList.getMessage());
          QLog.d("QQGamePub_GamePubAccountMsgServiceImpl", 1, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  public void saveGalleryDataToMsg(Bundle paramBundle)
  {
    ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).saveGalleryDataToMsg(this.mApp, paramBundle);
  }
  
  public void showFirstOperationMsg()
  {
    IMessageFacade localIMessageFacade = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
    Object localObject1 = localIMessageFacade.getAllMessages("2747277822", 1008, new int[0]);
    if (!((List)localObject1).isEmpty())
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("current msg size: ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.i("QQGamePub_GamePubAccountMsgServiceImpl", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        String str = ((MessageRecord)localObject2).getExtInfoFromExtStr("game_pa_notice_msg_flag");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((MessageRecord)localObject2).msg);
          localStringBuilder.append("--->");
          localStringBuilder.append(((MessageRecord)localObject2).extStr);
          QLog.i("QQGamePub_GamePubAccountMsgServiceImpl", 2, localStringBuilder.toString());
        }
        if ("1".equals(str)) {
          localIMessageFacade.removeMsgByMessageRecord((MessageRecord)localObject2, true);
        }
      }
    }
  }
  
  public void startShowGamePaNoticeMsgByPush(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.i("QQGamePub_GamePubAccountMsgServiceImpl", 2, "startShowGamePaNoticeMsgByPush --> param notice is empty!!!");
      return;
    }
    boolean bool = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isPubAccountReceiveMsg((AppInterface)this.mApp);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startShowGamePaNoticeMsgByPush --> isFlowPa: ");
    localStringBuilder.append(bool);
    QLog.i("QQGamePub_GamePubAccountMsgServiceImpl", 2, localStringBuilder.toString());
    if (!bool) {
      return;
    }
    if (canShowMsgSummary(paramJSONObject)) {
      showNoticeMsgSummaryAndRedPoint(paramJSONObject);
    }
    if (GamePubAccountHelper.b()) {
      GamePubAccountHelper.a(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.GamePubAccountMsgServiceImpl
 * JD-Core Version:    0.7.0.1
 */