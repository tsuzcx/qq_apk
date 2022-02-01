package com.tencent.mobileqq.graytip;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UniteGrayTipMsgUtil
{
  private static List<MessageRecord> a = new ArrayList(1);
  private static UniteGrayTipMsgUtil.Callback b = new UniteGrayTipMsgUtil.1();
  
  public static MessageForUniteGrayTip a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    long l = paramMessageRecord.time;
    Object localObject = paramAppRuntime.getApp().getString(2131892377);
    localObject = new UniteGrayTipParam(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5040, 656398, l);
    ((UniteGrayTipParam)localObject).m = true;
    localMessageForUniteGrayTip.initGrayTipMsg(paramAppRuntime, (UniteGrayTipParam)localObject);
    localMessageForUniteGrayTip.shmsgseq = paramMessageRecord.shmsgseq;
    return localMessageForUniteGrayTip;
  }
  
  public static void a(UniteGrayTipMsgUtil.Callback paramCallback)
  {
    b = paramCallback;
  }
  
  protected static void a(StringBuilder paramStringBuilder, MessageRecord paramMessageRecord)
  {
    String str2 = paramMessageRecord.msg;
    String str1 = str2;
    if (paramMessageRecord.msgtype == -8018)
    {
      str1 = str2;
      if ((paramMessageRecord instanceof ChatMessage)) {
        str1 = ((ChatMessage)paramMessageRecord).getSummaryMsg();
      }
    }
    if (QLog.isColorLevel())
    {
      int i = 0;
      if (str1 != null) {
        i = str1.length();
      }
      QLog.d("UniteGrayTipMsgUtil", 2, new Object[] { "revoke msg edit mr.msg length = ", Integer.valueOf(i) });
    }
    paramStringBuilder.append(str1);
  }
  
  public static void a(List<MessageRecord> paramList)
  {
    a.addAll(paramList);
  }
  
  public static void a(AppRuntime paramAppRuntime, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (a.size() > 0)
    {
      ArrayList localArrayList = new ArrayList(2);
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.msgUid == paramMessageForUniteGrayTip.msgUid) {
          localArrayList.add(localMessageRecord);
        }
      }
      if (localArrayList.size() > 0)
      {
        a(paramAppRuntime, paramMessageForUniteGrayTip, localArrayList, paramInt, paramMessageForUniteGrayTip.tipParam.g, paramMessageForUniteGrayTip.tipParam);
        paramMessageForUniteGrayTip.updateUniteGrayTipMsgData(paramAppRuntime);
        b.a();
        if (QLog.isColorLevel()) {
          QLog.d("UniteGrayTipMsgUtil", 2, new Object[] { "revoke msg handleRevokeSameGrayMsgSelfMsgToEditalbe msgGray.msgUid =", Long.valueOf(paramMessageForUniteGrayTip.msgUid), ",uinseq=", Long.valueOf(paramMessageForUniteGrayTip.uniseq) });
        }
      }
      paramAppRuntime = a;
      paramAppRuntime.removeAll(paramAppRuntime);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UniteGrayTipMsgUtil", 2, new Object[] { "revoke msg handleRevokeSameGrayMsgSelfMsgToEditalbe not find msgGray.msgUid =", Long.valueOf(paramMessageForUniteGrayTip.msgUid), ",uinseq=", Long.valueOf(paramMessageForUniteGrayTip.uniseq) });
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, MessageForUniteGrayTip paramMessageForUniteGrayTip, List<MessageRecord> paramList, int paramInt, String paramString, UniteGrayTipParam paramUniteGrayTipParam)
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    int i = 0;
    Object localObject;
    int j;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (!a(localMessageRecord))
      {
        a(localStringBuilder, localMessageRecord);
        if (paramInt == 1) {
          paramList = localMessageRecord.getExtInfoFromExtStr(MessageConstants.i);
        } else if (paramInt == 3000) {
          paramList = localMessageRecord.getExtInfoFromExtStr(MessageConstants.j);
        }
        localObject = paramList;
        if (TextUtils.isEmpty(paramList))
        {
          localObject = paramList;
          if (localMessageRecord.msgtype == -1051)
          {
            localObject = paramList;
            if (localMessageRecord.atInfoList != null)
            {
              paramList = localMessageRecord.atInfoList;
              localObject = new JSONArray();
              j = 0;
              while (j < paramList.size())
              {
                try
                {
                  ((JSONArray)localObject).put(j, ((AtTroopMemberInfo)paramList.get(j)).toJsonObject());
                }
                catch (JSONException localJSONException)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("UniteGrayTipMsgUtil", 2, "revoke msg handle gray json info:", localJSONException);
                  }
                }
                j += 1;
              }
              localObject = ((JSONArray)localObject).toString();
            }
          }
        }
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          try
          {
            paramList = new JSONObject();
            paramList.put(MessageConstants.k, localObject);
            paramList.put(MessageConstants.l, paramInt);
            localJSONArray.put(i, paramList);
          }
          catch (JSONException paramList)
          {
            if (QLog.isColorLevel()) {
              QLog.d("UniteGrayTipMsgUtil", 2, "revoke msg handle gray at info:", paramList);
            }
          }
          j = i + 1;
        }
        paramList = (List<MessageRecord>)localObject;
        i = j;
      }
    }
    if (localStringBuilder.length() > 0)
    {
      paramMessageForUniteGrayTip.editState = 1;
      paramMessageForUniteGrayTip.editTime = NetConnInfoCenter.getServerTimeMillis();
      paramMessageForUniteGrayTip.editMsgData = localStringBuilder.toString();
      localObject = BaseApplication.getContext().getString(2131891965);
      paramString = paramString.concat(" ");
      j = paramString.length();
      int k = ((String)localObject).length() + j;
      paramString = paramString.concat((String)localObject);
      paramUniteGrayTipParam.g = paramString;
      paramMessageForUniteGrayTip.msg = paramString;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_action", 27);
      ((Bundle)localObject).putString("key_action_DATA", paramMessageForUniteGrayTip.editMsgData);
      if (!TextUtils.isEmpty(paramList)) {
        ((Bundle)localObject).putString("key_a_action_DATA", localJSONArray.toString());
      }
      paramUniteGrayTipParam.a(j, k, (Bundle)localObject);
      if (QLog.isColorLevel())
      {
        if (paramMessageForUniteGrayTip.editMsgData != null) {
          paramInt = paramMessageForUniteGrayTip.editMsgData.length();
        } else {
          paramInt = 0;
        }
        i = paramInt;
        if (paramInt > 2) {
          i = 2;
        }
        long l1 = paramMessageForUniteGrayTip.editTime;
        long l2 = paramMessageForUniteGrayTip.msgUid;
        long l3 = paramMessageForUniteGrayTip.uniseq;
        if (i > 0) {
          paramList = paramMessageForUniteGrayTip.editMsgData.substring(0, i);
        } else {
          paramList = "";
        }
        QLog.d("UniteGrayTipMsgUtil", 2, new Object[] { "revoke msg beding edit,time=", Long.valueOf(l1), ",wording=", paramString, ",msguid=", Long.valueOf(l2), ",uniseq=", Long.valueOf(l3), ",start =", Integer.valueOf(j), ",end=", Integer.valueOf(k), ",msgDta[0-2]=", paramList, ",msgGray.editMsgData.length=", Integer.valueOf(paramMessageForUniteGrayTip.editMsgData.length()), ",atString=", localJSONArray.toString() });
      }
      ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8008E55", "0X8008E55", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UniteGrayTipMsgUtil", 2, "revoke msg handle empty msg data");
    }
  }
  
  protected static boolean a(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord.msgtype != -1000) && (paramMessageRecord.msgtype != -1051)) || ((!MessageRecordInfo.b(paramMessageRecord.issend)) && (paramMessageRecord.msgtype != -8018)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UniteGrayTipMsgUtil", 2, new Object[] { "revoke msg handle not text msg or not local send, type = ", Integer.valueOf(paramMessageRecord.msgtype), ",mr.issend=", Integer.valueOf(paramMessageRecord.issend), ",uniseq=", Long.valueOf(paramMessageRecord.uniseq) });
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (paramMessageForUniteGrayTip == null) {
      return false;
    }
    if (((!paramMessageForUniteGrayTip.tipParam.b) && (!MsgProxyUtils.b(paramMessageForUniteGrayTip.msgtype))) || ((!paramMessageForUniteGrayTip.tipParam.d) && (!MsgProxyUtils.c(paramMessageForUniteGrayTip.msgtype))))
    {
      if (QLog.isColorLevel()) {
        QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, error param");
      }
      return false;
    }
    if (b(paramAppRuntime, paramMessageForUniteGrayTip)) {
      return false;
    }
    boolean bool1 = paramMessageForUniteGrayTip.tipParam.c;
    boolean bool2 = paramMessageForUniteGrayTip.tipParam.m;
    ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).addMessage(paramMessageForUniteGrayTip, paramAppRuntime.getAccount(), false, bool1, true, bool2 ^ true);
    return true;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2031) {
      return true;
    }
    if ((paramMessageRecord instanceof MessageForUniteGrayTip))
    {
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      if (paramMessageRecord.tipParam == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, mutex grayTip in cache");
        }
        return false;
      }
      if (paramMessageRecord.tipParam.i == 1) {
        return true;
      }
    }
    return false;
  }
  
  static boolean b(AppRuntime paramAppRuntime, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    paramAppRuntime = ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.istroop);
    if ((paramAppRuntime != null) && (!paramAppRuntime.isEmpty()))
    {
      Object localObject1;
      Object localObject2;
      if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.p != null))
      {
        localObject1 = paramAppRuntime.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject2 instanceof MessageForUniteGrayTip))
          {
            localObject2 = (MessageForUniteGrayTip)localObject2;
            if ((((MessageForUniteGrayTip)localObject2).tipParam != null) && (paramMessageForUniteGrayTip.tipParam.i == ((MessageForUniteGrayTip)localObject2).tipParam.i) && (paramMessageForUniteGrayTip.tipParam.p.equals(((MessageForUniteGrayTip)localObject2).tipParam.p)))
            {
              if (QLog.isColorLevel()) {
                QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, repeat grayTip in cache");
              }
              return true;
            }
          }
        }
      }
      int i = paramAppRuntime.size() - 1;
      while (i >= 0)
      {
        if ((paramAppRuntime.size() - i <= 10) && ((paramAppRuntime.get(i) instanceof MessageForUniteGrayTip)))
        {
          localObject1 = (MessageForUniteGrayTip)paramAppRuntime.get(i);
          if ((((MessageForUniteGrayTip)localObject1).tipParam != null) && (paramMessageForUniteGrayTip.tipParam != null))
          {
            int k;
            int j;
            if (paramMessageForUniteGrayTip.tipParam.o != null)
            {
              localObject2 = paramMessageForUniteGrayTip.tipParam.o;
              k = localObject2.length;
              j = 0;
              while (j < k)
              {
                if (localObject2[j] == ((MessageForUniteGrayTip)localObject1).tipParam.i)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, mutex grayTip in cache");
                  }
                  return true;
                }
                j += 1;
              }
            }
            if (((MessageForUniteGrayTip)localObject1).tipParam.o != null)
            {
              localObject1 = ((MessageForUniteGrayTip)localObject1).tipParam.o;
              k = localObject1.length;
              j = 0;
              while (j < k)
              {
                if (localObject1[j] == paramMessageForUniteGrayTip.tipParam.i)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, mutex grayTip in cache");
                  }
                  return true;
                }
                j += 1;
              }
            }
          }
        }
        i -= 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil
 * JD-Core Version:    0.7.0.1
 */