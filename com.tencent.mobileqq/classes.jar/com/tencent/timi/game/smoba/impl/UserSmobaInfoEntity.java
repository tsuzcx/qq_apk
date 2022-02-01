package com.tencent.timi.game.smoba.impl;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uin")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/UserSmobaInfoEntity;", "Lcom/tencent/timi/game/databasecore/impl/base/BaseTimiGameEntity;", "()V", "accountListInfo", "", "authDescInfo", "defaultAccountInfo", "uin", "", "toString", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserSmobaInfoEntity
  extends BaseTimiGameEntity
{
  public static final UserSmobaInfoEntity.Companion Companion = new UserSmobaInfoEntity.Companion(null);
  @JvmField
  @Nullable
  public byte[] accountListInfo;
  @JvmField
  @Nullable
  public byte[] authDescInfo;
  @JvmField
  @Nullable
  public byte[] defaultAccountInfo;
  @JvmField
  @NotNull
  public String uin = "";
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:");
    localStringBuilder.append(LogUtil.getSafePrintUin(this.uin));
    localStringBuilder.append(", defaultAccountInfo:");
    localStringBuilder.append(this.defaultAccountInfo);
    localStringBuilder.append(", ");
    localStringBuilder.append("accountListInfo:");
    localStringBuilder.append(this.accountListInfo);
    localStringBuilder.append(", authDescInfo:");
    localStringBuilder.append(this.authDescInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.UserSmobaInfoEntity
 * JD-Core Version:    0.7.0.1
 */