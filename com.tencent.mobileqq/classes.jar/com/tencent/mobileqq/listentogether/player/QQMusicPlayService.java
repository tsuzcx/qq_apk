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
  private static volatile int jdField_a_of_type_Int;
  private static MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private static volatile ISong jdField_a_of_type_ComTencentMobileqqListentogetherDataISong;
  private static volatile int jdField_b_of_type_Int;
  private static int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean;
  private static boolean d;
  private static boolean e;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private QQMusicPlayService.IncomingHandler jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler;
  private QQMusicPlayService.NetInfoHandler jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$NetInfoHandler;
  private QQMusicPlayService.QQMusicPlayBroadcastReceiver jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$QQMusicPlayBroadcastReceiver;
  private final LinkedHashSet<Messenger> jdField_a_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
  public static int a()
  {
    return jdField_b_of_type_Int;
  }
  
  public static ISong a()
  {
    return jdField_a_of_type_ComTencentMobileqqListentogetherDataISong;
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
    jdField_a_of_type_AndroidMediaMediaPlayer = new ReportMediaPlayer();
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
  }
  
  private void a(int paramInt)
  {
    if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 3))) {
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
    int k = 0;
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
    else
    {
      if (!jdField_c_of_type_Boolean)
      {
        b();
        a(paramISong.a(), 6);
      }
      else if (paramISong.a() != null)
      {
        localArrayList.addAll(paramISong.a());
      }
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("realStartPlay urls=[%s]", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= localArrayList.size()) {
        break;
      }
      try
      {
        b();
        jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource((String)localArrayList.get(i));
        a(paramISong.a(), 1);
        jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        j = 1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] Throwable => ", new Object[] { Integer.valueOf(i) }), localThrowable);
        b();
        if (i == localArrayList.size() - 1) {
          a(paramISong.a(), 6);
        }
      }
      catch (IOException localIOException)
      {
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IOException => ", new Object[] { Integer.valueOf(i) }), localIOException);
        b();
        if (i == localArrayList.size() - 1) {
          a(paramISong.a(), 6);
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalStateException => ", new Object[] { Integer.valueOf(i) }), localIllegalStateException);
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] SecurityException => ", new Object[] { Integer.valueOf(i) }), localSecurityException);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalArgumentException => ", new Object[] { Integer.valueOf(i) }), localIllegalArgumentException);
      }
      i += 1;
    }
    jdField_a_of_type_AndroidMediaMediaPlayer.start();
    if (j != 0) {
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
    //   5: new 316	java/io/RandomAccessFile
    //   8: dup
    //   9: new 179	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 182	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: ldc_w 318
    //   20: invokespecial 321	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 325	java/io/RandomAccessFile:readByte	()B
    //   28: istore_1
    //   29: aload_0
    //   30: lconst_0
    //   31: invokevirtual 329	java/io/RandomAccessFile:seek	(J)V
    //   34: aload_0
    //   35: iload_1
    //   36: invokevirtual 332	java/io/RandomAccessFile:write	(I)V
    //   39: aload_0
    //   40: invokevirtual 335	java/io/RandomAccessFile:close	()V
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
    //   65: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   68: aload_0
    //   69: ifnull +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 335	java/io/RandomAccessFile:close	()V
    //   76: return
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 335	java/io/RandomAccessFile:close	()V
    //   85: aload_3
    //   86: athrow
    //   87: astore_0
    //   88: return
    //   89: astore_0
    //   90: goto -5 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString	String
    //   28	8	1	i	int
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
      jdField_a_of_type_Int = paramInt;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updatePlayStateNotify %s [state=%s]", new Object[] { paramString, Const.a(paramInt) }));
      }
      if ((jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler != null)) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler.sendEmptyMessage(14);
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
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPlaying : sPlayState ");
      localStringBuilder.append(Const.a(jdField_a_of_type_Int));
      QLog.d("QQMusicPlay.QQMusicPlayService", 2, localStringBuilder.toString());
    }
    int i = jdField_a_of_type_Int;
    boolean bool = true;
    if (i != 2)
    {
      if (jdField_a_of_type_Int == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static int b()
  {
    if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 3))) {
      try
      {
        int i = jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        return i;
      }
      catch (Exception localException)
      {
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, new Object[] { "getPlayPosition exception state=", Const.a(jdField_a_of_type_Int), localException.getStackTrace() });
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
    MediaPlayer localMediaPlayer = jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {}
    try
    {
      localMediaPlayer.reset();
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
      QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("updateSongNotify [id=%s]", new Object[] { paramISong.a() }));
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
  
  public static int c()
  {
    return jdField_a_of_type_Int;
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 499	android/os/HandlerThread
    //   4: dup
    //   5: ldc_w 501
    //   8: invokespecial 502	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   11: putfield 504	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   14: aload_0
    //   15: getfield 504	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   18: invokevirtual 505	android/os/HandlerThread:start	()V
    //   21: aload_0
    //   22: new 347	com/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler
    //   25: dup
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 504	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   31: invokevirtual 509	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   34: invokespecial 512	com/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler:<init>	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;Landroid/os/Looper;)V
    //   37: putfield 64	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler;
    //   40: aload_0
    //   41: getfield 64	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler;
    //   44: ifnonnull +37 -> 81
    //   47: iconst_1
    //   48: ireturn
    //   49: astore_1
    //   50: goto +33 -> 83
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 513	java/lang/Throwable:printStackTrace	()V
    //   58: ldc 114
    //   60: iconst_1
    //   61: ldc_w 515
    //   64: aload_1
    //   65: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: aload_0
    //   69: invokevirtual 518	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:stopSelf	()V
    //   72: aload_0
    //   73: getfield 64	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler;
    //   76: ifnonnull +5 -> 81
    //   79: iconst_1
    //   80: ireturn
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: getfield 64	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService$IncomingHandler;
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
  
  public IBinder onBind(Intent paramIntent)
  {
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onBind");
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
    QQMusicPlayReport.b(e, jdField_c_of_type_Int);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onCreate");
    }
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new QQMusicPlayService.1(this);
    if (c()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$QQMusicPlayBroadcastReceiver = new QQMusicPlayService.QQMusicPlayBroadcastReceiver(this, null);
    QQMusicPlayService.2 local2 = new QQMusicPlayService.2(this);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler.post(local2);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onDestroy");
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler != null)
    {
      localObject = new QQMusicPlayService.ReleaseObject(this, jdField_a_of_type_AndroidMediaMediaPlayer, jdField_a_of_type_ComTencentMobileqqListentogetherDataISong);
      localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler.obtainMessage(12, localObject);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler.sendMessage((Message)localObject);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler = null;
    }
    jdField_b_of_type_Int = 0;
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$QQMusicPlayBroadcastReceiver);
      localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$NetInfoHandler;
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
      paramMediaPlayer = jdField_a_of_type_AndroidMediaMediaPlayer;
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
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
    paramMediaPlayer = jdField_a_of_type_AndroidMediaMediaPlayer;
    if (paramMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQMusicPlay.QQMusicPlayService", 2, "player is null while invoking method onPrepared");
      }
      stopSelf();
      return;
    }
    jdField_b_of_type_Int = paramMediaPlayer.getDuration();
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("--->onPrepared:sDuration ");
    paramMediaPlayer.append(jdField_b_of_type_Int);
    QLog.d("QQMusicPlay.QQMusicPlayService", 1, paramMediaPlayer.toString());
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.sendEmptyMessage(14);
    }
    paramMediaPlayer = (AudioManager)getSystemService("audio");
    int i = paramMediaPlayer.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
    boolean bool = paramMediaPlayer.isMusicActive();
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("--->onPrepared requestAudioFocus,result:");
      paramMediaPlayer.append(i);
      paramMediaPlayer.append(" isMusicActive:");
      paramMediaPlayer.append(bool);
      QLog.d("QQMusicPlay.QQMusicPlayService", 2, paramMediaPlayer.toString());
    }
    if (i == 1) {
      return;
    }
    a(b(), 7);
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler;
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
        if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler == null) || (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {}
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler.getLooper().quit();
      label79:
      c();
      QQMusicPlayService.IncomingHandler localIncomingHandler = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$IncomingHandler;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService
 * JD-Core Version:    0.7.0.1
 */