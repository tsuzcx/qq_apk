package com.tencent.qqlive.tvkplayer.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.regex.PatternSyntaxException;

public class TVKUtils
{
  private static String DOT = "\\.";
  private static final String TAG = "TVKUtils[TVKUtils.java]";
  private static String appVersion = "";
  private static int buildNum = -1;
  private static float sDensity;
  private static int sWidth;
  
  /* Error */
  public static boolean byte2File(byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +319 -> 320
    //   4: aload_0
    //   5: arraylength
    //   6: ifeq +314 -> 320
    //   9: iload_1
    //   10: ifne +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_2
    //   16: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +301 -> 320
    //   22: aload_3
    //   23: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: new 38	java/io/File
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 45	java/io/File:exists	()Z
    //   44: ifeq +10 -> 54
    //   47: aload_2
    //   48: invokevirtual 48	java/io/File:isDirectory	()Z
    //   51: ifne +12 -> 63
    //   54: aload_2
    //   55: invokevirtual 51	java/io/File:mkdirs	()Z
    //   58: ifne +5 -> 63
    //   61: iconst_0
    //   62: ireturn
    //   63: new 53	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   70: astore 4
    //   72: aload 4
    //   74: aload_2
    //   75: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 4
    //   81: getstatic 61	java/io/File:separator	Ljava/lang/String;
    //   84: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 4
    //   90: aload_3
    //   91: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: new 38	java/io/File
    //   98: dup
    //   99: aload 4
    //   101: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 45	java/io/File:exists	()Z
    //   112: ifeq +15 -> 127
    //   115: aload_2
    //   116: invokevirtual 72	java/io/File:length	()J
    //   119: iload_1
    //   120: i2l
    //   121: lcmp
    //   122: ifne +5 -> 127
    //   125: iconst_1
    //   126: ireturn
    //   127: aload_2
    //   128: invokevirtual 45	java/io/File:exists	()Z
    //   131: ifeq +12 -> 143
    //   134: aload_2
    //   135: invokevirtual 75	java/io/File:delete	()Z
    //   138: ifne +5 -> 143
    //   141: iconst_0
    //   142: ireturn
    //   143: aconst_null
    //   144: astore 6
    //   146: aconst_null
    //   147: astore 4
    //   149: aconst_null
    //   150: astore_3
    //   151: new 77	java/io/FileOutputStream
    //   154: dup
    //   155: aload_2
    //   156: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   159: astore_2
    //   160: aload_3
    //   161: astore 4
    //   163: aload_2
    //   164: astore_3
    //   165: new 82	java/io/BufferedOutputStream
    //   168: dup
    //   169: aload_2
    //   170: invokespecial 85	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   173: astore 5
    //   175: aload 5
    //   177: aload_0
    //   178: invokevirtual 89	java/io/BufferedOutputStream:write	([B)V
    //   181: aload 5
    //   183: invokevirtual 92	java/io/BufferedOutputStream:flush	()V
    //   186: aload 5
    //   188: invokevirtual 95	java/io/BufferedOutputStream:close	()V
    //   191: aload_2
    //   192: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   195: iconst_1
    //   196: ireturn
    //   197: astore_0
    //   198: ldc 11
    //   200: aload_0
    //   201: invokestatic 102	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   204: iconst_1
    //   205: ireturn
    //   206: astore_0
    //   207: aload 5
    //   209: astore 4
    //   211: goto +77 -> 288
    //   214: astore_0
    //   215: goto +30 -> 245
    //   218: astore_0
    //   219: aload_3
    //   220: astore_2
    //   221: goto +67 -> 288
    //   224: astore_0
    //   225: aload 6
    //   227: astore 5
    //   229: goto +16 -> 245
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_2
    //   235: goto +53 -> 288
    //   238: astore_0
    //   239: aconst_null
    //   240: astore_2
    //   241: aload 6
    //   243: astore 5
    //   245: aload 5
    //   247: astore 4
    //   249: aload_2
    //   250: astore_3
    //   251: ldc 11
    //   253: aload_0
    //   254: invokestatic 102	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload 5
    //   259: ifnull +11 -> 270
    //   262: aload 5
    //   264: invokevirtual 95	java/io/BufferedOutputStream:close	()V
    //   267: goto +3 -> 270
    //   270: aload_2
    //   271: ifnull +15 -> 286
    //   274: aload_2
    //   275: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   278: iconst_0
    //   279: ireturn
    //   280: ldc 11
    //   282: aload_0
    //   283: invokestatic 102	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   286: iconst_0
    //   287: ireturn
    //   288: aload 4
    //   290: ifnull +11 -> 301
    //   293: aload 4
    //   295: invokevirtual 95	java/io/BufferedOutputStream:close	()V
    //   298: goto +3 -> 301
    //   301: aload_2
    //   302: ifnull +16 -> 318
    //   305: aload_2
    //   306: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   309: goto +9 -> 318
    //   312: ldc 11
    //   314: aload_2
    //   315: invokestatic 102	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload_0
    //   319: athrow
    //   320: iconst_0
    //   321: ireturn
    //   322: astore_0
    //   323: goto -43 -> 280
    //   326: astore_2
    //   327: goto -15 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramArrayOfByte	byte[]
    //   0	330	1	paramInt	int
    //   0	330	2	paramString1	String
    //   0	330	3	paramString2	String
    //   70	224	4	localObject1	Object
    //   173	90	5	localObject2	Object
    //   144	98	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   186	195	197	java/lang/Exception
    //   175	186	206	finally
    //   175	186	214	java/lang/Exception
    //   165	175	218	finally
    //   251	257	218	finally
    //   165	175	224	java/lang/Exception
    //   151	160	232	finally
    //   151	160	238	java/lang/Exception
    //   262	267	322	java/lang/Exception
    //   274	278	322	java/lang/Exception
    //   293	298	326	java/lang/Exception
    //   305	309	326	java/lang/Exception
  }
  
  public static long convertDateToTime(String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString);
      if (paramString != null)
      {
        long l = paramString.getTime();
        return l;
      }
    }
    catch (Exception paramString)
    {
      TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
    }
    return 0L;
  }
  
  public static String convertDefnName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace(";(", "  ").replace(")", "");
  }
  
  /* Error */
  public static void copyAssetsToDst(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 142	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 148	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   8: astore 5
    //   10: aload 5
    //   12: arraylength
    //   13: istore 4
    //   15: iconst_0
    //   16: istore_3
    //   17: iload 4
    //   19: ifle +191 -> 210
    //   22: new 38	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 6
    //   32: aload 6
    //   34: invokevirtual 45	java/io/File:exists	()Z
    //   37: ifne +9 -> 46
    //   40: aload 6
    //   42: invokevirtual 51	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: aload 5
    //   48: arraylength
    //   49: istore 4
    //   51: iload_3
    //   52: iload 4
    //   54: if_icmpge +351 -> 405
    //   57: aload 5
    //   59: iload_3
    //   60: aaload
    //   61: astore 6
    //   63: aload_1
    //   64: ldc 14
    //   66: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifne +90 -> 159
    //   72: new 53	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   79: astore 7
    //   81: aload 7
    //   83: aload_1
    //   84: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 7
    //   90: getstatic 61	java/io/File:separator	Ljava/lang/String;
    //   93: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 7
    //   99: aload 6
    //   101: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 7
    //   107: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 7
    //   112: new 53	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   119: astore 8
    //   121: aload 8
    //   123: aload_2
    //   124: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 8
    //   130: getstatic 61	java/io/File:separator	Ljava/lang/String;
    //   133: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 8
    //   139: aload 6
    //   141: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_0
    //   146: aload 7
    //   148: aload 8
    //   150: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 154	com/tencent/qqlive/tvkplayer/tools/utils/TVKUtils:copyAssetsToDst	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto +47 -> 203
    //   159: new 53	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   166: astore 7
    //   168: aload 7
    //   170: aload_2
    //   171: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 7
    //   177: getstatic 61	java/io/File:separator	Ljava/lang/String;
    //   180: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 7
    //   186: aload 6
    //   188: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_0
    //   193: aload 6
    //   195: aload 7
    //   197: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 154	com/tencent/qqlive/tvkplayer/tools/utils/TVKUtils:copyAssetsToDst	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   203: iload_3
    //   204: iconst_1
    //   205: iadd
    //   206: istore_3
    //   207: goto -156 -> 51
    //   210: aconst_null
    //   211: astore 6
    //   213: aconst_null
    //   214: astore 5
    //   216: aconst_null
    //   217: astore 7
    //   219: new 38	java/io/File
    //   222: dup
    //   223: aload_2
    //   224: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   227: astore 8
    //   229: aload_0
    //   230: invokevirtual 142	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   233: aload_1
    //   234: invokevirtual 158	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   237: astore_0
    //   238: aload 6
    //   240: astore_1
    //   241: aload_0
    //   242: astore_2
    //   243: new 77	java/io/FileOutputStream
    //   246: dup
    //   247: aload 8
    //   249: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   252: astore 5
    //   254: sipush 1024
    //   257: newarray byte
    //   259: astore_1
    //   260: aload_0
    //   261: aload_1
    //   262: invokevirtual 164	java/io/InputStream:read	([B)I
    //   265: istore_3
    //   266: iload_3
    //   267: iconst_m1
    //   268: if_icmpeq +14 -> 282
    //   271: aload 5
    //   273: aload_1
    //   274: iconst_0
    //   275: iload_3
    //   276: invokevirtual 167	java/io/FileOutputStream:write	([BII)V
    //   279: goto -19 -> 260
    //   282: aload 5
    //   284: invokevirtual 168	java/io/FileOutputStream:flush	()V
    //   287: aload_0
    //   288: invokevirtual 169	java/io/InputStream:close	()V
    //   291: aload 5
    //   293: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   296: aload 5
    //   298: invokevirtual 168	java/io/FileOutputStream:flush	()V
    //   301: aload_0
    //   302: ifnull +7 -> 309
    //   305: aload_0
    //   306: invokevirtual 169	java/io/InputStream:close	()V
    //   309: aload 5
    //   311: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   314: return
    //   315: astore_2
    //   316: aload 5
    //   318: astore_1
    //   319: aload_2
    //   320: astore 5
    //   322: goto +88 -> 410
    //   325: astore 6
    //   327: goto +32 -> 359
    //   330: astore 6
    //   332: aload 7
    //   334: astore 5
    //   336: goto +23 -> 359
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_0
    //   342: aload 5
    //   344: astore_1
    //   345: aload_2
    //   346: astore 5
    //   348: goto +62 -> 410
    //   351: astore 6
    //   353: aconst_null
    //   354: astore_0
    //   355: aload 7
    //   357: astore 5
    //   359: aload 5
    //   361: astore_1
    //   362: aload_0
    //   363: astore_2
    //   364: aload 6
    //   366: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   369: aload 5
    //   371: ifnull +11 -> 382
    //   374: aload 5
    //   376: invokevirtual 168	java/io/FileOutputStream:flush	()V
    //   379: goto +3 -> 382
    //   382: aload_0
    //   383: ifnull +7 -> 390
    //   386: aload_0
    //   387: invokevirtual 169	java/io/InputStream:close	()V
    //   390: aload 5
    //   392: ifnull +13 -> 405
    //   395: aload 5
    //   397: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   400: return
    //   401: aload_0
    //   402: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   405: return
    //   406: astore 5
    //   408: aload_2
    //   409: astore_0
    //   410: aload_1
    //   411: ifnull +10 -> 421
    //   414: aload_1
    //   415: invokevirtual 168	java/io/FileOutputStream:flush	()V
    //   418: goto +3 -> 421
    //   421: aload_0
    //   422: ifnull +7 -> 429
    //   425: aload_0
    //   426: invokevirtual 169	java/io/InputStream:close	()V
    //   429: aload_1
    //   430: ifnull +14 -> 444
    //   433: aload_1
    //   434: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   437: goto +7 -> 444
    //   440: aload_0
    //   441: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   444: aload 5
    //   446: athrow
    //   447: astore_0
    //   448: aload_0
    //   449: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   452: return
    //   453: astore_0
    //   454: goto -53 -> 401
    //   457: astore_0
    //   458: goto -18 -> 440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	paramContext	Context
    //   0	461	1	paramString1	String
    //   0	461	2	paramString2	String
    //   16	260	3	i	int
    //   13	42	4	j	int
    //   8	388	5	localObject1	Object
    //   406	39	5	localObject2	Object
    //   30	209	6	localFile	java.io.File
    //   325	1	6	localException1	Exception
    //   330	1	6	localException2	Exception
    //   351	14	6	localException3	Exception
    //   79	277	7	localObject3	Object
    //   119	129	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   254	260	315	finally
    //   260	266	315	finally
    //   271	279	315	finally
    //   282	296	315	finally
    //   254	260	325	java/lang/Exception
    //   260	266	325	java/lang/Exception
    //   271	279	325	java/lang/Exception
    //   282	296	325	java/lang/Exception
    //   243	254	330	java/lang/Exception
    //   219	238	339	finally
    //   219	238	351	java/lang/Exception
    //   243	254	406	finally
    //   364	369	406	finally
    //   0	10	447	java/io/IOException
    //   296	301	453	java/io/IOException
    //   305	309	453	java/io/IOException
    //   309	314	453	java/io/IOException
    //   374	379	453	java/io/IOException
    //   386	390	453	java/io/IOException
    //   395	400	453	java/io/IOException
    //   414	418	457	java/io/IOException
    //   425	429	457	java/io/IOException
    //   433	437	457	java/io/IOException
  }
  
  public static int defLevelCompare(String paramString1, String paramString2)
  {
    int i = getDefLevel(paramString1);
    int j = getDefLevel(paramString2);
    if (i > j) {
      return 1;
    }
    if (i == j) {
      return 0;
    }
    return -1;
  }
  
  public static Activity getActivity(View paramView)
  {
    Object localObject;
    if (paramView.getRootView().getContext().getClass().getName().contains("com.android.internal.policy.DecorContext")) {
      try
      {
        localObject = paramView.getRootView().getContext().getClass().getDeclaredField("mPhoneWindow");
        ((Field)localObject).setAccessible(true);
        paramView = ((Field)localObject).get(paramView.getRootView().getContext());
        paramView = (Activity)paramView.getClass().getMethod("getContext", new Class[0]).invoke(paramView, new Object[0]);
        return paramView;
      }
      catch (Exception paramView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Exception: ");
        ((StringBuilder)localObject).append(paramView.toString());
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", ((StringBuilder)localObject).toString());
      }
    } else {
      try
      {
        paramView = (Activity)paramView.getRootView().getContext();
        return paramView;
      }
      catch (Exception paramView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Exception: ");
        ((StringBuilder)localObject).append(paramView.toString());
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static String getAppVersion(String paramString)
  {
    if (!TextUtils.isEmpty(appVersion)) {
      return appVersion;
    }
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split(DOT);
      str = paramString;
      if (arrayOfString != null)
      {
        str = paramString;
        if (arrayOfString.length == 4) {
          str = paramString.substring(0, paramString.lastIndexOf("."));
        }
      }
    }
    else
    {
      str = "0.0.0";
    }
    appVersion = str;
    return str;
  }
  
  public static int getBuildNumber(String paramString)
  {
    int i = buildNum;
    if (-1 != i) {
      return i;
    }
    int j = 0;
    i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(DOT);
      i = j;
      if (paramString.length == 4) {
        try
        {
          i = Integer.parseInt(paramString[3]);
        }
        catch (Exception paramString)
        {
          TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
          i = j;
        }
        catch (NumberFormatException paramString)
        {
          TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
          i = j;
        }
      }
    }
    buildNum = i;
    return i;
  }
  
  public static int getDefLevel(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    if (paramString.equals("msd")) {
      return 0;
    }
    if (paramString.equals("sd")) {
      return 1;
    }
    if (paramString.equals("hd")) {
      return 2;
    }
    if (paramString.equals("shd")) {
      return 3;
    }
    if (paramString.equals("fhd")) {
      return 4;
    }
    if (paramString.equals("uhd")) {
      return 5;
    }
    return 6;
  }
  
  public static float getDensity(Context paramContext)
  {
    float f = sDensity;
    if (f != 0.0F) {
      return f;
    }
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      sDensity = Math.round(localDisplayMetrics.density * 100.0F) / 100.0F;
      sWidth = Math.max(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramContext);
    }
    return sDensity;
  }
  
  public static boolean getMapValueBool(Map<String, Object> paramMap, String paramString, boolean paramBoolean)
  {
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramBoolean = ((Boolean)paramMap).booleanValue();
    }
    return paramBoolean;
  }
  
  public static float getMapValueFloat(Map<String, Object> paramMap, String paramString, float paramFloat)
  {
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramFloat = ((Float)paramMap).floatValue();
    }
    return paramFloat;
  }
  
  public static int getMapValueInteger(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramInt = ((Integer)paramMap).intValue();
    }
    return paramInt;
  }
  
  public static long getMapValueLong(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramLong = ((Long)paramMap).longValue();
    }
    return paramLong;
  }
  
  public static Object getMapValueObject(Map<String, Object> paramMap, String paramString)
  {
    if (paramMap == null) {
      return null;
    }
    return paramMap.get(paramString);
  }
  
  public static String getMapValueString(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    paramMap = paramMap.get(paramString1);
    if (paramMap != null) {
      paramString2 = (String)paramMap;
    }
    return paramString2;
  }
  
  public static String getMd5(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
        StringBuilder localStringBuilder = new StringBuilder(40);
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          int k = paramString[i] & 0xFF;
          if (k >> 4 == 0)
          {
            localStringBuilder.append("0");
            localStringBuilder.append(Integer.toHexString(k));
          }
          else
          {
            localStringBuilder.append(Integer.toHexString(k));
          }
        }
        else
        {
          paramString = localStringBuilder.toString();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString.toString());
        return null;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static int getTextureFromBitmap(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_2
    //   9: aload 5
    //   11: astore_3
    //   12: aload_1
    //   13: ldc_w 404
    //   16: invokevirtual 205	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +21 -> 40
    //   22: aload 4
    //   24: astore_2
    //   25: aload 5
    //   27: astore_3
    //   28: new 406	java/io/FileInputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 407	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: goto +18 -> 55
    //   40: aload 4
    //   42: astore_2
    //   43: aload 5
    //   45: astore_3
    //   46: aload_0
    //   47: invokevirtual 142	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   50: aload_1
    //   51: invokevirtual 158	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_0
    //   55: aload_0
    //   56: astore_2
    //   57: aload_0
    //   58: astore_3
    //   59: aload_0
    //   60: invokestatic 413	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   63: astore_1
    //   64: aload_0
    //   65: ifnull +17 -> 82
    //   68: aload_0
    //   69: invokevirtual 169	java/io/InputStream:close	()V
    //   72: goto +10 -> 82
    //   75: astore_0
    //   76: ldc 11
    //   78: aload_0
    //   79: invokestatic 102	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   82: iconst_1
    //   83: newarray int
    //   85: astore_0
    //   86: iconst_1
    //   87: aload_0
    //   88: iconst_0
    //   89: invokestatic 419	android/opengl/GLES20:glGenTextures	(I[II)V
    //   92: aload_0
    //   93: iconst_0
    //   94: iaload
    //   95: ifne +13 -> 108
    //   98: ldc 11
    //   100: ldc_w 421
    //   103: invokestatic 240	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: iconst_0
    //   107: ireturn
    //   108: aload_1
    //   109: ifnonnull +19 -> 128
    //   112: iconst_1
    //   113: aload_0
    //   114: iconst_0
    //   115: invokestatic 424	android/opengl/GLES20:glDeleteTextures	(I[II)V
    //   118: ldc 11
    //   120: ldc_w 421
    //   123: invokestatic 240	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iconst_0
    //   127: ireturn
    //   128: sipush 3553
    //   131: aload_0
    //   132: iconst_0
    //   133: iaload
    //   134: invokestatic 428	android/opengl/GLES20:glBindTexture	(II)V
    //   137: sipush 3553
    //   140: sipush 10240
    //   143: ldc_w 429
    //   146: invokestatic 433	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   149: sipush 3553
    //   152: sipush 10241
    //   155: ldc_w 429
    //   158: invokestatic 433	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   161: sipush 3553
    //   164: sipush 10242
    //   167: ldc_w 434
    //   170: invokestatic 433	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   173: sipush 3553
    //   176: sipush 10243
    //   179: ldc_w 434
    //   182: invokestatic 433	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   185: sipush 3553
    //   188: iconst_0
    //   189: aload_1
    //   190: iconst_0
    //   191: invokestatic 440	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   194: aload_1
    //   195: invokevirtual 445	android/graphics/Bitmap:recycle	()V
    //   198: sipush 3553
    //   201: iconst_0
    //   202: invokestatic 428	android/opengl/GLES20:glBindTexture	(II)V
    //   205: aload_0
    //   206: iconst_0
    //   207: iaload
    //   208: ireturn
    //   209: astore_0
    //   210: aload_2
    //   211: ifnull +17 -> 228
    //   214: aload_2
    //   215: invokevirtual 169	java/io/InputStream:close	()V
    //   218: goto +10 -> 228
    //   221: astore_1
    //   222: ldc 11
    //   224: aload_1
    //   225: invokestatic 102	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_0
    //   229: athrow
    //   230: aload_3
    //   231: ifnull +16 -> 247
    //   234: aload_3
    //   235: invokevirtual 169	java/io/InputStream:close	()V
    //   238: iconst_0
    //   239: ireturn
    //   240: astore_0
    //   241: ldc 11
    //   243: aload_0
    //   244: invokestatic 102	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_0
    //   250: goto -20 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramContext	Context
    //   0	253	1	paramString	String
    //   8	207	2	localObject1	Object
    //   11	224	3	localObject2	Object
    //   4	37	4	localObject3	Object
    //   1	43	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   68	72	75	java/io/IOException
    //   12	22	209	finally
    //   28	37	209	finally
    //   46	55	209	finally
    //   59	64	209	finally
    //   214	218	221	java/io/IOException
    //   234	238	240	java/io/IOException
    //   12	22	249	java/lang/Throwable
    //   28	37	249	java/lang/Throwable
    //   46	55	249	java/lang/Throwable
    //   59	64	249	java/lang/Throwable
  }
  
  public static int getsWidth(Context paramContext)
  {
    int i = sWidth;
    if (i != 0) {
      return i;
    }
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      sDensity = Math.round(localDisplayMetrics.density * 100.0F) / 100.0F;
      sWidth = Math.max(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramContext);
    }
    return sWidth;
  }
  
  /* Error */
  public static byte[] gzipDeCompress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +349 -> 350
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 452	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 454	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore_0
    //   20: new 456	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 457	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore_2
    //   28: new 459	java/util/zip/GZIPInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 462	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore 6
    //   38: aload_0
    //   39: astore 4
    //   41: aload 6
    //   43: astore 5
    //   45: aload_2
    //   46: astore_3
    //   47: sipush 8192
    //   50: newarray byte
    //   52: astore 7
    //   54: aload_0
    //   55: astore 4
    //   57: aload 6
    //   59: astore 5
    //   61: aload_2
    //   62: astore_3
    //   63: aload 6
    //   65: aload 7
    //   67: iconst_0
    //   68: sipush 8192
    //   71: invokevirtual 465	java/util/zip/GZIPInputStream:read	([BII)I
    //   74: istore_1
    //   75: iload_1
    //   76: iconst_m1
    //   77: if_icmpeq +23 -> 100
    //   80: aload_0
    //   81: astore 4
    //   83: aload 6
    //   85: astore 5
    //   87: aload_2
    //   88: astore_3
    //   89: aload_2
    //   90: aload 7
    //   92: iconst_0
    //   93: iload_1
    //   94: invokevirtual 466	java/io/ByteArrayOutputStream:write	([BII)V
    //   97: goto -43 -> 54
    //   100: aload_0
    //   101: astore 4
    //   103: aload 6
    //   105: astore 5
    //   107: aload_2
    //   108: astore_3
    //   109: aload_2
    //   110: invokevirtual 470	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: astore 7
    //   115: aload_0
    //   116: invokevirtual 471	java/io/ByteArrayInputStream:close	()V
    //   119: aload_2
    //   120: invokevirtual 472	java/io/ByteArrayOutputStream:close	()V
    //   123: aload 6
    //   125: invokevirtual 473	java/util/zip/GZIPInputStream:close	()V
    //   128: aload 7
    //   130: areturn
    //   131: astore_3
    //   132: aconst_null
    //   133: astore 5
    //   135: aload_0
    //   136: astore 4
    //   138: aload 5
    //   140: astore_0
    //   141: goto +178 -> 319
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_0
    //   147: astore 4
    //   149: aload_3
    //   150: astore_0
    //   151: aload_2
    //   152: astore_3
    //   153: goto +75 -> 228
    //   156: aconst_null
    //   157: astore_3
    //   158: aload_0
    //   159: astore 7
    //   161: aload_3
    //   162: astore_0
    //   163: goto +101 -> 264
    //   166: astore 5
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_2
    //   171: astore_3
    //   172: aload_0
    //   173: astore 4
    //   175: aload_3
    //   176: astore_0
    //   177: aload 5
    //   179: astore_3
    //   180: goto +139 -> 319
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: astore_2
    //   187: aload_0
    //   188: astore 4
    //   190: aload_2
    //   191: astore_0
    //   192: goto +36 -> 228
    //   195: aconst_null
    //   196: astore_2
    //   197: aload_2
    //   198: astore_3
    //   199: aload_0
    //   200: astore 7
    //   202: aload_3
    //   203: astore_0
    //   204: goto +60 -> 264
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_2
    //   210: aload_2
    //   211: astore 4
    //   213: aload 4
    //   215: astore_0
    //   216: goto +103 -> 319
    //   219: aconst_null
    //   220: astore_3
    //   221: aload_3
    //   222: astore_2
    //   223: aload_2
    //   224: astore_0
    //   225: aload_2
    //   226: astore 4
    //   228: aload 4
    //   230: ifnull +8 -> 238
    //   233: aload 4
    //   235: invokevirtual 471	java/io/ByteArrayInputStream:close	()V
    //   238: aload_3
    //   239: ifnull +7 -> 246
    //   242: aload_3
    //   243: invokevirtual 472	java/io/ByteArrayOutputStream:close	()V
    //   246: aload_0
    //   247: ifnull +7 -> 254
    //   250: aload_0
    //   251: invokevirtual 473	java/util/zip/GZIPInputStream:close	()V
    //   254: aconst_null
    //   255: areturn
    //   256: aconst_null
    //   257: astore_2
    //   258: aload_2
    //   259: astore 7
    //   261: aload 7
    //   263: astore_0
    //   264: aload 7
    //   266: astore 4
    //   268: aload_0
    //   269: astore 5
    //   271: aload_2
    //   272: astore_3
    //   273: aload_2
    //   274: invokevirtual 470	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   277: astore 6
    //   279: aload 7
    //   281: ifnull +8 -> 289
    //   284: aload 7
    //   286: invokevirtual 471	java/io/ByteArrayInputStream:close	()V
    //   289: aload_2
    //   290: ifnull +7 -> 297
    //   293: aload_2
    //   294: invokevirtual 472	java/io/ByteArrayOutputStream:close	()V
    //   297: aload_0
    //   298: ifnull +10 -> 308
    //   301: aload_0
    //   302: invokevirtual 473	java/util/zip/GZIPInputStream:close	()V
    //   305: aload 6
    //   307: areturn
    //   308: aload 6
    //   310: areturn
    //   311: astore_0
    //   312: aload_3
    //   313: astore_2
    //   314: aload_0
    //   315: astore_3
    //   316: aload 5
    //   318: astore_0
    //   319: aload 4
    //   321: ifnull +8 -> 329
    //   324: aload 4
    //   326: invokevirtual 471	java/io/ByteArrayInputStream:close	()V
    //   329: aload_2
    //   330: ifnull +7 -> 337
    //   333: aload_2
    //   334: invokevirtual 472	java/io/ByteArrayOutputStream:close	()V
    //   337: aload_0
    //   338: ifnull +10 -> 348
    //   341: aload_0
    //   342: invokevirtual 473	java/util/zip/GZIPInputStream:close	()V
    //   345: goto +3 -> 348
    //   348: aload_3
    //   349: athrow
    //   350: aconst_null
    //   351: areturn
    //   352: astore_0
    //   353: goto -97 -> 256
    //   356: astore_0
    //   357: goto -138 -> 219
    //   360: astore_2
    //   361: goto -166 -> 195
    //   364: astore_2
    //   365: goto -182 -> 183
    //   368: astore_3
    //   369: goto -213 -> 156
    //   372: astore_3
    //   373: goto -229 -> 144
    //   376: astore_3
    //   377: aload_0
    //   378: astore 7
    //   380: aload 6
    //   382: astore_0
    //   383: goto -119 -> 264
    //   386: astore_3
    //   387: aload_0
    //   388: astore 4
    //   390: aload 6
    //   392: astore_0
    //   393: aload_2
    //   394: astore_3
    //   395: goto -167 -> 228
    //   398: astore_0
    //   399: aconst_null
    //   400: areturn
    //   401: astore_0
    //   402: aconst_null
    //   403: areturn
    //   404: astore_0
    //   405: aconst_null
    //   406: areturn
    //   407: astore_0
    //   408: aconst_null
    //   409: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramArrayOfByte	byte[]
    //   74	20	1	i	int
    //   27	307	2	localObject1	Object
    //   360	1	2	localEOFException1	java.io.EOFException
    //   364	30	2	localIOException1	java.io.IOException
    //   46	63	3	localObject2	Object
    //   131	1	3	localObject3	Object
    //   145	58	3	localObject4	Object
    //   207	1	3	localObject5	Object
    //   220	129	3	localObject6	Object
    //   368	1	3	localEOFException2	java.io.EOFException
    //   372	1	3	localIOException2	java.io.IOException
    //   376	1	3	localEOFException3	java.io.EOFException
    //   386	1	3	localIOException3	java.io.IOException
    //   394	1	3	localIOException4	java.io.IOException
    //   39	350	4	localObject7	Object
    //   43	96	5	localObject8	Object
    //   166	12	5	localObject9	Object
    //   269	48	5	arrayOfByte	byte[]
    //   36	355	6	localObject10	Object
    //   52	327	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   28	38	131	finally
    //   20	28	166	finally
    //   11	20	207	finally
    //   47	54	311	finally
    //   63	75	311	finally
    //   89	97	311	finally
    //   109	115	311	finally
    //   273	279	311	finally
    //   11	20	352	java/io/EOFException
    //   11	20	356	java/io/IOException
    //   20	28	360	java/io/EOFException
    //   20	28	364	java/io/IOException
    //   28	38	368	java/io/EOFException
    //   28	38	372	java/io/IOException
    //   47	54	376	java/io/EOFException
    //   63	75	376	java/io/EOFException
    //   89	97	376	java/io/EOFException
    //   109	115	376	java/io/EOFException
    //   47	54	386	java/io/IOException
    //   63	75	386	java/io/IOException
    //   89	97	386	java/io/IOException
    //   109	115	386	java/io/IOException
    //   115	128	398	java/io/IOException
    //   233	238	401	java/io/IOException
    //   242	246	401	java/io/IOException
    //   250	254	401	java/io/IOException
    //   284	289	404	java/io/IOException
    //   293	297	404	java/io/IOException
    //   301	305	404	java/io/IOException
    //   324	329	407	java/io/IOException
    //   333	337	407	java/io/IOException
    //   341	345	407	java/io/IOException
  }
  
  public static void invokeSetterMethod(Object paramObject1, String paramString, Class<?> paramClass, Object paramObject2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set");
      ((StringBuilder)localObject).append(Character.toUpperCase(paramString.charAt(0)));
      String str = ((StringBuilder)localObject).toString();
      localObject = str;
      if (paramString.length() > 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramString.substring(1));
        localObject = ((StringBuilder)localObject).toString();
      }
      paramObject1.getClass().getDeclaredMethod((String)localObject, new Class[] { paramClass }).invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (Exception paramObject1)
    {
      paramString = new StringBuilder();
      paramString.append("invokeSetterMethod error = ");
      paramString.append(paramObject1.toString());
      TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString.toString());
    }
  }
  
  public static boolean isAllowBySample(int paramInt)
  {
    boolean bool = false;
    if ((paramInt >= 0) && (paramInt <= 100))
    {
      if (paramInt == 0) {
        return false;
      }
      if (100 == paramInt) {
        return true;
      }
      int i = (int)(Math.random() * 100.0D);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isAllowBySample] randomNum = ");
      localStringBuilder.append(i);
      TVKLogUtil.i("TVKUtils[TVKUtils.java]", localStringBuilder.toString());
      if (i < paramInt) {
        bool = true;
      }
      return bool;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isAllowBySample] the sample is illegal, +sample = ");
    localStringBuilder.append(paramInt);
    TVKLogUtil.w("TVKUtils[TVKUtils.java]", localStringBuilder.toString());
    return false;
  }
  
  public static boolean isCryptoSchemeSupported(UUID paramUUID)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return MediaDrm.isCryptoSchemeSupported(paramUUID);
    }
    return false;
  }
  
  public static boolean isLocalHost(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool = paramString.contains("127.0.0.1");
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static boolean isUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = paramString.split(":");
      return paramString[0].matches("^((https|http|ftp|rtsp|mms)?)");
    }
    catch (PatternSyntaxException paramString) {}
    return false;
  }
  
  public static double optDouble(String paramString, double paramDouble)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        double d = Double.parseDouble(paramString);
        return d;
      }
      catch (NumberFormatException paramString)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
      }
    }
    return paramDouble;
  }
  
  public static float optFloat(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        float f = Float.parseFloat(paramString);
        return f;
      }
      catch (NumberFormatException paramString)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
      }
    }
    return paramInt;
  }
  
  public static int optInt(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
      }
    }
    return paramInt;
  }
  
  public static long optLong(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        long l = Long.parseLong(paramString);
        return l;
      }
      catch (NumberFormatException paramString)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
      }
    }
    return paramLong;
  }
  
  public static void sendMessage(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (paramHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      paramHandler.sendMessage(localMessage);
    }
  }
  
  public static void sendMessageDelay(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    if (paramHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      paramHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils
 * JD-Core Version:    0.7.0.1
 */