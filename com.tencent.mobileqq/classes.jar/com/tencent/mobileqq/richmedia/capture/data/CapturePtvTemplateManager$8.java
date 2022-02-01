package com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class CapturePtvTemplateManager$8
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResp url: ");
      ((StringBuilder)localObject).append(this.a.resurl);
      ((StringBuilder)localObject).append(" resultcode: ");
      ((StringBuilder)localObject).append(paramNetResp.mHttpCode);
      QLog.i("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    paramNetResp = this.a;
    paramNetResp.usable = this.c.a(paramNetResp);
    paramNetResp = this.c.h.iterator();
    while (paramNetResp.hasNext())
    {
      localObject = (TemplateGroupItem)paramNetResp.next();
      if (((TemplateGroupItem)localObject).a != null)
      {
        localObject = ((TemplateGroupItem)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo.id.equals(this.a.id)) {
            localPtvTemplateInfo.usable = this.c.a(localPtvTemplateInfo);
          }
        }
      }
    }
    if (this.a.usable) {
      try
      {
        ZipUtils.unZipFile(new File(CapturePtvTemplateManager.e, this.a.md5), CapturePtvTemplateManager.a(this.a.md5));
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
      }
    }
    paramNetResp = this.b;
    if (paramNetResp != null)
    {
      localObject = this.a;
      paramNetResp.a((PtvTemplateManager.PtvTemplateInfo)localObject, ((PtvTemplateManager.PtvTemplateInfo)localObject).usable);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.b;
    if (paramNetReq != null) {
      paramNetReq.a(this.a, (int)(paramLong1 * 100L / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.8
 * JD-Core Version:    0.7.0.1
 */