package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.MutualMarkPushInfo;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LoveZoneInfoHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipFriendTag2Config;
import com.tencent.mobileqq.config.business.qvip.QVipFriendTag2Processor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.friends.intimate.IntimateInfoManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkGrayTipsHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.intimate_relation.intimate_relation.IntimateBestFriend;
import tencent.intimate_relation.intimate_relation.IntimateBuddy;
import tencent.intimate_relation.intimate_relation.IntimateInfo;
import tencent.intimate_relation.intimate_relation.IntimateLadybro;
import tencent.intimate_relation.intimate_relation.IntimateLover;
import tencent.intimate_relation_ext.intimate_relation_ext.IntimateRelationExtMsg;

public class FriendIntimateRelationshipHelper
{
  static long jdField_a_of_type_Long = 0L;
  private static String jdField_a_of_type_JavaLangString;
  static boolean jdField_a_of_type_Boolean = false;
  static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    b = false;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramQQAppInterface != null)
    {
      long l = System.currentTimeMillis();
      try
      {
        i = paramQQAppInterface.d();
        if (QLog.isColorLevel()) {
          QLog.i("FriendIntimateRelationshipHelper", 2, "getBindIntimateRelationshipFriendCount cost:" + (System.currentTimeMillis() - l) + "  count:" + i);
        }
        return i;
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          QLog.i("FriendIntimateRelationshipHelper", 2, "getBindIntimateRelationshipFriendCount e:" + paramQQAppInterface.getMessage());
          int i = 0;
        }
      }
    }
    return 0;
  }
  
  public static String a()
  {
    return FriendIntimateRelationshipConfProcessor.a().jdField_a_of_type_JavaLangString;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str = "";
    FriendIntimateRelationshipBean localFriendIntimateRelationshipBean = FriendIntimateRelationshipConfProcessor.a();
    switch (paramInt1)
    {
    default: 
      str = localFriendIntimateRelationshipBean.c;
    }
    for (;;)
    {
      QLog.i("FriendIntimateRelationshipHelper", 1, "getAIOIntimateBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      return str;
      if (paramInt2 == 0)
      {
        str = localFriendIntimateRelationshipBean.d;
      }
      else if (paramInt2 == 1)
      {
        str = localFriendIntimateRelationshipBean.e;
      }
      else if (paramInt2 == 2)
      {
        str = localFriendIntimateRelationshipBean.f;
        continue;
        if (paramInt2 == 0)
        {
          str = localFriendIntimateRelationshipBean.g;
        }
        else if (paramInt2 == 1)
        {
          str = localFriendIntimateRelationshipBean.h;
        }
        else if (paramInt2 == 2)
        {
          str = localFriendIntimateRelationshipBean.i;
          continue;
          if (paramInt2 == 0)
          {
            str = localFriendIntimateRelationshipBean.j;
          }
          else if (paramInt2 == 1)
          {
            str = localFriendIntimateRelationshipBean.k;
          }
          else if (paramInt2 == 2)
          {
            str = localFriendIntimateRelationshipBean.l;
            continue;
            if (paramInt2 == 0) {
              str = localFriendIntimateRelationshipBean.m;
            } else if (paramInt2 == 1) {
              str = localFriendIntimateRelationshipBean.n;
            } else if (paramInt2 == 2) {
              str = localFriendIntimateRelationshipBean.o;
            }
          }
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse(FriendIntimateRelationshipConfProcessor.a().jdField_b_of_type_JavaLangString).buildUpon();
    localBuilder.appendQueryParameter("uin", paramString);
    paramString = localBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 2, "bindPageURL url:" + paramString);
    }
    return paramString;
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    String str3 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString1, paramInt, 0L);
    String str1 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString1, paramInt, 1L);
    String str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramString1, paramInt, 2L);
    paramQQAppInterface = paramString2;
    if (paramString2.contains("#intimateshipicon1"))
    {
      paramQQAppInterface = paramString2.replace("#intimateshipicon1", str3);
      localArrayList.add(str3);
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface.contains("#intimateshipicon2"))
    {
      paramString1 = paramQQAppInterface.replace("#intimateshipicon2", str1);
      localArrayList.add(str1);
    }
    paramQQAppInterface = paramString1;
    if (paramString1.contains("#intimateshipicon3"))
    {
      paramQQAppInterface = paramString1.replace("#intimateshipicon3", str2);
      localArrayList.add(str2);
    }
    localArrayList.add(0, paramQQAppInterface);
    return localArrayList;
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FriendsManager paramFriendsManager, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    String str3 = MutualMarkConfigHelper.a(paramQQAppInterface, paramInt, 0L);
    String str2 = MutualMarkConfigHelper.a(paramQQAppInterface, paramInt, 1L);
    String str1 = MutualMarkConfigHelper.a(paramQQAppInterface, paramInt, 2L);
    paramInt = paramFriendsManager.n;
    int i = paramFriendsManager.o;
    int j = paramFriendsManager.p;
    paramQQAppInterface = paramString1;
    if (paramString1.contains("#intimateshipday1")) {
      paramQQAppInterface = paramString1.replace("#intimateshipday1", String.valueOf(paramInt));
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface.contains("#intimateshipday2")) {
      paramString1 = paramQQAppInterface.replace("#intimateshipday2", String.valueOf(i));
    }
    paramQQAppInterface = paramString1;
    if (paramString1.contains("#intimateshipmsgcount")) {
      paramQQAppInterface = paramString1.replace("#intimateshipmsgcount", String.valueOf(j));
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface.contains("#intimateshipname1"))
    {
      paramString1 = paramQQAppInterface.replace("#intimateshipname1", str3);
      localArrayList.add(str3);
    }
    paramQQAppInterface = paramString1;
    if (paramString1.contains("#intimateshipname2"))
    {
      paramQQAppInterface = paramString1.replace("#intimateshipname2", str2);
      localArrayList.add(str2);
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface.contains("#intimateshipname3"))
    {
      paramString1 = paramQQAppInterface.replace("#intimateshipname3", str1);
      localArrayList.add(str1);
    }
    localArrayList.add(0, paramString1.replace(HardCodeUtil.a(2131704896), paramString2));
    return localArrayList;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, String paramString1, String paramString2, int paramInt1, int paramInt2, PushMsg0x210C7Info paramPushMsg0x210C7Info, int paramInt3, int paramInt4)
  {
    QLog.i("FriendIntimateRelationshipHelper", 1, "insertGrayTips uin:" + paramString1 + " grayTips:" + paramString2 + " intimateType:" + paramInt1);
    if ((TextUtils.isEmpty(paramString2)) || (MutualMarkUtils.a(paramQQAppInterface))) {
      return;
    }
    Object localObject2 = ContactUtils.m(paramQQAppInterface, paramString1);
    Object localObject1 = paramString2;
    if (paramInt3 == 2097154)
    {
      localObject1 = paramString2;
      if (paramInt4 == 0)
      {
        localObject3 = QVipFriendTag2Processor.c();
        localObject1 = paramString2;
        if (((QVipFriendTag2Config)localObject3).jdField_a_of_type_Boolean) {
          localObject1 = paramString2 + ((QVipFriendTag2Config)localObject3).jdField_a_of_type_JavaLangString;
        }
      }
    }
    localObject2 = a(paramQQAppInterface, (String)localObject1, (String)localObject2, paramFriendsManager, paramInt1);
    Object localObject3 = a(paramQQAppInterface, paramString1, (String)((List)localObject2).get(0), paramInt1);
    paramFriendsManager = (String)((List)localObject3).get(0);
    ((List)localObject3).remove(0);
    ((List)localObject2).remove(0);
    paramString2 = new UniteGrayTipParam(paramString1, paramString1, paramFriendsManager, 0, -5040, paramInt3, MessageCache.a());
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).hasRead = 0;
    ((MessageForUniteGrayTip)localObject1).subType = paramInt4;
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, paramString2);
    ((MessageForUniteGrayTip)localObject1).tipParam.d = (paramString1 + "_intimate_" + String.valueOf(paramPushMsg0x210C7Info.jdField_b_of_type_Long) + "_" + String.valueOf(paramPushMsg0x210C7Info.jdField_b_of_type_Int));
    int i;
    Object localObject4;
    int j;
    if (((List)localObject3).size() > 0)
    {
      i = 0;
      while (i < ((List)localObject3).size())
      {
        paramPushMsg0x210C7Info = new Bundle();
        localObject4 = (String)((List)localObject3).get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramPushMsg0x210C7Info.putString("image_resource", (String)localObject4);
          j = 0;
          do
          {
            k = paramFriendsManager.indexOf((String)localObject4, j);
            j = ((String)localObject4).length() + k;
            if (k >= 0)
            {
              paramString2.a(k, j, paramPushMsg0x210C7Info);
              if (QLog.isColorLevel()) {
                QLog.d("FriendIntimateRelationshipHelper", 2, "iconPos=" + k + " fromIndex=" + j);
              }
            }
          } while (k >= 0);
        }
        i += 1;
      }
    }
    int m;
    String str1;
    label562:
    int i2;
    int i3;
    int i1;
    Object localObject5;
    Object localObject6;
    if (((List)localObject2).size() > 0)
    {
      Collections.sort((List)localObject2, new FriendIntimateRelationshipHelper.2());
      paramPushMsg0x210C7Info = new ArrayList();
      i = 0;
      m = 0;
      if (m < ((List)localObject2).size())
      {
        localObject4 = new Bundle();
        str1 = (String)((List)localObject2).get(m);
        j = i;
        if (!TextUtils.isEmpty(str1))
        {
          ((Bundle)localObject4).putInt("key_action", 11);
          ((Bundle)localObject4).putString("key_action_DATA", str1);
          j = 0;
          i2 = paramFriendsManager.indexOf(str1, j);
          i3 = str1.length();
          i1 = i2 + i3;
          localObject5 = paramPushMsg0x210C7Info.iterator();
          do
          {
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            localObject6 = (Pair)((Iterator)localObject5).next();
          } while ((i2 < ((Integer)((Pair)localObject6).first).intValue()) || (i2 >= ((Integer)((Pair)localObject6).second).intValue()));
        }
      }
    }
    for (int k = 1;; k = 0)
    {
      j = paramFriendsManager.length();
      int n = k;
      label733:
      String str2;
      if (k == 0)
      {
        n = k;
        if (((List)localObject3).size() > 0)
        {
          n = k;
          if (i2 >= 0)
          {
            n = k;
            if (i2 < j)
            {
              n = k;
              if (i1 >= 0)
              {
                n = k;
                if (i1 < j) {
                  if (paramFriendsManager.indexOf(str1, i1) >= 0)
                  {
                    j = 1;
                    if ((((List)localObject2).size() <= 1) && (j == 0))
                    {
                      n = k;
                      if (i <= 0) {
                        break label859;
                      }
                    }
                    localObject5 = paramFriendsManager.substring(0, i2);
                    localObject6 = paramFriendsManager.substring(i1);
                    Iterator localIterator = ((List)localObject3).iterator();
                    j = 0;
                    label787:
                    if (!localIterator.hasNext()) {
                      break label847;
                    }
                    str2 = (String)localIterator.next();
                    if (!((String)localObject6).startsWith(str2)) {
                      break label831;
                    }
                    j = 1;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break label787;
        j = 0;
        break label733;
        label831:
        if (((String)localObject5).endsWith(str2))
        {
          j = 1;
          continue;
          label847:
          n = k;
          if (j == 0) {
            n = 1;
          }
          label859:
          if (n != 0) {}
          for (;;)
          {
            if (i2 < 0)
            {
              j = i;
              m += 1;
              i = j;
              break;
              paramPushMsg0x210C7Info.add(new Pair(Integer.valueOf(i2), Integer.valueOf(i2 + i3)));
              j = i;
              if (i2 >= 0)
              {
                i += 1;
                paramString2.a(i2, i1, (Bundle)localObject4);
                j = i;
                if (QLog.isColorLevel())
                {
                  QLog.d("FriendIntimateRelationshipHelper", 2, "spanPos=" + i2 + " fromIndex=" + i1);
                  j = i;
                }
              }
              i = j;
              continue;
              if ((paramInt3 == 2097154) && (paramInt4 == 0))
              {
                paramPushMsg0x210C7Info = QVipFriendTag2Processor.c();
                if (paramPushMsg0x210C7Info.jdField_a_of_type_Boolean)
                {
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putInt("key_action", 1);
                  paramInt3 = 10;
                  switch (paramInt1)
                  {
                  default: 
                    paramInt1 = paramInt3;
                  }
                }
              }
              for (;;)
              {
                ((Bundle)localObject2).putString("key_action_DATA", String.format(paramPushMsg0x210C7Info.jdField_b_of_type_JavaLangString, new Object[] { paramString1, Integer.valueOf(paramInt1) }));
                paramInt2 = paramFriendsManager.length() - paramPushMsg0x210C7Info.jdField_a_of_type_JavaLangString.length();
                if (paramInt2 >= 0)
                {
                  paramString2.a(paramInt2, paramFriendsManager.length(), (Bundle)localObject2);
                  ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009CA5", paramInt1, 0, "", "", "", "");
                }
                UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject1);
                return;
                if (paramInt2 == 0)
                {
                  paramInt1 = 25;
                }
                else
                {
                  paramInt1 = 26;
                  continue;
                  if (paramInt2 == 0)
                  {
                    paramInt1 = 23;
                  }
                  else
                  {
                    paramInt1 = 24;
                    continue;
                    if (paramInt2 == 0)
                    {
                      paramInt1 = 27;
                    }
                    else
                    {
                      paramInt1 = 28;
                      continue;
                      if (paramInt2 == 0) {
                        paramInt1 = 21;
                      } else {
                        paramInt1 = 22;
                      }
                    }
                  }
                }
              }
            }
          }
          j = i1;
          break label562;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    paramQQAppInterface = new intimate_relation_ext.IntimateRelationExtMsg();
    try
    {
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
      if (paramQQAppInterface != null)
      {
        boolean bool1 = bool2;
        if (paramQQAppInterface.uint64_icon_status.has())
        {
          bool1 = bool2;
          if (paramQQAppInterface.uint64_icon_status.get() == 1L) {
            bool1 = true;
          }
        }
        if (paramExtensionInfo.isExtinguish != bool1) {
          paramExtensionInfo.isExtinguish = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("FriendIntimateRelationshipHelper", 1, "handleGetIntimateRelationExtMsgInfo ext_info.uint64_icon_status.has():" + paramQQAppInterface.uint64_icon_status.has() + " newIsExtinguish:" + bool1);
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramQQAppInterface = null;
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 app:" + paramQQAppInterface + "  changeInfo:" + paramRelationalChainChange + "  msginfo:" + paramPushMsg0x210C7Info);
    }
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramPushMsg0x210C7Info == null)) {}
    long l1;
    long l2;
    ExtSnsRelationChainChangePushInfo localExtSnsRelationChainChangePushInfo;
    FriendsManager localFriendsManager;
    do
    {
      do
      {
        return;
        l1 = paramPushMsg0x210C7Info.jdField_b_of_type_Long;
        l2 = paramPushMsg0x210C7Info.c;
        localExtSnsRelationChainChangePushInfo = ExtSnsRelationChainChangePushInfo.a(paramRelationalChainChange, paramPushMsg0x210C7Info.jdField_a_of_type_Boolean);
      } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString)));
      localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramRelationalChainChange = localFriendsManager.e(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
      QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramPushMsg0x210C7Info + "changePushInfo:" + localExtSnsRelationChainChangePushInfo);
    } while ((paramRelationalChainChange != null) && (!paramRelationalChainChange.isFriend()));
    ExtensionInfo localExtensionInfo = localFriendsManager.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
    if (localExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject3 = (IntimateInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
      Object localObject1 = null;
      Object localObject2 = null;
      String str1 = null;
      label315:
      int i;
      switch (localExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int)
      {
      default: 
        paramRelationalChainChange = str1;
      case 1: 
        do
        {
          QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 changeType:" + localExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int + " grayTips:" + paramRelationalChainChange + " uin:" + localExtensionInfo.uin + " isOpen:" + a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString) + " intimate_type:" + localExtensionInfo.intimate_type + " intimate_level:" + localExtensionInfo.intimate_level + " intimate_chatDays:" + localExtensionInfo.intimate_chatDays + " isExtinguish:" + localExtensionInfo.isExtinguish + " last_intimate_chatTime:" + localExtensionInfo.last_intimate_chatTime);
          return;
          paramRelationalChainChange = str1;
        } while (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null);
        if (IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int))
        {
          localExtensionInfo.intimate_type = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
          localExtensionInfo.intimate_chatDays = 0;
          localExtensionInfo.intimate_level = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
          localExtensionInfo.isExtinguish = false;
          if ((localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null) && (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c > 0L)) {
            localExtensionInfo.last_intimate_chatTime = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c;
          }
          str1 = HotReactiveHelper.a(paramQQAppInterface.getApp(), 162);
          localFriendsManager.a(localExtensionInfo);
          if (a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString))
          {
            i = MutualMarkGrayTipsHelper.a(localExtSnsRelationChainChangePushInfo);
            a(paramQQAppInterface, localFriendsManager, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, str1, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a(), paramPushMsg0x210C7Info, 2097153, i);
            ((IntimateInfoHandler)localObject3).notifyUI(2, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString });
          }
          paramRelationalChainChange = str1;
          if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface = (LoveZoneInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER);
            paramRelationalChainChange = str1;
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(1);
            }
          }
        }
        break;
      }
      for (paramRelationalChainChange = str1;; paramRelationalChainChange = null)
      {
        QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Add friendUin:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString + " changePushInfo.now:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo);
        break label315;
        int k = 0;
        int j = 0;
        if (localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
        {
          k = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
          j = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
        }
        int m = j;
        i = k;
        if (k == 0)
        {
          m = j;
          i = k;
          if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
          {
            i = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
            m = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
          }
        }
        if (i == 0)
        {
          j = localExtensionInfo.intimate_type;
          k = localExtensionInfo.intimate_level;
        }
        for (;;)
        {
          if (IntimateUtil.a(j))
          {
            localExtensionInfo.intimate_type = 0;
            localExtensionInfo.intimate_level = 0;
            localExtensionInfo.intimate_chatDays = 0;
            localExtensionInfo.isExtinguish = false;
            i = 163;
            if (k == 1)
            {
              i = 164;
              label885:
              str1 = HotReactiveHelper.a(paramQQAppInterface.getApp(), i);
              localFriendsManager.a(localExtensionInfo);
              if (a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString))
              {
                a(paramQQAppInterface, localFriendsManager, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, str1, j, 0, paramPushMsg0x210C7Info, 2097154, 1);
                ((IntimateInfoHandler)localObject3).notifyUI(1, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Boolean.valueOf(true) });
                ((IntimateInfoManager)paramQQAppInterface.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
              }
              paramRelationalChainChange = str1;
              if (j == 1)
              {
                paramQQAppInterface = (LoveZoneInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER);
                paramRelationalChainChange = str1;
                if (paramQQAppInterface != null) {
                  paramQQAppInterface.a(0);
                }
              }
            }
          }
          for (paramRelationalChainChange = str1;; paramRelationalChainChange = null)
          {
            QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Del intimate_type:" + j + " intimate_level:" + k + " friendUin:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
            break label315;
            if (k != 2) {
              break label885;
            }
            i = 165;
            break label885;
            paramRelationalChainChange = str1;
            if (!a()) {
              break label315;
            }
            paramRelationalChainChange = str1;
            if (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) {
              break label315;
            }
            paramRelationalChainChange = str1;
            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
              break label315;
            }
            paramRelationalChainChange = str1;
            if (localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
              break label315;
            }
            if ((localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null) && (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c > 0L)) {
              localExtensionInfo.last_intimate_chatTime = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c;
            }
            k = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
            m = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
            paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
            if (IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int))
            {
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (k > m)
              {
                j = -1;
                if (k != 1) {
                  break label1479;
                }
                if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int != 1) {
                  break label1418;
                }
                i = 150;
              }
            }
            for (;;)
            {
              paramRelationalChainChange = HotReactiveHelper.a(paramQQAppInterface.getApp(), i);
              localExtensionInfo.intimate_type = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
              localExtensionInfo.intimate_level = k;
              localFriendsManager.a(localExtensionInfo);
              i = MutualMarkGrayTipsHelper.a(localExtSnsRelationChainChangePushInfo);
              a(paramQQAppInterface, localFriendsManager, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, k, paramPushMsg0x210C7Info, 2097153, i);
              ((IntimateInfoHandler)localObject3).notifyUI(3, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int), Integer.valueOf(m), Integer.valueOf(k) });
              QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Upgrade intimate_type:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int + " intimate_level:" + k + " old_intimate_level:" + m);
              break;
              label1418:
              if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 2)
              {
                i = 158;
              }
              else if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 26)
              {
                i = 168;
              }
              else
              {
                i = j;
                if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 3)
                {
                  i = 154;
                  continue;
                  label1479:
                  i = j;
                  if (k == 2) {
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 1)
                    {
                      i = 151;
                    }
                    else if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 2)
                    {
                      i = 159;
                    }
                    else if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 26)
                    {
                      i = 169;
                    }
                    else
                    {
                      i = j;
                      if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 3) {
                        i = 155;
                      }
                    }
                  }
                }
              }
            }
            paramRelationalChainChange = str1;
            if (!a()) {
              break label315;
            }
            paramRelationalChainChange = str1;
            if (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) {
              break label315;
            }
            paramRelationalChainChange = str1;
            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
              break label315;
            }
            paramRelationalChainChange = str1;
            if (localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
              break label315;
            }
            if ((localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null) && (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c > 0L)) {
              localExtensionInfo.last_intimate_chatTime = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c;
            }
            k = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
            m = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
            paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject2;
            if (IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int))
            {
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject2;
              if (k < m)
              {
                j = -1;
                if (m != 1) {
                  break label1960;
                }
                if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int != 1) {
                  break label1899;
                }
                i = 152;
              }
            }
            label1960:
            for (;;)
            {
              paramRelationalChainChange = HotReactiveHelper.a(paramQQAppInterface.getApp(), i);
              localExtensionInfo.intimate_type = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
              localExtensionInfo.intimate_level = k;
              localFriendsManager.a(localExtensionInfo);
              a(paramQQAppInterface, localFriendsManager, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, k, paramPushMsg0x210C7Info, 2097154, 0);
              ((IntimateInfoHandler)localObject3).notifyUI(3, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int), Integer.valueOf(m), Integer.valueOf(k) });
              QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Downgrade intimate_type:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int + " intimate_level:" + k + " old_intimate_level:" + m);
              break;
              label1899:
              if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 2)
              {
                i = 160;
              }
              else if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 26)
              {
                i = 170;
              }
              else
              {
                i = j;
                if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 3)
                {
                  i = 156;
                  continue;
                  i = j;
                  if (m == 2) {
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 1)
                    {
                      i = 153;
                    }
                    else if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 2)
                    {
                      i = 161;
                    }
                    else if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 26)
                    {
                      i = 171;
                    }
                    else
                    {
                      i = j;
                      if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 3) {
                        i = 157;
                      }
                    }
                  }
                }
              }
            }
            paramRelationalChainChange = str1;
            if (!a()) {
              break label315;
            }
            paramRelationalChainChange = str1;
            if (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) {
              break label315;
            }
            paramRelationalChainChange = str1;
            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
              break label315;
            }
            String str2;
            if ((localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int != 0) && (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null)) {
              if ((!TextUtils.isEmpty(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_a_of_type_JavaLangString)) && (!MutualMarkUtils.a(paramQQAppInterface)))
              {
                localObject1 = HotReactiveHelper.a(paramQQAppInterface, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_a_of_type_JavaLangString, ContactUtils.m(paramQQAppInterface, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString), localFriendsManager);
                localObject2 = HotReactiveHelper.a(paramQQAppInterface, (String)((List)localObject1).get(0), localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
                paramRelationalChainChange = (String)((List)localObject2).get(0);
                ((List)localObject1).remove(0);
                ((List)localObject2).remove(0);
                paramPushMsg0x210C7Info = new UniteGrayTipParam(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramRelationalChainChange, 0, -5020, 2097153, MessageCache.a());
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  i = 0;
                  while (i < ((List)localObject2).size())
                  {
                    localObject3 = new Bundle();
                    str2 = (String)((List)localObject2).get(i);
                    if (!TextUtils.isEmpty(str2))
                    {
                      ((Bundle)localObject3).putString("image_resource", str2);
                      j = paramRelationalChainChange.lastIndexOf(str2);
                      if (j >= 0) {
                        paramPushMsg0x210C7Info.a(j, str2.length() + j, (Bundle)localObject3);
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + paramRelationalChainChange + "iconPos=" + j + "icon=" + str2 + "grayStr=" + paramRelationalChainChange);
                      }
                    }
                    i += 1;
                  }
                }
                if ((localObject1 != null) && (((List)localObject1).size() > 0))
                {
                  Collections.sort((List)localObject1, new FriendIntimateRelationshipHelper.1());
                  localObject2 = new ArrayList();
                  j = 0;
                  label2446:
                  if (j < ((List)localObject1).size())
                  {
                    localObject3 = new Bundle();
                    str2 = (String)((List)localObject1).get(j);
                    if (!TextUtils.isEmpty(str2))
                    {
                      ((Bundle)localObject3).putInt("key_action", 11);
                      ((Bundle)localObject3).putString("key_action_DATA", str2);
                      i = 0;
                      label2511:
                      m = paramRelationalChainChange.indexOf(str2, i);
                      if (m >= 0) {
                        break label2539;
                      }
                    }
                  }
                }
              }
            }
            label2525:
            label2539:
            label3570:
            for (;;)
            {
              int n;
              if (m < 0)
              {
                j += 1;
                break label2446;
                n = str2.length();
                i = m + n;
                Iterator localIterator = ((ArrayList)localObject2).iterator();
                Pair localPair;
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  localPair = (Pair)localIterator.next();
                } while ((m < ((Integer)localPair.first).intValue()) || (m >= ((Integer)localPair.second).intValue()));
              }
              for (k = 1;; k = 0)
              {
                if (k != 0) {
                  break label3570;
                }
                ((ArrayList)localObject2).add(new Pair(Integer.valueOf(m), Integer.valueOf(m + n)));
                if (m >= 0)
                {
                  paramPushMsg0x210C7Info.a(m, i, (Bundle)localObject3);
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendIntimateRelationshipHelper", 2, "spanPos=" + m + " fromIndex=" + i);
                  }
                }
                break label2525;
                break label2511;
                localObject1 = new MessageForUniteGrayTip();
                ((MessageForUniteGrayTip)localObject1).hasRead = 0;
                ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, paramPushMsg0x210C7Info);
                paramPushMsg0x210C7Info = new StringBuilder(21);
                paramPushMsg0x210C7Info.append(l1).append("_").append(l2);
                ((MessageForUniteGrayTip)localObject1).tipParam.d = paramPushMsg0x210C7Info.toString();
                paramPushMsg0x210C7Info = paramQQAppInterface.getMessageFacade().b(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, 0);
                if ((paramPushMsg0x210C7Info != null) && (!paramPushMsg0x210C7Info.isEmpty()))
                {
                  paramPushMsg0x210C7Info = (MessageRecord)paramPushMsg0x210C7Info.get(paramPushMsg0x210C7Info.size() - 1);
                  if (((paramPushMsg0x210C7Info instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramPushMsg0x210C7Info).tipParam != null) && (((MessageForUniteGrayTip)paramPushMsg0x210C7Info).subType == ((MessageForUniteGrayTip)localObject1).subType) && (((MessageForUniteGrayTip)paramPushMsg0x210C7Info).tipParam.c.equals(((MessageForUniteGrayTip)localObject1).tipParam.c)) && (((MessageForUniteGrayTip)localObject1).tipParam.jdField_a_of_type_Long - ((MessageForUniteGrayTip)paramPushMsg0x210C7Info).tipParam.jdField_a_of_type_Long <= 1L))
                  {
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
                    return;
                  }
                }
                if (!TextUtils.isEmpty(paramRelationalChainChange)) {
                  UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject1);
                }
                localExtensionInfo.intimate_level = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
                if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c > 0L) {
                  localExtensionInfo.last_intimate_chatTime = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c;
                }
                localFriendsManager.a(localExtensionInfo);
                paramRelationalChainChange = new ArrayList();
                paramRelationalChainChange.add(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
                paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(106, true, paramRelationalChainChange);
                QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Egalitarian_Soon intimate_type:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int + " intimate_level:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a());
                paramRelationalChainChange = str1;
                break label315;
                paramRelationalChainChange = str1;
                if (!a()) {
                  break label315;
                }
                paramRelationalChainChange = str1;
                if (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) {
                  break label315;
                }
                paramRelationalChainChange = str1;
                if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
                  break label315;
                }
                if (IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int))
                {
                  localExtensionInfo.isExtinguish = false;
                  localFriendsManager.a(localExtensionInfo);
                  paramRelationalChainChange = HotReactiveHelper.a(paramQQAppInterface.getApp(), 167);
                  a(paramQQAppInterface, localFriendsManager, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a(), paramPushMsg0x210C7Info, 2097153, 0);
                  ((IntimateInfoHandler)localObject3).notifyUI(3, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int), Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a()), Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a()) });
                  ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
                }
                for (paramQQAppInterface = paramRelationalChainChange;; paramQQAppInterface = null)
                {
                  QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Light intimate_type:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int + " intimate_level:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a());
                  paramRelationalChainChange = paramQQAppInterface;
                  break;
                  paramRelationalChainChange = str1;
                  if (!a()) {
                    break;
                  }
                  paramRelationalChainChange = str1;
                  if (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) {
                    break;
                  }
                  paramRelationalChainChange = str1;
                  if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
                    break;
                  }
                  if (IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int))
                  {
                    localExtensionInfo.isExtinguish = true;
                    localFriendsManager.a(localExtensionInfo);
                    paramRelationalChainChange = HotReactiveHelper.a(paramQQAppInterface.getApp(), 166);
                    a(paramQQAppInterface, localFriendsManager, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a(), paramPushMsg0x210C7Info, 2097154, 0);
                    ((IntimateInfoHandler)localObject3).notifyUI(3, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int), Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a()), Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a()) });
                    ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
                  }
                  for (paramQQAppInterface = paramRelationalChainChange;; paramQQAppInterface = null)
                  {
                    QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Extinguish intimate_type:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int + " intimate_level:" + localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a());
                    paramRelationalChainChange = paramQQAppInterface;
                    break;
                  }
                }
              }
            }
          }
          k = m;
          j = i;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, intimate_relation.IntimateInfo paramIntimateInfo)
  {
    boolean bool = false;
    if (paramIntimateInfo == null) {}
    long l;
    do
    {
      return;
      l = paramIntimateInfo.frd_uin.get();
    } while (l <= 0L);
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ExtensionInfo localExtensionInfo2 = localFriendsManager.a(Long.toString(l));
    ExtensionInfo localExtensionInfo1;
    if (localExtensionInfo2 == null)
    {
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = Long.toString(l);
      label67:
      if ((!paramIntimateInfo.is_del.has()) || (!paramIntimateInfo.is_del.get())) {
        break label354;
      }
      localExtensionInfo1.intimate_type = 0;
      localExtensionInfo1.intimate_level = 0;
      localExtensionInfo1.intimate_chatDays = 0;
      localExtensionInfo1.isExtinguish = false;
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        localFriendsManager.a(localExtensionInfo1);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("FriendIntimateRelationshipHelper", 1, "handleGet0x5e0IntimateInfo end changed:" + bool + "  uin:" + l + " isOpen:" + a(paramQQAppInterface.getCurrentUin()) + " intimate_type:" + localExtensionInfo1.intimate_type + " intimate_level:" + localExtensionInfo1.intimate_level + " isExtinguish:" + localExtensionInfo1.isExtinguish + " intimate_chatDays:" + localExtensionInfo1.intimate_chatDays);
      return;
      localExtensionInfo1 = localExtensionInfo2;
      if (!QLog.isColorLevel()) {
        break label67;
      }
      QLog.i("FriendIntimateRelationshipHelper", 1, "handleGet0x5e0IntimateInfo before uin:" + l + " isOpen:" + a(paramQQAppInterface.getCurrentUin()) + " intimate_type:" + localExtensionInfo2.intimate_type + " intimate_level:" + localExtensionInfo2.intimate_level + " isExtinguish:" + localExtensionInfo2.isExtinguish + " intimate_chatDays:" + localExtensionInfo2.intimate_chatDays);
      localExtensionInfo1 = localExtensionInfo2;
      break label67;
      label354:
      if (paramIntimateInfo.lover.has())
      {
        localExtensionInfo1.intimate_type = 1;
        localExtensionInfo1.intimate_level = paramIntimateInfo.lover.level.get();
        localExtensionInfo1.intimate_chatDays = paramIntimateInfo.lover.chat_days.get();
        if ((paramIntimateInfo.lover.buffer.has()) && (paramIntimateInfo.lover.buffer.get() != null))
        {
          a(paramQQAppInterface, localExtensionInfo1, paramIntimateInfo.lover.buffer.get().toByteArray());
          bool = true;
        }
      }
      else if (paramIntimateInfo.ladybro.has())
      {
        localExtensionInfo1.intimate_type = 2;
        localExtensionInfo1.intimate_level = paramIntimateInfo.ladybro.level.get();
        localExtensionInfo1.intimate_chatDays = paramIntimateInfo.ladybro.chat_days.get();
        if ((paramIntimateInfo.ladybro.buffer.has()) && (paramIntimateInfo.ladybro.buffer.get() != null))
        {
          a(paramQQAppInterface, localExtensionInfo1, paramIntimateInfo.ladybro.buffer.get().toByteArray());
          bool = true;
        }
      }
      else if (paramIntimateInfo.bestfriend.has())
      {
        localExtensionInfo1.intimate_type = 26;
        localExtensionInfo1.intimate_level = paramIntimateInfo.bestfriend.level.get();
        localExtensionInfo1.intimate_chatDays = paramIntimateInfo.bestfriend.chat_days.get();
        if ((paramIntimateInfo.bestfriend.buffer.has()) && (paramIntimateInfo.bestfriend.buffer.get() != null))
        {
          a(paramQQAppInterface, localExtensionInfo1, paramIntimateInfo.bestfriend.buffer.get().toByteArray());
          bool = true;
        }
      }
      else
      {
        if (!paramIntimateInfo.buddy.has()) {
          continue;
        }
        localExtensionInfo1.intimate_type = 3;
        localExtensionInfo1.intimate_level = paramIntimateInfo.buddy.level.get();
        localExtensionInfo1.intimate_chatDays = paramIntimateInfo.buddy.chat_days.get();
        if ((paramIntimateInfo.buddy.buffer.has()) && (paramIntimateInfo.buddy.buffer.get() != null)) {
          a(paramQQAppInterface, localExtensionInfo1, paramIntimateInfo.buddy.buffer.get().toByteArray());
        }
      }
      bool = true;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    boolean bool = jdField_a_of_type_Boolean;
    if (!TextUtils.isEmpty(paramString))
    {
      jdField_a_of_type_Boolean = paramBoolean;
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0).edit();
      localEditor.putBoolean("friend_intimate_isOpen", paramBoolean);
      localEditor.commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 1, "updateIsOpen uin:" + paramString + " isOpen:" + paramBoolean + "  sLastIsOpen:" + jdField_a_of_type_Boolean + " lastOpen:" + bool);
    }
  }
  
  public static boolean a()
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L) {
      return b;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    b = FriendIntimateRelationshipConfProcessor.a().jdField_a_of_type_Boolean;
    QLog.i("FriendIntimateRelationshipHelper", 1, "isUpgradeOpen res:" + b);
    return b;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    if (paramExtensionInfo != null) {}
    for (int j = paramExtensionInfo.intimate_type;; j = 0)
    {
      int i;
      boolean bool2;
      boolean bool1;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        intimate_relation.IntimateInfo localIntimateInfo = new intimate_relation.IntimateInfo();
        try
        {
          localIntimateInfo.mergeFrom(paramArrayOfByte);
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            localObject1 = null;
            i = 1;
            continue;
            if (localObject1.ladybro.has())
            {
              paramExtensionInfo.intimate_type = 2;
              paramExtensionInfo.intimate_level = localObject1.ladybro.level.get();
              paramExtensionInfo.intimate_chatDays = localObject1.ladybro.chat_days.get();
              if ((localObject1.ladybro.buffer.has()) && (localObject1.ladybro.buffer.get() != null)) {
                a(paramQQAppInterface, paramExtensionInfo, localObject1.ladybro.buffer.get().toByteArray());
              }
              bool2 = true;
              bool1 = true;
            }
            else if (localObject1.bestfriend.has())
            {
              paramExtensionInfo.intimate_type = 26;
              paramExtensionInfo.intimate_level = localObject1.bestfriend.level.get();
              paramExtensionInfo.intimate_chatDays = localObject1.bestfriend.chat_days.get();
              if ((localObject1.bestfriend.buffer.has()) && (localObject1.bestfriend.buffer.get() != null)) {
                a(paramQQAppInterface, paramExtensionInfo, localObject1.bestfriend.buffer.get().toByteArray());
              }
              bool2 = true;
              bool1 = true;
            }
            else if (localObject1.buddy.has())
            {
              paramExtensionInfo.intimate_type = 3;
              paramExtensionInfo.intimate_level = localObject1.buddy.level.get();
              paramExtensionInfo.intimate_chatDays = localObject1.buddy.chat_days.get();
              if ((localObject1.buddy.buffer.has()) && (localObject1.buddy.buffer.get() != null)) {
                a(paramQQAppInterface, paramExtensionInfo, localObject1.buddy.buffer.get().toByteArray());
              }
              bool2 = true;
              bool1 = true;
            }
            else
            {
              bool2 = false;
              bool1 = false;
            }
          }
        }
        if ((localIntimateInfo != null) && (paramExtensionInfo != null)) {
          if (localIntimateInfo.lover.has())
          {
            paramExtensionInfo.intimate_type = 1;
            paramExtensionInfo.intimate_level = localIntimateInfo.lover.level.get();
            paramExtensionInfo.intimate_chatDays = localIntimateInfo.lover.chat_days.get();
            if ((localIntimateInfo.lover.buffer.has()) && (localIntimateInfo.lover.buffer.get() != null)) {
              a(paramQQAppInterface, paramExtensionInfo, localIntimateInfo.lover.buffer.get().toByteArray());
            }
            bool2 = true;
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        boolean bool3 = bool1;
        if (!bool2)
        {
          bool3 = bool1;
          if (i == 0)
          {
            bool3 = bool1;
            if (paramExtensionInfo != null) {
              if ((paramExtensionInfo.intimate_type == 0) && (paramExtensionInfo.intimate_level == 0) && (paramExtensionInfo.intimate_chatDays == 0))
              {
                bool3 = bool1;
                if (!paramExtensionInfo.isExtinguish) {}
              }
              else
              {
                paramExtensionInfo.intimate_type = 0;
                paramExtensionInfo.intimate_level = 0;
                paramExtensionInfo.intimate_chatDays = 0;
                paramExtensionInfo.isExtinguish = false;
                bool3 = true;
              }
            }
          }
        }
        if ((paramQQAppInterface != null) && (paramExtensionInfo != null))
        {
          paramExtensionInfo = new StringBuilder().append("handleGetIntimateInfo hasFlag:").append(bool2).append("  uin:").append(paramExtensionInfo.uin).append(" isOpen:").append(a(paramQQAppInterface.getCurrentUin())).append(" old_type:").append(j).append(" intimate_type:").append(paramExtensionInfo.intimate_type).append(" intimate_level:").append(paramExtensionInfo.intimate_level).append(" intimate_chatDays:").append(paramExtensionInfo.intimate_chatDays).append(" isExtinguish:").append(paramExtensionInfo.isExtinguish).append(" vecIntimateInfo.length:");
          paramQQAppInterface = localObject2;
          if (paramArrayOfByte != null) {
            paramQQAppInterface = Integer.valueOf(paramArrayOfByte.length);
          }
          QLog.i("FriendIntimateRelationshipHelper", 1, paramQQAppInterface + " changed:" + bool3);
        }
        return bool3;
        Object localObject1;
        bool1 = false;
        i = 0;
        bool2 = false;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, jdField_a_of_type_JavaLangString)))
    {
      boolean bool = jdField_a_of_type_Boolean;
      String str = jdField_a_of_type_JavaLangString;
      jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0).getBoolean("friend_intimate_isOpen", false);
      QLog.d("FriendIntimateRelationshipHelper", 1, "isOpen oldOpen:" + bool + " sLastIsOpen:" + jdField_a_of_type_Boolean + "  oldUin:" + str + "  sLastUin:" + jdField_a_of_type_JavaLangString);
    }
    QLog.i("FriendIntimateRelationshipHelper", 1, "isOpen res:" + jdField_a_of_type_Boolean);
    return jdField_a_of_type_Boolean;
  }
  
  public static String b()
  {
    return FriendIntimateRelationshipConfProcessor.a().S;
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    String str = "";
    FriendIntimateRelationshipBean localFriendIntimateRelationshipBean = FriendIntimateRelationshipConfProcessor.a();
    switch (paramInt1)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      QLog.i("FriendIntimateRelationshipHelper", 1, "getAIOIntimateDarkBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      return str;
      if (paramInt2 == 0)
      {
        str = localFriendIntimateRelationshipBean.p;
      }
      else if (paramInt2 == 1)
      {
        str = localFriendIntimateRelationshipBean.q;
      }
      else if (paramInt2 == 2)
      {
        str = localFriendIntimateRelationshipBean.r;
        continue;
        if (paramInt2 == 0)
        {
          str = localFriendIntimateRelationshipBean.s;
        }
        else if (paramInt2 == 1)
        {
          str = localFriendIntimateRelationshipBean.t;
        }
        else if (paramInt2 == 2)
        {
          str = localFriendIntimateRelationshipBean.u;
          continue;
          if (paramInt2 == 0)
          {
            str = localFriendIntimateRelationshipBean.v;
          }
          else if (paramInt2 == 1)
          {
            str = localFriendIntimateRelationshipBean.w;
          }
          else if (paramInt2 == 2)
          {
            str = localFriendIntimateRelationshipBean.x;
            continue;
            if (paramInt2 == 0) {
              str = localFriendIntimateRelationshipBean.y;
            } else if (paramInt2 == 1) {
              str = localFriendIntimateRelationshipBean.z;
            } else if (paramInt2 == 2) {
              str = localFriendIntimateRelationshipBean.A;
            }
          }
        }
      }
    }
  }
  
  public static String c(int paramInt1, int paramInt2)
  {
    String str = "";
    FriendIntimateRelationshipBean localFriendIntimateRelationshipBean = FriendIntimateRelationshipConfProcessor.a();
    switch (paramInt1)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      QLog.i("FriendIntimateRelationshipHelper", 1, "getAIOIntimateShareBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      return str;
      str = localFriendIntimateRelationshipBean.B;
      continue;
      if (paramInt2 == 0)
      {
        str = localFriendIntimateRelationshipBean.C;
      }
      else if (paramInt2 == 1)
      {
        str = localFriendIntimateRelationshipBean.D;
      }
      else if (paramInt2 == 2)
      {
        str = localFriendIntimateRelationshipBean.E;
        continue;
        if (paramInt2 == 0)
        {
          str = localFriendIntimateRelationshipBean.F;
        }
        else if (paramInt2 == 1)
        {
          str = localFriendIntimateRelationshipBean.G;
        }
        else if (paramInt2 == 2)
        {
          str = localFriendIntimateRelationshipBean.H;
          continue;
          if (paramInt2 == 0)
          {
            str = localFriendIntimateRelationshipBean.I;
          }
          else if (paramInt2 == 1)
          {
            str = localFriendIntimateRelationshipBean.J;
          }
          else if (paramInt2 == 2)
          {
            str = localFriendIntimateRelationshipBean.K;
            continue;
            if (paramInt2 == 0) {
              str = localFriendIntimateRelationshipBean.L;
            } else if (paramInt2 == 1) {
              str = localFriendIntimateRelationshipBean.M;
            } else if (paramInt2 == 2) {
              str = localFriendIntimateRelationshipBean.N;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper
 * JD-Core Version:    0.7.0.1
 */