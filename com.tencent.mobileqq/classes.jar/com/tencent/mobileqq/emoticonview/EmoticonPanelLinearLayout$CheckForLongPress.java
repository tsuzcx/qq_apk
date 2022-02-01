package com.tencent.mobileqq.emoticonview;

import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import arxd;
import arxg;
import bcst;
import com.tencent.mobileqq.activity.BaseChatPie;

class EmoticonPanelLinearLayout$CheckForLongPress
  implements Runnable
{
  int jdField_a_of_type_Int;
  SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  
  public EmoticonPanelLinearLayout$CheckForLongPress(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewMotionEvent = paramMotionEvent;
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray(10);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(7, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(4, 2);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(5, 2);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(11, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(6, 4);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(9, 4);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(10, 5);
  }
  
  private void a(arxg paramarxg)
  {
    if (EmoticonPanelLinearLayout.a(this.this$0) == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramarxg.c, -1);
    } while (i == -1);
    bcst.b(EmoticonPanelLinearLayout.a(this.this$0).a, "dc00898", "", "", "0X800AEEC", "0X800AEEC", i, 0, "", "", "", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = EmoticonPanelLinearLayout.b(this.this$0);
  }
  
  public void run()
  {
    if ((this.this$0.getParent() != null) && (this.jdField_a_of_type_Int == EmoticonPanelLinearLayout.a(this.this$0)) && (this.this$0.jdField_a_of_type_AndroidViewView != null))
    {
      arxg localarxg = (arxg)this.this$0.jdField_a_of_type_AndroidViewView.getTag();
      if (localarxg != null)
      {
        if ((this.this$0.jdField_a_of_type_Arxd != null) && (this.this$0.jdField_a_of_type_Arxd.a(localarxg))) {
          break label139;
        }
        this.this$0.d = true;
        this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
        this.this$0.sendAccessibilityEvent(2);
        if (EmoticonPanelLinearLayout.a(this.this$0, localarxg))
        {
          this.this$0.a(this.this$0.jdField_a_of_type_AndroidViewView, localarxg);
          a(localarxg);
        }
      }
    }
    return;
    label139:
    this.this$0.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */