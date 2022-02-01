package com.tencent.mobileqq.kandian.biz.ugc.capture;

import android.content.Context;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.Callback;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCameraCaptureSoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyCameraCaptureSoManager
  implements IAEDownloadCallBack, IReadInJoyCameraCaptureSoManager, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig
{
  private QQAppInterface b;
  private Context c;
  private Callback d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public ReadInJoyCameraCaptureSoManager(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = true;
    this.e = true;
    this.f = false;
    this.g = false;
    this.b = paramQQAppInterface;
    this.c = paramContext;
    int i = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
    paramQQAppInterface = (IAEResUtil)QRoute.api(IAEResUtil.class);
    if (i == 0) {
      bool = false;
    }
    this.e = bool;
  }
  
  private void a()
  {
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null)
    {
      ShortVideoResourceManager.b(localQQAppInterface, this);
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).removeCallBack(this);
    }
  }
  
  private void a(int paramInt)
  {
    a();
    Callback localCallback = this.d;
    if (localCallback != null) {
      localCallback.a(paramInt);
    }
  }
  
  private void b()
  {
    if ((this.f) && ((this.g) || (!this.e))) {
      a(1);
    }
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramAEResInfo.resPrefix.equals(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix))
    {
      if (paramInt != 0)
      {
        paramAEResInfo = new StringBuilder();
        paramAEResInfo.append("[onAEDownloadFinish] error :");
        paramAEResInfo.append(paramInt);
        AEQLog.d("ReadInJoyCameraCaptureSoManager", paramAEResInfo.toString());
        a(3);
        return;
      }
      AEQLog.d("ReadInJoyCameraCaptureSoManager", "[onAEDownloadFinish] success");
      this.g = true;
      b();
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("result=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",serverError=");
    ((StringBuilder)localObject).append(paramInt2);
    VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", ((StringBuilder)localObject).toString(), null);
    int j = 1;
    int i;
    if (paramInt1 != 1)
    {
      i = j;
      if (paramInt1 != 0) {}
    }
    else if (paramInt2 != 0)
    {
      i = j;
    }
    else
    {
      localObject = new ArrayList(1);
      i = j;
      if (ShortVideoResourceManager.a(this.b, (List)localObject) == 0)
      {
        ShortVideoResourceManager.a(this.b, (List)localObject, this);
        paramInt1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
        localObject = (IAEResUtil)QRoute.api(IAEResUtil.class);
        if (paramInt1 != 2)
        {
          paramInt1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE);
          localObject = (IAEResUtil)QRoute.api(IAEResUtil.class);
          if (paramInt1 != 2)
          {
            this.g = true;
            VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "onConfigResult| getFilterSoState != 2", null);
            break label293;
          }
        }
        paramInt1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
        localObject = (IAEResUtil)QRoute.api(IAEResUtil.class);
        if (paramInt1 == 2) {
          ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, this, false);
        }
        paramInt1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE);
        localObject = (IAEResUtil)QRoute.api(IAEResUtil.class);
        if (paramInt1 == 2) {
          ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.LIGHT_RES_BASE_PACKAGE, this, false);
        }
        label293:
        i = 0;
      }
    }
    if (i != 0) {
      a(3);
    }
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        a(3);
      }
      else
      {
        this.f = true;
        b();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", localStringBuilder.toString(), null);
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "onNetWorkNone", null);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyCameraCaptureSoManager
 * JD-Core Version:    0.7.0.1
 */