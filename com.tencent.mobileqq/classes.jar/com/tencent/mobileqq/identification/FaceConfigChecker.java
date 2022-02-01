package com.tencent.mobileqq.identification;

import android.text.TextUtils;
import com.tencent.mobileqq.util.FaceSharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FaceConfigChecker
{
  /* Error */
  private static HashMap<String, Integer> a(File paramFile)
  {
    // Byte code:
    //   0: new 17	java/util/HashMap
    //   3: dup
    //   4: invokespecial 18	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 20	java/io/BufferedReader
    //   11: dup
    //   12: new 22	java/io/FileReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 25	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   20: invokespecial 28	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 32	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +53 -> 85
    //   35: aload_1
    //   36: astore_0
    //   37: aload_2
    //   38: ldc 34
    //   40: invokevirtual 40	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +30 -> 75
    //   48: aload_1
    //   49: astore_0
    //   50: aload_2
    //   51: arraylength
    //   52: iconst_2
    //   53: if_icmpne +22 -> 75
    //   56: aload_1
    //   57: astore_0
    //   58: aload_3
    //   59: aload_2
    //   60: iconst_0
    //   61: aaload
    //   62: aload_2
    //   63: iconst_1
    //   64: aaload
    //   65: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 54	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_1
    //   76: astore_0
    //   77: aload_1
    //   78: invokevirtual 32	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore_2
    //   82: goto -51 -> 31
    //   85: aload_1
    //   86: invokevirtual 57	java/io/BufferedReader:close	()V
    //   89: aload_3
    //   90: areturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   96: aload_3
    //   97: areturn
    //   98: astore_2
    //   99: goto +12 -> 111
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_1
    //   105: goto +70 -> 175
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: astore_0
    //   113: aload_2
    //   114: invokevirtual 61	java/lang/Exception:printStackTrace	()V
    //   117: aload_1
    //   118: astore_0
    //   119: new 63	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   126: astore 4
    //   128: aload_1
    //   129: astore_0
    //   130: aload 4
    //   132: ldc 66
    //   134: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: astore_0
    //   140: aload 4
    //   142: aload_2
    //   143: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_1
    //   148: astore_0
    //   149: ldc 75
    //   151: iconst_1
    //   152: aload 4
    //   154: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 57	java/io/BufferedReader:close	()V
    //   168: aload_3
    //   169: areturn
    //   170: astore_2
    //   171: aload_0
    //   172: astore_1
    //   173: aload_2
    //   174: astore_0
    //   175: aload_1
    //   176: ifnull +15 -> 191
    //   179: aload_1
    //   180: invokevirtual 57	java/io/BufferedReader:close	()V
    //   183: goto +8 -> 191
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   191: goto +5 -> 196
    //   194: aload_0
    //   195: athrow
    //   196: goto -2 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramFile	File
    //   23	157	1	localObject1	Object
    //   186	2	1	localIOException	java.io.IOException
    //   30	52	2	localObject2	Object
    //   98	1	2	localException1	java.lang.Exception
    //   108	35	2	localException2	java.lang.Exception
    //   170	4	2	localObject3	Object
    //   7	162	3	localHashMap	HashMap
    //   126	27	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   85	89	91	java/io/IOException
    //   164	168	91	java/io/IOException
    //   26	31	98	java/lang/Exception
    //   37	44	98	java/lang/Exception
    //   50	56	98	java/lang/Exception
    //   58	75	98	java/lang/Exception
    //   77	82	98	java/lang/Exception
    //   8	24	102	finally
    //   8	24	108	java/lang/Exception
    //   26	31	170	finally
    //   37	44	170	finally
    //   50	56	170	finally
    //   58	75	170	finally
    //   77	82	170	finally
    //   113	117	170	finally
    //   119	128	170	finally
    //   130	138	170	finally
    //   140	147	170	finally
    //   149	160	170	finally
    //   179	183	186	java/io/IOException
  }
  
  private static void a(Map<String, File> paramMap, File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          a(paramMap, paramFile[i]);
          i += 1;
        }
      }
    }
    else
    {
      paramMap.put(paramFile.getName(), paramFile);
    }
  }
  
  public static boolean a()
  {
    int i = FaceSharedPreUtils.a();
    boolean bool = false;
    QLog.d("FaceConfigChecker", 1, new Object[] { "local res version : ", Integer.valueOf(i) });
    if (i >= 7) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(ConfigItem paramConfigItem)
  {
    if (paramConfigItem == null)
    {
      QLog.d("FaceConfigChecker", 1, "checkConfigValid, item is null");
      return false;
    }
    return d(paramConfigItem);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("FaceConfigChecker", 1, "no local res exist");
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("identification/");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    paramString = new File((File)localObject1, "identification_res_desct.txt");
    if (!paramString.exists())
    {
      QLog.d("FaceConfigChecker", 1, "checkResValid identification_res_desct.txt not exist");
      return false;
    }
    Object localObject2 = a(paramString);
    if (((HashMap)localObject2).isEmpty())
    {
      QLog.d("FaceConfigChecker", 1, "checkResValid fileConfigData.isEmpty");
      return false;
    }
    paramString = new HashMap();
    a(paramString, (File)localObject1);
    localObject2 = ((HashMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (String)((Map.Entry)localObject3).getKey();
      int i = ((Integer)((Map.Entry)localObject3).getValue()).intValue();
      localObject3 = (File)paramString.get(localObject1);
      if ((localObject3 != null) && (((File)localObject3).exists()))
      {
        if (i != ((File)localObject3).length())
        {
          paramString = new StringBuilder();
          paramString.append("check file valid failed,file size is wrong,name = ");
          paramString.append((String)localObject1);
          QLog.d("FaceConfigChecker", 1, paramString.toString());
          return false;
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("check file valid failed,file not exist,name = ");
        paramString.append((String)localObject1);
        QLog.d("FaceConfigChecker", 1, paramString.toString());
        return false;
      }
    }
    return true;
  }
  
  public static boolean b()
  {
    int i = FaceSharedPreUtils.b();
    int j = FaceConfigManager.a();
    boolean bool = false;
    QLog.d("FaceConfigChecker", 1, new Object[] { "current download bits is : ", Integer.valueOf(i), " app setting so bits is : ", Integer.valueOf(j) });
    if (i == j) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(ConfigItem paramConfigItem)
  {
    boolean bool = false;
    if (paramConfigItem == null)
    {
      QLog.e("FaceConfigChecker", 1, "checkConfigVersionLimit item is null");
      return false;
    }
    QLog.d("FaceConfigChecker", 1, new Object[] { "config version : ", Integer.valueOf(paramConfigItem.a) });
    if (paramConfigItem.a >= 7) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean c(ConfigItem paramConfigItem)
  {
    if (paramConfigItem == null)
    {
      QLog.e("FaceConfigChecker", 1, "checkConfigVersionUpdate item is null");
      return true;
    }
    int i = FaceSharedPreUtils.a();
    QLog.d("FaceConfigChecker", 1, new Object[] { "local res version is ", Integer.valueOf(i), " config version is ", Integer.valueOf(paramConfigItem.a) });
    return i < paramConfigItem.a;
  }
  
  public static boolean d(ConfigItem paramConfigItem)
  {
    if (paramConfigItem == null)
    {
      QLog.e("FaceConfigChecker", 1, "checkConfigVersionValid item is null");
      return false;
    }
    return b(paramConfigItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceConfigChecker
 * JD-Core Version:    0.7.0.1
 */