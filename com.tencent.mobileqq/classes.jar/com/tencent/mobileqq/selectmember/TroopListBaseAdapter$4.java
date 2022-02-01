package com.tencent.mobileqq.selectmember;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;

class TroopListBaseAdapter$4
  extends TroopAvatarObserver
{
  TroopListBaseAdapter$4(TroopListBaseAdapter paramTroopListBaseAdapter) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getFaceBitmap(this.a.a, 113, paramString, false, 0);
    if (localBitmap != null) {
      TroopListBaseAdapter.a(this.a, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListBaseAdapter.4
 * JD-Core Version:    0.7.0.1
 */