package cooperation.qqcircle.chat;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class QCircleBlankRecentChatListData
  extends RecentBaseData
{
  public long getLastDraftTime()
  {
    return 0L;
  }
  
  public long getLastMsgTime()
  {
    return 0L;
  }
  
  public int getRecentUserType()
  {
    return 0;
  }
  
  public String getRecentUserUin()
  {
    return null;
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.chat.QCircleBlankRecentChatListData
 * JD-Core Version:    0.7.0.1
 */