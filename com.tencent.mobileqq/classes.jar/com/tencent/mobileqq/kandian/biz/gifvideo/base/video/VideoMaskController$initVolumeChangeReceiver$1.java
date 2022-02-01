package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoMaskController$initVolumeChangeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoMaskController$initVolumeChangeReceiver$1
  extends BroadcastReceiver
{
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    if (paramContext != null)
    {
      String str = this.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceive], volume change, action = ");
      if (paramIntent != null) {
        paramIntent = paramIntent.getAction();
      } else {
        paramIntent = null;
      }
      localStringBuilder.append(paramIntent);
      QLog.i(str, 1, localStringBuilder.toString());
      paramIntent = ReadInJoyUtils.b();
      if (paramIntent != null)
      {
        if (RIJAppSetting.f((QQAppInterface)paramIntent))
        {
          QLog.i(this.a.a(), 1, "[onReceive] app is in background, do not change volume.");
          return;
        }
        boolean bool = VideoAudioControlUtil.a.a(paramContext);
        if (bool) {
          this.a.c().setImageResource(2130844081);
        } else {
          this.a.c().setImageResource(2130844080);
        }
        VideoMaskController.b(this.a).setMute(bool ^ true);
        VideoAudioControlUtil.a.a(bool ^ true, "ADJUST_VOLUME");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoMaskController.initVolumeChangeReceiver.1
 * JD-Core Version:    0.7.0.1
 */