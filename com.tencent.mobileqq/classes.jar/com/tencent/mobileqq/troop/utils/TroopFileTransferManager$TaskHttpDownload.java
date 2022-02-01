package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TroopFileTransferManager$TaskHttpDownload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpDownload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 3);
    this.d = true;
  }
  
  private HttpURLConnection a(String paramString1, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean, TroopFileTransferManager.HttpDownloadRetCode paramHttpDownloadRetCode)
  {
    paramString2 = new StringBuilder();
    paramString2.append(paramLong1);
    paramString2.append("-");
    paramString2 = paramString2.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("?&range=");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("&mType=Other");
    paramString1 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<TroopFile> generateZipInnerConnection url:");
    ((StringBuilder)localObject).append(paramString1);
    QLog.i("TroopFileTransferManager", 1, ((StringBuilder)localObject).toString());
    this.a.downUrlStr4Report = paramString1;
    this.a.transferBeginTime = System.currentTimeMillis();
    try
    {
      localObject = new URL(paramString1);
      try
      {
        localObject = (HttpURLConnection)((URL)localObject).openConnection();
        if (localObject == null) {
          return null;
        }
        ((HttpURLConnection)localObject).setConnectTimeout(30000);
        ((HttpURLConnection)localObject).setReadTimeout(30000);
        ((HttpURLConnection)localObject).setRequestMethod("GET");
        ((HttpURLConnection)localObject).setRequestProperty("User-Agent", "Troop");
        if (paramLong2 != 0L)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("bytes=");
          localStringBuilder.append(paramString2);
          ((HttpURLConnection)localObject).setRequestProperty("Range", localStringBuilder.toString());
        }
        ((HttpURLConnection)localObject).setRequestProperty("Connection", "Keep-Alive");
        if (paramHttpDownloadRetCode != null) {
          paramHttpDownloadRetCode.a = ((HttpURLConnection)localObject).getResponseCode();
        }
        if ((((HttpURLConnection)localObject).getResponseCode() != 200) && (((HttpURLConnection)localObject).getResponseCode() != 206))
        {
          paramString2 = ((HttpURLConnection)localObject).getHeaderField("User-ReturnCode");
          if ((paramString2 != null) && (paramHttpDownloadRetCode != null)) {
            paramHttpDownloadRetCode.b = paramString2;
          }
          if (QLog.isColorLevel())
          {
            paramHttpDownloadRetCode = new StringBuilder();
            paramHttpDownloadRetCode.append("generateConnection, ret.getResponseCode():");
            paramHttpDownloadRetCode.append(((HttpURLConnection)localObject).getResponseCode());
            paramHttpDownloadRetCode.append(" strUsrRetCode:");
            paramHttpDownloadRetCode.append(paramString2);
            QLog.e("TroopFileTransferManager", 2, paramHttpDownloadRetCode.toString());
          }
          return null;
        }
        return localObject;
      }
      catch (NullPointerException paramString2)
      {
        if (QLog.isColorLevel())
        {
          paramHttpDownloadRetCode = new StringBuilder();
          paramHttpDownloadRetCode.append("getResponseCode URL: ");
          paramHttpDownloadRetCode.append(paramString1);
          paramHttpDownloadRetCode.append(", exception:");
          paramHttpDownloadRetCode.append(paramString2.getMessage());
          QLog.e("TroopFileTransferManager", 2, paramHttpDownloadRetCode.toString());
        }
        return null;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
    }
    catch (MalformedURLException paramString1)
    {
      label441:
      break label441;
    }
    if (paramBoolean) {
      this.this$0.a(this.a, 10, 102);
    }
    return null;
  }
  
  private HttpURLConnection a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String paramString5, boolean paramBoolean, TroopFileTransferManager.HttpDownloadRetCode paramHttpDownloadRetCode)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramLong2 - 1L);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder;
    if (paramLong1 == 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/ftn_handler/");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("/?fname=");
      localStringBuilder.append(HexUtil.string2HexString(paramString3));
      localStringBuilder.append(paramString5);
      paramString1 = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/ftn_handler/");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("/?fname=");
      localStringBuilder.append(HexUtil.string2HexString(paramString3));
      localStringBuilder.append("&range=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString5);
      paramString1 = localStringBuilder.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append("<TroopFile> generateConnection url:");
    paramString2.append(paramString1);
    QLog.i("TroopFileTransferManager", 1, paramString2.toString());
    this.a.downUrlStr4Report = paramString1;
    this.a.transferBeginTime = System.currentTimeMillis();
    try
    {
      paramString2 = new URL(paramString1);
      try
      {
        paramString2 = (HttpURLConnection)paramString2.openConnection();
        if (paramString2 == null) {
          return null;
        }
        paramString2.setConnectTimeout(30000);
        paramString2.setReadTimeout(30000);
        paramString2.setRequestMethod("GET");
        paramString2.setRequestProperty("User-Agent", "TroopFile");
        if (paramLong2 != 0L)
        {
          paramString3 = new StringBuilder();
          paramString3.append("bytes=");
          paramString3.append((String)localObject);
          paramString2.setRequestProperty("Range", paramString3.toString());
        }
        paramString2.setRequestProperty("Connection", "Keep-Alive");
        paramString3 = new StringBuilder();
        paramString3.append("FTN5K=");
        paramString3.append(paramString4);
        paramString2.setRequestProperty("Cookie", paramString3.toString());
        if (paramHttpDownloadRetCode != null) {
          paramHttpDownloadRetCode.a = paramString2.getResponseCode();
        }
        if ((paramString2.getResponseCode() != 200) && (paramString2.getResponseCode() != 206))
        {
          paramString3 = paramString2.getHeaderField("User-ReturnCode");
          if ((paramString3 != null) && (paramHttpDownloadRetCode != null)) {
            paramHttpDownloadRetCode.b = paramString3;
          }
          if (QLog.isColorLevel())
          {
            paramString4 = new StringBuilder();
            paramString4.append("generateConnection, ret.getResponseCode():");
            paramString4.append(paramString2.getResponseCode());
            paramString4.append(" strUsrRetCode:");
            paramString4.append(paramString3);
            QLog.e("TroopFileTransferManager", 2, paramString4.toString());
          }
          return null;
        }
        return paramString2;
      }
      catch (Exception paramString2)
      {
        paramString3 = new StringBuilder();
        paramString3.append("generateConnection error! url:");
        paramString3.append(paramString1);
        QLog.e("TroopFileTransferManager", 1, paramString3.toString(), paramString2);
        return null;
      }
    }
    catch (MalformedURLException paramString1)
    {
      label543:
      break label543;
    }
    if (paramBoolean) {
      this.this$0.a(this.a, 10, 102);
    }
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:h	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 206	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   18: istore 4
    //   20: ldc 52
    //   22: astore 10
    //   24: iload 4
    //   26: ifeq +11 -> 37
    //   29: ldc 52
    //   31: iconst_4
    //   32: ldc 208
    //   34: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: invokestatic 214	com/tencent/open/appcommon/Common:d	()Z
    //   40: ifne +29 -> 69
    //   43: aload_0
    //   44: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   47: aload_0
    //   48: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   51: bipush 10
    //   53: sipush 308
    //   56: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   59: getstatic 218	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   62: getstatic 221	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:n	I
    //   65: invokestatic 226	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   68: return
    //   69: new 228	java/io/File
    //   72: dup
    //   73: getstatic 233	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_TROOPTMP_PATH	Ljava/lang/String;
    //   76: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 9
    //   81: aload 9
    //   83: invokevirtual 237	java/io/File:exists	()Z
    //   86: ifne +9 -> 95
    //   89: aload 9
    //   91: invokevirtual 240	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload_0
    //   96: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   99: astore 9
    //   101: new 28	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   108: astore 11
    //   110: aload 11
    //   112: getstatic 233	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_TROOPTMP_PATH	Ljava/lang/String;
    //   115: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 11
    //   121: aload_0
    //   122: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   125: getfield 243	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   128: invokevirtual 249	java/lang/String:getBytes	()[B
    //   131: invokestatic 253	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   134: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 11
    //   140: ldc 255
    //   142: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 9
    //   148: aload 11
    //   150: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: putfield 258	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   156: new 228	java/io/File
    //   159: dup
    //   160: aload_0
    //   161: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   164: getfield 258	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   167: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore 11
    //   172: aload 11
    //   174: invokevirtual 237	java/io/File:exists	()Z
    //   177: ifne +38 -> 215
    //   180: aload 11
    //   182: invokevirtual 261	java/io/File:createNewFile	()Z
    //   185: pop
    //   186: goto +29 -> 215
    //   189: aload_0
    //   190: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   193: aload_0
    //   194: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   197: bipush 10
    //   199: sipush 303
    //   202: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   205: getstatic 218	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   208: getstatic 263	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:h	I
    //   211: invokestatic 226	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   214: return
    //   215: aload_0
    //   216: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   219: aload 11
    //   221: invokevirtual 266	java/io/File:length	()J
    //   224: putfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   227: aload_0
    //   228: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   231: iconst_0
    //   232: putfield 272	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   235: aload_0
    //   236: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   239: getfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   242: aload_0
    //   243: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   246: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   249: lcmp
    //   250: ifgt +29 -> 279
    //   253: aload 11
    //   255: astore 9
    //   257: aload_0
    //   258: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   261: getfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   264: lconst_0
    //   265: lcmp
    //   266: ifne +6 -> 272
    //   269: goto +10 -> 279
    //   272: aload 9
    //   274: astore 12
    //   276: goto +1368 -> 1644
    //   279: iconst_0
    //   280: istore_1
    //   281: iconst_0
    //   282: istore_3
    //   283: aload 11
    //   285: astore 9
    //   287: aload_0
    //   288: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   291: getfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   294: aload_0
    //   295: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   298: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   301: lcmp
    //   302: ifne +6 -> 308
    //   305: goto -33 -> 272
    //   308: iload_1
    //   309: iconst_3
    //   310: if_icmplt +87 -> 397
    //   313: aload_0
    //   314: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   317: aload_0
    //   318: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   321: bipush 10
    //   323: bipush 105
    //   325: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   328: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +45 -> 376
    //   334: new 28	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   341: astore 9
    //   343: aload 9
    //   345: ldc_w 277
    //   348: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 9
    //   354: aload_0
    //   355: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   358: getfield 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   361: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 10
    //   367: iconst_2
    //   368: aload 9
    //   370: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: iload_3
    //   377: ifne +19 -> 396
    //   380: getstatic 282	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   383: getstatic 285	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:p	I
    //   386: aload_0
    //   387: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   390: getfield 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   393: invokestatic 288	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(IILjava/lang/String;)V
    //   396: return
    //   397: iload_1
    //   398: ifle +119 -> 517
    //   401: invokestatic 294	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   404: invokestatic 300	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   407: ifne +28 -> 435
    //   410: aload_0
    //   411: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   414: aload_0
    //   415: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   418: bipush 10
    //   420: bipush 106
    //   422: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   425: getstatic 218	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   428: getstatic 303	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   431: invokestatic 226	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   434: return
    //   435: iconst_0
    //   436: istore_2
    //   437: iload_2
    //   438: iload_1
    //   439: bipush 100
    //   441: imul
    //   442: if_icmpge +75 -> 517
    //   445: ldc2_w 304
    //   448: invokestatic 311	java/lang/Thread:sleep	(J)V
    //   451: goto +10 -> 461
    //   454: astore 11
    //   456: aload 11
    //   458: invokevirtual 312	java/lang/InterruptedException:printStackTrace	()V
    //   461: aload_0
    //   462: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   465: aload_0
    //   466: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   469: invokevirtual 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:h	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   472: ifeq +4 -> 476
    //   475: return
    //   476: invokestatic 294	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   479: invokestatic 300	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   482: ifne +28 -> 510
    //   485: aload_0
    //   486: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   489: aload_0
    //   490: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   493: bipush 10
    //   495: bipush 106
    //   497: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   500: getstatic 218	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   503: getstatic 303	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   506: invokestatic 226	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   509: return
    //   510: iload_2
    //   511: iconst_1
    //   512: iadd
    //   513: istore_2
    //   514: goto -77 -> 437
    //   517: aload_0
    //   518: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   521: aload_0
    //   522: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   525: invokevirtual 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:h	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   528: ifeq +4 -> 532
    //   531: return
    //   532: iload_1
    //   533: iconst_1
    //   534: iadd
    //   535: istore_1
    //   536: aload_0
    //   537: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   540: iload_1
    //   541: putfield 272	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   544: aconst_null
    //   545: astore 16
    //   547: aconst_null
    //   548: astore 15
    //   550: new 122	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode
    //   553: dup
    //   554: aload_0
    //   555: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   558: invokespecial 315	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
    //   561: astore 11
    //   563: aload 16
    //   565: astore 12
    //   567: aload 11
    //   569: astore 14
    //   571: iload_1
    //   572: istore_2
    //   573: aload 9
    //   575: astore 13
    //   577: aload_0
    //   578: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   581: invokevirtual 318	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:i	()Lmqq/manager/ProxyIpManager;
    //   584: ifnull +324 -> 908
    //   587: aload 16
    //   589: astore 12
    //   591: aload 11
    //   593: astore 14
    //   595: iload_1
    //   596: istore_2
    //   597: aload 9
    //   599: astore 13
    //   601: aload_0
    //   602: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   605: getfield 321	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   608: ifne +300 -> 908
    //   611: aload_0
    //   612: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   615: invokevirtual 318	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:i	()Lmqq/manager/ProxyIpManager;
    //   618: iconst_5
    //   619: invokeinterface 327 2 0
    //   624: astore 17
    //   626: aload 16
    //   628: astore 12
    //   630: aload 11
    //   632: astore 14
    //   634: iload_1
    //   635: istore_2
    //   636: aload 9
    //   638: astore 13
    //   640: aload 17
    //   642: ifnull +266 -> 908
    //   645: aload 16
    //   647: astore 12
    //   649: aload 11
    //   651: astore 14
    //   653: iload_1
    //   654: istore_2
    //   655: aload 9
    //   657: astore 13
    //   659: aload 17
    //   661: invokeinterface 332 1 0
    //   666: ifne +242 -> 908
    //   669: aload 17
    //   671: invokeinterface 336 1 0
    //   676: astore 16
    //   678: aload 15
    //   680: astore 12
    //   682: aload 11
    //   684: astore 14
    //   686: iload_1
    //   687: istore_2
    //   688: aload 9
    //   690: astore 13
    //   692: aload 16
    //   694: invokeinterface 341 1 0
    //   699: ifeq +209 -> 908
    //   702: aload 16
    //   704: invokeinterface 345 1 0
    //   709: checkcast 347	mqq/manager/ProxyIpManager$ProxyIp
    //   712: astore 13
    //   714: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq +38 -> 755
    //   720: aload 10
    //   722: iconst_2
    //   723: ldc_w 349
    //   726: iconst_2
    //   727: anewarray 351	java/lang/Object
    //   730: dup
    //   731: iconst_0
    //   732: aload 13
    //   734: getfield 354	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   737: aastore
    //   738: dup
    //   739: iconst_1
    //   740: aload 13
    //   742: getfield 357	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   745: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   748: aastore
    //   749: invokestatic 367	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   752: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   755: ldc_w 369
    //   758: iconst_2
    //   759: anewarray 351	java/lang/Object
    //   762: dup
    //   763: iconst_0
    //   764: aload_0
    //   765: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   768: getfield 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   771: aastore
    //   772: dup
    //   773: iconst_1
    //   774: bipush 80
    //   776: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   779: aastore
    //   780: invokestatic 367	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   783: astore 12
    //   785: aload 13
    //   787: getfield 354	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   790: astore 13
    //   792: aload_0
    //   793: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   796: getfield 372	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   799: astore 14
    //   801: aload_0
    //   802: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   805: getfield 243	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   808: astore 15
    //   810: aload_0
    //   811: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   814: astore 17
    //   816: aload 17
    //   818: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   821: lstore 5
    //   823: aload_0
    //   824: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   827: getfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   830: lstore 7
    //   832: aload_0
    //   833: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   836: getfield 375	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   839: astore 17
    //   841: aload_0
    //   842: aload 13
    //   844: aload 14
    //   846: aload 15
    //   848: lload 5
    //   850: lload 7
    //   852: aload 17
    //   854: aload 12
    //   856: iconst_0
    //   857: aload 11
    //   859: invokespecial 377	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode;)Ljava/net/HttpURLConnection;
    //   862: astore 12
    //   864: aload 12
    //   866: ifnull +39 -> 905
    //   869: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   872: ifeq +26 -> 898
    //   875: aload 10
    //   877: iconst_2
    //   878: ldc_w 379
    //   881: iconst_0
    //   882: anewarray 351	java/lang/Object
    //   885: invokestatic 367	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   888: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: aload 11
    //   893: astore 13
    //   895: goto +23 -> 918
    //   898: aload 11
    //   900: astore 13
    //   902: goto +16 -> 918
    //   905: goto -223 -> 682
    //   908: iload_2
    //   909: istore_1
    //   910: aload 13
    //   912: astore 9
    //   914: aload 14
    //   916: astore 13
    //   918: aload 12
    //   920: ifnonnull +342 -> 1262
    //   923: aload_0
    //   924: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   927: getfield 321	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   930: ifeq +53 -> 983
    //   933: aload_0
    //   934: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   937: getfield 382	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   940: ifnull +43 -> 983
    //   943: aload_0
    //   944: aload_0
    //   945: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   948: getfield 382	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   951: aload_0
    //   952: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   955: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   958: aload_0
    //   959: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   962: getfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   965: aload_0
    //   966: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   969: getfield 375	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   972: iconst_0
    //   973: aload 13
    //   975: invokespecial 384	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;JJLjava/lang/String;ZLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode;)Ljava/net/HttpURLConnection;
    //   978: astore 11
    //   980: goto +57 -> 1037
    //   983: aload_0
    //   984: aload_0
    //   985: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   988: getfield 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   991: aload_0
    //   992: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   995: getfield 372	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   998: aload_0
    //   999: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1002: getfield 243	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   1005: aload_0
    //   1006: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1009: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1012: aload_0
    //   1013: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1016: getfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1019: aload_0
    //   1020: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1023: getfield 375	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1026: ldc_w 386
    //   1029: iconst_1
    //   1030: aload 13
    //   1032: invokespecial 377	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode;)Ljava/net/HttpURLConnection;
    //   1035: astore 11
    //   1037: aload 11
    //   1039: ifnonnull +190 -> 1229
    //   1042: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1045: ifeq +80 -> 1125
    //   1048: new 28	java/lang/StringBuilder
    //   1051: dup
    //   1052: ldc_w 388
    //   1055: invokespecial 389	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1058: astore 11
    //   1060: aload 11
    //   1062: iload_1
    //   1063: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload 11
    //   1069: ldc_w 391
    //   1072: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload 11
    //   1078: aload_0
    //   1079: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1082: getfield 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1085: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: pop
    //   1089: aload 11
    //   1091: ldc_w 393
    //   1094: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: aload 11
    //   1100: aload_0
    //   1101: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1104: getfield 372	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1107: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload 10
    //   1113: iconst_2
    //   1114: aload 11
    //   1116: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: goto +3 -> 1125
    //   1125: iload_1
    //   1126: istore_2
    //   1127: iload_2
    //   1128: iconst_3
    //   1129: if_icmpne +95 -> 1224
    //   1132: getstatic 396	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:z	I
    //   1135: istore_3
    //   1136: iload_3
    //   1137: istore_1
    //   1138: aload 13
    //   1140: getfield 125	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode:a	I
    //   1143: sipush 200
    //   1146: if_icmpeq +22 -> 1168
    //   1149: iload_3
    //   1150: istore_1
    //   1151: aload 13
    //   1153: getfield 125	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode:a	I
    //   1156: sipush 206
    //   1159: if_icmpeq +9 -> 1168
    //   1162: aload 13
    //   1164: getfield 125	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode:a	I
    //   1167: istore_1
    //   1168: iload_1
    //   1169: istore_3
    //   1170: aload 13
    //   1172: getfield 134	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode:b	Ljava/lang/String;
    //   1175: ifnull +28 -> 1203
    //   1178: iload_1
    //   1179: istore_3
    //   1180: aload 13
    //   1182: getfield 134	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode:b	Ljava/lang/String;
    //   1185: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1188: ifne +15 -> 1203
    //   1191: aload 13
    //   1193: getfield 134	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$HttpDownloadRetCode:b	Ljava/lang/String;
    //   1196: invokestatic 404	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1199: invokevirtual 407	java/lang/Integer:intValue	()I
    //   1202: istore_3
    //   1203: getstatic 282	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   1206: iload_3
    //   1207: aload_0
    //   1208: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1211: getfield 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1214: invokestatic 288	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(IILjava/lang/String;)V
    //   1217: iconst_1
    //   1218: istore_3
    //   1219: iload_2
    //   1220: istore_1
    //   1221: goto -934 -> 287
    //   1224: iload_2
    //   1225: istore_1
    //   1226: goto -939 -> 287
    //   1229: aload 11
    //   1231: astore 13
    //   1233: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1236: ifeq +30 -> 1266
    //   1239: aload 10
    //   1241: iconst_2
    //   1242: ldc_w 409
    //   1245: iconst_0
    //   1246: anewarray 351	java/lang/Object
    //   1249: invokestatic 367	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1252: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1255: aload 11
    //   1257: astore 13
    //   1259: goto +7 -> 1266
    //   1262: aload 12
    //   1264: astore 13
    //   1266: new 411	java/io/BufferedInputStream
    //   1269: dup
    //   1270: aload 13
    //   1272: invokevirtual 415	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1275: invokespecial 418	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1278: astore 15
    //   1280: aload_0
    //   1281: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1284: getfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1287: lconst_0
    //   1288: lcmp
    //   1289: ifne +16 -> 1305
    //   1292: aload_0
    //   1293: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1296: aload 13
    //   1298: invokevirtual 421	java/net/HttpURLConnection:getContentLength	()I
    //   1301: i2l
    //   1302: putfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1305: aload 9
    //   1307: astore 12
    //   1309: new 423	java/io/FileOutputStream
    //   1312: dup
    //   1313: aload 12
    //   1315: iconst_1
    //   1316: invokespecial 426	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1319: astore 14
    //   1321: sipush 8192
    //   1324: newarray byte
    //   1326: astore 16
    //   1328: aload 15
    //   1330: aload 16
    //   1332: invokevirtual 432	java/io/InputStream:read	([B)I
    //   1335: istore_2
    //   1336: iload_2
    //   1337: iconst_m1
    //   1338: if_icmpeq +293 -> 1631
    //   1341: aload_0
    //   1342: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1345: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1348: lstore 5
    //   1350: iload_2
    //   1351: i2l
    //   1352: lstore 7
    //   1354: aload_0
    //   1355: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1358: astore 17
    //   1360: aload 10
    //   1362: astore 11
    //   1364: lload 5
    //   1366: lload 7
    //   1368: ladd
    //   1369: aload 17
    //   1371: getfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1374: lcmp
    //   1375: ifle +47 -> 1422
    //   1378: aload_0
    //   1379: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1382: astore 11
    //   1384: aload_0
    //   1385: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1388: astore 12
    //   1390: aload 11
    //   1392: aload 12
    //   1394: bipush 10
    //   1396: sipush 305
    //   1399: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1402: getstatic 218	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1405: getstatic 435	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:q	I
    //   1408: invokestatic 226	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   1411: aload 15
    //   1413: invokevirtual 438	java/io/InputStream:close	()V
    //   1416: aload 14
    //   1418: invokevirtual 439	java/io/FileOutputStream:close	()V
    //   1421: return
    //   1422: aload 14
    //   1424: aload 16
    //   1426: iconst_0
    //   1427: iload_2
    //   1428: invokevirtual 443	java/io/FileOutputStream:write	([BII)V
    //   1431: aload_0
    //   1432: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1435: astore 17
    //   1437: aload 17
    //   1439: aload 17
    //   1441: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1444: lload 7
    //   1446: ladd
    //   1447: putfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1450: aload_0
    //   1451: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1454: astore 17
    //   1456: aload 17
    //   1458: aload 17
    //   1460: getfield 446	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1463: lload 7
    //   1465: ladd
    //   1466: putfield 446	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1469: aload_0
    //   1470: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1473: iconst_1
    //   1474: lload 7
    //   1476: invokestatic 449	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
    //   1479: aload_0
    //   1480: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1483: aload_0
    //   1484: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1487: invokevirtual 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:h	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   1490: istore 4
    //   1492: iload 4
    //   1494: ifeq +14 -> 1508
    //   1497: aload 15
    //   1499: invokevirtual 438	java/io/InputStream:close	()V
    //   1502: aload 14
    //   1504: invokevirtual 439	java/io/FileOutputStream:close	()V
    //   1507: return
    //   1508: aload_0
    //   1509: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1512: iconst_0
    //   1513: putfield 272	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   1516: aload_0
    //   1517: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1520: aload_0
    //   1521: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1524: invokevirtual 452	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1527: aload_0
    //   1528: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1531: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1534: lstore 5
    //   1536: aload_0
    //   1537: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1540: getfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1543: lstore 7
    //   1545: lload 5
    //   1547: lload 7
    //   1549: lcmp
    //   1550: ifne +6 -> 1556
    //   1553: goto +78 -> 1631
    //   1556: aload 11
    //   1558: astore 10
    //   1560: iconst_0
    //   1561: istore_1
    //   1562: goto -234 -> 1328
    //   1565: astore 12
    //   1567: iconst_0
    //   1568: istore_1
    //   1569: aload 11
    //   1571: astore 10
    //   1573: goto +561 -> 2134
    //   1576: astore 11
    //   1578: goto +46 -> 1624
    //   1581: aload_0
    //   1582: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1585: aload_0
    //   1586: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1589: bipush 10
    //   1591: sipush 306
    //   1594: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1597: getstatic 218	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1600: getstatic 454	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:i	I
    //   1603: invokestatic 226	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   1606: aload 15
    //   1608: invokevirtual 438	java/io/InputStream:close	()V
    //   1611: aload 14
    //   1613: invokevirtual 439	java/io/FileOutputStream:close	()V
    //   1616: return
    //   1617: astore 11
    //   1619: goto +5 -> 1624
    //   1622: astore 11
    //   1624: aload 11
    //   1626: astore 12
    //   1628: goto +501 -> 2129
    //   1631: aload 15
    //   1633: invokevirtual 438	java/io/InputStream:close	()V
    //   1636: aload 14
    //   1638: invokevirtual 439	java/io/FileOutputStream:close	()V
    //   1641: goto +3 -> 1644
    //   1644: aload_0
    //   1645: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1648: getfield 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1651: invokevirtual 459	java/lang/String:length	()I
    //   1654: bipush 85
    //   1656: if_icmple +132 -> 1788
    //   1659: aload_0
    //   1660: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1663: getfield 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1666: bipush 46
    //   1668: invokevirtual 463	java/lang/String:lastIndexOf	(I)I
    //   1671: istore_2
    //   1672: iload_2
    //   1673: istore_1
    //   1674: iload_2
    //   1675: ifge +5 -> 1680
    //   1678: iconst_0
    //   1679: istore_1
    //   1680: aload_0
    //   1681: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1684: getfield 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1687: invokevirtual 459	java/lang/String:length	()I
    //   1690: bipush 85
    //   1692: isub
    //   1693: istore_2
    //   1694: iload_1
    //   1695: ifne +26 -> 1721
    //   1698: aload_0
    //   1699: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1702: aload_0
    //   1703: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1706: getfield 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1709: iconst_0
    //   1710: bipush 85
    //   1712: invokevirtual 467	java/lang/String:substring	(II)Ljava/lang/String;
    //   1715: putfield 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1718: goto +70 -> 1788
    //   1721: iload_1
    //   1722: iload_2
    //   1723: if_icmple +65 -> 1788
    //   1726: new 28	java/lang/StringBuilder
    //   1729: dup
    //   1730: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   1733: astore 9
    //   1735: aload 9
    //   1737: aload_0
    //   1738: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1741: getfield 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1744: iconst_0
    //   1745: iload_1
    //   1746: iload_2
    //   1747: isub
    //   1748: invokevirtual 467	java/lang/String:substring	(II)Ljava/lang/String;
    //   1751: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: pop
    //   1755: aload 9
    //   1757: aload_0
    //   1758: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1761: getfield 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1764: iload_1
    //   1765: invokevirtual 470	java/lang/String:substring	(I)Ljava/lang/String;
    //   1768: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: pop
    //   1772: aload 9
    //   1774: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1777: astore 9
    //   1779: aload_0
    //   1780: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1783: aload 9
    //   1785: putfield 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1788: aload_0
    //   1789: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1792: getfield 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1795: astore 10
    //   1797: aload 10
    //   1799: astore 9
    //   1801: aload_0
    //   1802: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1805: getfield 473	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   1808: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1811: ifne +27 -> 1838
    //   1814: aload 10
    //   1816: astore 9
    //   1818: aload_0
    //   1819: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1822: getfield 476	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:SafeCheckRes	I
    //   1825: iconst_2
    //   1826: if_icmpne +12 -> 1838
    //   1829: aload_0
    //   1830: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1833: getfield 473	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   1836: astore 9
    //   1838: iconst_0
    //   1839: istore_1
    //   1840: iload_1
    //   1841: sipush 1000
    //   1844: if_icmpge +257 -> 2101
    //   1847: iload_1
    //   1848: ifle +97 -> 1945
    //   1851: aload 9
    //   1853: bipush 46
    //   1855: invokevirtual 463	java/lang/String:lastIndexOf	(I)I
    //   1858: istore_3
    //   1859: iload_3
    //   1860: istore_2
    //   1861: iload_3
    //   1862: ifge +5 -> 1867
    //   1865: iconst_0
    //   1866: istore_2
    //   1867: new 28	java/lang/StringBuilder
    //   1870: dup
    //   1871: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   1874: astore 10
    //   1876: aload 10
    //   1878: getstatic 479	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_PATH	Ljava/lang/String;
    //   1881: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: pop
    //   1885: aload 10
    //   1887: aload 9
    //   1889: iconst_0
    //   1890: iload_2
    //   1891: invokevirtual 467	java/lang/String:substring	(II)Ljava/lang/String;
    //   1894: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1897: pop
    //   1898: aload 10
    //   1900: ldc_w 481
    //   1903: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: pop
    //   1907: aload 10
    //   1909: iload_1
    //   1910: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1913: pop
    //   1914: aload 10
    //   1916: ldc_w 483
    //   1919: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1922: pop
    //   1923: aload 10
    //   1925: aload 9
    //   1927: iload_2
    //   1928: invokevirtual 470	java/lang/String:substring	(I)Ljava/lang/String;
    //   1931: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: pop
    //   1935: aload 10
    //   1937: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1940: astore 10
    //   1942: goto +36 -> 1978
    //   1945: new 28	java/lang/StringBuilder
    //   1948: dup
    //   1949: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   1952: astore 10
    //   1954: aload 10
    //   1956: getstatic 479	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_PATH	Ljava/lang/String;
    //   1959: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1962: pop
    //   1963: aload 10
    //   1965: aload 9
    //   1967: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: pop
    //   1971: aload 10
    //   1973: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1976: astore 10
    //   1978: new 228	java/io/File
    //   1981: dup
    //   1982: aload 10
    //   1984: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   1987: astore 11
    //   1989: aload 11
    //   1991: invokevirtual 237	java/io/File:exists	()Z
    //   1994: ifne +100 -> 2094
    //   1997: aload 12
    //   1999: aload 11
    //   2001: invokevirtual 487	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2004: ifeq +90 -> 2094
    //   2007: aload_0
    //   2008: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2011: aload 10
    //   2013: putfield 490	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   2016: aload_0
    //   2017: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2020: aload_0
    //   2021: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2024: bipush 11
    //   2026: invokevirtual 493	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   2029: aload_0
    //   2030: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2033: getfield 497	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   2036: invokestatic 253	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   2039: astore 9
    //   2041: aload_0
    //   2042: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2045: getfield 500	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   2048: invokestatic 253	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   2051: astore 10
    //   2053: aload_0
    //   2054: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2057: aload_0
    //   2058: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2061: aload_0
    //   2062: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2065: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:k	J
    //   2068: invokevirtual 506	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   2071: iconst_0
    //   2072: aload 9
    //   2074: aload 10
    //   2076: aload_0
    //   2077: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2080: getfield 509	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   2083: invokevirtual 512	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2086: getstatic 513	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:a	I
    //   2089: iconst_0
    //   2090: invokestatic 226	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   2093: return
    //   2094: iload_1
    //   2095: iconst_1
    //   2096: iadd
    //   2097: istore_1
    //   2098: goto -258 -> 1840
    //   2101: aload_0
    //   2102: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2105: aload_0
    //   2106: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2109: bipush 10
    //   2111: sipush 307
    //   2114: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2117: getstatic 218	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   2120: getstatic 516	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:o	I
    //   2123: invokestatic 226	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   2126: return
    //   2127: astore 12
    //   2129: goto +5 -> 2134
    //   2132: astore 12
    //   2134: aload 15
    //   2136: invokevirtual 438	java/io/InputStream:close	()V
    //   2139: aload 14
    //   2141: invokevirtual 439	java/io/FileOutputStream:close	()V
    //   2144: aload 12
    //   2146: athrow
    //   2147: astore 11
    //   2149: goto +44 -> 2193
    //   2152: astore 11
    //   2154: goto +39 -> 2193
    //   2157: goto +3 -> 2160
    //   2160: aload_0
    //   2161: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2164: aload_0
    //   2165: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2168: bipush 10
    //   2170: sipush 304
    //   2173: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2176: getstatic 218	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   2179: getstatic 519	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:g	I
    //   2182: invokestatic 226	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   2185: return
    //   2186: astore 11
    //   2188: goto +5 -> 2193
    //   2191: astore 11
    //   2193: invokestatic 206	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2196: ifeq +46 -> 2242
    //   2199: new 28	java/lang/StringBuilder
    //   2202: dup
    //   2203: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   2206: astore 12
    //   2208: aload 12
    //   2210: ldc_w 521
    //   2213: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2216: pop
    //   2217: aload 12
    //   2219: aload 11
    //   2221: invokevirtual 522	java/io/IOException:toString	()Ljava/lang/String;
    //   2224: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: pop
    //   2228: aload 10
    //   2230: iconst_4
    //   2231: aload 12
    //   2233: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2236: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2239: goto +3 -> 2242
    //   2242: aload 11
    //   2244: instanceof 524
    //   2247: ifeq +97 -> 2344
    //   2250: sipush 206
    //   2253: aload 13
    //   2255: invokevirtual 120	java/net/HttpURLConnection:getResponseCode	()I
    //   2258: if_icmpne +86 -> 2344
    //   2261: aload_0
    //   2262: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2265: aload_0
    //   2266: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2269: bipush 10
    //   2271: bipush 105
    //   2273: invokevirtual 163	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2276: getstatic 282	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   2279: aload 13
    //   2281: invokevirtual 120	java/net/HttpURLConnection:getResponseCode	()I
    //   2284: aload_0
    //   2285: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2288: getfield 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   2291: invokestatic 288	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(IILjava/lang/String;)V
    //   2294: return
    //   2295: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2298: ifeq +46 -> 2344
    //   2301: new 28	java/lang/StringBuilder
    //   2304: dup
    //   2305: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   2308: astore 12
    //   2310: aload 12
    //   2312: ldc_w 521
    //   2315: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2318: pop
    //   2319: aload 12
    //   2321: aload 11
    //   2323: invokevirtual 522	java/io/IOException:toString	()Ljava/lang/String;
    //   2326: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2329: pop
    //   2330: aload 10
    //   2332: iconst_4
    //   2333: aload 12
    //   2335: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2338: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2341: goto +3 -> 2344
    //   2344: invokestatic 206	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2347: ifeq +39 -> 2386
    //   2350: new 28	java/lang/StringBuilder
    //   2353: dup
    //   2354: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   2357: astore 11
    //   2359: aload 11
    //   2361: ldc_w 526
    //   2364: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2367: pop
    //   2368: aload 11
    //   2370: iload_1
    //   2371: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2374: pop
    //   2375: aload 10
    //   2377: iconst_4
    //   2378: aload 11
    //   2380: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2383: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2386: goto -2099 -> 287
    //   2389: astore 9
    //   2391: goto -2202 -> 189
    //   2394: astore 11
    //   2396: iload_1
    //   2397: istore_3
    //   2398: goto -1195 -> 1203
    //   2401: astore 9
    //   2403: goto -243 -> 2160
    //   2406: astore 11
    //   2408: goto -251 -> 2157
    //   2411: astore 9
    //   2413: goto -997 -> 1416
    //   2416: astore 9
    //   2418: return
    //   2419: astore 11
    //   2421: goto -840 -> 1581
    //   2424: astore 9
    //   2426: goto -924 -> 1502
    //   2429: astore 9
    //   2431: return
    //   2432: astore 9
    //   2434: goto -823 -> 1611
    //   2437: astore 9
    //   2439: return
    //   2440: astore 9
    //   2442: goto -806 -> 1636
    //   2445: astore 9
    //   2447: goto -803 -> 1644
    //   2450: astore 11
    //   2452: goto -313 -> 2139
    //   2455: astore 11
    //   2457: goto -313 -> 2144
    //   2460: astore 12
    //   2462: goto -167 -> 2295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2465	0	this	TaskHttpDownload
    //   280	2117	1	i	int
    //   436	1492	2	j	int
    //   282	2116	3	k	int
    //   18	1475	4	bool	boolean
    //   821	725	5	l1	long
    //   830	718	7	l2	long
    //   79	1994	9	localObject1	Object
    //   2389	1	9	localIOException1	IOException
    //   22	2354	10	localObject2	Object
    //   108	176	11	localObject3	Object
    //   454	3	11	localInterruptedException	java.lang.InterruptedException
    //   561	1009	11	localObject4	Object
    //   1576	1	11	localObject5	Object
    //   1617	1	11	localObject6	Object
    //   1622	3	11	localObject7	Object
    //   1987	13	11	localFile	java.io.File
    //   2147	1	11	localIOException2	IOException
    //   2152	1	11	localIOException3	IOException
    //   2186	1	11	localIOException4	IOException
    //   2191	131	11	localIOException5	IOException
    //   2357	22	11	localStringBuilder1	StringBuilder
    //   2394	1	11	localNumberFormatException	java.lang.NumberFormatException
    //   274	1119	12	localObject8	Object
    //   1565	1	12	localObject9	Object
    //   1626	372	12	localObject10	Object
    //   2127	1	12	localObject11	Object
    //   2132	13	12	localObject12	Object
    //   2206	128	12	localStringBuilder2	StringBuilder
    //   575	1705	13	localObject13	Object
    //   569	1571	14	localObject14	Object
    //   548	1587	15	localObject15	Object
    //   545	880	16	localObject16	Object
    //   624	835	17	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   445	451	454	java/lang/InterruptedException
    //   1508	1545	1565	finally
    //   1390	1411	1576	finally
    //   1422	1431	1576	finally
    //   1431	1492	1576	finally
    //   1581	1606	1576	finally
    //   1364	1390	1617	finally
    //   1341	1350	1622	finally
    //   1354	1360	1622	finally
    //   1328	1336	2127	finally
    //   1321	1328	2132	finally
    //   2144	2147	2147	java/io/IOException
    //   1309	1321	2152	java/io/IOException
    //   2160	2185	2186	java/io/IOException
    //   1266	1305	2191	java/io/IOException
    //   180	186	2389	java/io/IOException
    //   1170	1178	2394	java/lang/NumberFormatException
    //   1170	1178	2394	java/lang/Exception
    //   1180	1203	2394	java/lang/NumberFormatException
    //   1180	1203	2394	java/lang/Exception
    //   1309	1321	2406	java/io/FileNotFoundException
    //   1411	1416	2411	java/io/IOException
    //   1416	1421	2416	java/io/IOException
    //   1422	1431	2419	java/io/IOException
    //   1497	1502	2424	java/io/IOException
    //   1502	1507	2429	java/io/IOException
    //   1606	1611	2432	java/io/IOException
    //   1611	1616	2437	java/io/IOException
    //   1631	1636	2440	java/io/IOException
    //   1636	1641	2445	java/io/IOException
    //   2134	2139	2450	java/io/IOException
    //   2139	2144	2455	java/io/IOException
    //   2242	2294	2460	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */