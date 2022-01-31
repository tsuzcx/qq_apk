package com.tencent.mobileqq.emosm.favroaming;

import absr;
import abss;
import abst;
import absu;
import absv;
import absx;
import absz;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DiyDoutuHelper;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamPicInfo;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionExpRoamTryUp;

public class FavroamingManager
  implements Manager
{
  private static int jdField_a_of_type_Int;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static int jdField_b_of_type_Int;
  private static AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private FavEmoRoamingObserver jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver = new absv(this);
  public QQAppInterface a;
  public EmoticonPackageDownloadListener a;
  private EmotionJsonDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener = new absu(this);
  public TransFileController a;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new absx(this, ThreadManager.getSubThreadLooper());
  String jdField_a_of_type_JavaLangString;
  public Map a;
  public CopyOnWriteArrayList a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  
  public FavroamingManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new abst(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.a();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      int i = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("fav_roaming_max" + this.jdField_a_of_type_JavaLangString, 144);
      if (i > 144) {
        FavEmoConstant.jdField_a_of_type_Int = i;
      }
    }
  }
  
  public static boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "downloadCount:" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", needDownloadCount" + jdField_a_of_type_Int + "uploadCount:" + jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", needUploadCount" + jdField_b_of_type_Int);
    }
    return (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == jdField_a_of_type_Int) && (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == jdField_b_of_type_Int);
  }
  
  private void e()
  {
    if (b())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "------------end syncRoaming----------");
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
        {
          SyncListener localSyncListener = (SyncListener)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
          if (localSyncListener != null) {
            localSyncListener.b();
          }
        }
        i += 1;
      }
    }
  }
  
  private void f()
  {
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    jdField_b_of_type_Int = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
      {
        SyncListener localSyncListener = (SyncListener)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
        if (localSyncListener != null) {
          localSyncListener.a();
        }
      }
      i += 1;
    }
    e();
  }
  
  private void g()
  {
    int j = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    jdField_a_of_type_Int = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
      {
        SyncListener localSyncListener = (SyncListener)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
        if (localSyncListener != null) {
          localSyncListener.a(j);
        }
      }
      i += 1;
    }
    e();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    FavEmoRoamingHandler localFavEmoRoamingHandler;
    do
    {
      return;
      localFavEmoRoamingHandler = (FavEmoRoamingHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
    } while (localFavEmoRoamingHandler == null);
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "------------start syncRoaming----------");
    }
    localFavEmoRoamingHandler.b();
  }
  
  public void a(CustomEmotionData paramCustomEmotionData)
  {
    a(paramCustomEmotionData, null);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, UpCallBack paramUpCallBack)
  {
    b(paramCustomEmotionData, paramUpCallBack);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    int j = 1;
    int i = 1;
    if ((paramCustomEmotionData == null) || (paramTransferRequest == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "uploadNoMarkFace " + paramCustomEmotionData);
    }
    cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
    cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
    Object localObject = FunnyPicHelper.a(paramCustomEmotionData.emoPath);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("qto_")))
    {
      localObject = ((String)localObject).replace("qto_", "qto@");
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "upload FunnyPic name.replace->" + (String)localObject);
      }
      j = FunnyPicHelper.a(paramCustomEmotionData.eId);
      if (j != 0) {
        break label347;
      }
    }
    for (;;)
    {
      localExpRoamPicInfo.uint32_pkg_id.set(i);
      for (;;)
      {
        localExpRoamPicInfo.uint32_shop_flag.set(0);
        localObject = new ArrayList();
        ((List)localObject).add(localExpRoamPicInfo);
        localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set((List)localObject);
        paramTransferRequest.jdField_a_of_type_ArrayOfByte = localExtensionExpRoamTryUp.toByteArray();
        paramTransferRequest.jdField_a_of_type_Long = paramCustomEmotionData.emoId;
        paramTransferRequest.i = paramCustomEmotionData.emoPath;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(paramTransferRequest);
        return;
        localObject = DiyDoutuHelper.a(paramCustomEmotionData.emoPath);
        if (!((String)localObject).equals("")) {
          localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
        }
        try
        {
          i = Integer.parseInt(paramCustomEmotionData.eId);
          localExpRoamPicInfo.uint32_pkg_id.set(i);
          continue;
          localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom("0".getBytes()));
          localExpRoamPicInfo.uint32_pkg_id.set(0);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            i = j;
          }
        }
      }
      label347:
      i = j;
    }
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    if ((paramCustomEmotionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int i;
    label203:
    label226:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + ",isSuccess = " + paramBoolean + " , roamingType: " + paramCustomEmotionData.RomaingType);
      }
      Object localObject = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(148);
      if ((localObject != null) && (paramBoolean))
      {
        if (!"needDownload".equals(paramCustomEmotionData.RomaingType)) {
          break label203;
        }
        paramCustomEmotionData.RomaingType = "isUpdate";
        if ("needDel".equals(paramCustomEmotionData.RomaingType)) {
          break label226;
        }
        ((FavroamingDBManager)localObject).b(paramCustomEmotionData);
      }
      for (;;)
      {
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
          {
            localObject = (SyncListener)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
            if (localObject != null) {
              ((SyncListener)localObject).a(paramCustomEmotionData, jdField_a_of_type_Int, jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
            }
          }
          i += 1;
        }
        if (!"overflow".equals(paramCustomEmotionData.RomaingType)) {
          break;
        }
        paramCustomEmotionData.RomaingType = "overflow_downloaded";
        break;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + " has been deleted");
        }
      }
      i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "market face : downloadCount: " + i + ",needDownloadCount: " + jdField_a_of_type_Int);
      }
    } while (i < jdField_a_of_type_Int);
    g();
  }
  
  public void a(SyncListener paramSyncListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramSyncListener) {
        return;
      }
    }
    paramSyncListener = new WeakReference(paramSyncListener);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramSyncListener);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
    ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(paramString, EmojiManager.jdField_b_of_type_Int, null, false);
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {
      c(paramList);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    FavEmoRoamingHandler localFavEmoRoamingHandler;
    do
    {
      return;
      localFavEmoRoamingHandler = (FavEmoRoamingHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
    } while (localFavEmoRoamingHandler == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    ThreadManager.post(new absr(this, localFavEmoRoamingHandler), 5, null, true);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData, UpCallBack paramUpCallBack)
  {
    if (paramCustomEmotionData == null) {}
    while (!NetworkUtil.d(BaseApplication.getContext())) {
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BDHCommonUploadProcessor.class });
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_Boolean = true;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_Int = 24;
    localTransferRequest.jdField_c_of_type_Int = 9;
    localTransferRequest.jdField_a_of_type_JavaLangString = "scbqmanyou";
    localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    if (paramUpCallBack != null) {
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = paramUpCallBack;
    }
    if (paramCustomEmotionData.isMarkFace)
    {
      b(paramCustomEmotionData, localTransferRequest);
      return;
    }
    a(paramCustomEmotionData, localTransferRequest);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    if ((paramCustomEmotionData == null) || (paramTransferRequest == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "uploadMarkFace favEmoticon.epid=" + paramCustomEmotionData.emoPath + " and eid=" + paramCustomEmotionData.eId);
    }
    cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
    cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
    localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(paramCustomEmotionData.eId.getBytes()));
    localExpRoamPicInfo.uint32_pkg_id.set(Integer.parseInt(paramCustomEmotionData.emoPath));
    localExpRoamPicInfo.uint32_shop_flag.set(1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localExpRoamPicInfo);
    localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set(localArrayList);
    paramTransferRequest.jdField_a_of_type_ArrayOfByte = localExtensionExpRoamTryUp.toByteArray();
    paramTransferRequest.jdField_a_of_type_Long = paramCustomEmotionData.getId();
    paramCustomEmotionData = EmojiManager.a(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId, false);
    paramTransferRequest.i = paramCustomEmotionData[1];
    ThreadManager.post(new absz(this, paramCustomEmotionData, paramTransferRequest), 5, null, true);
  }
  
  public void b(SyncListener paramSyncListener)
  {
    if (paramSyncListener == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (localWeakReference.get() != paramSyncListener);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        Object localObject;
        try
        {
          this.jdField_a_of_type_JavaUtilMap.clear();
          i = 0;
          if (i < paramList.size())
          {
            localObject = (CustomEmotionData)paramList.get(i);
            if (localObject == null) {
              break label218;
            }
            if (this.jdField_a_of_type_JavaUtilMap.containsKey(((CustomEmotionData)localObject).emoPath))
            {
              ((ArrayList)this.jdField_a_of_type_JavaUtilMap.get(((CustomEmotionData)localObject).emoPath)).add(localObject);
            }
            else
            {
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localObject);
              this.jdField_a_of_type_JavaUtilMap.put(((CustomEmotionData)localObject).emoPath, localArrayList);
            }
          }
        }
        finally {}
        try
        {
          paramList = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (paramList.hasNext())
          {
            localObject = (Map.Entry)paramList.next();
            if (localObject != null) {
              a((String)((Map.Entry)localObject).getKey());
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception paramList) {}
      }
      QLog.d("FavroamingManager", 2, "downmap exception=" + paramList.toString());
      break;
      label218:
      i += 1;
    }
  }
  
  public void c()
  {
    int i = 0;
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Object localObject1 = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(148);
    Object localObject4 = ((FavroamingDBManager)localObject1).b("needDownload");
    Object localObject3 = ((FavroamingDBManager)localObject1).b("overflow");
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localObject4 != null)
    {
      localObject1 = localObject2;
      if (((List)localObject4).size() > 0)
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll((Collection)localObject4);
      }
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      ((List)localObject2).addAll((Collection)localObject3);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        if (i >= ((List)localObject1).size()) {
          break label238;
        }
        localObject4 = (CustomEmotionData)((List)localObject1).get(i);
        if (!((CustomEmotionData)localObject4).isMarkFace) {
          break label226;
        }
        ((List)localObject3).add(localObject4);
      }
      for (;;)
      {
        i += 1;
        break;
        e();
        return;
        label226:
        ((List)localObject2).add(localObject4);
      }
      label238:
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      jdField_a_of_type_Int = ((List)localObject3).size();
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "needDownload: " + jdField_a_of_type_Int + ", markFace size: " + ((List)localObject3).size() + ", noMarkFace size:" + ((List)localObject2).size());
      }
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingManager", 2, "now sync start download noMarkFace! " + TextUtils.join(",", (Iterable)localObject2));
      }
      new Handler(Looper.getMainLooper()).post(new abss(this));
      b((List)localObject3);
      return;
    }
  }
  
  public void c(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (!NetworkUtil.d(BaseApplication.getContext()))) {
      return;
    }
    List localList = paramList;
    if (paramList.size() > FavEmoConstant.jdField_a_of_type_Int)
    {
      i = paramList.size() - FavEmoConstant.jdField_a_of_type_Int;
      localList = paramList.subList(i, FavEmoConstant.jdField_a_of_type_Int + i);
    }
    int k = localList.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      paramList = (CustomEmotionData)localList.get(j);
      if (("needDownload".equals(paramList.RomaingType)) || ("needDel".equals(paramList.RomaingType))) {
        break label158;
      }
      if (!"isUpdate".equals(paramList.RomaingType)) {}
    }
    label158:
    for (;;)
    {
      j += 1;
      break;
      b(paramList, null);
      i += 1;
      continue;
      jdField_b_of_type_Int = i;
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager
 * JD-Core Version:    0.7.0.1
 */