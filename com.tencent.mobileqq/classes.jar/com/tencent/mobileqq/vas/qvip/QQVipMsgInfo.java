package com.tencent.mobileqq.vas.qvip;

import android.text.TextUtils;
import anxs;
import atzc;
import atzd;
import bcgw;
import bcgx;
import bcit;
import bciz;
import bclv;
import bgjg;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import ueg;

public class QQVipMsgInfo
  implements Serializable
{
  public static final int MSG_TYPE_ARK = 1;
  public static final int MSG_TYPE_IMGHEADER = 2;
  public static final int MSG_TYPE_TEXTHEADER = 3;
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
  public FullPopData fullPopData;
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
  
  private static void a(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    paramQQVipMsgInfo.msgType = 3;
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    do
    {
      return;
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
    } while (!(paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare));
    Object localObject = (StructMsgForGeneralShare)paramMessageRecord.structingMsg;
    paramMessageRecord = (ArrayList)((StructMsgForGeneralShare)localObject).getStructMsgItemLists();
    paramQQVipMsgInfo.title = ((StructMsgItemTitle)((bcgx)paramMessageRecord.get(0)).a.get(0)).ai;
    StringBuilder localStringBuilder = new StringBuilder();
    paramQQVipMsgInfo.url = ((StructMsgForGeneralShare)localObject).mMsgUrl;
    int k = 1;
    int i = 0;
    int j = 0;
    if (k < paramMessageRecord.size())
    {
      localObject = ((bcgx)paramMessageRecord.get(k)).a;
      int m = 0;
      while (m < ((ArrayList)localObject).size())
      {
        int n = j;
        String str;
        if ((((ArrayList)localObject).get(m) instanceof bclv))
        {
          str = ((bclv)((ArrayList)localObject).get(m)).ai;
          n = j;
          if (!TextUtils.isEmpty(str))
          {
            localStringBuilder.append(str);
            n = 1;
          }
        }
        if ((((ArrayList)localObject).get(m) instanceof bcit))
        {
          str = ((bcit)((ArrayList)localObject).get(m)).b;
          if ((TextUtils.isEmpty(paramQQVipMsgInfo.url)) && (!TextUtils.isEmpty(str))) {
            paramQQVipMsgInfo.url = str;
          }
        }
        m += 1;
        j = n;
      }
      if (j == 0) {
        break label298;
      }
      localStringBuilder.append("\n");
      i += 1;
      j = 0;
    }
    label298:
    for (;;)
    {
      k += 1;
      break;
      paramQQVipMsgInfo.contentText = localStringBuilder.toString();
      return;
    }
  }
  
  private static void b(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    paramQQVipMsgInfo.msgType = 2;
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    label53:
    label319:
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        Object localObject = (StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg;
        paramMessageRecord = (ArrayList)((StructMsgForGeneralShare)localObject).getStructMsgItemLists();
        paramQQVipMsgInfo.url = ((StructMsgForGeneralShare)localObject).mMsgUrl;
        int n = 0;
        int i1;
        int j;
        if (n < paramMessageRecord.size()) {
          if ((paramMessageRecord.get(n) instanceof bcgx))
          {
            localObject = ((bcgx)paramMessageRecord.get(n)).a;
            i1 = 0;
            j = 0;
          }
        }
        int m;
        for (int i = 0;; i = m)
        {
          int k = j;
          m = i;
          if (i1 < ((ArrayList)localObject).size())
          {
            if ((!(((ArrayList)localObject).get(i1) instanceof StructMsgItemTitle)) || (i != 0)) {
              break label264;
            }
            paramQQVipMsgInfo.title = ((StructMsgItemTitle)((ArrayList)localObject).get(i1)).ai;
            m = 1;
            k = j;
          }
          for (;;)
          {
            if (((((ArrayList)localObject).get(i1) instanceof bcit)) && (TextUtils.isEmpty(paramQQVipMsgInfo.url)))
            {
              String str = ((bcit)((ArrayList)localObject).get(i1)).b;
              if (!TextUtils.isEmpty(str)) {
                paramQQVipMsgInfo.url = str;
              }
            }
            if ((m == 0) || (k == 0) || (TextUtils.isEmpty(paramQQVipMsgInfo.url))) {
              break label319;
            }
            paramQQVipMsgInfo.url = ((bcgw)paramMessageRecord.get(n)).b;
            if ((m != 0) && (k != 0)) {
              break;
            }
            n += 1;
            break label53;
            break;
            k = j;
            m = i;
            if ((((ArrayList)localObject).get(i1) instanceof bciz))
            {
              k = j;
              m = i;
              if (j == 0)
              {
                paramQQVipMsgInfo.coverUrl = ((bciz)((ArrayList)localObject).get(i1)).ac;
                k = 1;
                m = i;
              }
            }
          }
          i1 += 1;
          j = k;
        }
      }
    } while (!(paramMessageRecord instanceof MessageForPubAccount));
    label264:
    paramMessageRecord = (MessageForPubAccount)paramMessageRecord;
    paramMessageRecord.mPAMessage = ueg.a(paramMessageRecord.msgData);
    paramQQVipMsgInfo.coverUrl = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).cover;
    paramQQVipMsgInfo.title = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).title;
    paramQQVipMsgInfo.url = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).url;
  }
  
  private static void c(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    paramQQVipMsgInfo.msgType = 1;
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
    }
    try
    {
      paramQQVipMsgInfo.arkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
      paramQQVipMsgInfo.arkAppName = paramMessageRecord.ark_app_message.appName;
      paramQQVipMsgInfo.arkAppView = paramMessageRecord.ark_app_message.appView;
      paramQQVipMsgInfo.arkMetaList = paramMessageRecord.ark_app_message.metaList;
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("QQVipMsgInfo", 1, "MessageForArkApp error =" + paramMessageRecord.toString());
    }
  }
  
  public static QQVipMsgInfo parseMessageRecord(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQVipMsgInfo", 1, "parseMessageRecord-->record is null");
      }
      return null;
    }
    QQVipMsgInfo localQQVipMsgInfo = new QQVipMsgInfo();
    localQQVipMsgInfo.uniseq = paramMessageRecord.uniseq;
    localQQVipMsgInfo.frienduin = paramMessageRecord.frienduin;
    localQQVipMsgInfo.msgTime = paramMessageRecord.time;
    parseQGameInfo(paramMessageRecord, localQQVipMsgInfo);
    localQQVipMsgInfo.fullPopData = atzd.a(paramMessageRecord);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      c(paramMessageRecord, localQQVipMsgInfo);
      return localQQVipMsgInfo;
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
          break label319;
        }
        return null;
      }
      catch (Throwable paramMessageRecord)
      {
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        QLog.e("QQVipMsgInfo", 1, "createHeader failed structMsg error=" + paramMessageRecord.toString());
      }
      if (n < localArrayList1.size())
      {
        if (!(localArrayList1.get(n) instanceof bcgx)) {
          break label340;
        }
        localArrayList2 = ((bcgx)localArrayList1.get(n)).a;
        k = i;
        i = j;
        i1 = 0;
        j = k;
        k = j;
        m = i;
        if (i1 >= localArrayList2.size()) {
          break label345;
        }
        if ((localArrayList2.get(i1) instanceof StructMsgItemTitle))
        {
          k = 1;
          if ((k != 0) && (j != 0))
          {
            b(paramMessageRecord, localQQVipMsgInfo);
            return localQQVipMsgInfo;
          }
        }
        else
        {
          k = i;
          if (!(localArrayList2.get(i1) instanceof bciz)) {
            continue;
          }
          j = 1;
          k = i;
          continue;
        }
      }
      else
      {
        if (j != 0)
        {
          a(paramMessageRecord, localQQVipMsgInfo);
          return localQQVipMsgInfo;
        }
        if (localArrayList1.size() == 2)
        {
          a(paramMessageRecord, localQQVipMsgInfo);
          return localQQVipMsgInfo;
        }
        return localQQVipMsgInfo;
        if ((paramMessageRecord instanceof MessageForPubAccount))
        {
          b(paramMessageRecord, localQQVipMsgInfo);
          return localQQVipMsgInfo;
        }
        return null;
        label319:
        n = 0;
        i = 0;
        j = 0;
        continue;
      }
      i1 += 1;
      int i = k;
      continue;
      label340:
      int m = j;
      int k = i;
      label345:
      n += 1;
      int j = m;
      i = k;
    }
  }
  
  public static void parseQGameInfo(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    Object localObject2 = paramMessageRecord.extStr;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramMessageRecord.mExJsonObject.toString();
    }
    paramQQVipMsgInfo.paMsgid = bgjg.a(paramMessageRecord);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    do
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).optString("report_key_bytes_oac_msg_extend", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramQQVipMsgInfo.triggerInfo = ((String)localObject1);
          paramQQVipMsgInfo.advId = anxs.a((String)localObject1);
          localObject1 = new JSONObject((String)localObject1).optString("game_extra", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            localObject2 = ((JSONObject)localObject1).optJSONArray("sorted_configs");
            if (localObject2 != null)
            {
              paramQQVipMsgInfo.sortedConfigs = ((JSONArray)localObject2).toString();
              paramQQVipMsgInfo.gameAppId = ((JSONArray)localObject2).optJSONObject(0).optString("app_id", "");
              paramQQVipMsgInfo.taskId = ((JSONArray)localObject2).optJSONObject(1).optString("task_id", "");
            }
            paramQQVipMsgInfo.extJson = ((JSONObject)localObject1).optString("ext_json", "");
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QQVipMsgInfo", 1, "get getGameMsgInfoByMsg  msg err= " + localThrowable.getMessage());
        }
      }
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        paramMessageRecord = (MessageForArkApp)paramMessageRecord;
        try
        {
          paramQQVipMsgInfo.gameAppId = paramMessageRecord.ark_app_message.mSourceName;
          paramQQVipMsgInfo.arkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
          paramQQVipMsgInfo.arkAppName = paramMessageRecord.ark_app_message.appName;
          paramQQVipMsgInfo.arkAppView = paramMessageRecord.ark_app_message.appView;
          paramQQVipMsgInfo.arkMetaList = paramMessageRecord.ark_app_message.metaList;
          paramQQVipMsgInfo.arkAppConfig = paramMessageRecord.ark_app_message.config;
          return;
        }
        catch (Throwable paramMessageRecord)
        {
          QLog.e("QQVipMsgInfo", 1, "MessageForArkApp error =" + paramMessageRecord.toString());
          return;
        }
      }
    } while (!(paramMessageRecord instanceof MessageForStructing));
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
          break;
        }
        n = 0;
        j = 0;
        i = 0;
        if (n >= localArrayList.size()) {
          break label554;
        }
        if (!(localArrayList.get(n) instanceof bcgx)) {
          break label587;
        }
        localObject2 = ((bcgx)localArrayList.get(n)).a;
        i1 = 0;
        k = j;
        m = i;
        if (i1 >= ((ArrayList)localObject2).size()) {
          break label593;
        }
        if ((((ArrayList)localObject2).get(i1) instanceof StructMsgItemTitle))
        {
          k = 1;
          if ((k == 0) || (j == 0)) {
            break label575;
          }
          paramQQVipMsgInfo.gameAppId = atzc.a(((bcgw)localArrayList.get(n)).b);
          return;
        }
      }
      catch (Throwable paramMessageRecord)
      {
        QLog.e("QQVipMsgInfo", 1, "createHeader failed structMsg error=" + paramMessageRecord.toString());
        return;
      }
      int k = i;
      if ((((ArrayList)localObject2).get(i1) instanceof bciz))
      {
        j = 1;
        k = i;
        continue;
        label554:
        if (localArrayList.size() != 2) {
          break;
        }
        paramQQVipMsgInfo.gameAppId = atzc.a(paramMessageRecord.mMsgUrl);
        return;
        label575:
        i1 += 1;
        i = k;
        continue;
        label587:
        m = i;
        k = j;
        label593:
        n += 1;
        i = m;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.QQVipMsgInfo
 * JD-Core Version:    0.7.0.1
 */