package com.tencent.mobileqq.kandian.biz.pts.fragment;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyProteusFamilyViewController;
import java.util.List;

class ReadInJoyProteusFamilyFragment$1
  implements Runnable
{
  ReadInJoyProteusFamilyFragment$1(ReadInJoyProteusFamilyFragment paramReadInJoyProteusFamilyFragment, List paramList) {}
  
  public void run()
  {
    ReadInJoyProteusFamilyFragment localReadInJoyProteusFamilyFragment = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyProteusFamilyFragment.a(this.this$0).getString(2131915470));
    localStringBuilder.append("(");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(")");
    localReadInJoyProteusFamilyFragment.setTitle(localStringBuilder.toString());
    if (ReadInJoyProteusFamilyFragment.b(this.this$0) != null) {
      ReadInJoyProteusFamilyFragment.b(this.this$0).a(true, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.fragment.ReadInJoyProteusFamilyFragment.1
 * JD-Core Version:    0.7.0.1
 */