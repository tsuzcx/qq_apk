package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class PicEmoticonInfoSender$2
  implements QueryCallback<EmoticonPackage>
{
  PicEmoticonInfoSender$2(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Emoticon paramEmoticon, IEmojiManagerService paramIEmojiManagerService, BaseSessionInfo paramBaseSessionInfo, StickerInfo paramStickerInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    int i = 0;
    if ((paramEmoticonPackage != null) && ((2 != paramEmoticonPackage.status) || (!paramEmoticonPackage.valid)))
    {
      boolean bool;
      if (paramEmoticonPackage.jobType == 4) {
        bool = true;
      } else {
        bool = false;
      }
      ((IEmosmService)QRoute.api(IEmosmService.class)).openEmojiDetailPage(this.val$context, this.val$app.getAccount(), 8, this.val$emoticon.epId, false, bool);
      ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
      return;
    }
    if (this.val$pcm.getMagicFaceSendAccessControl())
    {
      if (!this.val$pcm.isMagicFacePackageIntact(this.val$emoticon.epId, Boolean.valueOf(false)))
      {
        EmotionUtils.a(this.val$context, 2131689916, 0);
        paramEmoticonPackage = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.val$app);
        if (paramEmoticonPackage != null)
        {
          paramEmoticonPackage.obtainMessage(10).sendToTarget();
          paramEmoticonPackage.obtainMessage(21).sendToTarget();
        }
        return;
      }
      ActionGlobalData localActionGlobalData = ((IEmosmService)QRoute.api(IEmosmService.class)).hasAction(this.val$emoticon, 0);
      if ((localActionGlobalData != null) && (localActionGlobalData.a))
      {
        if (((IEmosmService)QRoute.api(IEmosmService.class)).isSupportMagicface())
        {
          ((IEmosmService)QRoute.api(IEmosmService.class)).setPicEmoticonTag(this.val$context, this.val$emoticon);
          return;
        }
        this.val$emoticon.magicValue = "value=1";
      }
      else
      {
        int j = PngFrameUtil.a(((IEmosmService)QRoute.api(IEmosmService.class)).getRandomMaxValue(this.val$emoticon, 0));
        if (paramEmoticonPackage != null) {
          i = paramEmoticonPackage.rscType;
        }
        paramEmoticonPackage = new StringBuilder();
        paramEmoticonPackage.append("rscType?");
        paramEmoticonPackage.append(i);
        paramEmoticonPackage.append(";value=");
        paramEmoticonPackage.append(j);
        paramEmoticonPackage = paramEmoticonPackage.toString();
        this.val$emoticon.magicValue = paramEmoticonPackage;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("before play,magicvalue:");
          localStringBuilder.append(this.val$emoticon.magicValue);
          QLog.d("PicEmoticonInfoSender", 2, localStringBuilder.toString());
        }
        if ((localActionGlobalData != null) && (!localActionGlobalData.c))
        {
          ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmosmMsg(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon);
          ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.val$emoticon.epId, "", "", "");
          return;
        }
        if (((IEmosmService)QRoute.api(IEmosmService.class)).magicfaceAutoPlay(this.val$context, this.val$emoticon, new PicEmoticonInfoSender.2.1(this, paramEmoticonPackage))) {
          return;
        }
      }
      PicEmoticonInfoSender.access$000(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon, this.val$stickerInfo);
      return;
    }
    EmotionUtils.a(this.val$context, 2131689932);
    ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.2
 * JD-Core Version:    0.7.0.1
 */