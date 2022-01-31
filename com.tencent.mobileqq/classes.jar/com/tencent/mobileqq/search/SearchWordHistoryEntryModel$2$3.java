package com.tencent.mobileqq.search;

import android.view.View;
import android.widget.RelativeLayout;
import awix;
import awiz;

public class SearchWordHistoryEntryModel$2$3
  implements Runnable
{
  public SearchWordHistoryEntryModel$2$3(awiz paramawiz, int[] paramArrayOfInt1, View paramView, int[] paramArrayOfInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Awiz.a.a.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.b);
    if (this.jdField_a_of_type_ArrayOfInt[1] > this.b[1])
    {
      View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131362810);
      View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131362798);
      localView1.setVisibility(8);
      localView2.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2.3
 * JD-Core Version:    0.7.0.1
 */