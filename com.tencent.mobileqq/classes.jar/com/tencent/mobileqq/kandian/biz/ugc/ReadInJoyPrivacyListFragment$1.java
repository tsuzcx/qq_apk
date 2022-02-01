package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyPrivacyListFragment$1
  extends ReadInJoyObserver
{
  ReadInJoyPrivacyListFragment$1(ReadInJoyPrivacyListFragment paramReadInJoyPrivacyListFragment) {}
  
  public void a(int paramInt1, long paramLong, List<Long> paramList, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetPrivacyList | retcode ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" | feedsId ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("| totalCnt ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" | nextPageStartIndex ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" | hasNextPage ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("| uinList size ");
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    QLog.d("ReadInJoyPrivacyListFragment", 1, localStringBuilder.toString());
    if (paramInt1 == 0)
    {
      ReadInJoyPrivacyListFragment.a(this.a, paramInt2);
      ReadInJoyPrivacyListFragment.b(this.a, paramInt3);
      ReadInJoyPrivacyListFragment.a(this.a, paramBoolean);
      if (paramList != null) {
        ReadInJoyPrivacyListFragment.a(this.a).addAll(paramList);
      }
      if (ReadInJoyPrivacyListFragment.b(this.a) != null) {
        ReadInJoyPrivacyListFragment.b(this.a).a(ReadInJoyPrivacyListFragment.c(this.a));
      }
    }
    else if (ReadInJoyPrivacyListFragment.b(this.a) != null)
    {
      ReadInJoyPrivacyListFragment.b(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListFragment.1
 * JD-Core Version:    0.7.0.1
 */