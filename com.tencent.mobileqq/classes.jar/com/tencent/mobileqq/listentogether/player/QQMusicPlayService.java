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
import artb;
import artk;
import artl;
import artm;
import artn;
import arto;
import artp;
import bbev;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class QQMusicPlayService
  extends Service
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static int jdField_a_of_type_Int = 0;
  private static MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private static ISong jdField_a_of_type_ComTencentMobileqqListentogetherDataISong;
  private static int jdField_b_of_type_Int;
  private static int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean;
  private static boolean d;
  private static boolean e;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private artm jdField_a_of_type_Artm;
  private artn jdField_a_of_type_Artn;
  private arto jdField_a_of_type_Arto;
  private final LinkedHashSet<Messenger> jdField_a_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public static int a()
  {
    int i = -1;
    if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 3))) {
      i = jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    while (!QLog.isColorLevel()) {
      return i;
    }
    QLog.d("QQMusicPlay.QQMusicPlayService", 2, "getPlayPosition  " + -1);
    return -1;
  }
  
  public static String a()
  {
    ISong localISong = jdField_a_of_type_ComTencentMobileqqListentogetherDataISong;
    if ((localISong != null) && ((jdField_a_of_type_Int == 1) || (jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 3))) {
      return localISong.a();
    }
    return null;
  }
  
  private void a()
  {
    jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
  }
  
  private void a(int paramInt)
  {
    if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 3))) {}
    try
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      QLog.e("QQMusicPlay.QQMusicPlayService", 1, "seekTo", localIllegalStateException);
    }
  }
  
  private void a(Messenger paramMessenger)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashSet.iterator();
    while (localIterator.hasNext()) {
      if (!((Messenger)localIterator.next()).getBinder().isBinderAlive()) {
        localIterator.remove();
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramMessenger);
  }
  
  private void a(ISong paramISong)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramISong.c();
    e = false;
    jdField_c_of_type_Int = 0;
    boolean bool;
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()) && (new File(str).canRead()))
    {
      e = true;
      a(str);
      localArrayList.add(Uri.fromFile(new File(str)).toString());
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("realStartPlay urls=[%s]", new Object[] { Arrays.toString(localArrayList.toArray()) }));
      }
      if (!localArrayList.isEmpty()) {
        break;
      }
      return;
      if (!jdField_c_of_type_Boolean)
      {
        b();
        a(paramISong.a(), 6);
        bool = false;
      }
      else
      {
        if (paramISong.a() != null) {
          localArrayList.addAll(paramISong.a());
        }
        bool = false;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < localArrayList.size()) {}
      try
      {
        b();
        jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource((String)localArrayList.get(i));
        a(paramISong.a(), 1);
        jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        a(paramISong.a(), 2);
        jdField_a_of_type_AndroidMediaMediaPlayer.start();
        artk.a(bool, bbev.b(this));
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalArgumentException => ", new Object[] { Integer.valueOf(i) }), localIllegalArgumentException);
        i += 1;
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          localSecurityException.printStackTrace();
          QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] SecurityException => ", new Object[] { Integer.valueOf(i) }), localSecurityException);
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          localIllegalStateException.printStackTrace();
          QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalStateException => ", new Object[] { Integer.valueOf(i) }), localIllegalStateException);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IOException => ", new Object[] { Integer.valueOf(i) }), localIOException);
          b();
          if (i == localArrayList.size() - 1) {
            a(paramISong.a(), 6);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] Throwable => ", new Object[] { Integer.valueOf(i) }), localThrowable);
          b();
          if (i == localArrayList.size() - 1) {
            a(paramISong.a(), 6);
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 321	java/io/RandomAccessFile
    //   5: dup
    //   6: new 191	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: ldc_w 323
    //   17: invokespecial 326	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: invokevirtual 330	java/io/RandomAccessFile:readByte	()B
    //   27: istore_1
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: lconst_0
    //   32: invokevirtual 334	java/io/RandomAccessFile:seek	(J)V
    //   35: aload_2
    //   36: astore_0
    //   37: aload_2
    //   38: iload_1
    //   39: invokevirtual 337	java/io/RandomAccessFile:write	(I)V
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 340	java/io/RandomAccessFile:close	()V
    //   50: return
    //   51: astore_3
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: astore_0
    //   56: aload_3
    //   57: invokevirtual 341	java/io/IOException:printStackTrace	()V
    //   60: aload_2
    //   61: ifnull -11 -> 50
    //   64: aload_2
    //   65: invokevirtual 340	java/io/RandomAccessFile:close	()V
    //   68: return
    //   69: astore_0
    //   70: return
    //   71: astore_0
    //   72: aload_3
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 340	java/io/RandomAccessFile:close	()V
    //   82: aload_0
    //   83: athrow
    //   84: astore_0
    //   85: return
    //   86: astore_2
    //   87: goto -5 -> 82
    //   90: astore_3
    //   91: aload_0
    //   92: astore_2
    //   93: aload_3
    //   94: astore_0
    //   95: goto -21 -> 74
    //   98: astore_3
    //   99: goto -45 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramString	String
    //   27	12	1	i	int
    //   20	59	2	localObject1	Object
    //   86	1	2	localIOException1	IOException
    //   92	1	2	str	String
    //   1	1	3	localObject2	Object
    //   51	22	3	localIOException2	IOException
    //   90	4	3	localObject3	Object
    //   98	1	3	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   2	21	51	java/io/IOException
    //   64	68	69	java/io/IOException
    //   2	21	71	finally
    //   46	50	84	java/io/IOException
    //   78	82	86	java/io/IOException
    //   23	28	90	finally
    //   30	35	90	finally
    //   37	42	90	finally
    //   56	60	90	finally
    //   23	28	98	java/io/IOException
    //   30	35	98	java/io/IOException
    //   37	42	98	java/io/IOException
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      try
      {
        throw new IllegalArgumentException("playState value " + paramInt + " is illegal.");
      }
      finally {}
    }
    jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updatePlayStateNotify %s [state=%s]", new Object[] { paramString, artb.a(paramInt) }));
    }
    if ((jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Artm != null)) {
      this.jdField_a_of_type_Artm.sendEmptyMessage(14);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashSet.iterator();
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
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashSet.iterator();
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
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      jdField_c_of_type_Boolean = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updateNetStateNotify [%b]", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashSet.iterator();
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
    }
    finally {}
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      d = paramBoolean1;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updateFocusStateNotify [%b_%b]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashSet.iterator();
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
    }
    finally {}
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlay.QQMusicPlayService", 2, "isPlaying : sPlayState " + artb.a(jdField_a_of_type_Int));
    }
    return (jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public static String b()
  {
    ISong localISong = jdField_a_of_type_ComTencentMobileqqListentogetherDataISong;
    if (localISong != null) {
      return localISong.a();
    }
    return null;
  }
  
  private void b()
  {
    if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void b(ISong paramISong)
  {
    try
    {
      jdField_b_of_type_Int = 0;
      jdField_a_of_type_ComTencentMobileqqListentogetherDataISong = paramISong;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updateSongNotify [id=%s]", new Object[] { paramISong.a() }));
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashSet.iterator();
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
    }
    finally {}
  }
  
  public static void b(String paramString)
  {
    if (a())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("QQMusicPlay_exit_action");
      BaseApplicationImpl.getApplication().getApplicationContext().sendBroadcast(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("notifyExit by[%s]", new Object[] { paramString }));
      }
    }
  }
  
  private boolean c()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQMusicPlayService");
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_Artm = new artm(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      if (this.jdField_a_of_type_Artm != null) {
        break label75;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("QQMusicPlay.QQMusicPlayService", 1, "initThread exception, stop self ==>", localThrowable);
      stopSelf();
      return false;
    }
    finally
    {
      while (this.jdField_a_of_type_Artm == null) {}
    }
    return true;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onBind");
    }
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
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
    a(b(), 8);
    artk.b(e, jdField_c_of_type_Int);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onCreate");
    }
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new artl(this);
    if (c()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Artm);
    this.jdField_a_of_type_Arto = new arto(this, null);
    QQMusicPlayService.2 local2 = new QQMusicPlayService.2(this);
    this.jdField_a_of_type_Artm.post(local2);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onDestroy");
    }
    if (this.jdField_a_of_type_Artm != null)
    {
      Object localObject = new artp(this, jdField_a_of_type_AndroidMediaMediaPlayer, jdField_a_of_type_ComTencentMobileqqListentogetherDataISong);
      localObject = this.jdField_a_of_type_Artm.obtainMessage(12, localObject);
      this.jdField_a_of_type_Artm.sendMessage((Message)localObject);
      this.jdField_a_of_type_Artm = null;
    }
    jdField_b_of_type_Int = 0;
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Arto);
      label98:
      if (this.jdField_a_of_type_Artn != null) {}
      try
      {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Artn);
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label98;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.d("QQMusicPlay.QQMusicPlayService", 1, String.format("--->onError [%d %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (paramInt1 == 100)
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      a();
    }
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    b();
    a(b(), 5);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQMusicPlay.QQMusicPlayService", 2, "player is null while invoking method onPrepared");
      }
      stopSelf();
    }
    do
    {
      int i;
      do
      {
        return;
        jdField_b_of_type_Int = jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
        if (QLog.isColorLevel()) {
          QLog.d("QQMusicPlay.QQMusicPlayService", 2, "--->onPrepared:sDuration " + jdField_b_of_type_Int);
        }
        if (this.jdField_a_of_type_Artm != null) {
          this.jdField_a_of_type_Artm.sendEmptyMessage(14);
        }
        paramMediaPlayer = (AudioManager)getSystemService("audio");
        i = paramMediaPlayer.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
        boolean bool = paramMediaPlayer.isMusicActive();
        if (QLog.isColorLevel()) {
          QLog.d("QQMusicPlay.QQMusicPlayService", 2, "--->onPrepared requestAudioFocus,result:" + i + " isMusicActive:" + bool);
        }
      } while (i == 1);
      a(b(), 7);
    } while (this.jdField_a_of_type_Artm == null);
    this.jdField_a_of_type_Artm.sendEmptyMessage(11);
  }
  
  public void onRebind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onRebind");
    }
    super.onRebind(paramIntent);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onStart startId=" + paramInt);
    }
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      paramIntent = (Message)paramIntent.getParcelableExtra("key_message");
      if (paramIntent != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->onStartCommand startId=%d what=%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramIntent.what) }));
        }
        if ((this.jdField_a_of_type_Artm == null) || (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {}
      }
    }
    try
    {
      this.jdField_a_of_type_Artm.getLooper().quit();
      label85:
      c();
      if (this.jdField_a_of_type_Artm != null) {
        this.jdField_a_of_type_Artm.sendMessage(paramIntent);
      }
      return 2;
    }
    catch (Throwable localThrowable)
    {
      break label85;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService
 * JD-Core Version:    0.7.0.1
 */