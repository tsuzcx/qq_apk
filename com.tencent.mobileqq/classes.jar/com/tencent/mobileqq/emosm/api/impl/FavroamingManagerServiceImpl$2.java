package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import java.util.List;

class FavroamingManagerServiceImpl$2
  extends FavEmoRoamingObserver
{
  FavroamingManagerServiceImpl$2(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl) {}
  
  public void onDelEmoResponse(boolean paramBoolean)
  {
    if (FavroamingManagerServiceImpl.access$400(this.a) == null) {
      return;
    }
    if (paramBoolean) {
      this.a.syncRoaming();
    }
  }
  
  public void onUploadReq(List<CustomEmotionData> paramList)
  {
    if (FavroamingManagerServiceImpl.access$500(this.a) == null) {
      return;
    }
    FavroamingManagerServiceImpl.access$700(this.a).removeObserver(FavroamingManagerServiceImpl.access$600(this.a));
    ThreadManager.excute(new FavroamingManagerServiceImpl.2.1(this, paramList), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */