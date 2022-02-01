package com.tencent.mobileqq.nearby;

import android.content.Intent;
import com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class NearbyAlumniServlet$NearbyAlumniDownloadListener
  implements INetEngineListener
{
  private Intent b;
  private byte[] c;
  
  public NearbyAlumniServlet$NearbyAlumniDownloadListener(NearbyAlumniServlet paramNearbyAlumniServlet, Intent paramIntent, byte[] paramArrayOfByte)
  {
    this.b = paramIntent;
    this.c = paramArrayOfByte;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((paramNetResp != null) && (paramNetResp.mResult == 0))
    {
      NearbyAlumniServlet.a(this.a, this.b, 0, paramNetResp.mRespData, this.c);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NearbyAlumniDownloadListener.onResp() | resp = ");
      localStringBuilder.append(paramNetResp);
      localStringBuilder.append(" | mResult=");
      int i;
      if (paramNetResp != null) {
        i = paramNetResp.mResult;
      } else {
        i = -1;
      }
      localStringBuilder.append(i);
      QLog.i("NearbyAlumniServlet", 2, localStringBuilder.toString());
    }
    NearbyAlumniServlet.a(this.a, this.b, -10, null, new byte[1]);
    paramNetResp = this.a.a();
    if (paramNetResp != null) {
      paramNetResp.onResponseException();
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyAlumniServlet.NearbyAlumniDownloadListener
 * JD-Core Version:    0.7.0.1
 */