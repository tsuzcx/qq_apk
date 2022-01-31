package com.tencent.mobileqq.earlydownload.handler;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

public abstract class EarlyHandler
{
  static final String jdField_a_of_type_JavaLangString = AppConstants.aK + "pddata/prd/early";
  public QQAppInterface a;
  private XmlData jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  protected ArrayList a;
  protected boolean a;
  protected String b;
  protected boolean b;
  protected boolean c;
  
  public EarlyHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public final XmlData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData == null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData = EarlyDataFactory.a(a());
    }
    return this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  }
  
  public abstract Class a();
  
  public abstract String a();
  
  public GetResourceReqInfo a()
  {
    Object localObject = null;
    XmlData localXmlData = a();
    if ((localXmlData != null) && (localXmlData.strPkgName != null) && (localXmlData.strPkgName.length() > 0))
    {
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = localXmlData.strPkgName;
      ((GetResourceReqInfo)localObject).uiCurVer = b();
      ((GetResourceReqInfo)localObject).sResType = 512;
      ((GetResourceReqInfo)localObject).sLanType = 1;
      ((GetResourceReqInfo)localObject).sReqType = 1;
    }
    while (!QLog.isColorLevel()) {
      return localObject;
    }
    localObject = new StringBuffer("getResourceReqInfo() return null.");
    if (localXmlData == null) {
      ((StringBuffer)localObject).append("data==null");
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
      return null;
      ((StringBuffer)localObject).append("resName=" + localXmlData.strResName);
      ((StringBuffer)localObject).append(".pkgName=" + localXmlData.strPkgName);
    }
  }
  
  public GetResourceReqInfoV2 a()
  {
    Object localObject = null;
    XmlData localXmlData = a();
    if ((localXmlData != null) && (localXmlData.strPkgName != null) && (localXmlData.strPkgName.length() > 0))
    {
      localObject = new GetResourceReqInfoV2();
      ((GetResourceReqInfoV2)localObject).cState = 0;
      ((GetResourceReqInfoV2)localObject).sLanType = 1;
      ((GetResourceReqInfoV2)localObject).sResSubType = 1;
      ((GetResourceReqInfoV2)localObject).strPkgName = localXmlData.strPkgName;
      if (g())
      {
        l = 0L;
        ((GetResourceReqInfoV2)localObject).uiCurVer = l;
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return localObject;
        long l = b();
      }
    }
    localObject = new StringBuffer("getResourceReqInfoV2() return null.");
    if (localXmlData == null) {
      ((StringBuffer)localObject).append("data==null");
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
      return null;
      ((StringBuffer)localObject).append("this.strResName=[" + this.jdField_b_of_type_JavaLangString);
      ((StringBuffer)localObject).append("], resName=[" + localXmlData.strResName);
      ((StringBuffer)localObject).append("], pkgName=[" + localXmlData.strPkgName);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      XmlData localXmlData = a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(localXmlData, paramLong1, paramLong2);
      }
    }
  }
  
  public void a(EarlyDownloadManager.EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    if (paramEarlyDownLoadListener != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramEarlyDownLoadListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramEarlyDownLoadListener);
      }
    }
  }
  
  /* Error */
  public void a(XmlData paramXmlData)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +18 -> 19
    //   4: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 111
    //   12: iconst_2
    //   13: ldc 191
    //   15: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: return
    //   19: aload_0
    //   20: invokevirtual 58	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;
    //   23: astore 10
    //   25: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +82 -> 110
    //   31: ldc 111
    //   33: iconst_2
    //   34: new 16	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   41: ldc 196
    //   43: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: getfield 121	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   50: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 198
    //   55: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: getfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   62: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 207
    //   67: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload 10
    //   72: getfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   75: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: ldc 209
    //   80: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 10
    //   85: getfield 212	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   88: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: ldc 214
    //   93: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 10
    //   98: getfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   101: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aconst_null
    //   111: astore 8
    //   113: aconst_null
    //   114: astore 6
    //   116: aconst_null
    //   117: astore 9
    //   119: new 219	java/io/File
    //   122: dup
    //   123: aload_0
    //   124: invokevirtual 221	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	()Ljava/lang/String;
    //   127: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   130: astore 7
    //   132: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +45 -> 180
    //   138: ldc 111
    //   140: iconst_2
    //   141: new 16	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   148: ldc 224
    //   150: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 7
    //   155: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   158: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 229
    //   163: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 7
    //   168: invokevirtual 232	java/io/File:exists	()Z
    //   171: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   174: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload 8
    //   182: astore 5
    //   184: aload 7
    //   186: invokevirtual 232	java/io/File:exists	()Z
    //   189: ifeq +89 -> 278
    //   192: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +32 -> 227
    //   198: ldc 111
    //   200: iconst_2
    //   201: new 16	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   208: ldc 237
    //   210: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 7
    //   215: invokevirtual 240	java/io/File:length	()J
    //   218: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload 7
    //   229: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   232: invokestatic 249	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   235: invokestatic 255	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   238: astore 4
    //   240: aload 4
    //   242: ifnull +734 -> 976
    //   245: aload_1
    //   246: getfield 258	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   249: ifnull +727 -> 976
    //   252: aload 4
    //   254: invokevirtual 261	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   257: aload_1
    //   258: getfield 258	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   261: invokevirtual 261	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   264: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: ifeq +709 -> 976
    //   270: aload 7
    //   272: astore 5
    //   274: aload 4
    //   276: astore 6
    //   278: new 219	java/io/File
    //   281: dup
    //   282: aload_0
    //   283: invokevirtual 266	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d	()Ljava/lang/String;
    //   286: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore 8
    //   291: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +46 -> 340
    //   297: ldc 111
    //   299: iconst_2
    //   300: new 16	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 268
    //   310: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 8
    //   315: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   318: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc 229
    //   323: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 8
    //   328: invokevirtual 232	java/io/File:exists	()Z
    //   331: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   334: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload 5
    //   342: ifnonnull +925 -> 1267
    //   345: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +33 -> 381
    //   351: ldc 111
    //   353: iconst_2
    //   354: new 16	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 270
    //   364: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 8
    //   369: invokevirtual 240	java/io/File:length	()J
    //   372: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: new 219	java/io/File
    //   384: dup
    //   385: new 16	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   392: getstatic 24	com/tencent/mobileqq/app/AppConstants:aK	Ljava/lang/String;
    //   395: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w 272
    //   401: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_0
    //   405: getfield 41	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   408: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   417: astore 4
    //   419: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +46 -> 468
    //   425: ldc 111
    //   427: iconst_2
    //   428: new 16	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   435: ldc_w 274
    //   438: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 4
    //   443: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   446: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: ldc 229
    //   451: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload 4
    //   456: invokevirtual 232	java/io/File:exists	()Z
    //   459: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   462: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload 8
    //   470: invokevirtual 232	java/io/File:exists	()Z
    //   473: ifne +51 -> 524
    //   476: aload 4
    //   478: invokevirtual 232	java/io/File:exists	()Z
    //   481: ifeq +43 -> 524
    //   484: aload 4
    //   486: aload 8
    //   488: invokestatic 279	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   491: istore_2
    //   492: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +29 -> 524
    //   498: ldc 111
    //   500: iconst_2
    //   501: new 16	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   508: ldc_w 281
    //   511: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: iload_2
    //   515: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   518: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: aload 4
    //   526: invokevirtual 232	java/io/File:exists	()Z
    //   529: ifeq +41 -> 570
    //   532: aload 4
    //   534: invokevirtual 284	java/io/File:delete	()Z
    //   537: istore_2
    //   538: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq +29 -> 570
    //   544: ldc 111
    //   546: iconst_2
    //   547: new 16	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   554: ldc_w 286
    //   557: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: iload_2
    //   561: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   564: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 8
    //   572: invokevirtual 232	java/io/File:exists	()Z
    //   575: ifeq +692 -> 1267
    //   578: aload 8
    //   580: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   583: invokestatic 249	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   586: invokestatic 255	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   589: astore 4
    //   591: aload 4
    //   593: ifnull +668 -> 1261
    //   596: aload_1
    //   597: getfield 258	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   600: ifnull +661 -> 1261
    //   603: aload 4
    //   605: invokevirtual 261	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   608: aload_1
    //   609: getfield 258	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   612: invokevirtual 261	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   615: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   618: ifeq +643 -> 1261
    //   621: aload 8
    //   623: astore 4
    //   625: aload 4
    //   627: ifnonnull +993 -> 1620
    //   630: aload 10
    //   632: iconst_0
    //   633: putfield 289	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   636: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +32 -> 671
    //   642: ldc 111
    //   644: iconst_2
    //   645: new 16	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   652: ldc_w 291
    //   655: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_0
    //   659: getfield 41	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   662: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   671: aload 10
    //   673: iconst_1
    //   674: anewarray 65	java/lang/String
    //   677: dup
    //   678: iconst_0
    //   679: ldc_w 292
    //   682: aastore
    //   683: invokestatic 295	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   686: iconst_0
    //   687: istore_3
    //   688: aload_0
    //   689: invokevirtual 298	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:i	()Z
    //   692: ifne +582 -> 1274
    //   695: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   698: ifeq +32 -> 730
    //   701: ldc 111
    //   703: iconst_2
    //   704: new 16	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   711: ldc_w 300
    //   714: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload_0
    //   718: getfield 41	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   721: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: aload 10
    //   732: aload_1
    //   733: invokevirtual 303	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   736: aload 10
    //   738: iconst_1
    //   739: putfield 212	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   742: aload 10
    //   744: iconst_0
    //   745: anewarray 65	java/lang/String
    //   748: invokestatic 295	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   751: iload_3
    //   752: istore_2
    //   753: iload_2
    //   754: ifne -736 -> 18
    //   757: aload_0
    //   758: getfield 43	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   761: bipush 76
    //   763: invokevirtual 309	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   766: checkcast 311	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   769: aload 10
    //   771: invokevirtual 314	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   774: invokevirtual 316	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	(Ljava/lang/String;)V
    //   777: aload_0
    //   778: aload 10
    //   780: invokevirtual 318	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   783: return
    //   784: astore 4
    //   786: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   789: ifeq +32 -> 821
    //   792: ldc 111
    //   794: iconst_2
    //   795: iconst_2
    //   796: anewarray 4	java/lang/Object
    //   799: dup
    //   800: iconst_0
    //   801: ldc_w 320
    //   804: aastore
    //   805: dup
    //   806: iconst_1
    //   807: aload 4
    //   809: invokevirtual 323	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   812: aastore
    //   813: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   816: aload 4
    //   818: invokevirtual 329	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   821: aload 7
    //   823: invokestatic 334	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   826: astore 4
    //   828: goto -588 -> 240
    //   831: astore 4
    //   833: aload 9
    //   835: astore 4
    //   837: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   840: ifeq -600 -> 240
    //   843: ldc 111
    //   845: iconst_2
    //   846: new 16	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   853: ldc_w 336
    //   856: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload 7
    //   861: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   864: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: aload 9
    //   875: astore 4
    //   877: goto -637 -> 240
    //   880: astore 4
    //   882: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   885: ifeq +32 -> 917
    //   888: ldc 111
    //   890: iconst_2
    //   891: iconst_2
    //   892: anewarray 4	java/lang/Object
    //   895: dup
    //   896: iconst_0
    //   897: ldc_w 338
    //   900: aastore
    //   901: dup
    //   902: iconst_1
    //   903: aload 4
    //   905: invokevirtual 339	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   908: aastore
    //   909: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   912: aload 4
    //   914: invokevirtual 340	java/lang/OutOfMemoryError:printStackTrace	()V
    //   917: aload 7
    //   919: invokestatic 334	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   922: astore 4
    //   924: goto -684 -> 240
    //   927: astore 4
    //   929: aload 9
    //   931: astore 4
    //   933: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq -696 -> 240
    //   939: ldc 111
    //   941: iconst_2
    //   942: new 16	java/lang/StringBuilder
    //   945: dup
    //   946: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   949: ldc_w 336
    //   952: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: aload 7
    //   957: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   960: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   969: aload 9
    //   971: astore 4
    //   973: goto -733 -> 240
    //   976: aload 7
    //   978: invokevirtual 284	java/io/File:delete	()Z
    //   981: pop
    //   982: aload 4
    //   984: astore 6
    //   986: aload 8
    //   988: astore 5
    //   990: goto -712 -> 278
    //   993: astore 4
    //   995: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   998: ifeq +38 -> 1036
    //   1001: ldc 111
    //   1003: iconst_2
    //   1004: new 16	java/lang/StringBuilder
    //   1007: dup
    //   1008: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1011: ldc_w 342
    //   1014: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: aload 4
    //   1019: invokevirtual 343	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1022: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: aload 4
    //   1030: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1033: goto -463 -> 570
    //   1036: ldc 111
    //   1038: iconst_2
    //   1039: new 16	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 342
    //   1049: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload 4
    //   1054: invokevirtual 343	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1057: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1066: goto -496 -> 570
    //   1069: astore 4
    //   1071: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1074: ifeq +32 -> 1106
    //   1077: ldc 111
    //   1079: iconst_2
    //   1080: iconst_2
    //   1081: anewarray 4	java/lang/Object
    //   1084: dup
    //   1085: iconst_0
    //   1086: ldc_w 348
    //   1089: aastore
    //   1090: dup
    //   1091: iconst_1
    //   1092: aload 4
    //   1094: invokevirtual 323	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1097: aastore
    //   1098: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1101: aload 4
    //   1103: invokevirtual 329	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   1106: aload 8
    //   1108: invokestatic 334	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   1111: astore 4
    //   1113: goto -522 -> 591
    //   1116: astore 4
    //   1118: aload 6
    //   1120: astore 4
    //   1122: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1125: ifeq -534 -> 591
    //   1128: ldc 111
    //   1130: iconst_2
    //   1131: new 16	java/lang/StringBuilder
    //   1134: dup
    //   1135: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1138: ldc_w 336
    //   1141: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: aload 8
    //   1146: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1149: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1155: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1158: aload 6
    //   1160: astore 4
    //   1162: goto -571 -> 591
    //   1165: astore 4
    //   1167: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1170: ifeq +32 -> 1202
    //   1173: ldc 111
    //   1175: iconst_2
    //   1176: iconst_2
    //   1177: anewarray 4	java/lang/Object
    //   1180: dup
    //   1181: iconst_0
    //   1182: ldc_w 350
    //   1185: aastore
    //   1186: dup
    //   1187: iconst_1
    //   1188: aload 4
    //   1190: invokevirtual 339	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1193: aastore
    //   1194: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1197: aload 4
    //   1199: invokevirtual 340	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1202: aload 8
    //   1204: invokestatic 334	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   1207: astore 4
    //   1209: goto -618 -> 591
    //   1212: astore 4
    //   1214: aload 6
    //   1216: astore 4
    //   1218: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1221: ifeq -630 -> 591
    //   1224: ldc 111
    //   1226: iconst_2
    //   1227: new 16	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1234: ldc_w 336
    //   1237: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 8
    //   1242: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1245: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1254: aload 6
    //   1256: astore 4
    //   1258: goto -667 -> 591
    //   1261: aload 8
    //   1263: invokevirtual 284	java/io/File:delete	()Z
    //   1266: pop
    //   1267: aload 5
    //   1269: astore 4
    //   1271: goto -646 -> 625
    //   1274: iload_3
    //   1275: istore_2
    //   1276: aload_1
    //   1277: getfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1280: aload 10
    //   1282: getfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1285: if_icmplt -532 -> 753
    //   1288: aload_1
    //   1289: getfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1292: aload 10
    //   1294: getfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1297: if_icmpne +185 -> 1482
    //   1300: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1303: ifeq +46 -> 1349
    //   1306: ldc 111
    //   1308: iconst_2
    //   1309: new 16	java/lang/StringBuilder
    //   1312: dup
    //   1313: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1316: ldc_w 352
    //   1319: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: aload 10
    //   1324: getfield 212	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1327: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1330: ldc_w 354
    //   1333: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: aload_0
    //   1337: getfield 41	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1340: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1346: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1349: iload_3
    //   1350: istore_2
    //   1351: aload 10
    //   1353: getfield 212	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1356: iconst_1
    //   1357: if_icmpeq -604 -> 753
    //   1360: aload 10
    //   1362: aload_1
    //   1363: invokevirtual 303	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1366: aload 10
    //   1368: iconst_0
    //   1369: anewarray 65	java/lang/String
    //   1372: invokestatic 295	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1375: aload_0
    //   1376: getfield 43	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1379: bipush 76
    //   1381: invokevirtual 309	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1384: checkcast 311	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   1387: astore_1
    //   1388: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1391: ifeq +60 -> 1451
    //   1394: ldc 111
    //   1396: iconst_2
    //   1397: new 16	java/lang/StringBuilder
    //   1400: dup
    //   1401: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1404: ldc_w 356
    //   1407: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: aload 10
    //   1412: getfield 359	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1415: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1418: ldc_w 361
    //   1421: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: aload 10
    //   1426: getfield 364	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1429: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1432: ldc_w 366
    //   1435: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: aload_1
    //   1439: invokevirtual 368	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Z
    //   1442: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1445: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1448: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1451: aload 10
    //   1453: getfield 359	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1456: ifne +18 -> 1474
    //   1459: aload 10
    //   1461: getfield 364	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1464: ifeq +10 -> 1474
    //   1467: aload_1
    //   1468: invokevirtual 368	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Z
    //   1471: ifne +723 -> 2194
    //   1474: aload_0
    //   1475: invokevirtual 371	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:f	()Z
    //   1478: istore_2
    //   1479: goto -726 -> 753
    //   1482: iload_3
    //   1483: istore_2
    //   1484: aload_1
    //   1485: getfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1488: aload 10
    //   1490: getfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1493: if_icmple -740 -> 753
    //   1496: aload 10
    //   1498: aload_1
    //   1499: invokevirtual 303	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1502: aload 10
    //   1504: iconst_0
    //   1505: anewarray 65	java/lang/String
    //   1508: invokestatic 295	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1511: aload_0
    //   1512: getfield 43	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1515: bipush 76
    //   1517: invokevirtual 309	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1520: checkcast 311	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   1523: astore_1
    //   1524: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1527: ifeq +60 -> 1587
    //   1530: ldc 111
    //   1532: iconst_2
    //   1533: new 16	java/lang/StringBuilder
    //   1536: dup
    //   1537: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1540: ldc_w 373
    //   1543: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: aload 10
    //   1548: getfield 359	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1551: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1554: ldc_w 361
    //   1557: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: aload 10
    //   1562: getfield 364	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1565: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1568: ldc_w 366
    //   1571: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: aload_1
    //   1575: invokevirtual 368	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Z
    //   1578: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1581: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1584: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1587: aload 10
    //   1589: getfield 359	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1592: ifne +20 -> 1612
    //   1595: aload 10
    //   1597: getfield 364	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1600: ifeq +12 -> 1612
    //   1603: iload_3
    //   1604: istore_2
    //   1605: aload_1
    //   1606: invokevirtual 368	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Z
    //   1609: ifne -856 -> 753
    //   1612: aload_0
    //   1613: invokevirtual 371	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:f	()Z
    //   1616: istore_2
    //   1617: goto -864 -> 753
    //   1620: aload 10
    //   1622: aload_1
    //   1623: invokevirtual 303	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1626: aload 10
    //   1628: aload_1
    //   1629: getfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1632: putfield 202	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1635: aload 10
    //   1637: iconst_1
    //   1638: putfield 212	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1641: aload 10
    //   1643: iconst_1
    //   1644: putfield 289	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   1647: aload 10
    //   1649: iconst_1
    //   1650: anewarray 65	java/lang/String
    //   1653: dup
    //   1654: iconst_0
    //   1655: ldc_w 292
    //   1658: aastore
    //   1659: invokestatic 295	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1662: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1665: ifeq +32 -> 1697
    //   1668: ldc 111
    //   1670: iconst_2
    //   1671: new 16	java/lang/StringBuilder
    //   1674: dup
    //   1675: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1678: ldc_w 375
    //   1681: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: aload_0
    //   1685: getfield 41	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1688: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1694: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1697: aload 7
    //   1699: invokevirtual 232	java/io/File:exists	()Z
    //   1702: ifne +74 -> 1776
    //   1705: aload_0
    //   1706: invokevirtual 376	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Z
    //   1709: ifne +67 -> 1776
    //   1712: aload 4
    //   1714: aload 7
    //   1716: invokestatic 279	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   1719: pop
    //   1720: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1723: ifeq +53 -> 1776
    //   1726: ldc 111
    //   1728: iconst_2
    //   1729: new 16	java/lang/StringBuilder
    //   1732: dup
    //   1733: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1736: ldc_w 378
    //   1739: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: aload 4
    //   1744: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1747: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: ldc_w 380
    //   1753: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: aload 7
    //   1758: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1761: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: ldc_w 382
    //   1767: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1773: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1776: aload 10
    //   1778: iconst_0
    //   1779: anewarray 65	java/lang/String
    //   1782: invokestatic 295	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1785: aload_0
    //   1786: aload 4
    //   1788: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1791: invokevirtual 384	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	(Ljava/lang/String;)V
    //   1794: aload_0
    //   1795: getfield 43	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1798: bipush 76
    //   1800: invokevirtual 309	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1803: checkcast 311	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   1806: aload 10
    //   1808: invokevirtual 314	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   1811: invokevirtual 316	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	(Ljava/lang/String;)V
    //   1814: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1817: ifeq +52 -> 1869
    //   1820: ldc 111
    //   1822: iconst_2
    //   1823: new 16	java/lang/StringBuilder
    //   1826: dup
    //   1827: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1830: ldc 196
    //   1832: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1835: aload 10
    //   1837: getfield 121	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1840: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: ldc_w 386
    //   1846: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: aload 4
    //   1851: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1854: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: ldc_w 382
    //   1860: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1863: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1866: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1869: aload_0
    //   1870: getfield 388	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	Z
    //   1873: ifeq +145 -> 2018
    //   1876: new 390	android/content/Intent
    //   1879: dup
    //   1880: ldc_w 392
    //   1883: invokespecial 393	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1886: astore 5
    //   1888: aload 5
    //   1890: ldc_w 394
    //   1893: aload_0
    //   1894: getfield 41	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1897: invokevirtual 398	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1900: pop
    //   1901: aload 5
    //   1903: ldc_w 399
    //   1906: aload 10
    //   1908: getfield 63	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   1911: invokevirtual 398	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1914: pop
    //   1915: aload 5
    //   1917: ldc_w 400
    //   1920: iconst_1
    //   1921: invokevirtual 403	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1924: pop
    //   1925: aload 5
    //   1927: ldc_w 405
    //   1930: aload 10
    //   1932: getfield 407	com/tencent/mobileqq/earlydownload/xmldata/XmlData:totalSize	J
    //   1935: invokevirtual 410	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1938: pop
    //   1939: aload 5
    //   1941: ldc_w 412
    //   1944: aload 10
    //   1946: getfield 414	com/tencent/mobileqq/earlydownload/xmldata/XmlData:downSize	J
    //   1949: invokevirtual 410	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1952: pop
    //   1953: aload 5
    //   1955: ldc_w 416
    //   1958: aload 4
    //   1960: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1963: invokevirtual 398	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1966: pop
    //   1967: invokestatic 422	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1970: aload 5
    //   1972: ldc_w 424
    //   1975: invokevirtual 430	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1978: aload_0
    //   1979: iconst_0
    //   1980: putfield 388	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	Z
    //   1983: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1986: ifeq +32 -> 2018
    //   1989: ldc 111
    //   1991: iconst_2
    //   1992: new 16	java/lang/StringBuilder
    //   1995: dup
    //   1996: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1999: ldc_w 432
    //   2002: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: aload_0
    //   2006: getfield 41	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2009: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2015: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2018: new 434	java/util/HashMap
    //   2021: dup
    //   2022: invokespecial 435	java/util/HashMap:<init>	()V
    //   2025: astore 5
    //   2027: aload 5
    //   2029: ldc_w 437
    //   2032: aload 10
    //   2034: getfield 63	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   2037: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2040: pop
    //   2041: aload 5
    //   2043: ldc_w 443
    //   2046: getstatic 449	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2049: invokevirtual 450	java/lang/Boolean:toString	()Ljava/lang/String;
    //   2052: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2055: pop
    //   2056: aload_0
    //   2057: invokevirtual 452	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Ljava/lang/String;
    //   2060: astore 6
    //   2062: aload 6
    //   2064: ifnull +43 -> 2107
    //   2067: aload 6
    //   2069: invokevirtual 68	java/lang/String:length	()I
    //   2072: ifle +35 -> 2107
    //   2075: invokestatic 422	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2078: invokestatic 457	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2081: aload_0
    //   2082: getfield 43	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2085: invokevirtual 460	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2088: aload 6
    //   2090: iconst_1
    //   2091: ldc2_w 461
    //   2094: aload 7
    //   2096: invokevirtual 240	java/io/File:length	()J
    //   2099: aload 5
    //   2101: ldc_w 464
    //   2104: invokevirtual 467	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2107: aload 8
    //   2109: invokevirtual 232	java/io/File:exists	()Z
    //   2112: ifne -2094 -> 18
    //   2115: aload_1
    //   2116: getfield 470	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   2119: ifeq -2101 -> 18
    //   2122: aload 4
    //   2124: aload 8
    //   2126: invokestatic 279	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   2129: pop
    //   2130: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2133: ifeq -2115 -> 18
    //   2136: ldc 111
    //   2138: iconst_2
    //   2139: new 16	java/lang/StringBuilder
    //   2142: dup
    //   2143: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   2146: ldc_w 378
    //   2149: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: aload 4
    //   2154: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2157: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2160: ldc_w 380
    //   2163: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2166: aload 8
    //   2168: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2171: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: ldc_w 382
    //   2177: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2180: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2183: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2186: return
    //   2187: astore_1
    //   2188: return
    //   2189: astore 5
    //   2191: goto -415 -> 1776
    //   2194: iconst_0
    //   2195: istore_2
    //   2196: goto -717 -> 1479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2199	0	this	EarlyHandler
    //   0	2199	1	paramXmlData	XmlData
    //   491	1705	2	bool1	boolean
    //   687	917	3	bool2	boolean
    //   238	388	4	localObject1	Object
    //   784	33	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   826	1	4	str1	String
    //   831	1	4	localException1	Exception
    //   835	41	4	localObject2	Object
    //   880	33	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   922	1	4	str2	String
    //   927	1	4	localException2	Exception
    //   931	52	4	localObject3	Object
    //   993	60	4	localThrowable	java.lang.Throwable
    //   1069	33	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   1111	1	4	str3	String
    //   1116	1	4	localException3	Exception
    //   1120	41	4	localObject4	Object
    //   1165	33	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1207	1	4	str4	String
    //   1212	1	4	localException4	Exception
    //   1216	937	4	localObject5	Object
    //   182	1918	5	localObject6	Object
    //   2189	1	5	localException5	Exception
    //   114	1975	6	localObject7	Object
    //   130	1965	7	localFile1	File
    //   111	2056	8	localFile2	File
    //   117	853	9	localObject8	Object
    //   23	2010	10	localXmlData	XmlData
    // Exception table:
    //   from	to	target	type
    //   227	240	784	java/lang/UnsatisfiedLinkError
    //   821	828	831	java/lang/Exception
    //   227	240	880	java/lang/OutOfMemoryError
    //   917	924	927	java/lang/Exception
    //   381	468	993	java/lang/Throwable
    //   468	524	993	java/lang/Throwable
    //   524	570	993	java/lang/Throwable
    //   578	591	1069	java/lang/UnsatisfiedLinkError
    //   1106	1113	1116	java/lang/Exception
    //   578	591	1165	java/lang/OutOfMemoryError
    //   1202	1209	1212	java/lang/Exception
    //   2122	2186	2187	java/lang/Exception
    //   1712	1776	2189	java/lang/Exception
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadFinish() result=" + paramBoolean + " filePath=" + paramString);
    }
    Object localObject;
    if (paramBoolean)
    {
      paramXmlData.hasResDownloaded = true;
      EarlyDataFactory.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download Successful, hasResDownloaded=true, resName=" + this.jdField_b_of_type_JavaLangString);
      }
      a(paramString);
      ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192)).a(paramXmlData.strResURL_big, paramXmlData.downSize);
      if (this.c)
      {
        localObject = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
        if (paramInt != 9037) {
          break label392;
        }
        ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_CANCEL");
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("strResName", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("strPkgName", a().strPkgName);
      ((Intent)localObject).putExtra("loadState", a().loadState);
      ((Intent)localObject).putExtra("totalSize", paramXmlData.totalSize);
      ((Intent)localObject).putExtra("downSize", paramXmlData.downSize);
      ((Intent)localObject).putExtra("errCode", paramInt);
      ((Intent)localObject).putExtra("resPath", paramString);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
      this.c = false;
      return;
      paramXmlData.hasResDownloaded = false;
      EarlyDataFactory.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download failed, hasResDownloaded=false, resName=" + this.jdField_b_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)((Iterator)localObject).next()).a(paramXmlData, paramBoolean, paramInt, a(), paramString);
      }
      break;
      label392:
      ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_QUERY");
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(a(), true, 0, a(), paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    new File(c()).delete();
    XmlData localXmlData = a();
    localXmlData.Version = 0;
    localXmlData.tLoadFail = 0L;
    localXmlData.loadState = 0;
    localXmlData.hasResDownloaded = false;
    EarlyDataFactory.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail", "hasResDownloaded" });
    localXmlData.isUserClick = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "restartDownload(), this.strResName=" + this.jdField_b_of_type_JavaLangString + ", resName=" + localXmlData.strResName + ", user=" + paramBoolean);
    }
    Intent localIntent = new Intent();
    GetResourceReqInfo localGetResourceReqInfo = a();
    if (localGetResourceReqInfo != null)
    {
      EarlyDownloadManager localEarlyDownloadManager = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      if ((localEarlyDownloadManager != null) && (!localEarlyDownloadManager.a(localXmlData.getStrResName())))
      {
        localIntent.putExtra("reqResult", true);
        localEarlyDownloadManager.a(localXmlData.getStrResName());
        ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).a(null, new GetResourceReqInfo[] { localGetResourceReqInfo });
      }
    }
    for (;;)
    {
      if (this.c)
      {
        localIntent.setAction("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
        localIntent.putExtra("strResName", this.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("strPkgName", localXmlData.strPkgName);
        BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, String.format("restartDownload() res[%s] is downloading", new Object[] { localXmlData.getStrResName() }));
      }
      localIntent.putExtra("reqResult", false);
      localIntent.putExtra("resultReason", "strPkgName=" + localXmlData.strPkgName);
      continue;
      localIntent.putExtra("reqResult", false);
      localIntent.putExtra("resultReason", "strPkgName=" + localXmlData.strPkgName);
    }
  }
  
  public abstract boolean a();
  
  public int b()
  {
    int i = 0;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      i = localXmlData.Version;
    }
    return i;
  }
  
  public abstract String b();
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void b(EarlyDownloadManager.EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    if ((paramEarlyDownLoadListener != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramEarlyDownLoadListener);
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadBegin()");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(paramXmlData);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "setIsBroadcast() " + paramBoolean);
      }
    }
  }
  
  public String c()
  {
    File localFile = new File(BaseApplicationImpl.getContext().getFilesDir() + "/pddata/prd/early");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (!a()) {
      new File(c()).delete();
    }
  }
  
  public void c(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EarlyDown", 2, "onDownloadCancel");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).b(paramXmlData);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "setFail() resName:" + this.jdField_b_of_type_JavaLangString);
    }
    XmlData localXmlData = a();
    if (localXmlData != null)
    {
      if (localXmlData.loadState != 1) {
        break label94;
      }
      localXmlData.loadState = 0;
      localXmlData.Version = 0;
    }
    for (;;)
    {
      localXmlData.hasResDownloaded = false;
      EarlyDataFactory.a(localXmlData, new String[] { "loadState", "Version", "hasResDownloaded" });
      return;
      label94:
      if ((localXmlData.loadState == 2) && (paramBoolean)) {
        localXmlData.loadState = 0;
      }
    }
  }
  
  public String d()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.jdField_b_of_type_JavaLangString;
  }
  
  public void d()
  {
    if (a())
    {
      File localFile = new File(c());
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "doAfterFinish() deleteResouceAfterDownload==true, delete storage:" + localFile.getAbsolutePath() + " bool=" + bool);
        }
      }
    }
  }
  
  public void d(XmlData paramXmlData) {}
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          i = 1;
        }
        if (i == 1)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_strResName", this.jdField_b_of_type_JavaLangString);
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actEarlyDownUse", paramBoolean, 0L, 0L, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "statisticUsage() strResName=" + this.jdField_b_of_type_JavaLangString + " inUse=" + paramBoolean);
          }
        }
        return;
      }
      finally {}
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        i = 1;
      }
    }
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public void e()
  {
    String str = c();
    try
    {
      new File(str).delete();
      label17:
      EarlyDataFactory.a(a());
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    XmlData localXmlData = a();
    if (localXmlData != null)
    {
      long l = System.currentTimeMillis();
      boolean bool1;
      if (localXmlData.tLoadFail != 0L)
      {
        bool1 = bool3;
        if (localXmlData.tLoadFail > 0L)
        {
          bool1 = bool3;
          if (localXmlData.tLoadFail + 43200000L >= l) {}
        }
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isTimeValid() " + bool1 + " res=" + localXmlData.strResName + " tLoadFail=" + localXmlData.tLoadFail);
        bool2 = bool1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "isTimeValid() = false,  data = null");
    }
    return bool2;
  }
  
  public boolean e_()
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      if (NetworkUtil.h(BaseApplicationImpl.getContext())) {
        if (!localXmlData.loadWifi) {
          break label310;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " isWifiConn=true, " + localXmlData.strResName + ":loadWifi=" + localXmlData.loadWifi);
        bool1 = bool2;
      }
      return bool1;
      if (NetworkUtil.b(BaseApplicationImpl.getContext())) {
        if (NetworkUtil.c(BaseApplicationImpl.getContext())) {
          if (!localXmlData.load3G) {
            break label305;
          }
        }
      }
      label305:
      for (bool2 = bool1;; bool2 = false)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is3Gor4G=true, " + localXmlData.strResName + ":load3G=" + localXmlData.load3G);
        return bool2;
        if (localXmlData.load2G) {}
        for (bool2 = bool3;; bool2 = false)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is2G=true, " + localXmlData.strResName + ":load2G=" + localXmlData.load2G);
          return bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, "isNetValid2Down() return:false, no wifi and no MobileNet.");
            return false;
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "isNetValid2Download() return false, data == null");
            }
          }
          return false;
        }
      }
      label310:
      bool2 = false;
    }
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    XmlData localXmlData = a();
    boolean bool3 = e_();
    boolean bool1;
    if (!e()) {
      if (NetworkUtil.h(BaseApplicationImpl.getContext()))
      {
        if (!QLog.isColorLevel()) {
          break label141;
        }
        QLog.d("EarlyDown", 2, "wifi connected,reset timeValid=true");
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((bool3) && (bool1))
      {
        ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a(localXmlData, c());
        bool2 = true;
      }
      while (!QLog.isColorLevel())
      {
        return bool2;
        bool1 = false;
        break;
      }
      QLog.d("EarlyDown", 2, "downloadResource() return false, netValid=" + bool3 + " timeValid=" + bool1 + " strResName=" + this.jdField_b_of_type_JavaLangString);
      return false;
      label141:
      bool1 = true;
    }
  }
  
  public boolean g()
  {
    boolean bool1 = false;
    boolean bool2 = true;
    boolean bool3 = true;
    XmlData localXmlData = a();
    if (localXmlData == null)
    {
      bool2 = bool3;
      return bool2;
    }
    System.currentTimeMillis();
    if (localXmlData.loadState == 1)
    {
      if (!a())
      {
        if (!new File(c()).exists())
        {
          c(false);
          c();
        }
        bool1 = true;
      }
      label69:
      if (localXmlData.hasResDownloaded) {
        break label220;
      }
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isNeedServerInfo() " + a().strResName + " hasResDownloaded=false, 强制刷新");
        bool1 = bool2;
      }
    }
    label220:
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EarlyDown", 2, "isNeedServerInfo() " + a().strResName + " need=" + bool1);
      return bool1;
      if ((localXmlData.Version != 0) && (localXmlData.loadState != 2))
      {
        localXmlData.Version = 0;
        EarlyDataFactory.a(localXmlData, new String[] { "Version" });
      }
      bool1 = true;
      break label69;
    }
  }
  
  public boolean h()
  {
    XmlData localXmlData = a();
    if (localXmlData != null) {
      return localXmlData.loadState == 1;
    }
    return false;
  }
  
  public boolean i()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.EarlyHandler
 * JD-Core Version:    0.7.0.1
 */