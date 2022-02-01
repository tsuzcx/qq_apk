package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import androidx.annotation.NonNull;

public class GuildClientManageViewModel$RoleInfo
{
  public boolean a = false;
  public String b = "";
  public String c = "";
  
  public GuildClientManageViewModel$RoleInfo() {}
  
  public GuildClientManageViewModel$RoleInfo(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.a = paramBoolean;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public boolean a()
  {
    return (this.a) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.b));
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsBind: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mRoleName: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mRoleId: ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel.RoleInfo
 * JD-Core Version:    0.7.0.1
 */