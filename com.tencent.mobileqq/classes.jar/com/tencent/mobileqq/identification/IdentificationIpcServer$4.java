package com.tencent.mobileqq.identification;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import face.qqlogin.faceproto.Response;
import java.io.File;
import java.util.HashMap;

class IdentificationIpcServer$4
  implements ITransactionCallback
{
  IdentificationIpcServer$4(IdentificationIpcServer paramIdentificationIpcServer, File paramFile, EIPCResult paramEIPCResult, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.i("qqidentification_server", 1, "BDH.Upload fail  : result:" + paramInt);
    IdentificationIpcServer.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, "", "", this.c + "", "");
    this.jdField_a_of_type_EipcEIPCResult.code = -102;
    paramArrayOfByte = new Bundle();
    paramArrayOfByte.putInt("ret", 209);
    paramArrayOfByte.putString("subError", "UPLOAD onFailed I=" + paramInt);
    paramArrayOfByte.putString("errMsg", HardCodeUtil.a(2131705725));
    this.jdField_a_of_type_EipcEIPCResult.data = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer.callbackResult(IdentificationIpcServer.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer), this.jdField_a_of_type_EipcEIPCResult);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.d("qqidentification_server", 1, "upload file success");
    IdentificationIpcServer.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer);
    this.jdField_a_of_type_JavaIoFile.delete();
    paramHashMap = new faceproto.Response();
    for (;;)
    {
      try
      {
        paramHashMap.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new Bundle();
        i = paramHashMap.Ret.get();
        paramArrayOfByte.putInt("ret", i);
        str1 = paramHashMap.ErrMsg.get();
        paramArrayOfByte.putString("errMsg", str1);
        paramArrayOfByte.putBoolean("needRetry", paramHashMap.NeedRetry.get());
        String str2 = paramHashMap.IDKey.get();
        QLog.d("qqidentification_server", 1, new Object[] { "retry: " + paramHashMap.NeedRetry.get() + " ret=" + i, "idKey : ", str2 });
        paramArrayOfByte.putString("idKey", str2);
        this.jdField_a_of_type_EipcEIPCResult.data = paramArrayOfByte;
        if (i != 0) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097ED", "0X80097ED", 0, 0, this.jdField_a_of_type_Int + "", "" + this.b, this.c + "", "");
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int i;
        String str1;
        QLog.e("qqidentification_server", 1, new Object[] { "parse bytes error : ", paramArrayOfByte.getMessage() });
        this.jdField_a_of_type_EipcEIPCResult.code = -102;
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putString("subError", "InvalidProtocolBufferMicroException");
        paramArrayOfByte.putInt("ret", 208);
        paramArrayOfByte.putString("errMsg", HardCodeUtil.a(2131705727));
        this.jdField_a_of_type_EipcEIPCResult.data = paramArrayOfByte;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, this.jdField_a_of_type_Int + "", "" + this.b, this.c + "", "");
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer.callbackResult(IdentificationIpcServer.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer), this.jdField_a_of_type_EipcEIPCResult);
      return;
      QLog.e("qqidentification_server", 1, "request err: " + i + ", " + str1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097EE", "0X80097EE", 0, 0, this.jdField_a_of_type_Int + "", "" + this.b, this.c + "", i + "");
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationIpcServer.4
 * JD-Core Version:    0.7.0.1
 */