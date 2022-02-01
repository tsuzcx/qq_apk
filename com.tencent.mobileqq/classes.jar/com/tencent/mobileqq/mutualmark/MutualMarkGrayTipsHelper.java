package com.tencent.mobileqq.mutualmark;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return -5040;
        }
        return -5022;
      }
      return -5023;
    }
    return -5020;
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L)) {
      return MutualMarkUtils.b(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo)
  {
    long l1 = paramExtSnsRelationChainChangePushInfo.b();
    long l2 = paramExtSnsRelationChainChangePushInfo.c();
    if (l1 == 17L)
    {
      if (paramExtSnsRelationChainChangePushInfo.h()) {
        return 999;
      }
      return 0;
    }
    if (paramExtSnsRelationChainChangePushInfo.h()) {
      return 999;
    }
    if (paramExtSnsRelationChainChangePushInfo.i()) {
      return 998;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo> a(AppInterface paramAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    int i;
    MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo localGrayTipHighlightItemInfo;
    for (;;)
    {
      boolean bool = ((Matcher)localObject).find();
      i = 2;
      if (!bool) {
        break;
      }
      localGrayTipHighlightItemInfo = new MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo();
      localGrayTipHighlightItemInfo.b = ((Matcher)localObject).group();
      localGrayTipHighlightItemInfo.c = ((Matcher)localObject).start();
      localGrayTipHighlightItemInfo.d = ((Matcher)localObject).group(2);
      if (!localGrayTipHighlightItemInfo.a()) {
        i = 1;
      }
      localGrayTipHighlightItemInfo.a = i;
      localArrayList.add(localGrayTipHighlightItemInfo);
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localGrayTipHighlightItemInfo = new MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo();
      localGrayTipHighlightItemInfo.a = 5;
      localGrayTipHighlightItemInfo.b = ((Matcher)localObject).group();
      localGrayTipHighlightItemInfo.c = ((Matcher)localObject).start();
      localGrayTipHighlightItemInfo.g = ((Matcher)localObject).group(1);
      localArrayList.add(localGrayTipHighlightItemInfo);
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localGrayTipHighlightItemInfo = new MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo();
      localGrayTipHighlightItemInfo.a = 3;
      localGrayTipHighlightItemInfo.b = ((Matcher)localObject).group();
      localGrayTipHighlightItemInfo.c = ((Matcher)localObject).start();
      localGrayTipHighlightItemInfo.g = ((Matcher)localObject).group(1);
      localGrayTipHighlightItemInfo.h = MutualMarkUtils.g(((Matcher)localObject).group(2));
      localArrayList.add(localGrayTipHighlightItemInfo);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localGrayTipHighlightItemInfo = new MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo();
      localGrayTipHighlightItemInfo.a = 4;
      localGrayTipHighlightItemInfo.b = ((Matcher)localObject).group();
      localGrayTipHighlightItemInfo.c = ((Matcher)localObject).start();
      localGrayTipHighlightItemInfo.h = MutualMarkUtils.g(((Matcher)localObject).group(1));
      localGrayTipHighlightItemInfo.h = MutualMarkAlienationHelper.a(paramAppInterface, paramString, localGrayTipHighlightItemInfo.h);
      localGrayTipHighlightItemInfo.g = localGrayTipHighlightItemInfo.b.replace(((Matcher)localObject).group(1), localGrayTipHighlightItemInfo.h);
      localArrayList.add(localGrayTipHighlightItemInfo);
    }
    Collections.sort(localArrayList, new MutualMarkGrayTipsHelper.1());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localGrayTipHighlightItemInfo = (MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localGrayTipHighlightItemInfo.b))
      {
        i = paramStringBuilder.indexOf(localGrayTipHighlightItemInfo.b);
        int j = localGrayTipHighlightItemInfo.b.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          int k = localGrayTipHighlightItemInfo.a;
          if (k != 1)
          {
            if (k == 2) {
              localGrayTipHighlightItemInfo.g = MutualMarkConfigHelper.a(paramAppInterface, paramString, localGrayTipHighlightItemInfo.d);
            }
          }
          else {
            localGrayTipHighlightItemInfo.g = MutualMarkConfigHelper.a(paramAppInterface, localGrayTipHighlightItemInfo.d);
          }
          if (localGrayTipHighlightItemInfo.g == null) {
            localGrayTipHighlightItemInfo.g = localGrayTipHighlightItemInfo.b;
          }
          localGrayTipHighlightItemInfo.e = i;
          localGrayTipHighlightItemInfo.f = (localGrayTipHighlightItemInfo.g.length() + i);
          paramStringBuilder.replace(i, j, localGrayTipHighlightItemInfo.g);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo localMutualMarkPushGrayTipInfo = paramExtSnsRelationChainChangePushInfo.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndInsertGrayTips grayInfo:");
      localStringBuilder.append(localMutualMarkPushGrayTipInfo);
      localStringBuilder.append(" onlinePush:");
      localStringBuilder.append(paramPushMsg0x210C7Info.f);
      QLog.i("MutualMarkGrayTipsHelper", 2, localStringBuilder.toString());
    }
    if ((localMutualMarkPushGrayTipInfo != null) && (localMutualMarkPushGrayTipInfo.a()))
    {
      if (!TextUtils.isEmpty(localMutualMarkPushGrayTipInfo.c))
      {
        paramPushMsg0x210C7Info = localMutualMarkPushGrayTipInfo.c;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramExtSnsRelationChainChangePushInfo.b);
        localStringBuilder.append("_");
        localStringBuilder.append(paramExtSnsRelationChainChangePushInfo.c);
        localStringBuilder.append("_");
        localStringBuilder.append(paramPushMsg0x210C7Info.b);
        localStringBuilder.append("_");
        localStringBuilder.append(localMutualMarkPushGrayTipInfo.b);
        paramPushMsg0x210C7Info = localStringBuilder.toString();
      }
      int i = paramExtSnsRelationChainChangePushInfo.c;
      if (i != 1)
      {
        if (i != 2) {
          if (i != 3)
          {
            if (i == 11000) {
              break label332;
            }
            if (i == 11001) {
              break label325;
            }
          }
        }
        switch (i)
        {
        default: 
          break;
          if ((paramExtSnsRelationChainChangePushInfo.e != null) && (paramExtSnsRelationChainChangePushInfo.f != null))
          {
            if (paramExtSnsRelationChainChangePushInfo.e.a() > paramExtSnsRelationChainChangePushInfo.f.a()) {
              break label325;
            }
            if (paramExtSnsRelationChainChangePushInfo.e.a() < paramExtSnsRelationChainChangePushInfo.f.a()) {
              i = a(paramExtSnsRelationChainChangePushInfo);
            }
          }
          break;
        case 10003: 
          label325:
          for (i = 2097155;; i = 2097154)
          {
            j = 0;
            break;
          }
        }
      }
      label332:
      i = a(paramExtSnsRelationChainChangePushInfo);
      int k = 2097153;
      int j = i;
      i = k;
      k = a(localMutualMarkPushGrayTipInfo.d);
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, localMutualMarkPushGrayTipInfo.a, k, i, j, paramPushMsg0x210C7Info);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    Object localObject1 = paramString1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("insertGrayTips friendUin:");
      ((StringBuilder)localObject2).append(paramExtSnsRelationChainChangePushInfo.b);
      ((StringBuilder)localObject2).append(" grayType:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" grayID:");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" subType:");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append(" grayTipKey:");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" _grayTipTemplate:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("MutualMarkGrayTipsHelper", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = (String)localObject1;
    if (((String)localObject1).contains("#nick")) {
      paramString1 = ((String)localObject1).replaceAll("#nick", ContactUtils.g(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.b));
    }
    localObject1 = new StringBuilder(paramString1);
    MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, (StringBuilder)localObject1);
    paramString1 = a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.b, (StringBuilder)localObject1);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new UniteGrayTipParam(paramExtSnsRelationChainChangePushInfo.b, paramExtSnsRelationChainChangePushInfo.b, (String)localObject1, 0, paramInt1, paramInt2, MessageCache.c());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject2);
    localMessageForUniteGrayTip.tipParam.p = paramString2;
    if (paramInt3 == 998)
    {
      localMessageForUniteGrayTip.caidanAnimUrl = paramExtSnsRelationChainChangePushInfo.e();
      localMessageForUniteGrayTip.caidanAnimUrl = MutualMarkUtils.g(localMessageForUniteGrayTip.caidanAnimUrl);
      localMessageForUniteGrayTip.caidanAnimUrl = MutualMarkAlienationHelper.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.b, localMessageForUniteGrayTip.caidanAnimUrl);
    }
    else if (paramInt3 == 999)
    {
      localMessageForUniteGrayTip.caidanAnimUrl = paramExtSnsRelationChainChangePushInfo.f();
      localMessageForUniteGrayTip.caidanAnimUrl = MutualMarkUtils.g(localMessageForUniteGrayTip.caidanAnimUrl);
      localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramExtSnsRelationChainChangePushInfo.g();
    }
    a((UniteGrayTipParam)localObject2, paramString1);
    localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", MutualMarkUtils.a(paramExtSnsRelationChainChangePushInfo.b(), paramExtSnsRelationChainChangePushInfo.c()));
    paramInt1 = paramExtSnsRelationChainChangePushInfo.d();
    if (paramInt1 > 0) {
      localMessageForUniteGrayTip.saveExtInfoToExtStr("sub_level", String.valueOf(paramInt1));
    }
    MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, (String)localObject1, (UniteGrayTipParam)localObject2, paramString1);
    UniteGrayTipMsgUtil.a(paramQQAppInterface, localMessageForUniteGrayTip);
    MutualMarkBusinessLogicHelper.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.i);
    MutualMarkBusinessLogicHelper.a(paramQQAppInterface, localMessageForUniteGrayTip.frienduin, localMessageForUniteGrayTip.istroop);
  }
  
  public static void a(UniteGrayTipParam paramUniteGrayTipParam, ArrayList<MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo localGrayTipHighlightItemInfo = (MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo)paramArrayList.next();
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleHighlightInfo item=");
          ((StringBuilder)localObject).append(localGrayTipHighlightItemInfo);
          QLog.d("MutualMarkGrayTipsHelper", 2, ((StringBuilder)localObject).toString());
        }
        int i = localGrayTipHighlightItemInfo.a;
        if (i != 1)
        {
          if (i != 2) {
            if (i != 3)
            {
              if (i != 4) {
                if (i == 5) {
                  break label226;
                }
              }
            }
            else
            {
              if ((TextUtils.isEmpty(localGrayTipHighlightItemInfo.g)) || (TextUtils.isEmpty(localGrayTipHighlightItemInfo.h))) {
                continue;
              }
              localObject = new Bundle();
              ((Bundle)localObject).putInt("key_action", 1);
              ((Bundle)localObject).putString("key_action_DATA", localGrayTipHighlightItemInfo.h);
              paramUniteGrayTipParam.a(localGrayTipHighlightItemInfo.e, localGrayTipHighlightItemInfo.f, (Bundle)localObject);
              continue;
            }
          }
          if (TextUtils.isEmpty(localGrayTipHighlightItemInfo.g)) {
            continue;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("image_resource", localGrayTipHighlightItemInfo.g);
          paramUniteGrayTipParam.a(localGrayTipHighlightItemInfo.e, localGrayTipHighlightItemInfo.f, (Bundle)localObject);
          continue;
        }
        label226:
        if (!TextUtils.isEmpty(localGrayTipHighlightItemInfo.g))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("key_action", 11);
          ((Bundle)localObject).putString("key_action_DATA", localGrayTipHighlightItemInfo.g);
          paramUniteGrayTipParam.a(localGrayTipHighlightItemInfo.e, localGrayTipHighlightItemInfo.f, (Bundle)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkGrayTipsHelper
 * JD-Core Version:    0.7.0.1
 */