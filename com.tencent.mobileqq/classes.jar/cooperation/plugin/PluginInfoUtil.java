package cooperation.plugin;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PluginInfoUtil
{
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
  
  public static void a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = PluginUtils.getPluginCfgFile(paramFile, paramString);
    if ((paramString.isFile()) && (paramString.exists())) {
      paramString.delete();
    }
  }
  
  static boolean a(PluginBaseInfo paramPluginBaseInfo, File paramFile)
  {
    if ((paramFile.exists()) && (paramFile.isFile()))
    {
      StringBuilder localStringBuilder;
      if ((paramPluginBaseInfo.mLength > 0L) && (paramFile.length() == paramPluginBaseInfo.mLength))
      {
        paramFile = PluginStatic.encodeFile(paramFile.getPath());
        if ((paramPluginBaseInfo.mMD5 != null) && (paramPluginBaseInfo.mMD5.equals(paramFile))) {
          return true;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isValidPluginFile md5 invalid:");
          localStringBuilder.append(paramPluginBaseInfo.mMD5);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramFile);
          QLog.e("plugin_tag", 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isValidPluginFile lenth invalid:");
        localStringBuilder.append(paramPluginBaseInfo.mLength);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramFile.length());
        QLog.e("plugin_tag", 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("plugin_tag", 2, "isValidPluginFile file not exist");
    }
    return false;
  }
  
  static boolean a(PluginInfo paramPluginInfo, Context paramContext)
  {
    Object localObject2 = paramPluginInfo.mProcesses;
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject1 = "";
    if ((localObject2 != null) && (paramPluginInfo.mProcesses.length != 0))
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        localObject2 = paramContext.iterator();
        bool2 = false;
        paramContext = (Context)localObject1;
        label143:
        for (;;)
        {
          bool1 = bool2;
          localObject1 = paramContext;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
          int j = paramPluginInfo.mProcesses.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label143;
            }
            if (TextUtils.equals(paramPluginInfo.mProcesses[i], ((ActivityManager.RunningAppProcessInfo)localObject1).processName))
            {
              paramContext = paramPluginInfo.mProcesses[i];
              bool2 = true;
              break;
            }
            i += 1;
          }
        }
      }
    }
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      bool2 = bool1;
      if (BaseApplicationImpl.useQIPCStart((String)localObject1)) {
        bool2 = QIPCServerHelper.getInstance().isModuleRunning(paramPluginInfo.mID);
      }
    }
    if (paramPluginInfo.mSubType == 1)
    {
      bool1 = bool3;
      if (bool2)
      {
        bool1 = bool3;
        if (QShadow.getInstance().isPluginRunning(PluginIdUtil.convertQPluginId2QShadowId(paramPluginInfo.mID))) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramPluginInfo.mSubType == 2)
    {
      bool1 = bool4;
      if (bool2)
      {
        bool1 = bool4;
        if (LoadCompactDynamicFeature.a().a(paramPluginInfo.mID)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return bool2;
  }
  
  public static boolean a(File paramFile)
  {
    return IOUtil.contentEquals(new File(paramFile, "PluginVersion.ini"), AppSetting.i()) ^ true;
  }
  
  /* Error */
  private static boolean a(File paramFile, PluginInfo paramPluginInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_1
    //   8: invokestatic 220	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser:pluginToXML	(Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfo;)Ljava/lang/String;
    //   11: invokevirtual 224	java/lang/String:getBytes	()[B
    //   14: iconst_0
    //   15: invokestatic 230	com/tencent/mobileqq/utils/Base64Util:encode	([BI)[B
    //   18: astore_1
    //   19: new 232	java/io/FileOutputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 235	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: astore_0
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 239	java/io/FileOutputStream:write	([B)V
    //   33: iconst_1
    //   34: istore_2
    //   35: aload_0
    //   36: invokevirtual 242	java/io/FileOutputStream:close	()V
    //   39: iconst_1
    //   40: ireturn
    //   41: astore_3
    //   42: aload_0
    //   43: astore_1
    //   44: aload_3
    //   45: astore_0
    //   46: goto +9 -> 55
    //   49: goto +16 -> 65
    //   52: astore_0
    //   53: aload_3
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +7 -> 63
    //   59: aload_1
    //   60: invokevirtual 242	java/io/FileOutputStream:close	()V
    //   63: aload_0
    //   64: athrow
    //   65: aload_0
    //   66: ifnull +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 242	java/io/FileOutputStream:close	()V
    //   73: iconst_0
    //   74: ireturn
    //   75: astore_0
    //   76: aload 4
    //   78: astore_0
    //   79: goto -14 -> 65
    //   82: astore_1
    //   83: goto -34 -> 49
    //   86: astore_0
    //   87: iload_2
    //   88: ireturn
    //   89: astore_1
    //   90: goto -27 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramFile	File
    //   0	93	1	paramPluginInfo	PluginInfo
    //   1	87	2	bool	boolean
    //   6	1	3	localObject1	Object
    //   41	13	3	localObject2	Object
    //   3	74	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	33	41	finally
    //   7	28	52	finally
    //   7	28	75	java/lang/Exception
    //   28	33	82	java/lang/Exception
    //   35	39	86	java/io/IOException
    //   69	73	86	java/io/IOException
    //   59	63	89	java/io/IOException
  }
  
  /* Error */
  public static void b(File paramFile)
  {
    // Byte code:
    //   0: new 27	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: ldc 198
    //   7: invokespecial 201	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 34	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_0
    //   19: invokevirtual 37	java/io/File:delete	()Z
    //   22: pop
    //   23: new 232	java/io/FileOutputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 235	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokestatic 206	com/tencent/common/config/AppSetting:i	()Ljava/lang/String;
    //   36: invokevirtual 224	java/lang/String:getBytes	()[B
    //   39: invokevirtual 239	java/io/FileOutputStream:write	([B)V
    //   42: goto +18 -> 60
    //   45: astore_1
    //   46: goto +6 -> 52
    //   49: astore_1
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: invokestatic 247	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   56: aload_1
    //   57: athrow
    //   58: aconst_null
    //   59: astore_0
    //   60: aload_0
    //   61: invokestatic 247	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   64: return
    //   65: astore_0
    //   66: goto -8 -> 58
    //   69: astore_1
    //   70: goto -10 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramFile	File
    //   45	1	1	localObject1	Object
    //   49	8	1	localObject2	Object
    //   69	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   32	42	45	finally
    //   23	32	49	finally
    //   23	32	65	java/lang/Exception
    //   32	42	69	java/lang/Exception
  }
  
  public static File[] c(File paramFile)
  {
    return paramFile.listFiles(new PluginInfoUtil.1());
  }
  
  static PluginInfo d(File paramFile)
  {
    return (PluginInfo)PluginBaseInfoHelper.createFromFile(paramFile, PluginInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginInfoUtil
 * JD-Core Version:    0.7.0.1
 */