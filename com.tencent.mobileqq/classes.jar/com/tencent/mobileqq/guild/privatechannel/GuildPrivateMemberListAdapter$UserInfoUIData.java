package com.tencent.mobileqq.guild.privatechannel;

import android.text.TextUtils;
import java.io.Serializable;

public class GuildPrivateMemberListAdapter$UserInfoUIData
  implements Serializable
{
  public static final int GAP = 1;
  public static final int ITEM_CELL = 0;
  public static final int TITLE = 2;
  public String mName = "";
  public boolean mSelectable;
  public String mTinyId = "";
  public String mTitleName = "";
  public int mType;
  
  public GuildPrivateMemberListAdapter$UserInfoUIData(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public boolean isEqual(UserInfoUIData paramUserInfoUIData)
  {
    if (paramUserInfoUIData == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.mTinyId)) && (!this.mTinyId.equals(paramUserInfoUIData.mTinyId))) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.mName)) && (!this.mName.equals(paramUserInfoUIData.mName))) {
      return false;
    }
    if (this.mSelectable != paramUserInfoUIData.mSelectable) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.mTitleName)) && (!this.mTitleName.equals(paramUserInfoUIData.mTitleName))) {
      return false;
    }
    return this.mType == paramUserInfoUIData.mType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData
 * JD-Core Version:    0.7.0.1
 */