package com.tencent.mobileqq.wink.edit.manager;

import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.edit.util.AEDownloader.DownloadListener;

class WinkEditorResourceDownloader$4
  implements AEDownloader.DownloadListener
{
  WinkEditorResourceDownloader$4(WinkEditorResourceDownloader paramWinkEditorResourceDownloader, WinkEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener, String paramString1, AEEditorDownloadResBean paramAEEditorDownloadResBean, String paramString2, String paramString3) {}
  
  public void a(int paramInt)
  {
    WinkEditorResourceDownloader.ResDownLoadListener localResDownLoadListener = this.a;
    if (localResDownLoadListener != null) {
      localResDownLoadListener.a(paramInt);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool3 = false;
    if (paramNetResp == null)
    {
      paramNetResp = this.a;
      if (paramNetResp != null) {
        paramNetResp.a(false);
      }
      this.f.a(this.b, false);
      return;
    }
    boolean bool1;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramNetResp = this.f.d;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downLoadOneResInternal-onDownloadFinish---isSuccess=");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", id=");
    ((StringBuilder)localObject).append(this.c.getId());
    WinkQLog.b(paramNetResp, ((StringBuilder)localObject).toString());
    boolean bool2 = bool3;
    if (bool1)
    {
      paramNetResp = FileUtils.calcMd5(this.d);
      if ((paramNetResp != null) && (paramNetResp.equalsIgnoreCase(this.b)))
      {
        try
        {
          bool2 = this.f.a(this.d, this.e, this.c.getId(), this.b);
        }
        catch (Exception paramNetResp)
        {
          localObject = this.f.d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=");
          localStringBuilder.append(this.c.getId());
          WinkQLog.a((String)localObject, localStringBuilder.toString(), paramNetResp);
          paramNetResp.printStackTrace();
          bool2 = bool3;
        }
      }
      else
      {
        paramNetResp = this.f.d;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=");
        ((StringBuilder)localObject).append(this.c.getId());
        WinkQLog.d(paramNetResp, ((StringBuilder)localObject).toString());
        bool2 = bool3;
      }
    }
    if (!bool2) {
      FileUtils.deleteDirectory(this.e);
    }
    FileUtils.deleteFile(this.d);
    paramNetResp = this.f.d;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downLoadOneResInternal-onDownloadFinish---REAL result=");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(", id=");
    ((StringBuilder)localObject).append(this.c.getId());
    WinkQLog.b(paramNetResp, ((StringBuilder)localObject).toString());
    paramNetResp = this.a;
    if (paramNetResp != null) {
      paramNetResp.a(bool2);
    }
    this.f.a(this.b, bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */