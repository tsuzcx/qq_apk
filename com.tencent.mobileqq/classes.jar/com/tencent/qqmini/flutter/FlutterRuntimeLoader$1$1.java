package com.tencent.qqmini.flutter;

import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;

class FlutterRuntimeLoader$1$1
  implements TissueEnv
{
  FlutterRuntimeLoader$1$1(FlutterRuntimeLoader.1 param1, String paramString) {}
  
  public String getNativeLibDir()
  {
    if (TissueGlobal.verifyTissueEngine(this.val$nativeLibDir)) {
      return this.val$nativeLibDir;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.flutter.FlutterRuntimeLoader.1.1
 * JD-Core Version:    0.7.0.1
 */