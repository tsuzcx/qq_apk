package com.tencent.mobileqq.search;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;

class HotWordSearchEntryModel$4
  implements Runnable
{
  HotWordSearchEntryModel$4(HotWordSearchEntryModel paramHotWordSearchEntryModel, HotWordSearchEntryDataModel.GIFInfo paramGIFInfo, HotWordSearchEntryModel.OnGifPlayListener paramOnGifPlayListener) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a.hotSearchGifID)) && (!TextUtils.isEmpty(this.a.hotSearchGifUrl)))
    {
      if (TextUtils.isEmpty(this.a.hotSearchGifUrlNight)) {
        return;
      }
      int i = this.this$0.d.getHeight();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.this$0.e.getLayoutParams();
      localLayoutParams.height = i;
      this.this$0.e.setLayoutParams(localLayoutParams);
      HotWordSearchEntryModel.a(this.this$0.q, this.this$0.e, this.a.hotSearchGifUrl, this.a.hotSearchGifUrlNight, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */