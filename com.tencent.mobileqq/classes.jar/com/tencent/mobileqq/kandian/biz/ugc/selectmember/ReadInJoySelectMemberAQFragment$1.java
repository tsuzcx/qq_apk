package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import com.tencent.mobileqq.widget.QQToast;

class ReadInJoySelectMemberAQFragment$1
  implements Runnable
{
  ReadInJoySelectMemberAQFragment$1(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment, int paramInt) {}
  
  public void run()
  {
    if (!this.this$0.a)
    {
      if (this.this$0.getBaseActivity() == null) {
        return;
      }
      this.this$0.a();
      QQToast.a(this.this$0.getBaseActivity(), 1, this.this$0.getString(this.a), 0).b(ReadInJoySelectMemberAQFragment.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQFragment.1
 * JD-Core Version:    0.7.0.1
 */