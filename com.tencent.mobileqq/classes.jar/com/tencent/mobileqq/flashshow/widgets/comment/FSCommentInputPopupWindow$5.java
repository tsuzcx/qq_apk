package com.tencent.mobileqq.flashshow.widgets.comment;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSCommentInputPopupWindow$5
  implements TextView.OnEditorActionListener
{
  FSCommentInputPopupWindow$5(FSCommentInputPopupWindow paramFSCommentInputPopupWindow) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt != 4) && (paramInt != 6))
    {
      bool1 = false;
    }
    else if (this.a.l())
    {
      bool1 = bool2;
    }
    else
    {
      bool1 = bool2;
      if (this.a.j != null)
      {
        this.a.j.a();
        bool1 = bool2;
      }
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow.5
 * JD-Core Version:    0.7.0.1
 */