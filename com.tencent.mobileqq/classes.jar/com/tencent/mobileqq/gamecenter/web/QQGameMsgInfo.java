package com.tencent.mobileqq.gamecenter.web;

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
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameMsgInfo
  implements Serializable
{
  public static final int MSG_TYPE_ARK = 1;
  public static final int MSG_TYPE_IMGHEADER = 2;
  public static final int MSG_TYPE_TEXTHEADER = 3;
  public String actionUrl = "";
  public String advId = "";
  public String arkAppConfig = "";
  public String arkAppMinVersion = "";
  public String arkAppName = "";
  public String arkAppView = "";
  public int arkHeight;
  public String arkMetaList = "";
  public int arkWidth;
  public String contentText = "";
  public String coverUrl = "";
  public String dateTitle = "";
  public String desc = "";
  public String extJson = "";
  public String frienduin = "";
  public String gameAppId = "";
  public String icon = "";
  public String limitText = "";
  public long msgTime;
  public int msgType;
  public String paMsgid = "";
  public String sortedConfigs = "";
  public String taskId = "";
  public String title = "";
  public String triggerInfo = "";
  public long uniseq;
  public String url = "";
  
  private static void a(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 3;
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    do
    {
      return;
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
    } while (!(paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare));
    paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord.structingMsg;
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = (StructMsgItemLayoutDefault)((ArrayList)paramMessageRecord.getStructMsgItemLists()).get(1);
    paramQQGameMsgInfo.url = paramMessageRecord.mMsgUrl;
    paramQQGameMsgInfo.title = ((StructMsgItemSummary)localStructMsgItemLayoutDefault.a.get(1)).ai;
    paramQQGameMsgInfo.dateTitle = ((StructMsgItemSummary)localStructMsgItemLayoutDefault.a.get(0)).ai;
    paramQQGameMsgInfo.contentText = ((StructMsgItemSummary)localStructMsgItemLayoutDefault.a.get(2)).ai;
    paramQQGameMsgInfo.limitText = ((StructMsgItemSummary)localStructMsgItemLayoutDefault.a.get(3)).ai;
  }
  
  private static void b(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 2;
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    label40:
    label181:
    label222:
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        paramMessageRecord = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
        int m = 0;
        ArrayList localArrayList;
        int n;
        int j;
        if (m < paramMessageRecord.size()) {
          if ((paramMessageRecord.get(m) instanceof AbsStructMsgItem))
          {
            localArrayList = ((AbsStructMsgItem)paramMessageRecord.get(m)).a;
            n = 0;
            j = 0;
          }
        }
        int k;
        for (int i = 0;; i = k)
        {
          int i1 = j;
          k = i;
          if (n < localArrayList.size())
          {
            if (!(localArrayList.get(n) instanceof StructMsgItemTitle)) {
              break label181;
            }
            paramQQGameMsgInfo.title = ((StructMsgItemTitle)localArrayList.get(n)).ai;
            k = 1;
          }
          for (;;)
          {
            if ((k == 0) || (j == 0)) {
              break label222;
            }
            i1 = j;
            paramQQGameMsgInfo.url = ((AbsStructMsgElement)paramMessageRecord.get(m)).b;
            if ((k != 0) && (i1 != 0)) {
              break;
            }
            m += 1;
            break label40;
            break;
            k = i;
            if ((localArrayList.get(n) instanceof StructMsgItemCover))
            {
              paramQQGameMsgInfo.coverUrl = ((StructMsgItemCover)localArrayList.get(n)).ac;
              j = 1;
              k = i;
            }
          }
          n += 1;
        }
      }
    } while (!(paramMessageRecord instanceof MessageForPubAccount));
    paramMessageRecord = (MessageForPubAccount)paramMessageRecord;
    paramMessageRecord.mPAMessage = ((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).fromByteArray(paramMessageRecord.msgData);
    paramQQGameMsgInfo.coverUrl = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).cover;
    paramQQGameMsgInfo.title = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).title;
    paramQQGameMsgInfo.url = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).url;
  }
  
  private static void c(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 1;
    if ((paramMessageRecord instanceof MessageForArkApp)) {}
    label191:
    for (paramMessageRecord = (MessageForArkApp)paramMessageRecord;; paramMessageRecord = "") {
      try
      {
        paramQQGameMsgInfo.arkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
        paramQQGameMsgInfo.arkAppName = paramMessageRecord.ark_app_message.appName;
        paramQQGameMsgInfo.arkAppView = paramMessageRecord.ark_app_message.appView;
        paramQQGameMsgInfo.arkMetaList = paramMessageRecord.ark_app_message.metaList;
        JSONObject localJSONObject = new JSONObject(paramMessageRecord.ark_app_message.metaList);
        Object localObject = localJSONObject.keys();
        int i = 0;
        for (paramMessageRecord = ""; ((Iterator)localObject).hasNext(); paramMessageRecord = (String)((Iterator)localObject).next())
        {
          i += 1;
          if (i != 1) {
            break label191;
          }
        }
        if (!TextUtils.isEmpty(paramMessageRecord))
        {
          localObject = localJSONObject.optJSONObject(paramMessageRecord);
          ((JSONObject)localObject).put("nativeScene", "gamePubAccount");
          localJSONObject.put(paramMessageRecord, localObject);
          paramQQGameMsgInfo.arkMetaList = localJSONObject.toString();
        }
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        QLog.e("QQGameMsgInfo", 1, "MessageForArkApp error =" + paramMessageRecord.toString());
        return;
      }
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
      c(paramMessageRecord, localQQGameMsgInfo);
      return localQQGameMsgInfo;
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {}
    for (;;)
    {
      int n;
      int i1;
      try
      {
        localArrayList1 = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
        if (localArrayList1 != null) {
          break label302;
        }
        return null;
      }
      catch (Throwable paramMessageRecord)
      {
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        QLog.e("QQGameMsgInfo", 1, "createHeader failed structMsg error=" + paramMessageRecord.toString());
      }
      if (n < localArrayList1.size())
      {
        if (!(localArrayList1.get(n) instanceof AbsStructMsgItem)) {
          break label323;
        }
        localArrayList2 = ((AbsStructMsgItem)localArrayList1.get(n)).a;
        k = i;
        i = j;
        i1 = 0;
        j = k;
        k = j;
        m = i;
        if (i1 >= localArrayList2.size()) {
          break label328;
        }
        if ((localArrayList2.get(i1) instanceof StructMsgItemTitle))
        {
          k = 1;
          if ((k != 0) && (j != 0))
          {
            b(paramMessageRecord, localQQGameMsgInfo);
            return localQQGameMsgInfo;
          }
        }
        else
        {
          k = i;
          if (!(localArrayList2.get(i1) instanceof StructMsgItemCover)) {
            continue;
          }
          j = 1;
          k = i;
          continue;
        }
      }
      else
      {
        if (localArrayList1.size() == 2)
        {
          a(paramMessageRecord, localQQGameMsgInfo);
          return localQQGameMsgInfo;
        }
        return localQQGameMsgInfo;
        if ((paramMessageRecord instanceof MessageForPubAccount))
        {
          b(paramMessageRecord, localQQGameMsgInfo);
          return localQQGameMsgInfo;
        }
        return null;
        label302:
        n = 0;
        i = 0;
        j = 0;
        continue;
      }
      i1 += 1;
      int i = k;
      continue;
      label323:
      int m = j;
      int k = i;
      label328:
      n += 1;
      int j = m;
      i = k;
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
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQGameMsgInfo", 2, "parseQGameInfo -> extStr：" + (String)localObject1);
        }
        localObject1 = new JSONObject((String)localObject1).optString("report_key_bytes_oac_msg_extend", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramQQGameMsgInfo.triggerInfo = ((String)localObject1);
          localObject2 = PublicAccountEventReport.a((String)localObject1);
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
            try
            {
              if (!TextUtils.isEmpty(paramQQGameMsgInfo.extJson))
              {
                localObject1 = new JSONObject(paramQQGameMsgInfo.extJson);
                paramQQGameMsgInfo.desc = ((JSONObject)localObject1).optString("desc");
                paramQQGameMsgInfo.icon = ((JSONObject)localObject1).optString("icon");
                paramQQGameMsgInfo.arkWidth = ((JSONObject)localObject1).optInt("w");
                paramQQGameMsgInfo.arkHeight = ((JSONObject)localObject1).optInt("h");
              }
              if (!TextUtils.isEmpty(paramQQGameMsgInfo.gameAppId)) {
                return;
              }
            }
            catch (Throwable localThrowable1)
            {
              for (;;)
              {
                QLog.e("QQGameMsgInfo", 1, localThrowable1, new Object[0]);
              }
            }
          }
        }
        if (!(paramMessageRecord instanceof MessageForArkApp)) {
          break label504;
        }
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QQGameMsgInfo", 1, "get getGameMsgInfoByMsg  msg err= " + localThrowable2.getMessage());
        }
      }
    }
    else
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
        QLog.e("QQGameMsgInfo", 1, "MessageForArkApp error =" + paramMessageRecord.toString());
        return;
      }
    }
    label504:
    if ((paramMessageRecord instanceof MessageForStructing)) {}
    for (;;)
    {
      ArrayList localArrayList;
      int n;
      int j;
      int i;
      int i1;
      int m;
      try
      {
        paramMessageRecord = (StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg;
        localArrayList = (ArrayList)paramMessageRecord.getStructMsgItemLists();
        if (localArrayList == null) {
          break label724;
        }
        n = 0;
        j = 0;
        i = 0;
        if (n >= localArrayList.size()) {
          break label704;
        }
        if (!(localArrayList.get(n) instanceof AbsStructMsgItem)) {
          break label737;
        }
        localObject2 = ((AbsStructMsgItem)localArrayList.get(n)).a;
        i1 = 0;
        k = j;
        m = i;
        if (i1 >= ((ArrayList)localObject2).size()) {
          break label743;
        }
        if ((((ArrayList)localObject2).get(i1) instanceof StructMsgItemTitle))
        {
          k = 1;
          if ((k == 0) || (j == 0)) {
            break label725;
          }
          paramQQGameMsgInfo.gameAppId = QQGameConstant.a(((AbsStructMsgElement)localArrayList.get(n)).b);
          return;
        }
      }
      catch (Throwable paramMessageRecord)
      {
        QLog.e("QQGameMsgInfo", 1, "createHeader failed structMsg error=" + paramMessageRecord.toString());
        return;
      }
      int k = i;
      if ((((ArrayList)localObject2).get(i1) instanceof StructMsgItemCover))
      {
        j = 1;
        k = i;
        continue;
        label704:
        if (localArrayList.size() == 2) {
          paramQQGameMsgInfo.gameAppId = QQGameConstant.a(paramMessageRecord.mMsgUrl);
        }
        label724:
        return;
        label725:
        i1 += 1;
        i = k;
        continue;
        label737:
        m = i;
        k = j;
        label743:
        n += 1;
        i = m;
        j = k;
      }
    }
  }
  
  public static boolean validMsgType(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForArkApp)) || ((paramMessageRecord instanceof MessageForPubAccount)) || ((paramMessageRecord instanceof MessageForStructing));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo
 * JD-Core Version:    0.7.0.1
 */