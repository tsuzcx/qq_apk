package com.tencent.mobileqq.emoticonview.relateemo;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

class RelatedEmoticonListAdapter$3
  implements Runnable
{
  RelatedEmoticonListAdapter$3(RelatedEmoticonListAdapter paramRelatedEmoticonListAdapter, View paramView, LinearLayout paramLinearLayout) {}
  
  public void run()
  {
    if (((RelatedEmoticonListAdapter.access$100(this.this$0) instanceof Activity)) && (!((Activity)RelatedEmoticonListAdapter.access$100(this.this$0)).isFinishing()))
    {
      int[] arrayOfInt = new int[2];
      this.val$view.getLocationInWindow(arrayOfInt);
      PopupWindow localPopupWindow = RelatedEmoticonListAdapter.access$200(this.this$0);
      View localView = this.val$view;
      localPopupWindow.showAtLocation(localView, 48, (int)(arrayOfInt[0] - localView.getMeasuredWidth() * 1.5F), arrayOfInt[1] - this.val$linearLayout.getMeasuredHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonListAdapter.3
 * JD-Core Version:    0.7.0.1
 */