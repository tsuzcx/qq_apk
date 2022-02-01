package com.tencent.mobileqq.graytip;

import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.anim.config.TroopDragonKingAnimEntryConfig;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pushdialog.PushDialogHandler;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterManager;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Set;
import msf.msgcomm.msg_comm.ExtGroupKeyInfo;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122.MsgBody;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class UniteGrayTipUtil
{
  private static MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  public static String a;
  private static List<MessageRecord> jdField_a_of_type_JavaUtilList = new ArrayList(1);
  private static MessageRecord b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniteGrayTip";
  }
  
  public static int a(int paramInt)
  {
    int k = 1;
    int i;
    int j;
    if ((paramInt & 0x1) == 1)
    {
      i = 1;
      if ((paramInt & 0x2) != 2) {
        break label50;
      }
      j = 1;
      label20:
      if ((paramInt & 0x4) != 4) {
        break label55;
      }
      paramInt = k;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((j == 0) || (paramInt != 0))
        {
          return -5040;
          i = 0;
          break;
          label50:
          j = 0;
          break label20;
          label55:
          paramInt = 0;
          continue;
        }
        return -5021;
      }
    }
    if (j != 0)
    {
      if (paramInt != 0) {
        return -5020;
      }
      return -5023;
    }
    return -5022;
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, long paramLong1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "createUniteGrayTip contentXml " + paramString2);
    }
    paramString2 = a(paramString2);
    if ((paramString2 == null) || (a(paramString1, paramQQAppInterface, paramLong2, paramLong3, paramArrayOfByte))) {}
    UniteGrayTipParam localUniteGrayTipParam;
    Object localObject1;
    do
    {
      return null;
      localUniteGrayTipParam = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentAccountUin(), "", paramInt1, paramInt2, 655397, paramLong1);
      localObject1 = paramString2.a();
    } while (localObject1 == null);
    paramString2 = "";
    HashMap localHashMap = ((UniteEntity.Note)localObject1).a();
    Iterator localIterator = localHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      Object localObject2 = localHashMap.get(localInteger);
      if (localInteger.intValue() != 1) {
        break label219;
      }
      paramString2 = (String)localObject2;
    }
    label219:
    for (;;)
    {
      break;
      a(paramQQAppInterface, localUniteGrayTipParam, (UniteEntity.Note)localObject1, paramInt1, paramString1);
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, localUniteGrayTipParam);
      ((MessageForUniteGrayTip)localObject1).saveExtInfoToExtStr("unite_gray_tips_align", paramString2);
      a(paramQQAppInterface, paramString1, paramInt1, paramLong2, paramLong3, paramArrayOfByte);
      return localObject1;
    }
  }
  
  private static UniteEntity.Note a(UniteEntity.Note paramNote1, UniteEntity.Note paramNote2)
  {
    if (paramNote1 != null) {
      paramNote2 = paramNote1.a();
    }
    return paramNote2;
  }
  
  public static UniteEntity a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseXML " + paramString);
    }
    Object localObject4;
    boolean bool;
    try
    {
      paramString = new ByteArrayInputStream(paramString.getBytes("utf-8"));
      localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput(paramString, "utf-8");
      i = localXmlPullParser.getEventType();
      localObject4 = null;
      bool = true;
      localObject1 = null;
      paramString = null;
    }
    catch (Exception localException1)
    {
      try
      {
        XmlPullParser localXmlPullParser;
        Object localObject1;
        int i = localXmlPullParser.next();
        paramString = (String)localObject3;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          Object localObject5;
          paramString = localException3;
          localObject2 = localException4;
        }
      }
      localException1 = localException1;
      paramString = null;
      if (!QLog.isColorLevel()) {
        break label1073;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "parseXML, exception: ", localException1);
      bool = false;
    }
    if (i != 1)
    {
      localObject5 = localObject1;
      for (;;)
      {
        try
        {
          str2 = localXmlPullParser.getName();
          switch (i)
          {
          case 2: 
            localObject5 = localObject1;
            if (str2.equals("gtip"))
            {
              if (localObject1 != null)
              {
                localObject3 = paramString;
                break label1121;
              }
              localObject5 = localObject1;
              paramString = new UniteEntity(1);
            }
            break;
          }
        }
        catch (Exception localException3)
        {
          String str2;
          Object localObject3;
          int j;
          paramString = localObject5;
          continue;
        }
        try
        {
          localObject1 = paramString.a();
          j = localXmlPullParser.getAttributeCount();
          i = 0;
          if (i < j)
          {
            localObject3 = localXmlPullParser.getAttributeName(i);
            localObject4 = localXmlPullParser.getAttributeValue(i);
            if (((String)localObject3).equals("align")) {
              ((UniteEntity.Note)localObject1).a(1, localObject4);
            }
            i += 1;
            continue;
          }
          localObject3 = paramString;
          paramString = (String)localObject1;
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
          if (!bool)
          {
            localObject4 = paramString;
            break label1121;
            localObject5 = localObject1;
            if (str2.equals("dialog"))
            {
              if (localObject1 != null)
              {
                localObject3 = paramString;
                break label1121;
              }
              localObject5 = localObject1;
              localObject1 = new UniteEntity(6);
            }
          }
        }
        catch (Exception localException2)
        {
          continue;
        }
        try
        {
          localObject3 = ((UniteEntity)localObject1).a();
          paramString = (String)localObject3;
        }
        catch (Exception localException5)
        {
          paramString = localObject2;
          localObject2 = localException5;
          continue;
        }
        localObject5 = localObject1;
        if (str2.equals("nor"))
        {
          localObject5 = localObject1;
          localObject4 = new UniteEntity.Note(2);
          localObject3 = paramString;
          paramString = (String)localObject4;
        }
        else
        {
          localObject5 = localObject1;
          if (str2.equals("url"))
          {
            localObject5 = localObject1;
            localObject4 = new UniteEntity.Note(3);
            localObject3 = paramString;
            paramString = (String)localObject4;
          }
          else
          {
            localObject5 = localObject1;
            if (str2.equals("qq"))
            {
              localObject5 = localObject1;
              localObject4 = new UniteEntity.Note(4);
              localObject3 = paramString;
              paramString = (String)localObject4;
            }
            else
            {
              localObject5 = localObject1;
              if (str2.equals("img"))
              {
                localObject5 = localObject1;
                localObject4 = new UniteEntity.Note(5);
                localObject3 = paramString;
                paramString = (String)localObject4;
              }
              else
              {
                localObject5 = localObject1;
                if (str2.equals("title"))
                {
                  localObject5 = localObject1;
                  localObject4 = new UniteEntity.Note(7);
                  localObject3 = paramString;
                  paramString = (String)localObject4;
                }
                else
                {
                  localObject5 = localObject1;
                  if (str2.equals("alert"))
                  {
                    localObject5 = localObject1;
                    localObject4 = new UniteEntity.Note(8);
                    localObject3 = paramString;
                    paramString = (String)localObject4;
                  }
                  else
                  {
                    localObject5 = localObject1;
                    if (str2.equals("btn"))
                    {
                      localObject5 = localObject1;
                      localObject4 = new UniteEntity.Note(9);
                      localObject3 = paramString;
                      paramString = (String)localObject4;
                    }
                    else
                    {
                      localObject5 = localObject1;
                      if (str2.equals("item"))
                      {
                        localObject5 = localObject1;
                        localObject4 = new UniteEntity.Note(10);
                        localObject3 = paramString;
                        paramString = (String)localObject4;
                      }
                      else
                      {
                        localObject5 = localObject1;
                        if (!QLog.isColorLevel()) {
                          break label1148;
                        }
                        localObject5 = localObject1;
                        QLog.i(jdField_a_of_type_JavaLangString, 2, "parseXML, illegel note: " + str2);
                        break label1148;
                        if (localObject3 == null) {
                          break label1159;
                        }
                        localObject5 = localObject1;
                        bool = a(paramString, (UniteEntity.Note)localObject3, localXmlPullParser);
                        break label1159;
                        localObject5 = localObject1;
                        localObject3 = localXmlPullParser.getText();
                        if (localObject4 != null)
                        {
                          localObject5 = localObject1;
                          if (((UniteEntity.Note)localObject4).a())
                          {
                            localObject5 = localObject1;
                            if (!TextUtils.isEmpty((CharSequence)localObject3))
                            {
                              localObject5 = localObject1;
                              ((UniteEntity.Note)localObject4).a(2, localObject3);
                              localObject3 = paramString;
                              break label1121;
                              localObject5 = localObject1;
                              if (str2.equals("gtip"))
                              {
                                localObject3 = paramString;
                                break label1168;
                              }
                              localObject5 = localObject1;
                              localObject3 = paramString;
                              if (str2.equals("dialog")) {
                                break label1168;
                              }
                              localObject5 = localObject1;
                              if (str2.equals("nor"))
                              {
                                localObject5 = localObject1;
                                localObject3 = a((UniteEntity.Note)localObject4, paramString);
                                break label1168;
                              }
                              localObject5 = localObject1;
                              if (str2.equals("url"))
                              {
                                localObject5 = localObject1;
                                localObject3 = a((UniteEntity.Note)localObject4, paramString);
                                break label1168;
                              }
                              localObject5 = localObject1;
                              if (str2.equals("qq"))
                              {
                                localObject5 = localObject1;
                                localObject3 = a((UniteEntity.Note)localObject4, paramString);
                                break label1168;
                              }
                              localObject5 = localObject1;
                              if (str2.equals("img"))
                              {
                                localObject5 = localObject1;
                                localObject3 = a((UniteEntity.Note)localObject4, paramString);
                                break label1168;
                              }
                              localObject5 = localObject1;
                              if (str2.equals("title"))
                              {
                                localObject5 = localObject1;
                                localObject3 = a((UniteEntity.Note)localObject4, paramString);
                                break label1168;
                              }
                              localObject5 = localObject1;
                              if (str2.equals("alert"))
                              {
                                localObject3 = localObject4;
                                if (localObject4 == null) {
                                  localObject3 = paramString;
                                }
                                localObject5 = localObject1;
                                localObject3 = a((UniteEntity.Note)localObject3, paramString);
                                break label1168;
                              }
                              localObject5 = localObject1;
                              if (str2.equals("btn"))
                              {
                                localObject3 = localObject4;
                                if (localObject4 == null) {
                                  localObject3 = paramString;
                                }
                                localObject5 = localObject1;
                                localObject3 = a((UniteEntity.Note)localObject3, paramString);
                                break label1168;
                              }
                              localObject5 = localObject1;
                              localObject3 = paramString;
                              if (!str2.equals("item")) {
                                break label1168;
                              }
                              localObject5 = localObject1;
                              localObject3 = a((UniteEntity.Note)localObject4, paramString);
                              break label1168;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1159:
    label1168:
    label1172:
    for (;;)
    {
      label1073:
      Object localObject2;
      break label1125;
      String str1 = paramString;
      for (;;)
      {
        label1121:
        if (bool) {
          break label1172;
        }
        label1125:
        paramString = localObject2;
        if (!bool) {
          paramString = null;
        }
        return paramString;
        str1 = paramString;
        continue;
        str1 = paramString;
        continue;
        label1148:
        bool = false;
        str1 = paramString;
        paramString = (String)localObject4;
        break;
        str1 = paramString;
        localObject4 = paramString;
        continue;
        localObject4 = null;
      }
    }
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
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "rebuildUniteTipsContent");
    }
    UniteGrayTipParam localUniteGrayTipParam = paramMessageForUniteGrayTip.tipParam;
    Object localObject = paramMessageForUniteGrayTip.getExtInfoFromExtStr("bytes_content");
    if ((localUniteGrayTipParam != null) && (localUniteGrayTipParam.jdField_b_of_type_Int == 655397) && (!TextUtils.isEmpty((CharSequence)localObject))) {}
    try
    {
      localObject = a((String)localObject);
      if (localObject != null) {
        a(paramQQAppInterface, localUniteGrayTipParam, ((UniteEntity)localObject).a(), paramMessageForUniteGrayTip.istroop, paramMessageForUniteGrayTip.frienduin);
      }
      paramMessageForUniteGrayTip.msg = localUniteGrayTipParam.jdField_c_of_type_JavaLangString;
      paramMessageForUniteGrayTip.entity = ((UniteEntity)localObject);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
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
            paramQQAppInterface.a().g(131072);
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
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, List<MessageRecord> paramList, int paramInt, String paramString, UniteGrayTipParam paramUniteGrayTipParam)
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    Object localObject = null;
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    paramList = (List<MessageRecord>)localObject;
    int j;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (((localMessageRecord.msgtype != -1000) && (localMessageRecord.msgtype != -1051)) || (!MessageRecordInfo.a(localMessageRecord.issend)))
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
            break label334;
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
            label243:
            localObject = paramList;
            if (!TextUtils.isEmpty(paramList)) {
              break label389;
            }
            localObject = paramList;
            if (localMessageRecord.msgtype != -1051) {
              break label389;
            }
            localObject = paramList;
            if (localMessageRecord.atInfoList == null) {
              break label389;
            }
            paramList = localMessageRecord.atInfoList;
            localObject = new JSONArray();
            j = 0;
            label296:
            if (j >= paramList.size()) {}
          }
          else
          {
            try
            {
              ((JSONArray)localObject).put(j, ((AtTroopMemberInfo)paramList.get(j)).toJsonObject());
              j += 1;
              break label296;
              label334:
              j = 0;
              continue;
              if (paramInt != 3000) {
                break label243;
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
        label389:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label896;
        }
      }
    }
    label896:
    for (;;)
    {
      try
      {
        paramList = new JSONObject();
        paramList.put(MessageConstants.k, localObject);
        paramList.put(MessageConstants.l, paramInt);
        localJSONArray.put(i, paramList);
        i += 1;
        paramList = (List<MessageRecord>)localObject;
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
        localObject = BaseApplicationImpl.getApplication().getString(2131694362);
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
              break label873;
            }
            paramList = paramMessageForUniteGrayTip.editMsgData.substring(0, i);
            QLog.d(paramUniteGrayTipParam, 2, new Object[] { "revoke msg beding edit,time=", Long.valueOf(l1), ",wording=", paramString, ",msguid=", Long.valueOf(l2), ",uniseq=", Long.valueOf(l3), ",start =", Integer.valueOf(j), ",end=", Integer.valueOf(k), ",msgDta[0-2]=", paramList, ",msgGray.editMsgData.length=", Integer.valueOf(paramMessageForUniteGrayTip.editMsgData.length()), ",atString=", localJSONArray.toString() });
          }
        }
        else {
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8008E55", "0X8008E55", 0, 0, "", "", "", "");
        }
      }
      label873:
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
  
  private static void a(QQAppInterface paramQQAppInterface, UniteGrayTipParam paramUniteGrayTipParam, UniteEntity.Note paramNote, int paramInt, String paramString)
  {
    if (paramUniteGrayTipParam.a() != null) {
      paramUniteGrayTipParam.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = paramNote.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int j;
    int i;
    Object localObject5;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        paramNote = (UniteEntity.Note)localIterator1.next();
        Object localObject4;
        switch (paramNote.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 2: 
          paramNote = paramNote.a();
          localObject1 = paramNote.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            localObject3 = paramNote.get(localObject2);
            if (((Integer)localObject2).intValue() == 2) {
              localStringBuilder.append(localObject3);
            }
          }
        case 3: 
          paramNote = paramNote.a();
          localObject2 = paramNote.keySet();
          j = localStringBuilder.length();
          i = localStringBuilder.length();
          localObject1 = new Bundle();
          localObject2 = ((Set)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Integer)((Iterator)localObject2).next();
            if (((Integer)localObject3).intValue() == 2)
            {
              localObject3 = (String)paramNote.get(localObject3);
              localStringBuilder.append((String)localObject3);
              i = j + ((String)localObject3).length();
            }
            for (;;)
            {
              break;
              if (((Integer)localObject3).intValue() == 5)
              {
                localObject3 = (String)paramNote.get(localObject3);
                if (((String)localObject3).equals("2")) {
                  ((Bundle)localObject1).putString("textColor", "#FFFF596A");
                }
                for (;;)
                {
                  break;
                  if (((String)localObject3).equals("3")) {
                    ((Bundle)localObject1).putString("textColor", "#FF4D94FF");
                  }
                }
              }
              if (((Integer)localObject3).intValue() == 4)
              {
                localObject3 = (String)paramNote.get(localObject3);
                if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
                {
                  ((Bundle)localObject1).putInt("key_action", 1);
                  ((Bundle)localObject1).putString("key_action_DATA", (String)localObject3);
                }
                else if (((String)localObject3).startsWith("mqq"))
                {
                  ((Bundle)localObject1).putInt("key_action", 3);
                  ((Bundle)localObject1).putString("key_action_DATA", (String)localObject3);
                }
              }
            }
          }
          paramUniteGrayTipParam.a(j, i, (Bundle)localObject1);
          break;
        case 4: 
          localObject5 = paramNote.a();
          localObject3 = ((HashMap)localObject5).keySet();
          localStringBuilder.length();
          localStringBuilder.length();
          localObject1 = "";
          paramNote = "";
          localObject2 = "";
          Bundle localBundle = new Bundle();
          Iterator localIterator2 = ((Set)localObject3).iterator();
          if (localIterator2.hasNext())
          {
            localObject3 = (Integer)localIterator2.next();
            if (((Integer)localObject3).intValue() == 6)
            {
              localObject1 = (String)((HashMap)localObject5).get(localObject3);
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = paramNote;
              paramNote = (UniteEntity.Note)localObject3;
            }
            for (;;)
            {
              localObject3 = localObject2;
              localObject2 = paramNote;
              paramNote = (UniteEntity.Note)localObject1;
              localObject1 = localObject3;
              break;
              if (((Integer)localObject3).intValue() == 7)
              {
                localObject4 = (String)((HashMap)localObject5).get(localObject3);
                localObject3 = localObject1;
                paramNote = (UniteEntity.Note)localObject2;
                localObject1 = localObject4;
                localObject2 = localObject3;
              }
              else if (((Integer)localObject3).intValue() == 9)
              {
                localObject4 = (String)((HashMap)localObject5).get(localObject3);
                localObject2 = paramNote;
                localObject3 = localObject1;
                paramNote = (UniteEntity.Note)localObject4;
                localObject1 = localObject2;
                localObject2 = localObject3;
              }
              else
              {
                if (((Integer)localObject3).intValue() == 5)
                {
                  localObject3 = (String)((HashMap)localObject5).get(localObject3);
                  if (((String)localObject3).equals("2")) {
                    localBundle.putString("textColor", "#FFFF596A");
                  }
                  for (;;)
                  {
                    localObject3 = paramNote;
                    localObject4 = localObject1;
                    paramNote = (UniteEntity.Note)localObject2;
                    localObject1 = localObject3;
                    localObject2 = localObject4;
                    break;
                    if (((String)localObject3).equals("3")) {
                      localBundle.putString("textColor", "#FF4D94FF");
                    }
                  }
                }
                if (((Integer)localObject3).intValue() == 4)
                {
                  localObject3 = (String)((HashMap)localObject5).get(localObject3);
                  if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
                  {
                    localBundle.putInt("key_action", 1);
                    localBundle.putString("key_action_DATA", (String)localObject3);
                    localObject3 = paramNote;
                    localObject4 = localObject1;
                    paramNote = (UniteEntity.Note)localObject2;
                    localObject1 = localObject3;
                    localObject2 = localObject4;
                    continue;
                  }
                  if (((String)localObject3).startsWith("mqq"))
                  {
                    localBundle.putInt("key_action", 3);
                    localBundle.putString("key_action_DATA", (String)localObject3);
                  }
                }
                localObject3 = paramNote;
                localObject4 = localObject1;
                paramNote = (UniteEntity.Note)localObject2;
                localObject1 = localObject3;
                localObject2 = localObject4;
              }
            }
          }
          if (((String)localObject1).equals(paramQQAppInterface.getCurrentAccountUin()))
          {
            paramNote = HardCodeUtil.a(2131715741);
            if (TextUtils.equals("1", (CharSequence)localObject2)) {
              paramNote = BaseApplicationImpl.getContext().getString(2131692914);
            }
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "parseUniteGrayTipsContent name : " + paramNote);
            }
            localStringBuilder.append(paramNote);
            paramNote.length();
            break;
            if (UinTypeUtil.b(paramInt)) {
              paramNote = ContactUtils.j(paramQQAppInterface, (String)localObject1);
            } else if (UinTypeUtil.g(paramInt)) {
              paramNote = ContactUtils.g(paramQQAppInterface, paramString, (String)localObject1);
            }
          }
        case 5: 
          localObject2 = paramNote.a();
          localObject4 = ((HashMap)localObject2).keySet();
          j = localStringBuilder.length();
          i = localStringBuilder.length();
          localObject3 = new Bundle();
          paramNote = "";
          localObject1 = "";
          localObject4 = ((Set)localObject4).iterator();
          label1050:
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Integer)((Iterator)localObject4).next();
            if (((Integer)localObject5).intValue() == 8)
            {
              paramNote = (String)((HashMap)localObject2).get(localObject5);
              i = "icon".length();
              ((Bundle)localObject3).putString("image_resource", paramNote);
              paramNote = "icon";
              i += j;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      break label1050;
      if (((Integer)localObject5).intValue() == 4)
      {
        localObject5 = (String)((HashMap)localObject2).get(localObject5);
        if ((((String)localObject5).startsWith("http://")) || (((String)localObject5).startsWith("https://")))
        {
          ((Bundle)localObject3).putInt("key_action", 1);
          ((Bundle)localObject3).putString("key_action_DATA", (String)localObject5);
        }
        for (;;)
        {
          break;
          if (((String)localObject5).startsWith("mqq"))
          {
            ((Bundle)localObject3).putInt("key_action", 3);
            ((Bundle)localObject3).putString("key_action_DATA", (String)localObject5);
          }
        }
      }
      if (((Integer)localObject5).intValue() == 10)
      {
        localObject1 = (String)((HashMap)localObject2).get(localObject5);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          i = ((String)localObject1).length();
          ((Bundle)localObject3).putString("image_alt", (String)localObject1);
          i += j;
          continue;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localStringBuilder.append(paramNote);
          }
          for (;;)
          {
            paramUniteGrayTipParam.a(j, i, (Bundle)localObject3);
            break;
            localStringBuilder.append((String)localObject1);
          }
          paramUniteGrayTipParam.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
          QLog.d(jdField_a_of_type_JavaLangString, 2, "parseUniteGrayTipsContent content :" + localStringBuilder);
        }
        else {}
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForSystemMsg paramMessageForSystemMsg, structmsg.MsgInviteExt paramMsgInviteExt, String paramString)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    long l = paramMessageForSystemMsg.structMsg.msg.action_uin.get();
    int i = -1;
    paramMessageForSystemMsg = null;
    if (paramMsgInviteExt.uint32_src_type.has())
    {
      i = paramMsgInviteExt.uint32_src_type.get();
      paramMessageForSystemMsg = String.valueOf(paramMsgInviteExt.uint64_src_code.get());
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addTroopTipsFromSystemMsg-->from:" + i + " fromUin:" + paramMessageForSystemMsg);
    }
    paramMsgInviteExt = new Bundle();
    paramMsgInviteExt.putLong("troop_uin", Long.parseLong(paramString));
    paramMsgInviteExt.putString("inviteUin", String.valueOf(l));
    paramMsgInviteExt.putInt("from", i);
    paramMsgInviteExt.putString("fromUin", paramMessageForSystemMsg);
    paramMsgInviteExt.putBoolean("isSysPush", false);
    paramMsgInviteExt.putBoolean("isFromReqSystemMsgNew", true);
    a(paramQQAppInterface, paramString, -1L, paramMsgInviteExt);
  }
  
  /* Error */
  private static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +46 -> 49
    //   6: getstatic 16	com/tencent/mobileqq/graytip/UniteGrayTipUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: ldc_w 689
    //   13: iconst_4
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: iload_2
    //   24: invokestatic 379	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: lload_3
    //   31: invokestatic 263	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: lload 5
    //   39: invokestatic 263	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: aastore
    //   43: invokestatic 693	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   46: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: lload_3
    //   50: lload 5
    //   52: invokestatic 698	com/tencent/mobileqq/troop/honor/util/TroopHonorUtils:a	(JJ)Z
    //   55: ifeq +127 -> 182
    //   58: aload 7
    //   60: ifnull +29 -> 89
    //   63: iload_2
    //   64: iconst_1
    //   65: if_icmpne +24 -> 89
    //   68: aload_0
    //   69: ldc_w 700
    //   72: ldc 67
    //   74: invokevirtual 704	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   77: checkcast 700	com/tencent/mobileqq/troop/honor/api/ITroopHonorService
    //   80: aload_1
    //   81: aload 7
    //   83: iconst_1
    //   84: invokeinterface 708 4 0
    //   89: ldc2_w 709
    //   92: lload 5
    //   94: lcmp
    //   95: ifne +179 -> 274
    //   98: lconst_1
    //   99: lload_3
    //   100: lcmp
    //   101: ifne +173 -> 274
    //   104: aload 7
    //   106: ifnull +168 -> 274
    //   109: iload_2
    //   110: iconst_1
    //   111: if_icmpne +163 -> 274
    //   114: new 712	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData
    //   117: dup
    //   118: invokespecial 713	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:<init>	()V
    //   121: astore 8
    //   123: aload 8
    //   125: aload 7
    //   127: invokevirtual 717	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   130: pop
    //   131: aload 8
    //   133: getfield 720	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:all_read	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   136: invokevirtual 639	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   139: ifeq +320 -> 459
    //   142: aload 8
    //   144: getfield 720	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:all_read	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   147: invokevirtual 641	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   150: i2l
    //   151: lstore_3
    //   152: ldc 67
    //   154: astore_0
    //   155: aload 8
    //   157: getfield 724	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:feed_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   160: invokevirtual 727	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   163: ifeq +12 -> 175
    //   166: aload 8
    //   168: getfield 724	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:feed_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   171: invokevirtual 729	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   174: astore_0
    //   175: lconst_0
    //   176: lload_3
    //   177: lcmp
    //   178: ifne +49 -> 227
    //   181: return
    //   182: lload 5
    //   184: ldc2_w 730
    //   187: lcmp
    //   188: ifne -99 -> 89
    //   191: aload 7
    //   193: ifnull -104 -> 89
    //   196: iload_2
    //   197: iconst_1
    //   198: if_icmpne -109 -> 89
    //   201: aload_0
    //   202: getstatic 601	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   205: invokevirtual 605	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   208: checkcast 607	com/tencent/mobileqq/app/TroopManager
    //   211: astore_0
    //   212: aload_0
    //   213: ifnull -124 -> 89
    //   216: aload_0
    //   217: aload_1
    //   218: aload 7
    //   220: iconst_1
    //   221: invokevirtual 733	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;[BI)V
    //   224: goto -135 -> 89
    //   227: new 422	org/json/JSONObject
    //   230: dup
    //   231: invokespecial 423	org/json/JSONObject:<init>	()V
    //   234: astore 8
    //   236: aload 8
    //   238: ldc_w 735
    //   241: aload_0
    //   242: invokevirtual 429	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 8
    //   248: ldc_w 737
    //   251: aload_1
    //   252: invokevirtual 429	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: ldc_w 739
    //   259: ldc_w 741
    //   262: aload 8
    //   264: invokevirtual 742	org/json/JSONObject:toString	()Ljava/lang/String;
    //   267: ldc_w 744
    //   270: invokestatic 749	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   273: pop
    //   274: ldc2_w 750
    //   277: lload 5
    //   279: lcmp
    //   280: ifne -99 -> 181
    //   283: aload 7
    //   285: ifnull -104 -> 181
    //   288: new 753	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr
    //   291: dup
    //   292: invokespecial 754	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:<init>	()V
    //   295: astore_0
    //   296: aload_0
    //   297: aload 7
    //   299: invokevirtual 755	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   302: pop
    //   303: iconst_0
    //   304: istore_2
    //   305: aload_0
    //   306: getfield 758	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:uint32_gray_tips_from	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   309: invokevirtual 639	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   312: ifeq +11 -> 323
    //   315: aload_0
    //   316: getfield 758	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:uint32_gray_tips_from	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   319: invokevirtual 641	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   322: istore_2
    //   323: iconst_1
    //   324: iload_2
    //   325: if_icmpne +99 -> 424
    //   328: aconst_null
    //   329: ldc_w 509
    //   332: ldc 67
    //   334: ldc 67
    //   336: ldc_w 760
    //   339: ldc_w 760
    //   342: iconst_1
    //   343: iconst_0
    //   344: ldc_w 762
    //   347: ldc_w 762
    //   350: ldc 67
    //   352: ldc 67
    //   354: invokestatic 516	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   357: return
    //   358: astore_0
    //   359: aload_0
    //   360: invokevirtual 763	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   363: getstatic 16	com/tencent/mobileqq/graytip/UniteGrayTipUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   366: iconst_1
    //   367: ldc_w 765
    //   370: aload_0
    //   371: invokestatic 419	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   374: return
    //   375: astore_0
    //   376: getstatic 16	com/tencent/mobileqq/graytip/UniteGrayTipUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   379: iconst_1
    //   380: ldc_w 767
    //   383: aload_0
    //   384: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   387: goto -131 -> 256
    //   390: astore_0
    //   391: aload_0
    //   392: invokevirtual 763	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   395: getstatic 16	com/tencent/mobileqq/graytip/UniteGrayTipUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   398: iconst_1
    //   399: ldc_w 765
    //   402: aload_0
    //   403: invokestatic 419	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   406: goto -132 -> 274
    //   409: astore_0
    //   410: getstatic 16	com/tencent/mobileqq/graytip/UniteGrayTipUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   413: iconst_1
    //   414: ldc_w 769
    //   417: aload_0
    //   418: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   421: goto -147 -> 274
    //   424: iconst_2
    //   425: iload_2
    //   426: if_icmpne -245 -> 181
    //   429: aconst_null
    //   430: ldc_w 509
    //   433: ldc 67
    //   435: ldc 67
    //   437: ldc_w 760
    //   440: ldc_w 760
    //   443: iconst_2
    //   444: iconst_0
    //   445: ldc_w 762
    //   448: ldc_w 762
    //   451: ldc 67
    //   453: ldc 67
    //   455: invokestatic 516	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   458: return
    //   459: lconst_0
    //   460: lstore_3
    //   461: goto -309 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	paramQQAppInterface	QQAppInterface
    //   0	464	1	paramString	String
    //   0	464	2	paramInt	int
    //   0	464	3	paramLong1	long
    //   0	464	5	paramLong2	long
    //   0	464	7	paramArrayOfByte	byte[]
    //   121	142	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   288	303	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   305	323	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   328	357	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   429	458	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   236	256	375	org/json/JSONException
    //   114	152	390	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   155	175	390	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   227	236	390	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   236	256	390	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   256	274	390	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   376	387	390	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   410	421	390	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   256	274	409	java/lang/UnsatisfiedLinkError
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "----------addTroopTipsMr troopUin: " + paramString);
    }
    if (paramLong < 0L) {
      NetConnInfoCenter.getServerTime();
    }
    paramQQAppInterface = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.joinSplitMsg", 2, "addFriendTipsMr troopUin=" + paramString);
    }
    paramQQAppInterface.a(paramString, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, msg_comm.MsgHead paramMsgHead)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte));
    paramArrayOfByte = localTroopManager.b(str);
    Object localObject = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    TroopInfoHandler localTroopInfoHandler = (TroopInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new TroopInfo();
      paramArrayOfByte.troopuin = String.valueOf(str);
      paramArrayOfByte.troopcode = String.valueOf(paramLong1);
      localTroopManager.a(paramArrayOfByte);
      localTroopInfoHandler.b(paramArrayOfByte.troopuin);
      ((TroopHandler)localObject).a(1, BizTroopHandler.a(paramArrayOfByte.troopuin), 0L, 2, 0, 0, true);
    }
    for (;;)
    {
      ((TroopHandler)localObject).a(paramArrayOfByte.troopuin, Boolean.valueOf(false));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleTroopSystemMessageResp-->msgTime:" + paramLong2 + ":addFriendTipsMr");
      }
      localObject = new Bundle();
      ((Bundle)localObject).putLong("troop_uin", Long.parseLong(paramArrayOfByte.troopuin));
      ((Bundle)localObject).putString("inviteUin", null);
      ((Bundle)localObject).putInt("from", -1);
      ((Bundle)localObject).putString("fromUin", null);
      ((Bundle)localObject).putBoolean("isSysPush", true);
      ((Bundle)localObject).putBoolean("isFromReqSystemMsgNew", false);
      if ((paramMsgHead != null) && (paramMsgHead.ext_group_key_info.has()))
      {
        paramMsgHead = (msg_comm.ExtGroupKeyInfo)paramMsgHead.ext_group_key_info.get();
        int i = paramMsgHead.cur_max_seq.get();
        paramLong1 = paramMsgHead.cur_time.get();
        ((Bundle)localObject).putInt("joinTroopSeq", i);
        ((Bundle)localObject).putLong("joinTroopTime", paramLong1);
      }
      a(paramQQAppInterface, paramArrayOfByte.troopuin, paramLong2, (Bundle)localObject);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    submsgtype0x122.MsgBody localMsgBody = new submsgtype0x122.MsgBody();
    localMsgBody.mergeFrom(paramArrayOfByte);
    PushDialogHandler.a().a(localMsgBody, paramMsgInfo, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp message prepared");
    }
    if (paramBoolean) {}
    try
    {
      b(paramQQAppInterface, paramArrayOfByte, paramMsgInfo);
      return;
    }
    catch (UnsupportedEncodingException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    a(paramQQAppInterface, paramArrayOfByte, paramMsgInfo);
    return;
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
  
  public static void a(List<MessageRecord> paramList)
  {
    jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (paramMessageForUniteGrayTip == null) {}
    do
    {
      do
      {
        return false;
        if (((paramMessageForUniteGrayTip.tipParam.a) || (MsgProxyUtils.b(paramMessageForUniteGrayTip.msgtype))) && ((paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_Boolean) || (MsgProxyUtils.c(paramMessageForUniteGrayTip.msgtype)))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, error param");
      return false;
    } while (b(paramQQAppInterface, paramMessageForUniteGrayTip));
    boolean bool2 = paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_Boolean;
    if (!paramMessageForUniteGrayTip.tipParam.e) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramQQAppInterface.getMessageFacade().a(paramMessageForUniteGrayTip, paramQQAppInterface.getCurrentAccountUin(), false, bool2, true, bool1);
      return true;
    }
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
          if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.a() != null)) {
            paramMessageForUniteGrayTip.tipParam.a();
          }
          paramMessageForUniteGrayTip.editState = 0;
          paramMessageForUniteGrayTip.editTime = 0L;
          StringBuilder localStringBuilder = new StringBuilder();
          String str = " " + BaseApplicationImpl.getApplication().getString(2131694362);
          if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString != null)) {
            paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString = paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString.replace(str, "");
          }
          if (paramMessageForUniteGrayTip.msg != null) {
            paramMessageForUniteGrayTip.msg = paramMessageForUniteGrayTip.msg.replace(localStringBuilder.toString(), "");
          }
          if (paramMessageForUniteGrayTip.contentDescription != null) {
            paramMessageForUniteGrayTip.contentDescription = paramMessageForUniteGrayTip.contentDescription.replace(localStringBuilder.toString(), "");
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
              break label472;
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
              break label477;
            }
          }
        }
      }
    }
    label472:
    label477:
    for (paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.editMsgData.substring(0, j);; paramMessageForUniteGrayTip = "")
    {
      QLog.e(paramQQAppInterface, 2, new Object[] { "revoke msg handle update edit cost =", Long.valueOf(l3 - l2), ", disappear time delta =", Long.valueOf(l1), ", msguid=", Long.valueOf(l4), ",uniseq=", Long.valueOf(l5), ",msgDta[0-2]=", paramMessageForUniteGrayTip });
      bool1 = true;
      return bool1;
      i = 0;
      break;
    }
  }
  
  private static boolean a(UniteEntity.Note paramNote1, UniteEntity.Note paramNote2, XmlPullParser paramXmlPullParser)
  {
    paramNote1.a(paramNote2);
    int j = paramXmlPullParser.getAttributeCount();
    int i = 0;
    if (i < j)
    {
      paramNote2 = paramXmlPullParser.getAttributeName(i);
      String str = paramXmlPullParser.getAttributeValue(i);
      if (paramNote2.equals("txt")) {
        paramNote1.a(2, str);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramNote2.equals("jp"))
        {
          paramNote1.a(4, str);
        }
        else if (paramNote2.equals("uin"))
        {
          paramNote1.a(6, str);
        }
        else if (paramNote2.equals("nm"))
        {
          paramNote1.a(7, str);
        }
        else if (paramNote2.equals("tp"))
        {
          paramNote1.a(9, str);
        }
        else if (paramNote2.equals("si"))
        {
          paramNote1.a(3, str);
        }
        else if (paramNote2.equals("col"))
        {
          paramNote1.a(5, str);
        }
        else if (paramNote2.equals("src"))
        {
          paramNote1.a(8, str);
        }
        else if (paramNote2.equals("align"))
        {
          paramNote1.a(1, str);
        }
        else
        {
          if (!paramNote2.equals("alt")) {
            break label247;
          }
          paramNote1.a(10, str);
        }
      }
      label247:
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "parseXML, illegel field: " + paramNote2);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "friendUin friendUin :" + paramString + " busiId:" + paramLong2 + "isHideGrayfalse");
        bool2 = bool1;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool2;
          paramQQAppInterface = (ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "");
          paramQQAppInterface.isSupportTroopHonor(paramString);
          bool1 = bool2;
          if (TroopHonorUtils.a(paramLong1, paramLong2)) {
            if (!SimpleUIUtil.a())
            {
              bool1 = bool2;
              if (paramQQAppInterface.isSupportTroopHonor(paramString)) {}
            }
            else
            {
              bool1 = true;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "friendUin:" + paramString + " busiId:" + paramLong2 + " isHideGray" + bool1);
          }
          bool2 = bool1;
        } while (bool1);
        bool2 = bool1;
      } while (paramLong2 != 1021L);
      paramQQAppInterface = (TroopDragonKingAnimEntryConfig)QConfigManager.a().a(609);
      bool2 = bool1;
    } while (paramQQAppInterface == null);
    bool2 = paramQQAppInterface.a(paramString);
    if (!bool2) {
      bool1 = bool3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "friendUin:" + paramString + " busiId:" + paramLong2 + " isHideGray" + bool1 + " bSwitchOpen:" + bool2);
      }
      return bool1;
    }
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    boolean bool1 = true;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shieldTroopInteractionIconGrayTip friendUin :" + paramString + " busiId:" + paramLong2 + "isHideGrayfalse");
      }
      return false;
    }
    if (paramLong2 == 1038L)
    {
      if (!TroopMemberLevelUtils.a(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shieldTroopInteractionIconGrayTip friendUin :" + paramString + " busiId:" + paramLong2 + ",isHideGray:" + bool1);
        }
        return bool1;
      }
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramQQAppInterface == null) {
        break label219;
      }
    }
    label219:
    for (paramQQAppInterface = paramQQAppInterface.c(paramString);; paramQQAppInterface = null)
    {
      if ((paramQQAppInterface != null) && ((paramQQAppInterface.isHomeworkTroop()) || (paramQQAppInterface.isQidianPrivateTroop()))) {}
      for (bool1 = true;; bool1 = false)
      {
        break;
        boolean bool2 = a(paramString, paramQQAppInterface, paramLong1, paramLong2);
        bool1 = bool2;
        if (bool2) {
          break;
        }
        bool1 = b(paramString, paramQQAppInterface, paramLong1, paramLong2);
        break;
      }
    }
  }
  
  private static int b(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("<---getTempUinType: dump info:");
        localStringBuilder.append(" serviceType:").append(paramInt);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      return i;
      i = 1000;
      continue;
      i = 1004;
      continue;
      i = 1024;
      continue;
      i = 1005;
      continue;
      i = 1008;
      continue;
      i = 1006;
      continue;
      i = 1009;
      continue;
      i = 1001;
      continue;
      i = 1020;
      continue;
      i = 1021;
      continue;
      i = 1022;
      continue;
      i = 1023;
      continue;
      i = 1010;
      continue;
      i = 7400;
      continue;
      i = 10002;
      continue;
      i = 10004;
      continue;
      i = 1036;
      continue;
      i = 1032;
      continue;
      i = 1037;
      continue;
      i = 1038;
      continue;
      i = 1044;
      continue;
      i = 1045;
      continue;
      i = 10008;
      continue;
      i = 10009;
      continue;
      i = 10010;
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
  
  private static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    Object localObject = new submsgtype0x122.MsgBody();
    ((submsgtype0x122.MsgBody)localObject).mergeFrom(paramArrayOfByte);
    long l1;
    long l2;
    label58:
    label78:
    long l3;
    label99:
    int j;
    label120:
    int k;
    label141:
    label164:
    byte[] arrayOfByte;
    label188:
    long l4;
    if (((submsgtype0x122.MsgBody)localObject).uint64_busi_type.has())
    {
      l1 = ((submsgtype0x122.MsgBody)localObject).uint64_busi_type.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint64_busi_id.has()) {
        break label306;
      }
      l2 = ((submsgtype0x122.MsgBody)localObject).uint64_busi_id.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint32_ctrl_flag.has()) {
        break label312;
      }
      i = ((submsgtype0x122.MsgBody)localObject).uint32_ctrl_flag.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint64_templ_id.has()) {
        break label317;
      }
      l3 = ((submsgtype0x122.MsgBody)localObject).uint64_templ_id.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint32_c2c_type.has()) {
        break label323;
      }
      j = ((submsgtype0x122.MsgBody)localObject).uint32_c2c_type.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint32_service_type.has()) {
        break label329;
      }
      k = ((submsgtype0x122.MsgBody)localObject).uint32_service_type.get();
      if (!((submsgtype0x122.MsgBody)localObject).bytes_content.has()) {
        break label335;
      }
      paramArrayOfByte = ((submsgtype0x122.MsgBody)localObject).bytes_content.get().toByteArray();
      if (!((submsgtype0x122.MsgBody)localObject).bytes_pb_reserv.has()) {
        break label340;
      }
      arrayOfByte = ((submsgtype0x122.MsgBody)localObject).bytes_pb_reserv.get().toByteArray();
      if (!((submsgtype0x122.MsgBody)localObject).uint64_tips_seq_id.has()) {
        break label346;
      }
      l4 = ((submsgtype0x122.MsgBody)localObject).uint64_tips_seq_id.get();
      label209:
      localObject = "";
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
        break label352;
      }
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
    }
    for (;;)
    {
      int m = 0;
      int n = a(i);
      i = m;
      if (j == 1)
      {
        j = b(k);
        i = j;
        if (j == -1) {
          i = 0;
        }
      }
      paramMsgInfo = a(paramQQAppInterface, String.valueOf(paramMsgInfo.lFromUin), i, n, paramMsgInfo.uMsgTime, paramArrayOfByte, l1, l2, arrayOfByte);
      if (paramMsgInfo != null) {
        break label377;
      }
      return;
      l1 = 0L;
      break;
      label306:
      l2 = 0L;
      break label58;
      label312:
      i = 0;
      break label78;
      label317:
      l3 = 0L;
      break label99;
      label323:
      j = 0;
      break label120;
      label329:
      k = 0;
      break label141;
      label335:
      paramArrayOfByte = null;
      break label164;
      label340:
      arrayOfByte = null;
      break label188;
      label346:
      l4 = 0L;
      break label209;
      label352:
      paramArrayOfByte = (byte[])localObject;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
        paramArrayOfByte = (byte[])localObject;
      }
    }
    label377:
    paramMsgInfo.tipParam.d = String.valueOf(l4);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp uint64_tips_seq_id" + l4);
    }
    paramMsgInfo.saveExtInfoToExtStr("uint64_busi_type", String.valueOf(l1));
    paramMsgInfo.saveExtInfoToExtStr("uint64_busi_id", String.valueOf(l2));
    paramMsgInfo.saveExtInfoToExtStr("uint64_templ_id", String.valueOf(l3));
    paramMsgInfo.saveExtInfoToExtStr("bytes_content", paramArrayOfByte);
    paramMsgInfo.saveExtInfoToExtStr("uint64_tips_seq_id", String.valueOf(l4));
    if (i == 0) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800A560", "0X800A560", i, 0, "" + l2, "" + l1, "", "");
      paramMsgInfo.prewrite();
      a(paramQQAppInterface, paramMsgInfo);
      return;
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().b(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.istroop);
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
  
  public static boolean b(String paramString, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!TroopLuckyCharacterUtil.a.contains(Long.valueOf(paramLong2))) {
      return false;
    }
    paramString = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    return !((TroopLuckyCharacterManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_LUCKY_CHARACTER_MANAGER)).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipUtil
 * JD-Core Version:    0.7.0.1
 */