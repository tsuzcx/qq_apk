package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.qphone.base.util.QLog;

class FSLayerBasePart$4
  implements Runnable
{
  FSLayerBasePart$4(FSLayerBasePart paramFSLayerBasePart, FSFeedSelectInfo paramFSFeedSelectInfo) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    String str = this.this$0.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle notifyPostOnFeedSelected | selectInfo = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" | pageId = ");
    localStringBuilder.append(this.this$0.i());
    QLog.i(str, 1, localStringBuilder.toString());
    this.this$0.b.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSLayerBasePart.4
 * JD-Core Version:    0.7.0.1
 */