package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

class TroopAvatarWallPreviewActivity$5
  implements AdapterView.OnItemLongClickListener
{
  TroopAvatarWallPreviewActivity$5(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.a.mIsShowAction) || (this.a.mIsEdit)) {
      TroopAvatarWallPreviewActivity.access$600(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.5
 * JD-Core Version:    0.7.0.1
 */