package com.tencent.mobileqq.emoticonview;

import admh;
import android.content.Context;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import asih;
import awrh;
import awrn;
import awsf;
import awsw;
import awzc;
import bdla;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class PicEmoticonInfo$3
  implements awzc<EmoticonPackage>
{
  PicEmoticonInfo$3(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, asih paramasih, SessionInfo paramSessionInfo, EmojiStickerManager.StickerInfo paramStickerInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if ((paramEmoticonPackage != null) && ((2 != paramEmoticonPackage.status) || (!paramEmoticonPackage.valid))) {
      if (paramEmoticonPackage.jobType == 4)
      {
        bool = true;
        EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity)this.val$context).getActivity(), this.val$app.getAccount(), 8, this.val$emoticon.epId, false, bool);
        bdla.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if (!this.val$pcm.c()) {
        break label483;
      }
      if (this.val$pcm.a(this.val$emoticon.epId, Boolean.valueOf(false))) {
        break label170;
      }
      ChatActivityUtils.a(this.val$context, 2131689959, 0);
      paramEmoticonPackage = this.val$app.getHandler(ChatActivity.class);
    } while (paramEmoticonPackage == null);
    paramEmoticonPackage.obtainMessage(10).sendToTarget();
    paramEmoticonPackage.obtainMessage(21).sendToTarget();
    return;
    label170:
    Object localObject = awsf.a(this.val$emoticon, 0);
    if ((localObject != null) && (((awrn)localObject).a))
    {
      if (awsw.a())
      {
        ((FragmentActivity)this.val$context).getChatFragment().a().playMaigcface(this.val$emoticon, 0, null, false);
        ((FragmentActivity)this.val$context).getChatFragment().a().getMagicfaceViewController().a(this.val$emoticon);
        return;
      }
      this.val$emoticon.magicValue = "value=1";
    }
    do
    {
      PicEmoticonInfo.access$000(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon, this.val$stickerInfo);
      return;
      int j = awrh.a(awsf.a(this.val$emoticon, 0));
      int i = 0;
      if (paramEmoticonPackage != null) {
        i = paramEmoticonPackage.rscType;
      }
      paramEmoticonPackage = "rscType?" + i + ";value=" + j;
      this.val$emoticon.magicValue = paramEmoticonPackage;
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + this.val$emoticon.magicValue);
      }
      if ((localObject != null) && (!((awrn)localObject).c))
      {
        admh.a(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon);
        bdla.b(this.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.val$emoticon.epId, "", "", "");
        return;
      }
      localObject = ((FragmentActivity)this.val$context).getChatFragment();
    } while (localObject == null);
    ((ChatFragment)localObject).a().getMagicfaceViewController().a(this.val$emoticon, new PicEmoticonInfo.3.1(this, paramEmoticonPackage));
    return;
    label483:
    ChatActivityUtils.a(this.val$context, 2131689975);
    bdla.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.3
 * JD-Core Version:    0.7.0.1
 */