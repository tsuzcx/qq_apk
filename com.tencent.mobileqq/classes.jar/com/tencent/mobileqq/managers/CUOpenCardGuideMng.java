package com.tencent.mobileqq.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingCustomDialogInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.manager.Manager;

public class CUOpenCardGuideMng
  implements Manager
{
  public static final String[] a = { "entry_setting", "entry_aio_video", "entry_file", "entry_chat_audio", "entry_chat_video", "entry_kandian_video" };
  private static CUOpenCardGuideMng.GuideConfigData c = null;
  final CUOpenCardGuideMng.GuideConfigData b;
  
  public CUOpenCardGuideMng(QQAppInterface paramQQAppInterface)
  {
    this.b = new CUOpenCardGuideMng.GuideConfigData(paramQQAppInterface.getAccount());
  }
  
  public static CharSequence a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      int j;
      try
      {
        localObject1 = (CUOpenCardGuideMng)paramQQAppInterface.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          if (!((CUOpenCardGuideMng)localObject1).a()) {
            break label334;
          }
          localObject1 = ((CUOpenCardGuideMng)localObject1).a(paramInt);
        }
        else
        {
          localObject1 = ((CUOpenCardGuideMng)localObject1).a(paramInt);
        }
        i = 0;
        j = i;
        localObject2 = paramString;
        if (localObject1 == null) {
          break label288;
        }
        j = i;
        localObject2 = paramString;
        try
        {
          if (TextUtils.isEmpty(((CUOpenCardGuideMng.GuideEntry)localObject1).a)) {
            break label288;
          }
          j = i;
          localObject2 = paramString;
          if (TextUtils.isEmpty(((CUOpenCardGuideMng.GuideEntry)localObject1).b)) {
            break label288;
          }
          j = i;
          localObject2 = paramString;
          if (!((CUOpenCardGuideMng.GuideEntry)localObject1).a.contains(((CUOpenCardGuideMng.GuideEntry)localObject1).b)) {
            break label288;
          }
          j = i;
          localObject2 = paramString;
          if (TextUtils.isEmpty(((CUOpenCardGuideMng.GuideEntry)localObject1).c)) {
            break label288;
          }
          String str = String.format("%s\n%s", new Object[] { paramString, ((CUOpenCardGuideMng.GuideEntry)localObject1).a });
          localObject2 = new SpannableString(str);
          j = str.indexOf(((CUOpenCardGuideMng.GuideEntry)localObject1).b);
          int k = ((CUOpenCardGuideMng.GuideEntry)localObject1).b.length();
          ((SpannableString)localObject2).setSpan(new CUOpenCardGuideMng.CUOpenCardClickableSpan(paramContext, ((CUOpenCardGuideMng.GuideEntry)localObject1).c, paramQQAppInterface.getCurrentUin(), paramInt), j, k + j, 17);
          j = i;
        }
        catch (Exception paramQQAppInterface) {}
        j = i;
      }
      catch (Exception paramQQAppInterface)
      {
        i = 0;
      }
      Object localObject2 = paramString;
      if (QLog.isColorLevel())
      {
        QLog.i("CUOpenCardGuideMng", 2, "getGuideEnty", paramQQAppInterface);
        j = i;
        localObject2 = paramString;
        break label288;
        j = 0;
        localObject2 = paramString;
      }
      label288:
      if (QLog.isColorLevel()) {
        QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d retCode: %d context: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext }));
      }
      return localObject2;
      label334:
      Object localObject1 = null;
      int i = 3;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    long l2 = 0L;
    long l1;
    Object localObject3;
    if (i != 1)
    {
      long l3 = SharedPreUtils.be(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
      long l4 = System.currentTimeMillis();
      CUKingCardHelper.CUKingCustomDialogInfo localCUKingCustomDialogInfo = CUKingCardHelper.a(paramString2, true, false);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("WL_DEBUG addCallGrayTip info.mPopUpType = ");
        paramString2.append(localCUKingCustomDialogInfo.a);
        paramString2.append(", info.mGuideJumpUrl = ");
        paramString2.append(localCUKingCustomDialogInfo.b);
        QLog.d("CUOpenCardGuideMng", 2, paramString2.toString());
      }
      paramString2 = (CUOpenCardGuideMng)paramQQAppInterface.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER);
      if (paramString2 != null)
      {
        if (paramBoolean) {
          paramString2 = paramString2.a(4);
        } else {
          paramString2 = paramString2.a(3);
        }
      }
      else {
        paramString2 = null;
      }
      l2 = l3;
      l1 = l4;
      localObject3 = paramString2;
      if (paramString2 != null)
      {
        l2 = l3;
        l1 = l4;
        localObject3 = paramString2;
        if (!TextUtils.isEmpty(paramString2.a))
        {
          l2 = l3;
          l1 = l4;
          localObject3 = paramString2;
          if (!TextUtils.isEmpty(paramString2.b))
          {
            l2 = l3;
            l1 = l4;
            localObject3 = paramString2;
            if (!TextUtils.isEmpty(localCUKingCustomDialogInfo.b))
            {
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("WL_DEBUG addCallGrayTip entry.tip = ");
                ((StringBuilder)localObject1).append(paramString2.a);
                ((StringBuilder)localObject1).append(", entry.keyWord = ");
                ((StringBuilder)localObject1).append(paramString2.b);
                QLog.d("CUOpenCardGuideMng", 2, ((StringBuilder)localObject1).toString());
              }
              Object localObject1 = paramString2.a.split("\\|");
              Object localObject2 = paramString2.b.split("\\|");
              if ((localObject1.length >= 2) && (localObject2.length >= 2))
              {
                if (localCUKingCustomDialogInfo.a == 2)
                {
                  localObject1 = localObject1[0];
                  localObject2 = localObject2[0];
                  break label399;
                }
                if (localCUKingCustomDialogInfo.a == 3)
                {
                  localObject1 = localObject1[1];
                  localObject2 = localObject2[1];
                  break label399;
                }
              }
              localObject1 = null;
              localObject2 = null;
              label399:
              l2 = l3;
              l1 = l4;
              localObject3 = paramString2;
              if (localObject1 != null)
              {
                l2 = l3;
                l1 = l4;
                localObject3 = paramString2;
                if (localObject2 != null)
                {
                  localObject3 = new Bundle();
                  ((Bundle)localObject3).putInt("key_action", 1);
                  ((Bundle)localObject3).putString("textColor", "#40A0FF");
                  ((Bundle)localObject3).putString("key_action_DATA", localCUKingCustomDialogInfo.b);
                  int j = ((String)localObject1).indexOf((String)localObject2);
                  int k = ((String)localObject2).length();
                  localObject1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentUin(), (String)localObject1, paramInt, -5020, 3145729, MessageCache.c());
                  localObject2 = new MessageForUniteGrayTip();
                  if (j >= 0) {
                    ((UniteGrayTipParam)localObject1).a(j, k + j, (Bundle)localObject3);
                  }
                  ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
                  UniteGrayTipMsgUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject2);
                  ReportController.b(null, "dc00898", "", "", "0X800812A", "0X800812A", 0, 0, "", "", "", "");
                  SharedPreUtils.b(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), System.currentTimeMillis());
                  l2 = l3;
                  l1 = l4;
                  localObject3 = paramString2;
                }
              }
            }
          }
        }
      }
    }
    else
    {
      l1 = 0L;
      localObject3 = null;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("addCallGrayTip, friendUin= ");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append(",isVideoMsg=");
      paramQQAppInterface.append(paramBoolean);
      paramQQAppInterface.append(",netType=");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(",uinType=");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface.append(",lastAlertTime=");
      paramQQAppInterface.append(l2);
      paramQQAppInterface.append(",currentTime=");
      paramQQAppInterface.append(l1);
      paramQQAppInterface.append(",entry=");
      paramQQAppInterface.append(localObject3);
      QLog.i("CUOpenCardGuideMng", 2, paramQQAppInterface.toString());
    }
  }
  
  public CUOpenCardGuideMng.GuideEntry a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d, isInit: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.b.c) }));
    }
    this.b.a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.b.e)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.b.f.length) {
          localObject1 = this.b.f[paramInt];
        }
      }
    }
    return localObject1;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "onGetConfig isInit: %b, config: %s", new Object[] { Boolean.valueOf(this.b.c), paramString }));
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChinaUnicomPhoneCard");
    localStringBuilder.append(this.b.a);
    paramString = paramString.getSharedPreferences(localStringBuilder.toString(), 4).edit();
    paramString.putString("config_content", str);
    paramString.commit();
    this.b.a(str);
  }
  
  public boolean a()
  {
    return this.b.c;
  }
  
  public void b()
  {
    this.b.a();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng
 * JD-Core Version:    0.7.0.1
 */