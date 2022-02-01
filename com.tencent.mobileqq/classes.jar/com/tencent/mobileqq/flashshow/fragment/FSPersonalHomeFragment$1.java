package com.tencent.mobileqq.flashshow.fragment;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalInfoBlock;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalInfo;

class FSPersonalHomeFragment$1
  implements Observer<FSPersonalInfo>
{
  FSPersonalHomeFragment$1(FSPersonalHomeFragment paramFSPersonalHomeFragment) {}
  
  public void a(FSPersonalInfo paramFSPersonalInfo)
  {
    if (paramFSPersonalInfo != null)
    {
      if (FSPersonalHomeFragment.a(this.a) == null) {
        return;
      }
      FSPersonalHomeFragment.a(this.a).a(paramFSPersonalInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSPersonalHomeFragment.1
 * JD-Core Version:    0.7.0.1
 */