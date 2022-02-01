package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import java.util.List;

class FavRoamingStrategy$5
  extends FavEmoRoamingObserver
{
  FavRoamingStrategy$5(FavRoamingStrategy paramFavRoamingStrategy) {}
  
  public void onDelEmoResponse(boolean paramBoolean)
  {
    FavRoamingStrategy.a(this.a).clear();
  }
  
  public void onModifyFavData(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.e();
    }
  }
  
  public void onUpdateFavData(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Integer)) && (FavRoamingStrategy.a(this.a) != null)) {
      FavRoamingStrategy.a(this.a).obtainMessage(208, paramObject).sendToTarget();
    }
    if ((this.a.a != null) && (paramBoolean)) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */