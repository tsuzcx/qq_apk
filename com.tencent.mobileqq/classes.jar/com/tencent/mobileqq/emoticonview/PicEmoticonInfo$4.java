package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.os.Message;
import areb;
import avtb;
import bcef;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class PicEmoticonInfo$4
  implements avtb<EmoticonPackage>
{
  PicEmoticonInfo$4(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, areb paramareb, SessionInfo paramSessionInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if ((paramEmoticonPackage != null) && ((2 != paramEmoticonPackage.status) || (!paramEmoticonPackage.valid))) {
      if (paramEmoticonPackage.jobType == 4)
      {
        bool = true;
        EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity)this.val$context).getActivity(), this.val$app.getAccount(), 8, this.val$emoticon.epId, false, bool);
        bcef.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
      }
    }
    label194:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (!this.val$pcm.c()) {
          break label237;
        }
        if (!this.val$pcm.b(this.val$emoticon.epId, true, true)) {
          break label194;
        }
        if (this.val$pcm.b())
        {
          PicEmoticonInfo.access$100(this.val$context, this.val$app, this.val$sessionInfo, this.val$emoticon);
          bcef.b(this.val$app, "CliOper", "", "", "MbFasong", "MbZidongBofang", 0, 0, "", "", "", "");
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PicEmoticonInfo", 2, "not support h5magic ");
      return;
      ChatActivityUtils.a(this.val$context, 2131689930, 0);
      paramEmoticonPackage = this.val$app.getHandler(ChatActivity.class);
    } while (paramEmoticonPackage == null);
    paramEmoticonPackage.obtainMessage(10).sendToTarget();
    paramEmoticonPackage.obtainMessage(21).sendToTarget();
    return;
    label237:
    ChatActivityUtils.a(this.val$context, 2131689946);
    bcef.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.4
 * JD-Core Version:    0.7.0.1
 */