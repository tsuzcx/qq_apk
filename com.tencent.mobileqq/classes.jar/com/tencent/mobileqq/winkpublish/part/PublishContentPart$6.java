package com.tencent.mobileqq.winkpublish.part;

import com.tencent.mobileqq.winkpublish.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qphone.base.util.QLog;

class PublishContentPart$6
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  PublishContentPart$6(PublishContentPart paramPublishContentPart) {}
  
  public void a()
  {
    QLog.d(PublishContentPart.a, 1, "onSoftKeyboardClosed");
  }
  
  public void a(int paramInt)
  {
    QLog.d(PublishContentPart.a, 1, "onSoftKeyboardOpened");
    if (this.a.f != paramInt)
    {
      PublishContentPart localPublishContentPart = this.a;
      localPublishContentPart.f = paramInt;
      PublishContentPart.d(localPublishContentPart);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishContentPart.6
 * JD-Core Version:    0.7.0.1
 */