package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;

class CoverSelectTabFragment$4
  implements OutputPicListener
{
  CoverSelectTabFragment$4(CoverSelectTabFragment paramCoverSelectTabFragment) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OutputPicListener outPath:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("RIJUGC.CoverSelectTabFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    CoverSelectTabFragment.a((CoverSelectTabFragment)localObject, paramString, CoverSelectTabFragment.c((CoverSelectTabFragment)localObject).getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.CoverSelectTabFragment.4
 * JD-Core Version:    0.7.0.1
 */