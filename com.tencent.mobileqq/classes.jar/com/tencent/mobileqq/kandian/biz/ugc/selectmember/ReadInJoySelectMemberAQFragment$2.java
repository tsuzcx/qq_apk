package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.widget.QQToast;

class ReadInJoySelectMemberAQFragment$2
  extends ReadInJoyObserver
{
  ReadInJoySelectMemberAQFragment$2(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment) {}
  
  public void c(String paramString, int paramInt)
  {
    if (("OidbSvc.0xbd4_1".equals(paramString)) && (this.a.getBaseActivity() != null))
    {
      paramString = this.a;
      paramString.a = true;
      paramString.a();
      if (paramInt == 0)
      {
        ReadInJoySelectMemberAQFragment.a(this.a, 0);
        ReadInJoySelectMemberAQFragment.a(this.a, false);
        this.a.c();
        this.a.getBaseActivity().finish();
        ReadInJoySelectMemberAQFragment.a(this.a, true);
        return;
      }
      ReadInJoySelectMemberAQFragment.a(this.a, true);
      ReadInJoySelectMemberAQFragment.a(this.a, 2);
      paramString = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131712696));
      localStringBuilder.append(paramInt);
      ReadInJoySelectMemberAQFragment.a(paramString, localStringBuilder.toString());
      QQToast.a(this.a.getBaseActivity(), 1, this.a.getString(2131718026), 0).b(ReadInJoySelectMemberAQFragment.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQFragment.2
 * JD-Core Version:    0.7.0.1
 */