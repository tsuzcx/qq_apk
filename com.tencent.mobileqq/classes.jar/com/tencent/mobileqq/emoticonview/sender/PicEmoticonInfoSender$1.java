package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class PicEmoticonInfoSender$1
  implements QueryCallback<EmoticonPackage>
{
  PicEmoticonInfoSender$1(Emoticon paramEmoticon, BaseQQAppInterface paramBaseQQAppInterface, int paramInt, Context paramContext, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    int i = PngFrameUtil.a(this.val$emoticon.magicValue);
    if ((-1 != i) && (paramEmoticonPackage != null))
    {
      paramEmoticonPackage.rscType = i;
      ((IEmoticonManagerService)this.val$app.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPackage(paramEmoticonPackage);
    }
    paramEmoticonPackage = new StringBuilder();
    paramEmoticonPackage.append("rscType?");
    paramEmoticonPackage.append(i);
    paramEmoticonPackage.append(";value=");
    paramEmoticonPackage.append(this.val$random);
    paramEmoticonPackage = paramEmoticonPackage.toString();
    this.val$emoticon.magicValue = paramEmoticonPackage;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("before play,magicvalue:");
      ((StringBuilder)localObject).append(paramEmoticonPackage);
      QLog.d("PicEmoticonInfoSender", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((IEmosmService)QRoute.api(IEmosmService.class)).hasAction(this.val$emoticon, 0);
    if ((localObject != null) && (!((ActionGlobalData)localObject).c))
    {
      ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmosmMsg(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon);
      return;
    }
    ((IEmosmService)QRoute.api(IEmosmService.class)).magicfaceAutoPlay(this.val$context, this.val$emoticon, new PicEmoticonInfoSender.1.1(this, paramEmoticonPackage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.1
 * JD-Core Version:    0.7.0.1
 */