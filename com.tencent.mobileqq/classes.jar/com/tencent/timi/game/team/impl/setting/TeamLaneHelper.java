package com.tencent.timi.game.team.impl.setting;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.room.api.IRoomCommonConf;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

public class TeamLaneHelper
{
  private static final long a = ((IRoomService)ServiceCenter.a(IRoomService.class)).c().b() * 1000L;
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "";
              }
              return "游走";
            }
            return "打野";
          }
          return "发育";
        }
        return "中路";
      }
      return "对抗";
    }
    return "不限";
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "";
              }
              return "游走";
            }
            return "打野";
          }
          return "发育路";
        }
        return "中路";
      }
      return "对抗路";
    }
    if (paramBoolean) {
      return "选择分路";
    }
    return "未选择分路";
  }
  
  public static List<Pair<Integer, String>> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair(Integer.valueOf(1), "对抗路"));
    localArrayList.add(new Pair(Integer.valueOf(2), "中路"));
    localArrayList.add(new Pair(Integer.valueOf(3), "发育路"));
    localArrayList.add(new Pair(Integer.valueOf(4), "打野"));
    localArrayList.add(new Pair(Integer.valueOf(5), "游走"));
    return localArrayList;
  }
  
  public static void a(int paramInt, CommonOuterClass.QQUserId paramQQUserId)
  {
    a(paramInt, paramQQUserId, null);
  }
  
  public static void a(int paramInt, CommonOuterClass.QQUserId paramQQUserId, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(1);
    if ((localYoloRoomInfo != null) && (localYoloRoomInfo.tim_group_id.has()) && (localYoloRoomInfo.room_id.has()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("chooseHeroLane groupId == ");
      localStringBuilder.append(localYoloRoomInfo.tim_group_id.get());
      Logger.a("TeamLaneHelper", localStringBuilder.toString());
      ((IRoomService)ServiceCenter.a(IRoomService.class)).b(localYoloRoomInfo.room_id.get()).a(paramInt, new TeamLaneHelper.1(localYoloRoomInfo, paramQQUserId, paramInt, paramIResultListener));
    }
  }
  
  public static String b(int paramInt)
  {
    return "我玩".concat(a(paramInt, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.setting.TeamLaneHelper
 * JD-Core Version:    0.7.0.1
 */