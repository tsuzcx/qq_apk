package com.tencent.shadow.proguard;

import android.os.Binder;
import android.os.Parcel;
import com.tencent.shadow.dynamic.host.FailedException;
import com.tencent.shadow.dynamic.host.MultiLoaderPluginProcessService;
import com.tencent.shadow.dynamic.host.PpsStatus;

public class m
  extends Binder
{
  public static final String a = m.class.getName();
  private final MultiLoaderPluginProcessService b;
  
  public m(MultiLoaderPluginProcessService paramMultiLoaderPluginProcessService)
  {
    this.b = paramMultiLoaderPluginProcessService;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    String str;
    switch (paramInt1)
    {
    default: 
      return false;
    case 1598968902: 
      paramParcel2.writeString(a);
      return true;
    case 1: 
      paramParcel1.enforceInterface(a);
      str = paramParcel1.readString();
      paramParcel1 = paramParcel1.readString();
      try
      {
        this.b.a(str, paramParcel1);
        paramParcel2.writeInt(0);
        return true;
      }
      catch (FailedException paramParcel1)
      {
        for (;;)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 0);
        }
      }
    case 2: 
      paramParcel1.enforceInterface(a);
      str = paramParcel1.readString();
      paramParcel1 = paramParcel1.readString();
      try
      {
        this.b.b(str, paramParcel1);
        paramParcel2.writeInt(0);
        return true;
      }
      catch (FailedException paramParcel1)
      {
        for (;;)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 0);
        }
      }
    case 3: 
      paramParcel1.enforceInterface(a);
      str = paramParcel1.readString();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 != null) {}
      for (paramParcel1 = new e(paramParcel1);; paramParcel1 = null)
      {
        this.b.a(str, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface(a);
      paramParcel1 = paramParcel1.readString();
      paramParcel1 = this.b.a(paramParcel1);
      paramParcel2.writeNoException();
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    case 5: 
      paramParcel1.enforceInterface(a);
      paramParcel1 = paramParcel1.readString();
      paramParcel1 = this.b.b(paramParcel1);
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface(a);
    this.b.a();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.shadow.proguard.m
 * JD-Core Version:    0.7.0.1
 */