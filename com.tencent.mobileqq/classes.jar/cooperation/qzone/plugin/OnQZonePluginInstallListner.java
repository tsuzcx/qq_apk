package cooperation.qzone.plugin;

import android.os.IInterface;

public abstract interface OnQZonePluginInstallListner
  extends IInterface
{
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, float paramFloat, long paramLong);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.OnQZonePluginInstallListner
 * JD-Core Version:    0.7.0.1
 */