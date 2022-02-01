package com.tencent.mobileqq.flashshow.part;

import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.Tab;
import com.tencent.mobileqq.flashshow.fragment.tab.FSBaseTabFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class FSMainMultiTabFragmentPart$2
  implements TabLayoutCompat.OnTabSelectedListener
{
  FSMainMultiTabFragmentPart$2(FSMainMultiTabFragmentPart paramFSMainMultiTabFragmentPart) {}
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTabSelected");
    localStringBuilder.append(paramTab.c());
    QLog.i("FSMainMultiTabFragmentPart", 1, localStringBuilder.toString());
    FSMainMultiTabFragmentPart.a(this.a, paramTab.c());
    this.a.b(paramTab.c());
  }
  
  public void b(TabLayoutCompat.Tab paramTab) {}
  
  public void c(TabLayoutCompat.Tab paramTab)
  {
    if (paramTab.c() == FSMainMultiTabFragmentPart.b(this.a)) {
      ((FSBaseTabFragment)FSMainMultiTabFragmentPart.c(this.a).get(FSMainMultiTabFragmentPart.b(this.a))).k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSMainMultiTabFragmentPart.2
 * JD-Core Version:    0.7.0.1
 */