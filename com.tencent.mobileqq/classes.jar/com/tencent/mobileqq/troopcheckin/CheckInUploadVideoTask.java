package com.tencent.mobileqq.troopcheckin;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;

public class CheckInUploadVideoTask
  extends CheckInUploadTask
{
  protected String h;
  protected boolean i = false;
  protected Transaction j;
  private ITransactionCallback k = new CheckInUploadVideoTask.1(this);
  
  public CheckInUploadVideoTask(CheckInResEntity paramCheckInResEntity, int paramInt)
  {
    super(paramCheckInResEntity, paramInt);
  }
  
  public void a()
  {
    String str1 = this.a.b;
    String str2 = this.a.a;
    boolean bool2 = a(str1);
    boolean bool1;
    if (bool2) {
      bool1 = b(str2);
    } else {
      bool1 = false;
    }
    if ((bool2) && (bool1)) {
      return;
    }
    e();
  }
  
  public void b()
  {
    if ((this.e) && (this.i)) {
      c();
    }
  }
  
  protected boolean b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uploadVideo path= ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.k;
    Object localObject1 = f();
    if (localObject1 != null)
    {
      String str = ((QQAppInterface)localObject1).getCurrentUin();
      byte[] arrayOfByte = ARCloudFileUpload.a(paramString);
      File localFile = new File(paramString);
      if (arrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "uploadVideo md5 null ");
        }
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = this.b;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("uploadVideo,file length ");
        ((StringBuilder)localObject4).append(new File(paramString).length());
        QLog.d((String)localObject3, 1, ((StringBuilder)localObject4).toString());
      }
      Object localObject3 = new PttShortVideo.PttShortVideoUploadReq();
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).setHasFlag(true);
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).uint64_fromuin.set(Long.parseLong(str));
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).uint64_touin.set(Long.parseLong(str));
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).uint32_chat_type.set(1);
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).uint32_client_type.set(1);
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).uint64_group_code.set(Long.parseLong(str));
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).uint32_agent_type.set(0);
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).uint32_business_type.set(3001);
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).uint32_flag_support_large_size.set(1);
      Object localObject4 = new PttShortVideo.PttShortVideoFileInfo();
      ((PttShortVideo.PttShortVideoFileInfo)localObject4).str_file_name.set(localFile.getName());
      ((PttShortVideo.PttShortVideoFileInfo)localObject4).bytes_file_md5.set(ByteStringMicro.copyFrom(arrayOfByte));
      ((PttShortVideo.PttShortVideoFileInfo)localObject4).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(arrayOfByte));
      ((PttShortVideo.PttShortVideoFileInfo)localObject4).uint64_file_size.set(localFile.length());
      ((PttShortVideo.PttShortVideoFileInfo)localObject4).uint32_file_res_length.set(0);
      ((PttShortVideo.PttShortVideoFileInfo)localObject4).uint32_file_res_width.set(0);
      ((PttShortVideo.PttShortVideoFileInfo)localObject4).uint32_file_format.set(3);
      ((PttShortVideo.PttShortVideoFileInfo)localObject4).uint32_file_time.set((int)this.a.c);
      ((PttShortVideo.PttShortVideoFileInfo)localObject4).uint64_thumb_file_size.set(0L);
      ((PttShortVideo.PttShortVideoUploadReq)localObject3).msg_PttShortVideoFileInfo.set((MessageMicro)localObject4);
      paramString = new Transaction(str, 74, paramString, 0, arrayOfByte, (ITransactionCallback)localObject2, ((PttShortVideo.PttShortVideoUploadReq)localObject3).toByteArray(), false);
      int m = ((QQAppInterface)localObject1).getHwEngine().submitTransactionTask(paramString);
      if (m == 0)
      {
        this.j = paramString;
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramString = this.b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("uploadVideo submitTransactionTask  retCode= ");
        ((StringBuilder)localObject1).append(m);
        QLog.d(paramString, 2, ((StringBuilder)localObject1).toString());
      }
    }
    return false;
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    boolean bool = true;
    localBundle.putInt("isVideo", 1);
    if ((this.d != null) && (this.h != null))
    {
      localBundle.putInt("result", 1);
      localBundle.putString("url", this.d);
      localBundle.putString("vid", this.h);
    }
    else
    {
      localBundle.putInt("result", 0);
      localBundle.putString("error", "");
      bool = false;
    }
    CheckInServer.a().a(bool, this.c, localBundle);
  }
  
  public void d()
  {
    if (this.f != null) {
      this.f.cancelTransaction();
    }
    Transaction localTransaction = this.j;
    if (localTransaction != null) {
      localTransaction.cancelTransaction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopcheckin.CheckInUploadVideoTask
 * JD-Core Version:    0.7.0.1
 */