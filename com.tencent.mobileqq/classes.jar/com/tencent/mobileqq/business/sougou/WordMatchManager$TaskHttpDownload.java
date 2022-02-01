package com.tencent.mobileqq.business.sougou;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WordMatchManager$TaskHttpDownload
  implements Runnable
{
  int a = 0;
  
  WordMatchManager$TaskHttpDownload(WordMatchManager paramWordMatchManager, int paramInt)
  {
    this.a = paramInt;
  }
  
  private HttpURLConnection a(int paramInt)
  {
    String str = this.this$0.b(paramInt);
    try
    {
      localObject = new URL(str);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject;
      label90:
      break label129;
    }
    try
    {
      localObject = (HttpURLConnection)((URL)localObject).openConnection();
      if (localObject == null) {
        return null;
      }
      ((HttpURLConnection)localObject).setConnectTimeout(30000);
      ((HttpURLConnection)localObject).setIfModifiedSince(this.this$0.c(paramInt));
      ((HttpURLConnection)localObject).setReadTimeout(30000);
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      if (((HttpURLConnection)localObject).getResponseCode() != 200)
      {
        paramInt = ((HttpURLConnection)localObject).getResponseCode();
        if (paramInt != 206) {
          return null;
        }
      }
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label90;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("connection IOException | url:");
      ((StringBuilder)localObject).append(str);
      QLog.d(".business.sougou.DicFileDownloader", 2, ((StringBuilder)localObject).toString());
    }
    return null;
    label129:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url is invaild | url:");
      ((StringBuilder)localObject).append(str);
      QLog.d(".business.sougou.DicFileDownloader", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 99	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +52 -> 55
    //   6: new 74	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 101
    //   17: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   26: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: ldc 106
    //   33: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: invokestatic 112	java/lang/System:currentTimeMillis	()J
    //   41: invokevirtual 115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 83
    //   47: iconst_4
    //   48: aload_3
    //   49: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: invokestatic 119	com/tencent/open/appcommon/Common:d	()Z
    //   58: ifne +6 -> 64
    //   61: goto +433 -> 494
    //   64: new 121	java/io/File
    //   67: dup
    //   68: getstatic 124	com/tencent/mobileqq/business/sougou/WordMatchManager:b	Ljava/lang/String;
    //   71: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore_3
    //   75: aload_3
    //   76: invokevirtual 128	java/io/File:exists	()Z
    //   79: ifne +8 -> 87
    //   82: aload_3
    //   83: invokevirtual 131	java/io/File:mkdir	()Z
    //   86: pop
    //   87: new 74	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   94: astore_3
    //   95: aload_3
    //   96: aload_0
    //   97: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   100: aload_0
    //   101: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   104: invokevirtual 133	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   107: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_3
    //   112: ldc 135
    //   114: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_3
    //   119: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore_3
    //   123: new 121	java/io/File
    //   126: dup
    //   127: aload_3
    //   128: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: astore 5
    //   133: aload 5
    //   135: invokevirtual 128	java/io/File:exists	()Z
    //   138: ifeq +108 -> 246
    //   141: aload 5
    //   143: invokevirtual 138	java/io/File:delete	()Z
    //   146: ifne +47 -> 193
    //   149: invokestatic 99	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   152: ifeq +342 -> 494
    //   155: new 74	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   162: astore 4
    //   164: aload 4
    //   166: ldc 140
    //   168: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 4
    //   174: aload_3
    //   175: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: ldc 83
    //   181: iconst_4
    //   182: aload 4
    //   184: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: goto +304 -> 494
    //   193: aload 5
    //   195: invokevirtual 143	java/io/File:createNewFile	()Z
    //   198: pop
    //   199: goto +47 -> 246
    //   202: invokestatic 99	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   205: ifeq +289 -> 494
    //   208: new 74	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   215: astore 4
    //   217: aload 4
    //   219: ldc 145
    //   221: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 4
    //   227: aload_3
    //   228: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: ldc 83
    //   234: iconst_4
    //   235: aload 4
    //   237: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: goto +251 -> 494
    //   246: invokestatic 151	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   249: invokestatic 156	com/tencent/mobileqq/troop/utils/TroopFileUtils:a	(Landroid/content/Context;)I
    //   252: iconst_2
    //   253: if_icmpeq +6 -> 259
    //   256: goto +238 -> 494
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   264: invokespecial 158	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	(I)Ljava/net/HttpURLConnection;
    //   267: astore 4
    //   269: aload 4
    //   271: ifnonnull +6 -> 277
    //   274: goto +220 -> 494
    //   277: aload 4
    //   279: invokevirtual 66	java/net/HttpURLConnection:getResponseCode	()I
    //   282: sipush 200
    //   285: if_icmpeq +6 -> 291
    //   288: goto +206 -> 494
    //   291: aload 4
    //   293: invokevirtual 162	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   296: astore 6
    //   298: new 164	java/io/FileOutputStream
    //   301: dup
    //   302: aload 5
    //   304: iconst_1
    //   305: invokespecial 167	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   308: astore 5
    //   310: sipush 4096
    //   313: newarray byte
    //   315: astore 7
    //   317: aload 6
    //   319: aload 7
    //   321: invokevirtual 173	java/io/InputStream:read	([B)I
    //   324: istore_1
    //   325: iload_1
    //   326: iconst_m1
    //   327: if_icmpeq +56 -> 383
    //   330: aload 5
    //   332: aload 7
    //   334: iconst_0
    //   335: iload_1
    //   336: invokevirtual 177	java/io/FileOutputStream:write	([BII)V
    //   339: goto -22 -> 317
    //   342: invokestatic 99	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   345: ifeq +38 -> 383
    //   348: new 74	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   355: astore 7
    //   357: aload 7
    //   359: ldc 179
    //   361: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 7
    //   367: aload_3
    //   368: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: ldc 83
    //   374: iconst_4
    //   375: aload 7
    //   377: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload 6
    //   385: invokevirtual 182	java/io/InputStream:close	()V
    //   388: aload 5
    //   390: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   393: goto +62 -> 455
    //   396: astore 7
    //   398: aload 6
    //   400: invokevirtual 182	java/io/InputStream:close	()V
    //   403: aload 5
    //   405: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   408: aload 7
    //   410: athrow
    //   411: invokestatic 99	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   414: ifeq +80 -> 494
    //   417: new 74	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   424: astore 5
    //   426: aload 5
    //   428: ldc 185
    //   430: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 5
    //   436: aload_3
    //   437: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: ldc 83
    //   443: iconst_4
    //   444: aload 5
    //   446: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: goto +42 -> 494
    //   455: aload_3
    //   456: aload_0
    //   457: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   460: aload_0
    //   461: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   464: invokevirtual 133	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   467: invokestatic 190	com/tencent/mobileqq/business/sougou/DictFileUtil:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   470: ifeq +24 -> 494
    //   473: aload_0
    //   474: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   477: aload_0
    //   478: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   481: aload 4
    //   483: invokevirtual 193	java/net/HttpURLConnection:getLastModified	()J
    //   486: invokevirtual 196	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(IJ)V
    //   489: iconst_1
    //   490: istore_2
    //   491: goto +5 -> 496
    //   494: iconst_0
    //   495: istore_2
    //   496: invokestatic 99	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   499: ifeq +65 -> 564
    //   502: new 74	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   509: astore_3
    //   510: aload_3
    //   511: ldc 198
    //   513: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload_3
    //   518: aload_0
    //   519: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   522: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload_3
    //   527: ldc 200
    //   529: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload_3
    //   534: iload_2
    //   535: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload_3
    //   540: ldc 106
    //   542: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload_3
    //   547: invokestatic 112	java/lang/System:currentTimeMillis	()J
    //   550: invokevirtual 115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: ldc 83
    //   556: iconst_4
    //   557: aload_3
    //   558: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: iload_2
    //   565: ifeq +274 -> 839
    //   568: aload_0
    //   569: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   572: istore_1
    //   573: aconst_null
    //   574: astore 4
    //   576: iload_1
    //   577: iconst_1
    //   578: if_icmpne +36 -> 614
    //   581: aload_0
    //   582: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   585: getfield 207	com/tencent/mobileqq/business/sougou/WordMatchManager:j	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;
    //   588: astore_3
    //   589: aload_0
    //   590: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   593: astore 4
    //   595: aload 4
    //   597: iconst_1
    //   598: putfield 211	com/tencent/mobileqq/business/sougou/WordMatchManager:m	Z
    //   601: aload 4
    //   603: getfield 207	com/tencent/mobileqq/business/sougou/WordMatchManager:j	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;
    //   606: getfield 215	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:d	Ljava/lang/String;
    //   609: astore 4
    //   611: goto +40 -> 651
    //   614: iload_1
    //   615: iconst_2
    //   616: if_icmpne +33 -> 649
    //   619: aload_0
    //   620: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   623: astore_3
    //   624: aload_3
    //   625: iconst_1
    //   626: putfield 211	com/tencent/mobileqq/business/sougou/WordMatchManager:m	Z
    //   629: aload_3
    //   630: getfield 218	com/tencent/mobileqq/business/sougou/WordMatchManager:k	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;
    //   633: getfield 215	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:d	Ljava/lang/String;
    //   636: astore 4
    //   638: aload_0
    //   639: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   642: getfield 218	com/tencent/mobileqq/business/sougou/WordMatchManager:k	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;
    //   645: astore_3
    //   646: goto +5 -> 651
    //   649: aconst_null
    //   650: astore_3
    //   651: aload 4
    //   653: invokestatic 224	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   656: ifne +159 -> 815
    //   659: aload_0
    //   660: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   663: istore_1
    //   664: iload_1
    //   665: iconst_2
    //   666: if_icmpeq +8 -> 674
    //   669: iload_1
    //   670: iconst_1
    //   671: if_icmpne +144 -> 815
    //   674: aload 4
    //   676: invokevirtual 229	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   679: astore 4
    //   681: aload_0
    //   682: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   685: astore 5
    //   687: new 74	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   694: astore 6
    //   696: aload 6
    //   698: aload_0
    //   699: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   702: aload_0
    //   703: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   706: invokevirtual 133	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   709: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: aload 6
    //   715: ldc 135
    //   717: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload 5
    //   723: aload 6
    //   725: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: invokestatic 232	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager;Ljava/lang/String;)Ljava/lang/String;
    //   731: astore 5
    //   733: aload 5
    //   735: invokestatic 224	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   738: ifne +16 -> 754
    //   741: aload 5
    //   743: invokevirtual 229	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   746: aload 4
    //   748: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   751: ifne +64 -> 815
    //   754: aload_0
    //   755: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   758: iconst_0
    //   759: invokevirtual 239	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Z)V
    //   762: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   765: ifeq +49 -> 814
    //   768: new 74	java/lang/StringBuilder
    //   771: dup
    //   772: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   775: astore_3
    //   776: aload_3
    //   777: ldc 241
    //   779: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: pop
    //   783: aload_3
    //   784: aload 5
    //   786: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload_3
    //   791: ldc 243
    //   793: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload_3
    //   798: aload 4
    //   800: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: ldc 83
    //   806: iconst_2
    //   807: aload_3
    //   808: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: return
    //   815: aload_3
    //   816: ifnull +11 -> 827
    //   819: aload_0
    //   820: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   823: aload_3
    //   824: invokevirtual 246	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;)V
    //   827: aload_0
    //   828: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   831: aload_0
    //   832: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   835: invokevirtual 249	com/tencent/mobileqq/business/sougou/WordMatchManager:h	(I)V
    //   838: return
    //   839: aload_0
    //   840: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   843: iload_2
    //   844: invokevirtual 239	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Z)V
    //   847: return
    //   848: astore 4
    //   850: goto -648 -> 202
    //   853: astore 5
    //   855: goto -400 -> 455
    //   858: astore 5
    //   860: goto -449 -> 411
    //   863: astore 7
    //   865: goto -523 -> 342
    //   868: astore 6
    //   870: goto -482 -> 388
    //   873: astore 6
    //   875: goto -472 -> 403
    //   878: astore 5
    //   880: goto -472 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	883	0	this	TaskHttpDownload
    //   324	348	1	i	int
    //   490	354	2	bool	boolean
    //   13	811	3	localObject1	Object
    //   162	637	4	localObject2	Object
    //   848	1	4	localIOException1	IOException
    //   131	654	5	localObject3	Object
    //   853	1	5	localIOException2	IOException
    //   858	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   878	1	5	localIOException3	IOException
    //   296	428	6	localObject4	Object
    //   868	1	6	localIOException4	IOException
    //   873	1	6	localIOException5	IOException
    //   315	61	7	localObject5	Object
    //   396	13	7	localObject6	Object
    //   863	1	7	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   310	317	396	finally
    //   317	325	396	finally
    //   330	339	396	finally
    //   342	383	396	finally
    //   193	199	848	java/io/IOException
    //   277	288	853	java/io/IOException
    //   291	298	853	java/io/IOException
    //   298	310	853	java/io/IOException
    //   388	393	853	java/io/IOException
    //   408	411	853	java/io/IOException
    //   411	452	853	java/io/IOException
    //   298	310	858	java/io/FileNotFoundException
    //   330	339	863	java/io/IOException
    //   383	388	868	java/io/IOException
    //   398	403	873	java/io/IOException
    //   403	408	878	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */