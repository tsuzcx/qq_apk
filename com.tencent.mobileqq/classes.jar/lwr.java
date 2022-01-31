import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.AVPbInfo;

public abstract class lwr
  extends Binder
  implements lwq
{
  public lwr()
  {
    attachInterface(this, "com.tencent.av.service.IAVServiceForQQ");
  }
  
  public static lwq a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVServiceForQQ");
    if ((localIInterface != null) && ((localIInterface instanceof lwq))) {
      return (lwq)localIInterface;
    }
    return new lws(paramIBinder);
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
      paramParcel2.writeString("com.tencent.av.service.IAVServiceForQQ");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(lwo.a(paramParcel1.readStrongBinder()));
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(paramParcel1.createByteArray());
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      b(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      c(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label292;
        }
      }
      for (paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        bool = false;
        break;
      }
    case 6: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel2, paramParcel1);
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      paramInt1 = a(paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(paramParcel1.readString());
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      paramParcel1 = a(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a();
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      b();
      paramParcel2.writeNoException();
      return true;
    case 14: 
      label292:
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      a(bool);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
    c();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lwr
 * JD-Core Version:    0.7.0.1
 */