package com.tencent.mobileqq.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
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
import java.nio.charset.Charset;
import java.security.MessageDigest;
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
  protected static final char[] a = { 12290, -225, -255, 33, 63, -244, -229, 44, 32 };
  protected static String b = ".*(\\+86|086)?\\d{5,12}.*";
  public static String c = "";
  public static String d;
  public static final String[] e = { HardCodeUtil.a(2131897687), HardCodeUtil.a(2131897685), HardCodeUtil.a(2131897696), HardCodeUtil.a(2131897690), HardCodeUtil.a(2131897697), HardCodeUtil.a(2131897688), HardCodeUtil.a(2131897683), HardCodeUtil.a(2131897694), HardCodeUtil.a(2131897693), HardCodeUtil.a(2131897699), HardCodeUtil.a(2131897684), HardCodeUtil.a(2131897689) };
  static Boolean f = null;
  private static final Set<Long> g = new Utils.1(100);
  private static StringBuilder h;
  private static int i;
  
  static
  {
    d = null;
    h = new StringBuilder();
    i = 0;
  }
  
  public static final float a(int paramInt, Resources paramResources)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return paramInt / paramResources.getDisplayMetrics().density;
  }
  
  public static int a(byte paramByte)
  {
    int j = paramByte;
    if (paramByte < 0) {
      j = paramByte + 256;
    }
    return j;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
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
    int j = paramInt1;
    if (paramInt2 != 0)
    {
      j = paramInt1;
      if (paramInt3 != 0)
      {
        if (paramInt2 == paramInt3) {
          return paramInt1;
        }
        j = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
      }
    }
    return j;
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
    if (paramIntent != null) {
      paramIntent = paramIntent.getString("result");
    } else {
      paramIntent = "{}";
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResult data=");
      localStringBuilder.append(paramIntent);
      QLog.i("Utils", 2, localStringBuilder.toString());
    }
    try
    {
      int j = new JSONObject(paramIntent).optInt("resultCode", -1);
      return j;
    }
    catch (JSONException paramIntent)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPayResultCode ");
        localStringBuilder.append(paramIntent);
        QLog.e("Utils", 2, localStringBuilder.toString());
      }
    }
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
    return paramFile.getBlockSize() * paramFile.getAvailableBlocks();
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[7] & 0xFF) << 56;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = a(paramArrayOfByte[(paramInt + 3)]);
    long l2 = a(paramArrayOfByte[(paramInt + 2)]) << 8;
    long l3 = a(paramArrayOfByte[(paramInt + 1)]) << 16;
    return a(paramArrayOfByte[paramInt]) << 24 | l1 | l2 | l3;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramString;
    }
    String str = paramString;
    if (paramString.length() != 0)
    {
      if (paramString.length() <= paramInt) {
        return paramString;
      }
      paramString = paramString.substring(0, paramInt);
      if ((paramString.codePointAt(paramString.length() - 1) != 20) && ((paramString.length() < 4) || (paramString.codePointAt(paramString.length() - 4) != 20))) {
        return paramString;
      }
      str = paramString.substring(0, paramString.length() - 1);
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { "QQ注册验证码" }, 3);
  }
  
  private static String a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString1 != null)
    {
      localObject1 = localObject2;
      if (paramString1.length() != 0)
      {
        localObject1 = localObject2;
        if (paramString2 != null)
        {
          if (paramString2.length() == 0) {
            return null;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("oriAdd=");
            ((StringBuilder)localObject1).append(paramString1);
            ((StringBuilder)localObject1).append("smsbody=");
            ((StringBuilder)localObject1).append(paramString2);
            QLog.d("Utils", 2, ((StringBuilder)localObject1).toString());
          }
          if (paramArrayOfString1 == null) {
            return null;
          }
          int k = paramArrayOfString1.length;
          int j = 0;
          while (j < k)
          {
            localObject1 = paramArrayOfString1[j];
            if ((localObject1 != null) && (((String)localObject1).length() > 0) && (paramString1.startsWith((String)localObject1)))
            {
              j = 1;
              break label161;
            }
            j += 1;
          }
          j = 0;
          label161:
          if (j == 0) {
            return null;
          }
          localObject1 = localObject2;
          if (paramArrayOfString2 != null)
          {
            localObject1 = localObject2;
            if (paramArrayOfString2.length != 0)
            {
              if (paramString2 == null) {
                return null;
              }
              k = paramArrayOfString2.length;
              j = 0;
              while (j < k)
              {
                paramString1 = paramArrayOfString2[j];
                if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2.contains(paramString1)))
                {
                  j = 1;
                  break label247;
                }
                j += 1;
              }
              j = 0;
              label247:
              if (j == 0) {
                return null;
              }
              paramArrayOfString1 = paramString2.toCharArray();
              paramString1 = "";
              k = 0;
              for (int m = 0; k < paramArrayOfString1.length; m = j)
              {
                char c1 = paramArrayOfString1[k];
                if ((c1 >= '0') && (c1 <= '9'))
                {
                  paramString2 = new StringBuilder();
                  paramString2.append(paramString1);
                  paramString2.append(String.valueOf(c1));
                  paramString2 = paramString2.toString();
                  j = 1;
                }
                else
                {
                  paramString2 = paramString1;
                  j = m;
                  if (m != 0)
                  {
                    if (paramString1.length() >= paramInt) {
                      break;
                    }
                    paramString2 = "";
                    j = 0;
                  }
                }
                k += 1;
                paramString1 = paramString2;
              }
              localObject1 = localObject2;
              if (paramString1 != null)
              {
                localObject1 = localObject2;
                if (paramString1.length() > 0) {
                  localObject1 = paramString1;
                }
              }
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setClickable(false);
    paramView.postDelayed(new Utils.2(paramView), 500L);
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (paramView == null) {
        return;
      }
      Rect localRect = new Rect();
      paramDrawable.getPadding(localRect);
      int j = paramView.getPaddingTop();
      int k = localRect.top;
      int m = paramView.getPaddingLeft();
      int n = localRect.left;
      int i1 = paramView.getPaddingRight();
      int i2 = localRect.right;
      int i3 = paramView.getPaddingBottom();
      int i4 = localRect.bottom;
      paramView.setBackgroundDrawable(paramDrawable);
      paramView.setPadding(m + n, j + k, i1 + i2, i3 + i4);
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
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
  }
  
  public static void a(String paramString)
  {
    ExceptionTracker.printCallStack(paramString, 1);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(10);
    int k = paramVarArgs.length;
    int j = 0;
    while (j < k)
    {
      localStringBuilder.append(paramVarArgs[j]);
      j += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar >= '一') && (paramChar <= 40895);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
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
    }
    return false;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private static byte b(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static float b(float paramFloat, Resources paramResources)
  {
    return paramFloat * paramResources.getDisplayMetrics().density + 0.5F;
  }
  
  public static int b(int paramInt)
  {
    int k = h.length();
    int j = 2;
    if (k > 560) {}
    try
    {
      k = h.toString().getBytes("utf-8").length;
      if ((i != k) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("calculate byte num not equal byte num returned by getBytes(),totalByteNum is:");
        localStringBuilder.append(i);
        localStringBuilder.append(",byteNum");
        localStringBuilder.append(k);
        QLog.d("Utils", 2, localStringBuilder.toString());
      }
      label91:
      h.setLength(0);
      i = 0;
      if ((paramInt >= 0) && (paramInt < 128)) {
        j = 1;
      } else if ((paramInt < 128) || (paramInt >= 2048)) {
        if ((paramInt >= 2048) && (paramInt < 65536)) {
          j = 3;
        } else if ((paramInt >= 65536) && (paramInt < 2097152)) {
          j = 4;
        } else if ((paramInt >= 2097152) && (paramInt < 67108864)) {
          j = 5;
        } else {
          j = 6;
        }
      }
      h.append(Character.toChars(paramInt));
      i += j;
      return j;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label91;
    }
  }
  
  public static int b(long paramLong1, long paramLong2)
  {
    return a(paramLong1 - -9223372036854775808L, paramLong2 - -9223372036854775808L);
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    return c(a(paramInt1, paramInt2));
  }
  
  @SuppressLint({"NewApi"})
  public static String b(Context paramContext)
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/Android/data/");
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append("/cache/");
      paramContext = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append(paramContext);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 463	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_1
    //   8: invokevirtual 469	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_2
    //   12: new 471	java/io/BufferedReader
    //   15: dup
    //   16: new 473	java/io/InputStreamReader
    //   19: dup
    //   20: aload_2
    //   21: invokespecial 476	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: invokespecial 479	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_0
    //   28: aload_0
    //   29: astore_3
    //   30: aload_2
    //   31: astore 4
    //   33: new 54	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: aload_0
    //   43: astore_3
    //   44: aload_2
    //   45: astore 4
    //   47: aload_0
    //   48: invokevirtual 482	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnull +19 -> 74
    //   58: aload_0
    //   59: astore_3
    //   60: aload_2
    //   61: astore 4
    //   63: aload 5
    //   65: aload 7
    //   67: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -29 -> 42
    //   74: aload_0
    //   75: astore_3
    //   76: aload_2
    //   77: astore 4
    //   79: aload 5
    //   81: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 5
    //   86: aload_0
    //   87: invokevirtual 483	java/io/BufferedReader:close	()V
    //   90: goto +28 -> 118
    //   93: astore_0
    //   94: ldc 130
    //   96: iconst_1
    //   97: iconst_3
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: ldc_w 485
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_1
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: aload_0
    //   114: aastore
    //   115: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   118: aload 5
    //   120: astore_0
    //   121: aload_2
    //   122: ifnull +177 -> 299
    //   125: aload_2
    //   126: invokevirtual 491	java/io/InputStream:close	()V
    //   129: aload 5
    //   131: areturn
    //   132: astore_0
    //   133: ldc 130
    //   135: iconst_1
    //   136: iconst_3
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: ldc_w 493
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: aload_1
    //   149: aastore
    //   150: dup
    //   151: iconst_2
    //   152: aload_0
    //   153: aastore
    //   154: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   157: aload 5
    //   159: areturn
    //   160: astore 5
    //   162: goto +30 -> 192
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_3
    //   168: goto +137 -> 305
    //   171: astore 5
    //   173: aconst_null
    //   174: astore_0
    //   175: goto +17 -> 192
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_3
    //   181: aload_3
    //   182: astore_2
    //   183: goto +122 -> 305
    //   186: astore 5
    //   188: aconst_null
    //   189: astore_2
    //   190: aload_2
    //   191: astore_0
    //   192: aload_0
    //   193: astore_3
    //   194: aload_2
    //   195: astore 4
    //   197: ldc 130
    //   199: iconst_1
    //   200: iconst_3
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: ldc_w 495
    //   209: aastore
    //   210: dup
    //   211: iconst_1
    //   212: aload_1
    //   213: aastore
    //   214: dup
    //   215: iconst_2
    //   216: aload 5
    //   218: aastore
    //   219: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   222: aload_0
    //   223: ifnull +35 -> 258
    //   226: aload_0
    //   227: invokevirtual 483	java/io/BufferedReader:close	()V
    //   230: goto +28 -> 258
    //   233: astore_0
    //   234: ldc 130
    //   236: iconst_1
    //   237: iconst_3
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: ldc_w 485
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: aload_1
    //   250: aastore
    //   251: dup
    //   252: iconst_2
    //   253: aload_0
    //   254: aastore
    //   255: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   258: aload 6
    //   260: astore_0
    //   261: aload_2
    //   262: ifnull +37 -> 299
    //   265: aload_2
    //   266: invokevirtual 491	java/io/InputStream:close	()V
    //   269: aconst_null
    //   270: areturn
    //   271: astore_0
    //   272: ldc 130
    //   274: iconst_1
    //   275: iconst_3
    //   276: anewarray 4	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: ldc_w 493
    //   284: aastore
    //   285: dup
    //   286: iconst_1
    //   287: aload_1
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: aload_0
    //   292: aastore
    //   293: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   296: aload 6
    //   298: astore_0
    //   299: aload_0
    //   300: areturn
    //   301: astore_0
    //   302: aload 4
    //   304: astore_2
    //   305: aload_3
    //   306: ifnull +35 -> 341
    //   309: aload_3
    //   310: invokevirtual 483	java/io/BufferedReader:close	()V
    //   313: goto +28 -> 341
    //   316: astore_3
    //   317: ldc 130
    //   319: iconst_1
    //   320: iconst_3
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: ldc_w 485
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: aload_1
    //   333: aastore
    //   334: dup
    //   335: iconst_2
    //   336: aload_3
    //   337: aastore
    //   338: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   341: aload_2
    //   342: ifnull +35 -> 377
    //   345: aload_2
    //   346: invokevirtual 491	java/io/InputStream:close	()V
    //   349: goto +28 -> 377
    //   352: astore_2
    //   353: ldc 130
    //   355: iconst_1
    //   356: iconst_3
    //   357: anewarray 4	java/lang/Object
    //   360: dup
    //   361: iconst_0
    //   362: ldc_w 493
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: aload_1
    //   369: aastore
    //   370: dup
    //   371: iconst_2
    //   372: aload_2
    //   373: aastore
    //   374: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   377: goto +5 -> 382
    //   380: aload_0
    //   381: athrow
    //   382: goto -2 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramContext	Context
    //   0	385	1	paramString	String
    //   11	335	2	localObject1	Object
    //   352	21	2	localIOException1	IOException
    //   29	281	3	localContext	Context
    //   316	21	3	localIOException2	IOException
    //   31	272	4	localObject2	Object
    //   40	118	5	localObject3	Object
    //   160	1	5	localIOException3	IOException
    //   171	1	5	localIOException4	IOException
    //   186	31	5	localIOException5	IOException
    //   1	296	6	localObject4	Object
    //   51	15	7	str	String
    // Exception table:
    //   from	to	target	type
    //   86	90	93	java/io/IOException
    //   125	129	132	java/io/IOException
    //   33	42	160	java/io/IOException
    //   47	53	160	java/io/IOException
    //   63	71	160	java/io/IOException
    //   79	86	160	java/io/IOException
    //   12	28	165	finally
    //   12	28	171	java/io/IOException
    //   3	12	178	finally
    //   3	12	186	java/io/IOException
    //   226	230	233	java/io/IOException
    //   265	269	271	java/io/IOException
    //   33	42	301	finally
    //   47	53	301	finally
    //   63	71	301	finally
    //   79	86	301	finally
    //   197	222	301	finally
    //   309	313	316	java/io/IOException
    //   345	349	352	java/io/IOException
  }
  
  public static String b(String paramString, int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramString == null) {
        return paramString;
      }
      if (paramString.length() <= paramInt) {
        return paramString;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(0, paramInt));
      localStringBuilder.append("...");
      return localStringBuilder.toString();
    }
    paramString = new StringBuilder();
    paramString.append("len must be greater than 0,len is:");
    paramString.append(paramInt);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public static String b(String paramString1, String paramString2)
  {
    String str = HardCodeUtil.a(2131897698);
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { str, "Login Verification Code" }, 3);
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
      int j = 0;
      while (j < paramArrayOfByte.length)
      {
        String str = Integer.toHexString(paramArrayOfByte[j] & 0xFF);
        if (str.length() < 2) {
          localStringBuffer.append(0);
        }
        localStringBuffer.append(str.toUpperCase());
        j += 1;
      }
      return localStringBuffer.toString();
    }
    return null;
  }
  
  public static short b(byte[] paramArrayOfByte, int paramInt)
  {
    int j = a(paramArrayOfByte[(paramInt + 1)]);
    return (short)(a(paramArrayOfByte[paramInt]) << 8 | j);
  }
  
  public static boolean b()
  {
    return (Environment.getExternalStorageState().equals("mounted")) && (Environment.getExternalStorageDirectory().exists());
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.equals(AppConstants.VOTE_MSG_UIN)) || (paramString.equals(String.valueOf(AppConstants.JOIN_TROOP_UIN))) || (paramString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) || (paramString.equals(String.valueOf(AppConstants.LBS_HELLO_UIN))) || (paramString.equals(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN))) || (paramString.equals(String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN))) || (paramString.equals(String.valueOf(AppConstants.TROOP_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.TROOP_BAR_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATALINE_PC_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATALINE_PRINTER_UIN))) || (paramString.equals(String.valueOf(AppConstants.SMARTDEVICE_UIN))) || (paramString.equals(String.valueOf(AppConstants.SUBACCOUNT_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.SAME_STATE_BOX_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATE_UIN))) || (paramString.equals(String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN))) || (paramString.equals(String.valueOf(AppConstants.SEC_MSG_UIN))) || (paramString.equals(String.valueOf(AppConstants.WIFI_HOT_CHAT_UIN))) || (paramString.equals(String.valueOf(AppConstants.ACTIVATE_FRIENDS_UIN))) || (paramString.equals(String.valueOf(AppConstants.EC_SHOP_ASSISTANT_UIN))) || (paramString.equals(String.valueOf(AppConstants.READINJOY_UIN))) || (paramString.equals(String.valueOf(AppConstants.DINGDONG_UIN))) || (paramString.equals(String.valueOf(AppConstants.SEND_BLESS_UIN))) || (paramString.equals(String.valueOf(AppConstants.KANDIAN_MERGE_UIN))) || (paramString.equals(String.valueOf(66600000L))) || (paramString.equals(String.valueOf(9946L))) || (paramString.equals(String.valueOf(AppConstants.CONFESS_UIN))) || (paramString.equals(String.valueOf(AppConstants.TEMP_MSG_BOX_UIN)));
  }
  
  public static long c()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    int j = localStatFs.getBlockSize();
    int k = localStatFs.getAvailableBlocks();
    return j * k;
  }
  
  public static String c(int paramInt)
  {
    if (paramInt >= 1)
    {
      String[] arrayOfString = e;
      if (paramInt <= arrayOfString.length) {
        return arrayOfString[(paramInt - 1)];
      }
    }
    return "";
  }
  
  public static String c(String paramString1, String paramString2)
  {
    String str1 = HardCodeUtil.a(2131897695);
    String str2 = HardCodeUtil.a(2131897686);
    return a(paramString1, paramString2, new String[] { "1062", "1065", "1066", "1069" }, new String[] { str1, str2 }, 3);
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return AppConstants.BABY_Q_UIN.equals(paramString);
  }
  
  public static String d(String paramString1, String paramString2)
  {
    String str1 = HardCodeUtil.a(2131897691);
    String str2 = HardCodeUtil.a(2131897692);
    return a(paramString1, paramString2, new String[] { "10010", "106" }, new String[] { str1, str2, "QQ" }, 3);
  }
  
  public static boolean d()
  {
    Boolean localBoolean = f;
    Object localObject = localBoolean;
    boolean bool2;
    long l1;
    if (localBoolean == null)
    {
      bool2 = false;
      localObject = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((SimpleAccount)localObject).getUin();
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          l1 = 0L;
        }
      }
    }
    try
    {
      long l2 = Long.parseLong((String)localObject);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label60:
      break label60;
    }
    boolean bool1 = bool2;
    if (g.contains(Long.valueOf(l1))) {
      bool1 = true;
    }
    localObject = Boolean.valueOf(bool1);
    return ((Boolean)localObject).booleanValue();
  }
  
  public static boolean d(String paramString)
  {
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (NumberFormatException paramString)
    {
      long l;
      label8:
      break label8;
    }
    l = 0L;
    return ((l >= 2726500000L) && (l <= 2726511999L)) || ((l >= 800000000L) && (l <= 800099999L)) || ((l >= 938000000L) && (l <= 938099999L)) || ((l >= 1068660000L) && (l <= 1068669960L)) || ((l >= 2355000000L) && (l <= 2355199999L)) || (l == 56268888L);
  }
  
  public static byte[] d(int paramInt)
  {
    int j = (byte)(paramInt & 0xFF);
    int k = (byte)((0xFF00 & paramInt) >> 8);
    int m = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((paramInt & 0xFF000000) >> 24), m, k, j };
  }
  
  public static String e(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt < 10000)) {
      return String.valueOf(paramInt);
    }
    StringBuilder localStringBuilder;
    float f1;
    if ((paramInt >= 10000) && (paramInt < 100000000))
    {
      if (paramInt % 10000 < 500)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt / 10000);
        localStringBuilder.append("万");
        return localStringBuilder.toString();
      }
      f1 = paramInt * 1.0F / 10000.0F;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Math.round(f1 * 10.0F) * 1.0F / 10.0F);
      localStringBuilder.append("万");
      return localStringBuilder.toString();
    }
    if (paramInt >= 100000000)
    {
      if (paramInt % 100000000 < 5000000)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt / 100000000);
        localStringBuilder.append("亿");
        return localStringBuilder.toString();
      }
      f1 = paramInt * 1.0F / 1.0E+008F;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Math.round(f1 * 10.0F) * 1.0F / 10.0F);
      localStringBuilder.append("亿");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static boolean e()
  {
    Object localObject = MobileQQ.sMobileQQ.getAllAccounts();
    boolean bool;
    if ((localObject != null) && (((List)localObject).size() >= 8)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isAccountNumExceedMax, isExceed=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Utils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean e(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!"0".equals(paramString)) && (!"10000".equals(paramString)) && (!"1000000".equals(paramString)) && (!"80000000".equals(paramString));
  }
  
  public static int f(String paramString)
  {
    return g(paramString)[0];
  }
  
  public static int[] g(String paramString)
  {
    int[] arrayOfInt = new int[2];
    if (paramString == null)
    {
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      return arrayOfInt;
    }
    int i3 = paramString.length();
    int m = 0;
    int j = 0;
    int i1;
    for (int n = 0; m < i3; n = i1)
    {
      int i4 = paramString.codePointAt(m);
      int k;
      if (i4 == 20)
      {
        k = m + 4;
        if (k < i3)
        {
          i1 = m + 1;
          if ((paramString.charAt(i1) == 'ÿ') || (paramString.charAt(i1) == 'ǿ'))
          {
            j += 20;
            i1 = n + 1;
            break label190;
          }
        }
        k = m + 1;
        if ((k < i3) && (paramString.charAt(k) >= 'Ą'))
        {
          j += 40;
          i1 = n;
        }
        else
        {
          j += 12;
          i1 = n;
        }
      }
      else
      {
        int i2 = j + b(i4);
        k = m;
        j = i2;
        i1 = n;
        if (i4 > 255)
        {
          k = m + 1;
          i1 = n;
          j = i2;
        }
      }
      label190:
      m = k + 1;
    }
    arrayOfInt[0] = j;
    arrayOfInt[1] = n;
    return arrayOfInt;
  }
  
  public static byte[] h(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      int k = paramString.length() / 2;
      byte[] arrayOfByte = new byte[k];
      paramString = paramString.toUpperCase().toCharArray();
      int j = 0;
      while (j < k)
      {
        int m = j * 2;
        int n = b(paramString[m]);
        arrayOfByte[j] = ((byte)(b(paramString[(m + 1)]) | n << 4));
        j += 1;
      }
      return arrayOfByte;
    }
    return null;
  }
  
  public static String i(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null)
    {
      localStringBuilder.append("null");
    }
    else if (paramString.length() == 0)
    {
      localStringBuilder.append("");
    }
    else
    {
      int k = paramString.length();
      int j = 1;
      if (k > 10)
      {
        localStringBuilder.append(paramString.charAt(0));
        localStringBuilder.append(paramString.charAt(1));
        localStringBuilder.append("***");
        localStringBuilder.append(paramString.charAt(k - 1));
        localStringBuilder.append('[');
        localStringBuilder.append(k);
        localStringBuilder.append(']');
      }
      else
      {
        localStringBuilder.append(paramString.charAt(0));
        while (j < paramString.length())
        {
          localStringBuilder.append('*');
          j += 1;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean j(String paramString)
  {
    return Pattern.matches(b, paramString);
  }
  
  public static ByteStringMicro k(String paramString)
  {
    return ByteStringMicro.copyFrom(l(paramString));
  }
  
  public static byte[] l(String paramString)
  {
    int m = paramString.length();
    if ((m & 0x1) == 0)
    {
      byte[] arrayOfByte = new byte[m >> 1];
      int j = 0;
      int k = 0;
      while (j < m)
      {
        int n = j + 1;
        arrayOfByte[k] = ((byte)((Character.digit(paramString.charAt(j), 16) << 4 | Character.digit(paramString.charAt(n), 16)) & 0xFF));
        k += 1;
        j = n + 1;
      }
      return arrayOfByte;
    }
    paramString = new RuntimeException("Odd number of characters.");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static String m(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int k = localObject.length;
      int j = 0;
      while (j < k)
      {
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(localObject[j] & 0xFF) }));
        j += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static int n(String paramString)
  {
    int k = 0;
    int j = 0;
    while (k < paramString.length())
    {
      if (a(paramString.charAt(k))) {
        j += 2;
      } else {
        j += 1;
      }
      k += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMixStringLength, str :");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",length :");
    localStringBuilder.append(j);
    QLog.d("Utils", 1, localStringBuilder.toString());
    return j;
  }
  
  public static String o(@NonNull String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("armeabi-v7a");
    localObject = ((StringBuilder)localObject).toString();
    if (!new File((String)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("appendAbiSuffixIfExists, ");
      ((StringBuilder)localObject).append("armeabi-v7a");
      ((StringBuilder)localObject).append(" path not exist.");
      QLog.i("Utils", 2, ((StringBuilder)localObject).toString());
      return paramString;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.Utils
 * JD-Core Version:    0.7.0.1
 */