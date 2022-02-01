package com.tencent.mobileqq.upgrade;

import android.os.Parcelable.Creator;

final class UpgradeTIMWrapper$1
  implements Parcelable.Creator<UpgradeTIMWrapper>
{
  /* Error */
  public UpgradeTIMWrapper a(android.os.Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 22	android/os/Parcel:readString	()Ljava/lang/String;
    //   4: astore 5
    //   6: aload_1
    //   7: invokevirtual 22	android/os/Parcel:readString	()Ljava/lang/String;
    //   10: astore 6
    //   12: aload_1
    //   13: invokevirtual 22	android/os/Parcel:readString	()Ljava/lang/String;
    //   16: astore 7
    //   18: aload_1
    //   19: invokevirtual 22	android/os/Parcel:readString	()Ljava/lang/String;
    //   22: astore 8
    //   24: aload_1
    //   25: invokevirtual 22	android/os/Parcel:readString	()Ljava/lang/String;
    //   28: astore 9
    //   30: aload_1
    //   31: invokevirtual 26	android/os/Parcel:readInt	()I
    //   34: istore_2
    //   35: aload_1
    //   36: invokevirtual 22	android/os/Parcel:readString	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_1
    //   41: invokevirtual 22	android/os/Parcel:readString	()Ljava/lang/String;
    //   44: astore_1
    //   45: aload_1
    //   46: astore 4
    //   48: goto +37 -> 85
    //   51: astore 4
    //   53: aload_3
    //   54: astore_1
    //   55: aload 4
    //   57: astore_3
    //   58: goto +18 -> 76
    //   61: astore_1
    //   62: goto +6 -> 68
    //   65: astore_1
    //   66: iconst_0
    //   67: istore_2
    //   68: aconst_null
    //   69: astore 4
    //   71: aload_1
    //   72: astore_3
    //   73: aload 4
    //   75: astore_1
    //   76: aload_3
    //   77: invokevirtual 29	java/lang/Exception:printStackTrace	()V
    //   80: aconst_null
    //   81: astore 4
    //   83: aload_1
    //   84: astore_3
    //   85: new 31	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper
    //   88: dup
    //   89: aload 5
    //   91: aload 6
    //   93: aload 7
    //   95: aload 8
    //   97: aload 9
    //   99: iload_2
    //   100: aload_3
    //   101: aload 4
    //   103: invokespecial 34	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   106: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	1
    //   0	107	1	paramParcel	android.os.Parcel
    //   34	66	2	i	int
    //   39	62	3	localObject	Object
    //   46	1	4	localParcel	android.os.Parcel
    //   51	5	4	localException	java.lang.Exception
    //   69	33	4	str1	java.lang.String
    //   4	86	5	str2	java.lang.String
    //   10	82	6	str3	java.lang.String
    //   16	78	7	str4	java.lang.String
    //   22	74	8	str5	java.lang.String
    //   28	70	9	str6	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   40	45	51	java/lang/Exception
    //   35	40	61	java/lang/Exception
    //   30	35	65	java/lang/Exception
  }
  
  public UpgradeTIMWrapper[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTIMWrapper.1
 * JD-Core Version:    0.7.0.1
 */