package com.tencent.mobileqq.flashshow.part;

import android.view.View;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.flashshow.fragment.FSBlockContainer;
import com.tencent.qphone.base.util.QLog;

class FSCommentPanelPart$11
  implements Runnable
{
  FSCommentPanelPart$11(FSCommentPanelPart paramFSCommentPanelPart, View paramView, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    this.a.getLocationOnScreen(this.b);
    Object localObject = this.b;
    localObject[1] += this.a.getHeight();
    if (this.b[1] > this.c)
    {
      FSCommentPanelPart.d(this.this$0).getRecyclerView().scrollBy(0, this.b[1] - this.c);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scrollItemToVisble  postDelayed scrollBy: ");
      ((StringBuilder)localObject).append(this.b[1] - this.c);
      QLog.i("FSC-FSCommentPanelPart", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSCommentPanelPart.11
 * JD-Core Version:    0.7.0.1
 */