package com.tencent.shadow.dynamic.host;

import android.os.IBinder;
import android.os.Parcel;

class BinderUuidManager
  implements UuidManager
{
  private IBinder mRemote;
  
  BinderUuidManager(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  private void checkException(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == 1) {
      throw new FailedException(paramParcel);
    }
    if (i == 2) {
      throw new NotFoundException(paramParcel);
    }
    if (i != 0) {
      throw new RuntimeException("不认识的Code==" + i);
    }
  }
  
  /* Error */
  public com.tencent.shadow.core.common.InstalledApk getPlugin(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: invokestatic 58	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 58	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: getstatic 62	com/tencent/shadow/dynamic/host/UuidManager:DESCRIPTOR	Ljava/lang/String;
    //   13: invokevirtual 65	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   16: aload_3
    //   17: aload_1
    //   18: invokevirtual 68	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual 68	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 15	com/tencent/shadow/dynamic/host/BinderUuidManager:mRemote	Landroid/os/IBinder;
    //   30: iconst_1
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: invokeinterface 74 5 0
    //   40: pop
    //   41: aload_0
    //   42: aload 4
    //   44: invokespecial 76	com/tencent/shadow/dynamic/host/BinderUuidManager:checkException	(Landroid/os/Parcel;)V
    //   47: aload 4
    //   49: invokevirtual 24	android/os/Parcel:readInt	()I
    //   52: ifeq +28 -> 80
    //   55: getstatic 82	com/tencent/shadow/core/common/InstalledApk:CREATOR	Landroid/os/Parcelable$Creator;
    //   58: aload 4
    //   60: invokeinterface 88 2 0
    //   65: checkcast 78	com/tencent/shadow/core/common/InstalledApk
    //   68: astore_1
    //   69: aload 4
    //   71: invokevirtual 91	android/os/Parcel:recycle	()V
    //   74: aload_3
    //   75: invokevirtual 91	android/os/Parcel:recycle	()V
    //   78: aload_1
    //   79: areturn
    //   80: aconst_null
    //   81: astore_1
    //   82: goto -13 -> 69
    //   85: astore_1
    //   86: aload 4
    //   88: invokevirtual 91	android/os/Parcel:recycle	()V
    //   91: aload_3
    //   92: invokevirtual 91	android/os/Parcel:recycle	()V
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	BinderUuidManager
    //   0	97	1	paramString1	java.lang.String
    //   0	97	2	paramString2	java.lang.String
    //   3	89	3	localParcel1	Parcel
    //   7	80	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	69	85	finally
  }
  
  /* Error */
  public com.tencent.shadow.core.common.InstalledApk getPluginLoader(java.lang.String paramString)
  {
    // Byte code:
    //   0: invokestatic 58	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 58	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: getstatic 62	com/tencent/shadow/dynamic/host/UuidManager:DESCRIPTOR	Ljava/lang/String;
    //   12: invokevirtual 65	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_2
    //   16: aload_1
    //   17: invokevirtual 68	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 15	com/tencent/shadow/dynamic/host/BinderUuidManager:mRemote	Landroid/os/IBinder;
    //   24: iconst_2
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 74 5 0
    //   33: pop
    //   34: aload_0
    //   35: aload_3
    //   36: invokespecial 76	com/tencent/shadow/dynamic/host/BinderUuidManager:checkException	(Landroid/os/Parcel;)V
    //   39: aload_3
    //   40: invokevirtual 24	android/os/Parcel:readInt	()I
    //   43: ifeq +26 -> 69
    //   46: getstatic 82	com/tencent/shadow/core/common/InstalledApk:CREATOR	Landroid/os/Parcelable$Creator;
    //   49: aload_3
    //   50: invokeinterface 88 2 0
    //   55: checkcast 78	com/tencent/shadow/core/common/InstalledApk
    //   58: astore_1
    //   59: aload_3
    //   60: invokevirtual 91	android/os/Parcel:recycle	()V
    //   63: aload_2
    //   64: invokevirtual 91	android/os/Parcel:recycle	()V
    //   67: aload_1
    //   68: areturn
    //   69: aconst_null
    //   70: astore_1
    //   71: goto -12 -> 59
    //   74: astore_1
    //   75: aload_3
    //   76: invokevirtual 91	android/os/Parcel:recycle	()V
    //   79: aload_2
    //   80: invokevirtual 91	android/os/Parcel:recycle	()V
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	BinderUuidManager
    //   0	85	1	paramString	java.lang.String
    //   3	77	2	localParcel1	Parcel
    //   7	69	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	59	74	finally
  }
  
  /* Error */
  public com.tencent.shadow.core.common.InstalledApk getRuntime(java.lang.String paramString)
  {
    // Byte code:
    //   0: invokestatic 58	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 58	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: getstatic 62	com/tencent/shadow/dynamic/host/UuidManager:DESCRIPTOR	Ljava/lang/String;
    //   12: invokevirtual 65	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_2
    //   16: aload_1
    //   17: invokevirtual 68	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 15	com/tencent/shadow/dynamic/host/BinderUuidManager:mRemote	Landroid/os/IBinder;
    //   24: iconst_3
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 74 5 0
    //   33: pop
    //   34: aload_0
    //   35: aload_3
    //   36: invokespecial 76	com/tencent/shadow/dynamic/host/BinderUuidManager:checkException	(Landroid/os/Parcel;)V
    //   39: aload_3
    //   40: invokevirtual 24	android/os/Parcel:readInt	()I
    //   43: ifeq +26 -> 69
    //   46: getstatic 82	com/tencent/shadow/core/common/InstalledApk:CREATOR	Landroid/os/Parcelable$Creator;
    //   49: aload_3
    //   50: invokeinterface 88 2 0
    //   55: checkcast 78	com/tencent/shadow/core/common/InstalledApk
    //   58: astore_1
    //   59: aload_3
    //   60: invokevirtual 91	android/os/Parcel:recycle	()V
    //   63: aload_2
    //   64: invokevirtual 91	android/os/Parcel:recycle	()V
    //   67: aload_1
    //   68: areturn
    //   69: aconst_null
    //   70: astore_1
    //   71: goto -12 -> 59
    //   74: astore_1
    //   75: aload_3
    //   76: invokevirtual 91	android/os/Parcel:recycle	()V
    //   79: aload_2
    //   80: invokevirtual 91	android/os/Parcel:recycle	()V
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	BinderUuidManager
    //   0	85	1	paramString	java.lang.String
    //   3	77	2	localParcel1	Parcel
    //   7	69	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	59	74	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.BinderUuidManager
 * JD-Core Version:    0.7.0.1
 */