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
    localObject = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).sheetItem;
    if (ShareActionSheetV2.access$000(this.this$0) != null) {
      ShareActionSheetV2.access$000(this.this$0).onItemClick((ShareActionSheetBuilder.ActionSheetItem)localObject, this.this$0);
    }
    ShareActionSheetV2 localShareActionSheetV2 = this.this$0;
    int i;
    if (paramAdapterView == this.this$0.grid_row_view0) {
      i = 0;
    }
    for (;;)
    {
      ShareActionSheetV2.access$100(localShareActionSheetV2, (ShareActionSheetBuilder.ActionSheetItem)localObject, i);
      break;
      if (paramAdapterView == this.this$0.grid_row_view1) {
        i = 1;
      } else if (paramAdapterView == this.this$0.grid_row_view2) {
        i = 2;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.1
 * JD-Core Version:    0.7.0.1
 */