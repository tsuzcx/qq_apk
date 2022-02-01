package com.tencent.mobileqq.vas.ui;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/ui/VasPagView$MyLoader$doLoad$1", "Ldov/com/qq/im/ae/download/AEResManager$AEDownloadCallBack;", "onAEDownloadFinish", "", "aeResInfo", "Ldov/com/qq/im/ae/download/AEResInfo;", "localFilePath", "", "downloaded", "", "errorType", "", "onAEProgressUpdate", "currentOffset", "", "totalLength", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasPagView$MyLoader$doLoad$1
  implements AEResManager.AEDownloadCallBack
{
  VasPagView$MyLoader$doLoad$1(Function0 paramFunction0) {}
  
  public void onAEDownloadFinish(@Nullable AEResInfo paramAEResInfo, @Nullable String paramString, boolean paramBoolean, int paramInt)
  {
    QLog.e(VasPagView.b(), 1, "onAEDownloadFinish : downloaded : " + paramBoolean + "errorType : " + paramInt);
    if ((VasPagView.MyLoader.a(this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView$MyLoader)) || ((Intrinsics.areEqual(paramAEResInfo, AEResInfo.c) ^ true)) || (!paramBoolean)) {
      return;
    }
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0.invoke();
  }
  
  public void onAEProgressUpdate(@Nullable AEResInfo paramAEResInfo, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasPagView.MyLoader.doLoad.1
 * JD-Core Version:    0.7.0.1
 */