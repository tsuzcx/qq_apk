package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class IdentificationIpcServer$5
  implements INetEngineListener
{
  IdentificationIpcServer$5(IdentificationIpcServer paramIdentificationIpcServer, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3)
    {
      QLog.d("qqidentification_server", 2, "identification res download repeating ");
      return;
    }
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = paramNetResp.mReq.mOutPath;
      String str = FileUtils.c(paramNetResp);
      if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      try
      {
        FileUtils.a(paramNetResp, this.b, false);
        QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but unzip is failed");
      }
      catch (IOException localIOException1)
      {
        try
        {
          IdentificationIpcServer.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer).destroy();
          IdentificationIpcServer.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer, null);
          bool = true;
          FileUtils.e(paramNetResp);
          if (QLog.isColorLevel()) {
            QLog.d("qqidentification_server", 2, "downloadRes.onResp download path : " + this.b);
          }
          QLog.d("qqidentification_server", 1, new Object[] { "download face res success : ", Boolean.valueOf(bool) });
          if (bool)
          {
            SharedPreUtils.c(this.b);
            SharedPreUtils.b(this.jdField_a_of_type_Int);
            SharedPreUtils.c(IdentificationActivityHelper.b());
          }
          IdentificationIpcServer.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer, bool);
          return;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            boolean bool = true;
          }
        }
        localIOException1 = localIOException1;
        bool = false;
      }
      continue;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but md5 is mismatched ");
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "downloadRes.onResp download succ but md5 is mismatched,fileSize = " + FileUtils.a(paramNetResp) + ",md5 = " + localIOException1 + ",url = " + this.c);
      }
      bool = false;
      continue;
      QLog.d("qqidentification_server", 1, new Object[] { "downloadRes.onResp failed  isSuccess is false, code is : ", Integer.valueOf(paramNetResp.mErrCode), " msg : ", paramNetResp.mErrDesc });
      bool = false;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationIpcServer.5
 * JD-Core Version:    0.7.0.1
 */