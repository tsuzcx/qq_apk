package com.tencent.timi.game.liveroom.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView;
import com.tencent.timi.game.api.live.ILiveModuleStatusListener;
import com.tencent.timi.game.router.IService;

public abstract interface IAnchorRoomService
  extends IService
{
  public abstract void a();
  
  public abstract void a(@NonNull Context paramContext, long paramLong);
  
  public abstract void a(@NonNull Context paramContext, boolean paramBoolean);
  
  public abstract BaseGameLiveAudienceView b(@NonNull Context paramContext);
  
  public abstract ILiveModuleStatusListener b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.api.IAnchorRoomService
 * JD-Core Version:    0.7.0.1
 */