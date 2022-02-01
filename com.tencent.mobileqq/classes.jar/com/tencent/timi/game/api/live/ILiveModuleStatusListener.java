package com.tencent.timi.game.api.live;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/api/live/ILiveModuleStatusListener;", "", "onAudiencePageOnCreate", "", "roomId", "", "onAudiencePageOnDestroy", "onAudiencePageOnStart", "onAudiencePageOnStop", "onAudiencePageVisibleToUser", "isVisibleToUser", "", "timi-game-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ILiveModuleStatusListener
{
  public abstract void a();
  
  public abstract void a(long paramLong);
  
  public abstract void a(boolean paramBoolean, long paramLong);
  
  public abstract void b();
  
  public abstract void b(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.live.ILiveModuleStatusListener
 * JD-Core Version:    0.7.0.1
 */