package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.graphics.Bitmap;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ProfileContentSignComponent$RichStatusIconListener
  implements IIconListener
{
  private WeakReference<ProfileContentSignComponent> mRef;
  
  public ProfileContentSignComponent$RichStatusIconListener(ProfileContentSignComponent paramProfileContentSignComponent)
  {
    this.mRef = new WeakReference(paramProfileContentSignComponent);
  }
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileContentSignComponent", 2, String.format("onGetIcon actionId=%s size=%s icon=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramBitmap }));
    }
    if (paramBitmap != null)
    {
      paramBitmap = (ProfileContentSignComponent)this.mRef.get();
      if (paramBitmap != null)
      {
        RichStatus localRichStatus = ProfileContentSignComponent.access$1000(paramBitmap);
        if ((localRichStatus != null) && (localRichStatus.actionId == paramInt1)) {
          ProfileContentSignComponent.access$1200(paramBitmap, ((ProfileCardInfo)ProfileContentSignComponent.access$3000(paramBitmap)).card, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.RichStatusIconListener
 * JD-Core Version:    0.7.0.1
 */