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
  private static float jdField_a_of_type_Float;
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static float jdField_b_of_type_Float;
  private static long jdField_b_of_type_Long;
  private static float c;
  
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
    paramQQAppInterface.status = FileManagerUtil.b(paramQQAppInterface.status);
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
    paramContext = paramQQAppInterface.getMsgHandler().a(AppShareIDUtil.a(paramMessage.shareAppID));
    if ((paramContext != null) && (paramContext.messagetail != null) && (!"".equals(paramContext.messagetail)))
    {
      paramMessage = new StringBuilder();
      paramMessage.append(paramQQAppInterface.getApp().getString(2131690096));
      paramMessage.append(paramContext.messagetail);
      paramMessage.append(paramQQAppInterface.getApp().getString(2131690097));
      return paramMessage.toString();
    }
    return paramQQAppInterface.getApp().getString(2131690094);
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
        paramContext = paramContext.getString(2131689526);
        break;
      case -1008: 
        paramContext = paramContext.getString(2131689525);
        break;
      case -1009: 
        paramContext = paramContext.getString(2131718177);
        break;
      case -1010: 
        paramContext = paramContext.getString(2131689659);
        break;
      case -1011: 
      case -1006: 
        paramContext = paramContext.getString(2131689622);
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
          ((StringBuffer)localObject).append(paramContext.getString(2131693231));
        }
        if (j > 0)
        {
          ((StringBuffer)localObject).append(j);
          ((StringBuffer)localObject).append(paramContext.getString(2131694190));
        }
        ((StringBuffer)localObject).append(k);
        ((StringBuffer)localObject).append(paramContext.getString(2131718653));
        str1 = paramString.replace(str1, ((StringBuffer)localObject).toString());
      }
    }
    return str1;
  }
  
  @Nullable
  private static String a(AppInterface paramAppInterface, Message paramMessage, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (AnonymousChatHelper.a(paramMessage)) {
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
          paramString = AnonymousChatHelper.a(paramAppInterface).b;
        }
        str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = AnonymousChatHelper.a(paramMessage).b;
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
      paramAppInterface = paramMessage.c;
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
      paramString1 = paramContext.getResources().getString(2131695557);
      if ((paramInt == 1) || (paramInt == 5000)) {
        paramString1 = paramContext.getResources().getString(2131695580);
      }
    }
    else if (paramString2 != null)
    {
      paramString2 = ContactUtils.a(paramQQAppInterface, paramString2, paramString1, i, 0);
      paramString1 = paramContext.getResources().getString(2131695557);
      if ((paramInt == 1) || (paramInt == 5000)) {
        paramString1 = paramContext.getResources().getString(2131695580);
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
      paramString1 = paramContext.getResources().getString(2131695509);
    }
    else
    {
      paramString1 = paramContext.getResources().getString(2131695577);
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
        paramArrayOfString = paramQQAppInterface.getApp().getString(2131695582);
      } else if (paramInt == 5) {
        paramArrayOfString = paramQQAppInterface.getApp().getString(2131695589);
      } else {
        paramArrayOfString = paramQQAppInterface.getApp().getString(2131695577);
      }
      paramContext = new StringBuilder();
      paramContext.append(": ");
      paramContext.append(paramArrayOfString);
      paramArrayOfString = paramContext.toString();
      paramArrayOfString = paramString1.replace(paramQQAppInterface.getApp().getString(2131695580), paramArrayOfString);
    }
    return paramArrayOfString;
    return "";
  }
  
  public static String a(String paramString)
  {
    String str = HardCodeUtil.a(2131707010);
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
    //   5: invokevirtual 213	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aload_0
    //   12: areturn
    //   13: lconst_0
    //   14: lstore 9
    //   16: invokestatic 376	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   19: ifeq +8 -> 27
    //   22: invokestatic 382	android/os/SystemClock:elapsedRealtime	()J
    //   25: lstore 9
    //   27: getstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   30: istore 5
    //   32: fconst_0
    //   33: fstore_2
    //   34: iload 5
    //   36: ifne +577 -> 613
    //   39: invokestatic 389	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: invokevirtual 340	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   45: invokevirtual 393	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   48: astore 11
    //   50: ldc_w 394
    //   53: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   56: astore 12
    //   58: new 396	android/text/TextPaint
    //   61: dup
    //   62: invokespecial 397	android/text/TextPaint:<init>	()V
    //   65: astore 13
    //   67: aload 13
    //   69: aload 11
    //   71: getfield 402	android/util/DisplayMetrics:density	F
    //   74: ldc_w 403
    //   77: fmul
    //   78: invokevirtual 407	android/text/TextPaint:setTextSize	(F)V
    //   81: aload 11
    //   83: getfield 410	android/util/DisplayMetrics:widthPixels	I
    //   86: aload 11
    //   88: getfield 413	android/util/DisplayMetrics:heightPixels	I
    //   91: invokestatic 419	java/lang/Math:min	(II)I
    //   94: i2f
    //   95: fstore_3
    //   96: aload 11
    //   98: getfield 402	android/util/DisplayMetrics:density	F
    //   101: fstore 4
    //   103: fload_3
    //   104: fload 4
    //   106: ldc_w 420
    //   109: fmul
    //   110: fsub
    //   111: fstore_3
    //   112: fload_3
    //   113: fconst_0
    //   114: fcmpg
    //   115: ifgt +115 -> 230
    //   118: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +107 -> 228
    //   124: new 150	java/lang/StringBuilder
    //   127: dup
    //   128: bipush 120
    //   130: invokespecial 368	java/lang/StringBuilder:<init>	(I)V
    //   133: astore 11
    //   135: aload 11
    //   137: ldc_w 425
    //   140: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 11
    //   146: ldc_w 427
    //   149: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 11
    //   155: getstatic 429	com/tencent/mobileqq/utils/MsgUtils:c	F
    //   158: invokevirtual 432	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 11
    //   164: ldc_w 434
    //   167: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 11
    //   173: getstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   176: invokevirtual 437	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 11
    //   182: ldc_w 439
    //   185: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 11
    //   191: getstatic 441	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Float	F
    //   194: invokevirtual 432	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 11
    //   200: ldc_w 443
    //   203: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 11
    //   209: getstatic 445	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Float	F
    //   212: invokevirtual 432	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc_w 447
    //   219: iconst_2
    //   220: aload 11
    //   222: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: areturn
    //   230: ldc_w 452
    //   233: fload_3
    //   234: fmul
    //   235: putstatic 429	com/tencent/mobileqq/utils/MsgUtils:c	F
    //   238: aload 13
    //   240: aload 12
    //   242: invokevirtual 456	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   245: putstatic 441	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Float	F
    //   248: aload 13
    //   250: ldc_w 458
    //   253: invokevirtual 456	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   256: bipush 8
    //   258: i2f
    //   259: fdiv
    //   260: putstatic 445	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Float	F
    //   263: getstatic 441	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Float	F
    //   266: fconst_1
    //   267: fcmpl
    //   268: ifle +16 -> 284
    //   271: fload_3
    //   272: ldc_w 459
    //   275: fmul
    //   276: getstatic 441	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Float	F
    //   279: fdiv
    //   280: f2i
    //   281: putstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   284: getstatic 445	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Float	F
    //   287: fconst_1
    //   288: fcmpl
    //   289: ifle +20 -> 309
    //   292: getstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   295: getstatic 429	com/tencent/mobileqq/utils/MsgUtils:c	F
    //   298: getstatic 445	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Float	F
    //   301: fdiv
    //   302: f2i
    //   303: invokestatic 419	java/lang/Math:min	(II)I
    //   306: putstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   309: getstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   312: ifgt +8 -> 320
    //   315: bipush 14
    //   317: putstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   320: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +290 -> 613
    //   326: new 150	java/lang/StringBuilder
    //   329: dup
    //   330: bipush 120
    //   332: invokespecial 368	java/lang/StringBuilder:<init>	(I)V
    //   335: astore 11
    //   337: goto +68 -> 405
    //   340: astore_0
    //   341: goto +160 -> 501
    //   344: astore 11
    //   346: aload 11
    //   348: invokevirtual 462	java/lang/Error:printStackTrace	()V
    //   351: bipush 14
    //   353: putstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   356: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +254 -> 613
    //   362: new 150	java/lang/StringBuilder
    //   365: dup
    //   366: bipush 120
    //   368: invokespecial 368	java/lang/StringBuilder:<init>	(I)V
    //   371: astore 11
    //   373: goto +32 -> 405
    //   376: astore 11
    //   378: aload 11
    //   380: invokevirtual 463	java/lang/Exception:printStackTrace	()V
    //   383: bipush 14
    //   385: putstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   388: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +222 -> 613
    //   394: new 150	java/lang/StringBuilder
    //   397: dup
    //   398: bipush 120
    //   400: invokespecial 368	java/lang/StringBuilder:<init>	(I)V
    //   403: astore 11
    //   405: aload 11
    //   407: ldc_w 425
    //   410: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 11
    //   416: ldc_w 427
    //   419: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 11
    //   425: getstatic 429	com/tencent/mobileqq/utils/MsgUtils:c	F
    //   428: invokevirtual 432	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 11
    //   434: ldc_w 434
    //   437: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 11
    //   443: getstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   446: invokevirtual 437	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 11
    //   452: ldc_w 439
    //   455: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 11
    //   461: getstatic 441	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Float	F
    //   464: invokevirtual 432	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 11
    //   470: ldc_w 443
    //   473: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 11
    //   479: getstatic 445	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Float	F
    //   482: invokevirtual 432	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: ldc_w 447
    //   489: iconst_2
    //   490: aload 11
    //   492: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: goto +115 -> 613
    //   501: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   504: ifeq +107 -> 611
    //   507: new 150	java/lang/StringBuilder
    //   510: dup
    //   511: bipush 120
    //   513: invokespecial 368	java/lang/StringBuilder:<init>	(I)V
    //   516: astore 11
    //   518: aload 11
    //   520: ldc_w 425
    //   523: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 11
    //   529: ldc_w 427
    //   532: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 11
    //   538: getstatic 429	com/tencent/mobileqq/utils/MsgUtils:c	F
    //   541: invokevirtual 432	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 11
    //   547: ldc_w 434
    //   550: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 11
    //   556: getstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   559: invokevirtual 437	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload 11
    //   565: ldc_w 439
    //   568: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 11
    //   574: getstatic 441	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Float	F
    //   577: invokevirtual 432	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 11
    //   583: ldc_w 443
    //   586: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 11
    //   592: getstatic 445	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Float	F
    //   595: invokevirtual 432	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: ldc_w 447
    //   602: iconst_2
    //   603: aload 11
    //   605: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload_0
    //   612: athrow
    //   613: aload_0
    //   614: invokevirtual 213	java/lang/String:length	()I
    //   617: istore 7
    //   619: iload 7
    //   621: getstatic 384	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Int	I
    //   624: if_icmplt +153 -> 777
    //   627: getstatic 445	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Float	F
    //   630: fconst_1
    //   631: fcmpg
    //   632: iflt +145 -> 777
    //   635: getstatic 441	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Float	F
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
    //   662: invokevirtual 467	java/lang/String:charAt	(I)C
    //   665: istore 8
    //   667: iload 8
    //   669: bipush 32
    //   671: if_icmplt +17 -> 688
    //   674: iload 8
    //   676: bipush 126
    //   678: if_icmpgt +10 -> 688
    //   681: getstatic 445	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Float	F
    //   684: fstore_3
    //   685: goto +7 -> 692
    //   688: getstatic 441	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Float	F
    //   691: fstore_3
    //   692: fload_2
    //   693: fload_3
    //   694: fadd
    //   695: fstore_2
    //   696: getstatic 429	com/tencent/mobileqq/utils/MsgUtils:c	F
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
    //   735: new 150	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   742: astore 11
    //   744: aload 11
    //   746: aload_0
    //   747: iconst_0
    //   748: iload 6
    //   750: iconst_1
    //   751: isub
    //   752: invokevirtual 352	java/lang/String:substring	(II)Ljava/lang/String;
    //   755: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 11
    //   761: ldc_w 354
    //   764: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 11
    //   770: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: astore_0
    //   774: goto +3 -> 777
    //   777: invokestatic 376	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   780: ifeq +79 -> 859
    //   783: getstatic 469	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Long	J
    //   786: invokestatic 382	android/os/SystemClock:elapsedRealtime	()J
    //   789: lload 9
    //   791: lsub
    //   792: ladd
    //   793: putstatic 469	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Long	J
    //   796: getstatic 471	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Long	J
    //   799: lconst_1
    //   800: ladd
    //   801: putstatic 471	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Long	J
    //   804: getstatic 471	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Long	J
    //   807: ldc2_w 472
    //   810: lrem
    //   811: lconst_1
    //   812: lcmp
    //   813: ifne +46 -> 859
    //   816: new 150	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   823: astore 11
    //   825: aload 11
    //   827: ldc_w 475
    //   830: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 11
    //   836: getstatic 469	com/tencent/mobileqq/utils/MsgUtils:jdField_a_of_type_Long	J
    //   839: getstatic 471	com/tencent/mobileqq/utils/MsgUtils:jdField_b_of_type_Long	J
    //   842: ldiv
    //   843: invokevirtual 478	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: ldc_w 447
    //   850: iconst_4
    //   851: aload 11
    //   853: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   856: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
                          paramContext = paramContext.getResources().getString(2131695943);
                        } else {
                          paramContext = paramContext.getResources().getString(2131695364);
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
                        ((StringBuilder)localObject).append(paramContext.getResources().getString(2131695364));
                        ((StringBuilder)localObject).append(" ");
                        ((StringBuilder)localObject).append(paramArrayOfString[0]);
                        return ((StringBuilder)localObject).toString();
                      }
                    }
                    localObject = str;
                    if (paramArrayOfString[0] == null) {
                      break label1037;
                    }
                    if (paramContext.getString(2131720225).equals(paramArrayOfString[0]))
                    {
                      if (paramBoolean1) {
                        paramArrayOfString = paramContext.getResources().getString(2131695960);
                      } else {
                        paramArrayOfString = paramContext.getResources().getString(2131695378);
                      }
                    }
                    else if (paramBoolean1)
                    {
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append(paramContext.getResources().getString(2131695943));
                      ((StringBuilder)localObject).append(" ");
                      ((StringBuilder)localObject).append(paramArrayOfString[0]);
                      paramArrayOfString = ((StringBuilder)localObject).toString();
                    }
                    else
                    {
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append(paramContext.getResources().getString(2131695364));
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
        return paramContext.getResources().getString(2131695959);
      }
      return paramContext.getResources().getString(2131695377);
      if (paramBoolean1) {
        return paramContext.getResources().getString(2131695943);
      }
      return paramContext.getResources().getString(2131695364);
      if (paramBoolean1) {
        return paramContext.getResources().getString(2131695944);
      }
      return paramContext.getResources().getString(2131695366);
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131695956);
        }
        return paramContext.getResources().getString(2131695955);
      }
      if (paramBoolean2) {
        return paramContext.getResources().getString(2131695373);
      }
      return paramContext.getResources().getString(2131695372);
      if (paramBoolean1) {
        return paramContext.getResources().getString(2131695957);
      }
      return paramContext.getResources().getString(2131695374);
      localObject = str;
      if (paramArrayOfString[0] == null) {
        break;
      }
      if (paramContext.getString(2131720229).equals(paramArrayOfString[0]))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            paramArrayOfString = paramContext.getResources().getString(2131695956);
          } else {
            paramArrayOfString = paramContext.getResources().getString(2131695955);
          }
        }
        else if (paramBoolean2) {
          paramArrayOfString = paramContext.getResources().getString(2131695373);
        } else {
          paramArrayOfString = paramContext.getResources().getString(2131695372);
        }
      }
      else if (paramBoolean1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getResources().getString(2131695943));
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramArrayOfString[0]);
        paramArrayOfString = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getResources().getString(2131695364));
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramArrayOfString[0]);
        paramArrayOfString = ((StringBuilder)localObject).toString();
        continue;
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695956);
          }
          return paramContext.getResources().getString(2131695955);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131695373);
        }
        return paramContext.getResources().getString(2131695372);
        localObject = str;
        if (paramArrayOfString[0] == null) {
          break;
        }
        if (paramContext.getString(2131720225).equals(paramArrayOfString[0]))
        {
          if (paramBoolean1) {
            paramArrayOfString = paramContext.getResources().getString(2131695960);
          } else {
            paramArrayOfString = paramContext.getResources().getString(2131695378);
          }
        }
        else if (paramBoolean1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.getResources().getString(2131695943));
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramArrayOfString[0]);
          paramArrayOfString = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.getResources().getString(2131695364));
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
    //   11: invokestatic 502	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;Ljava/lang/String;Z)Ljava/lang/String;
    //   14: astore 5
    //   16: aload 5
    //   18: astore 14
    //   20: aload_2
    //   21: getfield 506	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   24: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifne +49 -> 76
    //   30: aload 5
    //   32: astore 14
    //   34: aload 5
    //   36: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +37 -> 76
    //   42: new 150	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   49: astore 13
    //   51: aload 13
    //   53: aload_2
    //   54: getfield 506	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   57: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 13
    //   63: aload 5
    //   65: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 13
    //   71: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 14
    //   76: aload_0
    //   77: aload_1
    //   78: aload_2
    //   79: iload_3
    //   80: aload 4
    //   82: aload 14
    //   84: iload 6
    //   86: iload 7
    //   88: invokestatic 512	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;ILcom/tencent/mobileqq/activity/recent/MsgSummary;Ljava/lang/String;ZZ)Z
    //   91: ifeq +4 -> 95
    //   94: return
    //   95: aload_2
    //   96: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   99: sipush -2034
    //   102: if_icmpne +16 -> 118
    //   105: aload 4
    //   107: aload_2
    //   108: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   111: invokestatic 520	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   117: return
    //   118: aload_2
    //   119: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   122: istore 8
    //   124: ldc 119
    //   126: astore 5
    //   128: iload 8
    //   130: sipush -2011
    //   133: if_icmpne +194 -> 327
    //   136: aload_2
    //   137: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   140: sipush -2011
    //   143: if_icmpne +29 -> 172
    //   146: aload_2
    //   147: getfield 528	com/tencent/imcore/message/Message:extInt	I
    //   150: bipush 61
    //   152: if_icmpne +20 -> 172
    //   155: aload_2
    //   156: aload_1
    //   157: invokevirtual 529	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   160: invokevirtual 530	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   163: ldc_w 531
    //   166: invokevirtual 344	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   169: putfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   172: aload_2
    //   173: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   176: iconst_1
    //   177: if_icmpne +110 -> 287
    //   180: aload_1
    //   181: ldc_w 287
    //   184: ldc 119
    //   186: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   189: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   192: aload_2
    //   193: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   196: aload_2
    //   197: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   200: aload_2
    //   201: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   204: invokeinterface 297 5 0
    //   209: astore_0
    //   210: ldc_w 533
    //   213: invokestatic 539	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   216: checkcast 533	com/tencent/mobileqq/nearby/api/INearbyFlowerUtil
    //   219: aload_0
    //   220: invokeinterface 542 2 0
    //   225: ifeq +35 -> 260
    //   228: aconst_null
    //   229: aconst_null
    //   230: ldc_w 533
    //   233: invokestatic 539	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   236: checkcast 533	com/tencent/mobileqq/nearby/api/INearbyFlowerUtil
    //   239: aload_0
    //   240: checkcast 544	com/tencent/mobileqq/data/MessageForStructing
    //   243: invokeinterface 548 2 0
    //   248: iconst_0
    //   249: iconst_0
    //   250: aload 4
    //   252: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   255: iconst_1
    //   256: istore_3
    //   257: goto +5 -> 262
    //   260: iconst_0
    //   261: istore_3
    //   262: aload_0
    //   263: invokestatic 554	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   266: ifeq +23 -> 289
    //   269: aconst_null
    //   270: aconst_null
    //   271: aload_2
    //   272: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   275: iconst_0
    //   276: iconst_0
    //   277: aload 4
    //   279: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   282: iconst_1
    //   283: istore_3
    //   284: goto +5 -> 289
    //   287: iconst_0
    //   288: istore_3
    //   289: iload_3
    //   290: ifne +7895 -> 8185
    //   293: aload_1
    //   294: aload_2
    //   295: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   298: istore 6
    //   300: aload_1
    //   301: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   304: aload_2
    //   305: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   308: istore 7
    //   310: aload 14
    //   312: aconst_null
    //   313: aload_2
    //   314: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   317: iload 6
    //   319: iload 7
    //   321: aload 4
    //   323: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   326: return
    //   327: aload_2
    //   328: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   331: sipush -2000
    //   334: if_icmpeq +7366 -> 7700
    //   337: aload_2
    //   338: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   341: sipush -5015
    //   344: if_icmpne +6 -> 350
    //   347: goto +7353 -> 7700
    //   350: aload_2
    //   351: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   354: sipush -2002
    //   357: if_icmpeq +7077 -> 7434
    //   360: aload_2
    //   361: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   364: sipush -1031
    //   367: if_icmpne +6 -> 373
    //   370: goto +7064 -> 7434
    //   373: aload_2
    //   374: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   377: sipush -3008
    //   380: if_icmpne +58 -> 438
    //   383: new 150	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   390: astore_1
    //   391: aload_1
    //   392: aload_0
    //   393: ldc_w 560
    //   396: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   399: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_1
    //   404: ldc_w 562
    //   407: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_1
    //   412: aload_2
    //   413: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   416: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_1
    //   421: ldc_w 562
    //   424: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 4
    //   430: aload_1
    //   431: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   437: return
    //   438: aload_2
    //   439: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   442: sipush -2015
    //   445: if_icmpeq +6981 -> 7426
    //   448: aload_2
    //   449: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   452: sipush -2060
    //   455: if_icmpeq +6971 -> 7426
    //   458: aload_2
    //   459: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   462: sipush -2062
    //   465: if_icmpeq +6961 -> 7426
    //   468: aload_2
    //   469: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   472: sipush -2065
    //   475: if_icmpeq +6951 -> 7426
    //   478: aload_2
    //   479: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   482: sipush -7010
    //   485: if_icmpeq +6941 -> 7426
    //   488: aload_2
    //   489: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   492: sipush -7009
    //   495: if_icmpeq +6931 -> 7426
    //   498: aload_2
    //   499: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   502: sipush -7011
    //   505: if_icmpeq +6921 -> 7426
    //   508: aload_2
    //   509: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   512: sipush -7012
    //   515: if_icmpeq +6911 -> 7426
    //   518: aload_2
    //   519: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   522: sipush -4023
    //   525: if_icmpeq +6901 -> 7426
    //   528: aload_2
    //   529: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   532: sipush -4024
    //   535: if_icmpeq +6891 -> 7426
    //   538: aload_2
    //   539: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   542: sipush -4025
    //   545: if_icmpeq +6881 -> 7426
    //   548: aload_2
    //   549: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   552: sipush -4026
    //   555: if_icmpeq +6871 -> 7426
    //   558: aload_2
    //   559: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   562: sipush -4027
    //   565: if_icmpeq +6861 -> 7426
    //   568: aload_2
    //   569: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   572: sipush -7013
    //   575: if_icmpeq +6851 -> 7426
    //   578: aload_2
    //   579: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   582: sipush -7015
    //   585: if_icmpne +6 -> 591
    //   588: goto +6838 -> 7426
    //   591: aload_2
    //   592: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   595: invokestatic 566	com/tencent/mobileqq/utils/ActionMsgUtil:a	(I)Z
    //   598: ifeq +36 -> 634
    //   601: aload_1
    //   602: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   605: astore 5
    //   607: aload 14
    //   609: aload_0
    //   610: aload 5
    //   612: aload_2
    //   613: invokestatic 568	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   616: aconst_null
    //   617: aload_1
    //   618: aload_2
    //   619: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   622: aload 5
    //   624: aload_2
    //   625: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   628: aload 4
    //   630: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   633: return
    //   634: aload_2
    //   635: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   638: sipush -2017
    //   641: if_icmpne +107 -> 748
    //   644: aload_0
    //   645: ldc_w 569
    //   648: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   651: astore 5
    //   653: aload_2
    //   654: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   657: astore_0
    //   658: aload_2
    //   659: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   662: aload_2
    //   663: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   666: invokestatic 574	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   669: ifeq +8 -> 677
    //   672: aload_2
    //   673: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   676: astore_0
    //   677: aload_1
    //   678: ldc_w 287
    //   681: ldc 119
    //   683: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   686: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   689: aload_0
    //   690: aload_2
    //   691: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   694: aload_2
    //   695: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   698: invokeinterface 297 5 0
    //   703: astore 13
    //   705: aload 5
    //   707: astore_0
    //   708: aload 13
    //   710: instanceof 576
    //   713: ifeq +12 -> 725
    //   716: aload 13
    //   718: checkcast 576	com/tencent/mobileqq/data/MessageForTroopFile
    //   721: invokevirtual 579	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   724: astore_0
    //   725: aload 14
    //   727: aload_0
    //   728: aconst_null
    //   729: aload_1
    //   730: aload_2
    //   731: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   734: aload_1
    //   735: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   738: aload_2
    //   739: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   742: aload 4
    //   744: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   747: return
    //   748: aload_2
    //   749: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   752: invokestatic 581	com/tencent/mobileqq/utils/ActionMsgUtil:b	(I)Z
    //   755: ifeq +54 -> 809
    //   758: aload_2
    //   759: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   762: invokestatic 587	com/tencent/mobileqq/transfile/TransfileUtile:analysisTransFileProtocolData	(Ljava/lang/String;)[Ljava/lang/String;
    //   765: astore_1
    //   766: aload_1
    //   767: ifnull +22 -> 789
    //   770: aload 4
    //   772: aload_1
    //   773: aload_0
    //   774: aload_2
    //   775: getfield 590	com/tencent/imcore/message/Message:issend	I
    //   778: invokestatic 593	com/tencent/mobileqq/service/message/remote/MessageRecordInfo:b	(I)Z
    //   781: iload 7
    //   783: invokestatic 595	com/tencent/mobileqq/utils/MsgUtils:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   786: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   789: ldc_w 597
    //   792: invokestatic 539	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   795: checkcast 597	com/tencent/mobileqq/activity/recent/msgbox/api/ITempMsgBoxService
    //   798: iload_3
    //   799: aload 14
    //   801: aload 4
    //   803: invokeinterface 601 4 0
    //   808: return
    //   809: aload_2
    //   810: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   813: invokestatic 603	com/tencent/mobileqq/utils/ActionMsgUtil:c	(I)Z
    //   816: ifeq +42 -> 858
    //   819: aload_2
    //   820: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   823: invokestatic 587	com/tencent/mobileqq/transfile/TransfileUtile:analysisTransFileProtocolData	(Ljava/lang/String;)[Ljava/lang/String;
    //   826: astore 5
    //   828: aload 5
    //   830: ifnull +27 -> 857
    //   833: aload 4
    //   835: aload_1
    //   836: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   839: aload 5
    //   841: aload_0
    //   842: aload_2
    //   843: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   846: aload_2
    //   847: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   850: iload_3
    //   851: invokestatic 605	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   854: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   857: return
    //   858: aload_2
    //   859: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   862: invokestatic 608	com/tencent/mobileqq/utils/ActionMsgUtil:d	(I)Z
    //   865: ifeq +149 -> 1014
    //   868: aload_1
    //   869: aload_2
    //   870: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   873: istore 6
    //   875: aload_1
    //   876: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   879: aload_2
    //   880: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   883: istore 7
    //   885: aload_2
    //   886: ldc_w 610
    //   889: invokevirtual 613	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   892: astore 5
    //   894: getstatic 617	com/tencent/mobileqq/emoticon/EmojiStickerManager:f	Z
    //   897: ifeq +97 -> 994
    //   900: aload 5
    //   902: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   905: ifne +89 -> 994
    //   908: aload_0
    //   909: aload_2
    //   910: invokestatic 622	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   913: astore_0
    //   914: aload_2
    //   915: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   918: aload_1
    //   919: invokevirtual 623	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   922: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   925: ifeq +36 -> 961
    //   928: new 150	java/lang/StringBuilder
    //   931: dup
    //   932: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   935: astore_1
    //   936: aload_1
    //   937: ldc_w 624
    //   940: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   943: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: aload_1
    //   948: aload_0
    //   949: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: pop
    //   953: aload_1
    //   954: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: astore_0
    //   958: goto +42 -> 1000
    //   961: new 150	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   968: astore_1
    //   969: aload_1
    //   970: ldc_w 625
    //   973: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   976: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload_1
    //   981: aload_0
    //   982: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: pop
    //   986: aload_1
    //   987: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: astore_0
    //   991: goto +9 -> 1000
    //   994: aload_0
    //   995: aload_2
    //   996: invokestatic 622	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   999: astore_0
    //   1000: aload 14
    //   1002: aload_0
    //   1003: aconst_null
    //   1004: iload 6
    //   1006: iload 7
    //   1008: aload 4
    //   1010: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1013: return
    //   1014: aload_2
    //   1015: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   1018: sipush -2058
    //   1021: if_icmpne +995 -> 2016
    //   1024: aload_1
    //   1025: aload_2
    //   1026: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1029: istore 9
    //   1031: aload_1
    //   1032: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   1035: aload_2
    //   1036: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1039: istore 10
    //   1041: aload_2
    //   1042: ldc_w 627
    //   1045: invokevirtual 613	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1048: astore 13
    //   1050: aload 13
    //   1052: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1055: ifne +922 -> 1977
    //   1058: new 629	org/json/JSONObject
    //   1061: dup
    //   1062: aload 13
    //   1064: invokespecial 632	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1067: ldc_w 634
    //   1070: invokevirtual 637	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1073: istore 8
    //   1075: aload_2
    //   1076: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   1079: astore 5
    //   1081: aload 5
    //   1083: ifnull +149 -> 1232
    //   1086: iload 8
    //   1088: sipush -2007
    //   1091: if_icmpne +141 -> 1232
    //   1094: aload_2
    //   1095: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   1098: invokestatic 646	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   1101: instanceof 648
    //   1104: ifeq +128 -> 1232
    //   1107: getstatic 617	com/tencent/mobileqq/emoticon/EmojiStickerManager:f	Z
    //   1110: ifeq +102 -> 1212
    //   1113: aload_0
    //   1114: aload_2
    //   1115: invokestatic 622	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1118: astore 5
    //   1120: aload_2
    //   1121: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   1124: aload_1
    //   1125: invokevirtual 623	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1128: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1131: ifeq +42 -> 1173
    //   1134: new 150	java/lang/StringBuilder
    //   1137: dup
    //   1138: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   1141: astore 13
    //   1143: aload 13
    //   1145: ldc_w 649
    //   1148: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1151: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload 13
    //   1157: aload 5
    //   1159: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: pop
    //   1163: aload 13
    //   1165: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1168: astore 5
    //   1170: goto +49 -> 1219
    //   1173: new 150	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   1180: astore 13
    //   1182: aload 13
    //   1184: ldc_w 650
    //   1187: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1190: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: aload 13
    //   1196: aload 5
    //   1198: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: pop
    //   1202: aload 13
    //   1204: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: astore 5
    //   1209: goto +10 -> 1219
    //   1212: aload_0
    //   1213: aload_2
    //   1214: invokestatic 622	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1217: astore 5
    //   1219: iconst_1
    //   1220: istore_3
    //   1221: goto +17 -> 1238
    //   1224: astore_0
    //   1225: ldc 119
    //   1227: astore 5
    //   1229: goto +742 -> 1971
    //   1232: ldc 119
    //   1234: astore 5
    //   1236: iconst_0
    //   1237: istore_3
    //   1238: iload_3
    //   1239: ifne +735 -> 1974
    //   1242: getstatic 617	com/tencent/mobileqq/emoticon/EmojiStickerManager:f	Z
    //   1245: ifeq +147 -> 1392
    //   1248: aload_2
    //   1249: ldc_w 610
    //   1252: invokevirtual 613	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1255: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1258: ifne +131 -> 1389
    //   1261: aload_1
    //   1262: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   1265: aload_2
    //   1266: aload 4
    //   1268: invokestatic 653	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   1271: astore_0
    //   1272: new 150	java/lang/StringBuilder
    //   1275: dup
    //   1276: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   1279: astore_1
    //   1280: aload 14
    //   1282: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1285: ifne +18 -> 1303
    //   1288: aload_1
    //   1289: aload 14
    //   1291: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: pop
    //   1295: aload_1
    //   1296: ldc_w 360
    //   1299: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: aload 4
    //   1305: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1308: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1311: ifne +13 -> 1324
    //   1314: aload_1
    //   1315: aload 4
    //   1317: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1320: invokevirtual 659	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload_2
    //   1325: invokestatic 282	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1328: ifne +32 -> 1360
    //   1331: iload 9
    //   1333: ifeq +14 -> 1347
    //   1336: aload_1
    //   1337: ldc_w 661
    //   1340: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: goto +16 -> 1360
    //   1347: iload 10
    //   1349: ifeq +11 -> 1360
    //   1352: aload_1
    //   1353: ldc_w 663
    //   1356: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: pop
    //   1360: aload_0
    //   1361: checkcast 665	com/tencent/mobileqq/text/QQText
    //   1364: aload_1
    //   1365: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1368: iconst_1
    //   1369: iconst_0
    //   1370: newarray int
    //   1372: invokevirtual 668	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   1375: astore 5
    //   1377: goto +600 -> 1977
    //   1380: astore_1
    //   1381: aload_0
    //   1382: astore 5
    //   1384: aload_1
    //   1385: astore_0
    //   1386: goto +585 -> 1971
    //   1389: goto +588 -> 1977
    //   1392: iload 8
    //   1394: sipush -1000
    //   1397: if_icmpne +136 -> 1533
    //   1400: aload_2
    //   1401: invokestatic 671	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/imcore/message/Message;)Lcom/tencent/mobileqq/text/QQText;
    //   1404: astore_0
    //   1405: aload_0
    //   1406: ifnull +126 -> 1532
    //   1409: new 150	java/lang/StringBuilder
    //   1412: dup
    //   1413: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   1416: astore_1
    //   1417: aload 14
    //   1419: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1422: ifne +18 -> 1440
    //   1425: aload_1
    //   1426: aload 14
    //   1428: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: pop
    //   1432: aload_1
    //   1433: ldc_w 360
    //   1436: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload 4
    //   1442: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1445: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1448: ifne +13 -> 1461
    //   1451: aload_1
    //   1452: aload 4
    //   1454: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1457: invokevirtual 659	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   1460: pop
    //   1461: aload_2
    //   1462: invokestatic 282	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1465: ifne +32 -> 1497
    //   1468: iload 9
    //   1470: ifeq +14 -> 1484
    //   1473: aload_1
    //   1474: ldc_w 661
    //   1477: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: pop
    //   1481: goto +16 -> 1497
    //   1484: iload 10
    //   1486: ifeq +11 -> 1497
    //   1489: aload_1
    //   1490: ldc_w 663
    //   1493: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: pop
    //   1497: aload_0
    //   1498: checkcast 665	com/tencent/mobileqq/text/QQText
    //   1501: aload_1
    //   1502: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1505: iconst_1
    //   1506: iconst_0
    //   1507: newarray int
    //   1509: invokevirtual 668	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   1512: astore_0
    //   1513: aload 4
    //   1515: iconst_1
    //   1516: putfield 674	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   1519: aload 14
    //   1521: aload_0
    //   1522: aconst_null
    //   1523: iload 9
    //   1525: iload 10
    //   1527: aload 4
    //   1529: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1532: return
    //   1533: iload 8
    //   1535: sipush -2000
    //   1538: if_icmpne +436 -> 1974
    //   1541: aload_2
    //   1542: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   1545: astore 13
    //   1547: aload_2
    //   1548: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   1551: aload_2
    //   1552: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   1555: invokestatic 574	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   1558: ifeq +9 -> 1567
    //   1561: aload_2
    //   1562: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   1565: astore 13
    //   1567: aload_1
    //   1568: ldc_w 287
    //   1571: ldc 119
    //   1573: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1576: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   1579: astore 15
    //   1581: aload_2
    //   1582: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   1585: istore_3
    //   1586: aload 15
    //   1588: aload 13
    //   1590: iload_3
    //   1591: aload_2
    //   1592: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   1595: invokeinterface 297 5 0
    //   1600: checkcast 676	com/tencent/mobileqq/data/MessageForPic
    //   1603: astore 15
    //   1605: aload_1
    //   1606: ldc_w 678
    //   1609: ldc 119
    //   1611: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1614: checkcast 678	com/tencent/mobileqq/transfile/api/ITransFileController
    //   1617: aload 13
    //   1619: aload_2
    //   1620: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   1623: invokeinterface 682 4 0
    //   1628: astore 13
    //   1630: aload_2
    //   1631: invokevirtual 312	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   1634: ifeq +40 -> 1674
    //   1637: aload 15
    //   1639: getfield 685	com/tencent/mobileqq/data/MessageForPic:size	J
    //   1642: lconst_0
    //   1643: lcmp
    //   1644: ifgt +16 -> 1660
    //   1647: aload 13
    //   1649: ifnonnull +69 -> 1718
    //   1652: aload 15
    //   1654: ifnull +64 -> 1718
    //   1657: goto +6529 -> 8186
    //   1660: aload 15
    //   1662: getfield 688	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   1665: ldc_w 689
    //   1668: if_icmpne +50 -> 1718
    //   1671: goto +6515 -> 8186
    //   1674: aload 13
    //   1676: ifnull +42 -> 1718
    //   1679: aload 13
    //   1681: instanceof 691
    //   1684: ifeq +34 -> 1718
    //   1687: aload 13
    //   1689: checkcast 691	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   1692: invokevirtual 694	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   1695: lstore 11
    //   1697: lload 11
    //   1699: l2i
    //   1700: istore_3
    //   1701: iload_3
    //   1702: sipush 1005
    //   1705: if_icmpeq +6481 -> 8186
    //   1708: iload_3
    //   1709: sipush 1004
    //   1712: if_icmpne +6 -> 1718
    //   1715: goto +6471 -> 8186
    //   1718: iconst_0
    //   1719: istore 6
    //   1721: iload 6
    //   1723: istore 7
    //   1725: goto +22 -> 1747
    //   1728: astore_1
    //   1729: goto +11 -> 1740
    //   1732: astore_1
    //   1733: goto +4 -> 1737
    //   1736: astore_1
    //   1737: aconst_null
    //   1738: astore 13
    //   1740: aload_1
    //   1741: invokevirtual 463	java/lang/Exception:printStackTrace	()V
    //   1744: iconst_0
    //   1745: istore 7
    //   1747: aload 13
    //   1749: instanceof 691
    //   1752: ifeq +111 -> 1863
    //   1755: aload 13
    //   1757: checkcast 691	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   1760: astore_1
    //   1761: aload_1
    //   1762: invokevirtual 694	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   1765: ldc2_w 695
    //   1768: lcmp
    //   1769: ifeq +6423 -> 8192
    //   1772: iconst_1
    //   1773: istore 6
    //   1775: goto +3 -> 1778
    //   1778: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1781: ifeq +6425 -> 8206
    //   1784: aload_1
    //   1785: getfield 700	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1788: ifnull +6410 -> 8198
    //   1791: aload_1
    //   1792: getfield 700	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1795: getfield 705	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   1798: lstore 11
    //   1800: goto +3 -> 1803
    //   1803: new 150	java/lang/StringBuilder
    //   1806: dup
    //   1807: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   1810: astore 13
    //   1812: aload 13
    //   1814: ldc_w 707
    //   1817: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1820: pop
    //   1821: aload 13
    //   1823: lload 11
    //   1825: invokevirtual 478	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1828: pop
    //   1829: aload 13
    //   1831: ldc_w 709
    //   1834: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: pop
    //   1838: aload 13
    //   1840: aload_1
    //   1841: invokevirtual 712	com/tencent/mobileqq/transfile/BaseTransProcessor:getKey	()Ljava/lang/String;
    //   1844: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: pop
    //   1848: ldc_w 714
    //   1851: iconst_2
    //   1852: aload 13
    //   1854: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: invokestatic 716	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1860: goto +6346 -> 8206
    //   1863: aload 13
    //   1865: ifnull +6350 -> 8215
    //   1868: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1871: ifeq +6338 -> 8209
    //   1874: new 150	java/lang/StringBuilder
    //   1877: dup
    //   1878: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   1881: astore_1
    //   1882: aload_1
    //   1883: ldc_w 718
    //   1886: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1889: pop
    //   1890: aload_1
    //   1891: aload 13
    //   1893: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1896: pop
    //   1897: ldc_w 714
    //   1900: iconst_2
    //   1901: aload_1
    //   1902: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1905: invokestatic 716	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1908: goto +6301 -> 8209
    //   1911: aload_0
    //   1912: ldc_w 719
    //   1915: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   1918: astore_1
    //   1919: aload_2
    //   1920: invokestatic 722	com/tencent/mobileqq/app/HotChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1923: ifne +21 -> 1944
    //   1926: ldc_w 724
    //   1929: invokestatic 539	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1932: checkcast 724	com/tencent/mobileqq/pic/api/IPicFlash
    //   1935: aload_2
    //   1936: invokeinterface 727 2 0
    //   1941: ifeq +11 -> 1952
    //   1944: aload_0
    //   1945: ldc_w 728
    //   1948: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   1951: astore_1
    //   1952: aload 14
    //   1954: aload_1
    //   1955: aconst_null
    //   1956: iload 7
    //   1958: iload 6
    //   1960: aload 4
    //   1962: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1965: return
    //   1966: astore_0
    //   1967: goto +18 -> 1985
    //   1970: astore_0
    //   1971: goto +14 -> 1985
    //   1974: goto +3 -> 1977
    //   1977: goto +24 -> 2001
    //   1980: astore_0
    //   1981: ldc 119
    //   1983: astore 5
    //   1985: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1988: ifeq +13 -> 2001
    //   1991: ldc_w 730
    //   1994: iconst_2
    //   1995: ldc 119
    //   1997: aload_0
    //   1998: invokestatic 734	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2001: aload 14
    //   2003: aload 5
    //   2005: aconst_null
    //   2006: iload 9
    //   2008: iload 10
    //   2010: aload 4
    //   2012: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2015: return
    //   2016: aload_2
    //   2017: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2020: invokestatic 736	com/tencent/mobileqq/utils/ActionMsgUtil:e	(I)Z
    //   2023: ifeq +49 -> 2072
    //   2026: aload_1
    //   2027: aload_2
    //   2028: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2031: istore 6
    //   2033: aload_1
    //   2034: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   2037: aload_2
    //   2038: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2041: istore 7
    //   2043: aload 14
    //   2045: ldc_w 738
    //   2048: invokestatic 539	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2051: checkcast 738	com/tencent/mobileqq/apollo/utils/api/IApolloMessageUtil
    //   2054: aload_1
    //   2055: aload_2
    //   2056: invokeinterface 742 3 0
    //   2061: aconst_null
    //   2062: iload 6
    //   2064: iload 7
    //   2066: aload 4
    //   2068: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2071: return
    //   2072: aload_2
    //   2073: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2076: sipush -1013
    //   2079: if_icmpeq +5330 -> 7409
    //   2082: aload_2
    //   2083: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2086: sipush -1047
    //   2089: if_icmpne +6 -> 2095
    //   2092: goto +5317 -> 7409
    //   2095: aload_2
    //   2096: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2099: sipush -2042
    //   2102: if_icmpeq +5290 -> 7392
    //   2105: aload_2
    //   2106: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2109: sipush -2043
    //   2112: if_icmpne +6 -> 2118
    //   2115: goto +5277 -> 7392
    //   2118: aload_2
    //   2119: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2122: sipush -2051
    //   2125: if_icmpne +184 -> 2309
    //   2128: aload_1
    //   2129: ldc_w 287
    //   2132: ldc 119
    //   2134: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2137: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   2140: aload_2
    //   2141: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2144: aload_2
    //   2145: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   2148: aload_2
    //   2149: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   2152: invokeinterface 297 5 0
    //   2157: astore_0
    //   2158: aload_0
    //   2159: ifnull +53 -> 2212
    //   2162: aload_0
    //   2163: instanceof 744
    //   2166: ifeq +46 -> 2212
    //   2169: aload_0
    //   2170: checkcast 744	com/tencent/mobileqq/data/MessageForQQStory
    //   2173: astore_0
    //   2174: aload_0
    //   2175: invokevirtual 745	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   2178: aload_1
    //   2179: aload_2
    //   2180: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2183: istore 6
    //   2185: aload_1
    //   2186: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   2189: aload_2
    //   2190: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2193: istore 7
    //   2195: aload 14
    //   2197: aconst_null
    //   2198: aload_0
    //   2199: invokevirtual 746	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   2202: iload 6
    //   2204: iload 7
    //   2206: aload 4
    //   2208: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2211: return
    //   2212: new 150	java/lang/StringBuilder
    //   2215: dup
    //   2216: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   2219: astore_1
    //   2220: aload_1
    //   2221: ldc 2
    //   2223: invokevirtual 751	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2226: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: pop
    //   2230: aload_1
    //   2231: ldc_w 753
    //   2234: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: pop
    //   2238: aload_1
    //   2239: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2242: astore_1
    //   2243: new 150	java/lang/StringBuilder
    //   2246: dup
    //   2247: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   2250: astore 4
    //   2252: aload 4
    //   2254: ldc_w 755
    //   2257: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2260: pop
    //   2261: aload 4
    //   2263: aload_2
    //   2264: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   2267: invokevirtual 478	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2270: pop
    //   2271: aload 4
    //   2273: ldc_w 757
    //   2276: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2279: pop
    //   2280: aload_0
    //   2281: ifnull +9 -> 2290
    //   2284: aload_0
    //   2285: invokevirtual 760	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   2288: astore 5
    //   2290: aload 4
    //   2292: aload 5
    //   2294: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: pop
    //   2298: aload_1
    //   2299: iconst_1
    //   2300: aload 4
    //   2302: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2305: invokestatic 762	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2308: return
    //   2309: aload_2
    //   2310: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2313: sipush -7002
    //   2316: if_icmpne +169 -> 2485
    //   2319: aload_1
    //   2320: ldc_w 287
    //   2323: ldc 119
    //   2325: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2328: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   2331: aload_2
    //   2332: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2335: aload_2
    //   2336: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   2339: aload_2
    //   2340: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   2343: invokeinterface 297 5 0
    //   2348: checkcast 764	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   2351: astore_0
    //   2352: aload_0
    //   2353: ifnull +41 -> 2394
    //   2356: aload_0
    //   2357: invokevirtual 765	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   2360: aload_1
    //   2361: aload_2
    //   2362: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2365: istore 6
    //   2367: aload_1
    //   2368: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   2371: aload_2
    //   2372: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2375: istore 7
    //   2377: aload 14
    //   2379: aconst_null
    //   2380: aload_0
    //   2381: invokevirtual 766	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   2384: iload 6
    //   2386: iload 7
    //   2388: aload 4
    //   2390: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2393: return
    //   2394: new 150	java/lang/StringBuilder
    //   2397: dup
    //   2398: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   2401: astore_0
    //   2402: aload_0
    //   2403: ldc 2
    //   2405: invokevirtual 751	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2408: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2411: pop
    //   2412: aload_0
    //   2413: ldc_w 753
    //   2416: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2419: pop
    //   2420: aload_0
    //   2421: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2424: astore_0
    //   2425: new 150	java/lang/StringBuilder
    //   2428: dup
    //   2429: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   2432: astore_1
    //   2433: aload_1
    //   2434: ldc_w 768
    //   2437: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2440: pop
    //   2441: aload_1
    //   2442: aload_2
    //   2443: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   2446: invokevirtual 478	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2449: pop
    //   2450: aload_1
    //   2451: ldc_w 757
    //   2454: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: pop
    //   2458: aload_2
    //   2459: ifnull +9 -> 2468
    //   2462: aload_2
    //   2463: invokevirtual 769	com/tencent/imcore/message/Message:toString	()Ljava/lang/String;
    //   2466: astore 5
    //   2468: aload_1
    //   2469: aload 5
    //   2471: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2474: pop
    //   2475: aload_0
    //   2476: iconst_1
    //   2477: aload_1
    //   2478: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2481: invokestatic 762	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2484: return
    //   2485: aload_2
    //   2486: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2489: sipush -2054
    //   2492: if_icmpne +182 -> 2674
    //   2495: aload_1
    //   2496: ldc_w 287
    //   2499: ldc 119
    //   2501: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2504: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   2507: aload_2
    //   2508: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2511: aload_2
    //   2512: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   2515: aload_2
    //   2516: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   2519: invokeinterface 297 5 0
    //   2524: astore_0
    //   2525: aload_0
    //   2526: instanceof 771
    //   2529: ifeq +45 -> 2574
    //   2532: aload_0
    //   2533: checkcast 771	com/tencent/mobileqq/data/MessageForTroopSign
    //   2536: astore_0
    //   2537: ldc_w 772
    //   2540: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2543: pop
    //   2544: aload_0
    //   2545: invokevirtual 773	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   2548: aload 14
    //   2550: aconst_null
    //   2551: aload_0
    //   2552: invokevirtual 774	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   2555: aload_1
    //   2556: aload_2
    //   2557: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2560: aload_1
    //   2561: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   2564: aload_2
    //   2565: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2568: aload 4
    //   2570: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2573: return
    //   2574: new 150	java/lang/StringBuilder
    //   2577: dup
    //   2578: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   2581: astore_1
    //   2582: aload_1
    //   2583: ldc 2
    //   2585: invokevirtual 751	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2588: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2591: pop
    //   2592: aload_1
    //   2593: ldc_w 776
    //   2596: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2599: pop
    //   2600: aload_1
    //   2601: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2604: astore_1
    //   2605: new 150	java/lang/StringBuilder
    //   2608: dup
    //   2609: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   2612: astore 4
    //   2614: aload 4
    //   2616: ldc_w 778
    //   2619: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: pop
    //   2623: aload 4
    //   2625: aload_2
    //   2626: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   2629: invokevirtual 478	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2632: pop
    //   2633: aload 4
    //   2635: ldc_w 757
    //   2638: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2641: pop
    //   2642: aload_0
    //   2643: ifnull +12 -> 2655
    //   2646: aload_0
    //   2647: getfield 779	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2650: invokestatic 782	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2653: astore 5
    //   2655: aload 4
    //   2657: aload 5
    //   2659: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2662: pop
    //   2663: aload_1
    //   2664: iconst_1
    //   2665: aload 4
    //   2667: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2670: invokestatic 762	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2673: return
    //   2674: aload_2
    //   2675: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2678: sipush -2035
    //   2681: if_icmpne +20 -> 2701
    //   2684: aconst_null
    //   2685: aload_2
    //   2686: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   2689: invokestatic 520	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   2692: aconst_null
    //   2693: iconst_0
    //   2694: iconst_0
    //   2695: aload 4
    //   2697: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2700: return
    //   2701: aload_2
    //   2702: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2705: sipush -2038
    //   2708: if_icmpne +236 -> 2944
    //   2711: aload_2
    //   2712: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2715: astore 5
    //   2717: aload 5
    //   2719: astore_0
    //   2720: getstatic 787	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   2723: aload 5
    //   2725: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2728: ifeq +8 -> 2736
    //   2731: aload_2
    //   2732: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   2735: astore_0
    //   2736: aload_0
    //   2737: astore 5
    //   2739: getstatic 790	com/tencent/mobileqq/app/AppConstants:LBS_HELLO_UIN	Ljava/lang/String;
    //   2742: aload_0
    //   2743: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2746: ifeq +78 -> 2824
    //   2749: getstatic 787	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   2752: aload_2
    //   2753: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   2756: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2759: ifeq +59 -> 2818
    //   2762: aload_1
    //   2763: ldc_w 287
    //   2766: ldc 119
    //   2768: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2771: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   2774: getstatic 787	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   2777: aload_2
    //   2778: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   2781: aload_2
    //   2782: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   2785: invokeinterface 297 5 0
    //   2790: checkcast 792	com/tencent/mobileqq/data/MessageForTroopGift
    //   2793: astore 13
    //   2795: aload_0
    //   2796: astore 5
    //   2798: aload 13
    //   2800: ifnull +24 -> 2824
    //   2803: aload 13
    //   2805: invokevirtual 793	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   2808: aload 13
    //   2810: getfield 794	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   2813: astore 5
    //   2815: goto +9 -> 2824
    //   2818: aload_2
    //   2819: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   2822: astore 5
    //   2824: aload_1
    //   2825: ldc_w 287
    //   2828: ldc 119
    //   2830: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2833: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   2836: aload 5
    //   2838: aload_2
    //   2839: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   2842: aload_2
    //   2843: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   2846: invokeinterface 297 5 0
    //   2851: astore_0
    //   2852: aload_0
    //   2853: instanceof 792
    //   2856: ifeq +41 -> 2897
    //   2859: aload_0
    //   2860: checkcast 792	com/tencent/mobileqq/data/MessageForTroopGift
    //   2863: astore_0
    //   2864: aload_0
    //   2865: invokevirtual 793	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   2868: aload_0
    //   2869: getfield 795	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   2872: ifnull +11 -> 2883
    //   2875: aload_0
    //   2876: getfield 795	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   2879: astore_0
    //   2880: goto +6 -> 2886
    //   2883: ldc 119
    //   2885: astore_0
    //   2886: aconst_null
    //   2887: aload_0
    //   2888: aconst_null
    //   2889: iconst_0
    //   2890: iconst_0
    //   2891: aload 4
    //   2893: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2896: return
    //   2897: aload_0
    //   2898: ifnull +5287 -> 8185
    //   2901: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2904: ifeq +5281 -> 8185
    //   2907: new 150	java/lang/StringBuilder
    //   2910: dup
    //   2911: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   2914: astore_1
    //   2915: aload_1
    //   2916: ldc_w 797
    //   2919: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2922: pop
    //   2923: aload_1
    //   2924: aload_0
    //   2925: invokevirtual 760	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   2928: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2931: pop
    //   2932: ldc_w 730
    //   2935: iconst_2
    //   2936: aload_1
    //   2937: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2940: invokestatic 762	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2943: return
    //   2944: aload_2
    //   2945: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   2948: sipush -2036
    //   2951: if_icmpne +58 -> 3009
    //   2954: aload_1
    //   2955: ldc_w 287
    //   2958: ldc 119
    //   2960: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2963: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   2966: aload_2
    //   2967: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2970: aload_2
    //   2971: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   2974: aload_2
    //   2975: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   2978: invokeinterface 297 5 0
    //   2983: checkcast 799	com/tencent/mobileqq/data/MessageForTroopFee
    //   2986: astore_0
    //   2987: aload_0
    //   2988: ifnull +5197 -> 8185
    //   2991: aload_0
    //   2992: invokevirtual 800	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   2995: aconst_null
    //   2996: aload_0
    //   2997: getfield 801	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3000: aconst_null
    //   3001: iconst_0
    //   3002: iconst_0
    //   3003: aload 4
    //   3005: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3008: return
    //   3009: aload_2
    //   3010: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3013: sipush -2069
    //   3016: if_icmpne +58 -> 3074
    //   3019: aload_1
    //   3020: ldc_w 287
    //   3023: ldc 119
    //   3025: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3028: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3031: aload_2
    //   3032: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3035: aload_2
    //   3036: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   3039: aload_2
    //   3040: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   3043: invokeinterface 297 5 0
    //   3048: checkcast 803	com/tencent/mobileqq/data/MessageForStarLeague
    //   3051: astore_0
    //   3052: aload_0
    //   3053: ifnull +5132 -> 8185
    //   3056: aload_0
    //   3057: invokevirtual 804	com/tencent/mobileqq/data/MessageForStarLeague:parse	()V
    //   3060: aconst_null
    //   3061: aload_0
    //   3062: getfield 805	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   3065: aconst_null
    //   3066: iconst_0
    //   3067: iconst_0
    //   3068: aload 4
    //   3070: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3073: return
    //   3074: aload_2
    //   3075: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3078: sipush -2048
    //   3081: if_icmpne +59 -> 3140
    //   3084: aload_1
    //   3085: ldc_w 287
    //   3088: ldc 119
    //   3090: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3093: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3096: aload_2
    //   3097: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3100: aload_2
    //   3101: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   3104: aload_2
    //   3105: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   3108: invokeinterface 297 5 0
    //   3113: checkcast 807	com/tencent/mobileqq/data/MessageForTroopReward
    //   3116: astore_0
    //   3117: aload_0
    //   3118: ifnull +5067 -> 8185
    //   3121: aload_0
    //   3122: invokevirtual 808	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3125: aload 14
    //   3127: aload_0
    //   3128: getfield 809	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3131: aconst_null
    //   3132: iconst_0
    //   3133: iconst_0
    //   3134: aload 4
    //   3136: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3139: return
    //   3140: aload_2
    //   3141: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   3144: iconst_1
    //   3145: if_icmpne +148 -> 3293
    //   3148: aload_2
    //   3149: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3152: sipush -3006
    //   3155: if_icmpne +138 -> 3293
    //   3158: aload_1
    //   3159: ldc_w 287
    //   3162: ldc 119
    //   3164: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3167: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3170: aload_2
    //   3171: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3174: aload_2
    //   3175: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   3178: aload_2
    //   3179: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   3182: invokeinterface 297 5 0
    //   3187: checkcast 811	com/tencent/mobileqq/data/MessageForPubAccount
    //   3190: astore_0
    //   3191: aload_0
    //   3192: ifnull +4993 -> 8185
    //   3195: aload_0
    //   3196: invokevirtual 812	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   3199: aload_1
    //   3200: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   3203: aload_0
    //   3204: iconst_0
    //   3205: invokestatic 816	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   3208: astore 5
    //   3210: aload_0
    //   3211: invokevirtual 819	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   3214: ifne +8 -> 3222
    //   3217: aconst_null
    //   3218: astore_0
    //   3219: goto +14 -> 3233
    //   3222: aload_1
    //   3223: invokevirtual 529	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3226: ldc_w 820
    //   3229: invokevirtual 162	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3232: astore_0
    //   3233: aload_2
    //   3234: getfield 506	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   3237: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3240: ifne +41 -> 3281
    //   3243: aload_0
    //   3244: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3247: ifne +34 -> 3281
    //   3250: new 150	java/lang/StringBuilder
    //   3253: dup
    //   3254: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   3257: astore_1
    //   3258: aload_1
    //   3259: aload_2
    //   3260: getfield 506	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   3263: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3266: pop
    //   3267: aload_1
    //   3268: aload_0
    //   3269: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3272: pop
    //   3273: aload_1
    //   3274: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3277: astore_0
    //   3278: goto +3 -> 3281
    //   3281: aload_0
    //   3282: aload 5
    //   3284: aconst_null
    //   3285: iconst_0
    //   3286: iconst_0
    //   3287: aload 4
    //   3289: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3292: return
    //   3293: aload_2
    //   3294: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3297: sipush -1034
    //   3300: if_icmpne +106 -> 3406
    //   3303: new 822	com/tencent/mobileqq/data/MessageForRichState
    //   3306: dup
    //   3307: invokespecial 823	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   3310: astore_0
    //   3311: aload_0
    //   3312: aload_2
    //   3313: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3316: putfield 824	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   3319: aload_0
    //   3320: invokevirtual 825	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   3323: new 150	java/lang/StringBuilder
    //   3326: dup
    //   3327: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   3330: astore_1
    //   3331: aload_0
    //   3332: getfield 828	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   3335: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3338: ifne +38 -> 3376
    //   3341: aload_1
    //   3342: aload_0
    //   3343: getfield 828	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   3346: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3349: pop
    //   3350: aload_0
    //   3351: getfield 831	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   3354: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3357: ifne +12 -> 3369
    //   3360: aload_1
    //   3361: aload_0
    //   3362: getfield 831	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   3365: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3368: pop
    //   3369: aload_1
    //   3370: bipush 32
    //   3372: invokevirtual 834	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3375: pop
    //   3376: aload_1
    //   3377: aload_0
    //   3378: invokevirtual 837	com/tencent/mobileqq/data/MessageForRichState:getPlainMsg	()Ljava/lang/String;
    //   3381: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3384: pop
    //   3385: aload_1
    //   3386: invokevirtual 838	java/lang/StringBuilder:length	()I
    //   3389: ifle +4796 -> 8185
    //   3392: aconst_null
    //   3393: aload_1
    //   3394: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3397: aconst_null
    //   3398: iconst_0
    //   3399: iconst_0
    //   3400: aload 4
    //   3402: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3405: return
    //   3406: aload_2
    //   3407: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3410: sipush -2074
    //   3413: if_icmpne +47 -> 3460
    //   3416: new 840	com/tencent/mobileqq/data/MessageForAIOStoryVideo
    //   3419: dup
    //   3420: invokespecial 841	com/tencent/mobileqq/data/MessageForAIOStoryVideo:<init>	()V
    //   3423: astore_0
    //   3424: aload_0
    //   3425: aload_2
    //   3426: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3429: putfield 842	com/tencent/mobileqq/data/MessageForAIOStoryVideo:msg	Ljava/lang/String;
    //   3432: aload_0
    //   3433: invokevirtual 843	com/tencent/mobileqq/data/MessageForAIOStoryVideo:parse	()V
    //   3436: aload_0
    //   3437: getfield 846	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   3440: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3443: ifne +4742 -> 8185
    //   3446: aconst_null
    //   3447: aload_0
    //   3448: getfield 846	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   3451: aconst_null
    //   3452: iconst_0
    //   3453: iconst_0
    //   3454: aload 4
    //   3456: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3459: return
    //   3460: aload_2
    //   3461: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3464: sipush -1019
    //   3467: if_icmpne +56 -> 3523
    //   3470: new 150	java/lang/StringBuilder
    //   3473: dup
    //   3474: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   3477: astore_0
    //   3478: aload_0
    //   3479: ldc_w 847
    //   3482: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3485: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3488: pop
    //   3489: aload_0
    //   3490: aload_2
    //   3491: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3494: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3497: pop
    //   3498: aload_0
    //   3499: ldc_w 848
    //   3502: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3505: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3508: pop
    //   3509: aconst_null
    //   3510: aconst_null
    //   3511: aload_0
    //   3512: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3515: iconst_0
    //   3516: iconst_0
    //   3517: aload 4
    //   3519: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3522: return
    //   3523: aload_2
    //   3524: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3527: sipush -1018
    //   3530: if_icmpne +56 -> 3586
    //   3533: new 150	java/lang/StringBuilder
    //   3536: dup
    //   3537: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   3540: astore_0
    //   3541: aload_0
    //   3542: ldc_w 849
    //   3545: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3548: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3551: pop
    //   3552: aload_0
    //   3553: aload_2
    //   3554: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3557: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3560: pop
    //   3561: aload_0
    //   3562: ldc_w 850
    //   3565: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3568: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3571: pop
    //   3572: aconst_null
    //   3573: aconst_null
    //   3574: aload_0
    //   3575: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3578: iconst_0
    //   3579: iconst_0
    //   3580: aload 4
    //   3582: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3585: return
    //   3586: aload_2
    //   3587: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3590: sipush -2019
    //   3593: if_icmpne +16 -> 3609
    //   3596: aload 4
    //   3598: aload_0
    //   3599: ldc_w 851
    //   3602: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   3605: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3608: return
    //   3609: aload_2
    //   3610: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3613: sipush -7006
    //   3616: if_icmpne +16 -> 3632
    //   3619: aload 4
    //   3621: aload_0
    //   3622: ldc_w 852
    //   3625: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   3628: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3631: return
    //   3632: aload_2
    //   3633: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3636: sipush -1026
    //   3639: if_icmpne +16 -> 3655
    //   3642: aload 4
    //   3644: aload_0
    //   3645: ldc_w 853
    //   3648: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   3651: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3654: return
    //   3655: aload_2
    //   3656: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3659: sipush -1027
    //   3662: if_icmpne +16 -> 3678
    //   3665: aload 4
    //   3667: aload_0
    //   3668: ldc_w 854
    //   3671: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   3674: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3677: return
    //   3678: aload_2
    //   3679: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3682: sipush -2005
    //   3685: if_icmpne +70 -> 3755
    //   3688: aload_1
    //   3689: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   3692: astore 5
    //   3694: aload 5
    //   3696: aload_2
    //   3697: invokestatic 857	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   3700: astore 13
    //   3702: aload_1
    //   3703: aload_2
    //   3704: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3707: istore 6
    //   3709: aload 5
    //   3711: aload_2
    //   3712: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3715: istore 7
    //   3717: aload 14
    //   3719: aload_0
    //   3720: ldc_w 858
    //   3723: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   3726: aconst_null
    //   3727: iload 6
    //   3729: iload 7
    //   3731: aload 4
    //   3733: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3736: aload 13
    //   3738: ifnull +10 -> 3748
    //   3741: aload 4
    //   3743: aload 13
    //   3745: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3748: aload 4
    //   3750: iconst_0
    //   3751: putfield 861	com/tencent/mobileqq/activity/recent/MsgSummary:nState	I
    //   3754: return
    //   3755: aload_2
    //   3756: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3759: sipush -3017
    //   3762: if_icmpne +180 -> 3942
    //   3765: aload_1
    //   3766: ldc_w 287
    //   3769: ldc 119
    //   3771: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3774: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   3777: aload_2
    //   3778: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3781: aload_2
    //   3782: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   3785: aload_2
    //   3786: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   3789: invokeinterface 297 5 0
    //   3794: astore 15
    //   3796: aload 5
    //   3798: astore 13
    //   3800: aload 15
    //   3802: ifnull +88 -> 3890
    //   3805: aload 5
    //   3807: astore 13
    //   3809: aload 15
    //   3811: instanceof 863
    //   3814: ifeq +76 -> 3890
    //   3817: aload 15
    //   3819: checkcast 863	com/tencent/mobileqq/data/MessageForDLFile
    //   3822: astore 5
    //   3824: aload 5
    //   3826: getfield 866	com/tencent/mobileqq/data/MessageForDLFile:fileName	Ljava/lang/String;
    //   3829: invokestatic 868	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   3832: invokestatic 869	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(I)Ljava/lang/String;
    //   3835: astore 13
    //   3837: new 150	java/lang/StringBuilder
    //   3840: dup
    //   3841: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   3844: astore 15
    //   3846: aload 15
    //   3848: ldc_w 871
    //   3851: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3854: pop
    //   3855: aload 15
    //   3857: aload 13
    //   3859: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3862: pop
    //   3863: aload 15
    //   3865: ldc_w 873
    //   3868: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3871: pop
    //   3872: aload 15
    //   3874: aload 5
    //   3876: getfield 866	com/tencent/mobileqq/data/MessageForDLFile:fileName	Ljava/lang/String;
    //   3879: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3882: pop
    //   3883: aload 15
    //   3885: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3888: astore 13
    //   3890: aload_1
    //   3891: aload_2
    //   3892: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3895: istore 6
    //   3897: aload_1
    //   3898: aload_2
    //   3899: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3902: istore 7
    //   3904: aload 14
    //   3906: aload_0
    //   3907: ldc_w 858
    //   3910: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   3913: aconst_null
    //   3914: iload 6
    //   3916: iload 7
    //   3918: aload 4
    //   3920: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3923: aload 13
    //   3925: ifnull +10 -> 3935
    //   3928: aload 4
    //   3930: aload 13
    //   3932: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   3935: aload 4
    //   3937: iconst_0
    //   3938: putfield 861	com/tencent/mobileqq/activity/recent/MsgSummary:nState	I
    //   3941: return
    //   3942: aload_2
    //   3943: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3946: sipush -2022
    //   3949: if_icmpeq +2727 -> 6676
    //   3952: aload_2
    //   3953: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3956: sipush -2071
    //   3959: if_icmpne +6 -> 3965
    //   3962: goto +2714 -> 6676
    //   3965: aload_2
    //   3966: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   3969: sipush -5002
    //   3972: if_icmpne +40 -> 4012
    //   3975: new 875	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   3978: dup
    //   3979: invokespecial 876	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   3982: astore_0
    //   3983: aload_0
    //   3984: aload_2
    //   3985: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   3988: putfield 877	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   3991: aload_0
    //   3992: invokevirtual 878	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   3995: aload_0
    //   3996: getfield 879	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   3999: ifnull +4186 -> 8185
    //   4002: aload 4
    //   4004: aload_0
    //   4005: getfield 879	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   4008: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4011: return
    //   4012: aload_2
    //   4013: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4016: sipush -2029
    //   4019: if_icmpne +174 -> 4193
    //   4022: aload_1
    //   4023: ldc_w 287
    //   4026: ldc 119
    //   4028: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   4031: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   4034: aload_2
    //   4035: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4038: aload_2
    //   4039: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   4042: aload_2
    //   4043: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   4046: invokeinterface 297 5 0
    //   4051: astore_0
    //   4052: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4055: ifeq +40 -> 4095
    //   4058: new 150	java/lang/StringBuilder
    //   4061: dup
    //   4062: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   4065: astore 5
    //   4067: aload 5
    //   4069: ldc_w 881
    //   4072: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4075: pop
    //   4076: aload 5
    //   4078: aload_0
    //   4079: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4082: pop
    //   4083: ldc_w 447
    //   4086: iconst_2
    //   4087: aload 5
    //   4089: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4092: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4095: aload_0
    //   4096: instanceof 883
    //   4099: ifeq +4086 -> 8185
    //   4102: aload_0
    //   4103: checkcast 883	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   4106: astore_0
    //   4107: aload_0
    //   4108: aload_2
    //   4109: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   4112: putfield 884	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   4115: aload_0
    //   4116: invokevirtual 885	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   4119: aload_0
    //   4120: aload_1
    //   4121: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   4124: aload_1
    //   4125: invokevirtual 529	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4128: aconst_null
    //   4129: invokevirtual 889	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   4132: aload_0
    //   4133: getfield 892	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4136: ifnull +4049 -> 8185
    //   4139: aload_0
    //   4140: getfield 895	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   4143: iconst_1
    //   4144: if_icmpne +39 -> 4183
    //   4147: new 150	java/lang/StringBuilder
    //   4150: dup
    //   4151: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   4154: astore_1
    //   4155: aload_1
    //   4156: ldc_w 896
    //   4159: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   4162: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4165: pop
    //   4166: aload_1
    //   4167: aload_0
    //   4168: getfield 892	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4171: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4174: pop
    //   4175: aload_0
    //   4176: aload_1
    //   4177: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4180: putfield 892	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4183: aload 4
    //   4185: aload_0
    //   4186: getfield 892	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4189: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4192: return
    //   4193: aload_2
    //   4194: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4197: sipush -2025
    //   4200: if_icmpeq +2466 -> 6666
    //   4203: aload_2
    //   4204: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4207: sipush -2072
    //   4210: if_icmpne +6 -> 4216
    //   4213: goto +2453 -> 6666
    //   4216: aload_2
    //   4217: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4220: sipush -2076
    //   4223: if_icmpne +58 -> 4281
    //   4226: new 898	com/tencent/mobileqq/data/MessageForLocationShare
    //   4229: dup
    //   4230: invokespecial 899	com/tencent/mobileqq/data/MessageForLocationShare:<init>	()V
    //   4233: astore_1
    //   4234: aload_1
    //   4235: aload_2
    //   4236: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   4239: putfield 900	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   4242: aload_1
    //   4243: invokevirtual 901	com/tencent/mobileqq/data/MessageForLocationShare:parse	()V
    //   4246: aload_1
    //   4247: getfield 902	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   4250: astore_2
    //   4251: aload_2
    //   4252: astore_1
    //   4253: aload_2
    //   4254: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4257: ifeq +11 -> 4268
    //   4260: aload_0
    //   4261: ldc_w 903
    //   4264: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   4267: astore_1
    //   4268: aload 14
    //   4270: ldc 119
    //   4272: aload_1
    //   4273: iconst_0
    //   4274: iconst_0
    //   4275: aload 4
    //   4277: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4280: return
    //   4281: aload_2
    //   4282: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4285: sipush -2052
    //   4288: if_icmpne +85 -> 4373
    //   4291: aload_2
    //   4292: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4295: astore_0
    //   4296: aload_2
    //   4297: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4300: aload_2
    //   4301: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   4304: invokestatic 574	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   4307: ifeq +8 -> 4315
    //   4310: aload_2
    //   4311: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   4314: astore_0
    //   4315: aload_1
    //   4316: ldc_w 287
    //   4319: ldc 119
    //   4321: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   4324: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   4327: aload_0
    //   4328: aload_2
    //   4329: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   4332: aload_2
    //   4333: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   4336: invokeinterface 297 5 0
    //   4341: astore_0
    //   4342: aload_0
    //   4343: instanceof 905
    //   4346: ifeq +3839 -> 8185
    //   4349: aload_0
    //   4350: checkcast 905	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   4353: astore_0
    //   4354: aload_0
    //   4355: invokevirtual 906	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   4358: aload 14
    //   4360: aload_0
    //   4361: invokevirtual 907	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   4364: aconst_null
    //   4365: iconst_0
    //   4366: iconst_0
    //   4367: aload 4
    //   4369: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4372: return
    //   4373: aload_2
    //   4374: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4377: sipush -2047
    //   4380: if_icmpne +51 -> 4431
    //   4383: new 909	com/tencent/mobileqq/data/MessageForVIPDonate
    //   4386: dup
    //   4387: invokespecial 910	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   4390: astore_0
    //   4391: aload_0
    //   4392: aload_2
    //   4393: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   4396: putfield 911	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   4399: aload_0
    //   4400: invokevirtual 912	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   4403: aload_0
    //   4404: invokevirtual 913	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   4407: astore_0
    //   4408: aload_0
    //   4409: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4412: ifne +10 -> 4422
    //   4415: aload 4
    //   4417: aload_0
    //   4418: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4421: return
    //   4422: aload 4
    //   4424: ldc_w 915
    //   4427: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4430: return
    //   4431: aload_2
    //   4432: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4435: sipush -2040
    //   4438: if_icmpne +29 -> 4467
    //   4441: new 917	com/tencent/mobileqq/data/MessageForApproval
    //   4444: dup
    //   4445: invokespecial 918	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   4448: astore_0
    //   4449: aload_0
    //   4450: aload_2
    //   4451: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   4454: putfield 919	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   4457: aload 4
    //   4459: aload_0
    //   4460: invokevirtual 922	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   4463: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4466: return
    //   4467: aload_2
    //   4468: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4471: sipush -2041
    //   4474: if_icmpne +57 -> 4531
    //   4477: aload_0
    //   4478: ldc_w 923
    //   4481: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   4484: astore_1
    //   4485: aload_0
    //   4486: ldc_w 924
    //   4489: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   4492: astore_0
    //   4493: new 150	java/lang/StringBuilder
    //   4496: dup
    //   4497: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   4500: astore_2
    //   4501: aload_2
    //   4502: aload_1
    //   4503: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4506: pop
    //   4507: aload_2
    //   4508: ldc_w 485
    //   4511: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4514: pop
    //   4515: aload_2
    //   4516: aload_0
    //   4517: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4520: pop
    //   4521: aload 4
    //   4523: aload_2
    //   4524: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4527: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4530: return
    //   4531: aload_2
    //   4532: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4535: sipush -7001
    //   4538: if_icmpne +173 -> 4711
    //   4541: aload_2
    //   4542: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4545: astore 5
    //   4547: aload_2
    //   4548: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4551: aload_2
    //   4552: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   4555: invokestatic 574	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   4558: ifeq +9 -> 4567
    //   4561: aload_2
    //   4562: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   4565: astore 5
    //   4567: aload_1
    //   4568: ldc_w 287
    //   4571: ldc 119
    //   4573: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   4576: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   4579: aload 5
    //   4581: aload_2
    //   4582: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   4585: aload_2
    //   4586: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   4589: invokeinterface 297 5 0
    //   4594: checkcast 926	com/tencent/mobileqq/data/MessageForScribble
    //   4597: astore_1
    //   4598: aload_1
    //   4599: invokevirtual 927	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   4602: ifeq +31 -> 4633
    //   4605: aload_1
    //   4606: getfield 930	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   4609: iconst_2
    //   4610: if_icmpne +6 -> 4616
    //   4613: goto +3608 -> 8221
    //   4616: aload_1
    //   4617: getfield 930	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   4620: iconst_3
    //   4621: if_icmpne +50 -> 4671
    //   4624: iconst_0
    //   4625: istore 7
    //   4627: iconst_1
    //   4628: istore 6
    //   4630: goto +47 -> 4677
    //   4633: aload_1
    //   4634: getfield 933	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   4637: iconst_2
    //   4638: if_icmpne +33 -> 4671
    //   4641: ldc_w 935
    //   4644: invokestatic 539	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   4647: checkcast 935	com/tencent/mobileqq/scribble/IScribbleMsgUtils
    //   4650: aload_1
    //   4651: invokeinterface 939 2 0
    //   4656: istore_3
    //   4657: getstatic 943	com/tencent/mobileqq/scribble/ScribbleMsgConstants:c	I
    //   4660: istore 8
    //   4662: iload_3
    //   4663: iload 8
    //   4665: if_icmpeq +6 -> 4671
    //   4668: goto +3553 -> 8221
    //   4671: iconst_0
    //   4672: istore 7
    //   4674: iconst_0
    //   4675: istore 6
    //   4677: goto +14 -> 4691
    //   4680: astore_1
    //   4681: aload_1
    //   4682: invokevirtual 463	java/lang/Exception:printStackTrace	()V
    //   4685: iconst_0
    //   4686: istore 7
    //   4688: iconst_0
    //   4689: istore 6
    //   4691: aload 14
    //   4693: aload_0
    //   4694: ldc_w 944
    //   4697: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   4700: aconst_null
    //   4701: iload 7
    //   4703: iload 6
    //   4705: aload 4
    //   4707: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4710: return
    //   4711: aload_1
    //   4712: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   4715: astore 16
    //   4717: aload 16
    //   4719: aload_2
    //   4720: invokestatic 949	com/tencent/mobileqq/mutualmark/oldlogic/ReactivePushHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   4723: ifeq +18 -> 4741
    //   4726: aload 14
    //   4728: aload_2
    //   4729: invokevirtual 953	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   4732: aconst_null
    //   4733: iconst_0
    //   4734: iconst_0
    //   4735: aload 4
    //   4737: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4740: return
    //   4741: aload_2
    //   4742: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   4745: ifnonnull +11 -> 4756
    //   4748: aload 4
    //   4750: ldc 119
    //   4752: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4755: return
    //   4756: aload_2
    //   4757: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4760: sipush -5003
    //   4763: if_icmpne +13 -> 4776
    //   4766: aload 4
    //   4768: aload_2
    //   4769: invokevirtual 953	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   4772: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4775: return
    //   4776: aload_2
    //   4777: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4780: sipush -2033
    //   4783: if_icmpne +19 -> 4802
    //   4786: aconst_null
    //   4787: ldc_w 954
    //   4790: invokestatic 365	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   4793: aconst_null
    //   4794: iconst_0
    //   4795: iconst_0
    //   4796: aload 4
    //   4798: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4801: return
    //   4802: aload_2
    //   4803: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4806: sipush -2049
    //   4809: if_icmpne +16 -> 4825
    //   4812: aload 4
    //   4814: aload_2
    //   4815: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   4818: invokestatic 520	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   4821: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4824: return
    //   4825: aload_2
    //   4826: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   4829: sipush -1035
    //   4832: if_icmpne +329 -> 5161
    //   4835: aload_2
    //   4836: invokevirtual 312	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   4839: ifeq +64 -> 4903
    //   4842: aload_2
    //   4843: getfield 955	com/tencent/imcore/message/Message:extraflag	I
    //   4846: ldc_w 956
    //   4849: if_icmpne +32 -> 4881
    //   4852: aload_1
    //   4853: invokevirtual 960	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   4856: checkcast 962	com/tencent/mobileqq/service/message/MessageCache
    //   4859: aload_2
    //   4860: invokevirtual 964	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   4863: ifne +9 -> 4872
    //   4866: iconst_1
    //   4867: istore 6
    //   4869: goto +37 -> 4906
    //   4872: iconst_0
    //   4873: istore 6
    //   4875: iconst_1
    //   4876: istore 7
    //   4878: goto +31 -> 4909
    //   4881: aload_2
    //   4882: getfield 955	com/tencent/imcore/message/Message:extraflag	I
    //   4885: ldc_w 689
    //   4888: if_icmpne +9 -> 4897
    //   4891: iconst_1
    //   4892: istore 6
    //   4894: goto +6 -> 4900
    //   4897: iconst_0
    //   4898: istore 6
    //   4900: goto +6 -> 4906
    //   4903: iconst_0
    //   4904: istore 6
    //   4906: iconst_0
    //   4907: istore 7
    //   4909: aload_2
    //   4910: invokevirtual 953	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   4913: astore_0
    //   4914: aload_1
    //   4915: ldc_w 966
    //   4918: ldc_w 968
    //   4921: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   4924: checkcast 966	com/tencent/mobileqq/troop/robot/api/ITroopRobotService
    //   4927: astore_1
    //   4928: aload_1
    //   4929: aload_2
    //   4930: invokeinterface 971 2 0
    //   4935: ifeq +40 -> 4975
    //   4938: aload_1
    //   4939: aload_2
    //   4940: invokeinterface 974 2 0
    //   4945: ifne +10 -> 4955
    //   4948: aload_1
    //   4949: aload_2
    //   4950: invokeinterface 978 2 0
    //   4955: aload_1
    //   4956: aload_2
    //   4957: invokeinterface 982 2 0
    //   4962: astore_1
    //   4963: aload_1
    //   4964: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4967: ifne +8 -> 4975
    //   4970: aload_1
    //   4971: astore_0
    //   4972: goto +3 -> 4975
    //   4975: aload_2
    //   4976: getfield 985	com/tencent/imcore/message/Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   4979: ifnull +165 -> 5144
    //   4982: aload_0
    //   4983: ifnull +161 -> 5144
    //   4986: new 150	java/lang/StringBuilder
    //   4989: dup
    //   4990: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   4993: astore_1
    //   4994: aload 14
    //   4996: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4999: ifne +18 -> 5017
    //   5002: aload_1
    //   5003: aload 14
    //   5005: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5008: pop
    //   5009: aload_1
    //   5010: ldc_w 360
    //   5013: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5016: pop
    //   5017: aload 4
    //   5019: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5022: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5025: ifne +13 -> 5038
    //   5028: aload_1
    //   5029: aload 4
    //   5031: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5034: invokevirtual 659	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   5037: pop
    //   5038: aload_2
    //   5039: invokestatic 282	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5042: ifne +32 -> 5074
    //   5045: iload 6
    //   5047: ifeq +14 -> 5061
    //   5050: aload_1
    //   5051: ldc_w 661
    //   5054: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5057: pop
    //   5058: goto +16 -> 5074
    //   5061: iload 7
    //   5063: ifeq +11 -> 5074
    //   5066: aload_1
    //   5067: ldc_w 663
    //   5070: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5073: pop
    //   5074: aload_0
    //   5075: instanceof 665
    //   5078: ifeq +28 -> 5106
    //   5081: aload_0
    //   5082: checkcast 665	com/tencent/mobileqq/text/QQText
    //   5085: aload_1
    //   5086: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5089: iconst_1
    //   5090: iconst_0
    //   5091: newarray int
    //   5093: invokevirtual 668	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   5096: astore_0
    //   5097: aload 4
    //   5099: iconst_1
    //   5100: putfield 674	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   5103: goto +27 -> 5130
    //   5106: aload_1
    //   5107: aload_0
    //   5108: invokevirtual 659	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   5111: pop
    //   5112: new 987	android/text/SpannableString
    //   5115: dup
    //   5116: aload_1
    //   5117: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5120: invokespecial 990	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   5123: astore_0
    //   5124: aload 4
    //   5126: iconst_0
    //   5127: putfield 674	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   5130: aload 14
    //   5132: aload_0
    //   5133: aconst_null
    //   5134: iload 6
    //   5136: iload 7
    //   5138: aload 4
    //   5140: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5143: return
    //   5144: aload 14
    //   5146: aload_0
    //   5147: invokestatic 992	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5150: aconst_null
    //   5151: iload 6
    //   5153: iload 7
    //   5155: aload 4
    //   5157: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5160: return
    //   5161: aload_2
    //   5162: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   5165: sipush -2057
    //   5168: if_icmpne +17 -> 5185
    //   5171: aload 14
    //   5173: getstatic 997	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   5176: aconst_null
    //   5177: iconst_0
    //   5178: iconst_0
    //   5179: aload 4
    //   5181: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5184: return
    //   5185: aload_2
    //   5186: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   5189: sipush -1012
    //   5192: if_icmpne +79 -> 5271
    //   5195: aload_2
    //   5196: invokevirtual 953	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   5199: astore_1
    //   5200: aload_1
    //   5201: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5204: ifne +2981 -> 8185
    //   5207: aload_1
    //   5208: invokeinterface 1000 1 0
    //   5213: invokestatic 520	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   5216: astore_1
    //   5217: aload_0
    //   5218: ldc_w 1001
    //   5221: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   5224: astore_2
    //   5225: aload_1
    //   5226: invokevirtual 213	java/lang/String:length	()I
    //   5229: aload_2
    //   5230: invokevirtual 213	java/lang/String:length	()I
    //   5233: isub
    //   5234: iconst_1
    //   5235: isub
    //   5236: istore_3
    //   5237: aload_1
    //   5238: astore_0
    //   5239: aload_1
    //   5240: aload_2
    //   5241: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5244: ifeq +16 -> 5260
    //   5247: aload_1
    //   5248: astore_0
    //   5249: iload_3
    //   5250: ifle +10 -> 5260
    //   5253: aload_1
    //   5254: iconst_0
    //   5255: iload_3
    //   5256: invokevirtual 352	java/lang/String:substring	(II)Ljava/lang/String;
    //   5259: astore_0
    //   5260: aconst_null
    //   5261: aload_0
    //   5262: aconst_null
    //   5263: iconst_0
    //   5264: iconst_0
    //   5265: aload 4
    //   5267: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5270: return
    //   5271: aload_2
    //   5272: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   5275: sipush -2059
    //   5278: if_icmpne +33 -> 5311
    //   5281: new 1003	com/tencent/mobileqq/data/MessageForTroopPobing
    //   5284: dup
    //   5285: invokespecial 1004	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   5288: astore_0
    //   5289: aload_0
    //   5290: aload_2
    //   5291: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   5294: putfield 1005	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   5297: aload_0
    //   5298: invokevirtual 1008	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   5301: aload 4
    //   5303: aload_0
    //   5304: invokevirtual 1009	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   5307: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5310: return
    //   5311: aload_2
    //   5312: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   5315: sipush -2066
    //   5318: if_icmpne +95 -> 5413
    //   5321: new 1011	com/tencent/mobileqq/data/MessageForConfessCard
    //   5324: dup
    //   5325: invokespecial 1012	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   5328: astore_0
    //   5329: aload_0
    //   5330: aload_2
    //   5331: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   5334: putfield 1013	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   5337: aload_0
    //   5338: invokevirtual 1014	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   5341: aload_2
    //   5342: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   5345: sipush 1032
    //   5348: if_icmpne +18 -> 5366
    //   5351: aload 14
    //   5353: aload_0
    //   5354: getfield 1017	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   5357: aconst_null
    //   5358: iconst_0
    //   5359: iconst_0
    //   5360: aload 4
    //   5362: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5365: return
    //   5366: new 150	java/lang/StringBuilder
    //   5369: dup
    //   5370: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   5373: astore_1
    //   5374: aload_1
    //   5375: aload 14
    //   5377: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5380: pop
    //   5381: aload_1
    //   5382: ldc_w 1019
    //   5385: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5388: pop
    //   5389: aload_1
    //   5390: aload_0
    //   5391: getfield 1017	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   5394: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5397: pop
    //   5398: ldc 119
    //   5400: aload_1
    //   5401: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5404: aconst_null
    //   5405: iconst_0
    //   5406: iconst_0
    //   5407: aload 4
    //   5409: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5412: return
    //   5413: aload_2
    //   5414: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   5417: sipush -2067
    //   5420: if_icmpne +38 -> 5458
    //   5423: new 1021	com/tencent/mobileqq/data/MessageForTroopConfess
    //   5426: dup
    //   5427: invokespecial 1022	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   5430: astore_0
    //   5431: aload_0
    //   5432: aload_2
    //   5433: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   5436: putfield 1023	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   5439: aload_0
    //   5440: invokevirtual 1024	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   5443: aload 14
    //   5445: aload_0
    //   5446: getfield 1025	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   5449: aconst_null
    //   5450: iconst_0
    //   5451: iconst_0
    //   5452: aload 4
    //   5454: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5457: return
    //   5458: aload_2
    //   5459: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   5462: sipush -5008
    //   5465: if_icmpeq +1091 -> 6556
    //   5468: aload_2
    //   5469: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   5472: sipush -5016
    //   5475: if_icmpeq +1081 -> 6556
    //   5478: aload_2
    //   5479: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   5482: sipush -5017
    //   5485: if_icmpne +6 -> 5491
    //   5488: goto +1068 -> 6556
    //   5491: aload_1
    //   5492: aload_2
    //   5493: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   5496: istore 6
    //   5498: aload_1
    //   5499: aload_2
    //   5500: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   5503: istore 7
    //   5505: aload_2
    //   5506: getfield 1028	com/tencent/imcore/message/Message:fileType	I
    //   5509: istore 8
    //   5511: iload 8
    //   5513: iconst_1
    //   5514: if_icmpeq +979 -> 6493
    //   5517: iload 8
    //   5519: iconst_2
    //   5520: if_icmpeq +886 -> 6406
    //   5523: iload 8
    //   5525: bipush 8
    //   5527: if_icmpeq +879 -> 6406
    //   5530: iload 8
    //   5532: ldc_w 1029
    //   5535: if_icmpeq +853 -> 6388
    //   5538: iload 8
    //   5540: ldc_w 1030
    //   5543: if_icmpeq +827 -> 6370
    //   5546: aload_2
    //   5547: ldc_w 610
    //   5550: invokevirtual 613	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   5553: astore 5
    //   5555: getstatic 617	com/tencent/mobileqq/emoticon/EmojiStickerManager:f	Z
    //   5558: ifeq +133 -> 5691
    //   5561: aload 5
    //   5563: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5566: ifne +125 -> 5691
    //   5569: aload 16
    //   5571: aload_2
    //   5572: aload 4
    //   5574: invokestatic 653	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   5577: astore_0
    //   5578: new 150	java/lang/StringBuilder
    //   5581: dup
    //   5582: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   5585: astore_1
    //   5586: aload 14
    //   5588: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5591: ifne +18 -> 5609
    //   5594: aload_1
    //   5595: aload 14
    //   5597: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5600: pop
    //   5601: aload_1
    //   5602: ldc_w 360
    //   5605: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5608: pop
    //   5609: aload 4
    //   5611: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5614: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5617: ifne +13 -> 5630
    //   5620: aload_1
    //   5621: aload 4
    //   5623: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5626: invokevirtual 659	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   5629: pop
    //   5630: aload_2
    //   5631: invokestatic 282	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5634: ifne +32 -> 5666
    //   5637: iload 6
    //   5639: ifeq +14 -> 5653
    //   5642: aload_1
    //   5643: ldc_w 661
    //   5646: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5649: pop
    //   5650: goto +16 -> 5666
    //   5653: iload 7
    //   5655: ifeq +11 -> 5666
    //   5658: aload_1
    //   5659: ldc_w 663
    //   5662: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5665: pop
    //   5666: aload 14
    //   5668: aload_0
    //   5669: aload_1
    //   5670: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5673: iconst_1
    //   5674: iconst_0
    //   5675: newarray int
    //   5677: invokevirtual 668	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   5680: aconst_null
    //   5681: iload 6
    //   5683: iload 7
    //   5685: aload 4
    //   5687: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5690: return
    //   5691: aload_2
    //   5692: invokevirtual 953	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   5695: astore 13
    //   5697: aload_1
    //   5698: ldc_w 966
    //   5701: ldc_w 968
    //   5704: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   5707: checkcast 966	com/tencent/mobileqq/troop/robot/api/ITroopRobotService
    //   5710: astore 15
    //   5712: aload 13
    //   5714: astore 5
    //   5716: aload 15
    //   5718: aload_2
    //   5719: invokeinterface 971 2 0
    //   5724: ifeq +48 -> 5772
    //   5727: aload 15
    //   5729: aload_2
    //   5730: invokeinterface 974 2 0
    //   5735: ifne +11 -> 5746
    //   5738: aload 15
    //   5740: aload_2
    //   5741: invokeinterface 978 2 0
    //   5746: aload 15
    //   5748: aload_2
    //   5749: invokeinterface 982 2 0
    //   5754: astore 15
    //   5756: aload 13
    //   5758: astore 5
    //   5760: aload 15
    //   5762: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5765: ifne +7 -> 5772
    //   5768: aload 15
    //   5770: astore 5
    //   5772: aload_2
    //   5773: getfield 985	com/tencent/imcore/message/Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   5776: ifnull +456 -> 6232
    //   5779: aload 5
    //   5781: ifnull +451 -> 6232
    //   5784: new 150	java/lang/StringBuilder
    //   5787: dup
    //   5788: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   5791: astore_0
    //   5792: aload 14
    //   5794: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5797: ifne +18 -> 5815
    //   5800: aload_0
    //   5801: aload 14
    //   5803: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5806: pop
    //   5807: aload_0
    //   5808: ldc_w 360
    //   5811: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5814: pop
    //   5815: aload 4
    //   5817: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5820: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5823: ifne +13 -> 5836
    //   5826: aload_0
    //   5827: aload 4
    //   5829: getfield 656	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   5832: invokevirtual 659	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   5835: pop
    //   5836: aload_2
    //   5837: invokestatic 282	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5840: ifne +32 -> 5872
    //   5843: iload 6
    //   5845: ifeq +14 -> 5859
    //   5848: aload_0
    //   5849: ldc_w 661
    //   5852: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5855: pop
    //   5856: goto +16 -> 5872
    //   5859: iload 7
    //   5861: ifeq +11 -> 5872
    //   5864: aload_0
    //   5865: ldc_w 663
    //   5868: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5871: pop
    //   5872: aload 5
    //   5874: instanceof 665
    //   5877: ifeq +43 -> 5920
    //   5880: aload 5
    //   5882: checkcast 665	com/tencent/mobileqq/text/QQText
    //   5885: aload_0
    //   5886: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5889: iconst_1
    //   5890: iconst_3
    //   5891: newarray int
    //   5893: dup
    //   5894: iconst_0
    //   5895: iconst_0
    //   5896: iastore
    //   5897: dup
    //   5898: iconst_1
    //   5899: bipush 16
    //   5901: iastore
    //   5902: dup
    //   5903: iconst_2
    //   5904: iconst_1
    //   5905: iastore
    //   5906: invokevirtual 668	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   5909: astore 5
    //   5911: aload 4
    //   5913: iconst_1
    //   5914: putfield 674	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   5917: goto +29 -> 5946
    //   5920: aload_0
    //   5921: aload 5
    //   5923: invokevirtual 659	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   5926: pop
    //   5927: new 987	android/text/SpannableString
    //   5930: dup
    //   5931: aload_0
    //   5932: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5935: invokespecial 990	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   5938: astore 5
    //   5940: aload 4
    //   5942: iconst_0
    //   5943: putfield 674	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   5946: aload 5
    //   5948: astore_0
    //   5949: aload_2
    //   5950: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   5953: sipush -5040
    //   5956: if_icmpne +171 -> 6127
    //   5959: new 150	java/lang/StringBuilder
    //   5962: dup
    //   5963: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   5966: astore_0
    //   5967: aload_0
    //   5968: ldc_w 485
    //   5971: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5974: pop
    //   5975: aload_0
    //   5976: invokestatic 1034	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5979: ldc_w 1035
    //   5982: invokevirtual 1036	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   5985: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5988: pop
    //   5989: aload_0
    //   5990: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5993: astore_0
    //   5994: aload 5
    //   5996: invokeinterface 1000 1 0
    //   6001: astore 15
    //   6003: aload 5
    //   6005: astore 13
    //   6007: aload 15
    //   6009: ifnull +26 -> 6035
    //   6012: aload 5
    //   6014: astore 13
    //   6016: aload 15
    //   6018: aload_0
    //   6019: invokevirtual 1039	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6022: ifeq +13 -> 6035
    //   6025: aload 15
    //   6027: aload_0
    //   6028: ldc 119
    //   6030: invokevirtual 275	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   6033: astore 13
    //   6035: aload 13
    //   6037: astore_0
    //   6038: iload_3
    //   6039: ifne +88 -> 6127
    //   6042: aload_1
    //   6043: ldc_w 287
    //   6046: ldc 119
    //   6048: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   6051: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   6054: aload_2
    //   6055: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6058: iconst_0
    //   6059: invokeinterface 1043 3 0
    //   6064: astore 5
    //   6066: aload 13
    //   6068: astore_0
    //   6069: aload 5
    //   6071: instanceof 1045
    //   6074: ifeq +53 -> 6127
    //   6077: aload 5
    //   6079: checkcast 1045	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   6082: astore 5
    //   6084: aload 13
    //   6086: astore_0
    //   6087: aload 5
    //   6089: getfield 1049	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   6092: ifnull +35 -> 6127
    //   6095: aload 13
    //   6097: astore_0
    //   6098: aload 5
    //   6100: getfield 1049	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   6103: getfield 1053	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   6106: invokestatic 1056	com/tencent/mobileqq/mutualmark/MutualMarkUtils:b	(I)Z
    //   6109: ifeq +18 -> 6127
    //   6112: aload_1
    //   6113: invokevirtual 529	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6116: aload 13
    //   6118: invokeinterface 1000 1 0
    //   6123: invokestatic 1059	com/tencent/mobileqq/mutualmark/oldlogic/ReactivePushHelper:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    //   6126: astore_0
    //   6127: aload_0
    //   6128: astore 5
    //   6130: aload_2
    //   6131: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   6134: invokestatic 1060	com/tencent/imcore/message/MsgProxyUtils:d	(I)Z
    //   6137: ifeq +80 -> 6217
    //   6140: aload_1
    //   6141: ldc_w 287
    //   6144: ldc 119
    //   6146: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   6149: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   6152: aload_2
    //   6153: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6156: iload_3
    //   6157: invokeinterface 1043 3 0
    //   6162: astore_1
    //   6163: aload_0
    //   6164: astore 5
    //   6166: aload_1
    //   6167: ifnull +50 -> 6217
    //   6170: aload_0
    //   6171: astore 5
    //   6173: aload_1
    //   6174: instanceof 1045
    //   6177: ifeq +40 -> 6217
    //   6180: aload_1
    //   6181: checkcast 1045	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   6184: astore_1
    //   6185: aload_0
    //   6186: astore 5
    //   6188: aload_1
    //   6189: getfield 1049	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   6192: ifnull +25 -> 6217
    //   6195: aload_0
    //   6196: astore 5
    //   6198: aload_1
    //   6199: getfield 1049	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   6202: getfield 1053	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   6205: ldc_w 1061
    //   6208: if_icmpne +9 -> 6217
    //   6211: aload_1
    //   6212: invokevirtual 1062	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:getSummaryMsg	()Ljava/lang/String;
    //   6215: astore 5
    //   6217: aload 14
    //   6219: aload 5
    //   6221: aconst_null
    //   6222: iload 6
    //   6224: iload 7
    //   6226: aload 4
    //   6228: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6231: return
    //   6232: aload 5
    //   6234: ifnull +18 -> 6252
    //   6237: aload 5
    //   6239: invokeinterface 1000 1 0
    //   6244: invokevirtual 197	java/lang/String:trim	()Ljava/lang/String;
    //   6247: astore 5
    //   6249: goto +6 -> 6255
    //   6252: aconst_null
    //   6253: astore 5
    //   6255: getstatic 1065	com/tencent/mobileqq/app/AppConstants:SYSTEM_MSG_UIN	Ljava/lang/String;
    //   6258: aload_2
    //   6259: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6262: invokevirtual 1068	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6265: ifeq +30 -> 6295
    //   6268: aload 5
    //   6270: ifnull +25 -> 6295
    //   6273: aload 5
    //   6275: invokevirtual 213	java/lang/String:length	()I
    //   6278: ifle +17 -> 6295
    //   6281: aload_0
    //   6282: aload 16
    //   6284: aload 5
    //   6286: aload_2
    //   6287: invokestatic 1070	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   6290: astore 5
    //   6292: goto +3 -> 6295
    //   6295: aload 14
    //   6297: aconst_null
    //   6298: aload 5
    //   6300: iload 6
    //   6302: aload_1
    //   6303: invokevirtual 960	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   6306: checkcast 962	com/tencent/mobileqq/service/message/MessageCache
    //   6309: aload_2
    //   6310: invokevirtual 964	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6313: aload 4
    //   6315: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6318: aload_2
    //   6319: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   6322: sipush -1000
    //   6325: if_icmpne +38 -> 6363
    //   6328: aload 4
    //   6330: getfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6333: ifnull +30 -> 6363
    //   6336: aload 4
    //   6338: new 665	com/tencent/mobileqq/text/QQText
    //   6341: dup
    //   6342: aload 4
    //   6344: getfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6347: iconst_1
    //   6348: bipush 16
    //   6350: invokespecial 1073	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   6353: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6356: aload 4
    //   6358: iconst_1
    //   6359: putfield 674	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6362: return
    //   6363: aload 4
    //   6365: iconst_0
    //   6366: putfield 674	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6369: return
    //   6370: aload 14
    //   6372: aload_0
    //   6373: ldc_w 719
    //   6376: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   6379: aconst_null
    //   6380: iconst_0
    //   6381: iconst_0
    //   6382: aload 4
    //   6384: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6387: return
    //   6388: aload 14
    //   6390: ldc 119
    //   6392: aload_2
    //   6393: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   6396: iload 6
    //   6398: iload 7
    //   6400: aload 4
    //   6402: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6405: return
    //   6406: ldc_w 1075
    //   6409: iconst_3
    //   6410: anewarray 4	java/lang/Object
    //   6413: dup
    //   6414: iconst_0
    //   6415: iload_3
    //   6416: invokestatic 782	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6419: aastore
    //   6420: dup
    //   6421: iconst_1
    //   6422: iload 6
    //   6424: invokestatic 1080	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6427: aastore
    //   6428: dup
    //   6429: iconst_2
    //   6430: iload 7
    //   6432: invokestatic 1080	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6435: aastore
    //   6436: invokestatic 1085	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   6439: aload_0
    //   6440: ldc_w 1086
    //   6443: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   6446: astore_0
    //   6447: aload_2
    //   6448: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   6451: aload_1
    //   6452: invokevirtual 623	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6455: invokestatic 1091	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   6458: ifeq +22 -> 6480
    //   6461: iload_3
    //   6462: ifeq +18 -> 6480
    //   6465: aload 14
    //   6467: aload_0
    //   6468: ldc 119
    //   6470: iload 6
    //   6472: iload 7
    //   6474: aload 4
    //   6476: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6479: return
    //   6480: aload 14
    //   6482: aload_0
    //   6483: ldc 119
    //   6485: iconst_0
    //   6486: iconst_0
    //   6487: aload 4
    //   6489: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6492: return
    //   6493: aload_2
    //   6494: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   6497: sipush 1001
    //   6500: if_icmpeq +13 -> 6513
    //   6503: aload_2
    //   6504: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   6507: sipush 10002
    //   6510: if_icmpne +26 -> 6536
    //   6513: aload_2
    //   6514: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   6517: sipush -3001
    //   6520: if_icmpne +16 -> 6536
    //   6523: aload 4
    //   6525: aload_0
    //   6526: ldc_w 1092
    //   6529: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   6532: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6535: return
    //   6536: aload 14
    //   6538: aload_0
    //   6539: ldc_w 719
    //   6542: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   6545: aconst_null
    //   6546: iload 6
    //   6548: iload 7
    //   6550: aload 4
    //   6552: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6555: return
    //   6556: aload_2
    //   6557: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   6560: sipush -5016
    //   6563: if_icmpne +35 -> 6598
    //   6566: new 1094	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6569: dup
    //   6570: invokespecial 1095	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6573: astore_0
    //   6574: aload_0
    //   6575: aload_2
    //   6576: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   6579: putfield 1096	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6582: aload_0
    //   6583: invokevirtual 1097	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6586: aload 4
    //   6588: aload_0
    //   6589: invokevirtual 1100	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6592: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6595: goto +39 -> 6634
    //   6598: new 1102	com/tencent/mobileqq/data/MessageForArkApp
    //   6601: dup
    //   6602: invokespecial 1103	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6605: astore_0
    //   6606: aload_0
    //   6607: aload_2
    //   6608: getfield 641	com/tencent/imcore/message/Message:msgData	[B
    //   6611: putfield 1104	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6614: aload_0
    //   6615: invokevirtual 1105	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6618: aload 4
    //   6620: aload_0
    //   6621: invokevirtual 1106	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6624: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6627: aload_2
    //   6628: aload 4
    //   6630: aload_1
    //   6631: invokestatic 1109	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/imcore/message/Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;Lcom/tencent/common/app/AppInterface;)V
    //   6634: aload_1
    //   6635: aload_2
    //   6636: invokestatic 557	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   6639: istore 6
    //   6641: aload_1
    //   6642: aload_2
    //   6643: invokestatic 559	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   6646: istore 7
    //   6648: aload 14
    //   6650: aload 4
    //   6652: getfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6655: aconst_null
    //   6656: iload 6
    //   6658: iload 7
    //   6660: aload 4
    //   6662: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6665: return
    //   6666: aload 4
    //   6668: aload_2
    //   6669: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   6672: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6675: return
    //   6676: aload_1
    //   6677: ldc_w 287
    //   6680: ldc 119
    //   6682: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   6685: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   6688: aload_2
    //   6689: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6692: aload_2
    //   6693: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   6696: aload_2
    //   6697: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   6700: invokeinterface 297 5 0
    //   6705: astore 5
    //   6707: aload 5
    //   6709: instanceof 1111
    //   6712: ifeq +1473 -> 8185
    //   6715: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6718: ifeq +43 -> 6761
    //   6721: new 150	java/lang/StringBuilder
    //   6724: dup
    //   6725: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   6728: astore 13
    //   6730: aload 13
    //   6732: ldc_w 1113
    //   6735: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6738: pop
    //   6739: aload 13
    //   6741: aload_2
    //   6742: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   6745: invokevirtual 478	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6748: pop
    //   6749: ldc_w 447
    //   6752: iconst_2
    //   6753: aload 13
    //   6755: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6758: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6761: aload 5
    //   6763: checkcast 1111	com/tencent/mobileqq/data/MessageForShortVideo
    //   6766: astore 15
    //   6768: aload 15
    //   6770: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   6773: sipush 1005
    //   6776: if_icmpeq +64 -> 6840
    //   6779: aload_2
    //   6780: getfield 955	com/tencent/imcore/message/Message:extraflag	I
    //   6783: ldc_w 689
    //   6786: if_icmpeq +54 -> 6840
    //   6789: aload 15
    //   6791: getfield 1119	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   6794: ifne +17 -> 6811
    //   6797: aload 15
    //   6799: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   6802: sipush 1004
    //   6805: if_icmpeq +35 -> 6840
    //   6808: goto +3 -> 6811
    //   6811: aload 15
    //   6813: getfield 1119	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   6816: iconst_1
    //   6817: if_icmpne +17 -> 6834
    //   6820: aload 15
    //   6822: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   6825: sipush 1004
    //   6828: if_icmpne +6 -> 6834
    //   6831: goto +9 -> 6840
    //   6834: iconst_0
    //   6835: istore 6
    //   6837: goto +22 -> 6859
    //   6840: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6843: ifeq +13 -> 6856
    //   6846: ldc_w 447
    //   6849: iconst_2
    //   6850: ldc_w 1121
    //   6853: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6856: iconst_1
    //   6857: istore 6
    //   6859: aload_2
    //   6860: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6863: astore 5
    //   6865: aload_2
    //   6866: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   6869: aload_2
    //   6870: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   6873: invokestatic 574	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   6876: ifeq +9 -> 6885
    //   6879: aload_2
    //   6880: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   6883: astore 5
    //   6885: aload_1
    //   6886: ldc_w 678
    //   6889: ldc 119
    //   6891: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   6894: checkcast 678	com/tencent/mobileqq/transfile/api/ITransFileController
    //   6897: aload 5
    //   6899: aload_2
    //   6900: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   6903: invokeinterface 682 4 0
    //   6908: astore 5
    //   6910: iload 6
    //   6912: istore 7
    //   6914: aload 5
    //   6916: astore_1
    //   6917: aload 15
    //   6919: getfield 1124	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   6922: ifnull +201 -> 7123
    //   6925: iload 6
    //   6927: istore 7
    //   6929: aload 5
    //   6931: astore_1
    //   6932: ldc 119
    //   6934: aload 15
    //   6936: getfield 1124	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   6939: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6942: ifne +181 -> 7123
    //   6945: iload 6
    //   6947: istore 7
    //   6949: aload 5
    //   6951: astore_1
    //   6952: aload_2
    //   6953: invokevirtual 312	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   6956: ifeq +167 -> 7123
    //   6959: iload 6
    //   6961: istore 7
    //   6963: aload 5
    //   6965: astore_1
    //   6966: aload 5
    //   6968: ifnonnull +155 -> 7123
    //   6971: iload 6
    //   6973: istore 7
    //   6975: aload 5
    //   6977: astore_1
    //   6978: aload 15
    //   6980: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   6983: sipush 1003
    //   6986: if_icmpeq +137 -> 7123
    //   6989: iload 6
    //   6991: istore 7
    //   6993: aload 5
    //   6995: astore_1
    //   6996: aload 15
    //   6998: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7001: sipush 1004
    //   7004: if_icmpeq +119 -> 7123
    //   7007: iload 6
    //   7009: istore 7
    //   7011: aload 5
    //   7013: astore_1
    //   7014: aload 15
    //   7016: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7019: sipush 2003
    //   7022: if_icmpeq +101 -> 7123
    //   7025: iload 6
    //   7027: istore 7
    //   7029: aload 5
    //   7031: astore_1
    //   7032: aload 15
    //   7034: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7037: sipush 2009
    //   7040: if_icmpeq +83 -> 7123
    //   7043: iload 6
    //   7045: istore 7
    //   7047: aload 5
    //   7049: astore_1
    //   7050: aload 15
    //   7052: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7055: sipush 2002
    //   7058: if_icmpeq +65 -> 7123
    //   7061: iload 6
    //   7063: istore 7
    //   7065: aload 5
    //   7067: astore_1
    //   7068: aload 15
    //   7070: getfield 1127	com/tencent/mobileqq/data/MessageForShortVideo:isAllowAutoDown	Z
    //   7073: iconst_1
    //   7074: if_icmpne +49 -> 7123
    //   7077: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7080: ifeq +13 -> 7093
    //   7083: ldc_w 447
    //   7086: iconst_2
    //   7087: ldc_w 1129
    //   7090: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7093: iconst_1
    //   7094: istore 7
    //   7096: aload 5
    //   7098: astore_1
    //   7099: goto +24 -> 7123
    //   7102: astore 13
    //   7104: aload 5
    //   7106: astore_1
    //   7107: goto +7 -> 7114
    //   7110: astore 13
    //   7112: aconst_null
    //   7113: astore_1
    //   7114: aload 13
    //   7116: invokevirtual 463	java/lang/Exception:printStackTrace	()V
    //   7119: iload 6
    //   7121: istore 7
    //   7123: aload_2
    //   7124: invokevirtual 312	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   7127: ifeq +83 -> 7210
    //   7130: aload 15
    //   7132: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7135: sipush 1001
    //   7138: if_icmpeq +47 -> 7185
    //   7141: aload 15
    //   7143: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7146: sipush 1002
    //   7149: if_icmpeq +36 -> 7185
    //   7152: aload 15
    //   7154: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7157: sipush 998
    //   7160: if_icmpeq +25 -> 7185
    //   7163: aload 15
    //   7165: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7168: sipush 999
    //   7171: if_icmpeq +14 -> 7185
    //   7174: aload 15
    //   7176: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7179: sipush 1000
    //   7182: if_icmpne +28 -> 7210
    //   7185: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7188: ifeq +16 -> 7204
    //   7191: ldc_w 447
    //   7194: iconst_2
    //   7195: ldc_w 1131
    //   7198: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7201: goto +3 -> 7204
    //   7204: iconst_1
    //   7205: istore 6
    //   7207: goto +6 -> 7213
    //   7210: iconst_0
    //   7211: istore 6
    //   7213: aload 15
    //   7215: getfield 1119	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   7218: iconst_2
    //   7219: if_icmpne +14 -> 7233
    //   7222: aload_0
    //   7223: ldc_w 1132
    //   7226: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   7229: astore_0
    //   7230: goto +11 -> 7241
    //   7233: aload_0
    //   7234: ldc_w 1133
    //   7237: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   7240: astore_0
    //   7241: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7244: ifeq +134 -> 7378
    //   7247: new 150	java/lang/StringBuilder
    //   7250: dup
    //   7251: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   7254: astore_2
    //   7255: aload_2
    //   7256: ldc_w 1135
    //   7259: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7262: pop
    //   7263: aload_2
    //   7264: aload 15
    //   7266: getfield 1124	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   7269: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7272: pop
    //   7273: aload_2
    //   7274: ldc_w 1137
    //   7277: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7280: pop
    //   7281: aload_2
    //   7282: aload 15
    //   7284: getfield 1116	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   7287: invokevirtual 437	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7290: pop
    //   7291: ldc_w 447
    //   7294: iconst_2
    //   7295: aload_2
    //   7296: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7299: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7302: aload_1
    //   7303: ifnonnull +16 -> 7319
    //   7306: ldc_w 447
    //   7309: iconst_2
    //   7310: ldc_w 1139
    //   7313: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7316: goto +13 -> 7329
    //   7319: ldc_w 447
    //   7322: iconst_2
    //   7323: ldc_w 1141
    //   7326: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7329: new 150	java/lang/StringBuilder
    //   7332: dup
    //   7333: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   7336: astore_1
    //   7337: aload_1
    //   7338: ldc_w 1143
    //   7341: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7344: pop
    //   7345: aload_1
    //   7346: iload 7
    //   7348: invokevirtual 1146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7351: pop
    //   7352: aload_1
    //   7353: ldc_w 1148
    //   7356: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7359: pop
    //   7360: aload_1
    //   7361: iload 6
    //   7363: invokevirtual 1146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7366: pop
    //   7367: ldc_w 447
    //   7370: iconst_2
    //   7371: aload_1
    //   7372: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7375: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7378: aload 14
    //   7380: aload_0
    //   7381: aconst_null
    //   7382: iload 7
    //   7384: iload 6
    //   7386: aload 4
    //   7388: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7391: return
    //   7392: aconst_null
    //   7393: aload_2
    //   7394: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   7397: invokestatic 520	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   7400: aconst_null
    //   7401: iconst_0
    //   7402: iconst_0
    //   7403: aload 4
    //   7405: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7408: return
    //   7409: aconst_null
    //   7410: aconst_null
    //   7411: aload_2
    //   7412: getfield 515	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   7415: invokestatic 520	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   7418: iconst_0
    //   7419: iconst_0
    //   7420: aload 4
    //   7422: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7425: return
    //   7426: aload 4
    //   7428: ldc 119
    //   7430: putfield 525	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7433: return
    //   7434: aload_2
    //   7435: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7438: astore 13
    //   7440: aload_2
    //   7441: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7444: aload_2
    //   7445: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   7448: invokestatic 574	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   7451: ifeq +9 -> 7460
    //   7454: aload_2
    //   7455: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   7458: astore 13
    //   7460: aload_0
    //   7461: ldc_w 1086
    //   7464: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   7467: astore_0
    //   7468: aload_1
    //   7469: ldc_w 287
    //   7472: ldc 119
    //   7474: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   7477: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   7480: aload 13
    //   7482: aload_2
    //   7483: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   7486: aload_2
    //   7487: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   7490: invokeinterface 297 5 0
    //   7495: astore 5
    //   7497: aload 5
    //   7499: instanceof 1150
    //   7502: ifeq +152 -> 7654
    //   7505: aload 5
    //   7507: checkcast 1150	com/tencent/mobileqq/data/MessageForPtt
    //   7510: astore 15
    //   7512: aload 15
    //   7514: invokevirtual 1151	com/tencent/mobileqq/data/MessageForPtt:getSummaryMsg	()Ljava/lang/String;
    //   7517: astore 5
    //   7519: aload 5
    //   7521: astore_0
    //   7522: aload_2
    //   7523: invokevirtual 312	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   7526: ifeq +128 -> 7654
    //   7529: aload 15
    //   7531: getfield 1154	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   7534: ldc2_w 36
    //   7537: lcmp
    //   7538: ifne +15 -> 7553
    //   7541: aload 5
    //   7543: astore_0
    //   7544: iconst_1
    //   7545: istore 7
    //   7547: iconst_0
    //   7548: istore 6
    //   7550: goto +110 -> 7660
    //   7553: aload 5
    //   7555: astore_0
    //   7556: aload 15
    //   7558: getfield 1154	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   7561: lconst_0
    //   7562: lcmp
    //   7563: ifgt +91 -> 7654
    //   7566: aload_1
    //   7567: aload 13
    //   7569: aload 15
    //   7571: getfield 1157	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   7574: aload 15
    //   7576: getfield 1158	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   7579: invokestatic 1164	com/tencent/mobileqq/transfile/api/TransFileControllerBusHelper:findProcessorFileStatus	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;J)I
    //   7582: istore_3
    //   7583: iload_3
    //   7584: sipush 1005
    //   7587: if_icmpeq +27 -> 7614
    //   7590: iload_3
    //   7591: sipush 1004
    //   7594: if_icmpeq +20 -> 7614
    //   7597: iload_3
    //   7598: iconst_m1
    //   7599: if_icmpne +6 -> 7605
    //   7602: goto +12 -> 7614
    //   7605: iconst_0
    //   7606: istore 7
    //   7608: iconst_1
    //   7609: istore 6
    //   7611: goto +9 -> 7620
    //   7614: iconst_1
    //   7615: istore 7
    //   7617: iconst_0
    //   7618: istore 6
    //   7620: ldc_w 1075
    //   7623: iconst_2
    //   7624: anewarray 4	java/lang/Object
    //   7627: dup
    //   7628: iconst_0
    //   7629: aload 15
    //   7631: getfield 1154	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   7634: invokestatic 1169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7637: aastore
    //   7638: dup
    //   7639: iconst_1
    //   7640: iload_3
    //   7641: invokestatic 782	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7644: aastore
    //   7645: invokestatic 1085	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   7648: aload 5
    //   7650: astore_0
    //   7651: goto +9 -> 7660
    //   7654: iconst_0
    //   7655: istore 7
    //   7657: iconst_0
    //   7658: istore 6
    //   7660: ldc_w 1075
    //   7663: iconst_2
    //   7664: anewarray 4	java/lang/Object
    //   7667: dup
    //   7668: iconst_0
    //   7669: iload 7
    //   7671: invokestatic 1080	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7674: aastore
    //   7675: dup
    //   7676: iconst_1
    //   7677: iload 6
    //   7679: invokestatic 1080	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7682: aastore
    //   7683: invokestatic 1085	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   7686: aload 14
    //   7688: aload_0
    //   7689: aconst_null
    //   7690: iload 7
    //   7692: iload 6
    //   7694: aload 4
    //   7696: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7699: return
    //   7700: iconst_0
    //   7701: istore 9
    //   7703: aload_2
    //   7704: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7707: astore 5
    //   7709: aload_2
    //   7710: getfield 32	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7713: aload_2
    //   7714: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   7717: invokestatic 574	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   7720: ifeq +9 -> 7729
    //   7723: aload_2
    //   7724: getfield 204	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   7727: astore 5
    //   7729: aload_1
    //   7730: ldc_w 287
    //   7733: ldc 119
    //   7735: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   7738: checkcast 287	com/tencent/mobileqq/msg/api/IMessageFacade
    //   7741: aload 5
    //   7743: aload_2
    //   7744: getfield 35	com/tencent/imcore/message/Message:istroop	I
    //   7747: aload_2
    //   7748: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   7751: invokeinterface 297 5 0
    //   7756: checkcast 676	com/tencent/mobileqq/data/MessageForPic
    //   7759: astore 13
    //   7761: aload_1
    //   7762: ldc_w 678
    //   7765: ldc 119
    //   7767: invokevirtual 293	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   7770: checkcast 678	com/tencent/mobileqq/transfile/api/ITransFileController
    //   7773: aload 5
    //   7775: aload_2
    //   7776: getfield 28	com/tencent/imcore/message/Message:uniseq	J
    //   7779: invokeinterface 682 4 0
    //   7784: astore_1
    //   7785: aload_2
    //   7786: invokevirtual 312	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   7789: ifeq +44 -> 7833
    //   7792: aload 13
    //   7794: ifnull +20 -> 7814
    //   7797: aload 13
    //   7799: getfield 685	com/tencent/mobileqq/data/MessageForPic:size	J
    //   7802: lconst_0
    //   7803: lcmp
    //   7804: ifgt +10 -> 7814
    //   7807: aload_1
    //   7808: ifnonnull +66 -> 7874
    //   7811: goto +416 -> 8227
    //   7814: aload 13
    //   7816: ifnull +58 -> 7874
    //   7819: aload 13
    //   7821: getfield 688	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   7824: ldc_w 689
    //   7827: if_icmpne +47 -> 7874
    //   7830: goto +397 -> 8227
    //   7833: aload_1
    //   7834: ifnull +40 -> 7874
    //   7837: aload_1
    //   7838: instanceof 691
    //   7841: ifeq +33 -> 7874
    //   7844: aload_1
    //   7845: checkcast 691	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   7848: invokevirtual 694	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   7851: lstore 11
    //   7853: lload 11
    //   7855: l2i
    //   7856: istore_3
    //   7857: iload_3
    //   7858: sipush 1005
    //   7861: if_icmpeq +366 -> 8227
    //   7864: iload_3
    //   7865: sipush 1004
    //   7868: if_icmpne +6 -> 7874
    //   7871: goto +356 -> 8227
    //   7874: iconst_0
    //   7875: istore 6
    //   7877: iload 6
    //   7879: istore 7
    //   7881: goto +30 -> 7911
    //   7884: astore 5
    //   7886: goto +17 -> 7903
    //   7889: astore 5
    //   7891: aconst_null
    //   7892: astore_1
    //   7893: goto +10 -> 7903
    //   7896: astore 5
    //   7898: aconst_null
    //   7899: astore_1
    //   7900: aconst_null
    //   7901: astore 13
    //   7903: aload 5
    //   7905: invokevirtual 463	java/lang/Exception:printStackTrace	()V
    //   7908: iconst_0
    //   7909: istore 7
    //   7911: aload_1
    //   7912: instanceof 691
    //   7915: ifeq +116 -> 8031
    //   7918: aload_1
    //   7919: checkcast 691	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   7922: astore_1
    //   7923: iload 9
    //   7925: istore 6
    //   7927: aload_1
    //   7928: invokevirtual 694	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   7931: ldc2_w 695
    //   7934: lcmp
    //   7935: ifeq +6 -> 7941
    //   7938: iconst_1
    //   7939: istore 6
    //   7941: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7944: ifeq +84 -> 8028
    //   7947: aload_1
    //   7948: getfield 700	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   7951: ifnull +15 -> 7966
    //   7954: aload_1
    //   7955: getfield 700	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   7958: getfield 705	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   7961: lstore 11
    //   7963: goto +8 -> 7971
    //   7966: ldc2_w 36
    //   7969: lstore 11
    //   7971: new 150	java/lang/StringBuilder
    //   7974: dup
    //   7975: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   7978: astore 5
    //   7980: aload 5
    //   7982: ldc_w 707
    //   7985: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7988: pop
    //   7989: aload 5
    //   7991: lload 11
    //   7993: invokevirtual 478	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7996: pop
    //   7997: aload 5
    //   7999: ldc_w 709
    //   8002: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8005: pop
    //   8006: aload 5
    //   8008: aload_1
    //   8009: invokevirtual 712	com/tencent/mobileqq/transfile/BaseTransProcessor:getKey	()Ljava/lang/String;
    //   8012: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8015: pop
    //   8016: ldc_w 714
    //   8019: iconst_2
    //   8020: aload 5
    //   8022: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8025: invokestatic 716	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8028: goto +59 -> 8087
    //   8031: aload_1
    //   8032: ifnull +52 -> 8084
    //   8035: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8038: ifeq +40 -> 8078
    //   8041: new 150	java/lang/StringBuilder
    //   8044: dup
    //   8045: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   8048: astore 5
    //   8050: aload 5
    //   8052: ldc_w 718
    //   8055: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8058: pop
    //   8059: aload 5
    //   8061: aload_1
    //   8062: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8065: pop
    //   8066: ldc_w 714
    //   8069: iconst_2
    //   8070: aload 5
    //   8072: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8075: invokestatic 716	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8078: iconst_1
    //   8079: istore 6
    //   8081: goto +6 -> 8087
    //   8084: iconst_0
    //   8085: istore 6
    //   8087: aload_0
    //   8088: ldc_w 719
    //   8091: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   8094: astore_1
    //   8095: aload_2
    //   8096: invokestatic 722	com/tencent/mobileqq/app/HotChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   8099: ifne +21 -> 8120
    //   8102: ldc_w 724
    //   8105: invokestatic 539	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   8108: checkcast 724	com/tencent/mobileqq/pic/api/IPicFlash
    //   8111: aload_2
    //   8112: invokeinterface 727 2 0
    //   8117: ifeq +11 -> 8128
    //   8120: aload_0
    //   8121: ldc_w 728
    //   8124: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   8127: astore_1
    //   8128: aload_2
    //   8129: getfield 175	com/tencent/imcore/message/Message:msgtype	I
    //   8132: sipush -5015
    //   8135: if_icmpne +11 -> 8146
    //   8138: aload_0
    //   8139: ldc_w 1170
    //   8142: invokevirtual 185	android/content/Context:getString	(I)Ljava/lang/String;
    //   8145: astore_1
    //   8146: ldc_w 1172
    //   8149: invokestatic 539	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   8152: checkcast 1172	com/tencent/mobileqq/pic/api/IPicHelper
    //   8155: aload 13
    //   8157: invokeinterface 1176 2 0
    //   8162: astore_0
    //   8163: aload_0
    //   8164: ifnull +8 -> 8172
    //   8167: aload_0
    //   8168: astore_1
    //   8169: goto +3 -> 8172
    //   8172: aload 14
    //   8174: aload_1
    //   8175: aconst_null
    //   8176: iload 7
    //   8178: iload 6
    //   8180: aload 4
    //   8182: invokestatic 551	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   8185: return
    //   8186: iconst_1
    //   8187: istore 6
    //   8189: goto -6468 -> 1721
    //   8192: iconst_0
    //   8193: istore 6
    //   8195: goto -6417 -> 1778
    //   8198: ldc2_w 36
    //   8201: lstore 11
    //   8203: goto -6400 -> 1803
    //   8206: goto -6295 -> 1911
    //   8209: iconst_1
    //   8210: istore 6
    //   8212: goto -6301 -> 1911
    //   8215: iconst_0
    //   8216: istore 6
    //   8218: goto -6307 -> 1911
    //   8221: iconst_1
    //   8222: istore 7
    //   8224: goto -3550 -> 4674
    //   8227: iconst_1
    //   8228: istore 6
    //   8230: goto -353 -> 7877
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8233	0	paramContext	Context
    //   0	8233	1	paramAppInterface	AppInterface
    //   0	8233	2	paramMessage	Message
    //   0	8233	3	paramInt	int
    //   0	8233	4	paramMsgSummary	MsgSummary
    //   0	8233	5	paramString	String
    //   0	8233	6	paramBoolean1	boolean
    //   0	8233	7	paramBoolean2	boolean
    //   122	5422	8	i	int
    //   1029	6895	9	bool1	boolean
    //   1039	970	10	bool2	boolean
    //   1695	6507	11	l	long
    //   49	6705	13	localObject1	Object
    //   7102	1	13	localException1	Exception
    //   7110	5	13	localException2	Exception
    //   7438	718	13	localObject2	Object
    //   18	8155	14	str	String
    //   1579	6051	15	localObject3	Object
    //   4715	1568	16	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   1094	1170	1224	java/lang/Exception
    //   1173	1209	1224	java/lang/Exception
    //   1212	1219	1224	java/lang/Exception
    //   1272	1303	1380	java/lang/Exception
    //   1303	1324	1380	java/lang/Exception
    //   1324	1331	1380	java/lang/Exception
    //   1336	1344	1380	java/lang/Exception
    //   1352	1360	1380	java/lang/Exception
    //   1360	1377	1380	java/lang/Exception
    //   1630	1647	1728	java/lang/Exception
    //   1660	1671	1728	java/lang/Exception
    //   1679	1697	1728	java/lang/Exception
    //   1586	1630	1732	java/lang/Exception
    //   1541	1547	1736	java/lang/Exception
    //   1547	1567	1736	java/lang/Exception
    //   1567	1586	1736	java/lang/Exception
    //   1740	1744	1966	java/lang/Exception
    //   1747	1772	1966	java/lang/Exception
    //   1778	1800	1966	java/lang/Exception
    //   1803	1860	1966	java/lang/Exception
    //   1868	1908	1966	java/lang/Exception
    //   1911	1926	1966	java/lang/Exception
    //   1926	1944	1966	java/lang/Exception
    //   1944	1952	1966	java/lang/Exception
    //   1952	1965	1966	java/lang/Exception
    //   1242	1272	1970	java/lang/Exception
    //   1400	1405	1970	java/lang/Exception
    //   1409	1440	1970	java/lang/Exception
    //   1440	1461	1970	java/lang/Exception
    //   1461	1468	1970	java/lang/Exception
    //   1473	1481	1970	java/lang/Exception
    //   1489	1497	1970	java/lang/Exception
    //   1497	1532	1970	java/lang/Exception
    //   1041	1050	1980	java/lang/Exception
    //   1050	1081	1980	java/lang/Exception
    //   4541	4547	4680	java/lang/Exception
    //   4547	4567	4680	java/lang/Exception
    //   4567	4613	4680	java/lang/Exception
    //   4616	4624	4680	java/lang/Exception
    //   4633	4662	4680	java/lang/Exception
    //   6917	6925	7102	java/lang/Exception
    //   6932	6945	7102	java/lang/Exception
    //   6952	6959	7102	java/lang/Exception
    //   6978	6989	7102	java/lang/Exception
    //   6996	7007	7102	java/lang/Exception
    //   7014	7025	7102	java/lang/Exception
    //   7032	7043	7102	java/lang/Exception
    //   7050	7061	7102	java/lang/Exception
    //   7068	7093	7102	java/lang/Exception
    //   6859	6865	7110	java/lang/Exception
    //   6865	6885	7110	java/lang/Exception
    //   6885	6910	7110	java/lang/Exception
    //   7785	7792	7884	java/lang/Exception
    //   7797	7807	7884	java/lang/Exception
    //   7819	7830	7884	java/lang/Exception
    //   7837	7853	7884	java/lang/Exception
    //   7761	7785	7889	java/lang/Exception
    //   7703	7709	7896	java/lang/Exception
    //   7709	7729	7896	java/lang/Exception
    //   7729	7761	7896	java/lang/Exception
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
  
  private static void a(Message paramMessage, MsgSummary paramMsgSummary, AppInterface paramAppInterface)
  {
    if ((paramMessage.istroop == 10007) && (paramMessage.msgtype == -5008))
    {
      paramMessage = new StringBuilder();
      paramMessage.append(paramMsgSummary.strContent);
      paramMessage.append(paramAppInterface.getApp().getString(2131692791));
      paramMsgSummary.strContent = paramMessage.toString();
    }
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
  
  public static boolean a(Context paramContext, AppInterface paramAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().b().iterator();
    while (localIterator.hasNext()) {
      if (((ExtractMessageSummaryCallback)localIterator.next()).a(paramContext, paramAppInterface, paramMessage, paramInt, paramMsgSummary, paramString, paramBoolean1, paramBoolean2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    Message localMessage = paramMessage;
    if (UinTypeUtil.a(paramMessage.frienduin, paramMessage.istroop))
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
          if ((paramAppInterface != null) && ((paramAppInterface.b == 1) || (paramAppInterface.b == 0))) {
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
    return ((MessageCache)paramAppInterface.getMsgCache()).b(localMessage);
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
  
  private static boolean b(AppInterface paramAppInterface, Message paramMessage)
  {
    boolean bool2 = false;
    if (paramMessage == null) {
      return false;
    }
    Message localMessage = paramMessage;
    int i;
    if (UinTypeUtil.a(paramMessage.frienduin, paramMessage.istroop))
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
          if ((paramAppInterface != null) && (paramAppInterface.b == 3)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MsgUtils
 * JD-Core Version:    0.7.0.1
 */