package com.tencent.qidian;

import android.view.View;
import com.tencent.qidian.data.CompanyShowCaseInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

class PhotoWallViewForQiDianProfile$1
  implements AdapterView.OnItemClickListener
{
  PhotoWallViewForQiDianProfile$1(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (CompanyShowCaseInfo)this.a.b.get(paramInt);
    if (this.a.c == null) {
      return;
    }
    this.a.c.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.PhotoWallViewForQiDianProfile.1
 * JD-Core Version:    0.7.0.1
 */