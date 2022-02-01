package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DEPSConfig
{
  private Map<String, DEPSConfig.ComponentConfig> mComponentConfigs;
  private int mVersionCode;
  private String mVersionName;
  
  private DEPSConfig(JSONObject paramJSONObject)
  {
    this.mVersionName = paramJSONObject.optString("VERSIONNAME");
    this.mVersionCode = paramJSONObject.optInt("VERSIONCODE");
    paramJSONObject = paramJSONObject.optJSONArray("COMPONENTS");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int j = paramJSONObject.length();
      this.mComponentConfigs = new HashMap(j);
      int i = 0;
      while (i < j)
      {
        DEPSConfig.ComponentConfig localComponentConfig = parseComponentConfig(paramJSONObject.optJSONObject(i));
        if (localComponentConfig != null) {
          this.mComponentConfigs.put(localComponentConfig.getName(), localComponentConfig);
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static DEPSConfig parse(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 80	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokestatic 86	com/tencent/tbs/one/impl/common/DEPSConfig:parse	(Ljava/io/InputStream;)Lcom/tencent/tbs/one/impl/common/DEPSConfig;
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 92	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_2
    //   23: aconst_null
    //   24: astore_0
    //   25: new 94	com/tencent/tbs/one/TBSOneException
    //   28: dup
    //   29: sipush 306
    //   32: ldc 96
    //   34: aload_2
    //   35: invokespecial 99	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   38: athrow
    //   39: astore_2
    //   40: aload_0
    //   41: astore_1
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 92	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   48: aload_0
    //   49: athrow
    //   50: astore_0
    //   51: aconst_null
    //   52: astore_1
    //   53: goto -9 -> 44
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: goto -34 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramFile	java.io.File
    //   8	50	1	localObject1	Object
    //   15	6	2	localDEPSConfig	DEPSConfig
    //   22	13	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   39	4	2	localObject2	Object
    //   56	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	9	22	java/io/FileNotFoundException
    //   11	16	39	finally
    //   25	39	39	finally
    //   0	9	50	finally
    //   11	16	56	java/io/FileNotFoundException
  }
  
  public static DEPSConfig parse(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = FileUtils.readStreamToString(paramInputStream, "utf-8");
      return parse(paramInputStream);
    }
    catch (IOException paramInputStream)
    {
      throw new TBSOneException(307, "Failed to read DEPS contents", paramInputStream);
    }
  }
  
  public static DEPSConfig parse(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return new DEPSConfig(localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      throw new TBSOneException(308, "Failed to parse DEPS " + paramString + ", " + localJSONException.getMessage(), localJSONException);
    }
  }
  
  private DEPSConfig.ComponentConfig parseComponentConfig(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject == null) {}
    DEPSConfig.ComponentConfig localComponentConfig;
    do
    {
      do
      {
        String str;
        do
        {
          return localObject;
          str = paramJSONObject.optString("NAME");
        } while (TextUtils.isEmpty(str));
        localComponentConfig = new DEPSConfig.ComponentConfig();
        DEPSConfig.ComponentConfig.access$002(localComponentConfig, str);
        DEPSConfig.ComponentConfig.access$102(localComponentConfig, paramJSONObject.optString("VERSIONNAME"));
        DEPSConfig.ComponentConfig.access$202(localComponentConfig, paramJSONObject.optInt("VERSIONCODE"));
        DEPSConfig.ComponentConfig.access$302(localComponentConfig, paramJSONObject.optString("URL"));
        DEPSConfig.ComponentConfig.access$402(localComponentConfig, paramJSONObject.optString("MD5"));
        paramJSONObject = paramJSONObject.optJSONArray("DEPENDENCIES");
        localObject = localComponentConfig;
      } while (paramJSONObject == null);
      localObject = localComponentConfig;
    } while (paramJSONObject.length() <= 0);
    int j = paramJSONObject.length();
    DEPSConfig.ComponentConfig.access$502(localComponentConfig, new String[j]);
    int i = 0;
    for (;;)
    {
      localObject = localComponentConfig;
      if (i >= j) {
        break;
      }
      DEPSConfig.ComponentConfig.access$500(localComponentConfig)[i] = paramJSONObject.optString(i);
      i += 1;
    }
  }
  
  public DEPSConfig.ComponentConfig getComponentConfig(String paramString)
  {
    if (this.mComponentConfigs == null) {
      return null;
    }
    return (DEPSConfig.ComponentConfig)this.mComponentConfigs.get(paramString);
  }
  
  public Map<String, DEPSConfig.ComponentConfig> getComponentConfigs()
  {
    return this.mComponentConfigs;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String getVersionName()
  {
    return this.mVersionName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.DEPSConfig
 * JD-Core Version:    0.7.0.1
 */