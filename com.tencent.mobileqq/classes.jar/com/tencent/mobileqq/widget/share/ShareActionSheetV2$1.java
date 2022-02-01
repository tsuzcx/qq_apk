package com.tencent.mobileqq.widget.share;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShareActionSheetV2$1
  implements AdapterView.OnItemClickListener
{
  ShareActionSheetV2$1(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ShareActionSheetBuilder.ActionSheetItemViewHolder))
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    localObject = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a;
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).onItemClick((ShareActionSheetBuilder.ActionSheetItem)localObject, this.a);
    }
    ShareActionSheetV2 localShareActionSheetV2 = this.a;
    int i;
    if (paramAdapterView == this.a.a) {
      i = 0;
    }
    for (;;)
    {
      ShareActionSheetV2.a(localShareActionSheetV2, (ShareActionSheetBuilder.ActionSheetItem)localObject, i);
      break;
      if (paramAdapterView == this.a.b) {
        i = 1;
      } else if (paramAdapterView == this.a.c) {
        i = 2;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.1
 * JD-Core Version:    0.7.0.1
 */