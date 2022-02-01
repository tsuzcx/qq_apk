package com.tencent.mobileqq.uniformdownload.filemanager;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class FileManagerUtil
{
  private static HashMap<String, Integer> a = null;
  
  public static int a(int paramInt)
  {
    return a(paramInt, 2);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return 2130844531;
  }
  
  @TargetApi(9)
  public static int a(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = FileUtil.b(paramString);
    } while (a().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "-");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return 0;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -2;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return 0;
  }
  
  public static long a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerUtil", 1, "getFileSizes: filePath is null");
      return 0L;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.w("FileManagerUtil", 1, "file " + paramString + " is not exists");
      return 0L;
    }
    long l = localFile.length();
    if (0L == l) {
      QLog.w("FileManagerUtil", 1, "file " + paramString + " len is 0");
    }
    return l;
  }
  
  public static String a()
  {
    return FMSettings.a().a();
  }
  
  public static String a(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    Object localObject2 = "";
    Object localObject1 = "";
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      if ((j <= 0) || (j <= i)) {
        break label155;
      }
      localObject1 = paramString.substring(i, j);
    }
    for (str1 = paramString.substring(j);; str1 = str2)
    {
      str2 = paramString.substring(0, i);
      localObject2 = localObject1;
      localObject1 = str2;
      File localFile = new File(paramString);
      i = 1;
      str2 = paramString;
      paramString = localFile;
      while (paramString.exists())
      {
        str2 = (String)localObject1 + (String)localObject2 + "(" + i + ")" + str1;
        paramString = new File(str2);
        i += 1;
      }
      label155:
      localObject1 = paramString.substring(i);
    }
    return str2;
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6) {}
  
  public static void a(AppRuntime paramAppRuntime, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10) {}
  
  public static boolean a()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static int b(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null) {
      return 2130844531;
    }
    return a(c(paramString));
  }
  
  /* Error */
  public static int c(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 172	com/tencent/mobileqq/uniformdownload/filemanager/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull +12 -> 21
    //   12: aload_2
    //   13: invokevirtual 180	java/lang/String:length	()I
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +10 -> 28
    //   21: iconst_m1
    //   22: istore_1
    //   23: ldc 2
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: aload_2
    //   29: invokevirtual 183	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_2
    //   33: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   36: ifnonnull +1223 -> 1259
    //   39: new 185	java/util/HashMap
    //   42: dup
    //   43: invokespecial 186	java/util/HashMap:<init>	()V
    //   46: putstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   49: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   52: ldc 188
    //   54: iconst_1
    //   55: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   65: ldc 200
    //   67: iconst_1
    //   68: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   78: ldc 202
    //   80: iconst_1
    //   81: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   91: ldc 204
    //   93: iconst_1
    //   94: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   104: ldc 206
    //   106: iconst_1
    //   107: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   117: ldc 208
    //   119: iconst_1
    //   120: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   130: ldc 210
    //   132: invokevirtual 214	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   139: ldc 216
    //   141: invokevirtual 214	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   148: ldc 218
    //   150: invokevirtual 214	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: pop
    //   154: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   157: ldc 220
    //   159: invokevirtual 214	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   166: ldc 222
    //   168: iconst_0
    //   169: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   179: ldc 224
    //   181: iconst_0
    //   182: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   192: ldc 226
    //   194: iconst_0
    //   195: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   205: ldc 228
    //   207: iconst_0
    //   208: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: pop
    //   215: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   218: ldc 230
    //   220: iconst_0
    //   221: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   231: ldc 218
    //   233: iconst_0
    //   234: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   240: pop
    //   241: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   244: ldc 232
    //   246: bipush 12
    //   248: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: pop
    //   255: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   258: ldc 234
    //   260: iconst_2
    //   261: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   267: pop
    //   268: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   271: ldc 236
    //   273: iconst_2
    //   274: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   284: ldc 238
    //   286: iconst_2
    //   287: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   293: pop
    //   294: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   297: ldc 240
    //   299: iconst_2
    //   300: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   310: ldc 242
    //   312: iconst_2
    //   313: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   316: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   319: pop
    //   320: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   323: ldc 244
    //   325: iconst_2
    //   326: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   332: pop
    //   333: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   336: ldc 246
    //   338: iconst_2
    //   339: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   345: pop
    //   346: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   349: ldc 248
    //   351: iconst_2
    //   352: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: pop
    //   359: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   362: ldc 250
    //   364: iconst_2
    //   365: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: pop
    //   372: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   375: ldc 252
    //   377: iconst_2
    //   378: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: pop
    //   385: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   388: ldc 254
    //   390: iconst_2
    //   391: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   397: pop
    //   398: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   401: ldc_w 256
    //   404: iconst_2
    //   405: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   408: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   411: pop
    //   412: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   415: ldc 210
    //   417: iconst_2
    //   418: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   424: pop
    //   425: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   428: ldc_w 258
    //   431: iconst_2
    //   432: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   435: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   438: pop
    //   439: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   442: ldc_w 260
    //   445: iconst_2
    //   446: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   449: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   452: pop
    //   453: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   456: ldc_w 262
    //   459: iconst_2
    //   460: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   463: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   466: pop
    //   467: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   470: ldc_w 264
    //   473: iconst_2
    //   474: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   477: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   480: pop
    //   481: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   484: ldc_w 266
    //   487: iconst_2
    //   488: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   491: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   494: pop
    //   495: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   498: ldc_w 268
    //   501: iconst_2
    //   502: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   505: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   508: pop
    //   509: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   512: ldc_w 270
    //   515: iconst_2
    //   516: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   522: pop
    //   523: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   526: ldc_w 272
    //   529: iconst_2
    //   530: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: pop
    //   537: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   540: ldc_w 274
    //   543: iconst_2
    //   544: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   547: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   550: pop
    //   551: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   554: ldc_w 276
    //   557: iconst_3
    //   558: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   561: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   564: pop
    //   565: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   568: ldc_w 278
    //   571: iconst_3
    //   572: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   575: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   578: pop
    //   579: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   582: ldc_w 280
    //   585: iconst_3
    //   586: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   589: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   592: pop
    //   593: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   596: ldc_w 282
    //   599: iconst_3
    //   600: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   603: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   606: pop
    //   607: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   610: ldc_w 284
    //   613: iconst_4
    //   614: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   617: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   620: pop
    //   621: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   624: ldc_w 286
    //   627: iconst_4
    //   628: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   631: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   634: pop
    //   635: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   638: ldc_w 288
    //   641: iconst_4
    //   642: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   648: pop
    //   649: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   652: ldc_w 290
    //   655: iconst_4
    //   656: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   659: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   662: pop
    //   663: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   666: ldc_w 292
    //   669: iconst_4
    //   670: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   673: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   676: pop
    //   677: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   680: ldc_w 294
    //   683: iconst_4
    //   684: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   687: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   690: pop
    //   691: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   694: ldc_w 296
    //   697: iconst_5
    //   698: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   701: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   704: pop
    //   705: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   708: ldc_w 298
    //   711: iconst_5
    //   712: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   715: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   718: pop
    //   719: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   722: ldc_w 300
    //   725: bipush 6
    //   727: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   730: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   733: pop
    //   734: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   737: ldc_w 302
    //   740: bipush 6
    //   742: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   745: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   748: pop
    //   749: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   752: ldc_w 304
    //   755: bipush 6
    //   757: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   760: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   763: pop
    //   764: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   767: ldc_w 306
    //   770: bipush 6
    //   772: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   775: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   778: pop
    //   779: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   782: ldc_w 308
    //   785: bipush 6
    //   787: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   790: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   793: pop
    //   794: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   797: ldc_w 310
    //   800: bipush 7
    //   802: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   805: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   808: pop
    //   809: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   812: ldc_w 312
    //   815: bipush 7
    //   817: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   820: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   823: pop
    //   824: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   827: ldc_w 314
    //   830: bipush 7
    //   832: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   835: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   838: pop
    //   839: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   842: ldc_w 316
    //   845: bipush 7
    //   847: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   850: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   853: pop
    //   854: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   857: ldc_w 318
    //   860: bipush 7
    //   862: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   865: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   868: pop
    //   869: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   872: ldc_w 320
    //   875: bipush 8
    //   877: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   880: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   883: pop
    //   884: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   887: ldc_w 322
    //   890: bipush 8
    //   892: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   895: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   898: pop
    //   899: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   902: ldc_w 324
    //   905: bipush 8
    //   907: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   910: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   913: pop
    //   914: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   917: ldc_w 326
    //   920: bipush 9
    //   922: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   925: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   928: pop
    //   929: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   932: ldc_w 328
    //   935: bipush 10
    //   937: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   940: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   943: pop
    //   944: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   947: ldc_w 330
    //   950: bipush 10
    //   952: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   955: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   958: pop
    //   959: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   962: ldc_w 332
    //   965: bipush 10
    //   967: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   970: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   973: pop
    //   974: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   977: ldc_w 334
    //   980: bipush 10
    //   982: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   985: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   988: pop
    //   989: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   992: ldc_w 336
    //   995: bipush 10
    //   997: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1000: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1003: pop
    //   1004: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1007: ldc_w 338
    //   1010: bipush 10
    //   1012: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1015: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1018: pop
    //   1019: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1022: ldc_w 340
    //   1025: bipush 10
    //   1027: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1030: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1033: pop
    //   1034: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1037: ldc_w 342
    //   1040: bipush 10
    //   1042: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1045: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1048: pop
    //   1049: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1052: ldc_w 344
    //   1055: bipush 10
    //   1057: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1060: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1063: pop
    //   1064: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1067: ldc_w 346
    //   1070: bipush 10
    //   1072: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1075: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1078: pop
    //   1079: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1082: ldc_w 348
    //   1085: bipush 10
    //   1087: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1090: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1093: pop
    //   1094: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1097: ldc_w 350
    //   1100: bipush 10
    //   1102: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1105: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1108: pop
    //   1109: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1112: ldc_w 304
    //   1115: bipush 10
    //   1117: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1120: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1123: pop
    //   1124: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1127: ldc_w 352
    //   1130: bipush 10
    //   1132: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1135: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1138: pop
    //   1139: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1142: ldc_w 354
    //   1145: bipush 14
    //   1147: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1150: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1153: pop
    //   1154: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1157: ldc_w 356
    //   1160: bipush 15
    //   1162: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1165: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1168: pop
    //   1169: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1172: ldc_w 358
    //   1175: bipush 16
    //   1177: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1180: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1183: pop
    //   1184: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1187: ldc_w 360
    //   1190: bipush 17
    //   1192: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1195: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1198: pop
    //   1199: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1202: ldc_w 362
    //   1205: bipush 18
    //   1207: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1210: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1213: pop
    //   1214: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1217: ldc_w 306
    //   1220: bipush 19
    //   1222: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1225: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1228: pop
    //   1229: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1232: ldc_w 282
    //   1235: bipush 20
    //   1237: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1240: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1243: pop
    //   1244: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1247: ldc_w 364
    //   1250: bipush 21
    //   1252: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1255: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1258: pop
    //   1259: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1262: aload_2
    //   1263: invokevirtual 183	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1266: invokevirtual 368	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1269: ifeq +23 -> 1292
    //   1272: getstatic 11	com/tencent/mobileqq/uniformdownload/filemanager/FileManagerUtil:a	Ljava/util/HashMap;
    //   1275: aload_2
    //   1276: invokevirtual 183	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1279: invokevirtual 371	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1282: checkcast 190	java/lang/Integer
    //   1285: invokevirtual 374	java/lang/Integer:intValue	()I
    //   1288: istore_1
    //   1289: goto -1266 -> 23
    //   1292: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1295: ifeq +35 -> 1330
    //   1298: ldc 87
    //   1300: iconst_2
    //   1301: new 105	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1308: ldc_w 379
    //   1311: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: aload_0
    //   1315: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: ldc_w 381
    //   1321: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: invokestatic 120	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1330: bipush 11
    //   1332: istore_1
    //   1333: goto -1310 -> 23
    //   1336: astore_0
    //   1337: ldc 2
    //   1339: monitorexit
    //   1340: aload_0
    //   1341: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1342	0	paramString	String
    //   16	1317	1	i	int
    //   7	1269	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	8	1336	finally
    //   12	17	1336	finally
    //   28	1259	1336	finally
    //   1259	1289	1336	finally
    //   1292	1330	1336	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.filemanager.FileManagerUtil
 * JD-Core Version:    0.7.0.1
 */