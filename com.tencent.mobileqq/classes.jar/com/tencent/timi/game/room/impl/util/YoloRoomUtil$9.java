package com.tencent.timi.game.room.impl.util;

import android.app.Activity;
import com.tencent.timi.game.room.api.RoomInterceptCheckParam;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.smoba.api.SmobaCheckCallback;
import com.tencent.timi.game.smoba.api.SmobaGangupCheckParam;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;

final class YoloRoomUtil$9
  implements IResultListener<IUserInfo>
{
  YoloRoomUtil$9(Activity paramActivity, RoomInterceptCheckParam paramRoomInterceptCheckParam, SmobaCheckCallback paramSmobaCheckCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    ISmobaService localISmobaService = (ISmobaService)ServiceCenter.a(ISmobaService.class);
    Activity localActivity = this.a;
    if (this.b.a) {
      paramString = SmobaGangupCheckParam.a(1);
    } else {
      paramString = SmobaGangupCheckParam.a(1, this.b.e, this.b.f, this.b.g, this.b.h);
    }
    localISmobaService.a(localActivity, paramString, false, this.c);
  }
  
  public void a(IUserInfo paramIUserInfo)
  {
    ISmobaService localISmobaService = (ISmobaService)ServiceCenter.a(ISmobaService.class);
    Activity localActivity = this.a;
    if (this.b.a) {
      paramIUserInfo = SmobaGangupCheckParam.a(1);
    } else {
      paramIUserInfo = SmobaGangupCheckParam.a(1, this.b.e, this.b.f, this.b.g, this.b.h);
    }
    localISmobaService.a(localActivity, paramIUserInfo, false, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.9
 * JD-Core Version:    0.7.0.1
 */