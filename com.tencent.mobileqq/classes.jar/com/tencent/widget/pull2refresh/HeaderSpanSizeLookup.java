package com.tencent.widget.pull2refresh;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

public class HeaderSpanSizeLookup
  extends GridLayoutManager.SpanSizeLookup
{
  private GridLayoutManager.SpanSizeLookup jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup;
  private final GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private final RecyclerViewHeaderViewAdapter jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewHeaderViewAdapter;
  
  public HeaderSpanSizeLookup(RecyclerViewHeaderViewAdapter paramRecyclerViewHeaderViewAdapter, GridLayoutManager paramGridLayoutManager)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewHeaderViewAdapter = paramRecyclerViewHeaderViewAdapter;
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = paramGridLayoutManager;
  }
  
  public void a(GridLayoutManager.SpanSizeLookup paramSpanSizeLookup)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup = paramSpanSizeLookup;
  }
  
  public int getSpanSize(int paramInt)
  {
    int j = 1;
    int i;
    if ((this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewHeaderViewAdapter.a(paramInt)) || (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewHeaderViewAdapter.b(paramInt)))
    {
      i = 1;
      if (i == 0) {
        break label45;
      }
      i = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    label45:
    do
    {
      return i;
      i = 0;
      break;
      i = j;
    } while (this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup == null);
    return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup.getSpanSize(paramInt - this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewHeaderViewAdapter.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.HeaderSpanSizeLookup
 * JD-Core Version:    0.7.0.1
 */