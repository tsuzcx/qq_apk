package com.tencent.mobileqq.hotpic;

import adpw;
import adpx;
import adpy;
import adpz;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoRsp;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetVideoInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetVideoInfoRsp;
import com.tencent.pb.hotpicmsg.HotPicMsg.ImgInfo;
import com.tencent.pb.hotpicmsg.HotPicMsg.ReqBody;
import com.tencent.pb.hotpicmsg.HotPicMsg.RspBody;
import com.tencent.pb.hotpicmsg.HotPicMsg.TagInfo;
import com.tencent.pb.hotpicmsg.HotPicMsg.ThirdPartyInfo;
import com.tencent.pb.hotpicmsg.HotPicMsg.VideoInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class HotPicManager
  implements Handler.Callback, Manager
{
  public int a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public QQAppInterface a;
  HotPicManager.HotPicListener jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener;
  private PublicAccountGifListener jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), this);
  Object jdField_a_of_type_JavaLangObject = new Object();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  Set jdField_a_of_type_JavaUtilSet = new HashSet();
  volatile boolean jdField_a_of_type_Boolean = false;
  private SparseArray jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  boolean c = false;
  boolean d = false;
  boolean e = false;
  private boolean f;
  private boolean g;
  
  public HotPicManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + paramQQAppInterface.c(), 0).getInt("k_hotlist_config_v", 0);
  }
  
  public static HotPicManager a(QQAppInterface paramQQAppInterface)
  {
    return (HotPicManager)paramQQAppInterface.getManager(205);
  }
  
  public static ArrayList a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HotPicData localHotPicData = (HotPicData)paramArrayList.next();
      if (localHotPicData.getDataType() == 2) {
        localArrayList.add((HotVideoData)localHotPicData);
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + paramQQAppInterface.c(), 0).edit().putInt("k_hotlist_config_v", paramInt).commit();
  }
  
  private void a(ArrayList paramArrayList)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(HotPicTagInfo.class);
      paramArrayList = ((ArrayList)paramArrayList.clone()).iterator();
      while (paramArrayList.hasNext())
      {
        HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)paramArrayList.next();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localHotPicTagInfo);
      }
    }
    finally {}
  }
  
  private void a(List paramList, int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438807);
    localHotPicTagInfo.version = paramInt;
    localHotPicTagInfo.tagId = 2;
    localHotPicTagInfo.tagType = 1;
    localHotPicTagInfo.position = 0;
    paramList.add(localHotPicTagInfo);
    localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438808);
    localHotPicTagInfo.version = paramInt;
    localHotPicTagInfo.tagId = -20;
    localHotPicTagInfo.tagType = 255;
    localHotPicTagInfo.position = 1;
    paramList.add(localHotPicTagInfo);
  }
  
  private void a(List paramList, boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotPicManager", 2, "updateHotVideoData " + paramBoolean);
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(HotVideoData.class);
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        HotPicData localHotPicData = (HotPicData)localIterator.next();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localHotPicData);
        if (QLog.isColorLevel()) {
          QLog.i("HotPicManager", 2, "updateHotVideoData " + localHotPicData.toString());
        }
      }
      if (!QLog.isColorLevel()) {
        break label162;
      }
    }
    finally {}
    QLog.i("HotPicManager", 2, "updateHotVideoData size:" + paramList.size());
    label162:
  }
  
  /* Error */
  private void b(List paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 225
    //   10: iconst_2
    //   11: new 93	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   18: ldc 248
    //   20: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_2
    //   24: invokevirtual 230	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 234	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: iload_2
    //   34: ifeq +13 -> 47
    //   37: aload_0
    //   38: getfield 129	com/tencent/mobileqq/hotpic/HotPicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: ldc 146
    //   43: invokevirtual 178	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   46: pop
    //   47: aload_0
    //   48: getfield 129	com/tencent/mobileqq/hotpic/HotPicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 255	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   59: aload_1
    //   60: invokeinterface 235 1 0
    //   65: astore_1
    //   66: aload_1
    //   67: invokeinterface 140 1 0
    //   72: ifeq +38 -> 110
    //   75: aload_1
    //   76: invokeinterface 144 1 0
    //   81: checkcast 146	com/tencent/mobileqq/hotpic/HotPicData
    //   84: astore 4
    //   86: aload_0
    //   87: getfield 129	com/tencent/mobileqq/hotpic/HotPicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   90: aload 4
    //   92: invokevirtual 184	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   95: goto -29 -> 66
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 258	java/lang/Exception:printStackTrace	()V
    //   103: aload_3
    //   104: invokevirtual 260	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: aload_3
    //   111: invokevirtual 262	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   114: aload_3
    //   115: invokevirtual 260	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   118: goto -11 -> 107
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_3
    //   128: invokevirtual 260	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	HotPicManager
    //   0	133	1	paramList	List
    //   0	133	2	paramBoolean	boolean
    //   54	74	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   84	7	4	localHotPicData	HotPicData
    // Exception table:
    //   from	to	target	type
    //   55	66	98	java/lang/Exception
    //   66	95	98	java/lang/Exception
    //   110	114	98	java/lang/Exception
    //   2	33	121	finally
    //   37	47	121	finally
    //   47	55	121	finally
    //   103	107	121	finally
    //   114	118	121	finally
    //   127	133	121	finally
    //   55	66	126	finally
    //   66	95	126	finally
    //   99	103	126	finally
    //   110	114	126	finally
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/tencent/mobileqq/hotpic/HotPicManager:e	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 79	com/tencent/mobileqq/hotpic/HotPicManager:e	Z
    //   19: new 264	java/io/File
    //   22: dup
    //   23: getstatic 268	com/tencent/mobileqq/hotpic/HotPicDownLoader:a	Ljava/lang/String;
    //   26: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 275	java/io/File:listFiles	()[Ljava/io/File;
    //   36: astore_3
    //   37: aload 4
    //   39: invokevirtual 278	java/io/File:exists	()Z
    //   42: ifeq -31 -> 11
    //   45: aload 4
    //   47: invokevirtual 281	java/io/File:isDirectory	()Z
    //   50: ifeq -39 -> 11
    //   53: aload_3
    //   54: arraylength
    //   55: istore_1
    //   56: iload_1
    //   57: sipush 500
    //   60: if_icmple -49 -> 11
    //   63: aload_3
    //   64: new 283	adqa
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 286	adqa:<init>	(Lcom/tencent/mobileqq/hotpic/HotPicManager;)V
    //   72: invokestatic 292	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   75: new 38	java/util/HashSet
    //   78: dup
    //   79: invokespecial 39	java/util/HashSet:<init>	()V
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 77	com/tencent/mobileqq/hotpic/HotPicManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   88: invokevirtual 293	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   91: checkcast 74	java/util/LinkedList
    //   94: invokeinterface 235 1 0
    //   99: astore 5
    //   101: aload 5
    //   103: invokeinterface 140 1 0
    //   108: ifeq +64 -> 172
    //   111: aload 5
    //   113: invokeinterface 144 1 0
    //   118: checkcast 146	com/tencent/mobileqq/hotpic/HotPicData
    //   121: getfield 296	com/tencent/mobileqq/hotpic/HotPicData:url	Ljava/lang/String;
    //   124: invokestatic 299	com/tencent/mobileqq/hotpic/HotPicDownLoader:a	(Ljava/lang/String;)Ljava/io/File;
    //   127: astore 6
    //   129: aload 6
    //   131: ifnull -30 -> 101
    //   134: aload 4
    //   136: aload 6
    //   138: invokeinterface 302 2 0
    //   143: pop
    //   144: goto -43 -> 101
    //   147: astore_3
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_3
    //   151: athrow
    //   152: astore 4
    //   154: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq -82 -> 75
    //   160: ldc 225
    //   162: iconst_2
    //   163: ldc_w 304
    //   166: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: goto -94 -> 75
    //   172: new 67	java/util/ArrayList
    //   175: dup
    //   176: invokespecial 68	java/util/ArrayList:<init>	()V
    //   179: astore 5
    //   181: sipush 500
    //   184: istore_1
    //   185: iload_1
    //   186: aload_3
    //   187: arraylength
    //   188: if_icmpge +46 -> 234
    //   191: aload_3
    //   192: iload_1
    //   193: aaload
    //   194: astore 6
    //   196: aload 4
    //   198: aload 6
    //   200: invokeinterface 309 2 0
    //   205: ifeq +16 -> 221
    //   208: aload 4
    //   210: aload 6
    //   212: invokeinterface 312 2 0
    //   217: pop
    //   218: goto +87 -> 305
    //   221: aload 5
    //   223: aload 6
    //   225: invokeinterface 216 2 0
    //   230: pop
    //   231: goto +74 -> 305
    //   234: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +35 -> 272
    //   240: ldc 225
    //   242: iconst_2
    //   243: new 93	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 314
    //   253: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 5
    //   258: invokeinterface 241 1 0
    //   263: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload 5
    //   274: invokeinterface 235 1 0
    //   279: astore_3
    //   280: aload_3
    //   281: invokeinterface 140 1 0
    //   286: ifeq -275 -> 11
    //   289: aload_3
    //   290: invokeinterface 144 1 0
    //   295: checkcast 264	java/io/File
    //   298: invokevirtual 317	java/io/File:delete	()Z
    //   301: pop
    //   302: goto -22 -> 280
    //   305: iload_1
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: goto -124 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	HotPicManager
    //   55	254	1	i	int
    //   6	2	2	bool	boolean
    //   36	28	3	arrayOfFile	java.io.File[]
    //   147	45	3	localObject1	Object
    //   279	11	3	localIterator	Iterator
    //   29	106	4	localObject2	Object
    //   152	57	4	localException	Exception
    //   99	174	5	localObject3	Object
    //   127	97	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   2	7	147	finally
    //   14	56	147	finally
    //   63	75	147	finally
    //   75	101	147	finally
    //   101	129	147	finally
    //   134	144	147	finally
    //   154	169	147	finally
    //   172	181	147	finally
    //   185	191	147	finally
    //   196	218	147	finally
    //   221	231	147	finally
    //   234	272	147	finally
    //   272	280	147	finally
    //   280	302	147	finally
    //   63	75	152	java/lang/Exception
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getInt("hot_pic_last_click", -1);
  }
  
  public ArrayList a()
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilList;
  }
  
  public ArrayList a(int paramInt)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        Object localObject1 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          return localObject1;
        }
        localArrayList = (ArrayList)((ArrayList)localObject1).clone();
        localObject1 = localArrayList;
        if (!a(paramInt)) {
          continue;
        }
        localObject1 = localArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          HotPicData localHotPicData = (HotPicData)((Iterator)localObject1).next();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HotPicManager", 2, "getHotPics IsVideo " + localHotPicData.toString());
          continue;
        }
        localObject3 = localArrayList;
      }
      finally {}
      Object localObject3;
      if (QLog.isColorLevel())
      {
        QLog.d("HotPicManager", 2, "getHotPics IsVideo size:" + localArrayList.size());
        localObject3 = localArrayList;
      }
    }
  }
  
  public LinkedList a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList;
  }
  
  List a()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (a(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i))) {}
      for (;;)
      {
        i += 1;
        break;
        ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
          localArrayList1.addAll(localArrayList2);
        }
      }
    }
    return localArrayList1;
  }
  
  public void a()
  {
    for (;;)
    {
      int j;
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
          this.jdField_b_of_type_Boolean = ((SharedPreferences)localObject1).getBoolean("k_hotlist_f", true);
          this.c = ((SharedPreferences)localObject1).getBoolean("k_hotlist_s_e", false);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          try
          {
            this.jdField_a_of_type_JavaUtilList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(HotPicTagInfo.class, true, null, null, null, null, "position asc", null));
            if (this.jdField_a_of_type_JavaUtilList == null)
            {
              this.jdField_a_of_type_JavaUtilList = new ArrayList();
              a(this.jdField_a_of_type_JavaUtilList, 0);
            }
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            if (!localIterator.hasNext()) {
              break label416;
            }
            HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
            int i = localHotPicTagInfo.tagType;
            if (i == 255) {
              continue;
            }
            j = localHotPicTagInfo.tagId;
            localObject1 = new String[1];
            localObject1[0] = String.valueOf(j);
            if (i != 2) {
              continue;
            }
            localArrayList2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(HotVideoData.class, true, "tag = ?", (String[])localObject1, null, null, "picIndex asc", null);
            localObject1 = localArrayList2;
            if (localArrayList2 == null) {
              localObject1 = new ArrayList();
            }
            localArrayList2 = new ArrayList();
            localArrayList2.addAll((Collection)localObject1);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localArrayList2);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("HotPicManager", 2, "makesureInit localTagInfo name is " + localHotPicTagInfo.tagName);
            continue;
            if (localObject2 == null) {
              continue;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localObject2 = null;
          }
          Collections.sort((List)localObject2, Collections.reverseOrder());
          this.jdField_a_of_type_JavaUtilLinkedList.addAll((Collection)localObject2);
          this.jdField_a_of_type_Int = a();
        }
        return;
      }
      finally {}
      ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(HotPicData.class, true, "tag = ?", (String[])localObject2, null, null, "picIndex asc", null);
      Object localObject2 = localArrayList2;
      if (localArrayList2 == null) {
        localObject2 = new ArrayList();
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject2);
      continue;
      label416:
      ArrayList localArrayList1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(HotPicSendData.class, true, null, null, null, null, null, null);
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    HotPicTagInfo localHotPicTagInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
    } while ((localHotPicTagInfo.tagId != paramInt) || (localHotPicTagInfo.tagType != 2));
    for (int i = 10003;; i = 10002)
    {
      a(i, paramInt);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new adpx(this, paramInt1, paramInt2), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    int j = 1;
    int i = 1;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager", 2, "requestHotPicList " + paramInt1 + "-" + paramInt2 + " version= " + paramInt3 + " tag= " + paramInt4 + " checkUpdate" + paramBoolean + " reqType= " + paramInt5);
        }
        Object localObject1 = new HotPicMsg.ReqBody();
        if (paramInt5 == 10003)
        {
          localObject3 = new HotPicMsg.GetVideoInfoReq();
          ((HotPicMsg.ReqBody)localObject1).setHasFlag(true);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_src_term.set(3);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_start_video_index.set(paramInt1);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_end_video_index.set(paramInt2);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_build_ver.set(paramInt3);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_tag_id.set(paramInt4);
          ((HotPicMsg.GetVideoInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("7.6.3"));
          localObject4 = ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_need_update;
          if (paramBoolean)
          {
            paramInt1 = i;
            ((PBUInt32Field)localObject4).set(paramInt1);
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + SystemClock.uptimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("HotPicManager", 2, "sessionId:" + (String)localObject4);
            }
            ((HotPicMsg.GetVideoInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject4));
            ((HotPicMsg.ReqBody)localObject1).msg_get_videoinfo_req.set((MessageMicro)localObject3);
            localObject1 = ((HotPicMsg.ReqBody)localObject1).toByteArray();
            localObject3 = ByteBuffer.allocate(localObject1.length + 4);
            ((ByteBuffer)localObject3).putInt(localObject1.length + 4).put((byte[])localObject1);
            localObject1 = ((ByteBuffer)localObject3).array();
            localObject3 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), HotPicServlet.class);
            ((NewIntent)localObject3).putExtra("key_body", (byte[])localObject1);
            ((NewIntent)localObject3).putExtra("key_cmd", "ImagePopular.GetInfo");
            ((NewIntent)localObject3).putExtra("REQUEST_CHECK_UPDATE", paramBoolean);
            ((NewIntent)localObject3).putExtra("REQUEST_TAG", paramInt4);
            if (paramBoolean) {
              paramInt5 = 10001;
            }
            ((NewIntent)localObject3).putExtra("REQUEST_TYPE", paramInt5);
            ((NewIntent)localObject3).putExtra("REQUEST_VERSION", paramInt3);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject3);
            return;
          }
          paramInt1 = 0;
          continue;
        }
        Object localObject3 = new HotPicMsg.GetImgInfoReq();
        ((HotPicMsg.ReqBody)localObject1).setHasFlag(true);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_src_term.set(3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_start_pic_index.set(paramInt1);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_end_pic_index.set(paramInt2);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_build_ver.set(paramInt3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_pic_tag.set(paramInt4);
        ((HotPicMsg.GetImgInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("7.6.3"));
        Object localObject4 = ((HotPicMsg.GetImgInfoReq)localObject3).uint32_need_update;
        if (paramBoolean)
        {
          paramInt1 = j;
          ((PBUInt32Field)localObject4).set(paramInt1);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + SystemClock.uptimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("HotPicManager", 2, "sessionId:" + (String)localObject4);
          }
          ((HotPicMsg.GetImgInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject4));
          ((HotPicMsg.ReqBody)localObject1).msg_get_imginfo_req.set((MessageMicro)localObject3);
        }
        else
        {
          paramInt1 = 0;
        }
      }
      finally {}
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject3 = null;
    int i;
    int i1;
    int j;
    boolean bool2;
    int k;
    Object localObject1;
    Object localObject2;
    label233:
    int m;
    label399:
    int n;
    label503:
    Object localObject4;
    label762:
    try
    {
      i = paramIntent.getIntExtra("REQUEST_VERSION", -1);
      i1 = paramIntent.getIntExtra("REQUEST_TAG", -1);
      j = b();
      bool2 = paramIntent.getBooleanExtra("REQUEST_CHECK_UPDATE", false);
      k = paramIntent.getIntExtra("REQUEST_TYPE", -1);
      if (k == 10003)
      {
        bool1 = true;
        if (k != 10001) {
          break label2784;
        }
        bool1 = a(i1);
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager", 2, "handleResonpse: REQUEST_VERSION " + i + " ,REQUEST_TAG:" + i1 + " ,localVersion:" + j + " ,isCheckUpdateRequest:" + bool2 + " ,reqType:" + k);
        }
        if (paramFromServiceMsg.getResultCode() != 1000) {
          break label2132;
        }
        k = paramFromServiceMsg.getWupBuffer().length - 4;
        paramIntent = new byte[k];
        PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, k);
        paramFromServiceMsg.putWupBuffer(paramIntent);
      }
    }
    finally {}
    try
    {
      paramIntent = paramFromServiceMsg.getWupBuffer();
      paramFromServiceMsg = new HotPicMsg.RspBody();
      paramFromServiceMsg.mergeFrom(paramIntent);
      if (bool1)
      {
        localObject1 = (HotPicMsg.GetVideoInfoRsp)paramFromServiceMsg.msg_get_videoinfo_rsp.get();
        localObject2 = null;
        if (((localObject2 == null) || ((((HotPicMsg.GetImgInfoRsp)localObject2).uint32_result.get() != 0) && (((HotPicMsg.GetImgInfoRsp)localObject2).uint32_result.get() != -5))) && ((localObject1 == null) || ((((HotPicMsg.GetVideoInfoRsp)localObject1).int32_result.get() != 0) && (((HotPicMsg.GetVideoInfoRsp)localObject1).int32_result.get() != -5)))) {
          break label1997;
        }
        paramFromServiceMsg = null;
        paramIntent = null;
        if (!bool1) {
          break label863;
        }
        k = ((HotPicMsg.GetVideoInfoRsp)localObject1).uint32_build_ver.get();
        i = k;
        k = i;
      }
    }
    catch (InvalidProtocolBufferMicroException paramIntent)
    {
      label769:
      label863:
      label1017:
      k = i;
      label972:
      label1997:
      i = j;
      label1984:
      j = k;
      break label762;
    }
    try
    {
      if (((HotPicMsg.GetVideoInfoRsp)localObject1).rpt_msg_tag_info.has())
      {
        k = i;
        paramIntent = ((HotPicMsg.GetVideoInfoRsp)localObject1).rpt_msg_tag_info.get();
      }
      k = i;
      paramFromServiceMsg = paramIntent;
      m = i;
      if (!QLog.isColorLevel()) {
        break label2787;
      }
      k = i;
      QLog.d("HotPicManager", 2, "handleResonpse,REQ_GET_VIDEO buildVersion:" + i + " ,result:" + ((HotPicMsg.GetVideoInfoRsp)localObject1).int32_result.get());
      if ((!bool2) || (paramIntent == null)) {
        break label2781;
      }
      k = i;
      if (paramIntent.size() <= 0) {
        break label2781;
      }
      k = i;
      if (QLog.isColorLevel())
      {
        k = i;
        QLog.d("HotPicManager", 2, "handleResonpse update TagInfo:localVersion:" + j + " buildVersion" + i + " hotPicTagInfos .size()" + paramIntent.size());
      }
      if (j != 0) {
        break label972;
      }
      k = i;
      paramFromServiceMsg = this.jdField_a_of_type_JavaUtilList;
      k = i;
      n = 1;
      m = k;
      try
      {
        paramFromServiceMsg.clear();
        m = k;
        a(paramFromServiceMsg, i);
        m = k;
        paramIntent = paramIntent.iterator();
        for (;;)
        {
          m = k;
          if (!paramIntent.hasNext()) {
            break;
          }
          m = k;
          localObject4 = (HotPicMsg.TagInfo)paramIntent.next();
          m = k;
          HotPicTagInfo localHotPicTagInfo = new HotPicTagInfo();
          m = k;
          localHotPicTagInfo.tagType = ((HotPicMsg.TagInfo)localObject4).uint32_tag_type.get();
          m = k;
          localHotPicTagInfo.tagId = ((HotPicMsg.TagInfo)localObject4).uint32_tag_id.get();
          m = k;
          if (localHotPicTagInfo.tagId != 2)
          {
            m = k;
            localHotPicTagInfo.position = paramFromServiceMsg.size();
            m = k;
            localHotPicTagInfo.tagName = ((HotPicMsg.TagInfo)localObject4).bytes_tag_name.get().toStringUtf8();
            m = k;
            localHotPicTagInfo.version = i;
            m = k;
            paramFromServiceMsg.add(localHotPicTagInfo);
            m = k;
            if (QLog.isColorLevel())
            {
              m = k;
              QLog.d("HotPicManager", 2, "handleResonpse update new getLoaclVersion name is " + localHotPicTagInfo.tagName + " position is " + localHotPicTagInfo.position + " tagId is " + localHotPicTagInfo.tagId);
            }
          }
        }
        paramIntent.printStackTrace();
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        j = i;
        i = m;
      }
    }
    catch (InvalidProtocolBufferMicroException paramIntent)
    {
      label2203:
      label2770:
      for (;;)
      {
        label2132:
        label2269:
        i = j;
        j = k;
        break;
      }
      label2773:
      paramIntent = null;
      break label1984;
      break label1984;
      label2781:
      break label1017;
    }
    paramIntent = localObject3;
    for (;;)
    {
      if ((QLog.isColorLevel()) && (paramIntent != null))
      {
        paramFromServiceMsg = paramIntent.iterator();
        for (;;)
        {
          if (paramFromServiceMsg.hasNext())
          {
            localObject1 = (HotPicData)paramFromServiceMsg.next();
            QLog.d("HotPicManager", 2, "onGetResp hotPicObject:" + localObject1);
            continue;
            bool1 = false;
            break;
            localObject2 = (HotPicMsg.GetImgInfoRsp)paramFromServiceMsg.msg_get_imginfo_rsp.get();
            localObject1 = null;
            break label233;
            k = ((HotPicMsg.GetImgInfoRsp)localObject2).uint32_build_ver.get();
            i = k;
            paramIntent = paramFromServiceMsg;
            k = i;
            if (((HotPicMsg.GetImgInfoRsp)localObject2).rpt_msg_tag_info.has())
            {
              k = i;
              paramIntent = ((HotPicMsg.GetImgInfoRsp)localObject2).rpt_msg_tag_info.get();
            }
            k = i;
            paramFromServiceMsg = paramIntent;
            m = i;
            if (!QLog.isColorLevel()) {
              break label2787;
            }
            k = i;
            QLog.d("HotPicManager", 2, "handleResonpse,REQ_GET_PIC buildVersion:" + i + " ,result:" + ((HotPicMsg.GetImgInfoRsp)localObject2).uint32_result.get());
            paramFromServiceMsg = paramIntent;
            m = i;
            break label2787;
            k = i;
            paramFromServiceMsg = this.jdField_b_of_type_JavaUtilList;
            n = 0;
            k = j;
            break label503;
            j = k;
            if (n != 0)
            {
              m = k;
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(104);
              j = k;
            }
            paramFromServiceMsg = null;
            if (bool1)
            {
              m = j;
              localObject2 = ((HotPicMsg.GetVideoInfoRsp)localObject1).rpt_msg_video_info.get();
              paramIntent = paramFromServiceMsg;
              if (localObject2 != null)
              {
                m = j;
                paramIntent = paramFromServiceMsg;
                if (((List)localObject2).size() > 0)
                {
                  m = j;
                  paramIntent = new ArrayList();
                  m = j;
                  paramFromServiceMsg = ((List)localObject2).iterator();
                  for (;;)
                  {
                    m = j;
                    if (!paramFromServiceMsg.hasNext()) {
                      break;
                    }
                    m = j;
                    localObject2 = (HotPicMsg.VideoInfo)paramFromServiceMsg.next();
                    m = j;
                    localObject4 = new HotVideoData();
                    m = j;
                    ((HotVideoData)localObject4).md5 = ((HotPicMsg.VideoInfo)localObject2).bytes_preview_md5.get().toStringUtf8().toUpperCase();
                    m = j;
                    ((HotVideoData)localObject4).width = ((HotPicMsg.VideoInfo)localObject2).uint32_preview_width.get();
                    m = j;
                    ((HotVideoData)localObject4).height = ((HotPicMsg.VideoInfo)localObject2).uint32_preview_height.get();
                    m = j;
                    ((HotVideoData)localObject4).mPreviewUUID = ((HotPicMsg.VideoInfo)localObject2).bytes_preview_uuid.get().toStringUtf8();
                    m = j;
                    ((HotVideoData)localObject4).fileSize = ((HotPicMsg.VideoInfo)localObject2).uint64_preview_size.get();
                    m = j;
                    ((HotVideoData)localObject4).videoLength = ((HotPicMsg.VideoInfo)localObject2).uint64_video_length.get();
                    m = j;
                    ((HotVideoData)localObject4).iconUrl = ((HotPicMsg.VideoInfo)localObject2).bytes_jump_icon.get().toStringUtf8();
                    m = j;
                    ((HotVideoData)localObject4).jumpUrl = ((HotPicMsg.VideoInfo)localObject2).bytes_jump_url.get().toStringUtf8();
                    m = j;
                    ((HotVideoData)localObject4).picIndex = ((HotPicMsg.VideoInfo)localObject2).uint32_video_index.get();
                    m = j;
                    ((HotVideoData)localObject4).videoSource = ((HotPicMsg.VideoInfo)localObject2).bytes_video_source.get().toStringUtf8();
                    m = j;
                    ((HotVideoData)localObject4).name = ((HotPicMsg.VideoInfo)localObject2).bytes_video_name.get().toStringUtf8();
                    m = j;
                    ((HotVideoData)localObject4).originalWidth = ((HotPicMsg.VideoInfo)localObject2).uint32_video_width.get();
                    m = j;
                    ((HotVideoData)localObject4).originalHeight = ((HotPicMsg.VideoInfo)localObject2).uint32_video_height.get();
                    m = j;
                    ((HotVideoData)localObject4).mVideoUUID = ((HotPicMsg.VideoInfo)localObject2).bytes_video_uuid.get().toStringUtf8();
                    m = j;
                    ((HotVideoData)localObject4).originalMD5 = ((HotPicMsg.VideoInfo)localObject2).bytes_video_md5.get().toStringUtf8();
                    m = j;
                    ((HotVideoData)localObject4).mCertificatedIcon = ((HotPicMsg.VideoInfo)localObject2).bytes_certificated_icon.get().toStringUtf8();
                    m = j;
                    ((HotVideoData)localObject4).oringinalSize = ((HotPicMsg.VideoInfo)localObject2).uint64_video_size.get();
                    m = j;
                    ((HotVideoData)localObject4).tag = ((HotPicMsg.GetVideoInfoRsp)localObject1).uint32_tag_id.get();
                    m = j;
                    ((HotVideoData)localObject4).version = i;
                    m = j;
                    ((HotVideoData)localObject4).url = "";
                    m = j;
                    ((HotVideoData)localObject4).originalUrl = "";
                    m = j;
                    paramIntent.add(localObject4);
                  }
                }
              }
            }
            else
            {
              m = j;
              paramFromServiceMsg = ((HotPicMsg.GetImgInfoRsp)localObject2).rpt_msg_img_info.get();
              if (paramFromServiceMsg == null) {
                break label2773;
              }
              m = j;
              if (paramFromServiceMsg.size() <= 0) {
                break label2773;
              }
              m = j;
              paramIntent = new ArrayList();
              k = 0;
              for (;;)
              {
                m = j;
                if (k >= paramFromServiceMsg.size()) {
                  break;
                }
                m = j;
                localObject2 = (HotPicMsg.ImgInfo)paramFromServiceMsg.get(k);
                m = j;
                localObject1 = new HotPicData();
                m = j;
                ((HotPicData)localObject1).version = i;
                m = j;
                ((HotPicData)localObject1).picIndex = ((HotPicMsg.ImgInfo)localObject2).uint32_pic_index.get();
                m = j;
                ((HotPicData)localObject1).fileType = ((HotPicMsg.ImgInfo)localObject2).uint32_file_type.get();
                m = j;
                ((HotPicData)localObject1).sourceType = ((HotPicMsg.ImgInfo)localObject2).uint32_source_type.get();
                m = j;
                ((HotPicData)localObject1).height = ((HotPicMsg.ImgInfo)localObject2).uint32_thumb_file_height.get();
                m = j;
                ((HotPicData)localObject1).width = ((HotPicMsg.ImgInfo)localObject2).uint32_thumb_file_width.get();
                m = j;
                ((HotPicData)localObject1).url = ((HotPicMsg.ImgInfo)localObject2).bytes_thumb_down_url.get().toStringUtf8();
                m = j;
                ((HotPicData)localObject1).md5 = ((HotPicMsg.ImgInfo)localObject2).bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
                m = j;
                ((HotPicData)localObject1).fileSize = ((HotPicMsg.ImgInfo)localObject2).uint64_thumb_file_size.get();
                m = j;
                ((HotPicData)localObject1).originalMD5 = ((HotPicMsg.ImgInfo)localObject2).bytes_file_md5.get().toStringUtf8().toUpperCase();
                m = j;
                ((HotPicData)localObject1).originalUrl = ((HotPicMsg.ImgInfo)localObject2).bytes_pic_down_url.get().toStringUtf8();
                m = j;
                ((HotPicData)localObject1).originalHeight = ((HotPicMsg.ImgInfo)localObject2).uint32_file_height.get();
                m = j;
                ((HotPicData)localObject1).originalWidth = ((HotPicMsg.ImgInfo)localObject2).uint32_file_width.get();
                m = j;
                ((HotPicData)localObject1).oringinalSize = ((HotPicMsg.ImgInfo)localObject2).uint64_file_size.get();
                m = j;
                ((HotPicData)localObject1).tag = i1;
                m = j;
                if (((HotPicData)localObject1).sourceType == 3)
                {
                  m = j;
                  localObject2 = ((HotPicMsg.ImgInfo)localObject2).msg_third_party_info;
                  m = j;
                  ((HotPicData)localObject1).iconUrl = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_icon_url.get().toStringUtf8();
                  m = j;
                  ((HotPicData)localObject1).name = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_name.get().toStringUtf8();
                  m = j;
                  ((HotPicData)localObject1).jumpUrl = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_jump_url.get().toStringUtf8();
                  m = j;
                  ((HotPicData)localObject1).appid = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_appid.get().toStringUtf8();
                }
                m = j;
                paramIntent.add(localObject1);
                k += 1;
              }
            }
            k = j;
            j = i;
            i = k;
            break label769;
            if (bool1) {
              if (QLog.isColorLevel()) {
                QLog.d("HotPicManager", 2, "handleResonpse,REQ_GET_VIDEO error,result:" + ((HotPicMsg.GetVideoInfoRsp)localObject1).int32_result.get());
              }
            }
            for (;;)
            {
              StatisticCollector.a(BaseApplication.getContext()).a(null, "HotPicManagerfail", true, 0L, 0L, null, "");
              k = i;
              paramIntent = null;
              i = j;
              j = k;
              break;
              if (QLog.isColorLevel()) {
                QLog.d("HotPicManager", 2, "handleResonpse,REQ_GET_PIC error,result:" + ((HotPicMsg.GetImgInfoRsp)localObject2).uint32_result.get());
              }
            }
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i1));
            if (QLog.isColorLevel()) {
              QLog.d("HotPicManager", 2, "handleResonpse,msg.getResultCode() error:" + paramFromServiceMsg.getResultCode());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener.b(6, i1, i);
            }
            return;
          }
        }
        QLog.d("HotPicManager", 2, "onGetResp hotPicObject Size" + paramIntent.size());
      }
    }
    if ((paramIntent == null) || (paramIntent.size() <= 0)) {
      if (i == 0)
      {
        i = 5;
        if (!QLog.isColorLevel()) {
          break label2770;
        }
        QLog.d("HotPicManager", 2, "handleResonpse,arrays null,localVersion == 0 result NOTIFY_ERR");
        i = 5;
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder().append("onGetResp result:").append(i).append(" has listener:");
          if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener == null) {
            break label2805;
          }
        }
      }
    }
    label2784:
    label2787:
    label2795:
    label2800:
    label2805:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("HotPicManager", 2, bool1);
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener.b(i, i1, j);
        break label2203;
        if (bool2)
        {
          if (!QLog.isColorLevel()) {
            break label2203;
          }
          QLog.d("HotPicManager", 2, "handleResonpse,arrays null,isCheckUpdateRequest result NOTIFY_NO_UPDATE");
          break label2203;
        }
        i = 6;
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i1));
        if (!QLog.isColorLevel()) {
          break label2770;
        }
        QLog.d("HotPicManager", 2, "handleResonpse,arrays null,result NOTIFY_ERR_AT_LOAD_MORE");
        i = 6;
        break label2269;
        paramFromServiceMsg = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager", 2, "handleResonpse, newversion " + j + " local " + i);
        }
        if (i != j)
        {
          if (!bool2) {
            break label2203;
          }
          this.jdField_b_of_type_AndroidUtilSparseArray.clear();
          this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, paramIntent);
          if (!QLog.isColorLevel()) {
            break label2203;
          }
          QLog.d("HotPicManager", 2, "handleResonpse, newversion " + j + " local " + i);
          break label2203;
        }
        if (paramFromServiceMsg.size() == 0)
        {
          paramFromServiceMsg.addAll(paramIntent);
          i = 7;
          if (bool1)
          {
            a(a(paramIntent), false);
            break label2269;
          }
          b(paramFromServiceMsg, false);
          break label2269;
        }
        if (i == 0) {
          break label2800;
        }
        if (((HotPicData)paramIntent.get(0)).picIndex == paramFromServiceMsg.size())
        {
          if (bool1)
          {
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).addAll(a(paramIntent));
            paramFromServiceMsg.addAll((Collection)localObject1);
            a((List)localObject1, false);
            break label2795;
          }
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(paramIntent);
          paramFromServiceMsg.addAll((Collection)localObject1);
          b((List)localObject1, false);
          break label2795;
        }
        QLog.d("HotPicManager", 1, "wrong begin index " + ((HotPicData)paramIntent.get(0)).picIndex + ", local " + paramFromServiceMsg.size() + ",tag " + i1);
        break label2203;
      }
      ThreadManager.getUIHandler().post(new adpy(this));
      break label2203;
      break;
      paramIntent = paramFromServiceMsg;
      i = m;
      break label399;
      i = 3;
      break label2269;
      i = 5;
      break label2269;
    }
  }
  
  public void a(HotPicData paramHotPicData)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilLinkedList.size()) {
      if (!((HotPicSendData)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).md5.equals(paramHotPicData.md5)) {}
    }
    for (;;)
    {
      if (i >= 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
      }
      HotPicSendData localHotPicSendData1;
      if ((paramHotPicData instanceof HotPicSendData))
      {
        localHotPicSendData1 = (HotPicSendData)paramHotPicData;
        label62:
        localHotPicSendData1.sendTime = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(localHotPicSendData1);
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 500) {
          break label173;
        }
      }
      label173:
      for (HotPicSendData localHotPicSendData2 = (HotPicSendData)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();; localHotPicSendData2 = null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener.b(8, -20, 0);
        }
        ThreadManager.post(new adpw(this, localHotPicSendData1, localHotPicSendData2), 5, null, false);
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener.a(paramHotPicData);
        }
        return;
        i += 1;
        break;
        localHotPicSendData1 = HotPicSendData.build(paramHotPicData);
        break label62;
      }
      i = -1;
    }
  }
  
  public void a(HotPicManager.HotPicListener paramHotPicListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener = paramHotPicListener;
  }
  
  public void a(HotPicTagInfo paramHotPicTagInfo)
  {
    int i = paramHotPicTagInfo.tagId;
    if ((a()) || (this.g))
    {
      this.g = false;
      if (i != -20) {
        a(10001, paramHotPicTagInfo.tagId);
      }
    }
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new adpz(this, i), 5, null, false);
  }
  
  public void a(PublicAccountGifListener paramPublicAccountGifListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener = paramPublicAccountGifListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool = false;
    int i;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          Object localObject1 = (HotPicTagInfo)localIterator.next();
          i = ((HotPicTagInfo)localObject1).tagId;
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(i);
          SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
          localObject1 = localArrayList;
          if (localArrayList == null) {
            localObject1 = new ArrayList();
          }
          localSparseArray.put(i, localObject1);
        }
      }
      if (QLog.isColorLevel()) {
        if ("update NewVersionTagInfo" + this.jdField_b_of_type_JavaUtilList.get(0) != null) {
          break label232;
        }
      }
    }
    for (Object localObject3 = "null";; localObject3 = Integer.valueOf(i))
    {
      QLog.d("HotPicManager", 2, new Object[] { localObject3 });
      this.jdField_b_of_type_AndroidUtilSparseArray.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.e = true;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(101);
      bool = true;
      return bool;
      label232:
      i = ((HotPicTagInfo)this.jdField_b_of_type_JavaUtilList.get(0)).version;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    HotPicTagInfo localHotPicTagInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
    } while ((localHotPicTagInfo.tagId != paramInt) || (localHotPicTagInfo.tagType != 2));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        int i = ((HotPicTagInfo)localIterator.next()).version;
        if (i != 0) {
          return i;
        }
      }
      return 0;
    }
  }
  
  List b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (HotPicTagInfo)localIterator.next();
      if (((HotPicTagInfo)localObject).tagType == 2)
      {
        localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(((HotPicTagInfo)localObject).tagId);
        if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
          localArrayList.addAll(a((ArrayList)localObject));
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (HotVideoData)localIterator.next();
        QLog.d("HotPicManager", 2, "getAllHotVideoDatas item:" + ((HotVideoData)localObject).toString());
      }
      QLog.d("HotPicManager", 2, "getAllHotVideoDatas size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (!this.c) {}
    do
    {
      return;
      a();
      if (this.jdField_a_of_type_Int != -1)
      {
        if (this.jdField_a_of_type_Int != -20)
        {
          a(10001, this.jdField_a_of_type_Int);
          return;
        }
        a(10001, 2);
        return;
      }
    } while (!this.jdField_b_of_type_Boolean);
    a(10001, 2);
  }
  
  public void b(int paramInt)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label127;
        }
        QLog.i("HotPicManager", 1, "updateConfig entry" + paramInt);
      }
      finally {}
      this.c = bool;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putBoolean("k_hotlist_s_e", this.c).commit();
      if (this.c) {
        b();
      }
      return;
      bool = false;
      continue;
      label127:
      if (paramInt != 1) {}
    }
  }
  
  public boolean b()
  {
    if ((!this.c) && (!this.d))
    {
      this.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getBoolean("k_hotlist_s_e", false);
      this.d = true;
    }
    return this.c;
  }
  
  /* Error */
  public boolean b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/tencent/mobileqq/hotpic/HotPicManager:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual 325	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 67	java/util/ArrayList
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +18 -> 33
    //   18: aload_3
    //   19: invokevirtual 333	java/util/ArrayList:size	()I
    //   22: istore_1
    //   23: iload_1
    //   24: ifle +9 -> 33
    //   27: iconst_1
    //   28: istore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_2
    //   35: goto -6 -> 29
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	HotPicManager
    //   0	43	1	paramInt	int
    //   28	7	2	bool	boolean
    //   13	6	3	localArrayList	ArrayList
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	38	finally
    //   18	23	38	finally
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(102);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(103, 10000L);
  }
  
  public boolean c(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt));
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1059	com/tencent/mobileqq/hotpic/HotPicManager:a	()Z
    //   6: ifne +31 -> 37
    //   9: aload_0
    //   10: getfield 1069	com/tencent/mobileqq/hotpic/HotPicManager:f	Z
    //   13: ifne +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 1089	com/tencent/mobileqq/hotpic/HotPicManager:b	()V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 1069	com/tencent/mobileqq/hotpic/HotPicManager:f	Z
    //   25: aload_0
    //   26: getfield 58	com/tencent/mobileqq/hotpic/HotPicManager:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   29: bipush 103
    //   31: invokevirtual 1099	com/tencent/util/WeakReferenceHandler:removeMessages	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 1061	com/tencent/mobileqq/hotpic/HotPicManager:g	Z
    //   42: goto -17 -> 25
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	HotPicManager
    //   45	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	45	finally
    //   25	34	45	finally
    //   37	42	45	finally
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putBoolean("k_hotlist_f", false).commit();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i == 101)
    {
      a(a());
      b(a(), true);
      a(b(), true);
      return true;
    }
    if (i == 104)
    {
      a(a());
      return false;
    }
    if (i == 102)
    {
      f();
      return false;
    }
    if ((i == 103) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener == null)) {
      paramMessage = a().iterator();
    }
    for (;;)
    {
      Object localObject;
      if (paramMessage.hasNext())
      {
        localObject = (HotPicData)paramMessage.next();
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener == null) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager", 2, "clear urldrawable cache");
        }
        return false;
      }
      try
      {
        if (((HotPicData)localObject).getDataType() == 2)
        {
          localObject = HotVideoPreviewDownloader.a((HotVideoData)localObject);
          if (localObject != null) {
            URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
          }
        }
        else
        {
          URLDrawable.removeMemoryCacheByUrl(HotPicDownLoader.a(((HotPicData)localObject).url).toString());
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager
 * JD-Core Version:    0.7.0.1
 */