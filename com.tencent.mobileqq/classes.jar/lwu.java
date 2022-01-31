import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;

public abstract class lwu
  extends Binder
  implements lwt
{
  public lwu()
  {
    attachInterface(this, "com.tencent.av.service.IQQServiceCallback");
  }
  
  public static lwt a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IQQServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof lwt))) {
      return (lwt)localIInterface;
    }
    return new lwv(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Bundle localBundle = null;
    String str = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.av.service.IQQServiceCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
      paramParcel2 = str;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (RecvMsg)RecvMsg.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
      a((RecvGVideoLevelInfo[])paramParcel1.createTypedArray(RecvGVideoLevelInfo.CREATOR));
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool, paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
      str = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {
        localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a(str, paramInt1, paramInt2, localBundle);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
    a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lwu
 * JD-Core Version:    0.7.0.1
 */