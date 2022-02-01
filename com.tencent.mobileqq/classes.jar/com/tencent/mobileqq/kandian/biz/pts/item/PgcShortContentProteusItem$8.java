package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;

class PgcShortContentProteusItem$8
  extends BroadcastReceiver
{
  PgcShortContentProteusItem$8(PgcShortContentProteusItem paramPgcShortContentProteusItem, VideoView paramVideoView, ViewBean paramViewBean, ViewBase paramViewBase) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool;
    if (((AudioManager)paramContext.getSystemService("audio")).getStreamVolume(3) <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.a.setMute(bool);
    paramIntent = this.b;
    if (bool) {
      paramContext = "video_audio_mute";
    } else {
      paramContext = "video_audio_speak";
    }
    paramIntent.putMapValue("pgc_video_content_audio_icon", paramContext);
    this.c.bindDynamicValue(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.8
 * JD-Core Version:    0.7.0.1
 */