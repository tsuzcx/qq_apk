package com.tencent.mobileqq.doc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TencentDocGrayTipsUtils
{
  private static TencentDocEntryUtils.GrayTipsInfo a;
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 += 1L;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getAccount();
    a = TencentDocEntryUtils.a(paramQQAppInterface);
    int i = TencentDocGrayTipsPref.a(localBaseApplication, str);
    long l = TencentDocGrayTipsPref.b(localBaseApplication, str);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addGrayTipMsg friendUin = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", senderUin = ");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", uinType = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", selfUin = ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(", time = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(", msgseq = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(", msgUid = ");
      ((StringBuilder)localObject1).append(paramLong3);
      ((StringBuilder)localObject1).append(", times = ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", lastShowTime = ");
      ((StringBuilder)localObject1).append(l);
      QLog.d("TencentDocGrayTipsUtils", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool1;
    if (QQAudioHelper.b(10) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912137));
      ((StringBuilder)localObject1).append(a.b);
      QQAudioHelper.a(((StringBuilder)localObject1).toString());
      bool2 = TextUtils.isEmpty(a.b) ^ true;
    }
    if (((a.a) && (i < a.d) && (paramLong1 - l > 30L) && (!paramString2.equals(str))) || (bool2))
    {
      localObject1 = a.b;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(a.c);
      localObject2 = ((StringBuilder)localObject2).toString();
      paramString1 = new UniteGrayTipParam(paramString1, paramString2, (String)localObject2, paramInt, -5040, 3276801, paramLong1);
      paramString2 = new StringBuilder();
      paramString2.append(String.valueOf(paramLong2));
      paramString2.append("_");
      paramString2.append(String.valueOf(paramLong1));
      paramString1.p = paramString2.toString();
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("addGrayTipMsg grayTipParam.grayTipKey = ");
        paramString2.append(paramString1.p);
        QLog.d("TencentDocGrayTipsUtils", 2, paramString2.toString());
      }
      paramString2 = new Bundle();
      paramString2.putInt("key_action", 1);
      paramString2.putString("key_action_DATA", a.e);
      paramString1.a(((String)localObject1).length(), ((String)localObject2).length(), paramString2);
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
      if (UniteGrayTipMsgUtil.a(paramQQAppInterface, paramString2))
      {
        TencentDocGrayTipsPref.c(localBaseApplication, str, i + 1);
        TencentDocGrayTipsPref.c(localBaseApplication, str, paramLong1);
        TencentDocUtils.a("0X80094AA");
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (a == null) {
      a = TencentDocEntryUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
    if (paramString.equals(a.e)) {
      TencentDocUtils.a("0X80094AB");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocGrayTipsUtils
 * JD-Core Version:    0.7.0.1
 */