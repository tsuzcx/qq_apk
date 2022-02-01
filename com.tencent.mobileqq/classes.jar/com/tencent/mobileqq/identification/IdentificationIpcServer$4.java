package com.tencent.mobileqq.identification;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
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
import mqq.app.AppRuntime;

class IdentificationIpcServer$4
  implements ITransactionCallback
{
  IdentificationIpcServer$4(IdentificationIpcServer paramIdentificationIpcServer, File paramFile, EIPCResult paramEIPCResult, AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("BDH.Upload fail  : result:");
    paramArrayOfByte.append(paramInt);
    QLog.i("qqidentification_server", 1, paramArrayOfByte.toString());
    paramArrayOfByte = this.c;
    paramHashMap = new StringBuilder();
    paramHashMap.append(this.f);
    paramHashMap.append("");
    ReportController.b(paramArrayOfByte, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, "", "", paramHashMap.toString(), "");
    this.b.code = -102;
    paramArrayOfByte = new Bundle();
    paramArrayOfByte.putInt("ret", 209);
    paramHashMap = new StringBuilder();
    paramHashMap.append("UPLOAD onFailed I=");
    paramHashMap.append(paramInt);
    paramArrayOfByte.putString("subError", paramHashMap.toString());
    paramArrayOfByte.putString("errMsg", HardCodeUtil.a(2131903673));
    this.b.data = paramArrayOfByte;
    paramArrayOfByte = this.g;
    paramArrayOfByte.callbackResult(IdentificationIpcServer.a(paramArrayOfByte), this.b);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.d("qqidentification_server", 1, "upload file success");
    this.a.delete();
    paramHashMap = new faceproto.Response();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte);
      localObject1 = new Bundle();
      int i = paramHashMap.Ret.get();
      ((Bundle)localObject1).putInt("ret", i);
      paramArrayOfByte = paramHashMap.ErrMsg.get();
      ((Bundle)localObject1).putString("errMsg", paramArrayOfByte);
      ((Bundle)localObject1).putBoolean("needRetry", paramHashMap.NeedRetry.get());
      localObject2 = paramHashMap.IDKey.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retry: ");
      localStringBuilder.append(paramHashMap.NeedRetry.get());
      localStringBuilder.append(" ret=");
      localStringBuilder.append(i);
      QLog.d("qqidentification_server", 1, new Object[] { localStringBuilder.toString(), "idKey : ", localObject2 });
      ((Bundle)localObject1).putString("idKey", (String)localObject2);
      this.b.data = ((Bundle)localObject1);
      if (i == 0)
      {
        paramArrayOfByte = this.c;
        paramHashMap = new StringBuilder();
        paramHashMap.append(this.d);
        paramHashMap.append("");
        paramHashMap = paramHashMap.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.e);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.f);
        ((StringBuilder)localObject2).append("");
        ReportController.b(paramArrayOfByte, "dc00898", "", "", "0X80097ED", "0X80097ED", 0, 0, paramHashMap, (String)localObject1, ((StringBuilder)localObject2).toString(), "");
      }
      else
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("request err: ");
        paramHashMap.append(i);
        paramHashMap.append(", ");
        paramHashMap.append(paramArrayOfByte);
        QLog.e("qqidentification_server", 1, paramHashMap.toString());
        paramArrayOfByte = this.c;
        paramHashMap = new StringBuilder();
        paramHashMap.append(this.d);
        paramHashMap.append("");
        paramHashMap = paramHashMap.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.e);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.f);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ReportController.b(paramArrayOfByte, "dc00898", "", "", "0X80097EE", "0X80097EE", 0, 0, paramHashMap, (String)localObject1, (String)localObject2, localStringBuilder.toString());
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("qqidentification_server", 1, new Object[] { "parse bytes error : ", paramArrayOfByte.getMessage() });
      this.b.code = -102;
      paramArrayOfByte = new Bundle();
      paramArrayOfByte.putString("subError", "InvalidProtocolBufferMicroException");
      paramArrayOfByte.putInt("ret", 208);
      paramArrayOfByte.putString("errMsg", HardCodeUtil.a(2131903673));
      this.b.data = paramArrayOfByte;
      paramArrayOfByte = this.c;
      paramHashMap = new StringBuilder();
      paramHashMap.append(this.d);
      paramHashMap.append("");
      paramHashMap = paramHashMap.toString();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.e);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.f);
      ((StringBuilder)localObject2).append("");
      ReportController.b(paramArrayOfByte, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, paramHashMap, (String)localObject1, ((StringBuilder)localObject2).toString(), "");
    }
    paramArrayOfByte = this.g;
    paramArrayOfByte.callbackResult(IdentificationIpcServer.a(paramArrayOfByte), this.b);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationIpcServer.4
 * JD-Core Version:    0.7.0.1
 */