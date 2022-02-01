package com.tencent.mobileqq.nearby.guide;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

class NearbyGuideActivity$5
  implements Runnable
{
  NearbyGuideActivity$5(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void run()
  {
    int i = (int)(this.this$0.b.getBottom() - this.this$0.jdField_a_of_type_AndroidWidgetEditText.getBottom() + 30.0F * this.this$0.getResources().getDisplayMetrics().density);
    this.this$0.jdField_a_of_type_AndroidWidgetScrollView.smoothScrollBy(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.5
 * JD-Core Version:    0.7.0.1
 */