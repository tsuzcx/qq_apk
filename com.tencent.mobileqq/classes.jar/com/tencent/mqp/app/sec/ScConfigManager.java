package com.tencent.mqp.app.sec;

import apdh;
import baah;
import bbsl;
import bbsr;
import bbss;
import bbsu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;

public class ScConfigManager
{
  private static final ScConfigManager jdField_a_of_type_ComTencentMqpAppSecScConfigManager = new ScConfigManager();
  private static final bbsr[] jdField_a_of_type_ArrayOfBbsr = { new bbsr("SecCenterConfig", new bbsu()) };
  private HashMap<String, bbss> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, String> b = new HashMap();
  
  private ScConfigManager()
  {
    this.b.put("SecCenterConfig", "qq_security_sccfg");
  }
  
  public static bbsl a(String paramString)
  {
    bbsr[] arrayOfbbsr = jdField_a_of_type_ArrayOfBbsr;
    int j = arrayOfbbsr.length;
    int i = 0;
    while (i < j)
    {
      bbsr localbbsr = arrayOfbbsr[i];
      if (localbbsr.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localbbsr.jdField_a_of_type_Bbsl;
      }
      i += 1;
    }
    return null;
  }
  
  private bbss a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        paramString = (bbss)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        return paramString;
      }
      return null;
    }
  }
  
  public static ScConfigManager a()
  {
    return jdField_a_of_type_ComTencentMqpAppSecScConfigManager;
  }
  
  private String a(String paramString)
  {
    return BaseApplication.getContext().getFilesDir().getPath() + "/" + paramString + ".xml";
  }
  
  private void a(String paramString)
  {
    String str = a(paramString);
    if (b(str)) {
      a(paramString, str);
    }
    c(str);
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: invokevirtual 123	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   12: new 72	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 125	com/tencent/mqp/app/sec/ScConfigManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 97
    //   29: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokevirtual 131	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_1
    //   39: new 133	java/io/FileOutputStream
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 135	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   47: astore 4
    //   49: sipush 4096
    //   52: newarray byte
    //   54: astore_2
    //   55: aload_1
    //   56: aload_2
    //   57: invokevirtual 141	java/io/InputStream:read	([B)I
    //   60: istore_3
    //   61: iload_3
    //   62: ifle +47 -> 109
    //   65: aload 4
    //   67: aload_2
    //   68: iconst_0
    //   69: iload_3
    //   70: invokevirtual 147	java/io/OutputStream:write	([BII)V
    //   73: goto -18 -> 55
    //   76: astore 5
    //   78: aload_1
    //   79: astore_2
    //   80: aload 4
    //   82: astore_1
    //   83: aload 5
    //   85: astore 4
    //   87: aload 4
    //   89: invokevirtual 150	java/lang/Exception:printStackTrace	()V
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 153	java/io/InputStream:close	()V
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 154	java/io/OutputStream:close	()V
    //   108: return
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 153	java/io/InputStream:close	()V
    //   117: aload 4
    //   119: ifnull -11 -> 108
    //   122: aload 4
    //   124: invokevirtual 154	java/io/OutputStream:close	()V
    //   127: return
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   133: return
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   139: return
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: aload 5
    //   145: astore 4
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 153	java/io/InputStream:close	()V
    //   155: aload 4
    //   157: ifnull +8 -> 165
    //   160: aload 4
    //   162: invokevirtual 154	java/io/OutputStream:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   172: goto -7 -> 165
    //   175: astore_2
    //   176: aload 5
    //   178: astore 4
    //   180: goto -33 -> 147
    //   183: astore_2
    //   184: goto -37 -> 147
    //   187: astore 4
    //   189: aload_2
    //   190: astore 5
    //   192: aload 4
    //   194: astore_2
    //   195: aload_1
    //   196: astore 4
    //   198: aload 5
    //   200: astore_1
    //   201: goto -54 -> 147
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_1
    //   208: aload 6
    //   210: astore_2
    //   211: goto -124 -> 87
    //   214: astore 4
    //   216: aconst_null
    //   217: astore 5
    //   219: aload_1
    //   220: astore_2
    //   221: aload 5
    //   223: astore_1
    //   224: goto -137 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	ScConfigManager
    //   0	227	1	paramString1	String
    //   0	227	2	paramString2	String
    //   60	10	3	i	int
    //   47	132	4	localObject1	Object
    //   187	6	4	localObject2	Object
    //   196	1	4	str1	String
    //   204	1	4	localException1	java.lang.Exception
    //   214	1	4	localException2	java.lang.Exception
    //   1	1	5	localObject3	Object
    //   76	101	5	localException3	java.lang.Exception
    //   190	32	5	str2	String
    //   4	205	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   49	55	76	java/lang/Exception
    //   55	61	76	java/lang/Exception
    //   65	73	76	java/lang/Exception
    //   113	117	128	java/io/IOException
    //   122	127	128	java/io/IOException
    //   96	100	134	java/io/IOException
    //   104	108	134	java/io/IOException
    //   6	39	140	finally
    //   151	155	167	java/io/IOException
    //   160	165	167	java/io/IOException
    //   39	49	175	finally
    //   49	55	183	finally
    //   55	61	183	finally
    //   65	73	183	finally
    //   87	92	187	finally
    //   6	39	204	java/lang/Exception
    //   39	49	214	java/lang/Exception
  }
  
  private String b(String paramString)
  {
    return (String)this.b.get(paramString);
  }
  
  private boolean b(String paramString)
  {
    return !apdh.a(paramString);
  }
  
  private String c(String paramString)
  {
    paramString = new File(paramString).getName();
    return paramString.substring(0, paramString.lastIndexOf("."));
  }
  
  private boolean c(String arg1)
  {
    String str = c(???);
    Object localObject2 = a(str);
    if (localObject2 != null)
    {
      localObject2 = ((bbsl)localObject2).a(???);
      if (localObject2 != null) {
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localObject2);
        }
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public bbss a(String paramString, boolean paramBoolean)
  {
    bbss localbbss2 = a(paramString);
    bbss localbbss1 = localbbss2;
    if (localbbss2 == null)
    {
      localbbss1 = localbbss2;
      if (paramBoolean)
      {
        a(paramString);
        localbbss1 = a(paramString);
      }
    }
    return localbbss1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    baah.a().a(paramQQAppInterface, paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (a(paramString, false) == null) {
      ThreadManager.executeOnFileThread(new ScConfigManager.LoadLocalConfig(this, paramQQAppInterface, paramString, paramBoolean));
    }
  }
  
  public boolean a(String paramString)
  {
    return c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mqp.app.sec.ScConfigManager
 * JD-Core Version:    0.7.0.1
 */