import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class rzq
{
  public static rzo a(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    if (paramWSRedDotPushMsg == null) {}
    do
    {
      return null;
      if (paramWSRedDotPushMsg.mStrategyInfo != null) {}
      for (int i = paramWSRedDotPushMsg.mStrategyInfo.getType(); (paramInt == 2) && (i == 1); i = 0) {
        return new rzr(paramWSRedDotPushMsg);
      }
      if (i == 2) {
        return new rzs(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 3) {
        return new rzt(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 4) {
        return new rzp(paramWSRedDotPushMsg, paramInt);
      }
      if (paramInt == 2) {
        return new rzr(paramWSRedDotPushMsg);
      }
    } while (paramInt != 6);
    return new rzs(paramWSRedDotPushMsg, paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzq
 * JD-Core Version:    0.7.0.1
 */