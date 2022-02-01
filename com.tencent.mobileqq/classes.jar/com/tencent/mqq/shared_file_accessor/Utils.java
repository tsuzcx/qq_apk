package com.tencent.mqq.shared_file_accessor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;

public class Utils
{
  private static final int BUF_SIZE = 12288;
  private static final String CP_URI_BASE = "content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/save";
  private static final String LOG_TAG = "Utils";
  private static final Uri SAVE_CMD_URI = Uri.parse("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/save");
  private static SoftReference<ByteArrayOutputStream> mBuffer = null;
  static String sCurrentProcessName = "";
  static boolean sIsSameProcessAsCP = false;
  
  private static ByteArrayOutputStream ensureBuffer()
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if (mBuffer != null)
    {
      localByteArrayOutputStream = (ByteArrayOutputStream)mBuffer.get();
      if (localByteArrayOutputStream != null) {
        return localByteArrayOutputStream;
      }
    }
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream(12288);
      mBuffer = new SoftReference(localByteArrayOutputStream);
      return localByteArrayOutputStream;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  static Utils.StackInfo getMiniStackInfo()
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    Object localObject1 = "";
    Object localObject2 = "";
    int i1 = arrayOfStackTraceElement.length;
    int k = 0;
    int j = 0;
    StackTraceElement localStackTraceElement;
    int m;
    Object localObject3;
    Object localObject4;
    int n;
    if (k < i1)
    {
      localStackTraceElement = arrayOfStackTraceElement[k];
      String str = localStackTraceElement.getClassName();
      m = i;
      localObject3 = localObject2;
      localObject4 = localObject1;
      n = j;
      if (!str.contains("SPStatInspector"))
      {
        m = i;
        localObject3 = localObject2;
        localObject4 = localObject1;
        n = j;
        if (!str.startsWith("com.tencent.mqq.shared_file_accessor."))
        {
          m = i;
          localObject3 = localObject2;
          localObject4 = localObject1;
          n = j;
          if (!str.startsWith("android."))
          {
            m = i;
            localObject3 = localObject2;
            localObject4 = localObject1;
            n = j;
            if (!str.startsWith("java."))
            {
              m = i;
              localObject3 = localObject2;
              localObject4 = localObject1;
              n = j;
              if (!str.startsWith("com.android."))
              {
                m = i;
                localObject3 = localObject2;
                localObject4 = localObject1;
                n = j;
                if (!str.startsWith("org.chromium."))
                {
                  if (!str.startsWith("dalvik.")) {
                    break label236;
                  }
                  n = j;
                  localObject4 = localObject1;
                  localObject3 = localObject2;
                  m = i;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      k += 1;
      i = m;
      localObject2 = localObject3;
      localObject1 = localObject4;
      j = n;
      break;
      label236:
      n = j + 1;
      if (n >= 8) {
        return new Utils.StackInfo((String)localObject1, (String)localObject2, localStringBuilder.toString());
      }
      j = i;
      if (i == 0)
      {
        j = 1;
        localObject1 = localStackTraceElement.getClassName();
        localObject2 = localStackTraceElement.getMethodName();
      }
      localStringBuilder.append(localStackTraceElement.toString()).append(",");
      localStringBuilder.append("\n");
      m = j;
      localObject3 = localObject2;
      localObject4 = localObject1;
    }
  }
  
  /* Error */
  private static String getProcessName(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 137	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ldc 139
    //   7: invokevirtual 145	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast 147	android/app/ActivityManager
    //   13: invokevirtual 151	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +229 -> 247
    //   21: aload_0
    //   22: invokeinterface 157 1 0
    //   27: astore_0
    //   28: aload_0
    //   29: invokeinterface 163 1 0
    //   34: ifeq +213 -> 247
    //   37: aload_0
    //   38: invokeinterface 166 1 0
    //   43: checkcast 168	android/app/ActivityManager$RunningAppProcessInfo
    //   46: astore_2
    //   47: aload_2
    //   48: getfield 171	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   51: iload_1
    //   52: if_icmpne -24 -> 28
    //   55: aload_2
    //   56: getfield 174	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   59: astore_0
    //   60: aload_0
    //   61: astore_2
    //   62: aload_0
    //   63: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifeq +112 -> 178
    //   69: ldc 181
    //   71: ldc 183
    //   73: invokestatic 189	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: new 191	java/io/FileReader
    //   80: dup
    //   81: new 66	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   88: ldc 193
    //   90: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_1
    //   94: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc 198
    //   99: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokespecial 201	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   108: astore_3
    //   109: aload_3
    //   110: astore_2
    //   111: sipush 512
    //   114: newarray char
    //   116: astore 4
    //   118: aload_3
    //   119: astore_2
    //   120: aload_3
    //   121: aload 4
    //   123: invokevirtual 205	java/io/FileReader:read	([C)I
    //   126: pop
    //   127: iconst_0
    //   128: istore_1
    //   129: aload_3
    //   130: astore_2
    //   131: iload_1
    //   132: aload 4
    //   134: arraylength
    //   135: if_icmpge +10 -> 145
    //   138: aload 4
    //   140: iload_1
    //   141: caload
    //   142: ifne +38 -> 180
    //   145: aload_3
    //   146: astore_2
    //   147: new 87	java/lang/String
    //   150: dup
    //   151: aload 4
    //   153: invokespecial 208	java/lang/String:<init>	([C)V
    //   156: iconst_0
    //   157: iload_1
    //   158: invokevirtual 212	java/lang/String:substring	(II)Ljava/lang/String;
    //   161: astore 4
    //   163: aload 4
    //   165: astore_0
    //   166: aload_0
    //   167: astore_2
    //   168: aload_3
    //   169: ifnull +9 -> 178
    //   172: aload_3
    //   173: invokevirtual 215	java/io/FileReader:close	()V
    //   176: aload_0
    //   177: astore_2
    //   178: aload_2
    //   179: areturn
    //   180: iload_1
    //   181: iconst_1
    //   182: iadd
    //   183: istore_1
    //   184: goto -55 -> 129
    //   187: astore 4
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: astore_2
    //   193: ldc 181
    //   195: ldc 217
    //   197: aload 4
    //   199: invokestatic 220	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   202: pop
    //   203: aload_0
    //   204: astore_2
    //   205: aload_3
    //   206: ifnull -28 -> 178
    //   209: aload_3
    //   210: invokevirtual 215	java/io/FileReader:close	()V
    //   213: aload_0
    //   214: areturn
    //   215: astore_2
    //   216: aload_0
    //   217: areturn
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 215	java/io/FileReader:close	()V
    //   229: aload_0
    //   230: athrow
    //   231: astore_2
    //   232: aload_0
    //   233: areturn
    //   234: astore_2
    //   235: goto -6 -> 229
    //   238: astore_0
    //   239: goto -18 -> 221
    //   242: astore 4
    //   244: goto -53 -> 191
    //   247: ldc 34
    //   249: astore_0
    //   250: goto -190 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramContext	Context
    //   3	181	1	i	int
    //   46	159	2	localObject1	Object
    //   215	1	2	localThrowable1	java.lang.Throwable
    //   220	6	2	localObject2	Object
    //   231	1	2	localThrowable2	java.lang.Throwable
    //   234	1	2	localThrowable3	java.lang.Throwable
    //   108	102	3	localFileReader	java.io.FileReader
    //   116	48	4	localObject3	Object
    //   187	11	4	localThrowable4	java.lang.Throwable
    //   242	1	4	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   77	109	187	java/lang/Throwable
    //   209	213	215	java/lang/Throwable
    //   77	109	218	finally
    //   172	176	231	java/lang/Throwable
    //   225	229	234	java/lang/Throwable
    //   111	118	238	finally
    //   120	127	238	finally
    //   131	138	238	finally
    //   147	163	238	finally
    //   193	203	238	finally
    //   111	118	242	java/lang/Throwable
    //   120	127	242	java/lang/Throwable
    //   131	138	242	java/lang/Throwable
    //   147	163	242	java/lang/Throwable
  }
  
  static SharedPreferences getSystemSp(Context paramContext, String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().adapter.getSystemSharedPreferences(paramString, paramInt);
  }
  
  public static void initCurrentProcessName(Context paramContext)
  {
    if ((sCurrentProcessName != null) && (sCurrentProcessName.length() != 0)) {}
    while (paramContext == null) {
      return;
    }
    sCurrentProcessName = getProcessName(paramContext);
    if (TextUtils.isEmpty(sCurrentProcessName))
    {
      Log.e("SpLib", "getProcessName fail");
      return;
    }
    sIsSameProcessAsCP = TextUtils.equals(paramContext.getPackageName(), sCurrentProcessName);
  }
  
  /* Error */
  public static java.io.Serializable loadData(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 266	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: new 269	java/io/ObjectInputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 272	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 275	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   24: checkcast 277	java/io/Serializable
    //   27: astore_3
    //   28: aload_2
    //   29: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   32: aload_1
    //   33: invokevirtual 279	java/io/FileInputStream:close	()V
    //   36: iconst_0
    //   37: ifeq +11 -> 48
    //   40: new 281	java/lang/NullPointerException
    //   43: dup
    //   44: invokespecial 282	java/lang/NullPointerException:<init>	()V
    //   47: athrow
    //   48: iconst_0
    //   49: ifeq +11 -> 60
    //   52: new 281	java/lang/NullPointerException
    //   55: dup
    //   56: invokespecial 282	java/lang/NullPointerException:<init>	()V
    //   59: athrow
    //   60: new 284	java/io/File
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: invokevirtual 288	java/io/File:delete	()Z
    //   71: pop
    //   72: aload_3
    //   73: areturn
    //   74: astore_1
    //   75: aconst_null
    //   76: astore 4
    //   78: aconst_null
    //   79: astore_3
    //   80: aload_2
    //   81: astore_1
    //   82: aload 4
    //   84: astore_2
    //   85: aload_2
    //   86: ifnull +7 -> 93
    //   89: aload_2
    //   90: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 279	java/io/FileInputStream:close	()V
    //   101: new 284	java/io/File
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: invokevirtual 288	java/io/File:delete	()Z
    //   112: pop
    //   113: aload_3
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_2
    //   118: aconst_null
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_3
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 279	java/io/FileInputStream:close	()V
    //   138: new 284	java/io/File
    //   141: dup
    //   142: aload_0
    //   143: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: invokevirtual 288	java/io/File:delete	()Z
    //   149: pop
    //   150: aload_3
    //   151: areturn
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_1
    //   157: aconst_null
    //   158: astore_3
    //   159: aload_2
    //   160: ifnull +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 279	java/io/FileInputStream:close	()V
    //   175: new 284	java/io/File
    //   178: dup
    //   179: aload_0
    //   180: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   183: invokevirtual 288	java/io/File:delete	()Z
    //   186: pop
    //   187: aload_3
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_3
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   204: aload_1
    //   205: ifnull +7 -> 212
    //   208: aload_1
    //   209: invokevirtual 279	java/io/FileInputStream:close	()V
    //   212: new 284	java/io/File
    //   215: dup
    //   216: aload_0
    //   217: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   220: invokevirtual 288	java/io/File:delete	()Z
    //   223: pop
    //   224: aload_3
    //   225: areturn
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_2
    //   229: aconst_null
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_3
    //   233: aload_2
    //   234: ifnull +7 -> 241
    //   237: aload_2
    //   238: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 279	java/io/FileInputStream:close	()V
    //   249: new 284	java/io/File
    //   252: dup
    //   253: aload_0
    //   254: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: invokevirtual 288	java/io/File:delete	()Z
    //   260: pop
    //   261: aload_3
    //   262: areturn
    //   263: astore_3
    //   264: aconst_null
    //   265: astore_2
    //   266: aconst_null
    //   267: astore_1
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   276: aload_1
    //   277: ifnull +7 -> 284
    //   280: aload_1
    //   281: invokevirtual 279	java/io/FileInputStream:close	()V
    //   284: new 284	java/io/File
    //   287: dup
    //   288: aload_0
    //   289: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   292: invokevirtual 288	java/io/File:delete	()Z
    //   295: pop
    //   296: aload_3
    //   297: athrow
    //   298: astore_1
    //   299: goto -251 -> 48
    //   302: astore_1
    //   303: goto -243 -> 60
    //   306: astore_2
    //   307: goto -214 -> 93
    //   310: astore_1
    //   311: goto -210 -> 101
    //   314: astore_2
    //   315: goto -185 -> 130
    //   318: astore_1
    //   319: goto -181 -> 138
    //   322: astore_2
    //   323: goto -156 -> 167
    //   326: astore_1
    //   327: goto -152 -> 175
    //   330: astore_2
    //   331: goto -127 -> 204
    //   334: astore_1
    //   335: goto -123 -> 212
    //   338: astore_2
    //   339: goto -98 -> 241
    //   342: astore_1
    //   343: goto -94 -> 249
    //   346: astore_2
    //   347: goto -71 -> 276
    //   350: astore_1
    //   351: goto -67 -> 284
    //   354: astore_3
    //   355: aconst_null
    //   356: astore_2
    //   357: goto -89 -> 268
    //   360: astore_3
    //   361: goto -93 -> 268
    //   364: astore_2
    //   365: aconst_null
    //   366: astore_2
    //   367: aconst_null
    //   368: astore_3
    //   369: goto -136 -> 233
    //   372: astore_3
    //   373: aconst_null
    //   374: astore_3
    //   375: goto -142 -> 233
    //   378: astore 4
    //   380: goto -147 -> 233
    //   383: astore_2
    //   384: aconst_null
    //   385: astore_2
    //   386: aconst_null
    //   387: astore_3
    //   388: goto -192 -> 196
    //   391: astore_3
    //   392: aconst_null
    //   393: astore_3
    //   394: goto -198 -> 196
    //   397: astore 4
    //   399: goto -203 -> 196
    //   402: astore_2
    //   403: aconst_null
    //   404: astore_2
    //   405: aconst_null
    //   406: astore_3
    //   407: goto -248 -> 159
    //   410: astore_3
    //   411: aconst_null
    //   412: astore_3
    //   413: goto -254 -> 159
    //   416: astore 4
    //   418: goto -259 -> 159
    //   421: astore_2
    //   422: aconst_null
    //   423: astore_2
    //   424: aconst_null
    //   425: astore_3
    //   426: goto -304 -> 122
    //   429: astore_3
    //   430: aconst_null
    //   431: astore_3
    //   432: goto -310 -> 122
    //   435: astore 4
    //   437: goto -315 -> 122
    //   440: astore_2
    //   441: aconst_null
    //   442: astore_2
    //   443: aconst_null
    //   444: astore_3
    //   445: goto -360 -> 85
    //   448: astore_3
    //   449: aconst_null
    //   450: astore_3
    //   451: goto -366 -> 85
    //   454: astore 4
    //   456: goto -371 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramString	String
    //   10	23	1	localFileInputStream	java.io.FileInputStream
    //   74	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   81	17	1	localObject1	Object
    //   115	1	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   119	16	1	localObject2	Object
    //   152	1	1	localIOException1	IOException
    //   156	16	1	localObject3	Object
    //   189	1	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   193	16	1	localObject4	Object
    //   226	1	1	localThrowable1	java.lang.Throwable
    //   230	51	1	localObject5	Object
    //   298	1	1	localIOException2	IOException
    //   302	1	1	localIOException3	IOException
    //   310	1	1	localIOException4	IOException
    //   318	1	1	localIOException5	IOException
    //   326	1	1	localIOException6	IOException
    //   334	1	1	localIOException7	IOException
    //   342	1	1	localIOException8	IOException
    //   350	1	1	localIOException9	IOException
    //   1	272	2	localObject6	Object
    //   306	1	2	localIOException10	IOException
    //   314	1	2	localIOException11	IOException
    //   322	1	2	localIOException12	IOException
    //   330	1	2	localIOException13	IOException
    //   338	1	2	localIOException14	IOException
    //   346	1	2	localIOException15	IOException
    //   356	1	2	localObject7	Object
    //   364	1	2	localThrowable2	java.lang.Throwable
    //   366	1	2	localObject8	Object
    //   383	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   385	1	2	localObject9	Object
    //   402	1	2	localIOException16	IOException
    //   404	1	2	localObject10	Object
    //   421	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   423	1	2	localObject11	Object
    //   440	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   442	1	2	localObject12	Object
    //   27	235	3	localSerializable	java.io.Serializable
    //   263	34	3	localObject13	Object
    //   354	1	3	localObject14	Object
    //   360	1	3	localObject15	Object
    //   368	1	3	localObject16	Object
    //   372	1	3	localThrowable3	java.lang.Throwable
    //   374	14	3	localObject17	Object
    //   391	1	3	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   393	14	3	localObject18	Object
    //   410	1	3	localIOException17	IOException
    //   412	14	3	localObject19	Object
    //   429	1	3	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   431	14	3	localObject20	Object
    //   448	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   450	1	3	localObject21	Object
    //   76	7	4	localObject22	Object
    //   378	1	4	localThrowable4	java.lang.Throwable
    //   397	1	4	localClassNotFoundException4	java.lang.ClassNotFoundException
    //   416	1	4	localIOException18	IOException
    //   435	1	4	localStreamCorruptedException4	java.io.StreamCorruptedException
    //   454	1	4	localFileNotFoundException4	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   2	11	74	java/io/FileNotFoundException
    //   2	11	115	java/io/StreamCorruptedException
    //   2	11	152	java/io/IOException
    //   2	11	189	java/lang/ClassNotFoundException
    //   2	11	226	java/lang/Throwable
    //   2	11	263	finally
    //   40	48	298	java/io/IOException
    //   52	60	302	java/io/IOException
    //   89	93	306	java/io/IOException
    //   97	101	310	java/io/IOException
    //   126	130	314	java/io/IOException
    //   134	138	318	java/io/IOException
    //   163	167	322	java/io/IOException
    //   171	175	326	java/io/IOException
    //   200	204	330	java/io/IOException
    //   208	212	334	java/io/IOException
    //   237	241	338	java/io/IOException
    //   245	249	342	java/io/IOException
    //   272	276	346	java/io/IOException
    //   280	284	350	java/io/IOException
    //   11	20	354	finally
    //   20	28	360	finally
    //   28	36	360	finally
    //   11	20	364	java/lang/Throwable
    //   20	28	372	java/lang/Throwable
    //   28	36	378	java/lang/Throwable
    //   11	20	383	java/lang/ClassNotFoundException
    //   20	28	391	java/lang/ClassNotFoundException
    //   28	36	397	java/lang/ClassNotFoundException
    //   11	20	402	java/io/IOException
    //   20	28	410	java/io/IOException
    //   28	36	416	java/io/IOException
    //   11	20	421	java/io/StreamCorruptedException
    //   20	28	429	java/io/StreamCorruptedException
    //   28	36	435	java/io/StreamCorruptedException
    //   11	20	440	java/io/FileNotFoundException
    //   20	28	448	java/io/FileNotFoundException
    //   28	36	454	java/io/FileNotFoundException
  }
  
  public static void notifySave(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.getContentResolver().update(SAVE_CMD_URI, new ContentValues(0), null, null);
  }
  
  private static final void onGetSystemSpException(Exception paramException)
  {
    paramException.printStackTrace();
    if (SharedPreferencesProxyManager.sSystemSpExceptionMsg == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.append(paramException.getMessage());
      localStringBuilder.append(Log.getStackTraceString(paramException));
      SharedPreferencesProxyManager.sSystemSpExceptionMsg = localStringBuilder.toString();
    }
  }
  
  static boolean readGivenLenOrFail(byte[] paramArrayOfByte, int paramInt1, int paramInt2, InputStream paramInputStream)
  {
    if (paramInt2 == 0) {}
    int i;
    do
    {
      return true;
      int j = 0;
      int k = 0;
      i = paramInt2;
      paramInt2 = k;
      while ((i > 0) && (j >= 0)) {
        try
        {
          j = paramInputStream.read(paramArrayOfByte, paramInt1 + paramInt2, i);
          i -= j;
          paramInt2 += j;
        }
        catch (IOException paramArrayOfByte)
        {
          return false;
        }
      }
    } while (i == 0);
    return false;
  }
  
  public static boolean renameFile(String paramString1, String paramString2)
  {
    return new File(paramString1).renameTo(new File(paramString2));
  }
  
  /* Error */
  public static boolean saveData(java.io.Serializable paramSerializable, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 4
    //   14: aconst_null
    //   15: astore 7
    //   17: invokestatic 337	com/tencent/mqq/shared_file_accessor/Utils:ensureBuffer	()Ljava/io/ByteArrayOutputStream;
    //   20: astore 9
    //   22: aload 9
    //   24: ifnonnull +5 -> 29
    //   27: iload_2
    //   28: ireturn
    //   29: aload 9
    //   31: invokevirtual 340	java/io/ByteArrayOutputStream:reset	()V
    //   34: new 342	java/io/ObjectOutputStream
    //   37: dup
    //   38: aload 9
    //   40: invokespecial 345	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: astore_3
    //   44: aload_3
    //   45: aload_0
    //   46: invokevirtual 348	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   49: aload_3
    //   50: invokevirtual 351	java/io/ObjectOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 352	java/io/ObjectOutputStream:close	()V
    //   57: new 354	java/io/FileOutputStream
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 355	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   65: astore_0
    //   66: aload 9
    //   68: aload_0
    //   69: invokevirtual 358	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   72: aload 9
    //   74: invokevirtual 359	java/io/ByteArrayOutputStream:flush	()V
    //   77: aload 9
    //   79: invokevirtual 360	java/io/ByteArrayOutputStream:close	()V
    //   82: aload_0
    //   83: invokevirtual 361	java/io/FileOutputStream:flush	()V
    //   86: aload_0
    //   87: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   90: iconst_1
    //   91: istore_2
    //   92: iconst_0
    //   93: ifeq +11 -> 104
    //   96: new 281	java/lang/NullPointerException
    //   99: dup
    //   100: invokespecial 282	java/lang/NullPointerException:<init>	()V
    //   103: athrow
    //   104: iconst_0
    //   105: ifeq -78 -> 27
    //   108: new 281	java/lang/NullPointerException
    //   111: dup
    //   112: invokespecial 282	java/lang/NullPointerException:<init>	()V
    //   115: athrow
    //   116: astore_0
    //   117: iconst_1
    //   118: ireturn
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_3
    //   122: aload 7
    //   124: astore_0
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 352	java/io/ObjectOutputStream:close	()V
    //   133: aload_0
    //   134: ifnull -107 -> 27
    //   137: aload_0
    //   138: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   141: iconst_0
    //   142: ireturn
    //   143: astore_0
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_3
    //   149: aload 6
    //   151: astore_0
    //   152: aload_3
    //   153: ifnull +7 -> 160
    //   156: aload_3
    //   157: invokevirtual 352	java/io/ObjectOutputStream:close	()V
    //   160: aload_0
    //   161: ifnull -134 -> 27
    //   164: aload_0
    //   165: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_0
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_0
    //   174: aconst_null
    //   175: astore_3
    //   176: aload 5
    //   178: astore_0
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 352	java/io/ObjectOutputStream:close	()V
    //   187: aload_0
    //   188: ifnull -161 -> 27
    //   191: aload_0
    //   192: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_0
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_0
    //   201: aconst_null
    //   202: astore_3
    //   203: aload 8
    //   205: astore_0
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 352	java/io/ObjectOutputStream:close	()V
    //   214: aload_0
    //   215: ifnull -188 -> 27
    //   218: aload_0
    //   219: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: iconst_0
    //   226: ireturn
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_3
    //   230: aload 4
    //   232: astore_1
    //   233: aload_3
    //   234: ifnull +7 -> 241
    //   237: aload_3
    //   238: invokevirtual 352	java/io/ObjectOutputStream:close	()V
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: astore_0
    //   252: goto -148 -> 104
    //   255: astore_1
    //   256: goto -123 -> 133
    //   259: astore_1
    //   260: goto -100 -> 160
    //   263: astore_1
    //   264: goto -77 -> 187
    //   267: astore_1
    //   268: goto -54 -> 214
    //   271: astore_3
    //   272: goto -31 -> 241
    //   275: astore_1
    //   276: goto -27 -> 249
    //   279: astore_0
    //   280: aload 4
    //   282: astore_1
    //   283: goto -50 -> 233
    //   286: astore 4
    //   288: aload_0
    //   289: astore_1
    //   290: aload 4
    //   292: astore_0
    //   293: goto -60 -> 233
    //   296: astore_0
    //   297: aload 8
    //   299: astore_0
    //   300: goto -94 -> 206
    //   303: astore_1
    //   304: goto -98 -> 206
    //   307: astore_0
    //   308: aload 5
    //   310: astore_0
    //   311: goto -132 -> 179
    //   314: astore_1
    //   315: goto -136 -> 179
    //   318: astore_0
    //   319: aload 6
    //   321: astore_0
    //   322: goto -170 -> 152
    //   325: astore_1
    //   326: goto -174 -> 152
    //   329: astore_0
    //   330: aload 7
    //   332: astore_0
    //   333: goto -208 -> 125
    //   336: astore_1
    //   337: goto -212 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramSerializable	java.io.Serializable
    //   0	340	1	paramString	String
    //   1	91	2	bool	boolean
    //   43	195	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   271	1	3	localIOException	IOException
    //   12	269	4	localObject1	Object
    //   286	5	4	localObject2	Object
    //   6	303	5	localObject3	Object
    //   3	317	6	localObject4	Object
    //   15	316	7	localObject5	Object
    //   9	289	8	localObject6	Object
    //   20	58	9	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   108	116	116	java/io/IOException
    //   29	44	119	java/io/FileNotFoundException
    //   137	141	143	java/io/IOException
    //   29	44	146	java/io/IOException
    //   164	168	170	java/io/IOException
    //   29	44	173	java/lang/OutOfMemoryError
    //   191	195	197	java/io/IOException
    //   29	44	200	java/lang/Throwable
    //   218	222	224	java/io/IOException
    //   29	44	227	finally
    //   96	104	251	java/io/IOException
    //   129	133	255	java/io/IOException
    //   156	160	259	java/io/IOException
    //   183	187	263	java/io/IOException
    //   210	214	267	java/io/IOException
    //   237	241	271	java/io/IOException
    //   245	249	275	java/io/IOException
    //   44	66	279	finally
    //   66	90	286	finally
    //   44	66	296	java/lang/Throwable
    //   66	90	303	java/lang/Throwable
    //   44	66	307	java/lang/OutOfMemoryError
    //   66	90	314	java/lang/OutOfMemoryError
    //   44	66	318	java/io/IOException
    //   66	90	325	java/io/IOException
    //   44	66	329	java/io/FileNotFoundException
    //   66	90	336	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.Utils
 * JD-Core Version:    0.7.0.1
 */