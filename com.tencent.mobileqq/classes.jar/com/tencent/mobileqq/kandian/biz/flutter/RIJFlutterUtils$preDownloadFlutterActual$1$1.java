package com.tencent.mobileqq.kandian.biz.flutter;

import com.tencent.mobileqq.flutter.download.InstallCallback;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/flutter/RIJFlutterUtils$preDownloadFlutterActual$1$1", "Lcom/tencent/mobileqq/flutter/download/InstallCallback;", "onProgress", "", "progress", "", "onResult", "success", "", "installDir", "", "isEngineExist", "isAppExist", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFlutterUtils$preDownloadFlutterActual$1$1
  implements InstallCallback
{
  public void onProgress(int paramInt) {}
  
  public void onResult(boolean paramBoolean1, @Nullable String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramString = new StringBuilder();
    paramString.append("#preDownloadFlutterActual: onResult, success=");
    paramString.append(paramBoolean1);
    paramString.append(", ");
    paramString.append("isEnginExist=");
    paramString.append(paramBoolean2);
    paramString.append(", isAppExist=");
    paramString.append(paramBoolean3);
    QLog.d("RIJFlutterUtils", 1, paramString.toString());
    if (paramBoolean1) {
      MxFlutterResourceLoader.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils.preDownloadFlutterActual.1.1
 * JD-Core Version:    0.7.0.1
 */