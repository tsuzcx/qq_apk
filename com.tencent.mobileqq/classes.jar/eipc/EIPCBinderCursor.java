package eipc;

import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;

class EIPCBinderCursor
  extends MatrixCursor
{
  public static final String KEY_BINDER = "EIPCBinderCursor";
  Bundle mBinderExtra = new Bundle();
  
  public EIPCBinderCursor(String[] paramArrayOfString, IBinder paramIBinder)
  {
    super(paramArrayOfString);
    if (paramIBinder != null)
    {
      paramArrayOfString = new EIPCBinderCursor.BinderParcelable(paramIBinder);
      this.mBinderExtra.putParcelable("EIPCBinderCursor", paramArrayOfString);
    }
  }
  
  public Bundle getExtras()
  {
    return this.mBinderExtra;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCBinderCursor
 * JD-Core Version:    0.7.0.1
 */