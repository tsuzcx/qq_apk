package com.tencent.mobileqq.pic;

import android.os.RemoteException;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class PresendPicMgr$PresendReq
{
  public int a;
  public CompressInfo a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  
  public PresendPicMgr$PresendReq(PresendPicMgr paramPresendPicMgr, CompressInfo paramCompressInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("__");
    localStringBuilder.append(UUID.randomUUID().toString());
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call start,current PresendReq is ");
    localStringBuilder.append(this);
    Logger.a("PresendPicMgr", "PresendReq.compressAndUploadPic", localStringBuilder.toString());
    long l = System.nanoTime();
    if (this.jdField_a_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PresendStatus: srcPah:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
      localStringBuilder.append(",destPath:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
      localStringBuilder.append(",uuid:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ,canceled:true, peakCompress:false, peakUpload:false");
      Logger.a("PresendPicMgr", "compressAndUploadPic ", localStringBuilder.toString());
      return;
    }
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("PresendStatus: srcPah:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
    localStringBuilder.append(",destPath:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(",uuid:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",canceled:false,peakCompress:true,peakUpload:false");
    Logger.a("PresendPicMgr", "compressAndUploadPic ", localStringBuilder.toString());
    l = (System.nanoTime() - l) / 1000000L;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Process peak,[#]compress, cost= ");
    localStringBuilder.append(l);
    Logger.a("PresendPicMgr", "PresendReq.compressAndUploadPic", localStringBuilder.toString());
    b();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("call end,current PresendReq is ");
    localStringBuilder.append(this);
    Logger.a("PresendPicMgr", "PresendReq.compressAndUploadPic", localStringBuilder.toString());
  }
  
  public void a(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current PresendReq is ");
      localStringBuilder.append(this);
      Logger.a("PresendPicMgr", "PresendReq.cancel", localStringBuilder.toString());
      this.jdField_a_of_type_Boolean = true;
      boolean bool = this.jdField_b_of_type_Boolean;
      if (bool)
      {
        try
        {
          Logger.a("PresendPicMgr", "PresendReq.cancel", "call cancelUpload");
          PresendPicMgr.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr).a(this.jdField_a_of_type_JavaLangString, paramInt);
        }
        catch (RemoteException localRemoteException)
        {
          if (!QLog.isColorLevel()) {
            break label107;
          }
        }
        QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
      }
      else
      {
        Logger.a("PresendPicMgr", "PresendReq.cancel", "mIsUpload is false,no need to call cancelUpload");
      }
      label107:
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current PresendReq is ");
      localStringBuilder.append(this);
      Logger.a("PresendPicMgr", "PresendReq.uploadPic", localStringBuilder.toString());
      if (this.jdField_a_of_type_Boolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PresendStatus: srcPah:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
        localStringBuilder.append(",destPath:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
        localStringBuilder.append(",uuid:");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" ,canceled:true, peakCompress:true, peakUpload:false");
        Logger.a("PresendPicMgr", "uploadPic ", localStringBuilder.toString());
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString == null)
      {
        Logger.b("PresendPicMgr", "PresendReq.uploadPic", "mCompressInfo.destPath == null! ");
        return;
      }
      try
      {
        PresendPicMgr.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr).a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_b_of_type_Boolean = true;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PresendStatus: srcPah:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
        localStringBuilder.append(",destPath:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
        localStringBuilder.append(",uuid:");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" ,canceled:false, peakCompress:true, peakUpload:true");
        Logger.a("PresendPicMgr", "uploadPic ", localStringBuilder.toString());
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
        }
      }
      Logger.a("PresendPicMgr", "PresendReq.uploadPic", "call end");
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPresendReq");
    localStringBuilder.append("\n|-");
    localStringBuilder.append("localUUID:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("mIsCancel:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("mIsUpload:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("mCompressInfo:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendReq
 * JD-Core Version:    0.7.0.1
 */