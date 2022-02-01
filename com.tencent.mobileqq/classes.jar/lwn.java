import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.AVRedPacketConfig;

public abstract class lwn
  extends Binder
  implements lwm
{
  public lwn()
  {
    attachInterface(this, "com.tencent.av.service.IAVRedPacketCallback");
  }
  
  public static lwm a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVRedPacketCallback");
    if ((localIInterface != null) && ((localIInterface instanceof lwm))) {
      return (lwm)localIInterface;
    }
    return new lwo(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.av.service.IAVRedPacketCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVRedPacketCallback");
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label109;
        }
      }
      label109:
      for (paramParcel1 = (AVRedPacketConfig)AVRedPacketConfig.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(bool, paramParcel1);
        return true;
        bool = false;
        break;
      }
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IAVRedPacketCallback");
    if (paramParcel1.readInt() != 0) {
      bool = true;
    }
    a(bool, paramParcel1.readString(), paramParcel1.readString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lwn
 * JD-Core Version:    0.7.0.1
 */