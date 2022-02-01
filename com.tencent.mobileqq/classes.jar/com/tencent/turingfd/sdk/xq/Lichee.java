package com.tencent.turingfd.sdk.xq;

public class Lichee
  extends Kiwifruit
{
  public static final String b = import.a(import.i);
  
  /* Error */
  public String a(android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: ldc 27
    //   2: monitorenter
    //   3: getstatic 30	com/tencent/turingfd/sdk/xq/const:a	Landroid/content/Context;
    //   6: astore 4
    //   8: ldc 27
    //   10: monitorexit
    //   11: aload 4
    //   13: invokevirtual 36	android/content/Context:getPackageName	()Ljava/lang/String;
    //   16: astore 7
    //   18: aconst_null
    //   19: astore 6
    //   21: aload 4
    //   23: invokevirtual 40	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   26: aload 7
    //   28: bipush 64
    //   30: invokevirtual 46	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   33: getfield 52	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   36: astore 5
    //   38: goto +6 -> 44
    //   41: aconst_null
    //   42: astore 5
    //   44: aload 6
    //   46: astore 4
    //   48: aload 5
    //   50: ifnull +124 -> 174
    //   53: aload 6
    //   55: astore 4
    //   57: aload 5
    //   59: arraylength
    //   60: ifle +114 -> 174
    //   63: aload 5
    //   65: iconst_0
    //   66: aaload
    //   67: invokevirtual 58	android/content/pm/Signature:toByteArray	()[B
    //   70: astore 4
    //   72: ldc 60
    //   74: invokestatic 66	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   77: astore 5
    //   79: aload 5
    //   81: ifnonnull +10 -> 91
    //   84: aload 6
    //   86: astore 4
    //   88: goto +86 -> 174
    //   91: aload 5
    //   93: aload 4
    //   95: invokevirtual 70	java/security/MessageDigest:digest	([B)[B
    //   98: astore 4
    //   100: new 72	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   107: astore 5
    //   109: aload 4
    //   111: arraylength
    //   112: istore_3
    //   113: iconst_0
    //   114: istore_2
    //   115: iload_2
    //   116: iload_3
    //   117: if_icmpge +36 -> 153
    //   120: aload 5
    //   122: aload 4
    //   124: iload_2
    //   125: baload
    //   126: sipush 255
    //   129: iand
    //   130: sipush 256
    //   133: ior
    //   134: invokestatic 79	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   137: iconst_1
    //   138: iconst_3
    //   139: invokevirtual 85	java/lang/String:substring	(II)Ljava/lang/String;
    //   142: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: iload_2
    //   147: iconst_1
    //   148: iadd
    //   149: istore_2
    //   150: goto -35 -> 115
    //   153: aload 5
    //   155: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore 4
    //   160: goto +14 -> 174
    //   163: astore 4
    //   165: aload 4
    //   167: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   170: aload 6
    //   172: astore 4
    //   174: getstatic 100	com/tencent/turingfd/sdk/xq/import:j	[I
    //   177: invokestatic 18	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   180: astore 8
    //   182: invokestatic 106	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   185: astore 5
    //   187: invokestatic 106	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   190: astore 6
    //   192: aload 5
    //   194: getstatic 20	com/tencent/turingfd/sdk/xq/Lichee:b	Ljava/lang/String;
    //   197: invokevirtual 110	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   200: aload 5
    //   202: aload 7
    //   204: invokevirtual 113	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   207: aload 5
    //   209: aload 4
    //   211: invokevirtual 113	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   214: aload 5
    //   216: aload 8
    //   218: invokevirtual 113	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   221: aload_1
    //   222: iconst_1
    //   223: aload 5
    //   225: aload 6
    //   227: iconst_0
    //   228: invokeinterface 119 5 0
    //   233: pop
    //   234: aload 6
    //   236: invokevirtual 122	android/os/Parcel:readException	()V
    //   239: aload 6
    //   241: invokevirtual 125	android/os/Parcel:readString	()Ljava/lang/String;
    //   244: astore_1
    //   245: aload 6
    //   247: invokevirtual 128	android/os/Parcel:recycle	()V
    //   250: aload 5
    //   252: invokevirtual 128	android/os/Parcel:recycle	()V
    //   255: aload_1
    //   256: areturn
    //   257: astore_1
    //   258: aload 6
    //   260: invokevirtual 128	android/os/Parcel:recycle	()V
    //   263: aload 5
    //   265: invokevirtual 128	android/os/Parcel:recycle	()V
    //   268: aload_1
    //   269: athrow
    //   270: astore_1
    //   271: ldc 27
    //   273: monitorexit
    //   274: goto +5 -> 279
    //   277: aload_1
    //   278: athrow
    //   279: goto -2 -> 277
    //   282: astore 4
    //   284: goto -243 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	Lichee
    //   0	287	1	paramIBinder	android.os.IBinder
    //   114	36	2	i	int
    //   112	6	3	j	int
    //   6	153	4	localObject1	java.lang.Object
    //   163	3	4	localObject2	java.lang.Object
    //   172	38	4	localObject3	java.lang.Object
    //   282	1	4	localObject4	java.lang.Object
    //   36	228	5	localObject5	java.lang.Object
    //   19	240	6	localParcel	android.os.Parcel
    //   16	187	7	str1	String
    //   180	37	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   72	79	163	finally
    //   91	113	163	finally
    //   120	146	163	finally
    //   153	160	163	finally
    //   192	245	257	finally
    //   3	8	270	finally
    //   21	38	282	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Lichee
 * JD-Core Version:    0.7.0.1
 */