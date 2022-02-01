package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.friends.intimate.IntimateInfoManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msg.api.IMessageFacade;
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
import com.tencent.mobileqq.vas.config.business.qvip.QVipFriendTag2Config;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFriendTag2Processor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
  static boolean b = false;
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    int j = 0;
    int i = 0;
    if (paramQQAppInterface != null)
    {
      long l = System.currentTimeMillis();
      try
      {
        j = paramQQAppInterface.d();
        i = j;
      }
      catch (Throwable paramQQAppInterface)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBindIntimateRelationshipFriendCount e:");
        localStringBuilder.append(paramQQAppInterface.getMessage());
        QLog.i("FriendIntimateRelationshipHelper", 2, localStringBuilder.toString());
      }
      j = i;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getBindIntimateRelationshipFriendCount cost:");
        paramQQAppInterface.append(System.currentTimeMillis() - l);
        paramQQAppInterface.append("  count:");
        paramQQAppInterface.append(i);
        QLog.i("FriendIntimateRelationshipHelper", 2, paramQQAppInterface.toString());
        j = i;
      }
    }
    return j;
  }
  
  public static String a()
  {
    return FriendIntimateRelationshipConfProcessor.a().jdField_a_of_type_JavaLangString;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    Object localObject = FriendIntimateRelationshipConfProcessor.a();
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 26)
          {
            localObject = ((FriendIntimateRelationshipBean)localObject).c;
            break label188;
          }
          if (paramInt2 == 0)
          {
            localObject = ((FriendIntimateRelationshipBean)localObject).g;
            break label188;
          }
          if (paramInt2 == 1)
          {
            localObject = ((FriendIntimateRelationshipBean)localObject).h;
            break label188;
          }
          if (paramInt2 == 2)
          {
            localObject = ((FriendIntimateRelationshipBean)localObject).i;
            break label188;
          }
        }
        else
        {
          if (paramInt2 == 0)
          {
            localObject = ((FriendIntimateRelationshipBean)localObject).j;
            break label188;
          }
          if (paramInt2 == 1)
          {
            localObject = ((FriendIntimateRelationshipBean)localObject).k;
            break label188;
          }
          if (paramInt2 == 2)
          {
            localObject = ((FriendIntimateRelationshipBean)localObject).l;
            break label188;
          }
        }
      }
      else
      {
        if (paramInt2 == 0)
        {
          localObject = ((FriendIntimateRelationshipBean)localObject).d;
          break label188;
        }
        if (paramInt2 == 1)
        {
          localObject = ((FriendIntimateRelationshipBean)localObject).e;
          break label188;
        }
        if (paramInt2 == 2)
        {
          localObject = ((FriendIntimateRelationshipBean)localObject).f;
          break label188;
        }
      }
    }
    else
    {
      if (paramInt2 == 0)
      {
        localObject = ((FriendIntimateRelationshipBean)localObject).m;
        break label188;
      }
      if (paramInt2 == 1)
      {
        localObject = ((FriendIntimateRelationshipBean)localObject).n;
        break label188;
      }
      if (paramInt2 == 2)
      {
        localObject = ((FriendIntimateRelationshipBean)localObject).o;
        break label188;
      }
    }
    localObject = "";
    label188:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAIOIntimateBG intimateType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" level:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" res:");
    localStringBuilder.append((String)localObject);
    QLog.i("FriendIntimateRelationshipHelper", 1, localStringBuilder.toString());
    return localObject;
  }
  
  public static String a(String paramString)
  {
    Object localObject = Uri.parse(FriendIntimateRelationshipConfProcessor.a().jdField_b_of_type_JavaLangString).buildUpon();
    ((Uri.Builder)localObject).appendQueryParameter("uin", paramString);
    paramString = ((Uri.Builder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindPageURL url:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FriendIntimateRelationshipHelper", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public static List<String> a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    long l = paramInt;
    String str3 = MutualMarkConfigHelper.a(paramAppInterface, paramString1, l, 0L);
    String str1 = MutualMarkConfigHelper.a(paramAppInterface, paramString1, l, 1L);
    String str2 = MutualMarkConfigHelper.a(paramAppInterface, paramString1, l, 2L);
    paramAppInterface = paramString2;
    if (paramString2.contains("#intimateshipicon1"))
    {
      paramAppInterface = paramString2.replace("#intimateshipicon1", str3);
      localArrayList.add(str3);
    }
    paramString1 = paramAppInterface;
    if (paramAppInterface.contains("#intimateshipicon2"))
    {
      paramString1 = paramAppInterface.replace("#intimateshipicon2", str1);
      localArrayList.add(str1);
    }
    paramAppInterface = paramString1;
    if (paramString1.contains("#intimateshipicon3"))
    {
      paramAppInterface = paramString1.replace("#intimateshipicon3", str2);
      localArrayList.add(str2);
    }
    localArrayList.add(0, paramAppInterface);
    return localArrayList;
  }
  
  public static List<String> a(AppInterface paramAppInterface, String paramString1, String paramString2, FriendsManager paramFriendsManager, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    long l = paramInt;
    String str3 = MutualMarkConfigHelper.a(paramAppInterface, l, 0L);
    String str2 = MutualMarkConfigHelper.a(paramAppInterface, l, 1L);
    String str1 = MutualMarkConfigHelper.a(paramAppInterface, l, 2L);
    paramInt = paramFriendsManager.n;
    int i = paramFriendsManager.o;
    int j = paramFriendsManager.p;
    paramAppInterface = paramString1;
    if (paramString1.contains("#intimateshipday1")) {
      paramAppInterface = paramString1.replace("#intimateshipday1", String.valueOf(paramInt));
    }
    paramString1 = paramAppInterface;
    if (paramAppInterface.contains("#intimateshipday2")) {
      paramString1 = paramAppInterface.replace("#intimateshipday2", String.valueOf(i));
    }
    paramAppInterface = paramString1;
    if (paramString1.contains("#intimateshipmsgcount")) {
      paramAppInterface = paramString1.replace("#intimateshipmsgcount", String.valueOf(j));
    }
    paramString1 = paramAppInterface;
    if (paramAppInterface.contains("#intimateshipname1"))
    {
      paramString1 = paramAppInterface.replace("#intimateshipname1", str3);
      localArrayList.add(str3);
    }
    paramAppInterface = paramString1;
    if (paramString1.contains("#intimateshipname2"))
    {
      paramAppInterface = paramString1.replace("#intimateshipname2", str2);
      localArrayList.add(str2);
    }
    paramString1 = paramAppInterface;
    if (paramAppInterface.contains("#intimateshipname3"))
    {
      paramString1 = paramAppInterface.replace("#intimateshipname3", str1);
      localArrayList.add(str1);
    }
    localArrayList.add(0, paramString1.replace(HardCodeUtil.a(2131704972), paramString2));
    return localArrayList;
  }
  
  private static void a(AppInterface paramAppInterface, FriendsManager paramFriendsManager, String paramString1, String paramString2, int paramInt1, int paramInt2, PushMsg0x210C7Info paramPushMsg0x210C7Info, int paramInt3, int paramInt4)
  {
    Object localObject1 = paramString2;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("insertGrayTips uin:");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(" grayTips:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" intimateType:");
    ((StringBuilder)localObject2).append(paramInt1);
    QLog.i("FriendIntimateRelationshipHelper", 1, ((StringBuilder)localObject2).toString());
    if (!TextUtils.isEmpty(paramString2))
    {
      if (MutualMarkUtils.a(paramAppInterface)) {
        return;
      }
      localObject2 = ContactUtils.f(paramAppInterface, paramString1);
      paramString2 = (String)localObject1;
      if (paramInt3 == 2097154)
      {
        paramString2 = (String)localObject1;
        if (paramInt4 == 0)
        {
          localObject3 = QVipFriendTag2Processor.c();
          paramString2 = (String)localObject1;
          if (((QVipFriendTag2Config)localObject3).jdField_a_of_type_Boolean)
          {
            paramString2 = new StringBuilder();
            paramString2.append((String)localObject1);
            paramString2.append(((QVipFriendTag2Config)localObject3).jdField_a_of_type_JavaLangString);
            paramString2 = paramString2.toString();
          }
        }
      }
      localObject1 = a(paramAppInterface, paramString2, (String)localObject2, paramFriendsManager, paramInt1);
      paramString2 = a(paramAppInterface, paramString1, (String)((List)localObject1).get(0), paramInt1);
      paramFriendsManager = (String)paramString2.get(0);
      paramString2.remove(0);
      ((List)localObject1).remove(0);
      long l = MessageCache.a();
      UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(paramString1, paramString1, paramFriendsManager, 0, -5040, paramInt3, l);
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.hasRead = 0;
      localMessageForUniteGrayTip.subType = paramInt4;
      localMessageForUniteGrayTip.initGrayTipMsg(paramAppInterface, localUniteGrayTipParam);
      localObject2 = localMessageForUniteGrayTip.tipParam;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append("_intimate_");
      ((StringBuilder)localObject3).append(String.valueOf(paramPushMsg0x210C7Info.jdField_b_of_type_Long));
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(String.valueOf(paramPushMsg0x210C7Info.jdField_b_of_type_Int));
      ((UniteGrayTipParam)localObject2).d = ((StringBuilder)localObject3).toString();
      localObject2 = paramFriendsManager;
      localObject3 = paramString2;
      int j;
      int k;
      if (paramString2.size() > 0)
      {
        i = 0;
        for (;;)
        {
          localObject2 = paramFriendsManager;
          localObject3 = paramString2;
          if (i >= paramString2.size()) {
            break;
          }
          paramPushMsg0x210C7Info = new Bundle();
          localObject2 = (String)paramString2.get(i);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramPushMsg0x210C7Info.putString("image_resource", (String)localObject2);
            j = 0;
            for (;;)
            {
              k = paramFriendsManager.indexOf((String)localObject2, j);
              j = k + ((String)localObject2).length();
              if (k >= 0)
              {
                localUniteGrayTipParam.a(k, j, paramPushMsg0x210C7Info);
                if (QLog.isColorLevel())
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("iconPos=");
                  ((StringBuilder)localObject3).append(k);
                  ((StringBuilder)localObject3).append(" fromIndex=");
                  ((StringBuilder)localObject3).append(j);
                  QLog.d("FriendIntimateRelationshipHelper", 2, ((StringBuilder)localObject3).toString());
                }
              }
              if (k < 0) {
                break;
              }
            }
          }
          i += 1;
        }
      }
      int i = ((List)localObject1).size();
      paramString2 = "key_action_DATA";
      paramFriendsManager = "key_action";
      if (i > 0)
      {
        Object localObject4 = new FriendIntimateRelationshipHelper.2();
        paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject1;
        Collections.sort(paramPushMsg0x210C7Info, (Comparator)localObject4);
        localObject4 = new ArrayList();
        j = 0;
        i = 0;
        while (j < paramPushMsg0x210C7Info.size())
        {
          Bundle localBundle = new Bundle();
          String str1 = (String)paramPushMsg0x210C7Info.get(j);
          if (!TextUtils.isEmpty(str1))
          {
            localBundle.putInt(paramFriendsManager, 11);
            localBundle.putString(paramString2, str1);
            int m = 0;
            k = i;
            localObject1 = paramFriendsManager;
            paramFriendsManager = paramString2;
            for (;;)
            {
              int i1 = ((String)localObject2).indexOf(str1, m);
              i = str1.length();
              int n = i1 + i;
              Object localObject5 = ((ArrayList)localObject4).iterator();
              paramString2 = (String)localObject1;
              while (((Iterator)localObject5).hasNext())
              {
                localObject1 = (Pair)((Iterator)localObject5).next();
                if ((i1 >= ((Integer)((Pair)localObject1).first).intValue()) && (i1 < ((Integer)((Pair)localObject1).second).intValue()))
                {
                  i = 1;
                  break label776;
                }
              }
              i = 0;
              label776:
              m = ((String)localObject2).length();
              if ((i == 0) && (((List)localObject3).size() > 0) && (i1 >= 0) && (i1 < m) && (n >= 0) && (n < m))
              {
                if (((String)localObject2).indexOf(str1, n) >= 0) {
                  m = 1;
                } else {
                  m = 0;
                }
                if ((paramPushMsg0x210C7Info.size() > 1) || (m != 0) || (k > 0))
                {
                  localObject1 = ((String)localObject2).substring(0, i1);
                  localObject5 = ((String)localObject2).substring(n);
                  Iterator localIterator = ((List)localObject3).iterator();
                  m = 0;
                  while (localIterator.hasNext())
                  {
                    String str2 = (String)localIterator.next();
                    if (((String)localObject5).startsWith(str2)) {}
                    while (((String)localObject1).endsWith(str2))
                    {
                      m = 1;
                      break;
                    }
                  }
                  if (m == 0) {
                    i = 1;
                  }
                }
              }
              if (i != 0)
              {
                i = k;
              }
              else
              {
                ((ArrayList)localObject4).add(new Pair(Integer.valueOf(i1), Integer.valueOf(n)));
                i = k;
                if (i1 >= 0)
                {
                  k += 1;
                  localUniteGrayTipParam.a(i1, n, localBundle);
                  i = k;
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("spanPos=");
                    ((StringBuilder)localObject1).append(i1);
                    ((StringBuilder)localObject1).append(" fromIndex=");
                    ((StringBuilder)localObject1).append(n);
                    QLog.d("FriendIntimateRelationshipHelper", 2, ((StringBuilder)localObject1).toString());
                    i = k;
                  }
                }
              }
              if (i1 < 0) {
                break;
              }
              m = n;
              localObject1 = paramString2;
              k = i;
            }
          }
          localObject1 = paramString2;
          paramString2 = paramFriendsManager;
          paramFriendsManager = (FriendsManager)localObject1;
          j += 1;
          localObject1 = paramString2;
          paramString2 = paramFriendsManager;
          paramFriendsManager = (FriendsManager)localObject1;
        }
        paramPushMsg0x210C7Info = paramFriendsManager;
        paramFriendsManager = paramString2;
        paramString2 = paramPushMsg0x210C7Info;
      }
      else
      {
        paramFriendsManager = "key_action_DATA";
        paramString2 = "key_action";
      }
      if ((paramInt3 == 2097154) && (paramInt4 == 0))
      {
        paramPushMsg0x210C7Info = QVipFriendTag2Processor.c();
        if (paramPushMsg0x210C7Info.jdField_a_of_type_Boolean)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt(paramString2, 1);
          if (paramInt1 != 1)
          {
            if (paramInt1 != 2)
            {
              if (paramInt1 != 3)
              {
                if (paramInt1 != 26) {
                  paramInt1 = 10;
                } else if (paramInt2 == 0) {
                  paramInt1 = 27;
                } else {
                  paramInt1 = 28;
                }
              }
              else if (paramInt2 == 0) {
                paramInt1 = 21;
              } else {
                paramInt1 = 22;
              }
            }
            else if (paramInt2 == 0) {
              paramInt1 = 23;
            } else {
              paramInt1 = 24;
            }
          }
          else if (paramInt2 == 0) {
            paramInt1 = 25;
          } else {
            paramInt1 = 26;
          }
          ((Bundle)localObject1).putString(paramFriendsManager, String.format(paramPushMsg0x210C7Info.jdField_b_of_type_JavaLangString, new Object[] { paramString1, Integer.valueOf(paramInt1) }));
          paramInt2 = ((String)localObject2).length() - paramPushMsg0x210C7Info.jdField_a_of_type_JavaLangString.length();
          if (paramInt2 >= 0)
          {
            localUniteGrayTipParam.a(paramInt2, ((String)localObject2).length(), (Bundle)localObject1);
            ReportController.b(paramAppInterface, "dc00898", "", "", "qq_vip", "0X8009CA5", paramInt1, 0, "", "", "", "");
          }
        }
      }
      UniteGrayTipMsgUtil.a(paramAppInterface, localMessageForUniteGrayTip);
    }
  }
  
  public static void a(AppInterface paramAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeC2CMsgPkgSubMsgType0xc7 app:");
      ((StringBuilder)localObject1).append(paramAppInterface);
      ((StringBuilder)localObject1).append("  changeInfo:");
      ((StringBuilder)localObject1).append(paramRelationalChainChange);
      ((StringBuilder)localObject1).append("  msginfo:");
      ((StringBuilder)localObject1).append(paramPushMsg0x210C7Info);
      QLog.d("FriendIntimateRelationshipHelper", 1, ((StringBuilder)localObject1).toString());
    }
    if ((paramAppInterface != null) && (paramRelationalChainChange != null))
    {
      if (paramPushMsg0x210C7Info == null) {
        return;
      }
      long l1 = paramPushMsg0x210C7Info.jdField_b_of_type_Long;
      long l2 = paramPushMsg0x210C7Info.c;
      ExtSnsRelationChainChangePushInfo localExtSnsRelationChainChangePushInfo = ExtSnsRelationChainChangePushInfo.a(paramRelationalChainChange, paramPushMsg0x210C7Info.jdField_a_of_type_Boolean);
      if (TextUtils.equals(paramAppInterface.getCurrentAccountUin(), localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString))
      {
        if (TextUtils.isEmpty(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString)) {
          return;
        }
        Object localObject2 = (FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramRelationalChainChange = ((FriendsManager)localObject2).e(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decodeC2CMsgPkgSubMsgType0xc7 msginfo:");
        ((StringBuilder)localObject1).append(paramPushMsg0x210C7Info);
        ((StringBuilder)localObject1).append("changePushInfo:");
        ((StringBuilder)localObject1).append(localExtSnsRelationChainChangePushInfo);
        QLog.i("FriendIntimateRelationshipHelper", 1, ((StringBuilder)localObject1).toString());
        if ((paramRelationalChainChange != null) && (!paramRelationalChainChange.isFriend())) {
          return;
        }
        paramRelationalChainChange = ((FriendsManager)localObject2).a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
        localObject1 = paramRelationalChainChange;
        if (paramRelationalChainChange == null)
        {
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString;
        }
        paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
        Object localObject6 = (IntimateInfoHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
        int i = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int;
        Object localObject3 = " intimate_level:";
        Object localObject4;
        if (i != 1)
        {
          int j;
          int m;
          int k;
          if (i != 2)
          {
            if (i != 11000)
            {
              if (i != 11001)
              {
                switch (i)
                {
                default: 
                  localObject1 = paramRelationalChainChange;
                  localObject4 = localObject3;
                  localObject3 = localObject4;
                  localObject4 = localObject1;
                }
                Object localObject5;
                label1048:
                label1967:
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject4;
                        localObject1 = localObject3;
                        break label3893;
                        localObject4 = localObject3;
                        localObject1 = paramRelationalChainChange;
                        if (!a()) {
                          break;
                        }
                        localObject4 = localObject3;
                        localObject1 = paramRelationalChainChange;
                        if (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) {
                          break;
                        }
                        localObject4 = localObject3;
                        localObject1 = paramRelationalChainChange;
                        if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
                          break;
                        }
                        if ((localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int != 0) && (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null))
                        {
                          if ((!TextUtils.isEmpty(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_a_of_type_JavaLangString)) && (!MutualMarkUtils.a(paramAppInterface)))
                          {
                            localObject6 = HotReactiveHelper.a(paramAppInterface, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_a_of_type_JavaLangString, ContactUtils.f(paramAppInterface, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString), (FriendsManager)localObject2);
                            Object localObject7 = HotReactiveHelper.a(paramAppInterface, (String)((List)localObject6).get(0), localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
                            localObject5 = (String)((List)localObject7).get(0);
                            ((List)localObject6).remove(0);
                            ((List)localObject7).remove(0);
                            UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, (String)localObject5, 0, -5020, 2097153, MessageCache.a());
                            localObject4 = localObject2;
                            localObject1 = localObject3;
                            if (localObject7 != null)
                            {
                              localObject4 = localObject2;
                              localObject1 = localObject3;
                              if (((List)localObject7).size() > 0)
                              {
                                i = 0;
                                paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject3;
                                localObject3 = localObject7;
                                for (;;)
                                {
                                  localObject4 = localObject2;
                                  localObject1 = paramPushMsg0x210C7Info;
                                  if (i >= ((List)localObject3).size()) {
                                    break;
                                  }
                                  localObject4 = new Bundle();
                                  localObject1 = (String)((List)localObject3).get(i);
                                  if (!TextUtils.isEmpty((CharSequence)localObject1))
                                  {
                                    ((Bundle)localObject4).putString("image_resource", (String)localObject1);
                                    j = ((String)localObject5).lastIndexOf((String)localObject1);
                                    if (j >= 0) {
                                      localUniteGrayTipParam.a(j, j + ((String)localObject1).length(), (Bundle)localObject4);
                                    }
                                    if (QLog.isColorLevel())
                                    {
                                      localObject4 = new StringBuilder();
                                      ((StringBuilder)localObject4).append("addHotFriendAIOGrayTips grayStr=");
                                      ((StringBuilder)localObject4).append((String)localObject5);
                                      ((StringBuilder)localObject4).append("iconPos=");
                                      ((StringBuilder)localObject4).append(j);
                                      ((StringBuilder)localObject4).append("icon=");
                                      ((StringBuilder)localObject4).append((String)localObject1);
                                      ((StringBuilder)localObject4).append("grayStr=");
                                      ((StringBuilder)localObject4).append((String)localObject5);
                                      QLog.d("reactive", 2, ((StringBuilder)localObject4).toString());
                                    }
                                  }
                                  i += 1;
                                }
                              }
                            }
                            localObject3 = localObject1;
                            localObject2 = localObject5;
                            localObject1 = paramRelationalChainChange;
                            if (localObject6 != null)
                            {
                              localObject2 = localObject5;
                              localObject1 = paramRelationalChainChange;
                              if (((List)localObject6).size() > 0)
                              {
                                Collections.sort((List)localObject6, new FriendIntimateRelationshipHelper.1());
                                localObject7 = new ArrayList();
                                i = 0;
                                paramPushMsg0x210C7Info = paramRelationalChainChange;
                                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject5;
                                localObject5 = localObject6;
                                for (;;)
                                {
                                  localObject2 = paramRelationalChainChange;
                                  localObject1 = paramPushMsg0x210C7Info;
                                  if (i >= ((List)localObject5).size()) {
                                    break;
                                  }
                                  Bundle localBundle = new Bundle();
                                  localObject1 = (String)((List)localObject5).get(i);
                                  if (!TextUtils.isEmpty((CharSequence)localObject1))
                                  {
                                    localBundle.putInt("key_action", 11);
                                    localBundle.putString("key_action_DATA", (String)localObject1);
                                    j = 0;
                                    localObject2 = paramRelationalChainChange;
                                    for (;;)
                                    {
                                      m = ((String)localObject2).indexOf((String)localObject1, j);
                                      if (m < 0)
                                      {
                                        paramRelationalChainChange = paramPushMsg0x210C7Info;
                                        paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject1;
                                      }
                                      else
                                      {
                                        k = ((String)localObject1).length() + m;
                                        paramRelationalChainChange = ((ArrayList)localObject7).iterator();
                                        while (paramRelationalChainChange.hasNext())
                                        {
                                          localObject6 = (Pair)paramRelationalChainChange.next();
                                          if ((m >= ((Integer)((Pair)localObject6).first).intValue()) && (m < ((Integer)((Pair)localObject6).second).intValue()))
                                          {
                                            j = 1;
                                            break label1048;
                                          }
                                        }
                                        j = 0;
                                        localObject6 = paramPushMsg0x210C7Info;
                                        if (j != 0)
                                        {
                                          j = k;
                                          paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject6;
                                          paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject1;
                                        }
                                        else
                                        {
                                          ((ArrayList)localObject7).add(new Pair(Integer.valueOf(m), Integer.valueOf(k)));
                                          j = k;
                                          paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject6;
                                          paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject1;
                                          if (m >= 0)
                                          {
                                            localUniteGrayTipParam.a(m, k, localBundle);
                                            j = k;
                                            paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject6;
                                            paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject1;
                                            if (QLog.isColorLevel())
                                            {
                                              paramRelationalChainChange = new StringBuilder();
                                              paramRelationalChainChange.append("spanPos=");
                                              paramRelationalChainChange.append(m);
                                              paramRelationalChainChange.append(" fromIndex=");
                                              paramRelationalChainChange.append(k);
                                              QLog.d("FriendIntimateRelationshipHelper", 2, paramRelationalChainChange.toString());
                                              paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject1;
                                              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject6;
                                              j = k;
                                            }
                                          }
                                        }
                                      }
                                      if (m < 0) {
                                        break;
                                      }
                                      localObject1 = paramPushMsg0x210C7Info;
                                      paramPushMsg0x210C7Info = paramRelationalChainChange;
                                    }
                                  }
                                  localObject2 = paramRelationalChainChange;
                                  paramRelationalChainChange = paramPushMsg0x210C7Info;
                                  i += 1;
                                  paramPushMsg0x210C7Info = paramRelationalChainChange;
                                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject2;
                                }
                              }
                            }
                            localObject6 = new MessageForUniteGrayTip();
                            ((MessageForUniteGrayTip)localObject6).hasRead = 0;
                            ((MessageForUniteGrayTip)localObject6).initGrayTipMsg(paramAppInterface, localUniteGrayTipParam);
                            paramRelationalChainChange = new StringBuilder(21);
                            paramRelationalChainChange.append(l1);
                            paramRelationalChainChange.append("_");
                            paramRelationalChainChange.append(l2);
                            ((MessageForUniteGrayTip)localObject6).tipParam.d = paramRelationalChainChange.toString();
                            paramRelationalChainChange = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, 0);
                            if ((paramRelationalChainChange != null) && (!paramRelationalChainChange.isEmpty()))
                            {
                              paramRelationalChainChange = (MessageRecord)paramRelationalChainChange.get(paramRelationalChainChange.size() - 1);
                              if ((paramRelationalChainChange instanceof MessageForUniteGrayTip))
                              {
                                paramRelationalChainChange = (MessageForUniteGrayTip)paramRelationalChainChange;
                                if ((paramRelationalChainChange.tipParam != null) && (paramRelationalChainChange.subType == ((MessageForUniteGrayTip)localObject6).subType) && (paramRelationalChainChange.tipParam.c.equals(((MessageForUniteGrayTip)localObject6).tipParam.c)) && (((MessageForUniteGrayTip)localObject6).tipParam.jdField_a_of_type_Long - paramRelationalChainChange.tipParam.jdField_a_of_type_Long <= 1L))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
                                  }
                                  return;
                                }
                              }
                            }
                            paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject3;
                            localObject5 = localObject4;
                            paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject1;
                            if (!TextUtils.isEmpty((CharSequence)localObject2))
                            {
                              UniteGrayTipMsgUtil.a(paramAppInterface, (MessageForUniteGrayTip)localObject6);
                              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject3;
                              localObject5 = localObject4;
                              paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject1;
                            }
                          }
                          else
                          {
                            localObject1 = " intimate_level:";
                            paramPushMsg0x210C7Info = paramRelationalChainChange;
                            localObject5 = localObject2;
                            paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                          }
                          i = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
                          paramPushMsg0x210C7Info.intimate_level = i;
                          if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c > 0L) {
                            paramPushMsg0x210C7Info.last_intimate_chatTime = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c;
                          }
                          ((FriendsManager)localObject5).a(paramPushMsg0x210C7Info);
                          localObject1 = new ArrayList();
                          ((ArrayList)localObject1).add(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
                          paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(104, true, localObject1);
                          localObject1 = paramPushMsg0x210C7Info;
                          paramAppInterface = paramRelationalChainChange;
                        }
                        else
                        {
                          paramAppInterface = " intimate_level:";
                          localObject1 = paramRelationalChainChange;
                        }
                        paramRelationalChainChange = new StringBuilder();
                        paramRelationalChainChange.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Egalitarian_Soon intimate_type:");
                        paramRelationalChainChange.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int);
                        paramRelationalChainChange.append(paramAppInterface);
                        paramRelationalChainChange.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a());
                        QLog.i("FriendIntimateRelationshipHelper", 1, paramRelationalChainChange.toString());
                        localObject4 = paramAppInterface;
                        break;
                        localObject4 = localObject3;
                        localObject1 = paramRelationalChainChange;
                        if (!a()) {
                          break;
                        }
                        localObject4 = localObject3;
                        localObject1 = paramRelationalChainChange;
                        if (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) {
                          break;
                        }
                        localObject4 = localObject3;
                        localObject1 = paramRelationalChainChange;
                        if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
                          break;
                        }
                        localObject4 = localObject3;
                        localObject1 = paramRelationalChainChange;
                        if (localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
                          break;
                        }
                        if ((localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null) && (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c > 0L)) {
                          paramRelationalChainChange.last_intimate_chatTime = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c;
                        }
                        j = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
                        k = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
                        if ((IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) && (j > k))
                        {
                          if (j == 1)
                          {
                            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 1)
                            {
                              i = 150;
                              break label1967;
                            }
                            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 2)
                            {
                              i = 158;
                              break label1967;
                            }
                            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 26)
                            {
                              i = 168;
                              break label1967;
                            }
                            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 3)
                            {
                              i = 154;
                              break label1967;
                            }
                          }
                          else if (j == 2)
                          {
                            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 1)
                            {
                              i = 151;
                              break label1967;
                            }
                            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 2)
                            {
                              i = 159;
                              break label1967;
                            }
                            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 26)
                            {
                              i = 169;
                              break label1967;
                            }
                            if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 3)
                            {
                              i = 155;
                              break label1967;
                            }
                          }
                          i = -1;
                          localObject1 = HotReactiveHelper.a(paramAppInterface.getApp(), i);
                          paramRelationalChainChange.intimate_type = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
                          paramRelationalChainChange.intimate_level = j;
                          ((FriendsManager)localObject2).a(paramRelationalChainChange);
                          i = MutualMarkGrayTipsHelper.a(localExtSnsRelationChainChangePushInfo);
                          a(paramAppInterface, (FriendsManager)localObject2, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, (String)localObject1, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, j, paramPushMsg0x210C7Info, 2097153, i);
                          ((IntimateInfoHandler)localObject6).notifyUI(3, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int), Integer.valueOf(k), Integer.valueOf(j) });
                          paramAppInterface = (AppInterface)localObject1;
                        }
                        else
                        {
                          paramAppInterface = null;
                        }
                        paramPushMsg0x210C7Info = new StringBuilder();
                        paramPushMsg0x210C7Info.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Upgrade intimate_type:");
                        paramPushMsg0x210C7Info.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int);
                        paramPushMsg0x210C7Info.append(" intimate_level:");
                        paramPushMsg0x210C7Info.append(j);
                        paramPushMsg0x210C7Info.append(" old_intimate_level:");
                        paramPushMsg0x210C7Info.append(k);
                        QLog.i("FriendIntimateRelationshipHelper", 1, paramPushMsg0x210C7Info.toString());
                        paramPushMsg0x210C7Info = " intimate_level:";
                        break label3898;
                        localObject5 = " intimate_level:";
                        localObject4 = paramRelationalChainChange;
                        localObject3 = localObject5;
                      } while (!a());
                      localObject4 = paramRelationalChainChange;
                      localObject3 = localObject5;
                    } while (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString));
                    localObject4 = paramRelationalChainChange;
                    localObject3 = localObject5;
                  } while (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null);
                  localObject4 = paramRelationalChainChange;
                  localObject3 = localObject5;
                } while (localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null);
                if ((localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null) && (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c > 0L)) {
                  paramRelationalChainChange.last_intimate_chatTime = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c;
                }
                j = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
                k = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
                if ((IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) && (j < k))
                {
                  if (k == 1)
                  {
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 1)
                    {
                      i = 152;
                      break label2486;
                    }
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 2)
                    {
                      i = 160;
                      break label2486;
                    }
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 26)
                    {
                      i = 170;
                      break label2486;
                    }
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 3)
                    {
                      i = 156;
                      break label2486;
                    }
                  }
                  else if (k == 2)
                  {
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 1)
                    {
                      i = 153;
                      break label2486;
                    }
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 2)
                    {
                      i = 161;
                      break label2486;
                    }
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 26)
                    {
                      i = 171;
                      break label2486;
                    }
                    if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 3)
                    {
                      i = 157;
                      break label2486;
                    }
                  }
                  i = -1;
                  label2486:
                  localObject3 = HotReactiveHelper.a(paramAppInterface.getApp(), i);
                  paramRelationalChainChange.intimate_type = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
                  paramRelationalChainChange.intimate_level = j;
                  ((FriendsManager)localObject2).a(paramRelationalChainChange);
                  a(paramAppInterface, (FriendsManager)localObject2, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, (String)localObject3, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, j, paramPushMsg0x210C7Info, 2097154, 0);
                  ((IntimateInfoHandler)localObject6).notifyUI(3, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int), Integer.valueOf(k), Integer.valueOf(j) });
                  paramAppInterface = (AppInterface)localObject3;
                }
                else
                {
                  paramAppInterface = null;
                }
                paramRelationalChainChange = new StringBuilder();
                paramRelationalChainChange.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Downgrade intimate_type:");
                paramRelationalChainChange.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int);
                paramRelationalChainChange.append((String)localObject5);
                paramRelationalChainChange.append(j);
                paramRelationalChainChange.append(" old_intimate_level:");
                paramRelationalChainChange.append(k);
                QLog.i("FriendIntimateRelationshipHelper", 1, paramRelationalChainChange.toString());
              }
              else
              {
                localObject3 = " intimate_level:";
                if ((!a()) || (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) || (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null)) {
                  break label3883;
                }
                if (IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int))
                {
                  paramRelationalChainChange.isExtinguish = true;
                  ((FriendsManager)localObject2).a(paramRelationalChainChange);
                  paramRelationalChainChange = HotReactiveHelper.a(paramAppInterface.getApp(), 166);
                  a(paramAppInterface, (FriendsManager)localObject2, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a(), paramPushMsg0x210C7Info, 2097154, 0);
                  ((IntimateInfoHandler)localObject6).notifyUI(3, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int), Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a()), Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a()) });
                  ((FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
                  paramAppInterface = paramRelationalChainChange;
                }
                else
                {
                  paramAppInterface = null;
                }
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                paramPushMsg0x210C7Info = new StringBuilder();
                paramPushMsg0x210C7Info.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Extinguish intimate_type:");
                paramPushMsg0x210C7Info.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int);
                paramPushMsg0x210C7Info.append((String)localObject3);
                paramPushMsg0x210C7Info.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a());
                QLog.i("FriendIntimateRelationshipHelper", 1, paramPushMsg0x210C7Info.toString());
                paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject3;
                break label3898;
              }
            }
            else
            {
              localObject4 = " intimate_level:";
              localObject3 = paramRelationalChainChange;
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject3;
              localObject1 = localObject4;
              if (!a()) {
                break label3893;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject3;
              localObject1 = localObject4;
              if (!a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) {
                break label3893;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject3;
              localObject1 = localObject4;
              if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) {
                break label3893;
              }
              if (IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int))
              {
                ((ExtensionInfo)localObject3).isExtinguish = false;
                ((FriendsManager)localObject2).a((ExtensionInfo)localObject3);
                paramRelationalChainChange = HotReactiveHelper.a(paramAppInterface.getApp(), 167);
                a(paramAppInterface, (FriendsManager)localObject2, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a(), paramPushMsg0x210C7Info, 2097153, 0);
                ((IntimateInfoHandler)localObject6).notifyUI(3, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int), Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a()), Integer.valueOf(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a()) });
                ((FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
                paramAppInterface = paramRelationalChainChange;
              }
              else
              {
                paramAppInterface = null;
              }
              paramRelationalChainChange = new StringBuilder();
              paramRelationalChainChange.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Light intimate_type:");
              paramRelationalChainChange.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int);
              paramRelationalChainChange.append((String)localObject4);
              paramRelationalChainChange.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a());
              QLog.i("FriendIntimateRelationshipHelper", 1, paramRelationalChainChange.toString());
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject3;
              paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject4;
              break label3898;
            }
          }
          else
          {
            if (localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
            {
              k = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
              m = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
            }
            else
            {
              k = 0;
              m = 0;
            }
            i = k;
            j = m;
            if (k == 0)
            {
              i = k;
              j = m;
              if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
              {
                i = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
                j = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
              }
            }
            k = i;
            if (i == 0)
            {
              k = paramRelationalChainChange.intimate_type;
              j = paramRelationalChainChange.intimate_level;
            }
            if (IntimateUtil.a(k))
            {
              paramRelationalChainChange.intimate_type = 0;
              paramRelationalChainChange.intimate_level = 0;
              paramRelationalChainChange.intimate_chatDays = 0;
              paramRelationalChainChange.isExtinguish = false;
              i = 163;
              if (j == 1) {
                i = 164;
              } else if (j == 2) {
                i = 165;
              }
              localObject3 = HotReactiveHelper.a(paramAppInterface.getApp(), i);
              ((FriendsManager)localObject2).a(paramRelationalChainChange);
              if (a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString))
              {
                a(paramAppInterface, (FriendsManager)localObject2, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, (String)localObject3, k, 0, paramPushMsg0x210C7Info, 2097154, 1);
                ((IntimateInfoHandler)localObject6).notifyUI(1, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, Boolean.valueOf(true) });
                ((IntimateInfoManager)paramAppInterface.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
              }
              if (k == 1)
              {
                paramAppInterface = (LoveZoneInfoHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER);
                if (paramAppInterface != null) {
                  paramAppInterface.a(0);
                }
              }
              paramAppInterface = (AppInterface)localObject3;
            }
            else
            {
              paramAppInterface = null;
            }
            paramRelationalChainChange = new StringBuilder();
            paramRelationalChainChange.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Del intimate_type:");
            paramRelationalChainChange.append(k);
            paramRelationalChainChange.append(" intimate_level:");
            paramRelationalChainChange.append(j);
            paramRelationalChainChange.append(" friendUin:");
            paramRelationalChainChange.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
            QLog.i("FriendIntimateRelationshipHelper", 1, paramRelationalChainChange.toString());
          }
          paramPushMsg0x210C7Info = " intimate_level:";
          paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
          break label3898;
        }
        else
        {
          localObject3 = " intimate_level:";
          if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
          {
            if (IntimateUtil.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int))
            {
              i = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
              localObject4 = paramRelationalChainChange;
              ((ExtensionInfo)localObject4).intimate_type = i;
              ((ExtensionInfo)localObject4).intimate_chatDays = 0;
              ((ExtensionInfo)localObject4).intimate_level = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
              ((ExtensionInfo)localObject4).isExtinguish = false;
              if ((localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null) && (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c > 0L)) {
                ((ExtensionInfo)localObject4).last_intimate_chatTime = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c;
              }
              paramRelationalChainChange = HotReactiveHelper.a(paramAppInterface.getApp(), 162);
              ((FriendsManager)localObject2).a((ExtensionInfo)localObject4);
              if (a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString))
              {
                i = MutualMarkGrayTipsHelper.a(localExtSnsRelationChainChangePushInfo);
                a(paramAppInterface, (FriendsManager)localObject2, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int, localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a(), paramPushMsg0x210C7Info, 2097153, i);
                ((IntimateInfoHandler)localObject6).notifyUI(2, true, new Object[] { localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString });
              }
              if (localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int == 1)
              {
                paramAppInterface = (LoveZoneInfoHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER);
                if (paramAppInterface != null) {
                  paramAppInterface.a(1);
                }
              }
              paramAppInterface = paramRelationalChainChange;
            }
            else
            {
              paramAppInterface = null;
            }
            paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
            paramPushMsg0x210C7Info = new StringBuilder();
            paramPushMsg0x210C7Info.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Add friendUin:");
            paramPushMsg0x210C7Info.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
            paramPushMsg0x210C7Info.append(" changePushInfo.now:");
            paramPushMsg0x210C7Info.append(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo);
            QLog.i("FriendIntimateRelationshipHelper", 1, paramPushMsg0x210C7Info.toString());
            paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject3;
            break label3898;
          }
        }
        label3883:
        paramAppInterface = " intimate_level:";
        paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
        localObject1 = paramAppInterface;
        label3893:
        paramAppInterface = null;
        paramPushMsg0x210C7Info = (PushMsg0x210C7Info)localObject1;
        label3898:
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decodeC2CMsgPkgSubMsgType0xc7 changeType:");
        ((StringBuilder)localObject1).append(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(" grayTips:");
        ((StringBuilder)localObject1).append(paramAppInterface);
        ((StringBuilder)localObject1).append(" uin:");
        ((StringBuilder)localObject1).append(paramRelationalChainChange.uin);
        ((StringBuilder)localObject1).append(" isOpen:");
        ((StringBuilder)localObject1).append(a(localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString));
        ((StringBuilder)localObject1).append(" intimate_type:");
        ((StringBuilder)localObject1).append(paramRelationalChainChange.intimate_type);
        ((StringBuilder)localObject1).append(paramPushMsg0x210C7Info);
        ((StringBuilder)localObject1).append(paramRelationalChainChange.intimate_level);
        ((StringBuilder)localObject1).append(" intimate_chatDays:");
        ((StringBuilder)localObject1).append(paramRelationalChainChange.intimate_chatDays);
        ((StringBuilder)localObject1).append(" isExtinguish:");
        ((StringBuilder)localObject1).append(paramRelationalChainChange.isExtinguish);
        ((StringBuilder)localObject1).append(" last_intimate_chatTime:");
        ((StringBuilder)localObject1).append(paramRelationalChainChange.last_intimate_chatTime);
        QLog.i("FriendIntimateRelationshipHelper", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, byte[] paramArrayOfByte)
  {
    paramQQAppInterface = new intimate_relation_ext.IntimateRelationExtMsg();
    try
    {
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      paramQQAppInterface = null;
    }
    if (paramQQAppInterface != null)
    {
      boolean bool3 = paramQQAppInterface.uint64_icon_status.has();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (paramQQAppInterface.uint64_icon_status.get() == 1L) {
          bool1 = true;
        }
      }
      if (paramExtensionInfo.isExtinguish != bool1) {
        paramExtensionInfo.isExtinguish = bool1;
      }
      if (QLog.isColorLevel())
      {
        paramExtensionInfo = new StringBuilder();
        paramExtensionInfo.append("handleGetIntimateRelationExtMsgInfo ext_info.uint64_icon_status.has():");
        paramExtensionInfo.append(paramQQAppInterface.uint64_icon_status.has());
        paramExtensionInfo.append(" newIsExtinguish:");
        paramExtensionInfo.append(bool1);
        QLog.i("FriendIntimateRelationshipHelper", 1, paramExtensionInfo.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, intimate_relation.IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo == null) {
      return;
    }
    long l = paramIntimateInfo.frd_uin.get();
    if (l <= 0L) {
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ExtensionInfo localExtensionInfo = localFriendsManager.a(Long.toString(l));
    Object localObject;
    if (localExtensionInfo == null)
    {
      localObject = new ExtensionInfo();
      ((ExtensionInfo)localObject).uin = Long.toString(l);
    }
    else
    {
      localObject = localExtensionInfo;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGet0x5e0IntimateInfo before uin:");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" isOpen:");
        ((StringBuilder)localObject).append(a(paramQQAppInterface.getCurrentUin()));
        ((StringBuilder)localObject).append(" intimate_type:");
        ((StringBuilder)localObject).append(localExtensionInfo.intimate_type);
        ((StringBuilder)localObject).append(" intimate_level:");
        ((StringBuilder)localObject).append(localExtensionInfo.intimate_level);
        ((StringBuilder)localObject).append(" isExtinguish:");
        ((StringBuilder)localObject).append(localExtensionInfo.isExtinguish);
        ((StringBuilder)localObject).append(" intimate_chatDays:");
        ((StringBuilder)localObject).append(localExtensionInfo.intimate_chatDays);
        QLog.i("FriendIntimateRelationshipHelper", 1, ((StringBuilder)localObject).toString());
        localObject = localExtensionInfo;
      }
    }
    boolean bool2 = paramIntimateInfo.is_del.has();
    boolean bool1 = false;
    if ((bool2) && (paramIntimateInfo.is_del.get()))
    {
      ((ExtensionInfo)localObject).intimate_type = 0;
      ((ExtensionInfo)localObject).intimate_level = 0;
      ((ExtensionInfo)localObject).intimate_chatDays = 0;
      ((ExtensionInfo)localObject).isExtinguish = false;
    }
    else
    {
      if (!paramIntimateInfo.lover.has()) {
        break label372;
      }
      ((ExtensionInfo)localObject).intimate_type = 1;
      ((ExtensionInfo)localObject).intimate_level = paramIntimateInfo.lover.level.get();
      ((ExtensionInfo)localObject).intimate_chatDays = paramIntimateInfo.lover.chat_days.get();
      if ((paramIntimateInfo.lover.buffer.has()) && (paramIntimateInfo.lover.buffer.get() != null)) {
        a(paramQQAppInterface, (ExtensionInfo)localObject, paramIntimateInfo.lover.buffer.get().toByteArray());
      }
    }
    for (;;)
    {
      bool1 = true;
      break;
      label372:
      if (paramIntimateInfo.ladybro.has())
      {
        ((ExtensionInfo)localObject).intimate_type = 2;
        ((ExtensionInfo)localObject).intimate_level = paramIntimateInfo.ladybro.level.get();
        ((ExtensionInfo)localObject).intimate_chatDays = paramIntimateInfo.ladybro.chat_days.get();
        if ((paramIntimateInfo.ladybro.buffer.has()) && (paramIntimateInfo.ladybro.buffer.get() != null)) {
          a(paramQQAppInterface, (ExtensionInfo)localObject, paramIntimateInfo.ladybro.buffer.get().toByteArray());
        }
      }
      else if (paramIntimateInfo.bestfriend.has())
      {
        ((ExtensionInfo)localObject).intimate_type = 26;
        ((ExtensionInfo)localObject).intimate_level = paramIntimateInfo.bestfriend.level.get();
        ((ExtensionInfo)localObject).intimate_chatDays = paramIntimateInfo.bestfriend.chat_days.get();
        if ((paramIntimateInfo.bestfriend.buffer.has()) && (paramIntimateInfo.bestfriend.buffer.get() != null)) {
          a(paramQQAppInterface, (ExtensionInfo)localObject, paramIntimateInfo.bestfriend.buffer.get().toByteArray());
        }
      }
      else
      {
        if (!paramIntimateInfo.buddy.has()) {
          break;
        }
        ((ExtensionInfo)localObject).intimate_type = 3;
        ((ExtensionInfo)localObject).intimate_level = paramIntimateInfo.buddy.level.get();
        ((ExtensionInfo)localObject).intimate_chatDays = paramIntimateInfo.buddy.chat_days.get();
        if ((paramIntimateInfo.buddy.buffer.has()) && (paramIntimateInfo.buddy.buffer.get() != null)) {
          a(paramQQAppInterface, (ExtensionInfo)localObject, paramIntimateInfo.buddy.buffer.get().toByteArray());
        }
      }
    }
    if (bool1) {
      localFriendsManager.a((ExtensionInfo)localObject);
    }
    if (QLog.isColorLevel())
    {
      paramIntimateInfo = new StringBuilder();
      paramIntimateInfo.append("handleGet0x5e0IntimateInfo end changed:");
      paramIntimateInfo.append(bool1);
      paramIntimateInfo.append("  uin:");
      paramIntimateInfo.append(l);
      paramIntimateInfo.append(" isOpen:");
      paramIntimateInfo.append(a(paramQQAppInterface.getCurrentUin()));
      paramIntimateInfo.append(" intimate_type:");
      paramIntimateInfo.append(((ExtensionInfo)localObject).intimate_type);
      paramIntimateInfo.append(" intimate_level:");
      paramIntimateInfo.append(((ExtensionInfo)localObject).intimate_level);
      paramIntimateInfo.append(" isExtinguish:");
      paramIntimateInfo.append(((ExtensionInfo)localObject).isExtinguish);
      paramIntimateInfo.append(" intimate_chatDays:");
      paramIntimateInfo.append(((ExtensionInfo)localObject).intimate_chatDays);
      QLog.i("FriendIntimateRelationshipHelper", 1, paramIntimateInfo.toString());
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    boolean bool = jdField_a_of_type_Boolean;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      jdField_a_of_type_Boolean = paramBoolean;
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("friend_intimate_isOpen", paramBoolean);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateIsOpen uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" isOpen:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("  sLastIsOpen:");
      ((StringBuilder)localObject).append(jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" lastOpen:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("FriendIntimateRelationshipHelper", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean a()
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L) {
      return b;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    b = FriendIntimateRelationshipConfProcessor.a().jdField_a_of_type_Boolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isUpgradeOpen res:");
    localStringBuilder.append(b);
    QLog.i("FriendIntimateRelationshipHelper", 1, localStringBuilder.toString());
    return b;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, byte[] paramArrayOfByte)
  {
    int j;
    if (paramExtensionInfo != null) {
      j = paramExtensionInfo.intimate_type;
    } else {
      j = 0;
    }
    Object localObject = null;
    int i;
    StringBuilder localStringBuilder;
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
        localException.printStackTrace();
        localStringBuilder = null;
        i = 1;
      }
      if ((localStringBuilder != null) && (paramExtensionInfo != null))
      {
        if (localStringBuilder.lover.has())
        {
          paramExtensionInfo.intimate_type = 1;
          paramExtensionInfo.intimate_level = localStringBuilder.lover.level.get();
          paramExtensionInfo.intimate_chatDays = localStringBuilder.lover.chat_days.get();
          if ((localStringBuilder.lover.buffer.has()) && (localStringBuilder.lover.buffer.get() != null)) {
            a(paramQQAppInterface, paramExtensionInfo, localStringBuilder.lover.buffer.get().toByteArray());
          }
        }
        for (;;)
        {
          bool2 = true;
          bool1 = true;
          break label472;
          if (localStringBuilder.ladybro.has())
          {
            paramExtensionInfo.intimate_type = 2;
            paramExtensionInfo.intimate_level = localStringBuilder.ladybro.level.get();
            paramExtensionInfo.intimate_chatDays = localStringBuilder.ladybro.chat_days.get();
            if ((localStringBuilder.ladybro.buffer.has()) && (localStringBuilder.ladybro.buffer.get() != null)) {
              a(paramQQAppInterface, paramExtensionInfo, localStringBuilder.ladybro.buffer.get().toByteArray());
            }
          }
          else if (localStringBuilder.bestfriend.has())
          {
            paramExtensionInfo.intimate_type = 26;
            paramExtensionInfo.intimate_level = localStringBuilder.bestfriend.level.get();
            paramExtensionInfo.intimate_chatDays = localStringBuilder.bestfriend.chat_days.get();
            if ((localStringBuilder.bestfriend.buffer.has()) && (localStringBuilder.bestfriend.buffer.get() != null)) {
              a(paramQQAppInterface, paramExtensionInfo, localStringBuilder.bestfriend.buffer.get().toByteArray());
            }
          }
          else
          {
            if (!localStringBuilder.buddy.has()) {
              break;
            }
            paramExtensionInfo.intimate_type = 3;
            paramExtensionInfo.intimate_level = localStringBuilder.buddy.level.get();
            paramExtensionInfo.intimate_chatDays = localStringBuilder.buddy.chat_days.get();
            if ((localStringBuilder.buddy.buffer.has()) && (localStringBuilder.buddy.buffer.get() != null)) {
              a(paramQQAppInterface, paramExtensionInfo, localStringBuilder.buddy.buffer.get().toByteArray());
            }
          }
        }
      }
    }
    else
    {
      i = 0;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    label472:
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetIntimateInfo hasFlag:");
      localStringBuilder.append(bool2);
      localStringBuilder.append("  uin:");
      localStringBuilder.append(paramExtensionInfo.uin);
      localStringBuilder.append(" isOpen:");
      localStringBuilder.append(a(paramQQAppInterface.getCurrentUin()));
      localStringBuilder.append(" old_type:");
      localStringBuilder.append(j);
      localStringBuilder.append(" intimate_type:");
      localStringBuilder.append(paramExtensionInfo.intimate_type);
      localStringBuilder.append(" intimate_level:");
      localStringBuilder.append(paramExtensionInfo.intimate_level);
      localStringBuilder.append(" intimate_chatDays:");
      localStringBuilder.append(paramExtensionInfo.intimate_chatDays);
      localStringBuilder.append(" isExtinguish:");
      localStringBuilder.append(paramExtensionInfo.isExtinguish);
      localStringBuilder.append(" vecIntimateInfo.length:");
      paramQQAppInterface = localObject;
      if (paramArrayOfByte != null) {
        paramQQAppInterface = Integer.valueOf(paramArrayOfByte.length);
      }
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append(" changed:");
      localStringBuilder.append(bool3);
      QLog.i("FriendIntimateRelationshipHelper", 1, localStringBuilder.toString());
    }
    return bool3;
  }
  
  public static boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, jdField_a_of_type_JavaLangString)))
    {
      boolean bool = jdField_a_of_type_Boolean;
      String str = jdField_a_of_type_JavaLangString;
      jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0).getBoolean("friend_intimate_isOpen", false);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isOpen oldOpen:");
        paramString.append(bool);
        paramString.append(" sLastIsOpen:");
        paramString.append(jdField_a_of_type_Boolean);
        paramString.append("  oldUin:");
        paramString.append(str);
        paramString.append("  sLastUin:");
        paramString.append(jdField_a_of_type_JavaLangString);
        QLog.d("FriendIntimateRelationshipHelper", 2, paramString.toString());
      }
    }
    return jdField_a_of_type_Boolean;
  }
  
  public static String b()
  {
    return FriendIntimateRelationshipConfProcessor.a().S;
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    Object localObject = FriendIntimateRelationshipConfProcessor.a();
    String str = "";
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 == 26) {
            if (paramInt2 == 0) {
              str = ((FriendIntimateRelationshipBean)localObject).s;
            } else if (paramInt2 == 1) {
              str = ((FriendIntimateRelationshipBean)localObject).t;
            } else if (paramInt2 == 2) {
              str = ((FriendIntimateRelationshipBean)localObject).u;
            }
          }
        }
        else if (paramInt2 == 0) {
          str = ((FriendIntimateRelationshipBean)localObject).v;
        } else if (paramInt2 == 1) {
          str = ((FriendIntimateRelationshipBean)localObject).w;
        } else if (paramInt2 == 2) {
          str = ((FriendIntimateRelationshipBean)localObject).x;
        }
      }
      else if (paramInt2 == 0) {
        str = ((FriendIntimateRelationshipBean)localObject).p;
      } else if (paramInt2 == 1) {
        str = ((FriendIntimateRelationshipBean)localObject).q;
      } else if (paramInt2 == 2) {
        str = ((FriendIntimateRelationshipBean)localObject).r;
      }
    }
    else if (paramInt2 == 0) {
      str = ((FriendIntimateRelationshipBean)localObject).y;
    } else if (paramInt2 == 1) {
      str = ((FriendIntimateRelationshipBean)localObject).z;
    } else if (paramInt2 == 2) {
      str = ((FriendIntimateRelationshipBean)localObject).A;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAIOIntimateDarkBG intimateType:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" level:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" res:");
    ((StringBuilder)localObject).append(str);
    QLog.i("FriendIntimateRelationshipHelper", 1, ((StringBuilder)localObject).toString());
    return str;
  }
  
  public static String c(int paramInt1, int paramInt2)
  {
    Object localObject = FriendIntimateRelationshipConfProcessor.a();
    String str = "";
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 == 26) {
              if (paramInt2 == 0) {
                str = ((FriendIntimateRelationshipBean)localObject).F;
              } else if (paramInt2 == 1) {
                str = ((FriendIntimateRelationshipBean)localObject).G;
              } else if (paramInt2 == 2) {
                str = ((FriendIntimateRelationshipBean)localObject).H;
              }
            }
          }
          else if (paramInt2 == 0) {
            str = ((FriendIntimateRelationshipBean)localObject).I;
          } else if (paramInt2 == 1) {
            str = ((FriendIntimateRelationshipBean)localObject).J;
          } else if (paramInt2 == 2) {
            str = ((FriendIntimateRelationshipBean)localObject).K;
          }
        }
        else if (paramInt2 == 0) {
          str = ((FriendIntimateRelationshipBean)localObject).C;
        } else if (paramInt2 == 1) {
          str = ((FriendIntimateRelationshipBean)localObject).D;
        } else if (paramInt2 == 2) {
          str = ((FriendIntimateRelationshipBean)localObject).E;
        }
      }
      else if (paramInt2 == 0) {
        str = ((FriendIntimateRelationshipBean)localObject).L;
      } else if (paramInt2 == 1) {
        str = ((FriendIntimateRelationshipBean)localObject).M;
      } else if (paramInt2 == 2) {
        str = ((FriendIntimateRelationshipBean)localObject).N;
      }
    }
    else {
      str = ((FriendIntimateRelationshipBean)localObject).B;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAIOIntimateShareBG intimateType:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" level:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" res:");
    ((StringBuilder)localObject).append(str);
    QLog.i("FriendIntimateRelationshipHelper", 1, ((StringBuilder)localObject).toString());
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper
 * JD-Core Version:    0.7.0.1
 */