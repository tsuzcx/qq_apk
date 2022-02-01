package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import mqq.os.MqqHandler;

final class EmoticonUtils$1
  implements QueryCallback<EmoticonPackage>
{
  EmoticonUtils$1(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, int paramInt, Activity paramActivity) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (this.val$sessionInfo.a != 1008) && (this.val$sessionInfo.a != 1000) && (this.val$sessionInfo.a != 1001) && (this.val$sessionInfo.a != 10002) && (this.val$sessionInfo.a != 10004) && (this.val$sessionInfo.a != 1002) && (this.val$sessionInfo.a != 1003) && (this.val$sessionInfo.a != 1004) && (this.val$sessionInfo.a != 1005) && (this.val$sessionInfo.a != 1006))
    {
      paramEmoticonPackage = this.val$app.getHandler(ChatActivity.class);
      if (paramEmoticonPackage != null) {
        paramEmoticonPackage.obtainMessage(22, String.valueOf(this.val$touchedEpIdFinal)).sendToTarget();
      }
      ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8006FFE", 0, 0, String.valueOf(this.val$touchedEpIdFinal), String.valueOf(this.val$touchedEpIdFinal), "", "");
      return;
    }
    EmojiHomeUiPlugin.openEmojiDetailPage(this.val$context, this.val$app.getAccount(), 8, String.valueOf(this.val$touchedEpIdFinal), false, true);
    ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8006FFF", 0, 0, String.valueOf(this.val$touchedEpIdFinal), String.valueOf(this.val$touchedEpIdFinal), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonUtils.1
 * JD-Core Version:    0.7.0.1
 */