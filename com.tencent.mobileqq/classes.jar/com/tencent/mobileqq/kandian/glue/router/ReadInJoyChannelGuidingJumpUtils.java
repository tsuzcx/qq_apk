package com.tencent.mobileqq.kandian.glue.router;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyChannelGuidingJumpUtils
{
  public static boolean a(int paramInt)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if ((localObject != null) && (((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine() != null))
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          localObject = ((List)localObject).iterator();
        }
        while (((Iterator)localObject).hasNext()) {
          if (paramInt == ((TabChannelCoverInfo)((Iterator)localObject).next()).mChannelCoverId)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[isInMyChannelList] res = true, channelID = ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, ((StringBuilder)localObject).toString());
            return true;
            QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[isInMyChannelList] res = false, myChannelList is empty.");
            return false;
          }
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isInMyChannelList] res = false, channelID = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true);
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[jumpToChannel], scheme = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, ((StringBuilder)localObject1).toString());
      Object localObject3 = Uri.parse(paramString);
      Object localObject2 = ((Uri)localObject3).getQueryParameter("target");
      localObject1 = ((Uri)localObject3).getQueryParameter("channelid");
      String str = ((Uri)localObject3).getQueryParameter("ispush");
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[jumpToChannel], target = ");
      localStringBuilder1.append((String)localObject2);
      localStringBuilder1.append(", channelID = ");
      localStringBuilder1.append((String)localObject1);
      localStringBuilder1.append(", isPush = ");
      localStringBuilder1.append(str);
      localStringBuilder1.append(",doDynamicOrder = ");
      localStringBuilder1.append(paramBoolean);
      QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, localStringBuilder1.toString());
      int i = -1;
      try
      {
        int j = Integer.parseInt((String)localObject1);
        i = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[jumpToChannel], e = ");
        localStringBuilder2.append(localNumberFormatException);
        QLog.e("ReadInJoyChannelGuidingJumpUtils", 1, localStringBuilder2.toString());
      }
      localObject3 = ((Uri)localObject3).getQueryParameter("v_url_base64");
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ReadInJoyViolaChannelFragment.a(i, (String)localObject3);
      }
      if (("2".equals(localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (ReadInJoyDailyJumpToKDTabUtils.a(paramContext, paramString))
        {
          QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel], jump to recommend channel, using floating window.");
          return true;
        }
        if (paramBoolean)
        {
          paramBoolean = ReadInJoyHelper.z();
          if ((paramBoolean) && (b(i)))
          {
            if (!c(i))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[jumpToChannel] channelID = ");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(" not my channel");
              QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, ((StringBuilder)localObject2).toString());
              ReadInJoyLogicEngine.a().c(i, 1);
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[jumpToChannel] channelID = ");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(" is my channel");
              QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, ((StringBuilder)localObject2).toString());
              ReadInJoyLogicEngine.a().a(i, 1, false, true);
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[jumpToChannel] isDynamicOrderSwitchOn = ");
            ((StringBuilder)localObject2).append(paramBoolean);
            ((StringBuilder)localObject2).append(", channelID = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("ReadInJoyChannelGuidingJumpUtils", 1, ((StringBuilder)localObject2).toString());
          }
        }
        if (a(str, i))
        {
          RIJJumpUtils.a(paramContext, paramString, null);
          return true;
        }
        paramContext.startActivity(((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramContext, 0, i));
        return true;
      }
      paramContext = new StringBuilder();
      paramContext.append("[jumpToChannel] failed, target = ");
      paramContext.append((String)localObject2);
      paramContext.append(", scheme = ");
      paramContext.append(paramString);
      QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, paramContext.toString());
      return false;
    }
    QLog.d("ReadInJoyChannelGuidingJumpUtils", 1, "context or scheme is null");
    return false;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    boolean bool3 = TextUtils.equals(paramString, "1");
    boolean bool4 = RIJShowKanDianTabSp.c();
    boolean bool5 = a(paramInt);
    paramString = new StringBuilder();
    paramString.append("[shouldPushNewPage, isPushBoolean = ");
    paramString.append(bool3);
    paramString.append(", KDTab = ");
    paramString.append(bool4);
    paramString.append(", isInMyChannel = ");
    paramString.append(bool5);
    paramString.append(", channelID = ");
    paramString.append(paramInt);
    paramString = paramString.toString();
    boolean bool2 = true;
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, paramString);
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (bool4)
      {
        if (!bool5) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private static boolean b(int paramInt)
  {
    List localList = ReadInJoyLogicEngine.a().a();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        ChannelSection localChannelSection = (ChannelSection)localList.get(i);
        int j = 0;
        while (j < localChannelSection.a.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localChannelSection.a.get(j)).mChannelCoverId) {
            return true;
          }
          j += 1;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static boolean c(int paramInt)
  {
    Object localObject = ReadInJoyLogicEngine.a().a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ChannelSection)((List)localObject).get(0);
      int i = 0;
      while (i < ((ChannelSection)localObject).a.size())
      {
        if (paramInt == ((TabChannelCoverInfo)((ChannelSection)localObject).a.get(i)).mChannelCoverId) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.ReadInJoyChannelGuidingJumpUtils
 * JD-Core Version:    0.7.0.1
 */