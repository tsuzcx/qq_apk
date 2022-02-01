package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelObserver;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopAvatarWallPreviewActivity$27
  extends PersonalityLabelObserver
{
  TroopAvatarWallPreviewActivity$27(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onDelPersonalityLabelPhoto(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDelPersonalityLabelPhoto,suc:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.i("TroopAvatarWallPreviewActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString.equals(this.a.app.getCurrentAccountUin()))
    {
      if (TroopAvatarWallPreviewActivity.access$300(this.a) == null) {
        return;
      }
      if ((this.a.mIndex >= 0) && (this.a.mIndex <= this.a.mAdapter.getCount() - 1) && (this.a.mPhotoIds != null))
      {
        if (this.a.mIndex > this.a.mPhotoIds.size() - 1) {
          return;
        }
        long l1 = TroopAvatarWallPreviewActivity.access$300(this.a).getLong("label_id", 0L);
        long l2 = Long.valueOf((String)this.a.mPhotoIds.get(this.a.mIndex)).longValue();
        if (l1 == paramLong1)
        {
          if (l2 != paramLong2) {
            return;
          }
          TroopAvatarWallPreviewActivity.access$1900(this.a);
          localObject = this.a;
          int i;
          if (paramBoolean)
          {
            paramString = ((TroopAvatarWallPreviewActivity)localObject).getResources();
            i = 2131692658;
          }
          else
          {
            paramString = ((TroopAvatarWallPreviewActivity)localObject).getResources();
            i = 2131691485;
          }
          TroopAvatarWallPreviewActivity.access$2000((TroopAvatarWallPreviewActivity)localObject, paramString.getString(i));
          if (paramBoolean)
          {
            this.a.mPhotoIds.remove(this.a.mIndex);
            this.a.mSeqNumList.remove(this.a.mIndex);
            paramString = this.a;
            paramString.mSeqListLength = paramString.mSeqNumList.size();
            if (this.a.mPhotoIds.size() == 0) {
              this.a.finish();
            }
            if (this.a.mIndex >= this.a.mAdapter.getCount())
            {
              paramString = this.a;
              paramString.mIndex -= 1;
            }
            paramString = new StringBuilder();
            paramString.append(this.a.mIndex + 1);
            paramString.append("/");
            paramString.append(this.a.mSeqListLength);
            paramString = paramString.toString();
            this.a.mTextView.setText(paramString);
            this.a.mAdapter.notifyDataSetChanged();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.27
 * JD-Core Version:    0.7.0.1
 */