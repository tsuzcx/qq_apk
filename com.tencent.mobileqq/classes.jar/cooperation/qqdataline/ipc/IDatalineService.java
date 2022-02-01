package cooperation.qqdataline.ipc;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IDatalineService
  extends IInterface
{
  public abstract Bundle a(String paramString, Bundle paramBundle);
  
  public abstract void b(String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.ipc.IDatalineService
 * JD-Core Version:    0.7.0.1
 */