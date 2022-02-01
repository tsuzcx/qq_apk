package com.tencent.mobileqq.selectmember;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;

class TroopListAdapter$2
  extends TroopAvatarObserver
{
  TroopListAdapter$2(TroopListAdapter paramTroopListAdapter) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getFaceBitmap(this.a.i, 113, paramString, false, 0);
    if (localBitmap != null) {
      TroopListAdapter.a(this.a, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListAdapter.2
 * JD-Core Version:    0.7.0.1
 */