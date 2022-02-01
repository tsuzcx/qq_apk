package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppReport
{
  protected static Lock a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(Context paramContext)
  {
    Object localObject = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    ((SharedPreferences.Editor)localObject).putLong("app_last_fullReport_success_time", SystemClock.currentThreadTimeMillis());
    ((SharedPreferences.Editor)localObject).putBoolean("is_app_last_fullReport_success", true);
    ((SharedPreferences.Editor)localObject).putBoolean("is_incremental_report_overflow", false);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("appcenter_app_report_storage_file.txt");
    if (new File(((StringBuilder)localObject).toString()).exists())
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  /* Error */
  protected static void a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 63	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: ldc 112
    //   16: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: ldc 114
    //   29: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: iload_2
    //   35: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: ldc 119
    //   42: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 121
    //   48: aload_3
    //   49: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 127	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aconst_null
    //   56: astore 7
    //   58: aconst_null
    //   59: astore 8
    //   61: aconst_null
    //   62: astore 6
    //   64: aload 6
    //   66: astore_3
    //   67: aload 7
    //   69: astore 4
    //   71: aload 8
    //   73: astore 5
    //   75: getstatic 16	com/tencent/open/business/base/appreport/AppReport:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   78: invokeinterface 98 1 0
    //   83: aload 6
    //   85: astore_3
    //   86: aload 7
    //   88: astore 4
    //   90: aload 8
    //   92: astore 5
    //   94: aload_0
    //   95: ldc 83
    //   97: ldc 128
    //   99: invokevirtual 132	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   102: astore_0
    //   103: aload_0
    //   104: astore_3
    //   105: aload_0
    //   106: astore 4
    //   108: aload_0
    //   109: astore 5
    //   111: new 63	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   118: astore 6
    //   120: aload_0
    //   121: astore_3
    //   122: aload_0
    //   123: astore 4
    //   125: aload_0
    //   126: astore 5
    //   128: aload 6
    //   130: aload_1
    //   131: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_0
    //   136: astore_3
    //   137: aload_0
    //   138: astore 4
    //   140: aload_0
    //   141: astore 5
    //   143: aload 6
    //   145: ldc 134
    //   147: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_0
    //   152: astore_3
    //   153: aload_0
    //   154: astore 4
    //   156: aload_0
    //   157: astore 5
    //   159: aload 6
    //   161: iload_2
    //   162: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_0
    //   167: astore_3
    //   168: aload_0
    //   169: astore 4
    //   171: aload_0
    //   172: astore 5
    //   174: aload 6
    //   176: ldc 136
    //   178: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_0
    //   183: astore_3
    //   184: aload_0
    //   185: astore 4
    //   187: aload_0
    //   188: astore 5
    //   190: aload_0
    //   191: aload 6
    //   193: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokevirtual 142	java/lang/String:getBytes	()[B
    //   199: invokevirtual 148	java/io/FileOutputStream:write	([B)V
    //   202: aload_0
    //   203: ifnull +69 -> 272
    //   206: aload_0
    //   207: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   210: goto +62 -> 272
    //   213: astore_0
    //   214: goto +54 -> 268
    //   217: astore_0
    //   218: goto +63 -> 281
    //   221: astore_0
    //   222: aload 4
    //   224: astore_3
    //   225: aload_0
    //   226: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   229: aload 4
    //   231: ifnull +41 -> 272
    //   234: aload 4
    //   236: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   239: goto +33 -> 272
    //   242: astore_0
    //   243: goto +25 -> 268
    //   246: astore_0
    //   247: aload 5
    //   249: astore_3
    //   250: aload_0
    //   251: invokevirtual 155	java/io/FileNotFoundException:printStackTrace	()V
    //   254: aload 5
    //   256: ifnull +16 -> 272
    //   259: aload 5
    //   261: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   264: goto +8 -> 272
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   272: getstatic 16	com/tencent/open/business/base/appreport/AppReport:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   275: invokeinterface 105 1 0
    //   280: return
    //   281: aload_3
    //   282: ifnull +15 -> 297
    //   285: aload_3
    //   286: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   289: goto +8 -> 297
    //   292: astore_1
    //   293: aload_1
    //   294: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   297: getstatic 16	com/tencent/open/business/base/appreport/AppReport:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   300: invokeinterface 105 1 0
    //   305: aload_0
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramContext	Context
    //   0	307	1	paramString	String
    //   0	307	2	paramInt	int
    //   12	274	3	localObject1	Object
    //   69	166	4	localObject2	Object
    //   73	187	5	localObject3	Object
    //   62	130	6	localStringBuilder	StringBuilder
    //   56	31	7	localObject4	Object
    //   59	32	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   206	210	213	java/io/IOException
    //   75	83	217	finally
    //   94	103	217	finally
    //   111	120	217	finally
    //   128	135	217	finally
    //   143	151	217	finally
    //   159	166	217	finally
    //   174	182	217	finally
    //   190	202	217	finally
    //   225	229	217	finally
    //   250	254	217	finally
    //   75	83	221	java/io/IOException
    //   94	103	221	java/io/IOException
    //   111	120	221	java/io/IOException
    //   128	135	221	java/io/IOException
    //   143	151	221	java/io/IOException
    //   159	166	221	java/io/IOException
    //   174	182	221	java/io/IOException
    //   190	202	221	java/io/IOException
    //   234	239	242	java/io/IOException
    //   75	83	246	java/io/FileNotFoundException
    //   94	103	246	java/io/FileNotFoundException
    //   111	120	246	java/io/FileNotFoundException
    //   128	135	246	java/io/FileNotFoundException
    //   143	151	246	java/io/FileNotFoundException
    //   159	166	246	java/io/FileNotFoundException
    //   174	182	246	java/io/FileNotFoundException
    //   190	202	246	java/io/FileNotFoundException
    //   259	264	267	java/io/IOException
    //   285	289	292	java/io/IOException
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView, String paramString3) {}
  
  public static void a(Context paramContext, String paramString1, WebView paramWebView, String paramString2, boolean paramBoolean) {}
  
  public static void b(Context paramContext)
  {
    Object localObject = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("is_app_last_fullReport_success", false);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("appcenter_app_report_storage_file.txt");
    if (new File(((StringBuilder)localObject).toString()).exists())
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport
 * JD-Core Version:    0.7.0.1
 */