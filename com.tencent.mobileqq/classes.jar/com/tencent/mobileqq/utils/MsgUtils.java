package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

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
      return paramQQAppInterface.getApp().getString(2131435936);
    }
    return paramQQAppInterface.getApp().getString(2131435934) + paramContext.messagetail + paramQQAppInterface.getApp().getString(2131435935);
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
                  paramContext = paramContext.getString(2131434668);
                  break;
                  paramContext = paramContext.getString(2131434669);
                  break;
                  paramContext = paramContext.getString(2131434670);
                  break;
                  paramContext = paramContext.getString(2131434678);
                  break;
                  paramContext = paramContext.getString(2131434679);
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
      ((StringBuffer)localObject).append(i).append(paramContext.getString(2131433086));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131433089));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131433090));
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
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMessage == null) {}
    Object localObject;
    label118:
    String str3;
    int i;
    boolean bool1;
    label440:
    label509:
    do
    {
      do
      {
        do
        {
          return;
          localObject = paramString;
          if (!AnonymousChatHelper.a(paramMessage)) {
            break label6913;
          }
          if (!TextUtils.isEmpty(paramString))
          {
            localObject = paramString;
            if (paramString.equals(ContactUtils.a(paramQQAppInterface, paramMessage.frienduin, true))) {
              break label6913;
            }
          }
          localObject = paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
          if ((localObject instanceof ChatMessage)) {
            ((ChatMessage)localObject).parse();
          }
          if (localObject != null) {
            paramString = AnonymousChatHelper.a((MessageRecord)localObject).b;
          }
          localObject = paramString;
          if (!TextUtils.isEmpty(paramString)) {
            break label6913;
          }
          paramString = AnonymousChatHelper.a(paramMessage).b;
          localObject = paramString;
          if (!paramBoolean1) {
            if (!paramMessage.isSendFromLocal())
            {
              localObject = paramString;
              if (paramMessage.selfuin != null)
              {
                localObject = paramString;
                if (!paramMessage.selfuin.equals(paramMessage.senderuin)) {}
              }
            }
            else
            {
              localObject = null;
            }
          }
          if (MsgProxyUtils.j(paramMessage.msgtype)) {
            localObject = null;
          }
          paramString = TroopBusinessUtil.a(paramMessage);
          if (paramString != null) {
            localObject = paramString.c;
          }
          str3 = b((String)localObject);
          if (paramMessage.msgtype == -2034)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = MessageForGrayTips.getOrginMsg(paramMessage.msg);
            return;
          }
          if (paramMessage.msgtype != -2011) {
            break;
          }
          paramInt = 0;
          i = 0;
          if ((paramMessage.msgtype == -2011) && (paramMessage.extInt == 61)) {
            paramMessage.msg = paramQQAppInterface.getApp().getResources().getString(2131433677);
          }
          if (paramMessage.istroop == 1)
          {
            paramContext = paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
            paramInt = i;
            if (NearbyFlowerUtil.a(paramContext))
            {
              a(null, null, NearbyFlowerUtil.a((MessageForStructing)paramContext), false, false, paramMsgSummary);
              paramInt = 1;
            }
            if (TroopBindPublicAccountMgr.a(paramContext))
            {
              a(null, null, paramMessage.msg, false, false, paramMsgSummary);
              paramInt = 1;
            }
          }
        } while (paramInt != 0);
        paramBoolean1 = b(paramQQAppInterface, paramMessage);
        paramBoolean2 = a(paramQQAppInterface, paramMessage);
        a(str3, null, paramMessage.msg, paramBoolean1, paramBoolean2, paramMsgSummary);
        return;
        if ((paramMessage.msgtype == -2000) || (paramMessage.msgtype == -5015))
        {
          bool1 = false;
          try
          {
            paramString = paramMessage.frienduin;
            if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
              break label6910;
            }
            paramString = paramMessage.senderuin;
            localObject = (MessageForPic)paramQQAppInterface.a().b(paramString, paramMessage.istroop, paramMessage.uniseq);
            paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramMessage.uniseq);
          }
          catch (Exception paramString)
          {
            paramQQAppInterface = null;
          }
        }
        try
        {
          if (!paramMessage.isSendFromLocal()) {
            break label714;
          }
          if (localObject == null) {
            break label692;
          }
          l = ((MessageForPic)localObject).size;
          if (l > 0L) {
            break label692;
          }
          if (paramQQAppInterface != null) {
            break label6904;
          }
          paramBoolean1 = true;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            String str2;
            boolean bool3;
            boolean bool4;
            continue;
            paramContext = paramString;
            continue;
            continue;
            continue;
            continue;
            paramBoolean1 = false;
            paramBoolean2 = false;
            continue;
            continue;
            paramBoolean1 = false;
            continue;
            continue;
            paramContext = paramString;
            continue;
            continue;
            paramBoolean1 = false;
            paramBoolean2 = false;
          }
          paramContext = paramQQAppInterface;
          break label678;
          paramBoolean1 = false;
          break label539;
          paramBoolean1 = false;
          break label509;
        }
        paramBoolean2 = paramBoolean1;
        if ((paramQQAppInterface instanceof BaseTransProcessor))
        {
          paramQQAppInterface = (BaseTransProcessor)paramQQAppInterface;
          if (paramQQAppInterface.c() == 1003L) {
            break label6898;
          }
          paramBoolean1 = true;
          if (QLog.isColorLevel())
          {
            if (paramQQAppInterface.a == null) {
              break label773;
            }
            l = paramQQAppInterface.a.jdField_a_of_type_Long;
            QLog.d("sendingpic", 2, "uniseq:" + l + ",key:" + paramQQAppInterface.a());
          }
        }
        for (;;)
        {
          paramQQAppInterface = paramContext.getString(2131435567);
          if ((HotChatHelper.a(paramMessage)) || (FlashPicHelper.a(paramMessage))) {
            paramQQAppInterface = paramContext.getString(2131435568);
          }
          if (paramMessage.msgtype == -5015) {
            paramQQAppInterface = paramContext.getString(2131435569);
          }
          if (!GoldMsgChatHelper.c(paramMessage)) {
            break label6893;
          }
          paramContext = "[句有料]" + paramQQAppInterface;
          a(str3, paramContext, null, paramBoolean2, paramBoolean1, paramMsgSummary);
          return;
          if (localObject == null) {
            break label6904;
          }
          if (((MessageForPic)localObject).extraflag != 32768) {
            break label6920;
          }
          paramBoolean1 = true;
          break;
          if ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof BaseTransProcessor))) {
            break label6904;
          }
          l = ((BaseTransProcessor)paramQQAppInterface).c();
          paramInt = (int)l;
          if ((paramInt != 1005) && (paramInt != 1004)) {
            break label6904;
          }
          paramBoolean1 = true;
          break;
          paramString.printStackTrace();
          paramBoolean2 = false;
          break label513;
          l = -1L;
          break label561;
          paramBoolean1 = bool1;
          if (paramQQAppInterface != null)
          {
            bool1 = true;
            paramBoolean1 = bool1;
            if (QLog.isColorLevel())
            {
              QLog.d("sendingpic", 2, "processor:" + paramQQAppInterface);
              paramBoolean1 = bool1;
            }
          }
        }
        if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
        {
          paramString = paramMessage.frienduin;
          if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
            break label6890;
          }
          paramString = paramMessage.senderuin;
          localObject = paramContext.getString(2131435570);
          paramContext = (Context)localObject;
          if (GoldMsgChatHelper.c(paramMessage)) {
            paramContext = "[句有料]" + (String)localObject;
          }
          localObject = paramQQAppInterface.a().b(paramString, paramMessage.istroop, paramMessage.uniseq);
          if (!(localObject instanceof MessageForPtt)) {
            break label6881;
          }
          localObject = (MessageForPtt)localObject;
          if (!paramMessage.isSendFromLocal()) {
            break label6881;
          }
          if (((MessageForPtt)localObject).fileSize == -1L)
          {
            paramBoolean1 = true;
            paramBoolean2 = false;
            DatingUtil.a("buildMsgSummaryForMsg", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
            a(str3, paramContext, null, paramBoolean1, paramBoolean2, paramMsgSummary);
            return;
          }
          if (((MessageForPtt)localObject).fileSize > 0L) {
            break label6881;
          }
          paramInt = paramQQAppInterface.a().b(paramString, ((MessageForPtt)localObject).url, ((MessageForPtt)localObject).uniseq);
          if ((paramInt == 1005) || (paramInt == 1004) || (paramInt == -1))
          {
            paramBoolean1 = true;
            paramBoolean2 = false;
          }
          for (;;)
          {
            DatingUtil.a("buildMsgSummaryForMsg", new Object[] { Long.valueOf(((MessageForPtt)localObject).fileSize), Integer.valueOf(paramInt) });
            break;
            paramBoolean2 = true;
            paramBoolean1 = false;
          }
        }
        if (paramMessage.msgtype == -3008)
        {
          paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = (paramContext.getString(2131428259) + "\"" + paramMessage.msg + "\"");
          return;
        }
        if ((paramMessage.msgtype == -2015) || (paramMessage.msgtype == -2060) || (paramMessage.msgtype == -2065) || (paramMessage.msgtype == -2062))
        {
          paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
          return;
        }
        if (ActionMsgUtil.a(paramMessage.msgtype))
        {
          a(str3, a(paramContext, paramQQAppInterface, paramMessage), null, b(paramQQAppInterface, paramMessage), a(paramQQAppInterface, paramMessage), paramMsgSummary);
          return;
        }
        if (paramMessage.msgtype == -2017)
        {
          paramString = paramContext.getString(2131430385);
          paramContext = paramMessage.frienduin;
          if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
            paramContext = paramMessage.senderuin;
          }
          localObject = paramQQAppInterface.a().b(paramContext, paramMessage.istroop, paramMessage.uniseq);
          paramContext = paramString;
          if ((localObject instanceof MessageForTroopFile)) {
            paramContext = ((MessageForTroopFile)localObject).getSummaryMsg();
          }
          a(str3, paramContext, null, b(paramQQAppInterface, paramMessage), a(paramQQAppInterface, paramMessage), paramMsgSummary);
          return;
        }
        if (!ActionMsgUtil.b(paramMessage.msgtype)) {
          break;
        }
        paramQQAppInterface = TransfileUtile.a(paramMessage.msg);
      } while (paramQQAppInterface == null);
      paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(paramQQAppInterface, paramContext, b(paramMessage.issend), paramBoolean2);
      return;
      if (!ActionMsgUtil.c(paramMessage.msgtype)) {
        break;
      }
      paramString = TransfileUtile.a(paramMessage.msg);
    } while (paramString == null);
    label513:
    label539:
    label561:
    label692:
    label714:
    paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(paramQQAppInterface, paramString, paramContext, paramMessage.frienduin, paramMessage.senderuin, paramInt);
    label678:
    return;
    label773:
    if (ActionMsgUtil.d(paramMessage.msgtype))
    {
      paramBoolean1 = b(paramQQAppInterface, paramMessage);
      paramBoolean2 = a(paramQQAppInterface, paramMessage);
      paramString = paramMessage.getExtInfoFromExtStr("sticker_info");
      if ((EmojiStickerManager.e) && (!TextUtils.isEmpty(paramString)))
      {
        paramContext = EmosmUtils.a(paramContext, paramMessage);
        if (paramMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin())) {
          paramContext = "我贴了一个" + paramContext;
        }
      }
      while ((GoldMsgChatHelper.c(paramMessage)) && (paramContext != null))
      {
        paramContext = "[句有料]" + paramContext;
        a(str3, paramContext, null, paramBoolean1, paramBoolean2, paramMsgSummary);
        return;
        paramContext = "贴了一个" + paramContext;
        continue;
        paramContext = EmosmUtils.a(paramContext, paramMessage);
      }
    }
    if (paramMessage.msgtype == -2058)
    {
      str2 = "";
      bool3 = b(paramQQAppInterface, paramMessage);
      bool4 = a(paramQQAppInterface, paramMessage);
      i = 0;
      str1 = str2;
    }
    for (;;)
    {
      try
      {
        paramString = paramMessage.getExtInfoFromExtStr("Emoji_Sticker_Info");
        localObject = str2;
        str1 = str2;
        if (!TextUtils.isEmpty(paramString))
        {
          str1 = str2;
          j = new JSONObject(paramString).optInt("msgType");
          paramInt = i;
          paramString = str2;
          str1 = str2;
          if (paramMessage.msgData != null)
          {
            paramInt = i;
            paramString = str2;
            if (j == -2007)
            {
              paramInt = i;
              paramString = str2;
              str1 = str2;
              if ((MessagePkgUtils.a(paramMessage.msgData) instanceof MarkFaceMessage))
              {
                str1 = str2;
                if (!EmojiStickerManager.e) {
                  continue;
                }
                str1 = str2;
                paramString = EmosmUtils.a(paramContext, paramMessage);
                str1 = str2;
                if (!paramMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin())) {
                  continue;
                }
                str1 = str2;
                paramString = "我贴了一个" + paramString;
                continue;
              }
            }
          }
          localObject = paramString;
          if (paramInt == 0)
          {
            str1 = paramString;
            if (!EmojiStickerManager.e) {
              continue;
            }
            str1 = paramString;
            if (TextUtils.isEmpty(paramMessage.getExtInfoFromExtStr("sticker_info"))) {
              continue;
            }
            str1 = paramString;
            paramContext = EmojiStickerManager.a(paramQQAppInterface, paramMessage, paramMsgSummary);
          }
        }
        try
        {
          paramQQAppInterface = new StringBuilder();
          if (!TextUtils.isEmpty(str3)) {
            paramQQAppInterface.append(str3).append(": ");
          }
          if (!AnonymousChatHelper.a(paramMessage))
          {
            if (bool3) {
              paramQQAppInterface.append("F ");
            }
          }
          else
          {
            paramQQAppInterface = ((QQText)paramContext).a(paramQQAppInterface.toString(), true, new int[0]);
            paramContext = paramQQAppInterface;
            localObject = paramContext;
            paramMessage = (QQMessageFacade.Message)localObject;
            a(str3, paramMessage, null, bool3, bool4, paramMsgSummary);
            return;
            str1 = str2;
            paramString = "贴了一个" + paramString;
            continue;
            str1 = str2;
            paramString = EmosmUtils.a(paramContext, paramMessage);
            paramInt = 1;
            continue;
          }
          if (!bool4) {
            continue;
          }
          paramQQAppInterface.append("S ");
          continue;
          paramMessage = paramContext;
        }
        catch (Exception paramQQAppInterface) {}
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        boolean bool2;
        label6881:
        label6890:
        label6893:
        label6898:
        label6904:
        label6910:
        paramContext = str1;
        label6913:
        label6920:
        continue;
        paramBoolean1 = false;
        continue;
        l = -1L;
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("MsgUtils", 2, "", paramQQAppInterface);
        paramMessage = paramContext;
        continue;
        if (j == -1000)
        {
          str1 = paramString;
          paramContext = EmojiStickerManager.a(paramMessage);
          if (paramContext == null) {
            break;
          }
          str1 = paramString;
          paramQQAppInterface = new StringBuilder();
          str1 = paramString;
          if (!TextUtils.isEmpty(str3))
          {
            str1 = paramString;
            paramQQAppInterface.append(str3).append(": ");
          }
          str1 = paramString;
          if (!AnonymousChatHelper.a(paramMessage))
          {
            if (bool3)
            {
              str1 = paramString;
              paramQQAppInterface.append("F ");
            }
          }
          else
          {
            str1 = paramString;
            paramContext = ((QQText)paramContext).a(paramQQAppInterface.toString(), true, new int[0]);
            str1 = paramString;
            paramMsgSummary.jdField_b_of_type_Int = 1;
            str1 = paramString;
            a(str3, paramContext, null, bool3, bool4, paramMsgSummary);
            return;
          }
          if (!bool4) {
            continue;
          }
          str1 = paramString;
          paramQQAppInterface.append("S ");
          continue;
        }
        localObject = paramString;
        if (j == -2000)
        {
          bool2 = false;
          paramBoolean2 = false;
          str2 = null;
          localObject = str2;
          try
          {
            str1 = paramMessage.frienduin;
            localObject = str2;
            if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
              continue;
            }
            localObject = str2;
            str1 = paramMessage.senderuin;
            localObject = str2;
            localMessageForPic = (MessageForPic)paramQQAppInterface.a().b(str1, paramMessage.istroop, paramMessage.uniseq);
            localObject = str2;
            paramQQAppInterface = paramQQAppInterface.a().a(str1, paramMessage.uniseq);
            localObject = paramQQAppInterface;
            if (!paramMessage.isSendFromLocal()) {
              continue;
            }
            localObject = paramQQAppInterface;
            l = localMessageForPic.size;
            if (l > 0L) {
              continue;
            }
            if ((paramQQAppInterface != null) || (localMessageForPic == null)) {
              continue;
            }
            paramBoolean1 = true;
            bool1 = paramBoolean1;
          }
          catch (Exception paramQQAppInterface)
          {
            MessageForPic localMessageForPic;
            str1 = paramString;
            paramQQAppInterface.printStackTrace();
            paramQQAppInterface = (QQAppInterface)localObject;
            bool1 = false;
            continue;
            paramBoolean1 = bool2;
            if (paramQQAppInterface == null) {
              continue;
            }
            paramBoolean2 = true;
            paramBoolean1 = paramBoolean2;
            str1 = paramString;
            if (!QLog.isColorLevel()) {
              continue;
            }
            str1 = paramString;
            QLog.d("sendingpic", 2, "processor:" + paramQQAppInterface);
            paramBoolean1 = paramBoolean2;
            continue;
          }
          str1 = paramString;
          if ((paramQQAppInterface instanceof BaseTransProcessor))
          {
            str1 = paramString;
            paramQQAppInterface = (BaseTransProcessor)paramQQAppInterface;
            str1 = paramString;
            if (paramQQAppInterface.c() != 1003L) {
              paramBoolean2 = true;
            }
            paramBoolean1 = paramBoolean2;
            str1 = paramString;
            if (QLog.isColorLevel())
            {
              str1 = paramString;
              if (paramQQAppInterface.a == null) {
                continue;
              }
              str1 = paramString;
              l = paramQQAppInterface.a.jdField_a_of_type_Long;
              str1 = paramString;
              QLog.d("sendingpic", 2, "uniseq:" + l + ",key:" + paramQQAppInterface.a());
              paramBoolean1 = paramBoolean2;
            }
            str1 = paramString;
            paramQQAppInterface = paramContext.getString(2131435567);
            str1 = paramString;
            if (!HotChatHelper.a(paramMessage))
            {
              str1 = paramString;
              if (!FlashPicHelper.a(paramMessage)) {}
            }
            else
            {
              str1 = paramString;
              paramQQAppInterface = paramContext.getString(2131435568);
            }
            str1 = paramString;
            a(str3, paramQQAppInterface, null, bool1, paramBoolean1, paramMsgSummary);
            return;
            localObject = paramQQAppInterface;
            if (localMessageForPic.extraflag != 32768) {
              continue;
            }
            paramBoolean1 = true;
            continue;
            if (paramQQAppInterface != null)
            {
              localObject = paramQQAppInterface;
              if ((paramQQAppInterface instanceof BaseTransProcessor))
              {
                localObject = paramQQAppInterface;
                l = ((BaseTransProcessor)paramQQAppInterface).c();
                paramInt = (int)l;
                if ((paramInt == 1005) || (paramInt == 1004)) {
                  paramBoolean1 = true;
                }
              }
            }
          }
          else
          {
            if (ActionMsgUtil.e(paramMessage.msgtype))
            {
              paramContext = new MessageForApollo();
              paramContext.msgData = paramMessage.msgData;
              paramContext.parse();
              paramBoolean1 = b(paramQQAppInterface, paramMessage);
              paramBoolean2 = a(paramQQAppInterface, paramMessage);
              a(str3, ApolloUtil.a(paramQQAppInterface, paramContext), null, paramBoolean1, paramBoolean2, paramMsgSummary);
              return;
            }
            if ((paramMessage.msgtype == -1013) || (paramMessage.msgtype == -1047))
            {
              a(null, null, MessageForGrayTips.getOrginMsg(paramMessage.msg), false, false, paramMsgSummary);
              return;
            }
            if ((paramMessage.msgtype == -2042) || (paramMessage.msgtype == -2043))
            {
              a(null, MessageForGrayTips.getOrginMsg(paramMessage.msg), null, false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2051)
            {
              paramContext = (MessageForQQStory)paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              paramContext.parse();
              paramBoolean1 = b(paramQQAppInterface, paramMessage);
              paramBoolean2 = a(paramQQAppInterface, paramMessage);
              a(str3, null, paramContext.getSummaryMsg(), paramBoolean1, paramBoolean2, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -7002)
            {
              paramContext = (MessageForTribeShortVideo)paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              paramContext.parse();
              paramBoolean1 = b(paramQQAppInterface, paramMessage);
              paramBoolean2 = a(paramQQAppInterface, paramMessage);
              a(str3, null, paramContext.getSummaryMsg(), paramBoolean1, paramBoolean2, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2054)
            {
              paramContext = paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              if ((paramContext instanceof MessageForTroopSign))
              {
                paramContext = (MessageForTroopSign)paramContext;
                paramContext.parse();
                a(str3, null, paramContext.getSummaryMsg(), b(paramQQAppInterface, paramMessage), a(paramQQAppInterface, paramMessage), paramMsgSummary);
                return;
              }
              paramQQAppInterface = MsgUtils.class.getSimpleName() + ".troop.sign_in";
              paramMessage = new StringBuilder().append("!messageRecord instanceof MessageForTroopSign, msg.uniseq").append(paramMessage.uniseq).append(", messageRecord msgType:");
              if (paramContext != null)
              {
                paramContext = Integer.valueOf(paramContext.msgtype);
                QLog.e(paramQQAppInterface, 1, paramContext);
                return;
              }
              paramContext = "";
              continue;
            }
            if (paramMessage.msgtype == -2035)
            {
              a(null, MessageForGrayTips.getOrginMsg(paramMessage.msg), null, false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2038)
            {
              paramContext = paramMessage.frienduin;
              if (!AppConstants.ae.equals(paramContext)) {
                continue;
              }
              paramContext = paramMessage.senderuin;
              paramString = paramContext;
              if (AppConstants.G.equals(paramContext))
              {
                if (!AppConstants.ae.equals(paramMessage.senderuin)) {
                  continue;
                }
                localObject = (MessageForTroopGift)paramQQAppInterface.a().b(AppConstants.ae, paramMessage.istroop, paramMessage.uniseq);
                paramString = paramContext;
                if (localObject != null)
                {
                  ((MessageForTroopGift)localObject).parse();
                  paramString = ((MessageForTroopGift)localObject).senderuin;
                }
              }
              paramContext = paramQQAppInterface.a().b(paramString, paramMessage.istroop, paramMessage.uniseq);
              if ((paramContext instanceof MessageForTroopGift))
              {
                paramContext = (MessageForTroopGift)paramContext;
                paramContext.parse();
                if (paramContext.msg != null)
                {
                  paramContext = paramContext.msg;
                  a(null, paramContext, null, false, false, paramMsgSummary);
                  return;
                  paramString = paramMessage.senderuin;
                  continue;
                }
                paramContext = "";
                continue;
              }
              if ((paramContext == null) || (!QLog.isColorLevel())) {
                break;
              }
              QLog.e("MsgUtils", 2, "msgType is not MSG_TYPE_TROOP_DELIVER_GIFT_OBJ:" + paramContext.toString());
              return;
            }
            if (paramMessage.msgtype == -2036)
            {
              paramContext = (MessageForTroopFee)paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              paramContext.parse();
              a(null, paramContext.msg, null, false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2044)
            {
              paramContext = (MessageForTroopTopic)paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              paramContext.parse();
              a(str3, paramContext.msg, null, false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2048)
            {
              paramContext = (MessageForTroopReward)paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              paramContext.parse();
              a(str3, paramContext.msg, null, false, false, paramMsgSummary);
              return;
            }
            if ((paramMessage.istroop == 1) && (paramMessage.msgtype == -3006))
            {
              paramContext = (MessageForPubAccount)paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              paramContext.parse();
              paramMessage = MessageForPubAccount.getMsgSummary(paramQQAppInterface, paramContext, false);
              if (!paramContext.isTextMsg())
              {
                paramContext = null;
                a(paramContext, paramMessage, null, false, false, paramMsgSummary);
                return;
              }
              paramContext = paramQQAppInterface.getApp().getString(2131430781);
              continue;
            }
            if (paramMessage.msgtype == -1034)
            {
              paramContext = new MessageForRichState();
              paramContext.msg = paramMessage.msg;
              paramContext.parse();
              paramQQAppInterface = new StringBuilder();
              if (!TextUtils.isEmpty(paramContext.actionText))
              {
                paramQQAppInterface.append(paramContext.actionText);
                if (!TextUtils.isEmpty(paramContext.dataText)) {
                  paramQQAppInterface.append(paramContext.dataText);
                }
                paramQQAppInterface.append(' ');
              }
              if ((paramContext.plainText != null) && (paramContext.plainText.length() > 0)) {
                paramQQAppInterface.append(paramContext.plainText.optString(0));
              }
              if (paramQQAppInterface.length() <= 0) {
                break;
              }
              a(null, paramQQAppInterface.toString(), null, false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -1019)
            {
              a(null, null, "对方通过" + paramMessage.msg + "加你为好友，一起聊聊吧！", false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -1018)
            {
              a(null, null, "通过" + paramMessage.msg + "加的新朋友，一起聊聊吧！", false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2019)
            {
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131436919);
              return;
            }
            if (paramMessage.msgtype == -1026)
            {
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131437749);
              return;
            }
            if (paramMessage.msgtype == -1027)
            {
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131437751);
              return;
            }
            if (paramMessage.msgtype == -2005)
            {
              paramString = FileManagerUtil.a(paramQQAppInterface, paramMessage);
              paramBoolean1 = b(paramQQAppInterface, paramMessage);
              paramBoolean2 = a(paramQQAppInterface, paramMessage);
              a(str3, paramContext.getString(2131435572), null, paramBoolean1, paramBoolean2, paramMsgSummary);
              if (paramString == null) {
                break;
              }
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramString;
              return;
            }
            if (paramMessage.msgtype == -2022)
            {
              paramBoolean1 = false;
              bool1 = false;
              paramString = paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              if (!(paramString instanceof MessageForShortVideo)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO _FAIL msg.uniseq=" + paramMessage.uniseq);
              }
              localObject = (MessageForShortVideo)paramString;
              if ((((MessageForShortVideo)localObject).videoFileStatus == 1005) || (paramMessage.extraflag == 32768))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO STATUS_SEND_ERROR or EXTRA_FLAG_SEND_FAIL set failed=true");
                }
                paramBoolean1 = true;
              }
              try
              {
                paramString = paramMessage.frienduin;
                if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
                  paramString = paramMessage.senderuin;
                }
                paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramMessage.uniseq);
                paramBoolean2 = paramBoolean1;
                paramString.printStackTrace();
              }
              catch (Exception paramString)
              {
                try
                {
                  if (((MessageForShortVideo)localObject).md5 != null)
                  {
                    paramBoolean2 = paramBoolean1;
                    if (!"".equals(((MessageForShortVideo)localObject).md5))
                    {
                      paramBoolean2 = paramBoolean1;
                      if (paramMessage.isSendFromLocal())
                      {
                        paramBoolean2 = paramBoolean1;
                        if (paramQQAppInterface == null)
                        {
                          paramBoolean2 = paramBoolean1;
                          if (((MessageForShortVideo)localObject).videoFileStatus != 1003)
                          {
                            paramBoolean2 = paramBoolean1;
                            if (((MessageForShortVideo)localObject).videoFileStatus != 1004)
                            {
                              paramBoolean2 = paramBoolean1;
                              if (((MessageForShortVideo)localObject).videoFileStatus != 2003)
                              {
                                paramBoolean2 = paramBoolean1;
                                if (((MessageForShortVideo)localObject).videoFileStatus != 2009)
                                {
                                  paramBoolean2 = paramBoolean1;
                                  if (((MessageForShortVideo)localObject).videoFileStatus != 2002)
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO processor=null && NOT FINISHED set failed=true");
                                    }
                                    paramBoolean2 = true;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                  paramBoolean1 = paramBoolean2;
                  paramBoolean2 = bool1;
                  if (paramMessage.isSendFromLocal()) {
                    if ((((MessageForShortVideo)localObject).videoFileStatus != 1001) && (((MessageForShortVideo)localObject).videoFileStatus != 1002) && (((MessageForShortVideo)localObject).videoFileStatus != 998) && (((MessageForShortVideo)localObject).videoFileStatus != 999))
                    {
                      paramBoolean2 = bool1;
                      if (((MessageForShortVideo)localObject).videoFileStatus != 1000) {}
                    }
                    else
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO set sending=true");
                      }
                      paramBoolean2 = true;
                    }
                  }
                  if (((MessageForShortVideo)localObject).busiType != 2) {
                    continue;
                  }
                  paramContext = paramContext.getString(2131435574);
                  paramString = paramContext;
                  if (GoldMsgChatHelper.c(paramMessage)) {
                    paramString = "[句有料]" + paramContext;
                  }
                  if (QLog.isColorLevel())
                  {
                    QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO md5=" + ((MessageForShortVideo)localObject).md5 + ", shortVideo.videoFileStatus=" + ((MessageForShortVideo)localObject).videoFileStatus);
                    if (paramQQAppInterface != null) {
                      continue;
                    }
                    QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO processor=null");
                    QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO failed=" + paramBoolean1 + ", sending=" + paramBoolean2);
                  }
                  a(str3, paramString, null, paramBoolean1, paramBoolean2, paramMsgSummary);
                  return;
                }
                catch (Exception paramString)
                {
                  continue;
                }
                paramString = paramString;
                paramQQAppInterface = null;
              }
              continue;
              paramContext = paramContext.getString(2131435573);
              continue;
              QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO processor!=null");
              continue;
            }
            if (paramMessage.msgtype == -5002)
            {
              paramContext = new MessageForIncompatibleGrayTips();
              paramContext.msgData = paramMessage.msgData;
              paramContext.parse();
              if (paramContext.msg == null) {
                break;
              }
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.msg;
              return;
            }
            if (paramMessage.msgtype == -2029)
            {
              paramContext = paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              if (QLog.isColorLevel()) {
                QLog.i("Q.recent", 2, "MsgUtils.buildMsgSummaryForMsg MSG_TYPE_QQWALLET_TIPS mr=" + paramContext);
              }
              if (!(paramContext instanceof MessageForQQWalletTips)) {
                break;
              }
              paramContext = (MessageForQQWalletTips)paramContext;
              paramContext.msgData = paramMessage.msgData;
              paramContext.parse();
              paramContext.buildQQWalletTips(paramQQAppInterface, paramQQAppInterface.getApp(), null);
              if (paramContext.summary == null) {
                break;
              }
              if (paramContext.type == 1) {
                paramContext.summary = ("[提示]" + paramContext.summary);
              }
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.summary;
              return;
            }
            if (paramMessage.msgtype == -2025)
            {
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramMessage.msg;
              return;
            }
            if (paramMessage.msgtype == -2052)
            {
              paramContext = paramMessage.frienduin;
              if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
                paramContext = paramMessage.senderuin;
              }
              paramContext = paramQQAppInterface.a().b(paramContext, paramMessage.istroop, paramMessage.uniseq);
              if (!(paramContext instanceof MessageForQQStoryComment)) {
                break;
              }
              paramContext = (MessageForQQStoryComment)paramContext;
              paramContext.parse();
              a(str3, paramContext.getSummaryMsg(), null, false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2047)
            {
              paramContext = new MessageForVIPDonate();
              paramContext.msgData = paramMessage.msgData;
              paramContext.parse();
              paramContext = paramContext.getSummaryMsg();
              if (!TextUtils.isEmpty(paramContext))
              {
                paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext;
                return;
              }
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "[QQ会员赠送]";
              return;
            }
            if (paramMessage.msgtype == -2040)
            {
              paramContext = new MessageForApproval();
              paramContext.msgData = paramMessage.msgData;
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getFullTitle();
              return;
            }
            if (paramMessage.msgtype == -2041)
            {
              paramQQAppInterface = paramContext.getString(2131438331);
              paramContext = paramContext.getString(2131438332);
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = (paramQQAppInterface + " " + paramContext);
              return;
            }
            if (paramMessage.msgtype == -7001)
            {
              try
              {
                paramString = paramMessage.frienduin;
                if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
                  paramString = paramMessage.senderuin;
                }
                paramQQAppInterface = (MessageForScribble)paramQQAppInterface.a().b(paramString, paramMessage.istroop, paramMessage.uniseq);
                if (!paramQQAppInterface.isSendFromLocal()) {
                  continue;
                }
                paramInt = paramQQAppInterface.fileUploadStatus;
                if (paramInt != 2) {
                  continue;
                }
                paramBoolean2 = true;
                paramBoolean1 = false;
              }
              catch (Exception paramQQAppInterface)
              {
                paramQQAppInterface.printStackTrace();
                paramBoolean1 = false;
                paramBoolean2 = false;
                continue;
              }
              a(str3, paramContext.getString(2131439069), null, paramBoolean2, paramBoolean1, paramMsgSummary);
              return;
              if (paramQQAppInterface.fileUploadStatus != 3) {
                continue;
              }
              paramBoolean1 = true;
              paramBoolean2 = false;
              continue;
              if (paramQQAppInterface.fileDownloadStatus != 2) {
                continue;
              }
              paramInt = ScribbleMsgUtils.a(paramQQAppInterface);
              i = ScribbleMsgUtils.c;
              if (paramInt == i) {
                continue;
              }
              paramBoolean2 = true;
              paramBoolean1 = false;
              continue;
            }
            if (paramMessage.msg == null)
            {
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
              return;
            }
            if (paramMessage.msgtype == -5003)
            {
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramMessage.getMessageText();
              return;
            }
            if (paramMessage.msgtype == -2033)
            {
              a(null, "你的热聊房间会被推荐给附近的人和好友，感兴趣的会加入进来哦。你也可以邀请好友加入。分享热聊房间", null, false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -5010)
            {
              paramContext = new MessageForDingdongSchedule();
              paramContext.msgData = paramMessage.msgData;
              paramContext.parse();
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.msg;
              return;
            }
            if (paramMessage.msgtype == -2049)
            {
              paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = MessageForGrayTips.getOrginMsg(paramMessage.msg);
              return;
            }
            if (paramMessage.msgtype == -1035)
            {
              bool1 = false;
              bool2 = false;
              paramBoolean1 = bool1;
              paramBoolean2 = bool2;
              if (paramMessage.isSendFromLocal())
              {
                if (paramMessage.extraflag != 32772) {
                  continue;
                }
                if (!paramQQAppInterface.a().b(paramMessage))
                {
                  paramBoolean1 = true;
                  paramBoolean2 = bool2;
                }
              }
              else
              {
                paramContext = paramMessage.getMessageText();
                if (!TroopRobotManager.b(paramMessage)) {
                  continue;
                }
                if (!TroopRobotManager.d(paramMessage)) {
                  TroopRobotManager.a(paramMessage);
                }
                paramQQAppInterface = TroopRobotManager.b(paramMessage);
                if (TextUtils.isEmpty(paramQQAppInterface)) {
                  continue;
                }
                paramContext = paramQQAppInterface;
                if ((paramMessage.emoRecentMsg == null) || (paramContext == null)) {
                  continue;
                }
                paramQQAppInterface = new StringBuilder();
                if (!TextUtils.isEmpty(str3)) {
                  paramQQAppInterface.append(str3).append(": ");
                }
                if (!AnonymousChatHelper.a(paramMessage))
                {
                  if (!paramBoolean1) {
                    continue;
                  }
                  paramQQAppInterface.append("F ");
                }
                if (!(paramContext instanceof QQText)) {
                  continue;
                }
                paramContext = ((QQText)paramContext).a(paramQQAppInterface.toString(), true, new int[0]);
                paramMsgSummary.jdField_b_of_type_Int = 1;
                a(str3, paramContext, null, paramBoolean1, paramBoolean2, paramMsgSummary);
                return;
              }
              paramBoolean2 = true;
              paramBoolean1 = bool1;
              continue;
              paramBoolean2 = false;
              if (paramMessage.extraflag == 32768)
              {
                paramBoolean1 = true;
                continue;
              }
              paramBoolean1 = false;
              continue;
              if (!paramBoolean2) {
                continue;
              }
              paramQQAppInterface.append("S ");
              continue;
              paramQQAppInterface.append(paramContext);
              paramContext = new SpannableString(paramQQAppInterface.toString());
              paramMsgSummary.jdField_b_of_type_Int = 0;
              continue;
              a(str3, String.valueOf(paramContext), null, paramBoolean1, paramBoolean2, paramMsgSummary);
            }
            else
            {
              if (paramMessage.msgtype == -2057)
              {
                a(str3, "[小视频]", null, false, false, paramMsgSummary);
                return;
              }
              if (paramMessage.msgtype == -1012)
              {
                paramQQAppInterface = MessageForGrayTips.getOrginMsg(paramMessage.getMessageText().toString());
                paramMessage = paramContext.getString(2131433102);
                paramInt = paramQQAppInterface.length() - paramMessage.length() - 1;
                paramContext = paramQQAppInterface;
                if (paramQQAppInterface.endsWith(paramMessage))
                {
                  paramContext = paramQQAppInterface;
                  if (paramInt > 0) {
                    paramContext = paramQQAppInterface.substring(0, paramInt);
                  }
                }
                a(null, paramContext, null, false, false, paramMsgSummary);
                return;
              }
              if (paramMessage.msgtype == -2059)
              {
                paramContext = new MessageForTroopPobing();
                paramContext.msgData = paramMessage.msgData;
                paramContext.doParse();
                paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getSummaryMsg();
                return;
              }
              if (paramMessage.msgtype == -2066)
              {
                paramContext = new MessageForConfessCard();
                paramContext.msg = paramMessage.msg;
                paramContext.doParse();
                if (paramMessage.istroop == 1032)
                {
                  a(str3, paramContext.strConfessorDesc, null, false, false, paramMsgSummary);
                  return;
                }
                a("", str3 + "," + paramContext.strConfessorDesc, null, false, false, paramMsgSummary);
                return;
              }
              if ((paramMessage.msgtype == -5008) || (paramMessage.msgtype == -5016) || (paramMessage.msgtype == -5017))
              {
                if (paramMessage.msgtype == -5016)
                {
                  paramContext = new MessageForArkBabyqReply();
                  paramContext.msgData = paramMessage.msgData;
                  paramContext.doParse();
                  paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getSummery();
                  paramBoolean1 = b(paramQQAppInterface, paramMessage);
                  paramBoolean2 = a(paramQQAppInterface, paramMessage);
                  a(str3, paramMsgSummary.jdField_b_of_type_JavaLangCharSequence, null, paramBoolean1, paramBoolean2, paramMsgSummary);
                  return;
                }
                paramContext = new MessageForArkApp();
                paramContext.msgData = paramMessage.msgData;
                paramContext.doParse();
                paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getSummery();
                continue;
              }
              paramBoolean1 = b(paramQQAppInterface, paramMessage);
              paramBoolean2 = a(paramQQAppInterface, paramMessage);
              switch (paramMessage.fileType)
              {
              default: 
                paramString = paramMessage.getExtInfoFromExtStr("sticker_info");
                if ((!EmojiStickerManager.e) || (TextUtils.isEmpty(paramString))) {
                  continue;
                }
                paramContext = EmojiStickerManager.a(paramQQAppInterface, paramMessage, paramMsgSummary);
                paramQQAppInterface = new StringBuilder();
                if (!TextUtils.isEmpty(str3)) {
                  paramQQAppInterface.append(str3).append(": ");
                }
                if (!AnonymousChatHelper.a(paramMessage))
                {
                  if (paramBoolean1) {
                    paramQQAppInterface.append("F ");
                  }
                }
                else
                {
                  a(str3, paramContext.a(paramQQAppInterface.toString(), true, new int[0]), null, paramBoolean1, paramBoolean2, paramMsgSummary);
                  return;
                }
                break;
              case 65536: 
                a(str3, "", paramMessage.msg, paramBoolean1, paramBoolean2, paramMsgSummary);
                return;
              case 1: 
                if (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (paramMessage.msgtype == -3001))
                {
                  paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131436279);
                  return;
                }
                a(str3, paramContext.getString(2131435567), null, paramBoolean1, paramBoolean2, paramMsgSummary);
                return;
              case 65538: 
                a(str3, paramContext.getString(2131435567), null, false, false, paramMsgSummary);
                return;
              case 2: 
              case 8: 
                DatingUtil.a("buildMsgSummaryForMsg", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
                paramString = paramContext.getString(2131435570);
                paramContext = paramString;
                if (GoldMsgChatHelper.c(paramMessage)) {
                  paramContext = "[句有料]" + paramString;
                }
                if ((Utils.a(paramMessage.senderuin, paramQQAppInterface.getCurrentAccountUin())) && (paramInt != 0))
                {
                  a(str3, paramContext, "", paramBoolean1, paramBoolean2, paramMsgSummary);
                  return;
                }
                a(str3, paramContext, "", false, false, paramMsgSummary);
                return;
              }
              if (!paramBoolean2) {
                continue;
              }
              paramQQAppInterface.append("S ");
              continue;
              paramString = paramMessage.getMessageText();
              if (TroopRobotManager.b(paramMessage))
              {
                if (!TroopRobotManager.d(paramMessage)) {
                  TroopRobotManager.a(paramMessage);
                }
                localObject = TroopRobotManager.b(paramMessage);
                if (!TextUtils.isEmpty((CharSequence)localObject))
                {
                  paramString = (String)localObject;
                  if ((paramMessage.emoRecentMsg != null) && (paramString != null))
                  {
                    paramContext = new StringBuilder();
                    if (!TextUtils.isEmpty(str3)) {
                      paramContext.append(str3).append(": ");
                    }
                    if (!AnonymousChatHelper.a(paramMessage))
                    {
                      if (paramBoolean1) {
                        paramContext.append("F ");
                      }
                    }
                    else
                    {
                      if (GoldMsgChatHelper.c(paramMessage)) {
                        paramContext.append("[句有料]");
                      }
                      if (!(paramString instanceof QQText)) {
                        continue;
                      }
                      paramContext = ((QQText)paramString).a(paramContext.toString(), true, new int[] { ((QQText)paramString).jdField_a_of_type_Int, 16, 1 });
                      paramMsgSummary.jdField_b_of_type_Int = 1;
                      if (paramMessage.msgtype != -5040) {
                        continue;
                      }
                      paramQQAppInterface = " " + BaseApplicationImpl.getApplication().getString(2131438103);
                      paramMessage = paramContext.toString();
                      if ((paramMessage == null) || (!paramMessage.contains(paramQQAppInterface))) {
                        continue;
                      }
                      paramContext = paramMessage.replace(paramQQAppInterface, "");
                      a(str3, paramContext, null, paramBoolean1, paramBoolean2, paramMsgSummary);
                      return;
                    }
                    if (!paramBoolean2) {
                      continue;
                    }
                    paramContext.append("S ");
                    continue;
                    paramContext.append(paramString);
                    paramContext = new SpannableString(paramContext.toString());
                    paramMsgSummary.jdField_b_of_type_Int = 0;
                    continue;
                  }
                  else
                  {
                    if (paramString != null)
                    {
                      paramString = paramString.toString().trim();
                      if ((!AppConstants.F.equalsIgnoreCase(paramMessage.frienduin)) || (paramString == null) || (paramString.length() <= 0)) {
                        continue;
                      }
                      paramContext = a(paramContext, paramQQAppInterface, paramString, paramMessage);
                      a(str3, null, paramContext, paramBoolean1, paramQQAppInterface.a().b(paramMessage), paramMsgSummary);
                      if ((GoldMsgChatHelper.c(paramMessage)) && (paramMsgSummary.jdField_b_of_type_JavaLangCharSequence != null)) {
                        paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = ("[句有料]" + paramMsgSummary.jdField_b_of_type_JavaLangCharSequence);
                      }
                      if ((paramMessage.msgtype == -1000) && (paramMsgSummary.jdField_b_of_type_JavaLangCharSequence != null))
                      {
                        paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = new QQText(paramMsgSummary.jdField_b_of_type_JavaLangCharSequence, 1, 16);
                        paramMsgSummary.jdField_b_of_type_Int = 1;
                      }
                    }
                    else
                    {
                      paramString = null;
                      continue;
                    }
                    paramMsgSummary.jdField_b_of_type_Int = 0;
                    return;
                  }
                }
              }
            }
          }
          break label440;
          paramString = (String)localObject;
          break label118;
          paramBoolean1 = false;
          break label509;
          paramInt = 1;
        }
      }
    }
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
      paramMessage = (MessageForTroopFile)paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && (paramMessage.frienduin != null))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.jdField_b_of_type_Int == 1) || (paramQQAppInterface.jdField_b_of_type_Int == 0))) {
          return true;
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