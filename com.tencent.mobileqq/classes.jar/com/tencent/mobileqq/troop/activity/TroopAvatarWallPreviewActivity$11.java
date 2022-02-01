package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

class TroopAvatarWallPreviewActivity$11
  implements AdapterView.OnItemLongClickListener
{
  TroopAvatarWallPreviewActivity$11(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.a.mIsShowAction) || (this.a.mIsEdit)) {
      TroopAvatarWallPreviewActivity.access$800(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */