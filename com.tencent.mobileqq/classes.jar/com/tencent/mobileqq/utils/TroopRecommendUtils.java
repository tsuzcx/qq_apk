package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.HighlightTitle;

public class TroopRecommendUtils
{
  public static void a(AppInterface paramAppInterface, String paramString, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setRecommendGrayTipsLastInsertTime ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("TroopRecommendUtils", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramAppInterface != null) && (paramString != null))
    {
      localObject = paramAppInterface.getApp().getBaseContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_troop_recommend_graytips_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong("last_add_time", paramLong).commit();
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, List<oidb_0xe3b.HighlightTitle> paramList, int paramInt2, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a10 = a8\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
  }
  
  /* Error */
  public static void a(AppInterface paramAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 19	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 100
    //   17: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 33
    //   29: iconst_2
    //   30: aload_3
    //   31: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: ifnull +280 -> 318
    //   41: aload_1
    //   42: ifnull +276 -> 318
    //   45: aload_2
    //   46: ifnull +272 -> 318
    //   49: new 19	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   56: astore_3
    //   57: aload_3
    //   58: aload_0
    //   59: invokevirtual 47	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   62: invokevirtual 53	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   65: invokevirtual 104	android/content/Context:getFilesDir	()Ljava/io/File;
    //   68: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   71: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_3
    //   76: getstatic 113	java/io/File:separator	Ljava/lang/String;
    //   79: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_3
    //   84: ldc 115
    //   86: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: aload_1
    //   92: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_3
    //   97: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_0
    //   105: new 117	java/io/FileOutputStream
    //   108: dup
    //   109: new 106	java/io/File
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   120: astore_1
    //   121: aload_1
    //   122: aload_2
    //   123: invokevirtual 125	java/io/FileOutputStream:write	([B)V
    //   126: aload_1
    //   127: invokevirtual 128	java/io/FileOutputStream:flush	()V
    //   130: aload_1
    //   131: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   134: return
    //   135: astore_0
    //   136: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +179 -> 318
    //   142: new 19	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   149: astore_1
    //   150: aload_1
    //   151: ldc 133
    //   153: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: aload_0
    //   159: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc 33
    //   165: iconst_2
    //   166: aload_1
    //   167: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: return
    //   174: astore_2
    //   175: aload_1
    //   176: astore_0
    //   177: aload_2
    //   178: astore_1
    //   179: goto +88 -> 267
    //   182: astore_2
    //   183: goto +10 -> 193
    //   186: astore_1
    //   187: goto +80 -> 267
    //   190: astore_2
    //   191: aload_3
    //   192: astore_1
    //   193: aload_1
    //   194: astore_0
    //   195: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +42 -> 240
    //   201: aload_1
    //   202: astore_0
    //   203: new 19	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   210: astore_3
    //   211: aload_1
    //   212: astore_0
    //   213: aload_3
    //   214: ldc 138
    //   216: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_1
    //   221: astore_0
    //   222: aload_3
    //   223: aload_2
    //   224: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_1
    //   229: astore_0
    //   230: ldc 33
    //   232: iconst_2
    //   233: aload_3
    //   234: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_1
    //   241: ifnull +77 -> 318
    //   244: aload_1
    //   245: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   248: return
    //   249: astore_0
    //   250: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +65 -> 318
    //   256: new 19	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   263: astore_1
    //   264: goto -114 -> 150
    //   267: aload_0
    //   268: ifnull +48 -> 316
    //   271: aload_0
    //   272: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   275: goto +41 -> 316
    //   278: astore_0
    //   279: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +34 -> 316
    //   285: new 19	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   292: astore_2
    //   293: aload_2
    //   294: ldc 133
    //   296: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_2
    //   301: aload_0
    //   302: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: ldc 33
    //   308: iconst_2
    //   309: aload_2
    //   310: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload_1
    //   317: athrow
    //   318: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramAppInterface	AppInterface
    //   0	319	1	paramString	String
    //   0	319	2	paramArrayOfByte	byte[]
    //   13	221	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   130	134	135	java/lang/Exception
    //   121	130	174	finally
    //   121	130	182	java/lang/Exception
    //   105	121	186	finally
    //   195	201	186	finally
    //   203	211	186	finally
    //   213	220	186	finally
    //   222	228	186	finally
    //   230	240	186	finally
    //   105	121	190	java/lang/Exception
    //   244	248	249	java/lang/Exception
    //   271	275	278	java/lang/Exception
  }
  
