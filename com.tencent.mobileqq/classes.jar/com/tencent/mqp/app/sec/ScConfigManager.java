package com.tencent.mqp.app.sec;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;

public class ScConfigManager
{
  private static final ScConfigManager a = new ScConfigManager();
  private static final ScConfigManager.ConfigParserMapItem[] d = { new ScConfigManager.ConfigParserMapItem("SecCenterConfig", new SecCenterConfigParser()) };
  private HashMap<String, SecBaseConfig> b = new HashMap();
  private HashMap<String, String> c = new HashMap();
  
  private ScConfigManager()
  {
    this.c.put("SecCenterConfig", "qq_security_sccfg");
  }
  
  public static IConfigParser a(String paramString)
  {
    ScConfigManager.ConfigParserMapItem[] arrayOfConfigParserMapItem = d;
    int j = arrayOfConfigParserMapItem.length;
    int i = 0;
    while (i < j)
    {
      ScConfigManager.ConfigParserMapItem localConfigParserMapItem = arrayOfConfigParserMapItem[i];
      if (localConfigParserMapItem.a.equals(paramString)) {
        return localConfigParserMapItem.b;
      }
      i += 1;
    }
    return null;
  }
  
  public static ScConfigManager a()
  {
    return a;
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: invokestatic 76	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: invokevirtual 80	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore 5
    //   14: new 82	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   21: astore 7
    //   23: aload 7
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 87	com/tencent/mqp/app/sec/ScConfigManager:f	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 7
    //   36: ldc 93
    //   38: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 5
    //   44: aload 7
    //   46: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 103	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   52: astore 5
    //   54: new 105	java/io/FileOutputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   62: astore 4
    //   64: sipush 4096
    //   67: newarray byte
    //   69: astore_1
    //   70: aload 5
    //   72: aload_1
    //   73: invokevirtual 113	java/io/InputStream:read	([B)I
    //   76: istore_3
    //   77: iload_3
    //   78: ifle +14 -> 92
    //   81: aload 4
    //   83: aload_1
    //   84: iconst_0
    //   85: iload_3
    //   86: invokevirtual 119	java/io/OutputStream:write	([BII)V
    //   89: goto -19 -> 70
    //   92: aload 5
    //   94: ifnull +8 -> 102
    //   97: aload 5
    //   99: invokevirtual 122	java/io/InputStream:close	()V
    //   102: aload 4
    //   104: invokevirtual 123	java/io/OutputStream:close	()V
    //   107: return
    //   108: astore_1
    //   109: goto +11 -> 120
    //   112: astore_2
    //   113: goto +20 -> 133
    //   116: astore_1
    //   117: aconst_null
    //   118: astore 4
    //   120: aload 5
    //   122: astore_2
    //   123: aload_1
    //   124: astore 5
    //   126: goto +68 -> 194
    //   129: astore_2
    //   130: aconst_null
    //   131: astore 4
    //   133: aload 5
    //   135: astore_1
    //   136: goto +23 -> 159
    //   139: astore 5
    //   141: aconst_null
    //   142: astore_1
    //   143: aload 4
    //   145: astore_2
    //   146: aload_1
    //   147: astore 4
    //   149: goto +45 -> 194
    //   152: astore_2
    //   153: aconst_null
    //   154: astore 4
    //   156: aload 6
    //   158: astore_1
    //   159: aload_2
    //   160: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   163: aload_1
    //   164: ifnull +10 -> 174
    //   167: aload_1
    //   168: invokevirtual 122	java/io/InputStream:close	()V
    //   171: goto +3 -> 174
    //   174: aload 4
    //   176: ifnull +13 -> 189
    //   179: aload 4
    //   181: invokevirtual 123	java/io/OutputStream:close	()V
    //   184: return
    //   185: aload_1
    //   186: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   189: return
    //   190: astore 5
    //   192: aload_1
    //   193: astore_2
    //   194: aload_2
    //   195: ifnull +10 -> 205
    //   198: aload_2
    //   199: invokevirtual 122	java/io/InputStream:close	()V
    //   202: goto +3 -> 205
    //   205: aload 4
    //   207: ifnull +15 -> 222
    //   210: aload 4
    //   212: invokevirtual 123	java/io/OutputStream:close	()V
    //   215: goto +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   222: goto +6 -> 228
    //   225: aload 5
    //   227: athrow
    //   228: goto -3 -> 225
    //   231: astore_1
    //   232: goto -47 -> 185
    //   235: astore_1
    //   236: goto -18 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	ScConfigManager
    //   0	239	1	paramString1	String
    //   0	239	2	paramString2	String
    //   76	10	3	i	int
    //   1	210	4	localObject1	Object
    //   12	122	5	localObject2	Object
    //   139	1	5	localObject3	Object
    //   190	36	5	localObject4	Object
    //   4	153	6	localObject5	Object
    //   21	24	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	70	108	finally
    //   70	77	108	finally
    //   81	89	108	finally
    //   64	70	112	java/lang/Exception
    //   70	77	112	java/lang/Exception
    //   81	89	112	java/lang/Exception
    //   54	64	116	finally
    //   54	64	129	java/lang/Exception
    //   6	54	139	finally
    //   6	54	152	java/lang/Exception
    //   159	163	190	finally
    //   97	102	231	java/io/IOException
    //   102	107	231	java/io/IOException
    //   167	171	231	java/io/IOException
    //   179	184	231	java/io/IOException
    //   198	202	235	java/io/IOException
    //   210	215	235	java/io/IOException
  }
  
  private void c(String paramString)
  {
    String str = d(paramString);
    if (e(str)) {
      a(paramString, str);
    }
    i(str);
  }
  
  private String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getPath());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".xml");
    return localStringBuilder.toString();
  }
  
  private boolean e(String paramString)
  {
    return FileUtil.d(paramString) ^ true;
  }
  
  private String f(String paramString)
  {
    return (String)this.c.get(paramString);
  }
  
  private SecBaseConfig g(String paramString)
  {
    synchronized (this.b)
    {
      if (this.b.containsKey(paramString))
      {
        paramString = (SecBaseConfig)this.b.get(paramString);
        return paramString;
      }
      return null;
    }
  }
  
  private String h(String paramString)
  {
    paramString = new File(paramString).getName();
    return paramString.substring(0, paramString.lastIndexOf("."));
  }
  
  private boolean i(String arg1)
  {
    String str = h(???);
    Object localObject2 = a(str);
    if (localObject2 != null)
    {
      localObject2 = ((IConfigParser)localObject2).a(???);
      if (localObject2 != null) {
        synchronized (this.b)
        {
          this.b.put(str, localObject2);
        }
      }
      return true;
    }
    return false;
  }
  
  public SecBaseConfig a(String paramString, boolean paramBoolean)
  {
    SecBaseConfig localSecBaseConfig2 = g(paramString);
    SecBaseConfig localSecBaseConfig1 = localSecBaseConfig2;
    if (localSecBaseConfig2 == null)
    {
      localSecBaseConfig1 = localSecBaseConfig2;
      if (paramBoolean)
      {
        c(paramString);
        localSecBaseConfig1 = g(paramString);
      }
    }
    return localSecBaseConfig1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    AntiFraudConfigFileUtil.a().a(paramQQAppInterface, paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (a(paramString, false) == null) {
      ThreadManager.executeOnFileThread(new ScConfigManager.LoadLocalConfig(this, paramQQAppInterface, paramString, paramBoolean));
    }
  }
  
  public boolean b(String paramString)
  {
    return i(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.sec.ScConfigManager
 * JD-Core Version:    0.7.0.1
 */