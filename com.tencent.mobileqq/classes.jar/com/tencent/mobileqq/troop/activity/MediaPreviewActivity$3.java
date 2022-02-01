package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

class MediaPreviewActivity$3
  implements AdapterView.OnItemLongClickListener
{
  MediaPreviewActivity$3(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.e != null)
    {
      paramAdapterView = this.a.e.a(paramInt);
      if ((paramAdapterView == null) || (paramAdapterView.a != 1)) {
        return false;
      }
    }
    MediaPreviewActivity.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */