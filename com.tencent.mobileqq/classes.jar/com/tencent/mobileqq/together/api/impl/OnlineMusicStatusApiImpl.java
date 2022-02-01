package com.tencent.mobileqq.together.api.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.OnlineMusicStatus;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.together.api.IOnlineMusicStatusApi;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class OnlineMusicStatusApiImpl
  implements IOnlineMusicStatusApi
{
  public static final String TAG = "OnlineMusicStatusApiImpl";
  
  public OnlineMusicStatus buildFromMusicInfo(boolean paramBoolean)
  {
    MusicInfo localMusicInfo = (MusicInfo)QQMusicPlayService.f();
    int j = QQMusicPlayService.a();
    int k = QQMusicPlayService.b();
    if (localMusicInfo == null) {
      return null;
    }
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(localObject1 instanceof QQAppInterface)) {
      return null;
    }
    localObject1 = (QQAppInterface)localObject1;
    Object localObject2 = (ListenTogetherManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
    localObject1 = (IOnlineMusicStatusManager)((IOnlineStatusManagerService)((QQAppInterface)localObject1).getRuntimeService(IOnlineStatusManagerService.class)).getManager(IOnlineMusicStatusManager.class);
    if (((ListenTogetherManager)localObject2).g() != null)
    {
      if (((ListenTogetherManager)localObject2).g().m == 1) {
        i = 3;
      } else {
        i = 2;
      }
      if (localObject1 != null) {
        ((IOnlineMusicStatusManager)localObject1).a(i);
      }
    }
    localObject2 = new OnlineMusicStatus();
    ((OnlineMusicStatus)localObject2).a = true;
    ((OnlineMusicStatus)localObject2).b = localMusicInfo.a;
    ((OnlineMusicStatus)localObject2).c = localMusicInfo.b;
    ((OnlineMusicStatus)localObject2).d = 1;
    List localList = localMusicInfo.d;
    int i = 0;
    if ((localList != null) && (!localMusicInfo.d.isEmpty())) {
      ((OnlineMusicStatus)localObject2).e = ((String)localMusicInfo.d.get(0));
    }
    ((OnlineMusicStatus)localObject2).f = (j - k);
    if (localObject1 != null) {
      i = ((IOnlineMusicStatusManager)localObject1).a();
    }
    ((OnlineMusicStatus)localObject2).g = i;
    ((OnlineMusicStatus)localObject2).h = paramBoolean;
    ((OnlineMusicStatus)localObject2).i = QQMusicPlayService.a();
    return localObject2;
  }
  
  public OnlineMusicStatus buildFromSongInfo(boolean paramBoolean)
  {
    int j = QQPlayerService.i();
    int k = QQPlayerService.k();
    Object localObject = QQPlayerService.g();
    if (localObject == null) {
      return null;
    }
    OnlineMusicStatus localOnlineMusicStatus = new OnlineMusicStatus();
    int i = 0;
    localOnlineMusicStatus.a = false;
    localOnlineMusicStatus.b = ((SongInfo)localObject).b;
    if ((TextUtils.isEmpty(((SongInfo)localObject).b)) || (((SongInfo)localObject).b.equals("0")))
    {
      localOnlineMusicStatus.b = getSongMid(((SongInfo)localObject).h);
      if (TextUtils.isEmpty(localOnlineMusicStatus.b))
      {
        QLog.d("OnlineMusicStatusApiImpl", 1, "pushMusicStatus, songMid is null");
        return null;
      }
    }
    localOnlineMusicStatus.c = ((SongInfo)localObject).e;
    localOnlineMusicStatus.d = 1;
    if (TextUtils.isEmpty(((SongInfo)localObject).j)) {
      localObject = ((SongInfo)localObject).f;
    } else {
      localObject = ((SongInfo)localObject).j;
    }
    localOnlineMusicStatus.e = ((String)localObject);
    if (localOnlineMusicStatus.e == null) {
      localOnlineMusicStatus.e = "";
    }
    localOnlineMusicStatus.f = (j - k);
    localObject = (IOnlineMusicStatusManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class);
    if (localObject != null) {
      i = ((IOnlineMusicStatusManager)localObject).a();
    }
    localOnlineMusicStatus.g = i;
    localOnlineMusicStatus.h = paramBoolean;
    localOnlineMusicStatus.i = QQPlayerService.i();
    return localOnlineMusicStatus;
  }
  
  public String getSongMid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = redirectShortUrl(paramString);
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString.toString()).getQueryParameter("songmid");
  }
  
  public URL redirectShortUrl(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setInstanceFollowRedirects(false);
      paramString.setRequestProperty("Accept-Encoding", "identity");
      paramString.connect();
      if (paramString.getResponseCode() == 302)
      {
        paramString = new URL(paramString.getHeaderField("Location"));
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.d("OnlineMusicStatusApiImpl", 1, "redirectShortUrl, ", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.api.impl.OnlineMusicStatusApiImpl
 * JD-Core Version:    0.7.0.1
 */