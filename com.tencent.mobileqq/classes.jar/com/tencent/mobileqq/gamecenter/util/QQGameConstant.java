package com.tencent.mobileqq.gamecenter.util;

import android.text.TextUtils;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameConstant
{
  public static Map<String, String> a;
  public static Queue<String> a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilQueue = new ArrayDeque(100);
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_Boolean = true;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = "";
    try
    {
      String str = paramMessageRecord.extStr;
      Object localObject2 = str;
      if (TextUtils.isEmpty(str))
      {
        localObject2 = str;
        if (paramMessageRecord.mExJsonObject != null) {
          localObject2 = paramMessageRecord.mExJsonObject.toString();
        }
      }
      paramMessageRecord = (MessageRecord)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return paramMessageRecord;
      }
      localObject2 = new JSONObject((String)localObject2);
      paramMessageRecord = PublicAccountEventReport.a(((JSONObject)localObject2).optString("report_key_bytes_oac_msg_extend", ""));
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        return paramMessageRecord;
      }
      paramMessageRecord = ((JSONObject)localObject2).optString("public_account_msg_id", "");
      try
      {
        if (TextUtils.isEmpty(paramMessageRecord))
        {
          localObject1 = ((JSONObject)localObject2).optString("pa_msgId", "");
          return localObject1;
        }
        return paramMessageRecord;
      }
      catch (Throwable localThrowable1) {}
      localObject1 = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      paramMessageRecord = (MessageRecord)localObject1;
    }
    ((StringBuilder)localObject1).append("getPAMsgId error =");
    ((StringBuilder)localObject1).append(localThrowable2.toString());
    QLog.e("QQGameConstant", 1, ((StringBuilder)localObject1).toString());
    return paramMessageRecord;
  }
  
  public static String a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("into getGameMsgInfoByMsg getType = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("QQGameConstant", 1, ((StringBuilder)localObject1).toString());
    }
    if (paramMessageRecord == null) {
      return "";
    }
    String str = a(paramMessageRecord);
    if (paramInt == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("_appid");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (paramInt == 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("_taskid");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (paramInt == 2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("_extJson");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      if (paramInt != 4) {
        break label1465;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("_orted_configs");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (jdField_a_of_type_JavaUtilMap.containsKey(localObject1))
    {
      localObject1 = (String)jdField_a_of_type_JavaUtilMap.get(localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("get getGameMsgInfoByMsg from cache,getType= ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" value = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("QQGameConstant", 1, ((StringBuilder)localObject2).toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        return localObject1;
      }
    }
    Object localObject2 = paramMessageRecord.extStr;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (paramMessageRecord.mExJsonObject != null) {
        localObject1 = paramMessageRecord.mExJsonObject.toString();
      }
    }
    Object localObject6;
    Object localObject5;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).optString("report_key_bytes_oac_msg_extend", "");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1018;
        }
        localObject1 = new JSONObject((String)localObject1).optString("game_extra", "");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1483;
        }
        localObject6 = new JSONObject((String)localObject1);
        Object localObject3 = ((JSONObject)localObject6).optJSONArray("sorted_configs");
        if (localObject3 == null) {
          break label1468;
        }
        localObject5 = ((JSONArray)localObject3).toString();
        localObject2 = ((JSONArray)localObject3).optJSONObject(0).optString("app_id", "");
        localObject1 = localObject2;
        try
        {
          localObject3 = ((JSONArray)localObject3).optJSONObject(1).optString("task_id", "");
          localObject1 = localObject2;
          localObject6 = ((JSONObject)localObject6).optString("ext_json", "");
          localObject1 = localObject2;
          Object localObject7 = jdField_a_of_type_JavaUtilMap;
          localObject1 = localObject2;
          StringBuilder localStringBuilder = new StringBuilder();
          localObject1 = localObject2;
          localStringBuilder.append(str);
          localObject1 = localObject2;
          localStringBuilder.append("_appid");
          localObject1 = localObject2;
          ((Map)localObject7).put(localStringBuilder.toString(), localObject2);
          localObject1 = localObject2;
          localObject7 = jdField_a_of_type_JavaUtilMap;
          localObject1 = localObject2;
          localStringBuilder = new StringBuilder();
          localObject1 = localObject2;
          localStringBuilder.append(str);
          localObject1 = localObject2;
          localStringBuilder.append("_taskid");
          localObject1 = localObject2;
          ((Map)localObject7).put(localStringBuilder.toString(), localObject3);
          localObject1 = localObject2;
          localObject7 = jdField_a_of_type_JavaUtilMap;
          localObject1 = localObject2;
          localStringBuilder = new StringBuilder();
          localObject1 = localObject2;
          localStringBuilder.append(str);
          localObject1 = localObject2;
          localStringBuilder.append("_extJson");
          localObject1 = localObject2;
          ((Map)localObject7).put(localStringBuilder.toString(), localObject6);
          localObject1 = localObject2;
          localObject7 = jdField_a_of_type_JavaUtilMap;
          localObject1 = localObject2;
          localStringBuilder = new StringBuilder();
          localObject1 = localObject2;
          localStringBuilder.append(str);
          localObject1 = localObject2;
          localStringBuilder.append("_orted_configs");
          localObject1 = localObject2;
          ((Map)localObject7).put(localStringBuilder.toString(), localObject5);
          label751:
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject2;
            localObject7 = new StringBuilder();
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append("get getGameMsgInfoByMsg from msg,getType= ");
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append(paramInt);
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append(" appid = ");
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append((String)localObject2);
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append(" taskid=");
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append((String)localObject3);
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append(" extJson=");
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append((String)localObject6);
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append(" ortedConfigs=");
            localObject1 = localObject2;
            ((StringBuilder)localObject7).append((String)localObject5);
            localObject1 = localObject2;
            QLog.d("QQGameConstant", 1, ((StringBuilder)localObject7).toString());
          }
          if (paramInt == 0) {
            return localObject2;
          }
          if (paramInt == 1) {
            return localObject3;
          }
          if (paramInt == 2) {
            return localObject6;
          }
          if (paramInt == 4) {
            return localObject5;
          }
          return "";
        }
        catch (Throwable localThrowable1)
        {
          localObject2 = localObject1;
        }
        localThrowable2.printStackTrace();
      }
      catch (Throwable localThrowable2)
      {
        localObject2 = "";
      }
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label1022;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get getGameMsgInfoByMsg  msg err= ");
      ((StringBuilder)localObject1).append(localThrowable2.getMessage());
      QLog.d("QQGameConstant", 1, ((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
      break label1022;
    }
    label1018:
    localObject1 = "";
    label1022:
    if (paramInt == 0) {
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        paramMessageRecord = (MessageForArkApp)paramMessageRecord;
        try
        {
          paramMessageRecord = paramMessageRecord.ark_app_message.mSourceName;
          localObject1 = paramMessageRecord;
        }
        catch (Throwable paramMessageRecord)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("MessageForArkApp error =");
          ((StringBuilder)localObject2).append(paramMessageRecord.toString());
          QLog.e("QQGameConstant", 1, ((StringBuilder)localObject2).toString());
        }
      }
      else if (!(paramMessageRecord instanceof MessageForStructing)) {}
    }
    for (;;)
    {
      int j;
      try
      {
        paramMessageRecord = (StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg;
        localObject1 = (ArrayList)paramMessageRecord.getStructMsgItemLists();
        if (localObject1 != null) {
          break label1510;
        }
        return "";
      }
      catch (Throwable paramMessageRecord)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("createHeader failed structMsg error=");
        ((StringBuilder)localObject1).append(paramMessageRecord.toString());
        QLog.e("QQGameConstant", 1, ((StringBuilder)localObject1).toString());
      }
      if (j < ((ArrayList)localObject1).size())
      {
        m = paramInt;
        k = i;
        if (!(((ArrayList)localObject1).get(j) instanceof AbsStructMsgItem)) {
          break label1537;
        }
        localObject2 = ((AbsStructMsgItem)((ArrayList)localObject1).get(j)).a;
        k = paramInt;
        m = 0;
        paramInt = i;
        i = k;
        k = m;
        if (k >= ((ArrayList)localObject2).size()) {
          break label1531;
        }
        if ((((ArrayList)localObject2).get(k) instanceof StructMsgItemTitle))
        {
          m = 1;
        }
        else
        {
          m = i;
          if ((((ArrayList)localObject2).get(k) instanceof StructMsgItemCover))
          {
            paramInt = 1;
            m = i;
          }
        }
        if ((m != 0) && (paramInt != 0)) {
          return GamePubAccountConstant.a(((AbsStructMsgElement)((ArrayList)localObject1).get(j)).b);
        }
      }
      else
      {
        if (((ArrayList)localObject1).size() == 2)
        {
          paramMessageRecord = GamePubAccountConstant.a(paramMessageRecord.mMsgUrl);
          return paramMessageRecord;
        }
        return "";
        paramMessageRecord = jdField_a_of_type_JavaUtilMap;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("_appid");
        paramMessageRecord.put(((StringBuilder)localObject2).toString(), localObject1);
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("get getGameMsgInfoByMsg from old msg,getType= ");
          paramMessageRecord.append(paramInt);
          paramMessageRecord.append(" appid = ");
          paramMessageRecord.append((String)localObject1);
          QLog.d("QQGameConstant", 1, paramMessageRecord.toString());
        }
        return localObject1;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("get getGameMsgInfoByMsg from old msg,getType= ");
          paramMessageRecord.append(paramInt);
          paramMessageRecord.append(" is empty");
          QLog.d("QQGameConstant", 1, paramMessageRecord.toString());
        }
        label1465:
        return "";
        label1468:
        localObject2 = "";
        Object localObject4 = localObject2;
        localObject5 = localObject4;
        break;
        label1483:
        localObject2 = "";
        localObject4 = localObject2;
        localObject1 = localObject4;
        localObject5 = localObject1;
        localObject6 = localObject4;
        localObject4 = localObject1;
        break label751;
        label1510:
        j = 0;
        paramInt = 0;
        i = 0;
        continue;
      }
      k += 1;
      int i = m;
      continue;
      label1531:
      int k = paramInt;
      int m = i;
      label1537:
      j += 1;
      paramInt = m;
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameConstant
 * JD-Core Version:    0.7.0.1
 */