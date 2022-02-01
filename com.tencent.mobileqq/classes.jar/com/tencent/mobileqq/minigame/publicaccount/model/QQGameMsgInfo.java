package com.tencent.mobileqq.minigame.publicaccount.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameMsgInfo
  implements Serializable
{
  public static final int MSG_TYPE_ARK = 1;
  public static final int MSG_TYPE_IMGHEADER = 2;
  public static final int MSG_TYPE_MORE = 4;
  public static final int MSG_TYPE_TEXTHEADER = 3;
  private static final String TAG = "QQGameMsgInfo";
  public String actionUrl;
  public String advId;
  public String arkAppConfig;
  public String arkAppMinVersion;
  public String arkAppName;
  public String arkAppView;
  public String arkMetaList;
  public String contentText;
  public String coverUrl;
  public String dateTitle;
  public String extJson;
  public String frienduin;
  public String gameAppId;
  public String limitText;
  public long msgTime;
  public int msgType;
  public String paMsgid;
  public String sortedConfigs;
  public String taskId;
  public String title;
  public String triggerInfo;
  public long uniseq;
  public String url;
  
  private static void parseArkView(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 1;
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      try
      {
        paramQQGameMsgInfo.arkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
        paramQQGameMsgInfo.arkAppName = paramMessageRecord.ark_app_message.appName;
        paramQQGameMsgInfo.arkAppView = paramMessageRecord.ark_app_message.appView;
        paramQQGameMsgInfo.arkMetaList = paramMessageRecord.ark_app_message.metaList;
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        paramQQGameMsgInfo = new StringBuilder();
        paramQQGameMsgInfo.append("MessageForArkApp error =");
        paramQQGameMsgInfo.append(paramMessageRecord.toString());
        QLog.e("QQGameMsgInfo", 1, paramQQGameMsgInfo.toString());
      }
    }
  }
  
  private static void parseImgHeaderView(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 2;
    boolean bool = paramMessageRecord instanceof MessageForStructing;
    if (!bool) {
      return;
    }
    if (bool)
    {
      paramMessageRecord = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
      int m = 0;
      while (m < paramMessageRecord.size())
      {
        if ((paramMessageRecord.get(m) instanceof AbsStructMsgItem))
        {
          ArrayList localArrayList = ((AbsStructMsgItem)paramMessageRecord.get(m)).ax;
          int n = 0;
          int i = 0;
          int j = 0;
          int k;
          int i1;
          for (;;)
          {
            k = i;
            i1 = j;
            if (n >= localArrayList.size()) {
              break;
            }
            if ((localArrayList.get(n) instanceof StructMsgItemTitle))
            {
              paramQQGameMsgInfo.title = ((StructMsgItemTitle)localArrayList.get(n)).aA;
              k = 1;
            }
            else
            {
              k = i;
              if ((localArrayList.get(n) instanceof StructMsgItemCover))
              {
                paramQQGameMsgInfo.coverUrl = ((StructMsgItemCover)localArrayList.get(n)).av;
                j = 1;
                k = i;
              }
            }
            if ((k != 0) && (j != 0))
            {
              i1 = j;
              break;
            }
            n += 1;
            i = k;
          }
          paramQQGameMsgInfo.url = ((AbsStructMsgElement)paramMessageRecord.get(m)).d;
          if ((k != 0) && (i1 != 0)) {
            return;
          }
        }
        m += 1;
      }
    }
    if ((paramMessageRecord instanceof MessageForPubAccount))
    {
      paramMessageRecord = (MessageForPubAccount)paramMessageRecord;
      paramMessageRecord.mPAMessage = ((PAMessage)((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).fromByteArray(paramMessageRecord.msgData));
      paramQQGameMsgInfo.coverUrl = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).cover;
      paramQQGameMsgInfo.title = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).title;
      paramQQGameMsgInfo.url = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).url;
    }
  }
  
  public static QQGameMsgInfo parseMessageRecord(MessageRecord paramMessageRecord)
  {
    if (!validMsgType(paramMessageRecord))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameMsgInfo", 1, "parseMessageRecord-->record is null");
      }
      return null;
    }
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    localQQGameMsgInfo.uniseq = paramMessageRecord.uniseq;
    localQQGameMsgInfo.frienduin = paramMessageRecord.frienduin;
    localQQGameMsgInfo.msgTime = paramMessageRecord.time;
    parseQGameInfo(paramMessageRecord, localQQGameMsgInfo);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      parseArkView(paramMessageRecord, localQQGameMsgInfo);
      return localQQGameMsgInfo;
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {}
    for (;;)
    {
      int k;
      try
      {
        localObject = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
        if (localObject != null) {
          break label318;
        }
        return null;
      }
      catch (Throwable paramMessageRecord)
      {
        ArrayList localArrayList;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createHeader failed structMsg error=");
        ((StringBuilder)localObject).append(paramMessageRecord.toString());
        QLog.e("QQGameMsgInfo", 1, ((StringBuilder)localObject).toString());
      }
      if (k < ((ArrayList)localObject).size())
      {
        n = i;
        m = j;
        if (!(((ArrayList)localObject).get(k) instanceof AbsStructMsgItem)) {
          break label345;
        }
        localArrayList = ((AbsStructMsgItem)((ArrayList)localObject).get(k)).ax;
        m = i;
        n = 0;
        i = j;
        j = m;
        m = n;
        if (m >= localArrayList.size()) {
          break label339;
        }
        if ((localArrayList.get(m) instanceof StructMsgItemTitle))
        {
          n = 1;
        }
        else
        {
          n = i;
          if ((localArrayList.get(m) instanceof StructMsgItemCover))
          {
            j = 1;
            n = i;
          }
        }
        if ((n != 0) && (j != 0))
        {
          parseImgHeaderView(paramMessageRecord, localQQGameMsgInfo);
          return localQQGameMsgInfo;
        }
      }
      else
      {
        if (((ArrayList)localObject).size() == 2)
        {
          parseTextHeaderView(paramMessageRecord, localQQGameMsgInfo);
          return localQQGameMsgInfo;
        }
        return localQQGameMsgInfo;
        if ((paramMessageRecord instanceof MessageForPubAccount))
        {
          parseImgHeaderView(paramMessageRecord, localQQGameMsgInfo);
          return localQQGameMsgInfo;
        }
        return null;
        label318:
        k = 0;
        i = 0;
        j = 0;
        continue;
      }
      m += 1;
      int i = n;
      continue;
      label339:
      int m = i;
      int n = j;
      label345:
      k += 1;
      i = n;
      int j = m;
    }
  }
  
  public static void parseQGameInfo(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    Object localObject2 = paramMessageRecord.extStr;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (paramMessageRecord.mExJsonObject != null) {
        localObject1 = paramMessageRecord.mExJsonObject.toString();
      }
    }
    paramQQGameMsgInfo.paMsgid = QQGameConstant.a(paramMessageRecord);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONObject((String)localObject1).optString("report_key_bytes_oac_msg_extend", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramQQGameMsgInfo.triggerInfo = ((String)localObject1);
          localObject2 = PublicAccountEventReport.b((String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramQQGameMsgInfo.advId = ((String)localObject2);
          }
          localObject1 = new JSONObject((String)localObject1).optString("game_extra", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            localObject2 = ((JSONObject)localObject1).optJSONArray("sorted_configs");
            if (localObject2 != null)
            {
              paramQQGameMsgInfo.sortedConfigs = ((JSONArray)localObject2).toString();
              paramQQGameMsgInfo.gameAppId = ((JSONArray)localObject2).optJSONObject(0).optString("app_id", "");
              paramQQGameMsgInfo.taskId = ((JSONArray)localObject2).optJSONObject(1).optString("task_id", "");
            }
            paramQQGameMsgInfo.extJson = ((JSONObject)localObject1).optString("ext_json", "");
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get getGameMsgInfoByMsg  msg err= ");
          ((StringBuilder)localObject2).append(localThrowable.getMessage());
          QLog.d("QQGameMsgInfo", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      try
      {
        paramQQGameMsgInfo.gameAppId = paramMessageRecord.ark_app_message.mSourceName;
        paramQQGameMsgInfo.arkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
        paramQQGameMsgInfo.arkAppName = paramMessageRecord.ark_app_message.appName;
        paramQQGameMsgInfo.arkAppView = paramMessageRecord.ark_app_message.appView;
        paramQQGameMsgInfo.arkMetaList = paramMessageRecord.ark_app_message.metaList;
        paramQQGameMsgInfo.arkAppConfig = paramMessageRecord.ark_app_message.config;
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        paramQQGameMsgInfo = new StringBuilder();
        paramQQGameMsgInfo.append("MessageForArkApp error =");
        paramQQGameMsgInfo.append(paramMessageRecord.toString());
        QLog.e("QQGameMsgInfo", 1, paramQQGameMsgInfo.toString());
        return;
      }
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {}
    for (;;)
    {
      int k;
      try
      {
        paramMessageRecord = (StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg;
        localArrayList = (ArrayList)paramMessageRecord.getStructMsgItemLists();
        if (localArrayList != null) {
          break label625;
        }
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        ArrayList localArrayList;
        paramQQGameMsgInfo = new StringBuilder();
        paramQQGameMsgInfo.append("createHeader failed structMsg error=");
        paramQQGameMsgInfo.append(paramMessageRecord.toString());
        QLog.e("QQGameMsgInfo", 1, paramQQGameMsgInfo.toString());
      }
      if (k < localArrayList.size())
      {
        n = i;
        m = j;
        if (!(localArrayList.get(k) instanceof AbsStructMsgItem)) {
          break label653;
        }
        localObject2 = ((AbsStructMsgItem)localArrayList.get(k)).ax;
        m = i;
        n = 0;
        i = j;
        j = m;
        m = n;
        if (m >= ((ArrayList)localObject2).size()) {
          break label647;
        }
        if ((((ArrayList)localObject2).get(m) instanceof StructMsgItemTitle))
        {
          n = 1;
        }
        else
        {
          n = j;
          if ((((ArrayList)localObject2).get(m) instanceof StructMsgItemCover))
          {
            i = 1;
            n = j;
          }
        }
        if ((n != 0) && (i != 0)) {
          paramQQGameMsgInfo.gameAppId = GamePubAccountConstant.a(((AbsStructMsgElement)localArrayList.get(k)).d);
        }
      }
      else
      {
        if (localArrayList.size() == 2)
        {
          paramQQGameMsgInfo.gameAppId = GamePubAccountConstant.a(paramMessageRecord.mMsgUrl);
          return;
        }
        return;
        label625:
        k = 0;
        i = 0;
        j = 0;
        continue;
      }
      m += 1;
      int j = n;
      continue;
      label647:
      int m = i;
      int n = j;
      label653:
      k += 1;
      int i = n;
      j = m;
    }
  }
  
  private static void parseTextHeaderView(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 3;
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      return;
    }
    paramMessageRecord = (MessageForStructing)paramMessageRecord;
    if (!(paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare)) {
      return;
    }
    paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord.structingMsg;
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = (StructMsgItemLayoutDefault)((ArrayList)paramMessageRecord.getStructMsgItemLists()).get(1);
    paramQQGameMsgInfo.url = paramMessageRecord.mMsgUrl;
    paramQQGameMsgInfo.title = ((StructMsgItemSummary)localStructMsgItemLayoutDefault.ax.get(1)).aA;
    paramQQGameMsgInfo.dateTitle = ((StructMsgItemSummary)localStructMsgItemLayoutDefault.ax.get(0)).aA;
    paramQQGameMsgInfo.contentText = ((StructMsgItemSummary)localStructMsgItemLayoutDefault.ax.get(2)).aA;
    paramQQGameMsgInfo.limitText = ((StructMsgItemSummary)localStructMsgItemLayoutDefault.ax.get(3)).aA;
  }
  
  public static boolean validMsgType(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForArkApp)) || ((paramMessageRecord instanceof MessageForPubAccount)) || ((paramMessageRecord instanceof MessageForStructing));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo
 * JD-Core Version:    0.7.0.1
 */