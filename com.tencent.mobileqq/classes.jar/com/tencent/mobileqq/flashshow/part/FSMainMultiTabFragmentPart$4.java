package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.flashshow.widgets.FSViewPager.OnSlideListener;
import com.tencent.qphone.base.util.QLog;

class FSMainMultiTabFragmentPart$4
  implements FSViewPager.OnSlideListener
{
  FSMainMultiTabFragmentPart$4(FSMainMultiTabFragmentPart paramFSMainMultiTabFragmentPart) {}
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isEndPageSelected:");
    localStringBuilder.append(FSMainMultiTabFragmentPart.d(this.a));
    QLog.d("FSMainMultiTabFragmentPart", 1, localStringBuilder.toString());
    return FSMainMultiTabFragmentPart.d(this.a);
  }
  
  public void b()
  {
    QLog.d("FSMainMultiTabFragmentPart", 1, "onSlideRightAtEnd trigger");
    FSMainMultiTabFragmentPart.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSMainMultiTabFragmentPart.4
 * JD-Core Version:    0.7.0.1
 */