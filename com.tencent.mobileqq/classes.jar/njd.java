import java.util.Map;

public class njd
{
  public static final String[] a = { "qqvgame.RoomManager-RoomInfoGet", "qqvgame.GameManager-SelectGame", "qqvgame.GameList-GetGameList", "qqvgame.RoomManager-RoomLeave", "qqvgame.RoomManager-RoomUserStatusChange", "qqvgame.UserHeartBeat-UserHeartBeat", "qqvgame.Share-GetShareLink", "qqvgame.GameList-GetQuestionClass", "qqvgame.ActivityCenter-GetActivitys", "qqvgame.ActivityCenter-SyncShareGame", "qqvgame.StrangerMatch-AddMatchRoom", "qqvgame.StrangerMatch-DelMatchRoom" };
  public static final String[] b = { "qqvgame.GameManager-StartGame", "qqvgame.QuestionManager-GetQuestion", "qqvgame.GameRanking-GetRankingList", "qqvgame.QuestionManager-AnswerQuestion" };
  public static final String[] c = { "OnlinePush.ReqPush" };
  public static final String[] d = { "OidbSvc.0x5eb_20002" };
  
  public static void a(Map<String, int[]> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      String[] arrayOfString = b;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramMap.put(arrayOfString[i], new int[] { 3 });
        i += 1;
      }
      arrayOfString = a;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        paramMap.put(arrayOfString[i], new int[] { 1 });
        i += 1;
      }
      arrayOfString = c;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        paramMap.put(arrayOfString[i], new int[] { 4 });
        i += 1;
      }
      arrayOfString = d;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        paramMap.put(arrayOfString[i], new int[] { 2 });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njd
 * JD-Core Version:    0.7.0.1
 */