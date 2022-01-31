package com.tencent.ttpic.baseutils.guid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.UUID;

public class GUIDUtil
{
  private static final String KEY_UUID = "_uuid";
  private static final String KEY_UUID_FOLDER = "UUID";
  private static String sUUID = null;
  
  private static byte[] genUUIDNameBytes()
  {
    return (DeviceInstance.getInstance().getDeviceName() + System.currentTimeMillis() + UUID.randomUUID().toString()).getBytes();
  }
  
  public static String getGUID(Context paramContext)
  {
    return getUUID(paramContext).replace("-", "");
  }
  
  private static String getUUID(Context paramContext)
  {
    String str1;
    if (!TextUtils.isEmpty(sUUID)) {
      str1 = sUUID;
    }
    SharedPreferences localSharedPreferences;
    String str2;
    label274:
    do
    {
      String str3;
      do
      {
        for (;;)
        {
          return str1;
          str1 = "";
          localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
          paramContext = str1;
          try
          {
            if (!DeviceUtils.isExternalStorageAvailable()) {
              break label274;
            }
            paramContext = str1;
            str2 = readStringFromSD("_uuid");
            paramContext = str2;
            if (TextUtils.isEmpty(str2))
            {
              paramContext = str2;
              str1 = localSharedPreferences.getString("_uuid", "");
              paramContext = str1;
              if (TextUtils.isEmpty(str1))
              {
                paramContext = str1;
                str1 = UUID.nameUUIDFromBytes(genUUIDNameBytes()).toString();
                paramContext = str1;
                writeToSD("_uuid", str1);
                paramContext = str1;
                localSharedPreferences.edit().putString("_uuid", str1).apply();
                paramContext = str1;
                sUUID = str1;
                return str1;
              }
            }
          }
          catch (Exception localException1)
          {
            try
            {
              str2 = localSharedPreferences.getString("_uuid", "");
              Object localObject1 = str2;
              paramContext = str2;
              if (!TextUtils.isEmpty(str2)) {
                continue;
              }
              paramContext = str2;
              localObject1 = UUID.nameUUIDFromBytes(genUUIDNameBytes()).toString();
              paramContext = (Context)localObject1;
              localSharedPreferences.edit().putString("_uuid", (String)localObject1).apply();
              paramContext = (Context)localObject1;
              sUUID = (String)localObject1;
              return localObject1;
            }
            catch (Exception localException2)
            {
              LogUtils.e(localException2);
              return paramContext;
            }
            paramContext = localException2;
            writeToSD("_uuid", localException2);
            paramContext = localException2;
            sUUID = localException2;
            return localException2;
          }
        }
        paramContext = str2;
        str3 = localSharedPreferences.getString("_uuid", "");
        paramContext = str2;
        if (TextUtils.isEmpty(str3)) {
          break;
        }
        localObject2 = str2;
        paramContext = str2;
      } while (str3.equals(str2));
      paramContext = str2;
      localSharedPreferences.edit().putString("_uuid", str2).apply();
      paramContext = str2;
      sUUID = str2;
      return str2;
      paramContext = (Context)localObject2;
      str2 = localSharedPreferences.getString("_uuid", "");
      localObject2 = str2;
      paramContext = str2;
    } while (!TextUtils.isEmpty(str2));
    paramContext = str2;
    Object localObject2 = UUID.nameUUIDFromBytes(genUUIDNameBytes()).toString();
    paramContext = (Context)localObject2;
    localSharedPreferences.edit().putString("_uuid", (String)localObject2).apply();
    paramContext = (Context)localObject2;
    sUUID = (String)localObject2;
    return localObject2;
  }
  
  /* Error */
  private static String readStringFromSD(String paramString)
  {
    // Byte code:
    //   0: new 24	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: new 141	java/io/File
    //   12: dup
    //   13: new 24	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   20: invokestatic 147	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   23: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: getstatic 153	java/io/File:separator	Ljava/lang/String;
    //   29: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 11
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: aload_0
    //   41: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 159	java/io/File:exists	()Z
    //   49: ifne +5 -> 54
    //   52: aconst_null
    //   53: areturn
    //   54: new 161	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: astore_2
    //   63: aload_2
    //   64: astore_0
    //   65: aload_2
    //   66: invokevirtual 168	java/io/FileInputStream:read	()I
    //   69: istore_1
    //   70: iload_1
    //   71: iconst_m1
    //   72: if_icmpeq +37 -> 109
    //   75: aload_2
    //   76: astore_0
    //   77: aload 4
    //   79: iload_1
    //   80: i2c
    //   81: invokevirtual 171	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: goto -22 -> 63
    //   88: astore_3
    //   89: aload_2
    //   90: astore_0
    //   91: aload_3
    //   92: invokestatic 135	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 174	java/io/FileInputStream:close	()V
    //   103: aload 4
    //   105: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: areturn
    //   109: aload_2
    //   110: astore_0
    //   111: aload_2
    //   112: invokevirtual 174	java/io/FileInputStream:close	()V
    //   115: aload_2
    //   116: ifnull -13 -> 103
    //   119: aload_2
    //   120: invokevirtual 174	java/io/FileInputStream:close	()V
    //   123: goto -20 -> 103
    //   126: astore_0
    //   127: aload_0
    //   128: invokestatic 135	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   131: goto -28 -> 103
    //   134: astore_0
    //   135: aload_0
    //   136: invokestatic 135	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   139: goto -36 -> 103
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 174	java/io/FileInputStream:close	()V
    //   153: aload_2
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokestatic 135	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   160: goto -7 -> 153
    //   163: astore_2
    //   164: goto -19 -> 145
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -81 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramString	String
    //   69	11	1	i	int
    //   62	58	2	localFileInputStream	java.io.FileInputStream
    //   142	12	2	localObject1	Object
    //   163	1	2	localObject2	Object
    //   169	1	2	localObject3	Object
    //   88	4	3	localException1	Exception
    //   167	1	3	localException2	Exception
    //   7	97	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   65	70	88	java/lang/Exception
    //   77	85	88	java/lang/Exception
    //   111	115	88	java/lang/Exception
    //   119	123	126	java/lang/Exception
    //   99	103	134	java/lang/Exception
    //   54	63	142	finally
    //   149	153	155	java/lang/Exception
    //   65	70	163	finally
    //   77	85	163	finally
    //   91	95	163	finally
    //   111	115	163	finally
    //   54	63	167	java/lang/Exception
  }
  
