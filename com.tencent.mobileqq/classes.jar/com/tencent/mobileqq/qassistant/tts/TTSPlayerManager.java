package com.tencent.mobileqq.qassistant.tts;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qassistant.core.LoadManager;
import com.tencent.mobileqq.qassistant.listener.IPlayEventListener;
import com.tencent.mobileqq.tts.SilkStreamPlayer;
import com.tencent.mobileqq.tts.SilkStreamPlayer.OnSilkStreamPlay;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class TTSPlayerManager
  implements SilkStreamPlayer.OnSilkStreamPlay
{
  private SilkStreamPlayer a;
  private MediaPlayer b;
  private TicketManager c;
  private IPlayEventListener d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public TTSPlayerManager()
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    this.e = localMobileQQ.getString(2131917962);
    this.f = localMobileQQ.getString(2131917959);
    this.g = localMobileQQ.getString(2131917960);
    this.h = localMobileQQ.getString(2131917975);
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +28 -> 32
    //   7: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 73
    //   15: iconst_2
    //   16: ldc 75
    //   18: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: aload_1
    //   23: iload_3
    //   24: invokespecial 81	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	(Ljava/lang/String;I)V
    //   27: aload_0
    //   28: invokespecial 83	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:e	()V
    //   31: return
    //   32: aconst_null
    //   33: astore 5
    //   35: aconst_null
    //   36: astore 6
    //   38: aload 6
    //   40: astore 4
    //   42: aload_0
    //   43: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   46: ifnonnull +18 -> 64
    //   49: aload 6
    //   51: astore 4
    //   53: aload_0
    //   54: new 85	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   57: dup
    //   58: invokespecial 86	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   61: putfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   64: aload 6
    //   66: astore 4
    //   68: aload_0
    //   69: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   72: invokevirtual 91	android/media/MediaPlayer:isPlaying	()Z
    //   75: ifeq +14 -> 89
    //   78: aload 6
    //   80: astore 4
    //   82: aload_0
    //   83: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   86: invokevirtual 94	android/media/MediaPlayer:stop	()V
    //   89: aload 6
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   97: invokevirtual 97	android/media/MediaPlayer:reset	()V
    //   100: iload_3
    //   101: ifeq +15 -> 116
    //   104: aload 6
    //   106: astore 4
    //   108: aload_0
    //   109: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   112: iload_3
    //   113: invokevirtual 101	android/media/MediaPlayer:setAudioSessionId	(I)V
    //   116: aload 6
    //   118: astore 4
    //   120: new 103	java/io/FileInputStream
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 106	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   128: astore_2
    //   129: aload_0
    //   130: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   133: aload_2
    //   134: invokevirtual 110	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   137: invokevirtual 114	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   140: aload_0
    //   141: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   144: iconst_3
    //   145: invokevirtual 117	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   148: getstatic 29	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   151: iconst_1
    //   152: invokestatic 122	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   155: pop
    //   156: aload_0
    //   157: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   160: invokevirtual 125	android/media/MediaPlayer:prepare	()V
    //   163: aload_0
    //   164: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   167: new 127	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager$1
    //   170: dup
    //   171: aload_0
    //   172: aload_1
    //   173: invokespecial 130	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager$1:<init>	(Lcom/tencent/mobileqq/qassistant/tts/TTSPlayerManager;Ljava/lang/String;)V
    //   176: invokevirtual 134	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   179: aload_0
    //   180: getfield 51	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	Landroid/media/MediaPlayer;
    //   183: invokevirtual 137	android/media/MediaPlayer:start	()V
    //   186: aload_0
    //   187: getfield 54	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:d	Lcom/tencent/mobileqq/qassistant/listener/IPlayEventListener;
    //   190: ifnull +13 -> 203
    //   193: aload_0
    //   194: getfield 54	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:d	Lcom/tencent/mobileqq/qassistant/listener/IPlayEventListener;
    //   197: aload_1
    //   198: invokeinterface 141 2 0
    //   203: aload_2
    //   204: invokevirtual 144	java/io/FileInputStream:close	()V
    //   207: return
    //   208: astore_1
    //   209: aload_2
    //   210: astore 4
    //   212: goto +102 -> 314
    //   215: astore 4
    //   217: aload_2
    //   218: astore_1
    //   219: aload 4
    //   221: astore_2
    //   222: goto +11 -> 233
    //   225: astore_1
    //   226: goto +88 -> 314
    //   229: astore_2
    //   230: aload 5
    //   232: astore_1
    //   233: aload_1
    //   234: astore 4
    //   236: aload_2
    //   237: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   240: aload_1
    //   241: astore 4
    //   243: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +53 -> 299
    //   249: aload_1
    //   250: astore 4
    //   252: new 149	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   259: astore 5
    //   261: aload_1
    //   262: astore 4
    //   264: aload 5
    //   266: ldc 152
    //   268: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_1
    //   273: astore 4
    //   275: aload 5
    //   277: aload_2
    //   278: invokevirtual 160	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   281: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: astore 4
    //   288: ldc 73
    //   290: iconst_2
    //   291: aload 5
    //   293: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_1
    //   300: ifnull +13 -> 313
    //   303: aload_1
    //   304: invokevirtual 144	java/io/FileInputStream:close	()V
    //   307: return
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   313: return
    //   314: aload 4
    //   316: ifnull +16 -> 332
    //   319: aload 4
    //   321: invokevirtual 144	java/io/FileInputStream:close	()V
    //   324: goto +8 -> 332
    //   327: astore_2
    //   328: aload_2
    //   329: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   332: aload_1
    //   333: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	TTSPlayerManager
    //   0	334	1	paramString1	String
    //   0	334	2	paramString2	String
    //   0	334	3	paramInt	int
    //   40	171	4	localObject1	Object
    //   215	5	4	localException	Exception
    //   234	86	4	str	String
    //   33	259	5	localStringBuilder	StringBuilder
    //   36	81	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   129	203	208	finally
    //   129	203	215	java/lang/Exception
    //   42	49	225	finally
    //   53	64	225	finally
    //   68	78	225	finally
    //   82	89	225	finally
    //   93	100	225	finally
    //   108	116	225	finally
    //   120	129	225	finally
    //   236	240	225	finally
    //   243	249	225	finally
    //   252	261	225	finally
    //   264	272	225	finally
    //   275	285	225	finally
    //   288	299	225	finally
    //   42	49	229	java/lang/Exception
    //   53	64	229	java/lang/Exception
    //   68	78	229	java/lang/Exception
    //   82	89	229	java/lang/Exception
    //   93	100	229	java/lang/Exception
    //   108	116	229	java/lang/Exception
    //   120	129	229	java/lang/Exception
    //   203	207	308	java/io/IOException
    //   303	307	308	java/io/IOException
    //   319	324	327	java/io/IOException
  }
  
  private void b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TTSPlayerManager", 2, "dealOnlinePlay speech is null");
      }
      return;
    }
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject2 = this.a;
    String str = "";
    if (localObject2 == null) {
      this.a = new SilkStreamPlayer(MobileQQ.sMobileQQ, paramString, "", "");
    }
    if ((this.c == null) && ((localObject1 instanceof AppInterface))) {
      this.c = ((TicketManager)((AppRuntime)localObject1).getManager(2));
    }
    localObject1 = ((AppRuntime)localObject1).getAccount();
    localObject2 = this.c;
    if (localObject2 != null) {
      str = ((TicketManager)localObject2).getSkey((String)localObject1);
    }
    this.a.a((String)localObject1);
    this.a.b(str);
    this.a.c(paramString);
    this.a.a(this, 1, paramInt);
  }
  
  private boolean c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      return LoadManager.a(localArrayList);
    }
    return false;
  }
  
  private void e()
  {
    LoadManager.a(LoadManager.b, "TTSPlayerManager", null);
  }
  
  public void a(IPlayEventListener paramIPlayEventListener)
  {
    this.d = paramIPlayEventListener;
  }
  
  public void a(String paramString)
  {
    IPlayEventListener localIPlayEventListener = this.d;
    if (localIPlayEventListener != null) {
      localIPlayEventListener.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TTSPlayerManager", 2, "play speech is null");
      }
      return;
    }
    b();
    for (;;)
    {
      try
      {
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ))
        {
          if (c("network_tip.mp3")) {
            a(paramString, LoadManager.a("network_tip.mp3"), paramInt);
          }
        }
        else
        {
          boolean bool = paramString.equals(this.h);
          i = 1;
          if (bool)
          {
            if (c("wake_default_tip.mp3")) {
              a(paramString, LoadManager.a("wake_default_tip.mp3"), paramInt);
            }
          }
          else if (paramString.equals(this.e))
          {
            if (c("quit_voice_panel_tip.mp3")) {
              a(paramString, LoadManager.a("quit_voice_panel_tip.mp3"), paramInt);
            }
          }
          else if (paramString.equals(this.g))
          {
            if (c("voice_not_understant_tip.mp3")) {
              a(paramString, LoadManager.a("voice_not_understant_tip.mp3"), paramInt);
            }
          }
          else
          {
            if (!paramString.equals(this.f)) {
              break label259;
            }
            if (c("voice_not_support_tip.mp3"))
            {
              a(paramString, LoadManager.a("voice_not_support_tip.mp3"), paramInt);
              return;
            }
          }
          if (i != 0) {
            e();
          }
          b(paramString, paramInt);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("play exception = ");
          localStringBuilder.append(paramString.getMessage());
          QLog.d("TTSPlayerManager", 2, localStringBuilder.toString());
        }
        return;
      }
      return;
      label259:
      int i = 0;
    }
  }
  
  public boolean a()
  {
    Object localObject = this.a;
    boolean bool3 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((SilkStreamPlayer)localObject).b();
    } else {
      bool1 = false;
    }
    localObject = this.b;
    boolean bool2;
    if (localObject != null) {
      bool2 = ((MediaPlayer)localObject).isPlaying();
    } else {
      bool2 = false;
    }
    if (!bool1)
    {
      bool1 = bool3;
      if (!bool2) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    try
    {
      if ((this.a != null) && (this.a.b())) {
        this.a.a();
      }
      if ((this.b != null) && (this.b.isPlaying()))
      {
        this.b.stop();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stop exception  = ");
        localStringBuilder.append(localException.getMessage());
        QLog.d("TTSPlayerManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b(String paramString)
  {
    IPlayEventListener localIPlayEventListener = this.d;
    if (localIPlayEventListener != null) {
      localIPlayEventListener.b(paramString);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    try
    {
      if (this.a != null)
      {
        if (this.a.b()) {
          this.a.a();
        }
        this.a.c();
        this.a = null;
      }
      if (this.b != null)
      {
        if (this.b.isPlaying()) {
          this.b.stop();
        }
        this.b = null;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy exception  = ");
        localStringBuilder.append(localException.getMessage());
        QLog.d("TTSPlayerManager", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.tts.TTSPlayerManager
 * JD-Core Version:    0.7.0.1
 */