package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MsgUtils
{
  private static float jdField_a_of_type_Float = 0.0F;
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static float jdField_b_of_type_Float = 0.0F;
  private static long jdField_b_of_type_Long;
  private static float c;
  
  private static int a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    int i;
    if (paramMessage == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop, -1L);
      i = j;
    } while (j != -1);
    Object localObject = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
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
    paramQQAppInterface = (TransFileInfo)((EntityManager)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessage.frienduin });
    ((EntityManager)localObject).a();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = FileManagerUtil.b(paramQQAppInterface.status);
    if (paramQQAppInterface.status == 2) {
      paramQQAppInterface.status = 0;
    }
    return paramQQAppInterface.status;
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue))) {
      return paramMessage.actMsgContentValue;
    }
    paramContext = paramQQAppInterface.a().a(AppShareIDUtil.a(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.getApp().getString(2131435954);
    }
    return paramQQAppInterface.getApp().getString(2131435952) + paramContext.messagetail + paramQQAppInterface.getApp().getString(2131435953);
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, QQMessageFacade.Message paramMessage)
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
              paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramMessage.senderuin, true);
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
                  paramContext = paramContext.getString(2131434684);
                  break;
                  paramContext = paramContext.getString(2131434685);
                  break;
                  paramContext = paramContext.getString(2131434686);
                  break;
                  paramContext = paramContext.getString(2131434694);
                  break;
                  paramContext = paramContext.getString(2131434695);
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
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramContext, true);
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
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramMessage, true);
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
      ((StringBuffer)localObject).append(i).append(paramContext.getString(2131433100));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131433103));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131433104));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
  /* Error */
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_1
    //   4: ifnonnull +8 -> 12
    //   7: ldc 119
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: iload 5
    //   14: iconst_1
    //   15: if_icmpeq +11 -> 26
    //   18: iload 5
    //   20: sipush 5000
    //   23: if_icmpne +310 -> 333
    //   26: iconst_1
    //   27: istore 6
    //   29: aload_1
    //   30: arraylength
    //   31: iconst_1
    //   32: if_icmple +284 -> 316
    //   35: aload_1
    //   36: iconst_1
    //   37: aaload
    //   38: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   41: istore 7
    //   43: iload 7
    //   45: tableswitch	default:+19 -> 64, 13:+114->159
    //   65: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   68: ldc_w 283
    //   71: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   74: astore_3
    //   75: iload 5
    //   77: iconst_1
    //   78: if_icmpeq +11 -> 89
    //   81: iload 5
    //   83: sipush 5000
    //   86: if_icmpne +14 -> 100
    //   89: aload_2
    //   90: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   93: ldc_w 287
    //   96: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   99: astore_3
    //   100: iload 8
    //   102: istore 5
    //   104: aload_1
    //   105: arraylength
    //   106: iconst_4
    //   107: if_icmple +11 -> 118
    //   110: aload_1
    //   111: iconst_4
    //   112: aaload
    //   113: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   116: istore 5
    //   118: aload_3
    //   119: astore_1
    //   120: iload 5
    //   122: iconst_2
    //   123: if_icmpne -113 -> 10
    //   126: aload_3
    //   127: aload_0
    //   128: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: ldc_w 287
    //   134: invokevirtual 158	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   137: aload_0
    //   138: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   141: ldc_w 288
    //   144: invokevirtual 158	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   147: invokevirtual 275	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   150: areturn
    //   151: astore 9
    //   153: iconst_0
    //   154: istore 7
    //   156: goto -113 -> 43
    //   159: aload 4
    //   161: ifnull +113 -> 274
    //   164: aload_0
    //   165: aload 4
    //   167: aload_3
    //   168: iload 6
    //   170: iconst_0
    //   171: invokestatic 291	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   174: astore 4
    //   176: aload_2
    //   177: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   180: ldc_w 283
    //   183: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   186: astore_3
    //   187: iload 5
    //   189: iconst_1
    //   190: if_icmpeq +11 -> 201
    //   193: iload 5
    //   195: sipush 5000
    //   198: if_icmpne +14 -> 212
    //   201: aload_2
    //   202: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   205: ldc_w 287
    //   208: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   211: astore_3
    //   212: aload 4
    //   214: invokevirtual 204	java/lang/String:length	()I
    //   217: bipush 11
    //   219: if_icmple +108 -> 327
    //   222: aload 4
    //   224: iconst_0
    //   225: bipush 10
    //   227: invokevirtual 295	java/lang/String:substring	(II)Ljava/lang/String;
    //   230: astore_2
    //   231: new 160	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   238: aload_2
    //   239: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 297
    //   245: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: astore_2
    //   252: new 160	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   259: aload_2
    //   260: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_3
    //   264: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: astore_3
    //   271: goto -171 -> 100
    //   274: iload 5
    //   276: iconst_1
    //   277: if_icmpeq +11 -> 288
    //   280: iload 5
    //   282: sipush 5000
    //   285: if_icmpne +17 -> 302
    //   288: aload_2
    //   289: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   292: ldc_w 288
    //   295: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   298: astore_3
    //   299: goto -199 -> 100
    //   302: aload_2
    //   303: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   306: ldc_w 298
    //   309: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   312: astore_3
    //   313: goto -213 -> 100
    //   316: ldc 119
    //   318: areturn
    //   319: astore_1
    //   320: iload 8
    //   322: istore 5
    //   324: goto -206 -> 118
    //   327: aload 4
    //   329: astore_2
    //   330: goto -78 -> 252
    //   333: iconst_2
    //   334: istore 6
    //   336: goto -307 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramQQAppInterface	QQAppInterface
    //   0	339	1	paramArrayOfString	String[]
    //   0	339	2	paramContext	Context
    //   0	339	3	paramString1	String
    //   0	339	4	paramString2	String
    //   0	339	5	paramInt	int
    //   27	308	6	i	int
    //   41	114	7	j	int
    //   1	320	8	k	int
    //   151	1	9	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   35	43	151	java/lang/NumberFormatException
    //   110	118	319	java/lang/NumberFormatException
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    if (paramString != null) {
      localStringBuilder.append(paramString + ": ");
    }
    localStringBuilder.append("[文件]");
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
      label796:
      try
      {
        localObject1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
        localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(((DisplayMetrics)localObject1).density * 14.0F);
        f1 = Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
        float f2 = ((DisplayMetrics)localObject1).density;
        f1 -= f2 * 72.0F;
        if (f1 <= 0.0F)
        {
          localObject3 = paramString;
          return paramString;
        }
        c = 0.7F * f1;
        jdField_a_of_type_Float = ((TextPaint)localObject3).measureText("汉");
        jdField_b_of_type_Float = ((TextPaint)localObject3).measureText("AaJjIiMm") / "AaJjIiMm".length();
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
          break label796;
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
          break label798;
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
      label798:
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
            break label877;
          }
          j += 1;
          i += 1;
          break;
        }
      }
      label877:
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
              paramContext = paramContext.getResources().getString(2131428757);
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
        if (paramContext.getString(2131428848).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131428766);
          }
          return paramContext.getResources().getString(2131428772);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131428757) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131428759) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131428845).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131428765);
            }
            return paramContext.getResources().getString(2131428763);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131428771);
          }
          return paramContext.getResources().getString(2131428769);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131428757) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131428759) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131428765);
          }
          return paramContext.getResources().getString(2131428763);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131428771);
        }
        return paramContext.getResources().getString(2131428769);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131428765);
          }
          return paramContext.getResources().getString(2131428763);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131428771);
        }
        return paramContext.getResources().getString(2131428769);
        if (j != 0) {
          return paramContext.getResources().getString(2131428762);
        }
        return paramContext.getResources().getString(2131428768);
        if (j != 0) {
          return paramContext.getResources().getString(2131428757);
        }
        return paramContext.getResources().getString(2131428759);
        if (j != 0) {
          return paramContext.getResources().getString(2131428767);
        }
        return paramContext.getResources().getString(2131428774);
        if (j != 0) {
          return paramContext.getResources().getString(2131428766);
        }
        return paramContext.getResources().getString(2131428772);
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131428848).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131428766);
          }
          return paramContext.getResources().getString(2131428772);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131428757) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131428759) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        return paramContext.getResources().getString(2131428759) + " " + paramArrayOfString[0];
        label913:
        paramContext = paramContext.getResources().getString(2131428759);
      }
    }
    return "";
    label930:
    return "";
  }
  
  /* Error */
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload 5
    //   7: astore 16
    //   9: aload_2
    //   10: invokestatic 441	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   13: ifeq +7156 -> 7169
    //   16: aload 5
    //   18: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +24 -> 45
    //   24: aload 5
    //   26: astore 16
    //   28: aload 5
    //   30: aload_1
    //   31: aload_2
    //   32: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   35: iconst_1
    //   36: invokestatic 443	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   39: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifne +7127 -> 7169
    //   45: aload_1
    //   46: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   49: aload_2
    //   50: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   53: aload_2
    //   54: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   57: aload_2
    //   58: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   61: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   64: astore 16
    //   66: aload 16
    //   68: instanceof 453
    //   71: ifeq +11 -> 82
    //   74: aload 16
    //   76: checkcast 453	com/tencent/mobileqq/data/ChatMessage
    //   79: invokevirtual 456	com/tencent/mobileqq/data/ChatMessage:parse	()V
    //   82: aload 16
    //   84: ifnull +13 -> 97
    //   87: aload 16
    //   89: invokestatic 459	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo;
    //   92: getfield 463	com/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo:b	Ljava/lang/String;
    //   95: astore 5
    //   97: aload 5
    //   99: astore 16
    //   101: aload 5
    //   103: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +7063 -> 7169
    //   109: aload_2
    //   110: invokestatic 459	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo;
    //   113: getfield 463	com/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo:b	Ljava/lang/String;
    //   116: astore 5
    //   118: aload 5
    //   120: astore 16
    //   122: iload 6
    //   124: ifne +42 -> 166
    //   127: aload_2
    //   128: invokevirtual 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   131: ifne +32 -> 163
    //   134: aload 5
    //   136: astore 16
    //   138: aload_2
    //   139: getfield 469	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   142: ifnull +24 -> 166
    //   145: aload 5
    //   147: astore 16
    //   149: aload_2
    //   150: getfield 469	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   153: aload_2
    //   154: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   157: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +6 -> 166
    //   163: aconst_null
    //   164: astore 16
    //   166: aload_2
    //   167: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   170: invokestatic 474	com/tencent/mobileqq/app/message/MsgProxyUtils:j	(I)Z
    //   173: ifeq +6 -> 179
    //   176: aconst_null
    //   177: astore 16
    //   179: aload_2
    //   180: invokestatic 479	com/tencent/mobileqq/troop/utils/TroopBusinessUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/troop/utils/TroopBusinessUtil$TroopBusinessMessage;
    //   183: astore 5
    //   185: aload 5
    //   187: ifnull +10 -> 197
    //   190: aload 5
    //   192: getfield 483	com/tencent/mobileqq/troop/utils/TroopBusinessUtil$TroopBusinessMessage:c	Ljava/lang/String;
    //   195: astore 16
    //   197: aload 16
    //   199: invokestatic 484	com/tencent/mobileqq/utils/MsgUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 19
    //   204: aload_2
    //   205: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   208: sipush -2034
    //   211: if_icmpne +16 -> 227
    //   214: aload 4
    //   216: aload_2
    //   217: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   220: invokestatic 492	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   226: return
    //   227: aload_2
    //   228: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   231: sipush -2011
    //   234: if_icmpne +157 -> 391
    //   237: iconst_0
    //   238: istore_3
    //   239: iconst_0
    //   240: istore 8
    //   242: aload_2
    //   243: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   246: sipush -2011
    //   249: if_icmpne +29 -> 278
    //   252: aload_2
    //   253: getfield 500	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extInt	I
    //   256: bipush 61
    //   258: if_icmpne +20 -> 278
    //   261: aload_2
    //   262: aload_1
    //   263: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   266: invokevirtual 501	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   269: ldc_w 502
    //   272: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   275: putfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   278: aload_2
    //   279: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   282: iconst_1
    //   283: if_icmpne +73 -> 356
    //   286: aload_1
    //   287: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   290: aload_2
    //   291: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   294: aload_2
    //   295: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   298: aload_2
    //   299: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   302: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   305: astore_0
    //   306: iload 8
    //   308: istore_3
    //   309: aload_0
    //   310: invokestatic 505	com/tencent/mobileqq/nearby/NearbyFlowerUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   313: ifeq +21 -> 334
    //   316: aconst_null
    //   317: aconst_null
    //   318: aload_0
    //   319: checkcast 507	com/tencent/mobileqq/data/MessageForStructing
    //   322: invokestatic 510	com/tencent/mobileqq/nearby/NearbyFlowerUtil:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   325: iconst_0
    //   326: iconst_0
    //   327: aload 4
    //   329: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   332: iconst_1
    //   333: istore_3
    //   334: aload_0
    //   335: invokestatic 516	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   338: ifeq +18 -> 356
    //   341: aconst_null
    //   342: aconst_null
    //   343: aload_2
    //   344: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   347: iconst_0
    //   348: iconst_0
    //   349: aload 4
    //   351: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   354: iconst_1
    //   355: istore_3
    //   356: iload_3
    //   357: ifne -353 -> 4
    //   360: aload_1
    //   361: aload_2
    //   362: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   365: istore 6
    //   367: aload_1
    //   368: aload_2
    //   369: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   372: istore 7
    //   374: aload 19
    //   376: aconst_null
    //   377: aload_2
    //   378: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   381: iload 6
    //   383: iload 7
    //   385: aload 4
    //   387: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   390: return
    //   391: aload_2
    //   392: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   395: sipush -2000
    //   398: if_icmpeq +13 -> 411
    //   401: aload_2
    //   402: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   405: sipush -5015
    //   408: if_icmpne +428 -> 836
    //   411: iconst_0
    //   412: istore 10
    //   414: aload_2
    //   415: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   418: astore 5
    //   420: aload_2
    //   421: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   424: aload_2
    //   425: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   428: invokestatic 524	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   431: ifeq +6735 -> 7166
    //   434: aload_2
    //   435: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   438: astore 5
    //   440: aload_1
    //   441: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   444: aload 5
    //   446: aload_2
    //   447: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   450: aload_2
    //   451: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   454: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   457: checkcast 526	com/tencent/mobileqq/data/MessageForPic
    //   460: astore 16
    //   462: aload_1
    //   463: invokevirtual 529	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   466: aload 5
    //   468: aload_2
    //   469: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   472: invokevirtual 534	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   475: astore_1
    //   476: aload_2
    //   477: invokevirtual 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   480: ifeq +234 -> 714
    //   483: aload 16
    //   485: ifnull +207 -> 692
    //   488: aload 16
    //   490: getfield 537	com/tencent/mobileqq/data/MessageForPic:size	J
    //   493: lstore 14
    //   495: lload 14
    //   497: lconst_0
    //   498: lcmp
    //   499: ifgt +193 -> 692
    //   502: aload_1
    //   503: ifnonnull +6657 -> 7160
    //   506: iconst_1
    //   507: istore 6
    //   509: iload 6
    //   511: istore 7
    //   513: aload_1
    //   514: instanceof 539
    //   517: ifeq +264 -> 781
    //   520: aload_1
    //   521: checkcast 539	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   524: astore_1
    //   525: aload_1
    //   526: invokevirtual 541	com/tencent/mobileqq/transfile/BaseTransProcessor:c	()J
    //   529: ldc2_w 542
    //   532: lcmp
    //   533: ifeq +6621 -> 7154
    //   536: iconst_1
    //   537: istore 6
    //   539: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq +60 -> 602
    //   545: aload_1
    //   546: getfield 546	com/tencent/mobileqq/transfile/BaseTransProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   549: ifnull +224 -> 773
    //   552: aload_1
    //   553: getfield 546	com/tencent/mobileqq/transfile/BaseTransProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   556: getfield 549	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   559: lstore 14
    //   561: ldc_w 551
    //   564: iconst_2
    //   565: new 160	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 553
    //   575: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: lload 14
    //   580: invokevirtual 406	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: ldc_w 555
    //   586: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_1
    //   590: invokevirtual 557	com/tencent/mobileqq/transfile/BaseTransProcessor:a	()Ljava/lang/String;
    //   593: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 560	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload_0
    //   603: ldc_w 561
    //   606: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   609: astore_1
    //   610: aload_2
    //   611: invokestatic 564	com/tencent/mobileqq/app/HotChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   614: ifne +10 -> 624
    //   617: aload_2
    //   618: invokestatic 567	com/tencent/mobileqq/app/FlashPicHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   621: ifeq +11 -> 632
    //   624: aload_0
    //   625: ldc_w 568
    //   628: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   631: astore_1
    //   632: aload_2
    //   633: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   636: sipush -5015
    //   639: if_icmpne +11 -> 650
    //   642: aload_0
    //   643: ldc_w 569
    //   646: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   649: astore_1
    //   650: aload_2
    //   651: invokestatic 573	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   654: ifeq +6495 -> 7149
    //   657: new 160	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 575
    //   667: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_1
    //   671: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: astore_0
    //   678: aload 19
    //   680: aload_0
    //   681: aconst_null
    //   682: iload 7
    //   684: iload 6
    //   686: aload 4
    //   688: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   691: return
    //   692: aload 16
    //   694: ifnull +6466 -> 7160
    //   697: aload 16
    //   699: getfield 578	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   702: ldc_w 579
    //   705: if_icmpne +6471 -> 7176
    //   708: iconst_1
    //   709: istore 6
    //   711: goto -202 -> 509
    //   714: aload_1
    //   715: ifnull +6445 -> 7160
    //   718: aload_1
    //   719: instanceof 539
    //   722: ifeq +6438 -> 7160
    //   725: aload_1
    //   726: checkcast 539	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   729: invokevirtual 541	com/tencent/mobileqq/transfile/BaseTransProcessor:c	()J
    //   732: lstore 14
    //   734: lload 14
    //   736: l2i
    //   737: istore_3
    //   738: iload_3
    //   739: sipush 1005
    //   742: if_icmpeq +10 -> 752
    //   745: iload_3
    //   746: sipush 1004
    //   749: if_icmpne +6411 -> 7160
    //   752: iconst_1
    //   753: istore 6
    //   755: goto -246 -> 509
    //   758: astore 5
    //   760: aconst_null
    //   761: astore_1
    //   762: aload 5
    //   764: invokevirtual 409	java/lang/Exception:printStackTrace	()V
    //   767: iconst_0
    //   768: istore 7
    //   770: goto -257 -> 513
    //   773: ldc2_w 39
    //   776: lstore 14
    //   778: goto -217 -> 561
    //   781: iload 10
    //   783: istore 6
    //   785: aload_1
    //   786: ifnull -184 -> 602
    //   789: iconst_1
    //   790: istore 10
    //   792: iload 10
    //   794: istore 6
    //   796: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   799: ifeq -197 -> 602
    //   802: ldc_w 551
    //   805: iconst_2
    //   806: new 160	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   813: ldc_w 581
    //   816: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: aload_1
    //   820: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   823: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 560	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: iload 10
    //   831: istore 6
    //   833: goto -231 -> 602
    //   836: aload_2
    //   837: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   840: sipush -2002
    //   843: if_icmpeq +13 -> 856
    //   846: aload_2
    //   847: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   850: sipush -1031
    //   853: if_icmpne +264 -> 1117
    //   856: aload_2
    //   857: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   860: astore 5
    //   862: aload_2
    //   863: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   866: aload_2
    //   867: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   870: invokestatic 524	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   873: ifeq +6273 -> 7146
    //   876: aload_2
    //   877: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   880: astore 5
    //   882: aload_0
    //   883: ldc_w 585
    //   886: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   889: astore 16
    //   891: aload 16
    //   893: astore_0
    //   894: aload_2
    //   895: invokestatic 573	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   898: ifeq +25 -> 923
    //   901: new 160	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   908: ldc_w 575
    //   911: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: aload 16
    //   916: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: astore_0
    //   923: aload_1
    //   924: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   927: aload 5
    //   929: aload_2
    //   930: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   933: aload_2
    //   934: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   937: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   940: astore 16
    //   942: aload 16
    //   944: instanceof 587
    //   947: ifeq +6190 -> 7137
    //   950: aload 16
    //   952: checkcast 587	com/tencent/mobileqq/data/MessageForPtt
    //   955: astore 16
    //   957: aload_2
    //   958: invokevirtual 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   961: ifeq +6176 -> 7137
    //   964: aload 16
    //   966: getfield 590	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   969: ldc2_w 39
    //   972: lcmp
    //   973: ifne +49 -> 1022
    //   976: iconst_1
    //   977: istore 6
    //   979: iconst_0
    //   980: istore 7
    //   982: ldc_w 592
    //   985: iconst_2
    //   986: anewarray 4	java/lang/Object
    //   989: dup
    //   990: iconst_0
    //   991: iload 6
    //   993: invokestatic 597	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   996: aastore
    //   997: dup
    //   998: iconst_1
    //   999: iload 7
    //   1001: invokestatic 597	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1004: aastore
    //   1005: invokestatic 602	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1008: aload 19
    //   1010: aload_0
    //   1011: aconst_null
    //   1012: iload 6
    //   1014: iload 7
    //   1016: aload 4
    //   1018: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1021: return
    //   1022: aload 16
    //   1024: getfield 590	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1027: lconst_0
    //   1028: lcmp
    //   1029: ifgt +6108 -> 7137
    //   1032: aload_1
    //   1033: invokevirtual 529	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   1036: aload 5
    //   1038: aload 16
    //   1040: getfield 605	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1043: aload 16
    //   1045: getfield 606	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   1048: invokevirtual 609	com/tencent/mobileqq/transfile/TransFileController:b	(Ljava/lang/String;Ljava/lang/String;J)I
    //   1051: istore_3
    //   1052: iload_3
    //   1053: sipush 1005
    //   1056: if_icmpeq +15 -> 1071
    //   1059: iload_3
    //   1060: sipush 1004
    //   1063: if_icmpeq +8 -> 1071
    //   1066: iload_3
    //   1067: iconst_m1
    //   1068: if_icmpne +40 -> 1108
    //   1071: iconst_1
    //   1072: istore 6
    //   1074: iconst_0
    //   1075: istore 7
    //   1077: ldc_w 592
    //   1080: iconst_2
    //   1081: anewarray 4	java/lang/Object
    //   1084: dup
    //   1085: iconst_0
    //   1086: aload 16
    //   1088: getfield 590	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1091: invokestatic 614	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1094: aastore
    //   1095: dup
    //   1096: iconst_1
    //   1097: iload_3
    //   1098: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1101: aastore
    //   1102: invokestatic 602	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1105: goto -123 -> 982
    //   1108: iconst_1
    //   1109: istore 7
    //   1111: iconst_0
    //   1112: istore 6
    //   1114: goto -37 -> 1077
    //   1117: aload_2
    //   1118: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1121: sipush -3008
    //   1124: if_icmpne +48 -> 1172
    //   1127: aload 4
    //   1129: new 160	java/lang/StringBuilder
    //   1132: dup
    //   1133: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1136: aload_0
    //   1137: ldc_w 618
    //   1140: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   1143: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: ldc_w 620
    //   1149: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: aload_2
    //   1153: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1156: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: ldc_w 620
    //   1162: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1168: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   1171: return
    //   1172: aload_2
    //   1173: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1176: sipush -2015
    //   1179: if_icmpeq +33 -> 1212
    //   1182: aload_2
    //   1183: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1186: sipush -2060
    //   1189: if_icmpeq +23 -> 1212
    //   1192: aload_2
    //   1193: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1196: sipush -2065
    //   1199: if_icmpeq +13 -> 1212
    //   1202: aload_2
    //   1203: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1206: sipush -2062
    //   1209: if_icmpne +11 -> 1220
    //   1212: aload 4
    //   1214: ldc 119
    //   1216: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   1219: return
    //   1220: aload_2
    //   1221: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1224: invokestatic 624	com/tencent/mobileqq/utils/ActionMsgUtil:a	(I)Z
    //   1227: ifeq +28 -> 1255
    //   1230: aload 19
    //   1232: aload_0
    //   1233: aload_1
    //   1234: aload_2
    //   1235: invokestatic 626	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1238: aconst_null
    //   1239: aload_1
    //   1240: aload_2
    //   1241: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1244: aload_1
    //   1245: aload_2
    //   1246: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1249: aload 4
    //   1251: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1254: return
    //   1255: aload_2
    //   1256: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1259: sipush -2017
    //   1262: if_icmpne +94 -> 1356
    //   1265: aload_0
    //   1266: ldc_w 627
    //   1269: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   1272: astore 5
    //   1274: aload_2
    //   1275: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1278: astore_0
    //   1279: aload_2
    //   1280: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1283: aload_2
    //   1284: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1287: invokestatic 524	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   1290: ifeq +8 -> 1298
    //   1293: aload_2
    //   1294: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1297: astore_0
    //   1298: aload_1
    //   1299: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1302: aload_0
    //   1303: aload_2
    //   1304: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1307: aload_2
    //   1308: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1311: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1314: astore 16
    //   1316: aload 5
    //   1318: astore_0
    //   1319: aload 16
    //   1321: instanceof 629
    //   1324: ifeq +12 -> 1336
    //   1327: aload 16
    //   1329: checkcast 629	com/tencent/mobileqq/data/MessageForTroopFile
    //   1332: invokevirtual 632	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   1335: astore_0
    //   1336: aload 19
    //   1338: aload_0
    //   1339: aconst_null
    //   1340: aload_1
    //   1341: aload_2
    //   1342: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1345: aload_1
    //   1346: aload_2
    //   1347: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1350: aload 4
    //   1352: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1355: return
    //   1356: aload_2
    //   1357: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1360: invokestatic 634	com/tencent/mobileqq/utils/ActionMsgUtil:b	(I)Z
    //   1363: ifeq +35 -> 1398
    //   1366: aload_2
    //   1367: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1370: invokestatic 639	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1373: astore_1
    //   1374: aload_1
    //   1375: ifnull -1371 -> 4
    //   1378: aload 4
    //   1380: aload_1
    //   1381: aload_0
    //   1382: aload_2
    //   1383: getfield 642	com/tencent/mobileqq/app/message/QQMessageFacade$Message:issend	I
    //   1386: invokestatic 643	com/tencent/mobileqq/utils/MsgUtils:b	(I)Z
    //   1389: iload 7
    //   1391: invokestatic 645	com/tencent/mobileqq/utils/MsgUtils:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   1394: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   1397: return
    //   1398: aload_2
    //   1399: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1402: invokestatic 647	com/tencent/mobileqq/utils/ActionMsgUtil:c	(I)Z
    //   1405: ifeq +39 -> 1444
    //   1408: aload_2
    //   1409: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1412: invokestatic 639	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1415: astore 5
    //   1417: aload 5
    //   1419: ifnull -1415 -> 4
    //   1422: aload 4
    //   1424: aload_1
    //   1425: aload 5
    //   1427: aload_0
    //   1428: aload_2
    //   1429: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1432: aload_2
    //   1433: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1436: iload_3
    //   1437: invokestatic 649	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1440: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   1443: return
    //   1444: aload_2
    //   1445: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1448: invokestatic 651	com/tencent/mobileqq/utils/ActionMsgUtil:d	(I)Z
    //   1451: ifeq +160 -> 1611
    //   1454: aload_1
    //   1455: aload_2
    //   1456: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1459: istore 6
    //   1461: aload_1
    //   1462: aload_2
    //   1463: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1466: istore 7
    //   1468: aload_2
    //   1469: ldc_w 653
    //   1472: invokevirtual 656	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1475: astore 5
    //   1477: getstatic 661	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1480: ifeq +122 -> 1602
    //   1483: aload 5
    //   1485: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1488: ifne +114 -> 1602
    //   1491: aload_0
    //   1492: aload_2
    //   1493: invokestatic 666	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1496: astore_0
    //   1497: aload_2
    //   1498: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1501: aload_1
    //   1502: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1505: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1508: ifeq +70 -> 1578
    //   1511: new 160	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1518: ldc_w 668
    //   1521: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: aload_0
    //   1525: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1531: astore_0
    //   1532: aload_2
    //   1533: invokestatic 573	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1536: ifeq +5598 -> 7134
    //   1539: aload_0
    //   1540: ifnull +5594 -> 7134
    //   1543: new 160	java/lang/StringBuilder
    //   1546: dup
    //   1547: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1550: ldc_w 575
    //   1553: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: aload_0
    //   1557: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1563: astore_0
    //   1564: aload 19
    //   1566: aload_0
    //   1567: aconst_null
    //   1568: iload 6
    //   1570: iload 7
    //   1572: aload 4
    //   1574: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1577: return
    //   1578: new 160	java/lang/StringBuilder
    //   1581: dup
    //   1582: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1585: ldc_w 670
    //   1588: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: aload_0
    //   1592: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1598: astore_0
    //   1599: goto -67 -> 1532
    //   1602: aload_0
    //   1603: aload_2
    //   1604: invokestatic 666	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1607: astore_0
    //   1608: goto -76 -> 1532
    //   1611: aload_2
    //   1612: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1615: sipush -2058
    //   1618: if_icmpne +1064 -> 2682
    //   1621: ldc 119
    //   1623: astore 18
    //   1625: aload_1
    //   1626: aload_2
    //   1627: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1630: istore 12
    //   1632: aload_1
    //   1633: aload_2
    //   1634: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1637: istore 13
    //   1639: iconst_0
    //   1640: istore 8
    //   1642: aload 18
    //   1644: astore 17
    //   1646: aload_2
    //   1647: ldc_w 672
    //   1650: invokevirtual 656	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1653: astore 5
    //   1655: aload 18
    //   1657: astore 16
    //   1659: aload 18
    //   1661: astore 17
    //   1663: aload 5
    //   1665: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1668: ifne +267 -> 1935
    //   1671: aload 18
    //   1673: astore 17
    //   1675: new 674	org/json/JSONObject
    //   1678: dup
    //   1679: aload 5
    //   1681: invokespecial 677	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1684: ldc_w 679
    //   1687: invokevirtual 682	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1690: istore 9
    //   1692: iload 8
    //   1694: istore_3
    //   1695: aload 18
    //   1697: astore 5
    //   1699: aload 18
    //   1701: astore 17
    //   1703: aload_2
    //   1704: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1707: ifnull +111 -> 1818
    //   1710: iload 8
    //   1712: istore_3
    //   1713: aload 18
    //   1715: astore 5
    //   1717: iload 9
    //   1719: sipush -2007
    //   1722: if_icmpne +96 -> 1818
    //   1725: iload 8
    //   1727: istore_3
    //   1728: aload 18
    //   1730: astore 5
    //   1732: aload 18
    //   1734: astore 17
    //   1736: aload_2
    //   1737: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1740: invokestatic 691	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   1743: instanceof 693
    //   1746: ifeq +72 -> 1818
    //   1749: aload 18
    //   1751: astore 17
    //   1753: getstatic 661	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1756: ifeq +226 -> 1982
    //   1759: aload 18
    //   1761: astore 17
    //   1763: aload_0
    //   1764: aload_2
    //   1765: invokestatic 666	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1768: astore 5
    //   1770: aload 18
    //   1772: astore 17
    //   1774: aload_2
    //   1775: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1778: aload_1
    //   1779: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1782: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1785: ifeq +167 -> 1952
    //   1788: aload 18
    //   1790: astore 17
    //   1792: new 160	java/lang/StringBuilder
    //   1795: dup
    //   1796: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1799: ldc_w 668
    //   1802: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: aload 5
    //   1807: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1810: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1813: astore 5
    //   1815: goto +5367 -> 7182
    //   1818: aload 5
    //   1820: astore 16
    //   1822: iload_3
    //   1823: ifne +112 -> 1935
    //   1826: aload 5
    //   1828: astore 17
    //   1830: getstatic 661	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1833: ifeq +205 -> 2038
    //   1836: aload 5
    //   1838: astore 17
    //   1840: aload_2
    //   1841: ldc_w 653
    //   1844: invokevirtual 656	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1847: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1850: ifne +5278 -> 7128
    //   1853: aload 5
    //   1855: astore 17
    //   1857: aload_1
    //   1858: aload_2
    //   1859: aload 4
    //   1861: invokestatic 696	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   1864: astore_0
    //   1865: new 160	java/lang/StringBuilder
    //   1868: dup
    //   1869: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1872: astore_1
    //   1873: aload 19
    //   1875: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1878: ifne +16 -> 1894
    //   1881: aload_1
    //   1882: aload 19
    //   1884: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1887: ldc_w 303
    //   1890: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1893: pop
    //   1894: aload_2
    //   1895: invokestatic 441	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1898: ifne +16 -> 1914
    //   1901: iload 12
    //   1903: ifeq +95 -> 1998
    //   1906: aload_1
    //   1907: ldc_w 698
    //   1910: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1913: pop
    //   1914: aload_0
    //   1915: checkcast 700	com/tencent/mobileqq/text/QQText
    //   1918: aload_1
    //   1919: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1922: iconst_1
    //   1923: iconst_0
    //   1924: newarray int
    //   1926: invokevirtual 703	com/tencent/mobileqq/text/QQText:a	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   1929: astore_1
    //   1930: aload_1
    //   1931: astore_0
    //   1932: aload_0
    //   1933: astore 16
    //   1935: aload 16
    //   1937: astore_2
    //   1938: aload 19
    //   1940: aload_2
    //   1941: aconst_null
    //   1942: iload 12
    //   1944: iload 13
    //   1946: aload 4
    //   1948: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1951: return
    //   1952: aload 18
    //   1954: astore 17
    //   1956: new 160	java/lang/StringBuilder
    //   1959: dup
    //   1960: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1963: ldc_w 670
    //   1966: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1969: aload 5
    //   1971: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1974: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1977: astore 5
    //   1979: goto +5203 -> 7182
    //   1982: aload 18
    //   1984: astore 17
    //   1986: aload_0
    //   1987: aload_2
    //   1988: invokestatic 666	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1991: astore 5
    //   1993: iconst_1
    //   1994: istore_3
    //   1995: goto -177 -> 1818
    //   1998: iload 13
    //   2000: ifeq -86 -> 1914
    //   2003: aload_1
    //   2004: ldc_w 705
    //   2007: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2010: pop
    //   2011: goto -97 -> 1914
    //   2014: astore_1
    //   2015: aload_0
    //   2016: astore_2
    //   2017: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2020: ifeq -82 -> 1938
    //   2023: ldc_w 707
    //   2026: iconst_2
    //   2027: ldc 119
    //   2029: aload_1
    //   2030: invokestatic 710	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2033: aload_0
    //   2034: astore_2
    //   2035: goto -97 -> 1938
    //   2038: iload 9
    //   2040: sipush -1000
    //   2043: if_icmpne +153 -> 2196
    //   2046: aload 5
    //   2048: astore 17
    //   2050: aload_2
    //   2051: invokestatic 713	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Lcom/tencent/mobileqq/text/QQText;
    //   2054: astore_0
    //   2055: aload_0
    //   2056: ifnull -2052 -> 4
    //   2059: aload 5
    //   2061: astore 17
    //   2063: new 160	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2070: astore_1
    //   2071: aload 5
    //   2073: astore 17
    //   2075: aload 19
    //   2077: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2080: ifne +20 -> 2100
    //   2083: aload 5
    //   2085: astore 17
    //   2087: aload_1
    //   2088: aload 19
    //   2090: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: ldc_w 303
    //   2096: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: pop
    //   2100: aload 5
    //   2102: astore 17
    //   2104: aload_2
    //   2105: invokestatic 441	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2108: ifne +20 -> 2128
    //   2111: iload 12
    //   2113: ifeq +63 -> 2176
    //   2116: aload 5
    //   2118: astore 17
    //   2120: aload_1
    //   2121: ldc_w 698
    //   2124: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2127: pop
    //   2128: aload 5
    //   2130: astore 17
    //   2132: aload_0
    //   2133: checkcast 700	com/tencent/mobileqq/text/QQText
    //   2136: aload_1
    //   2137: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2140: iconst_1
    //   2141: iconst_0
    //   2142: newarray int
    //   2144: invokevirtual 703	com/tencent/mobileqq/text/QQText:a	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   2147: astore_0
    //   2148: aload 5
    //   2150: astore 17
    //   2152: aload 4
    //   2154: iconst_1
    //   2155: putfield 715	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_Int	I
    //   2158: aload 5
    //   2160: astore 17
    //   2162: aload 19
    //   2164: aload_0
    //   2165: aconst_null
    //   2166: iload 12
    //   2168: iload 13
    //   2170: aload 4
    //   2172: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2175: return
    //   2176: iload 13
    //   2178: ifeq -50 -> 2128
    //   2181: aload 5
    //   2183: astore 17
    //   2185: aload_1
    //   2186: ldc_w 705
    //   2189: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2192: pop
    //   2193: goto -65 -> 2128
    //   2196: aload 5
    //   2198: astore 16
    //   2200: iload 9
    //   2202: sipush -2000
    //   2205: if_icmpne -270 -> 1935
    //   2208: iconst_0
    //   2209: istore 11
    //   2211: iconst_0
    //   2212: istore 7
    //   2214: aconst_null
    //   2215: astore 18
    //   2217: aload 18
    //   2219: astore 16
    //   2221: aload_2
    //   2222: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2225: astore 17
    //   2227: aload 18
    //   2229: astore 16
    //   2231: aload_2
    //   2232: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2235: aload_2
    //   2236: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2239: invokestatic 524	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   2242: ifeq +4883 -> 7125
    //   2245: aload 18
    //   2247: astore 16
    //   2249: aload_2
    //   2250: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   2253: astore 17
    //   2255: aload 18
    //   2257: astore 16
    //   2259: aload_1
    //   2260: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   2263: aload 17
    //   2265: aload_2
    //   2266: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2269: aload_2
    //   2270: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2273: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2276: checkcast 526	com/tencent/mobileqq/data/MessageForPic
    //   2279: astore 20
    //   2281: aload 18
    //   2283: astore 16
    //   2285: aload_1
    //   2286: invokevirtual 529	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   2289: aload 17
    //   2291: aload_2
    //   2292: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2295: invokevirtual 534	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   2298: astore_1
    //   2299: aload_1
    //   2300: astore 16
    //   2302: aload_2
    //   2303: invokevirtual 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   2306: ifeq +245 -> 2551
    //   2309: aload_1
    //   2310: astore 16
    //   2312: aload 20
    //   2314: getfield 537	com/tencent/mobileqq/data/MessageForPic:size	J
    //   2317: lstore 14
    //   2319: lload 14
    //   2321: lconst_0
    //   2322: lcmp
    //   2323: ifgt +208 -> 2531
    //   2326: aload_1
    //   2327: ifnonnull +4792 -> 7119
    //   2330: aload 20
    //   2332: ifnull +4787 -> 7119
    //   2335: iconst_1
    //   2336: istore 6
    //   2338: iload 6
    //   2340: istore 10
    //   2342: aload 5
    //   2344: astore 17
    //   2346: aload_1
    //   2347: instanceof 539
    //   2350: ifeq +269 -> 2619
    //   2353: aload 5
    //   2355: astore 17
    //   2357: aload_1
    //   2358: checkcast 539	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   2361: astore_1
    //   2362: aload 5
    //   2364: astore 17
    //   2366: aload_1
    //   2367: invokevirtual 541	com/tencent/mobileqq/transfile/BaseTransProcessor:c	()J
    //   2370: ldc2_w 542
    //   2373: lcmp
    //   2374: ifeq +6 -> 2380
    //   2377: iconst_1
    //   2378: istore 7
    //   2380: iload 7
    //   2382: istore 6
    //   2384: aload 5
    //   2386: astore 17
    //   2388: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2391: ifeq +76 -> 2467
    //   2394: aload 5
    //   2396: astore 17
    //   2398: aload_1
    //   2399: getfield 546	com/tencent/mobileqq/transfile/BaseTransProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   2402: ifnull +4798 -> 7200
    //   2405: aload 5
    //   2407: astore 17
    //   2409: aload_1
    //   2410: getfield 546	com/tencent/mobileqq/transfile/BaseTransProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   2413: getfield 549	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   2416: lstore 14
    //   2418: aload 5
    //   2420: astore 17
    //   2422: ldc_w 551
    //   2425: iconst_2
    //   2426: new 160	java/lang/StringBuilder
    //   2429: dup
    //   2430: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2433: ldc_w 553
    //   2436: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: lload 14
    //   2441: invokevirtual 406	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2444: ldc_w 555
    //   2447: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2450: aload_1
    //   2451: invokevirtual 557	com/tencent/mobileqq/transfile/BaseTransProcessor:a	()Ljava/lang/String;
    //   2454: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2460: invokestatic 560	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2463: iload 7
    //   2465: istore 6
    //   2467: aload 5
    //   2469: astore 17
    //   2471: aload_0
    //   2472: ldc_w 561
    //   2475: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   2478: astore_1
    //   2479: aload 5
    //   2481: astore 17
    //   2483: aload_2
    //   2484: invokestatic 564	com/tencent/mobileqq/app/HotChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2487: ifne +14 -> 2501
    //   2490: aload 5
    //   2492: astore 17
    //   2494: aload_2
    //   2495: invokestatic 567	com/tencent/mobileqq/app/FlashPicHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2498: ifeq +15 -> 2513
    //   2501: aload 5
    //   2503: astore 17
    //   2505: aload_0
    //   2506: ldc_w 568
    //   2509: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   2512: astore_1
    //   2513: aload 5
    //   2515: astore 17
    //   2517: aload 19
    //   2519: aload_1
    //   2520: aconst_null
    //   2521: iload 10
    //   2523: iload 6
    //   2525: aload 4
    //   2527: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2530: return
    //   2531: aload_1
    //   2532: astore 16
    //   2534: aload 20
    //   2536: getfield 578	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   2539: ldc_w 579
    //   2542: if_icmpne +4652 -> 7194
    //   2545: iconst_1
    //   2546: istore 6
    //   2548: goto -210 -> 2338
    //   2551: aload_1
    //   2552: ifnull +4567 -> 7119
    //   2555: aload_1
    //   2556: astore 16
    //   2558: aload_1
    //   2559: instanceof 539
    //   2562: ifeq +4557 -> 7119
    //   2565: aload_1
    //   2566: astore 16
    //   2568: aload_1
    //   2569: checkcast 539	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   2572: invokevirtual 541	com/tencent/mobileqq/transfile/BaseTransProcessor:c	()J
    //   2575: lstore 14
    //   2577: lload 14
    //   2579: l2i
    //   2580: istore_3
    //   2581: iload_3
    //   2582: sipush 1005
    //   2585: if_icmpeq +10 -> 2595
    //   2588: iload_3
    //   2589: sipush 1004
    //   2592: if_icmpne +4527 -> 7119
    //   2595: iconst_1
    //   2596: istore 6
    //   2598: goto -260 -> 2338
    //   2601: astore_1
    //   2602: aload 5
    //   2604: astore 17
    //   2606: aload_1
    //   2607: invokevirtual 409	java/lang/Exception:printStackTrace	()V
    //   2610: aload 16
    //   2612: astore_1
    //   2613: iconst_0
    //   2614: istore 10
    //   2616: goto -274 -> 2342
    //   2619: iload 11
    //   2621: istore 6
    //   2623: aload_1
    //   2624: ifnull -157 -> 2467
    //   2627: iconst_1
    //   2628: istore 7
    //   2630: iload 7
    //   2632: istore 6
    //   2634: aload 5
    //   2636: astore 17
    //   2638: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2641: ifeq -174 -> 2467
    //   2644: aload 5
    //   2646: astore 17
    //   2648: ldc_w 551
    //   2651: iconst_2
    //   2652: new 160	java/lang/StringBuilder
    //   2655: dup
    //   2656: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2659: ldc_w 581
    //   2662: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2665: aload_1
    //   2666: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2669: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2672: invokestatic 560	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2675: iload 7
    //   2677: istore 6
    //   2679: goto -212 -> 2467
    //   2682: aload_2
    //   2683: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2686: invokestatic 717	com/tencent/mobileqq/utils/ActionMsgUtil:e	(I)Z
    //   2689: ifeq +263 -> 2952
    //   2692: new 719	com/tencent/mobileqq/data/MessageForApollo
    //   2695: dup
    //   2696: invokespecial 720	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   2699: astore 5
    //   2701: aload 5
    //   2703: aload_2
    //   2704: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2707: putfield 721	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   2710: aload 5
    //   2712: invokevirtual 722	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   2715: aload_1
    //   2716: aload_2
    //   2717: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   2720: istore 6
    //   2722: aload_1
    //   2723: aload_2
    //   2724: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   2727: istore 7
    //   2729: aload 5
    //   2731: getfield 724	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2734: invokestatic 727	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(I)Z
    //   2737: ifeq +205 -> 2942
    //   2740: ldc_w 729
    //   2743: astore_0
    //   2744: aload 5
    //   2746: getfield 724	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2749: iconst_4
    //   2750: if_icmpne +155 -> 2905
    //   2753: aload 5
    //   2755: getfield 732	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2758: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2761: ifeq +42 -> 2803
    //   2764: new 160	java/lang/StringBuilder
    //   2767: dup
    //   2768: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2771: ldc_w 729
    //   2774: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2777: ldc_w 734
    //   2780: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2783: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2786: astore_1
    //   2787: aload_1
    //   2788: astore_0
    //   2789: aload 19
    //   2791: aload_0
    //   2792: aconst_null
    //   2793: iload 6
    //   2795: iload 7
    //   2797: aload 4
    //   2799: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2802: return
    //   2803: new 674	org/json/JSONObject
    //   2806: dup
    //   2807: aload 5
    //   2809: getfield 732	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2812: invokespecial 677	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2815: ldc_w 736
    //   2818: invokevirtual 739	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2821: astore_1
    //   2822: aload_1
    //   2823: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2826: ifeq +31 -> 2857
    //   2829: new 160	java/lang/StringBuilder
    //   2832: dup
    //   2833: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2836: ldc_w 729
    //   2839: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2842: ldc_w 734
    //   2845: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2848: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2851: astore_1
    //   2852: aload_1
    //   2853: astore_0
    //   2854: goto -65 -> 2789
    //   2857: new 160	java/lang/StringBuilder
    //   2860: dup
    //   2861: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2864: ldc_w 729
    //   2867: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2870: ldc_w 420
    //   2873: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: aload_1
    //   2877: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2880: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2883: astore_1
    //   2884: aload_1
    //   2885: astore_0
    //   2886: goto -97 -> 2789
    //   2889: astore_1
    //   2890: ldc_w 707
    //   2893: iconst_1
    //   2894: aload_1
    //   2895: iconst_0
    //   2896: anewarray 4	java/lang/Object
    //   2899: invokestatic 742	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2902: goto -113 -> 2789
    //   2905: aload_1
    //   2906: aload 5
    //   2908: invokestatic 747	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2911: astore_0
    //   2912: new 160	java/lang/StringBuilder
    //   2915: dup
    //   2916: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2919: ldc_w 729
    //   2922: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2925: ldc_w 749
    //   2928: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2931: aload_0
    //   2932: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2935: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2938: astore_0
    //   2939: goto -150 -> 2789
    //   2942: aload_1
    //   2943: aload 5
    //   2945: invokestatic 751	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2948: astore_0
    //   2949: goto -160 -> 2789
    //   2952: aload_2
    //   2953: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2956: sipush -1013
    //   2959: if_icmpeq +13 -> 2972
    //   2962: aload_2
    //   2963: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2966: sipush -1047
    //   2969: if_icmpne +20 -> 2989
    //   2972: aconst_null
    //   2973: aconst_null
    //   2974: aload_2
    //   2975: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2978: invokestatic 492	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   2981: iconst_0
    //   2982: iconst_0
    //   2983: aload 4
    //   2985: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2988: return
    //   2989: aload_2
    //   2990: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2993: sipush -2042
    //   2996: if_icmpeq +13 -> 3009
    //   2999: aload_2
    //   3000: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3003: sipush -2043
    //   3006: if_icmpne +20 -> 3026
    //   3009: aconst_null
    //   3010: aload_2
    //   3011: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3014: invokestatic 492	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3017: aconst_null
    //   3018: iconst_0
    //   3019: iconst_0
    //   3020: aload 4
    //   3022: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3025: return
    //   3026: aload_2
    //   3027: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3030: sipush -2051
    //   3033: if_icmpne +61 -> 3094
    //   3036: aload_1
    //   3037: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3040: aload_2
    //   3041: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3044: aload_2
    //   3045: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3048: aload_2
    //   3049: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3052: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3055: checkcast 753	com/tencent/mobileqq/data/MessageForQQStory
    //   3058: astore_0
    //   3059: aload_0
    //   3060: invokevirtual 754	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   3063: aload_1
    //   3064: aload_2
    //   3065: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3068: istore 6
    //   3070: aload_1
    //   3071: aload_2
    //   3072: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3075: istore 7
    //   3077: aload 19
    //   3079: aconst_null
    //   3080: aload_0
    //   3081: invokevirtual 755	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   3084: iload 6
    //   3086: iload 7
    //   3088: aload 4
    //   3090: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3093: return
    //   3094: aload_2
    //   3095: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3098: sipush -7002
    //   3101: if_icmpne +61 -> 3162
    //   3104: aload_1
    //   3105: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3108: aload_2
    //   3109: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3112: aload_2
    //   3113: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3116: aload_2
    //   3117: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3120: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3123: checkcast 757	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   3126: astore_0
    //   3127: aload_0
    //   3128: invokevirtual 758	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   3131: aload_1
    //   3132: aload_2
    //   3133: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3136: istore 6
    //   3138: aload_1
    //   3139: aload_2
    //   3140: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3143: istore 7
    //   3145: aload 19
    //   3147: aconst_null
    //   3148: aload_0
    //   3149: invokevirtual 759	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   3152: iload 6
    //   3154: iload 7
    //   3156: aload 4
    //   3158: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3161: return
    //   3162: aload_2
    //   3163: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3166: sipush -2054
    //   3169: if_icmpne +146 -> 3315
    //   3172: aload_1
    //   3173: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3176: aload_2
    //   3177: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3180: aload_2
    //   3181: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3184: aload_2
    //   3185: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3188: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3191: astore_0
    //   3192: aload_0
    //   3193: instanceof 761
    //   3196: ifeq +35 -> 3231
    //   3199: aload_0
    //   3200: checkcast 761	com/tencent/mobileqq/data/MessageForTroopSign
    //   3203: astore_0
    //   3204: aload_0
    //   3205: invokevirtual 762	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   3208: aload 19
    //   3210: aconst_null
    //   3211: aload_0
    //   3212: invokevirtual 763	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   3215: aload_1
    //   3216: aload_2
    //   3217: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3220: aload_1
    //   3221: aload_2
    //   3222: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3225: aload 4
    //   3227: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3230: return
    //   3231: new 160	java/lang/StringBuilder
    //   3234: dup
    //   3235: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3238: ldc 2
    //   3240: invokevirtual 768	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3243: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3246: ldc_w 770
    //   3249: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3252: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3255: astore_1
    //   3256: new 160	java/lang/StringBuilder
    //   3259: dup
    //   3260: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3263: ldc_w 772
    //   3266: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3269: aload_2
    //   3270: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3273: invokevirtual 406	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3276: ldc_w 774
    //   3279: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3282: astore_2
    //   3283: aload_0
    //   3284: ifnull +25 -> 3309
    //   3287: aload_0
    //   3288: getfield 777	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3291: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3294: astore_0
    //   3295: aload_1
    //   3296: iconst_1
    //   3297: aload_2
    //   3298: aload_0
    //   3299: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3302: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3305: invokestatic 779	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3308: return
    //   3309: ldc 119
    //   3311: astore_0
    //   3312: goto -17 -> 3295
    //   3315: aload_2
    //   3316: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3319: sipush -2035
    //   3322: if_icmpne +20 -> 3342
    //   3325: aconst_null
    //   3326: aload_2
    //   3327: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3330: invokestatic 492	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3333: aconst_null
    //   3334: iconst_0
    //   3335: iconst_0
    //   3336: aload 4
    //   3338: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3341: return
    //   3342: aload_2
    //   3343: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3346: sipush -2038
    //   3349: if_icmpne +205 -> 3554
    //   3352: aload_2
    //   3353: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3356: astore_0
    //   3357: getstatic 784	com/tencent/mobileqq/app/AppConstants:ae	Ljava/lang/String;
    //   3360: aload_0
    //   3361: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3364: ifeq +3752 -> 7116
    //   3367: aload_2
    //   3368: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3371: astore_0
    //   3372: aload_0
    //   3373: astore 5
    //   3375: getstatic 787	com/tencent/mobileqq/app/AppConstants:G	Ljava/lang/String;
    //   3378: aload_0
    //   3379: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3382: ifeq +59 -> 3441
    //   3385: getstatic 784	com/tencent/mobileqq/app/AppConstants:ae	Ljava/lang/String;
    //   3388: aload_2
    //   3389: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3392: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3395: ifeq +103 -> 3498
    //   3398: aload_1
    //   3399: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3402: getstatic 784	com/tencent/mobileqq/app/AppConstants:ae	Ljava/lang/String;
    //   3405: aload_2
    //   3406: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3409: aload_2
    //   3410: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3413: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3416: checkcast 789	com/tencent/mobileqq/data/MessageForTroopGift
    //   3419: astore 16
    //   3421: aload_0
    //   3422: astore 5
    //   3424: aload 16
    //   3426: ifnull +15 -> 3441
    //   3429: aload 16
    //   3431: invokevirtual 790	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3434: aload 16
    //   3436: getfield 791	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   3439: astore 5
    //   3441: aload_1
    //   3442: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3445: aload 5
    //   3447: aload_2
    //   3448: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3451: aload_2
    //   3452: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3455: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3458: astore_0
    //   3459: aload_0
    //   3460: instanceof 789
    //   3463: ifeq +50 -> 3513
    //   3466: aload_0
    //   3467: checkcast 789	com/tencent/mobileqq/data/MessageForTroopGift
    //   3470: astore_0
    //   3471: aload_0
    //   3472: invokevirtual 790	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3475: aload_0
    //   3476: getfield 792	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3479: ifnull +28 -> 3507
    //   3482: aload_0
    //   3483: getfield 792	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3486: astore_0
    //   3487: aconst_null
    //   3488: aload_0
    //   3489: aconst_null
    //   3490: iconst_0
    //   3491: iconst_0
    //   3492: aload 4
    //   3494: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3497: return
    //   3498: aload_2
    //   3499: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3502: astore 5
    //   3504: goto -63 -> 3441
    //   3507: ldc 119
    //   3509: astore_0
    //   3510: goto -23 -> 3487
    //   3513: aload_0
    //   3514: ifnull -3510 -> 4
    //   3517: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3520: ifeq -3516 -> 4
    //   3523: ldc_w 707
    //   3526: iconst_2
    //   3527: new 160	java/lang/StringBuilder
    //   3530: dup
    //   3531: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3534: ldc_w 794
    //   3537: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3540: aload_0
    //   3541: invokevirtual 795	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3544: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3547: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3550: invokestatic 779	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3553: return
    //   3554: aload_2
    //   3555: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3558: sipush -2036
    //   3561: if_icmpne +44 -> 3605
    //   3564: aload_1
    //   3565: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3568: aload_2
    //   3569: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3572: aload_2
    //   3573: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3576: aload_2
    //   3577: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3580: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3583: checkcast 797	com/tencent/mobileqq/data/MessageForTroopFee
    //   3586: astore_0
    //   3587: aload_0
    //   3588: invokevirtual 798	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3591: aconst_null
    //   3592: aload_0
    //   3593: getfield 799	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3596: aconst_null
    //   3597: iconst_0
    //   3598: iconst_0
    //   3599: aload 4
    //   3601: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3604: return
    //   3605: aload_2
    //   3606: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3609: sipush -2044
    //   3612: if_icmpne +45 -> 3657
    //   3615: aload_1
    //   3616: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3619: aload_2
    //   3620: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3623: aload_2
    //   3624: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3627: aload_2
    //   3628: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3631: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3634: checkcast 801	com/tencent/mobileqq/data/MessageForTroopTopic
    //   3637: astore_0
    //   3638: aload_0
    //   3639: invokevirtual 802	com/tencent/mobileqq/data/MessageForTroopTopic:parse	()V
    //   3642: aload 19
    //   3644: aload_0
    //   3645: getfield 803	com/tencent/mobileqq/data/MessageForTroopTopic:msg	Ljava/lang/String;
    //   3648: aconst_null
    //   3649: iconst_0
    //   3650: iconst_0
    //   3651: aload 4
    //   3653: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3656: return
    //   3657: aload_2
    //   3658: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3661: sipush -2048
    //   3664: if_icmpne +45 -> 3709
    //   3667: aload_1
    //   3668: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3671: aload_2
    //   3672: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3675: aload_2
    //   3676: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3679: aload_2
    //   3680: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3683: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3686: checkcast 805	com/tencent/mobileqq/data/MessageForTroopReward
    //   3689: astore_0
    //   3690: aload_0
    //   3691: invokevirtual 806	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3694: aload 19
    //   3696: aload_0
    //   3697: getfield 807	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3700: aconst_null
    //   3701: iconst_0
    //   3702: iconst_0
    //   3703: aload 4
    //   3705: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3708: return
    //   3709: aload_2
    //   3710: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3713: iconst_1
    //   3714: if_icmpne +81 -> 3795
    //   3717: aload_2
    //   3718: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3721: sipush -3006
    //   3724: if_icmpne +71 -> 3795
    //   3727: aload_1
    //   3728: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3731: aload_2
    //   3732: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3735: aload_2
    //   3736: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3739: aload_2
    //   3740: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3743: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3746: checkcast 809	com/tencent/mobileqq/data/MessageForPubAccount
    //   3749: astore_0
    //   3750: aload_0
    //   3751: invokevirtual 810	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   3754: aload_1
    //   3755: aload_0
    //   3756: iconst_0
    //   3757: invokestatic 814	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   3760: astore_2
    //   3761: aload_0
    //   3762: invokevirtual 817	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   3765: ifne +16 -> 3781
    //   3768: aconst_null
    //   3769: astore_0
    //   3770: aload_0
    //   3771: aload_2
    //   3772: aconst_null
    //   3773: iconst_0
    //   3774: iconst_0
    //   3775: aload 4
    //   3777: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3780: return
    //   3781: aload_1
    //   3782: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3785: ldc_w 818
    //   3788: invokevirtual 158	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3791: astore_0
    //   3792: goto -22 -> 3770
    //   3795: aload_2
    //   3796: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3799: sipush -1034
    //   3802: if_icmpne +127 -> 3929
    //   3805: new 820	com/tencent/mobileqq/data/MessageForRichState
    //   3808: dup
    //   3809: invokespecial 821	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   3812: astore_0
    //   3813: aload_0
    //   3814: aload_2
    //   3815: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3818: putfield 822	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   3821: aload_0
    //   3822: invokevirtual 823	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   3825: new 160	java/lang/StringBuilder
    //   3828: dup
    //   3829: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3832: astore_1
    //   3833: aload_0
    //   3834: getfield 826	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   3837: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3840: ifne +38 -> 3878
    //   3843: aload_1
    //   3844: aload_0
    //   3845: getfield 826	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   3848: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3851: pop
    //   3852: aload_0
    //   3853: getfield 829	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   3856: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3859: ifne +12 -> 3871
    //   3862: aload_1
    //   3863: aload_0
    //   3864: getfield 829	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   3867: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3870: pop
    //   3871: aload_1
    //   3872: bipush 32
    //   3874: invokevirtual 832	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3877: pop
    //   3878: aload_0
    //   3879: getfield 836	com/tencent/mobileqq/data/MessageForRichState:plainText	Lorg/json/JSONArray;
    //   3882: ifnull +26 -> 3908
    //   3885: aload_0
    //   3886: getfield 836	com/tencent/mobileqq/data/MessageForRichState:plainText	Lorg/json/JSONArray;
    //   3889: invokevirtual 839	org/json/JSONArray:length	()I
    //   3892: ifle +16 -> 3908
    //   3895: aload_1
    //   3896: aload_0
    //   3897: getfield 836	com/tencent/mobileqq/data/MessageForRichState:plainText	Lorg/json/JSONArray;
    //   3900: iconst_0
    //   3901: invokevirtual 841	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   3904: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3907: pop
    //   3908: aload_1
    //   3909: invokevirtual 842	java/lang/StringBuilder:length	()I
    //   3912: ifle -3908 -> 4
    //   3915: aconst_null
    //   3916: aload_1
    //   3917: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3920: aconst_null
    //   3921: iconst_0
    //   3922: iconst_0
    //   3923: aload 4
    //   3925: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3928: return
    //   3929: aload_2
    //   3930: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3933: sipush -1019
    //   3936: if_icmpne +42 -> 3978
    //   3939: aconst_null
    //   3940: aconst_null
    //   3941: new 160	java/lang/StringBuilder
    //   3944: dup
    //   3945: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3948: ldc_w 844
    //   3951: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3954: aload_2
    //   3955: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3958: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3961: ldc_w 846
    //   3964: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3967: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3970: iconst_0
    //   3971: iconst_0
    //   3972: aload 4
    //   3974: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3977: return
    //   3978: aload_2
    //   3979: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3982: sipush -1018
    //   3985: if_icmpne +42 -> 4027
    //   3988: aconst_null
    //   3989: aconst_null
    //   3990: new 160	java/lang/StringBuilder
    //   3993: dup
    //   3994: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3997: ldc_w 848
    //   4000: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4003: aload_2
    //   4004: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4007: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4010: ldc_w 850
    //   4013: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4016: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4019: iconst_0
    //   4020: iconst_0
    //   4021: aload 4
    //   4023: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4026: return
    //   4027: aload_2
    //   4028: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4031: sipush -2019
    //   4034: if_icmpne +16 -> 4050
    //   4037: aload 4
    //   4039: aload_0
    //   4040: ldc_w 851
    //   4043: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4046: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   4049: return
    //   4050: aload_2
    //   4051: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4054: sipush -1026
    //   4057: if_icmpne +16 -> 4073
    //   4060: aload 4
    //   4062: aload_0
    //   4063: ldc_w 852
    //   4066: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4069: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   4072: return
    //   4073: aload_2
    //   4074: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4077: sipush -1027
    //   4080: if_icmpne +16 -> 4096
    //   4083: aload 4
    //   4085: aload_0
    //   4086: ldc_w 853
    //   4089: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4092: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   4095: return
    //   4096: aload_2
    //   4097: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4100: sipush -2005
    //   4103: if_icmpne +56 -> 4159
    //   4106: aload_1
    //   4107: aload_2
    //   4108: invokestatic 856	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   4111: astore 5
    //   4113: aload_1
    //   4114: aload_2
    //   4115: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   4118: istore 6
    //   4120: aload_1
    //   4121: aload_2
    //   4122: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   4125: istore 7
    //   4127: aload 19
    //   4129: aload_0
    //   4130: ldc_w 857
    //   4133: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4136: aconst_null
    //   4137: iload 6
    //   4139: iload 7
    //   4141: aload 4
    //   4143: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4146: aload 5
    //   4148: ifnull -4144 -> 4
    //   4151: aload 4
    //   4153: aload 5
    //   4155: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   4158: return
    //   4159: aload_2
    //   4160: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4163: sipush -2022
    //   4166: if_icmpne +600 -> 4766
    //   4169: iconst_0
    //   4170: istore 6
    //   4172: iconst_0
    //   4173: istore 10
    //   4175: aload_1
    //   4176: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   4179: aload_2
    //   4180: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4183: aload_2
    //   4184: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   4187: aload_2
    //   4188: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4191: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4194: astore 5
    //   4196: aload 5
    //   4198: instanceof 859
    //   4201: ifeq -4197 -> 4
    //   4204: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4207: ifeq +33 -> 4240
    //   4210: ldc_w 381
    //   4213: iconst_2
    //   4214: new 160	java/lang/StringBuilder
    //   4217: dup
    //   4218: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4221: ldc_w 861
    //   4224: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4227: aload_2
    //   4228: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4231: invokevirtual 406	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4234: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4237: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4240: aload 5
    //   4242: checkcast 859	com/tencent/mobileqq/data/MessageForShortVideo
    //   4245: astore 16
    //   4247: aload 16
    //   4249: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4252: sipush 1005
    //   4255: if_icmpeq +13 -> 4268
    //   4258: aload_2
    //   4259: getfield 865	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   4262: ldc_w 579
    //   4265: if_icmpne +22 -> 4287
    //   4268: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4271: ifeq +13 -> 4284
    //   4274: ldc_w 381
    //   4277: iconst_2
    //   4278: ldc_w 867
    //   4281: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4284: iconst_1
    //   4285: istore 6
    //   4287: aload_2
    //   4288: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4291: astore 5
    //   4293: aload_2
    //   4294: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4297: aload_2
    //   4298: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   4301: invokestatic 524	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   4304: ifeq +9 -> 4313
    //   4307: aload_2
    //   4308: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   4311: astore 5
    //   4313: aload_1
    //   4314: invokevirtual 529	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   4317: aload 5
    //   4319: aload_2
    //   4320: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4323: invokevirtual 534	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   4326: astore_1
    //   4327: iload 6
    //   4329: istore 7
    //   4331: aload 16
    //   4333: getfield 870	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4336: ifnull +133 -> 4469
    //   4339: iload 6
    //   4341: istore 7
    //   4343: ldc 119
    //   4345: aload 16
    //   4347: getfield 870	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4350: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4353: ifne +116 -> 4469
    //   4356: iload 6
    //   4358: istore 7
    //   4360: aload_2
    //   4361: invokevirtual 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4364: ifeq +105 -> 4469
    //   4367: iload 6
    //   4369: istore 7
    //   4371: aload_1
    //   4372: ifnonnull +97 -> 4469
    //   4375: iload 6
    //   4377: istore 7
    //   4379: aload 16
    //   4381: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4384: sipush 1003
    //   4387: if_icmpeq +82 -> 4469
    //   4390: iload 6
    //   4392: istore 7
    //   4394: aload 16
    //   4396: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4399: sipush 1004
    //   4402: if_icmpeq +67 -> 4469
    //   4405: iload 6
    //   4407: istore 7
    //   4409: aload 16
    //   4411: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4414: sipush 2003
    //   4417: if_icmpeq +52 -> 4469
    //   4420: iload 6
    //   4422: istore 7
    //   4424: aload 16
    //   4426: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4429: sipush 2009
    //   4432: if_icmpeq +37 -> 4469
    //   4435: iload 6
    //   4437: istore 7
    //   4439: aload 16
    //   4441: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4444: sipush 2002
    //   4447: if_icmpeq +22 -> 4469
    //   4450: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4453: ifeq +13 -> 4466
    //   4456: ldc_w 381
    //   4459: iconst_2
    //   4460: ldc_w 872
    //   4463: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4466: iconst_1
    //   4467: istore 7
    //   4469: iload 7
    //   4471: istore 6
    //   4473: iload 10
    //   4475: istore 7
    //   4477: aload_2
    //   4478: invokevirtual 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4481: ifeq +81 -> 4562
    //   4484: aload 16
    //   4486: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4489: sipush 1001
    //   4492: if_icmpeq +51 -> 4543
    //   4495: aload 16
    //   4497: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4500: sipush 1002
    //   4503: if_icmpeq +40 -> 4543
    //   4506: aload 16
    //   4508: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4511: sipush 998
    //   4514: if_icmpeq +29 -> 4543
    //   4517: aload 16
    //   4519: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4522: sipush 999
    //   4525: if_icmpeq +18 -> 4543
    //   4528: iload 10
    //   4530: istore 7
    //   4532: aload 16
    //   4534: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4537: sipush 1000
    //   4540: if_icmpne +22 -> 4562
    //   4543: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4546: ifeq +13 -> 4559
    //   4549: ldc_w 381
    //   4552: iconst_2
    //   4553: ldc_w 874
    //   4556: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4559: iconst_1
    //   4560: istore 7
    //   4562: aload 16
    //   4564: getfield 877	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4567: iconst_2
    //   4568: if_icmpne +174 -> 4742
    //   4571: aload_0
    //   4572: ldc_w 878
    //   4575: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4578: astore_0
    //   4579: aload_0
    //   4580: astore 5
    //   4582: aload_2
    //   4583: invokestatic 573	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   4586: ifeq +25 -> 4611
    //   4589: new 160	java/lang/StringBuilder
    //   4592: dup
    //   4593: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4596: ldc_w 575
    //   4599: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4602: aload_0
    //   4603: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4606: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4609: astore 5
    //   4611: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4614: ifeq +101 -> 4715
    //   4617: ldc_w 381
    //   4620: iconst_2
    //   4621: new 160	java/lang/StringBuilder
    //   4624: dup
    //   4625: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4628: ldc_w 880
    //   4631: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4634: aload 16
    //   4636: getfield 870	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4639: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4642: ldc_w 882
    //   4645: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4648: aload 16
    //   4650: getfield 864	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4653: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4656: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4659: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4662: aload_1
    //   4663: ifnonnull +90 -> 4753
    //   4666: ldc_w 381
    //   4669: iconst_2
    //   4670: ldc_w 884
    //   4673: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4676: ldc_w 381
    //   4679: iconst_2
    //   4680: new 160	java/lang/StringBuilder
    //   4683: dup
    //   4684: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4687: ldc_w 886
    //   4690: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4693: iload 6
    //   4695: invokevirtual 889	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4698: ldc_w 891
    //   4701: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4704: iload 7
    //   4706: invokevirtual 889	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4709: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4712: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4715: aload 19
    //   4717: aload 5
    //   4719: aconst_null
    //   4720: iload 6
    //   4722: iload 7
    //   4724: aload 4
    //   4726: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4729: return
    //   4730: astore 5
    //   4732: aconst_null
    //   4733: astore_1
    //   4734: aload 5
    //   4736: invokevirtual 409	java/lang/Exception:printStackTrace	()V
    //   4739: goto -266 -> 4473
    //   4742: aload_0
    //   4743: ldc_w 892
    //   4746: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4749: astore_0
    //   4750: goto -171 -> 4579
    //   4753: ldc_w 381
    //   4756: iconst_2
    //   4757: ldc_w 894
    //   4760: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4763: goto -87 -> 4676
    //   4766: aload_2
    //   4767: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4770: sipush -5002
    //   4773: if_icmpne +40 -> 4813
    //   4776: new 896	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   4779: dup
    //   4780: invokespecial 897	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   4783: astore_0
    //   4784: aload_0
    //   4785: aload_2
    //   4786: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   4789: putfield 898	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   4792: aload_0
    //   4793: invokevirtual 899	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   4796: aload_0
    //   4797: getfield 900	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   4800: ifnull -4796 -> 4
    //   4803: aload 4
    //   4805: aload_0
    //   4806: getfield 900	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   4809: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   4812: return
    //   4813: aload_2
    //   4814: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4817: sipush -2029
    //   4820: if_icmpne +142 -> 4962
    //   4823: aload_1
    //   4824: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   4827: aload_2
    //   4828: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4831: aload_2
    //   4832: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   4835: aload_2
    //   4836: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4839: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4842: astore_0
    //   4843: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4846: ifeq +30 -> 4876
    //   4849: ldc_w 381
    //   4852: iconst_2
    //   4853: new 160	java/lang/StringBuilder
    //   4856: dup
    //   4857: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4860: ldc_w 902
    //   4863: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4866: aload_0
    //   4867: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4870: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4873: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4876: aload_0
    //   4877: instanceof 904
    //   4880: ifeq -4876 -> 4
    //   4883: aload_0
    //   4884: checkcast 904	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   4887: astore_0
    //   4888: aload_0
    //   4889: aload_2
    //   4890: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   4893: putfield 905	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   4896: aload_0
    //   4897: invokevirtual 906	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   4900: aload_0
    //   4901: aload_1
    //   4902: aload_1
    //   4903: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4906: aconst_null
    //   4907: invokevirtual 910	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   4910: aload_0
    //   4911: getfield 912	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4914: ifnull -4910 -> 4
    //   4917: aload_0
    //   4918: getfield 915	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   4921: iconst_1
    //   4922: if_icmpne +30 -> 4952
    //   4925: aload_0
    //   4926: new 160	java/lang/StringBuilder
    //   4929: dup
    //   4930: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4933: ldc_w 917
    //   4936: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4939: aload_0
    //   4940: getfield 912	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4943: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4946: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4949: putfield 912	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4952: aload 4
    //   4954: aload_0
    //   4955: getfield 912	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   4958: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   4961: return
    //   4962: aload_2
    //   4963: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4966: sipush -2025
    //   4969: if_icmpne +13 -> 4982
    //   4972: aload 4
    //   4974: aload_2
    //   4975: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4978: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   4981: return
    //   4982: aload_2
    //   4983: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4986: sipush -2052
    //   4989: if_icmpne +75 -> 5064
    //   4992: aload_2
    //   4993: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4996: astore_0
    //   4997: aload_2
    //   4998: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5001: aload_2
    //   5002: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5005: invokestatic 524	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   5008: ifeq +8 -> 5016
    //   5011: aload_2
    //   5012: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5015: astore_0
    //   5016: aload_1
    //   5017: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   5020: aload_0
    //   5021: aload_2
    //   5022: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5025: aload_2
    //   5026: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   5029: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5032: astore_0
    //   5033: aload_0
    //   5034: instanceof 919
    //   5037: ifeq -5033 -> 4
    //   5040: aload_0
    //   5041: checkcast 919	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   5044: astore_0
    //   5045: aload_0
    //   5046: invokevirtual 920	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   5049: aload 19
    //   5051: aload_0
    //   5052: invokevirtual 921	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   5055: aconst_null
    //   5056: iconst_0
    //   5057: iconst_0
    //   5058: aload 4
    //   5060: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5063: return
    //   5064: aload_2
    //   5065: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5068: sipush -2047
    //   5071: if_icmpne +51 -> 5122
    //   5074: new 923	com/tencent/mobileqq/data/MessageForVIPDonate
    //   5077: dup
    //   5078: invokespecial 924	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   5081: astore_0
    //   5082: aload_0
    //   5083: aload_2
    //   5084: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5087: putfield 925	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   5090: aload_0
    //   5091: invokevirtual 926	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   5094: aload_0
    //   5095: invokevirtual 927	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   5098: astore_0
    //   5099: aload_0
    //   5100: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5103: ifne +10 -> 5113
    //   5106: aload 4
    //   5108: aload_0
    //   5109: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   5112: return
    //   5113: aload 4
    //   5115: ldc_w 929
    //   5118: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   5121: return
    //   5122: aload_2
    //   5123: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5126: sipush -2040
    //   5129: if_icmpne +29 -> 5158
    //   5132: new 931	com/tencent/mobileqq/data/MessageForApproval
    //   5135: dup
    //   5136: invokespecial 932	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   5139: astore_0
    //   5140: aload_0
    //   5141: aload_2
    //   5142: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5145: putfield 933	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   5148: aload 4
    //   5150: aload_0
    //   5151: invokevirtual 936	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   5154: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   5157: return
    //   5158: aload_2
    //   5159: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5162: sipush -2041
    //   5165: if_icmpne +49 -> 5214
    //   5168: aload_0
    //   5169: ldc_w 937
    //   5172: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5175: astore_1
    //   5176: aload_0
    //   5177: ldc_w 938
    //   5180: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5183: astore_0
    //   5184: aload 4
    //   5186: new 160	java/lang/StringBuilder
    //   5189: dup
    //   5190: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   5193: aload_1
    //   5194: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5197: ldc_w 420
    //   5200: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5203: aload_0
    //   5204: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5207: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5210: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   5213: return
    //   5214: aload_2
    //   5215: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5218: sipush -7001
    //   5221: if_icmpne +157 -> 5378
    //   5224: aload_2
    //   5225: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5228: astore 5
    //   5230: aload_2
    //   5231: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5234: aload_2
    //   5235: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5238: invokestatic 524	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   5241: ifeq +9 -> 5250
    //   5244: aload_2
    //   5245: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5248: astore 5
    //   5250: aload_1
    //   5251: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   5254: aload 5
    //   5256: aload_2
    //   5257: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5260: aload_2
    //   5261: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   5264: invokevirtual 451	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5267: checkcast 940	com/tencent/mobileqq/data/MessageForScribble
    //   5270: astore_1
    //   5271: aload_1
    //   5272: invokevirtual 941	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   5275: ifeq +56 -> 5331
    //   5278: aload_1
    //   5279: getfield 944	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5282: istore_3
    //   5283: iload_3
    //   5284: iconst_2
    //   5285: if_icmpne +29 -> 5314
    //   5288: iconst_1
    //   5289: istore 7
    //   5291: iconst_0
    //   5292: istore 6
    //   5294: aload 19
    //   5296: aload_0
    //   5297: ldc_w 945
    //   5300: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5303: aconst_null
    //   5304: iload 7
    //   5306: iload 6
    //   5308: aload 4
    //   5310: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5313: return
    //   5314: aload_1
    //   5315: getfield 944	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5318: iconst_3
    //   5319: if_icmpne +1788 -> 7107
    //   5322: iconst_1
    //   5323: istore 6
    //   5325: iconst_0
    //   5326: istore 7
    //   5328: goto -34 -> 5294
    //   5331: aload_1
    //   5332: getfield 948	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   5335: iconst_2
    //   5336: if_icmpne +1771 -> 7107
    //   5339: aload_1
    //   5340: invokestatic 953	com/tencent/mobileqq/scribble/ScribbleMsgUtils:a	(Lcom/tencent/mobileqq/data/MessageForScribble;)I
    //   5343: istore_3
    //   5344: getstatic 955	com/tencent/mobileqq/scribble/ScribbleMsgUtils:c	I
    //   5347: istore 8
    //   5349: iload_3
    //   5350: iload 8
    //   5352: if_icmpeq +1755 -> 7107
    //   5355: iconst_1
    //   5356: istore 7
    //   5358: iconst_0
    //   5359: istore 6
    //   5361: goto -67 -> 5294
    //   5364: astore_1
    //   5365: aload_1
    //   5366: invokevirtual 409	java/lang/Exception:printStackTrace	()V
    //   5369: iconst_0
    //   5370: istore 6
    //   5372: iconst_0
    //   5373: istore 7
    //   5375: goto -81 -> 5294
    //   5378: aload_2
    //   5379: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5382: ifnonnull +11 -> 5393
    //   5385: aload 4
    //   5387: ldc 119
    //   5389: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   5392: return
    //   5393: aload_2
    //   5394: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5397: sipush -5003
    //   5400: if_icmpne +13 -> 5413
    //   5403: aload 4
    //   5405: aload_2
    //   5406: invokevirtual 959	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5409: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   5412: return
    //   5413: aload_2
    //   5414: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5417: sipush -2033
    //   5420: if_icmpne +16 -> 5436
    //   5423: aconst_null
    //   5424: ldc_w 961
    //   5427: aconst_null
    //   5428: iconst_0
    //   5429: iconst_0
    //   5430: aload 4
    //   5432: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5435: return
    //   5436: aload_2
    //   5437: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5440: sipush -5010
    //   5443: if_icmpne +33 -> 5476
    //   5446: new 963	com/tencent/mobileqq/data/MessageForDingdongSchedule
    //   5449: dup
    //   5450: invokespecial 964	com/tencent/mobileqq/data/MessageForDingdongSchedule:<init>	()V
    //   5453: astore_0
    //   5454: aload_0
    //   5455: aload_2
    //   5456: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5459: putfield 965	com/tencent/mobileqq/data/MessageForDingdongSchedule:msgData	[B
    //   5462: aload_0
    //   5463: invokevirtual 966	com/tencent/mobileqq/data/MessageForDingdongSchedule:parse	()V
    //   5466: aload 4
    //   5468: aload_0
    //   5469: getfield 967	com/tencent/mobileqq/data/MessageForDingdongSchedule:msg	Ljava/lang/String;
    //   5472: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   5475: return
    //   5476: aload_2
    //   5477: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5480: sipush -2049
    //   5483: if_icmpne +16 -> 5499
    //   5486: aload 4
    //   5488: aload_2
    //   5489: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5492: invokestatic 492	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   5495: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   5498: return
    //   5499: aload_2
    //   5500: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5503: sipush -1035
    //   5506: if_icmpne +287 -> 5793
    //   5509: iconst_0
    //   5510: istore 10
    //   5512: iconst_0
    //   5513: istore 11
    //   5515: iload 10
    //   5517: istore 6
    //   5519: iload 11
    //   5521: istore 7
    //   5523: aload_2
    //   5524: invokevirtual 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   5527: ifeq +31 -> 5558
    //   5530: aload_2
    //   5531: getfield 865	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   5534: ldc_w 968
    //   5537: if_icmpne +171 -> 5708
    //   5540: aload_1
    //   5541: invokevirtual 971	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   5544: aload_2
    //   5545: invokevirtual 975	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5548: ifne +150 -> 5698
    //   5551: iconst_1
    //   5552: istore 6
    //   5554: iload 11
    //   5556: istore 7
    //   5558: aload_2
    //   5559: invokevirtual 959	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5562: astore_0
    //   5563: aload_2
    //   5564: invokestatic 978	com/tencent/mobileqq/troop/utils/TroopRobotManager:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5567: ifeq +1537 -> 7104
    //   5570: aload_2
    //   5571: invokestatic 980	com/tencent/mobileqq/troop/utils/TroopRobotManager:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5574: ifne +7 -> 5581
    //   5577: aload_2
    //   5578: invokestatic 983	com/tencent/mobileqq/troop/utils/TroopRobotManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   5581: aload_2
    //   5582: invokestatic 986	com/tencent/mobileqq/troop/utils/TroopRobotManager:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   5585: astore_1
    //   5586: aload_1
    //   5587: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5590: ifne +1514 -> 7104
    //   5593: aload_1
    //   5594: astore_0
    //   5595: aload_2
    //   5596: getfield 989	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   5599: ifnull +177 -> 5776
    //   5602: aload_0
    //   5603: ifnull +173 -> 5776
    //   5606: new 160	java/lang/StringBuilder
    //   5609: dup
    //   5610: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   5613: astore_1
    //   5614: aload 19
    //   5616: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5619: ifne +16 -> 5635
    //   5622: aload_1
    //   5623: aload 19
    //   5625: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5628: ldc_w 303
    //   5631: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5634: pop
    //   5635: aload_2
    //   5636: invokestatic 441	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5639: ifne +16 -> 5655
    //   5642: iload 6
    //   5644: ifeq +89 -> 5733
    //   5647: aload_1
    //   5648: ldc_w 698
    //   5651: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5654: pop
    //   5655: aload_0
    //   5656: instanceof 700
    //   5659: ifeq +90 -> 5749
    //   5662: aload_0
    //   5663: checkcast 700	com/tencent/mobileqq/text/QQText
    //   5666: aload_1
    //   5667: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5670: iconst_1
    //   5671: iconst_0
    //   5672: newarray int
    //   5674: invokevirtual 703	com/tencent/mobileqq/text/QQText:a	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   5677: astore_0
    //   5678: aload 4
    //   5680: iconst_1
    //   5681: putfield 715	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_Int	I
    //   5684: aload 19
    //   5686: aload_0
    //   5687: aconst_null
    //   5688: iload 6
    //   5690: iload 7
    //   5692: aload 4
    //   5694: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5697: return
    //   5698: iconst_1
    //   5699: istore 7
    //   5701: iload 10
    //   5703: istore 6
    //   5705: goto -147 -> 5558
    //   5708: iconst_0
    //   5709: istore 7
    //   5711: aload_2
    //   5712: getfield 865	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   5715: ldc_w 579
    //   5718: if_icmpne +9 -> 5727
    //   5721: iconst_1
    //   5722: istore 6
    //   5724: goto -166 -> 5558
    //   5727: iconst_0
    //   5728: istore 6
    //   5730: goto -6 -> 5724
    //   5733: iload 7
    //   5735: ifeq -80 -> 5655
    //   5738: aload_1
    //   5739: ldc_w 705
    //   5742: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5745: pop
    //   5746: goto -91 -> 5655
    //   5749: aload_1
    //   5750: aload_0
    //   5751: invokevirtual 992	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   5754: pop
    //   5755: new 994	android/text/SpannableString
    //   5758: dup
    //   5759: aload_1
    //   5760: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5763: invokespecial 997	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   5766: astore_0
    //   5767: aload 4
    //   5769: iconst_0
    //   5770: putfield 715	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_Int	I
    //   5773: goto -89 -> 5684
    //   5776: aload 19
    //   5778: aload_0
    //   5779: invokestatic 1000	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5782: aconst_null
    //   5783: iload 6
    //   5785: iload 7
    //   5787: aload 4
    //   5789: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5792: return
    //   5793: aload_2
    //   5794: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5797: sipush -2057
    //   5800: if_icmpne +17 -> 5817
    //   5803: aload 19
    //   5805: ldc_w 1002
    //   5808: aconst_null
    //   5809: iconst_0
    //   5810: iconst_0
    //   5811: aload 4
    //   5813: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5816: return
    //   5817: aload_2
    //   5818: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5821: sipush -1012
    //   5824: if_icmpne +70 -> 5894
    //   5827: aload_2
    //   5828: invokevirtual 959	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5831: invokeinterface 1005 1 0
    //   5836: invokestatic 492	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   5839: astore_1
    //   5840: aload_0
    //   5841: ldc_w 1006
    //   5844: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5847: astore_2
    //   5848: aload_1
    //   5849: invokevirtual 204	java/lang/String:length	()I
    //   5852: aload_2
    //   5853: invokevirtual 204	java/lang/String:length	()I
    //   5856: isub
    //   5857: iconst_1
    //   5858: isub
    //   5859: istore_3
    //   5860: aload_1
    //   5861: astore_0
    //   5862: aload_1
    //   5863: aload_2
    //   5864: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5867: ifeq +16 -> 5883
    //   5870: aload_1
    //   5871: astore_0
    //   5872: iload_3
    //   5873: ifle +10 -> 5883
    //   5876: aload_1
    //   5877: iconst_0
    //   5878: iload_3
    //   5879: invokevirtual 295	java/lang/String:substring	(II)Ljava/lang/String;
    //   5882: astore_0
    //   5883: aconst_null
    //   5884: aload_0
    //   5885: aconst_null
    //   5886: iconst_0
    //   5887: iconst_0
    //   5888: aload 4
    //   5890: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5893: return
    //   5894: aload_2
    //   5895: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5898: sipush -2059
    //   5901: if_icmpne +33 -> 5934
    //   5904: new 1008	com/tencent/mobileqq/data/MessageForTroopPobing
    //   5907: dup
    //   5908: invokespecial 1009	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   5911: astore_0
    //   5912: aload_0
    //   5913: aload_2
    //   5914: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5917: putfield 1010	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   5920: aload_0
    //   5921: invokevirtual 1013	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   5924: aload 4
    //   5926: aload_0
    //   5927: invokevirtual 1014	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   5930: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   5933: return
    //   5934: aload_2
    //   5935: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5938: sipush -2066
    //   5941: if_icmpne +87 -> 6028
    //   5944: new 1016	com/tencent/mobileqq/data/MessageForConfessCard
    //   5947: dup
    //   5948: invokespecial 1017	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   5951: astore_0
    //   5952: aload_0
    //   5953: aload_2
    //   5954: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5957: putfield 1018	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   5960: aload_0
    //   5961: invokevirtual 1019	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   5964: aload_2
    //   5965: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5968: sipush 1032
    //   5971: if_icmpne +18 -> 5989
    //   5974: aload 19
    //   5976: aload_0
    //   5977: getfield 1022	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   5980: aconst_null
    //   5981: iconst_0
    //   5982: iconst_0
    //   5983: aload 4
    //   5985: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5988: return
    //   5989: ldc 119
    //   5991: new 160	java/lang/StringBuilder
    //   5994: dup
    //   5995: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   5998: aload 19
    //   6000: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6003: ldc_w 1024
    //   6006: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6009: aload_0
    //   6010: getfield 1022	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6013: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6016: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6019: aconst_null
    //   6020: iconst_0
    //   6021: iconst_0
    //   6022: aload 4
    //   6024: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6027: return
    //   6028: aload_2
    //   6029: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6032: sipush -2067
    //   6035: if_icmpne +38 -> 6073
    //   6038: new 1026	com/tencent/mobileqq/data/MessageForTroopConfess
    //   6041: dup
    //   6042: invokespecial 1027	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   6045: astore_0
    //   6046: aload_0
    //   6047: aload_2
    //   6048: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6051: putfield 1028	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   6054: aload_0
    //   6055: invokevirtual 1029	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   6058: aload 19
    //   6060: aload_0
    //   6061: getfield 1030	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   6064: aconst_null
    //   6065: iconst_0
    //   6066: iconst_0
    //   6067: aload 4
    //   6069: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6072: return
    //   6073: aload_2
    //   6074: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6077: sipush -5008
    //   6080: if_icmpeq +23 -> 6103
    //   6083: aload_2
    //   6084: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6087: sipush -5016
    //   6090: if_icmpeq +13 -> 6103
    //   6093: aload_2
    //   6094: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6097: sipush -5017
    //   6100: if_icmpne +106 -> 6206
    //   6103: aload_2
    //   6104: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6107: sipush -5016
    //   6110: if_icmpne +64 -> 6174
    //   6113: new 1032	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6116: dup
    //   6117: invokespecial 1033	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6120: astore_0
    //   6121: aload_0
    //   6122: aload_2
    //   6123: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6126: putfield 1034	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6129: aload_0
    //   6130: invokevirtual 1035	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6133: aload 4
    //   6135: aload_0
    //   6136: invokevirtual 1038	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6139: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   6142: aload_1
    //   6143: aload_2
    //   6144: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6147: istore 6
    //   6149: aload_1
    //   6150: aload_2
    //   6151: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6154: istore 7
    //   6156: aload 19
    //   6158: aload 4
    //   6160: getfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   6163: aconst_null
    //   6164: iload 6
    //   6166: iload 7
    //   6168: aload 4
    //   6170: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6173: return
    //   6174: new 1040	com/tencent/mobileqq/data/MessageForArkApp
    //   6177: dup
    //   6178: invokespecial 1041	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6181: astore_0
    //   6182: aload_0
    //   6183: aload_2
    //   6184: getfield 686	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6187: putfield 1042	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6190: aload_0
    //   6191: invokevirtual 1043	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6194: aload 4
    //   6196: aload_0
    //   6197: invokevirtual 1044	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6200: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   6203: goto -61 -> 6142
    //   6206: aload_1
    //   6207: aload_2
    //   6208: invokestatic 519	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6211: istore 6
    //   6213: aload_1
    //   6214: aload_2
    //   6215: invokestatic 521	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6218: istore 7
    //   6220: aload_2
    //   6221: getfield 1047	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileType	I
    //   6224: lookupswitch	default:+52->6276, 1:+175->6399, 2:+256->6480, 8:+256->6480, 65536:+157->6381, 65538:+238->6462
    //   6277: ldc_w 653
    //   6280: invokevirtual 656	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   6283: astore 5
    //   6285: getstatic 661	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   6288: ifeq +328 -> 6616
    //   6291: aload 5
    //   6293: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6296: ifne +320 -> 6616
    //   6299: aload_1
    //   6300: aload_2
    //   6301: aload 4
    //   6303: invokestatic 696	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   6306: astore_0
    //   6307: new 160	java/lang/StringBuilder
    //   6310: dup
    //   6311: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6314: astore_1
    //   6315: aload 19
    //   6317: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6320: ifne +16 -> 6336
    //   6323: aload_1
    //   6324: aload 19
    //   6326: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6329: ldc_w 303
    //   6332: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6335: pop
    //   6336: aload_2
    //   6337: invokestatic 441	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6340: ifne +16 -> 6356
    //   6343: iload 6
    //   6345: ifeq +255 -> 6600
    //   6348: aload_1
    //   6349: ldc_w 698
    //   6352: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6355: pop
    //   6356: aload 19
    //   6358: aload_0
    //   6359: aload_1
    //   6360: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6363: iconst_1
    //   6364: iconst_0
    //   6365: newarray int
    //   6367: invokevirtual 703	com/tencent/mobileqq/text/QQText:a	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   6370: aconst_null
    //   6371: iload 6
    //   6373: iload 7
    //   6375: aload 4
    //   6377: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6380: return
    //   6381: aload 19
    //   6383: ldc 119
    //   6385: aload_2
    //   6386: getfield 487	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6389: iload 6
    //   6391: iload 7
    //   6393: aload 4
    //   6395: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6398: return
    //   6399: aload_2
    //   6400: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   6403: sipush 1001
    //   6406: if_icmpeq +13 -> 6419
    //   6409: aload_2
    //   6410: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   6413: sipush 10002
    //   6416: if_icmpne +26 -> 6442
    //   6419: aload_2
    //   6420: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6423: sipush -3001
    //   6426: if_icmpne +16 -> 6442
    //   6429: aload 4
    //   6431: aload_0
    //   6432: ldc_w 1048
    //   6435: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6438: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   6441: return
    //   6442: aload 19
    //   6444: aload_0
    //   6445: ldc_w 561
    //   6448: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6451: aconst_null
    //   6452: iload 6
    //   6454: iload 7
    //   6456: aload 4
    //   6458: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6461: return
    //   6462: aload 19
    //   6464: aload_0
    //   6465: ldc_w 561
    //   6468: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6471: aconst_null
    //   6472: iconst_0
    //   6473: iconst_0
    //   6474: aload 4
    //   6476: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6479: return
    //   6480: ldc_w 592
    //   6483: iconst_3
    //   6484: anewarray 4	java/lang/Object
    //   6487: dup
    //   6488: iconst_0
    //   6489: iload_3
    //   6490: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6493: aastore
    //   6494: dup
    //   6495: iconst_1
    //   6496: iload 6
    //   6498: invokestatic 597	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6501: aastore
    //   6502: dup
    //   6503: iconst_2
    //   6504: iload 7
    //   6506: invokestatic 597	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6509: aastore
    //   6510: invokestatic 602	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   6513: aload_0
    //   6514: ldc_w 585
    //   6517: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6520: astore 5
    //   6522: aload 5
    //   6524: astore_0
    //   6525: aload_2
    //   6526: invokestatic 573	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6529: ifeq +25 -> 6554
    //   6532: new 160	java/lang/StringBuilder
    //   6535: dup
    //   6536: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6539: ldc_w 575
    //   6542: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6545: aload 5
    //   6547: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6550: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6553: astore_0
    //   6554: aload_2
    //   6555: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   6558: aload_1
    //   6559: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6562: invokestatic 1053	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   6565: ifeq +22 -> 6587
    //   6568: iload_3
    //   6569: ifeq +18 -> 6587
    //   6572: aload 19
    //   6574: aload_0
    //   6575: ldc 119
    //   6577: iload 6
    //   6579: iload 7
    //   6581: aload 4
    //   6583: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6586: return
    //   6587: aload 19
    //   6589: aload_0
    //   6590: ldc 119
    //   6592: iconst_0
    //   6593: iconst_0
    //   6594: aload 4
    //   6596: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6599: return
    //   6600: iload 7
    //   6602: ifeq -246 -> 6356
    //   6605: aload_1
    //   6606: ldc_w 705
    //   6609: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6612: pop
    //   6613: goto -257 -> 6356
    //   6616: aload_2
    //   6617: invokevirtual 959	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6620: astore 5
    //   6622: aload_2
    //   6623: invokestatic 978	com/tencent/mobileqq/troop/utils/TroopRobotManager:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6626: ifeq +475 -> 7101
    //   6629: aload_2
    //   6630: invokestatic 980	com/tencent/mobileqq/troop/utils/TroopRobotManager:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6633: ifne +7 -> 6640
    //   6636: aload_2
    //   6637: invokestatic 983	com/tencent/mobileqq/troop/utils/TroopRobotManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   6640: aload_2
    //   6641: invokestatic 986	com/tencent/mobileqq/troop/utils/TroopRobotManager:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   6644: astore 16
    //   6646: aload 16
    //   6648: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6651: ifne +450 -> 7101
    //   6654: aload 16
    //   6656: astore 5
    //   6658: aload_2
    //   6659: getfield 989	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   6662: ifnull +247 -> 6909
    //   6665: aload 5
    //   6667: ifnull +242 -> 6909
    //   6670: new 160	java/lang/StringBuilder
    //   6673: dup
    //   6674: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6677: astore_0
    //   6678: aload 19
    //   6680: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6683: ifne +16 -> 6699
    //   6686: aload_0
    //   6687: aload 19
    //   6689: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6692: ldc_w 303
    //   6695: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6698: pop
    //   6699: aload_2
    //   6700: invokestatic 441	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6703: ifne +16 -> 6719
    //   6706: iload 6
    //   6708: ifeq +157 -> 6865
    //   6711: aload_0
    //   6712: ldc_w 698
    //   6715: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6718: pop
    //   6719: aload_2
    //   6720: invokestatic 573	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6723: ifeq +11 -> 6734
    //   6726: aload_0
    //   6727: ldc_w 575
    //   6730: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6733: pop
    //   6734: aload 5
    //   6736: instanceof 700
    //   6739: ifeq +142 -> 6881
    //   6742: aload 5
    //   6744: checkcast 700	com/tencent/mobileqq/text/QQText
    //   6747: aload_0
    //   6748: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6751: iconst_1
    //   6752: iconst_3
    //   6753: newarray int
    //   6755: dup
    //   6756: iconst_0
    //   6757: aload 5
    //   6759: checkcast 700	com/tencent/mobileqq/text/QQText
    //   6762: getfield 1054	com/tencent/mobileqq/text/QQText:jdField_a_of_type_Int	I
    //   6765: iastore
    //   6766: dup
    //   6767: iconst_1
    //   6768: bipush 16
    //   6770: iastore
    //   6771: dup
    //   6772: iconst_2
    //   6773: iconst_1
    //   6774: iastore
    //   6775: invokevirtual 703	com/tencent/mobileqq/text/QQText:a	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   6778: astore_0
    //   6779: aload 4
    //   6781: iconst_1
    //   6782: putfield 715	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_Int	I
    //   6785: aload_2
    //   6786: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6789: sipush -5040
    //   6792: if_icmpne +306 -> 7098
    //   6795: new 160	java/lang/StringBuilder
    //   6798: dup
    //   6799: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6802: ldc_w 420
    //   6805: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6808: invokestatic 1058	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6811: ldc_w 1059
    //   6814: invokevirtual 1060	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   6817: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6820: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6823: astore_1
    //   6824: aload_0
    //   6825: invokeinterface 1005 1 0
    //   6830: astore_2
    //   6831: aload_2
    //   6832: ifnull +266 -> 7098
    //   6835: aload_2
    //   6836: aload_1
    //   6837: invokevirtual 1063	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   6840: ifeq +258 -> 7098
    //   6843: aload_2
    //   6844: aload_1
    //   6845: ldc 119
    //   6847: invokevirtual 275	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   6850: astore_0
    //   6851: aload 19
    //   6853: aload_0
    //   6854: aconst_null
    //   6855: iload 6
    //   6857: iload 7
    //   6859: aload 4
    //   6861: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6864: return
    //   6865: iload 7
    //   6867: ifeq -148 -> 6719
    //   6870: aload_0
    //   6871: ldc_w 705
    //   6874: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6877: pop
    //   6878: goto -159 -> 6719
    //   6881: aload_0
    //   6882: aload 5
    //   6884: invokevirtual 992	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6887: pop
    //   6888: new 994	android/text/SpannableString
    //   6891: dup
    //   6892: aload_0
    //   6893: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6896: invokespecial 997	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   6899: astore_0
    //   6900: aload 4
    //   6902: iconst_0
    //   6903: putfield 715	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_Int	I
    //   6906: goto -121 -> 6785
    //   6909: aload 5
    //   6911: ifnull +158 -> 7069
    //   6914: aload 5
    //   6916: invokeinterface 1005 1 0
    //   6921: invokevirtual 188	java/lang/String:trim	()Ljava/lang/String;
    //   6924: astore 5
    //   6926: getstatic 1065	com/tencent/mobileqq/app/AppConstants:F	Ljava/lang/String;
    //   6929: aload_2
    //   6930: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   6933: invokevirtual 1068	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6936: ifeq +156 -> 7092
    //   6939: aload 5
    //   6941: ifnull +151 -> 7092
    //   6944: aload 5
    //   6946: invokevirtual 204	java/lang/String:length	()I
    //   6949: ifle +143 -> 7092
    //   6952: aload_0
    //   6953: aload_1
    //   6954: aload 5
    //   6956: aload_2
    //   6957: invokestatic 1070	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   6960: astore_0
    //   6961: aload 19
    //   6963: aconst_null
    //   6964: aload_0
    //   6965: iload 6
    //   6967: aload_1
    //   6968: invokevirtual 971	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   6971: aload_2
    //   6972: invokevirtual 975	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6975: aload 4
    //   6977: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6980: aload_2
    //   6981: invokestatic 573	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6984: ifeq +40 -> 7024
    //   6987: aload 4
    //   6989: getfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   6992: ifnull +32 -> 7024
    //   6995: aload 4
    //   6997: new 160	java/lang/StringBuilder
    //   7000: dup
    //   7001: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   7004: ldc_w 575
    //   7007: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7010: aload 4
    //   7012: getfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   7015: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7018: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7021: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   7024: aload_2
    //   7025: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   7028: sipush -1000
    //   7031: if_icmpne +44 -> 7075
    //   7034: aload 4
    //   7036: getfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   7039: ifnull +36 -> 7075
    //   7042: aload 4
    //   7044: new 700	com/tencent/mobileqq/text/QQText
    //   7047: dup
    //   7048: aload 4
    //   7050: getfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   7053: iconst_1
    //   7054: bipush 16
    //   7056: invokespecial 1073	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   7059: putfield 497	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   7062: aload 4
    //   7064: iconst_1
    //   7065: putfield 715	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_Int	I
    //   7068: return
    //   7069: aconst_null
    //   7070: astore 5
    //   7072: goto -146 -> 6926
    //   7075: aload 4
    //   7077: iconst_0
    //   7078: putfield 715	com/tencent/mobileqq/activity/recent/MsgSummary:jdField_b_of_type_Int	I
    //   7081: return
    //   7082: astore 5
    //   7084: goto -2350 -> 4734
    //   7087: astore 5
    //   7089: goto -6327 -> 762
    //   7092: aload 5
    //   7094: astore_0
    //   7095: goto -134 -> 6961
    //   7098: goto -247 -> 6851
    //   7101: goto -443 -> 6658
    //   7104: goto -1509 -> 5595
    //   7107: iconst_0
    //   7108: istore 6
    //   7110: iconst_0
    //   7111: istore 7
    //   7113: goto -1819 -> 5294
    //   7116: goto -3744 -> 3372
    //   7119: iconst_0
    //   7120: istore 6
    //   7122: goto -4784 -> 2338
    //   7125: goto -4870 -> 2255
    //   7128: aload 5
    //   7130: astore_0
    //   7131: goto -5199 -> 1932
    //   7134: goto -5570 -> 1564
    //   7137: iconst_0
    //   7138: istore 6
    //   7140: iconst_0
    //   7141: istore 7
    //   7143: goto -6161 -> 982
    //   7146: goto -6264 -> 882
    //   7149: aload_1
    //   7150: astore_0
    //   7151: goto -6473 -> 678
    //   7154: iconst_0
    //   7155: istore 6
    //   7157: goto -6618 -> 539
    //   7160: iconst_0
    //   7161: istore 6
    //   7163: goto -6654 -> 509
    //   7166: goto -6726 -> 440
    //   7169: aload 16
    //   7171: astore 5
    //   7173: goto -7055 -> 118
    //   7176: iconst_0
    //   7177: istore 6
    //   7179: goto -6670 -> 509
    //   7182: iconst_1
    //   7183: istore_3
    //   7184: goto -5366 -> 1818
    //   7187: astore_1
    //   7188: aload 17
    //   7190: astore_0
    //   7191: goto -5176 -> 2015
    //   7194: iconst_0
    //   7195: istore 6
    //   7197: goto -4859 -> 2338
    //   7200: ldc2_w 39
    //   7203: lstore 14
    //   7205: goto -4787 -> 2418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7208	0	paramContext	Context
    //   0	7208	1	paramQQAppInterface	QQAppInterface
    //   0	7208	2	paramMessage	QQMessageFacade.Message
    //   0	7208	3	paramInt	int
    //   0	7208	4	paramMsgSummary	MsgSummary
    //   0	7208	5	paramString	String
    //   0	7208	6	paramBoolean1	boolean
    //   0	7208	7	paramBoolean2	boolean
    //   240	5113	8	i	int
    //   1690	516	9	j	int
    //   412	5290	10	bool1	boolean
    //   2209	3346	11	bool2	boolean
    //   1630	537	12	bool3	boolean
    //   1637	540	13	bool4	boolean
    //   493	6711	14	l	long
    //   7	7163	16	localObject	Object
    //   1644	5545	17	str1	String
    //   1623	659	18	str2	String
    //   202	6760	19	str3	String
    //   2279	256	20	localMessageForPic	com.tencent.mobileqq.data.MessageForPic
    // Exception table:
    //   from	to	target	type
    //   414	440	758	java/lang/Exception
    //   440	476	758	java/lang/Exception
    //   1865	1894	2014	java/lang/Exception
    //   1894	1901	2014	java/lang/Exception
    //   1906	1914	2014	java/lang/Exception
    //   1914	1930	2014	java/lang/Exception
    //   2003	2011	2014	java/lang/Exception
    //   2221	2227	2601	java/lang/Exception
    //   2231	2245	2601	java/lang/Exception
    //   2249	2255	2601	java/lang/Exception
    //   2259	2281	2601	java/lang/Exception
    //   2285	2299	2601	java/lang/Exception
    //   2302	2309	2601	java/lang/Exception
    //   2312	2319	2601	java/lang/Exception
    //   2534	2545	2601	java/lang/Exception
    //   2558	2565	2601	java/lang/Exception
    //   2568	2577	2601	java/lang/Exception
    //   2753	2787	2889	java/lang/Throwable
    //   2803	2852	2889	java/lang/Throwable
    //   2857	2884	2889	java/lang/Throwable
    //   4287	4293	4730	java/lang/Exception
    //   4293	4313	4730	java/lang/Exception
    //   4313	4327	4730	java/lang/Exception
    //   5224	5230	5364	java/lang/Exception
    //   5230	5250	5364	java/lang/Exception
    //   5250	5283	5364	java/lang/Exception
    //   5314	5322	5364	java/lang/Exception
    //   5331	5349	5364	java/lang/Exception
    //   4331	4339	7082	java/lang/Exception
    //   4343	4356	7082	java/lang/Exception
    //   4360	4367	7082	java/lang/Exception
    //   4379	4390	7082	java/lang/Exception
    //   4394	4405	7082	java/lang/Exception
    //   4409	4420	7082	java/lang/Exception
    //   4424	4435	7082	java/lang/Exception
    //   4439	4466	7082	java/lang/Exception
    //   476	483	7087	java/lang/Exception
    //   488	495	7087	java/lang/Exception
    //   697	708	7087	java/lang/Exception
    //   718	734	7087	java/lang/Exception
    //   1646	1655	7187	java/lang/Exception
    //   1663	1671	7187	java/lang/Exception
    //   1675	1692	7187	java/lang/Exception
    //   1703	1710	7187	java/lang/Exception
    //   1736	1749	7187	java/lang/Exception
    //   1753	1759	7187	java/lang/Exception
    //   1763	1770	7187	java/lang/Exception
    //   1774	1788	7187	java/lang/Exception
    //   1792	1815	7187	java/lang/Exception
    //   1830	1836	7187	java/lang/Exception
    //   1840	1853	7187	java/lang/Exception
    //   1857	1865	7187	java/lang/Exception
    //   1956	1979	7187	java/lang/Exception
    //   1986	1993	7187	java/lang/Exception
    //   2050	2055	7187	java/lang/Exception
    //   2063	2071	7187	java/lang/Exception
    //   2075	2083	7187	java/lang/Exception
    //   2087	2100	7187	java/lang/Exception
    //   2104	2111	7187	java/lang/Exception
    //   2120	2128	7187	java/lang/Exception
    //   2132	2148	7187	java/lang/Exception
    //   2152	2158	7187	java/lang/Exception
    //   2162	2175	7187	java/lang/Exception
    //   2185	2193	7187	java/lang/Exception
    //   2346	2353	7187	java/lang/Exception
    //   2357	2362	7187	java/lang/Exception
    //   2366	2377	7187	java/lang/Exception
    //   2388	2394	7187	java/lang/Exception
    //   2398	2405	7187	java/lang/Exception
    //   2409	2418	7187	java/lang/Exception
    //   2422	2463	7187	java/lang/Exception
    //   2471	2479	7187	java/lang/Exception
    //   2483	2490	7187	java/lang/Exception
    //   2494	2501	7187	java/lang/Exception
    //   2505	2513	7187	java/lang/Exception
    //   2517	2530	7187	java/lang/Exception
    //   2606	2610	7187	java/lang/Exception
    //   2638	2644	7187	java/lang/Exception
    //   2648	2675	7187	java/lang/Exception
  }
  
  private static void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean1, boolean paramBoolean2, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.jdField_a_of_type_JavaLangCharSequence = paramCharSequence1;
    paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramCharSequence2;
    paramMsgSummary.c = paramCharSequence3;
    if (paramBoolean1)
    {
      paramMsgSummary.jdField_a_of_type_Int = 2;
      return;
    }
    if (paramBoolean2)
    {
      paramMsgSummary.jdField_a_of_type_Int = 1;
      return;
    }
    paramMsgSummary.jdField_a_of_type_Int = 0;
  }
  
  public static boolean a(int paramInt)
  {
    return (1 == paramInt) || (2 == paramInt);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    QQMessageFacade.Message localMessage = paramMessage;
    if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (MsgProxyUtils.c(paramMessage.senderuin)) {
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
      localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, i);
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
      paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && ((paramMessage instanceof MessageForTroopFile)))
      {
        paramMessage = (MessageForTroopFile)paramMessage;
        if ((paramMessage != null) && (paramMessage.frienduin != null))
        {
          paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.jdField_b_of_type_Int == 1) || (paramQQAppInterface.jdField_b_of_type_Int == 0))) {
            return true;
          }
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof BuddyTransfileProcessor)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((BuddyTransfileProcessor)paramMessage).f() >= 0) && (((BuddyTransfileProcessor)paramMessage).f() != 100)) {
      return true;
    }
    return paramQQAppInterface.a().b(localMessage);
  }
  
  public static String b(String paramString)
  {
    return a(paramString, 1.0F);
  }
  
  public static boolean b(int paramInt)
  {
    return 1 == paramInt;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    QQMessageFacade.Message localMessage;
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
          if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
            break;
          }
          localMessage = paramMessage;
          if (paramMessage.senderuin == null) {
            break;
          }
        } while (MsgProxyUtils.c(paramMessage.senderuin));
        int i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (!paramMessage.isSelfConfessor()) {
            break label105;
          }
        }
        for (i = 1033;; i = 1034)
        {
          localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, i);
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
          i = paramQQAppInterface.a().b(localMessage.frienduin, null, localMessage.uniseq);
          if ((i != 1005) && (i != 1004)) {
            break;
          }
          return true;
        }
        if (localMessage.msgtype != -2017) {
          break;
        }
        paramMessage = (MessageForTroopFile)paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      } while ((paramMessage == null) || (paramMessage.frienduin == null));
      paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.jdField_b_of_type_Int != 3));
    return true;
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
  
  public static boolean c(int paramInt)
  {
    return 2 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MsgUtils
 * JD-Core Version:    0.7.0.1
 */