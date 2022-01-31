import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.android.internal.telephony.ISms;
import com.android.internal.telephony.SmsRawData;
import java.util.ArrayList;
import java.util.List;

public class e
  implements ISms
{
  private IBinder a;
  
  public e(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public List a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArrayList localArrayList = localParcel2.createTypedArrayList(SmsRawData.CREATOR);
      return localArrayList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeInt(paramInt);
        localParcel1.writeByteArray(paramArrayOfByte);
        if (paramPendingIntent1 != null)
        {
          localParcel1.writeInt(1);
          paramPendingIntent1.writeToParcel(localParcel1, 0);
          if (paramPendingIntent2 != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent2.writeToParcel(localParcel1, 0);
            this.a.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeString(paramString3);
        if (paramPendingIntent1 != null)
        {
          localParcel1.writeInt(1);
          paramPendingIntent1.writeToParcel(localParcel1, 0);
          if (paramPendingIntent2 != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent2.writeToParcel(localParcel1, 0);
            this.a.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, List paramList1, List paramList2, List paramList3)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeStringList(paramList1);
      localParcel1.writeTypedList(paramList2);
      localParcel1.writeTypedList(paramList3);
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
      localParcel1.writeInt(paramInt);
      this.a.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      if (paramInt != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt1 = localParcel2.readInt();
      if (paramInt1 != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
      localParcel1.writeInt(paramInt);
      localParcel1.writeByteArray(paramArrayOfByte1);
      localParcel1.writeByteArray(paramArrayOfByte2);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      if (paramInt != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
      localParcel1.writeInt(paramInt);
      this.a.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      if (paramInt != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     e
 * JD-Core Version:    0.7.0.1
 */