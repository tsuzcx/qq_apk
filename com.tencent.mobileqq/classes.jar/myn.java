import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GameStatusInfo;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;
import trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListRsp;
import trpc.qq_vgame.game_ranking.AvGameRanking.UserScoreInfo;

public class myn
{
  static HashMap<Integer, Class<? extends mzm>> a = new HashMap(5);
  
  static
  {
    a.put(Integer.valueOf(1), mzn.class);
    a.put(Integer.valueOf(2), mzp.class);
    a.put(Integer.valueOf(3), mzq.class);
    a.put(Integer.valueOf(4), mzr.class);
    a.put(Integer.valueOf(5), mzs.class);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 2;
    }
    if ((paramInt >= 3) && (paramInt <= 102)) {
      return 3;
    }
    if ((paramInt >= 103) && (paramInt <= 202)) {
      return 2;
    }
    if ((paramInt >= 300) && (paramInt <= 399)) {
      return 5;
    }
    if ((paramInt >= 400) && (paramInt <= 499)) {
      return 4;
    }
    return 0;
  }
  
  @Nullable
  public static RoomInfo a(AvGameCommon.RoomInfo paramRoomInfo)
  {
    RoomInfo localRoomInfo = null;
    if (paramRoomInfo != null)
    {
      localRoomInfo = new RoomInfo();
      localRoomInfo.parseFrom(paramRoomInfo);
    }
    return localRoomInfo;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "NT_ROOM_ENTER";
    case 2: 
      return "NT_ROOM_LEAVE";
    case 3: 
      return "NT_ROOM_DESTORY";
    case 4: 
      return "NT_ROOM_USER_CHANGE_STATUS";
    case 101: 
      return "NT_GAME_CHANGE";
    case 102: 
      return "NT_GAME_START";
    case 103: 
      return "NT_ANSWER_RIGHT";
    case 104: 
      return "NT_TOPIC_TIMEOUT";
    case 105: 
      return "NT_TOPIC_CHANGE";
    case 106: 
      return "NT_NEXT_ACTOR_TIPS";
    case 107: 
      return "NT_ACTOR_CHANGE";
    case 108: 
      return "NT_ACTOR_GIVEOUT_ANSWER";
    }
    return "NT_TRANSLATE_INFO";
  }
  
  public static <F, S> String a(List<Pair<F, S>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      localStringBuilder.append("\n").append("[").append(localPair.first).append(",").append(localPair.second).append("]");
    }
    return localStringBuilder.toString();
  }
  
  @NotNull
  public static List<UserScore> a(AvGameRanking.GetRankingListRsp paramGetRankingListRsp)
  {
    ArrayList localArrayList = new ArrayList();
    paramGetRankingListRsp = paramGetRankingListRsp.ranking_list.get();
    if ((paramGetRankingListRsp != null) && (paramGetRankingListRsp.size() > 0))
    {
      int i = 0;
      while (i < paramGetRankingListRsp.size())
      {
        UserScore localUserScore = new UserScore();
        localUserScore.parseFrom((AvGameRanking.UserScoreInfo)paramGetRankingListRsp.get(i));
        localArrayList.add(localUserScore);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  @Nullable
  public static myo a(AvGameCommon.GameStatusInfo paramGameStatusInfo)
  {
    if (paramGameStatusInfo == null) {
      return null;
    }
    try
    {
      mzf localmzf = new mzf();
      try
      {
        localmzf.a(paramGameStatusInfo);
        return localmzf;
      }
      catch (Exception localException1)
      {
        paramGameStatusInfo = localmzf;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramGameStatusInfo = null;
      }
    }
    QLog.d("avgame_logic.GamePlayHandler", 1, new Object[] { "getGame ex=", localException1.getMessage(), localException1 });
    return paramGameStatusInfo;
  }
  
  public static myp a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo, boolean paramBoolean)
  {
    if (paramGameQuestionInfo == null) {
      paramGameQuestionInfo = null;
    }
    Object localObject;
    do
    {
      return paramGameQuestionInfo;
      int i = a(paramGameQuestionInfo.type.get());
      localObject = (Class)a.get(Integer.valueOf(i));
      if (localObject == null) {
        return null;
      }
      localObject = (myp)((Class)localObject).newInstance();
      ((myp)localObject).a(paramBoolean);
      ((myp)localObject).a(paramGameQuestionInfo);
      paramGameQuestionInfo = (AvGameCommon.GameQuestionInfo)localObject;
    } while (!QLog.isColorLevel());
    QLog.i("avgame_logic.GameUtil", 2, String.format("parseTopic {\n%s\n}", new Object[] { localObject }));
    return localObject;
  }
  
  public static void a(String paramString1, String paramString2, String[] paramArrayOfString, MessageMicro... paramVarArgs)
  {
    new StringBuilder(1024);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static boolean a(mzj parammzj)
  {
    if ((parammzj.a == 2) || (parammzj.a == 300) || (parammzj.a == 400)) {}
    int i;
    do
    {
      return false;
      i = a(parammzj.a);
    } while ((i != 3) && (i != 5) && (i != 4) && (i != 2));
    return true;
  }
  
  @Nullable
  public static myp b(AvGameCommon.GameQuestionInfo paramGameQuestionInfo, boolean paramBoolean)
  {
    try
    {
      paramGameQuestionInfo = a(paramGameQuestionInfo, paramBoolean);
      return paramGameQuestionInfo;
    }
    catch (InstantiationException paramGameQuestionInfo)
    {
      QLog.d("avgame_logic.GamePlayHandler", 1, new Object[] { "getTopic ex=", paramGameQuestionInfo.getMessage(), paramGameQuestionInfo });
      return null;
    }
    catch (IllegalAccessException paramGameQuestionInfo)
    {
      QLog.d("avgame_logic.GamePlayHandler", 1, new Object[] { "getTopic ex=", paramGameQuestionInfo.getMessage(), paramGameQuestionInfo });
      return null;
    }
    catch (Exception paramGameQuestionInfo)
    {
      QLog.d("avgame_logic.GamePlayHandler", 1, new Object[] { "getTopic ex=", paramGameQuestionInfo.getMessage(), paramGameQuestionInfo });
    }
    return null;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4);
  }
  
  public static boolean b(mzj parammzj)
  {
    boolean bool = true;
    if (parammzj == null) {
      return false;
    }
    if ((a(parammzj)) && (parammzj.b == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == 3;
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myn
 * JD-Core Version:    0.7.0.1
 */