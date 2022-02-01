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
    MusicInfo localMusicInfo = (MusicInfo)QQMusicPlayService.a();
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
    if (((ListenTogetherManager)localObject2).a() != null)
    {
      if (((ListenTogetherManager)localObject2).a().f == 1) {
        i = 3;
      } else {
        i = 2;
      }
      if (localObject1 != null) {
        ((IOnlineMusicStatusManager)localObject1).a(i);
      }
    }
    localObject2 = new OnlineMusicStatus();
    ((OnlineMusicStatus)localObject2).jdField_a_of_type_Boolean = true;
    ((OnlineMusicStatus)localObject2).jdField_a_of_type_JavaLangString = localMusicInfo.jdField_a_of_type_JavaLangString;
    ((OnlineMusicStatus)localObject2).jdField_b_of_type_JavaLangString = localMusicInfo.jdField_b_of_type_JavaLangString;
    ((OnlineMusicStatus)localObject2).jdField_a_of_type_Int = 1;
    List localList = localMusicInfo.jdField_a_of_type_JavaUtilList;
    int i = 0;
    if ((localList != null) && (!localMusicInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
      ((OnlineMusicStatus)localObject2).jdField_c_of_type_JavaLangString = ((String)localMusicInfo.jdField_a_of_type_JavaUtilList.get(0));
    }
    ((OnlineMusicStatus)localObject2).jdField_b_of_type_Int = (j - k);
    if (localObject1 != null) {
      i = ((IOnlineMusicStatusManager)localObject1).a();
    }
    ((OnlineMusicStatus)localObject2).jdField_c_of_type_Int = i;
    ((OnlineMusicStatus)localObject2).jdField_b_of_type_Boolean = paramBoolean;
    ((OnlineMusicStatus)localObject2).d = QQMusicPlayService.a();
    return localObject2;
  }
  
  public OnlineMusicStatus buildFromSongInfo(boolean paramBoolean)
  {
    int j = QQPlayerService.d();
    int k = QQPlayerService.f();
    Object localObject = QQPlayerService.b();
    if (localObject == null) {
      return null;
    }
    OnlineMusicStatus localOnlineMusicStatus = new OnlineMusicStatus();
    int i = 0;
    localOnlineMusicStatus.jdField_a_of_type_Boolean = false;
    localOnlineMusicStatus.jdField_a_of_type_JavaLangString = ((SongInfo)localObject).jdField_a_of_type_JavaLangString;
    if ((TextUtils.isEmpty(((SongInfo)localObject).jdField_a_of_type_JavaLangString)) || (((SongInfo)localObject).jdField_a_of_type_JavaLangString.equals("0")))
    {
      localOnlineMusicStatus.jdField_a_of_type_JavaLangString = getSongMid(((SongInfo)localObject).f);
      if (TextUtils.isEmpty(localOnlineMusicStatus.jdField_a_of_type_JavaLangString))
      {
        QLog.d("OnlineMusicStatusApiImpl", 1, "pushMusicStatus, songMid is null");
        return null;
      }
    }
    localOnlineMusicStatus.jdField_b_of_type_JavaLangString = ((SongInfo)localObject).jdField_c_of_type_JavaLangString;
    localOnlineMusicStatus.jdField_a_of_type_Int = 1;
    if (TextUtils.isEmpty(((SongInfo)localObject).h)) {
      localObject = ((SongInfo)localObject).d;
    } else {
      localObject = ((SongInfo)localObject).h;
    }
    localOnlineMusicStatus.jdField_c_of_type_JavaLangString = ((String)localObject);
    if (localOnlineMusicStatus.jdField_c_of_type_JavaLangString == null) {
      localOnlineMusicStatus.jdField_c_of_type_JavaLangString = "";
    }
    localOnlineMusicStatus.jdField_b_of_type_Int = (j - k);
    localObject = (IOnlineMusicStatusManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class);
    if (localObject != null) {
      i = ((IOnlineMusicStatusManager)localObject).a();
    }
    localOnlineMusicStatus.jdField_c_of_type_Int = i;
    localOnlineMusicStatus.jdField_b_of_type_Boolean = paramBoolean;
    localOnlineMusicStatus.d = QQPlayerService.d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.api.impl.OnlineMusicStatusApiImpl
 * JD-Core Version:    0.7.0.1
 */