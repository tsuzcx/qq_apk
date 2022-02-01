package com.tencent.tbs.one.impl.loader;

import android.os.Bundle;
import com.tencent.tbs.one.impl.common.CoreThreadCallback;
import com.tencent.tbs.one.impl.common.DEPSConfig;

class ComponentLoader$1
  extends CoreThreadCallback<DEPSConfig>
{
  ComponentLoader$1(ComponentLoader paramComponentLoader, Bundle paramBundle) {}
  
  public void onCompleted(DEPSConfig paramDEPSConfig)
  {
    ComponentLoader.access$000(this.this$0, this.val$options, paramDEPSConfig);
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    ComponentLoader.access$100(this.this$0, paramInt, paramString, paramThrowable);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(paramInt2, 0, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.ComponentLoader.1
 * JD-Core Version:    0.7.0.1
 */