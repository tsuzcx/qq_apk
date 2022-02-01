package dov.com.qq.im.ae.download.old;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class AEOldResManager
  implements AEOldShortVideoResManager.INet_ShortVideoResource, AEOldShortVideoResStatus.ISVConfig, AEOldShortVideoResStatus.ISVConfig_V2
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AEOldResManagerHandlerThread", 0);
  private List<AEOldShortVideoResManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<AEOldResInfo, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<AEOldResInfo> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private List<AEOldResManager.AEOldDownloadCallBack> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<AEOldResInfo, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private AEOldResManager()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static AEOldResManager a()
  {
    return AEOldResManager.InstanceHolder.a;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 0) {
      return "DOWNLOAD_STATUS_IDLE";
    }
    if (paramInt == 1) {
      return "DOWNLOAD_STATUS_WAIT";
    }
    if (paramInt == 2) {
      return "DOWNLOAD_STATUS_PREDOWNLOAD_WAIT";
    }
    if (paramInt == 3) {
      return "DOWNLOAD_STATUS_DOWNLOADING";
    }
    if (paramInt == 4) {
      return "DOWNLOAD_STATUS_READY";
    }
    return "DOWNLOAD_STATUS_UNKNOWN";
  }
  
  private void a(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldResManager.AEOldDownloadCallBack paramAEOldDownloadCallBack)
  {
    AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal] - BEGIN -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEOldResInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEOldResInfo, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEOldResInfo)).intValue();
    AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal], status=" + a(i));
    if (i == 4)
    {
      i = AEOldResUtil.a(paramAEOldResInfo.jdField_a_of_type_Int);
      if (i == 0) {
        break label565;
      }
    }
    label565:
    for (String str = AEOldResUtil.a(paramAEOldResInfo.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (paramAEOldDownloadCallBack != null) {
        paramAEOldDownloadCallBack.a(paramAEOldResInfo, str, true, 0);
      }
      AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        a(paramAEOldDownloadCallBack);
        AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
        return;
      }
      if (!NetworkUtil.g(null))
      {
        if (paramAEOldDownloadCallBack != null) {
          paramAEOldDownloadCallBack.a(paramAEOldResInfo, null, false, -6);
        }
        AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
        return;
      }
      AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int + ", networkStatus=USABLE");
      a(paramAEOldDownloadCallBack);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEOldResInfo))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(paramAEOldResInfo);
        this.jdField_a_of_type_JavaUtilMap.put(paramAEOldResInfo, Integer.valueOf(1));
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo))
      {
        this.jdField_a_of_type_JavaUtilMap.put(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo, Integer.valueOf(3));
        AEOldShortVideoResDownload.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        AEQLog.b("AEOldResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
        return;
        if ((this.jdField_a_of_type_JavaUtilMap.get(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo)).intValue() == 4)) {
          b(1, 0);
        }
      }
    }
  }
  
  private void a(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldResManager.AEOldDownloadCallBack paramAEOldDownloadCallBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    AEQLog.b("AEOldResManager", "[requestDownloadInternal] - BEGIN -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEOldResInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEOldResInfo, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEOldResInfo)).intValue();
    AEQLog.b("AEOldResManager", "[requestDownloadInternal], status=" + a(i));
    if (i == 4)
    {
      i = AEOldResUtil.a(paramAEOldResInfo.jdField_a_of_type_Int);
      if (i == 0) {
        break label682;
      }
    }
    label682:
    for (String str = AEOldResUtil.a(paramAEOldResInfo.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (paramAEOldDownloadCallBack != null) {
        paramAEOldDownloadCallBack.a(paramAEOldResInfo, str, true, 0);
      }
      AEOldResUtil.a(paramAEOldResInfo, str);
      AEQLog.b("AEOldResManager", "[requestDownloadInternal], packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      AEQLog.b("AEOldResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        a(paramAEOldDownloadCallBack);
        AEQLog.b("AEOldResManager", "[requestDownloadInternal], packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        AEQLog.b("AEOldResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
        return;
      }
      if ((NetworkUtil.g(null)) && ((!paramBoolean1) || (NetworkUtil.h(null)))) {}
      for (i = 1; i == 0; i = 0)
      {
        if (paramAEOldDownloadCallBack != null) {
          paramAEOldDownloadCallBack.a(paramAEOldResInfo, null, false, -6);
        }
        AEQLog.d("AEOldResManager", "[requestDownloadInternal], packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        AEQLog.b("AEOldResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
        return;
      }
      AEQLog.b("AEOldResManager", "[requestDownloadInternal], packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int + ", networkStatus=USABLE");
      a(paramAEOldDownloadCallBack);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEOldResInfo))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(paramAEOldResInfo);
        this.jdField_a_of_type_JavaUtilMap.put(paramAEOldResInfo, Integer.valueOf(1));
      }
      if ((paramAEOldResInfo.jdField_b_of_type_Boolean) && (paramBoolean2))
      {
        paramBoolean1 = true;
        paramAEOldResInfo.jdField_b_of_type_Boolean = paramBoolean1;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo)) {
          break label609;
        }
        AEQLog.b("AEOldResManager", "[requestDownloadInternal] 强制拉取配置列表" + paramAEOldResInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilMap.put(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo, Integer.valueOf(3));
        AEOldShortVideoResManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        AEQLog.b("AEOldResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEOldResInfo.jdField_a_of_type_Int);
        return;
        paramBoolean1 = false;
        break;
        label609:
        if ((this.jdField_a_of_type_JavaUtilMap.get(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo)).intValue() == 4))
        {
          AEQLog.b("AEOldResManager", "[requestDownloadInternal] 配置列表已经存在, packageIndex = " + paramAEOldResInfo.jdField_a_of_type_Int);
          a(1, 0);
        }
      }
    }
  }
  
  private void a(@Nullable AEOldResManager.AEOldDownloadCallBack paramAEOldDownloadCallBack)
  {
    if (paramAEOldDownloadCallBack == null) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.contains(paramAEOldDownloadCallBack))) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramAEOldDownloadCallBack);
  }
  
  private void a(@NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEOldResInfo paramAEOldResInfo)
  {
    AEQLog.b("AEOldResManager", "[cancelPreDownLoad] - BEGIN -, aeResInfo=" + paramAEOldResInfo);
    paramQQAppInterface = (PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (AEOldShortVideoResManager.SVConfigItem)localIterator.next();
      if (paramList.name.startsWith(paramAEOldResInfo.jdField_b_of_type_JavaLangString)) {
        AEQLog.b("AEOldResManager", "[cancelPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isEnable()) && (paramList != null))
      {
        if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!paramList.check64BitReady())) {
          break label178;
        }
        paramQQAppInterface.cancelPreDownload(paramList.arm64v8a_url);
      }
      for (;;)
      {
        AEQLog.b("AEOldResManager", "[cancelPreDownLoad], preDownloadController.isEnable() == " + paramQQAppInterface.isEnable());
        AEQLog.b("AEOldResManager", "[cancelPreDownLoad] - END -, aeResInfo=" + paramAEOldResInfo);
        return;
        label178:
        paramQQAppInterface.cancelPreDownload(paramList.armv7a_url);
      }
      paramList = null;
    }
  }
  
  private void a(@NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    AEQLog.b("AEOldResManager", "[startDownLoad] + BEGIN");
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilQueue))
    {
      AEQLog.d("AEOldResManager", "[startDownLoad], mDownLoadTaskQueue is empty");
      AEQLog.b("AEOldResManager", "[startDownLoad] - END -");
      return;
    }
    AEOldResInfo localAEOldResInfo = (AEOldResInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localAEOldResInfo == null)
    {
      AEQLog.d("AEOldResManager", "[startDownLoad], mDownLoadTaskQueue top element is null");
      AEQLog.b("AEOldResManager", "[startDownLoad] + END");
      return;
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localAEOldResInfo))
    {
      i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localAEOldResInfo)).intValue();
      AEQLog.a("AEOldResManager", "[startDownLoad], resNeedDownload=" + localAEOldResInfo);
      AEQLog.a("AEOldResManager", "[startDownLoad], status=" + a(i));
      if ((!paramBoolean) && (localAEOldResInfo.jdField_b_of_type_Boolean)) {
        break label275;
      }
      AEQLog.b("AEOldResManager", "[startDownLoad], isDownLoadImmediately=true");
      if (i != 3)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localAEOldResInfo, Integer.valueOf(3));
        if (i == 2) {
          a(paramList, paramQQAppInterface, localAEOldResInfo);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localAEOldResInfo, Long.valueOf(System.currentTimeMillis()));
        AEQLog.b("AEOldResManager", "[startDownLoad], realDownloadResource()");
        AEOldResDownload.a(localAEOldResInfo, paramList, this);
      }
    }
    for (;;)
    {
      AEQLog.b("AEOldResManager", "[startDownLoad] + END");
      return;
      AEQLog.d("AEOldResManager", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
      AEQLog.b("AEOldResManager", "[startDownLoad] + END");
      return;
      label275:
      AEQLog.b("AEOldResManager", "[startDownLoad], isDownLoadImmediately=false");
      if ((i == 3) || (i == 2)) {
        break;
      }
      if (!a(paramList, this, paramQQAppInterface, localAEOldResInfo))
      {
        a(paramList, paramQQAppInterface, localAEOldResInfo);
        localAEOldResInfo.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_JavaUtilMap.put(localAEOldResInfo, Long.valueOf(System.currentTimeMillis()));
        AEQLog.b("AEOldResManager", "[startDownLoad], realDownloadResource()");
        this.jdField_a_of_type_JavaUtilMap.put(localAEOldResInfo, Integer.valueOf(3));
        AEOldResDownload.a(localAEOldResInfo, paramList, this);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(localAEOldResInfo, Integer.valueOf(2));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    AEQLog.b("AEOldResManager", "[onConfigResultInternal] ++++++ BEGIN");
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 内存中'还没有'列表信息，开始生成配置列表");
      i = AEOldShortVideoResManager.a(null, this.jdField_a_of_type_JavaUtilList);
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 生成配置列表结果 errCode = " + i);
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 内存中'当前的'配置列表信息，size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (i != 0) {
        break label393;
      }
      i = AEOldResUtil.a(this.jdField_a_of_type_JavaUtilList);
    }
    label393:
    for (;;)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (i == 0)
      {
        this.jdField_a_of_type_JavaUtilMap.put(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo, Integer.valueOf(4));
        AEQLog.b("AEOldResManager", "[onConfigResultInternal] 配置列表拉取成功，开始进行ZIP包下载");
        localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a((List)localObject2, (QQAppInterface)localObject1, paramBoolean);
          AEQLog.b("AEOldResManager", "[onConfigResultInternal] ++++++ END");
          return;
          AEQLog.b("AEOldResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，执行检查刷新列表");
          localObject1 = new LinkedList();
          int j = AEOldShortVideoResManager.a(null, (List)localObject1);
          AEQLog.b("AEOldResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，刷新后列表为 = " + localObject1);
          i = j;
          if (j != 0) {
            break;
          }
          i = j;
          if (((List)localObject1).size() <= 0) {
            break;
          }
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
          i = j;
          break;
        }
      }
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 配置列表拉取失败，尝试构造内置列表进行下载");
      Object localObject2 = AEOldLocalConfig.jdField_a_of_type_JavaUtilList;
      if (((List)localObject2).size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
      }
      this.jdField_a_of_type_JavaUtilMap.put(AEOldResInfo.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo, Integer.valueOf(4));
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 构造内置列表成功，开始下载");
      localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        a((List)localObject2, (QQAppInterface)localObject1, paramBoolean);
        break;
      }
    }
  }
  
  private boolean a(@NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEOldResInfo paramAEOldResInfo)
  {
    AEQLog.b("AEOldResManager", "[startPreDownLoad] - BEGIN -, aeResInfo=" + paramAEOldResInfo);
    PreDownloadController localPreDownloadController = (PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
    Iterator localIterator = paramList.iterator();
    AEOldShortVideoResManager.SVConfigItem localSVConfigItem;
    while (localIterator.hasNext())
    {
      localSVConfigItem = (AEOldShortVideoResManager.SVConfigItem)localIterator.next();
      if (localSVConfigItem.name.startsWith(paramAEOldResInfo.jdField_b_of_type_JavaLangString)) {
        AEQLog.b("AEOldResManager", "[startPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((localPreDownloadController != null) && (localPreDownloadController.isEnable()))
      {
        paramINet_ShortVideoResource = new AEOldResManager.9(this, paramQQAppInterface, "ae_camera_res", new AEOldResManager.8(this, paramAEOldResInfo, paramList, paramINet_ShortVideoResource), 4000L);
        if (localSVConfigItem != null)
        {
          if ((VideoEnvironment64BitUtils.checkIs64bit()) && (localSVConfigItem.check64BitReady())) {}
          for (paramList = localSVConfigItem.arm64v8a_url;; paramList = localSVConfigItem.armv7a_url)
          {
            boolean bool = localPreDownloadController.requestPreDownload(10091, null, localSVConfigItem.name, 0, paramList, AEOldResUtil.a(localSVConfigItem.name), 4, 0, true, paramINet_ShortVideoResource);
            AEQLog.b("AEOldResManager", "[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=" + bool);
            AEQLog.b("AEOldResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramAEOldResInfo);
            return bool;
          }
        }
        AEQLog.b("AEOldResManager", "[startPreDownLoad], chosenConfigItem == nul");
        AEQLog.b("AEOldResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramAEOldResInfo);
        return false;
      }
      AEQLog.b("AEOldResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
      AEQLog.b("AEOldResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramAEOldResInfo);
      return false;
      localSVConfigItem = null;
    }
  }
  
  private void b(String paramString1, int paramInt, String paramString2)
  {
    AEQLog.b("AEOldResManager", "[onDownloadFinishInternal] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    Object localObject1 = paramString1;
    if (paramString1 == null) {
      localObject1 = "";
    }
    int i;
    Object localObject2;
    int k;
    int j;
    if ((paramInt == 0) || (paramInt == 1))
    {
      i = 0;
      localObject2 = AEOldResInfo.jdField_b_of_type_ArrayOfDovComQqImAeDownloadOldAEOldResInfo;
      k = localObject2.length;
      j = 0;
    }
    for (;;)
    {
      if (j < k)
      {
        paramString1 = localObject2[j];
        if (((String)localObject1).startsWith(paramString1.jdField_b_of_type_JavaLangString))
        {
          AEQLog.b("AEOldResManager", "[onDownloadFinishInternal], matched aeResInfo=" + paramString1);
          if (i == 0)
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(4));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            AEOldResUtil.a(paramString1, paramString2);
            j = Integer.valueOf(((String)localObject1).substring(paramString1.jdField_b_of_type_JavaLangString.length())).intValue();
            AEOldResUtil.a(paramString1.jdField_a_of_type_Int, j);
            label197:
            localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
            label208:
            if (!((Iterator)localObject1).hasNext()) {
              break label295;
            }
            localObject2 = (AEOldResManager.AEOldDownloadCallBack)((Iterator)localObject1).next();
            if (i != 0) {
              break label289;
            }
          }
          label289:
          for (boolean bool = true;; bool = false)
          {
            ((AEOldResManager.AEOldDownloadCallBack)localObject2).a(paramString1, paramString2, bool, i);
            break label208;
            i = paramInt;
            break;
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(0));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            break label197;
          }
          label295:
          if ((paramInt != 1) && (this.jdField_b_of_type_JavaUtilMap.get(paramString1) != null))
          {
            System.currentTimeMillis();
            ((Long)this.jdField_b_of_type_JavaUtilMap.get(paramString1)).longValue();
          }
          AEQLog.b("AEOldResManager", "[onDownloadFinishInternal], start download next package");
          paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          a(new LinkedList(this.jdField_a_of_type_JavaUtilList), paramString1, true);
        }
      }
      else
      {
        AEQLog.b("AEOldResManager", "[onDownloadFinishInternal] - END -");
        return;
      }
      j += 1;
    }
  }
  
  private void b(String paramString, long paramLong1, long paramLong2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = AEOldResInfo.jdField_b_of_type_ArrayOfDovComQqImAeDownloadOldAEOldResInfo;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (str.startsWith(localObject.jdField_b_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(3));
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((AEOldResManager.AEOldDownloadCallBack)localIterator.next()).a(localObject, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  public void a()
  {
    AEQLog.d("AEOldResManager", HardCodeUtil.a(2131700084));
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AEQLog.b("AEOldResManager", "[onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.4(this));
    AEQLog.b("AEOldResManager", "[onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void a(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldResManager.AEOldDownloadCallBack paramAEOldDownloadCallBack, boolean paramBoolean)
  {
    AEQLog.b("AEOldResManager", "[requestDownload] - BEGIN -, aeResInfo=" + paramAEOldResInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.1(this, paramAEOldResInfo, paramAEOldDownloadCallBack, paramBoolean));
    AEQLog.b("AEOldResManager", "[requestDownload] - END -, aeResInfo=" + paramAEOldResInfo);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    AEQLog.b("AEOldResManager", "[onDownloadFinish] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.6(this, paramString1, paramInt, paramString2));
    AEQLog.b("AEOldResManager", "[onDownloadFinish] - END -");
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.7(this, paramString, paramLong1, paramLong2));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AEQLog.b("AEOldResManager", "[onConfigResultWithoutLogin] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.5(this));
    AEQLog.b("AEOldResManager", "[onConfigResultWithoutLogin] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void b(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldResManager.AEOldDownloadCallBack paramAEOldDownloadCallBack, boolean paramBoolean)
  {
    AEQLog.b("AEOldResManager", "[requestDownload] - BEGIN -, AEOldResInfo=" + paramAEOldResInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.3(this, paramAEOldResInfo, paramAEOldDownloadCallBack, paramBoolean));
    AEQLog.b("AEOldResManager", "[requestDownload] - END -, AEOldResInfo=" + paramAEOldResInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldResManager
 * JD-Core Version:    0.7.0.1
 */