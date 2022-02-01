package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import mqq.os.MqqHandler;

class ReadInjoyTextView$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ReadInjoyTextView$1(ReadInjoyTextView paramReadInjoyTextView, String paramString1, String paramString2) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.jdField_a_of_type_JavaLangString))) {
      ThreadManager.getUIHandler().post(new ReadInjoyTextView.1.2(this));
    }
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_JavaLangString))) {
      ThreadManager.getUIHandler().post(new ReadInjoyTextView.1.1(this, paramReadInJoyUserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView.1
 * JD-Core Version:    0.7.0.1
 */