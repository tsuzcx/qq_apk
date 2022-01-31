package cooperation.qzone;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerListProvider
{
  private static String SERVER_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/com/tencent/mobileqq";
  private static final String TAG = "ServerListProvider";
  public static final int VALUE_DB2 = 13;
  public static final int VALUE_DB3 = 86;
  public static final int VALUE_DEV_001 = 15;
  public static final int VALUE_DEV_002 = 16;
  public static final int VALUE_DEV_003 = 17;
  public static final int VALUE_DEV_004 = 18;
  public static final int VALUE_DEV_005 = 19;
  public static final int VALUE_DEV_006 = 20;
  public static final int VALUE_DEV_007 = 21;
  public static final int VALUE_DEV_008 = 22;
  public static final int VALUE_DEV_009 = 23;
  public static final int VALUE_DEV_010 = 24;
  public static final int VALUE_DEV_011 = 25;
  public static final int VALUE_DEV_012 = 26;
  public static final int VALUE_DEV_013 = 27;
  public static final int VALUE_DEV_014 = 28;
  public static final int VALUE_DEV_015 = 29;
  public static final int VALUE_DEV_016 = 30;
  public static final int VALUE_DEV_017 = 31;
  public static final int VALUE_DEV_018 = 32;
  public static final int VALUE_DEV_019 = 33;
  public static final int VALUE_DEV_020 = 34;
  public static final int VALUE_DEV_021 = 35;
  public static final int VALUE_DEV_022 = 36;
  public static final int VALUE_DEV_023 = 37;
  public static final int VALUE_DEV_024 = 38;
  public static final int VALUE_DEV_025 = 39;
  public static final int VALUE_DEV_026 = 40;
  public static final int VALUE_DEV_027 = 41;
  public static final int VALUE_DEV_028 = 42;
  public static final int VALUE_DEV_029 = 43;
  public static final int VALUE_DEV_030 = 44;
  public static final int VALUE_DEV_031 = 45;
  public static final int VALUE_DEV_032 = 46;
  public static final int VALUE_DEV_033 = 47;
  public static final int VALUE_DEV_034 = 48;
  public static final int VALUE_DEV_035 = 49;
  public static final int VALUE_DEV_036 = 50;
  public static final int VALUE_DEV_037 = 51;
  public static final int VALUE_DEV_050 = 60;
  public static final int VALUE_DEV_051 = 61;
  public static final int VALUE_DEV_052 = 62;
  public static final int VALUE_DEV_053 = 63;
  public static final int VALUE_DEV_054 = 64;
  public static final int VALUE_DEV_055 = 65;
  public static final int VALUE_DEV_056 = 66;
  public static final int VALUE_DEV_057 = 67;
  public static final int VALUE_DEV_058 = 68;
  public static final int VALUE_DEV_059 = 69;
  public static final int VALUE_DEV_060 = 70;
  public static final int VALUE_DEV_061 = 71;
  public static final int VALUE_DEV_062 = 72;
  public static final int VALUE_DEV_063 = 73;
  public static final int VALUE_DEV_064 = 74;
  public static final int VALUE_DEV_065 = 75;
  public static final int VALUE_DEV_066 = 76;
  public static final int VALUE_DEV_067 = 77;
  public static final int VALUE_DEV_068 = 78;
  public static final int VALUE_DEV_069 = 79;
  public static final int VALUE_DEV_070 = 82;
  public static final int VALUE_DEV_071 = 83;
  public static final int VALUE_PUBLISH = 14;
  public static final int VALUE_TEST_001 = 11;
  public static final int VALUE_TEST_006 = 80;
  public static final int VALUE_TEST_007 = 81;
  public static final int VALUE_TEST_008 = 84;
  public static final int VALUE_TEST_009 = 85;
  public static final int VALUE_TEST_195 = 87;
  public static final int VALUE_TOUCH_001 = 12;
  public static final int VALUE_ZHENGSHI = 0;
  private static AtomicBoolean isDebugEnabled;
  
  private static void delServerFile()
  {
    try
    {
      File localFile = new File(SERVER_DIR + "/testserver");
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void enableDebug(boolean paramBoolean)
  {
    if (isDebugEnabled == null) {
      isDebugEnabled = new AtomicBoolean(false);
    }
    isDebugEnabled.set(paramBoolean);
    LocalMultiProcConfig.putBool("key_enable_debug", paramBoolean);
  }
  
  /* Error */
  private static void generateServerFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 222	cooperation/qzone/ServerListProvider:isServerFileExits	()Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: new 167	java/io/File
    //   14: dup
    //   15: getstatic 182	cooperation/qzone/ServerListProvider:SERVER_DIR	Ljava/lang/String;
    //   18: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 196	java/io/File:exists	()Z
    //   26: ifne +8 -> 34
    //   29: aload_0
    //   30: invokevirtual 225	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: new 167	java/io/File
    //   37: dup
    //   38: new 156	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   45: getstatic 182	cooperation/qzone/ServerListProvider:SERVER_DIR	Ljava/lang/String;
    //   48: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 189
    //   53: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 196	java/io/File:exists	()Z
    //   67: ifne -57 -> 10
    //   70: aload_0
    //   71: invokevirtual 228	java/io/File:createNewFile	()Z
    //   74: ifeq +165 -> 239
    //   77: new 230	java/io/FileWriter
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 233	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   85: astore_0
    //   86: new 235	java/io/BufferedWriter
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 238	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   94: astore_1
    //   95: aload_1
    //   96: ldc 240
    //   98: invokevirtual 243	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   101: aload_1
    //   102: invokevirtual 246	java/io/BufferedWriter:close	()V
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 246	java/io/BufferedWriter:close	()V
    //   113: aload_0
    //   114: ifnull -104 -> 10
    //   117: aload_0
    //   118: invokevirtual 247	java/io/FileWriter:close	()V
    //   121: return
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   127: return
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   133: goto -20 -> 113
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_2
    //   140: astore_1
    //   141: aload_1
    //   142: ifnull +7 -> 149
    //   145: aload_1
    //   146: invokevirtual 246	java/io/BufferedWriter:close	()V
    //   149: aload_0
    //   150: ifnull -140 -> 10
    //   153: aload_0
    //   154: invokevirtual 247	java/io/FileWriter:close	()V
    //   157: return
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   163: return
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   169: goto -20 -> 149
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_1
    //   175: aload_3
    //   176: astore_2
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 246	java/io/BufferedWriter:close	()V
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 247	java/io/FileWriter:close	()V
    //   193: aload_0
    //   194: athrow
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   200: goto -15 -> 185
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   208: goto -15 -> 193
    //   211: astore_3
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_0
    //   215: astore_2
    //   216: aload_3
    //   217: astore_0
    //   218: goto -41 -> 177
    //   221: astore_3
    //   222: aload_0
    //   223: astore_2
    //   224: aload_3
    //   225: astore_0
    //   226: goto -49 -> 177
    //   229: astore_1
    //   230: aload_2
    //   231: astore_1
    //   232: goto -91 -> 141
    //   235: astore_2
    //   236: goto -95 -> 141
    //   239: aconst_null
    //   240: astore_0
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -138 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	97	0	localObject1	Object
    //   122	2	0	localException1	Exception
    //   136	1	0	localException2	Exception
    //   138	16	0	localObject2	Object
    //   158	2	0	localException3	Exception
    //   172	43	0	localObject3	Object
    //   217	24	0	localObject4	Object
    //   94	16	1	localBufferedWriter	java.io.BufferedWriter
    //   128	2	1	localException4	Exception
    //   140	6	1	localObject5	Object
    //   164	2	1	localException5	Exception
    //   174	8	1	localObject6	Object
    //   195	2	1	localException6	Exception
    //   203	2	1	localException7	Exception
    //   213	1	1	localObject7	Object
    //   229	1	1	localException8	Exception
    //   231	12	1	localObject8	Object
    //   3	228	2	localObject9	Object
    //   235	1	2	localException9	Exception
    //   1	175	3	localObject10	Object
    //   211	6	3	localObject11	Object
    //   221	4	3	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   117	121	122	java/lang/Exception
    //   109	113	128	java/lang/Exception
    //   70	86	136	java/lang/Exception
    //   153	157	158	java/lang/Exception
    //   145	149	164	java/lang/Exception
    //   70	86	172	finally
    //   181	185	195	java/lang/Exception
    //   189	193	203	java/lang/Exception
    //   86	95	211	finally
    //   95	105	221	finally
    //   86	95	229	java/lang/Exception
    //   95	105	235	java/lang/Exception
  }
  
  public static String getCmdPrefix()
  {
    switch ()
    {
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    default: 
      return "SQQzoneSvc.";
    case 11: 
      return "SQQzoneSvcTest001.";
    case 12: 
      return "SQQzoneSvcTouch001.";
    case 13: 
      return "SQQzoneSvcDb2.";
    case 14: 
      return "SQQzoneSvcPublish.";
    case 15: 
      return "SQQzoneSvcDev001.";
    case 16: 
      return "SQQzoneSvcDev002.";
    case 17: 
      return "SQQzoneSvcDev003.";
    case 18: 
      return "SQQzoneSvcDev004.";
    case 19: 
      return "SQQzoneSvcDev005.";
    case 20: 
      return "SQQzoneSvcDev006.";
    case 21: 
      return "SQQzoneSvcDev007.";
    case 22: 
      return "SQQzoneSvcDev008.";
    case 23: 
      return "SQQzoneSvcDev009.";
    case 24: 
      return "SQQzoneSvcDev010.";
    case 25: 
      return "SQQzoneSvcDev011.";
    case 26: 
      return "SQQzoneSvcDev012.";
    case 27: 
      return "SQQzoneSvcDev013.";
    case 28: 
      return "SQQzoneSvcDev014.";
    case 29: 
      return "SQQzoneSvcDev015.";
    case 30: 
      return "SQQzoneSvcDev016.";
    case 31: 
      return "SQQzoneSvcDev017.";
    case 32: 
      return "SQQzoneSvcDev018.";
    case 33: 
      return "SQQzoneSvcDev019.";
    case 34: 
      return "SQQzoneSvcDev020.";
    case 35: 
      return "SQQzoneSvcDev021.";
    case 36: 
      return "SQQzoneSvcDev022.";
    case 37: 
      return "SQQzoneSvcDev023.";
    case 38: 
      return "SQQzoneSvcDev024.";
    case 39: 
      return "SQQzoneSvcDev025.";
    case 40: 
      return "SQQzoneSvcDev026.";
    case 41: 
      return "SQQzoneSvcDev027.";
    case 42: 
      return "SQQzoneSvcDev028.";
    case 43: 
      return "SQQzoneSvcDev029.";
    case 44: 
      return "SQQzoneSvcDev030.";
    case 45: 
      return "SQQzoneSvcDev031.";
    case 46: 
      return "SQQzoneSvcDev032.";
    case 47: 
      return "SQQzoneSvcDev033.";
    case 48: 
      return "SQQzoneSvcDev034.";
    case 49: 
      return "SQQzoneSvcDev035.";
    case 50: 
      return "SQQzoneSvcDev036.";
    case 51: 
      return "SQQzoneSvcDev037.";
    case 60: 
      return "SQQzoneSvcDev050.";
    case 61: 
      return "SQQzoneSvcDev051.";
    case 62: 
      return "SQQzoneSvcDev052.";
    case 63: 
      return "SQQzoneSvcDev053.";
    case 64: 
      return "SQQzoneSvcDev054.";
    case 65: 
      return "SQQzoneSvcDev055.";
    case 66: 
      return "SQQzoneSvcDev056.";
    case 67: 
      return "SQQzoneSvcDev057.";
    case 68: 
      return "SQQzoneSvcDev058.";
    case 69: 
      return "SQQzoneSvcDev059.";
    case 70: 
      return "SQQzoneSvcDev060.";
    case 71: 
      return "SQQzoneSvcDev061.";
    case 72: 
      return "SQQzoneSvcDev062.";
    case 73: 
      return "SQQzoneSvcDev063.";
    case 74: 
      return "SQQzoneSvcDev064.";
    case 75: 
      return "SQQzoneSvcDev065.";
    case 76: 
      return "SQQzoneSvcDev066.";
    case 77: 
      return "SQQzoneSvcDev067.";
    case 78: 
      return "SQQzoneSvcDev068.";
    case 79: 
      return "SQQzoneSvcDev069.";
    case 80: 
      return "SQQzoneSvcDev089.";
    case 81: 
      return "SQQzoneSvcTest007.";
    case 82: 
      return "SQQzoneSvcDev070.";
    case 83: 
      return "SQQzoneSvcDev071.";
    case 84: 
      return "SQQzoneSvcTest008.";
    case 85: 
      return "SQQzoneSvcTest009.";
    case 86: 
      return "SQQzoneSvcDb3.";
    }
    return "SQQzoneSvcTest195.";
  }
  
  public static int getType()
  {
    return LocalMultiProcConfig.getInt("ServerEnvironment", 0);
  }
  
  public static boolean isDebugEnable()
  {
    if (isDebugEnabled == null)
    {
      isDebugEnabled = new AtomicBoolean(false);
      isDebugEnabled.set(LocalMultiProcConfig.getBool("key_enable_debug", false));
    }
    return isDebugEnabled.get();
  }
  
  public static boolean isServerFileExits()
  {
    boolean bool2 = false;
    try
    {
      File localFile = new File(SERVER_DIR + "/testserver");
      boolean bool1 = bool2;
      if (localFile.exists())
      {
        long l = localFile.length();
        bool1 = bool2;
        if (l > 0L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean killMSF()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (localBaseApplication != null)
      {
        Iterator localIterator = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
        while (localIterator.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (localRunningAppProcessInfo.processName.equals(localBaseApplication.getPackageName() + ":MSF"))
          {
            Process.killProcess(localRunningAppProcessInfo.pid);
            return true;
          }
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean switchToTestServer()
  {
    if (!isServerFileExits())
    {
      generateServerFile();
      if (!killMSF()) {}
    }
    else
    {
      return true;
    }
    delServerFile();
    return false;
  }
  
  public static boolean switchToZhengshi()
  {
    if (isServerFileExits())
    {
      delServerFile();
      if (!killMSF()) {}
    }
    else
    {
      return true;
    }
    generateServerFile();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.ServerListProvider
 * JD-Core Version:    0.7.0.1
 */