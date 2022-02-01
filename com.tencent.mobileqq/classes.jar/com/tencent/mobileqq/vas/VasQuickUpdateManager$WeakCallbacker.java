package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import java.lang.ref.WeakReference;

public class VasQuickUpdateManager$WeakCallbacker
  extends CallBacker
{
  private VasQuickUpdateManager mVasQuickUpdateManager;
  private WeakReference<CallBacker> weakReference;
  
  public VasQuickUpdateManager$WeakCallbacker(CallBacker paramCallBacker, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    this.weakReference = new WeakReference(paramCallBacker);
    this.mVasQuickUpdateManager = paramVasQuickUpdateManager;
  }
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    CallBacker localCallBacker = (CallBacker)this.weakReference.get();
    if (localCallBacker != null)
    {
      localCallBacker.callback(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      return;
    }
    this.mVasQuickUpdateManager.removeCallBacker(this);
  }
  
  public boolean isWrapOf(CallBacker paramCallBacker)
  {
    return this.weakReference.get() == paramCallBacker;
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    CallBacker localCallBacker = (CallBacker)this.weakReference.get();
    if (localCallBacker != null) {
      localCallBacker.onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.WeakCallbacker
 * JD-Core Version:    0.7.0.1
 */