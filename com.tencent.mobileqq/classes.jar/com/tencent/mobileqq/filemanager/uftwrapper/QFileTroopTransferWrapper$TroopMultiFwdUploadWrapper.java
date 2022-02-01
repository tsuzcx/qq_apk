package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTroopFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo;
import java.util.UUID;

class QFileTroopTransferWrapper$TroopMultiFwdUploadWrapper
  extends QFileTroopTransferWrapper.TroopBaseUploadWrapper
{
  final String f;
  final UUID g;
  final String h = "";
  int i = 102;
  final QFileTroopTransferWrapper.ITroopMultiFwdCallback j;
  String k;
  String l;
  String m;
  long n;
  int o;
  int p;
  int q;
  
  public QFileTroopTransferWrapper$TroopMultiFwdUploadWrapper(QQAppInterface paramQQAppInterface, UUID paramUUID, long paramLong, String paramString, QFileTroopTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback, QFileTroopTransferWrapper.ITroopMultiFwdCallback paramITroopMultiFwdCallback)
  {
    super(paramQQAppInterface, paramLong, paramITransferWrapperCallback);
    this.f = paramString;
    this.g = paramUUID;
    this.j = paramITroopMultiFwdCallback;
  }
  
  long a()
  {
    if (this.n == 0L) {
      this.n = FileManagerUtil.h(this.f);
    }
    return this.n;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.b) {
      return;
    }
    if (this.j != null)
    {
      paramIUFTTransferKey = new Bundle();
      paramIUFTTransferKey.putLong("fileSize", this.n);
      paramIUFTTransferKey.putString("strFileId", this.m);
      paramIUFTTransferKey.putString("strMd5", this.k);
      paramIUFTTransferKey.putString("strSha", this.l);
      paramIUFTTransferKey.putInt("width", this.o);
      paramIUFTTransferKey.putInt("height", this.p);
      paramIUFTTransferKey.putInt("duration", this.q);
      paramIUFTTransferKey.putInt("busiId", this.i);
      this.j.a(paramInt, true, paramIUFTTransferKey);
    }
    paramIUFTTransferKey = this.e.a();
    if ((paramIUFTTransferKey instanceof UUID)) {
      this.d.a((UUID)paramIUFTTransferKey);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    this.k = FileHttpUtils.a(paramUFTFileLocalInfo.c());
    this.l = FileHttpUtils.a(paramUFTFileLocalInfo.e());
    this.o = paramUFTFileLocalInfo.f();
    this.p = paramUFTFileLocalInfo.g();
    this.q = paramUFTFileLocalInfo.h();
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.m = paramUFTFileUploadBusinessInfo.a();
    }
    if ((paramUFTFileUploadBusinessInfo instanceof UFTTroopFileUploadBusinessInfo)) {
      this.i = ((UFTTroopFileUploadBusinessInfo)paramUFTFileUploadBusinessInfo).h();
    }
  }
  
  public void c()
  {
    this.b = false;
    UFTTroopUploadInfo localUFTTroopUploadInfo = new UFTTroopUploadInfo();
    localUFTTroopUploadInfo.a(this.f);
    localUFTTroopUploadInfo.a(false);
    localUFTTroopUploadInfo.b(true);
    localUFTTroopUploadInfo.b(String.valueOf(this.c));
    localUFTTroopUploadInfo.a(1);
    localUFTTroopUploadInfo.a(this.g);
    localUFTTroopUploadInfo.b(this.i);
    localUFTTroopUploadInfo.c("");
    localUFTTroopUploadInfo.c(5);
    this.e = ((IUFTTransferService)this.a.getRuntimeService(IUFTTransferService.class, "")).uploadTroopFile(localUFTTroopUploadInfo, b(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper.TroopMultiFwdUploadWrapper
 * JD-Core Version:    0.7.0.1
 */