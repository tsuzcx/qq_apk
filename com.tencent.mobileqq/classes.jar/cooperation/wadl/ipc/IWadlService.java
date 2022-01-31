package cooperation.wadl.ipc;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IWadlService
  extends IInterface
{
  public abstract void a(IWadlServiceCallBack paramIWadlServiceCallBack);
  
  public abstract void a(String paramString, Bundle paramBundle);
  
  public abstract void b(IWadlServiceCallBack paramIWadlServiceCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.IWadlService
 * JD-Core Version:    0.7.0.1
 */