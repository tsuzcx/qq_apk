import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class rbg
  extends Binder
  implements rbf
{
  public rbg()
  {
    attachInterface(this, "com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
  }
  
  public static rbf a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
    if ((localIInterface != null) && ((localIInterface instanceof rbf))) {
      return (rbf)localIInterface;
    }
    return new rbh(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      bool = a();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      b(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = d();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      a(bool, paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      b(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      bool = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      c(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = e();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      a(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = f();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramParcel1 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = g();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      d(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = h();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), rbj.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      bool = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      c(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      bool = b();
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      bool = c();
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      bool = d();
      paramParcel2.writeNoException();
      paramInt1 = i1;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramParcel1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = i();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = j();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = k();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      paramInt1 = l();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
    a(rbm.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbg
 * JD-Core Version:    0.7.0.1
 */