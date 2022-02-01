package cooperation.smartdevice.ipc;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface ISmartDeviceService
  extends IInterface
{
  public abstract Bundle a(String paramString, Bundle paramBundle);
  
  public abstract void b(String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.smartdevice.ipc.ISmartDeviceService
 * JD-Core Version:    0.7.0.1
 */