package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

public class TroopFansInfo$IdolItem
{
  public static final String TAG = "idolItem";
  public String avatar = "";
  public int idolid = 0;
  public String name = "";
  public String pic = "";
  public long qScore = 0L;
  public long rank = 0L;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idolid:").append(this.idolid).append(" ");
    localStringBuilder.append("name:").append(this.name).append(" ");
    localStringBuilder.append("avatar:").append(this.avatar).append(" ");
    localStringBuilder.append("pic:").append(this.pic).append(" ");
    localStringBuilder.append("rank:").append(this.rank).append(" ");
    localStringBuilder.append("qScore:").append(this.qScore).append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansInfo.IdolItem
 * JD-Core Version:    0.7.0.1
 */