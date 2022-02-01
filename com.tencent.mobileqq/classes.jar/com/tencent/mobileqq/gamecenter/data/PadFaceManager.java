package com.tencent.mobileqq.gamecenter.data;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class PadFaceManager
{
  public static final String a = HardCodeUtil.a(2131905685);
  private static final Comparator<PadFaceAd> m = new PadFaceManager.2();
  private AppInterface b;
  private EntityManager c;
  private boolean d;
  private int e;
  private long f;
  private List<PadFaceAd> g = new ArrayList(4);
  private long h;
  private long i;
  private SharedPreferences j;
  private boolean k;
  private SparseIntArray l = new SparseIntArray();
  
  public PadFaceManager(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
    ThreadManagerV2.executeOnFileThread(new PadFaceManager.1(this));
  }
  
  public static int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    int i1 = 0;
    int n = i1;
    if (paramAppInfo != null) {
      if (paramAppInfo.iNewFlag.get() == 0)
      {
        n = i1;
        if (!paramBoolean) {}
      }
      else
      {
        paramAppInfo = paramAppInfo.buffer.get();
        n = i1;
        if (TextUtils.isEmpty(paramAppInfo)) {}
      }
    }
    try
    {
      paramAppInfo = new JSONObject(paramAppInfo).optString("_show_mission");
      if (TextUtils.isEmpty(paramAppInfo)) {
        return 0;
      }
      n = Integer.parseInt(paramAppInfo);
      return n;
    }
    catch (Exception paramAppInfo) {}
    return 0;
  }
  
  public static Intent a(PadFaceAd paramPadFaceAd, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("pad_face_ad", paramPadFaceAd);
    return localIntent;
  }
  
  public static PadFaceAd a(Intent paramIntent)
  {
    PadFaceAd localPadFaceAd = (PadFaceAd)paramIntent.getParcelableExtra("pad_face_ad");
    if (localPadFaceAd != null) {
      paramIntent.removeExtra("pad_face_ad");
    }
    return localPadFaceAd;
  }
  
  public static PadFaceManager.SWInfo a(AppInterface paramAppInterface)
  {
    Object localObject = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gamecenter_sp");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    localObject = new PadFaceManager.SWInfo();
    ((PadFaceManager.SWInfo)localObject).b = paramAppInterface.getLong("pwa_version", 0L);
    ((PadFaceManager.SWInfo)localObject).a = paramAppInterface.getLong("last_pwa_version", 0L);
    ((PadFaceManager.SWInfo)localObject).c = paramAppInterface.getString("pwa_url", "");
    return localObject;
  }
  
  public static void a(AppInterface paramAppInterface, long paramLong)
  {
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gamecenter_sp");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4).edit().putLong("last_pwa_version", paramLong);
  }
  
  private boolean a(PadFaceAd paramPadFaceAd)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      if (((PadFaceAd)localIterator.next()).padFaceId == paramPadFaceAd.padFaceId) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    ArrayList localArrayList = (ArrayList)this.c.query(PadFaceAd.class);
    this.g.clear();
    if (localArrayList != null) {
      this.g.addAll(localArrayList);
    }
    Collections.sort(this.g, m);
  }
  
  private PadFaceAd d(int paramInt)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      PadFaceAd localPadFaceAd = (PadFaceAd)localIterator.next();
      if (localPadFaceAd.padFaceId == paramInt)
      {
        this.g.remove(localPadFaceAd);
        return localPadFaceAd;
      }
    }
    return null;
  }
  
  public final long a()
  {
    return this.j.getLong("pwa_version", 0L);
  }
  
  public PadFaceAd a(int paramInt)
  {
    try
    {
      boolean bool = this.k;
      localObject3 = null;
      localObject4 = null;
      if (!bool) {
        return null;
      }
      if (!this.d) {
        break label137;
      }
      l1 = NetConnInfoCenter.getServerTime();
      n = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        long l1;
        int n;
        Object localObject1;
        for (;;)
        {
          label137:
          throw localObject2;
        }
        continue;
        label185:
        n += 1;
      }
    }
    localObject1 = localObject4;
    if (n < this.g.size())
    {
      localObject1 = (PadFaceAd)this.g.get(n);
      if ((((PadFaceAd)localObject1).startTime >= l1) || (l1 >= ((PadFaceAd)localObject1).endTime)) {
        break label185;
      }
      if (paramInt > 0) {
        if (((PadFaceAd)localObject1).redPointId != paramInt) {
          break label185;
        }
      }
    }
    else
    {
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (paramInt > 0)
        {
          localObject3 = new PadFaceAd();
          ((PadFaceAd)localObject3).redPointId = paramInt;
        }
      }
      if (localObject3 != null) {
        QLog.e("PadFaceManager", 1, new Object[] { "[getPadFaceToShow] outAd=", localObject3 });
      }
      return localObject3;
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int i2;
    int n;
    int i1;
    long l1;
    try
    {
      if (!this.k) {
        return;
      }
      i2 = a(paramAppInfo, false);
      n = this.l.get(i2);
      if ((i2 > 0) && (c(i2) == null) && (n < 2)) {
        this.l.put(i2, n + 1);
      } else if (this.i != 0L) {
        if (System.currentTimeMillis() - this.i <= this.h) {}
      }
    }
    finally {}
    if (n != 0)
    {
      this.i = System.currentTimeMillis();
      this.j.edit().putLong("last_pad_face_request_time", this.i).commit();
      i1 = this.e;
      l1 = this.f;
    }
    for (;;)
    {
      if (n != 0)
      {
        QLog.e("PadFaceManager", 2, new Object[] { "pullPadFace, mLastRequestTime=", Long.valueOf(this.i) });
        ((IApolloExtensionHandler)this.b.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(i2, i1, l1);
      }
      return;
      n = 0;
      break;
      n = 1;
      break;
      l1 = 0L;
      i1 = 0;
    }
  }
  
  /* Error */
  public void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 300
    //   3: iconst_2
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 354
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_1
    //   17: aastore
    //   18: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   21: new 148	com/tencent/mobileqq/gamecenter/data/PadFaceAd
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 356	com/tencent/mobileqq/gamecenter/data/PadFaceAd:<init>	(Lorg/json/JSONObject;)V
    //   29: astore 13
    //   31: aload_1
    //   32: ldc_w 358
    //   35: iconst_1
    //   36: invokevirtual 362	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   39: iconst_1
    //   40: if_icmpne +9 -> 49
    //   43: iconst_1
    //   44: istore 6
    //   46: goto +6 -> 52
    //   49: iconst_0
    //   50: istore 6
    //   52: aload_1
    //   53: ldc_w 364
    //   56: invokevirtual 368	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   59: lstore 7
    //   61: aload_1
    //   62: ldc 198
    //   64: invokevirtual 118	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 15
    //   69: iconst_2
    //   70: bipush 24
    //   72: aload_1
    //   73: ldc_w 370
    //   76: iconst_2
    //   77: invokevirtual 362	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   80: invokestatic 376	java/lang/Math:min	(II)I
    //   83: invokestatic 379	java/lang/Math:max	(II)I
    //   86: istore 5
    //   88: new 51	java/util/ArrayList
    //   91: dup
    //   92: invokespecial 380	java/util/ArrayList:<init>	()V
    //   95: astore 14
    //   97: aload_0
    //   98: monitorenter
    //   99: aload_0
    //   100: getfield 248	com/tencent/mobileqq/gamecenter/data/PadFaceManager:k	Z
    //   103: ifne +6 -> 109
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: aload_0
    //   110: getfield 250	com/tencent/mobileqq/gamecenter/data/PadFaceManager:h	J
    //   113: lstore 9
    //   115: iload 5
    //   117: i2l
    //   118: ldc2_w 381
    //   121: lmul
    //   122: lstore 11
    //   124: lload 9
    //   126: lload 11
    //   128: lcmp
    //   129: ifeq +512 -> 641
    //   132: aload_0
    //   133: lload 11
    //   135: putfield 250	com/tencent/mobileqq/gamecenter/data/PadFaceManager:h	J
    //   138: ldc_w 300
    //   141: iconst_2
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: ldc_w 384
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: iload 5
    //   156: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   163: iconst_1
    //   164: istore_2
    //   165: goto +3 -> 168
    //   168: iload 6
    //   170: aload_0
    //   171: getfield 243	com/tencent/mobileqq/gamecenter/data/PadFaceManager:d	Z
    //   174: if_icmpeq +478 -> 652
    //   177: aload_0
    //   178: iload 6
    //   180: putfield 243	com/tencent/mobileqq/gamecenter/data/PadFaceManager:d	Z
    //   183: aload_0
    //   184: getfield 243	com/tencent/mobileqq/gamecenter/data/PadFaceManager:d	Z
    //   187: ifne +459 -> 646
    //   190: ldc_w 300
    //   193: iconst_2
    //   194: ldc_w 389
    //   197: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: goto +446 -> 646
    //   203: aload_0
    //   204: invokevirtual 394	com/tencent/mobileqq/gamecenter/data/PadFaceManager:a	()J
    //   207: lstore 9
    //   209: lload 9
    //   211: lload 7
    //   213: lcmp
    //   214: ifeq +444 -> 658
    //   217: ldc_w 300
    //   220: iconst_1
    //   221: iconst_4
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: ldc_w 396
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: aload_0
    //   234: invokevirtual 398	com/tencent/mobileqq/gamecenter/data/PadFaceManager:b	()Ljava/lang/String;
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: ldc_w 400
    //   243: aastore
    //   244: dup
    //   245: iconst_3
    //   246: lload 9
    //   248: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   251: aastore
    //   252: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   255: iconst_1
    //   256: istore_3
    //   257: goto +403 -> 660
    //   260: aload_0
    //   261: getfield 140	com/tencent/mobileqq/gamecenter/data/PadFaceManager:j	Landroid/content/SharedPreferences;
    //   264: invokeinterface 214 1 0
    //   269: astore_1
    //   270: iload_2
    //   271: ifeq +15 -> 286
    //   274: aload_1
    //   275: ldc_w 402
    //   278: iload 5
    //   280: invokeinterface 406 3 0
    //   285: pop
    //   286: iload 4
    //   288: ifeq +26 -> 314
    //   291: aload_0
    //   292: getfield 243	com/tencent/mobileqq/gamecenter/data/PadFaceManager:d	Z
    //   295: ifeq +381 -> 676
    //   298: iconst_1
    //   299: istore_2
    //   300: goto +3 -> 303
    //   303: aload_1
    //   304: ldc_w 408
    //   307: iload_2
    //   308: invokeinterface 406 3 0
    //   313: pop
    //   314: iload_3
    //   315: ifeq +25 -> 340
    //   318: aload_1
    //   319: ldc 198
    //   321: aload 15
    //   323: invokeinterface 412 3 0
    //   328: pop
    //   329: aload_1
    //   330: ldc 184
    //   332: lload 7
    //   334: invokeinterface 220 4 0
    //   339: pop
    //   340: aload_1
    //   341: invokeinterface 329 1 0
    //   346: pop
    //   347: aload_0
    //   348: getfield 243	com/tencent/mobileqq/gamecenter/data/PadFaceManager:d	Z
    //   351: ifeq +337 -> 688
    //   354: aload 13
    //   356: getfield 240	com/tencent/mobileqq/gamecenter/data/PadFaceAd:padFaceId	I
    //   359: ifle +329 -> 688
    //   362: aload_0
    //   363: aload 13
    //   365: invokespecial 414	com/tencent/mobileqq/gamecenter/data/PadFaceManager:a	(Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;)Z
    //   368: ifne +320 -> 688
    //   371: aload_0
    //   372: getfield 56	com/tencent/mobileqq/gamecenter/data/PadFaceManager:g	Ljava/util/List;
    //   375: aload 13
    //   377: invokeinterface 417 2 0
    //   382: pop
    //   383: invokestatic 282	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   386: lstore 7
    //   388: iconst_0
    //   389: istore_2
    //   390: iload_2
    //   391: aload_0
    //   392: getfield 56	com/tencent/mobileqq/gamecenter/data/PadFaceManager:g	Ljava/util/List;
    //   395: invokeinterface 285 1 0
    //   400: if_icmpge +49 -> 449
    //   403: aload_0
    //   404: getfield 56	com/tencent/mobileqq/gamecenter/data/PadFaceManager:g	Ljava/util/List;
    //   407: iload_2
    //   408: invokeinterface 288 2 0
    //   413: checkcast 148	com/tencent/mobileqq/gamecenter/data/PadFaceAd
    //   416: astore_1
    //   417: aload_1
    //   418: getfield 291	com/tencent/mobileqq/gamecenter/data/PadFaceAd:startTime	J
    //   421: lload 7
    //   423: lcmp
    //   424: ifge +13 -> 437
    //   427: lload 7
    //   429: aload_1
    //   430: getfield 294	com/tencent/mobileqq/gamecenter/data/PadFaceAd:endTime	J
    //   433: lcmp
    //   434: iflt +247 -> 681
    //   437: aload 14
    //   439: aload_1
    //   440: invokeinterface 417 2 0
    //   445: pop
    //   446: goto +235 -> 681
    //   449: aload 14
    //   451: invokeinterface 285 1 0
    //   456: ifle +41 -> 497
    //   459: iconst_0
    //   460: istore_2
    //   461: iload_2
    //   462: aload 14
    //   464: invokeinterface 285 1 0
    //   469: if_icmpge +28 -> 497
    //   472: aload_0
    //   473: getfield 56	com/tencent/mobileqq/gamecenter/data/PadFaceManager:g	Ljava/util/List;
    //   476: aload 14
    //   478: iload_2
    //   479: invokeinterface 288 2 0
    //   484: invokeinterface 276 2 0
    //   489: pop
    //   490: iload_2
    //   491: iconst_1
    //   492: iadd
    //   493: istore_2
    //   494: goto -33 -> 461
    //   497: aload_0
    //   498: getfield 56	com/tencent/mobileqq/gamecenter/data/PadFaceManager:g	Ljava/util/List;
    //   501: getstatic 46	com/tencent/mobileqq/gamecenter/data/PadFaceManager:m	Ljava/util/Comparator;
    //   504: invokestatic 269	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   507: aload 13
    //   509: astore_1
    //   510: goto +3 -> 513
    //   513: aload_0
    //   514: monitorexit
    //   515: aload_1
    //   516: ifnull +113 -> 629
    //   519: aload_0
    //   520: getfield 209	com/tencent/mobileqq/gamecenter/data/PadFaceManager:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   523: aload_1
    //   524: invokevirtual 421	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   527: aload 14
    //   529: invokeinterface 285 1 0
    //   534: ifle +95 -> 629
    //   537: aload_0
    //   538: getfield 209	com/tencent/mobileqq/gamecenter/data/PadFaceManager:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   541: astore 13
    //   543: aload 13
    //   545: invokevirtual 425	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   548: astore_1
    //   549: aload_1
    //   550: invokevirtual 430	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   553: iconst_0
    //   554: istore_2
    //   555: iload_2
    //   556: aload 14
    //   558: invokeinterface 285 1 0
    //   563: if_icmpge +27 -> 590
    //   566: aload 13
    //   568: aload 14
    //   570: iload_2
    //   571: invokeinterface 288 2 0
    //   576: checkcast 432	com/tencent/mobileqq/persistence/Entity
    //   579: invokevirtual 435	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   582: pop
    //   583: iload_2
    //   584: iconst_1
    //   585: iadd
    //   586: istore_2
    //   587: goto -32 -> 555
    //   590: aload_1
    //   591: invokevirtual 437	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   594: goto +23 -> 617
    //   597: astore 13
    //   599: goto +23 -> 622
    //   602: astore 13
    //   604: ldc_w 300
    //   607: iconst_1
    //   608: aload 13
    //   610: iconst_0
    //   611: anewarray 4	java/lang/Object
    //   614: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   617: aload_1
    //   618: invokevirtual 443	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   621: return
    //   622: aload_1
    //   623: invokevirtual 443	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   626: aload 13
    //   628: athrow
    //   629: return
    //   630: astore_1
    //   631: aload_0
    //   632: monitorexit
    //   633: goto +5 -> 638
    //   636: aload_1
    //   637: athrow
    //   638: goto -2 -> 636
    //   641: iconst_0
    //   642: istore_2
    //   643: goto -475 -> 168
    //   646: iconst_1
    //   647: istore 4
    //   649: goto -446 -> 203
    //   652: iconst_0
    //   653: istore 4
    //   655: goto -452 -> 203
    //   658: iconst_0
    //   659: istore_3
    //   660: iload_2
    //   661: ifne -401 -> 260
    //   664: iload 4
    //   666: ifne -406 -> 260
    //   669: iload_3
    //   670: ifeq -323 -> 347
    //   673: goto -413 -> 260
    //   676: iconst_0
    //   677: istore_2
    //   678: goto -375 -> 303
    //   681: iload_2
    //   682: iconst_1
    //   683: iadd
    //   684: istore_2
    //   685: goto -295 -> 390
    //   688: aconst_null
    //   689: astore_1
    //   690: goto -177 -> 513
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	693	0	this	PadFaceManager
    //   0	693	1	paramJSONObject	JSONObject
    //   164	521	2	n	int
    //   256	414	3	i1	int
    //   286	379	4	i2	int
    //   86	193	5	i3	int
    //   44	135	6	bool	boolean
    //   59	369	7	l1	long
    //   113	134	9	l2	long
    //   122	12	11	l3	long
    //   29	538	13	localObject1	Object
    //   597	1	13	localObject2	Object
    //   602	25	13	localException	Exception
    //   95	474	14	localArrayList	ArrayList
    //   67	255	15	str	String
    // Exception table:
    //   from	to	target	type
    //   549	553	597	finally
    //   555	583	597	finally
    //   590	594	597	finally
    //   604	617	597	finally
    //   549	553	602	java/lang/Exception
    //   555	583	602	java/lang/Exception
    //   590	594	602	java/lang/Exception
    //   99	108	630	finally
    //   109	115	630	finally
    //   132	163	630	finally
    //   168	200	630	finally
    //   203	209	630	finally
    //   217	255	630	finally
    //   260	270	630	finally
    //   274	286	630	finally
    //   291	298	630	finally
    //   303	314	630	finally
    //   318	340	630	finally
    //   340	347	630	finally
    //   347	388	630	finally
    //   390	437	630	finally
    //   437	446	630	finally
    //   449	459	630	finally
    //   461	490	630	finally
    //   497	507	630	finally
    //   513	515	630	finally
    //   631	633	630	finally
  }
  
  public final String b()
  {
    return this.j.getString("pwa_url", "");
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (!this.k) {
        return;
      }
      PadFaceAd localPadFaceAd = d(paramInt);
      if (localPadFaceAd != null)
      {
        this.e = paramInt;
        this.f = NetConnInfoCenter.getServerTime();
      }
      if (localPadFaceAd != null)
      {
        this.c.remove(localPadFaceAd);
        this.j.edit().putInt("last_id_pad_face_shown", this.e).putLong("last_time_pad_face_shown", this.f).commit();
        ((IApolloExtensionHandler)this.b.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b(paramInt);
      }
      return;
    }
    finally {}
  }
  
  public PadFaceAd c(int paramInt)
  {
    try
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        PadFaceAd localPadFaceAd = (PadFaceAd)localIterator.next();
        if (localPadFaceAd.redPointId == paramInt) {
          return localPadFaceAd;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.PadFaceManager
 * JD-Core Version:    0.7.0.1
 */