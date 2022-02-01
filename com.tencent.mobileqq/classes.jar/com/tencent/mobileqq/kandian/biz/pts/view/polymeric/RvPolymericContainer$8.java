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
    if (RvPolymericContainer.a(this.a) != null)
    {
      RvPolymericContainer.a(this.a).a();
      return;
    }
    ReadInJoyUtils.a(RvPolymericContainer.b(this.a).getContext(), RvPolymericContainer.a(this.a));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mScrollJumpUrl : ");
    localStringBuilder.append(RvPolymericContainer.a(this.a));
    QLog.d("RvPolymericContainer", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer.8
 * JD-Core Version:    0.7.0.1
 */