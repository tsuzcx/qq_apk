package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Message;
import android.os.Parcelable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class PicEmoticonInfoSender$3
  implements QueryCallback<EmoticonPackage>
{
  PicEmoticonInfoSender$3(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Emoticon paramEmoticon, IEmojiManagerService paramIEmojiManagerService, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
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
      if (this.val$pcm.isH5MagicFacePackageIntact(this.val$emoticon.epId, true, true))
      {
        if (this.val$pcm.isDPCSupportH5Magic())
        {
          PicEmoticonInfoSender.access$100(this.val$context, this.val$app, (Parcelable)this.val$sessionInfo, this.val$emoticon);
          ReportController.b(this.val$app, "CliOper", "", "", "MbFasong", "MbZidongBofang", 0, 0, "", "", "", "");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfoSender", 2, "not support h5magic ");
        }
        return;
      }
      EmotionUtils.a(this.val$context, 2131689916, 0);
      paramEmoticonPackage = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.val$app);
      if (paramEmoticonPackage != null)
      {
        paramEmoticonPackage.obtainMessage(10).sendToTarget();
        paramEmoticonPackage.obtainMessage(21).sendToTarget();
      }
      return;
    }
    EmotionUtils.a(this.val$context, 2131689932);
    ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.3
 * JD-Core Version:    0.7.0.1
 */