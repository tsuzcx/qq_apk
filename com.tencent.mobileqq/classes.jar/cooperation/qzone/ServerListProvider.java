package cooperation.qzone;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import bhcq;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerListProvider
{
  private static String SERVER_DIR = bhcq.l;
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
      File localFile = new File(bhcq.m);
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
    //   4: invokestatic 206	cooperation/qzone/ServerListProvider:isServerFileExits	()Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: new 170	java/io/File
    //   14: dup
    //   15: getstatic 161	cooperation/qzone/ServerListProvider:SERVER_DIR	Ljava/lang/String;
    //   18: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 180	java/io/File:exists	()Z
    //   26: ifne +8 -> 34
    //   29: aload_0
    //   30: invokevirtual 209	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: new 170	java/io/File
    //   37: dup
    //   38: getstatic 173	bhcq:m	Ljava/lang/String;
    //   41: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 180	java/io/File:exists	()Z
    //   49: ifne -39 -> 10
    //   52: aload_0
    //   53: invokevirtual 212	java/io/File:createNewFile	()Z
    //   56: ifeq +165 -> 221
    //   59: new 214	java/io/FileWriter
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 217	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   67: astore_0
    //   68: new 219	java/io/BufferedWriter
    //   71: dup
    //   72: aload_0
    //   73: invokespecial 222	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   76: astore_1
    //   77: aload_1
    //   78: ldc 224
    //   80: invokevirtual 227	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 230	java/io/BufferedWriter:close	()V
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 230	java/io/BufferedWriter:close	()V
    //   95: aload_0
    //   96: ifnull -86 -> 10
    //   99: aload_0
    //   100: invokevirtual 231	java/io/FileWriter:close	()V
    //   103: return
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   109: return
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   115: goto -20 -> 95
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_2
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 230	java/io/BufferedWriter:close	()V
    //   131: aload_0
    //   132: ifnull -122 -> 10
    //   135: aload_0
    //   136: invokevirtual 231	java/io/FileWriter:close	()V
    //   139: return
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   145: return
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   151: goto -20 -> 131
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_3
    //   158: astore_2
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 230	java/io/BufferedWriter:close	()V
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 231	java/io/FileWriter:close	()V
    //   175: aload_0
    //   176: athrow
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   182: goto -15 -> 167
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   190: goto -15 -> 175
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_1
    //   196: aload_0
    //   197: astore_2
    //   198: aload_3
    //   199: astore_0
    //   200: goto -41 -> 159
    //   203: astore_3
    //   204: aload_0
    //   205: astore_2
    //   206: aload_3
    //   207: astore_0
    //   208: goto -49 -> 159
    //   211: astore_1
    //   212: aload_2
    //   213: astore_1
    //   214: goto -91 -> 123
    //   217: astore_2
    //   218: goto -95 -> 123
    //   221: aconst_null
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_1
    //   225: goto -138 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	79	0	localObject1	Object
    //   104	2	0	localException1	Exception
    //   118	1	0	localException2	Exception
    //   120	16	0	localObject2	Object
    //   140	2	0	localException3	Exception
    //   154	43	0	localObject3	Object
    //   199	24	0	localObject4	Object
    //   76	16	1	localBufferedWriter	java.io.BufferedWriter
    //   110	2	1	localException4	Exception
    //   122	6	1	localObject5	Object
    //   146	2	1	localException5	Exception
    //   156	8	1	localObject6	Object
    //   177	2	1	localException6	Exception
    //   185	2	1	localException7	Exception
    //   195	1	1	localObject7	Object
    //   211	1	1	localException8	Exception
    //   213	12	1	localObject8	Object
    //   3	210	2	localObject9	Object
    //   217	1	2	localException9	Exception
    //   1	157	3	localObject10	Object
    //   193	6	3	localObject11	Object
    //   203	4	3	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   99	103	104	java/lang/Exception
    //   91	95	110	java/lang/Exception
    //   52	68	118	java/lang/Exception
    //   135	139	140	java/lang/Exception
    //   127	131	146	java/lang/Exception
    //   52	68	154	finally
    //   163	167	177	java/lang/Exception
    //   171	175	185	java/lang/Exception
    //   68	77	193	finally
    //   77	87	203	finally
    //   68	77	211	java/lang/Exception
    //   77	87	217	java/lang/Exception
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
      File localFile = new File(bhcq.m);
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