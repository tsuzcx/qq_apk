package com.tencent.mobileqq.mutualmark;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MutualMarkGrayTipsHelper
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -5040;
    case 1: 
      return -5020;
    case 2: 
      return -5023;
    }
    return -5022;
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L)) {
      return MutualMarkUtils.a(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo)
  {
    long l1 = paramExtSnsRelationChainChangePushInfo.a();
    long l2 = paramExtSnsRelationChainChangePushInfo.b();
    if (l1 == 17L) {
      if (!paramExtSnsRelationChainChangePushInfo.a()) {}
    }
    while (paramExtSnsRelationChainChangePushInfo.a())
    {
      return 999;
      return 0;
    }
    if (paramExtSnsRelationChainChangePushInfo.b()) {
      return 998;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo localGrayTipHighlightItemInfo;
    int i;
    if (((Matcher)localObject).find())
    {
      localGrayTipHighlightItemInfo = new MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo();
      localGrayTipHighlightItemInfo.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localGrayTipHighlightItemInfo.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localGrayTipHighlightItemInfo.jdField_b_of_type_JavaLangString = ((Matcher)localObject).group(2);
      if (localGrayTipHighlightItemInfo.a()) {}
      for (i = 2;; i = 1)
      {
        localGrayTipHighlightItemInfo.jdField_a_of_type_Int = i;
        localArrayList.add(localGrayTipHighlightItemInfo);
        break;
      }
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localGrayTipHighlightItemInfo = new MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo();
      localGrayTipHighlightItemInfo.jdField_a_of_type_Int = 5;
      localGrayTipHighlightItemInfo.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localGrayTipHighlightItemInfo.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localGrayTipHighlightItemInfo.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localArrayList.add(localGrayTipHighlightItemInfo);
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localGrayTipHighlightItemInfo = new MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo();
      localGrayTipHighlightItemInfo.jdField_a_of_type_Int = 3;
      localGrayTipHighlightItemInfo.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localGrayTipHighlightItemInfo.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localGrayTipHighlightItemInfo.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localGrayTipHighlightItemInfo.jdField_d_of_type_JavaLangString = MutualMarkUtils.b(((Matcher)localObject).group(2));
      localArrayList.add(localGrayTipHighlightItemInfo);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localGrayTipHighlightItemInfo = new MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo();
      localGrayTipHighlightItemInfo.jdField_a_of_type_Int = 4;
      localGrayTipHighlightItemInfo.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localGrayTipHighlightItemInfo.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localGrayTipHighlightItemInfo.jdField_d_of_type_JavaLangString = MutualMarkUtils.b(((Matcher)localObject).group(1));
      localGrayTipHighlightItemInfo.jdField_d_of_type_JavaLangString = MutualMarkAlienationHelper.a(paramQQAppInterface, paramString, localGrayTipHighlightItemInfo.jdField_d_of_type_JavaLangString);
      localGrayTipHighlightItemInfo.jdField_c_of_type_JavaLangString = localGrayTipHighlightItemInfo.jdField_a_of_type_JavaLangString.replace(((Matcher)localObject).group(1), localGrayTipHighlightItemInfo.jdField_d_of_type_JavaLangString);
      localArrayList.add(localGrayTipHighlightItemInfo);
    }
    Collections.sort(localArrayList, new MutualMarkGrayTipsHelper.1());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localGrayTipHighlightItemInfo = (MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localGrayTipHighlightItemInfo.jdField_a_of_type_JavaLangString))
      {
        i = paramStringBuilder.indexOf(localGrayTipHighlightItemInfo.jdField_a_of_type_JavaLangString);
        int j = localGrayTipHighlightItemInfo.jdField_a_of_type_JavaLangString.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (localGrayTipHighlightItemInfo.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            if (localGrayTipHighlightItemInfo.jdField_c_of_type_JavaLangString == null) {
              localGrayTipHighlightItemInfo.jdField_c_of_type_JavaLangString = localGrayTipHighlightItemInfo.jdField_a_of_type_JavaLangString;
            }
            localGrayTipHighlightItemInfo.jdField_c_of_type_Int = i;
            localGrayTipHighlightItemInfo.jdField_d_of_type_Int = (localGrayTipHighlightItemInfo.jdField_c_of_type_JavaLangString.length() + i);
            paramStringBuilder.replace(i, j, localGrayTipHighlightItemInfo.jdField_c_of_type_JavaLangString);
            break;
            localGrayTipHighlightItemInfo.jdField_c_of_type_JavaLangString = MutualMarkConfigHelper.a(paramQQAppInterface, localGrayTipHighlightItemInfo.jdField_b_of_type_JavaLangString);
            continue;
            localGrayTipHighlightItemInfo.jdField_c_of_type_JavaLangString = MutualMarkConfigHelper.a(paramQQAppInterface, paramString, localGrayTipHighlightItemInfo.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    int i = 2097153;
    ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo localMutualMarkPushGrayTipInfo = paramExtSnsRelationChainChangePushInfo.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localMutualMarkPushGrayTipInfo + " onlinePush:" + paramPushMsg0x210C7Info.a);
    }
    int j;
    if ((localMutualMarkPushGrayTipInfo != null) && (localMutualMarkPushGrayTipInfo.a()))
    {
      j = 0;
      if (TextUtils.isEmpty(localMutualMarkPushGrayTipInfo.jdField_b_of_type_JavaLangString)) {
        break label203;
      }
      paramPushMsg0x210C7Info = localMutualMarkPushGrayTipInfo.jdField_b_of_type_JavaLangString;
      switch (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int)
      {
      default: 
        label168:
        i = 2097155;
      }
    }
    for (;;)
    {
      int k = a(localMutualMarkPushGrayTipInfo.jdField_a_of_type_Int);
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, localMutualMarkPushGrayTipInfo.jdField_a_of_type_JavaLangString, k, i, j, paramPushMsg0x210C7Info);
      return;
      label203:
      paramPushMsg0x210C7Info = paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString + "_" + paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int + "_" + paramPushMsg0x210C7Info.b + "_" + localMutualMarkPushGrayTipInfo.jdField_a_of_type_Long;
      break;
      j = a(paramExtSnsRelationChainChangePushInfo);
      continue;
      i = 2097154;
      continue;
      if ((paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null) || (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null)) {
        break label168;
      }
      if (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a() > paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a())
      {
        i = 2097154;
      }
      else
      {
        if (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a() >= paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a()) {
          break label168;
        }
        j = a(paramExtSnsRelationChainChangePushInfo);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", ContactUtils.m(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString));
    }
    localObject = new StringBuilder((String)localObject);
    MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, (String)localObject, 0, paramInt1, paramInt2, MessageCache.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localUniteGrayTipParam);
    localMessageForUniteGrayTip.tipParam.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt3 == 998)
    {
      localMessageForUniteGrayTip.caidanAnimUrl = paramExtSnsRelationChainChangePushInfo.a();
      localMessageForUniteGrayTip.caidanAnimUrl = MutualMarkUtils.b(localMessageForUniteGrayTip.caidanAnimUrl);
      localMessageForUniteGrayTip.caidanAnimUrl = MutualMarkAlienationHelper.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, localMessageForUniteGrayTip.caidanAnimUrl);
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localUniteGrayTipParam, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", MutualMarkUtils.a(paramExtSnsRelationChainChangePushInfo.a(), paramExtSnsRelationChainChangePushInfo.b()));
      paramInt1 = paramExtSnsRelationChainChangePushInfo.c();
      if (paramInt1 > 0) {
        localMessageForUniteGrayTip.saveExtInfoToExtStr("sub_level", String.valueOf(paramInt1));
      }
      MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, (String)localObject, localUniteGrayTipParam, paramString1);
      UniteGrayTipUtil.a(paramQQAppInterface, localMessageForUniteGrayTip);
      MutualMarkBusinessLogicHelper.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int);
      MutualMarkBusinessLogicHelper.a(paramQQAppInterface, localMessageForUniteGrayTip.frienduin, localMessageForUniteGrayTip.istroop);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramExtSnsRelationChainChangePushInfo.b();
        localMessageForUniteGrayTip.caidanAnimUrl = MutualMarkUtils.b(localMessageForUniteGrayTip.caidanAnimUrl);
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramExtSnsRelationChainChangePushInfo.c();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, UniteGrayTipParam paramUniteGrayTipParam, ArrayList<MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo)paramQQAppInterface.next();
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkGrayTipsHelper", 2, "handleHighlightInfo item=" + paramString);
        }
        switch (paramString.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
        case 5: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 11);
            paramArrayList.putString("key_action_DATA", paramString.jdField_c_of_type_JavaLangString);
            paramUniteGrayTipParam.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 2: 
        case 4: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramUniteGrayTipParam.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 3: 
          if ((!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString.jdField_d_of_type_JavaLangString)))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.jdField_d_of_type_JavaLangString);
            paramUniteGrayTipParam.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkGrayTipsHelper
 * JD-Core Version:    0.7.0.1
 */