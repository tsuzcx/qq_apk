package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.nativevue.NativeVueEngine.DomResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaUtils;

class NativeVueLoaderManager$NVDomResultProxy
  implements NativeVueEngine.DomResult, Runnable
{
  private NativeVueEngine.DomResult a;
  private volatile boolean b;
  private String c;
  private long d;
  
  public NativeVueLoaderManager$NVDomResultProxy(NativeVueLoaderManager paramNativeVueLoaderManager, NativeVueEngine.DomResult paramDomResult, String paramString)
  {
    this.a = paramDomResult;
    this.c = paramString;
    NativeVueLoaderManager.a(paramNativeVueLoaderManager).postDelayed(this, 1300L);
    this.d = System.currentTimeMillis();
  }
  
  public void onResult(String paramString)
  {
    if (this.b)
    {
      QLog.e("NativeVueLoaderManager", 1, "waiting native vue timeout");
      return;
    }
    this.b = true;
    long l1 = System.currentTimeMillis();
    long l2 = this.d;
    NativeVueLoaderManager.a(this.this$0).removeCallbacks(this);
    NativeVueEngine.DomResult localDomResult = this.a;
    if (localDomResult != null) {
      localDomResult.onResult(paramString);
    }
    NativeVueLoaderManager.a(this.this$0, l1 - l2, this.c);
    if (!TextUtils.isEmpty(paramString)) {
      paramString = "1";
    } else {
      paramString = "2";
    }
    ViolaUtils.reportNVProcess(paramString, this.c);
    NativeVueLoaderManager.a(this.this$0, null);
  }
  
  public void run()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    Object localObject = this.a;
    if (localObject != null) {
      ((NativeVueEngine.DomResult)localObject).onResult("");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("NativeVue create Dom timeout, url: ");
    ((StringBuilder)localObject).append(this.c);
    QLog.e("NativeVueLoaderManager", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.NativeVueLoaderManager.NVDomResultProxy
 * JD-Core Version:    0.7.0.1
 */