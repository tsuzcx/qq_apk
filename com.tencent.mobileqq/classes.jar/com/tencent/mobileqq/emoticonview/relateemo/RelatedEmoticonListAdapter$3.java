package com.tencent.mobileqq.emoticonview.relateemo;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import asdn;

public class RelatedEmoticonListAdapter$3
  implements Runnable
{
  public RelatedEmoticonListAdapter$3(asdn paramasdn, View paramView, LinearLayout paramLinearLayout) {}
  
  public void run()
  {
    if (((asdn.a(this.this$0) instanceof Activity)) && (!((Activity)asdn.a(this.this$0)).isFinishing()))
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_AndroidViewView.getLocationInWindow(arrayOfInt);
      asdn.a(this.this$0).showAtLocation(this.jdField_a_of_type_AndroidViewView, 48, (int)(arrayOfInt[0] - this.jdField_a_of_type_AndroidViewView.getMeasuredWidth() * 1.5F), arrayOfInt[1] - this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonListAdapter.3
 * JD-Core Version:    0.7.0.1
 */