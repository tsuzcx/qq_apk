package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import bgve;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.PublishEventTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class QzoneMoodPlugin$1
  implements Runnable
{
  QzoneMoodPlugin$1(QzoneMoodPlugin paramQzoneMoodPlugin, ArrayList paramArrayList1, String paramString1, int paramInt, Activity paramActivity, String paramString2, ArrayList paramArrayList2, PublishEventTag paramPublishEventTag) {}
  
  public void run()
  {
    Object localObject2;
    if ((this.val$finalAtFriendList != null) && (!this.val$finalAtFriendList.isEmpty()))
    {
      if (QzoneMoodPlugin.access$000().isEmpty()) {
        QzoneMoodPlugin.access$100(this.this$0);
      }
      localObject1 = QzoneMoodPlugin.access$000().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (QzoneMoodPlugin.FriendNickNames)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((QzoneMoodPlugin.FriendNickNames)localObject2).mainUin == null) || (((QzoneMoodPlugin.FriendNickNames)localObject2).nickNamesMap == null) || (!((QzoneMoodPlugin.FriendNickNames)localObject2).mainUin.equalsIgnoreCase(this.val$loginUin)));
    }
    for (Object localObject1 = ((QzoneMoodPlugin.FriendNickNames)localObject2).nickNamesMap;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = this.val$finalAtFriendList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
          String str = (String)((HashMap)localObject1).get(localResultRecord.uin);
          if (!TextUtils.isEmpty(str)) {
            localResultRecord.name = str;
          }
        }
      }
      if (this.val$eventSource == 1)
      {
        QZoneHelper.forwardToWriteEventShuoShuo(this.val$activity, this.this$0.parentPlugin.mRuntime.a().getCurrentAccountUin(), this.val$finalSummery, this.val$pics, this.val$finalAtFriendList, this.val$finalEventTag, -1);
        return;
      }
      QZoneHelper.forwardToWriteMood(this.val$activity, this.this$0.parentPlugin.mRuntime.a().getCurrentAccountUin(), this.val$finalSummery, this.val$pics, this.val$finalAtFriendList, this.val$finalEventTag, -1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneMoodPlugin.1
 * JD-Core Version:    0.7.0.1
 */