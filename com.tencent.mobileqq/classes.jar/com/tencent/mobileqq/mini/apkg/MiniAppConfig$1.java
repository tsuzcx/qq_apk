package com.tencent.mobileqq.mini.apkg;

import android.os.Parcelable.Creator;

final class MiniAppConfig$1
  implements Parcelable.Creator<MiniAppConfig>
{
  /* Error */
  public MiniAppConfig createFromParcel(android.os.Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 18
    //   3: invokevirtual 24	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   6: invokevirtual 30	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   9: checkcast 18	com/tencent/mobileqq/mini/apkg/MiniAppInfo
    //   12: astore 4
    //   14: aload_1
    //   15: ldc 32
    //   17: invokevirtual 24	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   20: invokevirtual 30	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   23: checkcast 32	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   26: astore 5
    //   28: aload_1
    //   29: ldc 34
    //   31: invokevirtual 24	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   34: invokevirtual 30	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   37: checkcast 34	com/tencent/mobileqq/mini/sdk/BaseLibInfo
    //   40: astore 6
    //   42: aload_1
    //   43: invokevirtual 38	android/os/Parcel:readInt	()I
    //   46: istore_2
    //   47: new 40	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   50: dup
    //   51: aload 4
    //   53: aload 6
    //   55: aconst_null
    //   56: invokespecial 43	com/tencent/mobileqq/mini/apkg/MiniAppConfig:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;Lcom/tencent/mobileqq/mini/sdk/BaseLibInfo;Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig$1;)V
    //   59: astore 4
    //   61: aload 4
    //   63: aload 5
    //   65: putfield 47	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   68: aload 4
    //   70: iload_2
    //   71: putfield 51	com/tencent/mobileqq/mini/apkg/MiniAppConfig:forceReroad	I
    //   74: aload_1
    //   75: invokevirtual 38	android/os/Parcel:readInt	()I
    //   78: iconst_1
    //   79: if_icmpne +57 -> 136
    //   82: iconst_1
    //   83: istore_3
    //   84: aload 4
    //   86: iload_3
    //   87: putfield 55	com/tencent/mobileqq/mini/apkg/MiniAppConfig:isFromShowInfo	Z
    //   90: aload 4
    //   92: aload_1
    //   93: invokevirtual 59	android/os/Parcel:readString	()Ljava/lang/String;
    //   96: putfield 63	com/tencent/mobileqq/mini/apkg/MiniAppConfig:link	Ljava/lang/String;
    //   99: aload 4
    //   101: aload_1
    //   102: invokevirtual 38	android/os/Parcel:readInt	()I
    //   105: putfield 66	com/tencent/mobileqq/mini/apkg/MiniAppConfig:linkType	I
    //   108: aload 4
    //   110: aload_1
    //   111: invokevirtual 59	android/os/Parcel:readString	()Ljava/lang/String;
    //   114: putfield 69	com/tencent/mobileqq/mini/apkg/MiniAppConfig:entryPath	Ljava/lang/String;
    //   117: aload_1
    //   118: invokevirtual 38	android/os/Parcel:readInt	()I
    //   121: iconst_1
    //   122: if_icmpne +19 -> 141
    //   125: iconst_1
    //   126: istore_3
    //   127: aload 4
    //   129: iload_3
    //   130: putfield 72	com/tencent/mobileqq/mini/apkg/MiniAppConfig:isSdkMode	Z
    //   133: aload 4
    //   135: areturn
    //   136: iconst_0
    //   137: istore_3
    //   138: goto -54 -> 84
    //   141: iconst_0
    //   142: istore_3
    //   143: goto -16 -> 127
    //   146: astore_1
    //   147: aconst_null
    //   148: astore 4
    //   150: ldc 74
    //   152: ldc 76
    //   154: aload_1
    //   155: invokestatic 82	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload 4
    //   160: areturn
    //   161: astore_1
    //   162: goto -12 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	1
    //   0	165	1	paramParcel	android.os.Parcel
    //   46	25	2	i	int
    //   83	60	3	bool	boolean
    //   12	147	4	localObject	Object
    //   26	38	5	localLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    //   40	14	6	localBaseLibInfo	com.tencent.mobileqq.mini.sdk.BaseLibInfo
    // Exception table:
    //   from	to	target	type
    //   0	61	146	java/lang/Throwable
    //   61	82	161	java/lang/Throwable
    //   84	125	161	java/lang/Throwable
    //   127	133	161	java/lang/Throwable
  }
  
  public MiniAppConfig[] newArray(int paramInt)
  {
    return new MiniAppConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.MiniAppConfig.1
 * JD-Core Version:    0.7.0.1
 */