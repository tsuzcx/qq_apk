package com.tencent.mobileqq.kandian.biz.message.activity;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.follow.PublicAccountUnfollowTask.UnFollowPublicAccountListenner;
import com.tencent.mobileqq.widget.QQToast;

class ReadinjoySubscriptManagerActivity$3
  implements PublicAccountUnfollowTask.UnFollowPublicAccountListenner
{
  ReadinjoySubscriptManagerActivity$3(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity, Context paramContext) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new ReadinjoySubscriptManagerActivity.3.1(this), 500L);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131712719), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadinjoySubscriptManagerActivity.3
 * JD-Core Version:    0.7.0.1
 */