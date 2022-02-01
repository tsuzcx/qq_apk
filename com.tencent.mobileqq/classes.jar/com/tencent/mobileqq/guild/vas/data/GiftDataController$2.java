package com.tencent.mobileqq.guild.vas.data;

import com.tencent.mobileqq.app.BusinessObserver;

class GiftDataController$2
  implements BusinessObserver
{
  GiftDataController$2(GiftDataController paramGiftDataController) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramInt == 0) && (paramObject != null)) {
      GiftDataController.a(this.a, (byte[])paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.data.GiftDataController.2
 * JD-Core Version:    0.7.0.1
 */