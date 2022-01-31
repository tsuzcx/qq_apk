package com.tencent.tmdownloader.internal.downloadservice;

import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.j;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.storage.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ApkDownloadManager
  implements com.tencent.tmassistantbase.network.a
{
  protected static final String TAG = "ApkDownloadManager";
  protected static ApkDownloadManager mApkDownloadManager = null;
  final ConcurrentHashMap<String, c> mDownloads = new ConcurrentHashMap();
  protected long mLastAutoDownloadTime = 0L;
  protected long mLastAutoPauseTime = 0L;
  protected String mLastNetType = "";
  private boolean mLeaving = false;
  
  public static ApkDownloadManager getInstance()
  {
    if (mApkDownloadManager == null) {
      mApkDownloadManager = new ApkDownloadManager();
    }
    return mApkDownloadManager;
  }
  
  public void AddDownloadListener(h paramh)
  {
    r.c("ApkDownloadManager", "call AddDownloadListener, dl: " + paramh);
    f.a().a(paramh);
  }
  
  public void RemoveDownloadListener(h paramh)
  {
    r.c("ApkDownloadManager", "call RemoveDownloadListener, dl: " + paramh);
    f.a().b(paramh);
  }
  
  public void cancelDownload(String paramString)
  {
    r.c("ApkDownloadManager", "call cancelDownload, url: " + paramString);
    paramString = (c)this.mDownloads.remove(paramString);
    if (paramString != null) {
      paramString.e();
    }
  }
  
  public void continueDownload(String paramString)
  {
    r.c("ApkDownloadManager", "call continueDownload, url: " + paramString);
    paramString = (c)this.mDownloads.get(paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  public void deleteDownload(String paramString)
  {
    r.c("ApkDownloadManager", "call deleteDownload, url: " + paramString);
    Object localObject = (c)this.mDownloads.remove(paramString);
    if (localObject != null) {
      ((c)localObject).f();
    }
    localObject = com.tencent.tmdownloader.internal.storage.a.a().b(paramString);
    if (localObject != null)
    {
      paramString = ((c)localObject).j;
      localObject = ((c)localObject).k;
      if (paramString != null) {
        new d((String)localObject, paramString).a();
      }
    }
  }
  
  public void init()
  {
    if ((this.mLeaving) || (GlobalUtil.getInstance().getContext() == null))
    {
      r.e("ApkDownloadManager", "init failed: mLeaving = " + this.mLeaving + ", context = " + GlobalUtil.getInstance().getContext());
      return;
    }
    HalleyAgent.init(GlobalUtil.getInstance().getContext(), "", "");
    Object localObject = GlobalUtil.getInstance().getPhoneGuid();
    HalleyAgent.getDownloader().setPhoneGuid((String)localObject);
    HalleyAgent.getDownloader().setTaskNumForCategory(DownloaderTaskCategory.Cate_DefaultMass, 3);
    HalleyAgent.getDownloader().setNotNetworkWaitMillis(5000);
    r.c("ApkDownloadManager", "Start to load DownloadInfo list.");
    this.mDownloads.clear();
    localObject = com.tencent.tmdownloader.internal.storage.a.a().b();
    if (localObject != null)
    {
      r.c("ApkDownloadManager", "The size of downloadinfo_list: " + ((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (localc != null)
        {
          r.c("ApkDownloadManager", "---------------load download info---------------");
          localc.a("ApkDownloadManager");
          if (!TextUtils.isEmpty(localc.b)) {
            this.mDownloads.put(localc.b, localc);
          }
          if (!localc.b()) {
            localc.a(3);
          }
        }
      }
    }
    r.c("ApkDownloadManager", "Add NetworkChangedObserver to NetworkMonitorReceiver");
    NetworkMonitorReceiver.a().a(this);
    this.mLastNetType = b.a();
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
      r.c("ApkDownloadManager", "halleytest onNetworkChanged and isNetworkConncted=" + b.b() + ",isAutoDownloadOrPause=" + g.a().c());
      j.c();
      if ((b.b()) && (g.a().c()))
      {
        String str = b.a();
        Iterator localIterator = this.mDownloads.keySet().iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)this.mDownloads.get(localIterator.next());
          if ((localc != null) && (!TextUtils.isEmpty(str)))
          {
            r.c("ApkDownloadManager", "halleytest onNetworkChanged and di.mAppName = " + localc.F + ",di.mStatus=" + localc.g + ",di.mIsPausedByMobl=" + localc.H);
            if (((localc.g == 3) && (localc.H)) || ((localc.g == 5) && (g.a().a(this.mLastNetType, str))))
            {
              r.c("ApkDownloadManager", "halleytest onNetworkChanged di.mAppName = " + localc.F + "and startDownloadIfReady");
              localc.c();
            }
            if (((localc.g == 2) || (localc.g == 1)) && (g.a().b(this.mLastNetType, str)))
            {
              localc.d();
              localc.H = true;
              r.c("ApkDownloadManager", "halleytest onNetworkChanged di.mAppName = " + localc.F + "and pauseDownload, di.mIsPausedByMoble=" + localc.H);
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
    r.c("ApkDownloadManager", "call pauseDownload, url: " + paramString);
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
      localObject1 = com.tencent.tmdownloader.internal.storage.a.a().b(paramString);
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
            com.tencent.tmdownloader.internal.storage.a.a().a(paramString);
            localObject2 = null;
          }
        }
      }
      return localObject2;
    }
  }
  
  public List<c> queryDownloadInfoByVia(String paramString)
  {
    r.b("ApkDownloadManager", "ApkDownloadManager queryDownloadInfoByVia" + paramString);
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mDownloads.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (c)this.mDownloads.get(((Map.Entry)localObject).getKey());
      if ((localObject != null) && (!TextUtils.isEmpty(((c)localObject).y)) && (((c)localObject).y.contains(paramString)))
      {
        ((c)localObject).a("jimluo");
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public void restartDownload(String paramString)
  {
    r.c("ApkDownloadManager", "call restartDownload, url: " + paramString);
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
    //   2: new 51	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 371
    //   12: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 373
    //   22: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_2
    //   26: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 71	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 268	com/tencent/tmdownloader/internal/downloadservice/b:b	()Z
    //   38: ifne +13 -> 51
    //   41: ldc 10
    //   43: ldc_w 375
    //   46: invokestatic 71	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: iconst_1
    //   50: ireturn
    //   51: invokestatic 249	com/tencent/tmdownloader/internal/downloadservice/b:a	()Ljava/lang/String;
    //   54: ldc_w 377
    //   57: invokevirtual 380	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: ifne +22 -> 82
    //   63: invokestatic 275	com/tencent/tmdownloader/internal/downloadservice/g:a	()Lcom/tencent/tmdownloader/internal/downloadservice/g;
    //   66: invokevirtual 381	com/tencent/tmdownloader/internal/downloadservice/g:b	()Z
    //   69: ifeq +13 -> 82
    //   72: ldc 10
    //   74: ldc_w 383
    //   77: invokestatic 71	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: iconst_2
    //   81: ireturn
    //   82: aload_1
    //   83: invokestatic 385	com/tencent/tmdownloader/internal/downloadservice/b:e	(Ljava/lang/String;)Z
    //   86: ifne +13 -> 99
    //   89: ldc 10
    //   91: ldc_w 387
    //   94: invokestatic 71	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iconst_3
    //   98: ireturn
    //   99: aload_1
    //   100: aload_3
    //   101: invokestatic 326	com/tencent/tmdownloader/internal/downloadservice/b:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   104: ifeq +13 -> 117
    //   107: ldc 10
    //   109: ldc_w 389
    //   112: invokestatic 71	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: iconst_4
    //   116: ireturn
    //   117: aload_0
    //   118: getfield 44	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mDownloads	Ljava/util/concurrent/ConcurrentHashMap;
    //   121: aload_1
    //   122: invokevirtual 104	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast 95	com/tencent/tmdownloader/internal/downloadservice/c
    //   128: astore 8
    //   130: aload 8
    //   132: ifnonnull +1258 -> 1390
    //   135: invokestatic 118	com/tencent/tmdownloader/internal/storage/a:a	()Lcom/tencent/tmdownloader/internal/storage/a;
    //   138: aload_1
    //   139: invokevirtual 121	com/tencent/tmdownloader/internal/storage/a:b	(Ljava/lang/String;)Lcom/tencent/tmdownloader/internal/downloadservice/c;
    //   142: astore 7
    //   144: aload 7
    //   146: ifnonnull +1191 -> 1337
    //   149: new 95	com/tencent/tmdownloader/internal/downloadservice/c
    //   152: dup
    //   153: aload_1
    //   154: iload_2
    //   155: aload_3
    //   156: invokespecial 392	com/tencent/tmdownloader/internal/downloadservice/c:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: astore 7
    //   161: aload 5
    //   163: ifnull +447 -> 610
    //   166: aload 5
    //   168: getstatic 397	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APPID	Ljava/lang/String;
    //   171: invokeinterface 400 2 0
    //   176: checkcast 321	java/lang/String
    //   179: astore 8
    //   181: aload 8
    //   183: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifne +13 -> 199
    //   189: aload 7
    //   191: aload 8
    //   193: invokestatic 406	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   196: putfield 409	com/tencent/tmdownloader/internal/downloadservice/c:r	J
    //   199: aload 7
    //   201: aload 5
    //   203: getstatic 412	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   206: invokeinterface 400 2 0
    //   211: checkcast 321	java/lang/String
    //   214: putfield 415	com/tencent/tmdownloader/internal/downloadservice/c:s	Ljava/lang/String;
    //   217: aload 7
    //   219: aload 5
    //   221: getstatic 418	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_VERSION	Ljava/lang/String;
    //   224: invokeinterface 400 2 0
    //   229: checkcast 321	java/lang/String
    //   232: putfield 421	com/tencent/tmdownloader/internal/downloadservice/c:t	Ljava/lang/String;
    //   235: aload 7
    //   237: aload 5
    //   239: getstatic 424	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_VIA	Ljava/lang/String;
    //   242: invokeinterface 400 2 0
    //   247: checkcast 321	java/lang/String
    //   250: putfield 350	com/tencent/tmdownloader/internal/downloadservice/c:y	Ljava/lang/String;
    //   253: aload 7
    //   255: aload 5
    //   257: getstatic 427	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADSIZE	Ljava/lang/String;
    //   260: invokeinterface 400 2 0
    //   265: checkcast 321	java/lang/String
    //   268: invokestatic 430	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   271: invokevirtual 434	java/lang/Long:longValue	()J
    //   274: putfield 436	com/tencent/tmdownloader/internal/downloadservice/c:J	J
    //   277: aload 5
    //   279: getstatic 439	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTSTYLE	Ljava/lang/String;
    //   282: invokeinterface 400 2 0
    //   287: checkcast 321	java/lang/String
    //   290: astore 8
    //   292: aload 8
    //   294: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifne +13 -> 310
    //   300: aload 7
    //   302: aload 8
    //   304: invokestatic 445	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   307: putfield 447	com/tencent/tmdownloader/internal/downloadservice/c:I	I
    //   310: aload 5
    //   312: getstatic 427	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADSIZE	Ljava/lang/String;
    //   315: invokeinterface 400 2 0
    //   320: checkcast 321	java/lang/String
    //   323: astore 8
    //   325: aload 8
    //   327: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   330: ifne +13 -> 343
    //   333: aload 7
    //   335: aload 8
    //   337: invokestatic 406	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   340: putfield 436	com/tencent/tmdownloader/internal/downloadservice/c:J	J
    //   343: ldc 10
    //   345: new 51	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 449
    //   355: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 7
    //   360: getfield 447	com/tencent/tmdownloader/internal/downloadservice/c:I	I
    //   363: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: ldc_w 451
    //   369: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 7
    //   374: getfield 436	com/tencent/tmdownloader/internal/downloadservice/c:J	J
    //   377: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 338	com/tencent/tmassistantbase/util/r:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 5
    //   388: getstatic 457	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN	Ljava/lang/String;
    //   391: invokeinterface 400 2 0
    //   396: checkcast 321	java/lang/String
    //   399: astore 8
    //   401: aload 8
    //   403: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   406: ifne +13 -> 419
    //   409: aload 7
    //   411: aload 8
    //   413: invokestatic 406	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   416: putfield 460	com/tencent/tmdownloader/internal/downloadservice/c:w	J
    //   419: aload 7
    //   421: aload 5
    //   423: getstatic 463	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN_TYPE	Ljava/lang/String;
    //   426: invokeinterface 400 2 0
    //   431: checkcast 321	java/lang/String
    //   434: putfield 466	com/tencent/tmdownloader/internal/downloadservice/c:x	Ljava/lang/String;
    //   437: aload 7
    //   439: aload 5
    //   441: getstatic 469	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_CHANNELID	Ljava/lang/String;
    //   444: invokeinterface 400 2 0
    //   449: checkcast 321	java/lang/String
    //   452: putfield 472	com/tencent/tmdownloader/internal/downloadservice/c:z	Ljava/lang/String;
    //   455: aload 7
    //   457: invokestatic 478	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   460: invokevirtual 479	java/util/UUID:toString	()Ljava/lang/String;
    //   463: putfield 482	com/tencent/tmdownloader/internal/downloadservice/c:A	Ljava/lang/String;
    //   466: aload 7
    //   468: aload 5
    //   470: getstatic 485	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_EXTRA_DATA	Ljava/lang/String;
    //   473: invokeinterface 400 2 0
    //   478: checkcast 321	java/lang/String
    //   481: putfield 488	com/tencent/tmdownloader/internal/downloadservice/c:B	Ljava/lang/String;
    //   484: aload 5
    //   486: getstatic 491	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTYPE	Ljava/lang/String;
    //   489: invokeinterface 400 2 0
    //   494: checkcast 321	java/lang/String
    //   497: astore 8
    //   499: aload 8
    //   501: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   504: ifne +13 -> 517
    //   507: aload 7
    //   509: aload 8
    //   511: invokestatic 445	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   514: putfield 494	com/tencent/tmdownloader/internal/downloadservice/c:C	I
    //   517: aload 7
    //   519: aload 5
    //   521: getstatic 497	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_ICON_URL	Ljava/lang/String;
    //   524: invokeinterface 400 2 0
    //   529: checkcast 321	java/lang/String
    //   532: putfield 500	com/tencent/tmdownloader/internal/downloadservice/c:E	Ljava/lang/String;
    //   535: aload 7
    //   537: aload 5
    //   539: getstatic 503	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APP_NAME	Ljava/lang/String;
    //   542: invokeinterface 400 2 0
    //   547: checkcast 321	java/lang/String
    //   550: putfield 286	com/tencent/tmdownloader/internal/downloadservice/c:F	Ljava/lang/String;
    //   553: aload 5
    //   555: getstatic 506	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_SHOW_NOTIFICATION	Ljava/lang/String;
    //   558: invokeinterface 400 2 0
    //   563: checkcast 321	java/lang/String
    //   566: astore 8
    //   568: aload 8
    //   570: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   573: ifne +13 -> 586
    //   576: aload 7
    //   578: aload 8
    //   580: invokestatic 445	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   583: putfield 509	com/tencent/tmdownloader/internal/downloadservice/c:L	I
    //   586: aload 7
    //   588: aload 5
    //   590: getstatic 512	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_IS_AUTOINSTALL_BY_SDK	Ljava/lang/String;
    //   593: invokeinterface 400 2 0
    //   598: checkcast 321	java/lang/String
    //   601: invokestatic 515	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   604: invokevirtual 518	java/lang/Boolean:booleanValue	()Z
    //   607: putfield 521	com/tencent/tmdownloader/internal/downloadservice/c:G	Z
    //   610: aload 7
    //   612: getfield 317	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   615: ldc_w 523
    //   618: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   621: ifeq +885 -> 1506
    //   624: aload 7
    //   626: aload 4
    //   628: putfield 124	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   631: aload_0
    //   632: getfield 44	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mDownloads	Ljava/util/concurrent/ConcurrentHashMap;
    //   635: aload_1
    //   636: aload 7
    //   638: invokevirtual 231	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   641: pop
    //   642: aload 7
    //   644: getfield 317	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   647: ldc_w 319
    //   650: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   653: ifeq +762 -> 1415
    //   656: aload_1
    //   657: aload 7
    //   659: getfield 317	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   662: invokestatic 326	com/tencent/tmdownloader/internal/downloadservice/b:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   665: istore 6
    //   667: ldc 10
    //   669: new 51	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 525
    //   679: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: iload 6
    //   684: invokevirtual 148	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   687: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 71	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: aload 7
    //   695: astore 8
    //   697: aload 7
    //   699: invokevirtual 328	com/tencent/tmdownloader/internal/downloadservice/c:a	()Z
    //   702: ifeq +489 -> 1191
    //   705: aload 7
    //   707: astore 8
    //   709: iload 6
    //   711: ifne +480 -> 1191
    //   714: aload_0
    //   715: getfield 44	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mDownloads	Ljava/util/concurrent/ConcurrentHashMap;
    //   718: aload_1
    //   719: invokevirtual 93	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   722: pop
    //   723: invokestatic 118	com/tencent/tmdownloader/internal/storage/a:a	()Lcom/tencent/tmdownloader/internal/storage/a;
    //   726: aload_1
    //   727: invokevirtual 329	com/tencent/tmdownloader/internal/storage/a:a	(Ljava/lang/String;)V
    //   730: new 95	com/tencent/tmdownloader/internal/downloadservice/c
    //   733: dup
    //   734: aload_1
    //   735: iload_2
    //   736: aload_3
    //   737: invokespecial 392	com/tencent/tmdownloader/internal/downloadservice/c:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: astore 8
    //   742: aload 5
    //   744: ifnull +405 -> 1149
    //   747: aload 5
    //   749: getstatic 397	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APPID	Ljava/lang/String;
    //   752: invokeinterface 400 2 0
    //   757: checkcast 321	java/lang/String
    //   760: astore_3
    //   761: aload_3
    //   762: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   765: ifne +12 -> 777
    //   768: aload 8
    //   770: aload_3
    //   771: invokestatic 406	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   774: putfield 409	com/tencent/tmdownloader/internal/downloadservice/c:r	J
    //   777: aload 8
    //   779: aload 5
    //   781: getstatic 412	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   784: invokeinterface 400 2 0
    //   789: checkcast 321	java/lang/String
    //   792: putfield 415	com/tencent/tmdownloader/internal/downloadservice/c:s	Ljava/lang/String;
    //   795: aload 8
    //   797: aload 5
    //   799: getstatic 418	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_VERSION	Ljava/lang/String;
    //   802: invokeinterface 400 2 0
    //   807: checkcast 321	java/lang/String
    //   810: putfield 421	com/tencent/tmdownloader/internal/downloadservice/c:t	Ljava/lang/String;
    //   813: aload 8
    //   815: aload 5
    //   817: getstatic 424	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_VIA	Ljava/lang/String;
    //   820: invokeinterface 400 2 0
    //   825: checkcast 321	java/lang/String
    //   828: putfield 350	com/tencent/tmdownloader/internal/downloadservice/c:y	Ljava/lang/String;
    //   831: aload 5
    //   833: getstatic 439	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTSTYLE	Ljava/lang/String;
    //   836: invokeinterface 400 2 0
    //   841: checkcast 321	java/lang/String
    //   844: astore_3
    //   845: aload_3
    //   846: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   849: ifne +12 -> 861
    //   852: aload 8
    //   854: aload_3
    //   855: invokestatic 445	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   858: putfield 447	com/tencent/tmdownloader/internal/downloadservice/c:I	I
    //   861: aload 5
    //   863: getstatic 427	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADSIZE	Ljava/lang/String;
    //   866: invokeinterface 400 2 0
    //   871: checkcast 321	java/lang/String
    //   874: astore_3
    //   875: aload_3
    //   876: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   879: ifne +12 -> 891
    //   882: aload 8
    //   884: aload_3
    //   885: invokestatic 406	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   888: putfield 436	com/tencent/tmdownloader/internal/downloadservice/c:J	J
    //   891: ldc 10
    //   893: new 51	java/lang/StringBuilder
    //   896: dup
    //   897: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   900: ldc_w 449
    //   903: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: aload 8
    //   908: getfield 447	com/tencent/tmdownloader/internal/downloadservice/c:I	I
    //   911: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   914: ldc_w 451
    //   917: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload 8
    //   922: getfield 436	com/tencent/tmdownloader/internal/downloadservice/c:J	J
    //   925: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   928: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   931: invokestatic 338	com/tencent/tmassistantbase/util/r:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   934: aload 5
    //   936: getstatic 457	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN	Ljava/lang/String;
    //   939: invokeinterface 400 2 0
    //   944: checkcast 321	java/lang/String
    //   947: astore_3
    //   948: aload_3
    //   949: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   952: ifne +12 -> 964
    //   955: aload 8
    //   957: aload_3
    //   958: invokestatic 406	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   961: putfield 460	com/tencent/tmdownloader/internal/downloadservice/c:w	J
    //   964: aload 8
    //   966: aload 5
    //   968: getstatic 463	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN_TYPE	Ljava/lang/String;
    //   971: invokeinterface 400 2 0
    //   976: checkcast 321	java/lang/String
    //   979: putfield 466	com/tencent/tmdownloader/internal/downloadservice/c:x	Ljava/lang/String;
    //   982: aload 8
    //   984: aload 5
    //   986: getstatic 469	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_CHANNELID	Ljava/lang/String;
    //   989: invokeinterface 400 2 0
    //   994: checkcast 321	java/lang/String
    //   997: putfield 472	com/tencent/tmdownloader/internal/downloadservice/c:z	Ljava/lang/String;
    //   1000: aload 8
    //   1002: invokestatic 478	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   1005: invokevirtual 479	java/util/UUID:toString	()Ljava/lang/String;
    //   1008: putfield 482	com/tencent/tmdownloader/internal/downloadservice/c:A	Ljava/lang/String;
    //   1011: aload 8
    //   1013: aload 5
    //   1015: getstatic 485	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_EXTRA_DATA	Ljava/lang/String;
    //   1018: invokeinterface 400 2 0
    //   1023: checkcast 321	java/lang/String
    //   1026: putfield 488	com/tencent/tmdownloader/internal/downloadservice/c:B	Ljava/lang/String;
    //   1029: aload 5
    //   1031: getstatic 491	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTYPE	Ljava/lang/String;
    //   1034: invokeinterface 400 2 0
    //   1039: checkcast 321	java/lang/String
    //   1042: astore_3
    //   1043: aload_3
    //   1044: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1047: ifne +12 -> 1059
    //   1050: aload 8
    //   1052: aload_3
    //   1053: invokestatic 445	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1056: putfield 494	com/tencent/tmdownloader/internal/downloadservice/c:C	I
    //   1059: aload 8
    //   1061: aload 5
    //   1063: getstatic 497	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_ICON_URL	Ljava/lang/String;
    //   1066: invokeinterface 400 2 0
    //   1071: checkcast 321	java/lang/String
    //   1074: putfield 500	com/tencent/tmdownloader/internal/downloadservice/c:E	Ljava/lang/String;
    //   1077: aload 8
    //   1079: aload 5
    //   1081: getstatic 503	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APP_NAME	Ljava/lang/String;
    //   1084: invokeinterface 400 2 0
    //   1089: checkcast 321	java/lang/String
    //   1092: putfield 286	com/tencent/tmdownloader/internal/downloadservice/c:F	Ljava/lang/String;
    //   1095: aload 5
    //   1097: getstatic 506	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_SHOW_NOTIFICATION	Ljava/lang/String;
    //   1100: invokeinterface 400 2 0
    //   1105: checkcast 321	java/lang/String
    //   1108: astore_3
    //   1109: aload_3
    //   1110: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1113: ifne +12 -> 1125
    //   1116: aload 8
    //   1118: aload_3
    //   1119: invokestatic 445	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1122: putfield 509	com/tencent/tmdownloader/internal/downloadservice/c:L	I
    //   1125: aload 8
    //   1127: aload 5
    //   1129: getstatic 512	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_IS_AUTOINSTALL_BY_SDK	Ljava/lang/String;
    //   1132: invokeinterface 400 2 0
    //   1137: checkcast 321	java/lang/String
    //   1140: invokestatic 515	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1143: invokevirtual 518	java/lang/Boolean:booleanValue	()Z
    //   1146: putfield 521	com/tencent/tmdownloader/internal/downloadservice/c:G	Z
    //   1149: aload 8
    //   1151: getfield 317	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   1154: ldc_w 523
    //   1157: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1160: ifeq +10 -> 1170
    //   1163: aload 8
    //   1165: aload 4
    //   1167: putfield 124	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   1170: aload 8
    //   1172: aload 5
    //   1174: checkcast 527	java/util/HashMap
    //   1177: invokevirtual 530	com/tencent/tmdownloader/internal/downloadservice/c:a	(Ljava/util/HashMap;)V
    //   1180: aload_0
    //   1181: getfield 44	com/tencent/tmdownloader/internal/downloadservice/ApkDownloadManager:mDownloads	Ljava/util/concurrent/ConcurrentHashMap;
    //   1184: aload_1
    //   1185: aload 8
    //   1187: invokevirtual 231	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1190: pop
    //   1191: aload 8
    //   1193: aload 5
    //   1195: checkcast 527	java/util/HashMap
    //   1198: invokevirtual 530	com/tencent/tmdownloader/internal/downloadservice/c:a	(Ljava/util/HashMap;)V
    //   1201: aload 8
    //   1203: invokevirtual 107	com/tencent/tmdownloader/internal/downloadservice/c:c	()I
    //   1206: istore_2
    //   1207: ldc 10
    //   1209: new 51	java/lang/StringBuilder
    //   1212: dup
    //   1213: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1216: ldc_w 532
    //   1219: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: iload_2
    //   1223: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokestatic 71	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1232: iload_2
    //   1233: ireturn
    //   1234: astore 8
    //   1236: ldc 10
    //   1238: ldc_w 534
    //   1241: aload 8
    //   1243: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1246: goto -1047 -> 199
    //   1249: astore 8
    //   1251: ldc 10
    //   1253: ldc_w 539
    //   1256: invokestatic 541	com/tencent/tmassistantbase/util/r:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1259: goto -982 -> 277
    //   1262: astore 8
    //   1264: ldc 10
    //   1266: ldc_w 543
    //   1269: aload 8
    //   1271: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1274: goto -964 -> 310
    //   1277: astore 8
    //   1279: ldc 10
    //   1281: ldc_w 545
    //   1284: aload 8
    //   1286: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1289: goto -946 -> 343
    //   1292: astore 8
    //   1294: ldc 10
    //   1296: ldc_w 547
    //   1299: aload 8
    //   1301: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1304: goto -885 -> 419
    //   1307: astore 8
    //   1309: ldc 10
    //   1311: ldc_w 549
    //   1314: aload 8
    //   1316: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1319: goto -802 -> 517
    //   1322: astore 8
    //   1324: ldc 10
    //   1326: ldc_w 551
    //   1329: aload 8
    //   1331: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1334: goto -748 -> 586
    //   1337: aload 7
    //   1339: getfield 317	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   1342: ldc_w 319
    //   1345: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1348: ifeq +29 -> 1377
    //   1351: aload_1
    //   1352: aload 7
    //   1354: getfield 317	com/tencent/tmdownloader/internal/downloadservice/c:a	Ljava/lang/String;
    //   1357: invokestatic 326	com/tencent/tmdownloader/internal/downloadservice/b:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1360: istore 6
    //   1362: iload 6
    //   1364: ifeq -733 -> 631
    //   1367: ldc 10
    //   1369: ldc_w 389
    //   1372: invokestatic 71	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: iconst_4
    //   1376: ireturn
    //   1377: aload 7
    //   1379: getfield 124	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   1382: invokestatic 332	com/tencent/tmdownloader/internal/downloadservice/b:f	(Ljava/lang/String;)Z
    //   1385: istore 6
    //   1387: goto -25 -> 1362
    //   1390: aload 8
    //   1392: astore 7
    //   1394: aload 8
    //   1396: getfield 124	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   1399: invokestatic 332	com/tencent/tmdownloader/internal/downloadservice/b:f	(Ljava/lang/String;)Z
    //   1402: ifeq -760 -> 642
    //   1405: ldc 10
    //   1407: ldc_w 389
    //   1410: invokestatic 71	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1413: iconst_4
    //   1414: ireturn
    //   1415: aload 7
    //   1417: getfield 124	com/tencent/tmdownloader/internal/downloadservice/c:j	Ljava/lang/String;
    //   1420: invokestatic 332	com/tencent/tmdownloader/internal/downloadservice/b:f	(Ljava/lang/String;)Z
    //   1423: istore 6
    //   1425: goto -758 -> 667
    //   1428: astore_3
    //   1429: ldc 10
    //   1431: ldc_w 534
    //   1434: aload_3
    //   1435: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1438: goto -661 -> 777
    //   1441: astore_3
    //   1442: ldc 10
    //   1444: ldc_w 543
    //   1447: aload_3
    //   1448: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1451: goto -590 -> 861
    //   1454: astore_3
    //   1455: ldc 10
    //   1457: ldc_w 545
    //   1460: aload_3
    //   1461: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1464: goto -573 -> 891
    //   1467: astore_3
    //   1468: ldc 10
    //   1470: ldc_w 553
    //   1473: aload_3
    //   1474: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1477: goto -513 -> 964
    //   1480: astore_3
    //   1481: ldc 10
    //   1483: ldc_w 549
    //   1486: aload_3
    //   1487: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1490: goto -431 -> 1059
    //   1493: astore_3
    //   1494: ldc 10
    //   1496: ldc_w 551
    //   1499: aload_3
    //   1500: invokestatic 537	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1503: goto -378 -> 1125
    //   1506: goto -875 -> 631
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1509	0	this	ApkDownloadManager
    //   0	1509	1	paramString1	String
    //   0	1509	2	paramInt	int
    //   0	1509	3	paramString2	String
    //   0	1509	4	paramString3	String
    //   0	1509	5	paramMap	java.util.Map<String, String>
    //   665	759	6	bool	boolean
    //   142	1274	7	localObject1	Object
    //   128	1074	8	localObject2	Object
    //   1234	8	8	localException1	java.lang.Exception
    //   1249	1	8	localException2	java.lang.Exception
    //   1262	8	8	localException3	java.lang.Exception
    //   1277	8	8	localException4	java.lang.Exception
    //   1292	8	8	localException5	java.lang.Exception
    //   1307	8	8	localException6	java.lang.Exception
    //   1322	73	8	localException7	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   189	199	1234	java/lang/Exception
    //   253	277	1249	java/lang/Exception
    //   300	310	1262	java/lang/Exception
    //   333	343	1277	java/lang/Exception
    //   409	419	1292	java/lang/Exception
    //   507	517	1307	java/lang/Exception
    //   576	586	1322	java/lang/Exception
    //   768	777	1428	java/lang/Exception
    //   852	861	1441	java/lang/Exception
    //   882	891	1454	java/lang/Exception
    //   955	964	1467	java/lang/Exception
    //   1050	1059	1480	java/lang/Exception
    //   1116	1125	1493	java/lang/Exception
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
    r.c("ApkDownloadManager", "Start to save DownloadInfo list.");
    com.tencent.tmdownloader.internal.storage.a.a().a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager
 * JD-Core Version:    0.7.0.1
 */