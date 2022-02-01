package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class PicEmoticonInfoSender$2
  implements QueryCallback<EmoticonPackage>
{
  PicEmoticonInfoSender$2(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, EmojiManager paramEmojiManager, SessionInfo paramSessionInfo, EmojiStickerManager.StickerInfo paramStickerInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if ((paramEmoticonPackage != null) && ((2 != paramEmoticonPackage.status) || (!paramEmoticonPackage.valid))) {
      if (paramEmoticonPackage.jobType == 4)
      {
        bool = true;
        EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity)this.val$context).getActivity(), this.val$app.getAccount(), 8, this.val$emoticon.epId, false, bool);
        ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
      }
    }
    label170:
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            bool = false;
            break;
            if (!this.val$pcm.c()) {
              break label500;
            }
            if (this.val$pcm.a(this.val$emoticon.epId, Boolean.valueOf(false))) {
              break label170;
            }
            ChatActivityUtils.a(this.val$context, 2131690001, 0);
            paramEmoticonPackage = this.val$app.getHandler(ChatActivity.class);
          } while (paramEmoticonPackage == null);
          paramEmoticonPackage.obtainMessage(10).sendToTarget();
          paramEmoticonPackage.obtainMessage(21).sendToTarget();
          return;
          localObject = MagicfaceActionManager.a(this.val$emoticon, 0);
          if ((localObject == null) || (!((ActionGlobalData)localObject).a)) {
            break label296;
          }
          if (!MagicfaceViewController.a()) {
            break label263;
          }
          paramEmoticonPackage = ((FragmentActivity)this.val$context).getChatFragment();
        } while (paramEmoticonPackage == null);
        paramEmoticonPackage = paramEmoticonPackage.a();
      } while (paramEmoticonPackage == null);
      localObject = (AIOEmoticonUIHelper)paramEmoticonPackage.a(105);
    } while (localObject == null);
    ((AIOEmoticonUIHelper)localObject).a(this.val$emoticon, 0, null, false);
    paramEmoticonPackage.a().a(this.val$emoticon);
    return;
    label263:
    this.val$emoticon.magicValue = "value=1";
    label296:
    do
    {
      PicEmoticonInfoSender.access$000(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon, this.val$stickerInfo);
      return;
      int j = PngFrameUtil.a(MagicfaceActionManager.a(this.val$emoticon, 0));
      int i = 0;
      if (paramEmoticonPackage != null) {
        i = paramEmoticonPackage.rscType;
      }
      paramEmoticonPackage = "rscType?" + i + ";value=" + j;
      this.val$emoticon.magicValue = paramEmoticonPackage;
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfoSender", 2, "before play,magicvalue:" + this.val$emoticon.magicValue);
      }
      if ((localObject != null) && (!((ActionGlobalData)localObject).c))
      {
        ChatActivityFacade.a(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon);
        ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.val$emoticon.epId, "", "", "");
        return;
      }
      localObject = ((FragmentActivity)this.val$context).getChatFragment();
    } while (localObject == null);
    ((ChatFragment)localObject).a().a().a(this.val$emoticon, new PicEmoticonInfoSender.2.1(this, paramEmoticonPackage));
    return;
    label500:
    ChatActivityUtils.a(this.val$context, 2131690017);
    ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.2
 * JD-Core Version:    0.7.0.1
 */