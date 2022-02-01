package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProRole;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public class GProRoleInfo
  implements IGProRoleInfo, Serializable
{
  private final GProRole role;
  
  public GProRoleInfo(GProRole paramGProRole)
  {
    this.role = paramGProRole;
  }
  
  public boolean getIsBind()
  {
    return this.role.getIsBind();
  }
  
  public String getRoleDescribe()
  {
    return this.role.getRoleDescribe();
  }
  
  public String getRoleId()
  {
    return this.role.getRoleId();
  }
  
  public String getRoleName()
  {
    return this.role.getRoleName();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProRoleInfo{RoleId : ");
    localStringBuilder.append(getRoleId());
    localStringBuilder.append(", RoleName : ");
    localStringBuilder.append(getRoleName());
    localStringBuilder.append(", RoleDescribe : ");
    localStringBuilder.append(getRoleDescribe());
    localStringBuilder.append(", IsBind : ");
    localStringBuilder.append(getIsBind());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProRoleInfo
 * JD-Core Version:    0.7.0.1
 */