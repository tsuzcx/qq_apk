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
    String str = this.strTitle;
    return (str == null) || (str.trim().length() <= 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.nBusiEntryType);
    localStringBuilder.append(",");
    localStringBuilder.append(this.strLogoUrl);
    localStringBuilder.append(",");
    localStringBuilder.append(this.strTitle);
    localStringBuilder.append(",");
    localStringBuilder.append(this.strContent);
    localStringBuilder.append(",");
    localStringBuilder.append(this.strJumpUrl);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.entity.ProfileBusiEntry
 * JD-Core Version:    0.7.0.1
 */