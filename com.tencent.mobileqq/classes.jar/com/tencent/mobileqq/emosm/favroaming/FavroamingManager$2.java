package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import java.util.List;

class FavroamingManager$2
  extends FavEmoRoamingObserver
{
  FavroamingManager$2(FavroamingManager paramFavroamingManager) {}
  
  public void onDelEmoResponse(boolean paramBoolean)
  {
    if (FavroamingManager.e(this.a) == null) {}
    while (!paramBoolean) {
      return;
    }
    this.a.b();
  }
  
  public void onUploadReq(List<CustomEmotionData> paramList)
  {
    if (FavroamingManager.f(this.a) == null) {
      return;
    }
    FavroamingManager.g(this.a).removeObserver(FavroamingManager.a(this.a));
    ThreadManager.excute(new FavroamingManager.2.1(this, paramList), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.2
 * JD-Core Version:    0.7.0.1
 */