  /* Error */
  private static boolean writeToSD(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 5
    //   8: astore_3
    //   9: new 141	java/io/File
    //   12: dup
    //   13: new 24	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   20: invokestatic 147	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   23: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: getstatic 153	java/io/File:separator	Ljava/lang/String;
    //   29: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 11
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: aload_0
    //   41: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: astore_0
    //   45: aload 5
    //   47: astore_3
    //   48: aload_0
    //   49: invokevirtual 159	java/io/File:exists	()Z
    //   52: ifne +98 -> 150
    //   55: aload 5
    //   57: astore_3
    //   58: new 141	java/io/File
    //   61: dup
    //   62: aload_0
    //   63: invokevirtual 177	java/io/File:getParent	()Ljava/lang/String;
    //   66: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore 6
    //   71: aload 5
    //   73: astore_3
    //   74: aload 6
    //   76: invokevirtual 159	java/io/File:exists	()Z
    //   79: ifne +153 -> 232
    //   82: aload 5
    //   84: astore_3
    //   85: aload 6
    //   87: invokevirtual 183	java/io/File:mkdirs	()Z
    //   90: istore_2
    //   91: iload_2
    //   92: ifeq +58 -> 150
    //   95: aload 5
    //   97: astore_3
    //   98: aload_0
    //   99: invokevirtual 186	java/io/File:createNewFile	()Z
    //   102: ifeq +48 -> 150
    //   105: aload 5
    //   107: astore_3
    //   108: aload_1
    //   109: ldc 188
    //   111: invokevirtual 191	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   114: astore_1
    //   115: aload 5
    //   117: astore_3
    //   118: new 193	java/io/FileOutputStream
    //   121: dup
    //   122: aload_0
    //   123: iconst_0
    //   124: invokespecial 196	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   127: astore_0
    //   128: aload_0
    //   129: aload_1
    //   130: invokevirtual 200	java/io/FileOutputStream:write	([B)V
    //   133: aload_0
    //   134: ifnull +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   141: iconst_1
    //   142: ireturn
    //   143: astore_0
    //   144: aload_0
    //   145: invokestatic 135	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   148: iconst_1
    //   149: ireturn
    //   150: iconst_0
    //   151: ifeq +11 -> 162
    //   154: new 203	java/lang/NullPointerException
    //   157: dup
    //   158: invokespecial 204	java/lang/NullPointerException:<init>	()V
    //   161: athrow
    //   162: iconst_0
    //   163: ireturn
    //   164: astore_0
    //   165: aload_0
    //   166: invokestatic 135	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   169: goto -7 -> 162
    //   172: astore_1
    //   173: aload 4
    //   175: astore_0
    //   176: aload_0
    //   177: astore_3
    //   178: aload_1
    //   179: invokestatic 135	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   182: aload_0
    //   183: ifnull -21 -> 162
    //   186: aload_0
    //   187: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   190: goto -28 -> 162
    //   193: astore_0
    //   194: aload_0
    //   195: invokestatic 135	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   198: goto -36 -> 162
    //   201: astore_0
    //   202: aload_3
    //   203: ifnull +7 -> 210
    //   206: aload_3
    //   207: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   210: aload_0
    //   211: athrow
    //   212: astore_1
    //   213: aload_1
    //   214: invokestatic 135	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   217: goto -7 -> 210
    //   220: astore_1
    //   221: aload_0
    //   222: astore_3
    //   223: aload_1
    //   224: astore_0
    //   225: goto -23 -> 202
    //   228: astore_1
    //   229: goto -53 -> 176
    //   232: iconst_1
    //   233: istore_2
    //   234: goto -143 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramString1	String
    //   0	237	1	paramString2	String
    //   90	144	2	bool	boolean
    //   8	215	3	localObject1	Object
    //   4	170	4	localObject2	Object
    //   1	115	5	localObject3	Object
    //   69	17	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   137	141	143	java/lang/Exception
    //   154	162	164	java/lang/Exception
    //   9	45	172	java/lang/Exception
    //   48	55	172	java/lang/Exception
    //   58	71	172	java/lang/Exception
    //   74	82	172	java/lang/Exception
    //   85	91	172	java/lang/Exception
    //   98	105	172	java/lang/Exception
    //   108	115	172	java/lang/Exception
    //   118	128	172	java/lang/Exception
    //   186	190	193	java/lang/Exception
    //   9	45	201	finally
    //   48	55	201	finally
    //   58	71	201	finally
    //   74	82	201	finally
    //   85	91	201	finally
    //   98	105	201	finally
    //   108	115	201	finally
    //   118	128	201	finally
    //   178	182	201	finally
    //   206	210	212	java/lang/Exception
    //   128	133	220	finally
    //   128	133	228	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.guid.GUIDUtil
 * JD-Core Version:    0.7.0.1
 */