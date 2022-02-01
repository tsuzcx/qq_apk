package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import android.os.Message;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.debug.Debugger.IDebugCallback;
import java.lang.ref.WeakReference;

final class TdsDebugView$CallbackImpl
  implements Debugger.IDebugCallback
{
  private final WeakReference<TdsDebugView> a;
  
  private TdsDebugView$CallbackImpl(TdsDebugView paramTdsDebugView)
  {
    this.a = new WeakReference(paramTdsDebugView);
  }
  
  public void onCleanCache(String paramString, int paramInt)
  {
    Log.d("TdsDebugView", "onCleanCache: m=" + paramString + ", r=" + paramInt);
    TdsDebugView localTdsDebugView = (TdsDebugView)this.a.get();
    if (localTdsDebugView == null) {
      return;
    }
    Message.obtain(TdsDebugView.a(localTdsDebugView), 3, paramInt, 0, paramString).sendToTarget();
  }
  
  public void onCleanPlugin(String paramString, int paramInt)
  {
    Log.d("TdsDebugView", "onCleanPlugin: m=" + paramString + ", r=" + paramInt);
    TdsDebugView localTdsDebugView = (TdsDebugView)this.a.get();
    if (localTdsDebugView == null) {
      return;
    }
    Message.obtain(TdsDebugView.a(localTdsDebugView), 1, paramInt, 0, paramString).sendToTarget();
  }
  
  public void onUpgradePlugin(String paramString, int paramInt)
  {
    Log.d("TdsDebugView", "onUpgradePlugin: m=" + paramString + ", r=" + paramInt);
    TdsDebugView localTdsDebugView = (TdsDebugView)this.a.get();
    if (localTdsDebugView == null) {
      return;
    }
    Message.obtain(TdsDebugView.a(localTdsDebugView), 2, paramInt, 0, paramString).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsDebugView.CallbackImpl
 * JD-Core Version:    0.7.0.1
 */