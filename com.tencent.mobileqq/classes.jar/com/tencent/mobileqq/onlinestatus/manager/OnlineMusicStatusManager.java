package com.tencent.mobileqq.onlinestatus.manager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.onlinestatus.OnlineMusicStatus;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.api.IOnlineMusicStatusApi;
import com.tencent.mobileqq.together.api.IQQPlayerServiceApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.statsvc.song.StatSvcStatSong.SongInfo;

public class OnlineMusicStatusManager
  implements Handler.Callback, IOnlineMusicStatusManager
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QQPlayerCallback jdField_a_of_type_ComTencentMobileqqMusicQQPlayerCallback = new OnlineMusicStatusManager.1(this);
  public ConcurrentHashMap<String, Lyric> a;
  public CopyOnWriteArrayList a;
  
  public OnlineMusicStatusManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(null);
  }
  
  public static String a(AppRuntime paramAppRuntime, Friends paramFriends, TextView paramTextView)
  {
    paramAppRuntime = paramAppRuntime.getApp().getResources();
    if ((!TextUtils.isEmpty(paramFriends.songName)) && (System.currentTimeMillis() < paramFriends.songEndTime))
    {
      if (!TextUtils.isEmpty(paramFriends.singerName)) {
        paramAppRuntime = String.format(paramAppRuntime.getString(2131698498), new Object[] { paramFriends.songName, paramFriends.singerName });
      } else {
        paramAppRuntime = String.format(paramAppRuntime.getString(2131698499), new Object[] { paramFriends.songName });
      }
      if ((paramTextView instanceof OnlineStatusLyricView))
      {
        ((OnlineStatusHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(OnlineStatusHandler.class.getName())).a(paramFriends);
        ((OnlineStatusLyricView)paramTextView).setFriendSession(paramFriends, paramAppRuntime);
      }
      else
      {
        paramAppRuntime = OnlineStatusUtil.a(paramTextView.getPaint(), paramAppRuntime, ViewUtils.a(200.0F));
      }
      ReportController.b(null, "dc00898", "", "", "0X800AC92", "0X800AC92", paramFriends.songSourceType, 0, "", "0", "0", "");
      return paramAppRuntime;
    }
    return paramAppRuntime.getString(2131698500);
  }
  
  public static void a(Friends paramFriends)
  {
    paramFriends.songId = "";
    paramFriends.songName = "";
    paramFriends.singerName = "";
    paramFriends.songEndTime = 0L;
    paramFriends.songSourceType = 0;
    paramFriends.songPauseRemainTime = 0;
    paramFriends.songDuration = 0;
  }
  
  public static void a(Friends paramFriends, byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        StatSvcStatSong.SongInfo localSongInfo = new StatSvcStatSong.SongInfo();
        localSongInfo.mergeFrom(paramArrayOfByte);
        paramFriends.songId = localSongInfo.bytes_song_id.get().toStringUtf8();
        boolean bool = ((OnlineMusicStatusManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class)).jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramFriends.songId);
        if (bool)
        {
          a(paramFriends);
          QLog.d("OnlineMusicStatusManager", 1, new Object[] { "update onlineSongState from ", paramString, " safeHit true" });
          return;
        }
        paramFriends.songName = localSongInfo.bytes_song_name.get().toStringUtf8();
        paramFriends.singerName = localSongInfo.bytes_singer_name.get().toStringUtf8();
        paramFriends.songEndTime = localSongInfo.uint64_end_time.get();
        paramFriends.songSourceType = localSongInfo.uint32_source_type.get();
        paramFriends.songPauseRemainTime = localSongInfo.uint32_pause_remaining_time.get();
        paramFriends.songDuration = localSongInfo.uint32_song_play_time.get();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineMusicStatusManager", 2, new Object[] { "update onlineSongState from ", paramString, ", uin:", StringUtil.e(paramFriends.uin), " songId:", paramFriends.songId, " songName:", paramFriends.songName, " songEndTime:", Long.valueOf(paramFriends.songEndTime), " source:", Integer.valueOf(paramFriends.songSourceType), " pauseRemain:", Integer.valueOf(paramFriends.songPauseRemainTime), " duration:", Integer.valueOf(paramFriends.songDuration), " remainTime:", Long.valueOf(paramFriends.songEndTime - System.currentTimeMillis()) });
        }
      }
      else
      {
        a(paramFriends);
        return;
      }
    }
    catch (Exception paramFriends)
    {
      QLog.d("OnlineMusicStatusManager", 1, "parseFriendMusicInfo fail", paramFriends);
    }
  }
  
  public static boolean a()
  {
    return MobileQQ.sMobileQQ.getSharedPreferences("online_music_status", 0).getBoolean("has_set_online_music", false);
  }
  
  public static void b()
  {
    MobileQQ.sMobileQQ.getSharedPreferences("online_music_status", 0).edit().putBoolean("has_set_online_music", true).apply();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Lyric a(String paramString)
  {
    return (Lyric)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public QQPlayerCallback a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerCallback;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QLog.d("OnlineMusicStatusManager", 1, new Object[] { "handleOnlineStatusChanged, ", Long.valueOf(paramLong1), "->", Long.valueOf(paramLong2) });
    if ((paramLong1 == 1028L) && (paramLong2 != 1028L))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    if ((paramLong1 != 1028L) && (paramLong2 == 1028L))
    {
      if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isListeningTogether())
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
        return;
      }
      if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isQQPlayServicePlaying())
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 3000L);
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      paramString = String.format("https://i.y.qq.com/v8/playsong.html?_mylisten=1&songmid=%s&ADTAG=sqwztg&channelId=10039001", new Object[] { paramString });
      Intent localIntent = new Intent();
      localIntent.putExtra("url", paramString);
      RouteUtils.a(paramActivity, localIntent, "/base/browser");
      ReportController.b(null, "dc00898", "", "", "0X800ABB2", "0X800ABB2", 0, 0, "", "0", "0", "");
      return;
    }
    QLog.d("OnlineMusicStatusManager", 1, "openH5 fail");
  }
  
  public void a(Handler paramHandler)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler = paramHandler;
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void b(int paramInt)
  {
    if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isStatePlaying(paramInt))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
      return;
    }
    if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isStateCompletion(paramInt))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      return;
    }
    if ((!((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isStateError(paramInt)) && (!((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isStateStop(paramInt)))
    {
      if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isStatePause(paramInt))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 1, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isStateStop(paramInt)) {
        this.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      OnlineStatusHandler localOnlineStatusHandler;
      IOnlineMusicStatusApi localIOnlineMusicStatusApi;
      boolean bool;
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
        localOnlineStatusHandler = (OnlineStatusHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(OnlineStatusHandler.class.getName());
        localIOnlineMusicStatusApi = (IOnlineMusicStatusApi)QRoute.api(IOnlineMusicStatusApi.class);
        if (paramMessage.arg1 == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramMessage = localIOnlineMusicStatusApi.buildFromSongInfo(bool);
        localOnlineStatusHandler.a(paramMessage);
        if (paramMessage != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramMessage.b);
          return false;
        }
      }
      else
      {
        localOnlineStatusHandler = (OnlineStatusHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(OnlineStatusHandler.class.getName());
        localIOnlineMusicStatusApi = (IOnlineMusicStatusApi)QRoute.api(IOnlineMusicStatusApi.class);
        if (paramMessage.arg1 == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramMessage = localIOnlineMusicStatusApi.buildFromMusicInfo(bool);
        localOnlineStatusHandler.a(paramMessage);
        if (paramMessage != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramMessage.b);
          return false;
        }
      }
    }
    else
    {
      ((OnlineStatusHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(OnlineStatusHandler.class.getName())).a(null);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager
 * JD-Core Version:    0.7.0.1
 */