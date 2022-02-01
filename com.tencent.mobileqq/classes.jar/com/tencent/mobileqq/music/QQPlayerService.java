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
  private static int jdField_a_of_type_Int = 0;
  public static long a = 0L;
  private static Intent jdField_a_of_type_AndroidContentIntent;
  private static MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  static SparseArray<Boolean> jdField_a_of_type_AndroidUtilSparseArray;
  private static MediaFocusManager.OnMediaFocusChangeListener jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener;
  private static QQPlayerLifecycleCallbacks jdField_a_of_type_ComTencentMobileqqMusicQQPlayerLifecycleCallbacks;
  private static SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  private static String jdField_a_of_type_JavaLangString;
  private static WeakReference<QQPlayerCallback> jdField_a_of_type_JavaLangRefWeakReference;
  private static Map<String, WeakReference<QQPlayerCallback>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  private static int jdField_b_of_type_Int = 103;
  public static long b = 0L;
  private static WeakReference<QQPlayerCallback> jdField_b_of_type_JavaLangRefWeakReference;
  private static int jdField_c_of_type_Int = 0;
  private static int jdField_d_of_type_Int = -1;
  private static boolean jdField_d_of_type_Boolean = Utils.a();
  private static int jdField_f_of_type_Int;
  private static boolean jdField_f_of_type_Boolean;
  public float a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private volatile Looper jdField_a_of_type_AndroidOsLooper;
  private RemoteCallbackList<IQQPlayerCallback> jdField_a_of_type_AndroidOsRemoteCallbackList;
  private IQQPlayerService.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService$Stub = new QQPlayerService.10(this);
  public QQPlayerService.DownloadThread a;
  private QQPlayerService.NetInfoHandler jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$NetInfoHandler;
  private QQPlayerService.QQPlayerBroadcastReceiverReceiver jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerBroadcastReceiverReceiver;
  private volatile QQPlayerService.ServiceHandler jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler;
  private Object jdField_a_of_type_JavaLangObject;
  public boolean a;
  private volatile boolean jdField_b_of_type_Boolean = false;
  public long c;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_f_of_type_Int = 0;
    jdField_d_of_type_Boolean = false;
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_f_of_type_Boolean = true;
    jdField_a_of_type_ComTencentMobileqqMusicQQPlayerLifecycleCallbacks = new QQPlayerLifecycleCallbacks();
    jdField_a_of_type_AndroidUtilSparseArray.put(10, Boolean.valueOf(true));
    try
    {
      Iterator localIterator = QQPlayerInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        jdField_a_of_type_ComTencentMobileqqMusicQQPlayerLifecycleCallbacks.a((IQQPlayerLifeCycleCallback)localClass.newInstance());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQPlayerService", 1, "[static] ", localException);
      jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener = new QQPlayerService.11();
    }
  }
  
  public QQPlayerService()
  {
    this.jdField_c_of_type_Long = 500L;
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
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
    try
    {
      if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length != 0))
      {
        int i = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pickNextSong : songNum=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",sPlayMode=");
          ((StringBuilder)localObject1).append(jdField_b_of_type_Int);
          ((StringBuilder)localObject1).append(",currentSongIndex=");
          ((StringBuilder)localObject1).append(jdField_d_of_type_Int);
          QLog.d("QQPlayerService", 2, ((StringBuilder)localObject1).toString());
        }
        int j = jdField_b_of_type_Int;
        switch (j)
        {
        case 104: 
        default: 
          return null;
        case 105: 
          jdField_d_of_type_Int = new Random().nextInt(i);
          if ((jdField_d_of_type_Int >= 0) && (jdField_d_of_type_Int <= i - 1))
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
            return localObject1;
          }
          if (i > 0)
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
            return localObject1;
          }
          return null;
        case 103: 
          if (jdField_d_of_type_Int >= 0)
          {
            j = jdField_d_of_type_Int;
            i -= 1;
            if (j <= i)
            {
              jdField_d_of_type_Int += 1;
              if (jdField_d_of_type_Int > i) {
                jdField_d_of_type_Int = 0;
              }
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
              return localObject1;
            }
          }
          return null;
        case 102: 
          if ((jdField_d_of_type_Int >= 0) && (jdField_d_of_type_Int <= i - 2))
          {
            jdField_d_of_type_Int += 1;
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
            return localObject1;
          }
          return null;
        case 101: 
          if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null)
          {
            localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
            return localObject1;
          }
          localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
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
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
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
    MediaFocusManager.a().a(1, jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
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
              localStringBuilder.append(jdField_b_of_type_Int);
              QLog.d("QQPlayerService", 2, localStringBuilder.toString());
            }
            jdField_a_of_type_JavaLangString = paramString;
            jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = paramArrayOfSongInfo;
            if (jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              jdField_a_of_type_Int = 0;
              paramString = (QQPlayerCallback)jdField_a_of_type_JavaLangRefWeakReference.get();
              if (paramString != null) {
                paramString.onPlayStateChanged(0);
              } else if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "startPlayMusic：lastCallback = null");
              }
            }
            jdField_d_of_type_Int = paramInt;
            a(paramContext, jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int], paramBoolean);
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
    jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public static void a(Bundle paramBundle)
  {
    jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public static void a(QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null)
    {
      jdField_a_of_type_JavaLangString = paramQQPlayerCallback.getToken();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCallback: sToken=");
        localStringBuilder.append(jdField_a_of_type_JavaLangString);
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
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
    if (paramSongInfo != null) {
      try
      {
        jdField_f_of_type_Int = 0;
        jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
        b(paramSongInfo);
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
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart:cache is complete");
    }
    jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    try
    {
      MusicCacheManager.a(paramFile);
      jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramFile.getAbsolutePath());
      jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
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
    jdField_a_of_type_AndroidMediaMediaPlayer.start();
    d(2);
    if (d())
    {
      k();
      return;
    }
    j();
  }
  
  private void a(String paramString)
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
    if (!jdField_d_of_type_Boolean)
    {
      localObject = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
      if ((localObject == null) || (((SongInfo)localObject).jdField_b_of_type_Int != 9))
      {
        String str = b(paramString);
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
            paramString = a(paramString);
            localObject = paramString;
            if (TextUtils.isEmpty(paramString))
            {
              jdField_a_of_type_AndroidMediaMediaPlayer.reset();
              d(10);
              if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null)
              {
                paramString = new StringBuilder();
                paramString.append("mediaPlayStart:url coverted is null , title :");
                paramString.append(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c);
                paramString.append("and mid :");
                paramString.append(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.g);
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
    i();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart, || play song in compatible mode ||");
    }
    if (!bool1)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      d(6);
      return;
    }
    try
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = paramString;
        if (paramString.startsWith("qzonevipmusic://"))
        {
          paramString = a(paramString);
          localObject = paramString;
          if (TextUtils.isEmpty(paramString))
          {
            d(10);
            if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo == null) {
              return;
            }
            paramString = new StringBuilder();
            paramString.append("mediaPlayStart:url coverted is null , title :");
            paramString.append(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c);
            paramString.append("and mid :");
            paramString.append(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.g);
            QLog.e("QQPlayerService", 1, paramString.toString());
            return;
          }
        }
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource((String)localObject);
      d(1);
      jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      d(2);
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IOException => ", paramString);
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      d(6);
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
    jdField_a_of_type_AndroidMediaMediaPlayer.start();
    return;
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file");
    }
    if (!paramBoolean)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      d(6);
      return;
    }
    QQPlayerService.DownloadThread localDownloadThread = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
    if ((localDownloadThread != null) && (localDownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean))
    {
      if ((paramString1 != null) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString)))
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
      localDownloadThread = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
      localDownloadThread.jdField_d_of_type_Boolean = false;
      localDownloadThread.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new QQPlayerService.DownloadThread(this, paramString1, paramString2, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.start();
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete");
    }
    if (!paramBoolean)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      d(6);
      return;
    }
    QQPlayerService.DownloadThread localDownloadThread = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
    if ((localDownloadThread != null) && (localDownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean))
    {
      if ((paramString1 != null) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString)))
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
      localDownloadThread = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
      localDownloadThread.jdField_d_of_type_Boolean = false;
      localDownloadThread.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new QQPlayerService.DownloadThread(this, paramString1, paramString2, paramArrayOfInt[0], paramArrayOfInt[1]);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPlaying : sPlayState ");
      localStringBuilder.append(c(jdField_a_of_type_Int));
      QLog.d("QQPlayerService", 2, localStringBuilder.toString());
    }
    int i = jdField_a_of_type_Int;
    boolean bool = true;
    if (i != 2)
    {
      if (i == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playPrev");
    }
    SongInfo localSongInfo = f();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    c(paramContext);
    return false;
  }
  
  private boolean a(Intent paramIntent)
  {
    paramIntent = (SongInfo)paramIntent.getParcelableExtra("musicplayer.song");
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.jdField_b_of_type_JavaLangString)))
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_c_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramIntent;
      a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
      a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString);
      if (paramIntent.jdField_a_of_type_Int > 0) {
        b(paramIntent.jdField_a_of_type_Int);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQPlayerService", 2, "mediaPlayStart, url is null");
    }
    return true;
  }
  
  public static boolean a(QQPlayerCallback paramQQPlayerCallback)
  {
    int i = jdField_a_of_type_Int;
    if (((i != 2) && (i != 1)) || (paramQQPlayerCallback == null)) {
      return false;
    }
    Object localObject = jdField_b_of_type_JavaLangRefWeakReference;
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
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
    }
    localObject = jdField_a_of_type_JavaLangString;
    if (localObject != null) {
      return ((String)localObject).equals(paramQQPlayerCallback);
    }
    return false;
  }
  
  public static boolean a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return true;
    }
    return jdField_a_of_type_AndroidUtilSparseArray.get(paramSongInfo.jdField_b_of_type_Int) == null;
  }
  
  public static boolean a(String paramString)
  {
    int i = jdField_a_of_type_Int;
    if ((i != 2) && (i != 1)) {
      return false;
    }
    String str = jdField_a_of_type_JavaLangString;
    if (str != null) {
      return str.equals(paramString);
    }
    return false;
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
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler = new QQPlayerService.ServiceHandler(this, this.jdField_a_of_type_AndroidOsLooper);
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
  
  public static void b(int paramInt)
  {
    if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      int i = jdField_a_of_type_Int;
      if ((i == 2) || (i == 3)) {
        try
        {
          jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
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
  
  public static void b(Context paramContext)
  {
    a(paramContext, a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo));
  }
  
  private void b(Intent paramIntent)
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (paramIntent == null) {
      return;
    }
    int i;
    try
    {
      i = paramIntent.getIntExtra("musicplayer.action", 0);
      if (!QLog.isColorLevel()) {
        break label172;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("action->");
      localStringBuilder.append(a(i));
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
    if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
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
      g();
      return;
      do
      {
        f();
        return;
        do
        {
          if (c()) {
            return;
          }
          do
          {
            e();
            return;
            do
            {
              boolean bool = a(paramIntent);
              if (bool) {
                return;
              }
              return;
              if (i != 0) {
                break;
              }
              return;
              return;
            } while (i == 2);
          } while (i == 3);
        } while (i == 4);
      } while (i == 5);
    } while (i == 6);
  }
  
  public static void b(QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null) {
      jdField_a_of_type_JavaUtilMap.put(paramQQPlayerCallback.getToken(), new WeakReference(paramQQPlayerCallback));
    }
  }
  
  private void b(SongInfo paramSongInfo)
  {
    try
    {
      Object localObject1;
      if ((jdField_b_of_type_JavaLangRefWeakReference != null) && (jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        localObject1 = (QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("changePlayStateAndNotify:newSong=");
          ((StringBuilder)localObject2).append(paramSongInfo.c);
          ((StringBuilder)localObject2).append(",local callback=");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("QQPlayerService", 2, ((StringBuilder)localObject2).toString());
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new QQPlayerService.4(this, (QQPlayerCallback)localObject1, paramSongInfo));
        }
        else
        {
          ((QQPlayerCallback)localObject1).onPlaySongChanged(paramSongInfo);
        }
      }
      Object localObject2 = jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        localObject1 = (WeakReference)jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = (QQPlayerCallback)((WeakReference)localObject1).get();
        }
        if (localObject1 != null) {
          if (Thread.currentThread() != Looper.getMainLooper().getThread())
          {
            if (this.jdField_a_of_type_AndroidOsHandler == null) {
              this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new QQPlayerService.5(this, (QQPlayerCallback)localObject1, paramSongInfo));
          }
          else
          {
            ((QQPlayerCallback)localObject1).onPlaySongChanged(paramSongInfo);
          }
        }
      }
      if (this.jdField_a_of_type_AndroidOsRemoteCallbackList == null) {
        break label368;
      }
      j = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int j;
        int i;
        for (;;)
        {
          label368:
          throw paramSongInfo;
        }
        label382:
        i += 1;
      }
    }
    if (i < j)
    {
      try
      {
        ((IQQPlayerCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramSongInfo);
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
      this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_MUSIC);
    localStringBuilder.append(paramString);
    paramString = new File(localStringBuilder.toString());
    return (paramString.exists()) && (paramString.length() > 102400L);
  }
  
  public static int c()
  {
    SongInfo[] arrayOfSongInfo = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
    if (arrayOfSongInfo != null) {
      return arrayOfSongInfo.length;
    }
    return 0;
  }
  
  public static SongInfo c()
  {
    return d();
  }
  
  private static String c(int paramInt)
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
  
  private void c()
  {
    jdField_a_of_type_AndroidMediaMediaPlayer = new ReportMediaPlayer();
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
  }
  
  private void c(int paramInt)
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
        if ((jdField_a_of_type_Int == 3) && (jdField_a_of_type_AndroidMediaMediaPlayer != null) && (!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
        {
          jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(1.0F, 1.0F);
          if (this.jdField_b_of_type_Boolean)
          {
            a();
          }
          else if (!this.jdField_c_of_type_Boolean)
          {
            jdField_a_of_type_AndroidMediaMediaPlayer.start();
            d(2);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "onAudioFocusChange,gain focus");
        }
        this.jdField_a_of_type_Boolean = true;
        break label241;
        if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
        {
          jdField_a_of_type_AndroidMediaMediaPlayer.pause();
          d(3);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "onAudioFocusChange,loss focus");
        }
        this.jdField_a_of_type_Boolean = false;
        break label241;
        if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
          jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(0.5F, 0.5F);
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
  
  public static void c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "stopPlayMusic");
    }
    MediaFocusManager.a().a(jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
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
  
  public static void c(QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null) {
      jdField_a_of_type_JavaUtilMap.remove(paramQQPlayerCallback.getToken());
    }
  }
  
  private boolean c()
  {
    try
    {
      QQPlayerService.DownloadThread localDownloadThread = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
      if ((localDownloadThread != null) && (jdField_a_of_type_AndroidMediaMediaPlayer != null) && (localDownloadThread.isAlive()) && (localDownloadThread.jdField_c_of_type_Boolean) && (!localDownloadThread.jdField_a_of_type_Boolean) && (localDownloadThread.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean) && (jdField_f_of_type_Int != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, current playing song isDownloading...");
        }
        if ((jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) && (!this.jdField_b_of_type_Boolean))
        {
          int i = e();
          float f1 = i;
          if (f1 / jdField_f_of_type_Int * localDownloadThread.jdField_b_of_type_Int + localDownloadThread.jdField_b_of_type_Int * this.jdField_a_of_type_Float >= jdField_f_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data is ok, just return;");
            }
            return true;
          }
          if (f1 / jdField_f_of_type_Int * localDownloadThread.jdField_b_of_type_Int + localDownloadThread.jdField_b_of_type_Int * this.jdField_a_of_type_Float > localDownloadThread.jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS,no more data to play, need pause!");
            }
            this.jdField_e_of_type_Int = i;
            this.jdField_b_of_type_Boolean = true;
            jdField_a_of_type_AndroidMediaMediaPlayer.pause();
            d(1);
            QLog.i("QQPlayerService", 2, "buffered");
          }
        }
        else
        {
          if ((!this.jdField_b_of_type_Boolean) || (jdField_a_of_type_Int != 1) || (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
            break label359;
          }
          if (this.jdField_e_of_type_Int / jdField_f_of_type_Int * localDownloadThread.jdField_b_of_type_Int + localDownloadThread.jdField_b_of_type_Int * this.jdField_a_of_type_Float <= localDownloadThread.jdField_a_of_type_Int)
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
              d(2);
            }
          }
        }
        a();
        break label363;
        label359:
        return true;
      }
      label363:
      return false;
    }
    finally {}
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDuration(): title= ");
        localStringBuilder.append(str);
        localStringBuilder.append(" ,sPlayState = ");
        localStringBuilder.append(c(jdField_a_of_type_Int));
        localStringBuilder.append(" duration = ");
        localStringBuilder.append(jdField_f_of_type_Int);
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
      }
      int i = jdField_f_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public static SongInfo d()
  {
    SongInfo[] arrayOfSongInfo = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
    if (arrayOfSongInfo != null)
    {
      if (arrayOfSongInfo.length == 0) {
        return null;
      }
      int i = arrayOfSongInfo.length;
      int j;
      switch (jdField_b_of_type_Int)
      {
      default: 
        return null;
      case 103: 
        j = jdField_d_of_type_Int;
        if (j >= 0)
        {
          int k = i - 1;
          if (j <= k)
          {
            j += 1;
            i = j;
            if (j > k) {
              i = 0;
            }
            return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[i];
          }
        }
        return null;
      case 102: 
        j = jdField_d_of_type_Int;
        if ((j >= 0) && (j <= i - 2)) {
          return arrayOfSongInfo[j];
        }
        return null;
      case 101: 
        SongInfo localSongInfo = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
        if (localSongInfo != null) {
          return localSongInfo;
        }
        return arrayOfSongInfo[0];
      }
    }
    return null;
  }
  
  private static void d()
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
  
  private void d(int paramInt)
  {
    try
    {
      g(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("changePlayStateAndNotify:");
        localStringBuilder.append(c(jdField_a_of_type_Int));
        localStringBuilder.append(" =====> ");
        localStringBuilder.append(c(paramInt));
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
      }
      jdField_a_of_type_Int = paramInt;
      f(paramInt);
      e(paramInt);
      return;
    }
    finally {}
  }
  
  private boolean d()
  {
    return (NetworkUtil.isWifiConnected(getApplicationContext())) && (d() != null);
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentSongPosition(): sPlayState = ");
        localStringBuilder.append(c(jdField_a_of_type_Int));
        localStringBuilder.append(" position = ");
        localStringBuilder.append(i);
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
      }
      return i;
    }
    finally {}
  }
  
  private void e()
  {
    Object localObject = jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localObject != null) && (((MediaPlayer)localObject).isPlaying())) {
      jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
    this.jdField_c_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
    if ((localObject != null) && (((QQPlayerService.DownloadThread)localObject).isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean = true;
    }
    d(4);
    localObject = jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).startsWith("qzone_")) && (jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      this.jdField_c_of_type_Boolean = true;
      jdField_d_of_type_Int = 0;
      jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
    }
    stopSelf();
  }
  
  private void e(int paramInt)
  {
    RemoteCallbackList localRemoteCallbackList1 = this.jdField_a_of_type_AndroidOsRemoteCallbackList;
    if (localRemoteCallbackList1 != null)
    {
      int j = localRemoteCallbackList1.beginBroadcast();
      int i = 0;
      while (i < j)
      {
        try
        {
          ((IQQPlayerCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramInt);
        }
        catch (RemoteException localRemoteException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", localRemoteException);
          }
        }
        i += 1;
      }
      RemoteCallbackList localRemoteCallbackList2 = this.jdField_a_of_type_AndroidOsRemoteCallbackList;
      if (localRemoteCallbackList2 != null) {
        localRemoteCallbackList2.finishBroadcast();
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
      if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler.postDelayed(new QQPlayerService.6(this), 4000L);
      }
    }
  }
  
  private static void e(Context paramContext)
  {
    if ((NetworkUtil.isNetworkAvailable(paramContext)) && (jdField_a_of_type_Int == 2))
    {
      Object localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
      if ((localObject1 != null) && (((SongInfo)localObject1).jdField_b_of_type_Int == 9) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_ComTencentMobileqqMusicBroadcastMusicInfo != null))
      {
        c(paramContext);
        localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
        ((SongInfo)localObject1).jdField_b_of_type_JavaLangString = ((SongInfo)localObject1).jdField_a_of_type_ComTencentMobileqqMusicBroadcastMusicInfo.a(NetworkUtil.isWifiConnected(paramContext));
        localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2 != null) && (localObject2.jdField_b_of_type_Int == 9) && (localObject2.jdField_a_of_type_ComTencentMobileqqMusicBroadcastMusicInfo != null)) {
            localObject2.jdField_b_of_type_JavaLangString = localObject2.jdField_a_of_type_ComTencentMobileqqMusicBroadcastMusicInfo.a(NetworkUtil.isWifiConnected(paramContext));
          }
          i += 1;
        }
        a(paramContext, jdField_a_of_type_JavaLangString, jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo, jdField_d_of_type_Int);
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentPlayPosition(): sPlayState = ");
        localStringBuilder.append(c(jdField_a_of_type_Int));
        localStringBuilder.append(" position = ");
        localStringBuilder.append(i);
        QLog.d("QQPlayerService", 2, localStringBuilder.toString());
      }
      return i;
    }
    finally {}
  }
  
  private static SongInfo f()
  {
    try
    {
      if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length != 0))
      {
        int i = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pickPreviousSong : songNum=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(",sPlayMode=");
          ((StringBuilder)localObject1).append(jdField_b_of_type_Int);
          ((StringBuilder)localObject1).append(",currentSongIndex=");
          ((StringBuilder)localObject1).append(jdField_d_of_type_Int);
          QLog.d("QQPlayerService", 2, ((StringBuilder)localObject1).toString());
        }
        int j = jdField_b_of_type_Int;
        switch (j)
        {
        case 104: 
        default: 
          return null;
        case 105: 
          j = jdField_d_of_type_Int;
          jdField_d_of_type_Int = new Random().nextInt(i);
          if ((jdField_d_of_type_Int == j) && (i >= 1))
          {
            jdField_d_of_type_Int += 1;
            jdField_d_of_type_Int %= i;
          }
          if ((jdField_d_of_type_Int >= 0) && (jdField_d_of_type_Int <= i - 1))
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
            return localObject1;
          }
          if (i > 0)
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
            return localObject1;
          }
          return null;
        case 103: 
          if (jdField_d_of_type_Int >= 0)
          {
            j = jdField_d_of_type_Int;
            i -= 1;
            if (j <= i)
            {
              jdField_d_of_type_Int -= 1;
              if (jdField_d_of_type_Int < 0) {
                jdField_d_of_type_Int = i;
              }
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
              return localObject1;
            }
          }
          return null;
        case 102: 
          if ((jdField_d_of_type_Int >= 1) && (jdField_d_of_type_Int <= i - 1))
          {
            jdField_d_of_type_Int -= 1;
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[jdField_d_of_type_Int];
            return localObject1;
          }
          return null;
        case 101: 
          if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null)
          {
            localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
            return localObject1;
          }
          localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
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
  
  private void f()
  {
    int i = jdField_a_of_type_Int;
    boolean bool = false;
    Object localObject;
    if ((i == 3) && (jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      this.jdField_c_of_type_Boolean = false;
      i = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject, 3, 1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestAudioFocus,result:");
        if (i == 1) {
          bool = true;
        }
        ((StringBuilder)localObject).append(bool);
        QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      d(2);
      return;
    }
    i = jdField_a_of_type_Int;
    if (i != 6) {
      if (i == 7)
      {
        localObject = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
        if ((localObject != null) && (!TextUtils.isEmpty(((SongInfo)localObject).jdField_b_of_type_JavaLangString))) {}
      }
      else
      {
        if (jdField_a_of_type_Int != 5) {
          return;
        }
        localObject = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
        if ((localObject == null) || (TextUtils.isEmpty(((SongInfo)localObject).jdField_b_of_type_JavaLangString))) {
          return;
        }
        this.jdField_c_of_type_Boolean = false;
        a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString);
        return;
      }
    }
    if (NetworkUtil.isNetworkAvailable(getApplicationContext()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resume from network interrupt, start play ");
        ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c);
        QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_c_of_type_Boolean = false;
      a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void f(int paramInt)
  {
    Object localObject1 = jdField_b_of_type_JavaLangRefWeakReference;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      localObject1 = (QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("changePlayStateAndNotify:playState=");
        ((StringBuilder)localObject2).append(c(paramInt));
        ((StringBuilder)localObject2).append(",local callback=");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("QQPlayerService", 2, ((StringBuilder)localObject2).toString());
      }
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new QQPlayerService.7(this, (QQPlayerCallback)localObject1, paramInt));
      }
      else
      {
        ((QQPlayerCallback)localObject1).onPlayStateChanged(jdField_a_of_type_Int);
      }
    }
    else if ((jdField_b_of_type_JavaLangRefWeakReference == null) && (QLog.isColorLevel()))
    {
      QLog.d("QQPlayerService", 2, "changePlayStateAndNotify: sCallback = null! ");
    }
    Object localObject2 = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (String)((Iterator)localObject2).next();
      localObject1 = (WeakReference)jdField_a_of_type_JavaUtilMap.get(localObject1);
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = (QQPlayerCallback)((WeakReference)localObject1).get();
      }
      if (localObject1 != null) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new QQPlayerService.8(this, (QQPlayerCallback)localObject1, paramInt));
        }
        else
        {
          ((QQPlayerCallback)localObject1).onPlayStateChanged(jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public static int g()
  {
    return jdField_d_of_type_Int;
  }
  
  private void g()
  {
    int i = jdField_a_of_type_Int;
    if ((i == 2) || ((i == 1) && (jdField_a_of_type_AndroidMediaMediaPlayer != null)))
    {
      if (VersionUtils.b()) {
        ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
      }
      if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      }
      this.jdField_c_of_type_Boolean = true;
      d(3);
    }
  }
  
  private void g(int paramInt)
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
  
  private void h()
  {
    SongInfo localSongInfo = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
    if ((localSongInfo != null) && (localSongInfo.jdField_b_of_type_Int == 9) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_ComTencentMobileqqMusicBroadcastMusicInfo != null))
    {
      long l1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_ComTencentMobileqqMusicBroadcastMusicInfo.a();
      if (l1 > 0L)
      {
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler.postDelayed(new QQPlayerService.3(this), l1 * 1000L - l2);
        }
      }
    }
  }
  
  private void i()
  {
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_Int == 9) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_ComTencentMobileqqMusicBroadcastMusicInfo != null))
      {
        jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_ComTencentMobileqqMusicBroadcastMusicInfo.a();
        b(jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
        h();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: no need pre download =================");
    }
    QQPlayerService.DownloadThread localDownloadThread = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
    if ((localDownloadThread != null) && (localDownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: download thread running,so no need play");
      }
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = false;
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download ============");
    }
    Object localObject1;
    if (d() != null) {
      localObject1 = d().jdField_b_of_type_JavaLangString;
    } else {
      localObject1 = "";
    }
    String str = b((String)localObject1);
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
          localObject1 = a((String)localObject1);
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return;
          }
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
      if ((localObject1 != null) && (((QQPlayerService.DownloadThread)localObject1).isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: downloadThread is  running.... ");
        }
        if (((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart: download url equals nextUrl,so no need play and return.");
          }
          this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_d_of_type_Boolean = false;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: download url not equals nextUrl,so no need stop.");
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
        ((QQPlayerService.DownloadThread)localObject1).jdField_d_of_type_Boolean = false;
        ((QQPlayerService.DownloadThread)localObject1).jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
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
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new QQPlayerService.DownloadThread(this, (String)localObject2, str, localObject1[0], localObject1[1]);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
        ((QQPlayerService.DownloadThread)localObject1).jdField_d_of_type_Boolean = false;
        ((QQPlayerService.DownloadThread)localObject1).start();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache no exists");
      }
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new QQPlayerService.DownloadThread(this, (String)localObject2, str, 0, 0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
      ((QQPlayerService.DownloadThread)localObject1).jdField_d_of_type_Boolean = false;
      ((QQPlayerService.DownloadThread)localObject1).start();
    }
  }
  
  private void l()
  {
    ThreadManager.getFileThreadHandler().post(new QQPlayerService.9(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loopProgress : loopProgressDelayTime=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler.obtainMessage();
    Intent localIntent = new Intent();
    localIntent.putExtra("musicplayer.action", 4);
    ((Message)localObject).obj = localIntent;
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler.sendMessageDelayed((Message)localObject, this.jdField_c_of_type_Long);
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
    return this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService$Stub;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if ((QLog.isColorLevel()) && (jdField_d_of_type_Boolean) && (paramInt < 100))
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
    d(8);
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
      this.jdField_a_of_type_JavaLangObject = new QQPlayerService.1(this);
    }
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerBroadcastReceiverReceiver = new QQPlayerService.QQPlayerBroadcastReceiverReceiver(this);
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler.post(new QQPlayerService.2(this));
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$NetInfoHandler = new QQPlayerService.NetInfoHandler();
    AppNetConnInfo.registerConnectionChangeReceiver(MobileQQ.getContext(), this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$NetInfoHandler);
    jdField_a_of_type_ComTencentMobileqqMusicQQPlayerLifecycleCallbacks.a(this);
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQPlayerService", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler != null)
    {
      localObject = new QQPlayerService.ReleaseObject(null);
      ((QQPlayerService.ReleaseObject)localObject).jdField_a_of_type_AndroidMediaMediaPlayer = jdField_a_of_type_AndroidMediaMediaPlayer;
      ((QQPlayerService.ReleaseObject)localObject).jdField_a_of_type_AndroidOsLooper = this.jdField_a_of_type_AndroidOsLooper;
      ((QQPlayerService.ReleaseObject)localObject).jdField_a_of_type_ComTencentMobileqqMusicSongInfo = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
      localObject = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler.obtainMessage(1, localObject);
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler.sendMessage((Message)localObject);
    }
    jdField_a_of_type_ComTencentMobileqqMusicQQPlayerLifecycleCallbacks.b(this);
    jdField_a_of_type_JavaLangString = null;
    jdField_f_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
    jdField_a_of_type_AndroidContentIntent = null;
    jdField_a_of_type_AndroidOsBundle = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    Object localObject = this.jdField_a_of_type_AndroidOsRemoteCallbackList;
    if (localObject != null)
    {
      ((RemoteCallbackList)localObject).kill();
      this.jdField_a_of_type_AndroidOsRemoteCallbackList = null;
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    } else if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "Android 2.1 and below can not stop music");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$NetInfoHandler;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
    l();
    this.jdField_e_of_type_Boolean = true;
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
      paramMediaPlayer = jdField_a_of_type_AndroidMediaMediaPlayer;
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      c();
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    d();
    try
    {
      d(5);
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
    paramMediaPlayer = jdField_a_of_type_AndroidMediaMediaPlayer;
    if (paramMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "player is null while invoking method onPrepared");
      }
      stopSelf();
      return;
    }
    jdField_f_of_type_Int = paramMediaPlayer.getDuration();
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("onPrepared:sDuration");
      paramMediaPlayer.append(jdField_f_of_type_Int);
      QLog.d("QQPlayerService", 2, paramMediaPlayer.toString());
    }
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
    if ((paramMediaPlayer != null) && (paramMediaPlayer.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString)))
    {
      i = jdField_f_of_type_Int;
      if (i != 0)
      {
        double d1 = i;
        Double.isNaN(d1);
        this.jdField_c_of_type_Long = ((d1 * 0.01D));
      }
      if (QLog.isColorLevel())
      {
        paramMediaPlayer = new StringBuilder();
        paramMediaPlayer.append("onPrepared:loopProgressDelayTime:");
        paramMediaPlayer.append(this.jdField_c_of_type_Long);
        QLog.d("QQPlayerService", 2, paramMediaPlayer.toString());
      }
      a();
    }
    if (!VersionUtils.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "onPrepared Android 2.1 and below can not stop music");
      }
      return;
    }
    paramMediaPlayer = (AudioManager)getSystemService("audio");
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = (AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject;
    boolean bool = true;
    int i = paramMediaPlayer.requestAudioFocus(localOnAudioFocusChangeListener, 3, 1);
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("requestAudioFocus,result:");
      if (i != 1) {
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
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler.obtainMessage();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramIntent != null) {
      if (paramIntent.getBooleanExtra("key_add_to_color_note", true)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    jdField_f_of_type_Boolean = bool1;
    localMessage.obj = paramIntent;
    paramIntent = this.jdField_a_of_type_AndroidOsHandlerThread;
    if ((paramIntent == null) || (paramIntent.isAlive()) || (this.jdField_a_of_type_AndroidOsLooper != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidOsLooper.quit();
      label97:
      b();
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$ServiceHandler.sendMessage(localMessage);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService
 * JD-Core Version:    0.7.0.1
 */