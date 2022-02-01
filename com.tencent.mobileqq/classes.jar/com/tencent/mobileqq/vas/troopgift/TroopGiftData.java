package com.tencent.mobileqq.vas.troopgift;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.mobileqq.utils.AIOAnimationControlManager.IAnimationMessage;

@Keep
public class TroopGiftData
  implements AIOAnimationControlManager.IAnimationMessage
{
  private static final String GIFT_TYPE_COMMON = "0";
  private static final String GIFT_TYPE_GESTURE = "2";
  private static final String GIFT_TYPE_GUILD = "7";
  private static final String GIFT_TYPE_STAFF = "1";
  public TroopGiftData.GiftDataBean giftData = new TroopGiftData.GiftDataBean();
  private boolean isReaded = true;
  private long shmsgseq = 0L;
  
  public String getFriendUin()
  {
    return this.giftData.dataForClient.troopUin;
  }
  
  public int getLimitType()
  {
    return 0;
  }
  
  public long getSenderUin()
  {
    return Long.parseLong(this.giftData.dataForClient.sendUin);
  }
  
  public long getShmsgseq()
  {
    return this.shmsgseq;
  }
  
  public boolean isCommonGift()
  {
    return this.giftData.dataForClient.giftType.equals("0");
  }
  
  public boolean isGestureGift()
  {
    return this.giftData.dataForClient.giftType.equals("2");
  }
  
  public boolean isGuildGift()
  {
    return this.giftData.dataForClient.giftType.equals("7");
  }
  
  public boolean isReaded()
  {
    return this.isReaded;
  }
  
  public boolean isResInvalid()
  {
    return TextUtils.isEmpty(this.giftData.dataForClient.giftResourceAnd);
  }
  
  public boolean isStaffGift()
  {
    return this.giftData.dataForClient.giftType.equals("1");
  }
  
  public void setReaded(boolean paramBoolean)
  {
    this.isReaded = paramBoolean;
  }
  
  public void setShmsgseq(long paramLong)
  {
    this.shmsgseq = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftData
 * JD-Core Version:    0.7.0.1
 */