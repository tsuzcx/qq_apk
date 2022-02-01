package com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class RIJMsgBoxUtils
{
  private static Integer a;
  
  public static int a()
  {
    a = null;
    return b();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, false);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    a(paramContext, paramInt, paramBoolean, "");
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject1 = (KandianMergeManager)RIJQQAppInterfaceUtil.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    int i = ((KandianMergeManager)localObject1).c();
    localObject1 = ((KandianMergeManager)localObject1).a();
    String str;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl);
      ((StringBuilder)localObject2).append("&privateLetters=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("&message_entry=");
      ((StringBuilder)localObject2).append(paramInt);
      str = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ViolaAccessHelper.a(RIJQQAppInterfaceUtil.a()));
      ((StringBuilder)localObject1).append("&adtag=2&privateLetters=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("&message_entry=");
      ((StringBuilder)localObject1).append(paramInt);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ReadInJoyConstants.h);
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("&message_entry=");
      ((StringBuilder)localObject1).append(paramInt);
      str = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ViolaAccessHelper.a(RIJQQAppInterfaceUtil.a()));
      ((StringBuilder)localObject1).append("&adtag=1&privateLetters=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("&message_entry=");
      ((StringBuilder)localObject1).append(paramInt);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = localObject1;
    if (paramBoolean)
    {
      i = DisplayUtil.b(paramContext, (float)DeviceInfoUtil.l()) / 3;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&v_present_radius=10&v_present=2&v_rij_floating=1&v_present_bar=0&v_nav_immer=1&hideNav=1&v_present_auto_top=0&v_present_top=");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&msgId=");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramBoolean = QLog.isColorLevel();
    i = 2;
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("person message box url: ");
      paramString.append(str);
      QLog.d("RIJMsgBoxUtils", 2, paramString.toString());
    }
    if (Boolean.valueOf(ReadInJoyHelper.x(RIJQQAppInterfaceUtil.a())).booleanValue())
    {
      paramString = new Bundle();
      if (paramInt == 6) {
        paramInt = i;
      } else if (paramInt == 5) {
        paramInt = 3;
      } else {
        paramInt = -1;
      }
      if (paramInt != -1) {
        paramString.putInt("floating_window_scene", paramInt);
      }
      paramString.putInt("requestCode", 20001);
      ViolaAccessHelper.a(paramContext, HardCodeUtil.a(2131713042), (String)localObject1, paramString);
      return;
    }
    paramString = new Bundle();
    paramString.putInt("requestCode", 20001);
    RIJJumpUtils.a(paramContext, str, paramString);
  }
  
  public static int b()
  {
    if (a == null)
    {
      a = Integer.valueOf(Aladdin.getConfig(215).getIntegerFromString("message_reddot_style", 1));
      if ((!RIJShowKanDianTabSp.c()) && (a.intValue() == 0)) {
        a = Integer.valueOf(1);
      }
      int j = a.intValue();
      int i = 2;
      if ((j == 2) && (RIJQQAppInterfaceUtil.a() != null))
      {
        Object localObject = ((KandianMergeManager)RIJQQAppInterfaceUtil.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
        if ((localObject != null) && (((KandianMsgBoxRedPntInfo)localObject).dataType != 1)) {
          a = Integer.valueOf(1);
        } else {
          i = 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init msgboxUIMode : ");
        ((StringBuilder)localObject).append(a);
        ((StringBuilder)localObject).append(", rule : ");
        ((StringBuilder)localObject).append(i);
        QLog.d("RIJMsgBoxUtils", 1, ((StringBuilder)localObject).toString());
      }
    }
    return a.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils
 * JD-Core Version:    0.7.0.1
 */