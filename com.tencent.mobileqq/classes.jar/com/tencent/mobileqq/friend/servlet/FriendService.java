package com.tencent.mobileqq.friend.servlet;

import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.friend.servlet.coder.BaseJCECoder;
import com.tencent.mobileqq.friend.servlet.coder.FriendAddJCECoder;
import com.tencent.mobileqq.friend.servlet.coder.FriendListJCECoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/servlet/FriendService;", "", "app", "Lcom/tencent/common/app/AppInterface;", "(Lcom/tencent/common/app/AppInterface;)V", "isCoderInit", "", "mCoderSet", "Ljava/util/HashSet;", "Lcom/tencent/mobileqq/friend/servlet/coder/BaseJCECoder;", "Lkotlin/collections/HashSet;", "seq", "", "getCoder", "cmd", "", "handleResponse", "", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "initCoder", "notifyResult", "data", "sendRequest", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendService
{
  public static final FriendService.Companion a;
  private volatile int jdField_a_of_type_Int;
  private final AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private HashSet<BaseJCECoder> jdField_a_of_type_JavaUtilHashSet;
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqFriendServletFriendService$Companion = new FriendService.Companion(null);
  }
  
  public FriendService(@NotNull AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private final BaseJCECoder a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    BaseJCECoder localBaseJCECoder2 = (BaseJCECoder)null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    BaseJCECoder localBaseJCECoder1;
    do
    {
      localBaseJCECoder1 = localBaseJCECoder2;
      if (!localIterator.hasNext()) {
        break;
      }
      localBaseJCECoder1 = (BaseJCECoder)localIterator.next();
    } while (!localBaseJCECoder1.a(paramString));
    return localBaseJCECoder1;
  }
  
  private final void a()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initJCECoder: ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("IMCore.friend.FriendService", 1, localStringBuilder.toString());
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(new FriendListJCECoder());
      this.jdField_a_of_type_JavaUtilHashSet.add(new FriendAddJCECoder());
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(Reflection.getOrCreateKotlinClass(FriendHandler.class).getQualifiedName()).onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public final void a(@NotNull ToServiceMsg paramToServiceMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    paramToServiceMsg = (Runnable)new FriendService.sendRequest.requestTask.1(this, paramToServiceMsg);
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localLooper, "Looper.getMainLooper()");
    if (Intrinsics.areEqual(localThread, localLooper.getThread()))
    {
      ThreadManager.excute(paramToServiceMsg, 16, null, false);
      return;
    }
    paramToServiceMsg.run();
  }
  
  public final void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "response");
    if (paramFromServiceMsg.isSuccess())
    {
      localObject = paramFromServiceMsg.getServiceCmd();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "response.serviceCmd");
      localObject = a((String)localObject);
      if (localObject != null)
      {
        localObject = ((BaseJCECoder)localObject).a(paramToServiceMsg, paramFromServiceMsg);
        break label137;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive[");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      ((StringBuilder)localObject).append("]: coder is null");
      QLog.d("IMCore.friend.FriendServlet", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive[");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      ((StringBuilder)localObject).append("]: response is fail");
      QLog.d("IMCore.friend.FriendServlet", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    label137:
    a(paramToServiceMsg, paramFromServiceMsg, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.servlet.FriendService
 * JD-Core Version:    0.7.0.1
 */