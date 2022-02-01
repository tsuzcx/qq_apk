package com.tencent.mobileqq.msf.core.net.patch;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PatchSharedPreUtil
{
  private static final String FILE_NAME = "installed_patch_name.txt";
  private static final String KEY_CONFIG_VERSION_PATCH = "key_config_version_patch";
  private static final String KEY_COUNT_FAIL_INSTALL_PATCH = "key_count_fail_install_patch_";
  private static final String KEY_COUNT_FAIL_STARTUP_PATCH = "key_count_fail_startup_patch_";
  private static final String KEY_PREFIX_CONFIG_PATCH = "key_config_patch_";
  private static final String KEY_TIME_PULL_PATCH_RECONNECT = "key_time_pull_patch_reconnect";
  private static final String KEY_VERIFY_STATUS_PATCH = "key_verify_status_patch_";
  public static final String SHARED_PREFERENCE_HOTPATCH = "hotpatch_preference";
  
  public static int getCountFailInstallPatch(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getInt("key_count_fail_install_patch_" + paramString1 + paramString2, 0);
  }
  
  public static int getCountFailStartupPatch(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getInt("key_count_fail_startup_patch_" + paramString1 + paramString2, 0);
  }
  
  /* Error */
  public static String getInstalledPatchName(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: new 68	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokevirtual 72	android/content/Context:getFilesDir	()Ljava/io/File;
    //   16: ldc 8
    //   18: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_0
    //   22: sipush 256
    //   25: newarray byte
    //   27: astore 6
    //   29: aload_0
    //   30: invokevirtual 79	java/io/File:exists	()Z
    //   33: ifeq +113 -> 146
    //   36: new 81	java/io/BufferedInputStream
    //   39: dup
    //   40: new 83	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 86	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 89	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_1
    //   52: aload_1
    //   53: aload 6
    //   55: invokevirtual 93	java/io/BufferedInputStream:read	([B)I
    //   58: istore_2
    //   59: aload_3
    //   60: astore_0
    //   61: aload_1
    //   62: astore_3
    //   63: iload_2
    //   64: ifle +17 -> 81
    //   67: new 95	java/lang/String
    //   70: dup
    //   71: aload 6
    //   73: iconst_0
    //   74: iload_2
    //   75: invokespecial 98	java/lang/String:<init>	([BII)V
    //   78: astore_0
    //   79: aload_1
    //   80: astore_3
    //   81: aload_0
    //   82: astore_1
    //   83: aload_3
    //   84: ifnull +11 -> 95
    //   87: aload_0
    //   88: astore_1
    //   89: aload_3
    //   90: invokevirtual 101	java/io/BufferedInputStream:close	()V
    //   93: aload_0
    //   94: astore_1
    //   95: aload_1
    //   96: areturn
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 101	java/io/BufferedInputStream:close	()V
    //   108: aload_0
    //   109: athrow
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_0
    //   113: aload 5
    //   115: astore_1
    //   116: aload_0
    //   117: ifnull -22 -> 95
    //   120: aload 4
    //   122: astore_1
    //   123: aload_0
    //   124: invokevirtual 101	java/io/BufferedInputStream:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aload_1
    //   131: areturn
    //   132: astore_1
    //   133: goto -25 -> 108
    //   136: astore_0
    //   137: goto -37 -> 100
    //   140: astore_0
    //   141: aload_1
    //   142: astore_0
    //   143: goto -30 -> 113
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_3
    //   149: astore_0
    //   150: aload_1
    //   151: astore_3
    //   152: goto -71 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramContext	Context
    //   0	155	1	paramString	String
    //   58	17	2	i	int
    //   7	145	3	str	String
    //   4	117	4	localObject1	Object
    //   1	113	5	localObject2	Object
    //   27	45	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	52	97	finally
    //   8	52	110	java/lang/Throwable
    //   89	93	129	java/io/IOException
    //   123	127	129	java/io/IOException
    //   104	108	132	java/io/IOException
    //   52	59	136	finally
    //   67	79	136	finally
    //   52	59	140	java/lang/Throwable
    //   67	79	140	java/lang/Throwable
  }
  
  public static long getLastTimePullPatchReconnect(Context paramContext)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getLong("key_time_pull_patch_reconnect", 0L);
  }
  
  public static String getPatchConfig(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getString("key_config_patch_" + paramString, null);
  }
  
  public static int getPatchConfigVersion(Context paramContext)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getInt("key_config_version_patch", 0);
  }
  
  public static String getPatchReportInfo(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getString(paramString, null);
  }
  
  public static boolean getPatchVerifyStatus(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getBoolean("key_verify_status_patch_" + paramString, false);
  }
  
  /* Error */
  public static void saveInstalledPatchName(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: new 68	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 72	android/content/Context:getFilesDir	()Ljava/io/File;
    //   12: ldc 8
    //   14: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload_2
    //   20: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +30 -> 53
    //   26: aload_3
    //   27: astore_0
    //   28: aload 4
    //   30: invokevirtual 79	java/io/File:exists	()Z
    //   33: ifeq +11 -> 44
    //   36: aload 4
    //   38: invokevirtual 132	java/io/File:delete	()Z
    //   41: pop
    //   42: aload_3
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +7 -> 52
    //   48: aload_0
    //   49: invokevirtual 135	java/io/BufferedOutputStream:close	()V
    //   52: return
    //   53: aload_2
    //   54: invokevirtual 139	java/lang/String:getBytes	()[B
    //   57: astore_2
    //   58: aload 4
    //   60: invokevirtual 79	java/io/File:exists	()Z
    //   63: ifeq +9 -> 72
    //   66: aload 4
    //   68: invokevirtual 132	java/io/File:delete	()Z
    //   71: pop
    //   72: aload 4
    //   74: invokevirtual 142	java/io/File:createNewFile	()Z
    //   77: pop
    //   78: new 134	java/io/BufferedOutputStream
    //   81: dup
    //   82: new 144	java/io/FileOutputStream
    //   85: dup
    //   86: aload 4
    //   88: invokespecial 145	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 148	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   94: astore_0
    //   95: aload_0
    //   96: aload_2
    //   97: invokevirtual 152	java/io/BufferedOutputStream:write	([B)V
    //   100: goto -56 -> 44
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 135	java/io/BufferedOutputStream:close	()V
    //   114: aload_1
    //   115: athrow
    //   116: astore_0
    //   117: aload_1
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull -68 -> 52
    //   123: aload_0
    //   124: invokevirtual 135	java/io/BufferedOutputStream:close	()V
    //   127: return
    //   128: astore_0
    //   129: return
    //   130: astore_0
    //   131: goto -17 -> 114
    //   134: astore_1
    //   135: goto -29 -> 106
    //   138: astore_1
    //   139: goto -20 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramContext	Context
    //   0	142	1	paramString1	String
    //   0	142	2	paramString2	String
    //   3	40	3	localObject	Object
    //   17	70	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   4	26	103	finally
    //   28	42	103	finally
    //   53	72	103	finally
    //   72	95	103	finally
    //   4	26	116	java/lang/Throwable
    //   28	42	116	java/lang/Throwable
    //   53	72	116	java/lang/Throwable
    //   72	95	116	java/lang/Throwable
    //   48	52	128	java/io/IOException
    //   123	127	128	java/io/IOException
    //   110	114	130	java/io/IOException
    //   95	100	134	finally
    //   95	100	138	java/lang/Throwable
  }
  
  public static void updateCountFailInstallPatch(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putInt("key_count_fail_install_patch_" + paramString1 + paramString2, paramInt);
    paramContext.commit();
  }
  
  public static void updateCountFailStartupPatch(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putInt("key_count_fail_startup_patch_" + paramString1 + paramString2, paramInt);
    paramContext.commit();
  }
  
  public static void updateLastTimePullPatchReconnect(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putLong("key_time_pull_patch_reconnect", paramLong);
    paramContext.commit();
  }
  
  public static void updatePatchConfig(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putString("key_config_patch_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void updatePatchConfigVersion(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putInt("key_config_version_patch", paramInt);
    paramContext.commit();
  }
  
  public static void updatePatchReportInfo(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void updatePatchVerifyStatus(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putBoolean("key_verify_status_patch_" + paramString, paramBoolean);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil
 * JD-Core Version:    0.7.0.1
 */