import com.tencent.component.network.downloader.impl.DownloadTask;
import com.tencent.component.network.downloader.impl.DownloaderImpl;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.FutureListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class poi
  implements FutureListener
{
  public poi(DownloaderImpl paramDownloaderImpl, DownloadTask paramDownloadTask) {}
  
  public void a(Future arg1)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask.c) {
      DownloaderImpl.access$108();
    }
    for (;;)
    {
      synchronized (DownloaderImpl.access$300(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask.a()))
      {
        synchronized (DownloaderImpl.access$400(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl))
        {
          WeakReference localWeakReference1 = new WeakReference(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask);
          Object localObject4;
          if (localWeakReference1 != null)
          {
            localObject4 = (List)DownloaderImpl.access$500(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl).get(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask.a());
            if (localObject4 == null)
            {
              localObject4 = new ArrayList();
              ((List)localObject4).add(localWeakReference1);
              DownloaderImpl.access$500(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl).put(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask.a(), localObject4);
            }
          }
          else
          {
            return;
            DownloaderImpl.access$208();
            continue;
          }
          Iterator localIterator = ((List)localObject4).iterator();
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference2 = (WeakReference)localIterator.next();
            if ((localWeakReference2 == null) || ((DownloadTask)localWeakReference2.get() != this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask)) {
              continue;
            }
            i = 0;
            if (i == 0) {
              continue;
            }
            ((List)localObject4).add(localWeakReference1);
          }
        }
      }
      int i = 1;
    }
  }
  
  /* Error */
  public void b(Future paramFuture)
  {
    // Byte code:
    //   0: invokestatic 102	com/tencent/component/network/module/base/QDLog:a	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc 104
    //   8: new 106	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   15: ldc 109
    //   17: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   24: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   27: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 119	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   40: getfield 26	com/tencent/component/network/downloader/impl/DownloadTask:c	Z
    //   43: ifeq +555 -> 598
    //   46: invokestatic 122	com/tencent/component/network/downloader/impl/DownloaderImpl:access$110	()I
    //   49: pop
    //   50: aload_0
    //   51: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   54: invokevirtual 124	com/tencent/component/network/downloader/impl/DownloadTask:c	()Ljava/lang/String;
    //   57: astore 14
    //   59: aload_0
    //   60: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   63: invokestatic 128	com/tencent/component/network/downloader/impl/DownloaderImpl:access$600	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/HashMap;
    //   66: astore 13
    //   68: aload 13
    //   70: monitorenter
    //   71: aload_0
    //   72: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   75: invokestatic 128	com/tencent/component/network/downloader/impl/DownloaderImpl:access$600	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/HashMap;
    //   78: aload 14
    //   80: invokevirtual 133	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload 13
    //   86: monitorexit
    //   87: aload_1
    //   88: invokeinterface 136 1 0
    //   93: checkcast 138	com/tencent/component/network/downloader/DownloadResult
    //   96: astore 19
    //   98: invokestatic 102	com/tencent/component/network/module/base/QDLog:a	()Z
    //   101: ifeq +92 -> 193
    //   104: aload 19
    //   106: ifnull +505 -> 611
    //   109: ldc2_w 139
    //   112: lstore 8
    //   114: aload 19
    //   116: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   119: ifnull +20 -> 139
    //   122: new 145	java/io/File
    //   125: dup
    //   126: aload 19
    //   128: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   131: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 152	java/io/File:length	()J
    //   137: lstore 8
    //   139: ldc 104
    //   141: new 106	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   148: ldc 154
    //   150: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 19
    //   155: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   158: invokevirtual 163	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   161: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: ldc 168
    //   166: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 19
    //   171: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   174: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 170
    //   179: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload 8
    //   184: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 119	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload 19
    //   195: ifnull +41 -> 236
    //   198: aload 19
    //   200: invokevirtual 177	com/tencent/component/network/downloader/DownloadResult:getReport	()Lcom/tencent/component/network/downloader/DownloadReport;
    //   203: astore 13
    //   205: aload 19
    //   207: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   210: astore 15
    //   212: aload 13
    //   214: ifnull +22 -> 236
    //   217: aload 15
    //   219: ifnull +17 -> 236
    //   222: aload 13
    //   224: aload 15
    //   226: aload_0
    //   227: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   230: getfield 26	com/tencent/component/network/downloader/impl/DownloadTask:c	Z
    //   233: invokestatic 181	com/tencent/component/network/downloader/impl/DownloaderImpl:access$700	(Lcom/tencent/component/network/downloader/DownloadReport;Lcom/tencent/component/network/downloader/DownloadResult$Status;Z)V
    //   236: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   239: pop2
    //   240: aload_0
    //   241: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   244: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   247: aload_0
    //   248: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   251: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   254: invokevirtual 44	pok:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   257: astore 18
    //   259: aload 18
    //   261: monitorenter
    //   262: aload_0
    //   263: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   266: invokestatic 48	com/tencent/component/network/downloader/impl/DownloaderImpl:access$400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/lang/Object;
    //   269: astore 15
    //   271: aload 15
    //   273: monitorenter
    //   274: aload_0
    //   275: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   278: invokestatic 57	com/tencent/component/network/downloader/impl/DownloaderImpl:access$500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/Map;
    //   281: aload_0
    //   282: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   285: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   288: invokeinterface 189 2 0
    //   293: ifeq +128 -> 421
    //   296: aload_0
    //   297: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   300: invokestatic 57	com/tencent/component/network/downloader/impl/DownloaderImpl:access$500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/Map;
    //   303: aload_0
    //   304: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   307: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   310: invokeinterface 63 2 0
    //   315: checkcast 65	java/util/List
    //   318: astore 16
    //   320: aload 16
    //   322: ifnull +99 -> 421
    //   325: aload 16
    //   327: invokeinterface 83 1 0
    //   332: astore 17
    //   334: aload 17
    //   336: invokeinterface 89 1 0
    //   341: ifeq +1459 -> 1800
    //   344: aload 17
    //   346: invokeinterface 93 1 0
    //   351: checkcast 50	java/lang/ref/WeakReference
    //   354: astore 13
    //   356: aload 13
    //   358: ifnull -24 -> 334
    //   361: aload 13
    //   363: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   366: checkcast 22	com/tencent/component/network/downloader/impl/DownloadTask
    //   369: aload_0
    //   370: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   373: if_acmpne -39 -> 334
    //   376: aload 13
    //   378: ifnull +43 -> 421
    //   381: aload 16
    //   383: aload 13
    //   385: invokeinterface 191 2 0
    //   390: pop
    //   391: aload 16
    //   393: invokeinterface 194 1 0
    //   398: ifgt +23 -> 421
    //   401: aload_0
    //   402: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   405: invokestatic 57	com/tencent/component/network/downloader/impl/DownloaderImpl:access$500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/Map;
    //   408: aload_0
    //   409: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   412: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   415: invokeinterface 195 2 0
    //   420: pop
    //   421: aload 15
    //   423: monitorexit
    //   424: aload 19
    //   426: ifnull +327 -> 753
    //   429: aload 19
    //   431: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   434: invokevirtual 198	com/tencent/component/network/downloader/DownloadResult$Status:isRetrying	()Z
    //   437: ifeq +316 -> 753
    //   440: invokestatic 102	com/tencent/component/network/module/base/QDLog:a	()Z
    //   443: ifeq +38 -> 481
    //   446: ldc 104
    //   448: new 106	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   455: ldc 154
    //   457: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_0
    //   461: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   464: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   467: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc 200
    //   472: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 119	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload 19
    //   483: ifnull +94 -> 577
    //   486: aload_1
    //   487: invokeinterface 203 1 0
    //   492: ifne +85 -> 577
    //   495: aload_0
    //   496: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   499: invokestatic 207	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1200	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   502: ifnull +28 -> 530
    //   505: aload_0
    //   506: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   509: invokestatic 210	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   512: aload 19
    //   514: invokevirtual 213	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   517: aload 19
    //   519: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   522: invokevirtual 163	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   525: invokeinterface 218 3 0
    //   530: aload 19
    //   532: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   535: invokevirtual 163	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   538: ifne +13 -> 551
    //   541: aload_0
    //   542: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   545: invokestatic 221	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   548: ifnonnull +29 -> 577
    //   551: aload 19
    //   553: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   556: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   559: ifne +18 -> 577
    //   562: new 145	java/io/File
    //   565: dup
    //   566: aload 19
    //   568: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   571: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   574: invokestatic 233	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   577: aload_0
    //   578: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   581: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   584: aload_0
    //   585: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   588: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   591: invokevirtual 235	pok:a	(Ljava/lang/String;)V
    //   594: aload 18
    //   596: monitorexit
    //   597: return
    //   598: invokestatic 238	com/tencent/component/network/downloader/impl/DownloaderImpl:access$210	()I
    //   601: pop
    //   602: goto -552 -> 50
    //   605: astore_1
    //   606: aload 13
    //   608: monitorexit
    //   609: aload_1
    //   610: athrow
    //   611: ldc 104
    //   613: ldc 240
    //   615: invokestatic 119	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: goto -425 -> 193
    //   621: astore 13
    //   623: aload 15
    //   625: monitorexit
    //   626: aload 13
    //   628: athrow
    //   629: astore 13
    //   631: aload 19
    //   633: ifnull +94 -> 727
    //   636: aload_1
    //   637: invokeinterface 203 1 0
    //   642: ifne +85 -> 727
    //   645: aload_0
    //   646: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   649: invokestatic 207	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1200	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   652: ifnull +28 -> 680
    //   655: aload_0
    //   656: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   659: invokestatic 210	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   662: aload 19
    //   664: invokevirtual 213	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   667: aload 19
    //   669: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   672: invokevirtual 163	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   675: invokeinterface 218 3 0
    //   680: aload 19
    //   682: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   685: invokevirtual 163	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   688: ifne +13 -> 701
    //   691: aload_0
    //   692: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   695: invokestatic 221	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   698: ifnonnull +29 -> 727
    //   701: aload 19
    //   703: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   706: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   709: ifne +18 -> 727
    //   712: new 145	java/io/File
    //   715: dup
    //   716: aload 19
    //   718: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   721: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   724: invokestatic 233	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   727: aload_0
    //   728: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   731: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   734: aload_0
    //   735: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   738: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   741: invokevirtual 235	pok:a	(Ljava/lang/String;)V
    //   744: aload 13
    //   746: athrow
    //   747: astore_1
    //   748: aload 18
    //   750: monitorexit
    //   751: aload_1
    //   752: athrow
    //   753: aload_0
    //   754: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   757: aload 14
    //   759: iconst_1
    //   760: aconst_null
    //   761: invokestatic 244	com/tencent/component/network/downloader/impl/DownloaderImpl:access$800	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Ljava/lang/String;ZLjava/util/Collection;)Ljava/util/Collection;
    //   764: astore 20
    //   766: aload 19
    //   768: ifnull +14 -> 782
    //   771: aload 19
    //   773: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   776: invokevirtual 163	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   779: ifne +131 -> 910
    //   782: aload_0
    //   783: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   786: aload 20
    //   788: aload 19
    //   790: invokestatic 248	com/tencent/component/network/downloader/impl/DownloaderImpl:access$900	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Ljava/util/Collection;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   793: aload 19
    //   795: ifnull +94 -> 889
    //   798: aload_1
    //   799: invokeinterface 203 1 0
    //   804: ifne +85 -> 889
    //   807: aload_0
    //   808: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   811: invokestatic 207	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1200	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   814: ifnull +28 -> 842
    //   817: aload_0
    //   818: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   821: invokestatic 210	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   824: aload 19
    //   826: invokevirtual 213	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   829: aload 19
    //   831: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   834: invokevirtual 163	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   837: invokeinterface 218 3 0
    //   842: aload 19
    //   844: invokevirtual 158	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   847: invokevirtual 163	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   850: ifne +13 -> 863
    //   853: aload_0
    //   854: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   857: invokestatic 221	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   860: ifnonnull +29 -> 889
    //   863: aload 19
    //   865: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   868: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   871: ifne +18 -> 889
    //   874: new 145	java/io/File
    //   877: dup
    //   878: aload 19
    //   880: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   883: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   886: invokestatic 233	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   889: aload_0
    //   890: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   893: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   896: aload_0
    //   897: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   900: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   903: invokevirtual 235	pok:a	(Ljava/lang/String;)V
    //   906: aload 18
    //   908: monitorexit
    //   909: return
    //   910: iconst_0
    //   911: istore_2
    //   912: aload 20
    //   914: ifnull +713 -> 1627
    //   917: new 67	java/util/ArrayList
    //   920: dup
    //   921: invokespecial 68	java/util/ArrayList:<init>	()V
    //   924: astore 21
    //   926: new 145	java/io/File
    //   929: dup
    //   930: aload 19
    //   932: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   935: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   938: astore 16
    //   940: aconst_null
    //   941: astore 13
    //   943: aload 16
    //   945: invokevirtual 152	java/io/File:length	()J
    //   948: lstore 8
    //   950: aload 20
    //   952: invokeinterface 251 1 0
    //   957: astore 22
    //   959: iconst_0
    //   960: istore_2
    //   961: aload 22
    //   963: invokeinterface 89 1 0
    //   968: ifeq +883 -> 1851
    //   971: aload 22
    //   973: invokeinterface 93 1 0
    //   978: checkcast 253	com/tencent/component/network/downloader/DownloadRequest
    //   981: astore 23
    //   983: aload 23
    //   985: ifnull -24 -> 961
    //   988: aload 23
    //   990: invokevirtual 256	com/tencent/component/network/downloader/DownloadRequest:isCanceled	()Z
    //   993: ifne -32 -> 961
    //   996: aload 23
    //   998: invokevirtual 259	com/tencent/component/network/downloader/DownloadRequest:shouldCacheEntry	()Z
    //   1001: ifeq +783 -> 1784
    //   1004: iconst_1
    //   1005: istore_2
    //   1006: aload 23
    //   1008: invokevirtual 263	com/tencent/component/network/downloader/DownloadRequest:getPaths	()[Ljava/lang/String;
    //   1011: astore 24
    //   1013: aload 24
    //   1015: ifnull +579 -> 1594
    //   1018: iconst_0
    //   1019: istore 5
    //   1021: aload 24
    //   1023: arraylength
    //   1024: istore 6
    //   1026: iconst_0
    //   1027: istore_3
    //   1028: iload 5
    //   1030: istore 4
    //   1032: iload_3
    //   1033: iload 6
    //   1035: if_icmpge +771 -> 1806
    //   1038: aload 21
    //   1040: aload 24
    //   1042: iload_3
    //   1043: aaload
    //   1044: invokeinterface 266 2 0
    //   1049: ifeq +765 -> 1814
    //   1052: iconst_1
    //   1053: istore 4
    //   1055: goto +751 -> 1806
    //   1058: aload 24
    //   1060: arraylength
    //   1061: istore 7
    //   1063: iconst_0
    //   1064: istore 5
    //   1066: aload 13
    //   1068: astore 14
    //   1070: iload 5
    //   1072: iload 7
    //   1074: if_icmpge +770 -> 1844
    //   1077: aload 24
    //   1079: iload 5
    //   1081: aaload
    //   1082: astore 25
    //   1084: aload 25
    //   1086: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1089: ifeq +10 -> 1099
    //   1092: aload 13
    //   1094: astore 14
    //   1096: goto +725 -> 1821
    //   1099: aload 13
    //   1101: astore 14
    //   1103: aload_0
    //   1104: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1107: aload 19
    //   1109: aload 23
    //   1111: invokestatic 270	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1000	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadRequest;)Z
    //   1114: ifne +707 -> 1821
    //   1117: aload 13
    //   1119: astore 14
    //   1121: aload 19
    //   1123: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1126: ifnull +695 -> 1821
    //   1129: aload 21
    //   1131: aload 25
    //   1133: invokeinterface 266 2 0
    //   1138: istore 12
    //   1140: aload 13
    //   1142: astore 14
    //   1144: iload 12
    //   1146: ifne +675 -> 1821
    //   1149: iconst_1
    //   1150: istore 4
    //   1152: iconst_0
    //   1153: istore_3
    //   1154: iload 4
    //   1156: iflt +393 -> 1549
    //   1159: iload_3
    //   1160: ifne +389 -> 1549
    //   1163: iload 4
    //   1165: iconst_1
    //   1166: isub
    //   1167: istore 6
    //   1169: new 145	java/io/File
    //   1172: dup
    //   1173: aload 25
    //   1175: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   1178: astore 17
    //   1180: aload 13
    //   1182: ifnull +11 -> 1193
    //   1185: aload 13
    //   1187: invokevirtual 273	java/io/File:exists	()Z
    //   1190: ifne +600 -> 1790
    //   1193: aload 16
    //   1195: aload 17
    //   1197: invokestatic 277	com/tencent/component/network/utils/FileUtils:rename	(Ljava/io/File;Ljava/io/File;)Z
    //   1200: istore 12
    //   1202: iload 12
    //   1204: ifeq +583 -> 1787
    //   1207: iconst_1
    //   1208: istore_3
    //   1209: aload 17
    //   1211: astore 13
    //   1213: aload 13
    //   1215: astore 14
    //   1217: ldc 104
    //   1219: new 106	java/lang/StringBuilder
    //   1222: dup
    //   1223: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   1226: ldc_w 279
    //   1229: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: aload 16
    //   1234: invokevirtual 280	java/io/File:getPath	()Ljava/lang/String;
    //   1237: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: ldc_w 282
    //   1243: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: aload 25
    //   1248: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: ldc_w 284
    //   1254: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: aload_0
    //   1258: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1261: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1264: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: ldc_w 286
    //   1270: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: iload 12
    //   1275: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1278: ldc_w 288
    //   1281: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: lload 8
    //   1286: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1289: ldc_w 290
    //   1292: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: aload 17
    //   1297: invokevirtual 152	java/io/File:length	()J
    //   1300: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1303: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1306: invokestatic 292	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1309: iload_3
    //   1310: istore 4
    //   1312: iload_3
    //   1313: ifne +521 -> 1834
    //   1316: aload 13
    //   1318: ifnull +475 -> 1793
    //   1321: aload 13
    //   1323: astore 14
    //   1325: aload 13
    //   1327: invokevirtual 273	java/io/File:exists	()Z
    //   1330: ifeq +463 -> 1793
    //   1333: aload 13
    //   1335: astore 15
    //   1337: aload 13
    //   1339: astore 14
    //   1341: aload 15
    //   1343: aload 17
    //   1345: invokestatic 295	com/tencent/component/network/utils/FileUtils:copyFiles	(Ljava/io/File;Ljava/io/File;)Z
    //   1348: istore 12
    //   1350: aload 13
    //   1352: astore 14
    //   1354: aload 17
    //   1356: invokevirtual 152	java/io/File:length	()J
    //   1359: lstore 10
    //   1361: aload 13
    //   1363: astore 14
    //   1365: ldc 104
    //   1367: new 106	java/lang/StringBuilder
    //   1370: dup
    //   1371: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   1374: ldc_w 297
    //   1377: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: aload 15
    //   1382: invokevirtual 280	java/io/File:getPath	()Ljava/lang/String;
    //   1385: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: ldc_w 282
    //   1391: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: aload 25
    //   1396: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: ldc_w 284
    //   1402: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: aload_0
    //   1406: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1409: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1412: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: ldc_w 286
    //   1418: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: iload 12
    //   1423: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1426: ldc_w 288
    //   1429: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: lload 8
    //   1434: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1437: ldc_w 290
    //   1440: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: lload 10
    //   1445: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1448: ldc_w 299
    //   1451: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: iload 6
    //   1456: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1459: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1462: invokestatic 292	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1465: iload 12
    //   1467: ifeq +17 -> 1484
    //   1470: lload 8
    //   1472: lload 10
    //   1474: lcmp
    //   1475: ifne +9 -> 1484
    //   1478: iconst_1
    //   1479: istore 4
    //   1481: goto +353 -> 1834
    //   1484: aload 13
    //   1486: astore 14
    //   1488: aload 17
    //   1490: invokestatic 233	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   1493: iload_3
    //   1494: istore 4
    //   1496: goto +338 -> 1834
    //   1499: astore 15
    //   1501: aload 14
    //   1503: astore 13
    //   1505: aload 15
    //   1507: astore 14
    //   1509: ldc 104
    //   1511: new 106	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   1518: ldc_w 304
    //   1521: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: aload_0
    //   1525: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1528: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1531: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1537: aload 14
    //   1539: invokestatic 307	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1542: aload 13
    //   1544: astore 14
    //   1546: goto +275 -> 1821
    //   1549: iload_3
    //   1550: ifeq +20 -> 1570
    //   1553: aload 21
    //   1555: aload 25
    //   1557: invokeinterface 72 2 0
    //   1562: pop
    //   1563: aload 13
    //   1565: astore 14
    //   1567: goto +277 -> 1844
    //   1570: new 145	java/io/File
    //   1573: dup
    //   1574: aload 25
    //   1576: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   1579: invokestatic 233	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   1582: aload 13
    //   1584: astore 14
    //   1586: goto +235 -> 1821
    //   1589: astore 14
    //   1591: goto -82 -> 1509
    //   1594: aload 13
    //   1596: astore 14
    //   1598: aload 23
    //   1600: getfield 311	com/tencent/component/network/downloader/DownloadRequest:outputStream	Ljava/io/OutputStream;
    //   1603: ifnull +241 -> 1844
    //   1606: aload 19
    //   1608: invokevirtual 143	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1611: aload 23
    //   1613: getfield 311	com/tencent/component/network/downloader/DownloadRequest:outputStream	Ljava/io/OutputStream;
    //   1616: invokestatic 315	com/tencent/component/network/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/io/OutputStream;)Z
    //   1619: pop
    //   1620: aload 13
    //   1622: astore 14
    //   1624: goto +220 -> 1844
    //   1627: aload_0
    //   1628: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1631: aload 20
    //   1633: aload 19
    //   1635: invokestatic 318	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1100	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Ljava/util/Collection;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   1638: iload_2
    //   1639: ifeq -846 -> 793
    //   1642: aload_0
    //   1643: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1646: aload_0
    //   1647: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1650: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1653: aload 19
    //   1655: invokevirtual 322	com/tencent/component/network/downloader/impl/DownloaderImpl:addCacheEntry	(Ljava/lang/String;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   1658: goto -865 -> 793
    //   1661: astore_1
    //   1662: aload_0
    //   1663: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1666: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   1669: aload_0
    //   1670: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1673: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1676: invokevirtual 235	pok:a	(Ljava/lang/String;)V
    //   1679: goto -935 -> 744
    //   1682: astore_1
    //   1683: aload_0
    //   1684: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1687: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   1690: aload_0
    //   1691: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1694: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1697: invokevirtual 235	pok:a	(Ljava/lang/String;)V
    //   1700: aload_1
    //   1701: athrow
    //   1702: astore_1
    //   1703: aload_0
    //   1704: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1707: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   1710: aload_0
    //   1711: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1714: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1717: invokevirtual 235	pok:a	(Ljava/lang/String;)V
    //   1720: goto -1126 -> 594
    //   1723: astore_1
    //   1724: aload_0
    //   1725: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1728: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   1731: aload_0
    //   1732: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1735: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1738: invokevirtual 235	pok:a	(Ljava/lang/String;)V
    //   1741: aload_1
    //   1742: athrow
    //   1743: astore_1
    //   1744: aload_0
    //   1745: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1748: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   1751: aload_0
    //   1752: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1755: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1758: invokevirtual 235	pok:a	(Ljava/lang/String;)V
    //   1761: goto -855 -> 906
    //   1764: astore_1
    //   1765: aload_0
    //   1766: getfield 13	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloaderImpl	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1769: invokestatic 36	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lpok;
    //   1772: aload_0
    //   1773: getfield 15	poi:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1776: invokevirtual 39	com/tencent/component/network/downloader/impl/DownloadTask:a	()Ljava/lang/String;
    //   1779: invokevirtual 235	pok:a	(Ljava/lang/String;)V
    //   1782: aload_1
    //   1783: athrow
    //   1784: goto -778 -> 1006
    //   1787: goto -574 -> 1213
    //   1790: goto -481 -> 1309
    //   1793: aload 16
    //   1795: astore 15
    //   1797: goto -460 -> 1337
    //   1800: aconst_null
    //   1801: astore 13
    //   1803: goto -1427 -> 376
    //   1806: iload 4
    //   1808: ifeq -750 -> 1058
    //   1811: goto -850 -> 961
    //   1814: iload_3
    //   1815: iconst_1
    //   1816: iadd
    //   1817: istore_3
    //   1818: goto -790 -> 1028
    //   1821: iload 5
    //   1823: iconst_1
    //   1824: iadd
    //   1825: istore 5
    //   1827: aload 14
    //   1829: astore 13
    //   1831: goto -765 -> 1066
    //   1834: iload 4
    //   1836: istore_3
    //   1837: iload 6
    //   1839: istore 4
    //   1841: goto -687 -> 1154
    //   1844: aload 14
    //   1846: astore 13
    //   1848: goto -887 -> 961
    //   1851: goto -224 -> 1627
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1854	0	this	poi
    //   0	1854	1	paramFuture	Future
    //   911	728	2	i	int
    //   1027	810	3	j	int
    //   1030	810	4	k	int
    //   1019	807	5	m	int
    //   1024	814	6	n	int
    //   1061	14	7	i1	int
    //   112	1359	8	l1	long
    //   1359	114	10	l2	long
    //   1138	328	12	bool	boolean
    //   66	541	13	localObject1	Object
    //   621	6	13	localObject2	Object
    //   629	116	13	localObject3	Object
    //   941	906	13	localObject4	Object
    //   57	1528	14	localObject5	Object
    //   1589	1	14	localThrowable1	java.lang.Throwable
    //   1596	249	14	localObject6	Object
    //   210	1171	15	localObject7	Object
    //   1499	7	15	localThrowable2	java.lang.Throwable
    //   1795	1	15	localObject8	Object
    //   318	1476	16	localObject9	Object
    //   332	1157	17	localObject10	Object
    //   257	650	18	localObject11	Object
    //   96	1558	19	localDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   764	868	20	localCollection	java.util.Collection
    //   924	630	21	localArrayList	ArrayList
    //   957	15	22	localIterator	Iterator
    //   981	631	23	localDownloadRequest	com.tencent.component.network.downloader.DownloadRequest
    //   1011	67	24	arrayOfString	java.lang.String[]
    //   1082	493	25	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   71	87	605	finally
    //   606	609	605	finally
    //   274	320	621	finally
    //   325	334	621	finally
    //   334	356	621	finally
    //   361	376	621	finally
    //   381	421	621	finally
    //   421	424	621	finally
    //   623	626	621	finally
    //   262	274	629	finally
    //   429	481	629	finally
    //   626	629	629	finally
    //   753	766	629	finally
    //   771	782	629	finally
    //   782	793	629	finally
    //   917	940	629	finally
    //   943	959	629	finally
    //   961	983	629	finally
    //   988	1004	629	finally
    //   1006	1013	629	finally
    //   1021	1026	629	finally
    //   1038	1052	629	finally
    //   1058	1063	629	finally
    //   1084	1092	629	finally
    //   1103	1117	629	finally
    //   1121	1140	629	finally
    //   1169	1180	629	finally
    //   1185	1193	629	finally
    //   1193	1202	629	finally
    //   1217	1309	629	finally
    //   1325	1333	629	finally
    //   1341	1350	629	finally
    //   1354	1361	629	finally
    //   1365	1465	629	finally
    //   1488	1493	629	finally
    //   1509	1542	629	finally
    //   1553	1563	629	finally
    //   1570	1582	629	finally
    //   1598	1620	629	finally
    //   1627	1638	629	finally
    //   1642	1658	629	finally
    //   577	594	747	finally
    //   594	597	747	finally
    //   727	744	747	finally
    //   744	747	747	finally
    //   748	751	747	finally
    //   889	906	747	finally
    //   906	909	747	finally
    //   1662	1679	747	finally
    //   1683	1702	747	finally
    //   1703	1720	747	finally
    //   1724	1743	747	finally
    //   1744	1761	747	finally
    //   1765	1784	747	finally
    //   1217	1309	1499	java/lang/Throwable
    //   1325	1333	1499	java/lang/Throwable
    //   1341	1350	1499	java/lang/Throwable
    //   1354	1361	1499	java/lang/Throwable
    //   1365	1465	1499	java/lang/Throwable
    //   1488	1493	1499	java/lang/Throwable
    //   1169	1180	1589	java/lang/Throwable
    //   1185	1193	1589	java/lang/Throwable
    //   1193	1202	1589	java/lang/Throwable
    //   1553	1563	1589	java/lang/Throwable
    //   1570	1582	1589	java/lang/Throwable
    //   636	680	1661	java/lang/Throwable
    //   680	701	1661	java/lang/Throwable
    //   701	727	1661	java/lang/Throwable
    //   636	680	1682	finally
    //   680	701	1682	finally
    //   701	727	1682	finally
    //   486	530	1702	java/lang/Throwable
    //   530	551	1702	java/lang/Throwable
    //   551	577	1702	java/lang/Throwable
    //   486	530	1723	finally
    //   530	551	1723	finally
    //   551	577	1723	finally
    //   798	842	1743	java/lang/Throwable
    //   842	863	1743	java/lang/Throwable
    //   863	889	1743	java/lang/Throwable
    //   798	842	1764	finally
    //   842	863	1764	finally
    //   863	889	1764	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     poi
 * JD-Core Version:    0.7.0.1
 */