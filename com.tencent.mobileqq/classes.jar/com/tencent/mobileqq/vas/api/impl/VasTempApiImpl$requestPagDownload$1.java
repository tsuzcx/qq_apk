package com.tencent.mobileqq.vas.api.impl;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.mobileqq.vas.ui.PagViewProxy;
import com.tencent.mobileqq.vas.ui.PagViewProxy.Companion;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/api/impl/VasTempApiImpl$requestPagDownload$1", "Lcom/tencent/aelight/camera/download/api/IAEDownloadCallBack;", "onAEDownloadFinish", "", "aeResInfo", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "localFilePath", "", "downloaded", "", "errorType", "", "onAEProgressUpdate", "currentOffset", "", "totalLength", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasTempApiImpl$requestPagDownload$1
  implements IAEDownloadCallBack
{
  VasTempApiImpl$requestPagDownload$1(Function0 paramFunction0) {}
  
  public void onAEDownloadFinish(@Nullable AEResInfo paramAEResInfo, @Nullable String paramString, boolean paramBoolean, int paramInt)
  {
    if ((Intrinsics.areEqual(paramAEResInfo, AEResInfo.LIGHT_RES_BASE_PACKAGE) ^ true)) {
      return;
    }
    paramAEResInfo = PagViewProxy.d.a();
    paramString = new StringBuilder();
    paramString.append("onAEDownloadFinish : downloaded : ");
    paramString.append(paramBoolean);
    paramString.append("errorType : ");
    paramString.append(paramInt);
    QLog.i(paramAEResInfo, 1, paramString.toString());
    this.a.invoke();
  }
  
  public void onAEProgressUpdate(@Nullable AEResInfo paramAEResInfo, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasTempApiImpl.requestPagDownload.1
 * JD-Core Version:    0.7.0.1
 */