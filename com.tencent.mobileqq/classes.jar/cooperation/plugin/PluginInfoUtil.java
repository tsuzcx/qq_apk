package cooperation.plugin;

import alwc;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PluginInfoUtil
{
  static PluginInfo a(File paramFile)
  {
    return (PluginInfo)PluginBaseInfoHelper.createFromFile(paramFile, PluginInfo.class);
  }
  
  public static void a(PluginInfo paramPluginInfo, File paramFile)
  {
    try
    {
      paramFile = PluginUtils.getPluginCfgFile(paramFile, paramPluginInfo.mID);
      if ((paramFile.isFile()) && (paramFile.exists()))
      {
        paramFile.delete();
        paramFile.createNewFile();
      }
      a(paramFile, paramPluginInfo);
      return;
    }
    catch (Exception paramPluginInfo) {}
  }
  
  /* Error */
  public static void a(File paramFile)
  {
    // Byte code:
    //   0: new 34	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: ldc 53
    //   7: invokespecial 56	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 41	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_0
    //   19: invokevirtual 44	java/io/File:delete	()Z
    //   22: pop
    //   23: aconst_null
    //   24: astore_1
    //   25: new 58	java/io/FileOutputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 60	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore_0
    //   34: aload_0
    //   35: ldc 62
    //   37: invokevirtual 68	java/lang/String:getBytes	()[B
    //   40: invokevirtual 72	java/io/FileOutputStream:write	([B)V
    //   43: aload_0
    //   44: invokestatic 78	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   47: return
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 78	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   55: return
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: aload_2
    //   60: astore_1
    //   61: aload_0
    //   62: invokestatic 78	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: goto -7 -> 61
    //   71: astore_1
    //   72: goto -21 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramFile	File
    //   24	42	1	localObject1	Object
    //   67	1	1	localObject2	Object
    //   71	1	1	localException	Exception
    //   56	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	34	48	java/lang/Exception
    //   25	34	56	finally
    //   34	43	67	finally
    //   34	43	71	java/lang/Exception
  }
  
  public static void a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = PluginUtils.getPluginCfgFile(paramFile, paramString);
    } while ((!paramString.isFile()) || (!paramString.exists()));
    paramString.delete();
  }
  
  static boolean a(PluginBaseInfo paramPluginBaseInfo, File paramFile)
  {
    if ((!paramFile.exists()) || (!paramFile.isFile())) {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, "isValidPluginFile file not exist");
      }
    }
    do
    {
      do
      {
        return false;
        if ((paramPluginBaseInfo.mLength > 0L) && (paramFile.length() == paramPluginBaseInfo.mLength)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("plugin_tag", 2, "isValidPluginFile lenth invalid:" + paramPluginBaseInfo.mLength + ", " + paramFile.length());
      return false;
      paramFile = PluginStatic.encodeFile(paramFile.getPath());
      if ((paramPluginBaseInfo.mMD5 != null) && (paramPluginBaseInfo.mMD5.equals(paramFile))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("plugin_tag", 2, "isValidPluginFile lenth invalid:" + paramPluginBaseInfo.mMD5 + ", " + paramFile);
    return false;
    return true;
  }
  
  static boolean a(PluginInfo paramPluginInfo, Context paramContext)
  {
    boolean bool2 = false;
    Object localObject1 = "";
    Object localObject2 = localObject1;
    boolean bool1 = bool2;
    if (paramPluginInfo.mProcesses != null)
    {
      if (paramPluginInfo.mProcesses.length != 0) {
        break label77;
      }
      bool1 = bool2;
      localObject2 = localObject1;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        bool2 = bool1;
        if (BaseApplicationImpl.useQIPCStart((String)localObject2)) {
          bool2 = QIPCServerHelper.getInstance().isModuleRunning(paramPluginInfo.mID);
        }
      }
      return bool2;
      label77:
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      localObject2 = localObject1;
      bool1 = bool2;
      if (paramContext != null)
      {
        localObject2 = paramContext.iterator();
        bool1 = false;
        paramContext = (Context)localObject1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
          int j = paramPluginInfo.mProcesses.length;
          int i = 0;
          label146:
          if (i < j) {
            if (TextUtils.equals(paramPluginInfo.mProcesses[i], ((ActivityManager.RunningAppProcessInfo)localObject1).processName))
            {
              paramContext = paramPluginInfo.mProcesses[i];
              bool1 = true;
            }
          }
          for (;;)
          {
            break;
            i += 1;
            break label146;
          }
        }
        localObject2 = paramContext;
      }
    }
  }
  
  public static boolean a(File paramFile)
  {
    return !IOUtil.contentEquals(new File(paramFile, "PluginVersion.ini"), "345599");
  }
  
  /* Error */
  private static boolean a(File paramFile, PluginInfo paramPluginInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_1
    //   6: invokestatic 215	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser:pluginToXML	(Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfo;)Ljava/lang/String;
    //   9: invokevirtual 68	java/lang/String:getBytes	()[B
    //   12: iconst_0
    //   13: invokestatic 221	com/tencent/mobileqq/utils/Base64Util:encode	([BI)[B
    //   16: astore_1
    //   17: new 58	java/io/FileOutputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 60	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: astore_0
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 72	java/io/FileOutputStream:write	([B)V
    //   31: iconst_1
    //   32: istore_3
    //   33: iload_3
    //   34: istore_2
    //   35: aload_0
    //   36: ifnull +9 -> 45
    //   39: aload_0
    //   40: invokevirtual 224	java/io/FileOutputStream:close	()V
    //   43: iload_3
    //   44: istore_2
    //   45: iload_2
    //   46: ireturn
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull -6 -> 45
    //   54: aload_0
    //   55: invokevirtual 224	java/io/FileOutputStream:close	()V
    //   58: iconst_0
    //   59: ireturn
    //   60: astore_0
    //   61: iconst_0
    //   62: ireturn
    //   63: astore_0
    //   64: aload 4
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 224	java/io/FileOutputStream:close	()V
    //   75: aload_0
    //   76: athrow
    //   77: astore_0
    //   78: iconst_1
    //   79: ireturn
    //   80: astore_1
    //   81: goto -6 -> 75
    //   84: astore 4
    //   86: aload_0
    //   87: astore_1
    //   88: aload 4
    //   90: astore_0
    //   91: goto -24 -> 67
    //   94: astore_1
    //   95: goto -45 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramFile	File
    //   0	98	1	paramPluginInfo	PluginInfo
    //   1	45	2	bool1	boolean
    //   32	12	3	bool2	boolean
    //   3	62	4	localObject1	Object
    //   84	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	26	47	java/lang/Exception
    //   54	58	60	java/io/IOException
    //   5	26	63	finally
    //   39	43	77	java/io/IOException
    //   71	75	80	java/io/IOException
    //   26	31	84	finally
    //   26	31	94	java/lang/Exception
  }
  
  public static File[] a(File paramFile)
  {
    return paramFile.listFiles(new alwc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.PluginInfoUtil
 * JD-Core Version:    0.7.0.1
 */