package com.tencent.tmdownloader.internal.downloadservice;

import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.aa;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.o;
import com.tencent.tmdownloader.internal.storage.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ApkDownloadManager
  implements INetworkChangedObserver
{
  protected static final String TAG = "ApkDownloadManager";
  protected static ApkDownloadManager mApkDownloadManager = null;
  final ConcurrentHashMap<String, c> mDownloads = new ConcurrentHashMap();
  protected long mLastAutoDownloadTime = 0L;
  protected long mLastAutoPauseTime = 0L;
  protected String mLastNetType = "";
  private boolean mLeaving = false;
  final ConcurrentHashMap<String, String> mPkgURL = new ConcurrentHashMap();
  
  public static ApkDownloadManager getInstance()
  {
    if (mApkDownloadManager == null) {
      mApkDownloadManager = new ApkDownloadManager();
    }
    return mApkDownloadManager;
  }
  
  public void AddDownloadListener(h paramh)
  {
    ab.c("ApkDownloadManager", "call AddDownloadListener, dl: " + paramh);
    f.a().a(paramh);
  }
  
  public void RemoveDownloadListener(h paramh)
  {
    ab.c("ApkDownloadManager", "call RemoveDownloadListener, dl: " + paramh);
    f.a().b(paramh);
  }
  
  public void cancelDownload(String paramString)
  {
    ab.c("ApkDownloadManager", "call cancelDownload, url: " + paramString);
    paramString = (c)this.mDownloads.remove(paramString);
    if (paramString != null) {
      paramString.e();
    }
  }
  
  public void continueDownload(String paramString)
  {
    ab.c("ApkDownloadManager", "call continueDownload, url: " + paramString);
    paramString = (c)this.mDownloads.get(paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  public void deleteDownload(String paramString)
  {
    ab.c("ApkDownloadManager", "call deleteDownload, url: " + paramString);
    paramString = (c)this.mDownloads.remove(paramString);
    if (paramString != null) {
      paramString.f();
    }
  }
  
  public void init()
  {
    if ((this.mLeaving) || (GlobalUtil.getInstance().getContext() == null))
    {
      ab.e("ApkDownloadManager", "init failed: mLeaving = " + this.mLeaving + ", context = " + GlobalUtil.getInstance().getContext());
      return;
    }
    long l = System.currentTimeMillis();
    HalleyAgent.init(GlobalUtil.getInstance().getContext(), "", "");
    Object localObject = GlobalUtil.getInstance().getPhoneGuid();
    HalleyAgent.getDownloader().setPhoneGuid((String)localObject);
    HalleyAgent.getDownloader().setTaskNumForCategory(DownloaderTaskCategory.Cate_DefaultMass, 3);
    HalleyAgent.getDownloader().setNotNetworkWaitMillis(5000);
    ab.c("ApkDownloadManager", "Start to load DownloadInfo list.");
    this.mDownloads.clear();
    localObject = a.a().b();
    if (localObject != null)
    {
      ab.c("ApkDownloadManager", "The size of downloadinfo_list: " + ((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (localc != null)
        {
          ab.c("ApkDownloadManager", "---------------load download info---------------");
          localc.a("ApkDownloadManager");
          if (!TextUtils.isEmpty(localc.b)) {
            this.mDownloads.put(localc.b, localc);
          }
          if (!localc.b()) {
            localc.a(3);
          }
          if ((!TextUtils.isEmpty(localc.b)) && (!TextUtils.isEmpty(localc.r))) {
            this.mPkgURL.put(localc.r, localc.b);
          }
        }
      }
    }
    ab.c("ApkDownloadManager", "Add NetworkChangedObserver to NetworkMonitorReceiver");
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this);
    this.mLastNetType = b.a();
    aa.a("ApkDownloadManager init end, timeCost = " + (System.currentTimeMillis() - l));
  }
  
  public Boolean isAllDownloadFinished()
  {
    Iterator localIterator = this.mDownloads.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!((c)this.mDownloads.get(localIterator.next())).b()) {
        return Boolean.valueOf(false);
      }
    }
    return Boolean.valueOf(true);
  }
  
  public void onNetworkChanged()
  {
    try
    {
      ab.c("ApkDownloadManager", "halleytest onNetworkChanged and isNetworkConncted=" + b.b() + ",isAutoDownloadOrPause=" + g.a().c());
      o.c();
      if ((b.b()) && (g.a().c()))
      {
        String str = b.a();
        Iterator localIterator = this.mDownloads.keySet().iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)this.mDownloads.get(localIterator.next());
          if ((localc != null) && (!TextUtils.isEmpty(str)))
          {
            ab.c("ApkDownloadManager", "halleytest onNetworkChanged and di.mAppName = " + localc.E + ",di.mStatus=" + localc.g + ",di.mIsPausedByMobl=" + localc.G);
            if (((localc.g == 3) && (localc.G)) || ((localc.g == 5) && (g.a().a(this.mLastNetType, str))))
            {
              ab.c("ApkDownloadManager", "halleytest onNetworkChanged di.mAppName = " + localc.E + "and startDownloadIfReady");
              localc.c();
            }
            if (((localc.g == 2) || (localc.g == 1)) && (g.a().b(this.mLastNetType, str)))
            {
              localc.d();
              localc.G = true;
              ab.c("ApkDownloadManager", "halleytest onNetworkChanged di.mAppName = " + localc.E + "and pauseDownload, di.mIsPausedByMoble=" + localc.G);
            }
          }
        }
        this.mLastNetType = localObject;
      }
    }
    finally {}
  }
  
  public void pauseDownload(String paramString)
  {
    ab.c("ApkDownloadManager", "call pauseDownload, url: " + paramString);
    paramString = (c)this.mDownloads.get(paramString);
    if (paramString != null) {
      paramString.d();
    }
  }
  
  public c queryDownloadInfo(String paramString)
  {
    Object localObject2 = (c)this.mDownloads.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a.a().b(paramString);
    }
    boolean bool = false;
    if (localObject1 != null) {
      if (!((c)localObject1).a.equals("application/tm.android.apkdiff")) {
        break label103;
      }
    }
    label103:
    for (bool = b.b(paramString, ((c)localObject1).a);; bool = b.f(((c)localObject1).j))
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((c)localObject1).a())
        {
          localObject2 = localObject1;
          if (!bool)
          {
            this.mDownloads.remove(paramString);
            a.a().a(paramString);
            localObject2 = null;
          }
        }
      }
      return localObject2;
    }
  }
  
  public c queryDownloadInfoByPkgName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (String)this.mPkgURL.get(paramString);
      if (!TextUtils.isEmpty(paramString)) {
        return queryDownloadInfo(paramString);
      }
    }
    return null;
  }
  
  public List<c> queryDownloadInfoByVia(String paramString)
  {
    ab.b("ApkDownloadManager", "ApkDownloadManager queryDownloadInfoByVia" + paramString);
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mDownloads.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (c)this.mDownloads.get(((Map.Entry)localObject).getKey());
      if ((localObject != null) && (!TextUtils.isEmpty(((c)localObject).x)) && (((c)localObject).x.contains(paramString)))
      {
        ((c)localObject).a("jimluo");
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public void restartDownload(String paramString)
  {
    ab.c("ApkDownloadManager", "call restartDownload, url: " + paramString);
    paramString = (c)this.mDownloads.get(paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  /* Error */
  public int startDownload(String paramString1, int paramInt, String paramString2, String paramString3, java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc 10
    //   2: new 55	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 387
    //   12: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 389
    //   22: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_2
    //   26: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 275	com/tencent/tmdownloader/internal/downloadservice/b:b	()Z
    //   38: ifne +13 -> 51
    //   41: ldc 10
    //   43: ldc_w 391
    //   46: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: iconst_1
    //   50: ireturn
    //   51: invokestatic 248	com/tencent/tmdownloader/internal/downloadservice/b:a	()Ljava/lang/String;
    //   54: ldc_w 393
    //   57: invokevirtual 396	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: ifne +22 -> 82
    //   63: invokestatic 282	com/tencent/tmdownloader/internal/downloadservice/g:a	()Lcom/tencent/tmdownloader/internal/downloadservice/g;
    //   66: invokevirtual 397	com/tencent/tmdownloader/internal/downloadservice/g:b	()Z
    //   69: ifeq +13 -> 82
    //   72: ldc 10
    //   74: ldc_w 399
    //   77: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: iconst_2
    //   81: ireturn
    //   82: aload_1
    //   83: invokestatic 401	com/tencent/tmdownloader/internal/downloadservice/b:e	(Ljava/lang/String;)Z
    //   86: ifne +13 -> 99
    //   89: ldc 10
    //   91: ldc_w 403
    //   94: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iconst_3
    //   98: ireturn
    //   99: aload_1
    //   100: aload_3
    //   101: invokestatic 336	com/tencent/tmdownloader/internal/downloadservice/b:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   104: ifeq +13 -> 117
    //   107: ldc 10
    //   109: ldc_w 405
    //   112: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: iconst_4
    //   116: ireturn
    //   117: aload_0
    //   118: getfield 46	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mDownloads	Ljava/util/concurrent/ConcurrentHashMap;
    //   121: aload_1
    //   122: invokevirtual 108	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast 99	com/tencent/tmdownloader/internal/downloadservice/c
    //   128: astore 7
    //   130: aload 7
    //   132: ifnonnull +1406 -> 1538
    //   135: invokestatic 183	com/tencent/tmdownloader/internal/storage/a:a	()Lcom/tencent/tmdownloader/internal/storage/a;
    //   138: aload_1
    //   139: invokevirtual 325	com/tencent/tmdownloader/internal/storage/a:b	(Ljava/lang/String;)Lcom/tencent/tmdownloader/internal/downloadservice/c;
    //   142: astore 7
    //   144: aload 7
    //   146: ifnonnull +1339 -> 1485
    //   149: new 99	com/tencent/tmdownloader/internal/downloadservice/c
    //   152: dup
    //   153: aload_1
    //   154: iload_2
    //   155: aload_3
    //   156: invokespecial 408	com/tencent/tmdownloader/internal/downloadservice/c:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: astore 7
    //   161: aload 5
    //   163: ifnull +447 -> 610
    //   166: aload 5
    //   168: getstatic 413	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APPID	Ljava/lang/String;
    //   171: invokeinterface 416 2 0
    //   176: checkcast 331	java/lang/String
    //   179: astore 8
    //   181: aload 8
    //   183: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifne +13 -> 199
    //   189: aload 7
    //   191: aload 8
    //   193: invokestatic 422	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   196: putfield 425	com/tencent/tmdownloader/internal/downloadservice/c:q	J
    //   199: aload 7
    //   201: aload 5
    //   203: getstatic 428	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   206: invokeinterface 416 2 0
    //   211: checkcast 331	java/lang/String
    //   214: putfield 233	com/tencent/tmdownloader/internal/downloadservice/c:r	Ljava/lang/String;
    //   217: aload 7
    //   219: aload 5
    //   221: getstatic 431	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_VERSION	Ljava/lang/String;
    //   224: invokeinterface 416 2 0
    //   229: checkcast 331	java/lang/String
    //   232: putfield 434	com/tencent/tmdownloader/internal/downloadservice/c:s	Ljava/lang/String;
    //   235: aload 7
    //   237: aload 5
    //   239: getstatic 437	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_VIA	Ljava/lang/String;
    //   242: invokeinterface 416 2 0
    //   247: checkcast 331	java/lang/String
    //   250: putfield 366	com/tencent/tmdownloader/internal/downloadservice/c:x	Ljava/lang/String;
    //   253: aload 7
    //   255: aload 5
    //   257: getstatic 440	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADSIZE	Ljava/lang/String;
    //   260: invokeinterface 416 2 0
    //   265: checkcast 331	java/lang/String
    //   268: invokestatic 443	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   271: invokevirtual 446	java/lang/Long:longValue	()J
    //   274: putfield 448	com/tencent/tmdownloader/internal/downloadservice/c:I	J
    //   277: aload 5
    //   279: getstatic 451	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTSTYLE	Ljava/lang/String;
    //   282: invokeinterface 416 2 0
    //   287: checkcast 331	java/lang/String
    //   290: astore 8
    //   292: aload 8
    //   294: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifne +13 -> 310
    //   300: aload 7
    //   302: aload 8
    //   304: invokestatic 457	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   307: putfield 460	com/tencent/tmdownloader/internal/downloadservice/c:H	I
    //   310: aload 5
    //   312: getstatic 440	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADSIZE	Ljava/lang/String;
    //   315: invokeinterface 416 2 0
    //   320: checkcast 331	java/lang/String
    //   323: astore 8
    //   325: aload 8
    //   327: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   330: ifne +13 -> 343
    //   333: aload 7
    //   335: aload 8
    //   337: invokestatic 422	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   340: putfield 448	com/tencent/tmdownloader/internal/downloadservice/c:I	J
    //   343: ldc 10
    //   345: new 55	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 462
    //   355: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 7
    //   360: getfield 460	com/tencent/tmdownloader/internal/downloadservice/c:H	I
    //   363: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: ldc_w 464
    //   369: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 7
    //   374: getfield 448	com/tencent/tmdownloader/internal/downloadservice/c:I	J
    //   377: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 354	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 5
    //   388: getstatic 467	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN	Ljava/lang/String;
    //   391: invokeinterface 416 2 0
    //   396: checkcast 331	java/lang/String
    //   399: astore 8
    //   401: aload 8
    //   403: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   406: ifne +13 -> 419
    //   409: aload 7
    //   411: aload 8
    //   413: invokestatic 422	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   416: putfield 470	com/tencent/tmdownloader/internal/downloadservice/c:v	J
    //   419: aload 7
    //   421: aload 5
    //   423: getstatic 473	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN_TYPE	Ljava/lang/String;
    //   426: invokeinterface 416 2 0
    //   431: checkcast 331	java/lang/String
    //   434: putfield 476	com/tencent/tmdownloader/internal/downloadservice/c:w	Ljava/lang/String;
    //   437: aload 7
    //   439: aload 5
    //   441: getstatic 479	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_CHANNELID	Ljava/lang/String;
    //   444: invokeinterface 416 2 0
    //   449: checkcast 331	java/lang/String
    //   452: putfield 482	com/tencent/tmdownloader/internal/downloadservice/c:y	Ljava/lang/String;
    //   455: aload 7
    //   457: invokestatic 488	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   460: invokevirtual 489	java/util/UUID:toString	()Ljava/lang/String;
    //   463: putfield 492	com/tencent/tmdownloader/internal/downloadservice/c:z	Ljava/lang/String;
    //   466: aload 7
    //   468: aload 5
    //   470: getstatic 495	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_EXTRA_DATA	Ljava/lang/String;
    //   473: invokeinterface 416 2 0
    //   478: checkcast 331	java/lang/String
    //   481: putfield 498	com/tencent/tmdownloader/internal/downloadservice/c:A	Ljava/lang/String;
    //   484: aload 5
    //   486: getstatic 501	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTYPE	Ljava/lang/String;
    //   489: invokeinterface 416 2 0
    //   494: checkcast 331	java/lang/String
    //   497: astore 8
    //   499: aload 8
    //   501: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   504: ifne +13 -> 517
    //   507: aload 7
    //   509: aload 8
    //   511: invokestatic 457	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   514: putfield 504	com/tencent/tmdownloader/internal/downloadservice/c:B	I
    //   517: aload 7
    //   519: aload 5
    //   521: getstatic 507	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_ICON_URL	Ljava/lang/String;
    //   524: invokeinterface 416 2 0
    //   529: checkcast 331	java/lang/String
    //   532: putfield 510	com/tencent/tmdownloader/internal/downloadservice/c:D	Ljava/lang/String;
    //   535: aload 7
    //   537: aload 5
    //   539: getstatic 513	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APP_NAME	Ljava/lang/String;
    //   542: invokeinterface 416 2 0
    //   547: checkcast 331	java/lang/String
    //   550: putfield 293	com/tencent/tmdownloader/internal/downloadservice/c:E	Ljava/lang/String;
    //   553: aload 5
    //   555: getstatic 516	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_SHOW_NOTIFICATION	Ljava/lang/String;
    //   558: invokeinterface 416 2 0
    //   563: checkcast 331	java/lang/String
    //   566: astore 8
    //   568: aload 8
    //   570: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   573: ifne +13 -> 586
    //   576: aload 7
    //   578: aload 8
    //   580: invokestatic 457	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   583: putfield 519	com/tencent/tmdownloader/internal/downloadservice/c:K	I
    //   586: aload 7
    //   588: aload 5
    //   590: getstatic 522	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_IS_AUTOINSTALL_BY_SDK	Ljava/lang/String;
    //   593: invokeinterface 416 2 0
    //   598: checkcast 331	java/lang/String
    //   601: invokestatic 525	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   604: invokevirtual 528	java/lang/Boolean:booleanValue	()Z
    //   607: putfield 531	com/tencent/tmdownloader/internal/downloadservice/c:F	Z
    //   610: aload 7
    //   612: getfield 327	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   615: ldc_w 533
    //   618: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   621: ifeq +1058 -> 1679
    //   624: aload 7
    //   626: aload 4
    //   628: putfield 342	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   631: aload_0
    //   632: getfield 46	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mDownloads	Ljava/util/concurrent/ConcurrentHashMap;
    //   635: aload_1
    //   636: aload 7
    //   638: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   641: pop
    //   642: aload 7
    //   644: getfield 233	com/tencent/tmdownloader/internal/downloadservice/c:r	Ljava/lang/String;
    //   647: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   650: ifne +1026 -> 1676
    //   653: aload_0
    //   654: getfield 48	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mPkgURL	Ljava/util/concurrent/ConcurrentHashMap;
    //   657: aload 7
    //   659: getfield 233	com/tencent/tmdownloader/internal/downloadservice/c:r	Ljava/lang/String;
    //   662: aload_1
    //   663: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   666: pop
    //   667: aload 7
    //   669: getfield 327	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   672: ldc_w 329
    //   675: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   678: ifeq +881 -> 1559
    //   681: aload_1
    //   682: aload 7
    //   684: getfield 327	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   687: invokestatic 336	com/tencent/tmdownloader/internal/downloadservice/b:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   690: istore 6
    //   692: ldc 10
    //   694: new 55	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   701: ldc_w 535
    //   704: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload 6
    //   709: invokevirtual 132	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   712: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: aload 5
    //   720: ifnull +852 -> 1572
    //   723: aload 7
    //   725: aload 5
    //   727: getstatic 538	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_QQ_SOURCE_ID	Ljava/lang/String;
    //   730: invokeinterface 416 2 0
    //   735: checkcast 331	java/lang/String
    //   738: putfield 541	com/tencent/tmdownloader/internal/downloadservice/c:L	Ljava/lang/String;
    //   741: aload 7
    //   743: aload 5
    //   745: getstatic 544	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_CALL_STACK	Ljava/lang/String;
    //   748: invokeinterface 416 2 0
    //   753: checkcast 331	java/lang/String
    //   756: putfield 547	com/tencent/tmdownloader/internal/downloadservice/c:M	Ljava/lang/String;
    //   759: ldc 10
    //   761: new 55	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   768: ldc_w 549
    //   771: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: aload 7
    //   776: getfield 541	com/tencent/tmdownloader/internal/downloadservice/c:L	Ljava/lang/String;
    //   779: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   785: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   788: ldc 10
    //   790: new 55	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   797: ldc_w 551
    //   800: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload 7
    //   805: getfield 547	com/tencent/tmdownloader/internal/downloadservice/c:M	Ljava/lang/String;
    //   808: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   817: aload 7
    //   819: astore 8
    //   821: aload 7
    //   823: invokevirtual 338	com/tencent/tmdownloader/internal/downloadservice/c:a	()Z
    //   826: ifeq +513 -> 1339
    //   829: aload 7
    //   831: astore 8
    //   833: iload 6
    //   835: ifne +504 -> 1339
    //   838: aload_0
    //   839: getfield 46	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mDownloads	Ljava/util/concurrent/ConcurrentHashMap;
    //   842: aload_1
    //   843: invokevirtual 97	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   846: pop
    //   847: invokestatic 183	com/tencent/tmdownloader/internal/storage/a:a	()Lcom/tencent/tmdownloader/internal/storage/a;
    //   850: aload_1
    //   851: invokevirtual 339	com/tencent/tmdownloader/internal/storage/a:a	(Ljava/lang/String;)V
    //   854: new 99	com/tencent/tmdownloader/internal/downloadservice/c
    //   857: dup
    //   858: aload_1
    //   859: iload_2
    //   860: aload_3
    //   861: invokespecial 408	com/tencent/tmdownloader/internal/downloadservice/c:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   864: astore_3
    //   865: aload 5
    //   867: ifnull +405 -> 1272
    //   870: aload 5
    //   872: getstatic 413	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APPID	Ljava/lang/String;
    //   875: invokeinterface 416 2 0
    //   880: checkcast 331	java/lang/String
    //   883: astore 7
    //   885: aload 7
    //   887: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   890: ifne +12 -> 902
    //   893: aload_3
    //   894: aload 7
    //   896: invokestatic 422	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   899: putfield 425	com/tencent/tmdownloader/internal/downloadservice/c:q	J
    //   902: aload_3
    //   903: aload 5
    //   905: getstatic 428	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   908: invokeinterface 416 2 0
    //   913: checkcast 331	java/lang/String
    //   916: putfield 233	com/tencent/tmdownloader/internal/downloadservice/c:r	Ljava/lang/String;
    //   919: aload_3
    //   920: aload 5
    //   922: getstatic 431	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_VERSION	Ljava/lang/String;
    //   925: invokeinterface 416 2 0
    //   930: checkcast 331	java/lang/String
    //   933: putfield 434	com/tencent/tmdownloader/internal/downloadservice/c:s	Ljava/lang/String;
    //   936: aload_3
    //   937: aload 5
    //   939: getstatic 437	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_VIA	Ljava/lang/String;
    //   942: invokeinterface 416 2 0
    //   947: checkcast 331	java/lang/String
    //   950: putfield 366	com/tencent/tmdownloader/internal/downloadservice/c:x	Ljava/lang/String;
    //   953: aload 5
    //   955: getstatic 451	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTSTYLE	Ljava/lang/String;
    //   958: invokeinterface 416 2 0
    //   963: checkcast 331	java/lang/String
    //   966: astore 7
    //   968: aload 7
    //   970: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   973: ifne +12 -> 985
    //   976: aload_3
    //   977: aload 7
    //   979: invokestatic 457	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   982: putfield 460	com/tencent/tmdownloader/internal/downloadservice/c:H	I
    //   985: aload 5
    //   987: getstatic 440	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADSIZE	Ljava/lang/String;
    //   990: invokeinterface 416 2 0
    //   995: checkcast 331	java/lang/String
    //   998: astore 7
    //   1000: aload 7
    //   1002: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1005: ifne +12 -> 1017
    //   1008: aload_3
    //   1009: aload 7
    //   1011: invokestatic 422	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1014: putfield 448	com/tencent/tmdownloader/internal/downloadservice/c:I	J
    //   1017: ldc 10
    //   1019: new 55	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   1026: ldc_w 462
    //   1029: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload_3
    //   1033: getfield 460	com/tencent/tmdownloader/internal/downloadservice/c:H	I
    //   1036: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1039: ldc_w 464
    //   1042: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: aload_3
    //   1046: getfield 448	com/tencent/tmdownloader/internal/downloadservice/c:I	J
    //   1049: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1052: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1055: invokestatic 354	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1058: aload 5
    //   1060: getstatic 467	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN	Ljava/lang/String;
    //   1063: invokeinterface 416 2 0
    //   1068: checkcast 331	java/lang/String
    //   1071: astore 7
    //   1073: aload 7
    //   1075: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1078: ifne +12 -> 1090
    //   1081: aload_3
    //   1082: aload 7
    //   1084: invokestatic 422	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1087: putfield 470	com/tencent/tmdownloader/internal/downloadservice/c:v	J
    //   1090: aload_3
    //   1091: aload 5
    //   1093: getstatic 473	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN_TYPE	Ljava/lang/String;
    //   1096: invokeinterface 416 2 0
    //   1101: checkcast 331	java/lang/String
    //   1104: putfield 476	com/tencent/tmdownloader/internal/downloadservice/c:w	Ljava/lang/String;
    //   1107: aload_3
    //   1108: aload 5
    //   1110: getstatic 479	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_CHANNELID	Ljava/lang/String;
    //   1113: invokeinterface 416 2 0
    //   1118: checkcast 331	java/lang/String
    //   1121: putfield 482	com/tencent/tmdownloader/internal/downloadservice/c:y	Ljava/lang/String;
    //   1124: aload_3
    //   1125: invokestatic 488	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   1128: invokevirtual 489	java/util/UUID:toString	()Ljava/lang/String;
    //   1131: putfield 492	com/tencent/tmdownloader/internal/downloadservice/c:z	Ljava/lang/String;
    //   1134: aload_3
    //   1135: aload 5
    //   1137: getstatic 495	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_EXTRA_DATA	Ljava/lang/String;
    //   1140: invokeinterface 416 2 0
    //   1145: checkcast 331	java/lang/String
    //   1148: putfield 498	com/tencent/tmdownloader/internal/downloadservice/c:A	Ljava/lang/String;
    //   1151: aload 5
    //   1153: getstatic 501	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTYPE	Ljava/lang/String;
    //   1156: invokeinterface 416 2 0
    //   1161: checkcast 331	java/lang/String
    //   1164: astore 7
    //   1166: aload 7
    //   1168: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1171: ifne +12 -> 1183
    //   1174: aload_3
    //   1175: aload 7
    //   1177: invokestatic 457	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1180: putfield 504	com/tencent/tmdownloader/internal/downloadservice/c:B	I
    //   1183: aload_3
    //   1184: aload 5
    //   1186: getstatic 507	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_ICON_URL	Ljava/lang/String;
    //   1189: invokeinterface 416 2 0
    //   1194: checkcast 331	java/lang/String
    //   1197: putfield 510	com/tencent/tmdownloader/internal/downloadservice/c:D	Ljava/lang/String;
    //   1200: aload_3
    //   1201: aload 5
    //   1203: getstatic 513	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APP_NAME	Ljava/lang/String;
    //   1206: invokeinterface 416 2 0
    //   1211: checkcast 331	java/lang/String
    //   1214: putfield 293	com/tencent/tmdownloader/internal/downloadservice/c:E	Ljava/lang/String;
    //   1217: aload 5
    //   1219: getstatic 516	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_SHOW_NOTIFICATION	Ljava/lang/String;
    //   1222: invokeinterface 416 2 0
    //   1227: checkcast 331	java/lang/String
    //   1230: astore 7
    //   1232: aload 7
    //   1234: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1237: ifne +12 -> 1249
    //   1240: aload_3
    //   1241: aload 7
    //   1243: invokestatic 457	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1246: putfield 519	com/tencent/tmdownloader/internal/downloadservice/c:K	I
    //   1249: aload_3
    //   1250: aload 5
    //   1252: getstatic 522	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_IS_AUTOINSTALL_BY_SDK	Ljava/lang/String;
    //   1255: invokeinterface 416 2 0
    //   1260: checkcast 331	java/lang/String
    //   1263: invokestatic 525	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1266: invokevirtual 528	java/lang/Boolean:booleanValue	()Z
    //   1269: putfield 531	com/tencent/tmdownloader/internal/downloadservice/c:F	Z
    //   1272: aload_3
    //   1273: getfield 327	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   1276: ldc_w 533
    //   1279: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1282: ifeq +9 -> 1291
    //   1285: aload_3
    //   1286: aload 4
    //   1288: putfield 342	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   1291: aload_3
    //   1292: aload 5
    //   1294: checkcast 553	java/util/HashMap
    //   1297: invokevirtual 556	com/tencent/tmdownloader/internal/downloadservice/c:a	(Ljava/util/HashMap;)V
    //   1300: aload_0
    //   1301: getfield 46	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mDownloads	Ljava/util/concurrent/ConcurrentHashMap;
    //   1304: aload_1
    //   1305: aload_3
    //   1306: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1309: pop
    //   1310: aload_3
    //   1311: astore 8
    //   1313: aload_3
    //   1314: getfield 233	com/tencent/tmdownloader/internal/downloadservice/c:r	Ljava/lang/String;
    //   1317: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1320: ifne +19 -> 1339
    //   1323: aload_0
    //   1324: getfield 48	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mPkgURL	Ljava/util/concurrent/ConcurrentHashMap;
    //   1327: aload_3
    //   1328: getfield 233	com/tencent/tmdownloader/internal/downloadservice/c:r	Ljava/lang/String;
    //   1331: aload_1
    //   1332: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1335: pop
    //   1336: aload_3
    //   1337: astore 8
    //   1339: aload 8
    //   1341: aload 5
    //   1343: checkcast 553	java/util/HashMap
    //   1346: invokevirtual 556	com/tencent/tmdownloader/internal/downloadservice/c:a	(Ljava/util/HashMap;)V
    //   1349: aload 8
    //   1351: invokevirtual 111	com/tencent/tmdownloader/internal/downloadservice/c:c	()I
    //   1354: istore_2
    //   1355: ldc 10
    //   1357: new 55	java/lang/StringBuilder
    //   1360: dup
    //   1361: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   1364: ldc_w 558
    //   1367: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: iload_2
    //   1371: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1374: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1377: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1380: iload_2
    //   1381: ireturn
    //   1382: astore 8
    //   1384: ldc 10
    //   1386: ldc_w 560
    //   1389: aload 8
    //   1391: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1394: goto -1195 -> 199
    //   1397: astore 8
    //   1399: ldc 10
    //   1401: ldc_w 565
    //   1404: invokestatic 567	com/tencent/tmassistantbase/util/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1407: goto -1130 -> 277
    //   1410: astore 8
    //   1412: ldc 10
    //   1414: ldc_w 569
    //   1417: aload 8
    //   1419: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1422: goto -1112 -> 310
    //   1425: astore 8
    //   1427: ldc 10
    //   1429: ldc_w 571
    //   1432: aload 8
    //   1434: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1437: goto -1094 -> 343
    //   1440: astore 8
    //   1442: ldc 10
    //   1444: ldc_w 573
    //   1447: aload 8
    //   1449: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1452: goto -1033 -> 419
    //   1455: astore 8
    //   1457: ldc 10
    //   1459: ldc_w 575
    //   1462: aload 8
    //   1464: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1467: goto -950 -> 517
    //   1470: astore 8
    //   1472: ldc 10
    //   1474: ldc_w 577
    //   1477: aload 8
    //   1479: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1482: goto -896 -> 586
    //   1485: aload 7
    //   1487: getfield 327	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   1490: ldc_w 329
    //   1493: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1496: ifeq +29 -> 1525
    //   1499: aload_1
    //   1500: aload 7
    //   1502: getfield 327	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   1505: invokestatic 336	com/tencent/tmdownloader/internal/downloadservice/b:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1508: istore 6
    //   1510: iload 6
    //   1512: ifeq -881 -> 631
    //   1515: ldc 10
    //   1517: ldc_w 405
    //   1520: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1523: iconst_4
    //   1524: ireturn
    //   1525: aload 7
    //   1527: getfield 342	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   1530: invokestatic 345	com/tencent/tmdownloader/internal/downloadservice/b:f	(Ljava/lang/String;)Z
    //   1533: istore 6
    //   1535: goto -25 -> 1510
    //   1538: aload 7
    //   1540: getfield 342	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   1543: invokestatic 345	com/tencent/tmdownloader/internal/downloadservice/b:f	(Ljava/lang/String;)Z
    //   1546: ifeq +127 -> 1673
    //   1549: ldc 10
    //   1551: ldc_w 405
    //   1554: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1557: iconst_4
    //   1558: ireturn
    //   1559: aload 7
    //   1561: getfield 342	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   1564: invokestatic 345	com/tencent/tmdownloader/internal/downloadservice/b:f	(Ljava/lang/String;)Z
    //   1567: istore 6
    //   1569: goto -877 -> 692
    //   1572: ldc 10
    //   1574: ldc_w 579
    //   1577: invokestatic 136	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1580: goto -763 -> 817
    //   1583: astore 7
    //   1585: ldc 10
    //   1587: ldc_w 560
    //   1590: aload 7
    //   1592: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1595: goto -693 -> 902
    //   1598: astore 7
    //   1600: ldc 10
    //   1602: ldc_w 569
    //   1605: aload 7
    //   1607: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1610: goto -625 -> 985
    //   1613: astore 7
    //   1615: ldc 10
    //   1617: ldc_w 571
    //   1620: aload 7
    //   1622: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1625: goto -608 -> 1017
    //   1628: astore 7
    //   1630: ldc 10
    //   1632: ldc_w 581
    //   1635: aload 7
    //   1637: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1640: goto -550 -> 1090
    //   1643: astore 7
    //   1645: ldc 10
    //   1647: ldc_w 575
    //   1650: aload 7
    //   1652: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1655: goto -472 -> 1183
    //   1658: astore 7
    //   1660: ldc 10
    //   1662: ldc_w 577
    //   1665: aload 7
    //   1667: invokestatic 563	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1670: goto -421 -> 1249
    //   1673: goto -1006 -> 667
    //   1676: goto -1009 -> 667
    //   1679: goto -1048 -> 631
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1682	0	this	ApkDownloadManager
    //   0	1682	1	paramString1	String
    //   0	1682	2	paramInt	int
    //   0	1682	3	paramString2	String
    //   0	1682	4	paramString3	String
    //   0	1682	5	paramMap	java.util.Map<String, String>
    //   690	878	6	bool	boolean
    //   128	1432	7	localObject1	Object
    //   1583	8	7	localException1	java.lang.Exception
    //   1598	8	7	localException2	java.lang.Exception
    //   1613	8	7	localException3	java.lang.Exception
    //   1628	8	7	localException4	java.lang.Exception
    //   1643	8	7	localException5	java.lang.Exception
    //   1658	8	7	localException6	java.lang.Exception
    //   179	1171	8	localObject2	Object
    //   1382	8	8	localException7	java.lang.Exception
    //   1397	1	8	localException8	java.lang.Exception
    //   1410	8	8	localException9	java.lang.Exception
    //   1425	8	8	localException10	java.lang.Exception
    //   1440	8	8	localException11	java.lang.Exception
    //   1455	8	8	localException12	java.lang.Exception
    //   1470	8	8	localException13	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   189	199	1382	java/lang/Exception
    //   253	277	1397	java/lang/Exception
    //   300	310	1410	java/lang/Exception
    //   333	343	1425	java/lang/Exception
    //   409	419	1440	java/lang/Exception
    //   507	517	1455	java/lang/Exception
    //   576	586	1470	java/lang/Exception
    //   893	902	1583	java/lang/Exception
    //   976	985	1598	java/lang/Exception
    //   1008	1017	1613	java/lang/Exception
    //   1081	1090	1628	java/lang/Exception
    //   1174	1183	1643	java/lang/Exception
    //   1240	1249	1658	java/lang/Exception
  }
  
  public void uninit()
  {
    this.mLeaving = true;
    ArrayList localArrayList = new ArrayList();
    if (!this.mDownloads.isEmpty())
    {
      Iterator localIterator = this.mDownloads.keySet().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)this.mDownloads.get(localIterator.next());
        if (localc.g == 2) {
          pauseDownload(localc.b);
        }
        localArrayList.add(localc);
      }
    }
    ab.c("ApkDownloadManager", "Start to save DownloadInfo list.");
    a.a().a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager
 * JD-Core Version:    0.7.0.1
 */