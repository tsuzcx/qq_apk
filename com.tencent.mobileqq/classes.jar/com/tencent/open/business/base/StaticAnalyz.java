package com.tencent.open.business.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.viareport.OpenSdkStatic;

public class StaticAnalyz
{
  protected static String a = "";
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 50)
      {
        if (paramInt != 100)
        {
          if (paramInt != 52)
          {
            if (paramInt != 53) {
              return "";
            }
            return "ANDROIDQQ.PK.APPAIO";
          }
          return "ANDROIDQQ.BRAG.APPAIO";
        }
        return "ANDROIDQQ.INVITE.APPAIO";
      }
      return "ANDROIDQQ.REQUEST.APPAIO";
    }
    return "ANDROIDQQ.FREEGIFT.APPAIO";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 352)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 == 3) {
            break label63;
          }
          if ((paramInt2 != 7) && (paramInt2 != 8)) {
            return "";
          }
          if ((paramInt3 != 0) && (paramInt3 != 2))
          {
            if (paramInt3 == 1) {
              return "ANDROIDQQ.SENDSTORY.FEED2";
            }
          }
          else {
            return "ANDROIDQQ.SENDSTORY.FEED1";
          }
        }
        return "";
      }
      label63:
      return "ANDROIDQQ.INSTALL.FEED";
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && ((paramString1.startsWith("ANDROIDQQ.YYB")) || (paramString1.startsWith("ANDROIDQQ.NEWYYB")))) {
      return paramString1;
    }
    String str = "";
    Object localObject = str;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = str;
        if (!TextUtils.isEmpty(paramString2))
        {
          int i = paramString1.indexOf("ANDROIDQQ");
          if (i != -1)
          {
            i += 9;
            localObject = new StringBuilder(paramString1);
            ((StringBuilder)localObject).insert(i, ".");
            ((StringBuilder)localObject).insert(i + 1, paramString2);
            localObject = ((StringBuilder)localObject).toString();
          }
          else
          {
            LogUtility.c("VIA", "jointYybVia via dont contain ANDROIDQQ");
            localObject = str;
          }
        }
      }
    }
    catch (Exception paramString2)
    {
      LogUtility.c("VIA", "jointYybVia>>>", paramString2);
      localObject = str;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return paramString1;
    }
    return localObject;
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: new 59	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   19: astore 7
    //   21: aload 4
    //   23: astore_3
    //   24: aload 7
    //   26: aload_0
    //   27: invokevirtual 99	android/content/Context:getFilesDir	()Ljava/io/File;
    //   30: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 4
    //   36: astore_3
    //   37: aload 7
    //   39: getstatic 108	java/io/File:separator	Ljava/lang/String;
    //   42: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 4
    //   48: astore_3
    //   49: aload 7
    //   51: ldc 113
    //   53: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 4
    //   59: astore_3
    //   60: aload 7
    //   62: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore 7
    //   67: aload 4
    //   69: astore_3
    //   70: new 115	java/io/BufferedReader
    //   73: dup
    //   74: new 117	java/io/FileReader
    //   77: dup
    //   78: aload 7
    //   80: invokespecial 118	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   83: invokespecial 121	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   86: astore 4
    //   88: aload 4
    //   90: invokevirtual 124	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   93: astore_3
    //   94: aload 4
    //   96: invokevirtual 124	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   99: astore 5
    //   101: aload 4
    //   103: invokevirtual 124	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   106: astore 6
    //   108: aload_3
    //   109: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: istore_2
    //   113: iload_2
    //   114: ifne +119 -> 233
    //   117: aload 5
    //   119: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne +111 -> 233
    //   125: aload 6
    //   127: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifne +103 -> 233
    //   133: new 59	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   140: astore 8
    //   142: aload 8
    //   144: ldc 126
    //   146: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 8
    //   152: aload_3
    //   153: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 8
    //   159: ldc 128
    //   161: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 8
    //   167: aload 5
    //   169: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 8
    //   175: ldc 130
    //   177: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 8
    //   183: aload 6
    //   185: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc 74
    //   191: aload 8
    //   193: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 82	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_3
    //   200: aload 5
    //   202: aload_1
    //   203: aload 6
    //   205: invokestatic 134	com/tencent/open/business/base/StaticAnalyz:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   208: new 105	java/io/File
    //   211: dup
    //   212: aload 7
    //   214: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   217: invokevirtual 139	java/io/File:exists	()Z
    //   220: ifeq +71 -> 291
    //   223: aload_0
    //   224: ldc 113
    //   226: invokevirtual 142	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   229: pop
    //   230: goto +61 -> 291
    //   233: new 59	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   240: astore_0
    //   241: aload_0
    //   242: ldc 144
    //   244: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_0
    //   249: aload_3
    //   250: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_0
    //   255: ldc 128
    //   257: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_0
    //   262: aload 5
    //   264: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_0
    //   269: ldc 130
    //   271: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload_0
    //   276: aload 6
    //   278: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: ldc 74
    //   284: aload_0
    //   285: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 147	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload 4
    //   293: invokevirtual 150	java/io/BufferedReader:close	()V
    //   296: return
    //   297: astore_0
    //   298: goto +68 -> 366
    //   301: astore_1
    //   302: aload 4
    //   304: astore_0
    //   305: goto +21 -> 326
    //   308: astore_1
    //   309: aload 4
    //   311: astore_0
    //   312: goto +33 -> 345
    //   315: astore_0
    //   316: aload_3
    //   317: astore 4
    //   319: goto +47 -> 366
    //   322: astore_1
    //   323: aload 5
    //   325: astore_0
    //   326: aload_0
    //   327: astore_3
    //   328: aload_1
    //   329: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   332: aload_0
    //   333: ifnull +32 -> 365
    //   336: aload_0
    //   337: invokevirtual 150	java/io/BufferedReader:close	()V
    //   340: return
    //   341: astore_1
    //   342: aload 6
    //   344: astore_0
    //   345: aload_0
    //   346: astore_3
    //   347: aload_1
    //   348: invokevirtual 154	java/io/FileNotFoundException:printStackTrace	()V
    //   351: aload_0
    //   352: ifnull +13 -> 365
    //   355: aload_0
    //   356: invokevirtual 150	java/io/BufferedReader:close	()V
    //   359: return
    //   360: astore_0
    //   361: aload_0
    //   362: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   365: return
    //   366: aload 4
    //   368: ifnull +16 -> 384
    //   371: aload 4
    //   373: invokevirtual 150	java/io/BufferedReader:close	()V
    //   376: goto +8 -> 384
    //   379: astore_1
    //   380: aload_1
    //   381: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   384: aload_0
    //   385: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramContext	android.content.Context
    //   0	386	1	paramString	String
    //   112	2	2	bool	boolean
    //   11	336	3	localObject1	Object
    //   7	365	4	localObject2	Object
    //   1	323	5	str1	String
    //   4	339	6	str2	String
    //   19	194	7	localObject3	Object
    //   140	52	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   88	113	297	finally
    //   117	230	297	finally
    //   233	291	297	finally
    //   88	113	301	java/io/IOException
    //   117	230	301	java/io/IOException
    //   233	291	301	java/io/IOException
    //   88	113	308	java/io/FileNotFoundException
    //   117	230	308	java/io/FileNotFoundException
    //   233	291	308	java/io/FileNotFoundException
    //   12	21	315	finally
    //   24	34	315	finally
    //   37	46	315	finally
    //   49	57	315	finally
    //   60	67	315	finally
    //   70	88	315	finally
    //   328	332	315	finally
    //   347	351	315	finally
    //   12	21	322	java/io/IOException
    //   24	34	322	java/io/IOException
    //   37	46	322	java/io/IOException
    //   49	57	322	java/io/IOException
    //   60	67	322	java/io/IOException
    //   70	88	322	java/io/IOException
    //   12	21	341	java/io/FileNotFoundException
    //   24	34	341	java/io/FileNotFoundException
    //   37	46	341	java/io/FileNotFoundException
    //   49	57	341	java/io/FileNotFoundException
    //   60	67	341	java/io/FileNotFoundException
    //   70	88	341	java/io/FileNotFoundException
    //   291	296	360	java/io/IOException
    //   336	340	360	java/io/IOException
    //   355	359	360	java/io/IOException
    //   371	376	379	java/io/IOException
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +324 -> 328
    //   7: aload_2
    //   8: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +317 -> 328
    //   14: aload_3
    //   15: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +6 -> 24
    //   21: goto +307 -> 328
    //   24: aconst_null
    //   25: astore 5
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 7
    //   33: aload 7
    //   35: astore 4
    //   37: new 59	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   44: astore 8
    //   46: aload 7
    //   48: astore 4
    //   50: aload 8
    //   52: aload_0
    //   53: invokevirtual 99	android/content/Context:getFilesDir	()Ljava/io/File;
    //   56: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 7
    //   62: astore 4
    //   64: aload 8
    //   66: getstatic 108	java/io/File:separator	Ljava/lang/String;
    //   69: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 7
    //   75: astore 4
    //   77: aload 8
    //   79: ldc 113
    //   81: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 7
    //   87: astore 4
    //   89: aload 8
    //   91: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore 8
    //   96: aload 7
    //   98: astore 4
    //   100: new 105	java/io/File
    //   103: dup
    //   104: aload 8
    //   106: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: invokevirtual 139	java/io/File:exists	()Z
    //   112: ifeq +14 -> 126
    //   115: aload 7
    //   117: astore 4
    //   119: aload_0
    //   120: ldc 113
    //   122: invokevirtual 142	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   125: pop
    //   126: aload 7
    //   128: astore 4
    //   130: new 157	java/io/BufferedWriter
    //   133: dup
    //   134: new 159	java/io/FileWriter
    //   137: dup
    //   138: aload 8
    //   140: invokespecial 160	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   143: invokespecial 163	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   146: astore_0
    //   147: aload_0
    //   148: aload_1
    //   149: invokevirtual 166	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: invokevirtual 169	java/io/BufferedWriter:newLine	()V
    //   156: aload_0
    //   157: aload_2
    //   158: invokevirtual 166	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: invokevirtual 169	java/io/BufferedWriter:newLine	()V
    //   165: aload_0
    //   166: aload_3
    //   167: invokevirtual 166	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokevirtual 172	java/io/BufferedWriter:flush	()V
    //   174: new 59	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   181: astore 4
    //   183: aload 4
    //   185: ldc 174
    //   187: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 4
    //   193: aload_1
    //   194: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: ldc 128
    //   202: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 4
    //   208: aload_2
    //   209: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 4
    //   215: ldc 130
    //   217: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: aload_3
    //   224: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc 74
    //   230: aload 4
    //   232: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 82	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_0
    //   239: invokevirtual 175	java/io/BufferedWriter:close	()V
    //   242: return
    //   243: astore_1
    //   244: aload_0
    //   245: astore 4
    //   247: goto +61 -> 308
    //   250: astore_1
    //   251: goto +15 -> 266
    //   254: astore_1
    //   255: goto +31 -> 286
    //   258: astore_1
    //   259: goto +49 -> 308
    //   262: astore_1
    //   263: aload 5
    //   265: astore_0
    //   266: aload_0
    //   267: astore 4
    //   269: aload_1
    //   270: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   273: aload_0
    //   274: ifnull +33 -> 307
    //   277: aload_0
    //   278: invokevirtual 175	java/io/BufferedWriter:close	()V
    //   281: return
    //   282: astore_1
    //   283: aload 6
    //   285: astore_0
    //   286: aload_0
    //   287: astore 4
    //   289: aload_1
    //   290: invokevirtual 154	java/io/FileNotFoundException:printStackTrace	()V
    //   293: aload_0
    //   294: ifnull +13 -> 307
    //   297: aload_0
    //   298: invokevirtual 175	java/io/BufferedWriter:close	()V
    //   301: return
    //   302: astore_0
    //   303: aload_0
    //   304: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   307: return
    //   308: aload 4
    //   310: ifnull +16 -> 326
    //   313: aload 4
    //   315: invokevirtual 175	java/io/BufferedWriter:close	()V
    //   318: goto +8 -> 326
    //   321: astore_0
    //   322: aload_0
    //   323: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   326: aload_1
    //   327: athrow
    //   328: new 59	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   335: astore_0
    //   336: aload_0
    //   337: ldc 177
    //   339: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_0
    //   344: aload_1
    //   345: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_0
    //   350: ldc 128
    //   352: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_0
    //   357: aload_2
    //   358: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_0
    //   363: ldc 130
    //   365: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_0
    //   370: aload_3
    //   371: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: ldc 74
    //   377: aload_0
    //   378: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 147	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramContext	android.content.Context
    //   0	385	1	paramString1	String
    //   0	385	2	paramString2	String
    //   0	385	3	paramString3	String
    //   35	279	4	localObject1	Object
    //   25	239	5	localObject2	Object
    //   28	256	6	localObject3	Object
    //   31	96	7	localObject4	Object
    //   44	95	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   147	238	243	finally
    //   147	238	250	java/io/IOException
    //   147	238	254	java/io/FileNotFoundException
    //   37	46	258	finally
    //   50	60	258	finally
    //   64	73	258	finally
    //   77	85	258	finally
    //   89	96	258	finally
    //   100	115	258	finally
    //   119	126	258	finally
    //   130	147	258	finally
    //   269	273	258	finally
    //   289	293	258	finally
    //   37	46	262	java/io/IOException
    //   50	60	262	java/io/IOException
    //   64	73	262	java/io/IOException
    //   77	85	262	java/io/IOException
    //   89	96	262	java/io/IOException
    //   100	115	262	java/io/IOException
    //   119	126	262	java/io/IOException
    //   130	147	262	java/io/IOException
    //   37	46	282	java/io/FileNotFoundException
    //   50	60	282	java/io/FileNotFoundException
    //   64	73	282	java/io/FileNotFoundException
    //   77	85	282	java/io/FileNotFoundException
    //   89	96	282	java/io/FileNotFoundException
    //   100	115	282	java/io/FileNotFoundException
    //   119	126	282	java/io/FileNotFoundException
    //   130	147	282	java/io/FileNotFoundException
    //   238	242	302	java/io/IOException
    //   277	281	302	java/io/IOException
    //   297	301	302	java/io/IOException
    //   313	318	321	java/io/IOException
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportForVia actionType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" via=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", appid=");
      localStringBuilder.append(paramString3);
      LogUtility.b("reportForVia", localStringBuilder.toString());
      OpenSdkStatic.a().a(String.valueOf(CommonDataAdapter.a().c()), paramString3, paramString2, paramString1, paramString4, false, false);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportForVia actionType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" via=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", appid=");
      localStringBuilder.append(paramString3);
      LogUtility.b("reportForVia", localStringBuilder.toString());
      long l = CommonDataAdapter.a().c();
      OpenSdkStatic.a().a(String.valueOf(l), paramString3, paramString2, paramString1, CommonDataAdapter.a().l(), paramBundle, paramString4, false, false);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportForVia actionType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" via=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", appid=");
      localStringBuilder.append(paramString3);
      LogUtility.b("reportForVia", localStringBuilder.toString());
      OpenSdkStatic.a().a(String.valueOf(CommonDataAdapter.a().c()), paramString3, paramString2, paramString1, "", false, paramBoolean);
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString4 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportForVia actionType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" via=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", appid=");
      localStringBuilder.append(paramString4);
      LogUtility.b("reportForVia", localStringBuilder.toString());
      OpenSdkStatic.a().a(paramString3, paramString4, paramString2, paramString1, "", false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.base.StaticAnalyz
 * JD-Core Version:    0.7.0.1
 */