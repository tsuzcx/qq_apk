package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/manager/ActiveUserManager;", "", "()V", "mStatus", "Lcom/tencent/mobileqq/qqexpand/manager/ActiveUserManager$ActiveUserStatus;", "currentAccountUin", "", "isActiveUser", "", "markActive", "", "updateUserStatus", "rspBody", "Ltencent/im/usercategory/ExtendFriendUserCategory$GetUserStatusRsp;", "ActiveUserStatus", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ActiveUserManager
{
  public static final ActiveUserManager.Companion a;
  private final ActiveUserManager.ActiveUserStatus a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager$Companion = new ActiveUserManager.Companion(null);
  }
  
  public ActiveUserManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager$ActiveUserStatus = new ActiveUserManager.ActiveUserStatus(null, 0L, 0L, 7, null);
  }
  
  private final String a()
  {
    Object localObject = ExpandManager.a();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      if (localObject != null) {
        return localObject;
      }
    }
    return "Null";
  }
  
  public final void a()
  {
    ActiveUserManager.ActiveUserStatus.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager$ActiveUserStatus, a(), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()), null, true, 4, null);
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markActive() -> ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager$ActiveUserStatus);
      ((ILog)localObject).a("ActiveUserManager", 2, localStringBuilder.toString());
    }
  }
  
  public final void a(@NotNull ExtendFriendUserCategory.GetUserStatusRsp paramGetUserStatusRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetUserStatusRsp, "rspBody");
    Object localObject = a();
    long l1 = paramGetUserStatusRsp.LastLoginTime.get();
    long l2 = 1000;
    ActiveUserManager.ActiveUserStatus.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager$ActiveUserStatus, (String)localObject, null, Long.valueOf(l1 * l2), true, 2, null);
    paramGetUserStatusRsp = LogUtils.a;
    if (QLog.isColorLevel())
    {
      paramGetUserStatusRsp = paramGetUserStatusRsp.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUserStatus() -> ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager$ActiveUserStatus);
      paramGetUserStatusRsp.a("ActiveUserManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public final boolean a()
  {
    long l = Math.max(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager$ActiveUserStatus.a(), this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager$ActiveUserStatus.b());
    l = Math.abs(NetConnInfoCenter.getServerTimeMillis() - l);
    boolean bool;
    if (l < TimeUnit.DAYS.toMillis(7)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isActiveUser() -> ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", range: ");
      localStringBuilder.append(l);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager$ActiveUserStatus);
      ((ILog)localObject).a("ActiveUserManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ActiveUserManager
 * JD-Core Version:    0.7.0.1
 */