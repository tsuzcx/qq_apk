package com.tencent.mobileqq.graytip;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UniteGrayTipUtil
{
  private static MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  public static String a;
  private static List jdField_a_of_type_JavaUtilList = new ArrayList(1);
  private static MessageRecord b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniteGrayTip";
  }
  
  public static void a()
  {
    b = jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    String str;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      if (b != null) {
        break label48;
      }
    }
    label48:
    for (Object localObject = "null";; localObject = Long.valueOf(b.uniseq))
    {
      QLog.e(str, 2, new Object[] { "revoke msg set current send msg and clean click msg ,uinseq =", localObject });
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (paramMessageForUniteGrayTip == null) {}
    do
    {
      do
      {
        return;
        if (((paramMessageForUniteGrayTip.tipParam.jdField_a_of_type_Boolean) || (MsgProxyUtils.g(paramMessageForUniteGrayTip.msgtype))) && ((paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_Boolean) || (MsgProxyUtils.h(paramMessageForUniteGrayTip.msgtype)))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, error param");
      return;
    } while (a(paramQQAppInterface, paramMessageForUniteGrayTip));
    boolean bool2 = paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_Boolean;
    if (!paramMessageForUniteGrayTip.tipParam.e) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramQQAppInterface.a().a(paramMessageForUniteGrayTip, paramQQAppInterface.getCurrentAccountUin(), false, bool2, true, bool1);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localArrayList = new ArrayList(2);
      localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.msgUid == paramMessageForUniteGrayTip.msgUid) {
          localArrayList.add(localMessageRecord);
        }
      }
      if (localArrayList.size() > 0)
      {
        a(paramQQAppInterface, paramMessageForUniteGrayTip, localArrayList, paramInt, paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString, paramMessageForUniteGrayTip.tipParam);
        paramMessageForUniteGrayTip.updateUniteGrayTipMsgData(paramQQAppInterface);
        paramQQAppInterface = BaseActivity.sTopActivity;
        if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof FragmentActivity)))
        {
          paramQQAppInterface = ((FragmentActivity)paramQQAppInterface).getChatFragment();
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a().b(131072);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "revoke msg handleRevokeSameGrayMsgSelfMsgToEditalbe msgGray.msgUid =", Long.valueOf(paramMessageForUniteGrayTip.msgUid), ",uinseq=", Long.valueOf(paramMessageForUniteGrayTip.uniseq) });
        }
      }
      jdField_a_of_type_JavaUtilList.removeAll(jdField_a_of_type_JavaUtilList);
    }
    while (!QLog.isColorLevel())
    {
      ArrayList localArrayList;
      Iterator localIterator;
      MessageRecord localMessageRecord;
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "revoke msg handleRevokeSameGrayMsgSelfMsgToEditalbe not find msgGray.msgUid =", Long.valueOf(paramMessageForUniteGrayTip.msgUid), ",uinseq=", Long.valueOf(paramMessageForUniteGrayTip.uniseq) });
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, List paramList, int paramInt, String paramString, UniteGrayTipParam paramUniteGrayTipParam)
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    Object localObject = null;
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    paramList = (List)localObject;
    int j;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (((localMessageRecord.msgtype != -1000) && (localMessageRecord.msgtype != -1051)) || (!MsgUtils.a(localMessageRecord.issend)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "revoke msg handle not text msg or not local send, type = ", Integer.valueOf(localMessageRecord.msgtype), ",mr.issend=", Integer.valueOf(localMessageRecord.issend), ",uniseq=", Long.valueOf(localMessageRecord.uniseq) });
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          if (localMessageRecord.msg == null) {
            break label330;
          }
          j = localMessageRecord.msg.length();
        }
        for (;;)
        {
          QLog.d((String)localObject, 2, new Object[] { "revoke msg edit mr.msg length = ", Integer.valueOf(j) });
          localStringBuilder.append(localMessageRecord.msg);
          if (paramInt == 1)
          {
            paramList = localMessageRecord.getExtInfoFromExtStr(MessageConstants.i);
            label239:
            localObject = paramList;
            if (!TextUtils.isEmpty(paramList)) {
              break label385;
            }
            localObject = paramList;
            if (localMessageRecord.msgtype != -1051) {
              break label385;
            }
            localObject = paramList;
            if (localMessageRecord.atInfoList == null) {
              break label385;
            }
            paramList = localMessageRecord.atInfoList;
            localObject = new JSONArray();
            j = 0;
            label292:
            if (j >= paramList.size()) {}
          }
          else
          {
            try
            {
              ((JSONArray)localObject).put(j, ((MessageForText.AtTroopMemberInfo)paramList.get(j)).toJsonObject());
              j += 1;
              break label292;
              label330:
              j = 0;
              continue;
              if (paramInt != 3000) {
                break label239;
              }
              paramList = localMessageRecord.getExtInfoFromExtStr(MessageConstants.j);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "revoke msg handle gray json info:", localJSONException);
                }
              }
            }
          }
        }
        localObject = ((JSONArray)localObject).toString();
        label385:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label898;
        }
      }
    }
    label898:
    for (;;)
    {
      try
      {
        paramList = new JSONObject();
        paramList.put(MessageConstants.k, localObject);
        paramList.put(MessageConstants.l, paramInt);
        localJSONArray.put(i, paramList);
        i += 1;
        paramList = (List)localObject;
      }
      catch (JSONException paramList)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "revoke msg handle gray at info:", paramList);
        continue;
      }
      if ((localStringBuilder != null) && (localStringBuilder.length() > 0))
      {
        paramMessageForUniteGrayTip.editState = 1;
        paramMessageForUniteGrayTip.editTime = NetConnInfoCenter.getServerTimeMillis();
        paramMessageForUniteGrayTip.editMsgData = localStringBuilder.toString();
        localObject = BaseApplicationImpl.getApplication().getString(2131438086);
        paramString = paramString.concat(" ");
        j = paramString.length();
        k = ((String)localObject).length() + j;
        paramString = paramString.concat((String)localObject);
        paramUniteGrayTipParam.jdField_c_of_type_JavaLangString = paramString;
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
          if (paramMessageForUniteGrayTip.editMsgData != null)
          {
            paramInt = paramMessageForUniteGrayTip.editMsgData.length();
            i = paramInt;
            if (paramInt > 2) {
              i = 2;
            }
            paramUniteGrayTipParam = jdField_a_of_type_JavaLangString;
            l1 = paramMessageForUniteGrayTip.editTime;
            l2 = paramMessageForUniteGrayTip.msgUid;
            l3 = paramMessageForUniteGrayTip.uniseq;
            if (i <= 0) {
              break label874;
            }
            paramList = paramMessageForUniteGrayTip.editMsgData.substring(0, i);
            QLog.d(paramUniteGrayTipParam, 2, new Object[] { "revoke msg beding edit,time=", Long.valueOf(l1), ",wording=", paramString, ",msguid=", Long.valueOf(l2), ",uniseq=", Long.valueOf(l3), ",start =", Integer.valueOf(j), ",end=", Integer.valueOf(k), ",msgDta[0-2]=", paramList, ",msgGray.editMsgData.length=", Integer.valueOf(paramMessageForUniteGrayTip.editMsgData.length()), ",atString=", localJSONArray.toString() });
          }
        }
        else {
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8008E55", "0X8008E55", 0, 0, "", "", "", "");
        }
      }
      label874:
      while (!QLog.isColorLevel()) {
        for (;;)
        {
          int k;
          long l1;
          long l2;
          long l3;
          return;
          paramInt = 0;
          continue;
          paramList = "";
        }
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "revoke msg handle empty msg data");
      return;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    String str;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        break label43;
      }
    }
    label43:
    for (paramMessageRecord = "null";; paramMessageRecord = Long.valueOf(jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq))
    {
      QLog.e(str, 2, new Object[] { "revoke msg current clicked msg uinseq =", paramMessageRecord });
      return;
    }
  }
  
  public static void a(List paramList)
  {
    jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    paramQQAppInterface = paramQQAppInterface.a().b(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.istroop);
    if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
    {
      Object localObject1;
      Object localObject2;
      if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.d != null))
      {
        localObject1 = paramQQAppInterface.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (((localObject2 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject2).tipParam != null) && (paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int == ((MessageForUniteGrayTip)localObject2).tipParam.jdField_b_of_type_Int) && (paramMessageForUniteGrayTip.tipParam.d.equals(((MessageForUniteGrayTip)localObject2).tipParam.d)))
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, repeat grayTip in cache");
            }
            return true;
          }
        }
      }
      int i = paramQQAppInterface.size() - 1;
      if (i >= 0)
      {
        if ((paramQQAppInterface.size() - i <= 10) && ((paramQQAppInterface.get(i) instanceof MessageForUniteGrayTip)))
        {
          localObject1 = (MessageForUniteGrayTip)paramQQAppInterface.get(i);
          if ((((MessageForUniteGrayTip)localObject1).tipParam != null) && (paramMessageForUniteGrayTip.tipParam != null)) {
            break label231;
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          label231:
          int k;
          int j;
          if (paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_ArrayOfInt != null)
          {
            localObject2 = paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_ArrayOfInt;
            k = localObject2.length;
            j = 0;
            while (j < k)
            {
              if (localObject2[j] == ((MessageForUniteGrayTip)localObject1).tipParam.jdField_b_of_type_Int)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, mutex grayTip in cache");
                }
                return true;
              }
              j += 1;
            }
          }
          if (((MessageForUniteGrayTip)localObject1).tipParam.jdField_b_of_type_ArrayOfInt != null)
          {
            localObject1 = ((MessageForUniteGrayTip)localObject1).tipParam.jdField_b_of_type_ArrayOfInt;
            k = localObject1.length;
            j = 0;
            while (j < k)
            {
              if (localObject1[j] == paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, mutex grayTip in cache");
                }
                return true;
              }
              j += 1;
            }
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2031) {}
    do
    {
      return true;
      if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {
        break;
      }
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      if (paramMessageRecord.tipParam == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, mutex grayTip in cache");
        }
        return false;
      }
    } while (paramMessageRecord.tipParam.jdField_b_of_type_Int == 1);
    return false;
  }
  
  public static boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    long l1;
    long l2;
    int i;
    int j;
    long l3;
    long l4;
    long l5;
    if (paramMessageForUniteGrayTip != null)
    {
      bool1 = bool2;
      if (paramMessageForUniteGrayTip.editState == 1)
      {
        l1 = NetConnInfoCenter.getServerTimeMillis() - paramMessageForUniteGrayTip.editTime;
        if ((b == null) || (paramMessageForUniteGrayTip.uniseq != b.uniseq))
        {
          bool1 = bool2;
          if (Math.abs(l1) < 180000L) {}
        }
        else
        {
          l2 = System.currentTimeMillis();
          if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.jdField_a_of_type_JavaUtilArrayList != null)) {
            paramMessageForUniteGrayTip.tipParam.jdField_a_of_type_JavaUtilArrayList.clear();
          }
          paramMessageForUniteGrayTip.editState = 0;
          paramMessageForUniteGrayTip.editTime = 0L;
          String str = " " + BaseApplicationImpl.getApplication().getString(2131438086);
          if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString != null)) {
            paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString = paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString.replace(str, "");
          }
          if (paramMessageForUniteGrayTip.msg != null) {
            paramMessageForUniteGrayTip.msg = paramMessageForUniteGrayTip.msg.replace(str, "");
          }
          if (paramMessageForUniteGrayTip.contentDescription != null) {
            paramMessageForUniteGrayTip.contentDescription = paramMessageForUniteGrayTip.contentDescription.replace(str, "");
          }
          if (paramMessageForUniteGrayTip.tipParam != null) {
            paramMessageForUniteGrayTip.updateUniteGrayTipMsgData(paramQQAppInterface);
          }
          if ((b != null) && (paramMessageForUniteGrayTip.uniseq == b.uniseq)) {
            ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8008E55", "0X8008E55", 1, 0, "", "", "", "");
          }
          if ((b != null) && (paramMessageForUniteGrayTip.uniseq == b.uniseq)) {
            b = null;
          }
          if (QLog.isColorLevel())
          {
            if (paramMessageForUniteGrayTip.editMsgData == null) {
              break label468;
            }
            i = paramMessageForUniteGrayTip.editMsgData.length();
            j = i;
            if (i > 2) {
              j = 2;
            }
            paramQQAppInterface = jdField_a_of_type_JavaLangString;
            l3 = System.currentTimeMillis();
            l4 = paramMessageForUniteGrayTip.msgUid;
            l5 = paramMessageForUniteGrayTip.uniseq;
            if (j <= 0) {
              break label473;
            }
          }
        }
      }
    }
    label468:
    label473:
    for (paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.editMsgData.substring(0, j);; paramMessageForUniteGrayTip = "")
    {
      QLog.e(paramQQAppInterface, 2, new Object[] { "revoke msg handle update edit cost =", Long.valueOf(l3 - l2), ", disappear time delta =", Long.valueOf(l1), ", msguid=", Long.valueOf(l4), ",uniseq=", Long.valueOf(l5), ",msgDta[0-2]=", paramMessageForUniteGrayTip });
      bool1 = true;
      return bool1;
      i = 0;
      break;
    }
  }
  
  public static void b()
  {
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    b = null;
    String str;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      if (b != null) {
        break label47;
      }
    }
    label47:
    for (Object localObject = "null";; localObject = Long.valueOf(b.uniseq))
    {
      QLog.e(str, 2, new Object[] { "revoke msg cleanCurrentRevokeMsg ,uinseq =", localObject });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipUtil
 * JD-Core Version:    0.7.0.1
 */