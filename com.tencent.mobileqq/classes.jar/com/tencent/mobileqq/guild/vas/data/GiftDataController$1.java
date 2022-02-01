package com.tencent.mobileqq.guild.vas.data;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.vas.util.SharedPreferencesHelper;

class GiftDataController$1
  implements BusinessObserver
{
  GiftDataController$1(GiftDataController paramGiftDataController, SharedPreferencesHelper paramSharedPreferencesHelper, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramInt == 0) && (paramObject != null)) {
      GiftDataController.a(this.c, (byte[])paramObject, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.data.GiftDataController.1
 * JD-Core Version:    0.7.0.1
 */