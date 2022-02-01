package com.tencent.mobileqq.structmsg;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.zip.Inflater;

public class StructMsgUtils
{
  public static int a(String paramString)
  {
    if (paramString != null) {
      paramString.trim();
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      label16:
      break label16;
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    if (paramString != null) {
      paramString.trim();
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      label16:
      break label16;
    }
    return 0L;
  }
  
  public static StateListDrawable a(Resources paramResources, int paramInt, float[] paramArrayOfFloat)
  {
    GradientDrawable[] arrayOfGradientDrawable = new GradientDrawable[2];
    int m = Color.red(paramInt);
    int i = Color.green(paramInt);
    int j = Color.blue(paramInt);
    int k = 0;
    paramInt = m;
    while (k < arrayOfGradientDrawable.length)
    {
      arrayOfGradientDrawable[k] = new GradientDrawable();
      arrayOfGradientDrawable[k].setShape(0);
      int n = k << 5;
      m = paramInt - n;
      paramInt = m;
      if (m < 0) {
        paramInt = 0;
      }
      m = i - n;
      i = m;
      if (m < 0) {
        i = 0;
      }
      m = j - n;
      j = m;
      if (m < 0) {
        j = 0;
      }
      arrayOfGradientDrawable[k].setColor(Color.rgb(paramInt, i, j));
      if (paramArrayOfFloat != null) {
        arrayOfGradientDrawable[k].setCornerRadii(paramArrayOfFloat);
      } else {
        arrayOfGradientDrawable[k].setCornerRadius(AIOUtils.b(4.0F, paramResources));
      }
      k += 1;
    }
    paramResources = new StateListDrawable();
    paramArrayOfFloat = arrayOfGradientDrawable[1];
    paramResources.addState(new int[] { 16842919, 16842910 }, paramArrayOfFloat);
    paramResources.addState(StateSet.WILD_CARD, arrayOfGradientDrawable[0]);
    return paramResources;
  }
  
  private static boolean a(Inflater paramInflater)
  {
    return (paramInflater.finished()) || (paramInflater.getRemaining() <= 0);
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 90	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 102	java/util/zip/Inflater:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: invokevirtual 105	java/util/zip/Inflater:reset	()V
    //   14: aload 5
    //   16: aload_0
    //   17: invokevirtual 109	java/util/zip/Inflater:setInput	([B)V
    //   20: new 111	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: aload_0
    //   25: arraylength
    //   26: invokespecial 113	java/io/ByteArrayOutputStream:<init>	(I)V
    //   29: astore_3
    //   30: sipush 1024
    //   33: newarray byte
    //   35: astore 4
    //   37: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   40: lstore_1
    //   41: aload 5
    //   43: invokestatic 121	com/tencent/mobileqq/structmsg/StructMsgUtils:a	(Ljava/util/zip/Inflater;)Z
    //   46: ifne +92 -> 138
    //   49: aload_3
    //   50: aload 4
    //   52: iconst_0
    //   53: aload 5
    //   55: aload 4
    //   57: invokevirtual 125	java/util/zip/Inflater:inflate	([B)I
    //   60: invokevirtual 129	java/io/ByteArrayOutputStream:write	([BII)V
    //   63: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   66: lload_1
    //   67: lsub
    //   68: ldc2_w 130
    //   71: lcmp
    //   72: ifle -31 -> 41
    //   75: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +11 -> 89
    //   81: ldc 138
    //   83: iconst_2
    //   84: ldc 140
    //   86: invokestatic 144	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aconst_null
    //   90: ldc 146
    //   92: ldc 148
    //   94: ldc 148
    //   96: ldc 150
    //   98: ldc 150
    //   100: iconst_0
    //   101: iconst_1
    //   102: ldc 148
    //   104: ldc 148
    //   106: ldc 148
    //   108: ldc 148
    //   110: invokestatic 155	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_3
    //   114: invokevirtual 158	java/io/ByteArrayOutputStream:close	()V
    //   117: aload_0
    //   118: areturn
    //   119: astore_3
    //   120: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +13 -> 136
    //   126: ldc 138
    //   128: iconst_2
    //   129: aload_3
    //   130: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   133: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload_0
    //   137: areturn
    //   138: aload_3
    //   139: invokevirtual 168	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: astore 4
    //   144: aload_3
    //   145: invokevirtual 158	java/io/ByteArrayOutputStream:close	()V
    //   148: aload 4
    //   150: astore_3
    //   151: goto +81 -> 232
    //   154: astore_0
    //   155: aload 4
    //   157: astore_3
    //   158: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +71 -> 232
    //   164: aload_0
    //   165: astore_3
    //   166: aload 4
    //   168: astore_0
    //   169: ldc 138
    //   171: iconst_2
    //   172: aload_3
    //   173: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   176: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_0
    //   180: astore_3
    //   181: goto +51 -> 232
    //   184: astore_0
    //   185: goto +54 -> 239
    //   188: astore 4
    //   190: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +14 -> 207
    //   196: ldc 138
    //   198: iconst_2
    //   199: aload 4
    //   201: invokevirtual 169	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_3
    //   208: invokevirtual 158	java/io/ByteArrayOutputStream:close	()V
    //   211: aload_0
    //   212: astore_3
    //   213: goto +19 -> 232
    //   216: astore 4
    //   218: aload_0
    //   219: astore_3
    //   220: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +9 -> 232
    //   226: aload 4
    //   228: astore_3
    //   229: goto -60 -> 169
    //   232: aload 5
    //   234: invokevirtual 172	java/util/zip/Inflater:end	()V
    //   237: aload_3
    //   238: areturn
    //   239: aload_3
    //   240: invokevirtual 158	java/io/ByteArrayOutputStream:close	()V
    //   243: goto +20 -> 263
    //   246: astore_3
    //   247: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +13 -> 263
    //   253: ldc 138
    //   255: iconst_2
    //   256: aload_3
    //   257: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   260: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto +5 -> 268
    //   266: aload_0
    //   267: athrow
    //   268: goto -2 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramArrayOfByte	byte[]
    //   40	27	1	l	long
    //   29	85	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   119	26	3	localIOException1	java.io.IOException
    //   150	90	3	localObject	Object
    //   246	11	3	localIOException2	java.io.IOException
    //   35	132	4	arrayOfByte	byte[]
    //   188	12	4	localException	Exception
    //   216	11	4	localIOException3	java.io.IOException
    //   7	226	5	localInflater	Inflater
    // Exception table:
    //   from	to	target	type
    //   113	117	119	java/io/IOException
    //   144	148	154	java/io/IOException
    //   30	41	184	finally
    //   41	89	184	finally
    //   89	113	184	finally
    //   138	144	184	finally
    //   190	207	184	finally
    //   30	41	188	java/lang/Exception
    //   41	89	188	java/lang/Exception
    //   89	113	188	java/lang/Exception
    //   138	144	188	java/lang/Exception
    //   207	211	216	java/io/IOException
    //   239	243	246	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    Object localObject;
    if (paramInt == -1)
    {
      paramInt = paramArrayOfByte[0];
      i -= 1;
      localObject = new byte[i];
      if (paramInt == 1)
      {
        System.arraycopy(paramArrayOfByte, 1, localObject, 0, i);
        paramArrayOfByte = a((byte[])localObject);
      }
      else
      {
        System.arraycopy(paramArrayOfByte, 1, localObject, 0, i);
        paramArrayOfByte = (byte[])localObject;
      }
    }
    else
    {
      localObject = new byte[i];
      if (paramInt == 1)
      {
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, i);
        paramArrayOfByte = a((byte[])localObject);
      }
      else
      {
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, i);
        paramArrayOfByte = (byte[])localObject;
      }
    }
    if ((QLog.isColorLevel()) && (paramArrayOfByte != null))
    {
      localObject = new String(paramArrayOfByte, 0, paramArrayOfByte.length);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStructMsgFromXmlBuff xmlStr:");
      localStringBuilder.append((String)localObject);
      QLog.d("StructMsg", 2, localStringBuilder.toString());
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public static final byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 199	java/util/zip/Deflater
    //   9: dup
    //   10: invokespecial 200	java/util/zip/Deflater:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: invokevirtual 201	java/util/zip/Deflater:reset	()V
    //   20: aload 4
    //   22: aload_0
    //   23: invokevirtual 202	java/util/zip/Deflater:setInput	([B)V
    //   26: aload 4
    //   28: invokevirtual 205	java/util/zip/Deflater:finish	()V
    //   31: new 111	java/io/ByteArrayOutputStream
    //   34: dup
    //   35: aload_0
    //   36: arraylength
    //   37: invokespecial 113	java/io/ByteArrayOutputStream:<init>	(I)V
    //   40: astore_1
    //   41: sipush 1024
    //   44: newarray byte
    //   46: astore_2
    //   47: aload 4
    //   49: invokevirtual 206	java/util/zip/Deflater:finished	()Z
    //   52: ifne +18 -> 70
    //   55: aload_1
    //   56: aload_2
    //   57: iconst_0
    //   58: aload 4
    //   60: aload_2
    //   61: invokevirtual 209	java/util/zip/Deflater:deflate	([B)I
    //   64: invokevirtual 129	java/io/ByteArrayOutputStream:write	([BII)V
    //   67: goto -20 -> 47
    //   70: aload_1
    //   71: invokevirtual 168	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   74: astore_2
    //   75: aload_1
    //   76: invokevirtual 158	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_2
    //   80: astore_1
    //   81: goto +123 -> 204
    //   84: astore_3
    //   85: aload_2
    //   86: astore_1
    //   87: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +114 -> 204
    //   93: aload_2
    //   94: astore_0
    //   95: aload_3
    //   96: astore_1
    //   97: ldc 138
    //   99: iconst_2
    //   100: aload_1
    //   101: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   104: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_0
    //   108: astore_1
    //   109: goto +95 -> 204
    //   112: astore_0
    //   113: goto +98 -> 211
    //   116: astore_0
    //   117: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +13 -> 133
    //   123: ldc 138
    //   125: iconst_2
    //   126: aload_0
    //   127: invokevirtual 210	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   130: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_1
    //   134: invokevirtual 158	java/io/ByteArrayOutputStream:close	()V
    //   137: goto +20 -> 157
    //   140: astore_0
    //   141: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +13 -> 157
    //   147: ldc 138
    //   149: iconst_2
    //   150: aload_0
    //   151: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   154: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: iconst_0
    //   158: newarray byte
    //   160: astore_1
    //   161: goto +43 -> 204
    //   164: astore_2
    //   165: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +13 -> 181
    //   171: ldc 138
    //   173: iconst_2
    //   174: aload_2
    //   175: invokevirtual 169	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   178: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_1
    //   182: invokevirtual 158	java/io/ByteArrayOutputStream:close	()V
    //   185: aload_0
    //   186: astore_1
    //   187: goto +17 -> 204
    //   190: astore_2
    //   191: aload_0
    //   192: astore_1
    //   193: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +8 -> 204
    //   199: aload_2
    //   200: astore_1
    //   201: goto -104 -> 97
    //   204: aload 4
    //   206: invokevirtual 211	java/util/zip/Deflater:end	()V
    //   209: aload_1
    //   210: areturn
    //   211: aload_1
    //   212: invokevirtual 158	java/io/ByteArrayOutputStream:close	()V
    //   215: goto +20 -> 235
    //   218: astore_1
    //   219: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +13 -> 235
    //   225: ldc 138
    //   227: iconst_2
    //   228: aload_1
    //   229: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   232: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: goto +5 -> 240
    //   238: aload_0
    //   239: athrow
    //   240: goto -2 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramArrayOfByte	byte[]
    //   40	172	1	localObject	Object
    //   218	11	1	localIOException1	java.io.IOException
    //   46	48	2	arrayOfByte	byte[]
    //   164	11	2	localException	Exception
    //   190	10	2	localIOException2	java.io.IOException
    //   84	12	3	localIOException3	java.io.IOException
    //   13	192	4	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   75	79	84	java/io/IOException
    //   41	47	112	finally
    //   47	67	112	finally
    //   70	75	112	finally
    //   117	133	112	finally
    //   165	181	112	finally
    //   41	47	116	java/lang/OutOfMemoryError
    //   47	67	116	java/lang/OutOfMemoryError
    //   70	75	116	java/lang/OutOfMemoryError
    //   133	137	140	java/io/IOException
    //   41	47	164	java/lang/Exception
    //   47	67	164	java/lang/Exception
    //   70	75	164	java/lang/Exception
    //   181	185	190	java/io/IOException
    //   211	215	218	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgUtils
 * JD-Core Version:    0.7.0.1
 */