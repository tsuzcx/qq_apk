package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class BridgeModule$DownloadListenerImp
  implements DownloadListener
{
  private String b;
  private String c;
  
  public BridgeModule$DownloadListenerImp(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  private String a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      return paramDownloadInfo.d;
    }
    return "";
  }
  
  private String b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      return paramDownloadInfo.e;
    }
    return "";
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("type", 6);
      this.a.invokeCallJS(this.c, paramString1);
    }
    catch (Exception paramString1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("installSucceed error:");
      localStringBuilder.append(paramString1.getMessage());
      ViolaLogUtils.e("downloadApk", localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("downloadApk installSucceed, packageName = ");
      paramString1.append(paramString2);
      QLog.d("BridgeModule", 2, paramString1.toString());
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", 3);
      if ((paramDownloadInfo != null) && (this.b.equals(paramDownloadInfo.d))) {
        localJSONObject.put("data", paramDownloadInfo.t);
      }
      this.a.invokeCallJS(this.c, localJSONObject);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("onDownloadError error:");
      localStringBuilder2.append(localException.getMessage());
      ViolaLogUtils.e("onDownloadCancel", localStringBuilder2.toString());
      localException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("downloadApk onDownloadCancel, url = ");
      localStringBuilder1.append(a(paramDownloadInfo));
      localStringBuilder1.append(" , packageName = ");
      localStringBuilder1.append(b(paramDownloadInfo));
      QLog.d("BridgeModule", 2, localStringBuilder1.toString());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      paramString = new JSONObject();
      paramString.put("type", 4);
      this.a.invokeCallJS(this.c, paramString);
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadError error:");
      localStringBuilder.append(paramString.getMessage());
      ViolaLogUtils.e("downloadApk", localStringBuilder.toString());
      paramString.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("downloadApk onDownloadError, url = ");
      paramString.append(a(paramDownloadInfo));
      paramString.append(" , packageName = ");
      paramString.append(b(paramDownloadInfo));
      QLog.d("BridgeModule", 2, paramString.toString());
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", 2);
      this.a.invokeCallJS(this.c, localJSONObject);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("onDownloadFinish error:");
      localStringBuilder2.append(localException.getMessage());
      ViolaLogUtils.e("downloadApk", localStringBuilder2.toString());
      localException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("downloadApk onDownloadFinish, url = ");
      localStringBuilder1.append(a(paramDownloadInfo));
      localStringBuilder1.append(" , packageName = ");
      localStringBuilder1.append(b(paramDownloadInfo));
      QLog.d("BridgeModule", 2, localStringBuilder1.toString());
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", 5);
      if ((paramDownloadInfo != null) && (this.b.equals(paramDownloadInfo.d))) {
        localJSONObject.put("data", paramDownloadInfo.t);
      }
      this.a.invokeCallJS(this.c, localJSONObject);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("onDownloadPause error:");
      localStringBuilder2.append(localException.getMessage());
      ViolaLogUtils.e("onDownloadPause", localStringBuilder2.toString());
      localException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("downloadApk onDownloadPause, url = ");
      localStringBuilder1.append(a(paramDownloadInfo));
      localStringBuilder1.append(" , packageName = ");
      localStringBuilder1.append(b(paramDownloadInfo));
      QLog.d("BridgeModule", 2, localStringBuilder1.toString());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (this.b.equals(localDownloadInfo.d)) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("type", 1);
          localJSONObject.put("data", localDownloadInfo.t);
          this.a.invokeCallJS(this.c, localJSONObject);
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("onDownloadFinish error:");
          localStringBuilder2.append(localException.getMessage());
          ViolaLogUtils.e("downloadApk", localStringBuilder2.toString());
          localException.printStackTrace();
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("downloadApk onDownloadUpdate, url = ");
        localStringBuilder1.append(localDownloadInfo.d);
        localStringBuilder1.append(" , packageName = ");
        localStringBuilder1.append(localDownloadInfo.e);
        localStringBuilder1.append(" process = ");
        localStringBuilder1.append(localDownloadInfo.t);
        QLog.d("BridgeModule", 2, localStringBuilder1.toString());
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadApk onDownloadWait, url = ");
      localStringBuilder.append(a(paramDownloadInfo));
      localStringBuilder.append(" , packageName = ");
      localStringBuilder.append(b(paramDownloadInfo));
      QLog.d("BridgeModule", 2, localStringBuilder.toString());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("type", 6);
      this.a.invokeCallJS(this.c, paramString1);
    }
    catch (Exception paramString1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("packageReplaced error:");
      localStringBuilder.append(paramString1.getMessage());
      ViolaLogUtils.e("downloadApk", localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("downloadApk packageReplaced, packageName = ");
      paramString1.append(paramString2);
      QLog.d("BridgeModule", 2, paramString1.toString());
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("downloadApk uninstallSucceed, packageName = ");
      paramString1.append(paramString2);
      QLog.d("BridgeModule", 2, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.DownloadListenerImp
 * JD-Core Version:    0.7.0.1
 */