package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;

public class TroopBindPublicAccountMgr
  implements Manager
{
  private static final ArrayList<Long> a;
  protected SharedPreferences a;
  protected LruCache<String, Bundle> a;
  protected QQAppInterface a;
  protected TroopManager a;
  protected String a;
  protected HashMap<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public TroopBindPublicAccountMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_troop_bind_pb");
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  @Deprecated
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (paramMessageRecord.msgtype == -3006);
  }
  
  public int a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_temp_follow_state");
    paramString = localStringBuilder.toString();
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, -1);
  }
  
  public Bundle a(String paramString)
  {
    return (Bundle)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
  }
  
  public String a()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    if (!jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) {
      jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject).append("_temp_follow_state");
        paramString = ((StringBuilder)localObject).toString();
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).remove(paramString);
        ((SharedPreferences.Editor)localObject).commit();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deletePubAccTempFollowState:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("TroopBindPublicAccountMgr.tempFollow", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deletePubAccTempFollowState:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("TroopBindPublicAccountMgr.tempFollow", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject).append("_temp_follow_state");
        paramString = ((StringBuilder)localObject).toString();
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        paramInt1 = paramInt1 << 4 | paramInt2;
        ((SharedPreferences.Editor)localObject).putInt(paramString, paramInt1);
        ((SharedPreferences.Editor)localObject).commit();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("saveTroopTempFollowState:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("TroopBindPublicAccountMgr.tempFollow", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveTroopTempFollowState:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("TroopBindPublicAccountMgr.tempFollow", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_btm_pbmsg_seq");
        paramString = ((StringBuilder)localObject).toString();
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
        ((SharedPreferences.Editor)localObject).commit();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setTroopLastPubAccountMsgUniseq:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(paramLong);
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setTroopLastPubAccountMsgUniseq:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("TroopBindPublicAccountMgr.bottom", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, paramBundle);
  }
  
  /* Error */
  public void a(String paramString, java.util.List<com.tencent.mobileqq.data.ChatMessage> arg2)
  {
    // Byte code:
    //   0: new 69	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   7: astore 10
    //   9: aload 10
    //   11: aload_1
    //   12: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 10
    //   18: ldc 180
    //   20: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 10
    //   26: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 11
    //   31: aload_0
    //   32: getfield 91	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   35: astore 10
    //   37: aload 10
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 91	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   44: aload 11
    //   46: ldc2_w 198
    //   49: invokeinterface 203 4 0
    //   54: lstore 7
    //   56: aload 10
    //   58: monitorexit
    //   59: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +67 -> 129
    //   65: new 69	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   72: astore 10
    //   74: aload 10
    //   76: ldc 205
    //   78: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: aload_1
    //   85: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 10
    //   91: ldc 207
    //   93: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: lload 7
    //   99: lconst_0
    //   100: lcmp
    //   101: ifle +777 -> 878
    //   104: iconst_1
    //   105: istore 9
    //   107: goto +3 -> 110
    //   110: aload 10
    //   112: iload 9
    //   114: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 191
    //   120: iconst_2
    //   121: aload 10
    //   123: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: lload 7
    //   131: lconst_0
    //   132: lcmp
    //   133: iflt +609 -> 742
    //   136: aload_2
    //   137: ifnull +605 -> 742
    //   140: aload_2
    //   141: invokeinterface 216 1 0
    //   146: ifne +4 -> 150
    //   149: return
    //   150: aload_2
    //   151: invokeinterface 216 1 0
    //   156: istore 4
    //   158: iconst_0
    //   159: istore_3
    //   160: iconst_m1
    //   161: istore 5
    //   163: iload_3
    //   164: iload 4
    //   166: if_icmpge +725 -> 891
    //   169: aload_2
    //   170: iload_3
    //   171: invokeinterface 219 2 0
    //   176: checkcast 221	com/tencent/mobileqq/data/ChatMessage
    //   179: getfield 225	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   182: lload 7
    //   184: lcmp
    //   185: ifne +699 -> 884
    //   188: goto +3 -> 191
    //   191: aload_0
    //   192: getfield 38	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   195: aload_1
    //   196: invokevirtual 228	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   199: istore 9
    //   201: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +70 -> 274
    //   207: new 69	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   214: astore 10
    //   216: aload 10
    //   218: ldc 230
    //   220: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 10
    //   226: iload_3
    //   227: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 10
    //   233: ldc 232
    //   235: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 10
    //   241: iload 4
    //   243: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 10
    //   249: ldc 234
    //   251: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 10
    //   257: iload 9
    //   259: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 191
    //   265: iconst_2
    //   266: aload 10
    //   268: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aconst_null
    //   275: astore 10
    //   277: iload_3
    //   278: ifge +90 -> 368
    //   281: aload_0
    //   282: getfield 47	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   285: invokevirtual 238	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   288: aload_1
    //   289: iconst_1
    //   290: lload 7
    //   292: invokevirtual 244	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   295: astore 12
    //   297: aload 12
    //   299: instanceof 221
    //   302: ifeq +10 -> 312
    //   305: aload 12
    //   307: checkcast 221	com/tencent/mobileqq/data/ChatMessage
    //   310: astore 10
    //   312: aload 10
    //   314: astore 11
    //   316: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +61 -> 380
    //   322: new 69	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   329: astore 11
    //   331: aload 11
    //   333: ldc 246
    //   335: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 11
    //   341: aload 12
    //   343: instanceof 221
    //   346: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc 191
    //   352: iconst_2
    //   353: aload 11
    //   355: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload 10
    //   363: astore 11
    //   365: goto +15 -> 380
    //   368: aload_2
    //   369: iload_3
    //   370: invokeinterface 248 2 0
    //   375: checkcast 221	com/tencent/mobileqq/data/ChatMessage
    //   378: astore 11
    //   380: aload 11
    //   382: ifnonnull +9 -> 391
    //   385: aload_0
    //   386: aload_1
    //   387: invokevirtual 250	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:b	(Ljava/lang/String;)V
    //   390: return
    //   391: iload 9
    //   393: ifne +111 -> 504
    //   396: aload_2
    //   397: aload 11
    //   399: invokeinterface 251 2 0
    //   404: pop
    //   405: aload_2
    //   406: invokeinterface 216 1 0
    //   411: istore_3
    //   412: iload_3
    //   413: iconst_1
    //   414: if_icmple +394 -> 808
    //   417: aload_2
    //   418: iload_3
    //   419: iconst_2
    //   420: isub
    //   421: invokeinterface 219 2 0
    //   426: checkcast 221	com/tencent/mobileqq/data/ChatMessage
    //   429: getfield 254	com/tencent/mobileqq/data/ChatMessage:shmsgseq	J
    //   432: lstore 7
    //   434: aload_0
    //   435: getfield 38	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   438: aload_1
    //   439: lload 7
    //   441: invokestatic 124	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   444: invokevirtual 255	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   447: pop
    //   448: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +357 -> 808
    //   454: new 69	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   461: astore_2
    //   462: aload_2
    //   463: ldc_w 257
    //   466: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_2
    //   471: aload_1
    //   472: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_2
    //   477: ldc_w 259
    //   480: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_2
    //   485: lload 7
    //   487: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: ldc 191
    //   493: iconst_2
    //   494: aload_2
    //   495: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   501: goto +307 -> 808
    //   504: aload_0
    //   505: getfield 38	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   508: aload_1
    //   509: invokevirtual 260	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   512: checkcast 120	java/lang/Long
    //   515: invokevirtual 264	java/lang/Long:longValue	()J
    //   518: lstore 7
    //   520: aload_2
    //   521: invokeinterface 216 1 0
    //   526: istore 6
    //   528: iconst_0
    //   529: istore_3
    //   530: iload 5
    //   532: istore 4
    //   534: iload_3
    //   535: iload 6
    //   537: if_icmpge +28 -> 565
    //   540: aload_2
    //   541: iload_3
    //   542: invokeinterface 219 2 0
    //   547: checkcast 221	com/tencent/mobileqq/data/ChatMessage
    //   550: getfield 254	com/tencent/mobileqq/data/ChatMessage:shmsgseq	J
    //   553: lload 7
    //   555: lcmp
    //   556: iflt +340 -> 896
    //   559: iload_3
    //   560: istore 4
    //   562: goto +3 -> 565
    //   565: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +57 -> 625
    //   571: new 69	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   578: astore 10
    //   580: aload 10
    //   582: ldc_w 266
    //   585: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 10
    //   591: lload 7
    //   593: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 10
    //   599: ldc_w 268
    //   602: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 10
    //   608: iload 4
    //   610: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: ldc 191
    //   616: iconst_2
    //   617: aload 10
    //   619: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   625: iload 4
    //   627: ifge +15 -> 642
    //   630: aload_2
    //   631: aload 11
    //   633: invokeinterface 251 2 0
    //   638: pop
    //   639: goto +68 -> 707
    //   642: aload_2
    //   643: iload 4
    //   645: invokeinterface 219 2 0
    //   650: checkcast 221	com/tencent/mobileqq/data/ChatMessage
    //   653: getfield 254	com/tencent/mobileqq/data/ChatMessage:shmsgseq	J
    //   656: lload 7
    //   658: lcmp
    //   659: ifle +16 -> 675
    //   662: aload_2
    //   663: iload 4
    //   665: aload 11
    //   667: invokeinterface 271 3 0
    //   672: goto +35 -> 707
    //   675: aload_2
    //   676: iload 4
    //   678: invokeinterface 219 2 0
    //   683: checkcast 221	com/tencent/mobileqq/data/ChatMessage
    //   686: getfield 254	com/tencent/mobileqq/data/ChatMessage:shmsgseq	J
    //   689: lload 7
    //   691: lcmp
    //   692: ifne +15 -> 707
    //   695: aload_2
    //   696: iload 4
    //   698: iconst_1
    //   699: iadd
    //   700: aload 11
    //   702: invokeinterface 271 3 0
    //   707: aload_0
    //   708: getfield 47	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   711: astore_2
    //   712: aload_2
    //   713: ldc_w 273
    //   716: ldc_w 275
    //   719: ldc 31
    //   721: ldc_w 277
    //   724: ldc_w 279
    //   727: iconst_0
    //   728: iconst_0
    //   729: aload_1
    //   730: ldc 31
    //   732: ldc 31
    //   734: ldc 31
    //   736: invokestatic 284	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   739: goto +69 -> 808
    //   742: return
    //   743: astore_2
    //   744: aload 10
    //   746: monitorexit
    //   747: aload_2
    //   748: athrow
    //   749: astore_2
    //   750: goto +8 -> 758
    //   753: astore_2
    //   754: goto -10 -> 744
    //   757: astore_2
    //   758: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   761: ifeq +42 -> 803
    //   764: new 69	java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   771: astore 10
    //   773: aload 10
    //   775: ldc_w 286
    //   778: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload 10
    //   784: aload_2
    //   785: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   788: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: ldc 191
    //   794: iconst_2
    //   795: aload 10
    //   797: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   803: aload_0
    //   804: aload_1
    //   805: invokevirtual 250	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:b	(Ljava/lang/String;)V
    //   808: new 69	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   815: astore_2
    //   816: aload_2
    //   817: aload_1
    //   818: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: aload_2
    //   823: ldc_w 288
    //   826: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: pop
    //   830: aload_2
    //   831: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: astore 10
    //   836: aload_0
    //   837: getfield 91	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   840: astore_2
    //   841: aload_2
    //   842: monitorenter
    //   843: aload_0
    //   844: getfield 91	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   847: aload 10
    //   849: iconst_0
    //   850: invokeinterface 110 3 0
    //   855: iconst_1
    //   856: if_icmpne +8 -> 864
    //   859: aload_0
    //   860: aload_1
    //   861: invokevirtual 290	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:d	(Ljava/lang/String;)V
    //   864: aload_2
    //   865: monitorexit
    //   866: return
    //   867: astore_1
    //   868: aload_2
    //   869: monitorexit
    //   870: goto +5 -> 875
    //   873: aload_1
    //   874: athrow
    //   875: goto -2 -> 873
    //   878: iconst_0
    //   879: istore 9
    //   881: goto -771 -> 110
    //   884: iload_3
    //   885: iconst_1
    //   886: iadd
    //   887: istore_3
    //   888: goto -728 -> 160
    //   891: iconst_m1
    //   892: istore_3
    //   893: goto -702 -> 191
    //   896: iload_3
    //   897: iconst_1
    //   898: iadd
    //   899: istore_3
    //   900: goto -370 -> 530
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	903	0	this	TroopBindPublicAccountMgr
    //   0	903	1	paramString	String
    //   159	741	3	i	int
    //   156	544	4	j	int
    //   161	370	5	k	int
    //   526	12	6	m	int
    //   54	636	7	l	long
    //   105	775	9	bool	boolean
    //   7	841	10	localObject1	Object
    //   29	672	11	localObject2	Object
    //   295	47	12	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   40	59	743	finally
    //   712	739	749	java/lang/Exception
    //   747	749	749	java/lang/Exception
    //   744	747	753	finally
    //   0	40	757	java/lang/Exception
    //   59	97	757	java/lang/Exception
    //   110	129	757	java/lang/Exception
    //   140	149	757	java/lang/Exception
    //   150	158	757	java/lang/Exception
    //   169	188	757	java/lang/Exception
    //   191	274	757	java/lang/Exception
    //   281	297	757	java/lang/Exception
    //   297	312	757	java/lang/Exception
    //   316	361	757	java/lang/Exception
    //   368	380	757	java/lang/Exception
    //   385	390	757	java/lang/Exception
    //   396	412	757	java/lang/Exception
    //   417	501	757	java/lang/Exception
    //   504	528	757	java/lang/Exception
    //   540	559	757	java/lang/Exception
    //   565	625	757	java/lang/Exception
    //   630	639	757	java/lang/Exception
    //   642	672	757	java/lang/Exception
    //   675	707	757	java/lang/Exception
    //   707	712	757	java/lang/Exception
    //   843	864	867	finally
    //   864	866	867	finally
    //   868	870	867	finally
  }
  
  public boolean a(long paramLong)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString)))
        {
          bool = true;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isInTroopAIO:");
            localStringBuilder.append(paramString);
            localStringBuilder.append(",");
            localStringBuilder.append(bool);
            QLog.d("TroopBindPublicAccountMgr", 2, localStringBuilder.toString());
          }
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean a(String arg1, long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(???);
    ((StringBuilder)localObject1).append("_btm_pbmsg_seq");
    localObject1 = ((StringBuilder)localObject1).toString();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong((String)localObject1, -1L);
        if ((l > 0L) && (l == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("_btm_pbmsg_seq");
        localObject2 = ((StringBuilder)localObject2).toString();
        ((SharedPreferences.Editor)localObject1).remove((String)localObject2);
        ((SharedPreferences.Editor)localObject1).commit();
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeTroopLastPubAccountMsgUniseq:");
          paramString.append((String)localObject2);
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, paramString.toString());
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("removeTroopLastPubAccountMsgUniseq:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e("TroopBindPublicAccountMgr.bottom", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool3 = paramMessageRecord instanceof MessageForStructing;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      bool1 = bool2;
      if (a(paramMessageRecord))
      {
        bool1 = bool2;
        if (a(paramMessageRecord.frienduin, paramMessageRecord.uniseq))
        {
          bool1 = bool2;
          if (!a(paramMessageRecord.uniseq)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString) == null;
  }
  
  public void c(String paramString)
  {
    try
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_unread_pbmsg_cnt");
        paramString = ((StringBuilder)localObject).toString();
        int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0) + 1;
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putInt(paramString, i);
        ((SharedPreferences.Editor)localObject).commit();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("increaseTroopPubMsgUnreadCount:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(i);
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("increaseTroopPubMsgUnreadCount:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("TroopBindPublicAccountMgr.redDot", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_unread_pbmsg_cnt");
        paramString = ((StringBuilder)localObject).toString();
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).remove(paramString);
        ((SharedPreferences.Editor)localObject).commit();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("clearTroopPubMsgUnreadCount:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearTroopPubMsgUnreadCount:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("TroopBindPublicAccountMgr.redDot", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public void e(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCurentAIOUin:");
        localStringBuilder.append(paramString);
        QLog.d("TroopBindPublicAccountMgr", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr
 * JD-Core Version:    0.7.0.1
 */