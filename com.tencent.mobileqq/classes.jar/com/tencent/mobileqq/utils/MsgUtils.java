package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.core.ExtractMessageSummaryCallback;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
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
import com.tencent.mobileqq.util.MessageRecordUtil;
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
  private static float jdField_a_of_type_Float = 0.0F;
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long = 0L;
  private static float jdField_b_of_type_Float = 0.0F;
  private static long jdField_b_of_type_Long = 0L;
  private static float c = 0.0F;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    int i;
    if (paramMessage == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.getFileManagerRSCenter().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop, -1L);
      i = j;
    } while (j != -1);
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
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.getApp().getString(2131690176);
    }
    return paramQQAppInterface.getApp().getString(2131690178) + paramContext.messagetail + paramQQAppInterface.getApp().getString(2131690179);
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, Message paramMessage)
  {
    String str1;
    if (SystemMsg.isSystemMessage(paramMessage.msgtype))
    {
      str1 = null;
      switch (paramMessage.msgtype)
      {
      default: 
        paramContext = str1;
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
              paramQQAppInterface = ContactUtils.c(paramQQAppInterface, paramMessage.senderuin, true);
              if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramMessage.senderuin))) {
                break label274;
              }
              paramString = new StringBuilder();
              paramString.append(paramQQAppInterface).append(paramContext);
              str1 = paramString.toString();
            }
          }
        }
        break;
      }
    }
    label274:
    label439:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return str1;
                  paramContext = paramContext.getString(2131689590);
                  break;
                  paramContext = paramContext.getString(2131689499);
                  break;
                  paramContext = paramContext.getString(2131689498);
                  break;
                  paramContext = paramContext.getString(2131718512);
                  break;
                  paramContext = paramContext.getString(2131689627);
                  break;
                  return paramMessage.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessage.msgtype));
                if ((paramMessage.msgtype != -1020) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != -1023) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46)) {
                  break label439;
                }
                paramContext = TroopSystemMsgUtil.b(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = ContactUtils.c(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return TroopSystemMsgUtil.a(paramString, paramContext, paramQQAppInterface);
      if (paramMessage.msgtype == -1021) {
        break label462;
      }
      str1 = paramString;
    } while (paramMessage.msgtype != -1022);
    label462:
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
          paramQQAppInterface = ContactUtils.c(paramQQAppInterface, paramMessage, true);
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
  
  public static String a(Context paramContext, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramString;
      localObject = Pattern.compile("(|(\\d{2}):)(\\d{2}):(\\d{2})$").matcher(paramString);
    } while ((!((Matcher)localObject).find()) || (((Matcher)localObject).groupCount() < 4));
    String str1 = ((Matcher)localObject).group(0);
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
    Object localObject = new StringBuffer();
    if (i > 0) {
      ((StringBuffer)localObject).append(i).append(paramContext.getString(2131693277));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131694225));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131718937));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
  @Nullable
  private static String a(QQAppInterface paramQQAppInterface, Message paramMessage, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    String str = paramString;
    if (AnonymousChatHelper.a(paramMessage)) {
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (paramString.equals(ContactUtils.a(paramQQAppInterface, paramMessage.frienduin, true))) {}
      }
      else
      {
        paramQQAppInterface = paramQQAppInterface.getMessageFacade().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if ((paramQQAppInterface instanceof ChatMessage)) {
          ((ChatMessage)paramQQAppInterface).parse();
        }
        if (paramQQAppInterface != null) {
          paramString = AnonymousChatHelper.a(paramQQAppInterface).b;
        }
        str = paramString;
        if (!TextUtils.isEmpty(paramString)) {}
      }
    }
    for (paramQQAppInterface = AnonymousChatHelper.a(paramMessage).b;; paramQQAppInterface = str)
    {
      paramString = paramQQAppInterface;
      if (!paramBoolean) {
        if (!paramMessage.isSendFromLocal())
        {
          paramString = paramQQAppInterface;
          if (paramMessage.selfuin != null)
          {
            paramString = paramQQAppInterface;
            if (!paramMessage.selfuin.equals(paramMessage.senderuin)) {}
          }
        }
        else
        {
          paramString = null;
        }
      }
      if (MsgProxyUtils.f(paramMessage.msgtype)) {}
      for (paramQQAppInterface = localObject;; paramQQAppInterface = paramString)
      {
        paramMessage = TroopBusinessUtil.a(paramMessage);
        if (paramMessage != null) {
          paramQQAppInterface = paramMessage.c;
        }
        return b(paramQQAppInterface);
      }
    }
  }
  
  /* Error */
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_1
    //   4: ifnonnull +8 -> 12
    //   7: ldc 131
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: iconst_2
    //   13: istore 6
    //   15: iload 5
    //   17: iconst_1
    //   18: if_icmpeq +11 -> 29
    //   21: iload 5
    //   23: sipush 5000
    //   26: if_icmpne +6 -> 32
    //   29: iconst_1
    //   30: istore 6
    //   32: aload_1
    //   33: arraylength
    //   34: iconst_1
    //   35: if_icmple +352 -> 387
    //   38: aload_1
    //   39: iconst_1
    //   40: aaload
    //   41: invokestatic 270	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   44: istore 7
    //   46: iload 7
    //   48: tableswitch	default:+20 -> 68, 13:+148->196
    //   69: invokevirtual 348	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   72: ldc_w 349
    //   75: invokevirtual 352	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   78: astore_3
    //   79: iload 5
    //   81: iconst_1
    //   82: if_icmpeq +11 -> 93
    //   85: iload 5
    //   87: sipush 5000
    //   90: if_icmpne +14 -> 104
    //   93: aload_2
    //   94: invokevirtual 348	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   97: ldc_w 353
    //   100: invokevirtual 352	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   103: astore_3
    //   104: aload_1
    //   105: arraylength
    //   106: iconst_5
    //   107: if_icmple +302 -> 409
    //   110: aload_1
    //   111: iconst_4
    //   112: aaload
    //   113: invokestatic 270	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   116: istore 5
    //   118: aload_1
    //   119: iconst_5
    //   120: aaload
    //   121: invokestatic 270	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: istore 6
    //   126: aload_3
    //   127: astore_1
    //   128: iload 5
    //   130: iconst_2
    //   131: if_icmpne -121 -> 10
    //   134: iload 6
    //   136: iconst_4
    //   137: if_icmpne +216 -> 353
    //   140: aload_0
    //   141: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   144: ldc_w 354
    //   147: invokevirtual 171	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   150: astore_1
    //   151: new 173	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 356
    //   161: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_1
    //   172: aload_3
    //   173: aload_0
    //   174: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   177: ldc_w 353
    //   180: invokevirtual 171	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   183: aload_1
    //   184: invokevirtual 287	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   187: areturn
    //   188: astore 9
    //   190: iconst_0
    //   191: istore 7
    //   193: goto -147 -> 46
    //   196: aload 4
    //   198: ifnull +113 -> 311
    //   201: aload_0
    //   202: aload 4
    //   204: aload_3
    //   205: iload 6
    //   207: iconst_0
    //   208: invokestatic 359	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   211: astore 4
    //   213: aload_2
    //   214: invokevirtual 348	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   217: ldc_w 349
    //   220: invokevirtual 352	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   223: astore_3
    //   224: iload 5
    //   226: iconst_1
    //   227: if_icmpeq +11 -> 238
    //   230: iload 5
    //   232: sipush 5000
    //   235: if_icmpne +14 -> 249
    //   238: aload_2
    //   239: invokevirtual 348	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   242: ldc_w 353
    //   245: invokevirtual 352	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   248: astore_3
    //   249: aload 4
    //   251: invokevirtual 217	java/lang/String:length	()I
    //   254: bipush 11
    //   256: if_icmple +163 -> 419
    //   259: aload 4
    //   261: iconst_0
    //   262: bipush 10
    //   264: invokevirtual 363	java/lang/String:substring	(II)Ljava/lang/String;
    //   267: astore_2
    //   268: new 173	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   275: aload_2
    //   276: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 365
    //   282: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore_2
    //   289: new 173	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   296: aload_2
    //   297: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_3
    //   301: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore_3
    //   308: goto -204 -> 104
    //   311: iload 5
    //   313: iconst_1
    //   314: if_icmpeq +11 -> 325
    //   317: iload 5
    //   319: sipush 5000
    //   322: if_icmpne +17 -> 339
    //   325: aload_2
    //   326: invokevirtual 348	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   329: ldc_w 366
    //   332: invokevirtual 352	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   335: astore_3
    //   336: goto -232 -> 104
    //   339: aload_2
    //   340: invokevirtual 348	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   343: ldc_w 367
    //   346: invokevirtual 352	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   349: astore_3
    //   350: goto -246 -> 104
    //   353: iload 6
    //   355: iconst_5
    //   356: if_icmpne +17 -> 373
    //   359: aload_0
    //   360: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   363: ldc_w 368
    //   366: invokevirtual 171	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   369: astore_1
    //   370: goto -219 -> 151
    //   373: aload_0
    //   374: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   377: ldc_w 366
    //   380: invokevirtual 171	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   383: astore_1
    //   384: goto -233 -> 151
    //   387: ldc 131
    //   389: areturn
    //   390: astore_1
    //   391: iconst_0
    //   392: istore 5
    //   394: iload 8
    //   396: istore 6
    //   398: goto -272 -> 126
    //   401: astore_1
    //   402: iload 8
    //   404: istore 6
    //   406: goto -280 -> 126
    //   409: iconst_0
    //   410: istore 5
    //   412: iload 8
    //   414: istore 6
    //   416: goto -290 -> 126
    //   419: aload 4
    //   421: astore_2
    //   422: goto -133 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	paramQQAppInterface	QQAppInterface
    //   0	425	1	paramArrayOfString	String[]
    //   0	425	2	paramContext	Context
    //   0	425	3	paramString1	String
    //   0	425	4	paramString2	String
    //   0	425	5	paramInt	int
    //   13	402	6	i	int
    //   44	148	7	j	int
    //   1	412	8	k	int
    //   188	1	9	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   38	46	188	java/lang/NumberFormatException
    //   110	118	390	java/lang/Exception
    //   118	126	401	java/lang/Exception
  }
  
  public static String a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {}
    do
    {
      return null;
      if (paramMessageForPic.picExtraData != null)
      {
        String str = paramMessageForPic.picExtraData.textSummary;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("msgSummary", 2, "textSummary: " + MessageRecordUtil.a(str));
          }
          return str;
        }
      }
      if ((paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isHotPics()) || (paramMessageForPic.picExtraData.isCustomFace()) || (paramMessageForPic.picExtraData.isRelatedEmo()) || (ZhituManager.b(paramMessageForPic)) || (DoutuManager.b(paramMessageForPic)) || (StickerRecManager.a(paramMessageForPic)))) {
        return BaseApplicationImpl.getApplication().getString(2131691358);
      }
    } while (!paramMessageForPic.checkGif());
    return BaseApplicationImpl.getApplication().getString(2131691358);
  }
  
  public static String a(String paramString)
  {
    String str = HardCodeUtil.a(2131706988);
    StringBuilder localStringBuilder = new StringBuilder(40);
    if (paramString != null) {
      localStringBuilder.append(paramString + ": ");
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, float paramFloat)
  {
    Object localObject3 = paramString;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label20;
      }
      localObject3 = paramString;
    }
    label20:
    float f1;
    for (;;)
    {
      return localObject3;
      long l1 = 0L;
      if (QLog.isDevelopLevel()) {
        l1 = SystemClock.elapsedRealtime();
      }
      if (jdField_a_of_type_Int == 0) {}
      label803:
      try
      {
        localObject1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
        localObject3 = HardCodeUtil.a(2131706997);
        TextPaint localTextPaint = new TextPaint();
        localTextPaint.setTextSize(((DisplayMetrics)localObject1).density * 14.0F);
        f1 = Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
        float f2 = ((DisplayMetrics)localObject1).density;
        f1 -= f2 * 72.0F;
        if (f1 <= 0.0F)
        {
          localObject3 = paramString;
          return paramString;
        }
        c = 0.7F * f1;
        jdField_a_of_type_Float = localTextPaint.measureText((String)localObject3);
        jdField_b_of_type_Float = localTextPaint.measureText("AaJjIiMm") / "AaJjIiMm".length();
        if (jdField_a_of_type_Float > 1.0F) {
          jdField_a_of_type_Int = (int)(f1 * 0.8F / jdField_a_of_type_Float);
        }
        if (jdField_b_of_type_Float > 1.0F) {
          jdField_a_of_type_Int = Math.min(jdField_a_of_type_Int, (int)(c / jdField_b_of_type_Float));
        }
        if (jdField_a_of_type_Int <= 0) {
          jdField_a_of_type_Int = 14;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          localException.printStackTrace();
          jdField_a_of_type_Int = 14;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder(120);
            localStringBuilder.append("trimName").append(", sMaxWidth = ").append(c).append(", sMinLen = ").append(jdField_a_of_type_Int).append(", sZhW = ").append(jdField_a_of_type_Float).append(", sEnW = ").append(jdField_b_of_type_Float);
            QLog.i("Q.recent", 2, localStringBuilder.toString());
          }
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          localError.printStackTrace();
          jdField_a_of_type_Int = 14;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder(120);
            ((StringBuilder)localObject2).append("trimName").append(", sMaxWidth = ").append(c).append(", sMinLen = ").append(jdField_a_of_type_Int).append(", sZhW = ").append(jdField_a_of_type_Float).append(", sEnW = ").append(jdField_b_of_type_Float);
            QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label803;
        }
        localObject2 = new StringBuilder(120);
        ((StringBuilder)localObject2).append("trimName").append(", sMaxWidth = ").append(c).append(", sMinLen = ").append(jdField_a_of_type_Int).append(", sZhW = ").append(jdField_a_of_type_Float).append(", sEnW = ").append(jdField_b_of_type_Float);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
      }
    }
    int k = paramString.length();
    localObject1 = paramString;
    if (k >= jdField_a_of_type_Int)
    {
      localObject1 = paramString;
      if (jdField_b_of_type_Float >= 1.0F)
      {
        if (jdField_a_of_type_Float >= 1.0F) {
          break label805;
        }
        localObject1 = paramString;
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      long l2 = jdField_a_of_type_Long;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime() - l1 + l2;
      jdField_b_of_type_Long += 1L;
      localObject3 = localObject1;
      if (jdField_b_of_type_Long % 10L != 1L) {
        break;
      }
      QLog.i("Q.recent", 4, "trimName, cost = " + jdField_a_of_type_Long / jdField_b_of_type_Long);
      return localObject1;
      StringBuilder localStringBuilder;
      label805:
      f1 = 0.0F;
      int i = 0;
      int j = 0;
      if (i < k)
      {
        int m = paramString.charAt(i);
        if ((m >= 32) && (m <= 126)) {}
        for (f1 += jdField_b_of_type_Float;; f1 += jdField_a_of_type_Float)
        {
          if (c * paramFloat - f1 <= 1.0F) {
            break label884;
          }
          j += 1;
          i += 1;
          break;
        }
      }
      label884:
      Object localObject2 = paramString;
      if (j < k)
      {
        localObject2 = paramString;
        if (j > 0) {
          localObject2 = paramString.substring(0, j - 1) + "...";
        }
      }
    }
  }
  
  public static String a(String[] paramArrayOfString, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    Object localObject;
    if (paramArrayOfString == null)
    {
      localObject = "";
      label11:
      return localObject;
    }
    if (paramArrayOfString.length > 1) {
      for (;;)
      {
        int j;
        try
        {
          i = Integer.parseInt(paramArrayOfString[1]);
          j = k;
          if (paramArrayOfString.length > 3)
          {
            if ("1".equals(paramArrayOfString[3])) {
              j = k;
            }
          }
          else {
            switch (i)
            {
            default: 
              if (j == 0) {
                break label913;
              }
              paramContext = paramContext.getResources().getString(2131695928);
              localObject = paramContext;
              if (TextUtils.isEmpty(paramArrayOfString[0])) {
                break label11;
              }
              return paramContext + " " + paramArrayOfString[0];
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int i = 0;
          continue;
          j = 0;
          continue;
          if (paramArrayOfString[0] == null) {
            break label930;
          }
        }
        if (paramContext.getString(2131720512).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131695945);
          }
          return paramContext.getResources().getString(2131695368);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695928) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131695354) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131720516).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131695941);
            }
            return paramContext.getResources().getString(2131695940);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695363);
          }
          return paramContext.getResources().getString(2131695362);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695928) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131695354) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695941);
          }
          return paramContext.getResources().getString(2131695940);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131695363);
        }
        return paramContext.getResources().getString(2131695362);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695941);
          }
          return paramContext.getResources().getString(2131695940);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131695363);
        }
        return paramContext.getResources().getString(2131695362);
        if (j != 0) {
          return paramContext.getResources().getString(2131695942);
        }
        return paramContext.getResources().getString(2131695364);
        if (j != 0) {
          return paramContext.getResources().getString(2131695928);
        }
        return paramContext.getResources().getString(2131695354);
        if (j != 0) {
          return paramContext.getResources().getString(2131695929);
        }
        return paramContext.getResources().getString(2131695356);
        if (j != 0) {
          return paramContext.getResources().getString(2131695944);
        }
        return paramContext.getResources().getString(2131695367);
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131720512).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131695945);
          }
          return paramContext.getResources().getString(2131695368);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695928) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131695354) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        return paramContext.getResources().getString(2131695354) + " " + paramArrayOfString[0];
        label913:
        paramContext = paramContext.getResources().getString(2131695354);
      }
    }
    return "";
    label930:
    return "";
  }
  
  public static void a(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, IMCoreMessageStub paramIMCoreMessageStub, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    paramIMCoreMessageStub = (Message)paramIMCoreMessageStub;
    a(paramIMCoreMessageStub, localQQAppInterface, paramInt);
    if (paramIMCoreMessageStub != null) {}
    for (paramBaseQQAppInterface = paramIMCoreMessageStub.nickName;; paramBaseQQAppInterface = null)
    {
      a(paramContext, localQQAppInterface, paramIMCoreMessageStub, paramInt, paramMsgSummary, paramBaseQQAppInterface, paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  /* Error */
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: aload_2
    //   7: aload 5
    //   9: iload 6
    //   11: invokestatic 564	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;Ljava/lang/String;Z)Ljava/lang/String;
    //   14: astore 5
    //   16: aload 5
    //   18: astore 19
    //   20: aload_2
    //   21: getfield 568	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   24: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifne +39 -> 66
    //   30: aload 5
    //   32: astore 19
    //   34: aload 5
    //   36: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +27 -> 66
    //   42: new 173	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   49: aload_2
    //   50: getfield 568	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   53: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: aload 5
    //   58: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 19
    //   66: aload_0
    //   67: aload_1
    //   68: aload_2
    //   69: iload_3
    //   70: aload 4
    //   72: aload 19
    //   74: iload 6
    //   76: iload 7
    //   78: invokestatic 574	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;ILcom/tencent/mobileqq/activity/recent/MsgSummary;Ljava/lang/String;ZZ)Z
    //   81: ifne -77 -> 4
    //   84: aload_2
    //   85: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   88: sipush -2034
    //   91: if_icmpne +16 -> 107
    //   94: aload 4
    //   96: aload_2
    //   97: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   100: invokestatic 582	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   103: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   106: return
    //   107: aload_2
    //   108: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   111: sipush -2011
    //   114: if_icmpne +157 -> 271
    //   117: iconst_0
    //   118: istore_3
    //   119: iconst_0
    //   120: istore 8
    //   122: aload_2
    //   123: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   126: sipush -2011
    //   129: if_icmpne +29 -> 158
    //   132: aload_2
    //   133: getfield 590	com/tencent/imcore/message/Message:extInt	I
    //   136: bipush 61
    //   138: if_icmpne +20 -> 158
    //   141: aload_2
    //   142: aload_1
    //   143: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   146: invokevirtual 591	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   149: ldc_w 592
    //   152: invokevirtual 352	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   155: putfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   158: aload_2
    //   159: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   162: iconst_1
    //   163: if_icmpne +73 -> 236
    //   166: aload_1
    //   167: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   170: aload_2
    //   171: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   174: aload_2
    //   175: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   178: aload_2
    //   179: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   182: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   185: astore_0
    //   186: iload 8
    //   188: istore_3
    //   189: aload_0
    //   190: invokestatic 595	com/tencent/mobileqq/nearby/NearbyFlowerUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   193: ifeq +21 -> 214
    //   196: aconst_null
    //   197: aconst_null
    //   198: aload_0
    //   199: checkcast 597	com/tencent/mobileqq/data/MessageForStructing
    //   202: invokestatic 600	com/tencent/mobileqq/nearby/NearbyFlowerUtil:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   205: iconst_0
    //   206: iconst_0
    //   207: aload 4
    //   209: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   212: iconst_1
    //   213: istore_3
    //   214: aload_0
    //   215: invokestatic 606	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   218: ifeq +18 -> 236
    //   221: iconst_1
    //   222: istore_3
    //   223: aconst_null
    //   224: aconst_null
    //   225: aload_2
    //   226: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   229: iconst_0
    //   230: iconst_0
    //   231: aload 4
    //   233: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   236: iload_3
    //   237: ifne -233 -> 4
    //   240: aload_1
    //   241: aload_2
    //   242: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   245: istore 6
    //   247: aload_1
    //   248: aload_2
    //   249: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   252: istore 7
    //   254: aload 19
    //   256: aconst_null
    //   257: aload_2
    //   258: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   261: iload 6
    //   263: iload 7
    //   265: aload 4
    //   267: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   270: return
    //   271: aload_2
    //   272: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   275: sipush -2000
    //   278: if_icmpeq +13 -> 291
    //   281: aload_2
    //   282: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   285: sipush -5015
    //   288: if_icmpne +454 -> 742
    //   291: aconst_null
    //   292: astore 18
    //   294: aconst_null
    //   295: astore 5
    //   297: aload_2
    //   298: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   301: astore 17
    //   303: aload_2
    //   304: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   307: aload_2
    //   308: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   311: invokestatic 616	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   314: ifeq +7620 -> 7934
    //   317: aload_2
    //   318: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   321: astore 17
    //   323: aload_1
    //   324: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   327: aload 17
    //   329: aload_2
    //   330: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   333: aload_2
    //   334: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   337: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   340: checkcast 371	com/tencent/mobileqq/data/MessageForPic
    //   343: astore 16
    //   345: aload 18
    //   347: astore 5
    //   349: aload_1
    //   350: ldc_w 618
    //   353: invokevirtual 622	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   356: checkcast 618	com/tencent/mobileqq/transfile/api/ITransFileController
    //   359: aload 17
    //   361: aload_2
    //   362: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   365: invokeinterface 626 4 0
    //   370: astore_1
    //   371: aload_1
    //   372: astore 5
    //   374: aload_2
    //   375: invokevirtual 320	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   378: ifeq +231 -> 609
    //   381: aload 16
    //   383: ifnull +201 -> 584
    //   386: aload_1
    //   387: astore 5
    //   389: aload 16
    //   391: getfield 629	com/tencent/mobileqq/data/MessageForPic:size	J
    //   394: lstore 14
    //   396: lload 14
    //   398: lconst_0
    //   399: lcmp
    //   400: ifgt +184 -> 584
    //   403: aload_1
    //   404: ifnonnull +7524 -> 7928
    //   407: iconst_1
    //   408: istore 6
    //   410: aload 16
    //   412: astore 5
    //   414: iload 6
    //   416: istore 7
    //   418: aload_1
    //   419: astore 16
    //   421: aload 16
    //   423: instanceof 631
    //   426: ifeq +263 -> 689
    //   429: aload 16
    //   431: checkcast 631	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 634	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   439: ldc2_w 635
    //   442: lcmp
    //   443: ifeq +7479 -> 7922
    //   446: iconst_1
    //   447: istore 6
    //   449: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq +60 -> 512
    //   455: aload_1
    //   456: getfield 640	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   459: ifnull +222 -> 681
    //   462: aload_1
    //   463: getfield 640	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   466: getfield 645	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   469: lstore 14
    //   471: ldc_w 647
    //   474: iconst_2
    //   475: new 173	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 649
    //   485: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: lload 14
    //   490: invokevirtual 521	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   493: ldc_w 651
    //   496: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_1
    //   500: invokevirtual 654	com/tencent/mobileqq/transfile/BaseTransProcessor:getKey	()Ljava/lang/String;
    //   503: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload_0
    //   513: ldc_w 655
    //   516: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   519: astore_1
    //   520: aload_2
    //   521: invokestatic 658	com/tencent/mobileqq/app/HotChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   524: ifne +10 -> 534
    //   527: aload_2
    //   528: invokestatic 661	com/tencent/mobileqq/app/FlashPicHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   531: ifeq +11 -> 542
    //   534: aload_0
    //   535: ldc_w 662
    //   538: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   541: astore_1
    //   542: aload_2
    //   543: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   546: sipush -5015
    //   549: if_icmpne +11 -> 560
    //   552: aload_0
    //   553: ldc_w 663
    //   556: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   559: astore_1
    //   560: aload 5
    //   562: invokestatic 665	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/data/MessageForPic;)Ljava/lang/String;
    //   565: astore_0
    //   566: aload_0
    //   567: ifnull +7344 -> 7911
    //   570: aload 19
    //   572: aload_0
    //   573: aconst_null
    //   574: iload 7
    //   576: iload 6
    //   578: aload 4
    //   580: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   583: return
    //   584: aload 16
    //   586: ifnull +7342 -> 7928
    //   589: aload_1
    //   590: astore 5
    //   592: aload 16
    //   594: getfield 668	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   597: ldc_w 669
    //   600: if_icmpne +7337 -> 7937
    //   603: iconst_1
    //   604: istore 6
    //   606: goto -196 -> 410
    //   609: aload_1
    //   610: ifnull +7318 -> 7928
    //   613: aload_1
    //   614: astore 5
    //   616: aload_1
    //   617: instanceof 631
    //   620: ifeq +7308 -> 7928
    //   623: aload_1
    //   624: astore 5
    //   626: aload_1
    //   627: checkcast 631	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   630: invokevirtual 634	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   633: lstore 14
    //   635: lload 14
    //   637: l2i
    //   638: istore_3
    //   639: iload_3
    //   640: sipush 1005
    //   643: if_icmpeq +10 -> 653
    //   646: iload_3
    //   647: sipush 1004
    //   650: if_icmpne +7278 -> 7928
    //   653: iconst_1
    //   654: istore 6
    //   656: goto -246 -> 410
    //   659: astore 16
    //   661: aconst_null
    //   662: astore_1
    //   663: aload 16
    //   665: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   668: iconst_0
    //   669: istore 7
    //   671: aload 5
    //   673: astore 16
    //   675: aload_1
    //   676: astore 5
    //   678: goto -257 -> 421
    //   681: ldc2_w 48
    //   684: lstore 14
    //   686: goto -215 -> 471
    //   689: aload 16
    //   691: ifnull +7225 -> 7916
    //   694: iconst_1
    //   695: istore 10
    //   697: iload 10
    //   699: istore 6
    //   701: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   704: ifeq -192 -> 512
    //   707: ldc_w 647
    //   710: iconst_2
    //   711: new 173	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 671
    //   721: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 16
    //   726: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   735: iload 10
    //   737: istore 6
    //   739: goto -227 -> 512
    //   742: aload_2
    //   743: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   746: sipush -2002
    //   749: if_icmpeq +13 -> 762
    //   752: aload_2
    //   753: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   756: sipush -1031
    //   759: if_icmpne +247 -> 1006
    //   762: aload_2
    //   763: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   766: astore 5
    //   768: aload_2
    //   769: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   772: aload_2
    //   773: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   776: invokestatic 616	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   779: ifeq +7129 -> 7908
    //   782: aload_2
    //   783: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   786: astore 5
    //   788: aload_0
    //   789: ldc_w 672
    //   792: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   795: astore_0
    //   796: aload_1
    //   797: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   800: aload 5
    //   802: aload_2
    //   803: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   806: aload_2
    //   807: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   810: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   813: astore 16
    //   815: aload 16
    //   817: instanceof 674
    //   820: ifeq +7079 -> 7899
    //   823: aload 16
    //   825: checkcast 674	com/tencent/mobileqq/data/MessageForPtt
    //   828: astore 17
    //   830: aload 17
    //   832: invokevirtual 677	com/tencent/mobileqq/data/MessageForPtt:getSummaryMsg	()Ljava/lang/String;
    //   835: astore 16
    //   837: aload 16
    //   839: astore_0
    //   840: aload_2
    //   841: invokevirtual 320	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   844: ifeq +7055 -> 7899
    //   847: aload 17
    //   849: getfield 680	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   852: ldc2_w 48
    //   855: lcmp
    //   856: ifne +52 -> 908
    //   859: iconst_0
    //   860: istore 7
    //   862: iconst_1
    //   863: istore 6
    //   865: aload 16
    //   867: astore_0
    //   868: ldc_w 682
    //   871: iconst_2
    //   872: anewarray 4	java/lang/Object
    //   875: dup
    //   876: iconst_0
    //   877: iload 6
    //   879: invokestatic 687	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   882: aastore
    //   883: dup
    //   884: iconst_1
    //   885: iload 7
    //   887: invokestatic 687	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   890: aastore
    //   891: invokestatic 692	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   894: aload 19
    //   896: aload_0
    //   897: aconst_null
    //   898: iload 6
    //   900: iload 7
    //   902: aload 4
    //   904: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   907: return
    //   908: aload 16
    //   910: astore_0
    //   911: aload 17
    //   913: getfield 680	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   916: lconst_0
    //   917: lcmp
    //   918: ifgt +6981 -> 7899
    //   921: aload_1
    //   922: aload 5
    //   924: aload 17
    //   926: getfield 695	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   929: aload 17
    //   931: getfield 696	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   934: invokestatic 702	com/tencent/mobileqq/transfile/api/TransFileControllerBusHelper:findProcessorFileStatus	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;J)I
    //   937: istore_3
    //   938: iload_3
    //   939: sipush 1005
    //   942: if_icmpeq +15 -> 957
    //   945: iload_3
    //   946: sipush 1004
    //   949: if_icmpeq +8 -> 957
    //   952: iload_3
    //   953: iconst_m1
    //   954: if_icmpne +43 -> 997
    //   957: iconst_1
    //   958: istore 6
    //   960: iconst_0
    //   961: istore 7
    //   963: ldc_w 682
    //   966: iconst_2
    //   967: anewarray 4	java/lang/Object
    //   970: dup
    //   971: iconst_0
    //   972: aload 17
    //   974: getfield 680	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   977: invokestatic 707	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   980: aastore
    //   981: dup
    //   982: iconst_1
    //   983: iload_3
    //   984: invokestatic 710	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   987: aastore
    //   988: invokestatic 692	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   991: aload 16
    //   993: astore_0
    //   994: goto -126 -> 868
    //   997: iconst_1
    //   998: istore 7
    //   1000: iconst_0
    //   1001: istore 6
    //   1003: goto -40 -> 963
    //   1006: aload_2
    //   1007: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1010: sipush -3008
    //   1013: if_icmpne +48 -> 1061
    //   1016: aload 4
    //   1018: new 173	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1025: aload_0
    //   1026: ldc_w 711
    //   1029: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   1032: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: ldc_w 713
    //   1038: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload_2
    //   1042: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   1045: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: ldc_w 713
    //   1051: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1060: return
    //   1061: aload_2
    //   1062: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1065: sipush -2015
    //   1068: if_icmpeq +143 -> 1211
    //   1071: aload_2
    //   1072: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1075: sipush -2060
    //   1078: if_icmpeq +133 -> 1211
    //   1081: aload_2
    //   1082: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1085: sipush -2062
    //   1088: if_icmpeq +123 -> 1211
    //   1091: aload_2
    //   1092: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1095: sipush -2065
    //   1098: if_icmpeq +113 -> 1211
    //   1101: aload_2
    //   1102: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1105: sipush -7010
    //   1108: if_icmpeq +103 -> 1211
    //   1111: aload_2
    //   1112: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1115: sipush -7009
    //   1118: if_icmpeq +93 -> 1211
    //   1121: aload_2
    //   1122: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1125: sipush -7011
    //   1128: if_icmpeq +83 -> 1211
    //   1131: aload_2
    //   1132: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1135: sipush -7012
    //   1138: if_icmpeq +73 -> 1211
    //   1141: aload_2
    //   1142: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1145: sipush -4023
    //   1148: if_icmpeq +63 -> 1211
    //   1151: aload_2
    //   1152: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1155: sipush -4024
    //   1158: if_icmpeq +53 -> 1211
    //   1161: aload_2
    //   1162: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1165: sipush -4025
    //   1168: if_icmpeq +43 -> 1211
    //   1171: aload_2
    //   1172: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1175: sipush -4026
    //   1178: if_icmpeq +33 -> 1211
    //   1181: aload_2
    //   1182: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1185: sipush -4027
    //   1188: if_icmpeq +23 -> 1211
    //   1191: aload_2
    //   1192: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1195: sipush -7013
    //   1198: if_icmpeq +13 -> 1211
    //   1201: aload_2
    //   1202: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1205: sipush -7015
    //   1208: if_icmpne +11 -> 1219
    //   1211: aload 4
    //   1213: ldc 131
    //   1215: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1218: return
    //   1219: aload_2
    //   1220: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1223: invokestatic 717	com/tencent/mobileqq/utils/ActionMsgUtil:a	(I)Z
    //   1226: ifeq +28 -> 1254
    //   1229: aload 19
    //   1231: aload_0
    //   1232: aload_1
    //   1233: aload_2
    //   1234: invokestatic 719	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1237: aconst_null
    //   1238: aload_1
    //   1239: aload_2
    //   1240: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1243: aload_1
    //   1244: aload_2
    //   1245: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1248: aload 4
    //   1250: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1253: return
    //   1254: aload_2
    //   1255: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1258: sipush -2017
    //   1261: if_icmpne +94 -> 1355
    //   1264: aload_0
    //   1265: ldc_w 720
    //   1268: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   1271: astore 5
    //   1273: aload_2
    //   1274: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   1277: astore_0
    //   1278: aload_2
    //   1279: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   1282: aload_2
    //   1283: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   1286: invokestatic 616	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   1289: ifeq +8 -> 1297
    //   1292: aload_2
    //   1293: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   1296: astore_0
    //   1297: aload_1
    //   1298: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1301: aload_0
    //   1302: aload_2
    //   1303: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   1306: aload_2
    //   1307: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   1310: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1313: astore 16
    //   1315: aload 5
    //   1317: astore_0
    //   1318: aload 16
    //   1320: instanceof 722
    //   1323: ifeq +12 -> 1335
    //   1326: aload 16
    //   1328: checkcast 722	com/tencent/mobileqq/data/MessageForTroopFile
    //   1331: invokevirtual 723	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   1334: astore_0
    //   1335: aload 19
    //   1337: aload_0
    //   1338: aconst_null
    //   1339: aload_1
    //   1340: aload_2
    //   1341: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1344: aload_1
    //   1345: aload_2
    //   1346: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1349: aload 4
    //   1351: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1354: return
    //   1355: aload_2
    //   1356: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1359: invokestatic 725	com/tencent/mobileqq/utils/ActionMsgUtil:b	(I)Z
    //   1362: ifeq +43 -> 1405
    //   1365: aload_2
    //   1366: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   1369: invokestatic 731	com/tencent/mobileqq/transfile/TransfileUtile:analysisTransFileProtocolData	(Ljava/lang/String;)[Ljava/lang/String;
    //   1372: astore_1
    //   1373: aload_1
    //   1374: ifnull +22 -> 1396
    //   1377: aload 4
    //   1379: aload_1
    //   1380: aload_0
    //   1381: aload_2
    //   1382: getfield 734	com/tencent/imcore/message/Message:issend	I
    //   1385: invokestatic 737	com/tencent/mobileqq/service/message/remote/MessageRecordInfo:b	(I)Z
    //   1388: iload 7
    //   1390: invokestatic 739	com/tencent/mobileqq/utils/MsgUtils:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   1393: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1396: iload_3
    //   1397: aload 19
    //   1399: aload 4
    //   1401: invokestatic 744	com/tencent/mobileqq/activity/recent/msgbox/TempMsgBoxUtil:a	(ILjava/lang/String;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1404: return
    //   1405: aload_2
    //   1406: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1409: invokestatic 746	com/tencent/mobileqq/utils/ActionMsgUtil:c	(I)Z
    //   1412: ifeq +39 -> 1451
    //   1415: aload_2
    //   1416: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   1419: invokestatic 731	com/tencent/mobileqq/transfile/TransfileUtile:analysisTransFileProtocolData	(Ljava/lang/String;)[Ljava/lang/String;
    //   1422: astore 5
    //   1424: aload 5
    //   1426: ifnull -1422 -> 4
    //   1429: aload 4
    //   1431: aload_1
    //   1432: aload 5
    //   1434: aload_0
    //   1435: aload_2
    //   1436: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   1439: aload_2
    //   1440: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   1443: iload_3
    //   1444: invokestatic 748	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1447: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1450: return
    //   1451: aload_2
    //   1452: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1455: invokestatic 750	com/tencent/mobileqq/utils/ActionMsgUtil:d	(I)Z
    //   1458: ifeq +134 -> 1592
    //   1461: aload_1
    //   1462: aload_2
    //   1463: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1466: istore 6
    //   1468: aload_1
    //   1469: aload_2
    //   1470: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1473: istore 7
    //   1475: aload_2
    //   1476: ldc_w 752
    //   1479: invokevirtual 755	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1482: astore 5
    //   1484: getstatic 759	com/tencent/mobileqq/emoticon/EmojiStickerManager:f	Z
    //   1487: ifeq +96 -> 1583
    //   1490: aload 5
    //   1492: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1495: ifne +88 -> 1583
    //   1498: aload_0
    //   1499: aload_2
    //   1500: invokestatic 764	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1503: astore_0
    //   1504: aload_2
    //   1505: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   1508: aload_1
    //   1509: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1512: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1515: ifeq +41 -> 1556
    //   1518: new 173	java/lang/StringBuilder
    //   1521: dup
    //   1522: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1525: ldc_w 765
    //   1528: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1531: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: aload_0
    //   1535: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1541: astore_0
    //   1542: aload 19
    //   1544: aload_0
    //   1545: aconst_null
    //   1546: iload 6
    //   1548: iload 7
    //   1550: aload 4
    //   1552: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1555: return
    //   1556: new 173	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1563: ldc_w 766
    //   1566: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1569: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: aload_0
    //   1573: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1576: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1579: astore_0
    //   1580: goto -38 -> 1542
    //   1583: aload_0
    //   1584: aload_2
    //   1585: invokestatic 764	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1588: astore_0
    //   1589: goto -47 -> 1542
    //   1592: aload_2
    //   1593: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   1596: sipush -2058
    //   1599: if_icmpne +1091 -> 2690
    //   1602: ldc 131
    //   1604: astore 18
    //   1606: aload_1
    //   1607: aload_2
    //   1608: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1611: istore 12
    //   1613: aload_1
    //   1614: aload_2
    //   1615: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   1618: istore 13
    //   1620: iconst_0
    //   1621: istore 8
    //   1623: aload 18
    //   1625: astore 17
    //   1627: aload_2
    //   1628: ldc_w 768
    //   1631: invokevirtual 755	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1634: astore 5
    //   1636: aload 18
    //   1638: astore 16
    //   1640: aload 18
    //   1642: astore 17
    //   1644: aload 5
    //   1646: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1649: ifne +291 -> 1940
    //   1652: aload 18
    //   1654: astore 17
    //   1656: new 770	org/json/JSONObject
    //   1659: dup
    //   1660: aload 5
    //   1662: invokespecial 773	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1665: ldc_w 775
    //   1668: invokevirtual 778	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1671: istore 9
    //   1673: iload 8
    //   1675: istore_3
    //   1676: aload 18
    //   1678: astore 5
    //   1680: aload 18
    //   1682: astore 17
    //   1684: aload_2
    //   1685: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   1688: ifnull +114 -> 1802
    //   1691: iload 8
    //   1693: istore_3
    //   1694: aload 18
    //   1696: astore 5
    //   1698: iload 9
    //   1700: sipush -2007
    //   1703: if_icmpne +99 -> 1802
    //   1706: iload 8
    //   1708: istore_3
    //   1709: aload 18
    //   1711: astore 5
    //   1713: aload 18
    //   1715: astore 17
    //   1717: aload_2
    //   1718: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   1721: invokestatic 787	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   1724: instanceof 789
    //   1727: ifeq +75 -> 1802
    //   1730: aload 18
    //   1732: astore 17
    //   1734: getstatic 759	com/tencent/mobileqq/emoticon/EmojiStickerManager:f	Z
    //   1737: ifeq +253 -> 1990
    //   1740: aload 18
    //   1742: astore 17
    //   1744: aload_0
    //   1745: aload_2
    //   1746: invokestatic 764	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1749: astore 5
    //   1751: aload 18
    //   1753: astore 17
    //   1755: aload_2
    //   1756: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   1759: aload_1
    //   1760: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1763: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1766: ifeq +191 -> 1957
    //   1769: aload 18
    //   1771: astore 17
    //   1773: new 173	java/lang/StringBuilder
    //   1776: dup
    //   1777: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1780: ldc_w 790
    //   1783: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1786: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1789: aload 5
    //   1791: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1797: astore 5
    //   1799: goto +6144 -> 7943
    //   1802: aload 5
    //   1804: astore 16
    //   1806: iload_3
    //   1807: ifne +133 -> 1940
    //   1810: aload 5
    //   1812: astore 17
    //   1814: getstatic 759	com/tencent/mobileqq/emoticon/EmojiStickerManager:f	Z
    //   1817: ifeq +229 -> 2046
    //   1820: aload 5
    //   1822: astore 17
    //   1824: aload_2
    //   1825: ldc_w 752
    //   1828: invokevirtual 755	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1831: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1834: ifne +6059 -> 7893
    //   1837: aload 5
    //   1839: astore 17
    //   1841: aload_1
    //   1842: aload_2
    //   1843: aload 4
    //   1845: invokestatic 793	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   1848: astore_0
    //   1849: new 173	java/lang/StringBuilder
    //   1852: dup
    //   1853: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1856: astore_1
    //   1857: aload 19
    //   1859: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1862: ifne +16 -> 1878
    //   1865: aload_1
    //   1866: aload 19
    //   1868: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: ldc_w 439
    //   1874: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1877: pop
    //   1878: aload 4
    //   1880: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1883: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1886: ifne +13 -> 1899
    //   1889: aload_1
    //   1890: aload 4
    //   1892: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1895: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   1898: pop
    //   1899: aload_2
    //   1900: invokestatic 294	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1903: ifne +16 -> 1919
    //   1906: iload 12
    //   1908: ifeq +98 -> 2006
    //   1911: aload_1
    //   1912: ldc_w 801
    //   1915: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1918: pop
    //   1919: aload_0
    //   1920: checkcast 803	com/tencent/mobileqq/text/QQText
    //   1923: aload_1
    //   1924: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1927: iconst_1
    //   1928: iconst_0
    //   1929: newarray int
    //   1931: invokevirtual 806	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   1934: astore_1
    //   1935: aload_1
    //   1936: astore_0
    //   1937: aload_0
    //   1938: astore 16
    //   1940: aload 16
    //   1942: astore_2
    //   1943: aload 19
    //   1945: aload_2
    //   1946: aconst_null
    //   1947: iload 12
    //   1949: iload 13
    //   1951: aload 4
    //   1953: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1956: return
    //   1957: aload 18
    //   1959: astore 17
    //   1961: new 173	java/lang/StringBuilder
    //   1964: dup
    //   1965: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1968: ldc_w 807
    //   1971: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1974: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: aload 5
    //   1979: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1985: astore 5
    //   1987: goto +5956 -> 7943
    //   1990: aload 18
    //   1992: astore 17
    //   1994: aload_0
    //   1995: aload_2
    //   1996: invokestatic 764	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   1999: astore 5
    //   2001: iconst_1
    //   2002: istore_3
    //   2003: goto -201 -> 1802
    //   2006: iload 13
    //   2008: ifeq -89 -> 1919
    //   2011: aload_1
    //   2012: ldc_w 809
    //   2015: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: pop
    //   2019: goto -100 -> 1919
    //   2022: astore_1
    //   2023: aload_0
    //   2024: astore_2
    //   2025: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2028: ifeq -85 -> 1943
    //   2031: ldc_w 811
    //   2034: iconst_2
    //   2035: ldc 131
    //   2037: aload_1
    //   2038: invokestatic 815	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2041: aload_0
    //   2042: astore_2
    //   2043: goto -100 -> 1943
    //   2046: iload 9
    //   2048: sipush -1000
    //   2051: if_icmpne +182 -> 2233
    //   2054: aload 5
    //   2056: astore 17
    //   2058: aload_2
    //   2059: invokestatic 818	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/imcore/message/Message;)Lcom/tencent/mobileqq/text/QQText;
    //   2062: astore_0
    //   2063: aload_0
    //   2064: ifnull -2060 -> 4
    //   2067: aload 5
    //   2069: astore 17
    //   2071: new 173	java/lang/StringBuilder
    //   2074: dup
    //   2075: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2078: astore_1
    //   2079: aload 5
    //   2081: astore 17
    //   2083: aload 19
    //   2085: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2088: ifne +20 -> 2108
    //   2091: aload 5
    //   2093: astore 17
    //   2095: aload_1
    //   2096: aload 19
    //   2098: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2101: ldc_w 439
    //   2104: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: pop
    //   2108: aload 5
    //   2110: astore 17
    //   2112: aload 4
    //   2114: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   2117: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2120: ifne +17 -> 2137
    //   2123: aload 5
    //   2125: astore 17
    //   2127: aload_1
    //   2128: aload 4
    //   2130: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   2133: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   2136: pop
    //   2137: aload 5
    //   2139: astore 17
    //   2141: aload_2
    //   2142: invokestatic 294	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2145: ifne +20 -> 2165
    //   2148: iload 12
    //   2150: ifeq +63 -> 2213
    //   2153: aload 5
    //   2155: astore 17
    //   2157: aload_1
    //   2158: ldc_w 801
    //   2161: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2164: pop
    //   2165: aload 5
    //   2167: astore 17
    //   2169: aload_0
    //   2170: checkcast 803	com/tencent/mobileqq/text/QQText
    //   2173: aload_1
    //   2174: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2177: iconst_1
    //   2178: iconst_0
    //   2179: newarray int
    //   2181: invokevirtual 806	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   2184: astore_0
    //   2185: aload 5
    //   2187: astore 17
    //   2189: aload 4
    //   2191: iconst_1
    //   2192: putfield 821	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   2195: aload 5
    //   2197: astore 17
    //   2199: aload 19
    //   2201: aload_0
    //   2202: aconst_null
    //   2203: iload 12
    //   2205: iload 13
    //   2207: aload 4
    //   2209: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2212: return
    //   2213: iload 13
    //   2215: ifeq -50 -> 2165
    //   2218: aload 5
    //   2220: astore 17
    //   2222: aload_1
    //   2223: ldc_w 809
    //   2226: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: pop
    //   2230: goto -65 -> 2165
    //   2233: aload 5
    //   2235: astore 16
    //   2237: iload 9
    //   2239: sipush -2000
    //   2242: if_icmpne -302 -> 1940
    //   2245: iconst_0
    //   2246: istore 11
    //   2248: iconst_0
    //   2249: istore 7
    //   2251: aload_2
    //   2252: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2255: astore 16
    //   2257: aload_2
    //   2258: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   2261: aload_2
    //   2262: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   2265: invokestatic 616	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   2268: ifeq +5622 -> 7890
    //   2271: aload_2
    //   2272: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   2275: astore 16
    //   2277: aload_1
    //   2278: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   2281: aload 16
    //   2283: aload_2
    //   2284: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   2287: aload_2
    //   2288: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   2291: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2294: checkcast 371	com/tencent/mobileqq/data/MessageForPic
    //   2297: astore 17
    //   2299: aload_1
    //   2300: ldc_w 618
    //   2303: invokevirtual 622	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   2306: checkcast 618	com/tencent/mobileqq/transfile/api/ITransFileController
    //   2309: aload 16
    //   2311: aload_2
    //   2312: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   2315: invokeinterface 626 4 0
    //   2320: astore_1
    //   2321: aload_2
    //   2322: invokevirtual 320	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   2325: ifeq +239 -> 2564
    //   2328: aload 17
    //   2330: getfield 629	com/tencent/mobileqq/data/MessageForPic:size	J
    //   2333: lstore 14
    //   2335: lload 14
    //   2337: lconst_0
    //   2338: lcmp
    //   2339: ifgt +208 -> 2547
    //   2342: aload_1
    //   2343: ifnonnull +5541 -> 7884
    //   2346: aload 17
    //   2348: ifnull +5536 -> 7884
    //   2351: iconst_1
    //   2352: istore 6
    //   2354: iload 6
    //   2356: istore 10
    //   2358: aload 5
    //   2360: astore 17
    //   2362: aload_1
    //   2363: instanceof 631
    //   2366: ifeq +261 -> 2627
    //   2369: aload 5
    //   2371: astore 17
    //   2373: aload_1
    //   2374: checkcast 631	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   2377: astore_1
    //   2378: aload 5
    //   2380: astore 17
    //   2382: aload_1
    //   2383: invokevirtual 634	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   2386: ldc2_w 635
    //   2389: lcmp
    //   2390: ifeq +6 -> 2396
    //   2393: iconst_1
    //   2394: istore 7
    //   2396: iload 7
    //   2398: istore 6
    //   2400: aload 5
    //   2402: astore 17
    //   2404: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2407: ifeq +76 -> 2483
    //   2410: aload 5
    //   2412: astore 17
    //   2414: aload_1
    //   2415: getfield 640	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   2418: ifnull +5543 -> 7961
    //   2421: aload 5
    //   2423: astore 17
    //   2425: aload_1
    //   2426: getfield 640	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   2429: getfield 645	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   2432: lstore 14
    //   2434: aload 5
    //   2436: astore 17
    //   2438: ldc_w 647
    //   2441: iconst_2
    //   2442: new 173	java/lang/StringBuilder
    //   2445: dup
    //   2446: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2449: ldc_w 649
    //   2452: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2455: lload 14
    //   2457: invokevirtual 521	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2460: ldc_w 651
    //   2463: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: aload_1
    //   2467: invokevirtual 654	com/tencent/mobileqq/transfile/BaseTransProcessor:getKey	()Ljava/lang/String;
    //   2470: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2473: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2476: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2479: iload 7
    //   2481: istore 6
    //   2483: aload 5
    //   2485: astore 17
    //   2487: aload_0
    //   2488: ldc_w 655
    //   2491: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   2494: astore_1
    //   2495: aload 5
    //   2497: astore 17
    //   2499: aload_2
    //   2500: invokestatic 658	com/tencent/mobileqq/app/HotChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2503: ifne +14 -> 2517
    //   2506: aload 5
    //   2508: astore 17
    //   2510: aload_2
    //   2511: invokestatic 661	com/tencent/mobileqq/app/FlashPicHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2514: ifeq +15 -> 2529
    //   2517: aload 5
    //   2519: astore 17
    //   2521: aload_0
    //   2522: ldc_w 662
    //   2525: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   2528: astore_1
    //   2529: aload 5
    //   2531: astore 17
    //   2533: aload 19
    //   2535: aload_1
    //   2536: aconst_null
    //   2537: iload 10
    //   2539: iload 6
    //   2541: aload 4
    //   2543: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2546: return
    //   2547: aload 17
    //   2549: getfield 668	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   2552: ldc_w 669
    //   2555: if_icmpne +5400 -> 7955
    //   2558: iconst_1
    //   2559: istore 6
    //   2561: goto -207 -> 2354
    //   2564: aload_1
    //   2565: ifnull +5319 -> 7884
    //   2568: aload_1
    //   2569: instanceof 631
    //   2572: ifeq +5312 -> 7884
    //   2575: aload_1
    //   2576: checkcast 631	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   2579: invokevirtual 634	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   2582: lstore 14
    //   2584: lload 14
    //   2586: l2i
    //   2587: istore_3
    //   2588: iload_3
    //   2589: sipush 1005
    //   2592: if_icmpeq +10 -> 2602
    //   2595: iload_3
    //   2596: sipush 1004
    //   2599: if_icmpne +5285 -> 7884
    //   2602: iconst_1
    //   2603: istore 6
    //   2605: goto -251 -> 2354
    //   2608: astore 16
    //   2610: aconst_null
    //   2611: astore_1
    //   2612: aload 5
    //   2614: astore 17
    //   2616: aload 16
    //   2618: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   2621: iconst_0
    //   2622: istore 10
    //   2624: goto -266 -> 2358
    //   2627: iload 11
    //   2629: istore 6
    //   2631: aload_1
    //   2632: ifnull -149 -> 2483
    //   2635: iconst_1
    //   2636: istore 7
    //   2638: iload 7
    //   2640: istore 6
    //   2642: aload 5
    //   2644: astore 17
    //   2646: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2649: ifeq -166 -> 2483
    //   2652: aload 5
    //   2654: astore 17
    //   2656: ldc_w 647
    //   2659: iconst_2
    //   2660: new 173	java/lang/StringBuilder
    //   2663: dup
    //   2664: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2667: ldc_w 671
    //   2670: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2673: aload_1
    //   2674: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2677: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2680: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2683: iload 7
    //   2685: istore 6
    //   2687: goto -204 -> 2483
    //   2690: aload_2
    //   2691: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   2694: invokestatic 823	com/tencent/mobileqq/utils/ActionMsgUtil:e	(I)Z
    //   2697: ifeq +278 -> 2975
    //   2700: new 825	com/tencent/mobileqq/apollo/api/model/MessageForApollo
    //   2703: dup
    //   2704: invokespecial 826	com/tencent/mobileqq/apollo/api/model/MessageForApollo:<init>	()V
    //   2707: astore 5
    //   2709: aload 5
    //   2711: aload_2
    //   2712: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   2715: putfield 827	com/tencent/mobileqq/apollo/api/model/MessageForApollo:msgData	[B
    //   2718: aload 5
    //   2720: invokevirtual 828	com/tencent/mobileqq/apollo/api/model/MessageForApollo:parse	()V
    //   2723: aload_1
    //   2724: aload_2
    //   2725: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2728: istore 6
    //   2730: aload_1
    //   2731: aload_2
    //   2732: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   2735: istore 7
    //   2737: aload 5
    //   2739: getfield 830	com/tencent/mobileqq/apollo/api/model/MessageForApollo:msgType	I
    //   2742: invokestatic 833	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(I)Z
    //   2745: ifeq +209 -> 2954
    //   2748: ldc_w 834
    //   2751: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2754: astore_0
    //   2755: aload 5
    //   2757: getfield 830	com/tencent/mobileqq/apollo/api/model/MessageForApollo:msgType	I
    //   2760: iconst_4
    //   2761: if_icmpne +155 -> 2916
    //   2764: aload 5
    //   2766: getfield 837	com/tencent/mobileqq/apollo/api/model/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2769: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2772: ifeq +43 -> 2815
    //   2775: new 173	java/lang/StringBuilder
    //   2778: dup
    //   2779: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2782: aload_0
    //   2783: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: ldc_w 838
    //   2789: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2792: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2795: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2798: astore_1
    //   2799: aload_1
    //   2800: astore_0
    //   2801: aload 19
    //   2803: aload_0
    //   2804: aconst_null
    //   2805: iload 6
    //   2807: iload 7
    //   2809: aload 4
    //   2811: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2814: return
    //   2815: new 770	org/json/JSONObject
    //   2818: dup
    //   2819: aload 5
    //   2821: getfield 837	com/tencent/mobileqq/apollo/api/model/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2824: invokespecial 773	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2827: ldc_w 840
    //   2830: invokevirtual 843	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2833: astore_1
    //   2834: aload_1
    //   2835: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2838: ifeq +32 -> 2870
    //   2841: new 173	java/lang/StringBuilder
    //   2844: dup
    //   2845: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2848: aload_0
    //   2849: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2852: ldc_w 844
    //   2855: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2858: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2861: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2864: astore_1
    //   2865: aload_1
    //   2866: astore_0
    //   2867: goto -66 -> 2801
    //   2870: new 173	java/lang/StringBuilder
    //   2873: dup
    //   2874: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2877: aload_0
    //   2878: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2881: ldc_w 535
    //   2884: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2887: aload_1
    //   2888: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2891: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2894: astore_1
    //   2895: aload_1
    //   2896: astore_0
    //   2897: goto -96 -> 2801
    //   2900: astore_1
    //   2901: ldc_w 811
    //   2904: iconst_1
    //   2905: aload_1
    //   2906: iconst_0
    //   2907: anewarray 4	java/lang/Object
    //   2910: invokestatic 847	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2913: goto -112 -> 2801
    //   2916: aload_1
    //   2917: aload 5
    //   2919: invokestatic 850	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;)Ljava/lang/String;
    //   2922: astore_1
    //   2923: new 173	java/lang/StringBuilder
    //   2926: dup
    //   2927: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2930: aload_0
    //   2931: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2934: ldc_w 851
    //   2937: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2940: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2943: aload_1
    //   2944: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2947: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2950: astore_0
    //   2951: goto -150 -> 2801
    //   2954: ldc_w 853
    //   2957: invokestatic 859	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2960: checkcast 853	com/tencent/mobileqq/apollo/api/uitls/IApolloUtil
    //   2963: aload_1
    //   2964: aload 5
    //   2966: invokeinterface 862 3 0
    //   2971: astore_0
    //   2972: goto -171 -> 2801
    //   2975: aload_2
    //   2976: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   2979: sipush -1013
    //   2982: if_icmpeq +13 -> 2995
    //   2985: aload_2
    //   2986: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   2989: sipush -1047
    //   2992: if_icmpne +20 -> 3012
    //   2995: aconst_null
    //   2996: aconst_null
    //   2997: aload_2
    //   2998: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3001: invokestatic 582	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3004: iconst_0
    //   3005: iconst_0
    //   3006: aload 4
    //   3008: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3011: return
    //   3012: aload_2
    //   3013: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3016: sipush -2042
    //   3019: if_icmpeq +13 -> 3032
    //   3022: aload_2
    //   3023: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3026: sipush -2043
    //   3029: if_icmpne +20 -> 3049
    //   3032: aconst_null
    //   3033: aload_2
    //   3034: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3037: invokestatic 582	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3040: aconst_null
    //   3041: iconst_0
    //   3042: iconst_0
    //   3043: aload 4
    //   3045: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3048: return
    //   3049: aload_2
    //   3050: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3053: sipush -2051
    //   3056: if_icmpne +155 -> 3211
    //   3059: aload_1
    //   3060: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3063: aload_2
    //   3064: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3067: aload_2
    //   3068: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3071: aload_2
    //   3072: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3075: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3078: astore_0
    //   3079: aload_0
    //   3080: ifnull +50 -> 3130
    //   3083: aload_0
    //   3084: instanceof 864
    //   3087: ifeq +43 -> 3130
    //   3090: aload_0
    //   3091: checkcast 864	com/tencent/mobileqq/data/MessageForQQStory
    //   3094: astore_0
    //   3095: aload_0
    //   3096: invokevirtual 865	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   3099: aload_1
    //   3100: aload_2
    //   3101: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3104: istore 6
    //   3106: aload_1
    //   3107: aload_2
    //   3108: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3111: istore 7
    //   3113: aload 19
    //   3115: aconst_null
    //   3116: aload_0
    //   3117: invokevirtual 866	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   3120: iload 6
    //   3122: iload 7
    //   3124: aload 4
    //   3126: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3129: return
    //   3130: new 173	java/lang/StringBuilder
    //   3133: dup
    //   3134: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   3137: ldc 2
    //   3139: invokevirtual 871	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3142: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3145: ldc_w 873
    //   3148: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3151: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3154: astore_1
    //   3155: new 173	java/lang/StringBuilder
    //   3158: dup
    //   3159: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   3162: ldc_w 875
    //   3165: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: aload_2
    //   3169: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3172: invokevirtual 521	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3175: ldc_w 877
    //   3178: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3181: astore_2
    //   3182: aload_0
    //   3183: ifnull +22 -> 3205
    //   3186: aload_0
    //   3187: invokevirtual 880	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3190: astore_0
    //   3191: aload_1
    //   3192: iconst_1
    //   3193: aload_2
    //   3194: aload_0
    //   3195: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3198: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3201: invokestatic 882	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3204: return
    //   3205: ldc 131
    //   3207: astore_0
    //   3208: goto -17 -> 3191
    //   3211: aload_2
    //   3212: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3215: sipush -7002
    //   3218: if_icmpne +148 -> 3366
    //   3221: aload_1
    //   3222: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3225: aload_2
    //   3226: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3229: aload_2
    //   3230: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3233: aload_2
    //   3234: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3237: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3240: checkcast 884	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   3243: astore_0
    //   3244: aload_0
    //   3245: ifnull +38 -> 3283
    //   3248: aload_0
    //   3249: invokevirtual 885	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   3252: aload_1
    //   3253: aload_2
    //   3254: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3257: istore 6
    //   3259: aload_1
    //   3260: aload_2
    //   3261: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3264: istore 7
    //   3266: aload 19
    //   3268: aconst_null
    //   3269: aload_0
    //   3270: invokevirtual 886	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   3273: iload 6
    //   3275: iload 7
    //   3277: aload 4
    //   3279: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3282: return
    //   3283: new 173	java/lang/StringBuilder
    //   3286: dup
    //   3287: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   3290: ldc 2
    //   3292: invokevirtual 871	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3295: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3298: ldc_w 873
    //   3301: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3304: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3307: astore_1
    //   3308: new 173	java/lang/StringBuilder
    //   3311: dup
    //   3312: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   3315: ldc_w 888
    //   3318: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3321: aload_2
    //   3322: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3325: invokevirtual 521	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3328: ldc_w 877
    //   3331: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3334: astore 4
    //   3336: aload_2
    //   3337: ifnull +23 -> 3360
    //   3340: aload_2
    //   3341: invokevirtual 889	com/tencent/imcore/message/Message:toString	()Ljava/lang/String;
    //   3344: astore_0
    //   3345: aload_1
    //   3346: iconst_1
    //   3347: aload 4
    //   3349: aload_0
    //   3350: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3353: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3356: invokestatic 882	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3359: return
    //   3360: ldc 131
    //   3362: astore_0
    //   3363: goto -18 -> 3345
    //   3366: aload_2
    //   3367: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3370: sipush -2054
    //   3373: if_icmpne +153 -> 3526
    //   3376: aload_1
    //   3377: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3380: aload_2
    //   3381: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3384: aload_2
    //   3385: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3388: aload_2
    //   3389: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3392: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3395: astore_0
    //   3396: aload_0
    //   3397: instanceof 891
    //   3400: ifeq +42 -> 3442
    //   3403: aload_0
    //   3404: checkcast 891	com/tencent/mobileqq/data/MessageForTroopSign
    //   3407: astore_0
    //   3408: ldc_w 892
    //   3411: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3414: pop
    //   3415: aload_0
    //   3416: invokevirtual 893	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   3419: aload 19
    //   3421: aconst_null
    //   3422: aload_0
    //   3423: invokevirtual 894	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   3426: aload_1
    //   3427: aload_2
    //   3428: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3431: aload_1
    //   3432: aload_2
    //   3433: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   3436: aload 4
    //   3438: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3441: return
    //   3442: new 173	java/lang/StringBuilder
    //   3445: dup
    //   3446: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   3449: ldc 2
    //   3451: invokevirtual 871	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3454: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3457: ldc_w 896
    //   3460: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3463: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3466: astore_1
    //   3467: new 173	java/lang/StringBuilder
    //   3470: dup
    //   3471: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   3474: ldc_w 898
    //   3477: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3480: aload_2
    //   3481: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3484: invokevirtual 521	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3487: ldc_w 877
    //   3490: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3493: astore_2
    //   3494: aload_0
    //   3495: ifnull +25 -> 3520
    //   3498: aload_0
    //   3499: getfield 899	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3502: invokestatic 710	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3505: astore_0
    //   3506: aload_1
    //   3507: iconst_1
    //   3508: aload_2
    //   3509: aload_0
    //   3510: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3513: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3516: invokestatic 882	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3519: return
    //   3520: ldc 131
    //   3522: astore_0
    //   3523: goto -17 -> 3506
    //   3526: aload_2
    //   3527: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3530: sipush -2035
    //   3533: if_icmpne +20 -> 3553
    //   3536: aconst_null
    //   3537: aload_2
    //   3538: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   3541: invokestatic 582	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3544: aconst_null
    //   3545: iconst_0
    //   3546: iconst_0
    //   3547: aload 4
    //   3549: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3552: return
    //   3553: aload_2
    //   3554: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3557: sipush -2038
    //   3560: if_icmpne +205 -> 3765
    //   3563: aload_2
    //   3564: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3567: astore_0
    //   3568: getstatic 904	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   3571: aload_0
    //   3572: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3575: ifeq +4306 -> 7881
    //   3578: aload_2
    //   3579: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   3582: astore_0
    //   3583: aload_0
    //   3584: astore 5
    //   3586: getstatic 907	com/tencent/mobileqq/app/AppConstants:LBS_HELLO_UIN	Ljava/lang/String;
    //   3589: aload_0
    //   3590: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3593: ifeq +59 -> 3652
    //   3596: getstatic 904	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   3599: aload_2
    //   3600: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   3603: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3606: ifeq +103 -> 3709
    //   3609: aload_1
    //   3610: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3613: getstatic 904	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   3616: aload_2
    //   3617: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3620: aload_2
    //   3621: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3624: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3627: checkcast 909	com/tencent/mobileqq/data/MessageForTroopGift
    //   3630: astore 16
    //   3632: aload_0
    //   3633: astore 5
    //   3635: aload 16
    //   3637: ifnull +15 -> 3652
    //   3640: aload 16
    //   3642: invokevirtual 910	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3645: aload 16
    //   3647: getfield 911	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   3650: astore 5
    //   3652: aload_1
    //   3653: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3656: aload 5
    //   3658: aload_2
    //   3659: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3662: aload_2
    //   3663: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3666: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3669: astore_0
    //   3670: aload_0
    //   3671: instanceof 909
    //   3674: ifeq +50 -> 3724
    //   3677: aload_0
    //   3678: checkcast 909	com/tencent/mobileqq/data/MessageForTroopGift
    //   3681: astore_0
    //   3682: aload_0
    //   3683: invokevirtual 910	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3686: aload_0
    //   3687: getfield 912	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3690: ifnull +28 -> 3718
    //   3693: aload_0
    //   3694: getfield 912	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3697: astore_0
    //   3698: aconst_null
    //   3699: aload_0
    //   3700: aconst_null
    //   3701: iconst_0
    //   3702: iconst_0
    //   3703: aload 4
    //   3705: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3708: return
    //   3709: aload_2
    //   3710: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   3713: astore 5
    //   3715: goto -63 -> 3652
    //   3718: ldc 131
    //   3720: astore_0
    //   3721: goto -23 -> 3698
    //   3724: aload_0
    //   3725: ifnull -3721 -> 4
    //   3728: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3731: ifeq -3727 -> 4
    //   3734: ldc_w 811
    //   3737: iconst_2
    //   3738: new 173	java/lang/StringBuilder
    //   3741: dup
    //   3742: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   3745: ldc_w 914
    //   3748: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3751: aload_0
    //   3752: invokevirtual 880	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3755: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3758: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3761: invokestatic 882	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3764: return
    //   3765: aload_2
    //   3766: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3769: sipush -2036
    //   3772: if_icmpne +48 -> 3820
    //   3775: aload_1
    //   3776: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3779: aload_2
    //   3780: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3783: aload_2
    //   3784: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3787: aload_2
    //   3788: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3791: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3794: checkcast 916	com/tencent/mobileqq/data/MessageForTroopFee
    //   3797: astore_0
    //   3798: aload_0
    //   3799: ifnull -3795 -> 4
    //   3802: aload_0
    //   3803: invokevirtual 917	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3806: aconst_null
    //   3807: aload_0
    //   3808: getfield 918	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3811: aconst_null
    //   3812: iconst_0
    //   3813: iconst_0
    //   3814: aload 4
    //   3816: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3819: return
    //   3820: aload_2
    //   3821: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3824: sipush -2069
    //   3827: if_icmpne +48 -> 3875
    //   3830: aload_1
    //   3831: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3834: aload_2
    //   3835: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3838: aload_2
    //   3839: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3842: aload_2
    //   3843: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3846: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3849: checkcast 920	com/tencent/mobileqq/data/MessageForStarLeague
    //   3852: astore_0
    //   3853: aload_0
    //   3854: ifnull -3850 -> 4
    //   3857: aload_0
    //   3858: invokevirtual 921	com/tencent/mobileqq/data/MessageForStarLeague:parse	()V
    //   3861: aconst_null
    //   3862: aload_0
    //   3863: getfield 922	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   3866: aconst_null
    //   3867: iconst_0
    //   3868: iconst_0
    //   3869: aload 4
    //   3871: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3874: return
    //   3875: aload_2
    //   3876: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3879: sipush -2048
    //   3882: if_icmpne +49 -> 3931
    //   3885: aload_1
    //   3886: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3889: aload_2
    //   3890: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3893: aload_2
    //   3894: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3897: aload_2
    //   3898: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3901: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3904: checkcast 924	com/tencent/mobileqq/data/MessageForTroopReward
    //   3907: astore_0
    //   3908: aload_0
    //   3909: ifnull -3905 -> 4
    //   3912: aload_0
    //   3913: invokevirtual 925	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3916: aload 19
    //   3918: aload_0
    //   3919: getfield 926	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3922: aconst_null
    //   3923: iconst_0
    //   3924: iconst_0
    //   3925: aload 4
    //   3927: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3930: return
    //   3931: aload_2
    //   3932: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3935: iconst_1
    //   3936: if_icmpne +130 -> 4066
    //   3939: aload_2
    //   3940: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   3943: sipush -3006
    //   3946: if_icmpne +120 -> 4066
    //   3949: aload_1
    //   3950: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3953: aload_2
    //   3954: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   3957: aload_2
    //   3958: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   3961: aload_2
    //   3962: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   3965: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3968: checkcast 928	com/tencent/mobileqq/data/MessageForPubAccount
    //   3971: astore_0
    //   3972: aload_0
    //   3973: ifnull -3969 -> 4
    //   3976: aload_0
    //   3977: invokevirtual 929	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   3980: aload_1
    //   3981: aload_0
    //   3982: iconst_0
    //   3983: invokestatic 933	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   3986: astore 5
    //   3988: aload_0
    //   3989: invokevirtual 936	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   3992: ifne +60 -> 4052
    //   3995: aconst_null
    //   3996: astore_0
    //   3997: aload_0
    //   3998: astore_1
    //   3999: aload_2
    //   4000: getfield 568	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   4003: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4006: ifne +34 -> 4040
    //   4009: aload_0
    //   4010: astore_1
    //   4011: aload_0
    //   4012: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4015: ifne +25 -> 4040
    //   4018: new 173	java/lang/StringBuilder
    //   4021: dup
    //   4022: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   4025: aload_2
    //   4026: getfield 568	com/tencent/imcore/message/Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   4029: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4032: aload_0
    //   4033: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4036: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4039: astore_1
    //   4040: aload_1
    //   4041: aload 5
    //   4043: aconst_null
    //   4044: iconst_0
    //   4045: iconst_0
    //   4046: aload 4
    //   4048: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4051: return
    //   4052: aload_1
    //   4053: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4056: ldc_w 937
    //   4059: invokevirtual 171	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4062: astore_0
    //   4063: goto -66 -> 3997
    //   4066: aload_2
    //   4067: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4070: sipush -1034
    //   4073: if_icmpne +106 -> 4179
    //   4076: new 939	com/tencent/mobileqq/data/MessageForRichState
    //   4079: dup
    //   4080: invokespecial 940	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   4083: astore_0
    //   4084: aload_0
    //   4085: aload_2
    //   4086: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   4089: putfield 941	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   4092: aload_0
    //   4093: invokevirtual 942	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   4096: new 173	java/lang/StringBuilder
    //   4099: dup
    //   4100: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   4103: astore_1
    //   4104: aload_0
    //   4105: getfield 945	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4108: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4111: ifne +38 -> 4149
    //   4114: aload_1
    //   4115: aload_0
    //   4116: getfield 945	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4119: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4122: pop
    //   4123: aload_0
    //   4124: getfield 948	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4127: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4130: ifne +12 -> 4142
    //   4133: aload_1
    //   4134: aload_0
    //   4135: getfield 948	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4138: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4141: pop
    //   4142: aload_1
    //   4143: bipush 32
    //   4145: invokevirtual 951	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   4148: pop
    //   4149: aload_1
    //   4150: aload_0
    //   4151: invokevirtual 954	com/tencent/mobileqq/data/MessageForRichState:getPlainMsg	()Ljava/lang/String;
    //   4154: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4157: pop
    //   4158: aload_1
    //   4159: invokevirtual 955	java/lang/StringBuilder:length	()I
    //   4162: ifle -4158 -> 4
    //   4165: aconst_null
    //   4166: aload_1
    //   4167: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4170: aconst_null
    //   4171: iconst_0
    //   4172: iconst_0
    //   4173: aload 4
    //   4175: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4178: return
    //   4179: aload_2
    //   4180: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4183: sipush -2074
    //   4186: if_icmpne +47 -> 4233
    //   4189: new 957	com/tencent/mobileqq/data/MessageForAIOStoryVideo
    //   4192: dup
    //   4193: invokespecial 958	com/tencent/mobileqq/data/MessageForAIOStoryVideo:<init>	()V
    //   4196: astore_0
    //   4197: aload_0
    //   4198: aload_2
    //   4199: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   4202: putfield 959	com/tencent/mobileqq/data/MessageForAIOStoryVideo:msg	Ljava/lang/String;
    //   4205: aload_0
    //   4206: invokevirtual 960	com/tencent/mobileqq/data/MessageForAIOStoryVideo:parse	()V
    //   4209: aload_0
    //   4210: getfield 963	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4213: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4216: ifne -4212 -> 4
    //   4219: aconst_null
    //   4220: aload_0
    //   4221: getfield 963	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4224: aconst_null
    //   4225: iconst_0
    //   4226: iconst_0
    //   4227: aload 4
    //   4229: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4232: return
    //   4233: aload_2
    //   4234: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4237: sipush -1019
    //   4240: if_icmpne +48 -> 4288
    //   4243: aconst_null
    //   4244: aconst_null
    //   4245: new 173	java/lang/StringBuilder
    //   4248: dup
    //   4249: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   4252: ldc_w 964
    //   4255: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   4258: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4261: aload_2
    //   4262: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   4265: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4268: ldc_w 965
    //   4271: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   4274: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4277: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4280: iconst_0
    //   4281: iconst_0
    //   4282: aload 4
    //   4284: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4287: return
    //   4288: aload_2
    //   4289: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4292: sipush -1018
    //   4295: if_icmpne +48 -> 4343
    //   4298: aconst_null
    //   4299: aconst_null
    //   4300: new 173	java/lang/StringBuilder
    //   4303: dup
    //   4304: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   4307: ldc_w 966
    //   4310: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   4313: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4316: aload_2
    //   4317: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   4320: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4323: ldc_w 967
    //   4326: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   4329: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4332: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4335: iconst_0
    //   4336: iconst_0
    //   4337: aload 4
    //   4339: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4342: return
    //   4343: aload_2
    //   4344: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4347: sipush -2019
    //   4350: if_icmpne +16 -> 4366
    //   4353: aload 4
    //   4355: aload_0
    //   4356: ldc_w 968
    //   4359: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   4362: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4365: return
    //   4366: aload_2
    //   4367: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4370: sipush -7006
    //   4373: if_icmpne +16 -> 4389
    //   4376: aload 4
    //   4378: aload_0
    //   4379: ldc_w 969
    //   4382: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   4385: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4388: return
    //   4389: aload_2
    //   4390: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4393: sipush -1026
    //   4396: if_icmpne +16 -> 4412
    //   4399: aload 4
    //   4401: aload_0
    //   4402: ldc_w 970
    //   4405: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   4408: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4411: return
    //   4412: aload_2
    //   4413: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4416: sipush -1027
    //   4419: if_icmpne +16 -> 4435
    //   4422: aload 4
    //   4424: aload_0
    //   4425: ldc_w 971
    //   4428: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   4431: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4434: return
    //   4435: aload_2
    //   4436: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4439: sipush -2005
    //   4442: if_icmpne +62 -> 4504
    //   4445: aload_1
    //   4446: aload_2
    //   4447: invokestatic 974	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   4450: astore 5
    //   4452: aload_1
    //   4453: aload_2
    //   4454: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   4457: istore 6
    //   4459: aload_1
    //   4460: aload_2
    //   4461: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   4464: istore 7
    //   4466: aload 19
    //   4468: aload_0
    //   4469: ldc_w 975
    //   4472: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   4475: aconst_null
    //   4476: iload 6
    //   4478: iload 7
    //   4480: aload 4
    //   4482: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4485: aload 5
    //   4487: ifnull +10 -> 4497
    //   4490: aload 4
    //   4492: aload 5
    //   4494: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4497: aload 4
    //   4499: iconst_0
    //   4500: putfield 978	com/tencent/mobileqq/activity/recent/MsgSummary:nState	I
    //   4503: return
    //   4504: aload_2
    //   4505: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4508: sipush -3017
    //   4511: if_icmpne +146 -> 4657
    //   4514: aload_1
    //   4515: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4518: aload_2
    //   4519: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4522: aload_2
    //   4523: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   4526: aload_2
    //   4527: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   4530: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4533: astore 5
    //   4535: aload 5
    //   4537: ifnull +3337 -> 7874
    //   4540: aload 5
    //   4542: instanceof 980
    //   4545: ifeq +3329 -> 7874
    //   4548: aload 5
    //   4550: checkcast 980	com/tencent/mobileqq/data/MessageForDLFile
    //   4553: astore 5
    //   4555: aload 5
    //   4557: getfield 983	com/tencent/mobileqq/data/MessageForDLFile:fileName	Ljava/lang/String;
    //   4560: invokestatic 985	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   4563: invokestatic 986	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(I)Ljava/lang/String;
    //   4566: astore 16
    //   4568: new 173	java/lang/StringBuilder
    //   4571: dup
    //   4572: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   4575: ldc_w 988
    //   4578: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4581: aload 16
    //   4583: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4586: ldc_w 990
    //   4589: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4592: aload 5
    //   4594: getfield 983	com/tencent/mobileqq/data/MessageForDLFile:fileName	Ljava/lang/String;
    //   4597: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4600: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4603: astore 5
    //   4605: aload_1
    //   4606: aload_2
    //   4607: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   4610: istore 6
    //   4612: aload_1
    //   4613: aload_2
    //   4614: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   4617: istore 7
    //   4619: aload 19
    //   4621: aload_0
    //   4622: ldc_w 975
    //   4625: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   4628: aconst_null
    //   4629: iload 6
    //   4631: iload 7
    //   4633: aload 4
    //   4635: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4638: aload 5
    //   4640: ifnull +10 -> 4650
    //   4643: aload 4
    //   4645: aload 5
    //   4647: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4650: aload 4
    //   4652: iconst_0
    //   4653: putfield 978	com/tencent/mobileqq/activity/recent/MsgSummary:nState	I
    //   4656: return
    //   4657: aload_2
    //   4658: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4661: sipush -2022
    //   4664: if_icmpeq +13 -> 4677
    //   4667: aload_2
    //   4668: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   4671: sipush -2071
    //   4674: if_icmpne +624 -> 5298
    //   4677: iconst_0
    //   4678: istore 10
    //   4680: aload_1
    //   4681: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4684: aload_2
    //   4685: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4688: aload_2
    //   4689: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   4692: aload_2
    //   4693: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   4696: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4699: astore 5
    //   4701: aload 5
    //   4703: instanceof 992
    //   4706: ifeq -4702 -> 4
    //   4709: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4712: ifeq +33 -> 4745
    //   4715: ldc_w 503
    //   4718: iconst_2
    //   4719: new 173	java/lang/StringBuilder
    //   4722: dup
    //   4723: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   4726: ldc_w 994
    //   4729: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4732: aload_2
    //   4733: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   4736: invokevirtual 521	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4739: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4742: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4745: aload 5
    //   4747: checkcast 992	com/tencent/mobileqq/data/MessageForShortVideo
    //   4750: astore 16
    //   4752: aload 16
    //   4754: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4757: sipush 1005
    //   4760: if_icmpeq +52 -> 4812
    //   4763: aload_2
    //   4764: getfield 998	com/tencent/imcore/message/Message:extraflag	I
    //   4767: ldc_w 669
    //   4770: if_icmpeq +42 -> 4812
    //   4773: aload 16
    //   4775: getfield 1001	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4778: ifne +14 -> 4792
    //   4781: aload 16
    //   4783: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4786: sipush 1004
    //   4789: if_icmpeq +23 -> 4812
    //   4792: aload 16
    //   4794: getfield 1001	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4797: iconst_1
    //   4798: if_icmpne +3070 -> 7868
    //   4801: aload 16
    //   4803: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4806: sipush 1004
    //   4809: if_icmpne +3059 -> 7868
    //   4812: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4815: ifeq +13 -> 4828
    //   4818: ldc_w 503
    //   4821: iconst_2
    //   4822: ldc_w 1003
    //   4825: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4828: iconst_1
    //   4829: istore 6
    //   4831: aload_2
    //   4832: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4835: astore 5
    //   4837: aload_2
    //   4838: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   4841: aload_2
    //   4842: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   4845: invokestatic 616	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   4848: ifeq +3017 -> 7865
    //   4851: aload_2
    //   4852: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   4855: astore 5
    //   4857: aload_1
    //   4858: ldc_w 618
    //   4861: invokevirtual 622	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   4864: checkcast 618	com/tencent/mobileqq/transfile/api/ITransFileController
    //   4867: aload 5
    //   4869: aload_2
    //   4870: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   4873: invokeinterface 626 4 0
    //   4878: astore_1
    //   4879: iload 6
    //   4881: istore 7
    //   4883: aload 16
    //   4885: getfield 1006	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4888: ifnull +146 -> 5034
    //   4891: iload 6
    //   4893: istore 7
    //   4895: ldc 131
    //   4897: aload 16
    //   4899: getfield 1006	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4902: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4905: ifne +129 -> 5034
    //   4908: iload 6
    //   4910: istore 7
    //   4912: aload_2
    //   4913: invokevirtual 320	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   4916: ifeq +118 -> 5034
    //   4919: iload 6
    //   4921: istore 7
    //   4923: aload_1
    //   4924: ifnonnull +110 -> 5034
    //   4927: iload 6
    //   4929: istore 7
    //   4931: aload 16
    //   4933: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4936: sipush 1003
    //   4939: if_icmpeq +95 -> 5034
    //   4942: iload 6
    //   4944: istore 7
    //   4946: aload 16
    //   4948: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4951: sipush 1004
    //   4954: if_icmpeq +80 -> 5034
    //   4957: iload 6
    //   4959: istore 7
    //   4961: aload 16
    //   4963: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4966: sipush 2003
    //   4969: if_icmpeq +65 -> 5034
    //   4972: iload 6
    //   4974: istore 7
    //   4976: aload 16
    //   4978: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4981: sipush 2009
    //   4984: if_icmpeq +50 -> 5034
    //   4987: iload 6
    //   4989: istore 7
    //   4991: aload 16
    //   4993: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4996: sipush 2002
    //   4999: if_icmpeq +35 -> 5034
    //   5002: iload 6
    //   5004: istore 7
    //   5006: aload 16
    //   5008: getfield 1009	com/tencent/mobileqq/data/MessageForShortVideo:isAllowAutoDown	Z
    //   5011: iconst_1
    //   5012: if_icmpne +22 -> 5034
    //   5015: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5018: ifeq +13 -> 5031
    //   5021: ldc_w 503
    //   5024: iconst_2
    //   5025: ldc_w 1011
    //   5028: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5031: iconst_1
    //   5032: istore 7
    //   5034: iload 7
    //   5036: istore 6
    //   5038: iload 10
    //   5040: istore 7
    //   5042: aload_2
    //   5043: invokevirtual 320	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   5046: ifeq +81 -> 5127
    //   5049: aload 16
    //   5051: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5054: sipush 1001
    //   5057: if_icmpeq +51 -> 5108
    //   5060: aload 16
    //   5062: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5065: sipush 1002
    //   5068: if_icmpeq +40 -> 5108
    //   5071: aload 16
    //   5073: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5076: sipush 998
    //   5079: if_icmpeq +29 -> 5108
    //   5082: aload 16
    //   5084: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5087: sipush 999
    //   5090: if_icmpeq +18 -> 5108
    //   5093: iload 10
    //   5095: istore 7
    //   5097: aload 16
    //   5099: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5102: sipush 1000
    //   5105: if_icmpne +22 -> 5127
    //   5108: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5111: ifeq +13 -> 5124
    //   5114: ldc_w 503
    //   5117: iconst_2
    //   5118: ldc_w 1013
    //   5121: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5124: iconst_1
    //   5125: istore 7
    //   5127: aload 16
    //   5129: getfield 1001	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   5132: iconst_2
    //   5133: if_icmpne +141 -> 5274
    //   5136: aload_0
    //   5137: ldc_w 1014
    //   5140: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   5143: astore_0
    //   5144: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5147: ifeq +101 -> 5248
    //   5150: ldc_w 503
    //   5153: iconst_2
    //   5154: new 173	java/lang/StringBuilder
    //   5157: dup
    //   5158: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   5161: ldc_w 1016
    //   5164: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5167: aload 16
    //   5169: getfield 1006	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   5172: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5175: ldc_w 1018
    //   5178: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5181: aload 16
    //   5183: getfield 997	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5186: invokevirtual 497	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5189: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5192: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5195: aload_1
    //   5196: ifnonnull +89 -> 5285
    //   5199: ldc_w 503
    //   5202: iconst_2
    //   5203: ldc_w 1020
    //   5206: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5209: ldc_w 503
    //   5212: iconst_2
    //   5213: new 173	java/lang/StringBuilder
    //   5216: dup
    //   5217: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   5220: ldc_w 1022
    //   5223: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5226: iload 6
    //   5228: invokevirtual 1025	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5231: ldc_w 1027
    //   5234: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5237: iload 7
    //   5239: invokevirtual 1025	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5242: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5245: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5248: aload 19
    //   5250: aload_0
    //   5251: aconst_null
    //   5252: iload 6
    //   5254: iload 7
    //   5256: aload 4
    //   5258: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5261: return
    //   5262: astore 5
    //   5264: aconst_null
    //   5265: astore_1
    //   5266: aload 5
    //   5268: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   5271: goto -233 -> 5038
    //   5274: aload_0
    //   5275: ldc_w 1028
    //   5278: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   5281: astore_0
    //   5282: goto -138 -> 5144
    //   5285: ldc_w 503
    //   5288: iconst_2
    //   5289: ldc_w 1030
    //   5292: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5295: goto -86 -> 5209
    //   5298: aload_2
    //   5299: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5302: sipush -5002
    //   5305: if_icmpne +40 -> 5345
    //   5308: new 1032	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   5311: dup
    //   5312: invokespecial 1033	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   5315: astore_0
    //   5316: aload_0
    //   5317: aload_2
    //   5318: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   5321: putfield 1034	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   5324: aload_0
    //   5325: invokevirtual 1035	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   5328: aload_0
    //   5329: getfield 1036	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5332: ifnull -5328 -> 4
    //   5335: aload 4
    //   5337: aload_0
    //   5338: getfield 1036	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5341: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5344: return
    //   5345: aload_2
    //   5346: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5349: sipush -2029
    //   5352: if_icmpne +145 -> 5497
    //   5355: aload_1
    //   5356: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5359: aload_2
    //   5360: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   5363: aload_2
    //   5364: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   5367: aload_2
    //   5368: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   5371: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5374: astore_0
    //   5375: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5378: ifeq +30 -> 5408
    //   5381: ldc_w 503
    //   5384: iconst_2
    //   5385: new 173	java/lang/StringBuilder
    //   5388: dup
    //   5389: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   5392: ldc_w 1038
    //   5395: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5398: aload_0
    //   5399: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5402: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5405: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5408: aload_0
    //   5409: instanceof 1040
    //   5412: ifeq -5408 -> 4
    //   5415: aload_0
    //   5416: checkcast 1040	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   5419: astore_0
    //   5420: aload_0
    //   5421: aload_2
    //   5422: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   5425: putfield 1041	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   5428: aload_0
    //   5429: invokevirtual 1042	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   5432: aload_0
    //   5433: aload_1
    //   5434: aload_1
    //   5435: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5438: aconst_null
    //   5439: invokevirtual 1046	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   5442: aload_0
    //   5443: getfield 1048	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5446: ifnull -5442 -> 4
    //   5449: aload_0
    //   5450: getfield 1051	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   5453: iconst_1
    //   5454: if_icmpne +33 -> 5487
    //   5457: aload_0
    //   5458: new 173	java/lang/StringBuilder
    //   5461: dup
    //   5462: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   5465: ldc_w 1052
    //   5468: invokestatic 434	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   5471: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5474: aload_0
    //   5475: getfield 1048	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5478: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5481: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5484: putfield 1048	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5487: aload 4
    //   5489: aload_0
    //   5490: getfield 1048	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5493: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5496: return
    //   5497: aload_2
    //   5498: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5501: sipush -2025
    //   5504: if_icmpeq +13 -> 5517
    //   5507: aload_2
    //   5508: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5511: sipush -2072
    //   5514: if_icmpne +13 -> 5527
    //   5517: aload 4
    //   5519: aload_2
    //   5520: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   5523: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5526: return
    //   5527: aload_2
    //   5528: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5531: sipush -2076
    //   5534: if_icmpne +58 -> 5592
    //   5537: new 1054	com/tencent/mobileqq/data/MessageForLocationShare
    //   5540: dup
    //   5541: invokespecial 1055	com/tencent/mobileqq/data/MessageForLocationShare:<init>	()V
    //   5544: astore_1
    //   5545: aload_1
    //   5546: aload_2
    //   5547: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   5550: putfield 1056	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   5553: aload_1
    //   5554: invokevirtual 1057	com/tencent/mobileqq/data/MessageForLocationShare:parse	()V
    //   5557: aload_1
    //   5558: getfield 1058	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   5561: astore_2
    //   5562: aload_2
    //   5563: astore_1
    //   5564: aload_2
    //   5565: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5568: ifeq +11 -> 5579
    //   5571: aload_0
    //   5572: ldc_w 1059
    //   5575: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   5578: astore_1
    //   5579: aload 19
    //   5581: ldc 131
    //   5583: aload_1
    //   5584: iconst_0
    //   5585: iconst_0
    //   5586: aload 4
    //   5588: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5591: return
    //   5592: aload_2
    //   5593: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5596: sipush -2052
    //   5599: if_icmpne +75 -> 5674
    //   5602: aload_2
    //   5603: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   5606: astore_0
    //   5607: aload_2
    //   5608: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   5611: aload_2
    //   5612: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   5615: invokestatic 616	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   5618: ifeq +8 -> 5626
    //   5621: aload_2
    //   5622: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   5625: astore_0
    //   5626: aload_1
    //   5627: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5630: aload_0
    //   5631: aload_2
    //   5632: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   5635: aload_2
    //   5636: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   5639: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5642: astore_0
    //   5643: aload_0
    //   5644: instanceof 1061
    //   5647: ifeq -5643 -> 4
    //   5650: aload_0
    //   5651: checkcast 1061	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   5654: astore_0
    //   5655: aload_0
    //   5656: invokevirtual 1062	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   5659: aload 19
    //   5661: aload_0
    //   5662: invokevirtual 1063	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   5665: aconst_null
    //   5666: iconst_0
    //   5667: iconst_0
    //   5668: aload 4
    //   5670: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5673: return
    //   5674: aload_2
    //   5675: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5678: sipush -2047
    //   5681: if_icmpne +51 -> 5732
    //   5684: new 1065	com/tencent/mobileqq/data/MessageForVIPDonate
    //   5687: dup
    //   5688: invokespecial 1066	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   5691: astore_0
    //   5692: aload_0
    //   5693: aload_2
    //   5694: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   5697: putfield 1067	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   5700: aload_0
    //   5701: invokevirtual 1068	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   5704: aload_0
    //   5705: invokevirtual 1069	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   5708: astore_0
    //   5709: aload_0
    //   5710: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5713: ifne +10 -> 5723
    //   5716: aload 4
    //   5718: aload_0
    //   5719: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5722: return
    //   5723: aload 4
    //   5725: ldc_w 1071
    //   5728: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5731: return
    //   5732: aload_2
    //   5733: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5736: sipush -2040
    //   5739: if_icmpne +29 -> 5768
    //   5742: new 1073	com/tencent/mobileqq/data/MessageForApproval
    //   5745: dup
    //   5746: invokespecial 1074	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   5749: astore_0
    //   5750: aload_0
    //   5751: aload_2
    //   5752: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   5755: putfield 1075	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   5758: aload 4
    //   5760: aload_0
    //   5761: invokevirtual 1078	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   5764: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5767: return
    //   5768: aload_2
    //   5769: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5772: sipush -2041
    //   5775: if_icmpne +49 -> 5824
    //   5778: aload_0
    //   5779: ldc_w 1079
    //   5782: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   5785: astore_1
    //   5786: aload_0
    //   5787: ldc_w 1080
    //   5790: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   5793: astore_0
    //   5794: aload 4
    //   5796: new 173	java/lang/StringBuilder
    //   5799: dup
    //   5800: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   5803: aload_1
    //   5804: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5807: ldc_w 535
    //   5810: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5813: aload_0
    //   5814: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5817: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5820: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5823: return
    //   5824: aload_2
    //   5825: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   5828: sipush -7001
    //   5831: if_icmpne +157 -> 5988
    //   5834: aload_2
    //   5835: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   5838: astore 5
    //   5840: aload_2
    //   5841: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   5844: aload_2
    //   5845: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   5848: invokestatic 616	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Z
    //   5851: ifeq +9 -> 5860
    //   5854: aload_2
    //   5855: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   5858: astore 5
    //   5860: aload_1
    //   5861: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5864: aload 5
    //   5866: aload_2
    //   5867: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   5870: aload_2
    //   5871: getfield 40	com/tencent/imcore/message/Message:uniseq	J
    //   5874: invokevirtual 305	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5877: checkcast 1082	com/tencent/mobileqq/data/MessageForScribble
    //   5880: astore_1
    //   5881: aload_1
    //   5882: invokevirtual 1083	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   5885: ifeq +56 -> 5941
    //   5888: aload_1
    //   5889: getfield 1086	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5892: istore_3
    //   5893: iload_3
    //   5894: iconst_2
    //   5895: if_icmpne +29 -> 5924
    //   5898: iconst_1
    //   5899: istore 7
    //   5901: iconst_0
    //   5902: istore 6
    //   5904: aload 19
    //   5906: aload_0
    //   5907: ldc_w 1087
    //   5910: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   5913: aconst_null
    //   5914: iload 7
    //   5916: iload 6
    //   5918: aload 4
    //   5920: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5923: return
    //   5924: aload_1
    //   5925: getfield 1086	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5928: iconst_3
    //   5929: if_icmpne +1927 -> 7856
    //   5932: iconst_1
    //   5933: istore 6
    //   5935: iconst_0
    //   5936: istore 7
    //   5938: goto -34 -> 5904
    //   5941: aload_1
    //   5942: getfield 1090	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   5945: iconst_2
    //   5946: if_icmpne +1910 -> 7856
    //   5949: aload_1
    //   5950: invokestatic 1095	com/tencent/mobileqq/scribble/ScribbleMsgUtils:a	(Lcom/tencent/mobileqq/data/MessageForScribble;)I
    //   5953: istore_3
    //   5954: getstatic 1097	com/tencent/mobileqq/scribble/ScribbleMsgUtils:c	I
    //   5957: istore 8
    //   5959: iload_3
    //   5960: iload 8
    //   5962: if_icmpeq +1894 -> 7856
    //   5965: iconst_1
    //   5966: istore 7
    //   5968: iconst_0
    //   5969: istore 6
    //   5971: goto -67 -> 5904
    //   5974: astore_1
    //   5975: aload_1
    //   5976: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   5979: iconst_0
    //   5980: istore 6
    //   5982: iconst_0
    //   5983: istore 7
    //   5985: goto -81 -> 5904
    //   5988: aload_1
    //   5989: aload_2
    //   5990: invokestatic 1100	com/tencent/mobileqq/mutualmark/oldlogic/ReactivePushHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   5993: ifeq +18 -> 6011
    //   5996: aload 19
    //   5998: aload_2
    //   5999: invokevirtual 1104	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   6002: aconst_null
    //   6003: iconst_0
    //   6004: iconst_0
    //   6005: aload 4
    //   6007: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6010: return
    //   6011: aload_2
    //   6012: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   6015: ifnonnull +11 -> 6026
    //   6018: aload 4
    //   6020: ldc 131
    //   6022: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6025: return
    //   6026: aload_2
    //   6027: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6030: sipush -5003
    //   6033: if_icmpne +13 -> 6046
    //   6036: aload 4
    //   6038: aload_2
    //   6039: invokevirtual 1104	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   6042: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6045: return
    //   6046: aload_2
    //   6047: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6050: sipush -2033
    //   6053: if_icmpne +16 -> 6069
    //   6056: aconst_null
    //   6057: getstatic 1109	com/tencent/mobileqq/data/ShareHotChatGrayTips:SHARE_GRAY_TIP_CONTENT	Ljava/lang/String;
    //   6060: aconst_null
    //   6061: iconst_0
    //   6062: iconst_0
    //   6063: aload 4
    //   6065: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6068: return
    //   6069: aload_2
    //   6070: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6073: sipush -2049
    //   6076: if_icmpne +16 -> 6092
    //   6079: aload 4
    //   6081: aload_2
    //   6082: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   6085: invokestatic 582	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6088: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6091: return
    //   6092: aload_2
    //   6093: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6096: sipush -1035
    //   6099: if_icmpne +308 -> 6407
    //   6102: iconst_0
    //   6103: istore 10
    //   6105: iconst_0
    //   6106: istore 11
    //   6108: iload 10
    //   6110: istore 6
    //   6112: iload 11
    //   6114: istore 7
    //   6116: aload_2
    //   6117: invokevirtual 320	com/tencent/imcore/message/Message:isSendFromLocal	()Z
    //   6120: ifeq +31 -> 6151
    //   6123: aload_2
    //   6124: getfield 998	com/tencent/imcore/message/Message:extraflag	I
    //   6127: ldc_w 1110
    //   6130: if_icmpne +192 -> 6322
    //   6133: aload_1
    //   6134: invokevirtual 1114	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   6137: aload_2
    //   6138: invokevirtual 1117	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6141: ifne +171 -> 6312
    //   6144: iconst_1
    //   6145: istore 6
    //   6147: iload 11
    //   6149: istore 7
    //   6151: aload_2
    //   6152: invokevirtual 1104	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   6155: astore_0
    //   6156: aload_2
    //   6157: invokestatic 1120	com/tencent/mobileqq/troop/utils/TroopRobotManager:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6160: ifeq +1693 -> 7853
    //   6163: aload_2
    //   6164: invokestatic 1122	com/tencent/mobileqq/troop/utils/TroopRobotManager:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6167: ifne +7 -> 6174
    //   6170: aload_2
    //   6171: invokestatic 1125	com/tencent/mobileqq/troop/utils/TroopRobotManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   6174: aload_2
    //   6175: invokestatic 1128	com/tencent/mobileqq/troop/utils/TroopRobotManager:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   6178: astore_1
    //   6179: aload_1
    //   6180: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6183: ifne +1670 -> 7853
    //   6186: aload_1
    //   6187: astore_0
    //   6188: aload_2
    //   6189: getfield 1131	com/tencent/imcore/message/Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   6192: ifnull +198 -> 6390
    //   6195: aload_0
    //   6196: ifnull +194 -> 6390
    //   6199: new 173	java/lang/StringBuilder
    //   6202: dup
    //   6203: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   6206: astore_1
    //   6207: aload 19
    //   6209: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6212: ifne +16 -> 6228
    //   6215: aload_1
    //   6216: aload 19
    //   6218: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6221: ldc_w 439
    //   6224: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6227: pop
    //   6228: aload 4
    //   6230: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6233: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6236: ifne +13 -> 6249
    //   6239: aload_1
    //   6240: aload 4
    //   6242: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6245: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6248: pop
    //   6249: aload_2
    //   6250: invokestatic 294	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6253: ifne +16 -> 6269
    //   6256: iload 6
    //   6258: ifeq +89 -> 6347
    //   6261: aload_1
    //   6262: ldc_w 801
    //   6265: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6268: pop
    //   6269: aload_0
    //   6270: instanceof 803
    //   6273: ifeq +90 -> 6363
    //   6276: aload_0
    //   6277: checkcast 803	com/tencent/mobileqq/text/QQText
    //   6280: aload_1
    //   6281: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6284: iconst_1
    //   6285: iconst_0
    //   6286: newarray int
    //   6288: invokevirtual 806	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   6291: astore_0
    //   6292: aload 4
    //   6294: iconst_1
    //   6295: putfield 821	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6298: aload 19
    //   6300: aload_0
    //   6301: aconst_null
    //   6302: iload 6
    //   6304: iload 7
    //   6306: aload 4
    //   6308: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6311: return
    //   6312: iconst_1
    //   6313: istore 7
    //   6315: iload 10
    //   6317: istore 6
    //   6319: goto -168 -> 6151
    //   6322: iconst_0
    //   6323: istore 7
    //   6325: aload_2
    //   6326: getfield 998	com/tencent/imcore/message/Message:extraflag	I
    //   6329: ldc_w 669
    //   6332: if_icmpne +9 -> 6341
    //   6335: iconst_1
    //   6336: istore 6
    //   6338: goto -187 -> 6151
    //   6341: iconst_0
    //   6342: istore 6
    //   6344: goto -6 -> 6338
    //   6347: iload 7
    //   6349: ifeq -80 -> 6269
    //   6352: aload_1
    //   6353: ldc_w 809
    //   6356: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6359: pop
    //   6360: goto -91 -> 6269
    //   6363: aload_1
    //   6364: aload_0
    //   6365: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6368: pop
    //   6369: new 1133	android/text/SpannableString
    //   6372: dup
    //   6373: aload_1
    //   6374: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6377: invokespecial 1136	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   6380: astore_0
    //   6381: aload 4
    //   6383: iconst_0
    //   6384: putfield 821	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6387: goto -89 -> 6298
    //   6390: aload 19
    //   6392: aload_0
    //   6393: invokestatic 1139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6396: aconst_null
    //   6397: iload 6
    //   6399: iload 7
    //   6401: aload 4
    //   6403: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6406: return
    //   6407: aload_2
    //   6408: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6411: sipush -2057
    //   6414: if_icmpne +17 -> 6431
    //   6417: aload 19
    //   6419: getstatic 1144	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   6422: aconst_null
    //   6423: iconst_0
    //   6424: iconst_0
    //   6425: aload 4
    //   6427: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6430: return
    //   6431: aload_2
    //   6432: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6435: sipush -1012
    //   6438: if_icmpne +79 -> 6517
    //   6441: aload_2
    //   6442: invokevirtual 1104	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   6445: astore_1
    //   6446: aload_1
    //   6447: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6450: ifne -6446 -> 4
    //   6453: aload_1
    //   6454: invokeinterface 1147 1 0
    //   6459: invokestatic 582	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6462: astore_1
    //   6463: aload_0
    //   6464: ldc_w 1148
    //   6467: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   6470: astore_2
    //   6471: aload_1
    //   6472: invokevirtual 217	java/lang/String:length	()I
    //   6475: aload_2
    //   6476: invokevirtual 217	java/lang/String:length	()I
    //   6479: isub
    //   6480: iconst_1
    //   6481: isub
    //   6482: istore_3
    //   6483: aload_1
    //   6484: astore_0
    //   6485: aload_1
    //   6486: aload_2
    //   6487: invokevirtual 135	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6490: ifeq +16 -> 6506
    //   6493: aload_1
    //   6494: astore_0
    //   6495: iload_3
    //   6496: ifle +10 -> 6506
    //   6499: aload_1
    //   6500: iconst_0
    //   6501: iload_3
    //   6502: invokevirtual 363	java/lang/String:substring	(II)Ljava/lang/String;
    //   6505: astore_0
    //   6506: aconst_null
    //   6507: aload_0
    //   6508: aconst_null
    //   6509: iconst_0
    //   6510: iconst_0
    //   6511: aload 4
    //   6513: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6516: return
    //   6517: aload_2
    //   6518: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6521: sipush -2059
    //   6524: if_icmpne +33 -> 6557
    //   6527: new 1150	com/tencent/mobileqq/data/MessageForTroopPobing
    //   6530: dup
    //   6531: invokespecial 1151	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   6534: astore_0
    //   6535: aload_0
    //   6536: aload_2
    //   6537: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   6540: putfield 1152	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   6543: aload_0
    //   6544: invokevirtual 1155	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   6547: aload 4
    //   6549: aload_0
    //   6550: invokevirtual 1156	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   6553: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6556: return
    //   6557: aload_2
    //   6558: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6561: sipush -2066
    //   6564: if_icmpne +87 -> 6651
    //   6567: new 1158	com/tencent/mobileqq/data/MessageForConfessCard
    //   6570: dup
    //   6571: invokespecial 1159	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   6574: astore_0
    //   6575: aload_0
    //   6576: aload_2
    //   6577: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   6580: putfield 1160	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   6583: aload_0
    //   6584: invokevirtual 1161	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   6587: aload_2
    //   6588: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   6591: sipush 1032
    //   6594: if_icmpne +18 -> 6612
    //   6597: aload 19
    //   6599: aload_0
    //   6600: getfield 1164	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6603: aconst_null
    //   6604: iconst_0
    //   6605: iconst_0
    //   6606: aload 4
    //   6608: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6611: return
    //   6612: ldc 131
    //   6614: new 173	java/lang/StringBuilder
    //   6617: dup
    //   6618: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   6621: aload 19
    //   6623: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6626: ldc_w 1166
    //   6629: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6632: aload_0
    //   6633: getfield 1164	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6636: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6639: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6642: aconst_null
    //   6643: iconst_0
    //   6644: iconst_0
    //   6645: aload 4
    //   6647: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6650: return
    //   6651: aload_2
    //   6652: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6655: sipush -2067
    //   6658: if_icmpne +38 -> 6696
    //   6661: new 1168	com/tencent/mobileqq/data/MessageForTroopConfess
    //   6664: dup
    //   6665: invokespecial 1169	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   6668: astore_0
    //   6669: aload_0
    //   6670: aload_2
    //   6671: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   6674: putfield 1170	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   6677: aload_0
    //   6678: invokevirtual 1171	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   6681: aload 19
    //   6683: aload_0
    //   6684: getfield 1172	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   6687: aconst_null
    //   6688: iconst_0
    //   6689: iconst_0
    //   6690: aload 4
    //   6692: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6695: return
    //   6696: aload_2
    //   6697: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6700: sipush -5008
    //   6703: if_icmpeq +23 -> 6726
    //   6706: aload_2
    //   6707: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6710: sipush -5016
    //   6713: if_icmpeq +13 -> 6726
    //   6716: aload_2
    //   6717: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6720: sipush -5017
    //   6723: if_icmpne +113 -> 6836
    //   6726: aload_2
    //   6727: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   6730: sipush -5016
    //   6733: if_icmpne +64 -> 6797
    //   6736: new 1174	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6739: dup
    //   6740: invokespecial 1175	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6743: astore_0
    //   6744: aload_0
    //   6745: aload_2
    //   6746: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   6749: putfield 1176	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6752: aload_0
    //   6753: invokevirtual 1177	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6756: aload 4
    //   6758: aload_0
    //   6759: invokevirtual 1180	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6762: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6765: aload_1
    //   6766: aload_2
    //   6767: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   6770: istore 6
    //   6772: aload_1
    //   6773: aload_2
    //   6774: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   6777: istore 7
    //   6779: aload 19
    //   6781: aload 4
    //   6783: getfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6786: aconst_null
    //   6787: iload 6
    //   6789: iload 7
    //   6791: aload 4
    //   6793: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6796: return
    //   6797: new 1182	com/tencent/mobileqq/data/MessageForArkApp
    //   6800: dup
    //   6801: invokespecial 1183	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6804: astore_0
    //   6805: aload_0
    //   6806: aload_2
    //   6807: getfield 782	com/tencent/imcore/message/Message:msgData	[B
    //   6810: putfield 1184	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6813: aload_0
    //   6814: invokevirtual 1185	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6817: aload 4
    //   6819: aload_0
    //   6820: invokevirtual 1186	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6823: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6826: aload_2
    //   6827: aload 4
    //   6829: aload_1
    //   6830: invokestatic 1189	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/imcore/message/Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   6833: goto -68 -> 6765
    //   6836: aload_1
    //   6837: aload_2
    //   6838: invokestatic 609	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   6841: istore 6
    //   6843: aload_1
    //   6844: aload_2
    //   6845: invokestatic 611	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;)Z
    //   6848: istore 7
    //   6850: aload_2
    //   6851: getfield 1192	com/tencent/imcore/message/Message:fileType	I
    //   6854: lookupswitch	default:+50->6904, 1:+194->7048, 2:+275->7129, 8:+275->7129, 65536:+176->7030, 65538:+257->7111
    //   6905: ldc_w 752
    //   6908: invokevirtual 755	com/tencent/imcore/message/Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   6911: astore 5
    //   6913: getstatic 759	com/tencent/mobileqq/emoticon/EmojiStickerManager:f	Z
    //   6916: ifeq +316 -> 7232
    //   6919: aload 5
    //   6921: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6924: ifne +308 -> 7232
    //   6927: aload_1
    //   6928: aload_2
    //   6929: aload 4
    //   6931: invokestatic 793	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   6934: astore_0
    //   6935: new 173	java/lang/StringBuilder
    //   6938: dup
    //   6939: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   6942: astore_1
    //   6943: aload 19
    //   6945: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6948: ifne +16 -> 6964
    //   6951: aload_1
    //   6952: aload 19
    //   6954: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6957: ldc_w 439
    //   6960: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6963: pop
    //   6964: aload 4
    //   6966: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6969: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6972: ifne +13 -> 6985
    //   6975: aload_1
    //   6976: aload 4
    //   6978: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6981: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6984: pop
    //   6985: aload_2
    //   6986: invokestatic 294	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6989: ifne +16 -> 7005
    //   6992: iload 6
    //   6994: ifeq +222 -> 7216
    //   6997: aload_1
    //   6998: ldc_w 801
    //   7001: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7004: pop
    //   7005: aload 19
    //   7007: aload_0
    //   7008: aload_1
    //   7009: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7012: iconst_1
    //   7013: iconst_0
    //   7014: newarray int
    //   7016: invokevirtual 806	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   7019: aconst_null
    //   7020: iload 6
    //   7022: iload 7
    //   7024: aload 4
    //   7026: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7029: return
    //   7030: aload 19
    //   7032: ldc 131
    //   7034: aload_2
    //   7035: getfield 577	com/tencent/imcore/message/Message:msg	Ljava/lang/String;
    //   7038: iload 6
    //   7040: iload 7
    //   7042: aload 4
    //   7044: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7047: return
    //   7048: aload_2
    //   7049: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   7052: sipush 1001
    //   7055: if_icmpeq +13 -> 7068
    //   7058: aload_2
    //   7059: getfield 47	com/tencent/imcore/message/Message:istroop	I
    //   7062: sipush 10002
    //   7065: if_icmpne +26 -> 7091
    //   7068: aload_2
    //   7069: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   7072: sipush -3001
    //   7075: if_icmpne +16 -> 7091
    //   7078: aload 4
    //   7080: aload_0
    //   7081: ldc_w 1193
    //   7084: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   7087: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7090: return
    //   7091: aload 19
    //   7093: aload_0
    //   7094: ldc_w 655
    //   7097: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   7100: aconst_null
    //   7101: iload 6
    //   7103: iload 7
    //   7105: aload 4
    //   7107: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7110: return
    //   7111: aload 19
    //   7113: aload_0
    //   7114: ldc_w 655
    //   7117: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   7120: aconst_null
    //   7121: iconst_0
    //   7122: iconst_0
    //   7123: aload 4
    //   7125: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7128: return
    //   7129: ldc_w 682
    //   7132: iconst_3
    //   7133: anewarray 4	java/lang/Object
    //   7136: dup
    //   7137: iconst_0
    //   7138: iload_3
    //   7139: invokestatic 710	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7142: aastore
    //   7143: dup
    //   7144: iconst_1
    //   7145: iload 6
    //   7147: invokestatic 687	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7150: aastore
    //   7151: dup
    //   7152: iconst_2
    //   7153: iload 7
    //   7155: invokestatic 687	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7158: aastore
    //   7159: invokestatic 692	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   7162: aload_0
    //   7163: ldc_w 672
    //   7166: invokevirtual 221	android/content/Context:getString	(I)Ljava/lang/String;
    //   7169: astore_0
    //   7170: aload_2
    //   7171: getfield 208	com/tencent/imcore/message/Message:senderuin	Ljava/lang/String;
    //   7174: aload_1
    //   7175: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7178: invokestatic 1198	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   7181: ifeq +22 -> 7203
    //   7184: iload_3
    //   7185: ifeq +18 -> 7203
    //   7188: aload 19
    //   7190: aload_0
    //   7191: ldc 131
    //   7193: iload 6
    //   7195: iload 7
    //   7197: aload 4
    //   7199: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7202: return
    //   7203: aload 19
    //   7205: aload_0
    //   7206: ldc 131
    //   7208: iconst_0
    //   7209: iconst_0
    //   7210: aload 4
    //   7212: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7215: return
    //   7216: iload 7
    //   7218: ifeq -213 -> 7005
    //   7221: aload_1
    //   7222: ldc_w 809
    //   7225: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7228: pop
    //   7229: goto -224 -> 7005
    //   7232: aload_2
    //   7233: invokevirtual 1104	com/tencent/imcore/message/Message:getMessageText	()Ljava/lang/CharSequence;
    //   7236: astore 5
    //   7238: aload_2
    //   7239: invokestatic 1120	com/tencent/mobileqq/troop/utils/TroopRobotManager:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7242: ifeq +608 -> 7850
    //   7245: aload_2
    //   7246: invokestatic 1122	com/tencent/mobileqq/troop/utils/TroopRobotManager:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7249: ifne +7 -> 7256
    //   7252: aload_2
    //   7253: invokestatic 1125	com/tencent/mobileqq/troop/utils/TroopRobotManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   7256: aload_2
    //   7257: invokestatic 1128	com/tencent/mobileqq/troop/utils/TroopRobotManager:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   7260: astore 16
    //   7262: aload 16
    //   7264: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7267: ifne +583 -> 7850
    //   7270: aload 16
    //   7272: astore 5
    //   7274: aload_2
    //   7275: getfield 1131	com/tencent/imcore/message/Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   7278: ifnull +403 -> 7681
    //   7281: aload 5
    //   7283: ifnull +398 -> 7681
    //   7286: new 173	java/lang/StringBuilder
    //   7289: dup
    //   7290: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   7293: astore_0
    //   7294: aload 19
    //   7296: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7299: ifne +16 -> 7315
    //   7302: aload_0
    //   7303: aload 19
    //   7305: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7308: ldc_w 439
    //   7311: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7314: pop
    //   7315: aload 4
    //   7317: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   7320: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7323: ifne +13 -> 7336
    //   7326: aload_0
    //   7327: aload 4
    //   7329: getfield 796	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   7332: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   7335: pop
    //   7336: aload_2
    //   7337: invokestatic 294	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7340: ifne +16 -> 7356
    //   7343: iload 6
    //   7345: ifeq +292 -> 7637
    //   7348: aload_0
    //   7349: ldc_w 801
    //   7352: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7355: pop
    //   7356: aload 5
    //   7358: instanceof 803
    //   7361: ifeq +292 -> 7653
    //   7364: aload 5
    //   7366: checkcast 803	com/tencent/mobileqq/text/QQText
    //   7369: aload_0
    //   7370: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7373: iconst_1
    //   7374: iconst_3
    //   7375: newarray int
    //   7377: dup
    //   7378: iconst_0
    //   7379: iconst_0
    //   7380: iastore
    //   7381: dup
    //   7382: iconst_1
    //   7383: bipush 16
    //   7385: iastore
    //   7386: dup
    //   7387: iconst_2
    //   7388: iconst_1
    //   7389: iastore
    //   7390: invokevirtual 806	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   7393: astore_0
    //   7394: aload 4
    //   7396: iconst_1
    //   7397: putfield 821	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7400: aload_2
    //   7401: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   7404: sipush -5040
    //   7407: if_icmpne +440 -> 7847
    //   7410: new 173	java/lang/StringBuilder
    //   7413: dup
    //   7414: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   7417: ldc_w 535
    //   7420: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7423: invokestatic 424	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7426: ldc_w 1199
    //   7429: invokevirtual 426	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   7432: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7435: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7438: astore 5
    //   7440: aload_0
    //   7441: invokeinterface 1147 1 0
    //   7446: astore 16
    //   7448: aload 16
    //   7450: ifnull +391 -> 7841
    //   7453: aload 16
    //   7455: aload 5
    //   7457: invokevirtual 1202	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7460: ifeq +381 -> 7841
    //   7463: aload 16
    //   7465: aload 5
    //   7467: ldc 131
    //   7469: invokevirtual 287	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   7472: astore 5
    //   7474: aload 5
    //   7476: astore_0
    //   7477: iload_3
    //   7478: ifne +77 -> 7555
    //   7481: aload_1
    //   7482: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7485: aload_2
    //   7486: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7489: iconst_0
    //   7490: invokevirtual 1205	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7493: astore 16
    //   7495: aload 5
    //   7497: astore_0
    //   7498: aload 16
    //   7500: instanceof 1207
    //   7503: ifeq +52 -> 7555
    //   7506: aload 5
    //   7508: astore_0
    //   7509: aload 16
    //   7511: checkcast 1207	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7514: getfield 1211	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   7517: ifnull +38 -> 7555
    //   7520: aload 5
    //   7522: astore_0
    //   7523: aload 16
    //   7525: checkcast 1207	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7528: getfield 1211	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   7531: getfield 1215	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   7534: invokestatic 1218	com/tencent/mobileqq/mutualmark/MutualMarkUtils:b	(I)Z
    //   7537: ifeq +18 -> 7555
    //   7540: aload_1
    //   7541: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7544: aload 5
    //   7546: invokeinterface 1147 1 0
    //   7551: invokestatic 1221	com/tencent/mobileqq/mutualmark/oldlogic/ReactivePushHelper:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    //   7554: astore_0
    //   7555: aload_2
    //   7556: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   7559: invokestatic 1222	com/tencent/imcore/message/MsgProxyUtils:d	(I)Z
    //   7562: ifeq +276 -> 7838
    //   7565: aload_1
    //   7566: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7569: aload_2
    //   7570: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7573: iload_3
    //   7574: invokevirtual 1205	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7577: astore_1
    //   7578: aload_1
    //   7579: ifnull +259 -> 7838
    //   7582: aload_1
    //   7583: instanceof 1207
    //   7586: ifeq +252 -> 7838
    //   7589: aload_1
    //   7590: checkcast 1207	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7593: getfield 1211	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   7596: ifnull +242 -> 7838
    //   7599: aload_1
    //   7600: checkcast 1207	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7603: getfield 1211	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   7606: getfield 1215	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   7609: ldc_w 1223
    //   7612: if_icmpne +226 -> 7838
    //   7615: aload_1
    //   7616: checkcast 1207	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7619: invokevirtual 1224	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:getSummaryMsg	()Ljava/lang/String;
    //   7622: astore_0
    //   7623: aload 19
    //   7625: aload_0
    //   7626: aconst_null
    //   7627: iload 6
    //   7629: iload 7
    //   7631: aload 4
    //   7633: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7636: return
    //   7637: iload 7
    //   7639: ifeq -283 -> 7356
    //   7642: aload_0
    //   7643: ldc_w 809
    //   7646: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7649: pop
    //   7650: goto -294 -> 7356
    //   7653: aload_0
    //   7654: aload 5
    //   7656: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   7659: pop
    //   7660: new 1133	android/text/SpannableString
    //   7663: dup
    //   7664: aload_0
    //   7665: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7668: invokespecial 1136	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   7671: astore_0
    //   7672: aload 4
    //   7674: iconst_0
    //   7675: putfield 821	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7678: goto -278 -> 7400
    //   7681: aload 5
    //   7683: ifnull +114 -> 7797
    //   7686: aload 5
    //   7688: invokeinterface 1147 1 0
    //   7693: invokevirtual 201	java/lang/String:trim	()Ljava/lang/String;
    //   7696: astore 5
    //   7698: getstatic 1227	com/tencent/mobileqq/app/AppConstants:SYSTEM_MSG_UIN	Ljava/lang/String;
    //   7701: aload_2
    //   7702: getfield 44	com/tencent/imcore/message/Message:frienduin	Ljava/lang/String;
    //   7705: invokevirtual 1230	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   7708: ifeq +124 -> 7832
    //   7711: aload 5
    //   7713: ifnull +119 -> 7832
    //   7716: aload 5
    //   7718: invokevirtual 217	java/lang/String:length	()I
    //   7721: ifle +111 -> 7832
    //   7724: aload_0
    //   7725: aload_1
    //   7726: aload 5
    //   7728: aload_2
    //   7729: invokestatic 1232	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/imcore/message/Message;)Ljava/lang/String;
    //   7732: astore_0
    //   7733: aload 19
    //   7735: aconst_null
    //   7736: aload_0
    //   7737: iload 6
    //   7739: aload_1
    //   7740: invokevirtual 1114	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   7743: aload_2
    //   7744: invokevirtual 1117	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7747: aload 4
    //   7749: invokestatic 603	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7752: aload_2
    //   7753: getfield 187	com/tencent/imcore/message/Message:msgtype	I
    //   7756: sipush -1000
    //   7759: if_icmpne +44 -> 7803
    //   7762: aload 4
    //   7764: getfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7767: ifnull +36 -> 7803
    //   7770: aload 4
    //   7772: new 803	com/tencent/mobileqq/text/QQText
    //   7775: dup
    //   7776: aload 4
    //   7778: getfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7781: iconst_1
    //   7782: bipush 16
    //   7784: invokespecial 1235	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   7787: putfield 587	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7790: aload 4
    //   7792: iconst_1
    //   7793: putfield 821	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7796: return
    //   7797: aconst_null
    //   7798: astore 5
    //   7800: goto -102 -> 7698
    //   7803: aload 4
    //   7805: iconst_0
    //   7806: putfield 821	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7809: return
    //   7810: astore 5
    //   7812: goto -2546 -> 5266
    //   7815: astore 16
    //   7817: goto -5205 -> 2612
    //   7820: astore 17
    //   7822: aload 16
    //   7824: astore_1
    //   7825: aload 17
    //   7827: astore 16
    //   7829: goto -7166 -> 663
    //   7832: aload 5
    //   7834: astore_0
    //   7835: goto -102 -> 7733
    //   7838: goto -215 -> 7623
    //   7841: aload_0
    //   7842: astore 5
    //   7844: goto -370 -> 7474
    //   7847: goto -292 -> 7555
    //   7850: goto -576 -> 7274
    //   7853: goto -1665 -> 6188
    //   7856: iconst_0
    //   7857: istore 6
    //   7859: iconst_0
    //   7860: istore 7
    //   7862: goto -1958 -> 5904
    //   7865: goto -3008 -> 4857
    //   7868: iconst_0
    //   7869: istore 6
    //   7871: goto -3040 -> 4831
    //   7874: ldc 131
    //   7876: astore 5
    //   7878: goto -3273 -> 4605
    //   7881: goto -4298 -> 3583
    //   7884: iconst_0
    //   7885: istore 6
    //   7887: goto -5533 -> 2354
    //   7890: goto -5613 -> 2277
    //   7893: aload 5
    //   7895: astore_0
    //   7896: goto -5959 -> 1937
    //   7899: iconst_0
    //   7900: istore 7
    //   7902: iconst_0
    //   7903: istore 6
    //   7905: goto -7037 -> 868
    //   7908: goto -7120 -> 788
    //   7911: aload_1
    //   7912: astore_0
    //   7913: goto -7343 -> 570
    //   7916: iconst_0
    //   7917: istore 6
    //   7919: goto -7407 -> 512
    //   7922: iconst_0
    //   7923: istore 6
    //   7925: goto -7476 -> 449
    //   7928: iconst_0
    //   7929: istore 6
    //   7931: goto -7521 -> 410
    //   7934: goto -7611 -> 323
    //   7937: iconst_0
    //   7938: istore 6
    //   7940: goto -7530 -> 410
    //   7943: iconst_1
    //   7944: istore_3
    //   7945: goto -6143 -> 1802
    //   7948: astore_1
    //   7949: aload 17
    //   7951: astore_0
    //   7952: goto -5929 -> 2023
    //   7955: iconst_0
    //   7956: istore 6
    //   7958: goto -5604 -> 2354
    //   7961: ldc2_w 48
    //   7964: lstore 14
    //   7966: goto -5532 -> 2434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7969	0	paramContext	Context
    //   0	7969	1	paramQQAppInterface	QQAppInterface
    //   0	7969	2	paramMessage	Message
    //   0	7969	3	paramInt	int
    //   0	7969	4	paramMsgSummary	MsgSummary
    //   0	7969	5	paramString	String
    //   0	7969	6	paramBoolean1	boolean
    //   0	7969	7	paramBoolean2	boolean
    //   120	5843	8	i	int
    //   1671	572	9	j	int
    //   695	5621	10	bool1	boolean
    //   2246	3902	11	bool2	boolean
    //   1611	593	12	bool3	boolean
    //   1618	596	13	bool4	boolean
    //   394	7571	14	l	long
    //   343	250	16	localObject1	Object
    //   659	5	16	localException1	Exception
    //   673	1637	16	localObject2	Object
    //   2608	9	16	localException2	Exception
    //   3630	3894	16	localObject3	Object
    //   7815	8	16	localException3	Exception
    //   7827	1	16	localException4	Exception
    //   301	2354	17	localObject4	Object
    //   7820	130	17	localException5	Exception
    //   292	1699	18	str1	String
    //   18	7716	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   297	323	659	java/lang/Exception
    //   323	345	659	java/lang/Exception
    //   1849	1878	2022	java/lang/Exception
    //   1878	1899	2022	java/lang/Exception
    //   1899	1906	2022	java/lang/Exception
    //   1911	1919	2022	java/lang/Exception
    //   1919	1935	2022	java/lang/Exception
    //   2011	2019	2022	java/lang/Exception
    //   2251	2277	2608	java/lang/Exception
    //   2277	2321	2608	java/lang/Exception
    //   2764	2799	2900	java/lang/Throwable
    //   2815	2865	2900	java/lang/Throwable
    //   2870	2895	2900	java/lang/Throwable
    //   4831	4857	5262	java/lang/Exception
    //   4857	4879	5262	java/lang/Exception
    //   5834	5840	5974	java/lang/Exception
    //   5840	5860	5974	java/lang/Exception
    //   5860	5893	5974	java/lang/Exception
    //   5924	5932	5974	java/lang/Exception
    //   5941	5959	5974	java/lang/Exception
    //   4883	4891	7810	java/lang/Exception
    //   4895	4908	7810	java/lang/Exception
    //   4912	4919	7810	java/lang/Exception
    //   4931	4942	7810	java/lang/Exception
    //   4946	4957	7810	java/lang/Exception
    //   4961	4972	7810	java/lang/Exception
    //   4976	4987	7810	java/lang/Exception
    //   4991	5002	7810	java/lang/Exception
    //   5006	5031	7810	java/lang/Exception
    //   2321	2335	7815	java/lang/Exception
    //   2547	2558	7815	java/lang/Exception
    //   2568	2584	7815	java/lang/Exception
    //   349	371	7820	java/lang/Exception
    //   374	381	7820	java/lang/Exception
    //   389	396	7820	java/lang/Exception
    //   592	603	7820	java/lang/Exception
    //   616	623	7820	java/lang/Exception
    //   626	635	7820	java/lang/Exception
    //   1627	1636	7948	java/lang/Exception
    //   1644	1652	7948	java/lang/Exception
    //   1656	1673	7948	java/lang/Exception
    //   1684	1691	7948	java/lang/Exception
    //   1717	1730	7948	java/lang/Exception
    //   1734	1740	7948	java/lang/Exception
    //   1744	1751	7948	java/lang/Exception
    //   1755	1769	7948	java/lang/Exception
    //   1773	1799	7948	java/lang/Exception
    //   1814	1820	7948	java/lang/Exception
    //   1824	1837	7948	java/lang/Exception
    //   1841	1849	7948	java/lang/Exception
    //   1961	1987	7948	java/lang/Exception
    //   1994	2001	7948	java/lang/Exception
    //   2058	2063	7948	java/lang/Exception
    //   2071	2079	7948	java/lang/Exception
    //   2083	2091	7948	java/lang/Exception
    //   2095	2108	7948	java/lang/Exception
    //   2112	2123	7948	java/lang/Exception
    //   2127	2137	7948	java/lang/Exception
    //   2141	2148	7948	java/lang/Exception
    //   2157	2165	7948	java/lang/Exception
    //   2169	2185	7948	java/lang/Exception
    //   2189	2195	7948	java/lang/Exception
    //   2199	2212	7948	java/lang/Exception
    //   2222	2230	7948	java/lang/Exception
    //   2362	2369	7948	java/lang/Exception
    //   2373	2378	7948	java/lang/Exception
    //   2382	2393	7948	java/lang/Exception
    //   2404	2410	7948	java/lang/Exception
    //   2414	2421	7948	java/lang/Exception
    //   2425	2434	7948	java/lang/Exception
    //   2438	2479	7948	java/lang/Exception
    //   2487	2495	7948	java/lang/Exception
    //   2499	2506	7948	java/lang/Exception
    //   2510	2517	7948	java/lang/Exception
    //   2521	2529	7948	java/lang/Exception
    //   2533	2546	7948	java/lang/Exception
    //   2616	2621	7948	java/lang/Exception
    //   2646	2652	7948	java/lang/Exception
    //   2656	2683	7948	java/lang/Exception
  }
  
  private static void a(Message paramMessage, MsgSummary paramMsgSummary, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessage.istroop == 10007) && (paramMessage.msgtype == -5008)) {
      paramMsgSummary.strContent += paramQQAppInterface.getApp().getString(2131692837);
    }
  }
  
  private static void a(Message paramMessage, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramMessage != null) && (1 == paramInt))
    {
      paramQQAppInterface = ContactUtils.f(paramQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
      if ((paramQQAppInterface != null) && (!TextUtils.equals(paramQQAppInterface, paramMessage.nickName)))
      {
        paramMessage.nickName = paramQQAppInterface;
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "processTroopNickName  nickname : " + paramQQAppInterface);
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
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = paramQQAppInterface.getMessageFacade().a().b().iterator();
    while (localIterator.hasNext()) {
      if (((ExtractMessageSummaryCallback)localIterator.next()).a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, paramString, paramBoolean1, paramBoolean2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage)
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
        i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (!paramMessage.isSelfConfessor()) {
            break label103;
          }
        }
      }
    }
    label103:
    for (int i = 1033;; i = 1034)
    {
      localMessage = paramQQAppInterface.getMessageFacade().a(paramMessage.senderuin, i);
      if (localMessage.msgtype != -2005) {
        break label112;
      }
      if (2 != a(paramQQAppInterface, localMessage)) {
        break;
      }
      return true;
    }
    return false;
    label112:
    if (localMessage.msgtype == -2017)
    {
      paramMessage = paramQQAppInterface.getMessageFacade().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && ((paramMessage instanceof MessageForTroopFile)))
      {
        paramMessage = (MessageForTroopFile)paramMessage;
        if ((paramMessage != null) && (paramMessage.frienduin != null))
        {
          paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.b == 1) || (paramQQAppInterface.b == 0))) {
            return true;
          }
        }
      }
      return false;
    }
    paramMessage = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof BuddyTransfileProcessor)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((BuddyTransfileProcessor)paramMessage).getProgress() >= 0) && (((BuddyTransfileProcessor)paramMessage).getProgress() != 100)) {
      return true;
    }
    return paramQQAppInterface.getMsgCache().b(localMessage);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramMessageForPic.isMultiMsg) {}
    while (!paramMessageForPic.isSendFromLocal()) {
      return false;
    }
    if (paramMessageForPic.size <= 0L)
    {
      paramQQAppInterface = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
      if ((paramQQAppInterface instanceof BaseTransProcessor))
      {
        long l = ((BaseTransProcessor)paramQQAppInterface).getFileStatus();
        if ((l == 1005L) || ((l == 1006L) && (!paramBoolean)) || (l == 1004L)) {}
        for (paramBoolean = true;; paramBoolean = false) {
          return paramBoolean;
        }
      }
      return true;
    }
    if (paramMessageForPic.extraflag == 32768) {}
    for (paramBoolean = bool;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static String b(String paramString)
  {
    return a(paramString, 1.0F);
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (paramMessage == null) {}
    Message localMessage;
    label105:
    label112:
    do
    {
      do
      {
        do
        {
          return false;
          localMessage = paramMessage;
          if (!UinTypeUtil.a(paramMessage.frienduin, paramMessage.istroop)) {
            break;
          }
          localMessage = paramMessage;
          if (paramMessage.senderuin == null) {
            break;
          }
        } while (UinTypeUtil.c(paramMessage.senderuin));
        int i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (!paramMessage.isSelfConfessor()) {
            break label105;
          }
        }
        for (i = 1033;; i = 1034)
        {
          localMessage = paramQQAppInterface.getMessageFacade().a(paramMessage.senderuin, i);
          if (localMessage.msgtype != -2005) {
            break label112;
          }
          if (a(paramQQAppInterface, localMessage) != 0) {
            break;
          }
          return true;
        }
        if (localMessage.fileType == 1)
        {
          i = TransFileControllerBusHelper.findProcessorFileStatus(paramQQAppInterface, localMessage.frienduin, null, localMessage.uniseq);
          if ((i != 1005) && (i != 1004)) {
            break label281;
          }
          return true;
        }
        if (localMessage.msgtype != -2017) {
          break label281;
        }
        paramMessage = paramQQAppInterface.getMessageFacade().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
        if (!(paramMessage instanceof MessageForTroopFile)) {
          break;
        }
        paramMessage = (MessageForTroopFile)paramMessage;
      } while ((paramMessage == null) || (paramMessage.frienduin == null));
      paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.b != 3));
    return true;
    if (QLog.isColorLevel()) {
      QLog.d("MsgTypeError", 2, "uniseq:" + localMessage.uniseq + ",msgtype:" + localMessage.msgtype);
    }
    label281:
    if ((localMessage.isSendFromLocal()) && (localMessage.extraflag == 32768)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int j;
    int i;
    do
    {
      return paramString;
      localObject = paramString.toCharArray();
      j = paramString.length();
      i = 0;
      j -= 1;
      while ((i <= j) && (localObject[i] <= ' ') && (localObject[i] != '\024')) {
        i += 1;
      }
    } while (i == 0);
    Object localObject = paramString.substring(i, j + 1);
    if (QLog.isDevelopLevel()) {
      QLog.i("MsgUtils", 4, "trimBegin source:" + paramString + ", temp:" + (String)localObject);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MsgUtils
 * JD-Core Version:    0.7.0.1
 */