package com.tencent.timi.game.liveroom.impl;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView;
import com.tencent.timi.game.api.live.ILiveModuleStatusListener;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.liveroom.api.IAnchorRoomService;
import com.tencent.timi.game.liveroom.impl.report.TGReportAudienceParamsManager;
import com.tencent.timi.game.liveroom.impl.report.TGReportAudienceParamsManager.Companion;
import com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment;

public class AnchorRoomService
  implements IAnchorRoomService
{
  public void a()
  {
    Intent localIntent = new Intent();
    QPublicFragmentActivityForTool.a(TimiGameActivityManager.a(), localIntent, TgLiveRoomTestFragment.class);
  }
  
  public void a(Context paramContext) {}
  
  public void a(@NonNull Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("roomId", paramLong);
    QPublicFragmentActivityForTool.a(paramContext, localIntent, TimiAudienceFragment.class);
  }
  
  public void a(@NonNull Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isStartLive", paramBoolean);
    QPublicFragmentActivityForTool.a(paramContext, localIntent, TimiAnchorFragment.class);
  }
  
  public BaseGameLiveAudienceView b(@NonNull Context paramContext)
  {
    return new TimiAudienceView(paramContext);
  }
  
  public ILiveModuleStatusListener b()
  {
    return LiveModuleStatusListenerImpl.a;
  }
  
  public void g()
  {
    TGReportAudienceParamsManager.a.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.AnchorRoomService
 * JD-Core Version:    0.7.0.1
 */