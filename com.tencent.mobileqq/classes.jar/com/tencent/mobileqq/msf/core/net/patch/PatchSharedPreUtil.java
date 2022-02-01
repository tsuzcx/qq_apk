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
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_count_fail_install_patch_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int getCountFailStartupPatch(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_count_fail_startup_patch_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  /* Error */
  public static String getInstalledPatchName(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 6
    //   11: new 68	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokevirtual 72	android/content/Context:getFilesDir	()Ljava/io/File;
    //   19: ldc 8
    //   21: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_0
    //   25: sipush 256
    //   28: newarray byte
    //   30: astore 7
    //   32: aload_0
    //   33: invokevirtual 79	java/io/File:exists	()Z
    //   36: ifeq +56 -> 92
    //   39: new 81	java/io/BufferedInputStream
    //   42: dup
    //   43: new 83	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 86	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 89	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload 7
    //   58: invokevirtual 93	java/io/BufferedInputStream:read	([B)I
    //   61: istore_2
    //   62: aload_1
    //   63: astore_3
    //   64: aload 6
    //   66: astore_0
    //   67: iload_2
    //   68: ifle +29 -> 97
    //   71: new 95	java/lang/String
    //   74: dup
    //   75: aload 7
    //   77: iconst_0
    //   78: iload_2
    //   79: invokespecial 98	java/lang/String:<init>	([BII)V
    //   82: astore_0
    //   83: aload_1
    //   84: astore_3
    //   85: goto +12 -> 97
    //   88: astore_0
    //   89: goto +26 -> 115
    //   92: aconst_null
    //   93: astore_3
    //   94: aload 6
    //   96: astore_0
    //   97: aload_0
    //   98: astore 4
    //   100: aload_3
    //   101: ifnull +36 -> 137
    //   104: aload_3
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 101	java/io/BufferedInputStream:close	()V
    //   110: aload_0
    //   111: areturn
    //   112: astore_0
    //   113: aload_3
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 101	java/io/BufferedInputStream:close	()V
    //   123: aload_0
    //   124: athrow
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +9 -> 137
    //   131: aload 5
    //   133: astore_0
    //   134: goto -28 -> 106
    //   137: aload 4
    //   139: areturn
    //   140: astore_0
    //   141: goto -16 -> 125
    //   144: astore_0
    //   145: goto -18 -> 127
    //   148: astore_1
    //   149: aload_0
    //   150: areturn
    //   151: astore_1
    //   152: goto -29 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramContext	Context
    //   0	155	1	paramString	String
    //   61	18	2	i	int
    //   4	110	3	str	String
    //   6	132	4	localContext	Context
    //   1	131	5	localObject1	Object
    //   9	86	6	localObject2	Object
    //   30	46	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   55	62	88	finally
    //   71	83	88	finally
    //   11	55	112	finally
    //   11	55	140	java/lang/Throwable
    //   55	62	144	java/lang/Throwable
    //   71	83	144	java/lang/Throwable
    //   106	110	148	java/io/IOException
    //   119	123	151	java/io/IOException
  }
  
  public static long getLastTimePullPatchReconnect(Context paramContext)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getLong("key_time_pull_patch_reconnect", 0L);
  }
  
  public static String getPatchConfig(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_config_patch_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), null);
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
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_verify_status_patch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  /* Error */
  public static void saveInstalledPatchName(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: new 68	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokevirtual 72	android/content/Context:getFilesDir	()Ljava/io/File;
    //   15: ldc 8
    //   17: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore 5
    //   22: aload_2
    //   23: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +26 -> 52
    //   29: aload 4
    //   31: astore_0
    //   32: aload 5
    //   34: invokevirtual 79	java/io/File:exists	()Z
    //   37: ifeq +62 -> 99
    //   40: aload 5
    //   42: invokevirtual 132	java/io/File:delete	()Z
    //   45: pop
    //   46: aload 4
    //   48: astore_0
    //   49: goto +50 -> 99
    //   52: aload_2
    //   53: invokevirtual 136	java/lang/String:getBytes	()[B
    //   56: astore_2
    //   57: aload 5
    //   59: invokevirtual 79	java/io/File:exists	()Z
    //   62: ifeq +9 -> 71
    //   65: aload 5
    //   67: invokevirtual 132	java/io/File:delete	()Z
    //   70: pop
    //   71: aload 5
    //   73: invokevirtual 139	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: new 141	java/io/BufferedOutputStream
    //   80: dup
    //   81: new 143	java/io/FileOutputStream
    //   84: dup
    //   85: aload 5
    //   87: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: invokespecial 147	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   93: astore_0
    //   94: aload_0
    //   95: aload_2
    //   96: invokevirtual 151	java/io/BufferedOutputStream:write	([B)V
    //   99: aload_0
    //   100: ifnull +37 -> 137
    //   103: aload_0
    //   104: invokevirtual 152	java/io/BufferedOutputStream:close	()V
    //   107: return
    //   108: astore_2
    //   109: aload_0
    //   110: astore_1
    //   111: aload_2
    //   112: astore_0
    //   113: goto +7 -> 120
    //   116: goto +14 -> 130
    //   119: astore_0
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 152	java/io/BufferedOutputStream:close	()V
    //   128: aload_0
    //   129: athrow
    //   130: aload_0
    //   131: ifnull +6 -> 137
    //   134: goto -31 -> 103
    //   137: return
    //   138: astore_0
    //   139: aload_3
    //   140: astore_0
    //   141: goto -11 -> 130
    //   144: astore_1
    //   145: goto -29 -> 116
    //   148: astore_0
    //   149: return
    //   150: astore_1
    //   151: goto -23 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramContext	Context
    //   0	154	1	paramString1	String
    //   0	154	2	paramString2	String
    //   3	137	3	localObject1	Object
    //   5	42	4	localObject2	Object
    //   20	66	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   94	99	108	finally
    //   7	29	119	finally
    //   32	46	119	finally
    //   52	71	119	finally
    //   71	94	119	finally
    //   7	29	138	java/lang/Throwable
    //   32	46	138	java/lang/Throwable
    //   52	71	138	java/lang/Throwable
    //   71	94	138	java/lang/Throwable
    //   94	99	144	java/lang/Throwable
    //   103	107	148	java/io/IOException
    //   124	128	150	java/io/IOException
  }
  
  public static void updateCountFailInstallPatch(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_count_fail_install_patch_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void updateCountFailStartupPatch(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_count_fail_startup_patch_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_config_patch_");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_verify_status_patch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil
 * JD-Core Version:    0.7.0.1
 */