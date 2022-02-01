package com.tencent.mobileqq.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils
{
  private static int jdField_a_of_type_Int;
  static Boolean jdField_a_of_type_JavaLangBoolean = null;
  protected static String a;
  private static StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private static final Set<Long> jdField_a_of_type_JavaUtilSet;
  protected static final char[] a;
  public static final String[] a;
  public static String b;
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 12290, -225, -255, 33, 63, -244, -229, 44, 32 };
    jdField_a_of_type_JavaLangString = ".*(\\+86|086)?\\d{5,12}.*";
    jdField_a_of_type_JavaUtilSet = new Utils.1(100);
    b = null;
    jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131699547), HardCodeUtil.a(2131699545), HardCodeUtil.a(2131699556), HardCodeUtil.a(2131699550), HardCodeUtil.a(2131699557), HardCodeUtil.a(2131699548), HardCodeUtil.a(2131699543), HardCodeUtil.a(2131699554), HardCodeUtil.a(2131699553), HardCodeUtil.a(2131699559), HardCodeUtil.a(2131699544), HardCodeUtil.a(2131699549) };
  }
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static int a(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    return i;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(int paramInt)
  {
    int i = 2;
    if (jdField_a_of_type_JavaLangStringBuilder.length() > 560) {}
    try
    {
      int j = jdField_a_of_type_JavaLangStringBuilder.toString().getBytes("utf-8").length;
      if ((jdField_a_of_type_Int != j) && (QLog.isColorLevel())) {
        QLog.d("Utils", 2, "calculate byte num not equal byte num returned by getBytes(),totalByteNum is:" + jdField_a_of_type_Int + ",byteNum" + j);
      }
      label76:
      jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      jdField_a_of_type_Int = 0;
      if ((paramInt >= 0) && (paramInt < 128)) {
        i = 1;
      }
      for (;;)
      {
        jdField_a_of_type_JavaLangStringBuilder.append(Character.toChars(paramInt));
        jdField_a_of_type_Int += i;
        return i;
        if ((paramInt < 128) || (paramInt >= 2048)) {
          if ((paramInt >= 2048) && (paramInt < 65536)) {
            i = 3;
          } else if ((paramInt >= 65536) && (paramInt < 2097152)) {
            i = 4;
          } else if ((paramInt >= 2097152) && (paramInt < 67108864)) {
            i = 5;
          } else {
            i = 6;
          }
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label76;
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, paramInt1, paramInt2);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, 1, 19);
    Calendar localCalendar3 = Calendar.getInstance();
    localCalendar3.set(1, 2, 18);
    Calendar localCalendar4 = Calendar.getInstance();
    localCalendar4.set(1, 3, 20);
    Calendar localCalendar5 = Calendar.getInstance();
    localCalendar5.set(1, 4, 19);
    Calendar localCalendar6 = Calendar.getInstance();
    localCalendar6.set(1, 5, 20);
    Calendar localCalendar7 = Calendar.getInstance();
    localCalendar7.set(1, 6, 21);
    Calendar localCalendar8 = Calendar.getInstance();
    localCalendar8.set(1, 7, 22);
    Calendar localCalendar9 = Calendar.getInstance();
    localCalendar9.set(1, 8, 22);
    Calendar localCalendar10 = Calendar.getInstance();
    localCalendar10.set(1, 9, 22);
    Calendar localCalendar11 = Calendar.getInstance();
    localCalendar11.set(1, 10, 23);
    Calendar localCalendar12 = Calendar.getInstance();
    localCalendar12.set(1, 11, 22);
    Calendar localCalendar13 = Calendar.getInstance();
    localCalendar13.set(1, 12, 21);
    if ((localCalendar1.compareTo(localCalendar2) > 0) && (localCalendar1.compareTo(localCalendar3) <= 0)) {
      return 1;
    }
    if ((localCalendar1.compareTo(localCalendar3) > 0) && (localCalendar1.compareTo(localCalendar4) <= 0)) {
      return 2;
    }
    if ((localCalendar1.compareTo(localCalendar4) > 0) && (localCalendar1.compareTo(localCalendar5) <= 0)) {
      return 3;
    }
    if ((localCalendar1.compareTo(localCalendar5) > 0) && (localCalendar1.compareTo(localCalendar6) <= 0)) {
      return 4;
    }
    if ((localCalendar1.compareTo(localCalendar6) > 0) && (localCalendar1.compareTo(localCalendar7) <= 0)) {
      return 5;
    }
    if ((localCalendar1.compareTo(localCalendar7) > 0) && (localCalendar1.compareTo(localCalendar8) <= 0)) {
      return 6;
    }
    if ((localCalendar1.compareTo(localCalendar8) > 0) && (localCalendar1.compareTo(localCalendar9) <= 0)) {
      return 7;
    }
    if ((localCalendar1.compareTo(localCalendar9) > 0) && (localCalendar1.compareTo(localCalendar10) <= 0)) {
      return 8;
    }
    if ((localCalendar1.compareTo(localCalendar10) > 0) && (localCalendar1.compareTo(localCalendar11) <= 0)) {
      return 9;
    }
    if ((localCalendar1.compareTo(localCalendar11) > 0) && (localCalendar1.compareTo(localCalendar12) <= 0)) {
      return 10;
    }
    if ((localCalendar1.compareTo(localCalendar12) > 0) && (localCalendar1.compareTo(localCalendar13) <= 0)) {
      return 11;
    }
    return 12;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt3 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static int a(long paramLong)
  {
    return (int)paramLong;
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Utils", 2, "onActivityResult data=null");
      }
      return -1;
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getString("result");; paramIntent = "{}")
    {
      if (QLog.isColorLevel()) {
        QLog.i("Utils", 2, "onActivityResult data=" + paramIntent);
      }
      try
      {
        int i = new JSONObject(paramIntent).optInt("resultCode", -1);
        return i;
      }
      catch (JSONException paramIntent)
      {
        if (!QLog.isColorLevel()) {
          break label122;
        }
        QLog.e("Utils", 2, "getPayResultCode " + paramIntent);
      }
    }
    label122:
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  public static int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return -1;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static int a(String paramString)
  {
    return a(paramString)[0];
  }
  
  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear(10);
    localCalendar.clear(12);
    localCalendar.clear(13);
    localCalendar.clear(14);
    return localCalendar.getTimeInMillis();
  }
  
  public static long a(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  @SuppressLint({"NewApi"})
  public static long a(File paramFile)
  {
    paramFile = new StatFs(paramFile.getPath());
    long l = paramFile.getBlockSize();
    return paramFile.getAvailableBlocks() * l;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[7] & 0xFF) << 56;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte[(paramInt + 3)]) | a(paramArrayOfByte[(paramInt + 2)]) << 8 | a(paramArrayOfByte[(paramInt + 1)]) << 16 | a(paramArrayOfByte[paramInt]) << 24;
  }
  
  public static ByteStringMicro a(String paramString)
  {
    return ByteStringMicro.copyFrom(b(paramString));
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return jdField_a_of_type_ArrayOfJavaLangString[(paramInt - 1)];
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    return a(a(paramInt1, paramInt2));
  }
  
  @SuppressLint({"NewApi"})
  public static String a(Context paramContext)
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      paramContext = "/Android/data/" + paramContext.getPackageName() + "/cache/";
      return Environment.getExternalStorageDirectory().getPath() + paramContext;
    }
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 306	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_1
    //   8: invokevirtual 312	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_0
    //   12: new 314	java/io/BufferedReader
    //   15: dup
    //   16: new 316	java/io/InputStreamReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 319	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: invokespecial 322	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore 4
    //   31: aload_0
    //   32: astore_3
    //   33: new 43	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: aload_2
    //   43: astore 4
    //   45: aload_0
    //   46: astore_3
    //   47: aload_2
    //   48: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnull +75 -> 130
    //   58: aload_2
    //   59: astore 4
    //   61: aload_0
    //   62: astore_3
    //   63: aload 5
    //   65: aload 7
    //   67: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -29 -> 42
    //   74: astore 5
    //   76: aload_2
    //   77: astore 4
    //   79: aload_0
    //   80: astore_3
    //   81: ldc 120
    //   83: iconst_1
    //   84: iconst_3
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: ldc_w 327
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload_1
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: aload 5
    //   102: aastore
    //   103: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 333	java/io/BufferedReader:close	()V
    //   114: aload 6
    //   116: astore_2
    //   117: aload_0
    //   118: ifnull +10 -> 128
    //   121: aload_0
    //   122: invokevirtual 336	java/io/InputStream:close	()V
    //   125: aload 6
    //   127: astore_2
    //   128: aload_2
    //   129: areturn
    //   130: aload_2
    //   131: astore 4
    //   133: aload_0
    //   134: astore_3
    //   135: aload 5
    //   137: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 5
    //   142: aload 5
    //   144: astore_3
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 333	java/io/BufferedReader:close	()V
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: ifnull -28 -> 128
    //   159: aload_0
    //   160: invokevirtual 336	java/io/InputStream:close	()V
    //   163: aload_3
    //   164: areturn
    //   165: astore_0
    //   166: ldc 120
    //   168: iconst_1
    //   169: iconst_3
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: ldc_w 338
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload_1
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: aload_0
    //   186: aastore
    //   187: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   190: aload_3
    //   191: areturn
    //   192: astore_2
    //   193: ldc 120
    //   195: iconst_1
    //   196: iconst_3
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: ldc_w 340
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_1
    //   209: aastore
    //   210: dup
    //   211: iconst_2
    //   212: aload_2
    //   213: aastore
    //   214: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   217: goto -64 -> 153
    //   220: astore_2
    //   221: ldc 120
    //   223: iconst_1
    //   224: iconst_3
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: ldc_w 340
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: aload_1
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: aload_2
    //   241: aastore
    //   242: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   245: goto -131 -> 114
    //   248: astore_0
    //   249: ldc 120
    //   251: iconst_1
    //   252: iconst_3
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: ldc_w 338
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: aload_1
    //   265: aastore
    //   266: dup
    //   267: iconst_2
    //   268: aload_0
    //   269: aastore
    //   270: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   273: aconst_null
    //   274: areturn
    //   275: astore_2
    //   276: aconst_null
    //   277: astore 4
    //   279: aconst_null
    //   280: astore_0
    //   281: aload 4
    //   283: ifnull +8 -> 291
    //   286: aload 4
    //   288: invokevirtual 333	java/io/BufferedReader:close	()V
    //   291: aload_0
    //   292: ifnull +7 -> 299
    //   295: aload_0
    //   296: invokevirtual 336	java/io/InputStream:close	()V
    //   299: aload_2
    //   300: athrow
    //   301: astore_3
    //   302: ldc 120
    //   304: iconst_1
    //   305: iconst_3
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: ldc_w 340
    //   314: aastore
    //   315: dup
    //   316: iconst_1
    //   317: aload_1
    //   318: aastore
    //   319: dup
    //   320: iconst_2
    //   321: aload_3
    //   322: aastore
    //   323: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   326: goto -35 -> 291
    //   329: astore_0
    //   330: ldc 120
    //   332: iconst_1
    //   333: iconst_3
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: ldc_w 338
    //   342: aastore
    //   343: dup
    //   344: iconst_1
    //   345: aload_1
    //   346: aastore
    //   347: dup
    //   348: iconst_2
    //   349: aload_0
    //   350: aastore
    //   351: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   354: goto -55 -> 299
    //   357: astore_2
    //   358: aconst_null
    //   359: astore 4
    //   361: goto -80 -> 281
    //   364: astore_2
    //   365: aload_3
    //   366: astore_0
    //   367: goto -86 -> 281
    //   370: astore 5
    //   372: aconst_null
    //   373: astore_2
    //   374: aconst_null
    //   375: astore_0
    //   376: goto -300 -> 76
    //   379: astore 5
    //   381: aconst_null
    //   382: astore_2
    //   383: goto -307 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramContext	Context
    //   0	386	1	paramString	String
    //   27	128	2	localObject1	Object
    //   192	21	2	localIOException1	IOException
    //   220	21	2	localIOException2	IOException
    //   275	25	2	localObject2	Object
    //   357	1	2	localObject3	Object
    //   364	1	2	localObject4	Object
    //   373	10	2	localObject5	Object
    //   32	159	3	localObject6	Object
    //   301	65	3	localIOException3	IOException
    //   29	331	4	localObject7	Object
    //   40	24	5	localStringBuilder	StringBuilder
    //   74	62	5	localIOException4	IOException
    //   140	3	5	str1	String
    //   370	1	5	localIOException5	IOException
    //   379	1	5	localIOException6	IOException
    //   1	125	6	localObject8	Object
    //   51	15	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   33	42	74	java/io/IOException
    //   47	53	74	java/io/IOException
    //   63	71	74	java/io/IOException
    //   135	142	74	java/io/IOException
    //   159	163	165	java/io/IOException
    //   149	153	192	java/io/IOException
    //   110	114	220	java/io/IOException
    //   121	125	248	java/io/IOException
    //   3	12	275	finally
    //   286	291	301	java/io/IOException
    //   295	299	329	java/io/IOException
    //   12	28	357	finally
    //   33	42	364	finally
    //   47	53	364	finally
    //   63	71	364	finally
    //   81	106	364	finally
    //   135	142	364	finally
    //   3	12	370	java/io/IOException
    //   12	28	379	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    int i = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {
      localStringBuilder.append("null");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramString.length() == 0)
      {
        localStringBuilder.append("");
      }
      else
      {
        int j = paramString.length();
        if (j > 10)
        {
          localStringBuilder.append(paramString.charAt(0)).append(paramString.charAt(1)).append("***").append(paramString.charAt(j - 1)).append('[').append(j).append(']');
        }
        else
        {
          localStringBuilder.append(paramString.charAt(0));
          while (i < paramString.length())
          {
            localStringBuilder.append('*');
            i += 1;
          }
        }
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (paramString == null) {
      str = paramString;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return str;
            str = paramString;
          } while (paramString.length() == 0);
          str = paramString;
        } while (paramString.length() <= paramInt);
        paramString = paramString.substring(0, paramInt);
        if (paramString.codePointAt(paramString.length() - 1) == 20) {
          break;
        }
        str = paramString;
      } while (paramString.length() < 4);
      str = paramString;
    } while (paramString.codePointAt(paramString.length() - 4) != 20);
    return paramString.substring(0, paramString.length() - 1);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { "QQ注册验证码" }, 3);
  }
  
  private static String a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    label140:
    label194:
    label323:
    label332:
    label338:
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("Utils", 2, "oriAdd=" + paramString1 + "smsbody=" + paramString2);
      }
      if (paramArrayOfString1 != null)
      {
        int j = paramArrayOfString1.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfString1[i];
          if ((str == null) || (str.length() <= 0) || (!paramString1.startsWith(str))) {}
        }
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (paramArrayOfString2 == null) || (paramArrayOfString2.length == 0) || (paramString2 == null)) {
            break label338;
          }
          j = paramArrayOfString2.length;
          i = 0;
          if (i < j)
          {
            paramString1 = paramArrayOfString2[i];
            if ((paramString1 == null) || (paramString1.length() <= 0) || (!paramString2.contains(paramString1))) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label332;
            }
            paramArrayOfString1 = paramString2.toCharArray();
            paramString1 = "";
            j = 0;
            int k = 0;
            if (j < paramArrayOfString1.length)
            {
              char c = paramArrayOfString1[j];
              if ((c >= '0') && (c <= '9'))
              {
                paramString2 = paramString1 + String.valueOf(c);
                i = 1;
              }
              do
              {
                j += 1;
                paramString1 = paramString2;
                k = i;
                break label194;
                i += 1;
                break;
                i += 1;
                break label140;
                paramString2 = paramString1;
                i = k;
              } while (k == 0);
              if (paramString1.length() < paramInt) {}
            }
            else
            {
              if ((paramString1 == null) || (paramString1.length() <= 0)) {
                break label323;
              }
            }
            for (;;)
            {
              return paramString1;
              paramString2 = "";
              i = 0;
              break;
              paramString1 = null;
            }
          }
          break;
        }
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static short a(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(a(paramArrayOfByte[(paramInt + 1)]) | a(paramArrayOfByte[paramInt]) << 8);
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      QLog.e("Utils", 1, paramCloseable, new Object[0]);
    }
  }
  
  public static void a(String paramString)
  {
    ExceptionTracker.printCallStack(paramString, 1);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(10);
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d(paramString, 2, localStringBuilder.toString());
  }
  
  public static void a(Throwable paramThrowable) {}
  
  public static boolean a()
  {
    return (Environment.getExternalStorageState().equals("mounted")) && (Environment.getExternalStorageDirectory().exists());
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.equals(paramString))
      {
        Process.killProcess(localRunningAppProcessInfo.pid);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.equals(AppConstants.VOTE_MSG_UIN)) || (paramString.equals(String.valueOf(AppConstants.JOIN_TROOP_UIN))) || (paramString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) || (paramString.equals(String.valueOf(AppConstants.LBS_HELLO_UIN))) || (paramString.equals(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN))) || (paramString.equals(String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN))) || (paramString.equals(String.valueOf(AppConstants.TROOP_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.TROOP_BAR_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATALINE_PC_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATALINE_PRINTER_UIN))) || (paramString.equals(String.valueOf(AppConstants.SMARTDEVICE_UIN))) || (paramString.equals(String.valueOf(AppConstants.SUBACCOUNT_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.SAME_STATE_BOX_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATE_UIN))) || (paramString.equals(String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN))) || (paramString.equals(String.valueOf(AppConstants.SEC_MSG_UIN))) || (paramString.equals(String.valueOf(AppConstants.WIFI_HOT_CHAT_UIN))) || (paramString.equals(String.valueOf(AppConstants.ACTIVATE_FRIENDS_UIN))) || (paramString.equals(String.valueOf(AppConstants.EC_SHOP_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.READINJOY_UIN))) || (paramString.equals(String.valueOf(AppConstants.DINGDONG_UIN))) || (paramString.equals(String.valueOf(AppConstants.SEND_BLESS_UIN))) || (paramString.equals(String.valueOf(AppConstants.KANDIAN_MERGE_UIN))) || (paramString.equals(String.valueOf(66600000L))) || (paramString.equals(String.valueOf(9946L))) || (paramString.equals(String.valueOf(AppConstants.CONFESS_UIN))) || (paramString.equals(String.valueOf(AppConstants.TEMP_MSG_BOX_UIN)));
  }
  
  public static byte[] a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)((0xFF00 & paramInt) >> 8);
    int k = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), k, j, i };
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = null;
      return paramString;
    }
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = a(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static int[] a(String paramString)
  {
    int[] arrayOfInt = new int[2];
    if (paramString == null)
    {
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      return arrayOfInt;
    }
    int n = paramString.length();
    int j = 0;
    int i = 0;
    int k = 0;
    int m;
    if (j < n)
    {
      m = paramString.codePointAt(j);
      if (m == 20) {
        if ((j + 4 < n) && ((paramString.charAt(j + 1) == 'ÿ') || (paramString.charAt(j + 1) == 'ǿ')))
        {
          m = j + 4;
          i += 1;
          j = k + 20;
          k = m;
        }
      }
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = m;
      break;
      if ((j + 1 < n) && (paramString.charAt(j + 1) >= 'Ą')) {
        k += 40;
      }
      for (;;)
      {
        m = k;
        k = j + 1;
        j = m;
        break;
        k += 12;
      }
      k = a(m) + k;
      if (m > 255)
      {
        m = j + 1;
        j = k;
        k = m;
        continue;
        arrayOfInt[0] = k;
        arrayOfInt[1] = i;
        return arrayOfInt;
      }
      else
      {
        m = k;
        k = j;
        j = m;
      }
    }
  }
  
  public static int b(long paramLong1, long paramLong2)
  {
    return a(paramLong1 - -9223372036854775808L, -9223372036854775808L + paramLong2);
  }
  
  public static long b()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    int i = localStatFs.getBlockSize();
    int j = localStatFs.getAvailableBlocks();
    long l = i;
    return j * l;
  }
  
  public static String b(String paramString, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("len must be greater than 0,len is:" + paramInt);
    }
    if (paramString == null) {}
    while (paramString.length() <= paramInt) {
      return paramString;
    }
    return paramString.substring(0, paramInt) + "...";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    String str = HardCodeUtil.a(2131699558);
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { str, "Login Verification Code" }, 3);
  }
  
  public static boolean b()
  {
    Boolean localBoolean = jdField_a_of_type_JavaLangBoolean;
    Object localObject = localBoolean;
    long l1;
    if (localBoolean == null)
    {
      localObject = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      if (localObject != null)
      {
        localObject = ((SimpleAccount)localObject).getUin();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          l1 = 0L;
        }
      }
    }
    else
    {
      try
      {
        long l2 = Long.parseLong((String)localObject);
        l1 = l2;
      }
      catch (Exception localException)
      {
        label52:
        break label52;
      }
      if (!jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(l1))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      localObject = Boolean.valueOf(bool);
      return ((Boolean)localObject).booleanValue();
    }
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return AppConstants.BABY_Q_UIN.equals(paramString);
  }
  
  public static byte[] b(String paramString)
  {
    int j = 0;
    int k = paramString.length();
    if ((k & 0x1) != 0) {
      throw new RuntimeException("Odd number of characters.");
    }
    byte[] arrayOfByte = new byte[k >> 1];
    int i = 0;
    while (j < k)
    {
      int m = j + 1;
      int n = Character.digit(paramString.charAt(j), 16);
      j = m + 1;
      arrayOfByte[i] = ((byte)((Character.digit(paramString.charAt(m), 16) | n << 4) & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String c(String paramString1, String paramString2)
  {
    String str1 = HardCodeUtil.a(2131699555);
    String str2 = HardCodeUtil.a(2131699546);
    return a(paramString1, paramString2, new String[] { "1062", "1065", "1066", "1069" }, new String[] { str1, str2 }, 3);
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    List localList = MobileQQ.sMobileQQ.getAllAccounts();
    boolean bool1 = bool2;
    if (localList != null)
    {
      bool1 = bool2;
      if (localList.size() >= 8) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Utils", 2, "isAccountNumExceedMax, isExceed=" + bool1);
    }
    return bool1;
  }
  
  public static boolean c(String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      label9:
      break label9;
    }
    return ((l1 >= 2726500000L) && (l1 <= 2726511999L)) || ((l1 >= 800000000L) && (l1 <= 800099999L)) || ((l1 >= 938000000L) && (l1 <= 938099999L)) || ((l1 >= 1068660000L) && (l1 <= 1068669960L)) || ((l1 >= 2355000000L) && (l1 <= 2355199999L)) || (l1 == 56268888L);
  }
  
  public static String d(String paramString1, String paramString2)
  {
    String str1 = HardCodeUtil.a(2131699551);
    String str2 = HardCodeUtil.a(2131699552);
    return a(paramString1, paramString2, new String[] { "10010", "106" }, new String[] { str1, str2, "QQ" }, 3);
  }
  
  public static boolean d(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!"0".equals(paramString)) && (!"10000".equals(paramString)) && (!"1000000".equals(paramString)) && (!"80000000".equals(paramString));
  }
  
  public static boolean e(String paramString)
  {
    return Pattern.matches(jdField_a_of_type_JavaLangString, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.Utils
 * JD-Core Version:    0.7.0.1
 */