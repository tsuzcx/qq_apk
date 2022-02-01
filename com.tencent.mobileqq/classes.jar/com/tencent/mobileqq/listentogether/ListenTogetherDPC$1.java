package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.qphone.base.util.QLog;

class ListenTogetherDPC$1
  implements DPCObserver
{
  ListenTogetherDPC$1(ListenTogetherDPC paramListenTogetherDPC) {}
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      ListenTogetherDPC.a(this.a);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDpcPullFinished, hasChanged = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ListenTogether.dpc", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherDPC.1
 * JD-Core Version:    0.7.0.1
 */