package com.tencent.mobileqq.music;

import adwl;
import adwm;
import adwn;
import adwo;
import adwp;
import adwq;
import adwr;
import adws;
import adwt;
import adwu;
import adwv;
import adww;
import adwx;
import adwy;
import adwz;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.MusicCacheManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.qzone.music.BroadcastMusicInfo;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.os.MqqHandler;

@SuppressLint({"NewApi"})
public class QQPlayerService
  extends Service
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Constants.PlayMode, Constants.PlayState
{
  private static int jdField_a_of_type_Int = 0;
  public static long a;
  private static Intent jdField_a_of_type_AndroidContentIntent;
  private static MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  private static SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  private static String jdField_a_of_type_JavaLangString;
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private static Map jdField_a_of_type_JavaUtilMap;
  private static SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  private static int jdField_b_of_type_Int = 103;
  private static final String jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/qqmusic/";
  private static WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private static int jdField_c_of_type_Int;
  private static int jdField_d_of_type_Int = -1;
  private static boolean jdField_d_of_type_Boolean;
  private static int f;
  public float a;
  public adwv a;
  private adww jdField_a_of_type_Adww;
  private adwx jdField_a_of_type_Adwx;
  private volatile adwz jdField_a_of_type_Adwz;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private volatile Looper jdField_a_of_type_AndroidOsLooper;
  private RemoteCallbackList jdField_a_of_type_AndroidOsRemoteCallbackList;
  private IQQPlayerService.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService$Stub = new adwm(this);
  private Object jdField_a_of_type_JavaLangObject;
  public boolean a;
  public long b;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_d_of_type_Boolean = Utils.a();
  }
  
  public QQPlayerService()
  {
    this.jdField_b_of_type_Long = 500L;
    this.jdField_a_of_type_Float = 0.3F;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static Intent a()
  {
    return jdField_a_of_type_AndroidContentIntent;
  }
  
  public static Bundle a()
  {
    return jdField_a_of_type_AndroidOsBundle;
  }
  
  public static SongInfo a()
  {
    return jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknow action";
    case 2: 
      return "start";
    case 3: 
      return "stop";
    case 4: 
      return "loopProgress";
    case 6: 
      return "pause";
    }
    return "resume";
  }
  
  public static String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "generateToken unknown callerType");
      }
      return null;
    case 1: 
      return "aio_" + paramString;
    case 2: 
      return "fav_" + paramString;
    case 3: 
      return "music_gene_" + paramString;
    case 4: 
      return "qzone_" + paramString;
    case 5: 
      return "troopbar_" + paramString;
    case 6: 
      return "music_pendant_" + paramString;
    }
    return "search_" + paramString;
  }
  
  private static String a(String paramString)
  {
    if (paramString != null) {
      return MD5.toMD5(paramString);
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "pausePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 6);
    paramContext.startService(localIntent);
  }
  
  private static void a(Context paramContext, SongInfo paramSongInfo)
  {
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 2);
    localIntent.putExtra("musicplayer.song", paramSongInfo);
    paramContext.startService(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, SongInfo paramSongInfo)
  {
    try
    {
      a(100);
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
  
  /* Error */
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_2
    //   4: ifnull +8 -> 12
    //   7: aload_2
    //   8: arraylength
    //   9: ifne +19 -> 28
    //   12: new 229	java/lang/IllegalArgumentException
    //   15: dup
    //   16: ldc 231
    //   18: invokespecial 234	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: athrow
    //   28: aload_1
    //   29: ifnull +12 -> 41
    //   32: aload_1
    //   33: ldc 236
    //   35: invokevirtual 242	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifeq +13 -> 51
    //   41: new 229	java/lang/IllegalArgumentException
    //   44: dup
    //   45: ldc 244
    //   47: invokespecial 234	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: iload_3
    //   52: iflt +11 -> 63
    //   55: iload_3
    //   56: aload_2
    //   57: arraylength
    //   58: iconst_1
    //   59: isub
    //   60: if_icmple +13 -> 73
    //   63: new 229	java/lang/IllegalArgumentException
    //   66: dup
    //   67: ldc 246
    //   69: invokespecial 234	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +49 -> 125
    //   79: ldc 158
    //   81: iconst_2
    //   82: new 71	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   89: ldc 248
    //   91: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: arraylength
    //   96: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc 253
    //   101: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_3
    //   105: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: ldc 255
    //   110: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: getstatic 53	com/tencent/mobileqq/music/QQPlayerService:jdField_b_of_type_Int	I
    //   116: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: putstatic 137	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   129: aload_2
    //   130: putstatic 257	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   133: getstatic 189	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   136: ifnull +28 -> 164
    //   139: iconst_0
    //   140: putstatic 51	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_Int	I
    //   143: getstatic 189	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   146: invokevirtual 263	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   149: checkcast 265	com/tencent/mobileqq/music/QQPlayerService$QQPlayerCallback
    //   152: astore_1
    //   153: aload_1
    //   154: ifnull +29 -> 183
    //   157: aload_1
    //   158: iconst_0
    //   159: invokeinterface 268 2 0
    //   164: iload_3
    //   165: putstatic 55	com/tencent/mobileqq/music/QQPlayerService:jdField_d_of_type_Int	I
    //   168: aload_0
    //   169: getstatic 257	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   172: getstatic 55	com/tencent/mobileqq/music/QQPlayerService:jdField_d_of_type_Int	I
    //   175: aaload
    //   176: invokestatic 270	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/content/Context;Lcom/tencent/mobileqq/music/SongInfo;)V
    //   179: ldc 2
    //   181: monitorexit
    //   182: return
    //   183: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq -22 -> 164
    //   189: ldc 158
    //   191: iconst_2
    //   192: ldc_w 272
    //   195: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: goto -34 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramContext	Context
    //   0	201	1	paramString	String
    //   0	201	2	paramArrayOfSongInfo	SongInfo[]
    //   0	201	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   7	12	22	finally
    //   12	22	22	finally
    //   32	41	22	finally
    //   41	51	22	finally
    //   55	63	22	finally
    //   63	73	22	finally
    //   73	125	22	finally
    //   125	153	22	finally
    //   157	164	22	finally
    //   164	179	22	finally
    //   183	198	22	finally
  }
  
  public static void a(Intent paramIntent)
  {
    jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public static void a(Bundle paramBundle)
  {
    jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public static void a(QQPlayerService.QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null)
    {
      jdField_a_of_type_JavaLangString = paramQQPlayerCallback.getToken();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "setCallback: sToken=" + jdField_a_of_type_JavaLangString);
      }
      jdField_a_of_type_JavaLangRefWeakReference = jdField_b_of_type_JavaLangRefWeakReference;
      jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQPlayerCallback);
      return;
    }
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_JavaLangRefWeakReference = jdField_b_of_type_JavaLangRefWeakReference;
    jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  private void a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      try
      {
        throw new IllegalArgumentException("newSong shouldn't be null!");
      }
      finally {}
    }
    f = 0;
    jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    g();
    b(paramSongInfo);
  }
  
  private void a(String paramString)
  {
    boolean bool1 = NetworkUtil.g(getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart,isNetworkAvailable = " + bool1 + ",url : " + paramString);
    }
    if ((jdField_d_of_type_Boolean) || (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_Int == 9))
    {
      f();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart, || play song in compatible mode ||");
      }
      if (!bool1)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        b(6);
      }
    }
    Object localObject2;
    int[] arrayOfInt;
    do
    {
      for (;;)
      {
        return;
        try
        {
          jdField_a_of_type_AndroidMediaMediaPlayer.reset();
          jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
          b(1);
          jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          b(2);
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          return;
        }
        catch (IllegalArgumentException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalArgumentException => ", paramString);
            }
          }
        }
        catch (SecurityException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode SecurityException => ", paramString);
            }
          }
        }
        catch (IllegalStateException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalStateException => ", paramString);
            }
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IOException => ", paramString);
            }
            jdField_a_of_type_AndroidMediaMediaPlayer.reset();
            b(6);
          }
        }
        localObject2 = a(paramString);
        Object localObject1 = new File(jdField_b_of_type_JavaLangString + "/" + (String)localObject2);
        if ((!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L)) {
          break label1182;
        }
        arrayOfInt = new int[2];
        boolean bool2 = MusicCacheManager.a((String)localObject2, arrayOfInt);
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject1).getAbsolutePath() + ",isCacheComplete:" + bool2 + ",result[0]:" + arrayOfInt[0] + ",result[1]:" + arrayOfInt[1]);
        }
        if (!bool2) {
          break label1014;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache is complete");
        }
        jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        try
        {
          MusicCacheManager.a((File)localObject1);
          jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(((File)localObject1).getAbsolutePath());
          jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          b(2);
          if (b())
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download ============");
            }
            paramString = e().jdField_a_of_type_JavaLangString;
            if ((this.jdField_a_of_type_Adwv != null) && (this.jdField_a_of_type_Adwv.isAlive()) && (!this.jdField_a_of_type_Adwv.jdField_a_of_type_Boolean))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: downloadThread is  running.... ");
              }
              if (paramString.equals(this.jdField_a_of_type_Adwv.jdField_a_of_type_JavaLangString))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QQPlayerService", 2, "mediaPlayStart: download url equals nextUrl,so no need play and return.");
                }
                this.jdField_a_of_type_Adwv.jdField_d_of_type_Boolean = false;
                return;
              }
            }
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart:" + paramString.getMessage(), paramString);
            }
            try
            {
              ((File)localObject1).delete();
            }
            catch (Exception paramString) {}
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart,delete file on error:" + paramString.getMessage(), paramString);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart: download url not equals nextUrl,so no need stop.");
          }
          this.jdField_a_of_type_Adwv.jdField_d_of_type_Boolean = false;
          this.jdField_a_of_type_Adwv.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Adwv = null;
          localObject1 = a(paramString);
          localObject2 = new File(jdField_b_of_type_JavaLangString + "/" + (String)localObject1);
          if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
          {
            arrayOfInt = new int[2];
            bool1 = MusicCacheManager.a((String)localObject1, arrayOfInt);
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject2).getAbsolutePath() + ",isNextCacheComplete:" + bool1 + ",nextResult[0]:" + arrayOfInt[0] + ",nextResult[1]:" + arrayOfInt[1]);
            }
            if (bool1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache is complete.return");
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache not complete");
              }
              this.jdField_a_of_type_Adwv = new adwv(this, paramString, (String)localObject1, arrayOfInt[0], arrayOfInt[1]);
              this.jdField_a_of_type_Adwv.jdField_d_of_type_Boolean = false;
              this.jdField_a_of_type_Adwv.start();
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache no exists");
            }
            this.jdField_a_of_type_Adwv = new adwv(this, paramString, (String)localObject1, 0, 0);
            this.jdField_a_of_type_Adwv.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_Adwv.start();
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no need pre download =================");
      }
    } while ((this.jdField_a_of_type_Adwv == null) || (!this.jdField_a_of_type_Adwv.isAlive()) || (this.jdField_a_of_type_Adwv.jdField_a_of_type_Boolean));
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: download thread running,so no need play");
    }
    this.jdField_a_of_type_Adwv.jdField_d_of_type_Boolean = false;
    return;
    label1014:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete");
    }
    if (!bool1)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      b(6);
      return;
    }
    if ((this.jdField_a_of_type_Adwv != null) && (this.jdField_a_of_type_Adwv.isAlive()) && (!this.jdField_a_of_type_Adwv.jdField_a_of_type_Boolean))
    {
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_Adwv.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_Adwv.jdField_d_of_type_Boolean = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_Adwv.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Adwv.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Adwv = null;
    }
    this.jdField_a_of_type_Adwv = new adwv(this, paramString, (String)localObject2, arrayOfInt[0], arrayOfInt[1]);
    this.jdField_a_of_type_Adwv.start();
    return;
    label1182:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file");
    }
    if (!bool1)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      b(6);
      return;
    }
    if ((this.jdField_a_of_type_Adwv != null) && (this.jdField_a_of_type_Adwv.isAlive()) && (!this.jdField_a_of_type_Adwv.jdField_a_of_type_Boolean))
    {
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_Adwv.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_Adwv.jdField_d_of_type_Boolean = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_Adwv.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Adwv.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Adwv = null;
    }
    this.jdField_a_of_type_Adwv = new adwv(this, paramString, (String)localObject2, 0, 0);
    this.jdField_a_of_type_Adwv.start();
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "isPlaying : sPlayState " + b(jdField_a_of_type_Int));
    }
    return (jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 1);
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playPrev");
    }
    SongInfo localSongInfo = c();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    c(paramContext);
    return false;
  }
  
  public static boolean a(QQPlayerService.QQPlayerCallback paramQQPlayerCallback)
  {
    if (((jdField_a_of_type_Int != 2) && (jdField_a_of_type_Int != 1)) || (paramQQPlayerCallback == null)) {
      return false;
    }
    if (jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      QQPlayerService.QQPlayerCallback localQQPlayerCallback = (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
      if ((localQQPlayerCallback != null) && (localQQPlayerCallback == paramQQPlayerCallback)) {
        return true;
      }
    }
    paramQQPlayerCallback = paramQQPlayerCallback.getToken();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "isPlayingMySong:callback.getToken()=" + paramQQPlayerCallback + ",sToken=" + jdField_a_of_type_JavaLangString);
    }
    if (jdField_a_of_type_JavaLangString != null) {
      return jdField_a_of_type_JavaLangString.equals(paramQQPlayerCallback);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if ((jdField_a_of_type_Int != 2) && (jdField_a_of_type_Int != 1)) {}
    while (jdField_a_of_type_JavaLangString == null) {
      return false;
    }
    return jdField_a_of_type_JavaLangString.equals(paramString);
  }
  
  public static SongInfo[] a()
  {
    return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  }
  
  public static int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " Unknow playState ";
    case 0: 
      return " IDLE ";
    case 1: 
      return " BUFFERING ";
    case 2: 
      return " PLAYING ";
    case 3: 
      return " PAUSE ";
    case 4: 
      return " STOP ";
    case 5: 
      return " ERROR_INTERNAL ";
    case 7: 
      return " ERROR_SERVER ";
    }
    return " NETWORK_INTERRUPT ";
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQPlayerService");
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsLooper = this.jdField_a_of_type_AndroidOsHandlerThread.getLooper();
      this.jdField_a_of_type_Adwz = new adwz(this, this.jdField_a_of_type_AndroidOsLooper);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("QQPlayerService", 1, "start thread oom, stop self");
      stopSelf();
    }
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 4) && (paramInt != 7) && (paramInt != 5) && (paramInt != 6)) {
      try
      {
        throw new IllegalArgumentException("playState value " + paramInt + " is illegal.");
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:" + b(jdField_a_of_type_Int) + " =====> " + b(paramInt));
    }
    jdField_a_of_type_Int = paramInt;
    Object localObject2;
    label282:
    Iterator localIterator;
    if ((jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 1))
    {
      g();
      if ((jdField_b_of_type_JavaLangRefWeakReference == null) || (jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
        break label422;
      }
      localObject2 = (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:playState=" + b(paramInt) + ",local callback=" + localObject2);
      }
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break label409;
      }
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new adwr(this, (QQPlayerService.QQPlayerCallback)localObject2, paramInt));
      localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    }
    for (;;)
    {
      label297:
      if (!localIterator.hasNext()) {
        break label472;
      }
      localObject2 = (String)localIterator.next();
      localObject2 = (WeakReference)jdField_a_of_type_JavaUtilMap.get(localObject2);
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = (QQPlayerService.QQPlayerCallback)((WeakReference)localObject2).get())
      {
        if (localObject2 == null) {
          break label457;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          break label459;
        }
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new adws(this, (QQPlayerService.QQPlayerCallback)localObject2, paramInt));
        break label297;
        h();
        break;
        label409:
        ((QQPlayerService.QQPlayerCallback)localObject2).onPlayStateChanged(jdField_a_of_type_Int);
        break label282;
        label422:
        if ((jdField_b_of_type_JavaLangRefWeakReference != null) || (!QLog.isColorLevel())) {
          break label282;
        }
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify: sCallback = null! ");
        break label282;
      }
      label457:
      continue;
      label459:
      ((QQPlayerService.QQPlayerCallback)localObject2).onPlayStateChanged(jdField_a_of_type_Int);
    }
    label472:
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
    {
      int j = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      for (;;)
      {
        if (i < j) {
          try
          {
            ((IQQPlayerCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramInt);
            i += 1;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", localRemoteException);
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null) {
        this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      }
    }
    if (jdField_a_of_type_Int == 2) {
      jdField_c_of_type_Int = 0;
    }
    if (jdField_a_of_type_Int == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "PLAY_STATE_ERROR_INTERNAL ======> post runnable to retry play media");
      }
      if (this.jdField_a_of_type_Adwz != null) {
        this.jdField_a_of_type_Adwz.postDelayed(new adwt(this), 4000L);
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "resumePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 5);
    paramContext.startService(localIntent);
  }
  
  private void b(Intent paramIntent)
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (paramIntent == null) {}
    int i;
    label118:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              i = paramIntent.getIntExtra("musicplayer.action", 0);
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "action->" + a(i));
              }
              if (i != 0)
              {
                if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
                  break label118;
                }
                if (QLog.isColorLevel())
                {
                  QLog.e("QQPlayerService", 2, "onHandleIntent, sPlayer is null");
                  return;
                }
              }
            }
            catch (Throwable paramIntent) {}
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQPlayerService", 2, "onHandleIntent error" + paramIntent.getMessage(), paramIntent);
        return;
        switch (i)
        {
        default: 
          return;
        case 2: 
          paramIntent = (SongInfo)paramIntent.getParcelableExtra("musicplayer.song");
          if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.jdField_a_of_type_JavaLangString))) {
            break label193;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("QQPlayerService", 2, "mediaPlayStart, url is null");
      return;
      if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_c_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramIntent;
      a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
      a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString);
      return;
    } while ((jdField_a_of_type_Int != 2) && ((jdField_a_of_type_Int != 1) || (jdField_a_of_type_AndroidMediaMediaPlayer == null)));
    label193:
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
      jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    this.jdField_c_of_type_Boolean = true;
    b(3);
    return;
    if ((jdField_a_of_type_Int == 3) && (jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      this.jdField_c_of_type_Boolean = false;
      i = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject, 3, 1);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder().append("requestAudioFocus,result:");
        if (i != 1) {
          break label980;
        }
      }
    }
    label980:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQPlayerService", 2, bool);
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      b(2);
      return;
      if ((jdField_a_of_type_Int == 6) || (jdField_a_of_type_Int == 7))
      {
        if (!NetworkUtil.g(getApplicationContext())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "resume from network interrupt, start play " + jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString);
        }
        this.jdField_c_of_type_Boolean = false;
        a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString);
        return;
      }
      if (jdField_a_of_type_Int != 5) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString);
      return;
      if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
        jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_c_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Adwv != null) && (this.jdField_a_of_type_Adwv.isAlive()) && (!this.jdField_a_of_type_Adwv.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Adwv.jdField_a_of_type_Boolean = true;
      }
      b(4);
      if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_JavaLangString.startsWith("qzone_")) && (jdField_a_of_type_AndroidMediaMediaPlayer != null))
      {
        this.jdField_c_of_type_Boolean = true;
        jdField_d_of_type_Int = 0;
        jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
      }
      stopSelf();
      return;
      try
      {
        paramIntent = this.jdField_a_of_type_Adwv;
        if ((paramIntent == null) || (jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!paramIntent.isAlive()) || (!paramIntent.jdField_c_of_type_Boolean) || (paramIntent.jdField_a_of_type_Boolean) || (!paramIntent.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_Boolean) || (f == 0)) {
          break label854;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, current playing song isDownloading...");
        }
        if ((!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) || (this.jdField_b_of_type_Boolean)) {
          break label857;
        }
        i = e();
        if (i / f * paramIntent.jdField_b_of_type_Int + paramIntent.jdField_b_of_type_Int * this.jdField_a_of_type_Float >= f)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data is ok, just return;");
          }
          return;
        }
      }
      finally {}
      float f1 = i;
      if (f1 / f * paramIntent.jdField_b_of_type_Int + paramIntent.jdField_b_of_type_Int * this.jdField_a_of_type_Float > paramIntent.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS,no more data to play, need pause!");
        }
        this.jdField_e_of_type_Int = i;
        this.jdField_b_of_type_Boolean = true;
        jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        b(1);
        QLog.i("QQPlayerService", 2, "buffered");
      }
      for (;;)
      {
        a();
        label854:
        return;
        label857:
        if ((!this.jdField_b_of_type_Boolean) || (jdField_a_of_type_Int != 1) || (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
          break;
        }
        if (this.jdField_e_of_type_Int / f * paramIntent.jdField_b_of_type_Int + paramIntent.jdField_b_of_type_Int * this.jdField_a_of_type_Float <= paramIntent.jdField_a_of_type_Int)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data buffering is enough");
          }
          this.jdField_e_of_type_Int = 0;
          this.jdField_b_of_type_Boolean = false;
          if (!this.jdField_c_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, user no Pause,so play!");
            }
            jdField_a_of_type_AndroidMediaMediaPlayer.start();
            b(2);
          }
        }
      }
      return;
    }
  }
  
  public static void b(QQPlayerService.QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null) {
      jdField_a_of_type_JavaUtilMap.put(paramQQPlayerCallback.getToken(), new WeakReference(paramQQPlayerCallback));
    }
  }
  
  private void b(SongInfo paramSongInfo)
  {
    for (;;)
    {
      try
      {
        if ((jdField_b_of_type_JavaLangRefWeakReference != null) && (jdField_b_of_type_JavaLangRefWeakReference.get() != null))
        {
          localObject = (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:newSong=" + paramSongInfo.jdField_b_of_type_JavaLangString + ",local callback=" + localObject);
          }
          if (Thread.currentThread() != Looper.getMainLooper().getThread())
          {
            if (this.jdField_a_of_type_AndroidOsHandler == null) {
              this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new adwp(this, (QQPlayerService.QQPlayerCallback)localObject, paramSongInfo));
          }
        }
        else
        {
          Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (String)localIterator.next();
          localObject = (WeakReference)jdField_a_of_type_JavaUtilMap.get(localObject);
          if (localObject != null) {
            break label262;
          }
          localObject = null;
          if (localObject == null) {
            continue;
          }
          if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            break label275;
          }
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new adwq(this, (QQPlayerService.QQPlayerCallback)localObject, paramSongInfo));
          continue;
        }
        ((QQPlayerService.QQPlayerCallback)localObject).onPlaySongChanged(paramSongInfo);
      }
      finally {}
      continue;
      label262:
      Object localObject = (QQPlayerService.QQPlayerCallback)((WeakReference)localObject).get();
      continue;
      label275:
      ((QQPlayerService.QQPlayerCallback)localObject).onPlaySongChanged(paramSongInfo);
    }
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
    {
      int j = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((IQQPlayerCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramSongInfo);
            i += 1;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", localRemoteException);
              }
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
    }
  }
  
  private boolean b()
  {
    return (NetworkUtil.h(getApplicationContext())) && (e() != null);
  }
  
  public static boolean b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playNext");
    }
    SongInfo localSongInfo = d();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    c(paramContext);
    return false;
  }
  
  public static boolean b(String paramString)
  {
    paramString = a(paramString);
    paramString = new File(jdField_b_of_type_JavaLangString + "/" + paramString);
    return (paramString.exists()) && (paramString.length() > 102400L);
  }
  
  public static int c()
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo != null) {
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
    }
    return 0;
  }
  
  private static SongInfo c()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0))
        {
          localObject1 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("QQPlayerService", 2, "pickPreviousSong : sSongList shouldn't be null or empty!");
            localObject1 = localObject4;
          }
          return localObject1;
        }
        int i = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "pickPreviousSong : songNum=" + i + ",sPlayMode=" + jdField_b_of_type_Int + ",currentSongIndex=" + jdField_d_of_type_Int);
        }
        Object localObject1 = localObject4;
        switch (jdField_b_of_type_Int)
        {
        case 100: 
        case 101: 
          if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
            localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
          } else {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
          }
          break;
        case 102: 
          localObject1 = localObject4;
          if (jdField_d_of_type_Int >= 1)
          {
            localObject1 = localObject4;
            if (jdField_d_of_type_Int <= i - 1)
            {
              jdField_d_of_type_Int -= 1;
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
            }
          }
          break;
        case 103: 
          localObject1 = localObject4;
          if (jdField_d_of_type_Int >= 0)
          {
            localObject1 = localObject4;
            if (jdField_d_of_type_Int <= i - 1)
            {
              jdField_d_of_type_Int -= 1;
              if (jdField_d_of_type_Int < 0) {
                jdField_d_of_type_Int = i - 1;
              }
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
            }
          }
          break;
        case 105: 
          int j = jdField_d_of_type_Int;
          jdField_d_of_type_Int = new Random().nextInt(i);
          if ((jdField_d_of_type_Int == j) && (i >= 1))
          {
            jdField_d_of_type_Int += 1;
            jdField_d_of_type_Int %= i;
          }
          if ((jdField_d_of_type_Int >= 0) && (jdField_d_of_type_Int <= i - 1))
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
          }
          else
          {
            localObject1 = localObject4;
            if (i > 0) {
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
            }
          }
          break;
        case 104: 
        default: 
          Object localObject3 = localObject4;
        }
      }
      finally {}
    }
  }
  
  private void c()
  {
    jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
  }
  
  public static void c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "stopPlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 3);
    paramContext.startService(localIntent);
  }
  
  public static void c(QQPlayerService.QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null) {
      jdField_a_of_type_JavaUtilMap.remove(paramQQPlayerCallback.getToken());
    }
  }
  
  public static int d()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = "";
        if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
          str = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString;
        }
        QLog.d("QQPlayerService", 2, "getDuration(): title= " + str + " ,sPlayState = " + b(jdField_a_of_type_Int) + " duration = " + f);
      }
      int i = f;
      return i;
    }
    finally {}
  }
  
  private static SongInfo d()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0))
        {
          localObject1 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("QQPlayerService", 2, "pickNextSong : sSongList shouldn't be null or empty!");
            localObject1 = localObject4;
          }
          return localObject1;
        }
        int i = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "pickNextSong : songNum=" + i + ",sPlayMode=" + jdField_b_of_type_Int + ",currentSongIndex=" + jdField_d_of_type_Int);
        }
        Object localObject1 = localObject4;
        switch (jdField_b_of_type_Int)
        {
        case 100: 
        case 101: 
          if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
            localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
          } else {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
          }
          break;
        case 102: 
          localObject1 = localObject4;
          if (jdField_d_of_type_Int >= 0)
          {
            localObject1 = localObject4;
            if (jdField_d_of_type_Int <= i - 2)
            {
              jdField_d_of_type_Int += 1;
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
            }
          }
          break;
        case 103: 
          localObject1 = localObject4;
          if (jdField_d_of_type_Int >= 0)
          {
            localObject1 = localObject4;
            if (jdField_d_of_type_Int <= i - 1)
            {
              jdField_d_of_type_Int += 1;
              if (jdField_d_of_type_Int > i - 1) {
                jdField_d_of_type_Int = 0;
              }
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
            }
          }
          break;
        case 105: 
          jdField_d_of_type_Int = new Random().nextInt(i);
          if ((jdField_d_of_type_Int >= 0) && (jdField_d_of_type_Int <= i - 1))
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
          }
          else
          {
            localObject1 = localObject4;
            if (i > 0) {
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
            }
          }
          break;
        case 104: 
        default: 
          Object localObject3 = localObject4;
        }
      }
      finally {}
    }
  }
  
  private static void d()
  {
    if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void d(Context paramContext)
  {
    if ((NetworkUtil.g(paramContext)) && (jdField_a_of_type_Int == 2) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_Int == 9) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo != null))
    {
      c(paramContext);
      jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.getSongUrl(NetworkUtil.h(paramContext));
      SongInfo[] arrayOfSongInfo = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
      int j = arrayOfSongInfo.length;
      int i = 0;
      while (i < j)
      {
        SongInfo localSongInfo = arrayOfSongInfo[i];
        if ((localSongInfo != null) && (localSongInfo.jdField_a_of_type_Int == 9) && (localSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo != null)) {
          localSongInfo.jdField_a_of_type_JavaLangString = localSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.getSongUrl(NetworkUtil.h(paramContext));
        }
        i += 1;
      }
      a(paramContext, jdField_a_of_type_JavaLangString, jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo, jdField_d_of_type_Int);
    }
  }
  
  public static int e()
  {
    int j = -1;
    int i = j;
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        i = j;
        if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          i = jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "getCurrentSongPosition(): sPlayState = " + b(jdField_a_of_type_Int) + " position = " + i);
      }
      return i;
    }
    finally {}
  }
  
  private static SongInfo e()
  {
    int i = 0;
    if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0)) {
      return null;
    }
    int k = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
    switch (jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 100: 
      return null;
    case 101: 
      if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
        return jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
      }
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
    case 102: 
      if ((jdField_d_of_type_Int >= 0) && (jdField_d_of_type_Int <= k - 2)) {
        return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
      }
      return null;
    }
    int j;
    if ((jdField_d_of_type_Int >= 0) && (jdField_d_of_type_Int <= k - 1))
    {
      j = jdField_d_of_type_Int + 1;
      if (j <= k - 1) {
        break label137;
      }
    }
    for (;;)
    {
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[i];
      return null;
      label137:
      i = j;
    }
  }
  
  private void e()
  {
    if ((jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_Int == 9) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo != null))
    {
      long l1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.getNearestTime();
      if (l1 > 0L)
      {
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_Adwz != null) {
          this.jdField_a_of_type_Adwz.postDelayed(new adwo(this), l1 * 1000L - l2);
        }
      }
    }
  }
  
  public static int f()
  {
    int i = -1;
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        i = jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "getCurrentPlayPosition(): sPlayState = " + b(jdField_a_of_type_Int) + " position = " + i);
      }
      return i;
    }
    finally {}
  }
  
  private void f()
  {
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_Int == 9) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo != null))
      {
        jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.getTitle();
        b(jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
        e();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int g()
  {
    return jdField_d_of_type_Int;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "showMsgTabBar =======>");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134010));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("QQPlayerService", 2, "showMsgTabBar app = null!");
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "dismissMsgTabBar <=======");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134011));
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "dismissMsgTabBar: send msg MSG_MUSIC_PLAYER_HIDE ~~~~");
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("QQPlayerService", 2, "dismissMsgTabBar app = null!");
  }
  
  private void i()
  {
    ThreadManager.getFileThreadHandler().post(new adwu(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "loopProgress : loopProgressDelayTime=" + this.jdField_b_of_type_Long);
    }
    Message localMessage = this.jdField_a_of_type_Adwz.obtainMessage();
    Intent localIntent = new Intent();
    localIntent.putExtra("musicplayer.action", 4);
    localMessage.obj = localIntent;
    this.jdField_a_of_type_Adwz.sendMessageDelayed(localMessage, this.jdField_b_of_type_Long);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onBind");
    }
    return this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService$Stub;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if ((QLog.isColorLevel()) && (jdField_d_of_type_Boolean) && (paramInt < 100)) {
      QLog.d("QQPlayerService", 2, "onBufferingUpdate : " + paramInt + "% buffered");
    }
  }
  
  @TargetApi(8)
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCompletion");
    }
    if ((!b(getApplicationContext())) && (VersionUtils.b())) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCreate");
    }
    if (VersionUtils.b()) {
      this.jdField_a_of_type_JavaLangObject = new adwl(this);
    }
    b();
    if (this.jdField_a_of_type_Adwz == null) {
      return;
    }
    this.jdField_a_of_type_Adwx = new adwx(this);
    this.jdField_a_of_type_Adwz.post(new adwn(this));
    this.jdField_a_of_type_Adww = new adww();
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Adww);
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQPlayerService", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Adwz != null)
    {
      Object localObject = new adwy(null);
      ((adwy)localObject).jdField_a_of_type_AndroidMediaMediaPlayer = jdField_a_of_type_AndroidMediaMediaPlayer;
      ((adwy)localObject).jdField_a_of_type_AndroidOsLooper = this.jdField_a_of_type_AndroidOsLooper;
      ((adwy)localObject).jdField_a_of_type_ComTencentMobileqqMusicSongInfo = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
      localObject = this.jdField_a_of_type_Adwz.obtainMessage(1, localObject);
      this.jdField_a_of_type_Adwz.sendMessage((Message)localObject);
    }
    jdField_a_of_type_JavaLangString = null;
    f = 0;
    jdField_d_of_type_Int = 0;
    jdField_a_of_type_AndroidContentIntent = null;
    jdField_a_of_type_AndroidOsBundle = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
    {
      this.jdField_a_of_type_AndroidOsRemoteCallbackList.kill();
      this.jdField_a_of_type_AndroidOsRemoteCallbackList = null;
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Adww != null) {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Adww);
      }
      i();
      this.jdField_e_of_type_Boolean = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "Android 2.1 and below can not stop music");
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQPlayerService", 2, "onError,what:" + paramInt1 + ",extra:" + paramInt2);
    }
    if (paramInt1 == 100)
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      c();
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    d();
    try
    {
      b(5);
      label99:
      return true;
    }
    catch (NullPointerException paramMediaPlayer)
    {
      break label99;
    }
  }
  
  @TargetApi(8)
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "player is null while invoking method onPrepared");
      }
      stopSelf();
    }
    int i;
    do
    {
      do
      {
        return;
        f = jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "onPrepared:sDuration" + f);
        }
        if ((this.jdField_a_of_type_Adwv != null) && (this.jdField_a_of_type_Adwv.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Adwv.jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (this.jdField_a_of_type_Adwv.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString)))
        {
          if (f != 0) {
            this.jdField_b_of_type_Long = ((f * 0.01D));
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onPrepared:loopProgressDelayTime:" + this.jdField_b_of_type_Long);
          }
          a();
        }
        if (VersionUtils.b()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQPlayerService", 2, "onPrepared Android 2.1 and below can not stop music");
      return;
      i = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject, 3, 1);
    } while (!QLog.isColorLevel());
    paramMediaPlayer = new StringBuilder().append("requestAudioFocus,result:");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQPlayerService", 2, bool);
      return;
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
    Message localMessage = this.jdField_a_of_type_Adwz.obtainMessage();
    localMessage.obj = paramIntent;
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive()) || (this.jdField_a_of_type_AndroidOsLooper != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidOsLooper.quit();
      label61:
      b();
      this.jdField_a_of_type_Adwz.sendMessage(localMessage);
      return 2;
    }
    catch (Throwable paramIntent)
    {
      break label61;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService
 * JD-Core Version:    0.7.0.1
 */