package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.qphone.base.util.QLog;

class PicEmoticonInfoSender$5
  implements QueryCallback<EmoticonPackage>
{
  PicEmoticonInfoSender$5(PicEmoticonInfoSender paramPicEmoticonInfoSender, Emoticon paramEmoticon, QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    int i = PngFrameUtil.a(this.val$emoticon.magicValue);
    if ((-1 != i) && (paramEmoticonPackage != null))
    {
      paramEmoticonPackage.rscType = i;
      ((EmoticonManager)this.val$app.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticonPackage);
    }
    paramEmoticonPackage = "rscType?" + i + ";value=" + this.val$random;
    this.val$emoticon.magicValue = paramEmoticonPackage;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfoSender", 2, "before play,magicvalue:" + paramEmoticonPackage);
    }
    ActionGlobalData localActionGlobalData = MagicfaceActionManager.a(this.val$emoticon, 0);
    if ((localActionGlobalData != null) && (!localActionGlobalData.c))
    {
      ChatActivityFacade.a(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon);
      return;
    }
    ((FragmentActivity)this.val$context).getChatFragment().a().a().a(this.val$emoticon, new PicEmoticonInfoSender.5.1(this, paramEmoticonPackage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.5
 * JD-Core Version:    0.7.0.1
 */