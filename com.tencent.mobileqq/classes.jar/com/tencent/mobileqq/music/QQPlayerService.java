package com.tencent.mobileqq.music;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.MusicCacheManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.app.AppService;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

@SuppressLint({"NewApi"})
public class QQPlayerService
  extends AppService
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Constants.PlayMode, Constants.PlayState
{
  private static boolean G = Utils.a();
  private static boolean I = false;
  private static QQPlayerLifecycleCallbacks J;
  private static MediaFocusManager.OnMediaFocusChangeListener L;
  public static long a = 0L;
  public static long b = 0L;
  static SparseArray<Boolean> g;
  private static int h = 0;
  private static int i = 103;
  private static int j = 0;
  private static SongInfo[] k;
  private static SongInfo l;
  private static int m = -1;
  private static WeakReference<QQPlayerCallback> n;
  private static WeakReference<QQPlayerCallback> o;
  private static String p;
  private static Map<String, WeakReference<QQPlayerCallback>> q = new HashMap();
  private static Intent r;
  private static Bundle s;
  private static MediaPlayer u;
  private static int w;
  private volatile QQPlayerService.ServiceHandler A;
  private volatile boolean B = false;
  private volatile boolean C = false;
  private HandlerThread D;
  private RemoteCallbackList<IQQPlayerCallback> E;
  private QQPlayerService.NetInfoHandler F;
  private boolean H;
  private IQQPlayerService.Stub K = new QQPlayerService.10(this);
  public long c = 500L;
  public QQPlayerService.DownloadThread d = null;
  public float e = 0.3F;
  public boolean f = true;
  private Object t;
  private int v = 0;
  private QQPlayerService.QQPlayerBroadcastReceiverReceiver x;
  private Handler y;
  private volatile Looper z;
  
  static
  {
    a = 0L;
    b = 0L;
    w = 0;
    G = false;
    g = new SparseArray();
    I = true;
    J = new QQPlayerLifecycleCallbacks();
    g.put(10, Boolean.valueOf(true));
    try
    {
      Iterator localIterator = QQPlayerInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        J.a((IQQPlayerLifeCycleCallback)localClass.newInstance());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQPlayerService", 1, "[static] ", localException);
      L = new QQPlayerService.11();
    }
  }
  
  private void A()
  {
    u = new ReportMediaPlayer();
    u.setOnErrorListener(this);
    u.setOnPreparedListener(this);
    u.setOnCompletionListener(this);
    u.setOnBufferingUpdateListener(this);
    u.setAudioStreamType(3);
  }
  
  private static void B()
  {
    MediaPlayer localMediaPlayer = u;
    if (localMediaPlayer != null) {}
    try
    {
      localMediaPlayer.reset();
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean C()
  {
    try
    {
      QQPlayerService.DownloadThread localDownloadThread = this.d;
      if ((localDownloadThread != null) && (u != null) && (localDownloadThread.isAlive()) && (localDownloadThread.g) && (!localDownloadThread.c) && (localDownloadThread.a.equals(l.d)) && (this.f) && (w != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, current playing song isDownloading...");
        }
        if ((u.isPlaying()) && (!this.B))
        {
          int i1 = j();
          float f1 = i1;
          if (f1 / w * localDownloadThread.f + localDownloadThread.f * this.e >= w)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data is ok, just return;");
            }
            return true;
          }
          if (f1 / w * localDownloadThread.f + localDownloadThread.f * this.e > localDownloadThread.e)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS,no more data to play, need pause!");
            }
            this.v = i1;
            this.B = true;
            u.pause();
            g(1);
            QLog.i("QQPlayerService", 2, "buffered");
          }
        }
        else
        {
          if ((!this.B) || (h != 1) || (u.isPlaying())) {
            break label359;
          }
          if (this.v / w * localDownloadThread.f + localDownloadThread.f * this.e <= localDownloadThread.e)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data buffering is enough");
            }
            this.v = 0;
            this.B = false;
            if (!this.C)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, user no Pause,so play!");
              }
              u.start();
              g(2);
            }
          }
        }
        p();
        break label363;
        label359:
        return true;
      }
      label363:
      return false;
    }
    finally {}
  }
  
  private void D()
  {
    Object localObject = u;
    if ((localObject != null) && (((MediaPlayer)localObject).isPlaying())) {
      u.stop();
    }
    this.C = false;
    localObject = this.d;
    if ((localObject != null) && (((QQPlayerService.DownloadThread)localObject).isAlive()) && (!this.d.c)) {
      this.d.c = true;
    }
    g(4);
    localObject = p;
    if ((localObject != null) && (((String)localObject).startsWith("qzone_")) && (u != null))
    {
      this.C = true;
      m = 0;
      l = null;
    }
    stopSelf();
  }
  
  private void E()
  {
    int i1 = h;
    boolean bool = false;
    Object localObject;
    if ((i1 == 3) && (u != null))
    {
      this.C = false;
      i1 = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.t, 3, 1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestAudioFocus,result:");
        if (i1 == 1) {
          bool = true;
        }
        ((StringBuilder)localObject).append(bool);
        QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
      }
      u.start();
      g(2);
      return;
    }
    i1 = h;
    if (i1 != 6) {
      if (i1 == 7)
      {
        localObject = l;
        if ((localObject != null) && (!TextUtils.isEmpty(((SongInfo)localObject).d))) {}
      }
      else
      {
        if (h != 5) {
          return;
        }
        localObject = l;
        if ((localObject == null) || (TextUtils.isEmpty(((SongInfo)localObject).d))) {
          return;
        }
        this.C = false;
        c(l.d);
        return;
      }
    }
    if (NetworkUtil.isNetworkAvailable(getApplicationContext()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resume from network interrupt, start play ");
        ((StringBuilder)localObject).append(l.e);
        QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
      }
      this.C = false;
      c(l.d);
    }
  }
  
  private void F()
  {
    int i1 = h;
    if ((i1 == 2) || ((i1 == 1) && (u != null)))
    {
      if (VersionUtils.b()) {
        ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.t);
      }
      if (u.isPlaying()) {
        u.pause();
      }
      this.C = true;
      g(3);
    }
  }
  
  private void G()
  {
    SongInfo localSongInfo = l;
    if ((localSongInfo != null) && (localSongInfo.m == 9) && (l.o != null))
    {
      long l1 = l.o.a();
      if (l1 > 0L)
      {
        long l2 = System.currentTimeMillis();
        if (this.A != null) {
          this.A.postDelayed(new QQPlayerService.3(this), l1 * 1000L - l2);
        }
      }
    }
  }
  
  private void H()
  {
    try
    {
      if ((l != null) && (l.m == 9) && (l.o != null))
      {
        l.e = l.o.b();
        d(l);
        G();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static SongInfo I()
  {
    try
    {
      if ((k != null) && (k.length != 0))
      {
        int i1 = k.length;
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pickPreviousSong : songNum=");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(",sPlayMode=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",currentSongIndex=");
          ((StringBuilder)localObject1).append(m);
          QLog.d("QQPlayerService", 2, ((StringBuilder)localObject1).toString());
        }
        int i2 = i;
        switch (i2)
        {
        case 104: 
        default: 
          return null;
        case 105: 
          i2 = m;
          m = new Random().nextInt(i1);
          if ((m == i2) && (i1 >= 1))
          {
            m += 1;
            m %= i1;
          }
          if ((m >= 0) && (m <= i1 - 1))
          {
            localObject1 = k[m];
            return localObject1;
          }
          if (i1 > 0)
          {
            localObject1 = k[0];
            return localObject1;
          }
          return null;
        case 103: 
          if (m >= 0)
          {
            i2 = m;
            i1 -= 1;
            if (i2 <= i1)
            {
              m -= 1;
              if (m < 0) {
                m = i1;
              }
              localObject1 = k[m];
              return localObject1;
            }
          }
          return null;
        case 102: 
          if ((m >= 1) && (m <= i1 - 1))
          {
            m -= 1;
            localObject1 = k[m];
            return localObject1;
          }
          return null;
        case 101: 
          if (l != null)
          {
            localObject1 = l;
            return localObject1;
          }
          localObject1 = k[0];
          return localObject1;
        }
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "pickPreviousSong : sSongList shouldn't be null or empty!");
      }
      return null;
    }
    finally {}
  }
  
  private void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: no need pre download =================");
    }
    QQPlayerService.DownloadThread localDownloadThread = this.d;
    if ((localDownloadThread != null) && (localDownloadThread.isAlive()) && (!this.d.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: download thread running,so no need play");
      }
      this.d.h = false;
    }
  }
  
  private void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download ============");
    }
    Object localObject1;
    if (q() != null) {
      localObject1 = q().d;
    } else {
      localObject1 = "";
    }
    String str = e((String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(str)) {
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_MUSIC);
      ((StringBuilder)localObject2).append(str);
      File localFile = new File(((StringBuilder)localObject2).toString());
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (((String)localObject1).startsWith("qzonevipmusic://"))
        {
          localObject1 = d((String)localObject1);
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return;
          }
        }
      }
      localObject1 = this.d;
      if ((localObject1 != null) && (((QQPlayerService.DownloadThread)localObject1).isAlive()) && (!this.d.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: downloadThread is  running.... ");
        }
        if (((String)localObject2).equals(this.d.a))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart: download url equals nextUrl,so no need play and return.");
          }
          this.d.h = false;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: download url not equals nextUrl,so no need stop.");
        }
        localObject1 = this.d;
        ((QQPlayerService.DownloadThread)localObject1).h = false;
        ((QQPlayerService.DownloadThread)localObject1).c = true;
        this.d = null;
      }
      if ((localFile.exists()) && (localFile.length() > 0L))
      {
        localObject1 = new int[2];
        boolean bool = MusicCacheManager.a(str, (int[])localObject1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mediaPlayStart:");
          localStringBuilder.append(localFile.getAbsolutePath());
          localStringBuilder.append(",isNextCacheComplete:");
          localStringBuilder.append(bool);
          localStringBuilder.append(",nextResult[0]:");
          localStringBuilder.append(localObject1[0]);
          localStringBuilder.append(",nextResult[1]:");
          localStringBuilder.append(localObject1[1]);
          QLog.d("QQPlayerService", 2, localStringBuilder.toString());
        }
        if (bool)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache is complete.return");
          }
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache not complete");
        }
        this.d = new QQPlayerService.DownloadThread(this, (String)localObject2, str, localObject1[0], localObject1[1]);
        localObject1 = this.d;
        ((QQPlayerService.DownloadThread)localObject1).h = false;
        ((QQPlayerService.DownloadThread)localObject1).start();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache no exists");
      }
      this.d = new QQPlayerService.DownloadThread(this, (String)localObject2, str, 0, 0);
      localObject1 = this.d;
      ((QQPlayerService.DownloadThread)localObject1).h = false;
      ((QQPlayerService.DownloadThread)localObject1).start();
    }
  }
  
  private void L()
  {
    ThreadManager.getFileThreadHandler().post(new QQPlayerService.9(this));
  }
  
  private boolean M()
  {
    return (NetworkUtil.isWifiConnected(getApplicationContext())) && (q() != null);
  }
  
  public static SongInfo a()
  {
    try
    {
      if ((k != null) && (k.length != 0))
      {
        int i1 = k.length;
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pickNextSong : songNum=");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(",sPlayMode=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",currentSongIndex=");
          ((StringBuilder)localObject1).append(m);
          QLog.d("QQPlayerService", 2, ((StringBuilder)localObject1).toString());
        }
        int i2 = i;
        switch (i2)
        {
        case 104: 
        default: 
          return null;
        case 105: 
          m = new Random().nextInt(i1);
          if ((m >= 0) && (m <= i1 - 1))
          {
            localObject1 = k[m];
            return localObject1;
          }
          if (i1 > 0)
          {
            localObject1 = k[0];
            return localObject1;
          }
          return null;
        case 103: 
          if (m >= 0)
          {
            i2 = m;
            i1 -= 1;
            if (i2 <= i1)
            {
              m += 1;
              if (m > i1) {
                m = 0;
              }
              localObject1 = k[m];
              return localObject1;
            }
          }
          return null;
        case 102: 
          if ((m >= 0) && (m <= i1 - 2))
          {
            m += 1;
            localObject1 = k[m];
            return localObject1;
          }
          return null;
        case 101: 
          if (l != null)
          {
            localObject1 = l;
            return localObject1;
          }
          localObject1 = k[0];
          return localObject1;
        }
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "pickNextSong : sSongList shouldn't be null or empty!");
      }
      return null;
    }
    finally {}
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return "unknow action";
            }
            return "pause";
          }
          return "resume";
        }
        return "loopProgress";
      }
      return "stop";
    }
    return "start";
  }
  
  public static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "generateToken unknown callerType");
      }
      break;
    case 8: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("miniapp_");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    case 7: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("search_");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    case 6: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("music_pendant_");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    case 5: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("troopbar_");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    case 4: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qzone_");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    case 3: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("music_gene_");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    case 2: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fav_");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    case 1: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("aio_");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private static void a(Context paramContext, SongInfo paramSongInfo)
  {
    a(paramContext, paramSongInfo, a(paramSongInfo));
  }
  
  private static void a(Context paramContext, SongInfo paramSongInfo, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 2);
    localIntent.putExtra("musicplayer.song", paramSongInfo);
    localIntent.putExtra("key_add_to_color_note", paramBoolean);
    MediaFocusManager.b().a(1, L);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQPlayerService", 1, "startPlayMusic", paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString, SongInfo paramSongInfo)
  {
    try
    {
      b(100);
      a(paramContext, paramString, new SongInfo[] { paramSongInfo });
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo)
  {
    a(paramContext, paramString, paramArrayOfSongInfo, 0);
  }
  
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    try
    {
      a(paramContext, paramString, paramArrayOfSongInfo, paramInt, a(paramArrayOfSongInfo[0]));
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt, boolean paramBoolean)
  {
    if (paramArrayOfSongInfo != null) {}
    try
    {
      if (paramArrayOfSongInfo.length != 0)
      {
        if ((paramString != null) && (!paramString.equals("")))
        {
          if ((paramInt >= 0) && (paramInt <= paramArrayOfSongInfo.length - 1))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("startPlayMusic,songLists num=");
              localStringBuilder.append(paramArrayOfSongInfo.length);
              localStringBuilder.append(", startIndex=");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(" ,playMode=");
              localStringBuilder.append(i);
              QLog.d("QQPlayerService", 2, localStringBuilder.toString());
            }
            p = paramString;
            k = paramArrayOfSongInfo;
            if (n != null)
            {
              h = 0;
              paramString = (QQPlayerCallback)n.get();
              if (paramString != null) {
                paramString.onPlayStateChanged(0);
              } else if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "startPlayMusic：lastCallback = null");
              }
            }
            m = paramInt;
            a(paramContext, k[m], paramBoolean);
            return;
          }
          throw new IllegalArgumentException("startIndex is out of range of SongList! Please check!");
        }
        throw new IllegalArgumentException("callerToken shouldn't be null or empty!");
      }
      throw new IllegalArgumentException("SongList shouldn't be null or empty!");
    }
    finally {}
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "resumePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 5);
    localIntent.putExtra("key_add_to_color_note", paramBoolean);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQPlayerService", 1, "resumePlayMusic", paramContext);
    }
  }
  
  public static void a(Intent paramIntent)
  {
    r = paramIntent;
  }
  
  public static void a(Bundle paramBundle)
  {
    s = paramBundle;
  }
  
  public static void a(QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null)
    {
      p = paramQQPlayerCallback.getToken();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCallback: sToken=");
        localStringBuilder.append(p);
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
      }
      n = o;
      o = new WeakReference(paramQQPlayerCallback);
      return;
    }
    p = null;
    n = o;
    o = null;
  }
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart:cache is complete");
    }
    u.reset();
    try
    {
      MusicCacheManager.a(paramFile);
      u.setDataSource(paramFile.getAbsolutePath());
      u.prepare();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("mediaPlayStart:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("QQPlayerService", 2, localStringBuilder2.toString(), localException);
      }
      try
      {
        paramFile.delete();
      }
      catch (Exception paramFile)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("mediaPlayStart,delete file on error:");
          localStringBuilder1.append(paramFile.getMessage());
          QLog.d("QQPlayerService", 2, localStringBuilder1.toString(), paramFile);
        }
      }
    }
    u.start();
    g(2);
    if (M())
    {
      K();
      return;
    }
    J();
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file");
    }
    if (!paramBoolean)
    {
      u.reset();
      g(6);
      return;
    }
    QQPlayerService.DownloadThread localDownloadThread = this.d;
    if ((localDownloadThread != null) && (localDownloadThread.isAlive()) && (!this.d.c))
    {
      if ((paramString1 != null) && (paramString1.equals(this.d.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url is equals current url,need play!");
        }
        this.d.h = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url not equals current url,need stop!");
      }
      localDownloadThread = this.d;
      localDownloadThread.h = false;
      localDownloadThread.c = true;
      this.d = null;
    }
    this.d = new QQPlayerService.DownloadThread(this, paramString1, paramString2, 0, 0);
    this.d.start();
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete");
    }
    if (!paramBoolean)
    {
      u.reset();
      g(6);
      return;
    }
    QQPlayerService.DownloadThread localDownloadThread = this.d;
    if ((localDownloadThread != null) && (localDownloadThread.isAlive()) && (!this.d.c))
    {
      if ((paramString1 != null) && (paramString1.equals(this.d.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url is equals current url,need play!");
        }
        this.d.h = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url not equals current url,need stop!");
      }
      localDownloadThread = this.d;
      localDownloadThread.h = false;
      localDownloadThread.c = true;
      this.d = null;
    }
    this.d = new QQPlayerService.DownloadThread(this, paramString1, paramString2, paramArrayOfInt[0], paramArrayOfInt[1]);
    this.d.start();
  }
  
  public static void a(SongInfo[] paramArrayOfSongInfo)
  {
    a(paramArrayOfSongInfo, i, 0);
  }
  
  public static void a(SongInfo[] paramArrayOfSongInfo, int paramInt1, int paramInt2)
  {
    k = paramArrayOfSongInfo;
    i = paramInt1;
    m = paramInt2;
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playPrev");
    }
    SongInfo localSongInfo = I();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    e(paramContext);
    return false;
  }
  
  public static boolean a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return true;
    }
    return g.get(paramSongInfo.m) == null;
  }
  
  public static boolean a(String paramString)
  {
    int i1 = h;
    if ((i1 != 2) && (i1 != 1)) {
      return false;
    }
    String str = p;
    if (str != null) {
      return str.equals(paramString);
    }
    return false;
  }
  
  public static void b(int paramInt)
  {
    i = paramInt;
  }
  
  private void b(Intent paramIntent)
  {
    a = SystemClock.uptimeMillis();
    if (paramIntent == null) {
      return;
    }
    int i1;
    try
    {
      i1 = paramIntent.getIntExtra("musicplayer.action", 0);
      if (!QLog.isColorLevel()) {
        break label172;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("action->");
      localStringBuilder.append(a(i1));
      QLog.d("QQPlayerService", 2, localStringBuilder.toString());
    }
    catch (Throwable paramIntent)
    {
      if (!QLog.isColorLevel()) {
        break label171;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHandleIntent error");
      localStringBuilder.append(paramIntent.getMessage());
      QLog.e("QQPlayerService", 2, localStringBuilder.toString(), paramIntent);
    }
    if (u == null) {
      if (QLog.isColorLevel())
      {
        QLog.e("QQPlayerService", 2, "onHandleIntent, sPlayer is null");
        return;
      }
    }
    label171:
    label172:
    do
    {
      F();
      return;
      do
      {
        E();
        return;
        do
        {
          if (C()) {
            return;
          }
          do
          {
            D();
            return;
            do
            {
              boolean bool = c(paramIntent);
              if (bool) {
                return;
              }
              return;
              if (i1 != 0) {
                break;
              }
              return;
              return;
            } while (i1 == 2);
          } while (i1 == 3);
        } while (i1 == 4);
      } while (i1 == 5);
    } while (i1 == 6);
  }
  
  public static void b(QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null) {
      q.put(paramQQPlayerCallback.getToken(), new WeakReference(paramQQPlayerCallback));
    }
  }
  
  public static boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPlaying : sPlayState ");
      localStringBuilder.append(f(h));
      QLog.d("QQPlayerService", 2, localStringBuilder.toString());
    }
    int i1 = h;
    boolean bool = true;
    if (i1 != 2)
    {
      if (i1 == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playNext");
    }
    SongInfo localSongInfo = a();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    e(paramContext);
    return false;
  }
  
  public static boolean b(String paramString)
  {
    paramString = e(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_MUSIC);
    localStringBuilder.append(paramString);
    paramString = new File(localStringBuilder.toString());
    return (paramString.exists()) && (paramString.length() > 102400L);
  }
  
  public static int c()
  {
    return h;
  }
  
  public static void c(int paramInt)
  {
    if (u != null)
    {
      int i1 = h;
      if ((i1 == 2) || (i1 == 3)) {
        try
        {
          u.seekTo(paramInt);
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQPlayerService", 2, "seekTo", localIllegalStateException);
          }
        }
      }
    }
  }
  
  public static void c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "pausePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 6);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQPlayerService", 1, "pausePlayMusic", paramContext);
    }
  }
  
  public static void c(QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null) {
      q.remove(paramQQPlayerCallback.getToken());
    }
  }
  
  private void c(SongInfo paramSongInfo)
  {
    if (paramSongInfo != null) {
      try
      {
        w = 0;
        l = paramSongInfo;
        d(paramSongInfo);
        return;
      }
      finally
      {
        break label37;
      }
    }
    throw new IllegalArgumentException("newSong shouldn't be null!");
    label37:
    throw paramSongInfo;
  }
  
  private void c(String paramString)
  {
    boolean bool1 = NetworkUtil.isNetworkAvailable(getApplicationContext());
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mediaPlayStart,isNetworkAvailable = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(",url : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
    }
    if (!G)
    {
      localObject = l;
      if ((localObject == null) || (((SongInfo)localObject).m != 9))
      {
        String str = e(paramString);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AppConstants.SDCARD_MUSIC);
        ((StringBuilder)localObject).append(str);
        File localFile = new File(((StringBuilder)localObject).toString());
        localObject = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = paramString;
          if (paramString.startsWith("qzonevipmusic://"))
          {
            paramString = d(paramString);
            localObject = paramString;
            if (TextUtils.isEmpty(paramString))
            {
              u.reset();
              g(10);
              if (l != null)
              {
                paramString = new StringBuilder();
                paramString.append("mediaPlayStart:url coverted is null , title :");
                paramString.append(l.e);
                paramString.append("and mid :");
                paramString.append(l.i);
                QLog.e("QQPlayerService", 1, paramString.toString());
              }
              return;
            }
          }
        }
        if ((localFile.exists()) && (localFile.length() > 0L))
        {
          paramString = new int[2];
          boolean bool2 = MusicCacheManager.a(str, paramString);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mediaPlayStart:");
            localStringBuilder.append(localFile.getAbsolutePath());
            localStringBuilder.append(",isCacheComplete:");
            localStringBuilder.append(bool2);
            localStringBuilder.append(",result[0]:");
            localStringBuilder.append(paramString[0]);
            localStringBuilder.append(",result[1]:");
            localStringBuilder.append(paramString[1]);
            QLog.d("QQPlayerService", 2, localStringBuilder.toString());
          }
          if (bool2)
          {
            a(localFile);
            return;
          }
          a((String)localObject, bool1, str, paramString);
          return;
        }
        a((String)localObject, bool1, str);
        return;
      }
    }
    H();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart, || play song in compatible mode ||");
    }
    if (!bool1)
    {
      u.reset();
      g(6);
      return;
    }
    try
    {
      u.reset();
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = paramString;
        if (paramString.startsWith("qzonevipmusic://"))
        {
          paramString = d(paramString);
          localObject = paramString;
          if (TextUtils.isEmpty(paramString))
          {
            g(10);
            if (l == null) {
              return;
            }
            paramString = new StringBuilder();
            paramString.append("mediaPlayStart:url coverted is null , title :");
            paramString.append(l.e);
            paramString.append("and mid :");
            paramString.append(l.i);
            QLog.e("QQPlayerService", 1, paramString.toString());
            return;
          }
        }
      }
      u.setDataSource((String)localObject);
      g(1);
      u.prepare();
      g(2);
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IOException => ", paramString);
      }
      u.reset();
      g(6);
    }
    catch (IllegalStateException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalStateException => ", paramString);
      }
    }
    catch (SecurityException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode SecurityException => ", paramString);
      }
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalArgumentException => ", paramString);
      }
    }
    u.start();
    return;
  }
  
  private boolean c(Intent paramIntent)
  {
    paramIntent = (SongInfo)paramIntent.getParcelableExtra("musicplayer.song");
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.d)))
    {
      if (u.isPlaying()) {
        u.stop();
      }
      this.C = false;
      l = paramIntent;
      c(l);
      c(l.d);
      if (paramIntent.l > 0) {
        c(paramIntent.l);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQPlayerService", 2, "mediaPlayStart, url is null");
    }
    return true;
  }
  
  public static int d()
  {
    return i;
  }
  
  private String d(String paramString)
  {
    try
    {
      Object localObject = n();
      if ((localObject != null) && (((Bundle)localObject).containsKey("cacheForRealUrl")))
      {
        localObject = (HashMap)((Bundle)localObject).getSerializable("cacheForRealUrl");
        if ((localObject != null) && (((HashMap)localObject).containsKey(paramString))) {
          return (String)((HashMap)localObject).get(paramString);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fakeUrl:");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("QQPlayerService", 1, ((StringBuilder)localObject).toString());
        return "";
      }
      QLog.e("QQPlayerService", 1, "playDataExtras dont contains cacheForRealUrl !");
      return "";
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static void d(Context paramContext)
  {
    a(paramContext, a(l));
  }
  
  private void d(SongInfo paramSongInfo)
  {
    try
    {
      Object localObject1;
      if ((o != null) && (o.get() != null))
      {
        localObject1 = (QQPlayerCallback)o.get();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("changePlayStateAndNotify:newSong=");
          ((StringBuilder)localObject2).append(paramSongInfo.e);
          ((StringBuilder)localObject2).append(",local callback=");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("QQPlayerService", 2, ((StringBuilder)localObject2).toString());
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          if (this.y == null) {
            this.y = new Handler(Looper.getMainLooper());
          }
          this.y.post(new QQPlayerService.4(this, (QQPlayerCallback)localObject1, paramSongInfo));
        }
        else
        {
          ((QQPlayerCallback)localObject1).onPlaySongChanged(paramSongInfo);
        }
      }
      Object localObject2 = q.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        localObject1 = (WeakReference)q.get(localObject1);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = (QQPlayerCallback)((WeakReference)localObject1).get();
        }
        if (localObject1 != null) {
          if (Thread.currentThread() != Looper.getMainLooper().getThread())
          {
            if (this.y == null) {
              this.y = new Handler(Looper.getMainLooper());
            }
            this.y.post(new QQPlayerService.5(this, (QQPlayerCallback)localObject1, paramSongInfo));
          }
          else
          {
            ((QQPlayerCallback)localObject1).onPlaySongChanged(paramSongInfo);
          }
        }
      }
      if (this.E == null) {
        break label368;
      }
      i2 = this.E.beginBroadcast();
      i1 = 0;
    }
    finally
    {
      for (;;)
      {
        int i2;
        int i1;
        for (;;)
        {
          label368:
          throw paramSongInfo;
        }
        label382:
        i1 += 1;
      }
    }
    if (i1 < i2)
    {
      try
      {
        ((IQQPlayerCallback)this.E.getBroadcastItem(i1)).a(paramSongInfo);
      }
      catch (RemoteException localRemoteException)
      {
        if (!QLog.isColorLevel()) {
          break label382;
        }
      }
      QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", localRemoteException);
    }
    else
    {
      this.E.finishBroadcast();
      return;
    }
  }
  
  public static boolean d(QQPlayerCallback paramQQPlayerCallback)
  {
    int i1 = h;
    if (((i1 != 2) && (i1 != 1)) || (paramQQPlayerCallback == null)) {
      return false;
    }
    Object localObject = o;
    if (localObject != null)
    {
      localObject = (QQPlayerCallback)((WeakReference)localObject).get();
      if ((localObject != null) && (localObject == paramQQPlayerCallback)) {
        return true;
      }
    }
    paramQQPlayerCallback = paramQQPlayerCallback.getToken();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPlayingMySong:callback.getToken()=");
      ((StringBuilder)localObject).append(paramQQPlayerCallback);
      ((StringBuilder)localObject).append(",sToken=");
      ((StringBuilder)localObject).append(p);
      QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
    }
    localObject = p;
    if (localObject != null) {
      return ((String)localObject).equals(paramQQPlayerCallback);
    }
    return false;
  }
  
  private static String e(String paramString)
  {
    if (paramString != null) {
      return MD5.toMD5(paramString);
    }
    return null;
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onAudioFocusChange,focusChange:");
      localStringBuilder1.append(paramInt);
      QLog.d("QQPlayerService", 2, localStringBuilder1.toString());
    }
    try
    {
      if ((paramInt == -3) || ((paramInt == -2) || (paramInt == -1) || (paramInt == 1))) {}
      try
      {
        if ((h == 3) && (u != null) && (!u.isPlaying()))
        {
          u.setVolume(1.0F, 1.0F);
          if (this.B)
          {
            p();
          }
          else if (!this.C)
          {
            u.start();
            g(2);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "onAudioFocusChange,gain focus");
        }
        this.f = true;
        break label241;
        if ((u != null) && (u.isPlaying()))
        {
          u.pause();
          g(3);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "onAudioFocusChange,loss focus");
        }
        this.f = false;
        break label241;
        if ((u != null) && (u.isPlaying())) {
          u.setVolume(0.5F, 0.5F);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "onAudioFocusChange,temporarily lost audio focus");
        }
        label241:
        return;
      }
      finally {}
      StringBuilder localStringBuilder2;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("onAudioFocusChange:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("QQPlayerService", 2, localStringBuilder2.toString(), localException);
      }
    }
  }
  
  public static void e(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "stopPlayMusic");
    }
    MediaFocusManager.b().a(L);
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 3);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQPlayerService", 1, "stopPlayMusic", paramContext);
    }
  }
  
  public static SongInfo[] e()
  {
    return k;
  }
  
  public static int f()
  {
    SongInfo[] arrayOfSongInfo = k;
    if (arrayOfSongInfo != null) {
      return arrayOfSongInfo.length;
    }
    return 0;
  }
  
  private static String f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " Unknow playState ";
    case 8: 
      return " COMPLETION ";
    case 7: 
      return " ERROR_SERVER ";
    case 6: 
      return " NETWORK_INTERRUPT ";
    case 5: 
      return " ERROR_INTERNAL ";
    case 4: 
      return " STOP ";
    case 3: 
      return " PAUSE ";
    case 2: 
      return " PLAYING ";
    case 1: 
      return " BUFFERING ";
    }
    return " IDLE ";
  }
  
  public static SongInfo g()
  {
    return l;
  }
  
  private void g(int paramInt)
  {
    try
    {
      j(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("changePlayStateAndNotify:");
        localStringBuilder.append(f(h));
        localStringBuilder.append(" =====> ");
        localStringBuilder.append(f(paramInt));
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
      }
      h = paramInt;
      i(paramInt);
      h(paramInt);
      return;
    }
    finally {}
  }
  
  private static void g(Context paramContext)
  {
    if ((NetworkUtil.isNetworkAvailable(paramContext)) && (h == 2))
    {
      Object localObject1 = l;
      if ((localObject1 != null) && (((SongInfo)localObject1).m == 9) && (l.o != null))
      {
        e(paramContext);
        localObject1 = l;
        ((SongInfo)localObject1).d = ((SongInfo)localObject1).o.b(NetworkUtil.isWifiConnected(paramContext));
        localObject1 = k;
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject2 = localObject1[i1];
          if ((localObject2 != null) && (localObject2.m == 9) && (localObject2.o != null)) {
            localObject2.d = localObject2.o.b(NetworkUtil.isWifiConnected(paramContext));
          }
          i1 += 1;
        }
        a(paramContext, p, k, m);
      }
    }
  }
  
  public static SongInfo h()
  {
    return q();
  }
  
  private void h(int paramInt)
  {
    RemoteCallbackList localRemoteCallbackList1 = this.E;
    if (localRemoteCallbackList1 != null)
    {
      int i2 = localRemoteCallbackList1.beginBroadcast();
      int i1 = 0;
      while (i1 < i2)
      {
        try
        {
          ((IQQPlayerCallback)this.E.getBroadcastItem(i1)).a(paramInt);
        }
        catch (RemoteException localRemoteException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", localRemoteException);
          }
        }
        i1 += 1;
      }
      RemoteCallbackList localRemoteCallbackList2 = this.E;
      if (localRemoteCallbackList2 != null) {
        localRemoteCallbackList2.finishBroadcast();
      }
    }
    if (h == 2) {
      j = 0;
    }
    if (h == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "PLAY_STATE_ERROR_INTERNAL ======> post runnable to retry play media");
      }
      if (this.A != null) {
        this.A.postDelayed(new QQPlayerService.6(this), 4000L);
      }
    }
  }
  
  public static int i()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = "";
        if (l != null) {
          str = l.e;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDuration(): title= ");
        localStringBuilder.append(str);
        localStringBuilder.append(" ,sPlayState = ");
        localStringBuilder.append(f(h));
        localStringBuilder.append(" duration = ");
        localStringBuilder.append(w);
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
      }
      int i1 = w;
      return i1;
    }
    finally {}
  }
  
  private void i(int paramInt)
  {
    Object localObject1 = o;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      localObject1 = (QQPlayerCallback)o.get();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("changePlayStateAndNotify:playState=");
        ((StringBuilder)localObject2).append(f(paramInt));
        ((StringBuilder)localObject2).append(",local callback=");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("QQPlayerService", 2, ((StringBuilder)localObject2).toString());
      }
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        if (this.y == null) {
          this.y = new Handler(Looper.getMainLooper());
        }
        this.y.post(new QQPlayerService.7(this, (QQPlayerCallback)localObject1, paramInt));
      }
      else
      {
        ((QQPlayerCallback)localObject1).onPlayStateChanged(h);
      }
    }
    else if ((o == null) && (QLog.isColorLevel()))
    {
      QLog.d("QQPlayerService", 2, "changePlayStateAndNotify: sCallback = null! ");
    }
    Object localObject2 = q.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (String)((Iterator)localObject2).next();
      localObject1 = (WeakReference)q.get(localObject1);
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = (QQPlayerCallback)((WeakReference)localObject1).get();
      }
      if (localObject1 != null) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          if (this.y == null) {
            this.y = new Handler(Looper.getMainLooper());
          }
          this.y.post(new QQPlayerService.8(this, (QQPlayerCallback)localObject1, paramInt));
        }
        else
        {
          ((QQPlayerCallback)localObject1).onPlayStateChanged(h);
        }
      }
    }
  }
  
  public static int j()
  {
    int i2 = -1;
    int i1 = i2;
    try
    {
      if (u != null)
      {
        i1 = i2;
        if (u.isPlaying()) {
          i1 = u.getCurrentPosition();
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentSongPosition(): sPlayState = ");
        localStringBuilder.append(f(h));
        localStringBuilder.append(" position = ");
        localStringBuilder.append(i1);
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
      }
      return i1;
    }
    finally {}
  }
  
  private void j(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 4) && (paramInt != 7) && (paramInt != 5) && (paramInt != 6) && (paramInt != 8))
    {
      if (paramInt == 10) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playState value ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is illegal.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public static int k()
  {
    int i1 = -1;
    try
    {
      if (u != null) {
        i1 = u.getCurrentPosition();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentPlayPosition(): sPlayState = ");
        localStringBuilder.append(f(h));
        localStringBuilder.append(" position = ");
        localStringBuilder.append(i1);
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
      }
      return i1;
    }
    finally {}
  }
  
  public static int l()
  {
    return m;
  }
  
  public static Intent m()
  {
    return r;
  }
  
  public static Bundle n()
  {
    return s;
  }
  
  public static String o()
  {
    return p;
  }
  
  public static SongInfo q()
  {
    SongInfo[] arrayOfSongInfo = k;
    if (arrayOfSongInfo != null)
    {
      if (arrayOfSongInfo.length == 0) {
        return null;
      }
      int i1 = arrayOfSongInfo.length;
      int i2;
      switch (i)
      {
      default: 
        return null;
      case 103: 
        i2 = m;
        if (i2 >= 0)
        {
          int i3 = i1 - 1;
          if (i2 <= i3)
          {
            i2 += 1;
            i1 = i2;
            if (i2 > i3) {
              i1 = 0;
            }
            return k[i1];
          }
        }
        return null;
      case 102: 
        i2 = m;
        if ((i2 >= 0) && (i2 <= i1 - 2)) {
          return arrayOfSongInfo[i2];
        }
        return null;
      case 101: 
        SongInfo localSongInfo = l;
        if (localSongInfo != null) {
          return localSongInfo;
        }
        return arrayOfSongInfo[0];
      }
    }
    return null;
  }
  
  private void z()
  {
    this.D = new HandlerThread("QQPlayerService");
    try
    {
      this.D.start();
      this.z = this.D.getLooper();
      this.A = new QQPlayerService.ServiceHandler(this, this.z);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label48:
      break label48;
    }
    QLog.e("QQPlayerService", 1, "start thread oom, stop self");
    stopSelf();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("QQPlayerService", 1, "[onAccountChanged]");
    stopSelf();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onBind");
    }
    return this.K;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if ((QLog.isColorLevel()) && (G) && (paramInt < 100))
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("onBufferingUpdate : ");
      paramMediaPlayer.append(paramInt);
      paramMediaPlayer.append("% buffered");
      QLog.d("QQPlayerService", 2, paramMediaPlayer.toString());
    }
  }
  
  @TargetApi(8)
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCompletion");
    }
    g(8);
    if ((!b(getApplicationContext())) && (VersionUtils.b())) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.t);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCreate");
    }
    if (VersionUtils.b()) {
      this.t = new QQPlayerService.1(this);
    }
    z();
    if (this.A == null) {
      return;
    }
    this.x = new QQPlayerService.QQPlayerBroadcastReceiverReceiver(this);
    this.A.post(new QQPlayerService.2(this));
    this.F = new QQPlayerService.NetInfoHandler();
    AppNetConnInfo.registerConnectionChangeReceiver(MobileQQ.getContext(), this.F);
    J.a(this);
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQPlayerService", 2, "onDestroy");
    }
    if (this.A != null)
    {
      localObject = new QQPlayerService.ReleaseObject(null);
      ((QQPlayerService.ReleaseObject)localObject).a = u;
      ((QQPlayerService.ReleaseObject)localObject).b = this.z;
      ((QQPlayerService.ReleaseObject)localObject).c = l;
      localObject = this.A.obtainMessage(1, localObject);
      this.A.sendMessage((Message)localObject);
    }
    J.b(this);
    p = null;
    w = 0;
    m = 0;
    r = null;
    s = null;
    if (this.y != null) {
      this.y = null;
    }
    Object localObject = this.E;
    if (localObject != null)
    {
      ((RemoteCallbackList)localObject).kill();
      this.E = null;
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.t);
    } else if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "Android 2.1 and below can not stop music");
    }
    localObject = this.F;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
    L();
    this.H = true;
  }
  
  @SuppressLint({"NewApi"})
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("onError,what:");
      paramMediaPlayer.append(paramInt1);
      paramMediaPlayer.append(",extra:");
      paramMediaPlayer.append(paramInt2);
      QLog.e("QQPlayerService", 2, paramMediaPlayer.toString());
    }
    if (paramInt1 == 100)
    {
      paramMediaPlayer = u;
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      A();
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.t);
    }
    B();
    try
    {
      g(5);
      label109:
      return true;
    }
    catch (NullPointerException paramMediaPlayer)
    {
      break label109;
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    super.onLogout(paramLogoutReason);
    QLog.d("QQPlayerService", 1, "[onLogout]");
    stopSelf();
  }
  
  @TargetApi(8)
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = u;
    if (paramMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "player is null while invoking method onPrepared");
      }
      stopSelf();
      return;
    }
    w = paramMediaPlayer.getDuration();
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("onPrepared:sDuration");
      paramMediaPlayer.append(w);
      QLog.d("QQPlayerService", 2, paramMediaPlayer.toString());
    }
    paramMediaPlayer = this.d;
    if ((paramMediaPlayer != null) && (paramMediaPlayer.g) && (this.d.a != null) && (l != null) && (this.d.a.equals(l.d)))
    {
      i1 = w;
      if (i1 != 0)
      {
        double d1 = i1;
        Double.isNaN(d1);
        this.c = ((d1 * 0.01D));
      }
      if (QLog.isColorLevel())
      {
        paramMediaPlayer = new StringBuilder();
        paramMediaPlayer.append("onPrepared:loopProgressDelayTime:");
        paramMediaPlayer.append(this.c);
        QLog.d("QQPlayerService", 2, paramMediaPlayer.toString());
      }
      p();
    }
    if (!VersionUtils.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "onPrepared Android 2.1 and below can not stop music");
      }
      return;
    }
    paramMediaPlayer = (AudioManager)getSystemService("audio");
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = (AudioManager.OnAudioFocusChangeListener)this.t;
    boolean bool = true;
    int i1 = paramMediaPlayer.requestAudioFocus(localOnAudioFocusChangeListener, 3, 1);
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("requestAudioFocus,result:");
      if (i1 != 1) {
        bool = false;
      }
      paramMediaPlayer.append(bool);
      QLog.d("QQPlayerService", 2, paramMediaPlayer.toString());
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onStart");
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onStartCommand");
    }
    Message localMessage = this.A.obtainMessage();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramIntent != null) {
      if (paramIntent.getBooleanExtra("key_add_to_color_note", true)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    I = bool1;
    localMessage.obj = paramIntent;
    paramIntent = this.D;
    if ((paramIntent == null) || (paramIntent.isAlive()) || (this.z != null)) {}
    try
    {
      this.z.quit();
      label97:
      z();
      this.A.sendMessage(localMessage);
      return 2;
    }
    catch (Throwable paramIntent)
    {
      break label97;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
  
  public void p()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loopProgress : loopProgressDelayTime=");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.A.obtainMessage();
    Intent localIntent = new Intent();
    localIntent.putExtra("musicplayer.action", 4);
    ((Message)localObject).obj = localIntent;
    this.A.sendMessageDelayed((Message)localObject, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService
 * JD-Core Version:    0.7.0.1
 */