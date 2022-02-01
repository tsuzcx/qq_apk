package com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class CapturePtvTemplateManager$5
  implements INetEngineListener
{
  CapturePtvTemplateManager$5(CapturePtvTemplateManager paramCapturePtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResp url: ");
      localStringBuilder.append(this.a.resurl);
      localStringBuilder.append(" resultcode: ");
      localStringBuilder.append(paramNetResp.mHttpCode);
      QLog.i("CapturePtvTemplateManager", 2, localStringBuilder.toString());
    }
    paramNetResp = this.a;
    paramNetResp.usable = this.b.a(paramNetResp);
    if (this.a.usable)
    {
      try
      {
        ZipUtils.unZipFile(new File(CapturePtvTemplateManager.e, this.a.md5), CapturePtvTemplateManager.a(this.a.md5));
      }
      catch (IOException paramNetResp)
      {
        if (QLog.isColorLevel()) {
          paramNetResp.printStackTrace();
        }
      }
      if (this.b.l != null) {
        this.b.l.a();
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */