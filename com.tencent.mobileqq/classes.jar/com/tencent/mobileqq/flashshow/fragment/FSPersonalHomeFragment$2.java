package com.tencent.mobileqq.flashshow.fragment;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalBottomBlock;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalTab;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class FSPersonalHomeFragment$2
  implements Observer<ArrayList<FSPersonalTab>>
{
  FSPersonalHomeFragment$2(FSPersonalHomeFragment paramFSPersonalHomeFragment) {}
  
  public void a(ArrayList<FSPersonalTab> paramArrayList)
  {
    if ((FSPersonalHomeFragment.b(this.a) != null) && (FSPersonalHomeFragment.a(this.a) != null))
    {
      FSPersonalHomeFragment.b(this.a).a(paramArrayList);
      return;
    }
    QLog.i("FSPersonalHomeFragment", 1, "mPersonalFeedBlock || mPersonalInfoBlock is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSPersonalHomeFragment.2
 * JD-Core Version:    0.7.0.1
 */