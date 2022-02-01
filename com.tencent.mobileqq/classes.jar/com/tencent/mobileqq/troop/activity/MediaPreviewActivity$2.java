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
    if (this.a.e != null) {
      this.a.e.a(false, paramInt);
    }
    this.a.i = paramInt;
    paramAdapterView = new StringBuilder();
    paramAdapterView.append(this.a.i + 1);
    paramAdapterView.append("/");
    paramAdapterView.append(this.a.j);
    paramAdapterView = paramAdapterView.toString();
    this.a.f.setText(paramAdapterView);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */