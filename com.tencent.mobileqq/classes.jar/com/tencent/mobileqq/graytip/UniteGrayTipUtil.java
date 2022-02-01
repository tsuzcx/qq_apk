package com.tencent.mobileqq.graytip;

import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.anim.config.TroopDragonKingAnimEntryConfig;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pushdialog.PushDialogHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.api.handler.ITroopBatchInfohandler;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService;
import com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterConstant;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import msf.msgcomm.msg_comm.ExtGroupKeyInfo;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GrayData;
import tencent.im.oidb.cmd0xe3e.oidb_0xe3e.ResvAttr;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122.MsgBody;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class UniteGrayTipUtil
{
  private static MessageRecord a;
  public static String a = "UniteGrayTip";
  private static MessageRecord b;
  
  public static int a(int paramInt)
  {
    int k = 0;
    int i;
    if ((paramInt & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((paramInt & 0x2) == 2) {
      j = 1;
    } else {
      j = 0;
    }
    if ((paramInt & 0x4) == 4) {
      k = 1;
    }
    paramInt = -5040;
    if (i != 0)
    {
      if (j != 0)
      {
        if (k != 0) {
          return -5040;
        }
        return -5021;
      }
    }
    else
    {
      if (j != 0)
      {
        if (k != 0) {
          return -5020;
        }
        return -5023;
      }
      paramInt = -5022;
    }
    return paramInt;
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, long paramLong1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createUniteGrayTip contentXml ");
      ((StringBuilder)localObject2).append(paramString2);
      QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject3 = a(paramString2);
    Object localObject1 = null;
    paramString2 = (String)localObject1;
    if (localObject3 != null)
    {
      if (a(paramString1, paramQQAppInterface, paramLong2, paramLong3, paramArrayOfByte)) {
        return null;
      }
      localObject2 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentAccountUin(), "", paramInt1, paramInt2, 655397, paramLong1);
      localObject3 = ((UniteEntity)localObject3).a();
      paramString2 = (String)localObject1;
      if (localObject3 != null)
      {
        localObject1 = ((UniteEntity.Note)localObject3).a();
        Iterator localIterator = ((HashMap)localObject1).keySet().iterator();
        paramString2 = "";
        while (localIterator.hasNext())
        {
          Integer localInteger = (Integer)localIterator.next();
          Object localObject4 = ((HashMap)localObject1).get(localInteger);
          if (localInteger.intValue() == 1) {
            paramString2 = (String)localObject4;
          }
        }
        a(paramQQAppInterface, (UniteGrayTipParam)localObject2, (UniteEntity.Note)localObject3, paramInt1, paramString1);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject2);
        ((MessageForUniteGrayTip)localObject1).saveExtInfoToExtStr("unite_gray_tips_align", paramString2);
        if (((UniteGrayTipParam)localObject2).g) {
          ((MessageForUniteGrayTip)localObject1).saveExtInfoToExtStr("pai_yi_pai_trigger_from_local", "1");
        }
        if (((UniteGrayTipParam)localObject2).h) {
          ((MessageForUniteGrayTip)localObject1).saveExtInfoToExtStr("pai_yi_pai_online_status", "1");
        }
        a(paramQQAppInterface, paramString1, paramInt1, paramLong2, paramLong3, paramArrayOfByte);
        paramString2 = (String)localObject1;
      }
    }
    return paramString2;
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
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseXML ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    for (;;)
    {
      boolean bool2;
      try
      {
        paramString = new ByteArrayInputStream(paramString.getBytes("utf-8"));
        XmlPullParser localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(paramString, "utf-8");
        int j = localXmlPullParser.getEventType();
        i = 1;
        localObject2 = null;
        bool1 = true;
        localObject4 = null;
        localObject1 = null;
        Object localObject3;
        if (j != i)
        {
          Object localObject5 = localObject2;
          try
          {
            String str = localXmlPullParser.getName();
            if ((j != 0) && (j != i))
            {
              bool2 = bool1;
              if (j != 2)
              {
                if (j != 3)
                {
                  if (j != 4)
                  {
                    i = 1;
                  }
                  else
                  {
                    localObject5 = localObject2;
                    paramString = localXmlPullParser.getText();
                    if (localObject4 == null) {
                      continue;
                    }
                    localObject5 = localObject2;
                    if (!((UniteEntity.Note)localObject4).a()) {
                      continue;
                    }
                    localObject5 = localObject2;
                    if (TextUtils.isEmpty(paramString)) {
                      continue;
                    }
                    localObject5 = localObject2;
                    ((UniteEntity.Note)localObject4).a(2, paramString);
                    continue;
                  }
                }
                else
                {
                  localObject5 = localObject2;
                  if (str.equals("gtip"))
                  {
                    paramString = (String)localObject1;
                    break label1203;
                  }
                  localObject5 = localObject2;
                  if (str.equals("dialog"))
                  {
                    paramString = (String)localObject1;
                    break label1203;
                  }
                  localObject5 = localObject2;
                  if (str.equals("nor"))
                  {
                    localObject5 = localObject2;
                    paramString = a((UniteEntity.Note)localObject4, (UniteEntity.Note)localObject1);
                    break label1203;
                  }
                  localObject5 = localObject2;
                  if (str.equals("url"))
                  {
                    localObject5 = localObject2;
                    paramString = a((UniteEntity.Note)localObject4, (UniteEntity.Note)localObject1);
                    break label1203;
                  }
                  localObject5 = localObject2;
                  if (str.equals("qq"))
                  {
                    localObject5 = localObject2;
                    paramString = a((UniteEntity.Note)localObject4, (UniteEntity.Note)localObject1);
                    break label1203;
                  }
                  localObject5 = localObject2;
                  if (str.equals("img"))
                  {
                    localObject5 = localObject2;
                    paramString = a((UniteEntity.Note)localObject4, (UniteEntity.Note)localObject1);
                    break label1203;
                  }
                  localObject5 = localObject2;
                  if (str.equals("title"))
                  {
                    localObject5 = localObject2;
                    paramString = a((UniteEntity.Note)localObject4, (UniteEntity.Note)localObject1);
                    break label1203;
                  }
                  localObject5 = localObject2;
                  if (str.equals("alert"))
                  {
                    paramString = (String)localObject4;
                    if (localObject4 == null) {
                      paramString = (String)localObject1;
                    }
                    localObject5 = localObject2;
                    paramString = a(paramString, (UniteEntity.Note)localObject1);
                    break label1203;
                  }
                  localObject5 = localObject2;
                  if (str.equals("btn"))
                  {
                    paramString = (String)localObject4;
                    if (localObject4 == null) {
                      paramString = (String)localObject1;
                    }
                    localObject5 = localObject2;
                    paramString = a(paramString, (UniteEntity.Note)localObject1);
                    break label1203;
                  }
                  localObject5 = localObject2;
                  if (str.equals("item"))
                  {
                    localObject5 = localObject2;
                    paramString = a((UniteEntity.Note)localObject4, (UniteEntity.Note)localObject1);
                    break label1203;
                  }
                  localObject5 = localObject2;
                  paramString = (String)localObject1;
                  if (!str.equals("olstatus")) {
                    break label1203;
                  }
                  localObject5 = localObject2;
                  paramString = a((UniteEntity.Note)localObject4, (UniteEntity.Note)localObject1);
                  break label1203;
                }
              }
              else
              {
                localObject5 = localObject2;
                if (str.equals("gtip"))
                {
                  if (localObject2 != null) {
                    continue;
                  }
                  localObject5 = localObject2;
                  localObject2 = new UniteEntity(1);
                  localObject1 = localObject2;
                  try
                  {
                    paramString = ((UniteEntity)localObject2).a();
                    localObject1 = localObject2;
                    j = localXmlPullParser.getAttributeCount();
                    i = 0;
                    if (i < j)
                    {
                      localObject1 = localObject2;
                      localObject4 = localXmlPullParser.getAttributeName(i);
                      localObject1 = localObject2;
                      localObject5 = localXmlPullParser.getAttributeValue(i);
                      localObject1 = localObject2;
                      if (((String)localObject4).equals("align"))
                      {
                        localObject1 = localObject2;
                        paramString.a(1, localObject5);
                      }
                      i += 1;
                      continue;
                    }
                  }
                  catch (Exception localException3)
                  {
                    paramString = (String)localObject1;
                    localObject1 = localException3;
                    continue;
                  }
                }
                else
                {
                  i = 1;
                  localObject5 = localException3;
                  if (!str.equals("dialog")) {
                    continue;
                  }
                  if (localException3 != null) {
                    continue;
                  }
                  localObject5 = localException3;
                  localObject3 = new UniteEntity(6);
                  localObject1 = localObject3;
                  paramString = ((UniteEntity)localObject3).a();
                }
                localObject1 = paramString;
                localObject4 = paramString;
                bool1 = bool2;
                paramString = (String)localObject3;
                localObject5 = localObject1;
                continue;
                localObject5 = localObject3;
                if (str.equals("nor"))
                {
                  localObject5 = localObject3;
                  paramString = new UniteEntity.Note(2);
                  break label1214;
                }
                localObject5 = localObject3;
                if (str.equals("url"))
                {
                  localObject5 = localObject3;
                  paramString = new UniteEntity.Note(3);
                  break label1214;
                }
                localObject5 = localObject3;
                if (str.equals("qq"))
                {
                  localObject5 = localObject3;
                  paramString = new UniteEntity.Note(4);
                  break label1214;
                }
                localObject5 = localObject3;
                if (str.equals("img"))
                {
                  localObject5 = localObject3;
                  paramString = new UniteEntity.Note(5);
                  break label1214;
                }
                localObject5 = localObject3;
                if (str.equals("title"))
                {
                  localObject5 = localObject3;
                  paramString = new UniteEntity.Note(7);
                  break label1214;
                }
                localObject5 = localObject3;
                if (str.equals("alert"))
                {
                  localObject5 = localObject3;
                  paramString = new UniteEntity.Note(8);
                  break label1214;
                }
                localObject5 = localObject3;
                if (str.equals("btn"))
                {
                  localObject5 = localObject3;
                  paramString = new UniteEntity.Note(9);
                  break label1214;
                }
                localObject5 = localObject3;
                if (str.equals("item"))
                {
                  localObject5 = localObject3;
                  paramString = new UniteEntity.Note(10);
                  break label1214;
                }
                localObject5 = localObject3;
                if (str.equals("olstatus"))
                {
                  localObject5 = localObject3;
                  paramString = new UniteEntity.Note(11);
                  break label1214;
                }
                localObject5 = localObject3;
                if (QLog.isColorLevel())
                {
                  localObject5 = localObject3;
                  paramString = jdField_a_of_type_JavaLangString;
                  localObject5 = localObject3;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localObject5 = localObject3;
                  localStringBuilder.append("parseXML, illegel note: ");
                  localObject5 = localObject3;
                  localStringBuilder.append(str);
                  localObject5 = localObject3;
                  QLog.i(paramString, 2, localStringBuilder.toString());
                }
                paramString = (String)localObject3;
                bool1 = false;
                localObject5 = localObject1;
                i = 1;
                if (!bool1)
                {
                  localObject3 = paramString;
                  paramString = (String)localObject5;
                  continue;
                }
                if (localObject5 != null)
                {
                  localObject1 = paramString;
                  bool1 = a((UniteEntity.Note)localObject4, (UniteEntity.Note)localObject5, localXmlPullParser);
                }
                localObject3 = paramString;
                paramString = (String)localObject4;
                continue;
              }
            }
            paramString = (String)localObject1;
            if (bool1)
            {
              localObject5 = localObject3;
              j = localXmlPullParser.next();
              localObject1 = paramString;
            }
          }
          catch (Exception localException1)
          {
            paramString = (String)localObject5;
            continue;
          }
        }
        paramString = (String)localObject3;
      }
      catch (Exception localException2)
      {
        paramString = null;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "parseXML, exception: ", localException2);
        }
        bool1 = false;
      }
      if (!bool1) {
        return null;
      }
      return paramString;
      label1203:
      boolean bool1 = bool2;
      int i = 1;
      Object localObject4 = null;
      continue;
      label1214:
      localObject4 = paramString;
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface, UniteGrayTipParam paramUniteGrayTipParam, UniteEntity.Note paramNote)
  {
    HashMap localHashMap = paramNote.a();
    Iterator localIterator = localHashMap.keySet().iterator();
    paramNote = "";
    long l1 = 0L;
    int i = 0;
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      int j = i;
      if (localInteger.intValue() == 11) {
        try
        {
          j = Integer.parseInt((String)localHashMap.get(localInteger));
        }
        catch (Exception localException1)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "parse status err: ", localException1);
          j = i;
        }
      }
      long l2 = l1;
      if (localInteger.intValue() == 12) {
        try
        {
          l2 = Long.parseLong((String)localHashMap.get(localInteger));
        }
        catch (Exception localException2)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "parse status err: ", localException2);
          l2 = l1;
        }
      }
      i = j;
      l1 = l2;
      if (localInteger.intValue() == 6)
      {
        paramNote = (String)localHashMap.get(localInteger);
        i = j;
        l1 = l2;
      }
    }
    boolean bool = paramQQAppInterface.getCurrentUin().equals(paramNote);
    paramQQAppInterface = (IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class);
    paramQQAppInterface = paramQQAppInterface.getOnlineStatusItem(paramQQAppInterface.translateStatus(i), l1, bool ^ true);
    if (paramQQAppInterface.a == 40001L) {
      paramQQAppInterface = paramQQAppInterface.e;
    } else {
      paramQQAppInterface = paramQQAppInterface.b;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "cur Status: ", Integer.valueOf(i), " exStatus: ", Long.valueOf(l1) });
    }
    paramUniteGrayTipParam.h = true;
    return paramQQAppInterface;
  }
  
  public static void a()
  {
    b = jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      Object localObject = b;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Long.valueOf(((MessageRecord)localObject).uniseq);
      }
      QLog.e(str, 2, new Object[] { "revoke msg set current send msg and clean click msg ,uinseq =", localObject });
    }
  }
  
  public static void a(AppInterface paramAppInterface, MessageForSystemMsg paramMessageForSystemMsg, structmsg.MsgInviteExt paramMsgInviteExt, String paramString)
  {
    Object localObject = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    long l = paramMessageForSystemMsg.structMsg.msg.action_uin.get();
    int i;
    if (paramMsgInviteExt.uint32_src_type.has())
    {
      i = paramMsgInviteExt.uint32_src_type.get();
      paramMessageForSystemMsg = String.valueOf(paramMsgInviteExt.uint64_src_code.get());
    }
    else
    {
      i = -1;
      paramMessageForSystemMsg = null;
    }
    if (QLog.isColorLevel())
    {
      paramMsgInviteExt = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addTroopTipsFromSystemMsg-->from:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" fromUin:");
      ((StringBuilder)localObject).append(paramMessageForSystemMsg);
      QLog.d(paramMsgInviteExt, 2, ((StringBuilder)localObject).toString());
    }
    paramMsgInviteExt = new Bundle();
    paramMsgInviteExt.putLong("troop_uin", Long.parseLong(paramString));
    paramMsgInviteExt.putString("inviteUin", String.valueOf(l));
    paramMsgInviteExt.putInt("from", i);
    paramMsgInviteExt.putString("fromUin", paramMessageForSystemMsg);
    paramMsgInviteExt.putBoolean("isSysPush", false);
    paramMsgInviteExt.putBoolean("isFromReqSystemMsgNew", true);
    a(paramAppInterface, paramString, -1L, paramMsgInviteExt);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, long paramLong, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----------addTroopTipsMr troopUin: ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramLong < 0L) {
      NetConnInfoCenter.getServerTime();
    }
    paramAppInterface = (ITroopManagerBizHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addFriendTipsMr troopUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d(".troop.joinSplitMsg", 2, ((StringBuilder)localObject).toString());
    }
    paramAppInterface.a(paramString, paramBundle);
  }
  
  public static void a(AppInterface paramAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, msg_comm.MsgHead paramMsgHead)
  {
    Object localObject2 = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte));
    Object localObject1 = ((TroopManager)localObject2).b(str);
    ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    paramArrayOfByte = (QQAppInterface)paramAppInterface;
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)paramArrayOfByte.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
    ITroopBatchInfohandler localITroopBatchInfohandler = (ITroopBatchInfohandler)paramArrayOfByte.getBusinessHandler(BusinessHandlerFactory.TROOP_BATCH_INFO_HANDLER);
    paramArrayOfByte = (byte[])localObject1;
    if (localObject1 == null)
    {
      paramArrayOfByte = new TroopInfo();
      paramArrayOfByte.troopuin = String.valueOf(str);
      paramArrayOfByte.troopcode = String.valueOf(paramLong1);
      ((TroopManager)localObject2).a(paramArrayOfByte);
      localITroopInfoHandler.a(paramArrayOfByte.troopuin);
      localITroopMemberListHandler.a(1, TroopFileHandler.a(paramArrayOfByte.troopuin), 0L, 2, 0, 0, true);
    }
    localITroopBatchInfohandler.a(paramArrayOfByte.troopuin, Boolean.valueOf(false));
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleTroopSystemMessageResp-->msgTime:");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append(":addFriendTipsMr");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("troop_uin", Long.parseLong(paramArrayOfByte.troopuin));
    ((Bundle)localObject1).putString("inviteUin", null);
    ((Bundle)localObject1).putInt("from", -1);
    ((Bundle)localObject1).putString("fromUin", null);
    ((Bundle)localObject1).putBoolean("isSysPush", true);
    ((Bundle)localObject1).putBoolean("isFromReqSystemMsgNew", false);
    if ((paramMsgHead != null) && (paramMsgHead.ext_group_key_info.has()))
    {
      paramMsgHead = (msg_comm.ExtGroupKeyInfo)paramMsgHead.ext_group_key_info.get();
      int i = paramMsgHead.cur_max_seq.get();
      paramLong1 = paramMsgHead.cur_time.get();
      ((Bundle)localObject1).putInt("joinTroopSeq", i);
      ((Bundle)localObject1).putLong("joinTroopTime", paramLong1);
    }
    a(paramAppInterface, paramArrayOfByte.troopuin, paramLong2, (Bundle)localObject1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "rebuildUniteTipsContent");
    }
    UniteGrayTipParam localUniteGrayTipParam = paramMessageForUniteGrayTip.tipParam;
    Object localObject = paramMessageForUniteGrayTip.getExtInfoFromExtStr("bytes_content");
    if ((localUniteGrayTipParam != null) && (localUniteGrayTipParam.b == 655397) && (!TextUtils.isEmpty((CharSequence)localObject))) {
      try
      {
        localObject = a((String)localObject);
        if (localObject != null) {
          a(paramQQAppInterface, localUniteGrayTipParam, ((UniteEntity)localObject).a(), paramMessageForUniteGrayTip.istroop, paramMessageForUniteGrayTip.frienduin);
        }
        boolean bool = localUniteGrayTipParam.g;
        if (bool) {
          paramMessageForUniteGrayTip.saveExtInfoToExtStr("pai_yi_pai_trigger_from_local", "1");
        }
        if (localUniteGrayTipParam.h) {
          paramMessageForUniteGrayTip.saveExtInfoToExtStr("pai_yi_pai_online_status", "1");
        }
        paramMessageForUniteGrayTip.msg = localUniteGrayTipParam.c;
        paramMessageForUniteGrayTip.entity = ((UniteEntity)localObject);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, UniteGrayTipParam paramUniteGrayTipParam, UniteEntity.Note paramNote, int paramInt, String paramString)
  {
    Object localObject1 = paramUniteGrayTipParam;
    if (paramUniteGrayTipParam.a() != null) {
      paramUniteGrayTipParam.a();
    }
    Object localObject2 = new StringBuilder();
    Iterator localIterator = paramNote.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 1;
    paramNote = (UniteEntity.Note)localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (UniteEntity.Note)localIterator.next();
      int j = ((UniteEntity.Note)localObject2).jdField_a_of_type_Int;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if (j != 2)
      {
        int m;
        int k;
        if (j != 3)
        {
          localObject3 = "";
          Object localObject7;
          Object localObject8;
          if (j != 4)
          {
            if (j != 5) {
              if (j == 11) {}
            }
            for (;;)
            {
              localObject2 = localObject1;
              break;
              paramNote.append(a(paramQQAppInterface, (UniteGrayTipParam)localObject1, (UniteEntity.Note)localObject2));
              continue;
              localObject7 = ((UniteEntity.Note)localObject2).a();
              localObject2 = ((HashMap)localObject7).keySet();
              m = paramNote.length();
              j = paramNote.length();
              localObject8 = new Bundle();
              localObject2 = ((Set)localObject2).iterator();
              localObject4 = "";
              for (localObject3 = localObject4; ((Iterator)localObject2).hasNext(); localObject3 = localObject6)
              {
                localObject9 = (Integer)((Iterator)localObject2).next();
                if (((Integer)localObject9).intValue() == 8)
                {
                  localObject3 = (String)((HashMap)localObject7).get(localObject9);
                  k = m + 4;
                  ((Bundle)localObject8).putString("image_resource", (String)localObject3);
                  localObject6 = "icon";
                  localObject5 = localObject4;
                }
                else if (((Integer)localObject9).intValue() == 4)
                {
                  localObject9 = (String)((HashMap)localObject7).get(localObject9);
                  if ((!((String)localObject9).startsWith("http://")) && (!((String)localObject9).startsWith("https://")))
                  {
                    k = j;
                    localObject5 = localObject4;
                    localObject6 = localObject3;
                    if (((String)localObject9).startsWith("mqq"))
                    {
                      ((Bundle)localObject8).putInt("key_action", 3);
                      ((Bundle)localObject8).putString("key_action_DATA", (String)localObject9);
                      k = j;
                      localObject5 = localObject4;
                      localObject6 = localObject3;
                    }
                  }
                  else
                  {
                    ((Bundle)localObject8).putInt("key_action", 1);
                    ((Bundle)localObject8).putString("key_action_DATA", (String)localObject9);
                    k = j;
                    localObject5 = localObject4;
                    localObject6 = localObject3;
                  }
                }
                else
                {
                  k = j;
                  localObject5 = localObject4;
                  localObject6 = localObject3;
                  if (((Integer)localObject9).intValue() == 10)
                  {
                    localObject5 = (String)((HashMap)localObject7).get(localObject9);
                    if (!TextUtils.isEmpty((CharSequence)localObject5))
                    {
                      j = ((String)localObject5).length() + m;
                      ((Bundle)localObject8).putString("image_alt", (String)localObject5);
                    }
                    localObject6 = localObject3;
                    k = j;
                  }
                }
                j = k;
                localObject4 = localObject5;
              }
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                paramNote.append((String)localObject3);
              } else {
                paramNote.append((String)localObject4);
              }
              ((UniteGrayTipParam)localObject1).a(m, j, (Bundle)localObject8);
            }
          }
          HashMap localHashMap = ((UniteEntity.Note)localObject2).a();
          localObject2 = localHashMap.keySet();
          j = paramNote.length();
          paramNote.length();
          Object localObject9 = new Bundle();
          Object localObject6 = ((Set)localObject2).iterator();
          localObject5 = "";
          localObject4 = localObject5;
          k = 0;
          localObject2 = paramNote;
          while (((Iterator)localObject6).hasNext())
          {
            Object localObject10 = (Integer)((Iterator)localObject6).next();
            if (((Integer)localObject10).intValue() == 6)
            {
              paramNote = (String)localHashMap.get(localObject10);
              localObject7 = localObject4;
              localObject8 = localObject3;
              m = k;
            }
            else if (((Integer)localObject10).intValue() == 7)
            {
              localObject8 = (String)localHashMap.get(localObject10);
              paramNote = (UniteEntity.Note)localObject5;
              localObject7 = localObject4;
              m = k;
            }
            else if (((Integer)localObject10).intValue() == 9)
            {
              localObject7 = (String)localHashMap.get(localObject10);
              paramNote = (UniteEntity.Note)localObject5;
              localObject8 = localObject3;
              m = k;
            }
            else if (((Integer)localObject10).intValue() == 5)
            {
              localObject10 = (String)localHashMap.get(localObject10);
              if (((String)localObject10).equals("2"))
              {
                ((Bundle)localObject9).putString("textColor", "#FFFF596A");
                paramNote = (UniteEntity.Note)localObject5;
                localObject7 = localObject4;
                localObject8 = localObject3;
                m = k;
              }
              else
              {
                paramNote = (UniteEntity.Note)localObject5;
                localObject7 = localObject4;
                localObject8 = localObject3;
                m = k;
                if (((String)localObject10).equals("3"))
                {
                  ((Bundle)localObject9).putString("textColor", "#FF4D94FF");
                  paramNote = (UniteEntity.Note)localObject5;
                  localObject7 = localObject4;
                  localObject8 = localObject3;
                  m = k;
                }
              }
            }
            else
            {
              paramNote = (UniteEntity.Note)localObject5;
              localObject7 = localObject4;
              localObject8 = localObject3;
              m = k;
              if (((Integer)localObject10).intValue() == 4)
              {
                localObject10 = (String)localHashMap.get(localObject10);
                if ((!((String)localObject10).startsWith("http://")) && (!((String)localObject10).startsWith("https://")))
                {
                  paramNote = (UniteEntity.Note)localObject5;
                  localObject7 = localObject4;
                  localObject8 = localObject3;
                  m = k;
                  if (!((String)localObject10).startsWith("mqq")) {
                    break label955;
                  }
                  ((Bundle)localObject9).putInt("key_action", 3);
                  ((Bundle)localObject9).putString("key_action_DATA", (String)localObject10);
                }
                else
                {
                  ((Bundle)localObject9).putInt("key_action", 1);
                  ((Bundle)localObject9).putString("key_action_DATA", (String)localObject10);
                }
                m = 1;
                localObject8 = localObject3;
                localObject7 = localObject4;
                paramNote = (UniteEntity.Note)localObject5;
              }
            }
            label955:
            localObject5 = paramNote;
            localObject4 = localObject7;
            localObject3 = localObject8;
            k = m;
          }
          if (((String)localObject5).equals(paramQQAppInterface.getCurrentAccountUin()))
          {
            paramNote = HardCodeUtil.a(2131715665);
            if (i != 0) {
              ((UniteGrayTipParam)localObject1).g = true;
            }
            if (TextUtils.equals("1", (CharSequence)localObject4)) {
              paramNote = BaseApplicationImpl.getContext().getString(2131692874);
            }
          }
          else if (UinTypeUtil.b(paramInt))
          {
            paramNote = ContactUtils.d(paramQQAppInterface, (String)localObject5);
          }
          else
          {
            paramNote = (UniteEntity.Note)localObject3;
            if (UinTypeUtil.g(paramInt)) {
              paramNote = ContactUtils.b(paramQQAppInterface, paramString, (String)localObject5);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject3 = jdField_a_of_type_JavaLangString;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("parseUniteGrayTipsContent name : ");
            ((StringBuilder)localObject4).append(paramNote);
            QLog.e((String)localObject3, 2, ((StringBuilder)localObject4).toString());
          }
          localObject3 = localObject2;
          ((StringBuilder)localObject3).append(paramNote);
          i = paramNote.length();
          if (k != 0) {
            ((UniteGrayTipParam)localObject1).a(j, j + i, (Bundle)localObject9);
          }
          i = 0;
          localObject2 = localObject1;
          paramNote = (UniteEntity.Note)localObject3;
        }
        else
        {
          k = i;
          localObject3 = ((UniteEntity.Note)localObject2).a();
          localObject2 = ((HashMap)localObject3).keySet();
          m = paramNote.length();
          i = paramNote.length();
          localObject4 = new Bundle();
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (Integer)((Iterator)localObject2).next();
            if (((Integer)localObject1).intValue() == 2)
            {
              localObject1 = (String)((HashMap)localObject3).get(localObject1);
              paramNote.append((String)localObject1);
              j = ((String)localObject1).length() + m;
            }
            for (;;)
            {
              i = j;
              break label1460;
              if (((Integer)localObject1).intValue() != 5) {
                break;
              }
              localObject1 = (String)((HashMap)localObject3).get(localObject1);
              if (((String)localObject1).equals("2"))
              {
                ((Bundle)localObject4).putString("textColor", "#FFFF596A");
                j = i;
              }
              else
              {
                j = i;
                if (((String)localObject1).equals("3"))
                {
                  ((Bundle)localObject4).putString("textColor", "#FF4D94FF");
                  j = i;
                }
              }
            }
            if (((Integer)localObject1).intValue() == 4)
            {
              localObject1 = (String)((HashMap)localObject3).get(localObject1);
              if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://")))
              {
                if (((String)localObject1).startsWith("mqq"))
                {
                  ((Bundle)localObject4).putInt("key_action", 3);
                  ((Bundle)localObject4).putString("key_action_DATA", (String)localObject1);
                }
              }
              else
              {
                ((Bundle)localObject4).putInt("key_action", 1);
                ((Bundle)localObject4).putString("key_action_DATA", (String)localObject1);
              }
            }
            label1460:
            localObject1 = paramUniteGrayTipParam;
          }
          ((UniteGrayTipParam)localObject1).a(m, i, (Bundle)localObject4);
          localObject2 = localObject1;
          i = k;
        }
      }
      else
      {
        j = i;
        localObject3 = paramNote;
        localObject4 = ((UniteEntity.Note)localObject2).a();
        localObject5 = ((HashMap)localObject4).keySet().iterator();
        for (;;)
        {
          localObject2 = localObject1;
          paramNote = (UniteEntity.Note)localObject3;
          i = j;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          paramNote = (Integer)((Iterator)localObject5).next();
          localObject2 = ((HashMap)localObject4).get(paramNote);
          if (paramNote.intValue() == 2) {
            ((StringBuilder)localObject3).append(localObject2);
          }
        }
      }
      localObject1 = localObject2;
    }
    ((UniteGrayTipParam)localObject1).c = paramNote.toString();
    paramQQAppInterface = jdField_a_of_type_JavaLangString;
    paramUniteGrayTipParam = new StringBuilder();
    paramUniteGrayTipParam.append("parseUniteGrayTipsContent content :");
    paramUniteGrayTipParam.append(paramNote);
    QLog.d(paramQQAppInterface, 2, paramUniteGrayTipParam.toString());
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("handleReserveData, friendUin: %s, uinType: %s, busiType: %s, busiId: %s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    bool = TroopHonorUtils.a(paramLong1, paramLong2);
    Object localObject = "";
    if (bool)
    {
      if ((paramArrayOfByte != null) && (paramInt == 1)) {
        ((ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "")).updatePushTroopHonor(paramString, paramArrayOfByte, 1);
      }
    }
    else if ((paramLong2 == 1038L) && (paramArrayOfByte != null) && (paramInt == 1))
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString, paramArrayOfByte, 1);
      }
    }
    if ((1011L == paramLong2) && (1L == paramLong1) && (paramArrayOfByte != null) && (paramInt == 1)) {}
    label481:
    do
    {
      for (;;)
      {
        try
        {
          TroopTips0x857.GrayData localGrayData = new TroopTips0x857.GrayData();
          localGrayData.mergeFrom(paramArrayOfByte);
          if (!localGrayData.all_read.has()) {
            break label481;
          }
          paramLong1 = localGrayData.all_read.get();
          paramQQAppInterface = (QQAppInterface)localObject;
          if (!localGrayData.feed_id.has()) {
            break;
          }
          paramQQAppInterface = localGrayData.feed_id.get();
        }
        catch (InvalidProtocolBufferMicroException paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          QLog.d(jdField_a_of_type_JavaLangString, 1, "updatePushTroopGray", paramQQAppInterface);
        }
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("fid", paramQQAppInterface);
          ((JSONObject)localObject).put("gc", paramString);
        }
        catch (JSONException paramQQAppInterface)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "jsonObj.put", paramQQAppInterface);
        }
        try
        {
          ((IArkAPIService)QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.mannounce", "UpdateAnnounce", ((JSONObject)localObject).toString());
        }
        catch (UnsatisfiedLinkError paramQQAppInterface)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "Error: arkNotify com.tencent.mannounce error. UpdateaAllConfirm.", paramQQAppInterface);
        }
        if ((50001L == paramLong2) && (paramArrayOfByte != null)) {
          try
          {
            paramQQAppInterface = new oidb_0xe3e.ResvAttr();
            paramQQAppInterface.mergeFrom(paramArrayOfByte);
            paramInt = i;
            if (paramQQAppInterface.uint32_gray_tips_from.has()) {
              paramInt = paramQQAppInterface.uint32_gray_tips_from.get();
            }
            if (1 == paramInt)
            {
              ReportController.b(null, "dc00898", "", "", "0X800AD1F", "0X800AD1F", 1, 0, "0", "0", "", "");
              return;
            }
            if (2 == paramInt)
            {
              ReportController.b(null, "dc00898", "", "", "0X800AD1F", "0X800AD1F", 2, 0, "0", "0", "", "");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            QLog.d(jdField_a_of_type_JavaLangString, 1, "updatePushTroopGray", paramQQAppInterface);
          }
        }
        return;
        paramLong1 = 0L;
      }
    } while (0L != paramLong1);
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
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return;
    }
    catch (UnsupportedEncodingException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    a(paramQQAppInterface, paramArrayOfByte, paramMsgInfo);
    return;
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      paramMessageRecord = jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (paramMessageRecord == null) {
        paramMessageRecord = "null";
      } else {
        paramMessageRecord = Long.valueOf(paramMessageRecord.uniseq);
      }
      QLog.e(str, 2, new Object[] { "revoke msg current clicked msg uinseq =", paramMessageRecord });
    }
  }
  
  public static boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip, QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if ((paramMessageForUniteGrayTip != null) && (paramMessageForUniteGrayTip.editState == 1))
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis() - paramMessageForUniteGrayTip.editTime;
      if (((b != null) && (paramMessageForUniteGrayTip.uniseq == b.uniseq)) || (Math.abs(l1) >= 180000L))
      {
        long l2 = System.currentTimeMillis();
        if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.a() != null)) {
          paramMessageForUniteGrayTip.tipParam.a();
        }
        paramMessageForUniteGrayTip.editState = 0;
        paramMessageForUniteGrayTip.editTime = 0L;
        Object localObject2 = new StringBuilder();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(BaseApplicationImpl.getApplication().getString(2131694327));
        String str = ((StringBuilder)localObject1).toString();
        UniteGrayTipParam localUniteGrayTipParam = paramMessageForUniteGrayTip.tipParam;
        localObject1 = "";
        if ((localUniteGrayTipParam != null) && (paramMessageForUniteGrayTip.tipParam.c != null)) {
          paramMessageForUniteGrayTip.tipParam.c = paramMessageForUniteGrayTip.tipParam.c.replace(str, "");
        }
        if (paramMessageForUniteGrayTip.msg != null) {
          paramMessageForUniteGrayTip.msg = paramMessageForUniteGrayTip.msg.replace(((StringBuilder)localObject2).toString(), "");
        }
        if (paramMessageForUniteGrayTip.contentDescription != null) {
          paramMessageForUniteGrayTip.contentDescription = paramMessageForUniteGrayTip.contentDescription.replace(((StringBuilder)localObject2).toString(), "");
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
        if (!QLog.isColorLevel()) {
          break label487;
        }
        int i;
        if (paramMessageForUniteGrayTip.editMsgData != null) {
          i = paramMessageForUniteGrayTip.editMsgData.length();
        } else {
          i = 0;
        }
        int j = i;
        if (i > 2) {
          j = 2;
        }
        localObject2 = jdField_a_of_type_JavaLangString;
        long l3 = System.currentTimeMillis();
        long l4 = paramMessageForUniteGrayTip.msgUid;
        long l5 = paramMessageForUniteGrayTip.uniseq;
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (j > 0) {
          paramQQAppInterface = paramMessageForUniteGrayTip.editMsgData.substring(0, j);
        }
        QLog.e((String)localObject2, 2, new Object[] { "revoke msg handle update edit cost =", Long.valueOf(l3 - l2), ", disappear time delta =", Long.valueOf(l1), ", msguid=", Long.valueOf(l4), ",uniseq=", Long.valueOf(l5), ",msgDta[0-2]=", paramQQAppInterface });
        return true;
      }
    }
    bool = false;
    label487:
    return bool;
  }
  
  private static boolean a(UniteEntity.Note paramNote1, UniteEntity.Note paramNote2, XmlPullParser paramXmlPullParser)
  {
    paramNote1.a(paramNote2);
    int j = paramXmlPullParser.getAttributeCount();
    boolean bool = false;
    int i = 0;
    while (i < j)
    {
      paramNote2 = paramXmlPullParser.getAttributeName(i);
      String str = paramXmlPullParser.getAttributeValue(i);
      if (paramNote2.equals("txt"))
      {
        paramNote1.a(2, str);
      }
      else if (paramNote2.equals("jp"))
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
      else if (paramNote2.equals("alt"))
      {
        paramNote1.a(10, str);
      }
      else if (paramNote2.equals("status"))
      {
        paramNote1.a(11, str);
      }
      else
      {
        if (!paramNote2.equals("ex_status")) {
          break label292;
        }
        paramNote1.a(12, str);
      }
      i += 1;
      continue;
      label292:
      if (!QLog.isColorLevel()) {
        break label338;
      }
      paramNote1 = jdField_a_of_type_JavaLangString;
      paramXmlPullParser = new StringBuilder();
      paramXmlPullParser.append("parseXML, illegel field: ");
      paramXmlPullParser.append(paramNote2);
      QLog.i(paramNote1, 2, paramXmlPullParser.toString());
      return false;
    }
    bool = true;
    label338:
    return bool;
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    StringBuilder localStringBuilder;
    if (bool1)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("friendUin friendUin :");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" busiId:");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("isHideGrayfalse");
        QLog.d(paramQQAppInterface, 2, localStringBuilder.toString());
      }
      return false;
    }
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
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("friendUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" busiId:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" isHideGray");
      localStringBuilder.append(bool1);
      QLog.d(paramQQAppInterface, 2, localStringBuilder.toString());
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (paramLong2 == 1021L)
      {
        paramQQAppInterface = (TroopDragonKingAnimEntryConfig)QConfigManager.a().a(609);
        bool2 = bool1;
        if (paramQQAppInterface != null)
        {
          boolean bool3 = paramQQAppInterface.a(paramString);
          if (!bool3) {
            bool1 = true;
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("friendUin:");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" busiId:");
            localStringBuilder.append(paramLong2);
            localStringBuilder.append(" isHideGray");
            localStringBuilder.append(bool1);
            localStringBuilder.append(" bSwitchOpen:");
            localStringBuilder.append(bool3);
            QLog.d(paramQQAppInterface, 2, localStringBuilder.toString());
            bool2 = bool1;
          }
        }
      }
    }
    return bool2;
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = jdField_a_of_type_JavaLangString;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("shieldTroopInteractionIconGrayTip friendUin :");
        paramArrayOfByte.append(paramString);
        paramArrayOfByte.append(" busiId:");
        paramArrayOfByte.append(paramLong2);
        paramArrayOfByte.append("isHideGrayfalse");
        QLog.d(paramQQAppInterface, 2, paramArrayOfByte.toString());
      }
      return false;
    }
    boolean bool2 = true;
    boolean bool1;
    if (paramLong2 == 1038L)
    {
      if (!((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(paramString))
      {
        bool1 = bool2;
      }
      else
      {
        paramArrayOfByte = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        paramQQAppInterface = null;
        if (paramArrayOfByte != null) {
          paramQQAppInterface = paramArrayOfByte.c(paramString);
        }
        if (paramQQAppInterface != null)
        {
          bool1 = bool2;
          if (paramQQAppInterface.isHomeworkTroop()) {
            break label207;
          }
          if (paramQQAppInterface.isQidianPrivateTroop())
          {
            bool1 = bool2;
            break label207;
          }
        }
        bool1 = false;
      }
    }
    else
    {
      bool2 = a(paramString, paramQQAppInterface, paramLong1, paramLong2);
      bool1 = bool2;
      if (!bool2) {
        bool1 = b(paramString, paramQQAppInterface, paramLong1, paramLong2);
      }
    }
    label207:
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = jdField_a_of_type_JavaLangString;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("shieldTroopInteractionIconGrayTip friendUin :");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(" busiId:");
      paramArrayOfByte.append(paramLong2);
      paramArrayOfByte.append(",isHideGray:");
      paramArrayOfByte.append(bool1);
      QLog.d(paramQQAppInterface, 2, paramArrayOfByte.toString());
    }
    return bool1;
  }
  
  private static int b(int paramInt)
  {
    int i;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 160)
        {
          if (paramInt != 161) {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  i = -1;
                  break;
                case 168: 
                  i = 10009;
                  break;
                case 167: 
                  i = 10010;
                  break;
                case 166: 
                  i = 1045;
                  break;
                case 165: 
                  i = 10008;
                }
                break;
              case 134: 
                i = 1022;
                break;
              case 133: 
                i = 1023;
                break;
              case 132: 
                i = 1020;
                break;
              case 131: 
                i = 1009;
                break;
              case 130: 
                i = 1006;
              }
              break;
            case 201: 
              i = 1005;
              break;
            case 163: 
              i = 1044;
              break;
            case 156: 
              i = 1032;
              break;
            case 153: 
              i = 10004;
              break;
            case 149: 
              i = 10002;
              break;
            case 144: 
              i = 7400;
              break;
            case 140: 
            case 142: 
              i = 1008;
              break;
            case 137: 
              i = 1010;
              break;
            case 124: 
              i = 1001;
              break;
            case 121: 
              i = 1021;
              break;
            case 58: 
              i = 1024;
              break;
            }
          } else {
            i = 1038;
          }
        }
        else {
          i = 1036;
        }
      }
      else {
        i = 1004;
      }
    }
    else {
      i = 1000;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("<---getTempUinType: dump info:");
      localStringBuilder.append(" serviceType:");
      localStringBuilder.append(paramInt);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static void b()
  {
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    b = null;
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      Object localObject = b;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Long.valueOf(((MessageRecord)localObject).uniseq);
      }
      QLog.e(str, 2, new Object[] { "revoke msg cleanCurrentRevokeMsg ,uinseq =", localObject });
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    Object localObject2 = new submsgtype0x122.MsgBody();
    ((submsgtype0x122.MsgBody)localObject2).mergeFrom(paramArrayOfByte);
    boolean bool = ((submsgtype0x122.MsgBody)localObject2).uint64_busi_type.has();
    long l4 = 0L;
    long l1;
    if (bool) {
      l1 = ((submsgtype0x122.MsgBody)localObject2).uint64_busi_type.get();
    } else {
      l1 = 0L;
    }
    long l2;
    if (((submsgtype0x122.MsgBody)localObject2).uint64_busi_id.has()) {
      l2 = ((submsgtype0x122.MsgBody)localObject2).uint64_busi_id.get();
    } else {
      l2 = 0L;
    }
    bool = ((submsgtype0x122.MsgBody)localObject2).uint32_ctrl_flag.has();
    int m = 0;
    int i;
    if (bool) {
      i = ((submsgtype0x122.MsgBody)localObject2).uint32_ctrl_flag.get();
    } else {
      i = 0;
    }
    long l3;
    if (((submsgtype0x122.MsgBody)localObject2).uint64_templ_id.has()) {
      l3 = ((submsgtype0x122.MsgBody)localObject2).uint64_templ_id.get();
    } else {
      l3 = 0L;
    }
    int j;
    if (((submsgtype0x122.MsgBody)localObject2).uint32_c2c_type.has()) {
      j = ((submsgtype0x122.MsgBody)localObject2).uint32_c2c_type.get();
    } else {
      j = 0;
    }
    int k;
    if (((submsgtype0x122.MsgBody)localObject2).uint32_service_type.has()) {
      k = ((submsgtype0x122.MsgBody)localObject2).uint32_service_type.get();
    } else {
      k = 0;
    }
    bool = ((submsgtype0x122.MsgBody)localObject2).bytes_content.has();
    paramArrayOfByte = null;
    if (bool) {
      localObject1 = ((submsgtype0x122.MsgBody)localObject2).bytes_content.get().toByteArray();
    } else {
      localObject1 = null;
    }
    if (((submsgtype0x122.MsgBody)localObject2).bytes_pb_reserv.has()) {
      paramArrayOfByte = ((submsgtype0x122.MsgBody)localObject2).bytes_pb_reserv.get().toByteArray();
    }
    if (((submsgtype0x122.MsgBody)localObject2).uint64_tips_seq_id.has()) {
      l4 = ((submsgtype0x122.MsgBody)localObject2).uint64_tips_seq_id.get();
    }
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = new String((byte[])localObject1, "utf-8");
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
      }
      localObject1 = "";
    }
    int n = a(i);
    if (j == 1)
    {
      i = b(k);
      if (i == -1) {
        i = m;
      }
    }
    else
    {
      i = 0;
    }
    paramArrayOfByte = a(paramQQAppInterface, String.valueOf(paramMsgInfo.lFromUin), i, n, paramMsgInfo.uMsgTime, (String)localObject1, l1, l2, paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return;
    }
    paramArrayOfByte.tipParam.d = String.valueOf(l4);
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleC2COnlinePushMsgGrayTipResp uint64_tips_seq_id");
      localStringBuilder.append(l4);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    paramArrayOfByte.saveExtInfoToExtStr("uint64_busi_type", String.valueOf(l1));
    paramArrayOfByte.saveExtInfoToExtStr("uint64_busi_id", String.valueOf(l2));
    paramArrayOfByte.saveExtInfoToExtStr("uint64_templ_id", String.valueOf(l3));
    paramArrayOfByte.saveExtInfoToExtStr("bytes_content", (String)localObject1);
    paramArrayOfByte.saveExtInfoToExtStr("uint64_tips_seq_id", String.valueOf(l4));
    paramArrayOfByte.saveExtInfoToExtStr("pai_yi_pai_uint64_msg_type", String.valueOf(paramMsgInfo.shMsgType));
    paramArrayOfByte.msgUid = paramMsgInfo.lMsgUid;
    paramArrayOfByte.shmsgseq = paramMsgInfo.shMsgSeq;
    if (i == 0) {
      i = 1;
    } else {
      i = 2;
    }
    paramMsgInfo = new StringBuilder();
    paramMsgInfo.append("");
    paramMsgInfo.append(l2);
    paramMsgInfo = paramMsgInfo.toString();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(l1);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800A560", "0X800A560", i, 0, paramMsgInfo, ((StringBuilder)localObject1).toString(), "", "");
    paramArrayOfByte.prewrite();
    UniteGrayTipMsgUtil.a(paramQQAppInterface, paramArrayOfByte);
  }
  
  public static boolean b(String paramString, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!TroopLuckyCharacterConstant.a.contains(Long.valueOf(paramLong2))) {
      return false;
    }
    paramString = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    return !((ITroopLuckyCharacterService)paramQQAppInterface.getRuntimeService(ITroopLuckyCharacterService.class, "")).isSupportLuckyCharacter(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipUtil
 * JD-Core Version:    0.7.0.1
 */