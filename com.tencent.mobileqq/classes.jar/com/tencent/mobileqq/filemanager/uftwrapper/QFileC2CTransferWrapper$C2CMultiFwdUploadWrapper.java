package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.UFTC2CUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;

class QFileC2CTransferWrapper$C2CMultiFwdUploadWrapper
  extends QFileC2CTransferWrapper.C2CBaseUploadWrapper
{
  final QFileC2CTransferWrapper.IC2CMultiFwdCallback f;
  final QFileC2CTransferWrapper.C2CFileMultiFwdInfo g;
  final long h;
  final long i;
  String j;
  String k;
  String l;
  int m;
  int n;
  int o;
  
  public QFileC2CTransferWrapper$C2CMultiFwdUploadWrapper(QFileC2CTransferWrapper paramQFileC2CTransferWrapper, QQAppInterface paramQQAppInterface, long paramLong, QFileC2CTransferWrapper.C2CFileMultiFwdInfo paramC2CFileMultiFwdInfo, QFileC2CTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback, QFileC2CTransferWrapper.IC2CMultiFwdCallback paramIC2CMultiFwdCallback)
  {
    super(paramQQAppInterface, paramITransferWrapperCallback);
    this.f = paramIC2CMultiFwdCallback;
    this.g = paramC2CFileMultiFwdInfo;
    this.h = paramLong;
    this.i = FileManagerUtil.h(paramC2CFileMultiFwdInfo.a);
    this.e = QFileAssistantUtils.a(paramC2CFileMultiFwdInfo.c);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.b) {
      return;
    }
    if (this.f != null)
    {
      paramIUFTTransferKey = new Bundle();
      paramIUFTTransferKey.putString("strFileId", this.j);
      paramIUFTTransferKey.putString("str10MMd5", this.k);
      paramIUFTTransferKey.putString("strSha", this.l);
      paramIUFTTransferKey.putInt("width", this.m);
      paramIUFTTransferKey.putInt("height", this.n);
      paramIUFTTransferKey.putInt("duration", this.o);
      this.f.a(paramInt, true, paramIUFTTransferKey);
    }
    paramIUFTTransferKey = this.d.a();
    if ((paramIUFTTransferKey instanceof Long)) {
      this.c.a(((Long)paramIUFTTransferKey).longValue());
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    this.k = FileHttpUtils.a(paramUFTFileLocalInfo.b());
    this.l = FileHttpUtils.a(paramUFTFileLocalInfo.e());
    this.m = paramUFTFileLocalInfo.f();
    this.n = paramUFTFileLocalInfo.g();
    this.o = paramUFTFileLocalInfo.h();
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.j = paramUFTFileUploadBusinessInfo.a();
    }
  }
  
  long b()
  {
    return this.i;
  }
  
  void c()
  {
    this.b = false;
    UFTC2CUploadInfo localUFTC2CUploadInfo = new UFTC2CUploadInfo();
    localUFTC2CUploadInfo.a(this.g.a);
    localUFTC2CUploadInfo.a(false);
    localUFTC2CUploadInfo.b(true);
    localUFTC2CUploadInfo.b(this.g.c);
    localUFTC2CUploadInfo.a(this.g.b);
    localUFTC2CUploadInfo.a(this.g.d);
    localUFTC2CUploadInfo.a(this.g.e);
    localUFTC2CUploadInfo.c(this.g.f);
    localUFTC2CUploadInfo.a(Long.valueOf(this.h));
    this.d = ((IUFTTransferService)this.a.getRuntimeService(IUFTTransferService.class, "")).uploadC2CFile(localUFTC2CUploadInfo, a(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.C2CMultiFwdUploadWrapper
 * JD-Core Version:    0.7.0.1
 */