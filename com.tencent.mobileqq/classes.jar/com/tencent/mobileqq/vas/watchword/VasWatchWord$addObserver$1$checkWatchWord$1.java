package com.tencent.mobileqq.vas.watchword;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class VasWatchWord$addObserver$1$checkWatchWord$1
  implements EIPCResultCallback
{
  public static final 1 a = new 1();
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null) {}
    for (Bundle localBundle = paramEIPCResult.data; localBundle == null; localBundle = null) {
      return;
    }
    int i = paramEIPCResult.data.getInt("ret");
    VasWatchWord.a.b();
    new Handler(Looper.getMainLooper()).post((Runnable)new VasWatchWord.addObserver.1.checkWatchWord.1.1(paramEIPCResult, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.watchword.VasWatchWord.addObserver.1.checkWatchWord.1
 * JD-Core Version:    0.7.0.1
 */