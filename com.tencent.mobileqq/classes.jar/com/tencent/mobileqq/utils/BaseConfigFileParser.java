package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.xmlpull.v1.XmlPullParser;

public abstract class BaseConfigFileParser
{
  public static String a;
  public static String b;
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: new 19	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_3
    //   17: astore_2
    //   18: aload_1
    //   19: invokevirtual 26	java/io/File:exists	()Z
    //   22: ifeq +129 -> 151
    //   25: aload_3
    //   26: astore_2
    //   27: aload_1
    //   28: invokevirtual 29	java/io/File:isFile	()Z
    //   31: ifne +6 -> 37
    //   34: goto +117 -> 151
    //   37: aload_3
    //   38: astore_2
    //   39: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +49 -> 91
    //   45: aload_3
    //   46: astore_2
    //   47: new 36	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   54: astore 5
    //   56: aload_3
    //   57: astore_2
    //   58: aload 5
    //   60: ldc 39
    //   62: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_3
    //   67: astore_2
    //   68: aload 5
    //   70: aload_1
    //   71: invokevirtual 47	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: astore_2
    //   80: ldc 49
    //   82: iconst_2
    //   83: aload 5
    //   85: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_3
    //   92: astore_2
    //   93: new 58	java/io/FileInputStream
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   101: astore_1
    //   102: invokestatic 67	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   105: invokevirtual 71	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   108: astore_2
    //   109: aload_2
    //   110: aload_1
    //   111: ldc 73
    //   113: invokeinterface 79 3 0
    //   118: aload_0
    //   119: aload_2
    //   120: invokevirtual 82	com/tencent/mobileqq/utils/BaseConfigFileParser:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/Object;
    //   123: astore_2
    //   124: aload_1
    //   125: invokevirtual 85	java/io/FileInputStream:close	()V
    //   128: aload_2
    //   129: ifnull +10 -> 139
    //   132: aload_0
    //   133: aload_2
    //   134: invokevirtual 88	com/tencent/mobileqq/utils/BaseConfigFileParser:a	(Ljava/lang/Object;)V
    //   137: iconst_1
    //   138: ireturn
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_3
    //   142: aload_1
    //   143: astore_2
    //   144: goto +100 -> 244
    //   147: astore_3
    //   148: goto +67 -> 215
    //   151: aload_3
    //   152: astore_2
    //   153: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +49 -> 205
    //   159: aload_3
    //   160: astore_2
    //   161: new 36	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   168: astore 5
    //   170: aload_3
    //   171: astore_2
    //   172: aload 5
    //   174: ldc 90
    //   176: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_3
    //   181: astore_2
    //   182: aload 5
    //   184: aload_1
    //   185: invokevirtual 47	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   188: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_3
    //   193: astore_2
    //   194: ldc 49
    //   196: iconst_2
    //   197: aload 5
    //   199: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_3
    //   208: goto +36 -> 244
    //   211: astore_3
    //   212: aload 4
    //   214: astore_1
    //   215: aload_1
    //   216: astore_2
    //   217: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +14 -> 234
    //   223: aload_1
    //   224: astore_2
    //   225: ldc 49
    //   227: iconst_2
    //   228: ldc 95
    //   230: aload_3
    //   231: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload_1
    //   235: ifnull +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 85	java/io/FileInputStream:close	()V
    //   242: iconst_0
    //   243: ireturn
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 85	java/io/FileInputStream:close	()V
    //   252: aload_3
    //   253: athrow
    //   254: astore_1
    //   255: goto -127 -> 128
    //   258: astore_1
    //   259: iconst_0
    //   260: ireturn
    //   261: astore_1
    //   262: goto -10 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	BaseConfigFileParser
    //   0	265	1	paramString	String
    //   6	243	2	localObject1	Object
    //   4	88	3	localObject2	Object
    //   141	1	3	localObject3	Object
    //   147	46	3	localException1	Exception
    //   207	1	3	localObject4	Object
    //   211	42	3	localException2	Exception
    //   1	212	4	localObject5	Object
    //   54	144	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   102	124	141	finally
    //   102	124	147	java/lang/Exception
    //   7	16	207	finally
    //   18	25	207	finally
    //   27	34	207	finally
    //   39	45	207	finally
    //   47	56	207	finally
    //   58	66	207	finally
    //   68	78	207	finally
    //   80	91	207	finally
    //   93	102	207	finally
    //   153	159	207	finally
    //   161	170	207	finally
    //   172	180	207	finally
    //   182	192	207	finally
    //   194	205	207	finally
    //   217	223	207	finally
    //   225	234	207	finally
    //   7	16	211	java/lang/Exception
    //   18	25	211	java/lang/Exception
    //   27	34	211	java/lang/Exception
    //   39	45	211	java/lang/Exception
    //   47	56	211	java/lang/Exception
    //   58	66	211	java/lang/Exception
    //   68	78	211	java/lang/Exception
    //   80	91	211	java/lang/Exception
    //   93	102	211	java/lang/Exception
    //   153	159	211	java/lang/Exception
    //   161	170	211	java/lang/Exception
    //   172	180	211	java/lang/Exception
    //   182	192	211	java/lang/Exception
    //   194	205	211	java/lang/Exception
    //   124	128	254	java/io/IOException
    //   238	242	258	java/io/IOException
    //   248	252	261	java/io/IOException
  }
  
  private void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseConfigFileParser", 2, "parseXmlFromRes");
    }
    int i = a();
    paramContext = paramContext.getResources().getXml(i);
    Object localObject = null;
    try
    {
      paramContext = a(paramContext);
    }
    catch (Exception localException)
    {
      paramContext = localObject;
      if (QLog.isColorLevel())
      {
        QLog.e("BaseConfigFileParser", 2, "parseXmlFromRes doParseRules exception:", localException);
        paramContext = localObject;
      }
    }
    if (paramContext != null) {
      a(paramContext);
    }
  }
  
  protected abstract int a();
  
  protected abstract Object a(XmlPullParser paramXmlPullParser);
  
  public void a(Context paramContext)
  {
    if (FileUtils.fileExistsAndNotEmpty(b))
    {
      boolean bool = a(b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseXmlFromOutside: success = ");
        localStringBuilder.append(bool);
        QLog.d("BaseConfigFileParser", 2, localStringBuilder.toString());
      }
      if (!bool) {
        b(paramContext);
      }
    }
    else
    {
      b(paramContext);
    }
  }
  
  protected abstract void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong);
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString)
  {
    int j = 0;
    int i;
    try
    {
      FileUtils.delete(a, false);
      FileUtils.uncompressZip(paramString, a, false);
      i = 1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("BaseConfigFileParser", 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
        i = j;
      }
    }
    if (i != 0)
    {
      boolean bool = a(b);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("pareseRulesFromZip : delete and uncompressZip success, parse from outside result = ");
        paramString.append(bool);
        QLog.d("BaseConfigFileParser", 2, paramString.toString());
      }
      if (bool)
      {
        a(paramBaseQQAppInterface, paramLong);
        return;
      }
      b(paramBaseQQAppInterface.getApplication());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseConfigFileParser", 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    b(paramBaseQQAppInterface.getApplication());
  }
  
  protected abstract void a(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BaseConfigFileParser
 * JD-Core Version:    0.7.0.1
 */