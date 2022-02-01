package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
    Object localObject1 = this.val$finalAtFriendList;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      if (QzoneMoodPlugin.access$000().isEmpty()) {
        QzoneMoodPlugin.access$100(this.this$0);
      }
      Iterator localIterator = null;
      Object localObject2 = QzoneMoodPlugin.access$000().iterator();
      do
      {
        localObject1 = localIterator;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (QzoneMoodPlugin.FriendNickNames)((Iterator)localObject2).next();
      } while ((localObject1 == null) || (((QzoneMoodPlugin.FriendNickNames)localObject1).mainUin == null) || (((QzoneMoodPlugin.FriendNickNames)localObject1).nickNamesMap == null) || (!((QzoneMoodPlugin.FriendNickNames)localObject1).mainUin.equalsIgnoreCase(this.val$loginUin)));
      localObject1 = ((QzoneMoodPlugin.FriendNickNames)localObject1).nickNamesMap;
      if (localObject1 != null)
      {
        localIterator = this.val$finalAtFriendList.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (ResultRecord)localIterator.next();
          String str = (String)((HashMap)localObject1).get(((ResultRecord)localObject2).uin);
          if (!TextUtils.isEmpty(str)) {
            ((ResultRecord)localObject2).name = str;
          }
        }
      }
    }
    if (this.val$eventSource == 1)
    {
      QZoneHelper.forwardToWriteEventShuoShuo(this.val$activity, this.this$0.parentPlugin.mRuntime.a().getCurrentAccountUin(), this.val$finalSummery, this.val$pics, this.val$finalAtFriendList, this.val$finalEventTag, -1);
      return;
    }
    QZoneHelper.forwardToWriteMood(this.val$activity, this.this$0.parentPlugin.mRuntime.a().getCurrentAccountUin(), this.val$finalSummery, this.val$pics, this.val$finalAtFriendList, this.val$finalEventTag, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneMoodPlugin.1
 * JD-Core Version:    0.7.0.1
 */