package com.tencent.timi.game.expand.hall.impl.mic;

import com.tencent.timi.game.mic.api.CheckMicPermissionCallback;
import com.tencent.timi.game.mic.api.IMicService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/mic/MicOperationUtil;", "", "()V", "TAG", "", "doOnMic", "", "micPos", "", "roomId", "", "listener", "Lcom/tencent/timi/game/expand/hall/impl/mic/OnMicOptCallback;", "onMicInner", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MicOperationUtil
{
  public static final MicOperationUtil a = new MicOperationUtil();
  
  private final void a(long paramLong, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    IRoomAudioService localIRoomAudioService = ((IRoomService)ServiceCenter.a(IRoomService.class)).d(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(localIRoomAudioService, "ServiceCenter.getService…ass.java).audioOp(roomId)");
    boolean bool = localIRoomAudioService.a();
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(paramLong).a(bool, 0, false, paramIResultListener);
  }
  
  public final void a(int paramInt, long paramLong, @NotNull OnMicOptCallback paramOnMicOptCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramOnMicOptCallback, "listener");
    ((IMicService)ServiceCenter.a(IMicService.class)).a((CheckMicPermissionCallback)new MicOperationUtil.doOnMic.1(paramOnMicOptCallback, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.MicOperationUtil
 * JD-Core Version:    0.7.0.1
 */