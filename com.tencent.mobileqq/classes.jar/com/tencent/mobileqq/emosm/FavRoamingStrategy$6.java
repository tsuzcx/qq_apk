package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;

class FavRoamingStrategy$6
  extends SyncListener<CustomEmotionData>
{
  FavRoamingStrategy$6(FavRoamingStrategy paramFavRoamingStrategy) {}
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    if (((paramInt1 <= 28) || (paramInt2 % 28 == 0)) && (this.a.a != null)) {
      this.a.a.k();
    }
  }
  
  public void onDownloadFinish(int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.k();
    }
  }
  
  public void onUploadFinish()
  {
    if (this.a.a != null) {
      this.a.a.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.6
 * JD-Core Version:    0.7.0.1
 */