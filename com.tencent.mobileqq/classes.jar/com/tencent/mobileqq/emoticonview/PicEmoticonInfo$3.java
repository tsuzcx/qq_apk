package com.tencent.mobileqq.emoticonview;

import acvv;
import android.content.Context;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import areb;
import avlc;
import avli;
import avma;
import avmr;
import avtb;
import bcef;
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
  implements avtb<EmoticonPackage>
{
  PicEmoticonInfo$3(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, areb paramareb, SessionInfo paramSessionInfo, EmojiStickerManager.StickerInfo paramStickerInfo) {}
  
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
      ChatActivityUtils.a(this.val$context, 2131689930, 0);
      paramEmoticonPackage = this.val$app.getHandler(ChatActivity.class);
    } while (paramEmoticonPackage == null);
    paramEmoticonPackage.obtainMessage(10).sendToTarget();
    paramEmoticonPackage.obtainMessage(21).sendToTarget();
    return;
    label170:
    Object localObject = avma.a(this.val$emoticon, 0);
    if ((localObject != null) && (((avli)localObject).a))
    {
      if (avmr.a())
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
      int j = avlc.a(avma.a(this.val$emoticon, 0));
      int i = 0;
      if (paramEmoticonPackage != null) {
        i = paramEmoticonPackage.rscType;
      }
      paramEmoticonPackage = "rscType?" + i + ";value=" + j;
      this.val$emoticon.magicValue = paramEmoticonPackage;
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + this.val$emoticon.magicValue);
      }
      if ((localObject != null) && (!((avli)localObject).c))
      {
        acvv.a(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon);
        bcef.b(this.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.val$emoticon.epId, "", "", "");
        return;
      }
      localObject = ((FragmentActivity)this.val$context).getChatFragment();
    } while (localObject == null);
    ((ChatFragment)localObject).a().getMagicfaceViewController().a(this.val$emoticon, new PicEmoticonInfo.3.1(this, paramEmoticonPackage));
    return;
    label483:
    ChatActivityUtils.a(this.val$context, 2131689946);
    bcef.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.3
 * JD-Core Version:    0.7.0.1
 */