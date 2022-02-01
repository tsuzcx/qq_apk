package com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class CapturePtvTemplateManager$SessionResHttpListener
  implements INetEngineListener
{
  CapturePtvTemplateManager.DLSession a;
  CapturePtvTemplateManager.DLItem b;
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramNetResp.mHttpCode), this.b.a, this.b.c }));
    }
    paramNetResp = (CapturePtvTemplateManager.DLItem)paramNetResp.mReq.getUserData();
    if (paramNetResp == null) {
      return;
    }
    Object localObject;
    if (paramNetResp.a.equals(this.b.a))
    {
      if (CapturePtvTemplateManager.b(paramNetResp.a, paramNetResp.b, false)) {
        try
        {
          ZipUtils.unZipFile(new File(CapturePtvTemplateManager.d, this.b.a), CapturePtvTemplateManager.b);
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
      if (!paramNetResp.e)
      {
        paramNetResp = (CapturePtvTemplateManager.BusinessParam)this.c.n.get(Integer.valueOf(this.a.d));
        if (paramNetResp != null)
        {
          paramNetResp = paramNetResp.c.iterator();
          while (paramNetResp.hasNext())
          {
            localObject = (CapturePtvTemplateManager.DLSession)paramNetResp.next();
            if (CapturePtvTemplateManager.a(this.c, (CapturePtvTemplateManager.DLSession)localObject, this.b)) {
              paramNetResp.remove();
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("SessionResHttpListener[onResp]: BusinessParam=null  kind=");
          paramNetResp.append(this.a.d);
          paramNetResp.append(" mItem.mName=");
          paramNetResp.append(this.b.a);
          QLog.e("CapturePtvTemplateManager", 2, paramNetResp.toString());
        }
      }
      else
      {
        CapturePtvTemplateManager.a(this.c, this.a, this.b);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SessionResHttpListener[onResp]: download information no match current=");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" callback=");
      ((StringBuilder)localObject).append(paramNetResp.a);
      QLog.e("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (CapturePtvTemplateManager.DLItem)paramNetReq.getUserData();
    if (paramNetReq == null) {
      return;
    }
    Object localObject;
    if (paramNetReq.a.equalsIgnoreCase(this.b.a))
    {
      localObject = (CapturePtvTemplateManager.BusinessParam)this.c.n.get(Integer.valueOf(this.a.d));
      if (localObject != null)
      {
        if (!paramNetReq.e)
        {
          paramNetReq = ((CapturePtvTemplateManager.BusinessParam)localObject).c.iterator();
          while (paramNetReq.hasNext())
          {
            localObject = (CapturePtvTemplateManager.DLSession)paramNetReq.next();
            CapturePtvTemplateManager.a(this.c, (CapturePtvTemplateManager.DLSession)localObject, this.b, paramLong1, paramLong2);
          }
        }
        CapturePtvTemplateManager.a(this.c, this.a, this.b, paramLong1, paramLong2);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramNetReq = new StringBuilder();
        paramNetReq.append("SessionResHttpListener[Progress]: BusinessParam=null  kind=");
        paramNetReq.append(this.a.d);
        paramNetReq.append(" mItem.mName=");
        paramNetReq.append(this.b.a);
        QLog.e("CapturePtvTemplateManager", 2, paramNetReq.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SessionResHttpListener[Progress]: download information no match current=");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" callback=");
      ((StringBuilder)localObject).append(paramNetReq.a);
      QLog.e("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.SessionResHttpListener
 * JD-Core Version:    0.7.0.1
 */