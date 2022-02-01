package com.tencent.mobileqq.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableUtil
{
  public static Parcel a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    return localParcel;
  }
  
  /* Error */
  public static <T> T a(byte[] paramArrayOfByte, android.os.Parcelable.Creator<T> paramCreator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokestatic 32	com/tencent/mobileqq/utils/ParcelableUtil:a	([B)Landroid/os/Parcel;
    //   9: astore_2
    //   10: aload_2
    //   11: astore_0
    //   12: aload_1
    //   13: aload_2
    //   14: invokeinterface 38 2 0
    //   19: astore_1
    //   20: aload_1
    //   21: astore_0
    //   22: aload_2
    //   23: ifnull +87 -> 110
    //   26: aload_2
    //   27: invokevirtual 41	android/os/Parcel:recycle	()V
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: goto +79 -> 112
    //   36: astore_1
    //   37: goto +16 -> 53
    //   40: astore_1
    //   41: goto +36 -> 77
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_0
    //   47: goto +65 -> 112
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_2
    //   53: aload_2
    //   54: astore_0
    //   55: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +70 -> 128
    //   61: aload_2
    //   62: astore_0
    //   63: ldc 49
    //   65: iconst_2
    //   66: aload_1
    //   67: invokevirtual 53	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   70: aload_1
    //   71: invokestatic 57	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   74: goto +54 -> 128
    //   77: aload_2
    //   78: astore_0
    //   79: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +16 -> 98
    //   85: aload_2
    //   86: astore_0
    //   87: ldc 49
    //   89: iconst_2
    //   90: aload_1
    //   91: invokevirtual 58	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   94: aload_1
    //   95: invokestatic 57	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload 4
    //   100: astore_0
    //   101: aload_2
    //   102: ifnull +8 -> 110
    //   105: aload_3
    //   106: astore_1
    //   107: goto -81 -> 26
    //   110: aload_0
    //   111: areturn
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 41	android/os/Parcel:recycle	()V
    //   120: goto +5 -> 125
    //   123: aload_1
    //   124: athrow
    //   125: goto -2 -> 123
    //   128: aload 4
    //   130: astore_0
    //   131: aload_2
    //   132: ifnull -22 -> 110
    //   135: aload_3
    //   136: astore_1
    //   137: goto -111 -> 26
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_2
    //   143: goto -66 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramArrayOfByte	byte[]
    //   0	146	1	paramCreator	android.os.Parcelable.Creator<T>
    //   9	134	2	localParcel	Parcel
    //   4	132	3	localObject1	Object
    //   1	128	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	20	32	finally
    //   55	61	32	finally
    //   63	74	32	finally
    //   79	85	32	finally
    //   87	98	32	finally
    //   12	20	36	java/lang/OutOfMemoryError
    //   12	20	40	java/lang/Exception
    //   5	10	44	finally
    //   5	10	50	java/lang/OutOfMemoryError
    //   5	10	140	java/lang/Exception
  }
  
  public static byte[] a(Parcelable paramParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return paramParcelable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ParcelableUtil
 * JD-Core Version:    0.7.0.1
 */