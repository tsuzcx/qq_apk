package dov.com.qq.im.ae.download;

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
import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig_V2;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.download.old.AEOldResInfo;
import dov.com.qq.im.ae.download.old.AEOldResManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
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

public class AEResManager
  implements ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig_V2
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AEResManagerHandlerThread", 0);
  private List<ShortVideoResourceManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<AEResInfo, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<AEResInfo> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private List<AEResManager.AEDownloadCallBack> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<AEResInfo, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private AEResManager()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static AEResManager a()
  {
    return AEResManager.InstanceHolder.a;
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
  
  private void a(@NonNull AEResInfo paramAEResInfo, @Nullable AEResManager.AEDownloadCallBack paramAEDownloadCallBack)
  {
    AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal] - BEGIN -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEResInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEResInfo)).intValue();
    AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal], status=" + a(i));
    if (i == 4)
    {
      i = AEResUtil.a(paramAEResInfo.jdField_a_of_type_Int);
      if (i == 0) {
        break label565;
      }
    }
    label565:
    for (String str = AEResUtil.a(paramAEResInfo.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (paramAEDownloadCallBack != null) {
        paramAEDownloadCallBack.onAEDownloadFinish(paramAEResInfo, str, true, 0);
      }
      AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEResInfo.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        b(paramAEDownloadCallBack);
        AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEResInfo.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
        return;
      }
      if (!NetworkUtil.g(null))
      {
        if (paramAEDownloadCallBack != null) {
          paramAEDownloadCallBack.onAEDownloadFinish(paramAEResInfo, null, false, -6);
        }
        AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEResInfo.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
        return;
      }
      AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEResInfo.jdField_a_of_type_Int + ", networkStatus=USABLE");
      b(paramAEDownloadCallBack);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEResInfo))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(paramAEResInfo);
        this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(1));
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo))
      {
        this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, Integer.valueOf(3));
        ShortVideoResDownload.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        AEQLog.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
        return;
        if ((this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo)).intValue() == 4)) {
          a(1, 0);
        }
      }
    }
  }
  
  private void a(@NonNull AEResInfo paramAEResInfo, @Nullable AEResManager.AEDownloadCallBack paramAEDownloadCallBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    AEQLog.b("AEResManager", "[requestDownloadInternal] - BEGIN -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEResInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(0));
    }
    int j = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEResInfo)).intValue();
    AEQLog.b("AEResManager", "[requestDownloadInternal], status=" + a(j));
    int i;
    if ((j == 4) && (AEResUtil.b(paramAEResInfo)))
    {
      i = AEResUtil.a(paramAEResInfo.jdField_a_of_type_Int);
      if (i == 0) {
        break label736;
      }
    }
    label662:
    label736:
    for (String str = AEResUtil.a(paramAEResInfo.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (paramAEDownloadCallBack != null) {
        paramAEDownloadCallBack.onAEDownloadFinish(paramAEResInfo, str, true, 0);
      }
      AEResUtil.a(paramAEResInfo, str);
      AEQLog.b("AEResManager", "[requestDownloadInternal], packageIndex=" + paramAEResInfo.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      AEQLog.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
      return;
      i = j;
      if (j == 4)
      {
        i = j;
        if (!AEResUtil.b(paramAEResInfo))
        {
          AEQLog.b("AEResManager", "[requestDownloadInternal], 重置内存中的文件状态为IDLE");
          this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(0));
          i = 0;
        }
      }
      if (i == 3)
      {
        b(paramAEDownloadCallBack);
        AEQLog.b("AEResManager", "[requestDownloadInternal], packageIndex=" + paramAEResInfo.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        AEQLog.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
        return;
      }
      if ((NetworkUtil.g(null)) && ((!paramBoolean1) || (NetworkUtil.h(null)))) {}
      for (i = 1; i == 0; i = 0)
      {
        if (paramAEDownloadCallBack != null) {
          paramAEDownloadCallBack.onAEDownloadFinish(paramAEResInfo, null, false, -6);
        }
        AEQLog.d("AEResManager", "[requestDownloadInternal], packageIndex=" + paramAEResInfo.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        AEQLog.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
        return;
      }
      AEQLog.b("AEResManager", "[requestDownloadInternal], packageIndex=" + paramAEResInfo.jdField_a_of_type_Int + ", networkStatus=USABLE");
      b(paramAEDownloadCallBack);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEResInfo))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(paramAEResInfo);
        this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(1));
      }
      if ((paramAEResInfo.jdField_b_of_type_Boolean) && (paramBoolean2))
      {
        paramBoolean1 = true;
        paramAEResInfo.jdField_b_of_type_Boolean = paramBoolean1;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo)) {
          break label662;
        }
        AEQLog.b("AEResManager", "[requestDownloadInternal] 强制拉取配置列表" + paramAEResInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, Integer.valueOf(3));
        ShortVideoResourceManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        AEQLog.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEResInfo.jdField_a_of_type_Int);
        return;
        paramBoolean1 = false;
        break;
        if ((this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo)).intValue() == 4))
        {
          AEQLog.b("AEResManager", "[requestDownloadInternal] 配置列表已经存在, packageIndex = " + paramAEResInfo.jdField_a_of_type_Int);
          onConfigResult(1, 0);
        }
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    AEQLog.b("AEResManager", "[onDownloadFinishInternal] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
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
      localObject2 = AEResInfo.jdField_b_of_type_ArrayOfDovComQqImAeDownloadAEResInfo;
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
          AEQLog.b("AEResManager", "[onDownloadFinishInternal], matched aeResInfo=" + paramString1);
          if (i == 0)
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(4));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            AEResUtil.a(paramString1, paramString2);
            j = Integer.valueOf(((String)localObject1).substring(paramString1.jdField_b_of_type_JavaLangString.length())).intValue();
            AEResUtil.a(paramString1.jdField_a_of_type_Int, j);
            label200:
            localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
            label211:
            if (!((Iterator)localObject1).hasNext()) {
              break label298;
            }
            localObject2 = (AEResManager.AEDownloadCallBack)((Iterator)localObject1).next();
            if (i != 0) {
              break label292;
            }
          }
          label292:
          for (boolean bool1 = true;; bool1 = false)
          {
            ((AEResManager.AEDownloadCallBack)localObject2).onAEDownloadFinish(paramString1, paramString2, bool1, i);
            break label211;
            i = paramInt;
            break;
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(0));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            break label200;
          }
          label298:
          if (paramInt != 1)
          {
            long l = -1L;
            if (this.jdField_b_of_type_JavaUtilMap.get(paramString1) != null) {
              l = System.currentTimeMillis() - ((Long)this.jdField_b_of_type_JavaUtilMap.get(paramString1)).longValue();
            }
            paramString2 = AEBaseDataReporter.a();
            bool1 = bool2;
            if (paramInt == 0) {
              bool1 = true;
            }
            paramString2.a(bool1, paramString1.jdField_a_of_type_Int, "", "", paramInt, l);
          }
          AEQLog.b("AEResManager", "[onDownloadFinishInternal], start download next package");
          paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          a(new LinkedList(this.jdField_a_of_type_JavaUtilList), paramString1, true);
        }
      }
      else
      {
        AEQLog.b("AEResManager", "[onDownloadFinishInternal] - END -");
        return;
      }
      j += 1;
    }
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = AEResInfo.jdField_b_of_type_ArrayOfDovComQqImAeDownloadAEResInfo;
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
          ((AEResManager.AEDownloadCallBack)localIterator.next()).onAEProgressUpdate(localObject, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEResInfo paramAEResInfo)
  {
    AEQLog.b("AEResManager", "[cancelPreDownLoad] - BEGIN -, aeResInfo=" + paramAEResInfo);
    paramQQAppInterface = (PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (paramList.name.startsWith(paramAEResInfo.jdField_b_of_type_JavaLangString)) {
        AEQLog.b("AEResManager", "[cancelPreDownLoad], chosenConfigItem matched");
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
        AEQLog.b("AEResManager", "[cancelPreDownLoad], preDownloadController.isEnable() == " + paramQQAppInterface.isEnable());
        AEQLog.b("AEResManager", "[cancelPreDownLoad] - END -, aeResInfo=" + paramAEResInfo);
        return;
        label178:
        paramQQAppInterface.cancelPreDownload(paramList.armv7a_url);
      }
      paramList = null;
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    AEQLog.b("AEResManager_download", "[startDownLoad] + BEGIN");
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilQueue))
    {
      AEQLog.d("AEResManager_download", "[startDownLoad], mDownLoadTaskQueue is empty");
      AEQLog.b("AEResManager_download", "[startDownLoad] - END -");
      return;
    }
    AEResInfo localAEResInfo = (AEResInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localAEResInfo == null)
    {
      AEQLog.d("AEResManager_download", "[startDownLoad], mDownLoadTaskQueue top element is null");
      AEQLog.b("AEResManager_download", "[startDownLoad] + END");
      return;
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localAEResInfo))
    {
      i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localAEResInfo)).intValue();
      AEQLog.a("AEResManager_download", "[startDownLoad], resNeedDownload=" + localAEResInfo);
      AEQLog.a("AEResManager_download", "[startDownLoad], status=" + a(i));
      if ((!paramBoolean) && (localAEResInfo.jdField_b_of_type_Boolean)) {
        break label284;
      }
      AEQLog.b("AEResManager", "[startDownLoad], isDownLoadImmediately=true");
      if (i != 3)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(3));
        if (i == 2) {
          a(paramList, paramQQAppInterface, localAEResInfo);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localAEResInfo, Long.valueOf(System.currentTimeMillis()));
        AEQLog.b("AEResManager", "[startDownLoad], realDownloadResource()");
        AEResDownload.a(localAEResInfo, paramList, this);
      }
    }
    for (;;)
    {
      AEQLog.b("AEResManager", "[startDownLoad] + END");
      return;
      AEQLog.d("AEResManager_download", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
      AEQLog.b("AEResManager_download", "[startDownLoad] + END");
      return;
      label284:
      AEQLog.b("AEResManager", "[startDownLoad], isDownLoadImmediately=false");
      if ((i == 3) || (i == 2)) {
        break;
      }
      if (!a(paramList, this, paramQQAppInterface, localAEResInfo))
      {
        a(paramList, paramQQAppInterface, localAEResInfo);
        localAEResInfo.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_JavaUtilMap.put(localAEResInfo, Long.valueOf(System.currentTimeMillis()));
        AEQLog.b("AEResManager", "[startDownLoad], realDownloadResource()");
        this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(3));
        AEResDownload.a(localAEResInfo, paramList, this);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(2));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    AEQLog.b("AEResManager", "[onConfigResultInternal] ++++++ BEGIN");
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      AEQLog.b("AEResManager", "[onConfigResultInternal] 内存中'还没有'列表信息，开始生成配置列表");
      i = ShortVideoResourceManager.a(null, this.jdField_a_of_type_JavaUtilList);
      AEQLog.b("AEResManager", "[onConfigResultInternal] 生成配置列表结果 errCode = " + i);
      AEQLog.b("AEResManager", "[onConfigResultInternal] 内存中'当前的'配置列表信息，size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (i != 0) {
        break label399;
      }
      i = AEResUtil.a(this.jdField_a_of_type_JavaUtilList);
    }
    label399:
    for (;;)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (i == 0)
      {
        this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, Integer.valueOf(4));
        AEQLog.b("AEResManager", "[onConfigResultInternal] 配置列表拉取成功，开始进行ZIP包下载");
        localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a((List)localObject2, (QQAppInterface)localObject1, paramBoolean);
          AEQLog.b("AEResManager", "[onConfigResultInternal] ++++++ END");
          return;
          AEQLog.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，执行检查刷新列表");
          localObject1 = new LinkedList();
          int j = ShortVideoResourceManager.a(null, (List)localObject1);
          AEQLog.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，刷新后列表为 = " + localObject1);
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
      AEQLog.b("AEResManager", "[onConfigResultInternal] 配置列表拉取失败，尝试构造内置列表进行下载");
      ShortVideoResourceManager.a((QQAppInterface)localObject1, null);
      Object localObject2 = AELocalConfig.jdField_a_of_type_JavaUtilList;
      if (((List)localObject2).size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
      }
      this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, Integer.valueOf(4));
      AEQLog.b("AEResManager", "[onConfigResultInternal] 构造内置列表成功，开始下载");
      localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        a((List)localObject2, (QQAppInterface)localObject1, paramBoolean);
        break;
      }
    }
  }
  
  private boolean a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEResInfo paramAEResInfo)
  {
    AEQLog.b("AEResManager", "[startPreDownLoad] - BEGIN -, aeResInfo=" + paramAEResInfo);
    PreDownloadController localPreDownloadController = (PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
    Iterator localIterator = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    while (localIterator.hasNext())
    {
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (localSVConfigItem.name.startsWith(paramAEResInfo.jdField_b_of_type_JavaLangString)) {
        AEQLog.b("AEResManager", "[startPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((localPreDownloadController != null) && (localPreDownloadController.isEnable()))
      {
        paramINet_ShortVideoResource = new AEResManager.5(this, paramQQAppInterface, "ae_camera_res", new AEResManager.4(this, paramAEResInfo, paramList, paramINet_ShortVideoResource), 4000L);
        if (localSVConfigItem != null)
        {
          if ((VideoEnvironment64BitUtils.checkIs64bit()) && (localSVConfigItem.check64BitReady())) {}
          for (paramList = localSVConfigItem.arm64v8a_url;; paramList = localSVConfigItem.armv7a_url)
          {
            boolean bool = localPreDownloadController.requestPreDownload(10091, null, localSVConfigItem.name, 0, paramList, AEResUtil.a(localSVConfigItem.name), 4, 0, true, paramINet_ShortVideoResource);
            AEQLog.b("AEResManager", "[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=" + bool);
            AEQLog.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramAEResInfo);
            return bool;
          }
        }
        AEQLog.b("AEResManager", "[startPreDownLoad], chosenConfigItem == nul");
        AEQLog.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramAEResInfo);
        return false;
      }
      AEQLog.b("AEResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
      AEQLog.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramAEResInfo);
      return false;
      localSVConfigItem = null;
    }
  }
  
  private void b(@Nullable AEResManager.AEDownloadCallBack paramAEDownloadCallBack)
  {
    if (paramAEDownloadCallBack == null) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.contains(paramAEDownloadCallBack))) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramAEDownloadCallBack);
  }
  
  public int a(@NonNull AEResInfo paramAEResInfo)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      paramAEResInfo = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEResInfo);
      if (paramAEResInfo != null) {
        return paramAEResInfo.intValue();
      }
      return 0;
    }
    return 0;
  }
  
  public void a()
  {
    a().b(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo, null, false);
    a().b(AEResInfo.c, null, false);
    AEOldResManager.a().a(AEOldResInfo.b, null, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AEQLog.b("AEResManager", "[onConfigResultWithoutLogin] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.9(this));
    AEQLog.b("AEResManager", "[onConfigResultWithoutLogin] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void a(@NonNull AEResInfo paramAEResInfo, @Nullable AEResManager.AEDownloadCallBack paramAEDownloadCallBack, boolean paramBoolean)
  {
    AEQLog.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + paramAEResInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.1(this, paramAEResInfo, paramAEDownloadCallBack, paramBoolean));
    AEQLog.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + paramAEResInfo);
  }
  
  public void a(@Nullable AEResManager.AEDownloadCallBack paramAEDownloadCallBack)
  {
    if (paramAEDownloadCallBack == null) {}
    while (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramAEDownloadCallBack);
  }
  
  public void b(@NonNull AEResInfo paramAEResInfo, @Nullable AEResManager.AEDownloadCallBack paramAEDownloadCallBack, boolean paramBoolean)
  {
    AEQLog.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + paramAEResInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.2(this, paramAEResInfo, paramAEDownloadCallBack, paramBoolean));
    AEQLog.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + paramAEResInfo);
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    AEQLog.b("AEResManager", "[onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.6(this));
    AEQLog.b("AEResManager", "[onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    AEQLog.b("AEResManager", "[onDownloadFinish] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.7(this, paramString1, paramInt, paramString2));
    AEQLog.b("AEResManager", "[onDownloadFinish] - END -");
  }
  
  public void onNetWorkNone()
  {
    AEQLog.d("AEResManager", HardCodeUtil.a(2131700084));
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.8(this, paramString, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager
 * JD-Core Version:    0.7.0.1
 */