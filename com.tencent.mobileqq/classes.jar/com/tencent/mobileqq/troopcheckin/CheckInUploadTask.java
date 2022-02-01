package com.tencent.mobileqq.troopcheckin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public abstract class CheckInUploadTask
{
  int jdField_a_of_type_Int;
  protected ITransactionCallback a;
  protected Transaction a;
  CheckInResEntity jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInResEntity;
  public String a;
  protected boolean a;
  protected String b;
  
  public CheckInUploadTask(CheckInResEntity paramCheckInResEntity, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqHighwayApiITransactionCallback = new CheckInUploadTask.1(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInResEntity = paramCheckInResEntity;
  }
  
  protected QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public abstract void a();
  
  protected boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uploadPic path= ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqHighwayApiITransactionCallback;
    Object localObject1 = a();
    if (localObject1 != null)
    {
      String str = ((QQAppInterface)localObject1).getCurrentUin();
      byte[] arrayOfByte = ARCloudFileUpload.a(paramString);
      if (arrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "uploadPic md5 null ");
        }
        return false;
      }
      Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
      localCommFileExtReq.uint32_action_type.set(0);
      localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramString = new Transaction(str, 75, paramString, 0, arrayOfByte, (ITransactionCallback)localObject2, localCommFileExtReq.toByteArray(), false);
      int i = ((QQAppInterface)localObject1).getHwEngine().submitTransactionTask(paramString);
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = paramString;
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramString = this.jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("uploadPic submitTransactionTask  retCode= ");
        ((StringBuilder)localObject1).append(i);
        QLog.d(paramString, 2, ((StringBuilder)localObject1).toString());
      }
    }
    return false;
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onFailed ");
    }
    c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopcheckin.CheckInUploadTask
 * JD-Core Version:    0.7.0.1
 */