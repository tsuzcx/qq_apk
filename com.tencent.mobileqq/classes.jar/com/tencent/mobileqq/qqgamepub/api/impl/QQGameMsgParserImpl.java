package com.tencent.mobileqq.qqgamepub.api.impl;

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
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameMsgParser;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGameMsgParserImpl
  implements IQQGameMsgParser
{
  private static final String TAG = "QQGamePub_QQGameMsgParserImpl";
  
  private static void parseArkView(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 1;
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseArkView metaList=");
        localStringBuilder.append(paramMessageRecord.ark_app_message.metaList);
        QLog.i("QQGamePub_QQGameMsgParserImpl", 2, localStringBuilder.toString());
      }
      try
      {
        paramQQGameMsgInfo.arkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
        paramQQGameMsgInfo.arkAppName = paramMessageRecord.ark_app_message.appName;
        paramQQGameMsgInfo.arkAppView = paramMessageRecord.ark_app_message.appView;
        paramQQGameMsgInfo.arkMetaList = paramMessageRecord.ark_app_message.metaList;
        paramMessageRecord = new JSONObject(paramMessageRecord.ark_app_message.metaList);
        if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).addQQGameArkField(paramQQGameMsgInfo.arkAppName, String.valueOf(paramQQGameMsgInfo.uniseq), GamePubAccountHelper.a(), paramMessageRecord) != null) {
          paramQQGameMsgInfo.arkMetaList = paramMessageRecord.toString();
        }
        boolean bool = TextUtils.isEmpty(paramQQGameMsgInfo.arkMetaList);
        if (!bool) {
          try
          {
            paramMessageRecord = paramMessageRecord.getJSONObject("gdt").getJSONObject("adInfo").getJSONObject("report_info");
            if (paramMessageRecord != null)
            {
              paramQQGameMsgInfo.isAdMsg = true;
              paramQQGameMsgInfo.adJson = paramMessageRecord.toString();
              return;
            }
          }
          catch (JSONException paramMessageRecord)
          {
            paramMessageRecord.printStackTrace();
            return;
          }
        }
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        paramQQGameMsgInfo = new StringBuilder();
        paramQQGameMsgInfo.append("MessageForArkApp error =");
        paramQQGameMsgInfo.append(paramMessageRecord.toString());
        QLog.e("QQGamePub_QQGameMsgParserImpl", 1, paramQQGameMsgInfo.toString());
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
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseQGameInfo -> extStr：");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("QQGamePub_QQGameMsgParserImpl", 2, ((StringBuilder)localObject2).toString());
        }
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
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                if (i == 0)
                {
                  paramQQGameMsgInfo.gameAppId = ((JSONArray)localObject2).optJSONObject(i).optString("app_id", "");
                  break label791;
                }
                if (i != 1) {
                  break label791;
                }
                paramQQGameMsgInfo.taskId = ((JSONArray)localObject2).optJSONObject(1).optString("task_id", "");
                break label791;
              }
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
            }
            catch (Throwable localThrowable1)
            {
              QLog.e("QQGamePub_QQGameMsgParserImpl", 1, localThrowable1, new Object[0]);
            }
            boolean bool = TextUtils.isEmpty(paramQQGameMsgInfo.gameAppId);
            if (!bool) {
              return;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get getGameMsgInfoByMsg  msg err= ");
          ((StringBuilder)localObject2).append(localThrowable2.getMessage());
          QLog.d("QQGamePub_QQGameMsgParserImpl", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
    else
    {
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
          QLog.e("QQGamePub_QQGameMsgParserImpl", 1, paramQQGameMsgInfo.toString());
          return;
        }
      }
      if (!(paramMessageRecord instanceof MessageForStructing)) {}
    }
    for (;;)
    {
      int k;
      try
      {
        paramMessageRecord = (StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg;
        localArrayList = (ArrayList)paramMessageRecord.getStructMsgItemLists();
        if (localArrayList != null) {
          break label798;
        }
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        ArrayList localArrayList;
        paramQQGameMsgInfo = new StringBuilder();
        paramQQGameMsgInfo.append("createHeader failed structMsg error=");
        paramQQGameMsgInfo.append(paramMessageRecord.toString());
        QLog.e("QQGamePub_QQGameMsgParserImpl", 1, paramQQGameMsgInfo.toString());
      }
      if (k < localArrayList.size())
      {
        n = i;
        m = j;
        if (!(localArrayList.get(k) instanceof AbsStructMsgItem)) {
          break label826;
        }
        localObject2 = ((AbsStructMsgItem)localArrayList.get(k)).ax;
        m = i;
        n = 0;
        i = j;
        j = m;
        m = n;
        if (m >= ((ArrayList)localObject2).size()) {
          break label820;
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
        label791:
        i += 1;
        break;
        label798:
        k = 0;
        i = 0;
        j = 0;
        continue;
      }
      m += 1;
      int j = n;
      continue;
      label820:
      int m = i;
      int n = j;
      label826:
      k += 1;
      i = n;
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
  
  public QQGameMsgInfo parseMessageRecord(MessageRecord paramMessageRecord)
  {
    if (!validMsgType(paramMessageRecord))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseMessageRecord--> validMsgType is failed:");
      ((StringBuilder)localObject1).append(paramMessageRecord);
      QLog.d("QQGamePub_QQGameMsgParserImpl", 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    Object localObject1 = new QQGameMsgInfo();
    ((QQGameMsgInfo)localObject1).uniseq = paramMessageRecord.uniseq;
    ((QQGameMsgInfo)localObject1).frienduin = paramMessageRecord.frienduin;
    ((QQGameMsgInfo)localObject1).msgTime = paramMessageRecord.time;
    ((QQGameMsgInfo)localObject1).istroop = paramMessageRecord.istroop;
    parseQGameInfo(paramMessageRecord, (QQGameMsgInfo)localObject1);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      parseArkView(paramMessageRecord, (QQGameMsgInfo)localObject1);
      return localObject1;
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {}
    for (;;)
    {
      int k;
      try
      {
        localObject2 = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
        if (localObject2 != null) {
          break label353;
        }
        return null;
      }
      catch (Throwable paramMessageRecord)
      {
        ArrayList localArrayList;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("createHeader failed structMsg error=");
        ((StringBuilder)localObject2).append(paramMessageRecord.toString());
        QLog.e("QQGamePub_QQGameMsgParserImpl", 1, ((StringBuilder)localObject2).toString());
      }
      if (k < ((ArrayList)localObject2).size())
      {
        n = i;
        m = j;
        if (!(((ArrayList)localObject2).get(k) instanceof AbsStructMsgItem)) {
          break label381;
        }
        localArrayList = ((AbsStructMsgItem)((ArrayList)localObject2).get(k)).ax;
        m = i;
        n = 0;
        i = j;
        j = m;
        m = n;
        if (m >= localArrayList.size()) {
          break label375;
        }
        if ((localArrayList.get(m) instanceof StructMsgItemTitle))
        {
          n = 1;
        }
        else
        {
          n = j;
          if ((localArrayList.get(m) instanceof StructMsgItemCover))
          {
            i = 1;
            n = j;
          }
        }
        if ((n != 0) && (i != 0))
        {
          parseImgHeaderView(paramMessageRecord, (QQGameMsgInfo)localObject1);
          return localObject1;
        }
      }
      else
      {
        if (((ArrayList)localObject2).size() == 2)
        {
          parseTextHeaderView(paramMessageRecord, (QQGameMsgInfo)localObject1);
          return localObject1;
        }
        return localObject1;
        if ((paramMessageRecord instanceof MessageForPubAccount))
        {
          parseImgHeaderView(paramMessageRecord, (QQGameMsgInfo)localObject1);
          return localObject1;
        }
        return null;
        label353:
        k = 0;
        i = 0;
        j = 0;
        continue;
      }
      m += 1;
      int j = n;
      continue;
      label375:
      int m = i;
      int n = j;
      label381:
      k += 1;
      int i = n;
      j = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameMsgParserImpl
 * JD-Core Version:    0.7.0.1
 */