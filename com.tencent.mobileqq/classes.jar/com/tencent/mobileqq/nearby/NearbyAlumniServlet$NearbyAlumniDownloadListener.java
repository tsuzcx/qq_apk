package com.tencent.mobileqq.nearby;

import android.content.Intent;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class NearbyAlumniServlet$NearbyAlumniDownloadListener
  implements INetEngineListener
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public NearbyAlumniServlet$NearbyAlumniDownloadListener(NearbyAlumniServlet paramNearbyAlumniServlet, Intent paramIntent, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((paramNetResp == null) || (paramNetResp.mResult != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("NearbyAlumniDownloadListener.onResp() | resp = ").append(paramNetResp).append(" | mResult=");
        if (paramNetResp == null) {
          break label110;
        }
      }
      label110:
      for (int i = paramNetResp.mResult;; i = -1)
      {
        QLog.i("NearbyAlumniServlet", 2, i);
        NearbyAlumniServlet.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAlumniServlet, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
        paramNetResp = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAlumniServlet.a();
        if (paramNetResp != null) {
          paramNetResp.a();
        }
        return;
      }
    }
    NearbyAlumniServlet.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAlumniServlet, this.jdField_a_of_type_AndroidContentIntent, 0, paramNetResp.mRespData, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyAlumniServlet.NearbyAlumniDownloadListener
 * JD-Core Version:    0.7.0.1
 */