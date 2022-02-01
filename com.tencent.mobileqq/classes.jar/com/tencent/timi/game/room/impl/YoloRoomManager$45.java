package com.tencent.timi.game.room.impl;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.DoubleCheckListener;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.scheme.tools.smoba.SmobaSchemeUtil;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaOneSchema;

class YoloRoomManager$45
  implements RoomGameDoubleCheckDialog.DoubleCheckListener
{
  YoloRoomManager$45(YoloRoomManager paramYoloRoomManager, YoloBattleSmobaOuterClass.YoloSmobaOneSchema paramYoloSmobaOneSchema) {}
  
  public void a()
  {
    Logger.a("YoloRoomManager", "notifyLaunchGame# DoubleCheckDialog - onLaunchGame ");
    YoloRoomUtil.a(this.b.u(), this.b.A());
    YoloRoomManager.b("DoubleCheckDialog - onLaunchGam");
    SmobaSchemeUtil.a(this.a.schema.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.45
 * JD-Core Version:    0.7.0.1
 */