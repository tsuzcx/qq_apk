package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.qphone.base.util.QLog;

class FSLayerBasePart$5
  implements Runnable
{
  FSLayerBasePart$5(FSLayerBasePart paramFSLayerBasePart, FSFeedSelectInfo paramFSFeedSelectInfo) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    String str = this.this$0.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle notifyPostOnFeedUnselected | selectInfo = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" | pageId = ");
    localStringBuilder.append(this.this$0.i());
    QLog.i(str, 1, localStringBuilder.toString());
    this.this$0.b.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSLayerBasePart.5
 * JD-Core Version:    0.7.0.1
 */