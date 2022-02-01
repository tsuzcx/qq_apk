package com.tencent.mobileqq.music;

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
import anhk;
import aqcb;
import aqcf;
import aqck;
import aqcs;
import aqfx;
import awjg;
import awjk;
import awxw;
import awya;
import awyc;
import awyd;
import awye;
import awyf;
import awyg;
import awyh;
import awyi;
import awyj;
import awyk;
import awym;
import aysz;
import bgns;
import bgnt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
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
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, aqck
{
  private static int jdField_a_of_type_Int = 0;
  public static long a;
  private static Intent jdField_a_of_type_AndroidContentIntent;
  private static MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  static SparseArray<Boolean> jdField_a_of_type_AndroidUtilSparseArray;
  private static awjk jdField_a_of_type_Awjk = new awye();
  private static SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  private static String jdField_a_of_type_JavaLangString;
  private static WeakReference<awyi> jdField_a_of_type_JavaLangRefWeakReference;
  private static Map<String, WeakReference<awyi>> jdField_a_of_type_JavaUtilMap;
  private static SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  private static int jdField_b_of_type_Int = 103;
  private static WeakReference<awyi> jdField_b_of_type_JavaLangRefWeakReference;
  private static int jdField_c_of_type_Int;
  private static int jdField_d_of_type_Int = -1;
  private static boolean jdField_d_of_type_Boolean;
  private static int jdField_f_of_type_Int;
  private static boolean jdField_f_of_type_Boolean;
  public float a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private volatile Looper jdField_a_of_type_AndroidOsLooper;
  private RemoteCallbackList<awxw> jdField_a_of_type_AndroidOsRemoteCallbackList;
  private aqcb jdField_a_of_type_Aqcb;
  private aqfx jdField_a_of_type_Aqfx = new awyf(this);
  private awya jdField_a_of_type_Awya = new awyd(this);
  private awyg jdField_a_of_type_Awyg;
  private awyh jdField_a_of_type_Awyh;
  private volatile awyk jdField_a_of_type_Awyk;
  public QQPlayerService.DownloadThread a;
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
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_f_of_type_Boolean = true;
    jdField_a_of_type_AndroidUtilSparseArray.put(10, Boolean.valueOf(true));
    jdField_d_of_type_Boolean = awym.a();
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
    case 7: 
      return "search_" + paramString;
    }
    return "miniapp_" + paramString;
  }
  
  private String a(String paramString)
  {
    try
    {
      Object localObject = a();
      if ((localObject != null) && (((Bundle)localObject).containsKey("cacheForRealUrl")))
      {
        localObject = (HashMap)((Bundle)localObject).getSerializable("cacheForRealUrl");
        if ((localObject != null) && (((HashMap)localObject).containsKey(paramString))) {
          return (String)((HashMap)localObject).get(paramString);
        }
        QLog.e("QQPlayerService", 1, "fakeUrl:" + paramString);
      }
      else
      {
        QLog.e("QQPlayerService", 1, "playDataExtras dont contains cacheForRealUrl !");
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
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
    awjg.a().a(1, jdField_a_of_type_Awjk);
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
  
  /* Error */
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_2
    //   4: ifnull +8 -> 12
    //   7: aload_2
    //   8: arraylength
    //   9: ifne +20 -> 29
    //   12: new 335	java/lang/IllegalArgumentException
    //   15: dup
    //   16: ldc_w 337
    //   19: invokespecial 340	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   22: athrow
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    //   29: aload_1
    //   30: ifnull +13 -> 43
    //   33: aload_1
    //   34: ldc_w 260
    //   37: invokevirtual 343	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +14 -> 54
    //   43: new 335	java/lang/IllegalArgumentException
    //   46: dup
    //   47: ldc_w 345
    //   50: invokespecial 340	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: iload_3
    //   55: iflt +11 -> 66
    //   58: iload_3
    //   59: aload_2
    //   60: arraylength
    //   61: iconst_1
    //   62: isub
    //   63: if_icmple +14 -> 77
    //   66: new 335	java/lang/IllegalArgumentException
    //   69: dup
    //   70: ldc_w 347
    //   73: invokespecial 340	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +52 -> 132
    //   83: ldc 151
    //   85: iconst_2
    //   86: new 158	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 349
    //   96: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: arraylength
    //   101: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc_w 351
    //   107: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload_3
    //   111: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc_w 353
    //   117: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 59	com/tencent/mobileqq/music/QQPlayerService:jdField_b_of_type_Int	I
    //   123: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_1
    //   133: putstatic 190	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   136: aload_2
    //   137: putstatic 144	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   140: getstatic 266	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   143: ifnull +28 -> 171
    //   146: iconst_0
    //   147: putstatic 57	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_Int	I
    //   150: getstatic 266	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   153: invokevirtual 358	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   156: checkcast 360	awyi
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +31 -> 192
    //   164: aload_1
    //   165: iconst_0
    //   166: invokeinterface 363 2 0
    //   171: iload_3
    //   172: putstatic 61	com/tencent/mobileqq/music/QQPlayerService:jdField_d_of_type_Int	I
    //   175: aload_0
    //   176: getstatic 144	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   179: getstatic 61	com/tencent/mobileqq/music/QQPlayerService:jdField_d_of_type_Int	I
    //   182: aaload
    //   183: iload 4
    //   185: invokestatic 299	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/content/Context;Lcom/tencent/mobileqq/music/SongInfo;Z)V
    //   188: ldc 2
    //   190: monitorexit
    //   191: return
    //   192: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -24 -> 171
    //   198: ldc 151
    //   200: iconst_2
    //   201: ldc_w 365
    //   204: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -36 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramContext	Context
    //   0	210	1	paramString	String
    //   0	210	2	paramArrayOfSongInfo	SongInfo[]
    //   0	210	3	paramInt	int
    //   0	210	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   7	12	23	finally
    //   12	23	23	finally
    //   33	43	23	finally
    //   43	54	23	finally
    //   58	66	23	finally
    //   66	77	23	finally
    //   77	132	23	finally
    //   132	160	23	finally
    //   164	171	23	finally
    //   171	188	23	finally
    //   192	207	23	finally
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
    jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public static void a(Bundle paramBundle)
  {
    jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public static void a(awyi paramawyi)
  {
    if (paramawyi != null)
    {
      jdField_a_of_type_JavaLangString = paramawyi.getToken();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "setCallback: sToken=" + jdField_a_of_type_JavaLangString);
      }
      jdField_a_of_type_JavaLangRefWeakReference = jdField_b_of_type_JavaLangRefWeakReference;
      jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramawyi);
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
    jdField_f_of_type_Int = 0;
    jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    h();
    b(paramSongInfo);
  }
  
  private void a(String paramString)
  {
    boolean bool1 = bgnt.g(getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart,isNetworkAvailable = " + bool1 + ",url : " + paramString);
    }
    if ((jdField_d_of_type_Boolean) || ((jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_Int == 9)))
    {
      f();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart, || play song in compatible mode ||");
      }
      if (!bool1)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        c(6);
      }
    }
    String str;
    Object localObject2;
    do
    {
      for (;;)
      {
        return;
        try
        {
          jdField_a_of_type_AndroidMediaMediaPlayer.reset();
          str = paramString;
          if (!TextUtils.isEmpty(paramString))
          {
            str = paramString;
            if (paramString.startsWith("qzonevipmusic://"))
            {
              paramString = a(paramString);
              str = paramString;
              if (TextUtils.isEmpty(paramString))
              {
                c(10);
                if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo == null) {
                  continue;
                }
                QLog.e("QQPlayerService", 1, "mediaPlayStart:url coverted is null , title :" + jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c + "and mid :" + jdField_a_of_type_ComTencentMobileqqMusicSongInfo.g);
                return;
              }
            }
          }
        }
        catch (IllegalArgumentException paramString)
        {
          paramString.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalArgumentException => ", paramString);
          }
          for (;;)
          {
            jdField_a_of_type_AndroidMediaMediaPlayer.start();
            return;
            jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(str);
            c(1);
            jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
            c(2);
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
            c(6);
          }
        }
        localObject2 = b(paramString);
        Object localObject1 = new File(anhk.bF + (String)localObject2);
        str = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          str = paramString;
          if (paramString.startsWith("qzonevipmusic://"))
          {
            paramString = a(paramString);
            str = paramString;
            if (TextUtils.isEmpty(paramString))
            {
              jdField_a_of_type_AndroidMediaMediaPlayer.reset();
              c(10);
              if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo == null) {
                continue;
              }
              QLog.e("QQPlayerService", 1, "mediaPlayStart:url coverted is null , title :" + jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c + "and mid :" + jdField_a_of_type_ComTencentMobileqqMusicSongInfo.g);
              return;
            }
          }
        }
        if ((!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L)) {
          break label1436;
        }
        paramString = new int[2];
        boolean bool2 = bgns.a((String)localObject2, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject1).getAbsolutePath() + ",isCacheComplete:" + bool2 + ",result[0]:" + paramString[0] + ",result[1]:" + paramString[1]);
        }
        if (!bool2) {
          break label1267;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache is complete");
        }
        jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        try
        {
          bgns.a((File)localObject1);
          jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(((File)localObject1).getAbsolutePath());
          jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          c(2);
          if (c())
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download ============");
            }
            paramString = "";
            if (c() != null) {
              paramString = c().jdField_b_of_type_JavaLangString;
            }
            localObject1 = b(paramString);
            if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              continue;
            }
            localObject2 = new File(anhk.bF + (String)localObject1);
            str = paramString;
            if (!TextUtils.isEmpty(paramString))
            {
              str = paramString;
              if (paramString.startsWith("qzonevipmusic://"))
              {
                str = a(paramString);
                if (TextUtils.isEmpty(str)) {
                  continue;
                }
              }
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: downloadThread is  running.... ");
              }
              if (str.equals(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QQPlayerService", 2, "mediaPlayStart: download url equals nextUrl,so no need play and return.");
                }
                this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = false;
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
          this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
          if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
          {
            paramString = new int[2];
            bool1 = bgns.a((String)localObject1, paramString);
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject2).getAbsolutePath() + ",isNextCacheComplete:" + bool1 + ",nextResult[0]:" + paramString[0] + ",nextResult[1]:" + paramString[1]);
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
              this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new QQPlayerService.DownloadThread(this, str, (String)localObject1, paramString[0], paramString[1]);
              this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.start();
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache no exists");
            }
            this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new QQPlayerService.DownloadThread(this, str, (String)localObject1, 0, 0);
            this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.start();
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no need pre download =================");
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread == null) || (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) || (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean));
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: download thread running,so no need play");
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = false;
    return;
    label1267:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete");
    }
    if (!bool1)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      c(6);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean))
    {
      if ((str != null) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new QQPlayerService.DownloadThread(this, str, (String)localObject2, paramString[0], paramString[1]);
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.start();
    return;
    label1436:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file");
    }
    if (!bool1)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      c(6);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean))
    {
      if ((str != null) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new QQPlayerService.DownloadThread(this, str, (String)localObject2, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.start();
  }
  
  public static void a(SongInfo[] paramArrayOfSongInfo)
  {
    a(paramArrayOfSongInfo, jdField_b_of_type_Int, 0);
  }
  
  public static void a(SongInfo[] paramArrayOfSongInfo, int paramInt1, int paramInt2)
  {
    jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = paramArrayOfSongInfo;
    jdField_b_of_type_Int = paramInt1;
    jdField_d_of_type_Int = paramInt2;
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
    SongInfo localSongInfo = e();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    c(paramContext);
    return false;
  }
  
  public static boolean a(awyi paramawyi)
  {
    if (((jdField_a_of_type_Int != 2) && (jdField_a_of_type_Int != 1)) || (paramawyi == null)) {
      return false;
    }
    if (jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      awyi localawyi = (awyi)jdField_b_of_type_JavaLangRefWeakReference.get();
      if ((localawyi != null) && (localawyi == paramawyi)) {
        return true;
      }
    }
    paramawyi = paramawyi.getToken();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "isPlayingMySong:callback.getToken()=" + paramawyi + ",sToken=" + jdField_a_of_type_JavaLangString);
    }
    if (jdField_a_of_type_JavaLangString != null) {
      return jdField_a_of_type_JavaLangString.equals(paramawyi);
    }
    return false;
  }
  
  public static boolean a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {}
    while (jdField_a_of_type_AndroidUtilSparseArray.get(paramSongInfo.jdField_b_of_type_Int) == null) {
      return true;
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
  
  public static SongInfo b()
  {
    return jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
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
    case 6: 
      return " NETWORK_INTERRUPT ";
    }
    return " COMPLETION ";
  }
  
  private static String b(String paramString)
  {
    if (paramString != null) {
      return MD5.toMD5(paramString);
    }
    return null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQPlayerService");
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsLooper = this.jdField_a_of_type_AndroidOsHandlerThread.getLooper();
      this.jdField_a_of_type_Awyk = new awyk(this, this.jdField_a_of_type_AndroidOsLooper);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("QQPlayerService", 1, "start thread oom, stop self");
      stopSelf();
    }
  }
  
  public static void b(int paramInt)
  {
    if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 3))) {}
    try
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQPlayerService", 2, "seekTo", localIllegalStateException);
    }
  }
  
  public static void b(Context paramContext)
  {
    a(paramContext, a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo));
  }
  
  private void b(Intent paramIntent)
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (paramIntent == null) {}
    int i;
    label119:
    do
    {
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
                    break label119;
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
            if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.jdField_b_of_type_JavaLangString))) {
              break label198;
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
        a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString);
      } while (paramIntent.jdField_a_of_type_Int <= 0);
      b(paramIntent.jdField_a_of_type_Int);
      return;
    } while ((jdField_a_of_type_Int != 2) && ((jdField_a_of_type_Int != 1) || (jdField_a_of_type_AndroidMediaMediaPlayer == null)));
    label198:
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
      jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    this.jdField_c_of_type_Boolean = true;
    c(3);
    return;
    if ((jdField_a_of_type_Int == 3) && (jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      this.jdField_c_of_type_Boolean = false;
      i = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject, 3, 1);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder().append("requestAudioFocus,result:");
        if (i != 1) {
          break label1035;
        }
      }
    }
    label1035:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQPlayerService", 2, bool);
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      c(2);
      return;
      if ((jdField_a_of_type_Int == 6) || ((jdField_a_of_type_Int == 7) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString))))
      {
        if (!bgnt.g(getApplicationContext())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "resume from network interrupt, start play " + jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c);
        }
        this.jdField_c_of_type_Boolean = false;
        a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString);
        return;
      }
      if ((jdField_a_of_type_Int != 5) || (jdField_a_of_type_ComTencentMobileqqMusicSongInfo == null) || (TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString))) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString);
      return;
      if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
        jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_c_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean = true;
      }
      c(4);
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
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
        if ((paramIntent == null) || (jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!paramIntent.isAlive()) || (!paramIntent.jdField_c_of_type_Boolean) || (paramIntent.jdField_a_of_type_Boolean) || (!paramIntent.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString)) || (!this.jdField_a_of_type_Boolean) || (jdField_f_of_type_Int == 0)) {
          break label909;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, current playing song isDownloading...");
        }
        if ((!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) || (this.jdField_b_of_type_Boolean)) {
          break label912;
        }
        i = e();
        if (i / jdField_f_of_type_Int * paramIntent.jdField_b_of_type_Int + paramIntent.jdField_b_of_type_Int * this.jdField_a_of_type_Float >= jdField_f_of_type_Int)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data is ok, just return;");
          }
          return;
        }
      }
      finally {}
      float f1 = i;
      if (f1 / jdField_f_of_type_Int * paramIntent.jdField_b_of_type_Int + paramIntent.jdField_b_of_type_Int * this.jdField_a_of_type_Float > paramIntent.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS,no more data to play, need pause!");
        }
        this.jdField_e_of_type_Int = i;
        this.jdField_b_of_type_Boolean = true;
        jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        c(1);
        QLog.i("QQPlayerService", 2, "buffered");
      }
      for (;;)
      {
        a();
        label909:
        return;
        label912:
        if ((!this.jdField_b_of_type_Boolean) || (jdField_a_of_type_Int != 1) || (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
          break;
        }
        if (this.jdField_e_of_type_Int / jdField_f_of_type_Int * paramIntent.jdField_b_of_type_Int + paramIntent.jdField_b_of_type_Int * this.jdField_a_of_type_Float <= paramIntent.jdField_a_of_type_Int)
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
            c(2);
          }
        }
      }
      return;
    }
  }
  
  public static void b(awyi paramawyi)
  {
    if (paramawyi != null) {
      jdField_a_of_type_JavaUtilMap.put(paramawyi.getToken(), new WeakReference(paramawyi));
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
          localObject = (awyi)jdField_b_of_type_JavaLangRefWeakReference.get();
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:newSong=" + paramSongInfo.c + ",local callback=" + localObject);
          }
          if (Thread.currentThread() != Looper.getMainLooper().getThread())
          {
            if (this.jdField_a_of_type_AndroidOsHandler == null) {
              this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new QQPlayerService.5(this, (awyi)localObject, paramSongInfo));
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
          this.jdField_a_of_type_AndroidOsHandler.post(new QQPlayerService.6(this, (awyi)localObject, paramSongInfo));
          continue;
        }
        ((awyi)localObject).onPlaySongChanged(paramSongInfo);
      }
      finally {}
      continue;
      label262:
      Object localObject = (awyi)((WeakReference)localObject).get();
      continue;
      label275:
      ((awyi)localObject).onPlaySongChanged(paramSongInfo);
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
            ((awxw)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).onPlaySongChanged(paramSongInfo);
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
    c(paramContext);
    return false;
  }
  
  public static boolean b(String paramString)
  {
    paramString = b(paramString);
    paramString = new File(anhk.bF + paramString);
    return (paramString.exists()) && (paramString.length() > 102400L);
  }
  
  public static int c()
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo != null) {
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
    }
    return 0;
  }
  
  public static SongInfo c()
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
  
  private void c()
  {
    jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
  }
  
  private void c(int paramInt)
  {
    int i = 0;
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 4) && (paramInt != 7) && (paramInt != 5) && (paramInt != 6) && (paramInt != 8) && (paramInt != 10)) {
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
    label342:
    Iterator localIterator;
    if ((jdField_a_of_type_Int == 2) || (jdField_a_of_type_Int == 1))
    {
      if (aqcf.a(16973824, "music_color_note_only_one")) {
        this.jdField_a_of_type_Aqcb.f();
      }
      if ((a(b())) && (this.jdField_a_of_type_Aqcb.a()) && (jdField_a_of_type_Int == 2)) {
        this.jdField_a_of_type_Aqcb.e();
      }
      if ((jdField_b_of_type_JavaLangRefWeakReference == null) || (jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
        break label485;
      }
      localObject2 = (awyi)jdField_b_of_type_JavaLangRefWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:playState=" + b(paramInt) + ",local callback=" + localObject2);
      }
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break label472;
      }
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new QQPlayerService.7(this, (awyi)localObject2, paramInt));
      localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    }
    for (;;)
    {
      label357:
      if (!localIterator.hasNext()) {
        break label535;
      }
      localObject2 = (String)localIterator.next();
      localObject2 = (WeakReference)jdField_a_of_type_JavaUtilMap.get(localObject2);
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = (awyi)((WeakReference)localObject2).get())
      {
        if (localObject2 == null) {
          break label520;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          break label522;
        }
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new QQPlayerService.8(this, (awyi)localObject2, paramInt));
        break label357;
        this.jdField_a_of_type_Aqcb.f();
        break;
        label472:
        ((awyi)localObject2).onPlayStateChanged(jdField_a_of_type_Int);
        break label342;
        label485:
        if ((jdField_b_of_type_JavaLangRefWeakReference != null) || (!QLog.isColorLevel())) {
          break label342;
        }
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify: sCallback = null! ");
        break label342;
      }
      label520:
      continue;
      label522:
      ((awyi)localObject2).onPlayStateChanged(jdField_a_of_type_Int);
    }
    label535:
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
    {
      int j = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      for (;;)
      {
        if (i < j) {
          try
          {
            ((awxw)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).onPlayStateChanged(paramInt);
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
      if (this.jdField_a_of_type_Awyk != null) {
        this.jdField_a_of_type_Awyk.postDelayed(new QQPlayerService.9(this), 4000L);
      }
    }
  }
  
  public static void c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "stopPlayMusic");
    }
    awjg.a().a(jdField_a_of_type_Awjk);
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
  
  public static void c(awyi paramawyi)
  {
    if (paramawyi != null) {
      jdField_a_of_type_JavaUtilMap.remove(paramawyi.getToken());
    }
  }
  
  private boolean c()
  {
    return (bgnt.h(getApplicationContext())) && (c() != null);
  }
  
  public static int d()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = "";
        if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
          str = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c;
        }
        QLog.d("QQPlayerService", 2, "getDuration(): title= " + str + " ,sPlayState = " + b(jdField_a_of_type_Int) + " duration = " + jdField_f_of_type_Int);
      }
      int i = jdField_f_of_type_Int;
      return i;
    }
    finally {}
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
    if ((bgnt.g(paramContext)) && (jdField_a_of_type_Int == 2) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_Int == 9) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo != null))
    {
      c(paramContext);
      jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.getSongUrl(bgnt.h(paramContext));
      SongInfo[] arrayOfSongInfo = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
      int j = arrayOfSongInfo.length;
      int i = 0;
      while (i < j)
      {
        SongInfo localSongInfo = arrayOfSongInfo[i];
        if ((localSongInfo != null) && (localSongInfo.jdField_b_of_type_Int == 9) && (localSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo != null)) {
          localSongInfo.jdField_b_of_type_JavaLangString = localSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.getSongUrl(bgnt.h(paramContext));
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
  
  private void e()
  {
    if ((jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_Int == 9) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo != null))
    {
      long l1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.getNearestTime();
      if (l1 > 0L)
      {
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_Awyk != null) {
          this.jdField_a_of_type_Awyk.postDelayed(new QQPlayerService.4(this), l1 * 1000L - l2);
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
      if ((jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_Int == 9) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo != null))
      {
        jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.getTitle();
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
    ThreadManager.getFileThreadHandler().post(new QQPlayerService.10(this));
  }
  
  private void h()
  {
    if ((jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (jdField_f_of_type_Boolean))
    {
      ColorNote localColorNote = getColorNote();
      localColorNote.mMainTitle = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c;
      localColorNote.mSubTitle = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.h;
      localColorNote.mPicUrl = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.e;
      this.jdField_a_of_type_Aqcb.a(localColorNote);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "loopProgress : loopProgressDelayTime=" + this.jdField_b_of_type_Long);
    }
    Message localMessage = this.jdField_a_of_type_Awyk.obtainMessage();
    Intent localIntent = new Intent();
    localIntent.putExtra("musicplayer.action", 4);
    localMessage.obj = localIntent;
    this.jdField_a_of_type_Awyk.sendMessageDelayed(localMessage, this.jdField_b_of_type_Long);
  }
  
  public ColorNote getColorNote()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null)
    {
      localObject1 = localObject2;
      if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.f != null) {
        localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.f.getBytes();
      }
      localObject1 = new aqcs().a(16973824).a("music_color_note_only_one").b(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c).c(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.h).d(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.e).a((byte[])localObject1).a();
    }
    return localObject1;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onBind");
    }
    return this.jdField_a_of_type_Awya;
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
    c(8);
    if ((!b(getApplicationContext())) && (VersionUtils.isrFroyo())) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCreate");
    }
    if (VersionUtils.isrFroyo()) {
      this.jdField_a_of_type_JavaLangObject = new awyc(this);
    }
    b();
    if (this.jdField_a_of_type_Awyk == null) {
      return;
    }
    this.jdField_a_of_type_Awyh = new awyh(this);
    this.jdField_a_of_type_Awyk.post(new QQPlayerService.2(this));
    this.jdField_a_of_type_Awyg = new awyg();
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Awyg);
    this.jdField_a_of_type_Aqcb = new aqcb(getBaseContext(), false, false);
    this.jdField_a_of_type_Aqcb.a(this);
    this.jdField_a_of_type_Aqcb.l();
    this.jdField_a_of_type_Aqcb.a(this.jdField_a_of_type_Aqfx);
    this.jdField_a_of_type_Aqcb.m();
    b(aysz.a());
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQPlayerService", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Awyk != null)
    {
      Object localObject = new awyj(null);
      ((awyj)localObject).jdField_a_of_type_AndroidMediaMediaPlayer = jdField_a_of_type_AndroidMediaMediaPlayer;
      ((awyj)localObject).jdField_a_of_type_AndroidOsLooper = this.jdField_a_of_type_AndroidOsLooper;
      ((awyj)localObject).jdField_a_of_type_ComTencentMobileqqMusicSongInfo = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
      localObject = this.jdField_a_of_type_Awyk.obtainMessage(1, localObject);
      this.jdField_a_of_type_Awyk.sendMessage((Message)localObject);
    }
    if (this.jdField_a_of_type_Aqcb != null)
    {
      this.jdField_a_of_type_Aqcb.c();
      this.jdField_a_of_type_Aqcb = null;
    }
    jdField_a_of_type_JavaLangString = null;
    jdField_f_of_type_Int = 0;
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
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Awyg != null) {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Awyg);
      }
      g();
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
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    d();
    try
    {
      c(5);
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
        jdField_f_of_type_Int = jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "onPrepared:sDuration" + jdField_f_of_type_Int);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString)))
        {
          if (jdField_f_of_type_Int != 0) {
            this.jdField_b_of_type_Long = ((jdField_f_of_type_Int * 0.01D));
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onPrepared:loopProgressDelayTime:" + this.jdField_b_of_type_Long);
          }
          a();
        }
        if (VersionUtils.isrFroyo()) {
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
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onStartCommand");
    }
    Message localMessage = this.jdField_a_of_type_Awyk.obtainMessage();
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("key_add_to_color_note", true)) {
        break label108;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      jdField_f_of_type_Boolean = bool1;
      localMessage.obj = paramIntent;
      if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive()) || (this.jdField_a_of_type_AndroidOsLooper != null)) {}
      try
      {
        this.jdField_a_of_type_AndroidOsLooper.quit();
        label92:
        b();
        this.jdField_a_of_type_Awyk.sendMessage(localMessage);
        return 2;
        label108:
        bool1 = false;
      }
      catch (Throwable paramIntent)
      {
        break label92;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService
 * JD-Core Version:    0.7.0.1
 */