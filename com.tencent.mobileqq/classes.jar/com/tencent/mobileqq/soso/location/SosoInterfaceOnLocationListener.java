package com.tencent.mobileqq.soso.location;

import android.os.SystemClock;
import android.util.AndroidRuntimeException;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

public abstract class SosoInterfaceOnLocationListener
{
  protected boolean askGPS = false;
  protected String callerRoute;
  protected long geoCacheInterval;
  protected long globalCacheInterval;
  protected boolean goonListener = false;
  public boolean isRemoved = false;
  protected int level;
  protected long levelCacheInterval;
  protected long maxCacheInterval;
  protected int maxFailCount = 3;
  protected boolean reqLocation = false;
  public boolean requesting = false;
  protected long sTime;
  protected String tag;
  protected boolean uiThread;
  
  public SosoInterfaceOnLocationListener(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 3) && (paramInt != 4))
    {
      paramString = new StringBuilder();
      paramString.append("invalid level=");
      paramString.append(paramInt);
      throw new AndroidRuntimeException(paramString.toString());
    }
    this.tag = paramString;
    this.level = paramInt;
    this.askGPS = paramBoolean2;
    this.reqLocation = paramBoolean1;
    this.goonListener = paramBoolean4;
    this.uiThread = paramBoolean3;
    this.maxCacheInterval = paramLong;
    this.sTime = SystemClock.elapsedRealtime();
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2) {}
  
  public abstract void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo);
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
 * JD-Core Version:    0.7.0.1
 */