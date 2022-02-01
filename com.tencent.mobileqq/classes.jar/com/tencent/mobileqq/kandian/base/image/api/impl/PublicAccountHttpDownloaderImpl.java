package com.tencent.mobileqq.kandian.base.image.api.impl;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.RIJImageDownloadParams;
import com.tencent.mobileqq.kandian.base.image.RIJImageOptBitmapFile;
import com.tencent.mobileqq.kandian.base.image.RIJImageOptConfig;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.nearby.now.utils.IIOUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.dns.IpData;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import com.tencent.util.URLUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class PublicAccountHttpDownloaderImpl
  extends HttpDownloader
  implements IPublicAccountHttpDownloader
{
  public static final String TAG = "PubAccountHttpDownloader";
  private BaseApplicationImpl application = BaseApplicationImpl.getApplication();
  
  private File getBitmapFile(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte != null) {
      return new RIJImageOptBitmapFile(paramArrayOfByte, paramLong);
    }
    return null;
  }
  
  private byte[] getByteArrayInputStream(InputStream paramInputStream, long paramLong)
  {
    return ((IIOUtils)QRoute.api(IIOUtils.class)).readBytes(paramInputStream, (int)paramLong);
  }
  
  private String getNetIdentifier()
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    String str2 = String.valueOf(NetworkUtil.getSystemNetwork(localContext));
    String str1 = str2;
    if (!StringUtil.isEmpty(str2))
    {
      str1 = str2;
      if (str2.equals(String.valueOf(1))) {
        str1 = DeviceInfoUtil.c(localContext);
      }
    }
    return str1;
  }
  
  private void hook(URL paramURL)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = InnerDns.getInstance().reqSerAddrList(paramURL.getHost(), 1002);
        if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
        {
          Object localObject2 = new ArrayList();
          localObject1 = InetAddress.getAllByName(paramURL.getHost());
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int k = localObject1.length;
            int i = 0;
            if (i < k)
            {
              localHashMap1 = localObject1[i];
              localObject3 = new IpData();
              ((IpData)localObject3).mIp = localHashMap1.getHostAddress();
              ((IpData)localObject3).mPort = 80;
              if (!IPAddressUtil.isIPv4LiteralAddress(((IpData)localObject3).mIp)) {
                break label293;
              }
              j = 1;
              ((IpData)localObject3).mType = j;
              ((ArrayList)localObject2).add(localObject3);
              i += 1;
              continue;
            }
            localObject2 = new DomainData(paramURL.getHost(), (ArrayList)localObject2);
            HashMap localHashMap1 = (HashMap)Reflect.on(InnerDns.getInstance()).get("mNetMap");
            Object localObject3 = getNetIdentifier();
            if (localHashMap1 != null) {
              if (localHashMap1.containsKey(localObject3))
              {
                ((HashMap)localHashMap1.get(localObject3)).put(paramURL.getHost(), localObject2);
              }
              else
              {
                HashMap localHashMap2 = new HashMap();
                localHashMap2.put(paramURL.getHost(), localObject2);
                localHashMap1.put(localObject3, localHashMap2);
              }
            }
            paramURL = new StringBuilder();
            paramURL.append("hook success: ");
            paramURL.append(Arrays.toString((Object[])localObject1));
            QLog.d("PubAccountHttpDownloader", 1, paramURL.toString());
            return;
          }
        }
      }
      catch (Exception paramURL)
      {
        QLog.d("PubAccountHttpDownloader", 1, paramURL.getMessage());
      }
      return;
      label293:
      int j = 28;
    }
  }
  
  private boolean isSupportInnerIpDNS(DownloadParams paramDownloadParams)
  {
    if ((paramDownloadParams instanceof RIJImageDownloadParams)) {
      return ((RIJImageDownloadParams)paramDownloadParams).a;
    }
    return false;
  }
  
  private boolean isUseIpConnect(DownloadParams paramDownloadParams)
  {
    if ((paramDownloadParams instanceof RIJImageDownloadParams)) {
      return ((RIJImageDownloadParams)paramDownloadParams).b;
    }
    return false;
  }
  
  private void saveFileInSingleThread(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    ThreadManager.getFileThreadHandler().post(new PublicAccountHttpDownloaderImpl.1(this, paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramBoolean, paramInt2, paramInputStream, paramLong));
  }
  
  public void copyRespInfo(NetResp paramNetResp, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramURLDrawableHandler instanceof PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler))
    {
      paramURLDrawableHandler = (PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler)paramURLDrawableHandler;
      PublicAccountHttpDownloaderImpl.PubAccoutImageReporter localPubAccoutImageReporter = paramURLDrawableHandler.a();
      if (localPubAccoutImageReporter != null)
      {
        localPubAccoutImageReporter.a(paramNetResp, paramNetResp.mErrDesc);
        paramNetResp = new StringBuilder();
        paramNetResp.append("image/");
        paramNetResp.append(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.b(localPubAccoutImageReporter));
        paramURLDrawableHandler.a(paramNetResp.toString());
      }
    }
  }
  
  /* Error */
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 283	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   4: astore 8
    //   6: aload 8
    //   8: astore 11
    //   10: aload 8
    //   12: ldc_w 285
    //   15: invokevirtual 288	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   18: ifeq +12 -> 30
    //   21: aload_2
    //   22: getfield 292	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   25: invokevirtual 295	java/net/URL:getFile	()Ljava/lang/String;
    //   28: astore 11
    //   30: aload 11
    //   32: invokestatic 300	com/tencent/util/URLUtil:a	(Ljava/lang/String;)Ljava/util/Map;
    //   35: astore 8
    //   37: aload 8
    //   39: ldc_w 302
    //   42: invokeinterface 305 2 0
    //   47: ifnull +93 -> 140
    //   50: aload 8
    //   52: ldc_w 302
    //   55: invokeinterface 305 2 0
    //   60: checkcast 79	java/lang/String
    //   63: invokestatic 311	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   66: istore 4
    //   68: goto +75 -> 143
    //   71: astore 9
    //   73: new 191	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   80: astore 10
    //   82: aload 10
    //   84: ldc_w 313
    //   87: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 10
    //   93: aload 11
    //   95: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 10
    //   101: ldc_w 315
    //   104: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 10
    //   110: aload 8
    //   112: ldc_w 302
    //   115: invokeinterface 305 2 0
    //   120: checkcast 79	java/lang/String
    //   123: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 10
    //   129: iconst_2
    //   130: aload 10
    //   132: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: aload 9
    //   137: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: iconst_m1
    //   141: istore 4
    //   143: aload_2
    //   144: new 111	java/net/URL
    //   147: dup
    //   148: aload 11
    //   150: invokespecial 321	java/net/URL:<init>	(Ljava/lang/String;)V
    //   153: putfield 292	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   156: aload_2
    //   157: aload 11
    //   159: putfield 283	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   162: new 259	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter
    //   165: dup
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 24	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:application	Lcom/tencent/common/app/BaseApplicationImpl;
    //   171: iload 4
    //   173: invokespecial 324	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:<init>	(Lcom/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl;Lcom/tencent/common/app/BaseApplicationImpl;I)V
    //   176: astore 14
    //   178: aload 14
    //   180: aload_2
    //   181: aload 8
    //   183: invokevirtual 327	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/image/DownloadParams;Ljava/util/Map;)V
    //   186: aload_2
    //   187: getfield 331	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   190: astore 8
    //   192: iconst_0
    //   193: istore 5
    //   195: aload 8
    //   197: ifnull +64 -> 261
    //   200: aload_2
    //   201: getfield 331	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   204: astore 8
    //   206: aload 8
    //   208: arraylength
    //   209: istore 6
    //   211: iconst_0
    //   212: istore 4
    //   214: iload 4
    //   216: iload 6
    //   218: if_icmpge +43 -> 261
    //   221: aload 8
    //   223: iload 4
    //   225: aaload
    //   226: astore 9
    //   228: ldc_w 333
    //   231: aload 9
    //   233: invokeinterface 338 1 0
    //   238: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifeq +11 -> 252
    //   244: aload 9
    //   246: invokeinterface 341 1 0
    //   251: pop
    //   252: iload 4
    //   254: iconst_1
    //   255: iadd
    //   256: istore 4
    //   258: goto -44 -> 214
    //   261: new 343	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$CountOutputStreamWapper
    //   264: dup
    //   265: aload_0
    //   266: aload_1
    //   267: invokespecial 346	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$CountOutputStreamWapper:<init>	(Lcom/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl;Ljava/io/OutputStream;)V
    //   270: astore 12
    //   272: aload_0
    //   273: aload_0
    //   274: aload_2
    //   275: invokespecial 348	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:isSupportInnerIpDNS	(Lcom/tencent/image/DownloadParams;)Z
    //   278: putfield 31	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:mSupportInnerIp	Z
    //   281: aconst_null
    //   282: astore 8
    //   284: iconst_1
    //   285: istore 4
    //   287: iload 4
    //   289: iconst_1
    //   290: isub
    //   291: istore 6
    //   293: aload 8
    //   295: astore 9
    //   297: iload 4
    //   299: ifle +502 -> 801
    //   302: iload 5
    //   304: iconst_1
    //   305: iadd
    //   306: istore 5
    //   308: aload 8
    //   310: astore 9
    //   312: aload 14
    //   314: invokevirtual 350	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:b	()V
    //   317: aload 8
    //   319: astore 9
    //   321: aload_0
    //   322: getfield 31	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:mSupportInnerIp	Z
    //   325: ifeq +27 -> 352
    //   328: aload 8
    //   330: astore 9
    //   332: aload_0
    //   333: aload_2
    //   334: invokespecial 352	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:isUseIpConnect	(Lcom/tencent/image/DownloadParams;)Z
    //   337: ifeq +15 -> 352
    //   340: aload 8
    //   342: astore 9
    //   344: aload_0
    //   345: aload_2
    //   346: getfield 292	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   349: invokespecial 354	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:hook	(Ljava/net/URL;)V
    //   352: aload 8
    //   354: astore 10
    //   356: aload 8
    //   358: astore 9
    //   360: aload_0
    //   361: aload 12
    //   363: aload_2
    //   364: aload 14
    //   366: aload_3
    //   367: invokevirtual 357	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/image/URLDrawableHandler;)Lcom/tencent/image/URLDrawableHandler;
    //   370: invokespecial 359	com/tencent/mobileqq/transfile/HttpDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   373: astore 8
    //   375: aload 8
    //   377: ifnull +27 -> 404
    //   380: aload 8
    //   382: astore 10
    //   384: aload 8
    //   386: astore 9
    //   388: aload 8
    //   390: instanceof 48
    //   393: istore 7
    //   395: iload 6
    //   397: istore 4
    //   399: iload 7
    //   401: ifeq +6 -> 407
    //   404: iconst_m1
    //   405: istore 4
    //   407: aload_0
    //   408: getfield 363	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   411: invokevirtual 368	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   414: ifeq +6 -> 420
    //   417: goto +310 -> 727
    //   420: iload 4
    //   422: iconst_m1
    //   423: if_icmpeq +30 -> 453
    //   426: iload 4
    //   428: ifne +6 -> 434
    //   431: goto +22 -> 453
    //   434: ldc2_w 369
    //   437: invokestatic 376	java/lang/Thread:sleep	(J)V
    //   440: goto +39 -> 479
    //   443: astore 9
    //   445: aload 9
    //   447: invokevirtual 379	java/lang/InterruptedException:printStackTrace	()V
    //   450: goto +29 -> 479
    //   453: aload 14
    //   455: invokestatic 382	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter;)I
    //   458: ifeq +13 -> 471
    //   461: aload_2
    //   462: getfield 385	com/tencent/image/DownloadParams:retryCount	I
    //   465: getstatic 390	com/tencent/mobileqq/kandian/base/image/ImageRequest:v	I
    //   468: if_icmpne +11 -> 479
    //   471: aload 14
    //   473: iload 5
    //   475: aload_2
    //   476: invokevirtual 393	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILcom/tencent/image/DownloadParams;)V
    //   479: goto +224 -> 703
    //   482: astore 13
    //   484: aload 10
    //   486: astore 8
    //   488: goto +9 -> 497
    //   491: astore_1
    //   492: goto +221 -> 713
    //   495: astore 13
    //   497: aload 8
    //   499: astore 9
    //   501: aload 13
    //   503: invokevirtual 394	java/io/IOException:getMessage	()Ljava/lang/String;
    //   506: ldc_w 396
    //   509: invokevirtual 400	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   512: ifeq +6 -> 518
    //   515: goto +18 -> 533
    //   518: aload 8
    //   520: astore 9
    //   522: aload 14
    //   524: iconst_m1
    //   525: aload 13
    //   527: invokevirtual 394	java/io/IOException:getMessage	()Ljava/lang/String;
    //   530: invokevirtual 403	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILjava/lang/String;)V
    //   533: iload 6
    //   535: ifeq +171 -> 706
    //   538: aload 8
    //   540: astore 9
    //   542: aload_1
    //   543: checkcast 405	java/io/FileOutputStream
    //   546: invokevirtual 409	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   549: astore 10
    //   551: aload 8
    //   553: astore 9
    //   555: aload 10
    //   557: lconst_0
    //   558: invokevirtual 415	java/nio/channels/FileChannel:truncate	(J)Ljava/nio/channels/FileChannel;
    //   561: pop
    //   562: goto +65 -> 627
    //   565: astore 10
    //   567: goto +5 -> 572
    //   570: astore 10
    //   572: aload 8
    //   574: astore 9
    //   576: new 191	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   583: astore 13
    //   585: aload 8
    //   587: astore 9
    //   589: aload 13
    //   591: ldc_w 313
    //   594: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload 8
    //   600: astore 9
    //   602: aload 13
    //   604: aload 11
    //   606: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload 8
    //   612: astore 9
    //   614: ldc 10
    //   616: iconst_2
    //   617: aload 13
    //   619: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: aload 10
    //   624: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   627: aload_0
    //   628: getfield 363	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   631: invokevirtual 368	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   634: ifeq +6 -> 640
    //   637: goto +90 -> 727
    //   640: iload 6
    //   642: iconst_m1
    //   643: if_icmpeq +30 -> 673
    //   646: iload 6
    //   648: ifne +6 -> 654
    //   651: goto +22 -> 673
    //   654: ldc2_w 369
    //   657: invokestatic 376	java/lang/Thread:sleep	(J)V
    //   660: goto +39 -> 699
    //   663: astore 9
    //   665: aload 9
    //   667: invokevirtual 379	java/lang/InterruptedException:printStackTrace	()V
    //   670: goto +29 -> 699
    //   673: aload 14
    //   675: invokestatic 382	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter;)I
    //   678: ifeq +13 -> 691
    //   681: aload_2
    //   682: getfield 385	com/tencent/image/DownloadParams:retryCount	I
    //   685: getstatic 390	com/tencent/mobileqq/kandian/base/image/ImageRequest:v	I
    //   688: if_icmpne +11 -> 699
    //   691: aload 14
    //   693: iload 5
    //   695: aload_2
    //   696: invokevirtual 393	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILcom/tencent/image/DownloadParams;)V
    //   699: iload 6
    //   701: istore 4
    //   703: goto -416 -> 287
    //   706: aload 8
    //   708: astore 9
    //   710: aload 13
    //   712: athrow
    //   713: aload_0
    //   714: getfield 363	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   717: invokevirtual 368	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   720: ifeq +22 -> 742
    //   723: aload 9
    //   725: astore 8
    //   727: aload 14
    //   729: iload 5
    //   731: aload_2
    //   732: invokevirtual 393	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILcom/tencent/image/DownloadParams;)V
    //   735: aload 8
    //   737: astore 9
    //   739: goto +62 -> 801
    //   742: iload 6
    //   744: iconst_m1
    //   745: if_icmpeq +28 -> 773
    //   748: iload 6
    //   750: ifne +6 -> 756
    //   753: goto +20 -> 773
    //   756: ldc2_w 369
    //   759: invokestatic 376	java/lang/Thread:sleep	(J)V
    //   762: goto +37 -> 799
    //   765: astore_2
    //   766: aload_2
    //   767: invokevirtual 379	java/lang/InterruptedException:printStackTrace	()V
    //   770: goto +29 -> 799
    //   773: aload 14
    //   775: invokestatic 382	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(Lcom/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter;)I
    //   778: ifeq +13 -> 791
    //   781: aload_2
    //   782: getfield 385	com/tencent/image/DownloadParams:retryCount	I
    //   785: getstatic 390	com/tencent/mobileqq/kandian/base/image/ImageRequest:v	I
    //   788: if_icmpne +11 -> 799
    //   791: aload 14
    //   793: iload 5
    //   795: aload_2
    //   796: invokevirtual 393	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl$PubAccoutImageReporter:a	(ILcom/tencent/image/DownloadParams;)V
    //   799: aload_1
    //   800: athrow
    //   801: aload_0
    //   802: getfield 363	com/tencent/mobileqq/kandian/base/image/api/impl/PublicAccountHttpDownloaderImpl:isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   805: invokevirtual 368	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   808: ifne +6 -> 814
    //   811: aload 9
    //   813: areturn
    //   814: new 276	java/io/IOException
    //   817: dup
    //   818: ldc_w 417
    //   821: invokespecial 418	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   824: astore_1
    //   825: goto +5 -> 830
    //   828: aload_1
    //   829: athrow
    //   830: goto -2 -> 828
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	PublicAccountHttpDownloaderImpl
    //   0	833	1	paramOutputStream	OutputStream
    //   0	833	2	paramDownloadParams	DownloadParams
    //   0	833	3	paramURLDrawableHandler	URLDrawableHandler
    //   66	636	4	i	int
    //   193	601	5	j	int
    //   209	540	6	k	int
    //   393	7	7	bool	boolean
    //   4	732	8	localObject1	Object
    //   71	65	9	localNumberFormatException	java.lang.NumberFormatException
    //   226	161	9	localObject2	Object
    //   443	3	9	localInterruptedException1	java.lang.InterruptedException
    //   499	114	9	localObject3	Object
    //   663	3	9	localInterruptedException2	java.lang.InterruptedException
    //   708	104	9	localObject4	Object
    //   80	476	10	localObject5	Object
    //   565	1	10	localException1	Exception
    //   570	53	10	localException2	Exception
    //   8	597	11	localObject6	Object
    //   270	92	12	localCountOutputStreamWapper	PublicAccountHttpDownloaderImpl.CountOutputStreamWapper
    //   482	1	13	localIOException1	java.io.IOException
    //   495	31	13	localIOException2	java.io.IOException
    //   583	128	13	localStringBuilder	StringBuilder
    //   176	616	14	localPubAccoutImageReporter	PublicAccountHttpDownloaderImpl.PubAccoutImageReporter
    // Exception table:
    //   from	to	target	type
    //   50	68	71	java/lang/NumberFormatException
    //   434	440	443	java/lang/InterruptedException
    //   360	375	482	java/io/IOException
    //   388	395	482	java/io/IOException
    //   312	317	491	finally
    //   321	328	491	finally
    //   332	340	491	finally
    //   344	352	491	finally
    //   360	375	491	finally
    //   388	395	491	finally
    //   501	515	491	finally
    //   522	533	491	finally
    //   542	551	491	finally
    //   555	562	491	finally
    //   576	585	491	finally
    //   589	598	491	finally
    //   602	610	491	finally
    //   614	627	491	finally
    //   710	713	491	finally
    //   312	317	495	java/io/IOException
    //   321	328	495	java/io/IOException
    //   332	340	495	java/io/IOException
    //   344	352	495	java/io/IOException
    //   555	562	565	java/lang/Exception
    //   542	551	570	java/lang/Exception
    //   654	660	663	java/lang/InterruptedException
    //   756	762	765	java/lang/InterruptedException
  }
  
  @Nullable
  protected File getDownloadFile(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    if (RIJImageOptConfig.INSTANCE.isDecodeHttpStream())
    {
      byte[] arrayOfByte = getByteArrayInputStream(paramInputStream, paramLong);
      QLog.d("PubAccountHttpDownloader", 1, "read into memory done");
      if (arrayOfByte != null)
      {
        saveFileInSingleThread(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramBoolean, paramInt2, new ByteArrayInputStream(arrayOfByte), paramLong);
        return getBitmapFile(arrayOfByte, paramLong);
      }
    }
    return super.getDownloadFile(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramBoolean, paramInt2, paramInputStream, paramLong);
  }
  
  public HttpDownloader getHttpDownloader()
  {
    return this;
  }
  
  protected boolean isCommitBimapFileAsyn(File paramFile)
  {
    return paramFile instanceof RIJImageOptBitmapFile;
  }
  
  public URL makeURL(String paramString, int paramInt)
  {
    return makeURL(paramString, paramInt, null);
  }
  
  public URL makeURL(String paramString, int paramInt, Object paramObject)
  {
    return makeURL(paramString, paramInt, paramObject, false);
  }
  
  public URL makeURL(String paramString, int paramInt, Object paramObject, boolean paramBoolean)
  {
    Object localObject1 = null;
    paramObject = localObject1;
    try
    {
      if (!paramString.startsWith("http"))
      {
        paramObject = localObject1;
        if (!paramString.startsWith("https"))
        {
          paramObject = localObject1;
          return new URL(paramString);
        }
      }
      paramObject = localObject1;
      Object localObject2 = URLUtil.a(paramString);
      paramObject = localObject1;
      if (((Map)localObject2).containsKey("busiType"))
      {
        paramObject = localObject1;
        StringBuilder localStringBuilder = new StringBuilder();
        paramObject = localObject1;
        localStringBuilder.append("busiType=");
        paramObject = localObject1;
        localStringBuilder.append((String)((Map)localObject2).get("busiType"));
        paramObject = localObject1;
        localObject2 = localStringBuilder.toString();
        paramObject = localObject1;
        localStringBuilder = new StringBuilder();
        paramObject = localObject1;
        localStringBuilder.append("busiType=");
        paramObject = localObject1;
        localStringBuilder.append(paramInt);
        paramObject = localObject1;
        paramString = paramString.replace((CharSequence)localObject2, localStringBuilder.toString());
      }
      else
      {
        paramObject = localObject1;
        localObject2 = new StringBuilder();
        paramObject = localObject1;
        ((StringBuilder)localObject2).append(paramInt);
        paramObject = localObject1;
        ((StringBuilder)localObject2).append("");
        paramObject = localObject1;
        paramString = URLUtil.a(paramString, "busiType", ((StringBuilder)localObject2).toString());
      }
      if (!paramBoolean)
      {
        paramObject = localObject1;
        paramString = new URL("pubaccountimage", null, paramString);
      }
      else
      {
        paramObject = localObject1;
        paramString = new URL(paramString);
      }
      paramObject = paramString;
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        paramObject = paramString;
        localObject1 = new StringBuilder();
        paramObject = paramString;
        ((StringBuilder)localObject1).append("<--generateURL urlString =");
        paramObject = paramString;
        ((StringBuilder)localObject1).append(paramString.toString());
        paramObject = paramString;
        QLog.d("PubAccountHttpDownloader", 2, ((StringBuilder)localObject1).toString());
        return paramString;
      }
    }
    catch (MalformedURLException paramString)
    {
      localObject1 = paramObject;
      if (QLog.isColorLevel())
      {
        QLog.e("PubAccountHttpDownloader", 2, "<--generateURL urlString", paramString);
        localObject1 = paramObject;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */