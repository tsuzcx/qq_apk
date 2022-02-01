package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;

class QFileDiscTransferWrapper$DiscMultiFwdUploadWrapper
  extends QFileDiscTransferWrapper.DiscBaseUploadWrapper
{
  String e;
  String f;
  final long g;
  final QFileDiscTransferWrapper.IDiscMultiFwdCallback h;
  String i;
  String j;
  String k;
  int l;
  int m;
  int n;
  
  QFileDiscTransferWrapper$DiscMultiFwdUploadWrapper(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, QFileDiscTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback, QFileDiscTransferWrapper.IDiscMultiFwdCallback paramIDiscMultiFwdCallback)
  {
    super(paramQQAppInterface, paramITransferWrapperCallback);
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramLong;
    this.h = paramIDiscMultiFwdCallback;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.b) {
      return;
    }
    if (this.h != null)
    {
      paramIUFTTransferKey = new Bundle();
      paramIUFTTransferKey.putString("strFileId", this.i);
      paramIUFTTransferKey.putString("str10MMd5", this.j);
      paramIUFTTransferKey.putString("strSha", this.k);
      paramIUFTTransferKey.putInt("width", this.l);
      paramIUFTTransferKey.putInt("height", this.m);
      paramIUFTTransferKey.putInt("duration", this.n);
      this.h.a(paramInt, true, paramIUFTTransferKey);
    }
    paramIUFTTransferKey = this.d.a();
    if ((paramIUFTTransferKey instanceof Long)) {
      this.c.a(((Long)paramIUFTTransferKey).longValue());
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    this.j = FileHttpUtils.a(paramUFTFileLocalInfo.b());
    this.k = FileHttpUtils.a(paramUFTFileLocalInfo.e());
    this.l = paramUFTFileLocalInfo.f();
    this.m = paramUFTFileLocalInfo.g();
    this.n = paramUFTFileLocalInfo.h();
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.i = paramUFTFileUploadBusinessInfo.a();
    }
  }
  
  void b()
  {
    this.b = false;
    UFTDiscUploadInfo localUFTDiscUploadInfo = new UFTDiscUploadInfo();
    localUFTDiscUploadInfo.a(this.e);
    localUFTDiscUploadInfo.a(false);
    localUFTDiscUploadInfo.b(true);
    localUFTDiscUploadInfo.b(this.f);
    localUFTDiscUploadInfo.a(3000);
    localUFTDiscUploadInfo.a(Long.valueOf(this.g));
    this.d = ((IUFTTransferService)this.a.getRuntimeService(IUFTTransferService.class, "")).uploadDiscFile(localUFTDiscUploadInfo, a(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.DiscMultiFwdUploadWrapper
 * JD-Core Version:    0.7.0.1
 */