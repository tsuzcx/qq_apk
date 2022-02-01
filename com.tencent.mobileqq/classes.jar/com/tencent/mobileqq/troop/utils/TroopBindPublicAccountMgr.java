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
  private static final ArrayList<Long> g = new ArrayList();
  protected String a = "";
  protected QQAppInterface b;
  protected TroopManager c;
  protected HashMap<String, Long> d = new HashMap();
  protected SharedPreferences e;
  protected LruCache<String, Bundle> f = new LruCache(10);
  
  public TroopBindPublicAccountMgr(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.c = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    paramQQAppInterface = this.b.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.getCurrentAccountUin());
    localStringBuilder.append("_troop_bind_pb");
    this.e = paramQQAppInterface.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  @Deprecated
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (paramMessageRecord.msgtype == -3006);
  }
  
  public String a()
  {
    try
    {
      String str = this.a;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      synchronized (this.e)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(this.b.getCurrentAccountUin());
        ((StringBuilder)localObject).append("_temp_follow_state");
        paramString = ((StringBuilder)localObject).toString();
        localObject = this.e.edit();
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
      synchronized (this.e)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(this.b.getCurrentAccountUin());
        ((StringBuilder)localObject).append("_temp_follow_state");
        paramString = ((StringBuilder)localObject).toString();
        localObject = this.e.edit();
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
      synchronized (this.e)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_btm_pbmsg_seq");
        paramString = ((StringBuilder)localObject).toString();
        localObject = this.e.edit();
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
    this.f.put(paramString, paramBundle);
  }
  
  /* Error */
  public void a(String paramString, java.util.List<com.tencent.mobileqq.data.ChatMessage> arg2)
  {
    // Byte code:
    //   0: new 75	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   7: astore 10
    //   9: aload 10
    //   11: aload_1
    //   12: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 10
    //   18: ldc 158
    //   20: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 10
    //   26: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 11
    //   31: aload_0
    //   32: getfield 97	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:e	Landroid/content/SharedPreferences;
    //   35: astore 10
    //   37: aload 10
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 97	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:e	Landroid/content/SharedPreferences;
    //   44: aload 11
    //   46: ldc2_w 176
    //   49: invokeinterface 181 4 0
    //   54: lstore 7
    //   56: aload 10
    //   58: monitorexit
    //   59: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +67 -> 129
    //   65: new 75	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   72: astore 10
    //   74: aload 10
    //   76: ldc 183
    //   78: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: aload_1
    //   85: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 10
    //   91: ldc 185
    //   93: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: lload 7
    //   99: lconst_0
    //   100: lcmp
    //   101: ifle +774 -> 875
    //   104: iconst_1
    //   105: istore 9
    //   107: goto +3 -> 110
    //   110: aload 10
    //   112: iload 9
    //   114: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 169
    //   120: iconst_2
    //   121: aload 10
    //   123: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: lload 7
    //   131: lconst_0
    //   132: lcmp
    //   133: iflt +606 -> 739
    //   136: aload_2
    //   137: ifnull +602 -> 739
    //   140: aload_2
    //   141: invokeinterface 194 1 0
    //   146: ifne +4 -> 150
    //   149: return
    //   150: aload_2
    //   151: invokeinterface 194 1 0
    //   156: istore 4
    //   158: iconst_0
    //   159: istore_3
    //   160: iconst_m1
    //   161: istore 5
    //   163: iload_3
    //   164: iload 4
    //   166: if_icmpge +722 -> 888
    //   169: aload_2
    //   170: iload_3
    //   171: invokeinterface 198 2 0
    //   176: checkcast 200	com/tencent/mobileqq/data/ChatMessage
    //   179: getfield 204	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   182: lload 7
    //   184: lcmp
    //   185: ifne +696 -> 881
    //   188: goto +3 -> 191
    //   191: aload_0
    //   192: getfield 44	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:d	Ljava/util/HashMap;
    //   195: aload_1
    //   196: invokevirtual 208	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   199: istore 9
    //   201: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +70 -> 274
    //   207: new 75	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   214: astore 10
    //   216: aload 10
    //   218: ldc 210
    //   220: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 10
    //   226: iload_3
    //   227: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 10
    //   233: ldc 212
    //   235: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 10
    //   241: iload 4
    //   243: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 10
    //   249: ldc 214
    //   251: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 10
    //   257: iload 9
    //   259: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 169
    //   265: iconst_2
    //   266: aload 10
    //   268: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aconst_null
    //   275: astore 10
    //   277: iload_3
    //   278: ifge +90 -> 368
    //   281: aload_0
    //   282: getfield 53	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   285: invokevirtual 218	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   288: aload_1
    //   289: iconst_1
    //   290: lload 7
    //   292: invokevirtual 223	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   295: astore 12
    //   297: aload 12
    //   299: instanceof 200
    //   302: ifeq +10 -> 312
    //   305: aload 12
    //   307: checkcast 200	com/tencent/mobileqq/data/ChatMessage
    //   310: astore 10
    //   312: aload 10
    //   314: astore 11
    //   316: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +61 -> 380
    //   322: new 75	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   329: astore 11
    //   331: aload 11
    //   333: ldc 225
    //   335: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 11
    //   341: aload 12
    //   343: instanceof 200
    //   346: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc 169
    //   352: iconst_2
    //   353: aload 11
    //   355: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload 10
    //   363: astore 11
    //   365: goto +15 -> 380
    //   368: aload_2
    //   369: iload_3
    //   370: invokeinterface 227 2 0
    //   375: checkcast 200	com/tencent/mobileqq/data/ChatMessage
    //   378: astore 11
    //   380: aload 11
    //   382: ifnonnull +9 -> 391
    //   385: aload_0
    //   386: aload_1
    //   387: invokevirtual 229	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:c	(Ljava/lang/String;)V
    //   390: return
    //   391: iload 9
    //   393: ifne +109 -> 502
    //   396: aload_2
    //   397: aload 11
    //   399: invokeinterface 232 2 0
    //   404: pop
    //   405: aload_2
    //   406: invokeinterface 194 1 0
    //   411: istore_3
    //   412: iload_3
    //   413: iconst_1
    //   414: if_icmple +391 -> 805
    //   417: aload_2
    //   418: iload_3
    //   419: iconst_2
    //   420: isub
    //   421: invokeinterface 198 2 0
    //   426: checkcast 200	com/tencent/mobileqq/data/ChatMessage
    //   429: getfield 235	com/tencent/mobileqq/data/ChatMessage:shmsgseq	J
    //   432: lstore 7
    //   434: aload_0
    //   435: getfield 44	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:d	Ljava/util/HashMap;
    //   438: aload_1
    //   439: lload 7
    //   441: invokestatic 241	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   444: invokevirtual 242	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   447: pop
    //   448: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +354 -> 805
    //   454: new 75	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   461: astore_2
    //   462: aload_2
    //   463: ldc 244
    //   465: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload_2
    //   470: aload_1
    //   471: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_2
    //   476: ldc 246
    //   478: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_2
    //   483: lload 7
    //   485: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: ldc 169
    //   491: iconst_2
    //   492: aload_2
    //   493: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: goto +306 -> 805
    //   502: aload_0
    //   503: getfield 44	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:d	Ljava/util/HashMap;
    //   506: aload_1
    //   507: invokevirtual 249	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   510: checkcast 237	java/lang/Long
    //   513: invokevirtual 253	java/lang/Long:longValue	()J
    //   516: lstore 7
    //   518: aload_2
    //   519: invokeinterface 194 1 0
    //   524: istore 6
    //   526: iconst_0
    //   527: istore_3
    //   528: iload 5
    //   530: istore 4
    //   532: iload_3
    //   533: iload 6
    //   535: if_icmpge +28 -> 563
    //   538: aload_2
    //   539: iload_3
    //   540: invokeinterface 198 2 0
    //   545: checkcast 200	com/tencent/mobileqq/data/ChatMessage
    //   548: getfield 235	com/tencent/mobileqq/data/ChatMessage:shmsgseq	J
    //   551: lload 7
    //   553: lcmp
    //   554: iflt +339 -> 893
    //   557: iload_3
    //   558: istore 4
    //   560: goto +3 -> 563
    //   563: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +56 -> 622
    //   569: new 75	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   576: astore 10
    //   578: aload 10
    //   580: ldc 255
    //   582: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 10
    //   588: lload 7
    //   590: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 10
    //   596: ldc_w 257
    //   599: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload 10
    //   605: iload 4
    //   607: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: ldc 169
    //   613: iconst_2
    //   614: aload 10
    //   616: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: iload 4
    //   624: ifge +15 -> 639
    //   627: aload_2
    //   628: aload 11
    //   630: invokeinterface 232 2 0
    //   635: pop
    //   636: goto +68 -> 704
    //   639: aload_2
    //   640: iload 4
    //   642: invokeinterface 198 2 0
    //   647: checkcast 200	com/tencent/mobileqq/data/ChatMessage
    //   650: getfield 235	com/tencent/mobileqq/data/ChatMessage:shmsgseq	J
    //   653: lload 7
    //   655: lcmp
    //   656: ifle +16 -> 672
    //   659: aload_2
    //   660: iload 4
    //   662: aload 11
    //   664: invokeinterface 260 3 0
    //   669: goto +35 -> 704
    //   672: aload_2
    //   673: iload 4
    //   675: invokeinterface 198 2 0
    //   680: checkcast 200	com/tencent/mobileqq/data/ChatMessage
    //   683: getfield 235	com/tencent/mobileqq/data/ChatMessage:shmsgseq	J
    //   686: lload 7
    //   688: lcmp
    //   689: ifne +15 -> 704
    //   692: aload_2
    //   693: iload 4
    //   695: iconst_1
    //   696: iadd
    //   697: aload 11
    //   699: invokeinterface 260 3 0
    //   704: aload_0
    //   705: getfield 53	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   708: astore_2
    //   709: aload_2
    //   710: ldc_w 262
    //   713: ldc_w 264
    //   716: ldc 37
    //   718: ldc_w 266
    //   721: ldc_w 268
    //   724: iconst_0
    //   725: iconst_0
    //   726: aload_1
    //   727: ldc 37
    //   729: ldc 37
    //   731: ldc 37
    //   733: invokestatic 273	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   736: goto +69 -> 805
    //   739: return
    //   740: astore_2
    //   741: aload 10
    //   743: monitorexit
    //   744: aload_2
    //   745: athrow
    //   746: astore_2
    //   747: goto +8 -> 755
    //   750: astore_2
    //   751: goto -10 -> 741
    //   754: astore_2
    //   755: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   758: ifeq +42 -> 800
    //   761: new 75	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   768: astore 10
    //   770: aload 10
    //   772: ldc_w 275
    //   775: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: aload 10
    //   781: aload_2
    //   782: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   785: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: ldc 169
    //   791: iconst_2
    //   792: aload 10
    //   794: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: aload_0
    //   801: aload_1
    //   802: invokevirtual 229	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:c	(Ljava/lang/String;)V
    //   805: new 75	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   812: astore_2
    //   813: aload_2
    //   814: aload_1
    //   815: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload_2
    //   820: ldc_w 277
    //   823: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload_2
    //   828: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: astore 10
    //   833: aload_0
    //   834: getfield 97	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:e	Landroid/content/SharedPreferences;
    //   837: astore_2
    //   838: aload_2
    //   839: monitorenter
    //   840: aload_0
    //   841: getfield 97	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:e	Landroid/content/SharedPreferences;
    //   844: aload 10
    //   846: iconst_0
    //   847: invokeinterface 281 3 0
    //   852: iconst_1
    //   853: if_icmpne +8 -> 861
    //   856: aload_0
    //   857: aload_1
    //   858: invokevirtual 283	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:e	(Ljava/lang/String;)V
    //   861: aload_2
    //   862: monitorexit
    //   863: return
    //   864: astore_1
    //   865: aload_2
    //   866: monitorexit
    //   867: goto +5 -> 872
    //   870: aload_1
    //   871: athrow
    //   872: goto -2 -> 870
    //   875: iconst_0
    //   876: istore 9
    //   878: goto -768 -> 110
    //   881: iload_3
    //   882: iconst_1
    //   883: iadd
    //   884: istore_3
    //   885: goto -725 -> 160
    //   888: iconst_m1
    //   889: istore_3
    //   890: goto -699 -> 191
    //   893: iload_3
    //   894: iconst_1
    //   895: iadd
    //   896: istore_3
    //   897: goto -369 -> 528
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	900	0	this	TroopBindPublicAccountMgr
    //   0	900	1	paramString	String
    //   159	738	3	i	int
    //   156	541	4	j	int
    //   161	368	5	k	int
    //   524	12	6	m	int
    //   54	633	7	l	long
    //   105	772	9	bool	boolean
    //   7	838	10	localObject1	Object
    //   29	669	11	localObject2	Object
    //   295	47	12	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   40	59	740	finally
    //   709	736	746	java/lang/Exception
    //   744	746	746	java/lang/Exception
    //   741	744	750	finally
    //   0	40	754	java/lang/Exception
    //   59	97	754	java/lang/Exception
    //   110	129	754	java/lang/Exception
    //   140	149	754	java/lang/Exception
    //   150	158	754	java/lang/Exception
    //   169	188	754	java/lang/Exception
    //   191	274	754	java/lang/Exception
    //   281	297	754	java/lang/Exception
    //   297	312	754	java/lang/Exception
    //   316	361	754	java/lang/Exception
    //   368	380	754	java/lang/Exception
    //   385	390	754	java/lang/Exception
    //   396	412	754	java/lang/Exception
    //   417	499	754	java/lang/Exception
    //   502	526	754	java/lang/Exception
    //   538	557	754	java/lang/Exception
    //   563	622	754	java/lang/Exception
    //   627	636	754	java/lang/Exception
    //   639	669	754	java/lang/Exception
    //   672	704	754	java/lang/Exception
    //   704	709	754	java/lang/Exception
    //   840	861	864	finally
    //   861	863	864	finally
    //   865	867	864	finally
  }
  
  public boolean a(long paramLong)
  {
    return g.contains(Long.valueOf(paramLong));
  }
  
  public int b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b.getCurrentAccountUin());
    localStringBuilder.append("_temp_follow_state");
    paramString = localStringBuilder.toString();
    return this.e.getInt(paramString, -1);
  }
  
  public void b(long paramLong)
  {
    if (!g.contains(Long.valueOf(paramLong))) {
      g.add(Long.valueOf(paramLong));
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
        if (b(paramMessageRecord.frienduin, paramMessageRecord.uniseq))
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
  
  public boolean b(String arg1, long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(???);
    ((StringBuilder)localObject1).append("_btm_pbmsg_seq");
    localObject1 = ((StringBuilder)localObject1).toString();
    for (;;)
    {
      synchronized (this.e)
      {
        long l = this.e.getLong((String)localObject1, -1L);
        if ((l > 0L) && (l == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      synchronized (this.e)
      {
        localObject1 = this.e.edit();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("_btm_pbmsg_seq");
        localObject2 = ((StringBuilder)localObject2).toString();
        ((SharedPreferences.Editor)localObject1).remove((String)localObject2);
        ((SharedPreferences.Editor)localObject1).commit();
        this.d.remove(paramString);
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
  
  public void d(String paramString)
  {
    try
    {
      synchronized (this.e)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_unread_pbmsg_cnt");
        paramString = ((StringBuilder)localObject).toString();
        int i = this.e.getInt(paramString, 0) + 1;
        localObject = this.e.edit();
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
  
  public void e(String paramString)
  {
    try
    {
      synchronized (this.e)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_unread_pbmsg_cnt");
        paramString = ((StringBuilder)localObject).toString();
        localObject = this.e.edit();
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
  
  public boolean f(String paramString)
  {
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a)))
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
  
  public void g(String paramString)
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
      this.a = paramString;
      return;
    }
    finally {}
  }
  
  public boolean h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.c.f(paramString) == null;
  }
  
  public Bundle i(String paramString)
  {
    return (Bundle)this.f.get(paramString);
  }
  
  public void onDestroy()
  {
    g.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr
 * JD-Core Version:    0.7.0.1
 */