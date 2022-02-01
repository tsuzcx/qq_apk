package com.tencent.tmassistantsdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class TMAssistantCallYYB_V1
  extends TMAssistantBaseCallYYB
  implements com.tencent.tmassistantsdk.internal.openSDK.b
{
  public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
  public static final Uri CONTENT_URI = com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.b.a;
  protected static final String TAG = "TMAssistantCallYYB_V1";
  protected static TMAssistantCallYYB_V1 mInstance;
  Map<String, TMAssistantCallYYBParamStruct> mDownloadParams = null;
  protected int sdkAPILevel = 1;
  
  public static TMAssistantCallYYB_V1 getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMAssistantCallYYB_V1();
      }
      TMAssistantCallYYB_V1 localTMAssistantCallYYB_V1 = mInstance;
      return localTMAssistantCallYYB_V1;
    }
    finally {}
  }
  
  private boolean isFileExist(String paramString)
  {
    if (new File(paramString).exists())
    {
      ab.c("TMAssistantCallYYB_V1", "File is exist");
      return true;
    }
    ab.c("TMAssistantCallYYB_V1", "File is not exist");
    return false;
  }
  
  private void relateToQQDownloader(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("context = ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(",param = ");
    localStringBuilder.append(paramTMAssistantCallYYBParamStruct);
    localStringBuilder.append(",taskId = ");
    localStringBuilder.append(paramString);
    ab.c("TMAssistantCallYYB_V1", localStringBuilder.toString());
    paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, false, false, paramString);
    paramTMAssistantCallYYBParamStruct.put("taskid", paramString);
    paramTMAssistantCallYYBParamStruct = super.formatIntentUriPath(4, paramTMAssistantCallYYBParamStruct);
    paramString = new Intent("com.tencent.android.qqdownloader.action.RELATED");
    paramString.setPackage("com.tencent.android.qqdownloader");
    paramString.putExtra("command", "cmd_updatedownload");
    paramString.putExtra("relatedurl", paramTMAssistantCallYYBParamStruct);
    paramContext.sendBroadcast(paramString);
  }
  
  public long addDownloadTaskFromAppDetail(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("param = ");
    ((StringBuilder)localObject1).append(paramTMAssistantCallYYBParamStruct);
    ((StringBuilder)localObject1).append(",isAutoDownload = ");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append(",isAutoInstall = ");
    ((StringBuilder)localObject1).append(paramBoolean2);
    ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject1).toString());
    localObject1 = UUID.randomUUID().toString();
    Object localObject2 = this.mDownloadParams;
    if ((localObject2 != null) && (paramTMAssistantCallYYBParamStruct != null))
    {
      ((Map)localObject2).put(localObject1, paramTMAssistantCallYYBParamStruct);
      localObject2 = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), (String)localObject1, "V1_addDownloadTaskFromAppDetail");
      com.tencent.tmassistantsdk.internal.logreport.b.g().a((JceStruct)localObject2);
    }
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 2, (String)localObject1);
    paramTMAssistantCallYYBParamStruct = new StringBuilder();
    paramTMAssistantCallYYBParamStruct.append("result = ");
    paramTMAssistantCallYYBParamStruct.append(l);
    ab.c("TMAssistantCallYYB_V1", paramTMAssistantCallYYBParamStruct.toString());
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("param = ");
    ((StringBuilder)localObject1).append(paramTMAssistantCallYYBParamStruct);
    ((StringBuilder)localObject1).append(",verifyType = ");
    ((StringBuilder)localObject1).append(paramString);
    ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject1).toString());
    localObject1 = UUID.randomUUID().toString();
    Object localObject2 = this.mDownloadParams;
    if ((localObject2 != null) && (paramTMAssistantCallYYBParamStruct != null))
    {
      ((Map)localObject2).put(localObject1, paramTMAssistantCallYYBParamStruct);
      localObject2 = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), (String)localObject1, "V1_addDownloadTaskFromAuthorize");
      com.tencent.tmassistantsdk.internal.logreport.b.g().a((JceStruct)localObject2);
    }
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, true, true, paramTMAssistantCallYYBParamStruct.actionFlag, paramString, 3, (String)localObject1);
    paramTMAssistantCallYYBParamStruct = new StringBuilder();
    paramTMAssistantCallYYBParamStruct.append("result = ");
    paramTMAssistantCallYYBParamStruct.append(l);
    ab.c("TMAssistantCallYYB_V1", paramTMAssistantCallYYBParamStruct.toString());
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("url = ");
    ((StringBuilder)localObject).append(paramString);
    ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject).toString());
    localObject = super.formatEncryptUrl(paramString);
    long l1 = System.currentTimeMillis();
    long l2 = l1 + 300000L;
    long l3 = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, (String)localObject, l1, l2, 0, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("result = ");
    ((StringBuilder)localObject).append(l3);
    ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject).toString());
    GlobalUtil.setClipboardCMD(this.mContext, paramString, l1, l2);
    return l3;
  }
  
  public long addDownloadTaskFromTaskList(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("param = ");
    ((StringBuilder)localObject1).append(paramTMAssistantCallYYBParamStruct);
    ((StringBuilder)localObject1).append(",isAutoDownload = ");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append(",isAutoInstall = ");
    ((StringBuilder)localObject1).append(paramBoolean2);
    ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject1).toString());
    localObject1 = UUID.randomUUID().toString();
    Object localObject2 = this.mDownloadParams;
    if ((localObject2 != null) && (paramTMAssistantCallYYBParamStruct != null))
    {
      ((Map)localObject2).put(localObject1, paramTMAssistantCallYYBParamStruct);
      localObject2 = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), (String)localObject1, "V1_addDownloadTaskFromTaskList");
      com.tencent.tmassistantsdk.internal.logreport.b.g().a((JceStruct)localObject2);
    }
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 1, (String)localObject1);
    paramTMAssistantCallYYBParamStruct = new StringBuilder();
    paramTMAssistantCallYYBParamStruct.append("result = ");
    paramTMAssistantCallYYBParamStruct.append(l);
    ab.c("TMAssistantCallYYB_V1", paramTMAssistantCallYYBParamStruct.toString());
    return l;
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mContext = ");
    localStringBuilder.append(this.mContext);
    ab.c("TMAssistantCallYYB_V1", localStringBuilder.toString());
    NetworkMonitorReceiver.getInstance().unregisterReceiver();
    com.tencent.tmassistantsdk.internal.logreport.e.a().b();
    if (this.mContext != null)
    {
      DownloadStateChangedReceiver.a().b(this.mContext);
      DownloadStateChangedReceiver.a().b(this);
    }
    GlobalUtil.getInstance().destroy();
    this.mContext = null;
  }
  
  /* Error */
  public TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 224	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mContext	Landroid/content/Context;
    //   4: ifnull +826 -> 830
    //   7: aload_1
    //   8: ifnull +803 -> 811
    //   11: new 72	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   18: astore 11
    //   20: aload 11
    //   22: ldc 137
    //   24: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 11
    //   30: aload_1
    //   31: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: ldc 15
    //   37: aload 11
    //   39: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 224	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mContext	Landroid/content/Context;
    //   49: invokevirtual 278	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   52: astore 15
    //   54: aconst_null
    //   55: astore 12
    //   57: aconst_null
    //   58: astore 13
    //   60: aconst_null
    //   61: astore 14
    //   63: aload 12
    //   65: astore 11
    //   67: getstatic 31	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:CONTENT_URI	Landroid/net/Uri;
    //   70: astore 16
    //   72: aload 12
    //   74: astore 11
    //   76: aload_1
    //   77: getfield 281	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   80: astore 17
    //   82: iconst_0
    //   83: istore_3
    //   84: aload 12
    //   86: astore 11
    //   88: aload 15
    //   90: aload 16
    //   92: aconst_null
    //   93: ldc_w 283
    //   96: iconst_3
    //   97: anewarray 285	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: aload 17
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: aload_1
    //   108: getfield 288	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   111: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   114: aastore
    //   115: dup
    //   116: iconst_2
    //   117: aload_1
    //   118: getfield 295	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:channelId	Ljava/lang/String;
    //   121: aastore
    //   122: aconst_null
    //   123: invokevirtual 301	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   126: astore 12
    //   128: new 72	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   135: astore 11
    //   137: aload 11
    //   139: ldc_w 303
    //   142: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 11
    //   148: aload_1
    //   149: getfield 281	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   152: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 11
    //   158: ldc_w 305
    //   161: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 11
    //   167: aload_1
    //   168: getfield 288	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   171: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   174: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 11
    //   180: ldc_w 307
    //   183: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 11
    //   189: aload_1
    //   190: getfield 295	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:channelId	Ljava/lang/String;
    //   193: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: ldc 15
    //   199: aload 11
    //   201: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 309	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload 14
    //   209: astore 11
    //   211: aload 12
    //   213: ifnull +456 -> 669
    //   216: aload 14
    //   218: astore 11
    //   220: aload 12
    //   222: invokeinterface 314 1 0
    //   227: ifeq +442 -> 669
    //   230: new 72	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   237: astore 11
    //   239: aload 11
    //   241: ldc_w 316
    //   244: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 11
    //   250: aload_1
    //   251: getfield 281	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   254: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc 15
    //   260: aload 11
    //   262: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 12
    //   270: aload 12
    //   272: ldc_w 318
    //   275: invokeinterface 322 2 0
    //   280: invokeinterface 326 2 0
    //   285: lstore 4
    //   287: aload 12
    //   289: aload 12
    //   291: ldc_w 328
    //   294: invokeinterface 322 2 0
    //   299: invokeinterface 331 2 0
    //   304: invokestatic 335	com/tencent/tmassistantbase/util/GlobalUtil:String2List	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   307: iconst_0
    //   308: invokevirtual 341	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   311: checkcast 285	java/lang/String
    //   314: astore 11
    //   316: aload 12
    //   318: aload 12
    //   320: ldc_w 343
    //   323: invokeinterface 322 2 0
    //   328: invokeinterface 331 2 0
    //   333: astore 13
    //   335: aload 12
    //   337: aload 12
    //   339: ldc_w 345
    //   342: invokeinterface 322 2 0
    //   347: invokeinterface 326 2 0
    //   352: lstore 6
    //   354: aload 12
    //   356: aload 12
    //   358: ldc_w 347
    //   361: invokeinterface 322 2 0
    //   366: invokeinterface 326 2 0
    //   371: lstore 8
    //   373: aload 12
    //   375: aload 12
    //   377: ldc_w 349
    //   380: invokeinterface 322 2 0
    //   385: invokeinterface 353 2 0
    //   390: invokestatic 356	com/tencent/tmassistantbase/util/GlobalUtil:assistantState2SDKState	(I)I
    //   393: istore_2
    //   394: new 72	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   401: astore 14
    //   403: aload 14
    //   405: ldc_w 358
    //   408: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 14
    //   414: iload_2
    //   415: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: ldc 15
    //   421: aload 14
    //   423: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: iconst_4
    //   430: iload_2
    //   431: if_icmpne +30 -> 461
    //   434: aload_0
    //   435: aload 13
    //   437: invokespecial 363	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:isFileExist	(Ljava/lang/String;)Z
    //   440: istore 10
    //   442: iload 10
    //   444: ifne +17 -> 461
    //   447: aload 12
    //   449: ifnull +10 -> 459
    //   452: aload 12
    //   454: invokeinterface 366 1 0
    //   459: aconst_null
    //   460: areturn
    //   461: new 368	com/tencent/tmassistantsdk/TMAssistantCallYYBTaskInfo
    //   464: dup
    //   465: aload 11
    //   467: aload 13
    //   469: iload_2
    //   470: lload 6
    //   472: lload 8
    //   474: ldc_w 370
    //   477: invokespecial 373	com/tencent/tmassistantsdk/TMAssistantCallYYBTaskInfo:<init>	(Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;)V
    //   480: astore 13
    //   482: aload_0
    //   483: getfield 39	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mDownloadParams	Ljava/util/Map;
    //   486: ifnull +168 -> 654
    //   489: aload_0
    //   490: getfield 39	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mDownloadParams	Ljava/util/Map;
    //   493: invokeinterface 377 1 0
    //   498: invokeinterface 383 1 0
    //   503: astore 11
    //   505: iload_3
    //   506: istore_2
    //   507: aload 11
    //   509: invokeinterface 388 1 0
    //   514: ifeq +57 -> 571
    //   517: aload 11
    //   519: invokeinterface 392 1 0
    //   524: checkcast 394	java/util/Map$Entry
    //   527: invokeinterface 397 1 0
    //   532: checkcast 170	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct
    //   535: astore 14
    //   537: aload 14
    //   539: ifnull -34 -> 505
    //   542: aload 14
    //   544: getfield 281	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   547: aload_1
    //   548: getfield 281	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   551: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   554: ifeq -49 -> 505
    //   557: aload 14
    //   559: getfield 288	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   562: aload_1
    //   563: getfield 288	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   566: if_icmpne -61 -> 505
    //   569: iconst_1
    //   570: istore_2
    //   571: iload_2
    //   572: ifne +82 -> 654
    //   575: new 72	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   582: astore 11
    //   584: aload 11
    //   586: ldc_w 316
    //   589: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 11
    //   595: aload_1
    //   596: getfield 281	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   599: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: ldc 15
    //   605: aload 11
    //   607: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: invokestatic 150	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   616: invokevirtual 151	java/util/UUID:toString	()Ljava/lang/String;
    //   619: astore 11
    //   621: aload_1
    //   622: lload 4
    //   624: invokestatic 404	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   627: putfield 407	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskApkId	Ljava/lang/String;
    //   630: aload_0
    //   631: getfield 39	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mDownloadParams	Ljava/util/Map;
    //   634: aload 11
    //   636: aload_1
    //   637: invokeinterface 102 3 0
    //   642: pop
    //   643: aload_0
    //   644: aload_0
    //   645: getfield 224	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mContext	Landroid/content/Context;
    //   648: aload_1
    //   649: aload 11
    //   651: invokespecial 409	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:relateToQQDownloader	(Landroid/content/Context;Lcom/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct;Ljava/lang/String;)V
    //   654: aload 13
    //   656: astore 11
    //   658: goto +11 -> 669
    //   661: astore 11
    //   663: aload 13
    //   665: astore_1
    //   666: goto +36 -> 702
    //   669: aload 11
    //   671: astore_1
    //   672: aload 12
    //   674: ifnull +86 -> 760
    //   677: aload 12
    //   679: invokeinterface 366 1 0
    //   684: aload 11
    //   686: astore_1
    //   687: goto +73 -> 760
    //   690: astore_1
    //   691: aload 12
    //   693: astore 11
    //   695: goto +102 -> 797
    //   698: astore 11
    //   700: aconst_null
    //   701: astore_1
    //   702: aload 11
    //   704: astore 13
    //   706: goto +19 -> 725
    //   709: astore_1
    //   710: goto +87 -> 797
    //   713: astore 11
    //   715: aconst_null
    //   716: astore_1
    //   717: aload 13
    //   719: astore 12
    //   721: aload 11
    //   723: astore 13
    //   725: aload 12
    //   727: astore 11
    //   729: aload 13
    //   731: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   734: aload 12
    //   736: astore 11
    //   738: ldc 15
    //   740: ldc_w 414
    //   743: aload 13
    //   745: invokestatic 417	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   748: aload 12
    //   750: ifnull +10 -> 760
    //   753: aload 12
    //   755: invokeinterface 366 1 0
    //   760: new 72	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   767: astore 11
    //   769: aload 11
    //   771: ldc_w 419
    //   774: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 11
    //   780: aload_1
    //   781: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: ldc 15
    //   787: aload 11
    //   789: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   795: aload_1
    //   796: areturn
    //   797: aload 11
    //   799: ifnull +10 -> 809
    //   802: aload 11
    //   804: invokeinterface 366 1 0
    //   809: aload_1
    //   810: athrow
    //   811: ldc 15
    //   813: ldc_w 421
    //   816: invokestatic 424	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   819: new 274	java/lang/Exception
    //   822: dup
    //   823: ldc_w 426
    //   826: invokespecial 427	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   829: athrow
    //   830: ldc 15
    //   832: ldc_w 429
    //   835: invokestatic 424	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   838: new 274	java/lang/Exception
    //   841: dup
    //   842: ldc_w 431
    //   845: invokespecial 427	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   848: astore_1
    //   849: goto +5 -> 854
    //   852: aload_1
    //   853: athrow
    //   854: goto -2 -> 852
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	857	0	this	TMAssistantCallYYB_V1
    //   0	857	1	paramTMAssistantCallYYBParamStruct	TMAssistantCallYYBParamStruct
    //   393	179	2	i	int
    //   83	423	3	j	int
    //   285	338	4	l1	long
    //   352	119	6	l2	long
    //   371	102	8	l3	long
    //   440	3	10	bool	boolean
    //   18	639	11	localObject1	Object
    //   661	24	11	localException1	Exception
    //   693	1	11	localObject2	Object
    //   698	5	11	localException2	Exception
    //   713	9	11	localException3	Exception
    //   727	76	11	localObject3	Object
    //   55	699	12	localObject4	Object
    //   58	686	13	localObject5	Object
    //   61	497	14	localObject6	Object
    //   52	37	15	localContentResolver	android.content.ContentResolver
    //   70	21	16	localUri	Uri
    //   80	23	17	str	String
    // Exception table:
    //   from	to	target	type
    //   482	505	661	java/lang/Exception
    //   507	537	661	java/lang/Exception
    //   542	569	661	java/lang/Exception
    //   575	654	661	java/lang/Exception
    //   128	207	690	finally
    //   220	429	690	finally
    //   434	442	690	finally
    //   461	482	690	finally
    //   482	505	690	finally
    //   507	537	690	finally
    //   542	569	690	finally
    //   575	654	690	finally
    //   128	207	698	java/lang/Exception
    //   220	429	698	java/lang/Exception
    //   434	442	698	java/lang/Exception
    //   461	482	698	java/lang/Exception
    //   67	72	709	finally
    //   76	82	709	finally
    //   88	128	709	finally
    //   729	734	709	finally
    //   738	748	709	finally
    //   67	72	713	java/lang/Exception
    //   76	82	713	java/lang/Exception
    //   88	128	713	java/lang/Exception
  }
  
  public void initTMAssistantCallYYBApi(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("context = ");
    localStringBuilder.append(paramContext);
    ab.c("TMAssistantCallYYB_V1", localStringBuilder.toString());
    this.mContext = paramContext;
    this.hostPackageName = paramContext.getPackageName();
    this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
    GlobalUtil.getInstance().setContext(this.mContext);
    this.sdkAPILevel = 1;
    DownloadStateChangedReceiver.a().a(this.mContext);
    DownloadStateChangedReceiver.a().a(this);
    NetworkMonitorReceiver.getInstance().registerReceiver();
    com.tencent.tmassistantsdk.internal.logreport.e.a();
  }
  
  public void onDownloadStateChanged(com.tencent.tmassistantsdk.internal.openSDK.e parame)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("stateChangedParam = ");
    ((StringBuilder)localObject1).append(parame);
    ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject1).toString());
    localObject1 = parame.a;
    int i = GlobalUtil.assistantState2SDKState(parame.e);
    int j = GlobalUtil.assistantErrorCode2SDKErrorCode(parame.f);
    Object localObject2 = parame.g;
    parame = parame.d;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onDownloadStateChanged state = ");
    ((StringBuilder)localObject3).append(i);
    ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject3).toString());
    if ((parame != null) && (parame.trim().length() > 0)) {
      parame = (TMAssistantCallYYBParamStruct)this.mDownloadParams.get(parame);
    } else {
      parame = null;
    }
    if (parame != null) {
      onStateChanged(parame, i, j, (String)localObject2);
    } else {
      ab.c("TMAssistantCallYYB_V1", "onDownloadStateChanged storeParam = null");
    }
    if (6 == i)
    {
      parame = new ArrayList();
      localObject2 = this.mDownloadParams.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = (TMAssistantCallYYBParamStruct)((Map.Entry)localObject4).getValue();
        localObject4 = (String)((Map.Entry)localObject4).getKey();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((TMAssistantCallYYBParamStruct)localObject1).taskPackageName)) && (((TMAssistantCallYYBParamStruct)localObject3).taskPackageName.equals(((TMAssistantCallYYBParamStruct)localObject1).taskPackageName)) && (((TMAssistantCallYYBParamStruct)localObject3).taskVersion == ((TMAssistantCallYYBParamStruct)localObject1).taskVersion)) {
          parame.add(localObject4);
        }
      }
      parame = parame.iterator();
      while (parame.hasNext())
      {
        localObject1 = (String)parame.next();
        this.mDownloadParams.remove(localObject1);
      }
    }
  }
  
  public void startToAppDetail(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext != null)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("param = ");
      ((StringBuilder)localObject1).append(paramTMAssistantCallYYBParamStruct);
      ((StringBuilder)localObject1).append(",isAutoDownload = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(",isAutoInstall = ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject1).toString());
      localObject1 = UUID.randomUUID().toString();
      Object localObject2 = this.mDownloadParams;
      if (localObject2 != null) {
        ((Map)localObject2).put(localObject1, paramTMAssistantCallYYBParamStruct);
      }
      localObject2 = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), (String)localObject1, "V1_startToAppDetail");
      com.tencent.tmassistantsdk.internal.logreport.b.g().a((JceStruct)localObject2);
      localObject2 = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, (String)localObject1);
      ((Map)localObject2).put("taskid", localObject1);
      localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(2, (Map)localObject2)));
      if ((paramContext instanceof Application)) {
        ((Intent)localObject1).addFlags(268435456);
      }
      ((Intent)localObject1).putExtra(TMAssistantCallYYBParamStruct.SOURCE_KEY, paramTMAssistantCallYYBParamStruct.source);
      ((Intent)localObject1).putExtra("packageName", paramTMAssistantCallYYBParamStruct.taskPackageName);
      paramContext.startActivity((Intent)localObject1);
      return;
    }
    ab.e("TMAssistantCallYYB_V1", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
  
  public void startToAuthorized(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    if (paramContext != null)
    {
      if (paramTMAssistantCallYYBParamStruct != null)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("context = ");
        ((StringBuilder)localObject1).append(paramContext);
        ((StringBuilder)localObject1).append(",param = ");
        ((StringBuilder)localObject1).append(paramTMAssistantCallYYBParamStruct);
        ((StringBuilder)localObject1).append(",verifyType = ");
        ((StringBuilder)localObject1).append(paramString);
        ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject1).toString());
        localObject1 = UUID.randomUUID().toString();
        Object localObject2 = this.mDownloadParams;
        if (localObject2 != null) {
          ((Map)localObject2).put(localObject1, paramTMAssistantCallYYBParamStruct);
        }
        localObject2 = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), (String)localObject1, "V1_startToAuthorized");
        com.tencent.tmassistantsdk.internal.logreport.b.g().a((JceStruct)localObject2);
        paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, true, true, (String)localObject1);
        paramTMAssistantCallYYBParamStruct.put("verifytype", paramString);
        paramTMAssistantCallYYBParamStruct.put("taskid", localObject1);
        paramTMAssistantCallYYBParamStruct = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(3, paramTMAssistantCallYYBParamStruct)));
        if ((paramContext instanceof Application)) {
          paramTMAssistantCallYYBParamStruct.addFlags(268435456);
        }
        paramContext.startActivity(paramTMAssistantCallYYBParamStruct);
        return;
      }
      ab.e("TMAssistantCallYYB_V1", "QQDownloaderParam param is null");
      throw new Exception("QQDownloaderParam param cann't be null!");
    }
    ab.e("TMAssistantCallYYB_V1", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("context = ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(",jumpUrl = ");
    localStringBuilder.append(paramString);
    ab.c("TMAssistantCallYYB_V1", localStringBuilder.toString());
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(formatEncryptUrl(paramString)));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
  
  public void startToDownloadTaskList(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext != null)
    {
      if (paramTMAssistantCallYYBParamStruct == null)
      {
        ab.e("TMAssistantCallYYB_V1", "param is null");
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("param = ");
      ((StringBuilder)localObject1).append(paramTMAssistantCallYYBParamStruct);
      ((StringBuilder)localObject1).append(",isAutoDownload = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(",isAutoInstall = ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject1).toString());
      localObject1 = UUID.randomUUID().toString();
      Object localObject2 = this.mDownloadParams;
      if (localObject2 != null) {
        ((Map)localObject2).put(localObject1, paramTMAssistantCallYYBParamStruct);
      }
      localObject2 = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), (String)localObject1, "V1_startToDownloadTaskList");
      com.tencent.tmassistantsdk.internal.logreport.b.g().a((JceStruct)localObject2);
      paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, (String)localObject1);
      paramTMAssistantCallYYBParamStruct.put("taskid", localObject1);
      paramTMAssistantCallYYBParamStruct = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(1, paramTMAssistantCallYYBParamStruct)));
      if ((paramContext instanceof Application)) {
        paramTMAssistantCallYYBParamStruct.addFlags(268435456);
      }
      paramContext.startActivity(paramTMAssistantCallYYBParamStruct);
      return;
    }
    ab.e("TMAssistantCallYYB_V1", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("context = ");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append(",url = ");
        ((StringBuilder)localObject).append(paramString);
        ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject).toString());
        localObject = new HashMap();
        ((Map)localObject).put("url", paramString);
        paramString = super.formatIntentUriPath(5, (Map)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startToWebView finalPath:");
        ((StringBuilder)localObject).append(paramString);
        ab.c("TMAssistantCallYYB_V1", ((StringBuilder)localObject).toString());
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        if ((paramContext instanceof Application)) {
          paramString.addFlags(268435456);
        }
        paramContext.startActivity(paramString);
        return;
      }
      ab.e("TMAssistantCallYYB_V1", "url is null");
      throw new Exception("param url shouldn't be null!");
    }
    ab.e("TMAssistantCallYYB_V1", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.TMAssistantCallYYB_V1
 * JD-Core Version:    0.7.0.1
 */