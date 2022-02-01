package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;

@ProxyService(proxy=MusicPlayerProxy.class)
public class MusicPlayerProxyImpl
  implements MusicPlayerProxy
{
  private static String jdField_a_of_type_JavaLangString;
  private long jdField_a_of_type_Long = -1L;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new MusicPlayerProxyImpl.1(this);
  private IQQPlayerCallback.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub = new MusicPlayerProxyImpl.2(this);
  private IQQPlayerService jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
  private MusicPlayerProxy.MusicPlayerListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMusicPlayerProxy$MusicPlayerListener = null;
  private String b;
  private String c;
  
  public MusicPlayerProxyImpl()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  private String a()
  {
    if (jdField_a_of_type_JavaLangString == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MusicPlayerProxyImpl");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      jdField_a_of_type_JavaLangString = QQPlayerService.a(8, localStringBuilder.toString());
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   6: ifnonnull +102 -> 108
    //   9: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   12: lstore_1
    //   13: aload_0
    //   14: getfield 34	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:jdField_a_of_type_Long	J
    //   17: ldc2_w 31
    //   20: lcmp
    //   21: ifeq +30 -> 51
    //   24: lload_1
    //   25: aload_0
    //   26: getfield 34	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:jdField_a_of_type_Long	J
    //   29: lsub
    //   30: ldc2_w 84
    //   33: lcmp
    //   34: ifle +6 -> 40
    //   37: goto +14 -> 51
    //   40: ldc 60
    //   42: iconst_1
    //   43: ldc 87
    //   45: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: goto +60 -> 108
    //   51: aload_0
    //   52: lload_1
    //   53: putfield 34	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:jdField_a_of_type_Long	J
    //   56: new 95	android/content/Intent
    //   59: dup
    //   60: invokestatic 101	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   63: ldc 69
    //   65: invokespecial 104	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   68: astore_3
    //   69: invokestatic 101	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   72: aload_3
    //   73: aload_0
    //   74: getfield 41	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   77: bipush 33
    //   79: invokevirtual 108	com/tencent/qphone/base/util/BaseApplication:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   82: pop
    //   83: ldc 60
    //   85: iconst_1
    //   86: ldc 110
    //   88: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: goto +17 -> 108
    //   94: astore_3
    //   95: goto +16 -> 111
    //   98: astore_3
    //   99: ldc 60
    //   101: iconst_1
    //   102: ldc 112
    //   104: aload_3
    //   105: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	MusicPlayerProxyImpl
    //   12	41	1	l	long
    //   68	5	3	localIntent	Intent
    //   94	1	3	localObject	Object
    //   98	16	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	37	94	finally
    //   40	48	94	finally
    //   51	91	94	finally
    //   99	108	94	finally
    //   2	37	98	java/lang/Throwable
    //   40	48	98	java/lang/Throwable
    //   51	91	98	java/lang/Throwable
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   6: ifnull +35 -> 41
    //   9: invokestatic 101	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: aload_0
    //   13: getfield 41	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   16: invokevirtual 119	com/tencent/qphone/base/util/BaseApplication:unbindService	(Landroid/content/ServiceConnection;)V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 50	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   24: goto +17 -> 41
    //   27: astore_1
    //   28: goto +16 -> 44
    //   31: astore_1
    //   32: ldc 60
    //   34: iconst_1
    //   35: ldc 121
    //   37: aload_1
    //   38: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	MusicPlayerProxyImpl
    //   27	1	1	localObject	Object
    //   31	16	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
    //   32	41	27	finally
    //   2	24	31	java/lang/Throwable
  }
  
  public com.tencent.qqmini.sdk.launcher.core.model.SongInfo getCurrentSong()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null)
      {
        com.tencent.mobileqq.music.SongInfo localSongInfo = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
        com.tencent.qqmini.sdk.launcher.core.model.SongInfo localSongInfo1 = new com.tencent.qqmini.sdk.launcher.core.model.SongInfo();
        localSongInfo1.id = localSongInfo.jdField_a_of_type_Long;
        localSongInfo1.mid = localSongInfo.jdField_a_of_type_JavaLangString;
        localSongInfo1.uin = localSongInfo.jdField_b_of_type_Long;
        localSongInfo1.url = localSongInfo.jdField_b_of_type_JavaLangString;
        localSongInfo1.title = localSongInfo.jdField_c_of_type_JavaLangString;
        localSongInfo1.summary = localSongInfo.jdField_d_of_type_JavaLangString;
        localSongInfo1.coverUrl = localSongInfo.e;
        localSongInfo1.detailUrl = localSongInfo.f;
        localSongInfo1.album = localSongInfo.g;
        localSongInfo1.singer = localSongInfo.h;
        localSongInfo1.singerId = localSongInfo.jdField_c_of_type_Long;
        localSongInfo1.startTime = localSongInfo.jdField_a_of_type_Int;
        localSongInfo1.type = localSongInfo.jdField_b_of_type_Int;
        localSongInfo1.fromMini = localSongInfo.jdField_a_of_type_Boolean;
        localSongInfo1.duration = localSongInfo.jdField_d_of_type_Long;
        return localSongInfo1;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSong exception ", localException);
    }
    return null;
  }
  
  public int getCurrentSongPosition()
  {
    IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    if (localIQQPlayerService != null) {
      try
      {
        int i = localIQQPlayerService.d();
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongPosition exception ", localException);
      }
    }
    return 0;
  }
  
  public int getDuration()
  {
    IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    if (localIQQPlayerService != null) {
      try
      {
        int i = localIQQPlayerService.c();
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongDuration exception ", localException);
      }
    }
    return 0;
  }
  
  public void init(MusicPlayerProxy.MusicPlayerListener paramMusicPlayerListener, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMusicPlayerProxy$MusicPlayerListener = paramMusicPlayerListener;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    a();
  }
  
  public boolean isInit()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null;
  }
  
  public boolean isPlaying()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null) {
          if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a(a())) {
            break label83;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBackgroundAudioState: null ");
        if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null) {
          break label85;
        }
        bool = true;
        localStringBuilder.append(bool);
        Log.i("MusicPlayerProxyImpl", localStringBuilder.toString());
        return false;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "isPlaying exception ", localException);
        return false;
      }
      label83:
      return true;
      label85:
      boolean bool = false;
    }
  }
  
  public void pause()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "pause exception ", localException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.b();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "resume exception ", localException);
    }
  }
  
  public void seekTo(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.b(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "seekTo exception ", localException);
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "setPlayMode exception ", localException);
    }
  }
  
  public void startPlay(com.tencent.qqmini.sdk.launcher.core.model.SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    if (paramArrayOfSongInfo != null)
    {
      if (paramArrayOfSongInfo.length < 1) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
      if (localObject != null) {
        try
        {
          ((IQQPlayerService)localObject).a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
          Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
          localObject = localBundle;
          if (localBundle == null)
          {
            localObject = new Bundle();
            this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a((Bundle)localObject);
          }
          ((Bundle)localObject).putString("KEY_SOURCE_NAME", this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a((Bundle)localObject);
          localObject = new com.tencent.mobileqq.music.SongInfo[paramArrayOfSongInfo.length];
          int i = 0;
          while (i < paramArrayOfSongInfo.length)
          {
            localObject[i] = new com.tencent.mobileqq.music.SongInfo();
            localObject[i].g = paramArrayOfSongInfo[i].album;
            localObject[i].e = paramArrayOfSongInfo[i].coverUrl;
            localObject[i].f = paramArrayOfSongInfo[i].detailUrl;
            localObject[i].jdField_d_of_type_Long = paramArrayOfSongInfo[i].duration;
            localObject[i].jdField_a_of_type_Boolean = paramArrayOfSongInfo[i].fromMini;
            localObject[i].jdField_a_of_type_Long = paramArrayOfSongInfo[i].id;
            localObject[i].jdField_a_of_type_JavaLangString = paramArrayOfSongInfo[i].mid;
            localObject[i].h = paramArrayOfSongInfo[i].singer;
            localObject[i].jdField_c_of_type_Long = paramArrayOfSongInfo[i].singerId;
            localObject[i].jdField_a_of_type_Int = paramArrayOfSongInfo[i].startTime;
            localObject[i].jdField_d_of_type_JavaLangString = paramArrayOfSongInfo[i].summary;
            localObject[i].jdField_c_of_type_JavaLangString = paramArrayOfSongInfo[i].title;
            localObject[i].jdField_b_of_type_Int = paramArrayOfSongInfo[i].type;
            localObject[i].jdField_b_of_type_Long = paramArrayOfSongInfo[i].uin;
            localObject[i].jdField_b_of_type_JavaLangString = paramArrayOfSongInfo[i].url;
            i += 1;
          }
          this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a(100);
          this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a(a(), (com.tencent.mobileqq.music.SongInfo[])localObject, paramInt);
          return;
        }
        catch (Exception paramArrayOfSongInfo)
        {
          QLog.e("MusicPlayerProxyImpl", 1, "startPlay exception ", paramArrayOfSongInfo);
        }
      }
    }
  }
  
  public void stop()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.c();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "stop exception ", localException);
    }
  }
  
  public void unInit()
  {
    b();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMusicPlayerProxy$MusicPlayerListener = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MusicPlayerProxyImpl
 * JD-Core Version:    0.7.0.1
 */