package com.tencent.mobileqq.flutter.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.flutter.download.InstallCallback;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

class FlutterMainQIPCModule$1
  implements InstallCallback
{
  FlutterMainQIPCModule$1(FlutterMainQIPCModule paramFlutterMainQIPCModule, String paramString1, String paramString2) {}
  
  public void onProgress(int paramInt) {}
  
  public void onResult(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    QLog.d("FlutterMainQIPCModule", 1, String.format("onResult, isSuccess: %s, installDir: %s, isEngineExist: %s, isAppExist: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("KEY_INSTALL_RESULT", paramBoolean1);
    localBundle.putString("KEY_INSTALL_DIR", paramString);
    localBundle.putBoolean("KEY_IS_APP_EXIST", paramBoolean3);
    localBundle.putBoolean("KEY_IS_ENGINE_EXIST", paramBoolean2);
    localBundle.putString("KEY_QFLUTTER_VERSION", QFlutterInstaller.a());
    QIPCServerHelper.getInstance().callClient(this.a, "FlutterSubQIPCModule", this.b, localBundle, new FlutterMainQIPCModule.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.ipc.FlutterMainQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */