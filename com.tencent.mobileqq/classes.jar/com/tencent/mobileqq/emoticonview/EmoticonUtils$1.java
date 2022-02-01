package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.os.Message;
import awzc;
import bdla;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import mqq.os.MqqHandler;

final class EmoticonUtils$1
  implements awzc<EmoticonPackage>
{
  EmoticonUtils$1(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, int paramInt, Activity paramActivity) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (this.val$sessionInfo.curType != 1008) && (this.val$sessionInfo.curType != 1000) && (this.val$sessionInfo.curType != 1001) && (this.val$sessionInfo.curType != 10002) && (this.val$sessionInfo.curType != 10004) && (this.val$sessionInfo.curType != 1002) && (this.val$sessionInfo.curType != 1003) && (this.val$sessionInfo.curType != 1004) && (this.val$sessionInfo.curType != 1005) && (this.val$sessionInfo.curType != 1006))
    {
      paramEmoticonPackage = this.val$app.getHandler(ChatActivity.class);
      if (paramEmoticonPackage != null) {
        paramEmoticonPackage.obtainMessage(22, String.valueOf(this.val$touchedEpIdFinal)).sendToTarget();
      }
      bdla.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8006FFE", 0, 0, String.valueOf(this.val$touchedEpIdFinal), String.valueOf(this.val$touchedEpIdFinal), "", "");
      return;
    }
    EmojiHomeUiPlugin.openEmojiDetailPage(this.val$context, this.val$app.getAccount(), 8, String.valueOf(this.val$touchedEpIdFinal), false, true);
    bdla.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8006FFF", 0, 0, String.valueOf(this.val$touchedEpIdFinal), String.valueOf(this.val$touchedEpIdFinal), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonUtils.1
 * JD-Core Version:    0.7.0.1
 */