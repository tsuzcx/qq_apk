package com.tencent.mobileqq.listentogether.player;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class QQMusicPlayService
  extends Service
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, IConst, IConst.PlayState
{
  private static volatile ISong h;
  private static volatile int i;
  private static volatile int j;
  private static MediaPlayer k;
  private static boolean l;
  private static boolean m;
  private static boolean n;
  private static int o;
  private QQMusicPlayService.NetInfoHandler a;
  private Messenger b;
  private QQMusicPlayService.QQMusicPlayBroadcastReceiver c;
  private final LinkedHashSet<Messenger> d = new LinkedHashSet();
  private AudioManager.OnAudioFocusChangeListener e;
  private volatile boolean f = false;
  private volatile boolean g = false;
  private HandlerThread p;
  private QQMusicPlayService.IncomingHandler q;
  
  public static int a()
  {
    return j;
  }
  
  private void a(int paramInt)
  {
    if ((k != null) && ((i == 2) || (i == 3))) {
      try
      {
        k.seekTo(paramInt);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, "seekTo", localIllegalStateException);
      }
    }
  }
  
  private void a(Messenger paramMessenger)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (!((Messenger)localIterator.next()).getBinder().isBinderAlive()) {
        localIterator.remove();
      }
    }
    this.d.add(paramMessenger);
  }
  
  private void a(ISong paramISong)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramISong.d();
    int i3 = 0;
    n = false;
    o = 0;
    boolean bool;
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()) && (new File(str).canRead()))
    {
      n = true;
      a(str);
      localArrayList.add(Uri.fromFile(new File(str)).toString());
      bool = true;
    }
    else
    {
      if (!l)
      {
        q();
        a(paramISong.a(), 6);
      }
      else if (paramISong.c() != null)
      {
        localArrayList.addAll(paramISong.c());
      }
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("realStartPlay urls=[%s]", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= localArrayList.size()) {
        break;
      }
      try
      {
        q();
        k.setDataSource((String)localArrayList.get(i1));
        a(paramISong.a(), 1);
        k.prepare();
        i2 = 1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] Throwable => ", new Object[] { Integer.valueOf(i1) }), localThrowable);
        q();
        if (i1 == localArrayList.size() - 1) {
          a(paramISong.a(), 6);
        }
      }
      catch (IOException localIOException)
      {
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IOException => ", new Object[] { Integer.valueOf(i1) }), localIOException);
        q();
        if (i1 == localArrayList.size() - 1) {
          a(paramISong.a(), 6);
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalStateException => ", new Object[] { Integer.valueOf(i1) }), localIllegalStateException);
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] SecurityException => ", new Object[] { Integer.valueOf(i1) }), localSecurityException);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalArgumentException => ", new Object[] { Integer.valueOf(i1) }), localIllegalArgumentException);
      }
      i1 += 1;
    }
    k.start();
    if (i2 != 0) {
      a(paramISong.a(), 2);
    }
    QQMusicPlayReport.a(bool, NetworkUtil.getNetworkType(this));
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 286	java/io/RandomAccessFile
    //   8: dup
    //   9: new 155	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: ldc_w 288
    //   20: invokespecial 291	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 295	java/io/RandomAccessFile:readByte	()B
    //   28: istore_1
    //   29: aload_0
    //   30: lconst_0
    //   31: invokevirtual 299	java/io/RandomAccessFile:seek	(J)V
    //   34: aload_0
    //   35: iload_1
    //   36: invokevirtual 302	java/io/RandomAccessFile:write	(I)V
    //   39: aload_0
    //   40: invokevirtual 305	java/io/RandomAccessFile:close	()V
    //   43: return
    //   44: astore_3
    //   45: aload_0
    //   46: astore_2
    //   47: goto +30 -> 77
    //   50: astore_3
    //   51: goto +11 -> 62
    //   54: astore_3
    //   55: goto +22 -> 77
    //   58: astore_3
    //   59: aload 4
    //   61: astore_0
    //   62: aload_0
    //   63: astore_2
    //   64: aload_3
    //   65: invokevirtual 306	java/io/IOException:printStackTrace	()V
    //   68: aload_0
    //   69: ifnull +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 305	java/io/RandomAccessFile:close	()V
    //   76: return
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 305	java/io/RandomAccessFile:close	()V
    //   85: aload_3
    //   86: athrow
    //   87: astore_0
    //   88: return
    //   89: astore_0
    //   90: goto -5 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString	String
    //   28	8	1	i1	int
    //   4	78	2	str	String
    //   44	1	3	localObject1	Object
    //   50	1	3	localIOException1	IOException
    //   54	1	3	localObject2	Object
    //   58	28	3	localIOException2	IOException
    //   1	59	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   24	39	44	finally
    //   24	39	50	java/io/IOException
    //   5	24	54	finally
    //   64	68	54	finally
    //   5	24	58	java/io/IOException
    //   39	43	87	java/io/IOException
    //   72	76	87	java/io/IOException
    //   81	85	89	java/io/IOException
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 8)) {}
    try
    {
      i = paramInt;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updatePlayStateNotify %s [state=%s]", new Object[] { paramString, Const.a(paramInt) }));
      }
      if ((i == 2) && (this.q != null)) {
        this.q.sendEmptyMessage(14);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          Messenger localMessenger = (Messenger)localIterator.next();
          try
          {
            if (localMessenger.getBinder().isBinderAlive())
            {
              Message localMessage = Message.obtain(null, 2);
              Bundle localBundle = new Bundle();
              localBundle.putString("key_id", paramString);
              localBundle.putInt("key_play_state", paramInt);
              localMessage.setData(localBundle);
              localMessenger.send(localMessage);
            }
          }
          catch (RemoteException localRemoteException)
          {
            QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updatePlayStateNotify sendToClient exception", localRemoteException);
          }
        }
      }
      return;
    }
    finally
    {
      break label241;
    }
    paramString = new StringBuilder();
    paramString.append("playState value ");
    paramString.append(paramInt);
    paramString.append(" is illegal.");
    throw new IllegalArgumentException(paramString.toString());
    label241:
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        Messenger localMessenger = (Messenger)localIterator.next();
        try
        {
          if (localMessenger.getBinder().isBinderAlive())
          {
            Message localMessage = Message.obtain(null, 15);
            Bundle localBundle = new Bundle();
            localBundle.putInt("key_position", paramInt1);
            localBundle.putInt("key_duration", paramInt2);
            localBundle.putString("key_id", paramString);
            localMessage.setData(localBundle);
            localMessenger.send(localMessage);
          }
        }
        catch (RemoteException localRemoteException)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateProgressNotify sendToClient exception", localRemoteException);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      m = paramBoolean1;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updateFocusStateNotify [%b_%b]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
      }
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        Messenger localMessenger = (Messenger)localIterator.next();
        try
        {
          if (localMessenger.getBinder().isBinderAlive())
          {
            Message localMessage = Message.obtain(null, 4);
            Bundle localBundle = new Bundle();
            localBundle.putBoolean("key_focus_state", paramBoolean1);
            localBundle.putBoolean("key_focus_transient", paramBoolean2);
            localMessage.setData(localBundle);
            localMessenger.send(localMessage);
          }
        }
        catch (RemoteException localRemoteException)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateFocusStateNotify sendToClient exception", localRemoteException);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static int b()
  {
    if ((k != null) && ((i == 2) || (i == 3))) {
      try
      {
        int i1 = k.getCurrentPosition();
        return i1;
      }
      catch (Exception localException)
      {
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, new Object[] { "getPlayPosition exception state=", Const.a(i), localException.getStackTrace() });
        return -1;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPlayPosition  ");
      localStringBuilder.append(-1);
      QLog.d("QQMusicPlay.QQMusicPlayService", 2, localStringBuilder.toString());
    }
    return -1;
  }
  
  private void b(ISong paramISong)
  {
    try
    {
      j = 0;
      h = paramISong;
      QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("updateSongNotify [id=%s]", new Object[] { paramISong.a() }));
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        Messenger localMessenger = (Messenger)localIterator.next();
        try
        {
          if (localMessenger.getBinder().isBinderAlive())
          {
            Message localMessage = Message.obtain(null, 5);
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("key_song", paramISong);
            localMessage.setData(localBundle);
            localMessenger.send(localMessage);
          }
        }
        catch (RemoteException localRemoteException)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateSongNotify sendToClient exception", localRemoteException);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramISong;
    }
  }
  
  public static void b(String paramString)
  {
    if (c())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("QQMusicPlay_exit_action");
      BaseApplicationImpl.getApplication().getApplicationContext().sendBroadcast(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("notifyExit by[%s]", new Object[] { paramString }));
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      l = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updateNetStateNotify [%b]", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        Messenger localMessenger = (Messenger)localIterator.next();
        try
        {
          if (localMessenger.getBinder().isBinderAlive())
          {
            Message localMessage = Message.obtain(null, 3);
            Bundle localBundle = new Bundle();
            localBundle.putBoolean("key_net_state", paramBoolean);
            localMessage.setData(localBundle);
            localMessenger.send(localMessage);
          }
        }
        catch (RemoteException localRemoteException)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateNetStateNotify sendToClient exception", localRemoteException);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static boolean c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPlaying : sPlayState ");
      localStringBuilder.append(Const.a(i));
      QLog.d("QQMusicPlay.QQMusicPlayService", 2, localStringBuilder.toString());
    }
    int i1 = i;
    boolean bool = true;
    if (i1 != 2)
    {
      if (i == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static String d()
  {
    ISong localISong = h;
    if ((localISong != null) && ((i == 1) || (i == 2) || (i == 3))) {
      return localISong.a();
    }
    return null;
  }
  
  public static String e()
  {
    ISong localISong = h;
    if (localISong != null) {
      return localISong.a();
    }
    return null;
  }
  
  public static ISong f()
  {
    return h;
  }
  
  public static int g()
  {
    return i;
  }
  
  /* Error */
  private boolean o()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 485	android/os/HandlerThread
    //   4: dup
    //   5: ldc_w 487
    //   8: invokespecial 488	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   11: putfield 490	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:p	Landroid/os/HandlerThread;
    //   14: aload_0
    //   15: getfield 490	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:p	Landroid/os/HandlerThread;
    //   18: invokevirtual 491	android/os/HandlerThread:start	()V
    //   21: aload_0
    //   22: new 317	com/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler
    //   25: dup
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 490	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:p	Landroid/os/HandlerThread;
    //   31: invokevirtual 495	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   34: invokespecial 498	com/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler:<init>	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;Landroid/os/Looper;)V
    //   37: putfield 69	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:q	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler;
    //   40: aload_0
    //   41: getfield 69	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:q	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler;
    //   44: ifnonnull +37 -> 81
    //   47: iconst_1
    //   48: ireturn
    //   49: astore_1
    //   50: goto +33 -> 83
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 499	java/lang/Throwable:printStackTrace	()V
    //   58: ldc 87
    //   60: iconst_1
    //   61: ldc_w 501
    //   64: aload_1
    //   65: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: aload_0
    //   69: invokevirtual 504	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:stopSelf	()V
    //   72: aload_0
    //   73: getfield 69	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:q	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler;
    //   76: ifnonnull +5 -> 81
    //   79: iconst_1
    //   80: ireturn
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: getfield 69	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:q	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler;
    //   87: ifnonnull +5 -> 92
    //   90: iconst_1
    //   91: ireturn
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	QQMusicPlayService
    //   49	1	1	localObject	Object
    //   53	40	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	40	49	finally
    //   54	72	49	finally
    //   14	40	53	java/lang/Throwable
  }
  
  private void p()
  {
    k = new ReportMediaPlayer();
    k.setOnErrorListener(this);
    k.setOnPreparedListener(this);
    k.setOnCompletionListener(this);
    k.setOnBufferingUpdateListener(this);
    k.setAudioStreamType(3);
  }
  
  private void q()
  {
    MediaPlayer localMediaPlayer = k;
    if (localMediaPlayer != null) {}
    try
    {
      localMediaPlayer.reset();
      return;
    }
    catch (Exception localException) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onBind");
    return this.b.getBinder();
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramInt < 100)) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->onBufferingUpdate %d/100", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onCompletion");
    }
    a(e(), 8);
    QQMusicPlayReport.b(n, o);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onCreate");
    }
    this.e = new QQMusicPlayService.1(this);
    if (o()) {
      return;
    }
    this.b = new Messenger(this.q);
    this.c = new QQMusicPlayService.QQMusicPlayBroadcastReceiver(this, null);
    QQMusicPlayService.2 local2 = new QQMusicPlayService.2(this);
    this.q.post(local2);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onDestroy");
    Object localObject;
    if (this.q != null)
    {
      localObject = new QQMusicPlayService.ReleaseObject(this, k, h);
      localObject = this.q.obtainMessage(12, localObject);
      this.q.sendMessage((Message)localObject);
      this.q = null;
    }
    j = 0;
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(this.e);
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.c);
      localObject = this.a;
      if (localObject == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.d("QQMusicPlay.QQMusicPlayService", 1, String.format("--->onError [%d %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (paramInt1 == 100)
    {
      paramMediaPlayer = k;
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      p();
    }
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(this.e);
    q();
    a(e(), 5);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = k;
    if (paramMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQMusicPlay.QQMusicPlayService", 2, "player is null while invoking method onPrepared");
      }
      stopSelf();
      return;
    }
    j = paramMediaPlayer.getDuration();
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("--->onPrepared:sDuration ");
    paramMediaPlayer.append(j);
    QLog.d("QQMusicPlay.QQMusicPlayService", 1, paramMediaPlayer.toString());
    paramMediaPlayer = this.q;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.sendEmptyMessage(14);
    }
    paramMediaPlayer = (AudioManager)getSystemService("audio");
    int i1 = paramMediaPlayer.requestAudioFocus(this.e, 3, 1);
    boolean bool = paramMediaPlayer.isMusicActive();
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("--->onPrepared requestAudioFocus,result:");
      paramMediaPlayer.append(i1);
      paramMediaPlayer.append(" isMusicActive:");
      paramMediaPlayer.append(bool);
      QLog.d("QQMusicPlay.QQMusicPlayService", 2, paramMediaPlayer.toString());
    }
    if (i1 == 1) {
      return;
    }
    a(e(), 7);
    paramMediaPlayer = this.q;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.sendEmptyMessage(11);
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onRebind");
    super.onRebind(paramIntent);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--->onStart startId=");
    localStringBuilder.append(paramInt);
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, localStringBuilder.toString());
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      paramIntent = (Message)paramIntent.getParcelableExtra("key_message");
      if (paramIntent != null)
      {
        QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("--->onStartCommand startId=%d what=%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramIntent.what) }));
        if ((this.q == null) || (this.p.isAlive())) {}
      }
    }
    try
    {
      this.q.getLooper().quit();
      label79:
      o();
      QQMusicPlayService.IncomingHandler localIncomingHandler = this.q;
      if (localIncomingHandler != null) {
        localIncomingHandler.sendMessage(paramIntent);
      }
      return 2;
    }
    catch (Throwable localThrowable)
    {
      break label79;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onUnbind");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService
 * JD-Core Version:    0.7.0.1
 */