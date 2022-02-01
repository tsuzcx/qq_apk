package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.core.ExtractMessageSummaryCallback;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public class MsgUtils
{
  private static long a;
  private static long b;
  private static int c;
  private static float d;
  private static float e;
  private static float f;
  
  private static int a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (paramMessage == null) {
      return 0;
    }
    int i = paramQQAppInterface.getFileManagerRSCenter().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop, -1L);
    if (i != -1) {
      return i;
    }
    Object localObject = paramQQAppInterface.getFileManagerDataCenter().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (localObject != null)
    {
      if (((FileManagerEntity)localObject).fProgress == 1.0D) {
        return 1;
      }
      if ((((FileManagerEntity)localObject).status == 0) && (!((FileManagerEntity)localObject).isSend())) {
        return 1;
      }
      if ((((FileManagerEntity)localObject).status == 16) && (((FileManagerEntity)localObject).bSend) && (!((FileManagerEntity)localObject).bOnceSuccess)) {
        return 0;
      }
      return ((FileManagerEntity)localObject).status;
    }
    localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface = (TransFileInfo)((EntityManager)localObject).find(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessage.frienduin });
    ((EntityManager)localObject).close();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = FileManagerUtil.d(paramQQAppInterface.status);
    if (paramQQAppInterface.status == 2) {
      paramQQAppInterface.status = 0;
    }
    return paramQQAppInterface.status;
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue))) {
      return paramMessage.actMsgContentValue;
    }
    paramContext = paramQQAppInterface.getMsgHandler().d(AppShareIDUtil.a(paramMessage.shareAppID));
    if ((paramContext != null) && (paramContext.messagetail != null) && (!"".equals(paramContext.messagetail)))
    {
      paramMessage = new StringBuilder();
      paramMessage.append(paramQQAppInterface.getApp().getString(2131886916));
      paramMessage.append(paramContext.messagetail);
      paramMessage.append(paramQQAppInterface.getApp().getString(2131886917));
      return paramMessage.toString();
    }
    return paramQQAppInterface.getApp().getString(2131886914);
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, Message paramMessage)
  {
    String str1;
    if (SystemMsg.isSystemMessage(paramMessage.msgtype))
    {
      str1 = null;
      int i = paramMessage.msgtype;
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          paramContext = str1;
        }
        break;
      case -1007: 
        paramContext = paramContext.getString(2131886134);
        break;
      case -1008: 
        paramContext = paramContext.getString(2131886133);
        break;
      case -1009: 
        paramContext = paramContext.getString(2131915656);
        break;
      case -1010: 
        paramContext = paramContext.getString(2131886270);
        break;
      case -1011: 
      case -1006: 
        paramContext = paramContext.getString(2131886233);
      }
      String str2 = TroopSystemMsgUtil.a(paramString);
      str1 = paramString;
      if (str2 != null)
      {
        str1 = paramString;
        if (!"".equals(str2.trim()))
        {
          str1 = paramString;
          if (paramString.indexOf(str2) == 1)
          {
            paramQQAppInterface = ContactUtils.a(paramQQAppInterface, paramMessage.senderuin, true);
            if ((paramQQAppInterface != null) && (paramQQAppInterface.trim().length() > 0) && (!paramQQAppInterface.equals(paramMessage.senderuin)))
            {
              paramString = new StringBuilder();
              paramString.append(paramQQAppInterface);
              paramString.append(paramContext);
              return paramString.toString();
            }
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(paramMessage.senderuin);
            paramQQAppInterface.append(paramContext);
            return paramQQAppInterface.toString();
          }
        }
      }
    }
    else
    {
      str1 = paramString;
      if (SystemMsg.isTroopSystemMessage(paramMessage.msgtype)) {
        if ((paramMessage.msgtype != -1020) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != -1023) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46))
        {
          if (paramMessage.msgtype != -1021)
          {
            str1 = paramString;
            if (paramMessage.msgtype != -1022) {}
          }
          else
          {
            paramString = TroopSystemMsgUtil.a(paramString, paramQQAppInterface);
            paramMessage = TroopSystemMsgUtil.b(paramString);
            paramContext = paramString;
            if (paramMessage != null)
            {
              paramContext = paramString;
              if (!"".equals(paramMessage.trim()))
              {
                paramContext = paramString;
                if (paramString.indexOf(paramMessage) == 1)
                {
                  paramQQAppInterface = ContactUtils.a(paramQQAppInterface, paramMessage, true);
                  paramContext = paramString;
                  if (paramQQAppInterface != "")
                  {
                    paramContext = paramString;
                    if (!paramQQAppInterface.equals("")) {
                      paramContext = TroopSystemMsgUtil.a(paramString, paramMessage, paramQQAppInterface);
                    }
                  }
                }
              }
            }
            return paramContext;
          }
        }
        else
        {
          paramContext = TroopSystemMsgUtil.b(paramString);
          str1 = paramString;
          if (paramContext != null)
          {
            str1 = paramString;
            if (!"".equals(paramContext.trim()))
            {
              str1 = paramString;
              if (paramString.indexOf(paramContext) == 1)
              {
                paramQQAppInterface = ContactUtils.a(paramQQAppInterface, paramContext, true);
                str1 = paramString;
                if (paramQQAppInterface != "")
                {
                  str1 = paramString;
                  if (!paramQQAppInterface.equals("")) {
                    str1 = TroopSystemMsgUtil.a(paramString, paramContext, paramQQAppInterface);
                  }
                }
              }
            }
          }
        }
      }
    }
    return str1;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = Pattern.compile("(|(\\d{2}):)(\\d{2}):(\\d{2})$").matcher(paramString);
    String str1 = paramString;
    if (((Matcher)localObject).find())
    {
      str1 = paramString;
      if (((Matcher)localObject).groupCount() >= 4)
      {
        int j = 0;
        str1 = ((Matcher)localObject).group(0);
        String str2 = ((Matcher)localObject).group(1);
        int i = j;
        if (str2 != null)
        {
          i = j;
          if (str2.length() > 0) {
            i = Integer.parseInt(((Matcher)localObject).group(2));
          }
        }
        j = Integer.parseInt(((Matcher)localObject).group(3));
        int k = Integer.parseInt(((Matcher)localObject).group(4));
        localObject = new StringBuffer();
        if (i > 0)
        {
          ((StringBuffer)localObject).append(i);
          ((StringBuffer)localObject).append(paramContext.getString(2131890771));
        }
        if (j > 0)
        {
          ((StringBuffer)localObject).append(j);
          ((StringBuffer)localObject).append(paramContext.getString(2131891827));
        }
        ((StringBuffer)localObject).append(k);
        ((StringBuffer)localObject).append(paramContext.getString(2131916154));
        str1 = paramString.replace(str1, ((StringBuffer)localObject).toString());
      }
    }
    return str1;
  }
  
  @Nullable
  private static String a(AppInterface paramAppInterface, Message paramMessage, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (AnonymousChatHelper.c(paramMessage)) {
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (paramString.equals(ContactUtils.a(paramAppInterface, paramMessage.frienduin, true))) {}
      }
      else
      {
        paramAppInterface = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if ((paramAppInterface instanceof ChatMessage)) {
          ((ChatMessage)paramAppInterface).parse();
        }
        if (paramAppInterface != null) {
          paramString = AnonymousChatHelper.g(paramAppInterface).c;
        }
        str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = AnonymousChatHelper.g(paramMessage).c;
        }
      }
    }
    paramString = null;
    paramAppInterface = str;
    if (!paramBoolean) {
      if (!paramMessage.isSendFromLocal())
      {
        paramAppInterface = str;
        if (paramMessage.selfuin != null)
        {
          paramAppInterface = str;
          if (!paramMessage.selfuin.equals(paramMessage.senderuin)) {}
        }
      }
      else
      {
        paramAppInterface = null;
      }
    }
    if (MsgProxyUtils.f(paramMessage.msgtype)) {
      paramAppInterface = paramString;
    }
    paramMessage = TroopBusinessUtil.a(paramMessage);
    if (paramMessage != null) {
      paramAppInterface = paramMessage.d;
    }
    return b(paramAppInterface);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramArrayOfString == null) {
      return "";
    }
    if ((paramInt != 1) && (paramInt != 5000)) {
      i = 2;
    } else {
      i = 1;
    }
    int k;
    if (paramArrayOfString.length > 1) {
      k = 0;
    }
    try
    {
      j = Integer.parseInt(paramArrayOfString[1]);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int j;
      label53:
      break label53;
    }
    j = 0;
    if (j != 13)
    {
      paramString1 = paramContext.getResources().getString(2131893316);
      if ((paramInt == 1) || (paramInt == 5000)) {
        paramString1 = paramContext.getResources().getString(2131893339);
      }
    }
    else if (paramString2 != null)
    {
      paramString2 = ContactUtils.a(paramQQAppInterface, paramString2, paramString1, i, 0);
      paramString1 = paramContext.getResources().getString(2131893316);
      if ((paramInt == 1) || (paramInt == 5000)) {
        paramString1 = paramContext.getResources().getString(2131893339);
      }
      paramContext = paramString2;
      if (paramString2.length() > 11)
      {
        paramContext = paramString2.substring(0, 10);
        paramString2 = new StringBuilder();
        paramString2.append(paramContext);
        paramString2.append("...");
        paramContext = paramString2.toString();
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramContext);
      paramString2.append(paramString1);
      paramString1 = paramString2.toString();
    }
    else if ((paramInt != 1) && (paramInt != 5000))
    {
      paramString1 = paramContext.getResources().getString(2131893268);
    }
    else
    {
      paramString1 = paramContext.getResources().getString(2131893336);
    }
    if (paramArrayOfString.length > 5) {}
    try
    {
      i = Integer.parseInt(paramArrayOfString[4]);
    }
    catch (Exception paramArrayOfString)
    {
      label307:
      label314:
      label321:
      break label314;
    }
    try
    {
      paramInt = Integer.parseInt(paramArrayOfString[5]);
    }
    catch (Exception paramArrayOfString)
    {
      break label307;
    }
    paramInt = k;
    break label321;
    int i = 0;
    paramInt = k;
    paramArrayOfString = paramString1;
    if (i == 2)
    {
      if (paramInt == 4) {
        paramArrayOfString = paramQQAppInterface.getApp().getString(2131893341);
      } else if (paramInt == 5) {
        paramArrayOfString = paramQQAppInterface.getApp().getString(2131893348);
      } else {
        paramArrayOfString = paramQQAppInterface.getApp().getString(2131893336);
      }
      paramContext = new StringBuilder();
      paramContext.append(": ");
      paramContext.append(paramArrayOfString);
      paramArrayOfString = paramContext.toString();
      paramArrayOfString = paramString1.replace(paramQQAppInterface.getApp().getString(2131893339), paramArrayOfString);
    }
    return paramArrayOfString;
    return "";
  }
  
  public static String a(String paramString)
  {
    String str = HardCodeUtil.a(2131904851);
    StringBuilder localStringBuilder1 = new StringBuilder(40);
    if (paramString != null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(": ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder1.append(str);
    return localStringBuilder1.toString();
  }
  
  /* Error */
  public static String a(String paramString, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +860 -> 861
    //   4: aload_0
    //   5: invokevirtual 216	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aload_0
    //   12: areturn
    //   13: lconst_0
    //   14: lstore 9
    //   16: invokestatic 379	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   19: ifeq +8 -> 27
    //   22: invokestatic 385	android/os/SystemClock:elapsedRealtime	()J
    //   25: lstore 9
    //   27: getstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   30: istore 5
    //   32: fconst_0
    //   33: fstore_2
    //   34: iload 5
    //   36: ifne +577 -> 613
    //   39: invokestatic 392	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   45: invokevirtual 396	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   48: astore 11
    //   50: ldc_w 397
    //   53: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   56: astore 12
    //   58: new 399	android/text/TextPaint
    //   61: dup
    //   62: invokespecial 400	android/text/TextPaint:<init>	()V
    //   65: astore 13
    //   67: aload 13
    //   69: aload 11
    //   71: getfield 405	android/util/DisplayMetrics:density	F
    //   74: ldc_w 406
    //   77: fmul
    //   78: invokevirtual 410	android/text/TextPaint:setTextSize	(F)V
    //   81: aload 11
    //   83: getfield 413	android/util/DisplayMetrics:widthPixels	I
    //   86: aload 11
    //   88: getfield 416	android/util/DisplayMetrics:heightPixels	I
    //   91: invokestatic 422	java/lang/Math:min	(II)I
    //   94: i2f
    //   95: fstore_3
    //   96: aload 11
    //   98: getfield 405	android/util/DisplayMetrics:density	F
    //   101: fstore 4
    //   103: fload_3
    //   104: fload 4
    //   106: ldc_w 423
    //   109: fmul
    //   110: fsub
    //   111: fstore_3
    //   112: fload_3
    //   113: fconst_0
    //   114: fcmpg
    //   115: ifgt +115 -> 230
    //   118: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +107 -> 228
    //   124: new 153	java/lang/StringBuilder
    //   127: dup
    //   128: bipush 120
    //   130: invokespecial 371	java/lang/StringBuilder:<init>	(I)V
    //   133: astore 11
    //   135: aload 11
    //   137: ldc_w 428
    //   140: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 11
    //   146: ldc_w 430
    //   149: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 11
    //   155: getstatic 432	com/tencent/mobileqq/utils/MsgUtils:f	F
    //   158: invokevirtual 435	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 11
    //   164: ldc_w 437
    //   167: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 11
    //   173: getstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   176: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 11
    //   182: ldc_w 442
    //   185: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 11
    //   191: getstatic 444	com/tencent/mobileqq/utils/MsgUtils:d	F
    //   194: invokevirtual 435	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 11
    //   200: ldc_w 446
    //   203: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 11
    //   209: getstatic 448	com/tencent/mobileqq/utils/MsgUtils:e	F
    //   212: invokevirtual 435	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc_w 450
    //   219: iconst_2
    //   220: aload 11
    //   222: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: areturn
    //   230: ldc_w 455
    //   233: fload_3
    //   234: fmul
    //   235: putstatic 432	com/tencent/mobileqq/utils/MsgUtils:f	F
    //   238: aload 13
    //   240: aload 12
    //   242: invokevirtual 459	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   245: putstatic 444	com/tencent/mobileqq/utils/MsgUtils:d	F
    //   248: aload 13
    //   250: ldc_w 461
    //   253: invokevirtual 459	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   256: bipush 8
    //   258: i2f
    //   259: fdiv
    //   260: putstatic 448	com/tencent/mobileqq/utils/MsgUtils:e	F
    //   263: getstatic 444	com/tencent/mobileqq/utils/MsgUtils:d	F
    //   266: fconst_1
    //   267: fcmpl
    //   268: ifle +16 -> 284
    //   271: fload_3
    //   272: ldc_w 462
    //   275: fmul
    //   276: getstatic 444	com/tencent/mobileqq/utils/MsgUtils:d	F
    //   279: fdiv
    //   280: f2i
    //   281: putstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   284: getstatic 448	com/tencent/mobileqq/utils/MsgUtils:e	F
    //   287: fconst_1
    //   288: fcmpl
    //   289: ifle +20 -> 309
    //   292: getstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   295: getstatic 432	com/tencent/mobileqq/utils/MsgUtils:f	F
    //   298: getstatic 448	com/tencent/mobileqq/utils/MsgUtils:e	F
    //   301: fdiv
    //   302: f2i
    //   303: invokestatic 422	java/lang/Math:min	(II)I
    //   306: putstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   309: getstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   312: ifgt +8 -> 320
    //   315: bipush 14
    //   317: putstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   320: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +290 -> 613
    //   326: new 153	java/lang/StringBuilder
    //   329: dup
    //   330: bipush 120
    //   332: invokespecial 371	java/lang/StringBuilder:<init>	(I)V
    //   335: astore 11
    //   337: goto +68 -> 405
    //   340: astore_0
    //   341: goto +160 -> 501
    //   344: astore 11
    //   346: aload 11
    //   348: invokevirtual 465	java/lang/Error:printStackTrace	()V
    //   351: bipush 14
    //   353: putstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   356: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +254 -> 613
    //   362: new 153	java/lang/StringBuilder
    //   365: dup
    //   366: bipush 120
    //   368: invokespecial 371	java/lang/StringBuilder:<init>	(I)V
    //   371: astore 11
    //   373: goto +32 -> 405
    //   376: astore 11
    //   378: aload 11
    //   380: invokevirtual 466	java/lang/Exception:printStackTrace	()V
    //   383: bipush 14
    //   385: putstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   388: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +222 -> 613
    //   394: new 153	java/lang/StringBuilder
    //   397: dup
    //   398: bipush 120
    //   400: invokespecial 371	java/lang/StringBuilder:<init>	(I)V
    //   403: astore 11
    //   405: aload 11
    //   407: ldc_w 428
    //   410: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 11
    //   416: ldc_w 430
    //   419: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 11
    //   425: getstatic 432	com/tencent/mobileqq/utils/MsgUtils:f	F
    //   428: invokevirtual 435	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 11
    //   434: ldc_w 437
    //   437: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 11
    //   443: getstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   446: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 11
    //   452: ldc_w 442
    //   455: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 11
    //   461: getstatic 444	com/tencent/mobileqq/utils/MsgUtils:d	F
    //   464: invokevirtual 435	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 11
    //   470: ldc_w 446
    //   473: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 11
    //   479: getstatic 448	com/tencent/mobileqq/utils/MsgUtils:e	F
    //   482: invokevirtual 435	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: ldc_w 450
    //   489: iconst_2
    //   490: aload 11
    //   492: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: goto +115 -> 613
    //   501: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   504: ifeq +107 -> 611
    //   507: new 153	java/lang/StringBuilder
    //   510: dup
    //   511: bipush 120
    //   513: invokespecial 371	java/lang/StringBuilder:<init>	(I)V
    //   516: astore 11
    //   518: aload 11
    //   520: ldc_w 428
    //   523: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 11
    //   529: ldc_w 430
    //   532: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 11
    //   538: getstatic 432	com/tencent/mobileqq/utils/MsgUtils:f	F
    //   541: invokevirtual 435	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 11
    //   547: ldc_w 437
    //   550: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 11
    //   556: getstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   559: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload 11
    //   565: ldc_w 442
    //   568: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 11
    //   574: getstatic 444	com/tencent/mobileqq/utils/MsgUtils:d	F
    //   577: invokevirtual 435	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 11
    //   583: ldc_w 446
    //   586: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 11
    //   592: getstatic 448	com/tencent/mobileqq/utils/MsgUtils:e	F
    //   595: invokevirtual 435	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: ldc_w 450
    //   602: iconst_2
    //   603: aload 11
    //   605: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload_0
    //   612: athrow
    //   613: aload_0
    //   614: invokevirtual 216	java/lang/String:length	()I
    //   617: istore 7
    //   619: iload 7
    //   621: getstatic 387	com/tencent/mobileqq/utils/MsgUtils:c	I
    //   624: if_icmplt +153 -> 777
    //   627: getstatic 448	com/tencent/mobileqq/utils/MsgUtils:e	F
    //   630: fconst_1
    //   631: fcmpg
    //   632: iflt +145 -> 777
    //   635: getstatic 444	com/tencent/mobileqq/utils/MsgUtils:d	F
    //   638: fconst_1
    //   639: fcmpg
    //   640: ifge +6 -> 646
    //   643: goto +134 -> 777
    //   646: iconst_0
    //   647: istore 5
    //   649: iconst_0
    //   650: istore 6
    //   652: iload 5
    //   654: iload 7
    //   656: if_icmpge +67 -> 723
    //   659: aload_0
    //   660: iload 5
    //   662: invokevirtual 470	java/lang/String:charAt	(I)C
    //   665: istore 8
    //   667: iload 8
    //   669: bipush 32
    //   671: if_icmplt +17 -> 688
    //   674: iload 8
    //   676: bipush 126
    //   678: if_icmpgt +10 -> 688
    //   681: getstatic 448	com/tencent/mobileqq/utils/MsgUtils:e	F
    //   684: fstore_3
    //   685: goto +7 -> 692
    //   688: getstatic 444	com/tencent/mobileqq/utils/MsgUtils:d	F
    //   691: fstore_3
    //   692: fload_2
    //   693: fload_3
    //   694: fadd
    //   695: fstore_2
    //   696: getstatic 432	com/tencent/mobileqq/utils/MsgUtils:f	F
    //   699: fload_1
    //   700: fmul
    //   701: fload_2
    //   702: fsub
    //   703: fconst_1
    //   704: fcmpl
    //   705: ifle +18 -> 723
    //   708: iload 6
    //   710: iconst_1
    //   711: iadd
    //   712: istore 6
    //   714: iload 5
    //   716: iconst_1
    //   717: iadd
    //   718: istore 5
    //   720: goto -68 -> 652
    //   723: iload 6
    //   725: iload 7
    //   727: if_icmpge +50 -> 777
    //   730: iload 6
    //   732: ifle +45 -> 777
    //   735: new 153	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   742: astore 11
    //   744: aload 11
    //   746: aload_0
    //   747: iconst_0
    //   748: iload 6
    //   750: iconst_1
    //   751: isub
    //   752: invokevirtual 355	java/lang/String:substring	(II)Ljava/lang/String;
    //   755: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 11
    //   761: ldc_w 357
    //   764: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 11
    //   770: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: astore_0
    //   774: goto +3 -> 777
    //   777: invokestatic 379	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   780: ifeq +79 -> 859
    //   783: getstatic 472	com/tencent/mobileqq/utils/MsgUtils:a	J
    //   786: invokestatic 385	android/os/SystemClock:elapsedRealtime	()J
    //   789: lload 9
    //   791: lsub
    //   792: ladd
    //   793: putstatic 472	com/tencent/mobileqq/utils/MsgUtils:a	J
    //   796: getstatic 474	com/tencent/mobileqq/utils/MsgUtils:b	J
    //   799: lconst_1
    //   800: ladd
    //   801: putstatic 474	com/tencent/mobileqq/utils/MsgUtils:b	J
    //   804: getstatic 474	com/tencent/mobileqq/utils/MsgUtils:b	J
    //   807: ldc2_w 475
    //   810: lrem
    //   811: lconst_1
    //   812: lcmp
    //   813: ifne +46 -> 859
    //   816: new 153	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   823: astore 11
    //   825: aload 11
    //   827: ldc_w 478
    //   830: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 11
    //   836: getstatic 472	com/tencent/mobileqq/utils/MsgUtils:a	J
    //   839: getstatic 474	com/tencent/mobileqq/utils/MsgUtils:b	J
    //   842: ldiv
    //   843: invokevirtual 481	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: ldc_w 450
    //   850: iconst_4
    //   851: aload 11
    //   853: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   856: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   859: aload_0
    //   860: areturn
    //   861: aload_0
    //   862: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	863	0	paramString	String
    //   0	863	1	paramFloat	float
    //   33	669	2	f1	float
    //   95	599	3	f2	float
    //   101	4	4	f3	float
    //   30	689	5	i	int
    //   650	102	6	j	int
    //   617	111	7	k	int
    //   665	14	8	m	int
    //   14	776	9	l	long
    //   48	288	11	localObject	Object
    //   344	3	11	localError	java.lang.Error
    //   371	1	11	localStringBuilder1	StringBuilder
    //   376	3	11	localException	Exception
    //   403	449	11	localStringBuilder2	StringBuilder
    //   56	185	12	str	String
    //   65	184	13	localTextPaint	android.text.TextPaint
    // Exception table:
    //   from	to	target	type
    //   39	103	340	finally
    //   230	284	340	finally
    //   284	309	340	finally
    //   309	320	340	finally
    //   346	356	340	finally
    //   378	388	340	finally
    //   39	103	344	java/lang/Error
    //   230	284	344	java/lang/Error
    //   284	309	344	java/lang/Error
    //   309	320	344	java/lang/Error
    //   39	103	376	java/lang/Exception
    //   230	284	376	java/lang/Exception
    //   284	309	376	java/lang/Exception
    //   309	320	376	java/lang/Exception
  }
  
  public static String a(String[] paramArrayOfString, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = "";
    if (paramArrayOfString == null) {
      return "";
    }
    Object localObject = str;
    if (paramArrayOfString.length > 1) {}
    label1037:
    try
    {
      i = Integer.parseInt(paramArrayOfString[1]);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label32:
      label613:
      break label32;
    }
    i = 0;
    if (paramArrayOfString.length > 3) {
      paramBoolean1 = "1".equals(paramArrayOfString[3]);
    } else {
      paramBoolean1 = true;
    }
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 6) {
              if (i != 7) {
                if (i != 10) {
                  if (i != 12)
                  {
                    if (i == 24) {
                      break label613;
                    }
                    if (i != 42) {
                      switch (i)
                      {
                      default: 
                        if (paramBoolean1) {
                          paramContext = paramContext.getResources().getString(2131893705);
                        } else {
                          paramContext = paramContext.getResources().getString(2131893105);
                        }
                        localObject = paramContext;
                        if (TextUtils.isEmpty(paramArrayOfString[0])) {
                          break;
                        }
                        localObject = new StringBuilder();
                        ((StringBuilder)localObject).append(paramContext);
                        ((StringBuilder)localObject).append(" ");
                        ((StringBuilder)localObject).append(paramArrayOfString[0]);
                        return ((StringBuilder)localObject).toString();
                      case 46: 
                      case 47: 
                      case 48: 
                        localObject = str;
                        if (paramArrayOfString[0] == null) {
                          break;
                        }
                        localObject = new StringBuilder();
                        ((StringBuilder)localObject).append(paramContext.getResources().getString(2131893105));
                        ((StringBuilder)localObject).append(" ");
                        ((StringBuilder)localObject).append(paramArrayOfString[0]);
                        return ((StringBuilder)localObject).toString();
                      }
                    }
                    localObject = str;
                    if (paramArrayOfString[0] == null) {
                      break label1037;
                    }
                    if (paramContext.getString(2131917859).equals(paramArrayOfString[0]))
                    {
                      if (paramBoolean1) {
                        paramArrayOfString = paramContext.getResources().getString(2131893722);
                      } else {
                        paramArrayOfString = paramContext.getResources().getString(2131893119);
                      }
                    }
                    else if (paramBoolean1)
                    {
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append(paramContext.getResources().getString(2131893705));
                      ((StringBuilder)localObject).append(" ");
                      ((StringBuilder)localObject).append(paramArrayOfString[0]);
                      paramArrayOfString = ((StringBuilder)localObject).toString();
                    }
                    else
                    {
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append(paramContext.getResources().getString(2131893105));
                      ((StringBuilder)localObject).append(" ");
                      ((StringBuilder)localObject).append(paramArrayOfString[0]);
                      paramArrayOfString = ((StringBuilder)localObject).toString();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return paramArrayOfString;
      if (paramBoolean1) {
        return paramContext.getResources().getString(2131893721);
      }
      return paramContext.getResources().getString(2131893118);
      if (paramBoolean1) {
        return paramContext.getResources().getString(2131893705);
      }
      return paramContext.getResources().getString(2131893105);
      if (paramBoolean1) {
        return paramContext.getResources().getString(2131893706);
      }
      return paramContext.getResources().getString(2131893107);
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131893718);
        }
        return paramContext.getResources().getString(2131893717);
      }
      if (paramBoolean2) {
        return paramContext.getResources().getString(2131893114);
      }
      return paramContext.getResources().getString(2131893113);
      if (paramBoolean1) {
        return paramContext.getResources().getString(2131893719);
      }
      return paramContext.getResources().getString(2131893115);
      localObject = str;
      if (paramArrayOfString[0] == null) {
        break;
      }
      if (paramContext.getString(2131917863).equals(paramArrayOfString[0]))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            paramArrayOfString = paramContext.getResources().getString(2131893718);
          } else {
            paramArrayOfString = paramContext.getResources().getString(2131893717);
          }
        }
        else if (paramBoolean2) {
          paramArrayOfString = paramContext.getResources().getString(2131893114);
        } else {
          paramArrayOfString = paramContext.getResources().getString(2131893113);
        }
      }
      else if (paramBoolean1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getResources().getString(2131893705));
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramArrayOfString[0]);
        paramArrayOfString = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getResources().getString(2131893105));
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramArrayOfString[0]);
        paramArrayOfString = ((StringBuilder)localObject).toString();
        continue;
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131893718);
          }
          return paramContext.getResources().getString(2131893717);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131893114);
        }
        return paramContext.getResources().getString(2131893113);
        localObject = str;
        if (paramArrayOfString[0] == null) {
          break;
        }
        if (paramContext.getString(2131917859).equals(paramArrayOfString[0]))
        {
          if (paramBoolean1) {
            paramArrayOfString = paramContext.getResources().getString(2131893722);
          } else {
            paramArrayOfString = paramContext.getResources().getString(2131893119);
          }
        }
        else if (paramBoolean1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.getResources().getString(2131893705));
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramArrayOfString[0]);
          paramArrayOfString = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.getResources().getString(2131893105));
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramArrayOfString[0]);
          paramArrayOfString = ((StringBuilder)localObject).toString();
        }
      }
    }
    return localObject;
  }
  
  /* Error */
  public static void a(Context paramContext, AppInterface paramAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: aload_2
    //   7: aload 5
    //   9: iload 6
    //   11: invokestatic 505	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;Ljava/lang/String;Z)Ljava/lang/String;
    //   14: astore 5
    //   16: aload 5
    //   18: astore 16
    //   20: aload_2
    //   21: getfield 509	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   24: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifne +49 -> 76
    //   30: aload 5
    //   32: astore 16
    //   34: aload 5
    //   36: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +37 -> 76
    //   42: new 153	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   49: astore 15
    //   51: aload 15
    //   53: aload_2
    //   54: getfield 509	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   57: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 15
    //   63: aload 5
    //   65: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 15
    //   71: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 16
    //   76: aload_0
    //   77: aload_1
    //   78: aload_2
    //   79: iload_3
    //   80: aload 4
    //   82: aload 16
    //   84: iload 6
    //   86: iload 7
    //   88: invokestatic 515	com/tencent/mobileqq/utils/MsgUtils:b	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;ILcom/tencent/mobileqq/activity/recent/MsgSummary;Ljava/lang/String;ZZ)Z
    //   91: ifeq +4 -> 95
    //   94: return
    //   95: aload_2
    //   96: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   99: sipush -2034
    //   102: if_icmpne +16 -> 118
    //   105: aload 4
    //   107: aload_2
    //   108: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   111: invokestatic 523	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   117: return
    //   118: aload_2
    //   119: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   122: istore 10
    //   124: ldc 122
    //   126: astore 5
    //   128: iconst_0
    //   129: istore 9
    //   131: iconst_0
    //   132: istore 8
    //   134: iload 10
    //   136: sipush -2011
    //   139: if_icmpne +190 -> 329
    //   142: aload_2
    //   143: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   146: sipush -2011
    //   149: if_icmpne +29 -> 178
    //   152: aload_2
    //   153: getfield 531	com/tencent/imcore/message/Message:extInt	I
    //   156: bipush 61
    //   158: if_icmpne +20 -> 178
    //   161: aload_2
    //   162: aload_1
    //   163: invokevirtual 532	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   166: invokevirtual 533	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   169: ldc_w 534
    //   172: invokevirtual 347	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   175: putfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   178: iload 9
    //   180: istore_3
    //   181: aload_2
    //   182: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   185: iconst_1
    //   186: if_icmpne +105 -> 291
    //   189: aload_1
    //   190: ldc_w 290
    //   193: ldc 122
    //   195: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   198: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   201: aload_2
    //   202: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   205: aload_2
    //   206: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   209: aload_2
    //   210: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   213: invokeinterface 300 5 0
    //   218: astore_0
    //   219: iload 8
    //   221: istore_3
    //   222: ldc_w 536
    //   225: invokestatic 542	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   228: checkcast 536	com/tencent/mobileqq/nearby/api/INearbyFlowerUtil
    //   231: aload_0
    //   232: invokeinterface 545 2 0
    //   237: ifeq +32 -> 269
    //   240: aconst_null
    //   241: aconst_null
    //   242: ldc_w 536
    //   245: invokestatic 542	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   248: checkcast 536	com/tencent/mobileqq/nearby/api/INearbyFlowerUtil
    //   251: aload_0
    //   252: checkcast 547	com/tencent/mobileqq/data/MessageForStructing
    //   255: invokeinterface 551 2 0
    //   260: iconst_0
    //   261: iconst_0
    //   262: aload 4
    //   264: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   267: iconst_1
    //   268: istore_3
    //   269: aload_0
    //   270: invokestatic 558	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   273: ifeq +18 -> 291
    //   276: aconst_null
    //   277: aconst_null
    //   278: aload_2
    //   279: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   282: iconst_0
    //   283: iconst_0
    //   284: aload 4
    //   286: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   289: iconst_1
    //   290: istore_3
    //   291: iload_3
    //   292: ifne +8164 -> 8456
    //   295: aload_1
    //   296: aload_2
    //   297: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   300: istore 6
    //   302: aload_1
    //   303: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   306: aload_2
    //   307: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   310: istore 7
    //   312: aload 16
    //   314: aconst_null
    //   315: aload_2
    //   316: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   319: iload 6
    //   321: iload 7
    //   323: aload 4
    //   325: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   328: return
    //   329: aload_2
    //   330: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   333: sipush -2000
    //   336: if_icmpeq +7632 -> 7968
    //   339: aload_2
    //   340: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   343: sipush -5015
    //   346: if_icmpne +6 -> 352
    //   349: goto +7619 -> 7968
    //   352: aload_2
    //   353: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   356: sipush -2002
    //   359: if_icmpeq +7343 -> 7702
    //   362: aload_2
    //   363: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   366: sipush -1031
    //   369: if_icmpne +6 -> 375
    //   372: goto +7330 -> 7702
    //   375: aload_2
    //   376: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   379: sipush -3008
    //   382: if_icmpne +58 -> 440
    //   385: new 153	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   392: astore_1
    //   393: aload_1
    //   394: aload_0
    //   395: ldc_w 564
    //   398: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   401: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_1
    //   406: ldc_w 566
    //   409: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload_1
    //   414: aload_2
    //   415: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   418: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_1
    //   423: ldc_w 566
    //   426: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload 4
    //   432: aload_1
    //   433: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   439: return
    //   440: aload_2
    //   441: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   444: sipush -2015
    //   447: if_icmpeq +7247 -> 7694
    //   450: aload_2
    //   451: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   454: sipush -2060
    //   457: if_icmpeq +7237 -> 7694
    //   460: aload_2
    //   461: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   464: sipush -2062
    //   467: if_icmpeq +7227 -> 7694
    //   470: aload_2
    //   471: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   474: sipush -2065
    //   477: if_icmpeq +7217 -> 7694
    //   480: aload_2
    //   481: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   484: sipush -7010
    //   487: if_icmpeq +7207 -> 7694
    //   490: aload_2
    //   491: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   494: sipush -7009
    //   497: if_icmpeq +7197 -> 7694
    //   500: aload_2
    //   501: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   504: sipush -7011
    //   507: if_icmpeq +7187 -> 7694
    //   510: aload_2
    //   511: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   514: sipush -7012
    //   517: if_icmpeq +7177 -> 7694
    //   520: aload_2
    //   521: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   524: sipush -4023
    //   527: if_icmpeq +7167 -> 7694
    //   530: aload_2
    //   531: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   534: sipush -4024
    //   537: if_icmpeq +7157 -> 7694
    //   540: aload_2
    //   541: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   544: sipush -4025
    //   547: if_icmpeq +7147 -> 7694
    //   550: aload_2
    //   551: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   554: sipush -4026
    //   557: if_icmpeq +7137 -> 7694
    //   560: aload_2
    //   561: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   564: sipush -4027
    //   567: if_icmpeq +7127 -> 7694
    //   570: aload_2
    //   571: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   574: sipush -7013
    //   577: if_icmpeq +7117 -> 7694
    //   580: aload_2
    //   581: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   584: sipush -7015
    //   587: if_icmpne +6 -> 593
    //   590: goto +7104 -> 7694
    //   593: aload_2
    //   594: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   597: invokestatic 570	com/tencent/mobileqq/utils/ActionMsgUtil:a	(I)Z
    //   600: ifeq +36 -> 636
    //   603: aload_1
    //   604: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   607: astore 5
    //   609: aload 16
    //   611: aload_0
    //   612: aload 5
    //   614: aload_2
    //   615: invokestatic 572	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   618: aconst_null
    //   619: aload_1
    //   620: aload_2
    //   621: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   624: aload 5
    //   626: aload_2
    //   627: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   630: aload 4
    //   632: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   635: return
    //   636: aload_2
    //   637: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   640: sipush -2017
    //   643: if_icmpne +107 -> 750
    //   646: aload_0
    //   647: ldc_w 573
    //   650: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   653: astore 5
    //   655: aload_2
    //   656: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   659: astore_0
    //   660: aload_2
    //   661: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   664: aload_2
    //   665: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   668: invokestatic 578	com/tencent/imcore/message/UinTypeUtil:c	(Ljava/lang/String;I)Z
    //   671: ifeq +8 -> 679
    //   674: aload_2
    //   675: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   678: astore_0
    //   679: aload_1
    //   680: ldc_w 290
    //   683: ldc 122
    //   685: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   688: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   691: aload_0
    //   692: aload_2
    //   693: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   696: aload_2
    //   697: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   700: invokeinterface 300 5 0
    //   705: astore 15
    //   707: aload 5
    //   709: astore_0
    //   710: aload 15
    //   712: instanceof 580
    //   715: ifeq +12 -> 727
    //   718: aload 15
    //   720: checkcast 580	com/tencent/mobileqq/data/MessageForTroopFile
    //   723: invokevirtual 583	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   726: astore_0
    //   727: aload 16
    //   729: aload_0
    //   730: aconst_null
    //   731: aload_1
    //   732: aload_2
    //   733: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   736: aload_1
    //   737: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   740: aload_2
    //   741: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   744: aload 4
    //   746: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   749: return
    //   750: aload_2
    //   751: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   754: invokestatic 585	com/tencent/mobileqq/utils/ActionMsgUtil:b	(I)Z
    //   757: ifeq +54 -> 811
    //   760: aload_2
    //   761: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   764: invokestatic 591	com/tencent/mobileqq/transfile/TransfileUtile:analysisTransFileProtocolData	(Ljava/lang/String;)[Ljava/lang/String;
    //   767: astore_1
    //   768: aload_1
    //   769: ifnull +22 -> 791
    //   772: aload 4
    //   774: aload_1
    //   775: aload_0
    //   776: aload_2
    //   777: getfield 594	com/tencent/imcore/message/Message:issend	I
    //   780: invokestatic 598	com/tencent/mobileqq/service/message/remote/MessageRecordInfo:c	(I)Z
    //   783: iload 7
    //   785: invokestatic 600	com/tencent/mobileqq/utils/MsgUtils:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   788: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   791: ldc_w 602
    //   794: invokestatic 542	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   797: checkcast 602	com/tencent/mobileqq/activity/recent/msgbox/api/ITempMsgBoxService
    //   800: iload_3
    //   801: aload 16
    //   803: aload 4
    //   805: invokeinterface 606 4 0
    //   810: return
    //   811: aload_2
    //   812: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   815: invokestatic 607	com/tencent/mobileqq/utils/ActionMsgUtil:c	(I)Z
    //   818: ifeq +42 -> 860
    //   821: aload_2
    //   822: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   825: invokestatic 591	com/tencent/mobileqq/transfile/TransfileUtile:analysisTransFileProtocolData	(Ljava/lang/String;)[Ljava/lang/String;
    //   828: astore 5
    //   830: aload 5
    //   832: ifnull +27 -> 859
    //   835: aload 4
    //   837: aload_1
    //   838: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   841: aload 5
    //   843: aload_0
    //   844: aload_2
    //   845: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   848: aload_2
    //   849: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   852: iload_3
    //   853: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   856: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   859: return
    //   860: aload_2
    //   861: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   864: invokestatic 611	com/tencent/mobileqq/utils/ActionMsgUtil:d	(I)Z
    //   867: ifeq +149 -> 1016
    //   870: aload_1
    //   871: aload_2
    //   872: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   875: istore 6
    //   877: aload_1
    //   878: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   881: aload_2
    //   882: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   885: istore 7
    //   887: aload_2
    //   888: ldc_w 613
    //   891: invokevirtual 616	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   894: astore 5
    //   896: getstatic 621	com/tencent/mobileqq/emoticon/EmojiStickerManager:n	Z
    //   899: ifeq +97 -> 996
    //   902: aload 5
    //   904: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   907: ifne +89 -> 996
    //   910: aload_0
    //   911: aload_2
    //   912: invokestatic 626	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   915: astore_0
    //   916: aload_2
    //   917: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   920: aload_1
    //   921: invokevirtual 627	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   924: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   927: ifeq +36 -> 963
    //   930: new 153	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   937: astore_1
    //   938: aload_1
    //   939: ldc_w 628
    //   942: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   945: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload_1
    //   950: aload_0
    //   951: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload_1
    //   956: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: astore_0
    //   960: goto +42 -> 1002
    //   963: new 153	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   970: astore_1
    //   971: aload_1
    //   972: ldc_w 629
    //   975: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   978: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload_1
    //   983: aload_0
    //   984: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload_1
    //   989: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: astore_0
    //   993: goto +9 -> 1002
    //   996: aload_0
    //   997: aload_2
    //   998: invokestatic 626	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1001: astore_0
    //   1002: aload 16
    //   1004: aload_0
    //   1005: aconst_null
    //   1006: iload 6
    //   1008: iload 7
    //   1010: aload 4
    //   1012: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1015: return
    //   1016: aload_2
    //   1017: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   1020: invokestatic 630	com/tencent/mobileqq/utils/ActionMsgUtil:f	(I)Z
    //   1023: ifeq +230 -> 1253
    //   1026: aload_1
    //   1027: aload_2
    //   1028: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1031: istore 6
    //   1033: aload_1
    //   1034: aload_2
    //   1035: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1038: istore 7
    //   1040: ldc_w 632
    //   1043: iconst_1
    //   1044: anewarray 4	java/lang/Object
    //   1047: dup
    //   1048: iconst_0
    //   1049: ldc_w 633
    //   1052: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1055: aastore
    //   1056: invokestatic 637	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1059: astore_1
    //   1060: aload_2
    //   1061: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   1064: ifnull +35 -> 1099
    //   1067: aload_2
    //   1068: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   1071: arraylength
    //   1072: ifle +27 -> 1099
    //   1075: new 643	com/tencent/mobileqq/data/MessageForAniSticker
    //   1078: dup
    //   1079: invokespecial 644	com/tencent/mobileqq/data/MessageForAniSticker:<init>	()V
    //   1082: astore_0
    //   1083: aload_0
    //   1084: aload_2
    //   1085: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   1088: invokevirtual 648	com/tencent/mobileqq/data/MessageForAniSticker:deserializeMsgData	([B)V
    //   1091: aload_0
    //   1092: invokevirtual 649	com/tencent/mobileqq/data/MessageForAniSticker:getSummaryMsg	()Ljava/lang/String;
    //   1095: astore_0
    //   1096: goto +23 -> 1119
    //   1099: aload_1
    //   1100: astore_0
    //   1101: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1104: ifeq +15 -> 1119
    //   1107: ldc_w 651
    //   1110: iconst_2
    //   1111: ldc_w 653
    //   1114: invokestatic 655	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1117: aload_1
    //   1118: astore_0
    //   1119: new 657	com/tencent/mobileqq/text/QQText
    //   1122: dup
    //   1123: aload_0
    //   1124: bipush 7
    //   1126: bipush 16
    //   1128: invokespecial 660	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   1131: astore_0
    //   1132: new 153	java/lang/StringBuilder
    //   1135: dup
    //   1136: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1139: astore_1
    //   1140: aload 16
    //   1142: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1145: ifne +18 -> 1163
    //   1148: aload_1
    //   1149: aload 16
    //   1151: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload_1
    //   1156: ldc_w 363
    //   1159: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: pop
    //   1163: aload 4
    //   1165: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1168: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1171: ifne +13 -> 1184
    //   1174: aload_1
    //   1175: aload 4
    //   1177: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1180: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload_2
    //   1185: invokestatic 285	com/tencent/biz/anonymous/AnonymousChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1188: ifne +32 -> 1220
    //   1191: iload 6
    //   1193: ifeq +14 -> 1207
    //   1196: aload_1
    //   1197: ldc_w 668
    //   1200: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: pop
    //   1204: goto +16 -> 1220
    //   1207: iload 7
    //   1209: ifeq +11 -> 1220
    //   1212: aload_1
    //   1213: ldc_w 670
    //   1216: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: pop
    //   1220: aload_0
    //   1221: aload_1
    //   1222: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: iconst_1
    //   1226: iconst_0
    //   1227: newarray int
    //   1229: invokevirtual 673	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   1232: astore_0
    //   1233: aload 4
    //   1235: iconst_1
    //   1236: putfield 676	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   1239: aload 16
    //   1241: aload_0
    //   1242: aconst_null
    //   1243: iload 6
    //   1245: iload 7
    //   1247: aload 4
    //   1249: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1252: return
    //   1253: aload_2
    //   1254: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   1257: sipush -2058
    //   1260: if_icmpne +988 -> 2248
    //   1263: aload_1
    //   1264: aload_2
    //   1265: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1268: istore 11
    //   1270: aload_1
    //   1271: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   1274: aload_2
    //   1275: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1278: istore 12
    //   1280: aload_2
    //   1281: ldc_w 678
    //   1284: invokevirtual 616	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1287: astore 15
    //   1289: aload 15
    //   1291: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1294: ifne +915 -> 2209
    //   1297: new 680	org/json/JSONObject
    //   1300: dup
    //   1301: aload 15
    //   1303: invokespecial 683	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1306: ldc_w 685
    //   1309: invokevirtual 688	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1312: istore 8
    //   1314: aload_2
    //   1315: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   1318: ifnull +141 -> 1459
    //   1321: iload 8
    //   1323: sipush -2007
    //   1326: if_icmpne +133 -> 1459
    //   1329: aload_2
    //   1330: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   1333: invokestatic 693	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   1336: instanceof 695
    //   1339: ifeq +120 -> 1459
    //   1342: getstatic 621	com/tencent/mobileqq/emoticon/EmojiStickerManager:n	Z
    //   1345: ifeq +102 -> 1447
    //   1348: aload_0
    //   1349: aload_2
    //   1350: invokestatic 626	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1353: astore 5
    //   1355: aload_2
    //   1356: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   1359: aload_1
    //   1360: invokevirtual 627	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1363: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1366: ifeq +42 -> 1408
    //   1369: new 153	java/lang/StringBuilder
    //   1372: dup
    //   1373: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1376: astore 15
    //   1378: aload 15
    //   1380: ldc_w 696
    //   1383: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1386: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: pop
    //   1390: aload 15
    //   1392: aload 5
    //   1394: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: pop
    //   1398: aload 15
    //   1400: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: astore 5
    //   1405: goto +49 -> 1454
    //   1408: new 153	java/lang/StringBuilder
    //   1411: dup
    //   1412: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1415: astore 15
    //   1417: aload 15
    //   1419: ldc_w 697
    //   1422: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1425: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: pop
    //   1429: aload 15
    //   1431: aload 5
    //   1433: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: pop
    //   1437: aload 15
    //   1439: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1442: astore 5
    //   1444: goto +10 -> 1454
    //   1447: aload_0
    //   1448: aload_2
    //   1449: invokestatic 626	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1452: astore 5
    //   1454: iconst_1
    //   1455: istore_3
    //   1456: goto +9 -> 1465
    //   1459: ldc 122
    //   1461: astore 5
    //   1463: iconst_0
    //   1464: istore_3
    //   1465: iload_3
    //   1466: ifne +743 -> 2209
    //   1469: getstatic 621	com/tencent/mobileqq/emoticon/EmojiStickerManager:n	Z
    //   1472: istore 6
    //   1474: iload 6
    //   1476: ifeq +151 -> 1627
    //   1479: aload_2
    //   1480: ldc_w 613
    //   1483: invokevirtual 616	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1486: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1489: ifne +131 -> 1620
    //   1492: aload_1
    //   1493: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   1496: aload_2
    //   1497: aload 4
    //   1499: invokestatic 700	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   1502: astore_0
    //   1503: new 153	java/lang/StringBuilder
    //   1506: dup
    //   1507: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1510: astore_1
    //   1511: aload 16
    //   1513: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1516: ifne +18 -> 1534
    //   1519: aload_1
    //   1520: aload 16
    //   1522: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: pop
    //   1526: aload_1
    //   1527: ldc_w 363
    //   1530: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: pop
    //   1534: aload 4
    //   1536: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1539: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1542: ifne +13 -> 1555
    //   1545: aload_1
    //   1546: aload 4
    //   1548: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1551: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   1554: pop
    //   1555: aload_2
    //   1556: invokestatic 285	com/tencent/biz/anonymous/AnonymousChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1559: ifne +32 -> 1591
    //   1562: iload 11
    //   1564: ifeq +14 -> 1578
    //   1567: aload_1
    //   1568: ldc_w 668
    //   1571: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: goto +16 -> 1591
    //   1578: iload 12
    //   1580: ifeq +11 -> 1591
    //   1583: aload_1
    //   1584: ldc_w 670
    //   1587: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: pop
    //   1591: aload_0
    //   1592: checkcast 657	com/tencent/mobileqq/text/QQText
    //   1595: aload_1
    //   1596: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1599: iconst_1
    //   1600: iconst_0
    //   1601: newarray int
    //   1603: invokevirtual 673	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   1606: astore 5
    //   1608: goto +601 -> 2209
    //   1611: astore_1
    //   1612: aload_0
    //   1613: astore 5
    //   1615: aload_1
    //   1616: astore_0
    //   1617: goto +600 -> 2217
    //   1620: goto +589 -> 2209
    //   1623: astore_0
    //   1624: goto +593 -> 2217
    //   1627: iload 8
    //   1629: sipush -1000
    //   1632: if_icmpne +136 -> 1768
    //   1635: aload_2
    //   1636: invokestatic 703	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/imcore/message/Message;)Lcom/tencent/mobileqq/text/QQText;
    //   1639: astore_0
    //   1640: aload_0
    //   1641: ifnull +126 -> 1767
    //   1644: new 153	java/lang/StringBuilder
    //   1647: dup
    //   1648: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1651: astore_1
    //   1652: aload 16
    //   1654: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1657: ifne +18 -> 1675
    //   1660: aload_1
    //   1661: aload 16
    //   1663: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: pop
    //   1667: aload_1
    //   1668: ldc_w 363
    //   1671: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: pop
    //   1675: aload 4
    //   1677: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1680: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1683: ifne +13 -> 1696
    //   1686: aload_1
    //   1687: aload 4
    //   1689: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1692: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   1695: pop
    //   1696: aload_2
    //   1697: invokestatic 285	com/tencent/biz/anonymous/AnonymousChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1700: ifne +32 -> 1732
    //   1703: iload 11
    //   1705: ifeq +14 -> 1719
    //   1708: aload_1
    //   1709: ldc_w 668
    //   1712: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: pop
    //   1716: goto +16 -> 1732
    //   1719: iload 12
    //   1721: ifeq +11 -> 1732
    //   1724: aload_1
    //   1725: ldc_w 670
    //   1728: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: pop
    //   1732: aload_0
    //   1733: checkcast 657	com/tencent/mobileqq/text/QQText
    //   1736: aload_1
    //   1737: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1740: iconst_1
    //   1741: iconst_0
    //   1742: newarray int
    //   1744: invokevirtual 673	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   1747: astore_0
    //   1748: aload 4
    //   1750: iconst_1
    //   1751: putfield 676	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   1754: aload 16
    //   1756: aload_0
    //   1757: aconst_null
    //   1758: iload 11
    //   1760: iload 12
    //   1762: aload 4
    //   1764: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1767: return
    //   1768: iload 8
    //   1770: sipush -2000
    //   1773: if_icmpne +436 -> 2209
    //   1776: aload_2
    //   1777: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   1780: astore 15
    //   1782: aload_2
    //   1783: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   1786: aload_2
    //   1787: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   1790: invokestatic 578	com/tencent/imcore/message/UinTypeUtil:c	(Ljava/lang/String;I)Z
    //   1793: ifeq +9 -> 1802
    //   1796: aload_2
    //   1797: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   1800: astore 15
    //   1802: aload_1
    //   1803: ldc_w 290
    //   1806: ldc 122
    //   1808: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1811: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   1814: astore 17
    //   1816: aload_2
    //   1817: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   1820: istore_3
    //   1821: aload 17
    //   1823: aload 15
    //   1825: iload_3
    //   1826: aload_2
    //   1827: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   1830: invokeinterface 300 5 0
    //   1835: checkcast 705	com/tencent/mobileqq/data/MessageForPic
    //   1838: astore 17
    //   1840: aload_1
    //   1841: ldc_w 707
    //   1844: ldc 122
    //   1846: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1849: checkcast 707	com/tencent/mobileqq/transfile/api/ITransFileController
    //   1852: aload 15
    //   1854: aload_2
    //   1855: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   1858: invokeinterface 711 4 0
    //   1863: astore 15
    //   1865: aload_2
    //   1866: invokevirtual 316	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   1869: ifeq +40 -> 1909
    //   1872: aload 17
    //   1874: getfield 714	com/tencent/mobileqq/data/MessageForPic:size	J
    //   1877: lconst_0
    //   1878: lcmp
    //   1879: ifgt +16 -> 1895
    //   1882: aload 15
    //   1884: ifnonnull +69 -> 1953
    //   1887: aload 17
    //   1889: ifnull +64 -> 1953
    //   1892: goto +6565 -> 8457
    //   1895: aload 17
    //   1897: getfield 717	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   1900: ldc_w 718
    //   1903: if_icmpne +50 -> 1953
    //   1906: goto +6551 -> 8457
    //   1909: aload 15
    //   1911: ifnull +42 -> 1953
    //   1914: aload 15
    //   1916: instanceof 720
    //   1919: ifeq +34 -> 1953
    //   1922: aload 15
    //   1924: checkcast 720	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   1927: invokevirtual 723	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   1930: lstore 13
    //   1932: lload 13
    //   1934: l2i
    //   1935: istore_3
    //   1936: iload_3
    //   1937: sipush 1005
    //   1940: if_icmpeq +6517 -> 8457
    //   1943: iload_3
    //   1944: sipush 1004
    //   1947: if_icmpne +6 -> 1953
    //   1950: goto +6507 -> 8457
    //   1953: iconst_0
    //   1954: istore 6
    //   1956: iload 6
    //   1958: istore 7
    //   1960: goto +22 -> 1982
    //   1963: astore_1
    //   1964: goto +11 -> 1975
    //   1967: astore_1
    //   1968: goto +4 -> 1972
    //   1971: astore_1
    //   1972: aconst_null
    //   1973: astore 15
    //   1975: aload_1
    //   1976: invokevirtual 466	java/lang/Exception:printStackTrace	()V
    //   1979: iconst_0
    //   1980: istore 7
    //   1982: aload 15
    //   1984: instanceof 720
    //   1987: ifeq +111 -> 2098
    //   1990: aload 15
    //   1992: checkcast 720	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   1995: astore_1
    //   1996: aload_1
    //   1997: invokevirtual 723	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   2000: ldc2_w 724
    //   2003: lcmp
    //   2004: ifeq +6459 -> 8463
    //   2007: iconst_1
    //   2008: istore 6
    //   2010: goto +3 -> 2013
    //   2013: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2016: ifeq +6461 -> 8477
    //   2019: aload_1
    //   2020: getfield 729	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   2023: ifnull +6446 -> 8469
    //   2026: aload_1
    //   2027: getfield 729	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   2030: getfield 734	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   2033: lstore 13
    //   2035: goto +3 -> 2038
    //   2038: new 153	java/lang/StringBuilder
    //   2041: dup
    //   2042: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2045: astore 15
    //   2047: aload 15
    //   2049: ldc_w 736
    //   2052: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: pop
    //   2056: aload 15
    //   2058: lload 13
    //   2060: invokevirtual 481	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2063: pop
    //   2064: aload 15
    //   2066: ldc_w 738
    //   2069: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: pop
    //   2073: aload 15
    //   2075: aload_1
    //   2076: invokevirtual 741	com/tencent/mobileqq/transfile/BaseTransProcessor:getKey	()Ljava/lang/String;
    //   2079: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: pop
    //   2083: ldc_w 743
    //   2086: iconst_2
    //   2087: aload 15
    //   2089: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2092: invokestatic 655	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2095: goto +6382 -> 8477
    //   2098: aload 15
    //   2100: ifnull +6386 -> 8486
    //   2103: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2106: ifeq +6374 -> 8480
    //   2109: new 153	java/lang/StringBuilder
    //   2112: dup
    //   2113: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2116: astore_1
    //   2117: aload_1
    //   2118: ldc_w 745
    //   2121: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: pop
    //   2125: aload_1
    //   2126: aload 15
    //   2128: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2131: pop
    //   2132: ldc_w 743
    //   2135: iconst_2
    //   2136: aload_1
    //   2137: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2140: invokestatic 655	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2143: goto +6337 -> 8480
    //   2146: aload_0
    //   2147: ldc_w 746
    //   2150: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   2153: astore_1
    //   2154: aload_2
    //   2155: invokestatic 749	com/tencent/mobileqq/app/HotChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2158: ifne +21 -> 2179
    //   2161: ldc_w 751
    //   2164: invokestatic 542	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2167: checkcast 751	com/tencent/mobileqq/pic/api/IPicFlash
    //   2170: aload_2
    //   2171: invokeinterface 754 2 0
    //   2176: ifeq +11 -> 2187
    //   2179: aload_0
    //   2180: ldc_w 755
    //   2183: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   2186: astore_1
    //   2187: aload 16
    //   2189: aload_1
    //   2190: aconst_null
    //   2191: iload 7
    //   2193: iload 6
    //   2195: aload 4
    //   2197: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2200: return
    //   2201: astore_0
    //   2202: goto +15 -> 2217
    //   2205: astore_0
    //   2206: goto +11 -> 2217
    //   2209: goto +24 -> 2233
    //   2212: astore_0
    //   2213: ldc 122
    //   2215: astore 5
    //   2217: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2220: ifeq +13 -> 2233
    //   2223: ldc_w 757
    //   2226: iconst_2
    //   2227: ldc 122
    //   2229: aload_0
    //   2230: invokestatic 760	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2233: aload 16
    //   2235: aload 5
    //   2237: aconst_null
    //   2238: iload 11
    //   2240: iload 12
    //   2242: aload 4
    //   2244: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2247: return
    //   2248: aload_2
    //   2249: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2252: invokestatic 762	com/tencent/mobileqq/utils/ActionMsgUtil:e	(I)Z
    //   2255: ifeq +49 -> 2304
    //   2258: aload_1
    //   2259: aload_2
    //   2260: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2263: istore 6
    //   2265: aload_1
    //   2266: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   2269: aload_2
    //   2270: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2273: istore 7
    //   2275: aload 16
    //   2277: ldc_w 764
    //   2280: invokestatic 542	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2283: checkcast 764	com/tencent/mobileqq/apollo/utils/api/IApolloMessageUtil
    //   2286: aload_1
    //   2287: aload_2
    //   2288: invokeinterface 768 3 0
    //   2293: aconst_null
    //   2294: iload 6
    //   2296: iload 7
    //   2298: aload 4
    //   2300: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2303: return
    //   2304: aload_2
    //   2305: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2308: sipush -1013
    //   2311: if_icmpeq +5366 -> 7677
    //   2314: aload_2
    //   2315: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2318: sipush -1047
    //   2321: if_icmpne +6 -> 2327
    //   2324: goto +5353 -> 7677
    //   2327: aload_2
    //   2328: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2331: sipush -2042
    //   2334: if_icmpeq +5326 -> 7660
    //   2337: aload_2
    //   2338: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2341: sipush -2043
    //   2344: if_icmpne +6 -> 2350
    //   2347: goto +5313 -> 7660
    //   2350: aload_2
    //   2351: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2354: sipush -2051
    //   2357: if_icmpne +184 -> 2541
    //   2360: aload_1
    //   2361: ldc_w 290
    //   2364: ldc 122
    //   2366: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2369: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   2372: aload_2
    //   2373: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2376: aload_2
    //   2377: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   2380: aload_2
    //   2381: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   2384: invokeinterface 300 5 0
    //   2389: astore_0
    //   2390: aload_0
    //   2391: ifnull +53 -> 2444
    //   2394: aload_0
    //   2395: instanceof 770
    //   2398: ifeq +46 -> 2444
    //   2401: aload_0
    //   2402: checkcast 770	com/tencent/mobileqq/data/MessageForQQStory
    //   2405: astore_0
    //   2406: aload_0
    //   2407: invokevirtual 771	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   2410: aload_1
    //   2411: aload_2
    //   2412: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2415: istore 6
    //   2417: aload_1
    //   2418: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   2421: aload_2
    //   2422: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2425: istore 7
    //   2427: aload 16
    //   2429: aconst_null
    //   2430: aload_0
    //   2431: invokevirtual 772	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   2434: iload 6
    //   2436: iload 7
    //   2438: aload 4
    //   2440: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2443: return
    //   2444: new 153	java/lang/StringBuilder
    //   2447: dup
    //   2448: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2451: astore_1
    //   2452: aload_1
    //   2453: ldc 2
    //   2455: invokevirtual 777	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2458: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2461: pop
    //   2462: aload_1
    //   2463: ldc_w 779
    //   2466: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2469: pop
    //   2470: aload_1
    //   2471: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2474: astore_1
    //   2475: new 153	java/lang/StringBuilder
    //   2478: dup
    //   2479: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2482: astore 4
    //   2484: aload 4
    //   2486: ldc_w 781
    //   2489: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2492: pop
    //   2493: aload 4
    //   2495: aload_2
    //   2496: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   2499: invokevirtual 481	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2502: pop
    //   2503: aload 4
    //   2505: ldc_w 783
    //   2508: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2511: pop
    //   2512: aload_0
    //   2513: ifnull +9 -> 2522
    //   2516: aload_0
    //   2517: invokevirtual 786	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   2520: astore 5
    //   2522: aload 4
    //   2524: aload 5
    //   2526: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2529: pop
    //   2530: aload_1
    //   2531: iconst_1
    //   2532: aload 4
    //   2534: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2537: invokestatic 788	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2540: return
    //   2541: aload_2
    //   2542: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2545: sipush -7002
    //   2548: if_icmpne +169 -> 2717
    //   2551: aload_1
    //   2552: ldc_w 290
    //   2555: ldc 122
    //   2557: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2560: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   2563: aload_2
    //   2564: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2567: aload_2
    //   2568: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   2571: aload_2
    //   2572: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   2575: invokeinterface 300 5 0
    //   2580: checkcast 790	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   2583: astore_0
    //   2584: aload_0
    //   2585: ifnull +41 -> 2626
    //   2588: aload_0
    //   2589: invokevirtual 791	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   2592: aload_1
    //   2593: aload_2
    //   2594: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2597: istore 6
    //   2599: aload_1
    //   2600: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   2603: aload_2
    //   2604: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2607: istore 7
    //   2609: aload 16
    //   2611: aconst_null
    //   2612: aload_0
    //   2613: invokevirtual 792	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   2616: iload 6
    //   2618: iload 7
    //   2620: aload 4
    //   2622: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2625: return
    //   2626: new 153	java/lang/StringBuilder
    //   2629: dup
    //   2630: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2633: astore_0
    //   2634: aload_0
    //   2635: ldc 2
    //   2637: invokevirtual 777	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2640: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2643: pop
    //   2644: aload_0
    //   2645: ldc_w 779
    //   2648: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2651: pop
    //   2652: aload_0
    //   2653: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2656: astore_0
    //   2657: new 153	java/lang/StringBuilder
    //   2660: dup
    //   2661: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2664: astore_1
    //   2665: aload_1
    //   2666: ldc_w 794
    //   2669: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2672: pop
    //   2673: aload_1
    //   2674: aload_2
    //   2675: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   2678: invokevirtual 481	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2681: pop
    //   2682: aload_1
    //   2683: ldc_w 783
    //   2686: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2689: pop
    //   2690: aload_2
    //   2691: ifnull +9 -> 2700
    //   2694: aload_2
    //   2695: invokevirtual 795	com/tencent/imcore/message/Message:toString	()Ljava/lang/String;
    //   2698: astore 5
    //   2700: aload_1
    //   2701: aload 5
    //   2703: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2706: pop
    //   2707: aload_0
    //   2708: iconst_1
    //   2709: aload_1
    //   2710: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2713: invokestatic 788	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2716: return
    //   2717: aload_2
    //   2718: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2721: sipush -2054
    //   2724: if_icmpne +182 -> 2906
    //   2727: aload_1
    //   2728: ldc_w 290
    //   2731: ldc 122
    //   2733: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2736: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   2739: aload_2
    //   2740: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2743: aload_2
    //   2744: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   2747: aload_2
    //   2748: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   2751: invokeinterface 300 5 0
    //   2756: astore_0
    //   2757: aload_0
    //   2758: instanceof 797
    //   2761: ifeq +45 -> 2806
    //   2764: aload_0
    //   2765: checkcast 797	com/tencent/mobileqq/data/MessageForTroopSign
    //   2768: astore_0
    //   2769: ldc_w 798
    //   2772: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2775: pop
    //   2776: aload_0
    //   2777: invokevirtual 799	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   2780: aload 16
    //   2782: aconst_null
    //   2783: aload_0
    //   2784: invokevirtual 800	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   2787: aload_1
    //   2788: aload_2
    //   2789: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2792: aload_1
    //   2793: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   2796: aload_2
    //   2797: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2800: aload 4
    //   2802: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2805: return
    //   2806: new 153	java/lang/StringBuilder
    //   2809: dup
    //   2810: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2813: astore_1
    //   2814: aload_1
    //   2815: ldc 2
    //   2817: invokevirtual 777	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2820: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2823: pop
    //   2824: aload_1
    //   2825: ldc_w 802
    //   2828: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2831: pop
    //   2832: aload_1
    //   2833: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2836: astore_1
    //   2837: new 153	java/lang/StringBuilder
    //   2840: dup
    //   2841: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2844: astore 4
    //   2846: aload 4
    //   2848: ldc_w 804
    //   2851: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2854: pop
    //   2855: aload 4
    //   2857: aload_2
    //   2858: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   2861: invokevirtual 481	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2864: pop
    //   2865: aload 4
    //   2867: ldc_w 783
    //   2870: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2873: pop
    //   2874: aload_0
    //   2875: ifnull +12 -> 2887
    //   2878: aload_0
    //   2879: getfield 805	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2882: invokestatic 808	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2885: astore 5
    //   2887: aload 4
    //   2889: aload 5
    //   2891: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2894: pop
    //   2895: aload_1
    //   2896: iconst_1
    //   2897: aload 4
    //   2899: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2902: invokestatic 788	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2905: return
    //   2906: aload_2
    //   2907: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2910: sipush -2035
    //   2913: if_icmpne +20 -> 2933
    //   2916: aconst_null
    //   2917: aload_2
    //   2918: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   2921: invokestatic 523	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   2924: aconst_null
    //   2925: iconst_0
    //   2926: iconst_0
    //   2927: aload 4
    //   2929: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2932: return
    //   2933: aload_2
    //   2934: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   2937: sipush -2038
    //   2940: if_icmpne +236 -> 3176
    //   2943: aload_2
    //   2944: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2947: astore 5
    //   2949: aload 5
    //   2951: astore_0
    //   2952: getstatic 813	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   2955: aload 5
    //   2957: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2960: ifeq +8 -> 2968
    //   2963: aload_2
    //   2964: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   2967: astore_0
    //   2968: aload_0
    //   2969: astore 5
    //   2971: getstatic 816	com/tencent/mobileqq/app/AppConstants:LBS_HELLO_UIN	Ljava/lang/String;
    //   2974: aload_0
    //   2975: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2978: ifeq +78 -> 3056
    //   2981: getstatic 813	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   2984: aload_2
    //   2985: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   2988: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2991: ifeq +59 -> 3050
    //   2994: aload_1
    //   2995: ldc_w 290
    //   2998: ldc 122
    //   3000: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3003: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3006: getstatic 813	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   3009: aload_2
    //   3010: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   3013: aload_2
    //   3014: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   3017: invokeinterface 300 5 0
    //   3022: checkcast 818	com/tencent/mobileqq/data/MessageForTroopGift
    //   3025: astore 15
    //   3027: aload_0
    //   3028: astore 5
    //   3030: aload 15
    //   3032: ifnull +24 -> 3056
    //   3035: aload 15
    //   3037: invokevirtual 819	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3040: aload 15
    //   3042: getfield 820	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   3045: astore 5
    //   3047: goto +9 -> 3056
    //   3050: aload_2
    //   3051: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   3054: astore 5
    //   3056: aload_1
    //   3057: ldc_w 290
    //   3060: ldc 122
    //   3062: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3065: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3068: aload 5
    //   3070: aload_2
    //   3071: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   3074: aload_2
    //   3075: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   3078: invokeinterface 300 5 0
    //   3083: astore_0
    //   3084: aload_0
    //   3085: instanceof 818
    //   3088: ifeq +41 -> 3129
    //   3091: aload_0
    //   3092: checkcast 818	com/tencent/mobileqq/data/MessageForTroopGift
    //   3095: astore_0
    //   3096: aload_0
    //   3097: invokevirtual 819	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3100: aload_0
    //   3101: getfield 821	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3104: ifnull +11 -> 3115
    //   3107: aload_0
    //   3108: getfield 821	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3111: astore_0
    //   3112: goto +6 -> 3118
    //   3115: ldc 122
    //   3117: astore_0
    //   3118: aconst_null
    //   3119: aload_0
    //   3120: aconst_null
    //   3121: iconst_0
    //   3122: iconst_0
    //   3123: aload 4
    //   3125: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3128: return
    //   3129: aload_0
    //   3130: ifnull +5326 -> 8456
    //   3133: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3136: ifeq +5320 -> 8456
    //   3139: new 153	java/lang/StringBuilder
    //   3142: dup
    //   3143: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3146: astore_1
    //   3147: aload_1
    //   3148: ldc_w 823
    //   3151: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3154: pop
    //   3155: aload_1
    //   3156: aload_0
    //   3157: invokevirtual 786	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3160: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3163: pop
    //   3164: ldc_w 757
    //   3167: iconst_2
    //   3168: aload_1
    //   3169: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3172: invokestatic 788	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3175: return
    //   3176: aload_2
    //   3177: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3180: sipush -2036
    //   3183: if_icmpne +58 -> 3241
    //   3186: aload_1
    //   3187: ldc_w 290
    //   3190: ldc 122
    //   3192: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3195: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3198: aload_2
    //   3199: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3202: aload_2
    //   3203: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   3206: aload_2
    //   3207: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   3210: invokeinterface 300 5 0
    //   3215: checkcast 825	com/tencent/mobileqq/data/MessageForTroopFee
    //   3218: astore_0
    //   3219: aload_0
    //   3220: ifnull +5236 -> 8456
    //   3223: aload_0
    //   3224: invokevirtual 826	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3227: aconst_null
    //   3228: aload_0
    //   3229: getfield 827	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3232: aconst_null
    //   3233: iconst_0
    //   3234: iconst_0
    //   3235: aload 4
    //   3237: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3240: return
    //   3241: aload_2
    //   3242: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3245: sipush -2069
    //   3248: if_icmpne +58 -> 3306
    //   3251: aload_1
    //   3252: ldc_w 290
    //   3255: ldc 122
    //   3257: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3260: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3263: aload_2
    //   3264: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3267: aload_2
    //   3268: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   3271: aload_2
    //   3272: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   3275: invokeinterface 300 5 0
    //   3280: checkcast 829	com/tencent/mobileqq/data/MessageForStarLeague
    //   3283: astore_0
    //   3284: aload_0
    //   3285: ifnull +5171 -> 8456
    //   3288: aload_0
    //   3289: invokevirtual 830	com/tencent/mobileqq/data/MessageForStarLeague:parse	()V
    //   3292: aconst_null
    //   3293: aload_0
    //   3294: getfield 831	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   3297: aconst_null
    //   3298: iconst_0
    //   3299: iconst_0
    //   3300: aload 4
    //   3302: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3305: return
    //   3306: aload_2
    //   3307: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3310: sipush -2048
    //   3313: if_icmpne +59 -> 3372
    //   3316: aload_1
    //   3317: ldc_w 290
    //   3320: ldc 122
    //   3322: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3325: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3328: aload_2
    //   3329: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3332: aload_2
    //   3333: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   3336: aload_2
    //   3337: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   3340: invokeinterface 300 5 0
    //   3345: checkcast 833	com/tencent/mobileqq/data/MessageForTroopReward
    //   3348: astore_0
    //   3349: aload_0
    //   3350: ifnull +5106 -> 8456
    //   3353: aload_0
    //   3354: invokevirtual 834	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3357: aload 16
    //   3359: aload_0
    //   3360: getfield 835	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3363: aconst_null
    //   3364: iconst_0
    //   3365: iconst_0
    //   3366: aload 4
    //   3368: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3371: return
    //   3372: aload_2
    //   3373: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   3376: iconst_1
    //   3377: if_icmpne +148 -> 3525
    //   3380: aload_2
    //   3381: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3384: sipush -3006
    //   3387: if_icmpne +138 -> 3525
    //   3390: aload_1
    //   3391: ldc_w 290
    //   3394: ldc 122
    //   3396: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3399: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3402: aload_2
    //   3403: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3406: aload_2
    //   3407: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   3410: aload_2
    //   3411: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   3414: invokeinterface 300 5 0
    //   3419: checkcast 837	com/tencent/mobileqq/data/MessageForPubAccount
    //   3422: astore_0
    //   3423: aload_0
    //   3424: ifnull +5032 -> 8456
    //   3427: aload_0
    //   3428: invokevirtual 838	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   3431: aload_1
    //   3432: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   3435: aload_0
    //   3436: iconst_0
    //   3437: invokestatic 842	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   3440: astore 5
    //   3442: aload_0
    //   3443: invokevirtual 845	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   3446: ifne +8 -> 3454
    //   3449: aconst_null
    //   3450: astore_0
    //   3451: goto +14 -> 3465
    //   3454: aload_1
    //   3455: invokevirtual 532	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3458: ldc_w 846
    //   3461: invokevirtual 165	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3464: astore_0
    //   3465: aload_2
    //   3466: getfield 509	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   3469: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3472: ifne +41 -> 3513
    //   3475: aload_0
    //   3476: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3479: ifne +34 -> 3513
    //   3482: new 153	java/lang/StringBuilder
    //   3485: dup
    //   3486: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3489: astore_1
    //   3490: aload_1
    //   3491: aload_2
    //   3492: getfield 509	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   3495: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3498: pop
    //   3499: aload_1
    //   3500: aload_0
    //   3501: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3504: pop
    //   3505: aload_1
    //   3506: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3509: astore_0
    //   3510: goto +3 -> 3513
    //   3513: aload_0
    //   3514: aload 5
    //   3516: aconst_null
    //   3517: iconst_0
    //   3518: iconst_0
    //   3519: aload 4
    //   3521: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3524: return
    //   3525: aload_2
    //   3526: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3529: sipush -1034
    //   3532: if_icmpne +106 -> 3638
    //   3535: new 848	com/tencent/mobileqq/data/MessageForRichState
    //   3538: dup
    //   3539: invokespecial 849	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   3542: astore_0
    //   3543: aload_0
    //   3544: aload_2
    //   3545: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3548: putfield 850	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   3551: aload_0
    //   3552: invokevirtual 851	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   3555: new 153	java/lang/StringBuilder
    //   3558: dup
    //   3559: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3562: astore_1
    //   3563: aload_0
    //   3564: getfield 854	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   3567: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3570: ifne +38 -> 3608
    //   3573: aload_1
    //   3574: aload_0
    //   3575: getfield 854	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   3578: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3581: pop
    //   3582: aload_0
    //   3583: getfield 857	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   3586: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3589: ifne +12 -> 3601
    //   3592: aload_1
    //   3593: aload_0
    //   3594: getfield 857	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   3597: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3600: pop
    //   3601: aload_1
    //   3602: bipush 32
    //   3604: invokevirtual 860	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3607: pop
    //   3608: aload_1
    //   3609: aload_0
    //   3610: invokevirtual 863	com/tencent/mobileqq/data/MessageForRichState:getPlainMsg	()Ljava/lang/String;
    //   3613: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3616: pop
    //   3617: aload_1
    //   3618: invokevirtual 864	java/lang/StringBuilder:length	()I
    //   3621: ifle +4835 -> 8456
    //   3624: aconst_null
    //   3625: aload_1
    //   3626: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3629: aconst_null
    //   3630: iconst_0
    //   3631: iconst_0
    //   3632: aload 4
    //   3634: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3637: return
    //   3638: aload_2
    //   3639: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3642: sipush -2074
    //   3645: if_icmpne +47 -> 3692
    //   3648: new 866	com/tencent/mobileqq/data/MessageForAIOStoryVideo
    //   3651: dup
    //   3652: invokespecial 867	com/tencent/mobileqq/data/MessageForAIOStoryVideo:<init>	()V
    //   3655: astore_0
    //   3656: aload_0
    //   3657: aload_2
    //   3658: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3661: putfield 868	com/tencent/mobileqq/data/MessageForAIOStoryVideo:msg	Ljava/lang/String;
    //   3664: aload_0
    //   3665: invokevirtual 869	com/tencent/mobileqq/data/MessageForAIOStoryVideo:parse	()V
    //   3668: aload_0
    //   3669: getfield 872	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   3672: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3675: ifne +4781 -> 8456
    //   3678: aconst_null
    //   3679: aload_0
    //   3680: getfield 872	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   3683: aconst_null
    //   3684: iconst_0
    //   3685: iconst_0
    //   3686: aload 4
    //   3688: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3691: return
    //   3692: aload_2
    //   3693: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3696: sipush -1019
    //   3699: if_icmpne +56 -> 3755
    //   3702: new 153	java/lang/StringBuilder
    //   3705: dup
    //   3706: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3709: astore_0
    //   3710: aload_0
    //   3711: ldc_w 873
    //   3714: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3717: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3720: pop
    //   3721: aload_0
    //   3722: aload_2
    //   3723: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3726: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3729: pop
    //   3730: aload_0
    //   3731: ldc_w 874
    //   3734: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3737: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3740: pop
    //   3741: aconst_null
    //   3742: aconst_null
    //   3743: aload_0
    //   3744: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3747: iconst_0
    //   3748: iconst_0
    //   3749: aload 4
    //   3751: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3754: return
    //   3755: aload_2
    //   3756: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3759: sipush -1018
    //   3762: if_icmpne +56 -> 3818
    //   3765: new 153	java/lang/StringBuilder
    //   3768: dup
    //   3769: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3772: astore_0
    //   3773: aload_0
    //   3774: ldc_w 875
    //   3777: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3780: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3783: pop
    //   3784: aload_0
    //   3785: aload_2
    //   3786: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3789: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3792: pop
    //   3793: aload_0
    //   3794: ldc_w 876
    //   3797: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3800: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3803: pop
    //   3804: aconst_null
    //   3805: aconst_null
    //   3806: aload_0
    //   3807: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3810: iconst_0
    //   3811: iconst_0
    //   3812: aload 4
    //   3814: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3817: return
    //   3818: aload_2
    //   3819: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3822: sipush -2019
    //   3825: if_icmpne +16 -> 3841
    //   3828: aload 4
    //   3830: aload_0
    //   3831: ldc_w 877
    //   3834: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   3837: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3840: return
    //   3841: aload_2
    //   3842: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3845: sipush -7006
    //   3848: if_icmpne +16 -> 3864
    //   3851: aload 4
    //   3853: aload_0
    //   3854: ldc_w 878
    //   3857: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   3860: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3863: return
    //   3864: aload_2
    //   3865: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3868: sipush -1026
    //   3871: if_icmpne +16 -> 3887
    //   3874: aload 4
    //   3876: aload_0
    //   3877: ldc_w 879
    //   3880: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   3883: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3886: return
    //   3887: aload_2
    //   3888: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3891: sipush -1027
    //   3894: if_icmpne +16 -> 3910
    //   3897: aload 4
    //   3899: aload_0
    //   3900: ldc_w 880
    //   3903: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   3906: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3909: return
    //   3910: aload_2
    //   3911: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3914: sipush -4028
    //   3917: if_icmpne +16 -> 3933
    //   3920: aload 4
    //   3922: aload_0
    //   3923: ldc_w 881
    //   3926: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   3929: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3932: return
    //   3933: aload_2
    //   3934: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   3937: sipush -2005
    //   3940: if_icmpne +70 -> 4010
    //   3943: aload_1
    //   3944: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   3947: astore 5
    //   3949: aload 5
    //   3951: aload_2
    //   3952: invokestatic 884	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   3955: astore 15
    //   3957: aload_1
    //   3958: aload_2
    //   3959: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3962: istore 6
    //   3964: aload 5
    //   3966: aload_2
    //   3967: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3970: istore 7
    //   3972: aload 16
    //   3974: aload_0
    //   3975: ldc_w 885
    //   3978: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   3981: aconst_null
    //   3982: iload 6
    //   3984: iload 7
    //   3986: aload 4
    //   3988: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3991: aload 15
    //   3993: ifnull +10 -> 4003
    //   3996: aload 4
    //   3998: aload 15
    //   4000: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4003: aload 4
    //   4005: iconst_0
    //   4006: putfield 888	com/tencent/mobileqq/activity/recent/MsgSummary:nState	I
    //   4009: return
    //   4010: aload_2
    //   4011: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4014: sipush -3017
    //   4017: if_icmpne +180 -> 4197
    //   4020: aload_1
    //   4021: ldc_w 290
    //   4024: ldc 122
    //   4026: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   4029: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   4032: aload_2
    //   4033: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4036: aload_2
    //   4037: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   4040: aload_2
    //   4041: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   4044: invokeinterface 300 5 0
    //   4049: astore 17
    //   4051: aload 5
    //   4053: astore 15
    //   4055: aload 17
    //   4057: ifnull +88 -> 4145
    //   4060: aload 5
    //   4062: astore 15
    //   4064: aload 17
    //   4066: instanceof 890
    //   4069: ifeq +76 -> 4145
    //   4072: aload 17
    //   4074: checkcast 890	com/tencent/mobileqq/data/MessageForDLFile
    //   4077: astore 5
    //   4079: aload 5
    //   4081: getfield 893	com/tencent/mobileqq/data/MessageForDLFile:fileName	Ljava/lang/String;
    //   4084: invokestatic 895	com/tencent/mobileqq/filemanager/util/FileManagerUtil:c	(Ljava/lang/String;)I
    //   4087: invokestatic 896	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(I)Ljava/lang/String;
    //   4090: astore 15
    //   4092: new 153	java/lang/StringBuilder
    //   4095: dup
    //   4096: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   4099: astore 17
    //   4101: aload 17
    //   4103: ldc_w 898
    //   4106: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4109: pop
    //   4110: aload 17
    //   4112: aload 15
    //   4114: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4117: pop
    //   4118: aload 17
    //   4120: ldc_w 900
    //   4123: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4126: pop
    //   4127: aload 17
    //   4129: aload 5
    //   4131: getfield 893	com/tencent/mobileqq/data/MessageForDLFile:fileName	Ljava/lang/String;
    //   4134: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4137: pop
    //   4138: aload 17
    //   4140: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4143: astore 15
    //   4145: aload_1
    //   4146: aload_2
    //   4147: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   4150: istore 6
    //   4152: aload_1
    //   4153: aload_2
    //   4154: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   4157: istore 7
    //   4159: aload 16
    //   4161: aload_0
    //   4162: ldc_w 885
    //   4165: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   4168: aconst_null
    //   4169: iload 6
    //   4171: iload 7
    //   4173: aload 4
    //   4175: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4178: aload 15
    //   4180: ifnull +10 -> 4190
    //   4183: aload 4
    //   4185: aload 15
    //   4187: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4190: aload 4
    //   4192: iconst_0
    //   4193: putfield 888	com/tencent/mobileqq/activity/recent/MsgSummary:nState	I
    //   4196: return
    //   4197: aload_2
    //   4198: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4201: sipush -2022
    //   4204: if_icmpeq +2740 -> 6944
    //   4207: aload_2
    //   4208: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4211: sipush -2071
    //   4214: if_icmpne +6 -> 4220
    //   4217: goto +2727 -> 6944
    //   4220: aload_2
    //   4221: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4224: sipush -5002
    //   4227: if_icmpne +40 -> 4267
    //   4230: new 902	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   4233: dup
    //   4234: invokespecial 903	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   4237: astore_0
    //   4238: aload_0
    //   4239: aload_2
    //   4240: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   4243: putfield 904	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   4246: aload_0
    //   4247: invokevirtual 905	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   4250: aload_0
    //   4251: getfield 906	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   4254: ifnull +4202 -> 8456
    //   4257: aload 4
    //   4259: aload_0
    //   4260: getfield 906	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   4263: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4266: return
    //   4267: aload_2
    //   4268: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4271: sipush -2029
    //   4274: if_icmpne +174 -> 4448
    //   4277: aload_1
    //   4278: ldc_w 290
    //   4281: ldc 122
    //   4283: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   4286: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   4289: aload_2
    //   4290: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4293: aload_2
    //   4294: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   4297: aload_2
    //   4298: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   4301: invokeinterface 300 5 0
    //   4306: astore_0
    //   4307: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4310: ifeq +40 -> 4350
    //   4313: new 153	java/lang/StringBuilder
    //   4316: dup
    //   4317: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   4320: astore 5
    //   4322: aload 5
    //   4324: ldc_w 908
    //   4327: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4330: pop
    //   4331: aload 5
    //   4333: aload_0
    //   4334: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4337: pop
    //   4338: ldc_w 450
    //   4341: iconst_2
    //   4342: aload 5
    //   4344: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4347: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4350: aload_0
    //   4351: instanceof 910
    //   4354: ifeq +4102 -> 8456
    //   4357: aload_0
    //   4358: checkcast 910	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   4361: astore_0
    //   4362: aload_0
    //   4363: aload_2
    //   4364: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   4367: putfield 911	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   4370: aload_0
    //   4371: invokevirtual 912	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   4374: aload_0
    //   4375: aload_1
    //   4376: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   4379: aload_1
    //   4380: invokevirtual 532	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4383: aconst_null
    //   4384: invokevirtual 916	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   4387: aload_0
    //   4388: getfield 919	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4391: ifnull +4065 -> 8456
    //   4394: aload_0
    //   4395: getfield 922	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   4398: iconst_1
    //   4399: if_icmpne +39 -> 4438
    //   4402: new 153	java/lang/StringBuilder
    //   4405: dup
    //   4406: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   4409: astore_1
    //   4410: aload_1
    //   4411: ldc_w 923
    //   4414: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   4417: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4420: pop
    //   4421: aload_1
    //   4422: aload_0
    //   4423: getfield 919	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4426: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4429: pop
    //   4430: aload_0
    //   4431: aload_1
    //   4432: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4435: putfield 919	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4438: aload 4
    //   4440: aload_0
    //   4441: getfield 919	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4444: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4447: return
    //   4448: aload_2
    //   4449: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4452: sipush -2025
    //   4455: if_icmpeq +2479 -> 6934
    //   4458: aload_2
    //   4459: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4462: sipush -2072
    //   4465: if_icmpne +6 -> 4471
    //   4468: goto +2466 -> 6934
    //   4471: aload_2
    //   4472: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4475: sipush -2076
    //   4478: if_icmpne +58 -> 4536
    //   4481: new 925	com/tencent/mobileqq/data/MessageForLocationShare
    //   4484: dup
    //   4485: invokespecial 926	com/tencent/mobileqq/data/MessageForLocationShare:<init>	()V
    //   4488: astore_1
    //   4489: aload_1
    //   4490: aload_2
    //   4491: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   4494: putfield 927	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   4497: aload_1
    //   4498: invokevirtual 928	com/tencent/mobileqq/data/MessageForLocationShare:parse	()V
    //   4501: aload_1
    //   4502: getfield 929	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   4505: astore_2
    //   4506: aload_2
    //   4507: astore_1
    //   4508: aload_2
    //   4509: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4512: ifeq +11 -> 4523
    //   4515: aload_0
    //   4516: ldc_w 930
    //   4519: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   4522: astore_1
    //   4523: aload 16
    //   4525: ldc 122
    //   4527: aload_1
    //   4528: iconst_0
    //   4529: iconst_0
    //   4530: aload 4
    //   4532: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4535: return
    //   4536: aload_2
    //   4537: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4540: sipush -2052
    //   4543: if_icmpne +85 -> 4628
    //   4546: aload_2
    //   4547: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4550: astore_0
    //   4551: aload_2
    //   4552: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4555: aload_2
    //   4556: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   4559: invokestatic 578	com/tencent/imcore/message/UinTypeUtil:c	(Ljava/lang/String;I)Z
    //   4562: ifeq +8 -> 4570
    //   4565: aload_2
    //   4566: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   4569: astore_0
    //   4570: aload_1
    //   4571: ldc_w 290
    //   4574: ldc 122
    //   4576: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   4579: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   4582: aload_0
    //   4583: aload_2
    //   4584: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   4587: aload_2
    //   4588: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   4591: invokeinterface 300 5 0
    //   4596: astore_0
    //   4597: aload_0
    //   4598: instanceof 932
    //   4601: ifeq +3855 -> 8456
    //   4604: aload_0
    //   4605: checkcast 932	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   4608: astore_0
    //   4609: aload_0
    //   4610: invokevirtual 933	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   4613: aload 16
    //   4615: aload_0
    //   4616: invokevirtual 934	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   4619: aconst_null
    //   4620: iconst_0
    //   4621: iconst_0
    //   4622: aload 4
    //   4624: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4627: return
    //   4628: aload_2
    //   4629: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4632: sipush -2047
    //   4635: if_icmpne +51 -> 4686
    //   4638: new 936	com/tencent/mobileqq/data/MessageForVIPDonate
    //   4641: dup
    //   4642: invokespecial 937	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   4645: astore_0
    //   4646: aload_0
    //   4647: aload_2
    //   4648: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   4651: putfield 938	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   4654: aload_0
    //   4655: invokevirtual 939	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   4658: aload_0
    //   4659: invokevirtual 940	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   4662: astore_0
    //   4663: aload_0
    //   4664: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4667: ifne +10 -> 4677
    //   4670: aload 4
    //   4672: aload_0
    //   4673: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4676: return
    //   4677: aload 4
    //   4679: ldc_w 942
    //   4682: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4685: return
    //   4686: aload_2
    //   4687: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4690: sipush -2040
    //   4693: if_icmpne +29 -> 4722
    //   4696: new 944	com/tencent/mobileqq/data/MessageForApproval
    //   4699: dup
    //   4700: invokespecial 945	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   4703: astore_0
    //   4704: aload_0
    //   4705: aload_2
    //   4706: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   4709: putfield 946	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   4712: aload 4
    //   4714: aload_0
    //   4715: invokevirtual 949	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   4718: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4721: return
    //   4722: aload_2
    //   4723: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4726: sipush -2041
    //   4729: if_icmpne +57 -> 4786
    //   4732: aload_0
    //   4733: ldc_w 950
    //   4736: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   4739: astore_1
    //   4740: aload_0
    //   4741: ldc_w 951
    //   4744: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   4747: astore_0
    //   4748: new 153	java/lang/StringBuilder
    //   4751: dup
    //   4752: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   4755: astore_2
    //   4756: aload_2
    //   4757: aload_1
    //   4758: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4761: pop
    //   4762: aload_2
    //   4763: ldc_w 488
    //   4766: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4769: pop
    //   4770: aload_2
    //   4771: aload_0
    //   4772: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4775: pop
    //   4776: aload 4
    //   4778: aload_2
    //   4779: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4782: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4785: return
    //   4786: aload_2
    //   4787: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   4790: sipush -7001
    //   4793: if_icmpne +173 -> 4966
    //   4796: aload_2
    //   4797: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4800: astore 5
    //   4802: aload_2
    //   4803: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4806: aload_2
    //   4807: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   4810: invokestatic 578	com/tencent/imcore/message/UinTypeUtil:c	(Ljava/lang/String;I)Z
    //   4813: ifeq +9 -> 4822
    //   4816: aload_2
    //   4817: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   4820: astore 5
    //   4822: aload_1
    //   4823: ldc_w 290
    //   4826: ldc 122
    //   4828: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   4831: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   4834: aload 5
    //   4836: aload_2
    //   4837: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   4840: aload_2
    //   4841: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   4844: invokeinterface 300 5 0
    //   4849: checkcast 953	com/tencent/mobileqq/data/MessageForScribble
    //   4852: astore_1
    //   4853: aload_1
    //   4854: invokevirtual 954	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   4857: ifeq +31 -> 4888
    //   4860: aload_1
    //   4861: getfield 957	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   4864: iconst_2
    //   4865: if_icmpne +6 -> 4871
    //   4868: goto +3624 -> 8492
    //   4871: aload_1
    //   4872: getfield 957	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   4875: iconst_3
    //   4876: if_icmpne +50 -> 4926
    //   4879: iconst_0
    //   4880: istore 7
    //   4882: iconst_1
    //   4883: istore 6
    //   4885: goto +47 -> 4932
    //   4888: aload_1
    //   4889: getfield 960	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   4892: iconst_2
    //   4893: if_icmpne +33 -> 4926
    //   4896: ldc_w 962
    //   4899: invokestatic 542	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   4902: checkcast 962	com/tencent/mobileqq/scribble/IScribbleMsgUtils
    //   4905: aload_1
    //   4906: invokeinterface 966 2 0
    //   4911: istore_3
    //   4912: getstatic 969	com/tencent/mobileqq/scribble/ScribbleMsgConstants:c	I
    //   4915: istore 8
    //   4917: iload_3
    //   4918: iload 8
    //   4920: if_icmpeq +6 -> 4926
    //   4923: goto +3569 -> 8492
    //   4926: iconst_0
    //   4927: istore 7
    //   4929: iconst_0
    //   4930: istore 6
    //   4932: goto +14 -> 4946
    //   4935: astore_1
    //   4936: aload_1
    //   4937: invokevirtual 466	java/lang/Exception:printStackTrace	()V
    //   4940: iconst_0
    //   4941: istore 7
    //   4943: iconst_0
    //   4944: istore 6
    //   4946: aload 16
    //   4948: aload_0
    //   4949: ldc_w 970
    //   4952: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   4955: aconst_null
    //   4956: iload 7
    //   4958: iload 6
    //   4960: aload 4
    //   4962: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4965: return
    //   4966: aload_1
    //   4967: checkcast 22	com/tencent/mobileqq/app/QQAppInterface
    //   4970: astore 18
    //   4972: aload 18
    //   4974: aload_2
    //   4975: invokestatic 975	com/tencent/mobileqq/mutualmark/oldlogic/ReactivePushHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   4978: ifeq +18 -> 4996
    //   4981: aload 16
    //   4983: aload_2
    //   4984: invokevirtual 979	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   4987: aconst_null
    //   4988: iconst_0
    //   4989: iconst_0
    //   4990: aload 4
    //   4992: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4995: return
    //   4996: aload_2
    //   4997: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   5000: ifnonnull +11 -> 5011
    //   5003: aload 4
    //   5005: ldc 122
    //   5007: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5010: return
    //   5011: aload_2
    //   5012: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5015: sipush -5003
    //   5018: if_icmpne +13 -> 5031
    //   5021: aload 4
    //   5023: aload_2
    //   5024: invokevirtual 979	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   5027: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5030: return
    //   5031: aload_2
    //   5032: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5035: sipush -7090
    //   5038: if_icmpne +13 -> 5051
    //   5041: aload 4
    //   5043: aload_2
    //   5044: invokevirtual 979	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   5047: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5050: return
    //   5051: aload_2
    //   5052: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5055: sipush -2033
    //   5058: if_icmpne +19 -> 5077
    //   5061: aconst_null
    //   5062: ldc_w 980
    //   5065: invokestatic 368	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   5068: aconst_null
    //   5069: iconst_0
    //   5070: iconst_0
    //   5071: aload 4
    //   5073: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5076: return
    //   5077: aload_2
    //   5078: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5081: sipush -2049
    //   5084: if_icmpne +16 -> 5100
    //   5087: aload 4
    //   5089: aload_2
    //   5090: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   5093: invokestatic 523	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   5096: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5099: return
    //   5100: aload_2
    //   5101: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5104: sipush -1035
    //   5107: if_icmpne +329 -> 5436
    //   5110: aload_2
    //   5111: invokevirtual 316	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   5114: ifeq +64 -> 5178
    //   5117: aload_2
    //   5118: getfield 981	com/tencent/imcore/message/Message:extraflag	I
    //   5121: ldc_w 982
    //   5124: if_icmpne +32 -> 5156
    //   5127: aload_1
    //   5128: invokevirtual 986	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   5131: checkcast 988	com/tencent/mobileqq/service/message/MessageCache
    //   5134: aload_2
    //   5135: invokevirtual 990	com/tencent/mobileqq/service/message/MessageCache:f	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5138: ifne +9 -> 5147
    //   5141: iconst_1
    //   5142: istore 6
    //   5144: goto +37 -> 5181
    //   5147: iconst_0
    //   5148: istore 6
    //   5150: iconst_1
    //   5151: istore 7
    //   5153: goto +31 -> 5184
    //   5156: aload_2
    //   5157: getfield 981	com/tencent/imcore/message/Message:extraflag	I
    //   5160: ldc_w 718
    //   5163: if_icmpne +9 -> 5172
    //   5166: iconst_1
    //   5167: istore 6
    //   5169: goto +6 -> 5175
    //   5172: iconst_0
    //   5173: istore 6
    //   5175: goto +6 -> 5181
    //   5178: iconst_0
    //   5179: istore 6
    //   5181: iconst_0
    //   5182: istore 7
    //   5184: aload_2
    //   5185: invokevirtual 979	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   5188: astore_0
    //   5189: aload_1
    //   5190: ldc_w 992
    //   5193: ldc_w 994
    //   5196: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   5199: checkcast 992	com/tencent/mobileqq/troop/robot/api/ITroopRobotService
    //   5202: astore_1
    //   5203: aload_1
    //   5204: aload_2
    //   5205: invokeinterface 997 2 0
    //   5210: ifeq +40 -> 5250
    //   5213: aload_1
    //   5214: aload_2
    //   5215: invokeinterface 1000 2 0
    //   5220: ifne +10 -> 5230
    //   5223: aload_1
    //   5224: aload_2
    //   5225: invokeinterface 1004 2 0
    //   5230: aload_1
    //   5231: aload_2
    //   5232: invokeinterface 1008 2 0
    //   5237: astore_1
    //   5238: aload_1
    //   5239: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5242: ifne +8 -> 5250
    //   5245: aload_1
    //   5246: astore_0
    //   5247: goto +3 -> 5250
    //   5250: aload_2
    //   5251: getfield 1011	com/tencent/imcore/message/Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   5254: ifnull +165 -> 5419
    //   5257: aload_0
    //   5258: ifnull +161 -> 5419
    //   5261: new 153	java/lang/StringBuilder
    //   5264: dup
    //   5265: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   5268: astore_1
    //   5269: aload 16
    //   5271: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5274: ifne +18 -> 5292
    //   5277: aload_1
    //   5278: aload 16
    //   5280: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5283: pop
    //   5284: aload_1
    //   5285: ldc_w 363
    //   5288: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5291: pop
    //   5292: aload 4
    //   5294: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5297: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5300: ifne +13 -> 5313
    //   5303: aload_1
    //   5304: aload 4
    //   5306: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5309: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   5312: pop
    //   5313: aload_2
    //   5314: invokestatic 285	com/tencent/biz/anonymous/AnonymousChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5317: ifne +32 -> 5349
    //   5320: iload 6
    //   5322: ifeq +14 -> 5336
    //   5325: aload_1
    //   5326: ldc_w 668
    //   5329: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5332: pop
    //   5333: goto +16 -> 5349
    //   5336: iload 7
    //   5338: ifeq +11 -> 5349
    //   5341: aload_1
    //   5342: ldc_w 670
    //   5345: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5348: pop
    //   5349: aload_0
    //   5350: instanceof 657
    //   5353: ifeq +28 -> 5381
    //   5356: aload_0
    //   5357: checkcast 657	com/tencent/mobileqq/text/QQText
    //   5360: aload_1
    //   5361: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5364: iconst_1
    //   5365: iconst_0
    //   5366: newarray int
    //   5368: invokevirtual 673	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   5371: astore_0
    //   5372: aload 4
    //   5374: iconst_1
    //   5375: putfield 676	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   5378: goto +27 -> 5405
    //   5381: aload_1
    //   5382: aload_0
    //   5383: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   5386: pop
    //   5387: new 1013	android/text/SpannableString
    //   5390: dup
    //   5391: aload_1
    //   5392: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5395: invokespecial 1016	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   5398: astore_0
    //   5399: aload 4
    //   5401: iconst_0
    //   5402: putfield 676	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   5405: aload 16
    //   5407: aload_0
    //   5408: aconst_null
    //   5409: iload 6
    //   5411: iload 7
    //   5413: aload 4
    //   5415: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5418: return
    //   5419: aload 16
    //   5421: aload_0
    //   5422: invokestatic 1018	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5425: aconst_null
    //   5426: iload 6
    //   5428: iload 7
    //   5430: aload 4
    //   5432: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5435: return
    //   5436: aload_2
    //   5437: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5440: sipush -2057
    //   5443: if_icmpne +17 -> 5460
    //   5446: aload 16
    //   5448: getstatic 1023	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   5451: aconst_null
    //   5452: iconst_0
    //   5453: iconst_0
    //   5454: aload 4
    //   5456: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5459: return
    //   5460: aload_2
    //   5461: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5464: sipush -1012
    //   5467: if_icmpne +79 -> 5546
    //   5470: aload_2
    //   5471: invokevirtual 979	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   5474: astore_1
    //   5475: aload_1
    //   5476: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5479: ifne +2977 -> 8456
    //   5482: aload_1
    //   5483: invokeinterface 1026 1 0
    //   5488: invokestatic 523	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   5491: astore_1
    //   5492: aload_0
    //   5493: ldc_w 1027
    //   5496: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   5499: astore_2
    //   5500: aload_1
    //   5501: invokevirtual 216	java/lang/String:length	()I
    //   5504: aload_2
    //   5505: invokevirtual 216	java/lang/String:length	()I
    //   5508: isub
    //   5509: iconst_1
    //   5510: isub
    //   5511: istore_3
    //   5512: aload_1
    //   5513: astore_0
    //   5514: aload_1
    //   5515: aload_2
    //   5516: invokevirtual 126	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5519: ifeq +16 -> 5535
    //   5522: aload_1
    //   5523: astore_0
    //   5524: iload_3
    //   5525: ifle +10 -> 5535
    //   5528: aload_1
    //   5529: iconst_0
    //   5530: iload_3
    //   5531: invokevirtual 355	java/lang/String:substring	(II)Ljava/lang/String;
    //   5534: astore_0
    //   5535: aconst_null
    //   5536: aload_0
    //   5537: aconst_null
    //   5538: iconst_0
    //   5539: iconst_0
    //   5540: aload 4
    //   5542: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5545: return
    //   5546: aload_2
    //   5547: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5550: sipush -2059
    //   5553: if_icmpne +33 -> 5586
    //   5556: new 1029	com/tencent/mobileqq/data/MessageForTroopPobing
    //   5559: dup
    //   5560: invokespecial 1030	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   5563: astore_0
    //   5564: aload_0
    //   5565: aload_2
    //   5566: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   5569: putfield 1031	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   5572: aload_0
    //   5573: invokevirtual 1034	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   5576: aload 4
    //   5578: aload_0
    //   5579: invokevirtual 1035	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   5582: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5585: return
    //   5586: aload_2
    //   5587: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5590: sipush -2066
    //   5593: if_icmpne +95 -> 5688
    //   5596: new 1037	com/tencent/mobileqq/data/MessageForConfessCard
    //   5599: dup
    //   5600: invokespecial 1038	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   5603: astore_0
    //   5604: aload_0
    //   5605: aload_2
    //   5606: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   5609: putfield 1039	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   5612: aload_0
    //   5613: invokevirtual 1040	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   5616: aload_2
    //   5617: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   5620: sipush 1032
    //   5623: if_icmpne +18 -> 5641
    //   5626: aload 16
    //   5628: aload_0
    //   5629: getfield 1043	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   5632: aconst_null
    //   5633: iconst_0
    //   5634: iconst_0
    //   5635: aload 4
    //   5637: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5640: return
    //   5641: new 153	java/lang/StringBuilder
    //   5644: dup
    //   5645: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   5648: astore_1
    //   5649: aload_1
    //   5650: aload 16
    //   5652: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5655: pop
    //   5656: aload_1
    //   5657: ldc_w 1045
    //   5660: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5663: pop
    //   5664: aload_1
    //   5665: aload_0
    //   5666: getfield 1043	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   5669: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5672: pop
    //   5673: ldc 122
    //   5675: aload_1
    //   5676: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5679: aconst_null
    //   5680: iconst_0
    //   5681: iconst_0
    //   5682: aload 4
    //   5684: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5687: return
    //   5688: aload_2
    //   5689: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5692: sipush -2067
    //   5695: if_icmpne +38 -> 5733
    //   5698: new 1047	com/tencent/mobileqq/data/MessageForTroopConfess
    //   5701: dup
    //   5702: invokespecial 1048	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   5705: astore_0
    //   5706: aload_0
    //   5707: aload_2
    //   5708: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   5711: putfield 1049	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   5714: aload_0
    //   5715: invokevirtual 1050	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   5718: aload 16
    //   5720: aload_0
    //   5721: getfield 1051	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   5724: aconst_null
    //   5725: iconst_0
    //   5726: iconst_0
    //   5727: aload 4
    //   5729: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5732: return
    //   5733: aload_2
    //   5734: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5737: sipush -5008
    //   5740: if_icmpeq +1091 -> 6831
    //   5743: aload_2
    //   5744: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5747: sipush -5016
    //   5750: if_icmpeq +1081 -> 6831
    //   5753: aload_2
    //   5754: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   5757: sipush -5017
    //   5760: if_icmpne +6 -> 5766
    //   5763: goto +1068 -> 6831
    //   5766: aload_1
    //   5767: aload_2
    //   5768: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   5771: istore 6
    //   5773: aload_1
    //   5774: aload_2
    //   5775: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   5778: istore 7
    //   5780: aload_2
    //   5781: getfield 1054	com/tencent/imcore/message/Message:fileType	I
    //   5784: istore 8
    //   5786: iload 8
    //   5788: iconst_1
    //   5789: if_icmpeq +979 -> 6768
    //   5792: iload 8
    //   5794: iconst_2
    //   5795: if_icmpeq +886 -> 6681
    //   5798: iload 8
    //   5800: bipush 8
    //   5802: if_icmpeq +879 -> 6681
    //   5805: iload 8
    //   5807: ldc_w 1055
    //   5810: if_icmpeq +853 -> 6663
    //   5813: iload 8
    //   5815: ldc_w 1056
    //   5818: if_icmpeq +827 -> 6645
    //   5821: aload_2
    //   5822: ldc_w 613
    //   5825: invokevirtual 616	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   5828: astore 5
    //   5830: getstatic 621	com/tencent/mobileqq/emoticon/EmojiStickerManager:n	Z
    //   5833: ifeq +133 -> 5966
    //   5836: aload 5
    //   5838: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5841: ifne +125 -> 5966
    //   5844: aload 18
    //   5846: aload_2
    //   5847: aload 4
    //   5849: invokestatic 700	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   5852: astore_0
    //   5853: new 153	java/lang/StringBuilder
    //   5856: dup
    //   5857: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   5860: astore_1
    //   5861: aload 16
    //   5863: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5866: ifne +18 -> 5884
    //   5869: aload_1
    //   5870: aload 16
    //   5872: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5875: pop
    //   5876: aload_1
    //   5877: ldc_w 363
    //   5880: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5883: pop
    //   5884: aload 4
    //   5886: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5889: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5892: ifne +13 -> 5905
    //   5895: aload_1
    //   5896: aload 4
    //   5898: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5901: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   5904: pop
    //   5905: aload_2
    //   5906: invokestatic 285	com/tencent/biz/anonymous/AnonymousChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5909: ifne +32 -> 5941
    //   5912: iload 6
    //   5914: ifeq +14 -> 5928
    //   5917: aload_1
    //   5918: ldc_w 668
    //   5921: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5924: pop
    //   5925: goto +16 -> 5941
    //   5928: iload 7
    //   5930: ifeq +11 -> 5941
    //   5933: aload_1
    //   5934: ldc_w 670
    //   5937: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5940: pop
    //   5941: aload 16
    //   5943: aload_0
    //   5944: aload_1
    //   5945: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5948: iconst_1
    //   5949: iconst_0
    //   5950: newarray int
    //   5952: invokevirtual 673	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   5955: aconst_null
    //   5956: iload 6
    //   5958: iload 7
    //   5960: aload 4
    //   5962: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5965: return
    //   5966: aload_2
    //   5967: invokevirtual 979	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   5970: astore 15
    //   5972: aload_1
    //   5973: ldc_w 992
    //   5976: ldc_w 994
    //   5979: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   5982: checkcast 992	com/tencent/mobileqq/troop/robot/api/ITroopRobotService
    //   5985: astore 17
    //   5987: aload 15
    //   5989: astore 5
    //   5991: aload 17
    //   5993: aload_2
    //   5994: invokeinterface 997 2 0
    //   5999: ifeq +48 -> 6047
    //   6002: aload 17
    //   6004: aload_2
    //   6005: invokeinterface 1000 2 0
    //   6010: ifne +11 -> 6021
    //   6013: aload 17
    //   6015: aload_2
    //   6016: invokeinterface 1004 2 0
    //   6021: aload 17
    //   6023: aload_2
    //   6024: invokeinterface 1008 2 0
    //   6029: astore 17
    //   6031: aload 15
    //   6033: astore 5
    //   6035: aload 17
    //   6037: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6040: ifne +7 -> 6047
    //   6043: aload 17
    //   6045: astore 5
    //   6047: aload_2
    //   6048: getfield 1011	com/tencent/imcore/message/Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   6051: ifnull +456 -> 6507
    //   6054: aload 5
    //   6056: ifnull +451 -> 6507
    //   6059: new 153	java/lang/StringBuilder
    //   6062: dup
    //   6063: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   6066: astore_0
    //   6067: aload 16
    //   6069: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6072: ifne +18 -> 6090
    //   6075: aload_0
    //   6076: aload 16
    //   6078: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6081: pop
    //   6082: aload_0
    //   6083: ldc_w 363
    //   6086: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6089: pop
    //   6090: aload 4
    //   6092: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6095: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6098: ifne +13 -> 6111
    //   6101: aload_0
    //   6102: aload 4
    //   6104: getfield 663	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6107: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6110: pop
    //   6111: aload_2
    //   6112: invokestatic 285	com/tencent/biz/anonymous/AnonymousChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6115: ifne +32 -> 6147
    //   6118: iload 6
    //   6120: ifeq +14 -> 6134
    //   6123: aload_0
    //   6124: ldc_w 668
    //   6127: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6130: pop
    //   6131: goto +16 -> 6147
    //   6134: iload 7
    //   6136: ifeq +11 -> 6147
    //   6139: aload_0
    //   6140: ldc_w 670
    //   6143: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6146: pop
    //   6147: aload 5
    //   6149: instanceof 657
    //   6152: ifeq +43 -> 6195
    //   6155: aload 5
    //   6157: checkcast 657	com/tencent/mobileqq/text/QQText
    //   6160: aload_0
    //   6161: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6164: iconst_1
    //   6165: iconst_3
    //   6166: newarray int
    //   6168: dup
    //   6169: iconst_0
    //   6170: iconst_0
    //   6171: iastore
    //   6172: dup
    //   6173: iconst_1
    //   6174: bipush 16
    //   6176: iastore
    //   6177: dup
    //   6178: iconst_2
    //   6179: iconst_1
    //   6180: iastore
    //   6181: invokevirtual 673	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   6184: astore 5
    //   6186: aload 4
    //   6188: iconst_1
    //   6189: putfield 676	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6192: goto +29 -> 6221
    //   6195: aload_0
    //   6196: aload 5
    //   6198: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6201: pop
    //   6202: new 1013	android/text/SpannableString
    //   6205: dup
    //   6206: aload_0
    //   6207: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6210: invokespecial 1016	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   6213: astore 5
    //   6215: aload 4
    //   6217: iconst_0
    //   6218: putfield 676	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6221: aload 5
    //   6223: astore_0
    //   6224: aload_2
    //   6225: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   6228: sipush -5040
    //   6231: if_icmpne +171 -> 6402
    //   6234: new 153	java/lang/StringBuilder
    //   6237: dup
    //   6238: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   6241: astore_0
    //   6242: aload_0
    //   6243: ldc_w 488
    //   6246: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6249: pop
    //   6250: aload_0
    //   6251: invokestatic 1060	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6254: ldc_w 1061
    //   6257: invokevirtual 1062	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   6260: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6263: pop
    //   6264: aload_0
    //   6265: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6268: astore_0
    //   6269: aload 5
    //   6271: invokeinterface 1026 1 0
    //   6276: astore 17
    //   6278: aload 5
    //   6280: astore 15
    //   6282: aload 17
    //   6284: ifnull +26 -> 6310
    //   6287: aload 5
    //   6289: astore 15
    //   6291: aload 17
    //   6293: aload_0
    //   6294: invokevirtual 1065	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6297: ifeq +13 -> 6310
    //   6300: aload 17
    //   6302: aload_0
    //   6303: ldc 122
    //   6305: invokevirtual 278	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   6308: astore 15
    //   6310: aload 15
    //   6312: astore_0
    //   6313: iload_3
    //   6314: ifne +88 -> 6402
    //   6317: aload_1
    //   6318: ldc_w 290
    //   6321: ldc 122
    //   6323: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   6326: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   6329: aload_2
    //   6330: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6333: iconst_0
    //   6334: invokeinterface 1069 3 0
    //   6339: astore 5
    //   6341: aload 15
    //   6343: astore_0
    //   6344: aload 5
    //   6346: instanceof 1071
    //   6349: ifeq +53 -> 6402
    //   6352: aload 5
    //   6354: checkcast 1071	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   6357: astore 5
    //   6359: aload 15
    //   6361: astore_0
    //   6362: aload 5
    //   6364: getfield 1075	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   6367: ifnull +35 -> 6402
    //   6370: aload 15
    //   6372: astore_0
    //   6373: aload 5
    //   6375: getfield 1075	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   6378: getfield 1079	com/tencent/mobileqq/graytip/UniteGrayTipParam:i	I
    //   6381: invokestatic 1082	com/tencent/mobileqq/mutualmark/MutualMarkUtils:c	(I)Z
    //   6384: ifeq +18 -> 6402
    //   6387: aload_1
    //   6388: invokevirtual 532	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6391: aload 15
    //   6393: invokeinterface 1026 1 0
    //   6398: invokestatic 1085	com/tencent/mobileqq/mutualmark/oldlogic/ReactivePushHelper:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    //   6401: astore_0
    //   6402: aload_0
    //   6403: astore 5
    //   6405: aload_2
    //   6406: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   6409: invokestatic 1086	com/tencent/imcore/message/MsgProxyUtils:d	(I)Z
    //   6412: ifeq +80 -> 6492
    //   6415: aload_1
    //   6416: ldc_w 290
    //   6419: ldc 122
    //   6421: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   6424: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   6427: aload_2
    //   6428: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6431: iload_3
    //   6432: invokeinterface 1069 3 0
    //   6437: astore_1
    //   6438: aload_0
    //   6439: astore 5
    //   6441: aload_1
    //   6442: ifnull +50 -> 6492
    //   6445: aload_0
    //   6446: astore 5
    //   6448: aload_1
    //   6449: instanceof 1071
    //   6452: ifeq +40 -> 6492
    //   6455: aload_1
    //   6456: checkcast 1071	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   6459: astore_1
    //   6460: aload_0
    //   6461: astore 5
    //   6463: aload_1
    //   6464: getfield 1075	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   6467: ifnull +25 -> 6492
    //   6470: aload_0
    //   6471: astore 5
    //   6473: aload_1
    //   6474: getfield 1075	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   6477: getfield 1079	com/tencent/mobileqq/graytip/UniteGrayTipParam:i	I
    //   6480: ldc_w 1087
    //   6483: if_icmpne +9 -> 6492
    //   6486: aload_1
    //   6487: invokevirtual 1088	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:getSummaryMsg	()Ljava/lang/String;
    //   6490: astore 5
    //   6492: aload 16
    //   6494: aload 5
    //   6496: aconst_null
    //   6497: iload 6
    //   6499: iload 7
    //   6501: aload 4
    //   6503: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6506: return
    //   6507: aload 5
    //   6509: ifnull +18 -> 6527
    //   6512: aload 5
    //   6514: invokeinterface 1026 1 0
    //   6519: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   6522: astore 5
    //   6524: goto +6 -> 6530
    //   6527: aconst_null
    //   6528: astore 5
    //   6530: getstatic 1091	com/tencent/mobileqq/app/AppConstants:SYSTEM_MSG_UIN	Ljava/lang/String;
    //   6533: aload_2
    //   6534: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6537: invokevirtual 1094	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6540: ifeq +30 -> 6570
    //   6543: aload 5
    //   6545: ifnull +25 -> 6570
    //   6548: aload 5
    //   6550: invokevirtual 216	java/lang/String:length	()I
    //   6553: ifle +17 -> 6570
    //   6556: aload_0
    //   6557: aload 18
    //   6559: aload 5
    //   6561: aload_2
    //   6562: invokestatic 1096	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   6565: astore 5
    //   6567: goto +3 -> 6570
    //   6570: aload 16
    //   6572: aconst_null
    //   6573: aload 5
    //   6575: iload 6
    //   6577: aload_1
    //   6578: invokevirtual 986	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   6581: checkcast 988	com/tencent/mobileqq/service/message/MessageCache
    //   6584: aload_2
    //   6585: invokevirtual 990	com/tencent/mobileqq/service/message/MessageCache:f	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6588: aload 4
    //   6590: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6593: aload_2
    //   6594: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   6597: sipush -1000
    //   6600: if_icmpne +38 -> 6638
    //   6603: aload 4
    //   6605: getfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6608: ifnull +30 -> 6638
    //   6611: aload 4
    //   6613: new 657	com/tencent/mobileqq/text/QQText
    //   6616: dup
    //   6617: aload 4
    //   6619: getfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6622: iconst_1
    //   6623: bipush 16
    //   6625: invokespecial 660	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   6628: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6631: aload 4
    //   6633: iconst_1
    //   6634: putfield 676	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6637: return
    //   6638: aload 4
    //   6640: iconst_0
    //   6641: putfield 676	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6644: return
    //   6645: aload 16
    //   6647: aload_0
    //   6648: ldc_w 746
    //   6651: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   6654: aconst_null
    //   6655: iconst_0
    //   6656: iconst_0
    //   6657: aload 4
    //   6659: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6662: return
    //   6663: aload 16
    //   6665: ldc 122
    //   6667: aload_2
    //   6668: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   6671: iload 6
    //   6673: iload 7
    //   6675: aload 4
    //   6677: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6680: return
    //   6681: ldc_w 1098
    //   6684: iconst_3
    //   6685: anewarray 4	java/lang/Object
    //   6688: dup
    //   6689: iconst_0
    //   6690: iload_3
    //   6691: invokestatic 808	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6694: aastore
    //   6695: dup
    //   6696: iconst_1
    //   6697: iload 6
    //   6699: invokestatic 1103	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6702: aastore
    //   6703: dup
    //   6704: iconst_2
    //   6705: iload 7
    //   6707: invokestatic 1103	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6710: aastore
    //   6711: invokestatic 1108	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   6714: aload_0
    //   6715: ldc_w 1109
    //   6718: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   6721: astore_0
    //   6722: aload_2
    //   6723: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   6726: aload_1
    //   6727: invokevirtual 627	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6730: invokestatic 1114	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   6733: ifeq +22 -> 6755
    //   6736: iload_3
    //   6737: ifeq +18 -> 6755
    //   6740: aload 16
    //   6742: aload_0
    //   6743: ldc 122
    //   6745: iload 6
    //   6747: iload 7
    //   6749: aload 4
    //   6751: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6754: return
    //   6755: aload 16
    //   6757: aload_0
    //   6758: ldc 122
    //   6760: iconst_0
    //   6761: iconst_0
    //   6762: aload 4
    //   6764: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6767: return
    //   6768: aload_2
    //   6769: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   6772: sipush 1001
    //   6775: if_icmpeq +13 -> 6788
    //   6778: aload_2
    //   6779: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   6782: sipush 10002
    //   6785: if_icmpne +26 -> 6811
    //   6788: aload_2
    //   6789: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   6792: sipush -3001
    //   6795: if_icmpne +16 -> 6811
    //   6798: aload 4
    //   6800: aload_0
    //   6801: ldc_w 1115
    //   6804: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   6807: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6810: return
    //   6811: aload 16
    //   6813: aload_0
    //   6814: ldc_w 746
    //   6817: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   6820: aconst_null
    //   6821: iload 6
    //   6823: iload 7
    //   6825: aload 4
    //   6827: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6830: return
    //   6831: aload_2
    //   6832: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   6835: sipush -5016
    //   6838: if_icmpne +35 -> 6873
    //   6841: new 1117	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6844: dup
    //   6845: invokespecial 1118	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6848: astore_0
    //   6849: aload_0
    //   6850: aload_2
    //   6851: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   6854: putfield 1119	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6857: aload_0
    //   6858: invokevirtual 1120	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6861: aload 4
    //   6863: aload_0
    //   6864: invokevirtual 1123	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6867: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6870: goto +32 -> 6902
    //   6873: new 1125	com/tencent/mobileqq/data/MessageForArkApp
    //   6876: dup
    //   6877: invokespecial 1126	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6880: astore_0
    //   6881: aload_0
    //   6882: aload_2
    //   6883: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   6886: putfield 1127	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6889: aload_0
    //   6890: invokevirtual 1128	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6893: aload 4
    //   6895: aload_0
    //   6896: invokevirtual 1129	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6899: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6902: aload_1
    //   6903: aload_2
    //   6904: invokestatic 561	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   6907: istore 6
    //   6909: aload_1
    //   6910: aload_2
    //   6911: invokestatic 563	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   6914: istore 7
    //   6916: aload 16
    //   6918: aload 4
    //   6920: getfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6923: aconst_null
    //   6924: iload 6
    //   6926: iload 7
    //   6928: aload 4
    //   6930: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6933: return
    //   6934: aload 4
    //   6936: aload_2
    //   6937: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   6940: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6943: return
    //   6944: aload_1
    //   6945: ldc_w 290
    //   6948: ldc 122
    //   6950: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   6953: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   6956: aload_2
    //   6957: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6960: aload_2
    //   6961: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   6964: aload_2
    //   6965: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   6968: invokeinterface 300 5 0
    //   6973: astore 5
    //   6975: aload 5
    //   6977: instanceof 1131
    //   6980: ifeq +1476 -> 8456
    //   6983: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6986: ifeq +43 -> 7029
    //   6989: new 153	java/lang/StringBuilder
    //   6992: dup
    //   6993: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   6996: astore 15
    //   6998: aload 15
    //   7000: ldc_w 1133
    //   7003: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7006: pop
    //   7007: aload 15
    //   7009: aload_2
    //   7010: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   7013: invokevirtual 481	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7016: pop
    //   7017: ldc_w 450
    //   7020: iconst_2
    //   7021: aload 15
    //   7023: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7026: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7029: aload 5
    //   7031: checkcast 1131	com/tencent/mobileqq/data/MessageForShortVideo
    //   7034: astore 17
    //   7036: aload 17
    //   7038: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7041: sipush 1005
    //   7044: if_icmpeq +64 -> 7108
    //   7047: aload_2
    //   7048: getfield 981	com/tencent/imcore/message/Message:extraflag	I
    //   7051: ldc_w 718
    //   7054: if_icmpeq +54 -> 7108
    //   7057: aload 17
    //   7059: getfield 1139	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   7062: ifne +17 -> 7079
    //   7065: aload 17
    //   7067: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7070: sipush 1004
    //   7073: if_icmpeq +35 -> 7108
    //   7076: goto +3 -> 7079
    //   7079: aload 17
    //   7081: getfield 1139	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   7084: iconst_1
    //   7085: if_icmpne +17 -> 7102
    //   7088: aload 17
    //   7090: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7093: sipush 1004
    //   7096: if_icmpne +6 -> 7102
    //   7099: goto +9 -> 7108
    //   7102: iconst_0
    //   7103: istore 6
    //   7105: goto +22 -> 7127
    //   7108: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7111: ifeq +13 -> 7124
    //   7114: ldc_w 450
    //   7117: iconst_2
    //   7118: ldc_w 1141
    //   7121: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7124: iconst_1
    //   7125: istore 6
    //   7127: aload_2
    //   7128: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7131: astore 5
    //   7133: aload_2
    //   7134: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7137: aload_2
    //   7138: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   7141: invokestatic 578	com/tencent/imcore/message/UinTypeUtil:c	(Ljava/lang/String;I)Z
    //   7144: ifeq +9 -> 7153
    //   7147: aload_2
    //   7148: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   7151: astore 5
    //   7153: aload_1
    //   7154: ldc_w 707
    //   7157: ldc 122
    //   7159: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   7162: checkcast 707	com/tencent/mobileqq/transfile/api/ITransFileController
    //   7165: aload 5
    //   7167: aload_2
    //   7168: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   7171: invokeinterface 711 4 0
    //   7176: astore 5
    //   7178: iload 6
    //   7180: istore 7
    //   7182: aload 5
    //   7184: astore_1
    //   7185: aload 17
    //   7187: getfield 1144	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   7190: ifnull +201 -> 7391
    //   7193: iload 6
    //   7195: istore 7
    //   7197: aload 5
    //   7199: astore_1
    //   7200: ldc 122
    //   7202: aload 17
    //   7204: getfield 1144	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   7207: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7210: ifne +181 -> 7391
    //   7213: iload 6
    //   7215: istore 7
    //   7217: aload 5
    //   7219: astore_1
    //   7220: aload_2
    //   7221: invokevirtual 316	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   7224: ifeq +167 -> 7391
    //   7227: iload 6
    //   7229: istore 7
    //   7231: aload 5
    //   7233: astore_1
    //   7234: aload 5
    //   7236: ifnonnull +155 -> 7391
    //   7239: iload 6
    //   7241: istore 7
    //   7243: aload 5
    //   7245: astore_1
    //   7246: aload 17
    //   7248: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7251: sipush 1003
    //   7254: if_icmpeq +137 -> 7391
    //   7257: iload 6
    //   7259: istore 7
    //   7261: aload 5
    //   7263: astore_1
    //   7264: aload 17
    //   7266: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7269: sipush 1004
    //   7272: if_icmpeq +119 -> 7391
    //   7275: iload 6
    //   7277: istore 7
    //   7279: aload 5
    //   7281: astore_1
    //   7282: aload 17
    //   7284: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7287: sipush 2003
    //   7290: if_icmpeq +101 -> 7391
    //   7293: iload 6
    //   7295: istore 7
    //   7297: aload 5
    //   7299: astore_1
    //   7300: aload 17
    //   7302: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7305: sipush 2009
    //   7308: if_icmpeq +83 -> 7391
    //   7311: iload 6
    //   7313: istore 7
    //   7315: aload 5
    //   7317: astore_1
    //   7318: aload 17
    //   7320: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7323: sipush 2002
    //   7326: if_icmpeq +65 -> 7391
    //   7329: iload 6
    //   7331: istore 7
    //   7333: aload 5
    //   7335: astore_1
    //   7336: aload 17
    //   7338: getfield 1147	com/tencent/mobileqq/data/MessageForShortVideo:isAllowAutoDown	Z
    //   7341: iconst_1
    //   7342: if_icmpne +49 -> 7391
    //   7345: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7348: ifeq +13 -> 7361
    //   7351: ldc_w 450
    //   7354: iconst_2
    //   7355: ldc_w 1149
    //   7358: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7361: iconst_1
    //   7362: istore 7
    //   7364: aload 5
    //   7366: astore_1
    //   7367: goto +24 -> 7391
    //   7370: astore 15
    //   7372: aload 5
    //   7374: astore_1
    //   7375: goto +7 -> 7382
    //   7378: astore 15
    //   7380: aconst_null
    //   7381: astore_1
    //   7382: aload 15
    //   7384: invokevirtual 466	java/lang/Exception:printStackTrace	()V
    //   7387: iload 6
    //   7389: istore 7
    //   7391: aload_2
    //   7392: invokevirtual 316	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   7395: ifeq +83 -> 7478
    //   7398: aload 17
    //   7400: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7403: sipush 1001
    //   7406: if_icmpeq +47 -> 7453
    //   7409: aload 17
    //   7411: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7414: sipush 1002
    //   7417: if_icmpeq +36 -> 7453
    //   7420: aload 17
    //   7422: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7425: sipush 998
    //   7428: if_icmpeq +25 -> 7453
    //   7431: aload 17
    //   7433: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7436: sipush 999
    //   7439: if_icmpeq +14 -> 7453
    //   7442: aload 17
    //   7444: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7447: sipush 1000
    //   7450: if_icmpne +28 -> 7478
    //   7453: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7456: ifeq +16 -> 7472
    //   7459: ldc_w 450
    //   7462: iconst_2
    //   7463: ldc_w 1151
    //   7466: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7469: goto +3 -> 7472
    //   7472: iconst_1
    //   7473: istore 6
    //   7475: goto +6 -> 7481
    //   7478: iconst_0
    //   7479: istore 6
    //   7481: aload 17
    //   7483: getfield 1139	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   7486: iconst_2
    //   7487: if_icmpne +14 -> 7501
    //   7490: aload_0
    //   7491: ldc_w 1152
    //   7494: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   7497: astore_0
    //   7498: goto +11 -> 7509
    //   7501: aload_0
    //   7502: ldc_w 1153
    //   7505: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   7508: astore_0
    //   7509: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7512: ifeq +134 -> 7646
    //   7515: new 153	java/lang/StringBuilder
    //   7518: dup
    //   7519: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   7522: astore_2
    //   7523: aload_2
    //   7524: ldc_w 1155
    //   7527: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7530: pop
    //   7531: aload_2
    //   7532: aload 17
    //   7534: getfield 1144	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   7537: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7540: pop
    //   7541: aload_2
    //   7542: ldc_w 1157
    //   7545: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7548: pop
    //   7549: aload_2
    //   7550: aload 17
    //   7552: getfield 1136	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7555: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7558: pop
    //   7559: ldc_w 450
    //   7562: iconst_2
    //   7563: aload_2
    //   7564: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7567: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7570: aload_1
    //   7571: ifnonnull +16 -> 7587
    //   7574: ldc_w 450
    //   7577: iconst_2
    //   7578: ldc_w 1159
    //   7581: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7584: goto +13 -> 7597
    //   7587: ldc_w 450
    //   7590: iconst_2
    //   7591: ldc_w 1161
    //   7594: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7597: new 153	java/lang/StringBuilder
    //   7600: dup
    //   7601: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   7604: astore_1
    //   7605: aload_1
    //   7606: ldc_w 1163
    //   7609: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7612: pop
    //   7613: aload_1
    //   7614: iload 7
    //   7616: invokevirtual 1166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7619: pop
    //   7620: aload_1
    //   7621: ldc_w 1168
    //   7624: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7627: pop
    //   7628: aload_1
    //   7629: iload 6
    //   7631: invokevirtual 1166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7634: pop
    //   7635: ldc_w 450
    //   7638: iconst_2
    //   7639: aload_1
    //   7640: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7643: invokestatic 454	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7646: aload 16
    //   7648: aload_0
    //   7649: aconst_null
    //   7650: iload 7
    //   7652: iload 6
    //   7654: aload 4
    //   7656: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7659: return
    //   7660: aconst_null
    //   7661: aload_2
    //   7662: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   7665: invokestatic 523	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   7668: aconst_null
    //   7669: iconst_0
    //   7670: iconst_0
    //   7671: aload 4
    //   7673: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7676: return
    //   7677: aconst_null
    //   7678: aconst_null
    //   7679: aload_2
    //   7680: getfield 518	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   7683: invokestatic 523	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   7686: iconst_0
    //   7687: iconst_0
    //   7688: aload 4
    //   7690: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7693: return
    //   7694: aload 4
    //   7696: ldc 122
    //   7698: putfield 528	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7701: return
    //   7702: aload_2
    //   7703: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7706: astore 15
    //   7708: aload_2
    //   7709: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7712: aload_2
    //   7713: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   7716: invokestatic 578	com/tencent/imcore/message/UinTypeUtil:c	(Ljava/lang/String;I)Z
    //   7719: ifeq +9 -> 7728
    //   7722: aload_2
    //   7723: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   7726: astore 15
    //   7728: aload_0
    //   7729: ldc_w 1109
    //   7732: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   7735: astore_0
    //   7736: aload_1
    //   7737: ldc_w 290
    //   7740: ldc 122
    //   7742: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   7745: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   7748: aload 15
    //   7750: aload_2
    //   7751: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   7754: aload_2
    //   7755: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   7758: invokeinterface 300 5 0
    //   7763: astore 5
    //   7765: aload 5
    //   7767: instanceof 1170
    //   7770: ifeq +152 -> 7922
    //   7773: aload 5
    //   7775: checkcast 1170	com/tencent/mobileqq/data/MessageForPtt
    //   7778: astore 17
    //   7780: aload 17
    //   7782: invokevirtual 1171	com/tencent/mobileqq/data/MessageForPtt:getSummaryMsg	()Ljava/lang/String;
    //   7785: astore 5
    //   7787: aload 5
    //   7789: astore_0
    //   7790: aload_2
    //   7791: invokevirtual 316	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   7794: ifeq +128 -> 7922
    //   7797: aload 17
    //   7799: getfield 1174	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   7802: ldc2_w 39
    //   7805: lcmp
    //   7806: ifne +15 -> 7821
    //   7809: aload 5
    //   7811: astore_0
    //   7812: iconst_1
    //   7813: istore 7
    //   7815: iconst_0
    //   7816: istore 6
    //   7818: goto +110 -> 7928
    //   7821: aload 5
    //   7823: astore_0
    //   7824: aload 17
    //   7826: getfield 1174	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   7829: lconst_0
    //   7830: lcmp
    //   7831: ifgt +91 -> 7922
    //   7834: aload_1
    //   7835: aload 15
    //   7837: aload 17
    //   7839: getfield 1177	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   7842: aload 17
    //   7844: getfield 1178	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   7847: invokestatic 1184	com/tencent/mobileqq/transfile/api/TransFileControllerBusHelper:findProcessorFileStatus	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;J)I
    //   7850: istore_3
    //   7851: iload_3
    //   7852: sipush 1005
    //   7855: if_icmpeq +27 -> 7882
    //   7858: iload_3
    //   7859: sipush 1004
    //   7862: if_icmpeq +20 -> 7882
    //   7865: iload_3
    //   7866: iconst_m1
    //   7867: if_icmpne +6 -> 7873
    //   7870: goto +12 -> 7882
    //   7873: iconst_0
    //   7874: istore 7
    //   7876: iconst_1
    //   7877: istore 6
    //   7879: goto +9 -> 7888
    //   7882: iconst_1
    //   7883: istore 7
    //   7885: iconst_0
    //   7886: istore 6
    //   7888: ldc_w 1098
    //   7891: iconst_2
    //   7892: anewarray 4	java/lang/Object
    //   7895: dup
    //   7896: iconst_0
    //   7897: aload 17
    //   7899: getfield 1174	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   7902: invokestatic 1189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7905: aastore
    //   7906: dup
    //   7907: iconst_1
    //   7908: iload_3
    //   7909: invokestatic 808	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7912: aastore
    //   7913: invokestatic 1108	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   7916: aload 5
    //   7918: astore_0
    //   7919: goto +9 -> 7928
    //   7922: iconst_0
    //   7923: istore 7
    //   7925: iconst_0
    //   7926: istore 6
    //   7928: ldc_w 1098
    //   7931: iconst_2
    //   7932: anewarray 4	java/lang/Object
    //   7935: dup
    //   7936: iconst_0
    //   7937: iload 7
    //   7939: invokestatic 1103	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7942: aastore
    //   7943: dup
    //   7944: iconst_1
    //   7945: iload 6
    //   7947: invokestatic 1103	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7950: aastore
    //   7951: invokestatic 1108	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   7954: aload 16
    //   7956: aload_0
    //   7957: aconst_null
    //   7958: iload 7
    //   7960: iload 6
    //   7962: aload 4
    //   7964: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7967: return
    //   7968: iconst_1
    //   7969: istore 11
    //   7971: aload_2
    //   7972: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7975: astore 5
    //   7977: aload_2
    //   7978: getfield 35	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7981: aload_2
    //   7982: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   7985: invokestatic 578	com/tencent/imcore/message/UinTypeUtil:c	(Ljava/lang/String;I)Z
    //   7988: ifeq +9 -> 7997
    //   7991: aload_2
    //   7992: getfield 207	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   7995: astore 5
    //   7997: aload_1
    //   7998: ldc_w 290
    //   8001: ldc 122
    //   8003: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   8006: checkcast 290	com/tencent/mobileqq/msg/api/IMessageFacade
    //   8009: aload 5
    //   8011: aload_2
    //   8012: getfield 38	com/tencent/imcore/message/Message:istroop	I
    //   8015: aload_2
    //   8016: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   8019: invokeinterface 300 5 0
    //   8024: checkcast 705	com/tencent/mobileqq/data/MessageForPic
    //   8027: astore 15
    //   8029: aload_1
    //   8030: ldc_w 707
    //   8033: ldc 122
    //   8035: invokevirtual 296	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   8038: checkcast 707	com/tencent/mobileqq/transfile/api/ITransFileController
    //   8041: aload 5
    //   8043: aload_2
    //   8044: getfield 31	com/tencent/imcore/message/Message:uniseq	J
    //   8047: invokeinterface 711 4 0
    //   8052: astore_1
    //   8053: aload_2
    //   8054: invokevirtual 316	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   8057: ifeq +44 -> 8101
    //   8060: aload 15
    //   8062: ifnull +20 -> 8082
    //   8065: aload 15
    //   8067: getfield 714	com/tencent/mobileqq/data/MessageForPic:size	J
    //   8070: lconst_0
    //   8071: lcmp
    //   8072: ifgt +10 -> 8082
    //   8075: aload_1
    //   8076: ifnonnull +66 -> 8142
    //   8079: goto +419 -> 8498
    //   8082: aload 15
    //   8084: ifnull +58 -> 8142
    //   8087: aload 15
    //   8089: getfield 717	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   8092: ldc_w 718
    //   8095: if_icmpne +47 -> 8142
    //   8098: goto +400 -> 8498
    //   8101: aload_1
    //   8102: ifnull +40 -> 8142
    //   8105: aload_1
    //   8106: instanceof 720
    //   8109: ifeq +33 -> 8142
    //   8112: aload_1
    //   8113: checkcast 720	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   8116: invokevirtual 723	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   8119: lstore 13
    //   8121: lload 13
    //   8123: l2i
    //   8124: istore_3
    //   8125: iload_3
    //   8126: sipush 1005
    //   8129: if_icmpeq +369 -> 8498
    //   8132: iload_3
    //   8133: sipush 1004
    //   8136: if_icmpne +6 -> 8142
    //   8139: goto +359 -> 8498
    //   8142: iconst_0
    //   8143: istore 6
    //   8145: iload 6
    //   8147: istore 7
    //   8149: goto +30 -> 8179
    //   8152: astore 5
    //   8154: goto +17 -> 8171
    //   8157: astore 5
    //   8159: aconst_null
    //   8160: astore_1
    //   8161: goto +10 -> 8171
    //   8164: astore 5
    //   8166: aconst_null
    //   8167: astore_1
    //   8168: aconst_null
    //   8169: astore 15
    //   8171: aload 5
    //   8173: invokevirtual 466	java/lang/Exception:printStackTrace	()V
    //   8176: iconst_0
    //   8177: istore 7
    //   8179: aload_1
    //   8180: instanceof 720
    //   8183: ifeq +119 -> 8302
    //   8186: aload_1
    //   8187: checkcast 720	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   8190: astore_1
    //   8191: aload_1
    //   8192: invokevirtual 723	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   8195: ldc2_w 724
    //   8198: lcmp
    //   8199: ifeq +10 -> 8209
    //   8202: iload 11
    //   8204: istore 6
    //   8206: goto +6 -> 8212
    //   8209: iconst_0
    //   8210: istore 6
    //   8212: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8215: ifeq +84 -> 8299
    //   8218: aload_1
    //   8219: getfield 729	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   8222: ifnull +15 -> 8237
    //   8225: aload_1
    //   8226: getfield 729	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   8229: getfield 734	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   8232: lstore 13
    //   8234: goto +8 -> 8242
    //   8237: ldc2_w 39
    //   8240: lstore 13
    //   8242: new 153	java/lang/StringBuilder
    //   8245: dup
    //   8246: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   8249: astore 5
    //   8251: aload 5
    //   8253: ldc_w 736
    //   8256: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8259: pop
    //   8260: aload 5
    //   8262: lload 13
    //   8264: invokevirtual 481	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8267: pop
    //   8268: aload 5
    //   8270: ldc_w 738
    //   8273: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8276: pop
    //   8277: aload 5
    //   8279: aload_1
    //   8280: invokevirtual 741	com/tencent/mobileqq/transfile/BaseTransProcessor:getKey	()Ljava/lang/String;
    //   8283: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8286: pop
    //   8287: ldc_w 743
    //   8290: iconst_2
    //   8291: aload 5
    //   8293: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8296: invokestatic 655	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8299: goto +59 -> 8358
    //   8302: aload_1
    //   8303: ifnull +52 -> 8355
    //   8306: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8309: ifeq +40 -> 8349
    //   8312: new 153	java/lang/StringBuilder
    //   8315: dup
    //   8316: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   8319: astore 5
    //   8321: aload 5
    //   8323: ldc_w 745
    //   8326: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8329: pop
    //   8330: aload 5
    //   8332: aload_1
    //   8333: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8336: pop
    //   8337: ldc_w 743
    //   8340: iconst_2
    //   8341: aload 5
    //   8343: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8346: invokestatic 655	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8349: iconst_1
    //   8350: istore 6
    //   8352: goto +6 -> 8358
    //   8355: iconst_0
    //   8356: istore 6
    //   8358: aload_0
    //   8359: ldc_w 746
    //   8362: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   8365: astore_1
    //   8366: aload_2
    //   8367: invokestatic 749	com/tencent/mobileqq/app/HotChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   8370: ifne +21 -> 8391
    //   8373: ldc_w 751
    //   8376: invokestatic 542	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   8379: checkcast 751	com/tencent/mobileqq/pic/api/IPicFlash
    //   8382: aload_2
    //   8383: invokeinterface 754 2 0
    //   8388: ifeq +11 -> 8399
    //   8391: aload_0
    //   8392: ldc_w 755
    //   8395: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   8398: astore_1
    //   8399: aload_2
    //   8400: getfield 178	com/tencent/imcore/message/Message:msgtype	I
    //   8403: sipush -5015
    //   8406: if_icmpne +11 -> 8417
    //   8409: aload_0
    //   8410: ldc_w 1190
    //   8413: invokevirtual 188	android/content/Context:getString	(I)Ljava/lang/String;
    //   8416: astore_1
    //   8417: ldc_w 1192
    //   8420: invokestatic 542	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   8423: checkcast 1192	com/tencent/mobileqq/pic/api/IPicHelper
    //   8426: aload 15
    //   8428: invokeinterface 1196 2 0
    //   8433: astore_0
    //   8434: aload_0
    //   8435: ifnull +8 -> 8443
    //   8438: aload_0
    //   8439: astore_1
    //   8440: goto +3 -> 8443
    //   8443: aload 16
    //   8445: aload_1
    //   8446: aconst_null
    //   8447: iload 7
    //   8449: iload 6
    //   8451: aload 4
    //   8453: invokestatic 554	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   8456: return
    //   8457: iconst_1
    //   8458: istore 6
    //   8460: goto -6504 -> 1956
    //   8463: iconst_0
    //   8464: istore 6
    //   8466: goto -6453 -> 2013
    //   8469: ldc2_w 39
    //   8472: lstore 13
    //   8474: goto -6436 -> 2038
    //   8477: goto -6331 -> 2146
    //   8480: iconst_1
    //   8481: istore 6
    //   8483: goto -6337 -> 2146
    //   8486: iconst_0
    //   8487: istore 6
    //   8489: goto -6343 -> 2146
    //   8492: iconst_1
    //   8493: istore 7
    //   8495: goto -3566 -> 4929
    //   8498: iconst_1
    //   8499: istore 6
    //   8501: goto -356 -> 8145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8504	0	paramContext	Context
    //   0	8504	1	paramAppInterface	AppInterface
    //   0	8504	2	paramMessage	Message
    //   0	8504	3	paramInt	int
    //   0	8504	4	paramMsgSummary	MsgSummary
    //   0	8504	5	paramString	String
    //   0	8504	6	paramBoolean1	boolean
    //   0	8504	7	paramBoolean2	boolean
    //   132	5687	8	i	int
    //   129	50	9	j	int
    //   122	18	10	k	int
    //   1268	6935	11	bool1	boolean
    //   1278	963	12	bool2	boolean
    //   1930	6543	13	l	long
    //   49	6973	15	localObject1	Object
    //   7370	1	15	localException1	Exception
    //   7378	5	15	localException2	Exception
    //   7706	721	15	localObject2	Object
    //   18	8426	16	str	String
    //   1814	6084	17	localObject3	Object
    //   4970	1588	18	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   1503	1534	1611	java/lang/Exception
    //   1534	1555	1611	java/lang/Exception
    //   1555	1562	1611	java/lang/Exception
    //   1567	1575	1611	java/lang/Exception
    //   1583	1591	1611	java/lang/Exception
    //   1591	1608	1611	java/lang/Exception
    //   1479	1503	1623	java/lang/Exception
    //   1635	1640	1623	java/lang/Exception
    //   1644	1675	1623	java/lang/Exception
    //   1675	1696	1623	java/lang/Exception
    //   1696	1703	1623	java/lang/Exception
    //   1708	1716	1623	java/lang/Exception
    //   1724	1732	1623	java/lang/Exception
    //   1732	1767	1623	java/lang/Exception
    //   1865	1882	1963	java/lang/Exception
    //   1895	1906	1963	java/lang/Exception
    //   1914	1932	1963	java/lang/Exception
    //   1821	1865	1967	java/lang/Exception
    //   1776	1782	1971	java/lang/Exception
    //   1782	1802	1971	java/lang/Exception
    //   1802	1821	1971	java/lang/Exception
    //   1975	1979	2201	java/lang/Exception
    //   1982	2007	2201	java/lang/Exception
    //   2013	2035	2201	java/lang/Exception
    //   2038	2095	2201	java/lang/Exception
    //   2103	2143	2201	java/lang/Exception
    //   2146	2161	2201	java/lang/Exception
    //   2161	2179	2201	java/lang/Exception
    //   2179	2187	2201	java/lang/Exception
    //   2187	2200	2201	java/lang/Exception
    //   1469	1474	2205	java/lang/Exception
    //   1280	1289	2212	java/lang/Exception
    //   1289	1321	2212	java/lang/Exception
    //   1329	1405	2212	java/lang/Exception
    //   1408	1444	2212	java/lang/Exception
    //   1447	1454	2212	java/lang/Exception
    //   4796	4802	4935	java/lang/Exception
    //   4802	4822	4935	java/lang/Exception
    //   4822	4868	4935	java/lang/Exception
    //   4871	4879	4935	java/lang/Exception
    //   4888	4917	4935	java/lang/Exception
    //   7185	7193	7370	java/lang/Exception
    //   7200	7213	7370	java/lang/Exception
    //   7220	7227	7370	java/lang/Exception
    //   7246	7257	7370	java/lang/Exception
    //   7264	7275	7370	java/lang/Exception
    //   7282	7293	7370	java/lang/Exception
    //   7300	7311	7370	java/lang/Exception
    //   7318	7329	7370	java/lang/Exception
    //   7336	7361	7370	java/lang/Exception
    //   7127	7133	7378	java/lang/Exception
    //   7133	7153	7378	java/lang/Exception
    //   7153	7178	7378	java/lang/Exception
    //   8053	8060	8152	java/lang/Exception
    //   8065	8075	8152	java/lang/Exception
    //   8087	8098	8152	java/lang/Exception
    //   8105	8121	8152	java/lang/Exception
    //   8029	8053	8157	java/lang/Exception
    //   7971	7977	8164	java/lang/Exception
    //   7977	7997	8164	java/lang/Exception
    //   7997	8029	8164	java/lang/Exception
  }
  
  public static void a(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    a(paramMessage, localQQAppInterface, paramInt);
    if (paramMessage != null) {
      paramBaseQQAppInterface = paramMessage.nickName;
    } else {
      paramBaseQQAppInterface = null;
    }
    a(paramContext, localQQAppInterface, paramMessage, paramInt, paramMsgSummary, paramBaseQQAppInterface, paramBoolean1, paramBoolean2);
  }
  
  private static void a(Message paramMessage, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramMessage != null) && (1 == paramInt))
    {
      paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
      if ((paramQQAppInterface != null) && (!TextUtils.equals(paramQQAppInterface, paramMessage.nickName)))
      {
        paramMessage.nickName = paramQQAppInterface;
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("processTroopNickName  nickname : ");
          paramMessage.append(paramQQAppInterface);
          QLog.i("Q.recent", 2, paramMessage.toString());
        }
      }
    }
  }
  
  private static void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean1, boolean paramBoolean2, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.strPrefix = paramCharSequence1;
    paramMsgSummary.strContent = paramCharSequence2;
    paramMsgSummary.suffix = paramCharSequence3;
    if (paramBoolean1)
    {
      paramMsgSummary.nState = 2;
      return;
    }
    if (paramBoolean2)
    {
      paramMsgSummary.nState = 1;
      return;
    }
    paramMsgSummary.nState = 0;
  }
  
  public static boolean a(AppInterface paramAppInterface, Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    Message localMessage = paramMessage;
    if (UinTypeUtil.c(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (UinTypeUtil.c(paramMessage.senderuin)) {
          return false;
        }
        int i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (paramMessage.isSelfConfessor()) {
            i = 1033;
          } else {
            i = 1034;
          }
        }
        localMessage = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramMessage.senderuin, i);
      }
    }
    if (localMessage.msgtype == -2005) {
      return 2 == a((QQAppInterface)paramAppInterface, localMessage);
    }
    if (localMessage.msgtype == -2017)
    {
      paramMessage = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && ((paramMessage instanceof MessageForTroopFile)))
      {
        paramMessage = (MessageForTroopFile)paramMessage;
        if ((paramMessage != null) && (paramMessage.frienduin != null))
        {
          paramAppInterface = TroopFileUtils.a((QQAppInterface)paramAppInterface, paramMessage);
          if ((paramAppInterface != null) && ((paramAppInterface.e == 1) || (paramAppInterface.e == 0))) {
            return true;
          }
        }
      }
      return false;
    }
    paramMessage = ((ITransFileController)paramAppInterface.getRuntimeService(ITransFileController.class, "")).findProcessor(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof BuddyTransfileProcessor)) && (localMessage.isSendFromLocal()) && (paramMessage != null))
    {
      paramMessage = (BuddyTransfileProcessor)paramMessage;
      if ((paramMessage.getProgress() >= 0) && (paramMessage.getProgress() != 100)) {
        return true;
      }
    }
    return ((MessageCache)paramAppInterface.getMsgCache()).f(localMessage);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic, boolean paramBoolean)
  {
    if (paramMessageForPic.isMultiMsg) {
      return false;
    }
    if (!paramMessageForPic.isSendFromLocal()) {
      return false;
    }
    long l = paramMessageForPic.size;
    boolean bool2 = true;
    if (l <= 0L)
    {
      paramQQAppInterface = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
      boolean bool1 = bool2;
      if ((paramQQAppInterface instanceof BaseTransProcessor))
      {
        l = ((BaseTransProcessor)paramQQAppInterface).getFileStatus();
        bool1 = bool2;
        if (l != 1005L) {
          if (l == 1006L)
          {
            bool1 = bool2;
            if (!paramBoolean) {}
          }
          else
          {
            if (l == 1004L) {
              return true;
            }
            bool1 = false;
          }
        }
      }
      return bool1;
    }
    return paramMessageForPic.extraflag == 32768;
  }
  
  public static String b(String paramString)
  {
    return a(paramString, 1.0F);
  }
  
  public static boolean b(Context paramContext, AppInterface paramAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().f().iterator();
    while (localIterator.hasNext()) {
      if (((ExtractMessageSummaryCallback)localIterator.next()).a(paramContext, paramAppInterface, paramMessage, paramInt, paramMsgSummary, paramString, paramBoolean1, paramBoolean2)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(AppInterface paramAppInterface, Message paramMessage)
  {
    boolean bool2 = false;
    if (paramMessage == null) {
      return false;
    }
    Message localMessage = paramMessage;
    int i;
    if (UinTypeUtil.c(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (UinTypeUtil.c(paramMessage.senderuin)) {
          return false;
        }
        i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (paramMessage.isSelfConfessor()) {
            i = 1033;
          } else {
            i = 1034;
          }
        }
        localMessage = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramMessage.senderuin, i);
      }
    }
    if (localMessage.msgtype == -2005) {
      return a((QQAppInterface)paramAppInterface, localMessage) == 0;
    }
    if (localMessage.fileType == 1)
    {
      i = TransFileControllerBusHelper.findProcessorFileStatus(paramAppInterface, localMessage.frienduin, null, localMessage.uniseq);
      if ((i == 1005) || (i == 1004)) {
        return true;
      }
    }
    else if (localMessage.msgtype == -2017)
    {
      paramMessage = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage instanceof MessageForTroopFile))
      {
        paramMessage = (MessageForTroopFile)paramMessage;
        if ((paramMessage != null) && (paramMessage.frienduin != null))
        {
          paramAppInterface = TroopFileUtils.a((QQAppInterface)paramAppInterface, paramMessage);
          if ((paramAppInterface != null) && (paramAppInterface.e == 3)) {
            return true;
          }
        }
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("uniseq:");
        paramAppInterface.append(localMessage.uniseq);
        paramAppInterface.append(",msgtype:");
        paramAppInterface.append(localMessage.msgtype);
        QLog.d("MsgTypeError", 2, paramAppInterface.toString());
      }
    }
    boolean bool1 = bool2;
    if (localMessage.isSendFromLocal())
    {
      bool1 = bool2;
      if (localMessage.extraflag == 32768) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String c(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return paramString;
      }
      Object localObject = paramString.toCharArray();
      int j = paramString.length();
      int i = 0;
      j -= 1;
      while ((i <= j) && (localObject[i] <= ' ') && (localObject[i] != '\024')) {
        i += 1;
      }
      if (i == 0) {
        return paramString;
      }
      localObject = paramString.substring(i, j + 1);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("trimBegin source:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", temp:");
        localStringBuilder.append((String)localObject);
        QLog.i("MsgUtils", 4, localStringBuilder.toString());
      }
      return localObject;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MsgUtils
 * JD-Core Version:    0.7.0.1
 */