package com.tencent.mobileqq.businessCard.activity;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class CardPicGalleryActivity$2
  implements AdapterView.OnItemClickListener
{
  CardPicGalleryActivity$2(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.a.isFinishing())
    {
      this.a.overridePendingTransition(0, 2130772510);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.2
 * JD-Core Version:    0.7.0.1
 */