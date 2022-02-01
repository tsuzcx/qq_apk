package com.tencent.mobileqq.kandian.biz.privatechat;

import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJPrivateChatListFragment$onLoadUserInfoSucceed$1
  implements Runnable
{
  RIJPrivateChatListFragment$onLoadUserInfoSucceed$1(RIJPrivateChatListFragment paramRIJPrivateChatListFragment, String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public final void run()
  {
    RIJPrivateChatListFragment.a(this.this$0, this.a, this.b);
    RIJPrivateChatListFragment.b(this.this$0, this.a, this.b);
    RIJPrivateChatListFragment.a(this.this$0).a(this.a, 10013);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onLoadUserInfoSucceed] uin = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", userInfo = ");
    localStringBuilder.append(this.b);
    QLog.i("RIJPrivateChatListFragment", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.privatechat.RIJPrivateChatListFragment.onLoadUserInfoSucceed.1
 * JD-Core Version:    0.7.0.1
 */