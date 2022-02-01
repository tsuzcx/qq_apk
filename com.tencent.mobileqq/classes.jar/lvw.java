import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class lvw
  extends Binder
  implements lvv
{
  public static lvv a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof lvv))) {
      return (lvv)localIInterface;
    }
    return new lvx(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.av.service.IAVServiceCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceCallback");
    a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lvw
 * JD-Core Version:    0.7.0.1
 */