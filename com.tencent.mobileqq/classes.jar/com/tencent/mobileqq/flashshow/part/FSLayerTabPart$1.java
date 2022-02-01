package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter;
import com.tencent.qphone.base.util.QLog;

class FSLayerTabPart$1
  implements Runnable
{
  FSLayerTabPart$1(FSLayerTabPart paramFSLayerTabPart) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      boolean bool = this.this$0.b.d(FSLayerTabPart.a(this.this$0));
      String str = this.this$0.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFSFeedEvent removeFeedByUin uin = ");
      localStringBuilder.append(FSLayerTabPart.a(this.this$0));
      localStringBuilder.append(" | result = ");
      localStringBuilder.append(bool);
      QLog.i(str, 1, localStringBuilder.toString());
      FSLayerTabPart.a(this.this$0, null);
      if (bool)
      {
        this.this$0.b.notifyDataSetChanged();
        if (this.this$0.t()) {
          this.this$0.q();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSLayerTabPart.1
 * JD-Core Version:    0.7.0.1
 */