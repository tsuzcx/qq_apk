package com.tencent.mobileqq.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Utils
{
  private static int jdField_a_of_type_Int;
  public static String a;
  private static StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private static final Set jdField_a_of_type_JavaUtilSet;
  private static final char[] jdField_a_of_type_ArrayOfChar = { 12290, -225, -255, 33, 63, -244, -229, 44, 32 };
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new Utils.1(100);
    jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
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
  
  private static int a(int paramInt)
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
  
  @SuppressLint({"NewApi"})
  public static int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return -1;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private static int a(String paramString)
  {
    int k = 0;
    int n = paramString.length();
    int i = 0;
    if (k < n)
    {
      int i1 = paramString.codePointAt(k);
      int j;
      if (i1 == 20) {
        if ((k + 4 < n) && (paramString.charAt(k + 1) == 'ÿ'))
        {
          i += 20;
          j = k + 4;
        }
      }
      for (;;)
      {
        k = j + 1;
        break;
        i += 12;
        j = k + 1;
        continue;
        int m = i + a(i1);
        j = k;
        i = m;
        if (i1 > 255)
        {
          j = k + 1;
          i = m;
        }
      }
    }
    return i;
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
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "0|0";
    }
    return paramString.charAt(0) + "|" + paramString.length();
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
    label193:
    label330:
    label336:
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
            break label336;
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
              break label330;
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
                break label193;
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
                break label321;
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
  
  public static ArrayList a(String paramString, int paramInt1, int paramInt2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ArrayList localArrayList2 = new ArrayList();
    int i2 = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    ArrayList localArrayList1 = null;
    int i1 = 0;
    int j = 0;
    int n = 0;
    int i3;
    int k;
    label62:
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
    String str1;
    label171:
    label195:
    String str2;
    int i4;
    String str3;
    if (j < i2)
    {
      i3 = paramString.codePointAt(j);
      k = i;
      if (paramArrayList1 == null) {
        break label1109;
      }
      k = i;
      if (i >= paramArrayList1.size()) {
        break label1109;
      }
      localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)paramArrayList1.get(i);
      if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.isValid()))
      {
        if ((localAtTroopMemberInfo == null) || (localAtTroopMemberInfo.startPos != j)) {
          break label477;
        }
        str1 = paramString.substring(localAtTroopMemberInfo.startPos, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen);
        k = a(str1);
        localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + i1));
        if (localArrayList1 != null) {
          break label1106;
        }
        localArrayList1 = new ArrayList();
        localArrayList1.add(localAtTroopMemberInfo);
        k = k + 11 + 8;
        i += 1;
        if (n + k <= paramInt1) {
          break label821;
        }
        str2 = localStringBuilder.toString();
        m = -1;
        if (localArrayList1 != null) {
          break label653;
        }
        i4 = str2.length() - paramInt2;
        n = 0;
      }
      for (;;)
      {
        if (n < jdField_a_of_type_ArrayOfChar.length)
        {
          m = str2.lastIndexOf(jdField_a_of_type_ArrayOfChar[n]);
          if (m <= i4) {}
        }
        else
        {
          n = str2.lastIndexOf('\024');
          if ((m <= i4) || (n != -1)) {
            break label549;
          }
          str2 = localStringBuilder.substring(0, m + 1);
          str3 = localStringBuilder.substring(m + 1);
          localStringBuilder.setLength(0);
          m = a(str3);
          localStringBuilder.append(str3);
          label326:
          i4 = str2.length();
          localArrayList2.add(str2);
          paramArrayList2.add(localArrayList1);
          if (str1 == null) {
            break label665;
          }
          localStringBuilder.append(str1);
          n = localAtTroopMemberInfo.textLen - 1 + j;
          label374:
          j = n;
          if (i3 == 20)
          {
            if (n + 1 < i2) {
              break label706;
            }
            j = n;
            if (QLog.isColorLevel())
            {
              QLog.e("Utils", 2, "there is no other char behind EMO_HEAD_CODE,msg is:" + paramString);
              j = n;
            }
          }
          label434:
          localArrayList1 = null;
          m += k;
          k = i1 - i4;
          j += 1;
          i1 = k;
          n = m;
          break;
          i += 1;
          break label62;
          label477:
          if (i3 == 20)
          {
            if ((j + 1 < i2) && (paramString.charAt(j + 1) == 'ÿ'))
            {
              str1 = null;
              k = 20;
              break label195;
            }
            str1 = null;
            k = 12;
            break label195;
          }
          k = a(i3);
          str1 = null;
          break label195;
        }
        n += 1;
      }
      label549:
      if ((n - 2 < 0) || (str2.charAt(n - 1) != 'ÿ') || (str2.charAt(n - 2) != '\024')) {
        break label1119;
      }
    }
    label653:
    label665:
    label706:
    label846:
    label1106:
    label1109:
    label1119:
    for (int m = n - 2;; m = n)
    {
      if (m > i4)
      {
        str2 = localStringBuilder.substring(0, m);
        str3 = localStringBuilder.substring(m);
        localStringBuilder.setLength(0);
        m = a(str3);
        localStringBuilder.append(str3);
        break label326;
      }
      localStringBuilder.setLength(0);
      m = 0;
      break label326;
      localStringBuilder.setLength(0);
      m = 0;
      break label326;
      if (i3 > 65535)
      {
        localStringBuilder.appendCodePoint(i3);
        n = j + 1;
        break label374;
      }
      localStringBuilder.append((char)i3);
      n = j;
      break label374;
      if ('ÿ' == paramString.charAt(n + 1))
      {
        j = n;
        if (n + 4 >= i2) {
          break label434;
        }
        localStringBuilder.append(paramString.charAt(n + 1));
        localStringBuilder.append(paramString.charAt(n + 2));
        localStringBuilder.append(paramString.charAt(n + 3));
        localStringBuilder.append(paramString.charAt(n + 4));
        j = n + 4;
        break label434;
      }
      localStringBuilder.append(paramString.charAt(n + 1));
      j = n + 1;
      break label434;
      if (str1 != null)
      {
        localStringBuilder.append(str1);
        m = localAtTroopMemberInfo.textLen - 1 + j;
        j = m;
        if (i3 == 20)
        {
          if (m + 1 < i2) {
            break label961;
          }
          j = m;
          if (QLog.isColorLevel())
          {
            QLog.e("Utils", 2, "there is no other char behind EMO_HEAD_CODE,msg is:" + paramString);
            j = m;
          }
        }
      }
      for (;;)
      {
        m = n + k;
        k = i1;
        break;
        if (i3 > 65535)
        {
          localStringBuilder.appendCodePoint(i3);
          m = j + 1;
          break label846;
        }
        localStringBuilder.append((char)i3);
        m = j;
        break label846;
        if ('ÿ' == paramString.charAt(m + 1))
        {
          j = m;
          if (m + 4 < i2)
          {
            localStringBuilder.append(paramString.charAt(m + 1));
            localStringBuilder.append(paramString.charAt(m + 2));
            localStringBuilder.append(paramString.charAt(m + 3));
            localStringBuilder.append(paramString.charAt(m + 4));
            j = m + 4;
          }
        }
        else
        {
          localStringBuilder.append(paramString.charAt(m + 1));
          j = m + 1;
        }
      }
      if (localStringBuilder.length() > 0)
      {
        localArrayList2.add(localStringBuilder.toString());
        paramArrayList2.add(localArrayList1);
      }
      return localArrayList2;
      break label171;
      localAtTroopMemberInfo = null;
      i = k;
      break;
    }
  }
  
  public static short a(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(a(paramArrayOfByte[(paramInt + 1)]) | a(paramArrayOfByte[paramInt]) << 8);
  }
  
  public static void a(String paramString)
  {
    ExceptionTracker.printCallStack(paramString, 1);
  }
  
  public static void a(Throwable paramThrowable) {}
  
  public static boolean a()
  {
    return (Environment.getExternalStorageState().equals("mounted")) && (Environment.getExternalStorageDirectory().exists());
  }
  
  public static boolean a(Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(jdField_a_of_type_JavaLangString.trim()))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", jdField_a_of_type_JavaLangString.trim());
    paramContext.startActivity(localIntent);
    return true;
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
    return (paramString == null) || (paramString.equals(AppConstants.D)) || (paramString.equals(String.valueOf(AppConstants.E))) || (paramString.equals(String.valueOf(AppConstants.F))) || (paramString.equals(String.valueOf(AppConstants.G))) || (paramString.equals(String.valueOf(AppConstants.H))) || (paramString.equals(String.valueOf(AppConstants.C))) || (paramString.equals(String.valueOf(AppConstants.B))) || (paramString.equals(String.valueOf(AppConstants.Q))) || (paramString.equals(String.valueOf(AppConstants.Y))) || (paramString.equals(String.valueOf(AppConstants.at))) || (paramString.equals(String.valueOf(AppConstants.y))) || (paramString.equals(String.valueOf(AppConstants.z))) || (paramString.equals(String.valueOf(AppConstants.A))) || (paramString.equals(String.valueOf(AppConstants.W))) || (paramString.equals(String.valueOf(AppConstants.w))) || (paramString.equals(String.valueOf(AppConstants.v))) || (paramString.equals(String.valueOf(AppConstants.X))) || (paramString.equals(String.valueOf(AppConstants.S))) || (paramString.equals(String.valueOf(AppConstants.V))) || (paramString.equals(String.valueOf(AppConstants.T))) || (paramString.equals(String.valueOf(AppConstants.Z))) || (paramString.equals(String.valueOf(AppConstants.aa))) || (paramString.equals(String.valueOf(AppConstants.aj))) || (paramString.equals(String.valueOf(AppConstants.al))) || (paramString.equals(String.valueOf(AppConstants.am))) || (paramString.equals(String.valueOf(AppConstants.as))) || (paramString.equals(String.valueOf(66600000L))) || (paramString.equals(String.valueOf(AppConstants.av))) || (paramString.equals(String.valueOf(9946L))) || (paramString.equals(String.valueOf(AppConstants.aE)));
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
  
  public static String b(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static String b(String paramString)
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
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { "短信登录验证码", "Login Verification Code" }, 3);
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    boolean bool1 = bool2;
    PackageManager localPackageManager;
    if (Build.VERSION.SDK_INT > 7) {
      localPackageManager = localBaseApplication.getPackageManager();
    }
    try
    {
      int i = localPackageManager.getPackageInfo(localBaseApplication.getPackageName(), 0).applicationInfo.flags;
      bool1 = bool2;
      if ((i & 0x40000) == 262144) {
        bool1 = true;
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return AppConstants.au.equals(paramString);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.lastIndexOf('_');
    } while (i <= 0);
    return paramString.substring(i + 1);
  }
  
  public static String c(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new String[] { "1062", "1065", "1066", "1069" }, new String[] { "设备锁", "密保手机" }, 3);
  }
  
  public static boolean c()
  {
    String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    if (!TextUtils.isEmpty(str))
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(str);
        l1 = l2;
      }
      catch (Exception localException)
      {
        label32:
        break label32;
      }
      if (jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(l1))) {
        return true;
      }
    }
    return false;
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
    return a(paramString1, paramString2, new String[] { "10010", "106" }, new String[] { "验证码", "通讯录", "QQ" }, 3);
  }
  
  public static boolean d(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!"0".equals(paramString)) && (!"10000".equals(paramString)) && (!"1000000".equals(paramString)) && (!"80000000".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.Utils
 * JD-Core Version:    0.7.0.1
 */