  /* Error */
  public static byte[] a(AppInterface paramAppInterface, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 5
    //   14: aload 7
    //   16: astore_2
    //   17: aload_0
    //   18: ifnull +354 -> 372
    //   21: aload 7
    //   23: astore_2
    //   24: aload_1
    //   25: ifnull +347 -> 372
    //   28: new 19	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   35: astore_2
    //   36: aload_2
    //   37: aload_0
    //   38: invokevirtual 47	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   41: invokevirtual 53	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   44: invokevirtual 104	android/content/Context:getFilesDir	()Ljava/io/File;
    //   47: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   50: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: getstatic 113	java/io/File:separator	Ljava/lang/String;
    //   58: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: ldc 115
    //   65: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: aload_1
    //   71: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_2
    //   76: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore_1
    //   80: aload 6
    //   82: astore_0
    //   83: new 106	java/io/File
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore_1
    //   92: aload 6
    //   94: astore_0
    //   95: aload_1
    //   96: invokevirtual 142	java/io/File:exists	()Z
    //   99: ifeq +52 -> 151
    //   102: aload 6
    //   104: astore_0
    //   105: new 144	java/io/FileInputStream
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   113: astore_1
    //   114: aload 5
    //   116: astore_0
    //   117: aload_1
    //   118: invokevirtual 149	java/io/FileInputStream:available	()I
    //   121: newarray byte
    //   123: astore_2
    //   124: aload_2
    //   125: astore_0
    //   126: aload_1
    //   127: aload_2
    //   128: invokevirtual 153	java/io/FileInputStream:read	([B)I
    //   131: pop
    //   132: aload_2
    //   133: astore_0
    //   134: goto +21 -> 155
    //   137: astore_2
    //   138: aload_1
    //   139: astore_0
    //   140: aload_2
    //   141: astore_1
    //   142: goto +179 -> 321
    //   145: astore_3
    //   146: aload_0
    //   147: astore_2
    //   148: goto +71 -> 219
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_3
    //   154: astore_0
    //   155: aload_0
    //   156: astore_2
    //   157: aload_1
    //   158: ifnull +214 -> 372
    //   161: aload_1
    //   162: invokevirtual 154	java/io/FileInputStream:close	()V
    //   165: aload_0
    //   166: areturn
    //   167: astore_1
    //   168: aload_0
    //   169: astore_2
    //   170: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +199 -> 372
    //   176: new 19	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   183: astore_2
    //   184: aload_2
    //   185: ldc 156
    //   187: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_2
    //   192: aload_1
    //   193: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: ldc 33
    //   199: iconst_2
    //   200: aload_2
    //   201: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_0
    //   208: areturn
    //   209: astore_1
    //   210: goto +111 -> 321
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_2
    //   216: aload 4
    //   218: astore_1
    //   219: aload_1
    //   220: astore_0
    //   221: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +46 -> 270
    //   227: aload_1
    //   228: astore_0
    //   229: new 19	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   236: astore 4
    //   238: aload_1
    //   239: astore_0
    //   240: aload 4
    //   242: ldc 156
    //   244: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_1
    //   249: astore_0
    //   250: aload 4
    //   252: aload_3
    //   253: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_1
    //   258: astore_0
    //   259: ldc 33
    //   261: iconst_2
    //   262: aload 4
    //   264: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_1
    //   271: ifnull +48 -> 319
    //   274: aload_1
    //   275: invokevirtual 154	java/io/FileInputStream:close	()V
    //   278: goto +41 -> 319
    //   281: astore_0
    //   282: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +34 -> 319
    //   288: new 19	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   295: astore_1
    //   296: aload_1
    //   297: ldc 156
    //   299: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_1
    //   304: aload_0
    //   305: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: ldc 33
    //   311: iconst_2
    //   312: aload_1
    //   313: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload_2
    //   320: areturn
    //   321: aload_0
    //   322: ifnull +48 -> 370
    //   325: aload_0
    //   326: invokevirtual 154	java/io/FileInputStream:close	()V
    //   329: goto +41 -> 370
    //   332: astore_0
    //   333: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +34 -> 370
    //   339: new 19	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   346: astore_2
    //   347: aload_2
    //   348: ldc 156
    //   350: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload_2
    //   355: aload_0
    //   356: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: ldc 33
    //   362: iconst_2
    //   363: aload_2
    //   364: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_1
    //   371: athrow
    //   372: aload_2
    //   373: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramAppInterface	AppInterface
    //   0	374	1	paramString	String
    //   16	117	2	localObject1	Object
    //   137	4	2	localObject2	Object
    //   147	226	2	localObject3	Object
    //   1	1	3	localObject4	Object
    //   145	9	3	localException1	java.lang.Exception
    //   213	40	3	localException2	java.lang.Exception
    //   6	257	4	localStringBuilder	StringBuilder
    //   12	103	5	localObject5	Object
    //   3	100	6	localObject6	Object
    //   9	13	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   117	124	137	finally
    //   126	132	137	finally
    //   117	124	145	java/lang/Exception
    //   126	132	145	java/lang/Exception
    //   161	165	167	java/lang/Exception
    //   83	92	209	finally
    //   95	102	209	finally
    //   105	114	209	finally
    //   221	227	209	finally
    //   229	238	209	finally
    //   240	248	209	finally
    //   250	257	209	finally
    //   259	270	209	finally
    //   83	92	213	java/lang/Exception
    //   95	102	213	java/lang/Exception
    //   105	114	213	java/lang/Exception
    //   274	278	281	java/lang/Exception
    //   325	329	332	java/lang/Exception
  }
  
