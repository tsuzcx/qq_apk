package com.tencent.timi.game.room.impl.tgpa;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.tgpa.TGPAUtil;
import com.tencent.timi.game.tgpa.TGPAUtil.TGPAGameDataCallback;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaUserGameData;
import trpc.yes.common.YoloRoomOuterClass.YoloUserGameData;

public class YoloRoomTGPALogic
{
  TGPAUtil.TGPAGameDataCallback a = new YoloRoomTGPALogic.1(this);
  private String b;
  private String c;
  private float d;
  private float e;
  
  public YoloRoomTGPALogic()
  {
    Logger.a("YoloRoomTGPALogic", "YoloRoomTGPALogic ");
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ensureStartTgpaService - ");
    localStringBuilder.append(paramString);
    Logger.a("YoloRoomTGPALogic", localStringBuilder.toString());
    TGPAUtil.a(Env.a(), true);
  }
  
  private static YoloRoomOuterClass.YoloUserGameData b(int paramInt1, int paramInt2)
  {
    YoloRoomOuterClass.YoloSmobaUserGameData localYoloSmobaUserGameData = new YoloRoomOuterClass.YoloSmobaUserGameData();
    if (paramInt1 >= 0) {
      localYoloSmobaUserGameData.update_status.set(paramInt1);
    }
    if (paramInt2 >= 0) {
      localYoloSmobaUserGameData.update_process.set(paramInt2);
    }
    YoloRoomOuterClass.YoloUserGameData localYoloUserGameData = new YoloRoomOuterClass.YoloUserGameData();
    localYoloUserGameData.user_smoba_game_data.set(localYoloSmobaUserGameData);
    return localYoloUserGameData;
  }
  
  private void d()
  {
    Logger.a("YoloRoomTGPALogic", "notifyServerUpdateTGPASmobaVersion");
  }
  
  public void a()
  {
    Logger.a("YoloRoomTGPALogic", "onEnterRoom");
    TGPAUtil.a();
    TGPAUtil.a(Env.a(), true);
    TGPAUtil.a(this.a);
  }
  
  public void b()
  {
    Logger.a("YoloRoomTGPALogic", "onExitRoom");
    TGPAUtil.a(Env.a());
    TGPAUtil.b(this.a);
  }
  
  public void c()
  {
    Logger.a("YoloRoomTGPALogic", "destroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic
 * JD-Core Version:    0.7.0.1
 */