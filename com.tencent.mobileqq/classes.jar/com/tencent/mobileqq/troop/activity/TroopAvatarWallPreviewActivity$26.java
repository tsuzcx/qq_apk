package com.tencent.mobileqq.troop.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import java.util.ArrayList;
import java.util.List;

class TroopAvatarWallPreviewActivity$26
  implements DialogInterface.OnClickListener
{
  TroopAvatarWallPreviewActivity$26(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopAvatarWallPreviewActivity.access$2000(this.a).add(this.a.mSeqNumList.get(this.a.mIndex));
    this.a.mSeqNumList.remove(this.a.mIndex);
    paramDialogInterface = this.a;
    paramDialogInterface.mSeqListLength = paramDialogInterface.mSeqNumList.size();
    paramDialogInterface = this.a.getIntent();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("extend_friend_delete_path_list", TroopAvatarWallPreviewActivity.access$2000(this.a));
    paramDialogInterface.putExtras(localBundle);
    this.a.setResult(-1, paramDialogInterface);
    if (this.a.mAdapter.getCount() == 0)
    {
      this.a.finish();
      return;
    }
    if (this.a.mIndex >= this.a.mAdapter.getCount())
    {
      paramDialogInterface = this.a;
      paramDialogInterface.mIndex -= 1;
    }
    this.a.mAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.26
 * JD-Core Version:    0.7.0.1
 */