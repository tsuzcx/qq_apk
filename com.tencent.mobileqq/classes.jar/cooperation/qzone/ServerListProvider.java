package cooperation.qzone;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.cache.QZoneFilePath;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerListProvider
{
  private static String SERVER_DIR = QZoneFilePath.SERVER_DIR;
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
      File localFile = new File(QZoneFilePath.TESTSERVER_PATH);
      if (localFile.exists()) {
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
    //   0: invokestatic 204	cooperation/qzone/ServerListProvider:isServerFileExits	()Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: new 168	java/io/File
    //   10: dup
    //   11: getstatic 159	cooperation/qzone/ServerListProvider:SERVER_DIR	Ljava/lang/String;
    //   14: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 178	java/io/File:exists	()Z
    //   22: ifne +8 -> 30
    //   25: aload_0
    //   26: invokevirtual 207	java/io/File:mkdirs	()Z
    //   29: pop
    //   30: new 168	java/io/File
    //   33: dup
    //   34: getstatic 171	cooperation/qzone/cache/QZoneFilePath:TESTSERVER_PATH	Ljava/lang/String;
    //   37: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 178	java/io/File:exists	()Z
    //   45: ifne +165 -> 210
    //   48: aconst_null
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_3
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_1
    //   55: invokevirtual 210	java/io/File:createNewFile	()Z
    //   58: ifeq +54 -> 112
    //   61: new 212	java/io/FileWriter
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 215	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   69: astore_0
    //   70: new 217	java/io/BufferedWriter
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 220	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   78: astore_1
    //   79: aload_1
    //   80: ldc 222
    //   82: invokevirtual 225	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   85: aload_1
    //   86: invokevirtual 228	java/io/BufferedWriter:close	()V
    //   89: goto +25 -> 114
    //   92: astore_3
    //   93: aload_1
    //   94: astore_2
    //   95: aload_3
    //   96: astore_1
    //   97: goto +45 -> 142
    //   100: goto +80 -> 180
    //   103: astore_1
    //   104: goto +38 -> 142
    //   107: aload_3
    //   108: astore_1
    //   109: goto +71 -> 180
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +15 -> 130
    //   118: aload_1
    //   119: invokevirtual 228	java/io/BufferedWriter:close	()V
    //   122: goto +8 -> 130
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 231	java/lang/Exception:printStackTrace	()V
    //   130: aload_0
    //   131: ifnull +79 -> 210
    //   134: aload_0
    //   135: invokevirtual 232	java/io/FileWriter:close	()V
    //   138: return
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: aload_2
    //   143: ifnull +15 -> 158
    //   146: aload_2
    //   147: invokevirtual 228	java/io/BufferedWriter:close	()V
    //   150: goto +8 -> 158
    //   153: astore_2
    //   154: aload_2
    //   155: invokevirtual 231	java/lang/Exception:printStackTrace	()V
    //   158: aload_0
    //   159: ifnull +15 -> 174
    //   162: aload_0
    //   163: invokevirtual 232	java/io/FileWriter:close	()V
    //   166: goto +8 -> 174
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 231	java/lang/Exception:printStackTrace	()V
    //   174: aload_1
    //   175: athrow
    //   176: aconst_null
    //   177: astore_0
    //   178: aload_3
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +15 -> 196
    //   184: aload_1
    //   185: invokevirtual 228	java/io/BufferedWriter:close	()V
    //   188: goto +8 -> 196
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 231	java/lang/Exception:printStackTrace	()V
    //   196: aload_0
    //   197: ifnull +13 -> 210
    //   200: aload_0
    //   201: invokevirtual 232	java/io/FileWriter:close	()V
    //   204: return
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 231	java/lang/Exception:printStackTrace	()V
    //   210: return
    //   211: astore_0
    //   212: goto -36 -> 176
    //   215: astore_1
    //   216: goto -109 -> 107
    //   219: astore_2
    //   220: goto -120 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	146	0	localObject1	Object
    //   169	2	0	localException1	Exception
    //   177	24	0	localObject2	Object
    //   205	2	0	localException2	Exception
    //   211	1	0	localException3	Exception
    //   40	57	1	localObject3	Object
    //   103	1	1	localObject4	Object
    //   108	11	1	localObject5	Object
    //   125	2	1	localException4	Exception
    //   139	36	1	localObject6	Object
    //   179	6	1	localObject7	Object
    //   191	2	1	localException5	Exception
    //   215	1	1	localException6	Exception
    //   49	98	2	localObject8	Object
    //   153	2	2	localException7	Exception
    //   219	1	2	localException8	Exception
    //   51	1	3	localObject9	Object
    //   92	87	3	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   79	89	92	finally
    //   70	79	103	finally
    //   118	122	125	java/lang/Exception
    //   54	70	139	finally
    //   146	150	153	java/lang/Exception
    //   162	166	169	java/lang/Exception
    //   184	188	191	java/lang/Exception
    //   134	138	205	java/lang/Exception
    //   200	204	205	java/lang/Exception
    //   54	70	211	java/lang/Exception
    //   70	79	215	java/lang/Exception
    //   79	89	219	java/lang/Exception
  }
  
  public static String getCmdPrefix()
  {
    return "SQQzoneSvc.";
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
      File localFile = new File(QZoneFilePath.TESTSERVER_PATH);
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
          String str = localRunningAppProcessInfo.processName;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localBaseApplication.getPackageName());
          localStringBuilder.append(":MSF");
          if (str.equals(localStringBuilder.toString()))
          {
            Process.killProcess(localRunningAppProcessInfo.pid);
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      label102:
      break label102;
    }
    return false;
  }
  
  public static boolean switchToTestServer()
  {
    if (!isServerFileExits())
    {
      generateServerFile();
      if (killMSF()) {
        return true;
      }
      delServerFile();
      return false;
    }
    return true;
  }
  
  public static boolean switchToZhengshi()
  {
    if (isServerFileExits())
    {
      delServerFile();
      if (killMSF()) {
        return true;
      }
      generateServerFile();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.ServerListProvider
 * JD-Core Version:    0.7.0.1
 */