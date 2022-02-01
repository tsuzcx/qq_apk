package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import mqq.os.MqqHandler;

class PTSNodeImage$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  PTSNodeImage$1(PTSNodeImage paramPTSNodeImage) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((TextUtils.equals(paramString, String.valueOf(PTSNodeImage.access$000(this.this$0)))) && (paramReadInJoyUserInfo != null))
    {
      paramString = ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo);
      ThreadManager.getUIHandler().post(new PTSNodeImage.1.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeImage.1
 * JD-Core Version:    0.7.0.1
 */