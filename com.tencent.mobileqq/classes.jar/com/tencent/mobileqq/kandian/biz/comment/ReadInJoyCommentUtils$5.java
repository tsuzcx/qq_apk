package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Context;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mtt.hippy.utils.UIThreadUtils;

final class ReadInJoyCommentUtils$5
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ReadInJoyCommentUtils$5(Context paramContext, String paramString1, String paramString2) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    UIThreadUtils.runOnUiThread(new ReadInJoyCommentUtils.5.1(this, paramReadInJoyUserInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.5
 * JD-Core Version:    0.7.0.1
 */