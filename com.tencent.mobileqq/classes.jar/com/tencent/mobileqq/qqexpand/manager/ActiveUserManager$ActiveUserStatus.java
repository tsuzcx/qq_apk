package com.tencent.mobileqq.qqexpand.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/manager/ActiveUserManager$ActiveUserStatus;", "", "uin", "", "latestEnterMills", "", "latestLoginMills", "(Ljava/lang/String;JJ)V", "getLatestEnterMills", "()J", "setLatestEnterMills", "(J)V", "getLatestLoginMills", "setLatestLoginMills", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "loadSp", "", "saveSp", "toString", "update", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Z)V", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ActiveUserManager$ActiveUserStatus
{
  @NotNull
  private String a;
  private long b;
  private long c;
  
  public ActiveUserManager$ActiveUserStatus()
  {
    this(null, 0L, 0L, 7, null);
  }
  
  public ActiveUserManager$ActiveUserStatus(@NotNull String paramString, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramLong2;
    a(this.a);
  }
  
  private final void a(String paramString)
  {
    Object localObject = SharedPreUtils.a(paramString, "extend_friend_config_785");
    this.a = paramString;
    this.c = ((SharedPreferences)localObject).getLong("sp_extend_friend_latest_login_time", 0L);
    this.b = ((SharedPreferences)localObject).getLong("sp_extend_friend_latest_enter_time", 0L);
    localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSp(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(") -> ");
      localStringBuilder.append(this);
      ((ILog)localObject).a("ActiveUserManager", 2, localStringBuilder.toString());
    }
  }
  
  private final void c()
  {
    SharedPreUtils.a(this.a, "extend_friend_config_785").edit().putLong("sp_extend_friend_latest_login_time", this.c).putLong("sp_extend_friend_latest_enter_time", this.b).apply();
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSp() -> ");
      localStringBuilder.append(this);
      ((ILog)localObject).a("ActiveUserManager", 2, localStringBuilder.toString());
    }
  }
  
  public final long a()
  {
    return this.b;
  }
  
  public final void a(@NotNull String paramString, @Nullable Long paramLong1, @Nullable Long paramLong2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    if ((Intrinsics.areEqual(this.a, paramString) ^ true)) {
      a(paramString);
    }
    this.a = paramString;
    if (paramLong1 != null) {
      this.b = ((Number)paramLong1).longValue();
    }
    if (paramLong2 != null) {
      this.c = ((Number)paramLong2).longValue();
    }
    if (paramBoolean) {
      c();
    }
  }
  
  public final long b()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ActiveUserStatus))
      {
        paramObject = (ActiveUserStatus)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    long l = this.b;
    int j = (int)(l ^ l >>> 32);
    l = this.c;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActiveUserStatus(uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", latestEnterMills=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", latestLoginMills=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ActiveUserManager.ActiveUserStatus
 * JD-Core Version:    0.7.0.1
 */