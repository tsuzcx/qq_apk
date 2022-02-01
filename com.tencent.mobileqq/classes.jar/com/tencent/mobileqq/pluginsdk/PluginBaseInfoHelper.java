package com.tencent.mobileqq.pluginsdk;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public final class PluginBaseInfoHelper
{
  /* Error */
  public static PluginBaseInfo createFromFile(java.io.File paramFile, java.lang.Class<? extends PluginBaseInfo> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 21	java/io/File:length	()J
    //   4: l2i
    //   5: newarray byte
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: new 23	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 26	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_0
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 30	java/io/FileInputStream:read	([B)I
    //   24: pop
    //   25: new 32	java/lang/String
    //   28: dup
    //   29: aload_3
    //   30: iconst_0
    //   31: invokestatic 38	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$Base64Helper:decode	([BI)[B
    //   34: invokespecial 41	java/lang/String:<init>	([B)V
    //   37: astore_3
    //   38: new 43	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser
    //   41: dup
    //   42: invokespecial 44	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: aload_1
    //   50: invokevirtual 48	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser:setResultClass	(Ljava/lang/Class;)V
    //   53: aload_3
    //   54: aload 4
    //   56: invokestatic 52	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper:parseConfig	(Ljava/lang/String;Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser;)Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfo;
    //   59: astore_1
    //   60: aload_0
    //   61: invokevirtual 55	java/io/FileInputStream:close	()V
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aload_0
    //   68: astore_1
    //   69: aload_2
    //   70: astore_0
    //   71: goto +9 -> 80
    //   74: goto +18 -> 92
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +7 -> 88
    //   84: aload_1
    //   85: invokevirtual 55	java/io/FileInputStream:close	()V
    //   88: aload_0
    //   89: athrow
    //   90: aconst_null
    //   91: astore_0
    //   92: aload_0
    //   93: ifnull +8 -> 101
    //   96: aload_2
    //   97: astore_1
    //   98: goto -38 -> 60
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: goto -14 -> 90
    //   107: astore_1
    //   108: goto -34 -> 74
    //   111: astore_0
    //   112: aload_1
    //   113: areturn
    //   114: astore_1
    //   115: goto -27 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramFile	java.io.File
    //   0	118	1	paramClass	java.lang.Class<? extends PluginBaseInfo>
    //   9	1	2	localObject1	Object
    //   66	31	2	localObject2	Object
    //   7	47	3	localObject3	Object
    //   45	10	4	localPluginInfoParser	PluginBaseInfoHelper.PluginInfoParser
    // Exception table:
    //   from	to	target	type
    //   19	60	66	finally
    //   10	19	77	finally
    //   10	19	103	java/lang/Exception
    //   19	60	107	java/lang/Exception
    //   60	64	111	java/io/IOException
    //   84	88	114	java/io/IOException
  }
  
  public static PluginBaseInfo parseConfig(String paramString, PluginBaseInfoHelper.PluginInfoParser paramPluginInfoParser)
  {
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(paramString.getBytes()), paramPluginInfoParser);
      paramString = paramPluginInfoParser.getResult();
      return paramString;
    }
    catch (Exception paramString)
    {
      label28:
      break label28;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper
 * JD-Core Version:    0.7.0.1
 */