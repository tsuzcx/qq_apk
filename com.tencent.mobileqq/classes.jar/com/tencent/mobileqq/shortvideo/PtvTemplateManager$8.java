package com.tencent.mobileqq.shortvideo;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class PtvTemplateManager$8
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
      QLog.i("PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    paramNetResp = this.a;
    paramNetResp.usable = this.c.a(paramNetResp);
    if (this.a.businessID == 1)
    {
      paramNetResp = this.c.C.iterator();
      while (paramNetResp.hasNext())
      {
        localObject = (PtvTemplateManager.PtvTemplateInfo)paramNetResp.next();
        if (((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.a.id)) {
          ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.c.a((PtvTemplateManager.PtvTemplateInfo)localObject);
        }
      }
    }
    paramNetResp = this.c.i.iterator();
    while (paramNetResp.hasNext())
    {
      localObject = (PtvTemplateManager.PtvTemplateInfo)paramNetResp.next();
      if (((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.a.id)) {
        ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.c.a((PtvTemplateManager.PtvTemplateInfo)localObject);
      }
    }
    paramNetResp = this.c.j.iterator();
    while (paramNetResp.hasNext())
    {
      localObject = (PtvTemplateManager.PtvTemplateInfo)paramNetResp.next();
      if (((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.a.id)) {
        ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.c.a((PtvTemplateManager.PtvTemplateInfo)localObject);
      }
    }
    if (this.a.usable) {
      try
      {
        ZipUtils.unZipFile(new File(PtvTemplateManager.e, this.a.name), PtvTemplateManager.b);
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
    if (paramNetReq != null)
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = this.a;
      localPtvTemplateInfo.totalLen = paramLong2;
      paramNetReq.a(localPtvTemplateInfo, (int)(paramLong1 * 100L / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.8
 * JD-Core Version:    0.7.0.1
 */