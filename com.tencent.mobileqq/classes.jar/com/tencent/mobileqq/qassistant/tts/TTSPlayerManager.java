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
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private IPlayEventListener jdField_a_of_type_ComTencentMobileqqQassistantListenerIPlayEventListener;
  private SilkStreamPlayer jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
  private String jdField_a_of_type_JavaLangString;
  private TicketManager jdField_a_of_type_MqqManagerTicketManager;
  private String b;
  private String c;
  private String d;
  
  public TTSPlayerManager()
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    this.jdField_a_of_type_JavaLangString = localMobileQQ.getString(2131720327);
    this.b = localMobileQQ.getString(2131720324);
    this.c = localMobileQQ.getString(2131720325);
    this.d = localMobileQQ.getString(2131720340);
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +28 -> 32
    //   7: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 69
    //   15: iconst_2
    //   16: ldc 71
    //   18: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: aload_1
    //   23: iload_3
    //   24: invokespecial 77	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:b	(Ljava/lang/String;I)V
    //   27: aload_0
    //   28: invokespecial 79	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:d	()V
    //   31: return
    //   32: aconst_null
    //   33: astore 5
    //   35: aconst_null
    //   36: astore 6
    //   38: aload 6
    //   40: astore 4
    //   42: aload_0
    //   43: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   46: ifnonnull +18 -> 64
    //   49: aload 6
    //   51: astore 4
    //   53: aload_0
    //   54: new 81	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   57: dup
    //   58: invokespecial 82	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   61: putfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   64: aload 6
    //   66: astore 4
    //   68: aload_0
    //   69: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   72: invokevirtual 87	android/media/MediaPlayer:isPlaying	()Z
    //   75: ifeq +14 -> 89
    //   78: aload 6
    //   80: astore 4
    //   82: aload_0
    //   83: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   86: invokevirtual 90	android/media/MediaPlayer:stop	()V
    //   89: aload 6
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   97: invokevirtual 93	android/media/MediaPlayer:reset	()V
    //   100: iload_3
    //   101: ifeq +15 -> 116
    //   104: aload 6
    //   106: astore 4
    //   108: aload_0
    //   109: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   112: iload_3
    //   113: invokevirtual 97	android/media/MediaPlayer:setAudioSessionId	(I)V
    //   116: aload 6
    //   118: astore 4
    //   120: new 99	java/io/FileInputStream
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   128: astore_2
    //   129: aload_0
    //   130: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   133: aload_2
    //   134: invokevirtual 106	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   137: invokevirtual 110	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   140: aload_0
    //   141: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   144: iconst_3
    //   145: invokevirtual 113	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   148: getstatic 25	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   151: iconst_1
    //   152: invokestatic 118	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   155: pop
    //   156: aload_0
    //   157: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   160: invokevirtual 121	android/media/MediaPlayer:prepare	()V
    //   163: aload_0
    //   164: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   167: new 123	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager$1
    //   170: dup
    //   171: aload_0
    //   172: aload_1
    //   173: invokespecial 126	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager$1:<init>	(Lcom/tencent/mobileqq/qassistant/tts/TTSPlayerManager;Ljava/lang/String;)V
    //   176: invokevirtual 130	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   179: aload_0
    //   180: getfield 47	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   183: invokevirtual 133	android/media/MediaPlayer:start	()V
    //   186: aload_0
    //   187: getfield 50	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_ComTencentMobileqqQassistantListenerIPlayEventListener	Lcom/tencent/mobileqq/qassistant/listener/IPlayEventListener;
    //   190: ifnull +13 -> 203
    //   193: aload_0
    //   194: getfield 50	com/tencent/mobileqq/qassistant/tts/TTSPlayerManager:jdField_a_of_type_ComTencentMobileqqQassistantListenerIPlayEventListener	Lcom/tencent/mobileqq/qassistant/listener/IPlayEventListener;
    //   197: aload_1
    //   198: invokeinterface 137 2 0
    //   203: aload_2
    //   204: invokevirtual 140	java/io/FileInputStream:close	()V
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
    //   237: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   240: aload_1
    //   241: astore 4
    //   243: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +53 -> 299
    //   249: aload_1
    //   250: astore 4
    //   252: new 145	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   259: astore 5
    //   261: aload_1
    //   262: astore 4
    //   264: aload 5
    //   266: ldc 148
    //   268: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_1
    //   273: astore 4
    //   275: aload 5
    //   277: aload_2
    //   278: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   281: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: astore 4
    //   288: ldc 69
    //   290: iconst_2
    //   291: aload 5
    //   293: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_1
    //   300: ifnull +13 -> 313
    //   303: aload_1
    //   304: invokevirtual 140	java/io/FileInputStream:close	()V
    //   307: return
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   313: return
    //   314: aload 4
    //   316: ifnull +16 -> 332
    //   319: aload 4
    //   321: invokevirtual 140	java/io/FileInputStream:close	()V
    //   324: goto +8 -> 332
    //   327: astore_2
    //   328: aload_2
    //   329: invokevirtual 163	java/io/IOException:printStackTrace	()V
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
  
  private boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      return LoadManager.a(localArrayList);
    }
    return false;
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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
    String str = "";
    if (localObject2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = new SilkStreamPlayer(MobileQQ.sMobileQQ, paramString, "", "");
    }
    if ((this.jdField_a_of_type_MqqManagerTicketManager == null) && ((localObject1 instanceof AppInterface))) {
      this.jdField_a_of_type_MqqManagerTicketManager = ((TicketManager)((AppRuntime)localObject1).getManager(2));
    }
    localObject1 = ((AppRuntime)localObject1).getAccount();
    localObject2 = this.jdField_a_of_type_MqqManagerTicketManager;
    if (localObject2 != null) {
      str = ((TicketManager)localObject2).getSkey((String)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a((String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.b(str);
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.c(paramString);
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(this, 1, paramInt);
  }
  
  private void d()
  {
    LoadManager.a(LoadManager.a, "TTSPlayerManager", null);
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a())) {
        this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
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
  
  public void a(IPlayEventListener paramIPlayEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPlayEventListener = paramIPlayEventListener;
  }
  
  public void a(String paramString)
  {
    IPlayEventListener localIPlayEventListener = this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPlayEventListener;
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
    a();
    for (;;)
    {
      try
      {
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ))
        {
          if (a("network_tip.mp3")) {
            a(paramString, LoadManager.a("network_tip.mp3"), paramInt);
          }
        }
        else
        {
          boolean bool = paramString.equals(this.d);
          i = 1;
          if (bool)
          {
            if (a("wake_default_tip.mp3")) {
              a(paramString, LoadManager.a("wake_default_tip.mp3"), paramInt);
            }
          }
          else if (paramString.equals(this.jdField_a_of_type_JavaLangString))
          {
            if (a("quit_voice_panel_tip.mp3")) {
              a(paramString, LoadManager.a("quit_voice_panel_tip.mp3"), paramInt);
            }
          }
          else if (paramString.equals(this.c))
          {
            if (a("voice_not_understant_tip.mp3")) {
              a(paramString, LoadManager.a("voice_not_understant_tip.mp3"), paramInt);
            }
          }
          else
          {
            if (!paramString.equals(this.b)) {
              break label261;
            }
            if (a("voice_not_support_tip.mp3"))
            {
              a(paramString, LoadManager.a("voice_not_support_tip.mp3"), paramInt);
              return;
            }
          }
          if (i != 0) {
            d();
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
      label261:
      int i = 0;
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
    boolean bool3 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((SilkStreamPlayer)localObject).a();
    } else {
      bool1 = false;
    }
    localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
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
  
  public void b() {}
  
  public void b(String paramString)
  {
    IPlayEventListener localIPlayEventListener = this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPlayEventListener;
    if (localIPlayEventListener != null) {
      localIPlayEventListener.b(paramString);
    }
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a()) {
          this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.b();
        this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = null;
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.tts.TTSPlayerManager
 * JD-Core Version:    0.7.0.1
 */