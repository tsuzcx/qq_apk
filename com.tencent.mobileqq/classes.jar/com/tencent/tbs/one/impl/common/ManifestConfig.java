package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ManifestConfig
{
  private String mEntryClassName;
  private String mEntryDexPath;
  private Pair<String, String>[] mEventPairs;
  private ManifestConfig.FileConfig[] mFileConfigs;
  private String mResourcePackagePath;
  private int mVersionCode;
  
  private ManifestConfig(JSONObject paramJSONObject)
  {
    this.mVersionCode = paramJSONObject.optInt("VERSIONCODE");
    this.mResourcePackagePath = paramJSONObject.optString("RESOURCE");
    Object localObject = paramJSONObject.optString("ENTRY");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(":");
      if (localObject.length != 1) {
        break label142;
      }
      this.mEntryDexPath = localObject[0];
    }
    ArrayList localArrayList;
    for (;;)
    {
      localObject = paramJSONObject.optJSONArray("FILES");
      if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
        break label186;
      }
      int j = ((JSONArray)localObject).length();
      localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        ManifestConfig.FileConfig localFileConfig = parseFileConfig(((JSONArray)localObject).optJSONObject(i));
        if (localFileConfig != null) {
          localArrayList.add(localFileConfig);
        }
        i += 1;
      }
      label142:
      if (localObject.length >= 2)
      {
        this.mEntryDexPath = localObject[0];
        this.mEntryClassName = localObject[1];
      }
    }
    this.mFileConfigs = ((ManifestConfig.FileConfig[])localArrayList.toArray(new ManifestConfig.FileConfig[0]));
    label186:
    parseReceivers(paramJSONObject.optJSONArray("RECEIVERS"));
  }
  
  /* Error */
  public static ManifestConfig parse(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 115	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: new 2	com/tencent/tbs/one/impl/common/ManifestConfig
    //   14: dup
    //   15: new 24	org/json/JSONObject
    //   18: dup
    //   19: aload_2
    //   20: ldc 120
    //   22: invokestatic 126	com/tencent/tbs/one/impl/base/FileUtils:readStreamToString	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    //   25: invokespecial 129	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: invokespecial 131	com/tencent/tbs/one/impl/common/ManifestConfig:<init>	(Lorg/json/JSONObject;)V
    //   31: astore_3
    //   32: aload_2
    //   33: invokestatic 135	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   36: aload_3
    //   37: areturn
    //   38: astore_3
    //   39: aconst_null
    //   40: astore_1
    //   41: new 137	com/tencent/tbs/one/TBSOneException
    //   44: dup
    //   45: sipush 401
    //   48: new 139	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   55: ldc 142
    //   57: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: aload_3
    //   71: invokespecial 158	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   74: athrow
    //   75: astore_0
    //   76: aload_1
    //   77: invokestatic 135	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: athrow
    //   82: astore_3
    //   83: aconst_null
    //   84: astore_1
    //   85: new 137	com/tencent/tbs/one/TBSOneException
    //   88: dup
    //   89: sipush 402
    //   92: new 139	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   99: ldc 160
    //   101: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   108: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: aload_3
    //   115: invokespecial 158	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   118: athrow
    //   119: new 137	com/tencent/tbs/one/TBSOneException
    //   122: dup
    //   123: sipush 403
    //   126: new 139	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   133: ldc 162
    //   135: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   142: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 164
    //   147: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_3
    //   151: invokevirtual 167	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload_3
    //   161: invokespecial 158	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: athrow
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_1
    //   168: goto -92 -> 76
    //   171: astore_3
    //   172: aload_2
    //   173: astore_1
    //   174: goto -55 -> 119
    //   177: astore_3
    //   178: aload_2
    //   179: astore_1
    //   180: goto -95 -> 85
    //   183: astore_3
    //   184: aload_2
    //   185: astore_1
    //   186: goto -145 -> 41
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -73 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramFile	java.io.File
    //   10	182	1	localFileInputStream1	java.io.FileInputStream
    //   8	177	2	localFileInputStream2	java.io.FileInputStream
    //   31	6	3	localManifestConfig	ManifestConfig
    //   38	33	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   82	79	3	localIOException1	java.io.IOException
    //   171	1	3	localJSONException1	org.json.JSONException
    //   177	1	3	localIOException2	java.io.IOException
    //   183	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   189	1	3	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   0	9	38	java/io/FileNotFoundException
    //   11	32	75	finally
    //   41	75	75	finally
    //   85	119	75	finally
    //   119	165	75	finally
    //   0	9	82	java/io/IOException
    //   0	9	165	finally
    //   11	32	171	org/json/JSONException
    //   11	32	177	java/io/IOException
    //   11	32	183	java/io/FileNotFoundException
    //   0	9	189	org/json/JSONException
  }
  
  private ManifestConfig.FileConfig parseFileConfig(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject == null) {}
    ManifestConfig.FileConfig localFileConfig;
    do
    {
      String str;
      do
      {
        return localObject;
        str = paramJSONObject.optString("PATH");
      } while (TextUtils.isEmpty(str));
      localFileConfig = new ManifestConfig.FileConfig();
      ManifestConfig.FileConfig.access$002(localFileConfig, str);
      ManifestConfig.FileConfig.access$102(localFileConfig, paramJSONObject.optString("MD5"));
      ManifestConfig.FileConfig.access$202(localFileConfig, paramJSONObject.optString("SEALED"));
      ManifestConfig.FileConfig.access$302(localFileConfig, paramJSONObject.optString("URL"));
      paramJSONObject = paramJSONObject.optString("PARENT");
      localObject = localFileConfig;
    } while (TextUtils.isEmpty(paramJSONObject));
    localObject = new ManifestConfig.ParentConfig();
    paramJSONObject = paramJSONObject.split(":");
    if (paramJSONObject.length == 1) {
      ManifestConfig.ParentConfig.access$402((ManifestConfig.ParentConfig)localObject, paramJSONObject[0]);
    }
    for (;;)
    {
      ManifestConfig.FileConfig.access$602(localFileConfig, (ManifestConfig.ParentConfig)localObject);
      return localFileConfig;
      ManifestConfig.ParentConfig.access$502((ManifestConfig.ParentConfig)localObject, paramJSONObject[0]);
      ManifestConfig.ParentConfig.access$402((ManifestConfig.ParentConfig)localObject, paramJSONObject[1]);
    }
  }
  
  private void parseReceivers(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0)) {
      return;
    }
    int k = paramJSONArray.length();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      String str = ((JSONObject)localObject).optString("CLASS");
      localObject = ((JSONObject)localObject).optJSONArray("EVENTS");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int m = ((JSONArray)localObject).length();
        int j = 0;
        while (j < m)
        {
          localArrayList.add(new Pair(((JSONArray)localObject).optString(j), str));
          j += 1;
        }
      }
      i += 1;
    }
    this.mEventPairs = ((Pair[])localArrayList.toArray(new Pair[0]));
  }
  
  public String getEntryClassName()
  {
    return this.mEntryClassName;
  }
  
  public String getEntryDexPath()
  {
    return this.mEntryDexPath;
  }
  
  public Pair<String, String>[] getEventPairs()
  {
    return this.mEventPairs;
  }
  
  public ManifestConfig.FileConfig getFileConfig(String paramString)
  {
    ManifestConfig.FileConfig[] arrayOfFileConfig = this.mFileConfigs;
    int j = arrayOfFileConfig.length;
    int i = 0;
    while (i < j)
    {
      ManifestConfig.FileConfig localFileConfig = arrayOfFileConfig[i];
      if (localFileConfig.getPath().equals(paramString)) {
        return localFileConfig;
      }
      i += 1;
    }
    return null;
  }
  
  public ManifestConfig.FileConfig[] getFileConfigs()
  {
    return this.mFileConfigs;
  }
  
  public String getResourcePackagePath()
  {
    return this.mResourcePackagePath;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.ManifestConfig
 * JD-Core Version:    0.7.0.1
 */