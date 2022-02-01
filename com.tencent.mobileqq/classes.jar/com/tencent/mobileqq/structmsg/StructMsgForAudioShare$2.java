package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.onlinestatus.music.OnlineMusicStatusManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AccountNotMatchException;

class StructMsgForAudioShare$2
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  StructMsgForAudioShare$2(StructMsgForAudioShare paramStructMsgForAudioShare) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    Resources localResources = paramView.getContext().getResources();
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = l;
      if ((paramView.getTag() instanceof AbsShareMsg)) {
        break label54;
      }
    }
    label54:
    AbsShareMsg localAbsShareMsg;
    Context localContext;
    Object localObject2;
    Object localObject1;
    SongInfo localSongInfo;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localAbsShareMsg = (AbsShareMsg)paramView.getTag();
      localContext = paramView.getContext();
      localObject2 = null;
      try
      {
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(localAbsShareMsg.currentAccountUin);
        if (localObject1 != null) {
          MediaPlayerManager.a((QQAppInterface)localObject1).a(true);
        }
        if ((localAbsShareMsg == null) || (localAbsShareMsg.mMsgServiceID != 2)) {
          break label629;
        }
        localObject2 = (StructMsgForAudioShare)localAbsShareMsg;
        if (QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare))
        {
          QQPlayerService.c(localContext);
          paramView.setContentDescription(localResources.getString(2131690294));
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isDevelopLevel())
          {
            QLog.d("StructMsg", 4, localAccountNotMatchException.getStackTrace().toString());
            localObject1 = localObject2;
          }
        }
        if ((localObject1 != null) && (((QQAppInterface)localObject1).isVideoChatting()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQPlayerService", 2, "Video Chatting is going on, don't play music.");
          }
        }
        else
        {
          OnlineMusicStatusManager.a().a = 1;
          localSongInfo = new SongInfo();
          localSongInfo.jdField_b_of_type_JavaLangString = ((StructMsgForAudioShare)localObject2).mContentSrc;
          localSongInfo.c = ((StructMsgForAudioShare)localObject2).mContentTitle;
          localSongInfo.d = ((StructMsgForAudioShare)localObject2).mContentSummary;
          localSongInfo.e = ((StructMsgForAudioShare)localObject2).mContentCover;
          localSongInfo.f = ((StructMsgForAudioShare)localObject2).mMsgUrl;
          if ("com.tencent.radio".equals(localAbsShareMsg.mSource_A_ActionData)) {
            break label323;
          }
        }
      }
    }
    label323:
    int i;
    if (("1103394134".equals(Long.valueOf(localAbsShareMsg.mSourceAppid))) || ("企鹅FM".equals(localAbsShareMsg.mSourceName)))
    {
      localSongInfo.jdField_b_of_type_Int = 6;
      i = 0;
      j = 1;
    }
    for (;;)
    {
      Intent localIntent = new Intent(localContext, MusicPlayerActivity.class);
      if (((j != 0) || (i != 0)) && ("web".equals(localAbsShareMsg.mMsgAction)))
      {
        localIntent.putExtra("key_isReadModeEnabled", true);
        localObject2 = localAbsShareMsg.mMsgUrl;
        localObject1 = localObject2;
        if (j != 0) {
          localObject1 = (String)localObject2 + "&player=mqq";
        }
        localIntent.putExtra("url", (String)localObject1);
        localIntent.putExtra("param_force_internal_browser", true);
        localIntent.putExtra("isAppShare", true);
        localIntent.putExtra("appShareID", AppShareIDUtil.a(localAbsShareMsg.mSourceAppid));
        localIntent.putExtra("fromAio", true);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, localAbsShareMsg.mMsgUrl);
      }
      QQPlayerService.a(localIntent);
      localObject2 = QQPlayerService.a();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new Bundle();
        QQPlayerService.a((Bundle)localObject1);
      }
      ((Bundle)localObject1).putString("KEY_SOURCE_NAME", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.getSourceName());
      QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare);
      QQPlayerService.a(localContext, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.getToken(), localSongInfo);
      paramView.setContentDescription(localResources.getString(2131690292));
      break;
      if (("com.tencent.qqmusic".equals(localAbsShareMsg.mSource_A_ActionData)) || ("100497308".equals(Long.valueOf(localAbsShareMsg.mSourceAppid))) || ("QQ音乐".equals(localAbsShareMsg.mSourceName)))
      {
        localSongInfo.jdField_b_of_type_Int = 4;
        i = 1;
        continue;
        label629:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQPlayerService", 2, "msg is null or serviceId not audio_share");
        break;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForAudioShare.2
 * JD-Core Version:    0.7.0.1
 */