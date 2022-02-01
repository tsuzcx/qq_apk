package com.tencent.mobileqq.graytip;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import mqq.manager.Manager;

public class CustomizeGrayTipsManager
  implements Manager
{
  private QQAppInterface a;
  private int b;
  private String c;
  private int d;
  
  public CustomizeGrayTipsManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface = Integer.valueOf(0);
    this.b = ((Integer)SharedPreUtils.c("gray_tips_wording_id", paramQQAppInterface)).intValue();
    this.c = ((String)SharedPreUtils.c("add_guide_gray_tips_time", ""));
    this.d = ((Integer)SharedPreUtils.c("add_guide_gray_tips_times", paramQQAppInterface)).intValue();
  }
  
  @NonNull
  private MessageForUniteGrayTip a(@NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("makeGuideCustomizeGrayTips, friendUin = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", senderUin = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", uinType = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", time = ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", shMsgSeq = ");
    ((StringBuilder)localObject).append(paramLong2);
    QLog.d("CustomizeGrayTipsManager", 1, ((StringBuilder)localObject).toString());
    localObject = HardCodeUtil.a(2131888295);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(HardCodeUtil.a(2131888294));
    paramString1 = new UniteGrayTipParam(paramString1, paramString2, localStringBuilder.toString(), paramInt, -5020, 3, paramLong1);
    paramString1.m = true;
    paramString2 = new Bundle();
    paramString2.putInt("key_action", 56);
    paramString1.a(0, ((String)localObject).length(), paramString2);
    paramString2 = new MessageForUniteGrayTip();
    paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
    paramString2.shmsgseq = paramLong2;
    return paramString2;
  }
  
  private void a(@NonNull QQAppInterface paramQQAppInterface, int paramInt, List<MessageRecord> paramList, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    b();
    MessageForUniteGrayTip localMessageForUniteGrayTip = a(paramQQAppInterface, paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.senderuin, paramInt, paramMessageForUniteGrayTip.time, paramMessageForUniteGrayTip.shmsgseq);
    paramQQAppInterface.getMessageFacade().a(paramInt).a(paramInt, paramMessageForUniteGrayTip.frienduin, localMessageForUniteGrayTip, paramList);
    UniteGrayTipMsgUtil.a(paramQQAppInterface, localMessageForUniteGrayTip);
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeGrayTipsManager", 2, "insert guide customize gray tips to aioList and db");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext instanceof ChatHistoryActivity)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (TextUtils.equals("1", paramString))
    {
      paramContext.startActivity(new Intent(paramContext, QQSettingSettingActivity.class));
      PublicFragmentActivity.a(paramContext, new Intent(), AssistantSettingFragment.class);
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://zb.vip.qq.com/v2/pages/withdrawMessage?_wv=2&dwop_via=");
      localStringBuilder.append(paramString);
      paramQQAppInterface.putExtra("url", localStringBuilder.toString());
      paramContext.startActivity(paramQQAppInterface);
      c(paramInt);
      return;
    }
    if (TextUtils.equals("2", paramString))
    {
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://zb.vip.qq.com/v2/pages/withdrawMessage?_wv=2&dwop_via=");
      localStringBuilder.append(paramString);
      paramQQAppInterface.putExtra("url", localStringBuilder.toString());
      paramContext.startActivity(paramQQAppInterface);
      d();
    }
  }
  
  private boolean a()
  {
    String str;
    if ((this.b == 0) && (this.d < 3)) {
      str = c();
    }
    return !TextUtils.equals(this.c, str);
  }
  
  private boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    return (paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.i == 1) && (!AnonymousChatHelper.c(paramMessageForUniteGrayTip)) && (TextUtils.equals(String.valueOf(0), paramMessageForUniteGrayTip.getExtInfoFromExtStr("revoke_op_type")));
  }
  
  private <T extends MessageRecord> boolean a(@NonNull List<T> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      if ((localObject instanceof MessageForUniteGrayTip))
      {
        localObject = ((MessageForUniteGrayTip)localObject).tipParam;
        if ((localObject != null) && (((UniteGrayTipParam)localObject).i == 3)) {
          return true;
        }
      }
    }
    return false;
  }
  
  @Nullable
  private <T extends MessageRecord> MessageForUniteGrayTip b(@NonNull List<T> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      Object localObject = (MessageRecord)paramList.get(i);
      if ((localObject instanceof MessageForUniteGrayTip))
      {
        localObject = (MessageForUniteGrayTip)localObject;
        if (a((MessageForUniteGrayTip)localObject)) {
          return localObject;
        }
      }
      i -= 1;
    }
    return null;
  }
  
  private void b()
  {
    this.d += 1;
    this.c = c();
    SharedPreUtils.a("add_guide_gray_tips_time", this.c);
    SharedPreUtils.a("add_guide_gray_tips_times", Integer.valueOf(this.d));
  }
  
  static void b(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B1FC", "0X800B1FC", d(paramInt), 0, "", "", "", "");
  }
  
  private String c()
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(j + 1);
    ((StringBuilder)localObject).append(k);
    return ((StringBuilder)localObject).toString();
  }
  
  private static void c(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B25A", "0X800B25A", d(paramInt), 0, "", "", "", "");
  }
  
  private static int d(int paramInt)
  {
    int i = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 10;
      }
      i = 2;
    }
    return i;
  }
  
  private static void d()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B25B", "0X800B25B", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    SharedPreUtils.a("gray_tips_wording_id", Integer.valueOf(paramInt));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGrayTipsWordingId, id = ");
      localStringBuilder.append(paramInt);
      QLog.d("CustomizeGrayTipsManager", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(@NonNull QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertGuideCustomizeGrayTipsIfNeed: uinType = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", mGrayTipsWordingId = ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", mAddGuideGrayTipsTimes = ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", mAddGuideGrayTipsDate = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("CustomizeGrayTipsManager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramInt == 3000) {
      return false;
    }
    if (!a())
    {
      if (QLog.isColorLevel())
      {
        QLog.d("CustomizeGrayTipsManager", 2, "do not need to insert guide customize gray tips to aioList");
        return false;
      }
    }
    else
    {
      localObject = paramQQAppInterface.getMessageProxy(paramInt).i(paramString, paramInt);
      paramString = paramQQAppInterface.getMessageProxy(paramInt).a().a(paramString, paramInt);
      paramString.lock();
    }
    try
    {
      if (ListUtils.a((Collection)localObject))
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CustomizeGrayTipsManager", 2, "aioList is empty");
          bool1 = bool2;
        }
      }
      else
      {
        MessageForUniteGrayTip localMessageForUniteGrayTip = b((List)localObject);
        if (localMessageForUniteGrayTip == null)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("CustomizeGrayTipsManager", 2, "aioList do not contains revoke gray tip");
            bool1 = bool2;
          }
        }
        else if (a((List)localObject))
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("CustomizeGrayTipsManager", 2, "aioList contains GuideCustomizeGrayTips");
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = true;
          a(paramQQAppInterface, paramInt, (List)localObject, localMessageForUniteGrayTip);
        }
      }
      return bool1;
    }
    finally
    {
      paramString.unlock();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.CustomizeGrayTipsManager
 * JD-Core Version:    0.7.0.1
 */