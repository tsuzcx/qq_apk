package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

class MediaPreviewActivity$2
  implements AdapterView.OnItemSelectedListener
{
  MediaPreviewActivity$2(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter.a(false, paramInt);
    }
    this.a.jdField_a_of_type_Int = paramInt;
    paramAdapterView = new StringBuilder();
    paramAdapterView.append(this.a.jdField_a_of_type_Int + 1);
    paramAdapterView.append("/");
    paramAdapterView.append(this.a.b);
    paramAdapterView = paramAdapterView.toString();
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdapterView);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */