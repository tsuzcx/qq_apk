package com.tencent.mobileqq.flashshow.manager;

import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class FSRichMediaDownLoadManager$3
  implements INetEngineListener
{
  FSRichMediaDownLoadManager$3(FSRichMediaDownLoadManager paramFSRichMediaDownLoadManager, FSRichMediaDownLoadManager.DownLoadParams paramDownLoadParams) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append(this.a.a());
      paramNetResp.append(",download success ");
      QLog.d("FSRichMediaDownLoadManager", 1, paramNetResp.toString());
      FSRichMediaDownLoadManager.a(this.b, this.a);
      return;
    }
    if ((paramNetResp.mResult == 1) || (paramNetResp.mResult == 2))
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append(this.a.a());
      paramNetResp.append(",download failed ");
      QLog.d("FSRichMediaDownLoadManager", 1, paramNetResp.toString());
      HostFileUtils.delete(this.a.c(), true);
      if (FSRichMediaDownLoadManager.DownLoadParams.a(this.a) != null) {
        FSRichMediaDownLoadManager.DownLoadParams.a(this.a).a(false);
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (FSRichMediaDownLoadManager.DownLoadParams.a(this.a) != null)
    {
      int i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
      FSRichMediaDownLoadManager.DownLoadParams.a(this.a).a(i);
      paramNetReq = new StringBuilder();
      paramNetReq.append(this.a.a());
      paramNetReq.append(",download progress:  ");
      paramNetReq.append(i);
      QLog.d("FSRichMediaDownLoadManager", 1, paramNetReq.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSRichMediaDownLoadManager.3
 * JD-Core Version:    0.7.0.1
 */