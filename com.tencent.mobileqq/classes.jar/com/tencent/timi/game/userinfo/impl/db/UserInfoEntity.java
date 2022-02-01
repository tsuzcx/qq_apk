package com.tencent.timi.game.userinfo.impl.db;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import java.util.Arrays;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uid")
public class UserInfoEntity
  extends BaseTimiGameEntity
{
  public int authStatus;
  public byte[] defaultSmobaRoleExtInfo;
  public String extensionAvatar;
  public String extensionNick;
  public byte[] groupProInfo;
  public byte[] qqBaseInfo;
  public long uid = 0L;
  public byte[] userGameOpenid;
  public byte[] userRoomList;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserInfoEntity{, qqBaseInfo=");
    localStringBuilder.append(Arrays.toString(this.qqBaseInfo));
    localStringBuilder.append(", userGameOpenid=");
    localStringBuilder.append(Arrays.toString(this.userGameOpenid));
    localStringBuilder.append(", extensionAvatar='");
    localStringBuilder.append(this.extensionAvatar);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extensionNick=");
    localStringBuilder.append(this.extensionNick);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.db.UserInfoEntity
 * JD-Core Version:    0.7.0.1
 */