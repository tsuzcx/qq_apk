package com.tencent.mobileqq.shortvideo;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class PtvTemplateManager$4$1
  implements INetEngineListener
{
  PtvTemplateManager$4$1(PtvTemplateManager.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResp url: ");
      localStringBuilder.append(this.a.a.resurl);
      localStringBuilder.append(" resultcode: ");
      localStringBuilder.append(paramNetResp.mHttpCode);
      QLog.i("PtvTemplateManager", 2, localStringBuilder.toString());
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {
      try
      {
        ZipUtils.unZipFile(new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, this.a.a.name), PtvTemplateManager.jdField_a_of_type_JavaLangString);
        return;
      }
      catch (IOException paramNetResp)
      {
        if (QLog.isColorLevel()) {
          paramNetResp.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.4.1
 * JD-Core Version:    0.7.0.1
 */