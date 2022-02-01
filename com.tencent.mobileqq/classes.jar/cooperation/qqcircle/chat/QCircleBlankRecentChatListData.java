package cooperation.qqcircle.chat;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

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
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.chat.QCircleBlankRecentChatListData
 * JD-Core Version:    0.7.0.1
 */