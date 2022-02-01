package com.tencent.mobileqq.imaxad;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.MobileQQ;

public class ImaxAdUtil
{
  public static Map<String, ?> a(String paramString)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imax_ad_item_data_");
    localStringBuilder.append(paramString);
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).getAll();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imax_ad_item_del_");
    localStringBuilder.append(paramString1);
    localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).edit().remove(paramString2).apply();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imax_ad_item_del_");
    localStringBuilder.append(paramString1);
    localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).edit().putString(paramString2, paramString3).apply();
  }
  
  public static boolean a(View paramView)
  {
    if (paramView != null)
    {
      int i = paramView.getHeight();
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      if (localRect.height() >= i / 2) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.istroop == 10005;
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: ifnull +237 -> 241
    //   7: aload_0
    //   8: arraylength
    //   9: ifne +6 -> 15
    //   12: goto +229 -> 241
    //   15: new 94	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 95	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore_1
    //   23: new 97	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_0
    //   28: iconst_0
    //   29: aload_0
    //   30: arraylength
    //   31: invokespecial 100	java/io/ByteArrayInputStream:<init>	([BII)V
    //   34: astore 4
    //   36: aload_1
    //   37: astore_2
    //   38: aload 4
    //   40: astore_3
    //   41: new 102	java/util/zip/GZIPInputStream
    //   44: dup
    //   45: aload 4
    //   47: aload_0
    //   48: arraylength
    //   49: invokespecial 105	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;I)V
    //   52: astore 6
    //   54: aload_1
    //   55: astore_2
    //   56: aload 4
    //   58: astore_3
    //   59: aload_0
    //   60: arraylength
    //   61: iconst_5
    //   62: imul
    //   63: newarray byte
    //   65: astore_0
    //   66: aload_1
    //   67: astore_2
    //   68: aload 4
    //   70: astore_3
    //   71: aload_1
    //   72: aload_0
    //   73: iconst_0
    //   74: aload 6
    //   76: aload_0
    //   77: invokevirtual 109	java/util/zip/GZIPInputStream:read	([B)I
    //   80: invokevirtual 112	java/io/ByteArrayOutputStream:write	([BII)V
    //   83: aload_1
    //   84: astore_2
    //   85: aload 4
    //   87: astore_3
    //   88: aload 6
    //   90: invokevirtual 115	java/util/zip/GZIPInputStream:close	()V
    //   93: aload_1
    //   94: astore_2
    //   95: aload 4
    //   97: astore_3
    //   98: aload_1
    //   99: invokevirtual 119	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   102: astore_0
    //   103: aload_0
    //   104: astore_2
    //   105: aload 4
    //   107: invokevirtual 120	java/io/ByteArrayInputStream:close	()V
    //   110: aload_0
    //   111: astore_2
    //   112: aload_1
    //   113: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: areturn
    //   118: astore_0
    //   119: ldc 123
    //   121: iconst_1
    //   122: ldc 125
    //   124: aload_0
    //   125: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: areturn
    //   130: astore_2
    //   131: aload 4
    //   133: astore_0
    //   134: aload_2
    //   135: astore 4
    //   137: goto +30 -> 167
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_3
    //   143: goto +65 -> 208
    //   146: astore 4
    //   148: aconst_null
    //   149: astore_0
    //   150: goto +17 -> 167
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_1
    //   156: aload_1
    //   157: astore_3
    //   158: goto +50 -> 208
    //   161: astore 4
    //   163: aconst_null
    //   164: astore_1
    //   165: aload_1
    //   166: astore_0
    //   167: aload_1
    //   168: astore_2
    //   169: aload_0
    //   170: astore_3
    //   171: ldc 123
    //   173: iconst_1
    //   174: ldc 133
    //   176: aload 4
    //   178: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_0
    //   182: ifnull +10 -> 192
    //   185: aload 5
    //   187: astore_2
    //   188: aload_0
    //   189: invokevirtual 120	java/io/ByteArrayInputStream:close	()V
    //   192: aload_1
    //   193: ifnull +10 -> 203
    //   196: aload 5
    //   198: astore_2
    //   199: aload_1
    //   200: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   203: aconst_null
    //   204: areturn
    //   205: astore_0
    //   206: aload_2
    //   207: astore_1
    //   208: aload_3
    //   209: ifnull +10 -> 219
    //   212: aload_3
    //   213: invokevirtual 120	java/io/ByteArrayInputStream:close	()V
    //   216: goto +3 -> 219
    //   219: aload_1
    //   220: ifnull +19 -> 239
    //   223: aload_1
    //   224: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   227: goto +12 -> 239
    //   230: ldc 123
    //   232: iconst_1
    //   233: ldc 125
    //   235: aload_1
    //   236: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: aload_0
    //   240: athrow
    //   241: ldc 123
    //   243: iconst_1
    //   244: ldc 135
    //   246: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aconst_null
    //   250: areturn
    //   251: astore_1
    //   252: goto -22 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramArrayOfByte	byte[]
    //   22	214	1	localObject1	Object
    //   251	1	1	localIOException	java.io.IOException
    //   37	92	2	localObject2	Object
    //   130	5	2	localException1	java.lang.Exception
    //   168	39	2	localObject3	Object
    //   40	173	3	localObject4	Object
    //   34	102	4	localObject5	Object
    //   146	1	4	localException2	java.lang.Exception
    //   161	16	4	localException3	java.lang.Exception
    //   1	196	5	localObject6	Object
    //   52	37	6	localGZIPInputStream	java.util.zip.GZIPInputStream
    // Exception table:
    //   from	to	target	type
    //   105	110	118	java/io/IOException
    //   112	116	118	java/io/IOException
    //   188	192	118	java/io/IOException
    //   199	203	118	java/io/IOException
    //   41	54	130	java/lang/Exception
    //   59	66	130	java/lang/Exception
    //   71	83	130	java/lang/Exception
    //   88	93	130	java/lang/Exception
    //   98	103	130	java/lang/Exception
    //   23	36	140	finally
    //   23	36	146	java/lang/Exception
    //   15	23	153	finally
    //   15	23	161	java/lang/Exception
    //   41	54	205	finally
    //   59	66	205	finally
    //   71	83	205	finally
    //   88	93	205	finally
    //   98	103	205	finally
    //   171	181	205	finally
    //   212	216	251	java/io/IOException
    //   223	227	251	java/io/IOException
  }
  
  public static String b(String paramString1, String paramString2)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imax_ad_item_del_");
    localStringBuilder.append(paramString1);
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).getString(paramString2, "");
  }
  
  public static void b(String paramString)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imax_ad_item_data_");
    localStringBuilder.append(paramString);
    localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).edit().clear().apply();
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imax_ad_item_data_");
    localStringBuilder.append(paramString1);
    localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).edit().putString(paramString2, paramString3).apply();
  }
  
  public static void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, paramString);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imax_ad_item_data_");
    localStringBuilder.append(paramString1);
    localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).edit().remove(paramString2).apply();
  }
  
  public static String d(String paramString1, String paramString2)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imax_ad_item_data_");
    localStringBuilder.append(paramString1);
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).getString(paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdUtil
 * JD-Core Version:    0.7.0.1
 */