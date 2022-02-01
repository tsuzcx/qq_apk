package com.tencent.timi.game.mic.api;

import com.tencent.timi.game.router.IService;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/mic/api/IMicService;", "Lcom/tencent/timi/game/router/IService;", "checkMicPermission", "", "checkMicPermissionCallback", "Lcom/tencent/timi/game/mic/api/CheckMicPermissionCallback;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IMicService
  extends IService
{
  public abstract void a(@Nullable CheckMicPermissionCallback paramCheckMicPermissionCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.mic.api.IMicService
 * JD-Core Version:    0.7.0.1
 */