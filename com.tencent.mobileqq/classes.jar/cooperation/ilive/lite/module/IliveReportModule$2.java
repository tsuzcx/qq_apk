package cooperation.ilive.lite.module;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent.PlayerState;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.ilive.lite.IliveMetricsReportUtil;
import cooperation.ilive.lite.heart.IliveRoomHeartController;

class IliveReportModule$2
  implements Observer<PlayerStateEvent>
{
  IliveReportModule$2(IliveReportModule paramIliveReportModule) {}
  
  public void a(@Nullable PlayerStateEvent paramPlayerStateEvent)
  {
    if (paramPlayerStateEvent != null)
    {
      if (paramPlayerStateEvent.playerState == null) {
        return;
      }
      IliveReportModule.b(this.a).a(paramPlayerStateEvent.playerState);
      IliveReportModule.b(this.a).a(false, IliveReportModule.a(this.a));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PlayerStateEvent = ");
      localStringBuilder.append(paramPlayerStateEvent.playerState.toString());
      localStringBuilder.append(" code = ");
      localStringBuilder.append(paramPlayerStateEvent.errCode);
      localStringBuilder.append(" roomId = ");
      localStringBuilder.append(IliveReportModule.a(this.a));
      localStringBuilder.append(" mIsFirstFrame = ");
      localStringBuilder.append(IliveReportModule.c(this.a));
      localStringBuilder.append(" mIsRtmpStop = ");
      localStringBuilder.append(IliveReportModule.d(this.a));
      localStringBuilder.append(" mAnchorNickName = ");
      localStringBuilder.append(IliveReportModule.e(this.a));
      QLog.e("IliveReportModule", 1, localStringBuilder.toString());
      if ((IliveReportModule.f(this.a)) && (!IliveReportModule.d(this.a)) && (paramPlayerStateEvent.playerState == PlayerStateEvent.PlayerState.PLAY_ERROR) && (!IliveReportModule.c(this.a)))
      {
        IliveLiteMonitorUtil.a(IliveReportModule.a(this.a));
        paramPlayerStateEvent = new StringBuilder();
        paramPlayerStateEvent.append(String.valueOf(IliveReportModule.a(this.a)));
        paramPlayerStateEvent.append("_");
        paramPlayerStateEvent.append(IliveReportModule.e(this.a));
        IliveMetricsReportUtil.a(paramPlayerStateEvent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.2
 * JD-Core Version:    0.7.0.1
 */