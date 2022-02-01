package com.tencent.mobileqq.multiaio;

import com.tencent.widget.ListView;

class MultiAIOItemFragment$6
  implements Runnable
{
  MultiAIOItemFragment$6(MultiAIOItemFragment paramMultiAIOItemFragment, ListView paramListView, int[] paramArrayOfInt) {}
  
  public void run()
  {
    ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    localListView.setSelectionFromBottom(arrayOfInt[0], arrayOfInt[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment.6
 * JD-Core Version:    0.7.0.1
 */