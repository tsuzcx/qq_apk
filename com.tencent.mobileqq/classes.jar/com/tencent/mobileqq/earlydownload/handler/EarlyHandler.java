package com.tencent.mobileqq.earlydownload.handler;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
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
  static final String jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "pddata/prd/early";
  protected QQAppInterface a;
  private XmlData jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  protected ArrayList<EarlyDownloadManager.EarlyDownLoadListener> a;
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
  
  public abstract Class<? extends XmlData> a();
  
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
  
  public GetResourceReqInfoV2 a(String paramString)
  {
    long l = 0L;
    XmlData localXmlData = a();
    GetResourceReqInfoV2 localGetResourceReqInfoV2;
    if (localXmlData == null)
    {
      localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = 1;
      localGetResourceReqInfoV2.strPkgName = paramString;
      localGetResourceReqInfoV2.uiCurVer = 0L;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuffer("getResourceReqInfoV2(), strPkgName=" + paramString);
        if (localXmlData != null) {
          break label168;
        }
        paramString.append(",data==null");
      }
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, paramString.toString());
      return localGetResourceReqInfoV2;
      localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = 1;
      localGetResourceReqInfoV2.strPkgName = paramString;
      if (f()) {}
      for (;;)
      {
        localGetResourceReqInfoV2.uiCurVer = l;
        break;
        l = b();
      }
      label168:
      paramString.append(",this.strResName=[" + this.jdField_b_of_type_JavaLangString);
      paramString.append("], resName=[" + localXmlData.strResName);
      paramString.append("], pkgName=[" + localXmlData.strPkgName);
      paramString.append("], version=[" + localXmlData.Version);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
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
    //   1: ifnonnull +12 -> 13
    //   4: ldc 112
    //   6: iconst_1
    //   7: ldc 206
    //   9: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 59	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;
    //   17: astore 10
    //   19: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +102 -> 124
    //   25: ldc 112
    //   27: iconst_2
    //   28: new 17	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   35: ldc 211
    //   37: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: getfield 122	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   44: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 213
    //   49: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_1
    //   53: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   56: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 215
    //   61: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   68: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc 217
    //   73: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 10
    //   78: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   81: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: ldc 219
    //   86: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 10
    //   91: getfield 222	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   94: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc 224
    //   99: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: getfield 227	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   106: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 229
    //   111: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload_1
    //   125: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   128: aload 10
    //   130: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   133: invokestatic 238	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   136: ifne +50 -> 186
    //   139: ldc 240
    //   141: iconst_1
    //   142: new 17	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   149: ldc 242
    //   151: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   158: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 244
    //   163: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 10
    //   168: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   171: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 246
    //   176: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 249	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: return
    //   186: aconst_null
    //   187: astore 8
    //   189: aconst_null
    //   190: astore 6
    //   192: aconst_null
    //   193: astore 9
    //   195: new 251	java/io/File
    //   198: dup
    //   199: aload_0
    //   200: invokevirtual 253	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	()Ljava/lang/String;
    //   203: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   206: astore 7
    //   208: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +47 -> 258
    //   214: ldc 112
    //   216: iconst_2
    //   217: new 17	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 256
    //   227: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 7
    //   232: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   235: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 261
    //   241: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 7
    //   246: invokevirtual 264	java/io/File:exists	()Z
    //   249: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   252: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload 8
    //   260: astore 5
    //   262: aload 7
    //   264: invokevirtual 264	java/io/File:exists	()Z
    //   267: ifeq +90 -> 357
    //   270: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +33 -> 306
    //   276: ldc 112
    //   278: iconst_2
    //   279: new 17	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 269
    //   289: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 7
    //   294: invokevirtual 272	java/io/File:length	()J
    //   297: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 7
    //   308: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   311: invokestatic 281	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   314: invokestatic 287	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   317: astore 4
    //   319: aload 4
    //   321: ifnull +737 -> 1058
    //   324: aload_1
    //   325: getfield 290	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   328: ifnull +730 -> 1058
    //   331: aload 4
    //   333: invokevirtual 293	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   336: aload_1
    //   337: getfield 290	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   340: invokevirtual 293	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   343: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   346: ifeq +712 -> 1058
    //   349: aload 7
    //   351: astore 5
    //   353: aload 4
    //   355: astore 6
    //   357: new 251	java/io/File
    //   360: dup
    //   361: aload_0
    //   362: invokevirtual 297	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d	()Ljava/lang/String;
    //   365: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   368: astore 8
    //   370: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +47 -> 420
    //   376: ldc 112
    //   378: iconst_2
    //   379: new 17	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 299
    //   389: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 8
    //   394: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   397: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc_w 261
    //   403: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 8
    //   408: invokevirtual 264	java/io/File:exists	()Z
    //   411: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   414: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload 5
    //   422: ifnonnull +894 -> 1316
    //   425: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +33 -> 461
    //   431: ldc 112
    //   433: iconst_2
    //   434: new 17	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 301
    //   444: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 8
    //   449: invokevirtual 272	java/io/File:length	()J
    //   452: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   455: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: new 251	java/io/File
    //   464: dup
    //   465: new 17	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   472: getstatic 25	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   475: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 303
    //   481: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_0
    //   485: getfield 42	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   488: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   497: astore 4
    //   499: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   502: ifeq +47 -> 549
    //   505: ldc 112
    //   507: iconst_2
    //   508: new 17	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 305
    //   518: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload 4
    //   523: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   526: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: ldc_w 261
    //   532: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 4
    //   537: invokevirtual 264	java/io/File:exists	()Z
    //   540: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   543: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: aload 8
    //   551: invokevirtual 264	java/io/File:exists	()Z
    //   554: ifne +51 -> 605
    //   557: aload 4
    //   559: invokevirtual 264	java/io/File:exists	()Z
    //   562: ifeq +43 -> 605
    //   565: aload 4
    //   567: aload 8
    //   569: invokestatic 310	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   572: istore_2
    //   573: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq +29 -> 605
    //   579: ldc 112
    //   581: iconst_2
    //   582: new 17	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 312
    //   592: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: iload_2
    //   596: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   599: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: aload 4
    //   607: invokevirtual 264	java/io/File:exists	()Z
    //   610: ifeq +41 -> 651
    //   613: aload 4
    //   615: invokevirtual 315	java/io/File:delete	()Z
    //   618: istore_2
    //   619: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq +29 -> 651
    //   625: ldc 112
    //   627: iconst_2
    //   628: new 17	java/lang/StringBuilder
    //   631: dup
    //   632: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   635: ldc_w 317
    //   638: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: iload_2
    //   642: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   645: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: aload 8
    //   653: invokevirtual 264	java/io/File:exists	()Z
    //   656: ifeq +660 -> 1316
    //   659: aload 8
    //   661: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   664: invokestatic 281	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   667: invokestatic 287	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   670: astore 4
    //   672: aload 4
    //   674: ifnull +632 -> 1306
    //   677: aload_1
    //   678: getfield 290	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   681: ifnull +625 -> 1306
    //   684: aload 4
    //   686: invokevirtual 293	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   689: aload_1
    //   690: getfield 290	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   693: invokevirtual 293	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   696: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   699: ifeq +607 -> 1306
    //   702: aload 8
    //   704: astore 4
    //   706: aload 4
    //   708: ifnonnull +963 -> 1671
    //   711: aload 10
    //   713: iconst_0
    //   714: putfield 320	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   717: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   720: ifeq +32 -> 752
    //   723: ldc 112
    //   725: iconst_2
    //   726: new 17	java/lang/StringBuilder
    //   729: dup
    //   730: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   733: ldc_w 322
    //   736: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: aload_0
    //   740: getfield 42	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   743: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: aload 10
    //   754: iconst_1
    //   755: anewarray 66	java/lang/String
    //   758: dup
    //   759: iconst_0
    //   760: ldc_w 323
    //   763: aastore
    //   764: invokestatic 326	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   767: iconst_0
    //   768: istore_3
    //   769: aload_0
    //   770: invokevirtual 329	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:h	()Z
    //   773: ifne +550 -> 1323
    //   776: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +32 -> 811
    //   782: ldc 112
    //   784: iconst_2
    //   785: new 17	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 331
    //   795: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_0
    //   799: getfield 42	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   802: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   811: aload 10
    //   813: aload_1
    //   814: invokevirtual 334	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   817: aload 10
    //   819: iconst_1
    //   820: putfield 222	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   823: aload 10
    //   825: iconst_0
    //   826: anewarray 66	java/lang/String
    //   829: invokestatic 326	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   832: iload_3
    //   833: istore_2
    //   834: iload_2
    //   835: ifne -823 -> 12
    //   838: aload_0
    //   839: getfield 44	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   842: getstatic 339	com/tencent/mobileqq/app/QQManagerFactory:EARLY_DOWNLOAD_MANAGER	I
    //   845: invokevirtual 345	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   848: checkcast 347	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   851: aload 10
    //   853: invokevirtual 350	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   856: invokevirtual 352	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	(Ljava/lang/String;)V
    //   859: aload_0
    //   860: aload 10
    //   862: invokevirtual 354	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   865: return
    //   866: astore 4
    //   868: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   871: ifeq +32 -> 903
    //   874: ldc 112
    //   876: iconst_2
    //   877: iconst_2
    //   878: anewarray 4	java/lang/Object
    //   881: dup
    //   882: iconst_0
    //   883: ldc_w 356
    //   886: aastore
    //   887: dup
    //   888: iconst_1
    //   889: aload 4
    //   891: invokevirtual 359	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   894: aastore
    //   895: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   898: aload 4
    //   900: invokevirtual 365	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   903: aload 7
    //   905: invokestatic 370	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   908: astore 4
    //   910: goto -591 -> 319
    //   913: astore 4
    //   915: aload 9
    //   917: astore 4
    //   919: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   922: ifeq -603 -> 319
    //   925: ldc 112
    //   927: iconst_2
    //   928: new 17	java/lang/StringBuilder
    //   931: dup
    //   932: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   935: ldc_w 372
    //   938: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: aload 7
    //   943: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   946: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   955: aload 9
    //   957: astore 4
    //   959: goto -640 -> 319
    //   962: astore 4
    //   964: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   967: ifeq +32 -> 999
    //   970: ldc 112
    //   972: iconst_2
    //   973: iconst_2
    //   974: anewarray 4	java/lang/Object
    //   977: dup
    //   978: iconst_0
    //   979: ldc_w 374
    //   982: aastore
    //   983: dup
    //   984: iconst_1
    //   985: aload 4
    //   987: invokevirtual 375	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   990: aastore
    //   991: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   994: aload 4
    //   996: invokevirtual 376	java/lang/OutOfMemoryError:printStackTrace	()V
    //   999: aload 7
    //   1001: invokestatic 370	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   1004: astore 4
    //   1006: goto -687 -> 319
    //   1009: astore 4
    //   1011: aload 9
    //   1013: astore 4
    //   1015: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1018: ifeq -699 -> 319
    //   1021: ldc 112
    //   1023: iconst_2
    //   1024: new 17	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1031: ldc_w 372
    //   1034: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload 7
    //   1039: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1042: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1051: aload 9
    //   1053: astore 4
    //   1055: goto -736 -> 319
    //   1058: aload 7
    //   1060: invokevirtual 315	java/io/File:delete	()Z
    //   1063: pop
    //   1064: aload_0
    //   1065: invokevirtual 378	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:b	()V
    //   1068: aload 4
    //   1070: astore 6
    //   1072: aload 8
    //   1074: astore 5
    //   1076: goto -719 -> 357
    //   1079: astore 4
    //   1081: ldc 112
    //   1083: iconst_1
    //   1084: new 17	java/lang/StringBuilder
    //   1087: dup
    //   1088: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1091: ldc_w 380
    //   1094: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: aload 4
    //   1099: invokevirtual 381	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1102: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1111: goto -460 -> 651
    //   1114: astore 4
    //   1116: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1119: ifeq +32 -> 1151
    //   1122: ldc 112
    //   1124: iconst_2
    //   1125: iconst_2
    //   1126: anewarray 4	java/lang/Object
    //   1129: dup
    //   1130: iconst_0
    //   1131: ldc_w 383
    //   1134: aastore
    //   1135: dup
    //   1136: iconst_1
    //   1137: aload 4
    //   1139: invokevirtual 359	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1142: aastore
    //   1143: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1146: aload 4
    //   1148: invokevirtual 365	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   1151: aload 8
    //   1153: invokestatic 370	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   1156: astore 4
    //   1158: goto -486 -> 672
    //   1161: astore 4
    //   1163: aload 6
    //   1165: astore 4
    //   1167: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1170: ifeq -498 -> 672
    //   1173: ldc 112
    //   1175: iconst_2
    //   1176: new 17	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1183: ldc_w 372
    //   1186: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: aload 8
    //   1191: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1194: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1200: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1203: aload 6
    //   1205: astore 4
    //   1207: goto -535 -> 672
    //   1210: astore 4
    //   1212: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1215: ifeq +32 -> 1247
    //   1218: ldc 112
    //   1220: iconst_2
    //   1221: iconst_2
    //   1222: anewarray 4	java/lang/Object
    //   1225: dup
    //   1226: iconst_0
    //   1227: ldc_w 385
    //   1230: aastore
    //   1231: dup
    //   1232: iconst_1
    //   1233: aload 4
    //   1235: invokevirtual 375	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1238: aastore
    //   1239: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1242: aload 4
    //   1244: invokevirtual 376	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1247: aload 8
    //   1249: invokestatic 370	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   1252: astore 4
    //   1254: goto -582 -> 672
    //   1257: astore 4
    //   1259: aload 6
    //   1261: astore 4
    //   1263: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1266: ifeq -594 -> 672
    //   1269: ldc 112
    //   1271: iconst_2
    //   1272: new 17	java/lang/StringBuilder
    //   1275: dup
    //   1276: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1279: ldc_w 372
    //   1282: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: aload 8
    //   1287: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1290: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1299: aload 6
    //   1301: astore 4
    //   1303: goto -631 -> 672
    //   1306: aload 8
    //   1308: invokevirtual 315	java/io/File:delete	()Z
    //   1311: pop
    //   1312: aload_0
    //   1313: invokevirtual 378	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:b	()V
    //   1316: aload 5
    //   1318: astore 4
    //   1320: goto -614 -> 706
    //   1323: iload_3
    //   1324: istore_2
    //   1325: aload_1
    //   1326: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1329: aload 10
    //   1331: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1334: if_icmplt -500 -> 834
    //   1337: aload_1
    //   1338: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1341: aload 10
    //   1343: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1346: if_icmpne +186 -> 1532
    //   1349: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1352: ifeq +46 -> 1398
    //   1355: ldc 112
    //   1357: iconst_2
    //   1358: new 17	java/lang/StringBuilder
    //   1361: dup
    //   1362: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1365: ldc_w 387
    //   1368: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: aload 10
    //   1373: getfield 222	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1376: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1379: ldc_w 389
    //   1382: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: aload_0
    //   1386: getfield 42	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1389: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1395: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1398: iload_3
    //   1399: istore_2
    //   1400: aload 10
    //   1402: getfield 222	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1405: iconst_1
    //   1406: if_icmpeq -572 -> 834
    //   1409: aload 10
    //   1411: aload_1
    //   1412: invokevirtual 334	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1415: aload 10
    //   1417: iconst_0
    //   1418: anewarray 66	java/lang/String
    //   1421: invokestatic 326	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1424: aload_0
    //   1425: getfield 44	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1428: getstatic 339	com/tencent/mobileqq/app/QQManagerFactory:EARLY_DOWNLOAD_MANAGER	I
    //   1431: invokevirtual 345	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1434: checkcast 347	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   1437: astore_1
    //   1438: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1441: ifeq +60 -> 1501
    //   1444: ldc 112
    //   1446: iconst_2
    //   1447: new 17	java/lang/StringBuilder
    //   1450: dup
    //   1451: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1454: ldc_w 391
    //   1457: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: aload 10
    //   1462: getfield 394	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1465: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1468: ldc_w 396
    //   1471: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: aload 10
    //   1476: getfield 399	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1479: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1482: ldc_w 401
    //   1485: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: aload_1
    //   1489: invokevirtual 403	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Z
    //   1492: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1495: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1501: aload 10
    //   1503: getfield 394	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1506: ifne +18 -> 1524
    //   1509: aload 10
    //   1511: getfield 399	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1514: ifeq +10 -> 1524
    //   1517: aload_1
    //   1518: invokevirtual 403	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Z
    //   1521: ifne +726 -> 2247
    //   1524: aload_0
    //   1525: invokevirtual 405	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:e	()Z
    //   1528: istore_2
    //   1529: goto -695 -> 834
    //   1532: iload_3
    //   1533: istore_2
    //   1534: aload_1
    //   1535: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1538: aload 10
    //   1540: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1543: if_icmple -709 -> 834
    //   1546: aload 10
    //   1548: aload_1
    //   1549: invokevirtual 334	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1552: aload 10
    //   1554: iconst_0
    //   1555: anewarray 66	java/lang/String
    //   1558: invokestatic 326	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1561: aload_0
    //   1562: getfield 44	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1565: getstatic 339	com/tencent/mobileqq/app/QQManagerFactory:EARLY_DOWNLOAD_MANAGER	I
    //   1568: invokevirtual 345	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1571: checkcast 347	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   1574: astore_1
    //   1575: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1578: ifeq +60 -> 1638
    //   1581: ldc 112
    //   1583: iconst_2
    //   1584: new 17	java/lang/StringBuilder
    //   1587: dup
    //   1588: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1591: ldc_w 407
    //   1594: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: aload 10
    //   1599: getfield 394	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1602: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1605: ldc_w 396
    //   1608: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: aload 10
    //   1613: getfield 399	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1616: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1619: ldc_w 401
    //   1622: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: aload_1
    //   1626: invokevirtual 403	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Z
    //   1629: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1632: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1635: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1638: aload 10
    //   1640: getfield 394	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1643: ifne +20 -> 1663
    //   1646: aload 10
    //   1648: getfield 399	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1651: ifeq +12 -> 1663
    //   1654: iload_3
    //   1655: istore_2
    //   1656: aload_1
    //   1657: invokevirtual 403	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Z
    //   1660: ifne -826 -> 834
    //   1663: aload_0
    //   1664: invokevirtual 405	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:e	()Z
    //   1667: istore_2
    //   1668: goto -834 -> 834
    //   1671: aload 10
    //   1673: aload_1
    //   1674: invokevirtual 334	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1677: aload 10
    //   1679: aload_1
    //   1680: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1683: putfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1686: aload 10
    //   1688: iconst_1
    //   1689: putfield 222	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1692: aload 10
    //   1694: iconst_1
    //   1695: putfield 320	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   1698: aload 10
    //   1700: iconst_1
    //   1701: anewarray 66	java/lang/String
    //   1704: dup
    //   1705: iconst_0
    //   1706: ldc_w 323
    //   1709: aastore
    //   1710: invokestatic 326	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1713: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1716: ifeq +32 -> 1748
    //   1719: ldc 112
    //   1721: iconst_2
    //   1722: new 17	java/lang/StringBuilder
    //   1725: dup
    //   1726: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1729: ldc_w 409
    //   1732: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: aload_0
    //   1736: getfield 42	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1739: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1745: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1748: aload 7
    //   1750: invokevirtual 264	java/io/File:exists	()Z
    //   1753: ifne +74 -> 1827
    //   1756: aload_0
    //   1757: invokevirtual 410	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Z
    //   1760: ifne +67 -> 1827
    //   1763: aload 4
    //   1765: aload 7
    //   1767: invokestatic 310	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   1770: pop
    //   1771: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1774: ifeq +53 -> 1827
    //   1777: ldc 112
    //   1779: iconst_2
    //   1780: new 17	java/lang/StringBuilder
    //   1783: dup
    //   1784: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1787: ldc_w 412
    //   1790: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1793: aload 4
    //   1795: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1798: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1801: ldc_w 414
    //   1804: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: aload 7
    //   1809: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1812: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1815: ldc_w 416
    //   1818: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1821: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1824: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1827: aload 10
    //   1829: iconst_0
    //   1830: anewarray 66	java/lang/String
    //   1833: invokestatic 326	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1836: aload_0
    //   1837: aload 4
    //   1839: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1842: invokevirtual 418	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	(Ljava/lang/String;)V
    //   1845: aload_0
    //   1846: getfield 44	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1849: getstatic 339	com/tencent/mobileqq/app/QQManagerFactory:EARLY_DOWNLOAD_MANAGER	I
    //   1852: invokevirtual 345	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1855: checkcast 347	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   1858: aload 10
    //   1860: invokevirtual 350	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   1863: invokevirtual 352	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	(Ljava/lang/String;)V
    //   1866: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1869: ifeq +53 -> 1922
    //   1872: ldc 112
    //   1874: iconst_2
    //   1875: new 17	java/lang/StringBuilder
    //   1878: dup
    //   1879: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1882: ldc_w 420
    //   1885: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1888: aload 10
    //   1890: getfield 122	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1893: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: ldc_w 422
    //   1899: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1902: aload 4
    //   1904: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1907: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: ldc_w 416
    //   1913: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1919: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1922: aload_0
    //   1923: getfield 424	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	Z
    //   1926: ifeq +145 -> 2071
    //   1929: new 426	android/content/Intent
    //   1932: dup
    //   1933: ldc_w 428
    //   1936: invokespecial 429	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1939: astore 5
    //   1941: aload 5
    //   1943: ldc_w 430
    //   1946: aload_0
    //   1947: getfield 42	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1950: invokevirtual 434	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1953: pop
    //   1954: aload 5
    //   1956: ldc_w 435
    //   1959: aload 10
    //   1961: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   1964: invokevirtual 434	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1967: pop
    //   1968: aload 5
    //   1970: ldc_w 436
    //   1973: iconst_1
    //   1974: invokevirtual 439	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1977: pop
    //   1978: aload 5
    //   1980: ldc_w 441
    //   1983: aload 10
    //   1985: getfield 443	com/tencent/mobileqq/earlydownload/xmldata/XmlData:totalSize	J
    //   1988: invokevirtual 446	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1991: pop
    //   1992: aload 5
    //   1994: ldc_w 448
    //   1997: aload 10
    //   1999: getfield 450	com/tencent/mobileqq/earlydownload/xmldata/XmlData:downSize	J
    //   2002: invokevirtual 446	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2005: pop
    //   2006: aload 5
    //   2008: ldc_w 452
    //   2011: aload 4
    //   2013: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2016: invokevirtual 434	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2019: pop
    //   2020: invokestatic 458	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2023: aload 5
    //   2025: ldc_w 460
    //   2028: invokevirtual 466	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2031: aload_0
    //   2032: iconst_0
    //   2033: putfield 424	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	Z
    //   2036: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2039: ifeq +32 -> 2071
    //   2042: ldc 112
    //   2044: iconst_2
    //   2045: new 17	java/lang/StringBuilder
    //   2048: dup
    //   2049: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   2052: ldc_w 468
    //   2055: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2058: aload_0
    //   2059: getfield 42	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2062: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2068: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2071: new 470	java/util/HashMap
    //   2074: dup
    //   2075: invokespecial 471	java/util/HashMap:<init>	()V
    //   2078: astore 5
    //   2080: aload 5
    //   2082: ldc_w 473
    //   2085: aload 10
    //   2087: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   2090: invokevirtual 477	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2093: pop
    //   2094: aload 5
    //   2096: ldc_w 479
    //   2099: getstatic 485	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2102: invokevirtual 486	java/lang/Boolean:toString	()Ljava/lang/String;
    //   2105: invokevirtual 477	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2108: pop
    //   2109: aload_0
    //   2110: invokevirtual 488	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Ljava/lang/String;
    //   2113: astore 6
    //   2115: aload 6
    //   2117: ifnull +43 -> 2160
    //   2120: aload 6
    //   2122: invokevirtual 69	java/lang/String:length	()I
    //   2125: ifle +35 -> 2160
    //   2128: invokestatic 458	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2131: invokestatic 494	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2134: aload_0
    //   2135: getfield 44	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2138: invokevirtual 497	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2141: aload 6
    //   2143: iconst_1
    //   2144: ldc2_w 498
    //   2147: aload 7
    //   2149: invokevirtual 272	java/io/File:length	()J
    //   2152: aload 5
    //   2154: ldc_w 501
    //   2157: invokevirtual 505	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2160: aload 8
    //   2162: invokevirtual 264	java/io/File:exists	()Z
    //   2165: ifne -2153 -> 12
    //   2168: aload_1
    //   2169: getfield 508	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   2172: ifeq -2160 -> 12
    //   2175: aload 4
    //   2177: aload 8
    //   2179: invokestatic 310	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   2182: pop
    //   2183: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2186: ifeq -2174 -> 12
    //   2189: ldc 112
    //   2191: iconst_2
    //   2192: new 17	java/lang/StringBuilder
    //   2195: dup
    //   2196: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   2199: ldc_w 412
    //   2202: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: aload 4
    //   2207: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2210: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2213: ldc_w 414
    //   2216: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2219: aload 8
    //   2221: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2224: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: ldc_w 416
    //   2230: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2233: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2236: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2239: return
    //   2240: astore_1
    //   2241: return
    //   2242: astore 5
    //   2244: goto -417 -> 1827
    //   2247: iconst_0
    //   2248: istore_2
    //   2249: goto -720 -> 1529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2252	0	this	EarlyHandler
    //   0	2252	1	paramXmlData	XmlData
    //   572	1677	2	bool1	boolean
    //   768	887	3	bool2	boolean
    //   317	390	4	localObject1	Object
    //   866	33	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   908	1	4	str1	String
    //   913	1	4	localException1	Exception
    //   917	41	4	localObject2	Object
    //   962	33	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1004	1	4	str2	String
    //   1009	1	4	localException2	Exception
    //   1013	56	4	localObject3	Object
    //   1079	19	4	localThrowable	java.lang.Throwable
    //   1114	33	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   1156	1	4	str3	String
    //   1161	1	4	localException3	Exception
    //   1165	41	4	localObject4	Object
    //   1210	33	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1252	1	4	str4	String
    //   1257	1	4	localException4	Exception
    //   1261	945	4	localObject5	Object
    //   260	1893	5	localObject6	Object
    //   2242	1	5	localException5	Exception
    //   190	1952	6	localObject7	Object
    //   206	1942	7	localFile1	File
    //   187	2033	8	localFile2	File
    //   193	859	9	localObject8	Object
    //   17	2069	10	localXmlData	XmlData
    // Exception table:
    //   from	to	target	type
    //   306	319	866	java/lang/UnsatisfiedLinkError
    //   903	910	913	java/lang/Exception
    //   306	319	962	java/lang/OutOfMemoryError
    //   999	1006	1009	java/lang/Exception
    //   461	549	1079	java/lang/Throwable
    //   549	605	1079	java/lang/Throwable
    //   605	651	1079	java/lang/Throwable
    //   659	672	1114	java/lang/UnsatisfiedLinkError
    //   1151	1158	1161	java/lang/Exception
    //   659	672	1210	java/lang/OutOfMemoryError
    //   1247	1254	1257	java/lang/Exception
    //   2175	2239	2240	java/lang/Exception
    //   1763	1827	2242	java/lang/Exception
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
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download Successful, hasResDownloaded=true, resName=" + this.jdField_b_of_type_JavaLangString + "this=" + this);
      }
      a(paramString);
      ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).preDownloadSuccess(paramXmlData.strResURL_big, paramXmlData.downSize);
      if (this.c)
      {
        localObject = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
        if (paramInt != 9037) {
          break label396;
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
      QLog.d("EarlyDown", 1, "EarlyHandler, onDownloadFinish,download failed, hasResDownloaded=false, resName=" + this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)((Iterator)localObject).next()).a(paramXmlData, paramBoolean, paramInt, a(), paramString);
      }
      break;
      label396:
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
      EarlyDownloadManager localEarlyDownloadManager = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      if ((localEarlyDownloadManager != null) && (!localEarlyDownloadManager.a(localXmlData.getStrResName())))
      {
        localIntent.putExtra("reqResult", true);
        localEarlyDownloadManager.a(localXmlData.getStrResName());
        ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a(null, new GetResourceReqInfo[] { localGetResourceReqInfo });
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
  
  public void b() {}
  
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
  
  public boolean b()
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
  
  public boolean c()
  {
    return this.c;
  }
  
  public String d()
  {
    String str = VFSAssistantUtils.getSDKPrivatePath(jdField_a_of_type_JavaLangString);
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath() + File.separator + this.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyHandler", 2, "getBackupPath ,SDCARD_DIR = " + jdField_a_of_type_JavaLangString + ",vfsDir = " + str + ",filepath = " + (String)localObject);
    }
    return localObject;
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
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actEarlyDownUse", paramBoolean, 0L, 0L, localHashMap, "");
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
  
  public void e(boolean paramBoolean) {}
  
  public boolean e()
  {
    boolean bool2 = false;
    XmlData localXmlData = a();
    boolean bool3 = b();
    boolean bool1;
    if (!d()) {
      if (NetworkUtil.h(BaseApplicationImpl.getContext()))
      {
        if (!QLog.isColorLevel()) {
          break label142;
        }
        QLog.d("EarlyDown", 2, "wifi connected,reset timeValid=true");
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((bool3) && (bool1))
      {
        ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a(localXmlData, c());
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
      label142:
      bool1 = true;
    }
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    int i = 1;
    XmlData localXmlData = a();
    int j = -1;
    boolean bool1;
    if (localXmlData == null)
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "isNeedServerInfo(), " + a().strResName + ", need=" + bool1 + ", needTrueReasonCode =" + i);
      }
      return bool1;
    }
    System.currentTimeMillis();
    if (localXmlData.loadState == 1)
    {
      i = j;
      bool1 = bool2;
      if (!a())
      {
        i = j;
        bool1 = bool2;
        if (!new File(c()).exists())
        {
          c(false);
          c();
          i = 2;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (!localXmlData.hasResDownloaded)
      {
        bool1 = true;
        i = 4;
        break;
        if ((localXmlData.Version == 0) || (localXmlData.loadState == 2)) {
          break label203;
        }
        localXmlData.Version = 0;
        EarlyDataFactory.a(localXmlData, new String[] { "Version" });
        i = 3;
        bool1 = true;
        continue;
      }
      break;
      label203:
      bool1 = true;
      i = j;
    }
  }
  
  public boolean g()
  {
    XmlData localXmlData = a();
    if (localXmlData != null) {
      return localXmlData.loadState == 1;
    }
    return false;
  }
  
  public boolean h()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.EarlyHandler
 * JD-Core Version:    0.7.0.1
 */