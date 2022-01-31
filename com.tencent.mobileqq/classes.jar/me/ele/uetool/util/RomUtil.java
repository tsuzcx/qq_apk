package me.ele.uetool.util;

import android.os.Build;
import android.text.TextUtils;

public class RomUtil
{
  private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
  private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
  private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
  private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
  private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
  public static final String ROM_EMUI = "EMUI";
  public static final String ROM_FLYME = "FLYME";
  public static final String ROM_MIUI = "MIUI";
  public static final String ROM_OPPO = "OPPO";
  public static final String ROM_QIKU = "QIKU";
  public static final String ROM_SMARTISAN = "SMARTISAN";
  public static final String ROM_VIVO = "VIVO";
  private static final String TAG = "RomUtil";
  private static String sName;
  private static String sVersion;
  
  public static boolean check(String paramString)
  {
    if (sName != null) {
      return sName.equals(paramString);
    }
    String str = getProp("ro.miui.ui.version.name");
    sVersion = str;
    if (!TextUtils.isEmpty(str)) {
      sName = "MIUI";
    }
    for (;;)
    {
      return sName.equals(paramString);
      str = getProp("ro.build.version.emui");
      sVersion = str;
      if (!TextUtils.isEmpty(str))
      {
        sName = "EMUI";
      }
      else
      {
        str = getProp("ro.build.version.opporom");
        sVersion = str;
        if (!TextUtils.isEmpty(str))
        {
          sName = "OPPO";
        }
        else
        {
          str = getProp("ro.vivo.os.version");
          sVersion = str;
          if (!TextUtils.isEmpty(str))
          {
            sName = "VIVO";
          }
          else
          {
            str = getProp("ro.smartisan.version");
            sVersion = str;
            if (!TextUtils.isEmpty(str))
            {
              sName = "SMARTISAN";
            }
            else
            {
              sVersion = Build.DISPLAY;
              if (sVersion.toUpperCase().contains("FLYME"))
              {
                sName = "FLYME";
              }
              else
              {
                sVersion = "unknown";
                sName = Build.MANUFACTURER.toUpperCase();
              }
            }
          }
        }
      }
    }
  }
  
  public static String getName()
  {
    if (sName == null) {
      check("");
    }
    return sName;
  }
  
  /* Error */
  public static String getProp(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 99	java/io/BufferedReader
    //   5: dup
    //   6: new 101	java/io/InputStreamReader
    //   9: dup
    //   10: invokestatic 107	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: new 109	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   20: ldc 112
    //   22: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 123	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   35: invokevirtual 129	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokespecial 132	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: sipush 1024
    //   44: invokespecial 135	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   47: astore_2
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: invokevirtual 138	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_3
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: invokevirtual 141	java/io/BufferedReader:close	()V
    //   61: aload_2
    //   62: ifnull +7 -> 69
    //   65: aload_2
    //   66: invokevirtual 141	java/io/BufferedReader:close	()V
    //   69: aload_3
    //   70: areturn
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 144	java/io/IOException:printStackTrace	()V
    //   76: aload_3
    //   77: areturn
    //   78: astore_3
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: astore_1
    //   83: ldc 44
    //   85: new 109	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   92: ldc 146
    //   94: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: aload_3
    //   105: invokestatic 152	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   108: pop
    //   109: aload_2
    //   110: ifnull +7 -> 117
    //   113: aload_2
    //   114: invokevirtual 141	java/io/BufferedReader:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 144	java/io/IOException:printStackTrace	()V
    //   124: goto -7 -> 117
    //   127: astore_0
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 141	java/io/BufferedReader:close	()V
    //   136: aload_0
    //   137: athrow
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 144	java/io/IOException:printStackTrace	()V
    //   143: goto -7 -> 136
    //   146: astore_0
    //   147: goto -19 -> 128
    //   150: astore_3
    //   151: goto -70 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   1	132	1	localObject	Object
    //   138	2	1	localIOException1	java.io.IOException
    //   47	67	2	localBufferedReader	java.io.BufferedReader
    //   54	23	3	str	String
    //   78	27	3	localIOException2	java.io.IOException
    //   150	1	3	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   65	69	71	java/io/IOException
    //   2	48	78	java/io/IOException
    //   113	117	119	java/io/IOException
    //   2	48	127	finally
    //   132	136	138	java/io/IOException
    //   50	55	146	finally
    //   57	61	146	finally
    //   83	109	146	finally
    //   50	55	150	java/io/IOException
    //   57	61	150	java/io/IOException
  }
  
  public static String getVersion()
  {
    if (sVersion == null) {
      check("");
    }
    return sVersion;
  }
  
  public static boolean isEmui()
  {
    return check("EMUI");
  }
  
  public static boolean isFlyme()
  {
    return check("FLYME");
  }
  
  public static boolean isMiui()
  {
    return check("MIUI");
  }
  
  public static boolean isOppo()
  {
    return check("OPPO");
  }
  
  public static boolean isQiku()
  {
    return (check("QIKU")) || (check("360"));
  }
  
  public static boolean isSmartisan()
  {
    return check("SMARTISAN");
  }
  
  public static boolean isVivo()
  {
    return check("VIVO");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.util.RomUtil
 * JD-Core Version:    0.7.0.1
 */