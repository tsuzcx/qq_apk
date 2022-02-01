package com.tencent.mobileqq.location;

import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;

class LocationShareRepository$3
  extends TroopMngObserver
{
  LocationShareRepository$3(LocationShareRepository paramLocationShareRepository) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0)) {
      LocationShareViewModel.a(LocationShareRepository.a(this.a), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareRepository.3
 * JD-Core Version:    0.7.0.1
 */