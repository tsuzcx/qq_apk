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
  public static final String a;
  private static final Comparator<PadFaceAd> jdField_a_of_type_JavaUtilComparator = new PadFaceManager.2();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private List<PadFaceAd> jdField_a_of_type_JavaUtilList = new ArrayList(4);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131707871);
  }
  
  public PadFaceManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    ThreadManagerV2.executeOnFileThread(new PadFaceManager.1(this));
  }
  
  public static int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    int j = 0;
    int i = j;
    if (paramAppInfo != null) {
      if (paramAppInfo.iNewFlag.get() == 0)
      {
        i = j;
        if (!paramBoolean) {}
      }
      else
      {
        paramAppInfo = paramAppInfo.buffer.get();
        i = j;
        if (TextUtils.isEmpty(paramAppInfo)) {}
      }
    }
    try
    {
      paramAppInfo = new JSONObject(paramAppInfo).optString("_show_mission");
      if (TextUtils.isEmpty(paramAppInfo)) {
        return 0;
      }
      i = Integer.parseInt(paramAppInfo);
      return i;
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
    ((PadFaceManager.SWInfo)localObject).jdField_b_of_type_Long = paramAppInterface.getLong("pwa_version", 0L);
    ((PadFaceManager.SWInfo)localObject).jdField_a_of_type_Long = paramAppInterface.getLong("last_pwa_version", 0L);
    ((PadFaceManager.SWInfo)localObject).jdField_a_of_type_JavaLangString = paramAppInterface.getString("pwa_url", "");
    return localObject;
  }
  
  private void a()
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PadFaceAd.class);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (localArrayList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((PadFaceAd)localIterator.next()).padFaceId == paramPadFaceAd.padFaceId) {
        return true;
      }
    }
    return false;
  }
  
  private PadFaceAd c(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      PadFaceAd localPadFaceAd = (PadFaceAd)localIterator.next();
      if (localPadFaceAd.padFaceId == paramInt)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localPadFaceAd);
        return localPadFaceAd;
      }
    }
    return null;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("pwa_version", 0L);
  }
  
  public PadFaceAd a(int paramInt)
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      localObject3 = null;
      localObject4 = null;
      if (!bool) {
        return null;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label137;
      }
      l = NetConnInfoCenter.getServerTime();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        long l;
        int i;
        Object localObject1;
        for (;;)
        {
          label137:
          throw localObject2;
        }
        continue;
        label185:
        i += 1;
      }
    }
    localObject1 = localObject4;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (PadFaceAd)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((((PadFaceAd)localObject1).startTime >= l) || (l >= ((PadFaceAd)localObject1).endTime)) {
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
  
  public final String a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("pwa_url", "");
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      PadFaceAd localPadFaceAd = c(paramInt);
      if (localPadFaceAd != null)
      {
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      }
      if (localPadFaceAd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localPadFaceAd);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("last_id_pad_face_shown", this.jdField_a_of_type_Int).putLong("last_time_pad_face_shown", this.jdField_a_of_type_Long).commit();
        ((IApolloExtensionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).c(paramInt);
      }
      return;
    }
    finally {}
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int k;
    int i;
    int j;
    long l;
    try
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      k = a(paramAppInfo, false);
      i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(k);
      if ((k > 0) && (b(k) == null) && (i < 2)) {
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(k, i + 1);
      } else if (this.c != 0L) {
        if (System.currentTimeMillis() - this.c <= this.jdField_b_of_type_Long) {}
      }
    }
    finally {}
    if (i != 0)
    {
      this.c = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_pad_face_request_time", this.c).commit();
      j = this.jdField_a_of_type_Int;
      l = this.jdField_a_of_type_Long;
    }
    for (;;)
    {
      if (i != 0)
      {
        QLog.e("PadFaceManager", 2, new Object[] { "pullPadFace, mLastRequestTime=", Long.valueOf(this.c) });
        ((IApolloExtensionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(k, j, l);
      }
      return;
      i = 0;
      break;
      i = 1;
      break;
      l = 0L;
      j = 0;
    }
  }
  
  /* Error */
  public void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 287
    //   3: iconst_2
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 357
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_1
    //   17: aastore
    //   18: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   21: new 139	com/tencent/mobileqq/gamecenter/data/PadFaceAd
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 359	com/tencent/mobileqq/gamecenter/data/PadFaceAd:<init>	(Lorg/json/JSONObject;)V
    //   29: astore 13
    //   31: aload_1
    //   32: ldc_w 361
    //   35: iconst_1
    //   36: invokevirtual 365	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   39: iconst_1
    //   40: if_icmpne +9 -> 49
    //   43: iconst_1
    //   44: istore 6
    //   46: goto +6 -> 52
    //   49: iconst_0
    //   50: istore 6
    //   52: aload_1
    //   53: ldc_w 367
    //   56: invokevirtual 371	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   59: lstore 7
    //   61: aload_1
    //   62: ldc 189
    //   64: invokevirtual 108	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 15
    //   69: iconst_2
    //   70: bipush 24
    //   72: aload_1
    //   73: ldc_w 373
    //   76: iconst_2
    //   77: invokevirtual 365	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   80: invokestatic 379	java/lang/Math:min	(II)I
    //   83: invokestatic 382	java/lang/Math:max	(II)I
    //   86: istore 5
    //   88: new 41	java/util/ArrayList
    //   91: dup
    //   92: invokespecial 383	java/util/ArrayList:<init>	()V
    //   95: astore 14
    //   97: aload_0
    //   98: monitorenter
    //   99: aload_0
    //   100: getfield 257	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_b_of_type_Boolean	Z
    //   103: ifne +6 -> 109
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: aload_0
    //   110: getfield 258	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_b_of_type_Long	J
    //   113: lstore 9
    //   115: iload 5
    //   117: i2l
    //   118: ldc2_w 384
    //   121: lmul
    //   122: lstore 11
    //   124: lload 9
    //   126: lload 11
    //   128: lcmp
    //   129: ifeq +512 -> 641
    //   132: aload_0
    //   133: lload 11
    //   135: putfield 258	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_b_of_type_Long	J
    //   138: ldc_w 287
    //   141: iconst_2
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: ldc_w 387
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: iload 5
    //   156: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   163: iconst_1
    //   164: istore_2
    //   165: goto +3 -> 168
    //   168: iload 6
    //   170: aload_0
    //   171: getfield 254	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_Boolean	Z
    //   174: if_icmpeq +478 -> 652
    //   177: aload_0
    //   178: iload 6
    //   180: putfield 254	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_Boolean	Z
    //   183: aload_0
    //   184: getfield 254	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_Boolean	Z
    //   187: ifne +459 -> 646
    //   190: ldc_w 287
    //   193: iconst_2
    //   194: ldc_w 392
    //   197: invokestatic 395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: goto +446 -> 646
    //   203: aload_0
    //   204: invokevirtual 397	com/tencent/mobileqq/gamecenter/data/PadFaceManager:a	()J
    //   207: lstore 9
    //   209: lload 9
    //   211: lload 7
    //   213: lcmp
    //   214: ifeq +444 -> 658
    //   217: ldc_w 287
    //   220: iconst_1
    //   221: iconst_4
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: ldc_w 399
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: aload_0
    //   234: invokevirtual 401	com/tencent/mobileqq/gamecenter/data/PadFaceManager:a	()Ljava/lang/String;
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: ldc_w 403
    //   243: aastore
    //   244: dup
    //   245: iconst_3
    //   246: lload 9
    //   248: invokestatic 351	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   251: aastore
    //   252: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   255: iconst_1
    //   256: istore_3
    //   257: goto +403 -> 660
    //   260: aload_0
    //   261: getfield 130	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   264: invokeinterface 225 1 0
    //   269: astore_1
    //   270: iload_2
    //   271: ifeq +15 -> 286
    //   274: aload_1
    //   275: ldc_w 405
    //   278: iload 5
    //   280: invokeinterface 306 3 0
    //   285: pop
    //   286: iload 4
    //   288: ifeq +26 -> 314
    //   291: aload_0
    //   292: getfield 254	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_Boolean	Z
    //   295: ifeq +381 -> 676
    //   298: iconst_1
    //   299: istore_2
    //   300: goto +3 -> 303
    //   303: aload_1
    //   304: ldc_w 407
    //   307: iload_2
    //   308: invokeinterface 306 3 0
    //   313: pop
    //   314: iload_3
    //   315: ifeq +25 -> 340
    //   318: aload_1
    //   319: ldc 189
    //   321: aload 15
    //   323: invokeinterface 411 3 0
    //   328: pop
    //   329: aload_1
    //   330: ldc 175
    //   332: lload 7
    //   334: invokeinterface 231 4 0
    //   339: pop
    //   340: aload_1
    //   341: invokeinterface 311 1 0
    //   346: pop
    //   347: aload_0
    //   348: getfield 254	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_Boolean	Z
    //   351: ifeq +337 -> 688
    //   354: aload 13
    //   356: getfield 251	com/tencent/mobileqq/gamecenter/data/PadFaceAd:padFaceId	I
    //   359: ifle +329 -> 688
    //   362: aload_0
    //   363: aload 13
    //   365: invokespecial 413	com/tencent/mobileqq/gamecenter/data/PadFaceManager:a	(Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;)Z
    //   368: ifne +320 -> 688
    //   371: aload_0
    //   372: getfield 46	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   375: aload 13
    //   377: invokeinterface 416 2 0
    //   382: pop
    //   383: invokestatic 269	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   386: lstore 7
    //   388: iconst_0
    //   389: istore_2
    //   390: iload_2
    //   391: aload_0
    //   392: getfield 46	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   395: invokeinterface 272 1 0
    //   400: if_icmpge +49 -> 449
    //   403: aload_0
    //   404: getfield 46	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   407: iload_2
    //   408: invokeinterface 275 2 0
    //   413: checkcast 139	com/tencent/mobileqq/gamecenter/data/PadFaceAd
    //   416: astore_1
    //   417: aload_1
    //   418: getfield 278	com/tencent/mobileqq/gamecenter/data/PadFaceAd:startTime	J
    //   421: lload 7
    //   423: lcmp
    //   424: ifge +13 -> 437
    //   427: lload 7
    //   429: aload_1
    //   430: getfield 281	com/tencent/mobileqq/gamecenter/data/PadFaceAd:endTime	J
    //   433: lcmp
    //   434: iflt +247 -> 681
    //   437: aload 14
    //   439: aload_1
    //   440: invokeinterface 416 2 0
    //   445: pop
    //   446: goto +235 -> 681
    //   449: aload 14
    //   451: invokeinterface 272 1 0
    //   456: ifle +41 -> 497
    //   459: iconst_0
    //   460: istore_2
    //   461: iload_2
    //   462: aload 14
    //   464: invokeinterface 272 1 0
    //   469: if_icmpge +28 -> 497
    //   472: aload_0
    //   473: getfield 46	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   476: aload 14
    //   478: iload_2
    //   479: invokeinterface 275 2 0
    //   484: invokeinterface 263 2 0
    //   489: pop
    //   490: iload_2
    //   491: iconst_1
    //   492: iadd
    //   493: istore_2
    //   494: goto -33 -> 461
    //   497: aload_0
    //   498: getfield 46	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   501: getstatic 36	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   504: invokestatic 220	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   507: aload 13
    //   509: astore_1
    //   510: goto +3 -> 513
    //   513: aload_0
    //   514: monitorexit
    //   515: aload_1
    //   516: ifnull +113 -> 629
    //   519: aload_0
    //   520: getfield 199	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   523: aload_1
    //   524: invokevirtual 420	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   527: aload 14
    //   529: invokeinterface 272 1 0
    //   534: ifle +95 -> 629
    //   537: aload_0
    //   538: getfield 199	com/tencent/mobileqq/gamecenter/data/PadFaceManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   541: astore 13
    //   543: aload 13
    //   545: invokevirtual 424	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   548: astore_1
    //   549: aload_1
    //   550: invokevirtual 429	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   553: iconst_0
    //   554: istore_2
    //   555: iload_2
    //   556: aload 14
    //   558: invokeinterface 272 1 0
    //   563: if_icmpge +27 -> 590
    //   566: aload 13
    //   568: aload 14
    //   570: iload_2
    //   571: invokeinterface 275 2 0
    //   576: checkcast 431	com/tencent/mobileqq/persistence/Entity
    //   579: invokevirtual 300	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   582: pop
    //   583: iload_2
    //   584: iconst_1
    //   585: iadd
    //   586: istore_2
    //   587: goto -32 -> 555
    //   590: aload_1
    //   591: invokevirtual 433	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   594: goto +23 -> 617
    //   597: astore 13
    //   599: goto +23 -> 622
    //   602: astore 13
    //   604: ldc_w 287
    //   607: iconst_1
    //   608: aload 13
    //   610: iconst_0
    //   611: anewarray 4	java/lang/Object
    //   614: invokestatic 436	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   617: aload_1
    //   618: invokevirtual 439	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   621: return
    //   622: aload_1
    //   623: invokevirtual 439	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
    //   164	521	2	i	int
    //   256	414	3	j	int
    //   286	379	4	k	int
    //   86	193	5	m	int
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
  
  public PadFaceAd b(int paramInt)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.PadFaceManager
 * JD-Core Version:    0.7.0.1
 */