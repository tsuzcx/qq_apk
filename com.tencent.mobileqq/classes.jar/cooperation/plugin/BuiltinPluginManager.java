package cooperation.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.HashMap;

public class BuiltinPluginManager
{
  private static volatile BuiltinPluginManager c;
  private static String[] d = { "qzone_plugin.apk", "qwallet_plugin.apk", "qqfav.apk", "qqwadl.apk" };
  private Context a;
  private HashMap<String, PluginInfo> b = new HashMap();
  
  private BuiltinPluginManager(Context paramContext)
  {
    this.a = paramContext;
    a();
  }
  
  public static final BuiltinPluginManager a(Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new BuiltinPluginManager(paramContext);
        }
      }
      finally {}
    }
    return c;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = d;
      if (i >= arrayOfString.length) {
        break;
      }
      if (paramString.equals(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public PluginInfo a(String paramString)
  {
    return (PluginInfo)this.b.get(paramString);
  }
  
  public void a()
  {
    b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init. built in plugin size:");
      localStringBuilder.append(this.b.size());
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      PluginInfo localPluginInfo = (PluginInfo)this.b.get(paramString);
      if (localPluginInfo != null)
      {
        if (paramPluginBaseInfo != null)
        {
          boolean bool2 = TextUtils.equals(localPluginInfo.mMD5, paramPluginBaseInfo.mMD5);
          paramPluginBaseInfo = new StringBuilder();
          paramPluginBaseInfo.append("isUpToDayBuiltIn ");
          paramPluginBaseInfo.append(paramString);
          paramPluginBaseInfo.append(" isUpToDay ");
          paramPluginBaseInfo.append(bool2);
          QLog.i("plugin_tag", 1, paramPluginBaseInfo.toString());
          bool1 = bool2;
          if (bool2) {
            return bool1;
          }
          CaughtExceptionReport.a(new RuntimeException(), "plugin_tagCreateClassLoaderNotUpToDay");
          return bool2;
        }
        QLog.i("plugin_tag", 1, "isUpToDayBuiltIn info");
      }
    }
    boolean bool1 = false;
    return bool1;
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: new 136	java/io/BufferedReader
    //   3: dup
    //   4: new 138	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: getfield 39	cooperation/plugin/BuiltinPluginManager:a	Landroid/content/Context;
    //   12: invokevirtual 144	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   15: ldc 146
    //   17: invokevirtual 152	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   20: invokespecial 155	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: invokespecial 158	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 161	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +157 -> 190
    //   36: aload_2
    //   37: invokevirtual 164	java/lang/String:trim	()Ljava/lang/String;
    //   40: ldc 166
    //   42: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   45: astore 4
    //   47: aload 4
    //   49: iconst_0
    //   50: aaload
    //   51: astore_3
    //   52: ldc 172
    //   54: astore_2
    //   55: aload 4
    //   57: arraylength
    //   58: iconst_1
    //   59: if_icmple +8 -> 67
    //   62: aload 4
    //   64: iconst_1
    //   65: aaload
    //   66: astore_2
    //   67: new 64	cooperation/plugin/PluginInfo
    //   70: dup
    //   71: invokespecial 173	cooperation/plugin/PluginInfo:<init>	()V
    //   74: astore 4
    //   76: aload 4
    //   78: aload_3
    //   79: putfield 176	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   82: aload 4
    //   84: aload_2
    //   85: putfield 102	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   88: aload 4
    //   90: iconst_1
    //   91: putfield 180	cooperation/plugin/PluginInfo:mUpdateType	I
    //   94: aload 4
    //   96: iconst_0
    //   97: putfield 183	cooperation/plugin/PluginInfo:mInstallType	I
    //   100: getstatic 188	com/tencent/mobileqq/BuildConfig:a	Ljava/util/Set;
    //   103: aload_3
    //   104: invokeinterface 193 2 0
    //   109: ifeq +9 -> 118
    //   112: aload 4
    //   114: iconst_2
    //   115: putfield 196	cooperation/plugin/PluginInfo:mSubType	I
    //   118: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +55 -> 176
    //   124: new 74	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   131: astore_2
    //   132: aload_2
    //   133: ldc 198
    //   135: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_2
    //   140: aload 4
    //   142: getfield 176	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   145: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: ldc 200
    //   152: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: aload 4
    //   159: getfield 102	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   162: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc 90
    //   168: iconst_2
    //   169: aload_2
    //   170: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: getfield 37	cooperation/plugin/BuiltinPluginManager:b	Ljava/util/HashMap;
    //   180: aload_3
    //   181: aload 4
    //   183: invokevirtual 204	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: pop
    //   187: goto -160 -> 27
    //   190: invokestatic 210	com/tencent/mobileqq/qshadow/core/QShadow:getInstance	()Lcom/tencent/mobileqq/qshadow/core/QShadow;
    //   193: invokevirtual 214	com/tencent/mobileqq/qshadow/core/QShadow:getQShadowBuildInPlugins	()Ljava/util/Map;
    //   196: invokeinterface 220 1 0
    //   201: invokeinterface 224 1 0
    //   206: astore_3
    //   207: aload_1
    //   208: astore_2
    //   209: aload_3
    //   210: invokeinterface 229 1 0
    //   215: ifeq +176 -> 391
    //   218: aload_3
    //   219: invokeinterface 233 1 0
    //   224: checkcast 235	java/util/Map$Entry
    //   227: astore 4
    //   229: new 64	cooperation/plugin/PluginInfo
    //   232: dup
    //   233: invokespecial 173	cooperation/plugin/PluginInfo:<init>	()V
    //   236: astore_2
    //   237: aload_2
    //   238: iconst_1
    //   239: putfield 196	cooperation/plugin/PluginInfo:mSubType	I
    //   242: aload_2
    //   243: aload 4
    //   245: invokeinterface 238 1 0
    //   250: checkcast 104	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
    //   253: getfield 239	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:mID	Ljava/lang/String;
    //   256: putfield 176	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   259: aload_2
    //   260: aload 4
    //   262: invokeinterface 238 1 0
    //   267: checkcast 104	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
    //   270: getfield 105	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:mMD5	Ljava/lang/String;
    //   273: putfield 102	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   276: aload_2
    //   277: aload 4
    //   279: invokeinterface 238 1 0
    //   284: checkcast 104	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
    //   287: getfield 240	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:mUpdateType	I
    //   290: putfield 180	cooperation/plugin/PluginInfo:mUpdateType	I
    //   293: aload_2
    //   294: aload 4
    //   296: invokeinterface 238 1 0
    //   301: checkcast 104	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
    //   304: getfield 241	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:mInstallType	I
    //   307: putfield 183	cooperation/plugin/PluginInfo:mInstallType	I
    //   310: aload_0
    //   311: getfield 37	cooperation/plugin/BuiltinPluginManager:b	Ljava/util/HashMap;
    //   314: aload 4
    //   316: invokeinterface 244 1 0
    //   321: aload_2
    //   322: invokevirtual 204	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq -122 -> 207
    //   332: new 74	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   339: astore 4
    //   341: aload 4
    //   343: ldc 246
    //   345: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 4
    //   351: aload_2
    //   352: getfield 176	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   355: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 4
    //   361: ldc 200
    //   363: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 4
    //   369: aload_2
    //   370: getfield 102	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   373: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: ldc 90
    //   379: iconst_2
    //   380: aload 4
    //   382: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: goto -181 -> 207
    //   391: aload_2
    //   392: invokevirtual 249	java/io/BufferedReader:close	()V
    //   395: return
    //   396: astore_2
    //   397: goto +9 -> 406
    //   400: goto +18 -> 418
    //   403: astore_2
    //   404: aconst_null
    //   405: astore_1
    //   406: aload_1
    //   407: ifnull +7 -> 414
    //   410: aload_1
    //   411: invokevirtual 249	java/io/BufferedReader:close	()V
    //   414: aload_2
    //   415: athrow
    //   416: aconst_null
    //   417: astore_1
    //   418: aload_1
    //   419: ifnull +8 -> 427
    //   422: aload_1
    //   423: astore_2
    //   424: goto -33 -> 391
    //   427: return
    //   428: astore_1
    //   429: goto -13 -> 416
    //   432: astore_2
    //   433: goto -33 -> 400
    //   436: astore_1
    //   437: return
    //   438: astore_1
    //   439: goto -25 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	BuiltinPluginManager
    //   26	397	1	localBufferedReader1	java.io.BufferedReader
    //   428	1	1	localIOException1	java.io.IOException
    //   436	1	1	localException1	java.lang.Exception
    //   438	1	1	localException2	java.lang.Exception
    //   31	361	2	localObject1	Object
    //   396	1	2	localObject2	Object
    //   403	12	2	localObject3	Object
    //   423	1	2	localBufferedReader2	java.io.BufferedReader
    //   432	1	2	localIOException2	java.io.IOException
    //   51	168	3	localObject4	Object
    //   45	336	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   27	32	396	finally
    //   36	47	396	finally
    //   55	62	396	finally
    //   67	118	396	finally
    //   118	176	396	finally
    //   176	187	396	finally
    //   190	207	396	finally
    //   209	388	396	finally
    //   0	27	403	finally
    //   0	27	428	java/io/IOException
    //   27	32	432	java/io/IOException
    //   36	47	432	java/io/IOException
    //   55	62	432	java/io/IOException
    //   67	118	432	java/io/IOException
    //   118	176	432	java/io/IOException
    //   176	187	432	java/io/IOException
    //   190	207	432	java/io/IOException
    //   209	388	432	java/io/IOException
    //   391	395	436	java/lang/Exception
    //   410	414	438	java/lang/Exception
  }
  
  public boolean b(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.BuiltinPluginManager
 * JD-Core Version:    0.7.0.1
 */