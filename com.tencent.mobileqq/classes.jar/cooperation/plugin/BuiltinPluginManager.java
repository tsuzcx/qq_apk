package cooperation.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class BuiltinPluginManager
{
  private static volatile BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "qzone_plugin.apk", "qwallet_plugin.apk", "qqfav.apk", "qqwadl.apk" };
  private Context jdField_a_of_type_AndroidContentContext;
  private HashMap<String, PluginInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private BuiltinPluginManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public static final BuiltinPluginManager a(Context paramContext)
  {
    if (jdField_a_of_type_CooperationPluginBuiltinPluginManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationPluginBuiltinPluginManager == null) {
        jdField_a_of_type_CooperationPluginBuiltinPluginManager = new BuiltinPluginManager(paramContext);
      }
      return jdField_a_of_type_CooperationPluginBuiltinPluginManager;
    }
    finally {}
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (paramString.equals(jdField_a_of_type_ArrayOfJavaLangString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public PluginInfo a(String paramString)
  {
    return (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    b();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "init. built in plugin size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public boolean a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localPluginInfo != null)
      {
        if (paramPluginBaseInfo != null)
        {
          boolean bool = TextUtils.equals(localPluginInfo.mMD5, paramPluginBaseInfo.mMD5);
          QLog.i("plugin_tag", 1, "isUpToDayBuiltIn " + paramString + " isUpToDay " + bool);
          if (!bool) {
            CaughtExceptionReport.a(new RuntimeException(), "plugin_tagCreateClassLoaderNotUpToDay");
          }
          return bool;
        }
        QLog.i("plugin_tag", 1, "isUpToDayBuiltIn info");
      }
    }
    return false;
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 138	java/io/BufferedReader
    //   5: dup
    //   6: new 140	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: getfield 36	cooperation/plugin/BuiltinPluginManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   14: invokevirtual 146	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: ldc 148
    //   19: invokevirtual 154	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: invokespecial 157	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 160	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 163	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +139 -> 174
    //   38: aload_2
    //   39: invokevirtual 166	java/lang/String:trim	()Ljava/lang/String;
    //   42: ldc 168
    //   44: invokevirtual 172	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   47: astore 4
    //   49: aload 4
    //   51: iconst_0
    //   52: aaload
    //   53: astore_3
    //   54: ldc 174
    //   56: astore_2
    //   57: aload 4
    //   59: arraylength
    //   60: iconst_1
    //   61: if_icmple +8 -> 69
    //   64: aload 4
    //   66: iconst_1
    //   67: aaload
    //   68: astore_2
    //   69: new 62	cooperation/plugin/PluginInfo
    //   72: dup
    //   73: invokespecial 175	cooperation/plugin/PluginInfo:<init>	()V
    //   76: astore 4
    //   78: aload 4
    //   80: aload_3
    //   81: putfield 178	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   84: aload 4
    //   86: aload_2
    //   87: putfield 104	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   90: aload 4
    //   92: iconst_1
    //   93: putfield 182	cooperation/plugin/PluginInfo:mUpdateType	I
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 185	cooperation/plugin/PluginInfo:mInstallType	I
    //   102: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +45 -> 150
    //   108: ldc 72
    //   110: iconst_2
    //   111: new 74	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   118: ldc 187
    //   120: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 4
    //   125: getfield 178	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   128: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 189
    //   133: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload 4
    //   138: getfield 104	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   141: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 34	cooperation/plugin/BuiltinPluginManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   154: aload_3
    //   155: aload 4
    //   157: invokevirtual 193	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: goto -132 -> 29
    //   164: astore_2
    //   165: aload_1
    //   166: ifnull +7 -> 173
    //   169: aload_1
    //   170: invokevirtual 196	java/io/BufferedReader:close	()V
    //   173: return
    //   174: invokestatic 202	com/tencent/mobileqq/qshadow/core/QShadow:getInstance	()Lcom/tencent/mobileqq/qshadow/core/QShadow;
    //   177: invokevirtual 206	com/tencent/mobileqq/qshadow/core/QShadow:getQShadowBuildInPlugins	()Ljava/util/Map;
    //   180: invokeinterface 212 1 0
    //   185: invokeinterface 218 1 0
    //   190: astore_2
    //   191: aload_2
    //   192: invokeinterface 223 1 0
    //   197: ifeq +178 -> 375
    //   200: aload_2
    //   201: invokeinterface 227 1 0
    //   206: checkcast 229	java/util/Map$Entry
    //   209: astore_3
    //   210: new 62	cooperation/plugin/PluginInfo
    //   213: dup
    //   214: invokespecial 175	cooperation/plugin/PluginInfo:<init>	()V
    //   217: astore 4
    //   219: aload 4
    //   221: iconst_1
    //   222: putfield 232	cooperation/plugin/PluginInfo:mSubType	I
    //   225: aload 4
    //   227: aload_3
    //   228: invokeinterface 235 1 0
    //   233: checkcast 106	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
    //   236: getfield 236	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:mID	Ljava/lang/String;
    //   239: putfield 178	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   242: aload 4
    //   244: aload_3
    //   245: invokeinterface 235 1 0
    //   250: checkcast 106	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
    //   253: getfield 107	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:mMD5	Ljava/lang/String;
    //   256: putfield 104	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   259: aload 4
    //   261: aload_3
    //   262: invokeinterface 235 1 0
    //   267: checkcast 106	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
    //   270: getfield 237	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:mUpdateType	I
    //   273: putfield 182	cooperation/plugin/PluginInfo:mUpdateType	I
    //   276: aload 4
    //   278: aload_3
    //   279: invokeinterface 235 1 0
    //   284: checkcast 106	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
    //   287: getfield 238	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:mInstallType	I
    //   290: putfield 185	cooperation/plugin/PluginInfo:mInstallType	I
    //   293: aload_0
    //   294: getfield 34	cooperation/plugin/BuiltinPluginManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   297: aload_3
    //   298: invokeinterface 241 1 0
    //   303: aload 4
    //   305: invokevirtual 193	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   308: pop
    //   309: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq -121 -> 191
    //   315: ldc 72
    //   317: iconst_2
    //   318: new 74	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   325: ldc 243
    //   327: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 4
    //   332: getfield 178	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   335: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc 189
    //   340: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 4
    //   345: getfield 104	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   348: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: goto -166 -> 191
    //   360: astore_3
    //   361: aload_1
    //   362: astore_2
    //   363: aload_3
    //   364: astore_1
    //   365: aload_2
    //   366: ifnull +7 -> 373
    //   369: aload_2
    //   370: invokevirtual 196	java/io/BufferedReader:close	()V
    //   373: aload_1
    //   374: athrow
    //   375: aload_1
    //   376: ifnull -203 -> 173
    //   379: aload_1
    //   380: invokevirtual 196	java/io/BufferedReader:close	()V
    //   383: return
    //   384: astore_1
    //   385: return
    //   386: astore_1
    //   387: return
    //   388: astore_2
    //   389: goto -16 -> 373
    //   392: astore_1
    //   393: aconst_null
    //   394: astore_2
    //   395: goto -30 -> 365
    //   398: astore_1
    //   399: aload_2
    //   400: astore_1
    //   401: goto -236 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	BuiltinPluginManager
    //   28	352	1	localObject1	Object
    //   384	1	1	localException1	java.lang.Exception
    //   386	1	1	localException2	java.lang.Exception
    //   392	1	1	localObject2	Object
    //   398	1	1	localIOException1	java.io.IOException
    //   400	1	1	localObject3	Object
    //   1	86	2	str	String
    //   164	1	2	localIOException2	java.io.IOException
    //   190	180	2	localObject4	Object
    //   388	1	2	localException3	java.lang.Exception
    //   394	6	2	localObject5	Object
    //   53	245	3	localObject6	Object
    //   360	4	3	localObject7	Object
    //   47	297	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	164	java/io/IOException
    //   38	49	164	java/io/IOException
    //   57	64	164	java/io/IOException
    //   69	150	164	java/io/IOException
    //   150	161	164	java/io/IOException
    //   174	191	164	java/io/IOException
    //   191	357	164	java/io/IOException
    //   29	34	360	finally
    //   38	49	360	finally
    //   57	64	360	finally
    //   69	150	360	finally
    //   150	161	360	finally
    //   174	191	360	finally
    //   191	357	360	finally
    //   379	383	384	java/lang/Exception
    //   169	173	386	java/lang/Exception
    //   369	373	388	java/lang/Exception
    //   2	29	392	finally
    //   2	29	398	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.plugin.BuiltinPluginManager
 * JD-Core Version:    0.7.0.1
 */