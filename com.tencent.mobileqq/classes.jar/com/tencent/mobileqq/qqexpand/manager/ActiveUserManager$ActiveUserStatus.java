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
  private long jdField_a_of_type_Long;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  public ActiveUserManager$ActiveUserStatus()
  {
    this(null, 0L, 0L, 7, null);
  }
  
  public ActiveUserManager$ActiveUserStatus(@NotNull String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  private final void a()
  {
    SharedPreUtils.a(this.jdField_a_of_type_JavaLangString, "extend_friend_config_785").edit().putLong("sp_extend_friend_latest_login_time", this.b).putLong("sp_extend_friend_latest_enter_time", this.jdField_a_of_type_Long).apply();
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
  
  private final void a(String paramString)
  {
    Object localObject = SharedPreUtils.a(paramString, "extend_friend_config_785");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = ((SharedPreferences)localObject).getLong("sp_extend_friend_latest_login_time", 0L);
    this.jdField_a_of_type_Long = ((SharedPreferences)localObject).getLong("sp_extend_friend_latest_enter_time", 0L);
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
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public final void a(@NotNull String paramString, @Nullable Long paramLong1, @Nullable Long paramLong2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramString) ^ true)) {
      a(paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramLong1 != null) {
      this.jdField_a_of_type_Long = ((Number)paramLong1).longValue();
    }
    if (paramLong2 != null) {
      this.b = ((Number)paramLong2).longValue();
    }
    if (paramBoolean) {
      a();
    }
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ActiveUserStatus))
      {
        paramObject = (ActiveUserStatus)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (this.b == paramObject.b)) {}
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
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    long l = this.jdField_a_of_type_Long;
    int j = (int)(l ^ l >>> 32);
    l = this.b;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActiveUserStatus(uin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", latestEnterMills=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", latestLoginMills=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ActiveUserManager.ActiveUserStatus
 * JD-Core Version:    0.7.0.1
 */