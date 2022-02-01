package com.tencent.mobileqq.flashshow.widgets.comment;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

class FSCommentPraiseLayout$2
  implements Runnable
{
  FSCommentPraiseLayout$2(FSCommentPraiseLayout paramFSCommentPraiseLayout, View paramView1, int paramInt, View paramView2) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    this.a.getHitRect(localRect);
    localRect.top -= this.b;
    localRect.bottom += this.b;
    localRect.left -= this.b;
    localRect.right += this.b;
    this.c.setTouchDelegate(new TouchDelegate(localRect, this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentPraiseLayout.2
 * JD-Core Version:    0.7.0.1
 */