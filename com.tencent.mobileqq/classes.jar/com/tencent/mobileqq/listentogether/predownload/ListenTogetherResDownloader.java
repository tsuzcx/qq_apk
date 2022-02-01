package com.tencent.mobileqq.listentogether.predownload;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherConstants;
import com.tencent.mobileqq.listentogether.ListenTogetherDPC;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ListenTogetherResDownloader
  implements IListenTogetherResDownloader
{
  private static File c;
  private static Comparator<File> f = new ListenTogetherResDownloader.1();
  private QQAppInterface a;
  private IHttpEngineService b;
  private ConcurrentHashMap<String, List<ListenTogetherResDownloader.MusicReqInfo>> d;
  private ConcurrentHashMap<String, HttpNetReq> e;
  private INetEngineListener g = new ListenTogetherResDownloader.2(this);
  
  public ListenTogetherResDownloader(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = ((IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    this.d = new ConcurrentHashMap();
    this.e = new ConcurrentHashMap();
  }
  
  private void a(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo != null) {}
    try
    {
      if (TextUtils.isEmpty(paramMusicInfo.a)) {
        break label578;
      }
      bool = a(ListenTogetherDPC.a().c);
      if (!bool) {
        return;
      }
      i = ListenTogetherDPC.a().b;
      if (i <= 0)
      {
        QLog.d("ListenTogether.downloader", 2, String.format("download, maxCacheCount <= 0: %s", new Object[] { Integer.valueOf(i) }));
        c();
        b();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("download, musicId: %s", new Object[] { paramMusicInfo.a }));
      }
      if (a(paramMusicInfo.a))
      {
        QLog.d("ListenTogether.downloader", 1, "download, cache file is exist");
        return;
      }
      localObject2 = (List)this.d.get(paramMusicInfo.a);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramMusicInfo.e != null)
        {
          localObject1 = localObject2;
          if (paramMusicInfo.e.size() > 0)
          {
            localObject2 = new ArrayList();
            localIterator1 = paramMusicInfo.e.iterator();
            for (;;)
            {
              localObject1 = localObject2;
              if (!localIterator1.hasNext()) {
                break;
              }
              localObject1 = (String)localIterator1.next();
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                ((List)localObject2).add(new ListenTogetherResDownloader.MusicReqInfo(paramMusicInfo.a, (String)localObject1));
              }
            }
          }
        }
        if ((localObject1 != null) && (((List)localObject1).size() != 0))
        {
          this.d.put(paramMusicInfo.a, localObject1);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("musicReqInfoList is empty!, ");
          ((StringBuilder)localObject1).append(paramMusicInfo);
          QLog.d("ListenTogether.downloader", 1, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      Iterator localIterator2 = null;
      Iterator localIterator1 = null;
      localObject2 = localIterator2;
      if (localObject1 == null) {
        break label600;
      }
      localObject2 = localIterator2;
      if (((List)localObject1).size() <= 0) {
        break label600;
      }
      localIterator2 = ((List)localObject1).iterator();
      for (localObject1 = localIterator1;; localObject1 = localObject2) {
        do
        {
          localObject2 = localObject1;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject2 = (ListenTogetherResDownloader.MusicReqInfo)localIterator2.next();
          if (((ListenTogetherResDownloader.MusicReqInfo)localObject2).d == 1)
          {
            bool = true;
            break label606;
          }
        } while ((((ListenTogetherResDownloader.MusicReqInfo)localObject2).d != 0) || (localObject1 != null));
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        Object localObject2;
        for (;;)
        {
          throw paramMusicInfo;
        }
        boolean bool = false;
        Object localObject1 = localObject2;
        if (!bool) {
          if (localObject1 != null) {}
        }
      }
    }
    if (!b(i))
    {
      QLog.d("ListenTogether.downloader", 1, "download, over cache count");
      return;
    }
    localObject2 = new HttpNetReq();
    ((HttpNetReq)localObject2).mCallback = this.g;
    ((HttpNetReq)localObject2).mReqUrl = ((ListenTogetherResDownloader.MusicReqInfo)localObject1).b;
    ((HttpNetReq)localObject2).mHttpMethod = 0;
    ((HttpNetReq)localObject2).mOutPath = ((ListenTogetherResDownloader.MusicReqInfo)localObject1).e;
    ((HttpNetReq)localObject2).mPrioty = 1;
    ((HttpNetReq)localObject2).setUserData(new Object[] { paramMusicInfo, localObject1 });
    ((HttpNetReq)localObject2).mSupportBreakResume = true;
    this.b.sendReq((NetReq)localObject2);
    ((ListenTogetherResDownloader.MusicReqInfo)localObject1).d = 1;
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.downloader", 2, String.format("musicReqInfo not found, isDownloading: %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return;
    label578:
    QLog.d("ListenTogether.downloader", 1, "musicInfo or id is empty");
  }
  
  private boolean a(int paramInt)
  {
    int i = NetUtil.a(BaseApplicationImpl.getContext());
    if (paramInt == 0) {}
    while (paramInt == 1 ? i == 1 : paramInt == 2 ? (i == 1) && (i == 4) : paramInt == 3 ? (i == 1) && (i == 4) && (i == 3) : (paramInt == 4) && ((i == 1) || (i == 4) || (i == 3) || (i == 2)))
    {
      bool = true;
      break;
    }
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.downloader", 2, String.format("netTypeNeedDownload, requestNetType: %s, netType: %s, needDownload: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    return new File(b(paramString)).exists();
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (c == null)
    {
      c = new File(ListenTogetherConstants.a);
      QLog.d("ListenTogether.downloader", 1, new Object[] { "init getCacheFilePath=", c });
    }
    if (!c.exists())
    {
      boolean bool = c.mkdir();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mkdir cache dir, result: ");
      localStringBuilder.append(bool);
      QLog.d("ListenTogether.downloader", 1, localStringBuilder.toString());
    }
    return new File(ListenTogetherConstants.a, MD5Utils.toMD5(paramString)).getAbsolutePath();
  }
  
  public static void b()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new File(ListenTogetherConstants.a);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.isFile())
          {
            String str1 = b(QQMusicPlayService.d());
            String str2 = localObject2.getAbsolutePath();
            if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2))) {
              QLog.d("ListenTogether.downloader", 1, String.format("removeAllCacheFiles, %s is playing", new Object[] { str2 }));
            } else {
              localObject2.delete();
            }
          }
          i += 1;
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("removeAllCacheFiles, costTime: ");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
    QLog.d("ListenTogether.downloader", 1, ((StringBuilder)localObject1).toString());
  }
  
  private boolean b(int paramInt)
  {
    String str = b(QQMusicPlayService.d());
    File localFile = new File(ListenTogetherConstants.a);
    boolean bool2 = localFile.exists();
    boolean bool1 = false;
    if (bool2)
    {
      Object localObject1 = localFile.listFiles();
      if (localObject1 != null)
      {
        if (localObject1.length < paramInt) {
          return true;
        }
        localObject1 = Arrays.asList((Object[])localObject1);
        Collections.sort((List)localObject1, f);
        int j = ((List)localObject1).size() - paramInt + 1;
        i = j;
        if (j > ((List)localObject1).size()) {
          i = ((List)localObject1).size();
        }
        j = 0;
        while (j < i)
        {
          Object localObject2 = (File)((List)localObject1).get(j);
          if ((!TextUtils.isEmpty(str)) && (str.equals(((File)localObject2).getAbsolutePath())))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkCacheStorage, ");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(" is playing...");
            QLog.d("ListenTogether.downloader", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            ((File)localObject2).delete();
            QLog.d("ListenTogether.downloader", 1, String.format("checkCacheStorage, del index: %s, file: %s", new Object[] { Integer.valueOf(j), ((File)localObject2).getAbsolutePath() }));
          }
          j += 1;
        }
        if (localFile.listFiles() != null)
        {
          i = localFile.listFiles().length;
          break label260;
        }
      }
      else
      {
        return true;
      }
    }
    int i = 0;
    label260:
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.downloader", 2, String.format("checkCacheCount, %s / %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
    }
    if (i < paramInt) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void c()
  {
    try
    {
      this.d.clear();
      Iterator localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (NetReq)((Map.Entry)localIterator.next()).getValue();
        this.b.cancelReq((NetReq)localObject2);
        if ((localObject2 instanceof HttpNetReq))
        {
          localObject2 = (HttpNetReq)localObject2;
          if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.downloader", 2, String.format("cancelAllRequests, cancel req url: %s", new Object[] { ((HttpNetReq)localObject2).mReqUrl }));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, "cancelAllRequests...");
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void a()
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.downloader", 2, "destroy");
    }
  }
  
  public void a(List<MusicInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((MusicInfo)paramList.next());
      }
      return;
    }
    QLog.d("ListenTogether.downloader", 1, "downloadMusicRes, musicList is empty!");
  }
  
  public void c(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d("ListenTogether.downloader", 1, "musicId is empty");
        return;
      }
      Object localObject = (NetReq)this.e.remove(paramString);
      if (localObject != null) {
        this.b.cancelReq((NetReq)localObject);
      }
      this.d.remove(paramString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cancel music id: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ListenTogether.downloader", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader
 * JD-Core Version:    0.7.0.1
 */