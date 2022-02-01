package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class DeskTopAppEntity
  extends Entity
{
  public static final String TAG = "DeskTopAppInfoEntity";
  public String appId;
  public byte[] appInfo;
  public String name;
  @unique
  public String uniqueId;
  public int verType;
  
  public DeskTopAppEntity() {}
  
  public DeskTopAppEntity(MiniAppInfo paramMiniAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniAppInfo.appId);
    localStringBuilder.append("_");
    localStringBuilder.append(this.verType);
    this.uniqueId = localStringBuilder.toString();
    this.appId = paramMiniAppInfo.appId;
    this.name = paramMiniAppInfo.name;
    this.verType = paramMiniAppInfo.verType;
    this.appInfo = packAppInfo(paramMiniAppInfo);
  }
  
  /* Error */
  private byte[] packAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: invokestatic 65	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: astore_2
    //   6: aload_3
    //   7: iconst_0
    //   8: invokevirtual 69	android/os/Parcel:setDataPosition	(I)V
    //   11: aload_3
    //   12: astore_2
    //   13: aload_3
    //   14: aload_1
    //   15: iconst_0
    //   16: invokevirtual 73	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   19: aload_3
    //   20: astore_2
    //   21: aload_3
    //   22: invokevirtual 77	android/os/Parcel:marshall	()[B
    //   25: astore_1
    //   26: aload_3
    //   27: ifnull +7 -> 34
    //   30: aload_3
    //   31: invokevirtual 80	android/os/Parcel:recycle	()V
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: goto +76 -> 113
    //   40: astore_2
    //   41: aload_3
    //   42: astore_1
    //   43: aload_2
    //   44: astore_3
    //   45: goto +12 -> 57
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_2
    //   51: goto +62 -> 113
    //   54: astore_3
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_1
    //   58: astore_2
    //   59: new 24	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   66: astore 4
    //   68: aload_1
    //   69: astore_2
    //   70: aload 4
    //   72: ldc 82
    //   74: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_1
    //   79: astore_2
    //   80: aload 4
    //   82: aload_3
    //   83: invokestatic 88	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   86: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: astore_2
    //   92: ldc 8
    //   94: iconst_1
    //   95: aload 4
    //   97: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 80	android/os/Parcel:recycle	()V
    //   111: aconst_null
    //   112: areturn
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 80	android/os/Parcel:recycle	()V
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	DeskTopAppEntity
    //   0	123	1	paramMiniAppInfo	MiniAppInfo
    //   5	16	2	localObject1	java.lang.Object
    //   40	4	2	localThrowable1	java.lang.Throwable
    //   50	68	2	localMiniAppInfo	MiniAppInfo
    //   3	42	3	localObject2	java.lang.Object
    //   54	29	3	localThrowable2	java.lang.Throwable
    //   66	30	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	11	36	finally
    //   13	19	36	finally
    //   21	26	36	finally
    //   59	68	36	finally
    //   70	78	36	finally
    //   80	90	36	finally
    //   92	103	36	finally
    //   6	11	40	java/lang/Throwable
    //   13	19	40	java/lang/Throwable
    //   21	26	40	java/lang/Throwable
    //   0	4	48	finally
    //   0	4	54	java/lang/Throwable
  }
  
  /* Error */
  public MiniAppInfo createAppInfoFromBuffer(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 65	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: astore_2
    //   6: aload_3
    //   7: aload_1
    //   8: iconst_0
    //   9: aload_1
    //   10: arraylength
    //   11: invokevirtual 102	android/os/Parcel:unmarshall	([BII)V
    //   14: aload_3
    //   15: astore_2
    //   16: aload_3
    //   17: iconst_0
    //   18: invokevirtual 69	android/os/Parcel:setDataPosition	(I)V
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: ldc 27
    //   26: invokevirtual 108	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   29: invokevirtual 112	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   32: checkcast 27	com/tencent/mobileqq/mini/apkg/MiniAppInfo
    //   35: astore_1
    //   36: aload_3
    //   37: ifnull +7 -> 44
    //   40: aload_3
    //   41: invokevirtual 80	android/os/Parcel:recycle	()V
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: goto +93 -> 140
    //   50: astore_2
    //   51: aload_3
    //   52: astore_1
    //   53: aload_2
    //   54: astore_3
    //   55: goto +12 -> 67
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_2
    //   61: goto +79 -> 140
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_1
    //   67: aload_1
    //   68: astore_2
    //   69: new 24	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   76: astore 4
    //   78: aload_1
    //   79: astore_2
    //   80: aload 4
    //   82: ldc 114
    //   84: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_1
    //   89: astore_2
    //   90: aload 4
    //   92: aload_3
    //   93: invokestatic 88	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   96: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_1
    //   101: astore_2
    //   102: ldc 8
    //   104: iconst_1
    //   105: aload 4
    //   107: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_1
    //   114: ifnull +24 -> 138
    //   117: goto +17 -> 134
    //   120: aload_1
    //   121: astore_2
    //   122: ldc 8
    //   124: iconst_1
    //   125: ldc 116
    //   127: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 80	android/os/Parcel:recycle	()V
    //   138: aconst_null
    //   139: areturn
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 80	android/os/Parcel:recycle	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: goto +9 -> 160
    //   154: astore_1
    //   155: aload_3
    //   156: astore_1
    //   157: goto -37 -> 120
    //   160: aconst_null
    //   161: astore_1
    //   162: goto -42 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	DeskTopAppEntity
    //   0	165	1	paramArrayOfByte	byte[]
    //   5	18	2	localObject1	java.lang.Object
    //   50	4	2	localThrowable1	java.lang.Throwable
    //   60	85	2	arrayOfByte	byte[]
    //   3	52	3	localObject2	java.lang.Object
    //   64	92	3	localThrowable2	java.lang.Throwable
    //   76	30	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	14	46	finally
    //   16	21	46	finally
    //   23	36	46	finally
    //   69	78	46	finally
    //   80	88	46	finally
    //   90	100	46	finally
    //   102	113	46	finally
    //   122	130	46	finally
    //   6	14	50	java/lang/Throwable
    //   16	21	50	java/lang/Throwable
    //   23	36	50	java/lang/Throwable
    //   0	4	58	finally
    //   0	4	64	java/lang/Throwable
    //   0	4	150	java/lang/OutOfMemoryError
    //   6	14	154	java/lang/OutOfMemoryError
    //   16	21	154	java/lang/OutOfMemoryError
    //   23	36	154	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DeskTopAppEntity
 * JD-Core Version:    0.7.0.1
 */