package com.tencent.mobileqq.uniformdownload.data;

import android.os.Bundle;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

public class UDFileInfo
{
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  
  public UDFileInfo(String paramString)
  {
    if ((paramString == null) || (paramString.length() < 1)) {}
    do
    {
      return;
      a(paramString);
    } while (!this.jdField_a_of_type_JavaLangString.isEmpty());
    this.jdField_a_of_type_JavaLangString = "nofilename.x";
  }
  
  /* Error */
  public static long a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 9
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 11
    //   14: iload_1
    //   15: ifgt +7 -> 22
    //   18: lconst_0
    //   19: lstore_3
    //   20: lload_3
    //   21: lreturn
    //   22: new 38	java/net/URL
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   33: checkcast 46	java/net/HttpURLConnection
    //   36: astore 8
    //   38: aload 8
    //   40: invokevirtual 49	java/net/HttpURLConnection:getResponseCode	()I
    //   43: sipush 302
    //   46: if_icmpne +39 -> 85
    //   49: aload 8
    //   51: ldc 51
    //   53: invokevirtual 55	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_0
    //   57: lload_3
    //   58: lstore 5
    //   60: aload_0
    //   61: astore 7
    //   63: aload 8
    //   65: ifnull +107 -> 172
    //   68: aload 8
    //   70: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   73: aload_0
    //   74: ifnull -54 -> 20
    //   77: aload_0
    //   78: iload_1
    //   79: iconst_1
    //   80: isub
    //   81: invokestatic 60	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:a	(Ljava/lang/String;I)J
    //   84: lreturn
    //   85: aload 8
    //   87: invokevirtual 63	java/net/HttpURLConnection:getContentLength	()I
    //   90: istore_2
    //   91: iload_2
    //   92: i2l
    //   93: lstore_3
    //   94: aload 11
    //   96: astore_0
    //   97: goto -40 -> 57
    //   100: astore 7
    //   102: aconst_null
    //   103: astore_0
    //   104: aload 7
    //   106: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   109: lload_3
    //   110: lstore 5
    //   112: aload 10
    //   114: astore 7
    //   116: aload_0
    //   117: ifnull +55 -> 172
    //   120: aload_0
    //   121: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   124: lconst_0
    //   125: lstore_3
    //   126: aload 9
    //   128: astore_0
    //   129: goto -56 -> 73
    //   132: astore_0
    //   133: aload 7
    //   135: ifnull +8 -> 143
    //   138: aload 7
    //   140: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: aload 8
    //   148: astore 7
    //   150: goto -17 -> 133
    //   153: astore 8
    //   155: aload_0
    //   156: astore 7
    //   158: aload 8
    //   160: astore_0
    //   161: goto -28 -> 133
    //   164: astore 7
    //   166: aload 8
    //   168: astore_0
    //   169: goto -65 -> 104
    //   172: lload 5
    //   174: lstore_3
    //   175: aload 7
    //   177: astore_0
    //   178: goto -105 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramString	String
    //   0	181	1	paramInt	int
    //   90	2	2	i	int
    //   1	174	3	l1	long
    //   58	115	5	l2	long
    //   6	56	7	str	String
    //   100	5	7	localException1	java.lang.Exception
    //   114	43	7	localObject1	Object
    //   164	12	7	localException2	java.lang.Exception
    //   36	111	8	localHttpURLConnection	HttpURLConnection
    //   153	14	8	localObject2	Object
    //   3	124	9	localObject3	Object
    //   9	104	10	localObject4	Object
    //   12	83	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   22	38	100	java/lang/Exception
    //   22	38	132	finally
    //   38	57	145	finally
    //   85	91	145	finally
    //   104	109	153	finally
    //   38	57	164	java/lang/Exception
    //   85	91	164	java/lang/Exception
  }
  
  private String a(String paramString)
  {
    String str = new URL(paramString).getFile();
    if ((str == null) || (!str.contains("."))) {
      paramString = "";
    }
    int i;
    do
    {
      return paramString;
      i = str.lastIndexOf("/");
      paramString = str;
    } while (i == -1);
    return str.substring(i + 1);
  }
  
  private String a(HttpURLConnection paramHttpURLConnection)
  {
    localObject = "";
    for (;;)
    {
      try
      {
        str = paramHttpURLConnection.getHeaderField("Content-Disposition");
        if (str != null)
        {
          localObject = str;
          if (str.length() >= 1) {
            continue;
          }
        }
        localObject = str;
        paramHttpURLConnection = paramHttpURLConnection.getURL().getFile();
        localObject = paramHttpURLConnection;
        paramHttpURLConnection = paramHttpURLConnection.substring(paramHttpURLConnection.lastIndexOf("/") + 1);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        String str;
        int i;
        paramHttpURLConnection = (HttpURLConnection)localObject;
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      return b(paramHttpURLConnection);
      localObject = str;
      i = str.toLowerCase().indexOf("filename=");
      if (i == -1) {
        return "";
      }
      localObject = str;
      str = URLDecoder.decode(str.substring(i + "filename=".length()), "utf-8");
      localObject = str;
      i = str.indexOf(";");
      paramHttpURLConnection = str;
      if (-1 != i)
      {
        localObject = str;
        paramHttpURLConnection = str.substring(0, i - 1);
      }
      localObject = paramHttpURLConnection;
      paramHttpURLConnection = paramHttpURLConnection.replaceAll("\"", "");
    }
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: new 38	java/net/URL
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 46	java/net/HttpURLConnection
    //   19: astore_3
    //   20: aload_3
    //   21: ldc 127
    //   23: ldc 108
    //   25: invokevirtual 131	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_3
    //   29: ldc 133
    //   31: ldc 108
    //   33: invokevirtual 131	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_3
    //   37: invokevirtual 136	java/net/HttpURLConnection:connect	()V
    //   40: aload_3
    //   41: invokevirtual 49	java/net/HttpURLConnection:getResponseCode	()I
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 49	java/net/HttpURLConnection:getResponseCode	()I
    //   49: sipush 200
    //   52: if_icmpne +40 -> 92
    //   55: aload_0
    //   56: aload_3
    //   57: invokevirtual 63	java/net/HttpURLConnection:getContentLength	()I
    //   60: i2l
    //   61: putfield 18	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:jdField_a_of_type_Long	J
    //   64: aload_0
    //   65: aload_0
    //   66: aload_3
    //   67: invokespecial 138	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   70: putfield 16	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_0
    //   74: getfield 16	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: invokevirtual 30	java/lang/String:isEmpty	()Z
    //   80: ifeq +12 -> 92
    //   83: aload_0
    //   84: aload_0
    //   85: aload_1
    //   86: invokespecial 140	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   89: putfield 16	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   100: return
    //   101: astore_3
    //   102: aload 4
    //   104: astore_1
    //   105: aload_1
    //   106: astore_2
    //   107: aload_3
    //   108: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   111: aload_1
    //   112: ifnull -12 -> 100
    //   115: aload_1
    //   116: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   119: return
    //   120: astore_1
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: aload_3
    //   133: astore_2
    //   134: goto -13 -> 121
    //   137: astore_2
    //   138: aload_3
    //   139: astore_1
    //   140: aload_2
    //   141: astore_3
    //   142: goto -37 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	UDFileInfo
    //   0	145	1	paramString	String
    //   1	133	2	localObject1	Object
    //   137	4	2	localException1	java.lang.Exception
    //   19	78	3	localHttpURLConnection	HttpURLConnection
    //   101	38	3	localException2	java.lang.Exception
    //   141	1	3	localException3	java.lang.Exception
    //   3	100	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	20	101	java/lang/Exception
    //   5	20	120	finally
    //   107	111	120	finally
    //   20	92	131	finally
    //   20	92	137	java/lang/Exception
  }
  
  public static void a(String paramString, Bundle paramBundle)
  {
    if ((TextUtils.isEmpty(paramBundle.getString("_filename_from_dlg", ""))) || (paramBundle.getLong("_filesize_from_dlg") == 0L))
    {
      paramString = new UDFileInfo(paramString);
      paramBundle.putString("_filename_from_dlg", paramString.a());
      paramBundle.putLong("_filesize_from_dlg", paramString.a());
    }
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      int i = paramString.indexOf("?");
      str = paramString;
      if (i != -1) {
        str = paramString.substring(0, i);
      }
      paramString = str;
    } while (!str.contains(":"));
    return "";
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.UDFileInfo
 * JD-Core Version:    0.7.0.1
 */