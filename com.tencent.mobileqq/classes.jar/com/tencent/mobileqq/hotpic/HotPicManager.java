package com.tencent.mobileqq.hotpic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
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
  private SparseArray<ArrayList<HotPicData>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HotPicManager.HotPicListener jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener;
  private PublicAccountGifListener jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), this);
  Object jdField_a_of_type_JavaLangObject = new Object();
  private LinkedList<HotPicSendData> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<HotPicTagInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  volatile boolean jdField_a_of_type_Boolean = false;
  private SparseArray<ArrayList<HotPicData>> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private List<HotPicTagInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  boolean d = false;
  boolean e = false;
  private boolean f = false;
  private boolean g = false;
  
  public HotPicManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_hotpic_");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt("k_hotlist_config_v", 0);
  }
  
  public static HotPicManager a(QQAppInterface paramQQAppInterface)
  {
    return (HotPicManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_PIC_MANAGER);
  }
  
  public static ArrayList<HotVideoData> a(ArrayList<HotPicData> paramArrayList)
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
  
  private void a(ArrayList<HotPicTagInfo> paramArrayList)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(HotPicTagInfo.class);
      paramArrayList = ((ArrayList)paramArrayList.clone()).iterator();
      while (paramArrayList.hasNext())
      {
        HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)paramArrayList.next();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(localHotPicTagInfo);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  private void a(List<HotPicTagInfo> paramList, int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698965);
    localHotPicTagInfo.version = paramInt;
    localHotPicTagInfo.tagId = 2;
    localHotPicTagInfo.tagType = 1;
    localHotPicTagInfo.position = 0;
    paramList.add(localHotPicTagInfo);
    localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698966);
    localHotPicTagInfo.version = paramInt;
    localHotPicTagInfo.tagId = -20;
    localHotPicTagInfo.tagType = 255;
    localHotPicTagInfo.position = 1;
    paramList.add(localHotPicTagInfo);
  }
  
  private void a(List<HotVideoData> paramList, boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateHotVideoData ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("HotPicManager", 2, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(HotVideoData.class);
      }
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        HotPicData localHotPicData = (HotPicData)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(localHotPicData);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateHotVideoData ");
          localStringBuilder.append(localHotPicData.toString());
          QLog.i("HotPicManager", 2, localStringBuilder.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateHotVideoData size:");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.i("HotPicManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  /* Error */
  private void b(List<HotPicData> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +34 -> 39
    //   8: new 101	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc 255
    //   19: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_3
    //   24: iload_2
    //   25: invokevirtual 234	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 236
    //   31: iconst_2
    //   32: aload_3
    //   33: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: iload_2
    //   40: ifeq +13 -> 53
    //   43: aload_0
    //   44: getfield 143	com/tencent/mobileqq/hotpic/HotPicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   47: ldc 160
    //   49: invokevirtual 181	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   52: pop
    //   53: aload_0
    //   54: getfield 143	com/tencent/mobileqq/hotpic/HotPicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: invokevirtual 259	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual 264	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   65: aload_1
    //   66: invokeinterface 241 1 0
    //   71: astore_1
    //   72: aload_1
    //   73: invokeinterface 154 1 0
    //   78: ifeq +26 -> 104
    //   81: aload_1
    //   82: invokeinterface 158 1 0
    //   87: checkcast 160	com/tencent/mobileqq/hotpic/HotPicData
    //   90: astore 4
    //   92: aload_0
    //   93: getfield 143	com/tencent/mobileqq/hotpic/HotPicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   96: aload 4
    //   98: invokevirtual 188	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   101: goto -29 -> 72
    //   104: aload_3
    //   105: invokevirtual 267	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   108: aload_3
    //   109: invokevirtual 270	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   112: goto +15 -> 127
    //   115: astore_1
    //   116: goto +14 -> 130
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   124: goto -16 -> 108
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: aload_3
    //   131: invokevirtual 270	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: goto +5 -> 144
    //   142: aload_1
    //   143: athrow
    //   144: goto -2 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	HotPicManager
    //   0	147	1	paramList	List<HotPicData>
    //   0	147	2	paramBoolean	boolean
    //   15	116	3	localObject	Object
    //   90	7	4	localHotPicData	HotPicData
    // Exception table:
    //   from	to	target	type
    //   61	72	115	finally
    //   72	101	115	finally
    //   104	108	115	finally
    //   120	124	115	finally
    //   61	72	119	java/lang/Exception
    //   72	101	119	java/lang/Exception
    //   104	108	119	java/lang/Exception
    //   2	39	136	finally
    //   43	53	136	finally
    //   53	61	136	finally
    //   108	112	136	finally
    //   130	136	136	finally
  }
  
  public int a()
  {
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_hotpic_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt("hot_pic_last_click", -1);
  }
  
  public ArrayList<HotPicTagInfo> a()
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilList;
  }
  
  public ArrayList<HotPicData> a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        return localArrayList;
      }
      localArrayList = (ArrayList)localArrayList.clone();
      if (a(paramInt))
      {
        Object localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          HotPicData localHotPicData = (HotPicData)((Iterator)localObject2).next();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getHotPics IsVideo ");
            localStringBuilder.append(localHotPicData.toString());
            QLog.d("HotPicManager", 2, localStringBuilder.toString());
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getHotPics IsVideo size:");
          ((StringBuilder)localObject2).append(localArrayList.size());
          QLog.d("HotPicManager", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public LinkedList<HotPicSendData> a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList;
  }
  
  List<HotPicData> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (!a(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i)))
      {
        ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
          localArrayList1.addAll(localArrayList2);
        }
      }
      i += 1;
    }
    return localArrayList1;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        this.jdField_a_of_type_Boolean = true;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("sp_hotpic_");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
        this.jdField_b_of_type_Boolean = ((SharedPreferences)localObject1).getBoolean("k_hotlist_f", true);
        this.c = ((SharedPreferences)localObject1).getBoolean("k_hotlist_s_e", false);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      finally
      {
        Object localObject1;
        Object localObject3;
        Iterator localIterator;
        List localList;
        continue;
        throw localObject2;
        continue;
        continue;
      }
      try
      {
        this.jdField_a_of_type_JavaUtilList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(HotPicTagInfo.class, true, null, null, null, null, "position asc", null));
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
          a(this.jdField_a_of_type_JavaUtilList, 0);
        }
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
          int i = localHotPicTagInfo.tagType;
          if (i != 255)
          {
            int j = localHotPicTagInfo.tagId;
            localObject1 = new String[1];
            localObject1[0] = String.valueOf(j);
            if (i == 2)
            {
              localObject3 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(HotVideoData.class, true, "tag = ?", (String[])localObject1, null, null, "picIndex asc", null);
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = new ArrayList();
              }
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).addAll((Collection)localObject1);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject3);
            }
            else
            {
              localObject3 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(HotPicData.class, true, "tag = ?", (String[])localObject1, null, null, "picIndex asc", null);
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = new ArrayList();
              }
              this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject1);
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("makesureInit localTagInfo name is ");
            ((StringBuilder)localObject1).append(localHotPicTagInfo.tagName);
            QLog.d("HotPicManager", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(HotPicSendData.class, true, null, null, null, null, null, null);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localList = null;
      }
    }
    if (localList != null)
    {
      Collections.sort(localList, Collections.reverseOrder());
      this.jdField_a_of_type_JavaUtilLinkedList.addAll(localList);
    }
    this.jdField_a_of_type_Int = a();
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
      if ((localHotPicTagInfo.tagId == paramInt) && (localHotPicTagInfo.tagType == 2))
      {
        i = 10003;
        break label59;
      }
    }
    int i = 10002;
    label59:
    a(i, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotPicManager.2(this, paramInt1, paramInt2), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("requestHotPicList ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(" version= ");
        ((StringBuilder)localObject1).append(paramInt3);
        ((StringBuilder)localObject1).append(" tag= ");
        ((StringBuilder)localObject1).append(paramInt4);
        ((StringBuilder)localObject1).append(" checkUpdate");
        ((StringBuilder)localObject1).append(paramBoolean);
        ((StringBuilder)localObject1).append(" reqType= ");
        ((StringBuilder)localObject1).append(paramInt5);
        QLog.d("HotPicManager", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new HotPicMsg.ReqBody();
      int j = 0;
      int i = 0;
      Object localObject4;
      StringBuilder localStringBuilder;
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
        ((HotPicMsg.GetVideoInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("8.7.0"));
        localObject4 = ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_need_update;
        paramInt1 = i;
        if (paramBoolean) {
          paramInt1 = 1;
        }
        ((PBUInt32Field)localObject4).set(paramInt1);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject4).append(SystemClock.uptimeMillis());
        localObject4 = ((StringBuilder)localObject4).toString();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sessionId:");
          localStringBuilder.append((String)localObject4);
          QLog.d("HotPicManager", 2, localStringBuilder.toString());
        }
        ((HotPicMsg.GetVideoInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject4));
        ((HotPicMsg.ReqBody)localObject1).msg_get_videoinfo_req.set((MessageMicro)localObject3);
      }
      else
      {
        localObject3 = new HotPicMsg.GetImgInfoReq();
        ((HotPicMsg.ReqBody)localObject1).setHasFlag(true);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_src_term.set(3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_start_pic_index.set(paramInt1);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_end_pic_index.set(paramInt2);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_build_ver.set(paramInt3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_pic_tag.set(paramInt4);
        ((HotPicMsg.GetImgInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("8.7.0"));
        localObject4 = ((HotPicMsg.GetImgInfoReq)localObject3).uint32_need_update;
        paramInt1 = j;
        if (paramBoolean) {
          paramInt1 = 1;
        }
        ((PBUInt32Field)localObject4).set(paramInt1);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject4).append(SystemClock.uptimeMillis());
        localObject4 = ((StringBuilder)localObject4).toString();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sessionId:");
          localStringBuilder.append((String)localObject4);
          QLog.d("HotPicManager", 2, localStringBuilder.toString());
        }
        ((HotPicMsg.GetImgInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject4));
        ((HotPicMsg.ReqBody)localObject1).msg_get_imginfo_req.set((MessageMicro)localObject3);
      }
      localObject1 = ((HotPicMsg.ReqBody)localObject1).toByteArray();
      Object localObject3 = ByteBuffer.allocate(localObject1.length + 4);
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
    finally {}
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      i = paramIntent.getIntExtra("REQUEST_VERSION", -1);
      i1 = paramIntent.getIntExtra("REQUEST_TAG", -1);
      j = b();
      bool3 = paramIntent.getBooleanExtra("REQUEST_CHECK_UPDATE", false);
      k = paramIntent.getIntExtra("REQUEST_TYPE", -1);
      if (k != 10003) {
        break label3802;
      }
      bool1 = true;
    }
    finally
    {
      for (;;)
      {
        int i1;
        boolean bool3;
        int k;
        int n;
        Object localObject1;
        Object localObject2;
        label1185:
        label2759:
        for (;;)
        {
          label1491:
          label1533:
          throw paramIntent;
        }
        label2973:
        label2976:
        label3802:
        boolean bool1 = false;
        continue;
        label3808:
        paramIntent = null;
        continue;
        label3813:
        int m = i;
        int j = k;
        continue;
        label3823:
        j = k;
        label3827:
        paramIntent = null;
        m = i;
        continue;
        label3835:
        int i = 7;
        continue;
        label3841:
        i = 3;
        continue;
        label3846:
        i = 6;
      }
    }
    if (k == 10001) {
      bool1 = a(i1);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("handleResonpse: REQUEST_VERSION ");
      paramIntent.append(i);
      paramIntent.append(" ,REQUEST_TAG:");
      paramIntent.append(i1);
      paramIntent.append(" ,localVersion:");
      paramIntent.append(j);
      paramIntent.append(" ,isCheckUpdateRequest:");
      paramIntent.append(bool3);
      paramIntent.append(" ,reqType:");
      paramIntent.append(k);
      QLog.d("HotPicManager", 2, paramIntent.toString());
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      k = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[k];
      PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, k);
      paramFromServiceMsg.putWupBuffer(paramIntent);
      m = i;
      n = j;
      try
      {
        paramIntent = paramFromServiceMsg.getWupBuffer();
        m = i;
        n = j;
        paramFromServiceMsg = new HotPicMsg.RspBody();
        m = i;
        n = j;
        paramFromServiceMsg.mergeFrom(paramIntent);
        if (bool1)
        {
          m = i;
          bool2 = bool1;
          n = j;
          try
          {
            paramFromServiceMsg = (HotPicMsg.GetVideoInfoRsp)paramFromServiceMsg.msg_get_videoinfo_rsp.get();
            localObject1 = null;
          }
          catch (InvalidProtocolBufferMicroException paramIntent)
          {
            bool1 = bool2;
            i = m;
          }
        }
        Object localObject3;
        for (;;)
        {
          j = n;
          break label2976;
          m = i;
          n = j;
          localObject1 = (HotPicMsg.GetImgInfoRsp)paramFromServiceMsg.msg_get_imginfo_rsp.get();
          paramFromServiceMsg = null;
          if (localObject1 != null)
          {
            m = i;
            bool2 = bool1;
            n = j;
            if (((HotPicMsg.GetImgInfoRsp)localObject1).int32_result.get() != 0)
            {
              m = i;
              bool2 = bool1;
              n = j;
              k = ((HotPicMsg.GetImgInfoRsp)localObject1).int32_result.get();
              if (k == -5) {}
            }
          }
          else
          {
            if (paramFromServiceMsg == null) {
              break label2759;
            }
            m = i;
            n = j;
            k = paramFromServiceMsg.int32_result.get();
            if (k != 0)
            {
              m = i;
              bool2 = bool1;
              n = j;
              if (paramFromServiceMsg.int32_result.get() != -5) {
                break label2759;
              }
            }
          }
          if (bool1)
          {
            m = i;
            bool2 = bool1;
            n = j;
            k = paramFromServiceMsg.uint32_build_ver.get();
            m = k;
            bool2 = bool1;
            n = j;
            if (!paramFromServiceMsg.rpt_msg_tag_info.has()) {
              break label3808;
            }
            m = k;
            bool2 = bool1;
            n = j;
            paramIntent = paramFromServiceMsg.rpt_msg_tag_info.get();
            m = k;
            bool2 = bool1;
            n = j;
            i = k;
            localObject2 = paramIntent;
            if (QLog.isColorLevel())
            {
              m = k;
              bool2 = bool1;
              n = j;
              localObject2 = new StringBuilder();
              m = k;
              bool2 = bool1;
              n = j;
              ((StringBuilder)localObject2).append("handleResonpse,REQ_GET_VIDEO buildVersion:");
              m = k;
              bool2 = bool1;
              n = j;
              ((StringBuilder)localObject2).append(k);
              m = k;
              bool2 = bool1;
              n = j;
              ((StringBuilder)localObject2).append(" ,result:");
              m = k;
              bool2 = bool1;
              n = j;
              ((StringBuilder)localObject2).append(paramFromServiceMsg.int32_result.get());
              m = k;
              bool2 = bool1;
              n = j;
              QLog.d("HotPicManager", 2, ((StringBuilder)localObject2).toString());
              i = k;
              localObject2 = paramIntent;
            }
          }
          else
          {
            m = i;
            n = j;
            k = ((HotPicMsg.GetImgInfoRsp)localObject1).uint32_build_ver.get();
            m = k;
            n = j;
            bool2 = ((HotPicMsg.GetImgInfoRsp)localObject1).rpt_msg_tag_info.has();
            if (bool2)
            {
              m = k;
              bool2 = bool1;
              n = j;
              paramIntent = ((HotPicMsg.GetImgInfoRsp)localObject1).rpt_msg_tag_info.get();
            }
            else
            {
              paramIntent = null;
            }
            m = k;
            n = j;
            bool2 = QLog.isColorLevel();
            i = k;
            localObject2 = paramIntent;
            if (bool2)
            {
              m = k;
              bool2 = bool1;
              n = j;
              localObject2 = new StringBuilder();
              m = k;
              bool2 = bool1;
              n = j;
              ((StringBuilder)localObject2).append("handleResonpse,REQ_GET_PIC buildVersion:");
              m = k;
              bool2 = bool1;
              n = j;
              ((StringBuilder)localObject2).append(k);
              m = k;
              bool2 = bool1;
              n = j;
              ((StringBuilder)localObject2).append(" ,result:");
              m = k;
              bool2 = bool1;
              n = j;
              ((StringBuilder)localObject2).append(((HotPicMsg.GetImgInfoRsp)localObject1).int32_result.get());
              m = k;
              bool2 = bool1;
              n = j;
              QLog.d("HotPicManager", 2, ((StringBuilder)localObject2).toString());
              localObject2 = paramIntent;
              i = k;
            }
          }
          k = j;
          if (!bool3) {
            break label1533;
          }
          k = j;
          if (localObject2 == null) {
            break label1533;
          }
          m = i;
          bool2 = bool1;
          n = j;
          k = j;
          if (((List)localObject2).size() <= 0) {
            break label1533;
          }
          m = i;
          bool2 = bool1;
          n = j;
          if (QLog.isColorLevel())
          {
            m = i;
            bool2 = bool1;
            n = j;
            paramIntent = new StringBuilder();
            m = i;
            bool2 = bool1;
            n = j;
            paramIntent.append("handleResonpse update TagInfo:localVersion:");
            m = i;
            bool2 = bool1;
            n = j;
            paramIntent.append(j);
            m = i;
            bool2 = bool1;
            n = j;
            paramIntent.append(" buildVersion");
            m = i;
            bool2 = bool1;
            n = j;
            paramIntent.append(i);
            m = i;
            bool2 = bool1;
            n = j;
            paramIntent.append(" hotPicTagInfos .size()");
            m = i;
            bool2 = bool1;
            n = j;
            paramIntent.append(((List)localObject2).size());
            m = i;
            bool2 = bool1;
            n = j;
            QLog.d("HotPicManager", 2, paramIntent.toString());
          }
          m = i;
          bool2 = bool1;
          n = j;
          localObject3 = this.jdField_a_of_type_JavaLangObject;
          m = i;
          bool2 = bool1;
          n = j;
          if (j == 0)
          {
            k = i;
            bool2 = bool1;
            m = j;
          }
          try
          {
            paramIntent = this.jdField_a_of_type_JavaUtilList;
            j = i;
            m = 1;
            break label1185;
            k = i;
            bool2 = bool1;
            m = j;
            paramIntent = this.jdField_b_of_type_JavaUtilList;
            m = 0;
            k = j;
            try
            {
              paramIntent.clear();
              k = j;
              a(paramIntent, i);
              k = j;
              localObject2 = ((List)localObject2).iterator();
              Object localObject4;
              HotPicTagInfo localHotPicTagInfo;
              do
              {
                k = j;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                k = j;
                localObject4 = (HotPicMsg.TagInfo)((Iterator)localObject2).next();
                k = j;
                localHotPicTagInfo = new HotPicTagInfo();
                k = j;
                localHotPicTagInfo.tagType = ((HotPicMsg.TagInfo)localObject4).uint32_tag_type.get();
                k = j;
                localHotPicTagInfo.tagId = ((HotPicMsg.TagInfo)localObject4).uint32_tag_id.get();
                k = j;
                n = localHotPicTagInfo.tagId;
              } while (n == 2);
              try
              {
                do
                {
                  localHotPicTagInfo.position = paramIntent.size();
                  localHotPicTagInfo.tagName = ((HotPicMsg.TagInfo)localObject4).bytes_tag_name.get().toStringUtf8();
                  localHotPicTagInfo.version = i;
                  paramIntent.add(localHotPicTagInfo);
                } while (!QLog.isColorLevel());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("handleResonpse update new getLoaclVersion name is ");
                ((StringBuilder)localObject4).append(localHotPicTagInfo.tagName);
                ((StringBuilder)localObject4).append(" position is ");
                ((StringBuilder)localObject4).append(localHotPicTagInfo.position);
                ((StringBuilder)localObject4).append(" tagId is ");
                ((StringBuilder)localObject4).append(localHotPicTagInfo.tagId);
                QLog.d("HotPicManager", 2, ((StringBuilder)localObject4).toString());
              }
              finally
              {
                break label1491;
              }
              k = j;
              if (m != 0)
              {
                try
                {
                  this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(104);
                }
                catch (InvalidProtocolBufferMicroException paramIntent) {}
                continue;
              }
            }
            finally
            {
              j = k;
            }
            n = j;
          }
          finally
          {
            n = m;
            bool1 = bool2;
            i = k;
          }
        }
        k = i;
        boolean bool2 = bool1;
        m = n;
        m = i;
        bool2 = bool1;
        throw paramIntent;
        if (bool1)
        {
          m = i;
          bool2 = bool1;
          n = k;
          paramIntent = paramFromServiceMsg.rpt_msg_video_info.get();
          if (paramIntent != null)
          {
            m = i;
            bool2 = bool1;
            n = k;
            if (paramIntent.size() > 0)
            {
              m = i;
              bool2 = bool1;
              n = k;
              localObject1 = new ArrayList();
              m = i;
              bool2 = bool1;
              n = k;
              localObject2 = paramIntent.iterator();
              for (;;)
              {
                m = i;
                bool2 = bool1;
                n = k;
                paramIntent = (Intent)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                m = i;
                bool2 = bool1;
                n = k;
                paramIntent = (HotPicMsg.VideoInfo)((Iterator)localObject2).next();
                m = i;
                bool2 = bool1;
                n = k;
                localObject3 = new HotVideoData();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).md5 = paramIntent.bytes_preview_md5.get().toStringUtf8().toUpperCase();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).width = paramIntent.uint32_preview_width.get();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).height = paramIntent.uint32_preview_height.get();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).mPreviewUUID = paramIntent.bytes_preview_uuid.get().toStringUtf8();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).fileSize = paramIntent.uint64_preview_size.get();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).videoLength = paramIntent.uint64_video_length.get();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).iconUrl = paramIntent.bytes_jump_icon.get().toStringUtf8();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).jumpUrl = paramIntent.bytes_jump_url.get().toStringUtf8();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).picIndex = paramIntent.uint32_video_index.get();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).videoSource = paramIntent.bytes_video_source.get().toStringUtf8();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).name = paramIntent.bytes_video_name.get().toStringUtf8();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).originalWidth = paramIntent.uint32_video_width.get();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).originalHeight = paramIntent.uint32_video_height.get();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).mVideoUUID = paramIntent.bytes_video_uuid.get().toStringUtf8();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).originalMD5 = paramIntent.bytes_video_md5.get().toStringUtf8();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).mCertificatedIcon = paramIntent.bytes_certificated_icon.get().toStringUtf8();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).oringinalSize = paramIntent.uint64_video_size.get();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).tag = paramFromServiceMsg.uint32_tag_id.get();
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).version = i;
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).url = "";
                m = i;
                bool2 = bool1;
                n = k;
                ((HotVideoData)localObject3).originalUrl = "";
                m = i;
                bool2 = bool1;
                n = k;
                ((ArrayList)localObject1).add(localObject3);
              }
            }
          }
          paramIntent = null;
          break label3813;
        }
        m = i;
        n = k;
        localObject1 = ((HotPicMsg.GetImgInfoRsp)localObject1).rpt_msg_img_info.get();
        if (localObject1 == null) {
          break label3823;
        }
        m = i;
        n = k;
        if (((List)localObject1).size() <= 0) {
          break label3823;
        }
        m = i;
        n = k;
        paramFromServiceMsg = new ArrayList();
        j = 0;
        for (;;)
        {
          m = i;
          n = k;
          paramIntent = paramFromServiceMsg;
          if (j >= ((List)localObject1).size()) {
            break label3813;
          }
          m = i;
          n = k;
          localObject2 = (HotPicMsg.ImgInfo)((List)localObject1).get(j);
          m = i;
          n = k;
          paramIntent = new HotPicData();
          m = i;
          n = k;
          paramIntent.version = i;
          m = i;
          n = k;
          paramIntent.picIndex = ((HotPicMsg.ImgInfo)localObject2).uint32_pic_index.get();
          m = i;
          n = k;
          paramIntent.fileType = ((HotPicMsg.ImgInfo)localObject2).uint32_file_type.get();
          m = i;
          n = k;
          paramIntent.sourceType = ((HotPicMsg.ImgInfo)localObject2).uint32_source_type.get();
          m = i;
          n = k;
          paramIntent.height = ((HotPicMsg.ImgInfo)localObject2).uint32_thumb_file_height.get();
          m = i;
          n = k;
          paramIntent.width = ((HotPicMsg.ImgInfo)localObject2).uint32_thumb_file_width.get();
          m = i;
          n = k;
          paramIntent.url = ((HotPicMsg.ImgInfo)localObject2).bytes_thumb_down_url.get().toStringUtf8();
          m = i;
          n = k;
          paramIntent.md5 = ((HotPicMsg.ImgInfo)localObject2).bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
          m = i;
          n = k;
          paramIntent.fileSize = ((HotPicMsg.ImgInfo)localObject2).uint64_thumb_file_size.get();
          m = i;
          n = k;
          paramIntent.originalMD5 = ((HotPicMsg.ImgInfo)localObject2).bytes_file_md5.get().toStringUtf8().toUpperCase();
          m = i;
          n = k;
          paramIntent.originalUrl = ((HotPicMsg.ImgInfo)localObject2).bytes_pic_down_url.get().toStringUtf8();
          m = i;
          n = k;
          paramIntent.originalHeight = ((HotPicMsg.ImgInfo)localObject2).uint32_file_height.get();
          m = i;
          n = k;
          paramIntent.originalWidth = ((HotPicMsg.ImgInfo)localObject2).uint32_file_width.get();
          m = i;
          n = k;
          paramIntent.oringinalSize = ((HotPicMsg.ImgInfo)localObject2).uint64_file_size.get();
          m = i;
          n = k;
          paramIntent.tag = i1;
          m = i;
          n = k;
          int i2 = paramIntent.sourceType;
          if (i2 == 3)
          {
            n = i;
            m = k;
          }
          try
          {
            localObject2 = ((HotPicMsg.ImgInfo)localObject2).msg_third_party_info;
            n = i;
            m = k;
            paramIntent.iconUrl = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_icon_url.get().toStringUtf8();
            n = i;
            m = k;
            paramIntent.name = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_name.get().toStringUtf8();
            n = i;
            m = k;
            paramIntent.jumpUrl = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_jump_url.get().toStringUtf8();
            n = i;
            m = k;
            paramIntent.appid = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_appid.get().toStringUtf8();
            n = i;
            m = k;
            paramFromServiceMsg.add(paramIntent);
            j += 1;
          }
          catch (InvalidProtocolBufferMicroException paramIntent)
          {
            j = m;
            break label2973;
          }
        }
        if (bool1)
        {
          n = i;
          m = j;
          if (QLog.isColorLevel())
          {
            n = i;
            m = j;
            paramIntent = new StringBuilder();
            n = i;
            m = j;
            paramIntent.append("handleResonpse,REQ_GET_VIDEO error,result:");
            n = i;
            m = j;
            paramIntent.append(paramFromServiceMsg.int32_result.get());
            n = i;
            m = j;
            QLog.d("HotPicManager", 2, paramIntent.toString());
          }
        }
        else
        {
          n = i;
          m = j;
          if (QLog.isColorLevel())
          {
            n = i;
            m = j;
            paramIntent = new StringBuilder();
            n = i;
            m = j;
            paramIntent.append("handleResonpse,REQ_GET_PIC error,result:");
            n = i;
            m = j;
            paramIntent.append(((HotPicMsg.GetImgInfoRsp)localObject1).int32_result.get());
            n = i;
            m = j;
            QLog.d("HotPicManager", 2, paramIntent.toString());
          }
        }
        n = i;
        m = j;
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "HotPicManagerfail", true, 0L, 0L, null, "");
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        j = n;
        n = m;
      }
      i = n;
      paramIntent.printStackTrace();
      break label3827;
      if ((QLog.isColorLevel()) && (paramIntent != null))
      {
        paramFromServiceMsg = paramIntent.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          localObject1 = (HotPicData)paramFromServiceMsg.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onGetResp hotPicObject:");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("HotPicManager", 2, ((StringBuilder)localObject2).toString());
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onGetResp hotPicObject Size");
        paramFromServiceMsg.append(paramIntent.size());
        QLog.d("HotPicManager", 2, paramFromServiceMsg.toString());
      }
      k = 5;
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramFromServiceMsg = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleResonpse, newversion ");
          ((StringBuilder)localObject1).append(m);
          ((StringBuilder)localObject1).append(" local ");
          ((StringBuilder)localObject1).append(j);
          QLog.d("HotPicManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (j != m)
        {
          if (bool3)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.clear();
            this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, paramIntent);
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("handleResonpse, newversion ");
              paramIntent.append(m);
              paramIntent.append(" local ");
              paramIntent.append(j);
              QLog.d("HotPicManager", 2, paramIntent.toString());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener == null) {
              ThreadManager.getUIHandler().post(new HotPicManager.3(this));
            }
          }
          return;
        }
        if (paramFromServiceMsg.size() == 0)
        {
          paramFromServiceMsg.addAll(paramIntent);
          if (bool1)
          {
            a(a(paramIntent), false);
            break label3835;
          }
          b(paramFromServiceMsg, false);
          break label3835;
        }
        i = k;
        if (j != 0)
        {
          if (((HotPicData)paramIntent.get(0)).picIndex == paramFromServiceMsg.size())
          {
            if (bool1)
            {
              localObject1 = new ArrayList();
              ((ArrayList)localObject1).addAll(a(paramIntent));
              paramFromServiceMsg.addAll((Collection)localObject1);
              a((List)localObject1, false);
              break label3841;
            }
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).addAll(paramIntent);
            paramFromServiceMsg.addAll((Collection)localObject1);
            b((List)localObject1, false);
            break label3841;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("wrong begin index ");
          ((StringBuilder)localObject1).append(((HotPicData)paramIntent.get(0)).picIndex);
          ((StringBuilder)localObject1).append(", local ");
          ((StringBuilder)localObject1).append(paramFromServiceMsg.size());
          ((StringBuilder)localObject1).append(",tag ");
          ((StringBuilder)localObject1).append(i1);
          QLog.d("HotPicManager", 1, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      else if (j == 0)
      {
        i = k;
        if (QLog.isColorLevel())
        {
          QLog.d("HotPicManager", 2, "handleResonpse,arrays null,localVersion == 0 result NOTIFY_ERR");
          i = k;
        }
      }
      else
      {
        if (bool3)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HotPicManager", 2, "handleResonpse,arrays null,isCheckUpdateRequest result NOTIFY_NO_UPDATE");
          }
          return;
        }
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i1));
        if (!QLog.isColorLevel()) {
          break label3846;
        }
        QLog.d("HotPicManager", 2, "handleResonpse,arrays null,result NOTIFY_ERR_AT_LOAD_MORE");
        break label3846;
      }
      bool1 = false;
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onGetResp result:");
        paramIntent.append(i);
        paramIntent.append(" has listener:");
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener != null) {
          bool1 = true;
        }
        paramIntent.append(bool1);
        QLog.d("HotPicManager", 2, paramIntent.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener.b(i, i1, m);
      } else {
        ThreadManager.getUIHandler().post(new HotPicManager.4(this));
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i1));
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("handleResonpse,msg.getResultCode() error:");
        paramIntent.append(paramFromServiceMsg.getResultCode());
        QLog.d("HotPicManager", 2, paramIntent.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener.b(6, i1, i);
      }
      return;
    }
  }
  
  public void a(HotPicData paramHotPicData)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
    {
      if (((HotPicSendData)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).md5.equals(paramHotPicData.md5)) {
        break label49;
      }
      i += 1;
    }
    i = -1;
    label49:
    if (i >= 0) {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
    }
    if ((paramHotPicData instanceof HotPicSendData)) {
      localObject = (HotPicSendData)paramHotPicData;
    } else {
      localObject = HotPicSendData.build(paramHotPicData);
    }
    ((HotPicSendData)localObject).sendTime = NetConnInfoCenter.getServerTime();
    this.jdField_a_of_type_JavaUtilLinkedList.addFirst(localObject);
    HotPicSendData localHotPicSendData;
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 500) {
      localHotPicSendData = (HotPicSendData)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
    } else {
      localHotPicSendData = null;
    }
    HotPicManager.HotPicListener localHotPicListener = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener;
    if (localHotPicListener != null) {
      localHotPicListener.b(8, -20, 0);
    }
    ThreadManager.post(new HotPicManager.1(this, (HotPicSendData)localObject, localHotPicSendData), 5, null, false);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener;
    if (localObject != null) {
      ((PublicAccountGifListener)localObject).a(paramHotPicData);
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
    ThreadManager.post(new HotPicManager.5(this, i), 5, null, false);
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
    if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        Object localObject1;
        while (localIterator.hasNext())
        {
          localObject1 = (HotPicTagInfo)localIterator.next();
          int i = ((HotPicTagInfo)localObject1).tagId;
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(i);
          SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
          localObject1 = localArrayList;
          if (localArrayList == null) {
            localObject1 = new ArrayList();
          }
          localSparseArray.put(i, localObject1);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("update NewVersionTagInfo");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaUtilList.get(0));
          if (((StringBuilder)localObject1).toString() == null) {
            localObject1 = "null";
          } else {
            localObject1 = Integer.valueOf(((HotPicTagInfo)this.jdField_b_of_type_JavaUtilList.get(0)).version);
          }
          QLog.d("HotPicManager", 2, new Object[] { localObject1 });
        }
        this.jdField_b_of_type_AndroidUtilSparseArray.clear();
        this.jdField_b_of_type_JavaUtilList.clear();
        this.e = true;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(101);
        return true;
      }
    }
    return false;
  }
  
  boolean a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    HotPicTagInfo localHotPicTagInfo;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localHotPicTagInfo = (HotPicTagInfo)((Iterator)localObject).next();
    } while ((localHotPicTagInfo.tagId != paramInt) || (localHotPicTagInfo.tagType != 2));
    boolean bool1 = true;
    return bool1;
  }
  
  int b()
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
    for (;;)
    {
      throw localObject2;
    }
  }
  
  List<HotVideoData> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HotPicTagInfo)((Iterator)localObject1).next();
      if (((HotPicTagInfo)localObject2).tagType == 2)
      {
        localObject2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(((HotPicTagInfo)localObject2).tagId);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0)) {
          localArrayList.addAll(a((ArrayList)localObject2));
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotVideoData)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAllHotVideoDatas item:");
        localStringBuilder.append(((HotVideoData)localObject2).toString());
        QLog.d("HotPicManager", 2, localStringBuilder.toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAllHotVideoDatas size:");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.d("HotPicManager", 2, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (!this.c) {
      return;
    }
    a();
    int i = this.jdField_a_of_type_Int;
    if (i != -1)
    {
      if (i != -20)
      {
        a(10001, i);
        return;
      }
      a(10001, 2);
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      a(10001, 2);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("sp_hotpic_");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      localObject3 = ((StringBuilder)localObject3).toString();
      boolean bool1 = false;
      localObject1 = ((MobileQQ)localObject1).getSharedPreferences((String)localObject3, 0);
      boolean bool2 = ((SharedPreferences)localObject1).getBoolean("k_hotlist_f", false);
      if (paramInt == 1) {
        bool1 = true;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateConfig configEntry");
        ((StringBuilder)localObject3).append(bool1);
        ((StringBuilder)localObject3).append(" spEntry:");
        ((StringBuilder)localObject3).append(bool2);
        QLog.i("HotPicManager", 1, ((StringBuilder)localObject3).toString());
      }
      if (bool1 != bool2)
      {
        this.c = bool1;
        ((SharedPreferences)localObject1).edit().putBoolean("k_hotlist_s_e", bool1).commit();
        if (bool1) {
          b();
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    if ((!this.c) && (!this.d))
    {
      MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_hotpic_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      this.c = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("k_hotlist_s_e", false);
      this.d = true;
    }
    return this.c;
  }
  
  public boolean b(int paramInt)
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (localArrayList != null)
      {
        paramInt = localArrayList.size();
        if (paramInt > 0) {
          return true;
        }
      }
      return false;
    }
    finally {}
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(103, 10000L);
  }
  
  public boolean c(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt));
  }
  
  public void d()
  {
    try
    {
      if (!a())
      {
        if (!this.f)
        {
          b();
          this.f = true;
        }
      }
      else {
        this.g = true;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(103);
      return;
    }
    finally {}
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_hotpic_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("k_hotlist_f", false).commit();
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
    if (i == 104) {
      a(a());
    } else if ((i == 103) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener == null)) {
      paramMessage = a().iterator();
    }
    for (;;)
    {
      Object localObject;
      if (paramMessage.hasNext())
      {
        localObject = (HotPicData)paramMessage.next();
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager$HotPicListener != null) {}
      }
      try
      {
        if (((HotPicData)localObject).getDataType() == 2)
        {
          localObject = HotVideoPreviewDownloader.a((HotVideoData)localObject);
          if (localObject == null) {
            continue;
          }
          URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
          continue;
        }
        URLDrawable.removeMemoryCacheByUrl(HotPicDownLoader.a(((HotPicData)localObject).url).toString());
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager", 2, "clear urldrawable cache");
      }
      return false;
    }
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager
 * JD-Core Version:    0.7.0.1
 */