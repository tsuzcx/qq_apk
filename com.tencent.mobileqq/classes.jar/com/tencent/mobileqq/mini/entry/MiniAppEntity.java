package com.tencent.mobileqq.mini.entry;

import awbv;
import awdj;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class MiniAppEntity
  extends awbv
{
  public static final String TAG = "MiniAppEntity";
  @awdj
  public String appId;
  public byte[] appInfo;
  public String name;
  public int position;
  
  public MiniAppEntity() {}
  
  public MiniAppEntity(MiniAppInfo paramMiniAppInfo)
  {
    this.appId = paramMiniAppInfo.appId;
    this.name = paramMiniAppInfo.name;
    this.position = paramMiniAppInfo.position;
    this.appInfo = packMiniAppInfo(paramMiniAppInfo);
  }
  
  /* Error */
  private byte[] packMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 46	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: aload_2
    //   10: iconst_0
    //   11: invokevirtual 50	android/os/Parcel:setDataPosition	(I)V
    //   14: aload_2
    //   15: astore_3
    //   16: aload_2
    //   17: aload_1
    //   18: iconst_0
    //   19: invokevirtual 54	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   22: aload_2
    //   23: astore_3
    //   24: aload_2
    //   25: invokevirtual 58	android/os/Parcel:marshall	()[B
    //   28: astore_1
    //   29: aload_1
    //   30: astore_3
    //   31: aload_3
    //   32: astore_1
    //   33: aload_2
    //   34: ifnull +9 -> 43
    //   37: aload_2
    //   38: invokevirtual 61	android/os/Parcel:recycle	()V
    //   41: aload_3
    //   42: astore_1
    //   43: aload_1
    //   44: areturn
    //   45: astore_1
    //   46: aconst_null
    //   47: astore_2
    //   48: aload_2
    //   49: astore_3
    //   50: ldc 8
    //   52: iconst_1
    //   53: new 63	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   60: ldc 66
    //   62: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokestatic 76	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   69: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload 4
    //   80: astore_1
    //   81: aload_2
    //   82: ifnull -39 -> 43
    //   85: aload_2
    //   86: invokevirtual 61	android/os/Parcel:recycle	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull +7 -> 102
    //   98: aload_3
    //   99: invokevirtual 61	android/os/Parcel:recycle	()V
    //   102: aload_1
    //   103: athrow
    //   104: astore_1
    //   105: goto -11 -> 94
    //   108: astore_1
    //   109: goto -61 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	MiniAppEntity
    //   0	112	1	paramMiniAppInfo	MiniAppInfo
    //   6	80	2	localParcel	android.os.Parcel
    //   8	91	3	localObject1	java.lang.Object
    //   1	78	4	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   3	7	45	java/lang/Throwable
    //   3	7	91	finally
    //   9	14	104	finally
    //   16	22	104	finally
    //   24	29	104	finally
    //   50	78	104	finally
    //   9	14	108	java/lang/Throwable
    //   16	22	108	java/lang/Throwable
    //   24	29	108	java/lang/Throwable
  }
  
  /* Error */
  public MiniAppInfo createFromBuffer(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 46	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: astore_3
    //   6: aload_2
    //   7: aload_1
    //   8: iconst_0
    //   9: aload_1
    //   10: arraylength
    //   11: invokevirtual 94	android/os/Parcel:unmarshall	([BII)V
    //   14: aload_2
    //   15: astore_3
    //   16: aload_2
    //   17: iconst_0
    //   18: invokevirtual 50	android/os/Parcel:setDataPosition	(I)V
    //   21: aload_2
    //   22: astore_3
    //   23: aload_2
    //   24: ldc 23
    //   26: invokevirtual 100	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   29: invokevirtual 104	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   32: checkcast 23	com/tencent/mobileqq/mini/apkg/MiniAppInfo
    //   35: astore_1
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokevirtual 61	android/os/Parcel:recycle	()V
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_1
    //   49: ldc 8
    //   51: iconst_1
    //   52: ldc 106
    //   54: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 61	android/os/Parcel:recycle	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: astore_3
    //   72: ldc 8
    //   74: iconst_1
    //   75: new 63	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   82: ldc 108
    //   84: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokestatic 76	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   91: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_2
    //   101: ifnull -36 -> 65
    //   104: aload_2
    //   105: invokevirtual 61	android/os/Parcel:recycle	()V
    //   108: goto -43 -> 65
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 61	android/os/Parcel:recycle	()V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: goto -11 -> 114
    //   128: astore_2
    //   129: aload_1
    //   130: astore_3
    //   131: aload_2
    //   132: astore_1
    //   133: goto -19 -> 114
    //   136: astore_1
    //   137: goto -67 -> 70
    //   140: astore_1
    //   141: aload_2
    //   142: astore_1
    //   143: goto -94 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	MiniAppEntity
    //   0	146	1	paramArrayOfByte	byte[]
    //   3	102	2	localParcel	android.os.Parcel
    //   128	14	2	localObject1	java.lang.Object
    //   5	126	3	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	4	46	java/lang/OutOfMemoryError
    //   0	4	67	java/lang/Throwable
    //   0	4	111	finally
    //   6	14	124	finally
    //   16	21	124	finally
    //   23	36	124	finally
    //   72	100	124	finally
    //   49	57	128	finally
    //   6	14	136	java/lang/Throwable
    //   16	21	136	java/lang/Throwable
    //   23	36	136	java/lang/Throwable
    //   6	14	140	java/lang/OutOfMemoryError
    //   16	21	140	java/lang/OutOfMemoryError
    //   23	36	140	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntity
 * JD-Core Version:    0.7.0.1
 */