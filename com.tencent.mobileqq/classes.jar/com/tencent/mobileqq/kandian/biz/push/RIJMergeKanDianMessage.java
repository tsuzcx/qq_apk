package com.tencent.mobileqq.kandian.biz.push;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.handler.sp.RIJGetIndividualArticleSp;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJMergeKanDianMessage
{
  public static SimpleDateFormat a;
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
  }
  
  public static int a()
  {
    if (RIJQQAppInterfaceUtil.a() == null) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Object localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
        if (localObject1 == null) {
          return -1;
        }
        localObject1 = ((Conversation)localObject1).a().b();
        if (localObject1 == null) {
          return -1;
        }
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if (!(localObject2 instanceof RecentBaseData)) {
            continue;
          }
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          if (i < localArrayList.size())
          {
            localObject1 = (RecentBaseData)localArrayList.get(i);
            if (localObject1 != null)
            {
              boolean bool = TextUtils.equals(((RecentUserBaseData)localObject1).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN);
              if (bool) {
                return i;
              }
            }
            i += 1;
            continue;
          }
          return -1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      int i = 0;
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    int i = ((IRIJDisplayStyleManager)QRoute.api(IRIJDisplayStyleManager.class)).getRecentListReportVisibleItemCount();
    int k = i - 2;
    Object localObject1;
    int m;
    int j;
    int i1;
    if ((paramQQAppInterface != null) && (i > 0))
    {
      localObject1 = new ArrayList();
      Object localObject2;
      try
      {
        localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
        if (localObject2 == null)
        {
          QLog.d("RIJMergeKanDianMessage", 1, "conversation frame is null");
          return l1;
        }
        localObject2 = ((Conversation)localObject2).a().b();
        if (localObject2 == null) {
          return l1;
        }
        localObject2 = ((List)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if ((localObject3 instanceof RecentBaseData)) {
            ((List)localObject1).add((RecentBaseData)localObject3);
          }
        }
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentBaseData)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            localObject3 = (RecentUserBaseData)localObject3;
            if ((((RecentUserBaseData)localObject3).mUser != null) && (((RecentUserBaseData)localObject3).mUser.getType() == 1008) && (ServiceAccountFolderManager.b(paramQQAppInterface, ((RecentUserBaseData)localObject3).mUser.uin))) {
              ((Iterator)localObject2).remove();
            }
          }
        }
        m = ((List)localObject1).size();
        j = i;
        if (i > m) {
          j = m;
        }
        int n = 0;
        i = 0;
        for (;;)
        {
          i1 = j;
          i2 = i;
          m = k;
          if (n >= j) {
            break label460;
          }
          i1 = i;
          try
          {
            paramQQAppInterface = (RecentBaseData)((List)localObject1).get(n);
            i1 = i;
            i2 = k;
            if (paramQQAppInterface != null)
            {
              i1 = i;
              paramQQAppInterface = (RecentUserBaseData)paramQQAppInterface;
              m = i;
              i1 = i;
              if (paramQQAppInterface.mUnreadNum > 0) {
                m = 1;
              }
              i1 = m;
              boolean bool = TextUtils.equals(paramQQAppInterface.getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN);
              i1 = m;
              i2 = k;
              if (bool)
              {
                i2 = n;
                i1 = m;
              }
            }
            n += 1;
            i = i1;
            k = i2;
          }
          catch (Exception paramQQAppInterface) {}
        }
        localObject2 = new StringBuilder();
      }
      catch (Exception paramQQAppInterface)
      {
        i1 = 0;
        j = i;
      }
      ((StringBuilder)localObject2).append("failed to construct recent base ");
      ((StringBuilder)localObject2).append(paramQQAppInterface.toString());
      QLog.d("RIJMergeKanDianMessage", 1, ((StringBuilder)localObject2).toString());
      m = k;
      int i2 = i1;
      i1 = j;
      label460:
      if (i2 != 0)
      {
        i = 0;
        if (i >= i1) {
          break label843;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(i);
        if (paramQQAppInterface == null) {
          continue;
        }
        j = i;
        if (((RecentUserBaseData)paramQQAppInterface).mUser.showUpTime > 0L) {
          continue;
        }
        if (j >= m)
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("insert individual push time:");
          paramQQAppInterface.append(l1);
          QLog.d("RIJMergeKanDianMessage", 1, paramQQAppInterface.toString());
          return l1;
        }
        double d1 = Math.random();
        double d2 = m - j;
        Double.isNaN(d2);
        i = (int)(d1 * d2) + 1 + j;
        paramQQAppInterface = (RecentUserBaseData)((List)localObject1).get(i - 1);
        localObject1 = (RecentUserBaseData)((List)localObject1).get(i);
        long l2 = Math.max(paramQQAppInterface.mUser.lastmsgtime, paramQQAppInterface.mUser.lastmsgdrafttime);
        long l3 = Math.max(((RecentUserBaseData)localObject1).mUser.lastmsgtime, ((RecentUserBaseData)localObject1).mUser.lastmsgdrafttime);
        d1 = Math.random();
        d2 = l2 - l3;
        Double.isNaN(d2);
        l1 = l2 - (d1 * d2) - 1L;
      }
      catch (Exception localException)
      {
        continue;
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("failed to construct individual push time ");
      paramQQAppInterface.append(((Exception)localObject1).toString());
      QLog.d("RIJMergeKanDianMessage", 1, paramQQAppInterface.toString());
      continue;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("construct individual push first ");
      paramQQAppInterface.append(i1);
      paramQQAppInterface.append(" msg no red point");
      QLog.d("RIJMergeKanDianMessage", 1, paramQQAppInterface.toString());
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("insert individual push time:");
      paramQQAppInterface.append(l1);
      QLog.d("RIJMergeKanDianMessage", 1, paramQQAppInterface.toString());
      return l1;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("break insert individual push time:");
      paramQQAppInterface.append(l1);
      QLog.d("RIJMergeKanDianMessage", 1, paramQQAppInterface.toString());
      return l1;
      i += 1;
      break;
      label843:
      j = 0;
    }
  }
  
  public static String a(int paramInt)
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    int j = Math.max(10, ((IRIJDisplayStyleManager)QRoute.api(IRIJDisplayStyleManager.class)).getRecentListReportVisibleItemCount());
    if (localObject == null) {
      return "";
    }
    List localList = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IRIJDisplayStyleManager)QRoute.api(IRIJDisplayStyleManager.class)).getRecentListReportVisibleItemCount());
    localStringBuilder.append(":");
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    int i = localList.size();
    j += 0;
    if (j < i) {
      i = j;
    }
    ConversationFacade localConversationFacade = ((QQAppInterface)localObject).getConversationFacade();
    j = 0;
    while (j < i)
    {
      localObject = (RecentBaseData)localList.get(j);
      if (localObject != null)
      {
        RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)localObject;
        if ((localRecentUserBaseData.mUser != null) && ((localRecentUserBaseData.mUser.getType() == paramInt) || (paramInt == -1)))
        {
          int k = localConversationFacade.a(localRecentUserBaseData.getRecentUserUin(), localRecentUserBaseData.mUser.getType());
          if (localRecentUserBaseData.mUnreadFlag == 3) {
            k = 0;
          }
          if (localRecentUserBaseData.mUser.getType() == 1008) {
            localObject = "1";
          } else {
            localObject = "0";
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("_");
          localStringBuilder.append(localRecentUserBaseData.getRecentUserUin());
          localStringBuilder.append("_");
          localStringBuilder.append(k);
          if (j != i - 1) {
            localStringBuilder.append(":");
          }
        }
      }
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getScreenPaInfo : ");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject).toString());
    }
    return localStringBuilder.toString();
  }
  
  private static List<RecentBaseData> a()
  {
    localArrayList = new ArrayList();
    try
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
      Object localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null)
      {
        QLog.d("RIJMergeKanDianMessage", 1, "conversation frame is null");
        return localArrayList;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return localArrayList;
      }
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData)) {
          localArrayList.add((RecentBaseData)localObject2);
        }
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (RecentUserBaseData)localObject2;
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (ServiceAccountFolderManager.b(localQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin))) {
            ((Iterator)localObject1).remove();
          }
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      QLog.d("RIJMergeKanDianMessage", 2, localException.getMessage());
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.getMessageFacade();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).a();
      if ((localObject != null) && (((ConversationFacade)localObject).a(paramString, 1008) > 0)) {
        ThreadManager.post(new RIJMergeKanDianMessage.2(paramString, paramQQAppInterface), 8, null, false);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (!paramQQAppInterface.isread) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (!paramMessageRecord.mIsParsed) {
        paramMessageRecord.parse();
      }
      if (paramMessageRecord.structingMsg == null) {
        return true;
      }
      if (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mExtraData)) {
        try
        {
          int i = new JSONObject(paramMessageRecord.structingMsg.mExtraData).optInt("keyguard_jump", 1);
          return i == 1;
        }
        catch (JSONException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return true;
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (paramAbsStructMsg != null) && (paramAbsStructMsg.mMsgUrl != null) && (paramAbsStructMsg.mMsgUrl.contains("kandianshare.html5.qq.com"));
  }
  
  public static boolean a(String paramString)
  {
    Object localObject1 = new ArrayList();
    try
    {
      Object localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((Conversation)localObject2).a().b();
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof RecentBaseData)) {
          ((List)localObject1).add((RecentBaseData)localObject3);
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (RecentUserBaseData)localObject2;
          if (TextUtils.equals(((RecentUserBaseData)localObject2).getRecentUserUin(), paramString)) {
            return true;
          }
          int i = ((RecentUserBaseData)localObject2).mMenuFlag;
          if ((i & 0x20) == 0) {
            return false;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("failed to construct recent base ");
      ((StringBuilder)localObject1).append(paramString.toString());
      QLog.d("RIJMergeKanDianMessage", 1, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  public static int b()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData)) {
          localArrayList.add((RecentBaseData)localObject2);
        }
      }
      int m = Math.min(localArrayList.size(), ((IRIJDisplayStyleManager)QRoute.api(IRIJDisplayStyleManager.class)).getRecentListReportVisibleItemCount());
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        localObject1 = (RecentBaseData)localArrayList.get(i);
        k = j;
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          k = j;
          if (!TextUtils.equals(((RecentUserBaseData)localObject1).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN)) {
            if (((RecentUserBaseData)localObject1).getRecentUserType() == 5000)
            {
              k = j;
            }
            else
            {
              k = j;
              if (((RecentUserBaseData)localObject1).getUnreadNum() > 0)
              {
                k = ((RecentUserBaseData)localObject1).getUnreadNum();
                k = j + k;
              }
            }
          }
        }
        i += 1;
      }
      return j;
    }
    catch (Exception localException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("failed to construct recent base ");
      ((StringBuilder)localObject1).append(localException.toString());
      QLog.d("RIJMergeKanDianMessage", 1, ((StringBuilder)localObject1).toString());
    }
    return -1;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    int i = ((IRIJDisplayStyleManager)QRoute.api(IRIJDisplayStyleManager.class)).getRecentListReportVisibleItemCount();
    Object localObject1;
    if (paramQQAppInterface != null)
    {
      if (i <= 0) {
        return false;
      }
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      int j;
      try
      {
        Object localObject2 = RecentDataListManager.a().a;
        if (localObject2 != null) {
          ((List)localObject1).addAll((Collection)localObject2);
        }
        localObject2 = ((List)localObject1).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (RecentBaseData)((Iterator)localObject2).next();
          if (localObject3 == null) {
            continue;
          }
          localObject3 = (RecentUserBaseData)localObject3;
          if ((((RecentUserBaseData)localObject3).mUser == null) || (((RecentUserBaseData)localObject3).mUser.getType() != 1008) || (!ServiceAccountFolderManager.b(paramQQAppInterface, ((RecentUserBaseData)localObject3).mUser.uin))) {
            continue;
          }
          ((Iterator)localObject2).remove();
          continue;
        }
        j = ((List)localObject1).size();
        if (i <= j) {
          break label253;
        }
        i = j;
      }
      catch (Exception paramQQAppInterface)
      {
        boolean bool;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("failed to construct recent base ");
        ((StringBuilder)localObject1).append(paramQQAppInterface.toString());
        QLog.d("RIJMergeKanDianMessage", 1, ((StringBuilder)localObject1).toString());
      }
      if (j < i)
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(j);
        if (paramQQAppInterface != null)
        {
          bool = TextUtils.equals(((RecentUserBaseData)paramQQAppInterface).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN);
          if (bool) {
            return true;
          }
        }
        j += 1;
      }
      else
      {
        return false;
        label253:
        j = 0;
      }
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Boolean)
    {
      ThreadManager.executeOnSubThread(new RIJMergeKanDianMessage.1(paramQQAppInterface));
      jdField_a_of_type_Boolean = false;
    }
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof SplashActivity))
    {
      if (((SplashActivity)localObject).getCurrentTab() != FrameControllerUtil.a)
      {
        QLog.d("RIJMergeKanDianMessage", 1, "r:Not in conversationtab");
        return false;
      }
      if (!ReadInJoyHelper.c(paramQQAppInterface))
      {
        QLog.d("RIJMergeKanDianMessage", 1, "r:config false");
        return false;
      }
      if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), null, "qqsetting_kandian_key", true))
      {
        QLog.d("RIJMergeKanDianMessage", 1, "kandian push disabled");
        return false;
      }
      localObject = RIJGetIndividualArticleSp.a(paramQQAppInterface);
      String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
      int i = Calendar.getInstance().get(11);
      if ((!TextUtils.equals((CharSequence)localObject, str)) && (i >= 6))
      {
        if (!a(paramQQAppInterface))
        {
          QLog.d("RIJMergeKanDianMessage", 1, "r:true to get individual push");
          return true;
        }
        QLog.d("RIJMergeKanDianMessage", 1, "r:already has red point");
        return false;
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("r:hour:");
      paramQQAppInterface.append(i);
      QLog.d("RIJMergeKanDianMessage", 1, paramQQAppInterface.toString());
      return false;
    }
    QLog.d("RIJMergeKanDianMessage", 1, "r:top activity is not splash");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage
 * JD-Core Version:    0.7.0.1
 */