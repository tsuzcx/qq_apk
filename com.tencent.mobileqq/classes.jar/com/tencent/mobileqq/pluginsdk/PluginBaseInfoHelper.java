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
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 21	java/io/File:length	()J
    //   6: l2i
    //   7: newarray byte
    //   9: astore_3
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
    //   60: aload_1
    //   61: astore_2
    //   62: aload_0
    //   63: ifnull +9 -> 72
    //   66: aload_0
    //   67: invokevirtual 55	java/io/FileInputStream:close	()V
    //   70: aload_1
    //   71: astore_2
    //   72: aload_2
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: ifnull -6 -> 72
    //   81: aload_0
    //   82: invokevirtual 55	java/io/FileInputStream:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: areturn
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 55	java/io/FileInputStream:close	()V
    //   101: aload_1
    //   102: athrow
    //   103: astore_0
    //   104: aload_1
    //   105: areturn
    //   106: astore_0
    //   107: goto -6 -> 101
    //   110: astore_1
    //   111: goto -18 -> 93
    //   114: astore_1
    //   115: goto -38 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramFile	java.io.File
    //   0	118	1	paramClass	java.lang.Class<? extends PluginBaseInfo>
    //   1	72	2	localClass	java.lang.Class<? extends PluginBaseInfo>
    //   9	45	3	localObject	Object
    //   45	10	4	localPluginInfoParser	PluginBaseInfoHelper.PluginInfoParser
    // Exception table:
    //   from	to	target	type
    //   10	19	74	java/lang/Exception
    //   81	85	87	java/io/IOException
    //   10	19	90	finally
    //   66	70	103	java/io/IOException
    //   97	101	106	java/io/IOException
    //   19	60	110	finally
    //   19	60	114	java/lang/Exception
  }
  
  public static PluginBaseInfo parseConfig(String paramString, PluginBaseInfoHelper.PluginInfoParser paramPluginInfoParser)
  {
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(paramString.getBytes()), paramPluginInfoParser);
      paramString = paramPluginInfoParser.getResult();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper
 * JD-Core Version:    0.7.0.1
 */