package dov.com.qq.im.ae.download;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AEResDownload
{
  private static Map<String, ShortVideoResourceManager.SVConfigItem> a = new ConcurrentHashMap();
  
  public static void a(@NonNull AEResInfo paramAEResInfo, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new AEResDownload.1(paramAEResInfo, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  private static void c(@NonNull AEResInfo paramAEResInfo, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    int i;
    Object localObject;
    if ((VcSystemInfo.isBeautySupported()) && (Build.VERSION.SDK_INT >= 15))
    {
      AEQLog.b("AEResDownload", "support isNeon");
      i = 0;
      if (i >= paramList.size()) {
        break label494;
      }
      localObject = (ShortVideoResourceManager.SVConfigItem)paramList.get(i);
      if ((!((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(paramAEResInfo.b)) || (((ShortVideoResourceManager.SVConfigItem)localObject).versionCode != paramAEResInfo.c)) {
        break label116;
      }
    }
    label217:
    label494:
    for (paramList = (List<ShortVideoResourceManager.SVConfigItem>)localObject;; paramList = null)
    {
      if (paramList == null)
      {
        AEQLog.d("AEResDownload", "[realDownloadResource EROOR]");
        paramINet_ShortVideoResource.onDownloadFinish("", -101, null);
        return;
        AEQLog.d("AEResDownload", "Neon is not Support");
        paramINet_ShortVideoResource.onDownloadFinish("", -1, null);
        return;
        label116:
        i += 1;
        break;
      }
      i = AEResUtil.a(paramAEResInfo.a);
      if (i >= Integer.valueOf(paramList.name.substring(paramAEResInfo.b.length())).intValue())
      {
        if (TextUtils.isEmpty(AEResUtil.a(paramAEResInfo))) {
          AEQLog.d("AEResDownload", "[realDownloadResourceInternal] local exist but finalPath is null");
        }
      }
      else
      {
        localObject = new HttpNetReq();
        ((HttpNetReq)localObject).mCallback = new AEResDownload.2(paramINet_ShortVideoResource, paramAEResInfo);
        if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!paramList.check64BitReady())) {
          break label419;
        }
        ((HttpNetReq)localObject).mReqUrl = paramList.arm64v8a_url;
        ((HttpNetReq)localObject).mHttpMethod = 0;
        ((HttpNetReq)localObject).mOutPath = (AEResUtil.c() + paramList.name);
        ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
        ((HttpNetReq)localObject).bAcceptNegativeContentLength = true;
        ((HttpNetReq)localObject).setUserData(paramList.name);
        paramAEResInfo = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramAEResInfo != null) {
          break label431;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          AEQLog.d("AEResDownload", "[realDownloadResourceInternal] need new DownLoadEngine");
          paramAEResInfo = new HttpCommunicator(4);
          paramAEResInfo.start();
          new HttpEngineServiceImpl(paramAEResInfo, false).sendReq((NetReq)localObject);
        }
        a.put(paramList.name, paramList);
        return;
        if ((TextUtils.isEmpty(AEResUtil.b(paramAEResInfo))) || (!AEResUtil.b(paramAEResInfo)))
        {
          AEQLog.d("AEResDownload", "[realDownloadResourceInternal] local exist but unzipPath is null");
          break;
        }
        AEQLog.d("AEResDownload", "[realDownloadResource info] local exist");
        paramINet_ShortVideoResource.onDownloadFinish(paramList.name, 1, AEResUtil.a(paramAEResInfo.b + i));
        return;
        ((HttpNetReq)localObject).mReqUrl = paramList.armv7a_url;
        break label217;
        if (!paramAEResInfo.isLogin())
        {
          i = 1;
        }
        else if (paramAEResInfo.getManager(QQManagerFactory.MGR_NET_ENGINE) == null)
        {
          i = 1;
        }
        else
        {
          paramAEResInfo = (IHttpEngineService)paramAEResInfo.getRuntimeService(IHttpEngineService.class, "all");
          if (paramAEResInfo == null)
          {
            i = 1;
          }
          else
          {
            paramAEResInfo.sendReq((NetReq)localObject);
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResDownload
 * JD-Core Version:    0.7.0.1
 */