  public static long b(AppInterface paramAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramAppInterface != null)
    {
      l1 = l2;
      if (paramString != null)
      {
        Context localContext = paramAppInterface.getApp().getBaseContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_troop_recommend_graytips_");
        localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
        localStringBuilder.append("_");
        localStringBuilder.append(paramString);
        l1 = localContext.getSharedPreferences(localStringBuilder.toString(), 0).getLong("last_add_time", 0L);
      }
    }
    return l1;
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTroopRecommendGrayTipsReportTimestamp ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("TroopRecommendUtils", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramAppInterface != null) && (paramString != null))
    {
      localObject = paramAppInterface.getApp().getBaseContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_troop_recommend_graytips_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong("report_timestamp", paramLong).commit();
    }
  }
  
  public static long c(AppInterface paramAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramAppInterface != null)
    {
      l1 = l2;
      if (paramString != null)
      {
        Context localContext = paramAppInterface.getApp().getBaseContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_troop_recommend_graytips_");
        localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
        localStringBuilder.append("_");
        localStringBuilder.append(paramString);
        l1 = localContext.getSharedPreferences(localStringBuilder.toString(), 0).getLong("old_last_add_time", 0L);
      }
    }
    return l1;
  }
  
  public static void c(AppInterface paramAppInterface, String paramString, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setOldRecommendGrayTipsLastInsertTime ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("TroopRecommendUtils", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramAppInterface != null) && (paramString != null))
    {
      localObject = paramAppInterface.getApp().getBaseContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_troop_recommend_graytips_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong("old_last_add_time", paramLong).commit();
    }
  }
  
  public static long d(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface != null) && (paramString != null))
    {
      Context localContext = paramAppInterface.getApp().getBaseContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_troop_recommend_graytips_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getLong("report_timestamp", -1L);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TroopRecommendUtils
 * JD-Core Version:    0.7.0.1
 */