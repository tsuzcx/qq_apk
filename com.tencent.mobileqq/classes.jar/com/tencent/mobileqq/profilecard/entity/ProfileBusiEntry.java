package com.tencent.mobileqq.profilecard.entity;

public class ProfileBusiEntry
{
  public static final int JOINED_TROOP_BUSI_ENTRY_TYPE = 1024;
  public int nBusiEntryType;
  public String strContent;
  public String strJumpUrl;
  public String strLogoUrl;
  public String strTitle;
  
  public boolean isEmpty()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.strTitle != null)
    {
      bool1 = bool2;
      if (this.strTitle.trim().length() > 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.nBusiEntryType).append(",").append(this.strLogoUrl).append(",").append(this.strTitle).append(",").append(this.strContent).append(",").append(this.strJumpUrl).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.entity.ProfileBusiEntry
 * JD-Core Version:    0.7.0.1
 */