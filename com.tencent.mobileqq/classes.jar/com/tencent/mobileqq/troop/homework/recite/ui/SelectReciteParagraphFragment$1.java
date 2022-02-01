package com.tencent.mobileqq.troop.homework.recite.ui;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Set;

class SelectReciteParagraphFragment$1
  implements AdapterView.OnItemClickListener
{
  SelectReciteParagraphFragment$1(SelectReciteParagraphFragment paramSelectReciteParagraphFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
      this.a.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$ParagraphListAdapter.notifyDataSetChanged();
      this.a.e();
      return;
      this.a.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment.1
 * JD-Core Version:    0.7.0.1
 */