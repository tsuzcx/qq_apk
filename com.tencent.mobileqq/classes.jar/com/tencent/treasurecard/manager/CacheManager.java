package com.tencent.treasurecard.manager;

import com.tencent.treasurecard.bean.TreasureCard;

public class CacheManager
{
  private TreasureCard a;
  
  public TreasureCard a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    if (this.a == null) {
      this.a = new TreasureCard();
    }
    this.a.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.treasurecard.manager.CacheManager
 * JD-Core Version:    0.7.0.1
 */