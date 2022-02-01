package com.tencent.timi.game.room.impl.util;

import com.tencent.timi.game.float_window.BusFloatManager;
import com.tencent.timi.game.float_window.BusFloatManager.Companion;
import com.tencent.timi.game.float_window.IFloatViewCreator;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

public class YoloRoomFloatViewUtil
{
  private static HashMap<Integer, IFloatViewCreator> a = new YoloRoomFloatViewUtil.1();
  
  public static void a(long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hideFloatingView - ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
    localObject = BusFloatManager.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    ((BusFloatManager)localObject).a(localStringBuilder.toString());
  }
  
  public static void a(long paramLong, int paramInt, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    paramYoloRoomInfo = new StringBuilder();
    paramYoloRoomInfo.append("showFloatingView - ");
    paramYoloRoomInfo.append(paramLong);
    paramYoloRoomInfo.append("_");
    paramYoloRoomInfo.append(paramInt);
    Logger.a("YoloRoomUtil", paramYoloRoomInfo.toString());
    if (paramInt != 5)
    {
      paramYoloRoomInfo = BusFloatManager.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      paramYoloRoomInfo.a(localStringBuilder.toString(), (IFloatViewCreator)a.get(Integer.valueOf(paramInt)));
    }
  }
  
  private static IFloatViewCreator b(int paramInt)
  {
    return new YoloRoomFloatViewUtil.2(paramInt);
  }
  
  public static void b(long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitFloatingView - ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
    localObject = BusFloatManager.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    ((BusFloatManager)localObject).b(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomFloatViewUtil
 * JD-Core Version:    0.7.0.1
 */