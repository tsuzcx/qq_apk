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
  QQAppInterface a;
  volatile boolean b = false;
  boolean c = false;
  Set<Integer> d = new HashSet();
  boolean e = false;
  boolean f = false;
  HotPicManager.HotPicListener g;
  boolean h = false;
  public int i;
  Object j = new Object();
  private WeakReferenceHandler k = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), this);
  private EntityManager l;
  private SparseArray<ArrayList<HotPicData>> m = new SparseArray();
  private SparseArray<ArrayList<HotPicData>> n = new SparseArray();
  private List<HotPicTagInfo> o = new ArrayList();
  private List<HotPicTagInfo> p = new ArrayList();
  private LinkedList<HotPicSendData> q = new LinkedList();
  private boolean r = false;
  private boolean s = false;
  private PublicAccountGifListener t;
  
  public HotPicManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
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
  
  private void a(List<HotPicTagInfo> paramList, int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.a.getApp().getString(2131896957);
    localHotPicTagInfo.version = paramInt;
    localHotPicTagInfo.tagId = 2;
    localHotPicTagInfo.tagType = 1;
    localHotPicTagInfo.position = 0;
    paramList.add(localHotPicTagInfo);
    localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.a.getApp().getString(2131896958);
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
        this.l.drop(HotVideoData.class);
      }
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        HotPicData localHotPicData = (HotPicData)((Iterator)localObject).next();
        this.l.persistOrReplace(localHotPicData);
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
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_hotpic_");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt("k_hotlist_config_v", 0);
  }
  
  private void b(ArrayList<HotPicTagInfo> paramArrayList)
  {
    try
    {
      this.l.drop(HotPicTagInfo.class);
      paramArrayList = ((ArrayList)paramArrayList.clone()).iterator();
      while (paramArrayList.hasNext())
      {
        HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)paramArrayList.next();
        this.l.persistOrReplace(localHotPicTagInfo);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  /* Error */
  private void b(List<HotPicData> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +35 -> 40
    //   8: new 193	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc_w 267
    //   20: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_3
    //   25: iload_2
    //   26: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 205
    //   32: iconst_2
    //   33: aload_3
    //   34: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: iload_2
    //   41: ifeq +13 -> 54
    //   44: aload_0
    //   45: getfield 120	com/tencent/mobileqq/hotpic/HotPicManager:l	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   48: ldc 137
    //   50: invokevirtual 218	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 120	com/tencent/mobileqq/hotpic/HotPicManager:l	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: invokevirtual 271	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 276	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   66: aload_1
    //   67: invokeinterface 219 1 0
    //   72: astore_1
    //   73: aload_1
    //   74: invokeinterface 131 1 0
    //   79: ifeq +26 -> 105
    //   82: aload_1
    //   83: invokeinterface 135 1 0
    //   88: checkcast 137	com/tencent/mobileqq/hotpic/HotPicData
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 120	com/tencent/mobileqq/hotpic/HotPicManager:l	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   97: aload 4
    //   99: invokevirtual 223	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   102: goto -29 -> 73
    //   105: aload_3
    //   106: invokevirtual 279	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   109: aload_3
    //   110: invokevirtual 282	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   113: goto +15 -> 128
    //   116: astore_1
    //   117: goto +14 -> 131
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   125: goto -16 -> 109
    //   128: aload_0
    //   129: monitorexit
    //   130: return
    //   131: aload_3
    //   132: invokevirtual 282	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: goto +5 -> 145
    //   143: aload_1
    //   144: athrow
    //   145: goto -2 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	HotPicManager
    //   0	148	1	paramList	List<HotPicData>
    //   0	148	2	paramBoolean	boolean
    //   15	117	3	localObject	Object
    //   91	7	4	localHotPicData	HotPicData
    // Exception table:
    //   from	to	target	type
    //   62	73	116	finally
    //   73	102	116	finally
    //   105	109	116	finally
    //   121	125	116	finally
    //   62	73	120	java/lang/Exception
    //   73	102	120	java/lang/Exception
    //   105	109	120	java/lang/Exception
    //   2	40	137	finally
    //   44	54	137	finally
    //   54	62	137	finally
    //   109	113	137	finally
    //   131	137	137	finally
  }
  
  public ArrayList<HotPicData> a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.m.get(paramInt);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        return localArrayList;
      }
      localArrayList = (ArrayList)localArrayList.clone();
      if (b(paramInt))
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
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (this.b) {
          continue;
        }
        this.b = true;
        localObject1 = this.a.getApplication();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("sp_hotpic_");
        ((StringBuilder)localObject3).append(this.a.getCurrentUin());
        localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
        this.c = ((SharedPreferences)localObject1).getBoolean("k_hotlist_f", true);
        this.e = ((SharedPreferences)localObject1).getBoolean("k_hotlist_s_e", false);
        this.l = this.a.getEntityManagerFactory().createEntityManager();
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
        this.o = ((ArrayList)this.l.query(HotPicTagInfo.class, true, null, null, null, null, "position asc", null));
        if (this.o == null)
        {
          this.o = new ArrayList();
          a(this.o, 0);
        }
        localIterator = this.o.iterator();
        if (localIterator.hasNext())
        {
          HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
          int i1 = localHotPicTagInfo.tagType;
          if (i1 != 255)
          {
            int i2 = localHotPicTagInfo.tagId;
            localObject1 = new String[1];
            localObject1[0] = String.valueOf(i2);
            if (i1 == 2)
            {
              localObject3 = (ArrayList)this.l.query(HotVideoData.class, true, "tag = ?", (String[])localObject1, null, null, "picIndex asc", null);
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = new ArrayList();
              }
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).addAll((Collection)localObject1);
              this.m.put(i2, localObject3);
            }
            else
            {
              localObject3 = (ArrayList)this.l.query(HotPicData.class, true, "tag = ?", (String[])localObject1, null, null, "picIndex asc", null);
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = new ArrayList();
              }
              this.m.put(i2, localObject1);
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
          localObject1 = (ArrayList)this.l.query(HotPicSendData.class, true, null, null, null, null, null, null);
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
      this.q.addAll(localList);
    }
    this.i = h();
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
      int i2 = 0;
      int i1 = 0;
      Object localObject4;
      StringBuilder localStringBuilder;
      if (paramInt5 == 10003)
      {
        localObject3 = new HotPicMsg.GetVideoInfoReq();
        ((HotPicMsg.ReqBody)localObject1).setHasFlag(true);
        ((HotPicMsg.GetVideoInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
        ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_src_term.set(3);
        ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_start_video_index.set(paramInt1);
        ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_end_video_index.set(paramInt2);
        ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_build_ver.set(paramInt3);
        ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_tag_id.set(paramInt4);
        ((HotPicMsg.GetVideoInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("8.8.17"));
        localObject4 = ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_need_update;
        paramInt1 = i1;
        if (paramBoolean) {
          paramInt1 = 1;
        }
        ((PBUInt32Field)localObject4).set(paramInt1);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
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
        ((HotPicMsg.GetImgInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_src_term.set(3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_start_pic_index.set(paramInt1);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_end_pic_index.set(paramInt2);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_build_ver.set(paramInt3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_pic_tag.set(paramInt4);
        ((HotPicMsg.GetImgInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("8.8.17"));
        localObject4 = ((HotPicMsg.GetImgInfoReq)localObject3).uint32_need_update;
        paramInt1 = i2;
        if (paramBoolean) {
          paramInt1 = 1;
        }
        ((PBUInt32Field)localObject4).set(paramInt1);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
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
      localObject3 = new NewIntent(this.a.getApp(), HotPicServlet.class);
      ((NewIntent)localObject3).putExtra("key_body", (byte[])localObject1);
      ((NewIntent)localObject3).putExtra("key_cmd", "ImagePopular.GetInfo");
      ((NewIntent)localObject3).putExtra("REQUEST_CHECK_UPDATE", paramBoolean);
      ((NewIntent)localObject3).putExtra("REQUEST_TAG", paramInt4);
      if (paramBoolean) {
        paramInt5 = 10001;
      }
      ((NewIntent)localObject3).putExtra("REQUEST_TYPE", paramInt5);
      ((NewIntent)localObject3).putExtra("REQUEST_VERSION", paramInt3);
      this.a.startServlet((NewIntent)localObject3);
      return;
    }
    finally {}
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      i1 = paramIntent.getIntExtra("REQUEST_VERSION", -1);
      i6 = paramIntent.getIntExtra("REQUEST_TAG", -1);
      i2 = m();
      bool3 = paramIntent.getBooleanExtra("REQUEST_CHECK_UPDATE", false);
      i3 = paramIntent.getIntExtra("REQUEST_TYPE", -1);
      if (i3 != 10003) {
        break label3802;
      }
      bool1 = true;
    }
    finally
    {
      for (;;)
      {
        int i6;
        boolean bool3;
        int i3;
        int i5;
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
        int i4 = i1;
        int i2 = i3;
        continue;
        label3823:
        i2 = i3;
        label3827:
        paramIntent = null;
        i4 = i1;
        continue;
        label3835:
        int i1 = 7;
        continue;
        label3841:
        i1 = 3;
        continue;
        label3846:
        i1 = 6;
      }
    }
    if (i3 == 10001) {
      bool1 = b(i6);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("handleResonpse: REQUEST_VERSION ");
      paramIntent.append(i1);
      paramIntent.append(" ,REQUEST_TAG:");
      paramIntent.append(i6);
      paramIntent.append(" ,localVersion:");
      paramIntent.append(i2);
      paramIntent.append(" ,isCheckUpdateRequest:");
      paramIntent.append(bool3);
      paramIntent.append(" ,reqType:");
      paramIntent.append(i3);
      QLog.d("HotPicManager", 2, paramIntent.toString());
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      i3 = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[i3];
      PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i3);
      paramFromServiceMsg.putWupBuffer(paramIntent);
      i4 = i1;
      i5 = i2;
      try
      {
        paramIntent = paramFromServiceMsg.getWupBuffer();
        i4 = i1;
        i5 = i2;
        paramFromServiceMsg = new HotPicMsg.RspBody();
        i4 = i1;
        i5 = i2;
        paramFromServiceMsg.mergeFrom(paramIntent);
        if (bool1)
        {
          i4 = i1;
          bool2 = bool1;
          i5 = i2;
          try
          {
            paramFromServiceMsg = (HotPicMsg.GetVideoInfoRsp)paramFromServiceMsg.msg_get_videoinfo_rsp.get();
            localObject1 = null;
          }
          catch (InvalidProtocolBufferMicroException paramIntent)
          {
            bool1 = bool2;
            i1 = i4;
          }
        }
        Object localObject3;
        for (;;)
        {
          i2 = i5;
          break label2976;
          i4 = i1;
          i5 = i2;
          localObject1 = (HotPicMsg.GetImgInfoRsp)paramFromServiceMsg.msg_get_imginfo_rsp.get();
          paramFromServiceMsg = null;
          if (localObject1 != null)
          {
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            if (((HotPicMsg.GetImgInfoRsp)localObject1).int32_result.get() != 0)
            {
              i4 = i1;
              bool2 = bool1;
              i5 = i2;
              i3 = ((HotPicMsg.GetImgInfoRsp)localObject1).int32_result.get();
              if (i3 == -5) {}
            }
          }
          else
          {
            if (paramFromServiceMsg == null) {
              break label2759;
            }
            i4 = i1;
            i5 = i2;
            i3 = paramFromServiceMsg.int32_result.get();
            if (i3 != 0)
            {
              i4 = i1;
              bool2 = bool1;
              i5 = i2;
              if (paramFromServiceMsg.int32_result.get() != -5) {
                break label2759;
              }
            }
          }
          if (bool1)
          {
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            i3 = paramFromServiceMsg.uint32_build_ver.get();
            i4 = i3;
            bool2 = bool1;
            i5 = i2;
            if (!paramFromServiceMsg.rpt_msg_tag_info.has()) {
              break label3808;
            }
            i4 = i3;
            bool2 = bool1;
            i5 = i2;
            paramIntent = paramFromServiceMsg.rpt_msg_tag_info.get();
            i4 = i3;
            bool2 = bool1;
            i5 = i2;
            i1 = i3;
            localObject2 = paramIntent;
            if (QLog.isColorLevel())
            {
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              localObject2 = new StringBuilder();
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              ((StringBuilder)localObject2).append("handleResonpse,REQ_GET_VIDEO buildVersion:");
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              ((StringBuilder)localObject2).append(i3);
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              ((StringBuilder)localObject2).append(" ,result:");
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              ((StringBuilder)localObject2).append(paramFromServiceMsg.int32_result.get());
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              QLog.d("HotPicManager", 2, ((StringBuilder)localObject2).toString());
              i1 = i3;
              localObject2 = paramIntent;
            }
          }
          else
          {
            i4 = i1;
            i5 = i2;
            i3 = ((HotPicMsg.GetImgInfoRsp)localObject1).uint32_build_ver.get();
            i4 = i3;
            i5 = i2;
            bool2 = ((HotPicMsg.GetImgInfoRsp)localObject1).rpt_msg_tag_info.has();
            if (bool2)
            {
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              paramIntent = ((HotPicMsg.GetImgInfoRsp)localObject1).rpt_msg_tag_info.get();
            }
            else
            {
              paramIntent = null;
            }
            i4 = i3;
            i5 = i2;
            bool2 = QLog.isColorLevel();
            i1 = i3;
            localObject2 = paramIntent;
            if (bool2)
            {
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              localObject2 = new StringBuilder();
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              ((StringBuilder)localObject2).append("handleResonpse,REQ_GET_PIC buildVersion:");
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              ((StringBuilder)localObject2).append(i3);
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              ((StringBuilder)localObject2).append(" ,result:");
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              ((StringBuilder)localObject2).append(((HotPicMsg.GetImgInfoRsp)localObject1).int32_result.get());
              i4 = i3;
              bool2 = bool1;
              i5 = i2;
              QLog.d("HotPicManager", 2, ((StringBuilder)localObject2).toString());
              localObject2 = paramIntent;
              i1 = i3;
            }
          }
          i3 = i2;
          if (!bool3) {
            break label1533;
          }
          i3 = i2;
          if (localObject2 == null) {
            break label1533;
          }
          i4 = i1;
          bool2 = bool1;
          i5 = i2;
          i3 = i2;
          if (((List)localObject2).size() <= 0) {
            break label1533;
          }
          i4 = i1;
          bool2 = bool1;
          i5 = i2;
          if (QLog.isColorLevel())
          {
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            paramIntent = new StringBuilder();
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            paramIntent.append("handleResonpse update TagInfo:localVersion:");
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            paramIntent.append(i2);
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            paramIntent.append(" buildVersion");
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            paramIntent.append(i1);
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            paramIntent.append(" hotPicTagInfos .size()");
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            paramIntent.append(((List)localObject2).size());
            i4 = i1;
            bool2 = bool1;
            i5 = i2;
            QLog.d("HotPicManager", 2, paramIntent.toString());
          }
          i4 = i1;
          bool2 = bool1;
          i5 = i2;
          localObject3 = this.j;
          i4 = i1;
          bool2 = bool1;
          i5 = i2;
          if (i2 == 0)
          {
            i3 = i1;
            bool2 = bool1;
            i4 = i2;
          }
          try
          {
            paramIntent = this.o;
            i2 = i1;
            i4 = 1;
            break label1185;
            i3 = i1;
            bool2 = bool1;
            i4 = i2;
            paramIntent = this.p;
            i4 = 0;
            i3 = i2;
            try
            {
              paramIntent.clear();
              i3 = i2;
              a(paramIntent, i1);
              i3 = i2;
              localObject2 = ((List)localObject2).iterator();
              Object localObject4;
              HotPicTagInfo localHotPicTagInfo;
              do
              {
                i3 = i2;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                i3 = i2;
                localObject4 = (HotPicMsg.TagInfo)((Iterator)localObject2).next();
                i3 = i2;
                localHotPicTagInfo = new HotPicTagInfo();
                i3 = i2;
                localHotPicTagInfo.tagType = ((HotPicMsg.TagInfo)localObject4).uint32_tag_type.get();
                i3 = i2;
                localHotPicTagInfo.tagId = ((HotPicMsg.TagInfo)localObject4).uint32_tag_id.get();
                i3 = i2;
                i5 = localHotPicTagInfo.tagId;
              } while (i5 == 2);
              try
              {
                do
                {
                  localHotPicTagInfo.position = paramIntent.size();
                  localHotPicTagInfo.tagName = ((HotPicMsg.TagInfo)localObject4).bytes_tag_name.get().toStringUtf8();
                  localHotPicTagInfo.version = i1;
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
              i3 = i2;
              if (i4 != 0)
              {
                try
                {
                  this.k.sendEmptyMessage(104);
                }
                catch (InvalidProtocolBufferMicroException paramIntent) {}
                continue;
              }
            }
            finally
            {
              i2 = i3;
            }
            i5 = i2;
          }
          finally
          {
            i5 = i4;
            bool1 = bool2;
            i1 = i3;
          }
        }
        i3 = i1;
        boolean bool2 = bool1;
        i4 = i5;
        i4 = i1;
        bool2 = bool1;
        throw paramIntent;
        if (bool1)
        {
          i4 = i1;
          bool2 = bool1;
          i5 = i3;
          paramIntent = paramFromServiceMsg.rpt_msg_video_info.get();
          if (paramIntent != null)
          {
            i4 = i1;
            bool2 = bool1;
            i5 = i3;
            if (paramIntent.size() > 0)
            {
              i4 = i1;
              bool2 = bool1;
              i5 = i3;
              localObject1 = new ArrayList();
              i4 = i1;
              bool2 = bool1;
              i5 = i3;
              localObject2 = paramIntent.iterator();
              for (;;)
              {
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                paramIntent = (Intent)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                paramIntent = (HotPicMsg.VideoInfo)((Iterator)localObject2).next();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                localObject3 = new HotVideoData();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).md5 = paramIntent.bytes_preview_md5.get().toStringUtf8().toUpperCase();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).width = paramIntent.uint32_preview_width.get();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).height = paramIntent.uint32_preview_height.get();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).mPreviewUUID = paramIntent.bytes_preview_uuid.get().toStringUtf8();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).fileSize = paramIntent.uint64_preview_size.get();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).videoLength = paramIntent.uint64_video_length.get();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).iconUrl = paramIntent.bytes_jump_icon.get().toStringUtf8();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).jumpUrl = paramIntent.bytes_jump_url.get().toStringUtf8();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).picIndex = paramIntent.uint32_video_index.get();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).videoSource = paramIntent.bytes_video_source.get().toStringUtf8();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).name = paramIntent.bytes_video_name.get().toStringUtf8();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).originalWidth = paramIntent.uint32_video_width.get();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).originalHeight = paramIntent.uint32_video_height.get();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).mVideoUUID = paramIntent.bytes_video_uuid.get().toStringUtf8();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).originalMD5 = paramIntent.bytes_video_md5.get().toStringUtf8();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).mCertificatedIcon = paramIntent.bytes_certificated_icon.get().toStringUtf8();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).oringinalSize = paramIntent.uint64_video_size.get();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).tag = paramFromServiceMsg.uint32_tag_id.get();
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).version = i1;
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).url = "";
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((HotVideoData)localObject3).originalUrl = "";
                i4 = i1;
                bool2 = bool1;
                i5 = i3;
                ((ArrayList)localObject1).add(localObject3);
              }
            }
          }
          paramIntent = null;
          break label3813;
        }
        i4 = i1;
        i5 = i3;
        localObject1 = ((HotPicMsg.GetImgInfoRsp)localObject1).rpt_msg_img_info.get();
        if (localObject1 == null) {
          break label3823;
        }
        i4 = i1;
        i5 = i3;
        if (((List)localObject1).size() <= 0) {
          break label3823;
        }
        i4 = i1;
        i5 = i3;
        paramFromServiceMsg = new ArrayList();
        i2 = 0;
        for (;;)
        {
          i4 = i1;
          i5 = i3;
          paramIntent = paramFromServiceMsg;
          if (i2 >= ((List)localObject1).size()) {
            break label3813;
          }
          i4 = i1;
          i5 = i3;
          localObject2 = (HotPicMsg.ImgInfo)((List)localObject1).get(i2);
          i4 = i1;
          i5 = i3;
          paramIntent = new HotPicData();
          i4 = i1;
          i5 = i3;
          paramIntent.version = i1;
          i4 = i1;
          i5 = i3;
          paramIntent.picIndex = ((HotPicMsg.ImgInfo)localObject2).uint32_pic_index.get();
          i4 = i1;
          i5 = i3;
          paramIntent.fileType = ((HotPicMsg.ImgInfo)localObject2).uint32_file_type.get();
          i4 = i1;
          i5 = i3;
          paramIntent.sourceType = ((HotPicMsg.ImgInfo)localObject2).uint32_source_type.get();
          i4 = i1;
          i5 = i3;
          paramIntent.height = ((HotPicMsg.ImgInfo)localObject2).uint32_thumb_file_height.get();
          i4 = i1;
          i5 = i3;
          paramIntent.width = ((HotPicMsg.ImgInfo)localObject2).uint32_thumb_file_width.get();
          i4 = i1;
          i5 = i3;
          paramIntent.url = ((HotPicMsg.ImgInfo)localObject2).bytes_thumb_down_url.get().toStringUtf8();
          i4 = i1;
          i5 = i3;
          paramIntent.md5 = ((HotPicMsg.ImgInfo)localObject2).bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
          i4 = i1;
          i5 = i3;
          paramIntent.fileSize = ((HotPicMsg.ImgInfo)localObject2).uint64_thumb_file_size.get();
          i4 = i1;
          i5 = i3;
          paramIntent.originalMD5 = ((HotPicMsg.ImgInfo)localObject2).bytes_file_md5.get().toStringUtf8().toUpperCase();
          i4 = i1;
          i5 = i3;
          paramIntent.originalUrl = ((HotPicMsg.ImgInfo)localObject2).bytes_pic_down_url.get().toStringUtf8();
          i4 = i1;
          i5 = i3;
          paramIntent.originalHeight = ((HotPicMsg.ImgInfo)localObject2).uint32_file_height.get();
          i4 = i1;
          i5 = i3;
          paramIntent.originalWidth = ((HotPicMsg.ImgInfo)localObject2).uint32_file_width.get();
          i4 = i1;
          i5 = i3;
          paramIntent.oringinalSize = ((HotPicMsg.ImgInfo)localObject2).uint64_file_size.get();
          i4 = i1;
          i5 = i3;
          paramIntent.tag = i6;
          i4 = i1;
          i5 = i3;
          int i7 = paramIntent.sourceType;
          if (i7 == 3)
          {
            i5 = i1;
            i4 = i3;
          }
          try
          {
            localObject2 = ((HotPicMsg.ImgInfo)localObject2).msg_third_party_info;
            i5 = i1;
            i4 = i3;
            paramIntent.iconUrl = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_icon_url.get().toStringUtf8();
            i5 = i1;
            i4 = i3;
            paramIntent.name = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_name.get().toStringUtf8();
            i5 = i1;
            i4 = i3;
            paramIntent.jumpUrl = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_jump_url.get().toStringUtf8();
            i5 = i1;
            i4 = i3;
            paramIntent.appid = ((HotPicMsg.ThirdPartyInfo)localObject2).bytes_appid.get().toStringUtf8();
            i5 = i1;
            i4 = i3;
            paramFromServiceMsg.add(paramIntent);
            i2 += 1;
          }
          catch (InvalidProtocolBufferMicroException paramIntent)
          {
            i2 = i4;
            break label2973;
          }
        }
        if (bool1)
        {
          i5 = i1;
          i4 = i2;
          if (QLog.isColorLevel())
          {
            i5 = i1;
            i4 = i2;
            paramIntent = new StringBuilder();
            i5 = i1;
            i4 = i2;
            paramIntent.append("handleResonpse,REQ_GET_VIDEO error,result:");
            i5 = i1;
            i4 = i2;
            paramIntent.append(paramFromServiceMsg.int32_result.get());
            i5 = i1;
            i4 = i2;
            QLog.d("HotPicManager", 2, paramIntent.toString());
          }
        }
        else
        {
          i5 = i1;
          i4 = i2;
          if (QLog.isColorLevel())
          {
            i5 = i1;
            i4 = i2;
            paramIntent = new StringBuilder();
            i5 = i1;
            i4 = i2;
            paramIntent.append("handleResonpse,REQ_GET_PIC error,result:");
            i5 = i1;
            i4 = i2;
            paramIntent.append(((HotPicMsg.GetImgInfoRsp)localObject1).int32_result.get());
            i5 = i1;
            i4 = i2;
            QLog.d("HotPicManager", 2, paramIntent.toString());
          }
        }
        i5 = i1;
        i4 = i2;
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "HotPicManagerfail", true, 0L, 0L, null, "");
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        i2 = i5;
        i5 = i4;
      }
      i1 = i5;
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
      i3 = 5;
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramFromServiceMsg = (ArrayList)this.m.get(i6);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleResonpse, newversion ");
          ((StringBuilder)localObject1).append(i4);
          ((StringBuilder)localObject1).append(" local ");
          ((StringBuilder)localObject1).append(i2);
          QLog.d("HotPicManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (i2 != i4)
        {
          if (bool3)
          {
            this.n.clear();
            this.n.put(i6, paramIntent);
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("handleResonpse, newversion ");
              paramIntent.append(i4);
              paramIntent.append(" local ");
              paramIntent.append(i2);
              QLog.d("HotPicManager", 2, paramIntent.toString());
            }
            if (this.g == null) {
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
        i1 = i3;
        if (i2 != 0)
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
          ((StringBuilder)localObject1).append(i6);
          QLog.d("HotPicManager", 1, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      else if (i2 == 0)
      {
        i1 = i3;
        if (QLog.isColorLevel())
        {
          QLog.d("HotPicManager", 2, "handleResonpse,arrays null,localVersion == 0 result NOTIFY_ERR");
          i1 = i3;
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
        this.d.add(Integer.valueOf(i6));
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
        paramIntent.append(i1);
        paramIntent.append(" has listener:");
        if (this.g != null) {
          bool1 = true;
        }
        paramIntent.append(bool1);
        QLog.d("HotPicManager", 2, paramIntent.toString());
      }
      if (this.g != null) {
        this.g.b(i1, i6, i4);
      } else {
        ThreadManager.getUIHandler().post(new HotPicManager.4(this));
      }
    }
    else
    {
      this.d.add(Integer.valueOf(i6));
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("handleResonpse,msg.getResultCode() error:");
        paramIntent.append(paramFromServiceMsg.getResultCode());
        QLog.d("HotPicManager", 2, paramIntent.toString());
      }
      if (this.g != null) {
        this.g.b(6, i6, i1);
      }
      return;
    }
  }
  
  public void a(HotPicData paramHotPicData)
  {
    int i1 = 0;
    while (i1 < this.q.size())
    {
      if (((HotPicSendData)this.q.get(i1)).md5.equals(paramHotPicData.md5)) {
        break label49;
      }
      i1 += 1;
    }
    i1 = -1;
    label49:
    if (i1 >= 0) {
      this.q.remove(i1);
    }
    if ((paramHotPicData instanceof HotPicSendData)) {
      localObject = (HotPicSendData)paramHotPicData;
    } else {
      localObject = HotPicSendData.build(paramHotPicData);
    }
    ((HotPicSendData)localObject).sendTime = NetConnInfoCenter.getServerTime();
    this.q.addFirst(localObject);
    HotPicSendData localHotPicSendData;
    if (this.q.size() > 500) {
      localHotPicSendData = (HotPicSendData)this.q.removeLast();
    } else {
      localHotPicSendData = null;
    }
    HotPicManager.HotPicListener localHotPicListener = this.g;
    if (localHotPicListener != null) {
      localHotPicListener.b(8, -20, 0);
    }
    ThreadManager.post(new HotPicManager.1(this, (HotPicSendData)localObject, localHotPicSendData), 5, null, false);
    Object localObject = this.t;
    if (localObject != null) {
      ((PublicAccountGifListener)localObject).a(paramHotPicData);
    }
  }
  
  public void a(HotPicManager.HotPicListener paramHotPicListener)
  {
    this.g = paramHotPicListener;
  }
  
  public void a(HotPicTagInfo paramHotPicTagInfo)
  {
    int i1 = paramHotPicTagInfo.tagId;
    if ((g()) || (this.s))
    {
      this.s = false;
      if (i1 != -20) {
        a(10001, paramHotPicTagInfo.tagId);
      }
    }
    this.i = i1;
    ThreadManager.post(new HotPicManager.5(this, i1), 5, null, false);
  }
  
  public void a(PublicAccountGifListener paramPublicAccountGifListener)
  {
    this.t = paramPublicAccountGifListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public ArrayList<HotPicTagInfo> b()
  {
    return (ArrayList)this.o;
  }
  
  boolean b(int paramInt)
  {
    Object localObject = this.o;
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
  
  public LinkedList<HotPicSendData> c()
  {
    return this.q;
  }
  
  public boolean c(int paramInt)
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.m.get(paramInt);
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
  
  public void d()
  {
    if (!this.e) {
      return;
    }
    a();
    int i1 = this.i;
    if (i1 != -1)
    {
      if (i1 != -20)
      {
        a(10001, i1);
        return;
      }
      a(10001, 2);
      return;
    }
    if (this.c) {
      a(10001, 2);
    }
  }
  
  public boolean d(int paramInt)
  {
    return this.d.contains(Integer.valueOf(paramInt));
  }
  
  public void e()
  {
    this.d.clear();
    this.k.sendEmptyMessageDelayed(103, 10000L);
  }
  
  public void e(int paramInt)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
      if ((localHotPicTagInfo.tagId == paramInt) && (localHotPicTagInfo.tagType == 2))
      {
        i1 = 10003;
        break label59;
      }
    }
    int i1 = 10002;
    label59:
    a(i1, paramInt);
  }
  
  public void f()
  {
    try
    {
      if (!g())
      {
        if (!this.r)
        {
          d();
          this.r = true;
        }
      }
      else {
        this.s = true;
      }
      this.k.removeMessages(103);
      return;
    }
    finally {}
  }
  
  public void f(int paramInt)
  {
    try
    {
      Object localObject1 = this.a.getApplication();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("sp_hotpic_");
      ((StringBuilder)localObject3).append(this.a.getCurrentUin());
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
        this.e = bool1;
        ((SharedPreferences)localObject1).edit().putBoolean("k_hotlist_s_e", bool1).commit();
        if (bool1) {
          d();
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean g()
  {
    if (this.p.size() > 0) {
      synchronized (this.j)
      {
        this.o.clear();
        this.m.clear();
        Iterator localIterator = this.p.iterator();
        Object localObject1;
        while (localIterator.hasNext())
        {
          localObject1 = (HotPicTagInfo)localIterator.next();
          int i1 = ((HotPicTagInfo)localObject1).tagId;
          this.o.add(localObject1);
          ArrayList localArrayList = (ArrayList)this.n.get(i1);
          SparseArray localSparseArray = this.m;
          localObject1 = localArrayList;
          if (localArrayList == null) {
            localObject1 = new ArrayList();
          }
          localSparseArray.put(i1, localObject1);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("update NewVersionTagInfo");
          ((StringBuilder)localObject1).append(this.p.get(0));
          if (((StringBuilder)localObject1).toString() == null) {
            localObject1 = "null";
          } else {
            localObject1 = Integer.valueOf(((HotPicTagInfo)this.p.get(0)).version);
          }
          QLog.d("HotPicManager", 2, new Object[] { localObject1 });
        }
        this.n.clear();
        this.p.clear();
        this.h = true;
        this.k.sendEmptyMessage(101);
        return true;
      }
    }
    return false;
  }
  
  public int h()
  {
    MobileQQ localMobileQQ = this.a.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_hotpic_");
    localStringBuilder.append(this.a.getCurrentUin());
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt("hot_pic_last_click", -1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 == 101)
    {
      b(b());
      b(k(), true);
      a(l(), true);
      return true;
    }
    if (i1 == 104) {
      b(b());
    } else if ((i1 == 103) && (this.g == null)) {
      paramMessage = k().iterator();
    }
    for (;;)
    {
      Object localObject;
      if (paramMessage.hasNext())
      {
        localObject = (HotPicData)paramMessage.next();
        if (this.g != null) {}
      }
      try
      {
        if (((HotPicData)localObject).getDataType() == 2)
        {
          localObject = HotVideoPreviewDownloader.b((HotVideoData)localObject);
          if (localObject == null) {
            continue;
          }
          URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
          continue;
        }
        URLDrawable.removeMemoryCacheByUrl(HotPicDownLoader.b(((HotPicData)localObject).url).toString());
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager", 2, "clear urldrawable cache");
      }
      return false;
    }
  }
  
  public void i()
  {
    if (this.c)
    {
      this.c = false;
      MobileQQ localMobileQQ = this.a.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_hotpic_");
      localStringBuilder.append(this.a.getCurrentUin());
      localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("k_hotlist_f", false).commit();
    }
  }
  
  public boolean j()
  {
    if ((!this.e) && (!this.f))
    {
      MobileQQ localMobileQQ = this.a.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_hotpic_");
      localStringBuilder.append(this.a.getCurrentUin());
      this.e = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("k_hotlist_s_e", false);
      this.f = true;
    }
    return this.e;
  }
  
  List<HotPicData> k()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i1 = 0;
    while (i1 < this.m.size())
    {
      if (!b(this.m.keyAt(i1)))
      {
        ArrayList localArrayList2 = (ArrayList)this.m.valueAt(i1);
        if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
          localArrayList1.addAll(localArrayList2);
        }
      }
      i1 += 1;
    }
    return localArrayList1;
  }
  
  List<HotVideoData> l()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.o.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HotPicTagInfo)((Iterator)localObject1).next();
      if (((HotPicTagInfo)localObject2).tagType == 2)
      {
        localObject2 = (ArrayList)this.m.get(((HotPicTagInfo)localObject2).tagId);
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
  
  int m()
  {
    synchronized (this.j)
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        int i1 = ((HotPicTagInfo)localIterator.next()).version;
        if (i1 != 0) {
          return i1;
        }
      }
      return 0;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.l;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager
 * JD-Core Version:    0.7.0.1
 */