package com.tencent.mobileqq.kandian.biz.pts.component;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController;
import com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController.IPlayCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.handler.UGCVoiceInfo;
import com.tencent.qphone.base.util.QLog;

class ComponentContentUGCVoice$1
  implements View.OnClickListener
{
  ComponentContentUGCVoice$1(ComponentContentUGCVoice paramComponentContentUGCVoice) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((ComponentContentUGCVoice.a(this.a) != null) && (!TextUtils.isEmpty(ComponentContentUGCVoice.a(this.a).voiceUrl)))
    {
      if (ComponentContentUGCVoice.a(this.a).isPlaying)
      {
        paramView = paramView.getCurrentAccountUin();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ComponentContentUGCVoice.b(this.a).mFeedId);
        ((StringBuilder)localObject).append("");
        PublicAccountReportUtils.a(null, "", "0X8009CA4", "0X8009CA4", 0, 0, paramView, ((StringBuilder)localObject).toString(), "2", "", false);
        ReadInJoyVoicePlayController.a().b();
        return;
      }
      paramView = paramView.getCurrentAccountUin();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ComponentContentUGCVoice.b(this.a).mFeedId);
      ((StringBuilder)localObject).append("");
      PublicAccountReportUtils.a(null, "", "0X8009CA4", "0X8009CA4", 0, 0, paramView, ((StringBuilder)localObject).toString(), "1", "", false);
      paramView = ReadInJoyVoicePlayController.a();
      localObject = this.a;
      paramView.a((ReadInJoyVoicePlayController.IPlayCallback)localObject, ComponentContentUGCVoice.a((ComponentContentUGCVoice)localObject));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ComponentContentUGCVoice.a, 2, "mUGCVoiceInfo or its voiceUrl is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUGCVoice.1
 * JD-Core Version:    0.7.0.1
 */