package com.tencent.timi.game.expand.hall.impl.mic;

import com.tencent.timi.game.mic.api.CheckMicPermissionCallback;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/mic/OnMicOptCallback;", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "Lcom/tencent/timi/game/mic/api/CheckMicPermissionCallback;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface OnMicOptCallback
  extends CheckMicPermissionCallback, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.OnMicOptCallback
 * JD-Core Version:    0.7.0.1
 */