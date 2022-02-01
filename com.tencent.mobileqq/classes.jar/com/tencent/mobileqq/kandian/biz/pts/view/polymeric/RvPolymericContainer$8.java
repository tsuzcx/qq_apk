package com.tencent.mobileqq.kandian.biz.pts.view.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.qphone.base.util.QLog;

class RvPolymericContainer$8
  implements ProteusRecycleView.OnStateChangeListener
{
  RvPolymericContainer$8(RvPolymericContainer paramRvPolymericContainer) {}
  
  public void a()
  {
    if (RvPolymericContainer.h(this.a) != null)
    {
      RvPolymericContainer.h(this.a).a();
      return;
    }
    ReadInJoyUtils.a(RvPolymericContainer.i(this.a).getContext(), RvPolymericContainer.j(this.a));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mScrollJumpUrl : ");
    localStringBuilder.append(RvPolymericContainer.j(this.a));
    QLog.d("RvPolymericContainer", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer.8
 * JD-Core Version:    0.7.0.1
 */