package com.tencent.timi.game.liveroom.impl;

import android.content.Context;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.liveroom.impl.floating.TGLiveFloatManager;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$10
  implements IResultListener<LiveInfo>
{
  TimiAudienceView$10(TimiAudienceView paramTimiAudienceView, long paramLong, LiveRoomExtraInfo paramLiveRoomExtraInfo, Context paramContext) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageIn audienceEnterRoom onError ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString);
    Logger.c("TimiAudienceView", localStringBuilder.toString());
    if (paramInt == 1004)
    {
      ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).a(this.a, null);
      CustomToastView.a("管理员设置限制，无法进入房间");
      return;
    }
    CustomToastView.a("进入房间失败");
  }
  
  public void a(LiveInfo paramLiveInfo)
  {
    Logger.a("TimiAudienceView", "enter room success");
    if (!TimiAudienceView.a(this.d, paramLiveInfo))
    {
      TGReportUtil.a.a(false, this.a, this.b);
      TimiAudienceView.a(this.d, this.a);
      TGLiveFloatManager.a.a(false, this.a);
    }
    else
    {
      Logger.a("TimiAudienceView", "the room was closed");
      TimiAudienceView.b(this.d, true);
      paramLiveInfo = this.d;
      TimiAudienceView.a(paramLiveInfo, TimiAudienceView.i(paramLiveInfo).e(this.a));
      TimiAudienceView.c(this.d);
    }
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this.c, this.d, "pg_qqlive_audience", TGReportUtil.a.a(this.a, this.b));
    paramLiveInfo = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.a);
    VideoReport.setPageContentId(paramLiveInfo, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.10
 * JD-Core Version:    0.7.0.1
 */