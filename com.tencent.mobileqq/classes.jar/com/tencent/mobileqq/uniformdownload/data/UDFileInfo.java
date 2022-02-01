package com.tencent.mobileqq.uniformdownload.data;

import android.os.Bundle;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

public class UDFileInfo
{
  private String a = "";
  private long b = 0L;
  
  public UDFileInfo(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() < 1) {
        return;
      }
      a(paramString);
      if (this.a.isEmpty()) {
        this.a = "nofilename.x";
      }
    }
  }
  
  /* Error */
  public static long a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: iload_1
    //   3: ifgt +5 -> 8
    //   6: lconst_0
    //   7: lreturn
    //   8: aconst_null
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 11
    //   14: aconst_null
    //   15: astore 9
    //   17: new 39	java/net/URL
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 41	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 45	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   28: checkcast 47	java/net/HttpURLConnection
    //   31: astore 7
    //   33: aload 7
    //   35: astore 8
    //   37: aload 7
    //   39: invokevirtual 50	java/net/HttpURLConnection:getResponseCode	()I
    //   42: sipush 302
    //   45: if_icmpne +18 -> 63
    //   48: aload 7
    //   50: astore 8
    //   52: aload 7
    //   54: ldc 52
    //   56: invokevirtual 56	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_0
    //   60: goto +19 -> 79
    //   63: aload 7
    //   65: astore 8
    //   67: aload 7
    //   69: invokevirtual 59	java/net/HttpURLConnection:getContentLength	()I
    //   72: istore_2
    //   73: iload_2
    //   74: i2l
    //   75: lstore_3
    //   76: aload 9
    //   78: astore_0
    //   79: lload_3
    //   80: lstore 5
    //   82: aload_0
    //   83: astore 8
    //   85: aload 7
    //   87: ifnull +65 -> 152
    //   90: aload_0
    //   91: astore 8
    //   93: aload 7
    //   95: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   98: lload_3
    //   99: lstore 5
    //   101: goto +51 -> 152
    //   104: astore 9
    //   106: aload 7
    //   108: astore_0
    //   109: goto +14 -> 123
    //   112: astore_0
    //   113: aconst_null
    //   114: astore 8
    //   116: goto +54 -> 170
    //   119: astore 9
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: astore 8
    //   126: aload 9
    //   128: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   131: lload_3
    //   132: lstore 5
    //   134: aload 11
    //   136: astore 8
    //   138: aload_0
    //   139: ifnull +13 -> 152
    //   142: aload 10
    //   144: astore 8
    //   146: aload_0
    //   147: astore 7
    //   149: goto -56 -> 93
    //   152: aload 8
    //   154: ifnull +12 -> 166
    //   157: aload 8
    //   159: iload_1
    //   160: iconst_1
    //   161: isub
    //   162: invokestatic 67	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:a	(Ljava/lang/String;I)J
    //   165: lreturn
    //   166: lload 5
    //   168: lreturn
    //   169: astore_0
    //   170: aload 8
    //   172: ifnull +8 -> 180
    //   175: aload 8
    //   177: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   180: goto +5 -> 185
    //   183: aload_0
    //   184: athrow
    //   185: goto -2 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramString	String
    //   0	188	1	paramInt	int
    //   72	2	2	i	int
    //   1	131	3	l1	long
    //   80	87	5	l2	long
    //   31	117	7	localObject1	Object
    //   35	141	8	localObject2	Object
    //   15	62	9	localObject3	Object
    //   104	1	9	localException1	java.lang.Exception
    //   119	8	9	localException2	java.lang.Exception
    //   9	134	10	localObject4	Object
    //   12	123	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   37	48	104	java/lang/Exception
    //   52	60	104	java/lang/Exception
    //   67	73	104	java/lang/Exception
    //   17	33	112	finally
    //   17	33	119	java/lang/Exception
    //   37	48	169	finally
    //   52	60	169	finally
    //   67	73	169	finally
    //   126	131	169	finally
  }
  
  private String a(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject1 = "";
    try
    {
      String str2 = paramHttpURLConnection.getHeaderField("Content-Disposition");
      if (str2 != null) {}
      try
      {
        if (str2.length() >= 1)
        {
          int i = str2.toLowerCase().indexOf("filename=");
          if (i == -1) {
            return "";
          }
          String str1 = URLDecoder.decode(str2.substring(i + 9), "utf-8");
          paramHttpURLConnection = str1;
          try
          {
            i = str1.indexOf(";");
            localObject1 = str1;
            if (-1 != i)
            {
              paramHttpURLConnection = str1;
              localObject1 = str1.substring(0, i - 1);
            }
            paramHttpURLConnection = (HttpURLConnection)localObject1;
            localObject1 = ((String)localObject1).replaceAll("\"", "");
            paramHttpURLConnection = (HttpURLConnection)localObject1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException1)
          {
            break label155;
          }
        }
        else
        {
          paramHttpURLConnection = paramHttpURLConnection.getURL().getFile();
          HttpURLConnection localHttpURLConnection = paramHttpURLConnection;
          paramHttpURLConnection = paramHttpURLConnection.substring(paramHttpURLConnection.lastIndexOf("/") + 1);
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        paramHttpURLConnection = str2;
      }
      Object localObject2;
      localObject2.printStackTrace();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException3)
    {
      paramHttpURLConnection = localUnsupportedEncodingException2;
      localObject2 = localUnsupportedEncodingException3;
    }
    label155:
    return c(paramHttpURLConnection);
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 39	java/net/URL
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 41	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 45	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 47	java/net/HttpURLConnection
    //   19: astore_3
    //   20: aload_3
    //   21: ldc 122
    //   23: ldc 88
    //   25: invokevirtual 126	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_3
    //   29: ldc 128
    //   31: ldc 88
    //   33: invokevirtual 126	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_3
    //   37: invokevirtual 131	java/net/HttpURLConnection:connect	()V
    //   40: aload_3
    //   41: invokevirtual 50	java/net/HttpURLConnection:getResponseCode	()I
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 50	java/net/HttpURLConnection:getResponseCode	()I
    //   49: sipush 200
    //   52: if_icmpne +40 -> 92
    //   55: aload_0
    //   56: aload_3
    //   57: invokevirtual 59	java/net/HttpURLConnection:getContentLength	()I
    //   60: i2l
    //   61: putfield 19	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:b	J
    //   64: aload_0
    //   65: aload_0
    //   66: aload_3
    //   67: invokespecial 133	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   70: putfield 17	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:a	Ljava/lang/String;
    //   73: aload_0
    //   74: getfield 17	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:a	Ljava/lang/String;
    //   77: invokevirtual 31	java/lang/String:isEmpty	()Z
    //   80: ifeq +12 -> 92
    //   83: aload_0
    //   84: aload_0
    //   85: aload_1
    //   86: invokespecial 135	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:b	(Ljava/lang/String;)Ljava/lang/String;
    //   89: putfield 17	com/tencent/mobileqq/uniformdownload/data/UDFileInfo:a	Ljava/lang/String;
    //   92: aload_3
    //   93: ifnull +44 -> 137
    //   96: aload_3
    //   97: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   100: return
    //   101: astore_1
    //   102: goto +36 -> 138
    //   105: astore_2
    //   106: aload_3
    //   107: astore_1
    //   108: aload_2
    //   109: astore_3
    //   110: goto +13 -> 123
    //   113: astore_1
    //   114: aload_2
    //   115: astore_3
    //   116: goto +22 -> 138
    //   119: astore_3
    //   120: aload 4
    //   122: astore_1
    //   123: aload_1
    //   124: astore_2
    //   125: aload_3
    //   126: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   137: return
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	UDFileInfo
    //   0	148	1	paramString	String
    //   4	1	2	localObject1	Object
    //   105	10	2	localException1	java.lang.Exception
    //   124	1	2	str	String
    //   19	97	3	localObject2	Object
    //   119	24	3	localException2	java.lang.Exception
    //   1	120	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	92	101	finally
    //   20	92	105	java/lang/Exception
    //   5	20	113	finally
    //   125	129	113	finally
    //   5	20	119	java/lang/Exception
  }
  
  public static void a(String paramString, Bundle paramBundle)
  {
    if ((TextUtils.isEmpty(paramBundle.getString("_filename_from_dlg", ""))) || (paramBundle.getLong("_filesize_from_dlg") == 0L))
    {
      paramString = new UDFileInfo(paramString);
      paramBundle.putString("_filename_from_dlg", paramString.a());
      paramBundle.putLong("_filesize_from_dlg", paramString.b());
    }
  }
  
  private String b(String paramString)
  {
    paramString = new URL(paramString).getFile();
    if ((paramString != null) && (paramString.contains(".")))
    {
      int i = paramString.lastIndexOf("/");
      if (i == -1) {
        return paramString;
      }
      return paramString.substring(i + 1);
    }
    return "";
  }
  
  private String c(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.indexOf("?");
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(0, i);
    }
    paramString = str;
    if (str.contains(":")) {
      paramString = "";
    }
    return paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.UDFileInfo
 * JD-Core Version:    0.7.0.1
 */