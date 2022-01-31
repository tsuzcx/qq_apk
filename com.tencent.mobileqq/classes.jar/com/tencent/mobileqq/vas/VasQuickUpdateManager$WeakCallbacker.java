package com.tencent.mobileqq.vas;

import java.lang.ref.WeakReference;

public class VasQuickUpdateManager$WeakCallbacker
  extends VasQuickUpdateManager.CallBacker
{
  private WeakReference<VasQuickUpdateManager.CallBacker> weakReference;
  
  public VasQuickUpdateManager$WeakCallbacker(VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    this.weakReference = new WeakReference(paramCallBacker);
  }
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    VasQuickUpdateManager.CallBacker localCallBacker = (VasQuickUpdateManager.CallBacker)this.weakReference.get();
    if (localCallBacker != null)
    {
      localCallBacker.callback(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramVasQuickUpdateManager);
      return;
    }
    paramVasQuickUpdateManager.removeCallBacker(this);
  }
  
  public boolean isWrapOf(VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    return this.weakReference.get() == paramCallBacker;
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    VasQuickUpdateManager.CallBacker localCallBacker = (VasQuickUpdateManager.CallBacker)this.weakReference.get();
    if (localCallBacker != null) {
      localCallBacker.onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.WeakCallbacker
 * JD-Core Version:    0.7.0.1
 */