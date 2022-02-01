package dov.com.qq.im.ae.download.old;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
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
import java.util.List<Ldov.com.qq.im.ae.download.old.AEOldShortVideoResManager.SVConfigItem;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AEOldResDownload
{
  private static Map<String, AEOldShortVideoResManager.SVConfigItem> a = new ConcurrentHashMap();
  
  public static void a(@NonNull AEOldResInfo paramAEOldResInfo, @NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new AEOldResDownload.1(paramAEOldResInfo, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  private static void c(@NonNull AEOldResInfo paramAEOldResInfo, @NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    int i;
    Object localObject;
    if ((VcSystemInfo.isBeautySupported()) && (Build.VERSION.SDK_INT >= 15))
    {
      AEQLog.b("AEOldResDownload", "support isNeon");
      i = 0;
      if (i >= paramList.size()) {
        break label487;
      }
      localObject = (AEOldShortVideoResManager.SVConfigItem)paramList.get(i);
      if ((!((AEOldShortVideoResManager.SVConfigItem)localObject).name.startsWith(paramAEOldResInfo.b)) || (((AEOldShortVideoResManager.SVConfigItem)localObject).versionCode != paramAEOldResInfo.c)) {
        break label116;
      }
    }
    label217:
    label487:
    for (paramList = (List<AEOldShortVideoResManager.SVConfigItem>)localObject;; paramList = null)
    {
      if (paramList == null)
      {
        AEQLog.d("AEOldResDownload", "[realDownloadResource EROOR]");
        paramINet_ShortVideoResource.a("", -101, null);
        return;
        AEQLog.d("AEOldResDownload", "Neon is not Support");
        paramINet_ShortVideoResource.a("", -1, null);
        return;
        label116:
        i += 1;
        break;
      }
      i = AEOldResUtil.a(paramAEOldResInfo.a);
      if (i >= Integer.valueOf(paramList.name.substring(paramAEOldResInfo.b.length())).intValue())
      {
        if (TextUtils.isEmpty(AEOldResUtil.a(paramAEOldResInfo))) {
          AEQLog.d("AEOldResDownload", "[realDownloadResourceInternal] local exist but finalPath is null");
        }
      }
      else
      {
        localObject = new HttpNetReq();
        ((HttpNetReq)localObject).mCallback = new AEOldResDownload.2(paramINet_ShortVideoResource, paramAEOldResInfo);
        if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!paramList.check64BitReady())) {
          break label412;
        }
        ((HttpNetReq)localObject).mReqUrl = paramList.arm64v8a_url;
        ((HttpNetReq)localObject).mHttpMethod = 0;
        ((HttpNetReq)localObject).mOutPath = (AEOldResUtil.c() + paramList.name);
        ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
        ((HttpNetReq)localObject).bAcceptNegativeContentLength = true;
        ((HttpNetReq)localObject).setUserData(paramList.name);
        paramAEOldResInfo = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramAEOldResInfo != null) {
          break label424;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          AEQLog.d("AEOldResDownload", "[realDownloadResourceInternal] need new DownLoadEngine");
          paramAEOldResInfo = new HttpCommunicator(4);
          paramAEOldResInfo.start();
          new HttpEngineServiceImpl(paramAEOldResInfo, false).sendReq((NetReq)localObject);
        }
        a.put(paramList.name, paramList);
        return;
        if (TextUtils.isEmpty(AEOldResUtil.c(paramAEOldResInfo)))
        {
          AEQLog.d("AEOldResDownload", "[realDownloadResourceInternal] local exist but unzipPath is null");
          break;
        }
        AEQLog.d("AEOldResDownload", "[realDownloadResource info] local exist");
        paramINet_ShortVideoResource.a(paramList.name, 1, AEOldResUtil.a(paramAEOldResInfo.b + i));
        return;
        ((HttpNetReq)localObject).mReqUrl = paramList.armv7a_url;
        break label217;
        if (!paramAEOldResInfo.isLogin())
        {
          i = 1;
        }
        else if (paramAEOldResInfo.getManager(QQManagerFactory.MGR_NET_ENGINE) == null)
        {
          i = 1;
        }
        else
        {
          paramAEOldResInfo = (IHttpEngineService)paramAEOldResInfo.getRuntimeService(IHttpEngineService.class, "all");
          if (paramAEOldResInfo == null)
          {
            i = 1;
          }
          else
          {
            paramAEOldResInfo.sendReq((NetReq)localObject);
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldResDownload
 * JD-Core Version:    0.7.0.1
 */