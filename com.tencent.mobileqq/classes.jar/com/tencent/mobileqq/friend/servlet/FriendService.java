package com.tencent.mobileqq.friend.servlet;

import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.friend.servlet.coder.BaseJCECoder;
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
    BaseJCECoder localBaseJCECoder1 = (BaseJCECoder)null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext())
    {
      BaseJCECoder localBaseJCECoder2 = (BaseJCECoder)localIterator.next();
      if (localBaseJCECoder2.a(paramString)) {
        return localBaseJCECoder2;
      }
    }
    return localBaseJCECoder1;
  }
  
  /* Error */
  private final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 106
    //   4: iconst_1
    //   5: new 108	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   12: ldc 111
    //   14: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: getfield 83	com/tencent/mobileqq/friend/servlet/FriendService:jdField_a_of_type_Boolean	Z
    //   21: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   24: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aload_0
    //   31: getfield 83	com/tencent/mobileqq/friend/servlet/FriendService:jdField_a_of_type_Boolean	Z
    //   34: istore_1
    //   35: iload_1
    //   36: ifeq +6 -> 42
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield 72	com/tencent/mobileqq/friend/servlet/FriendService:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   46: new 130	com/tencent/mobileqq/friend/servlet/coder/FriendListJCECoder
    //   49: dup
    //   50: invokespecial 131	com/tencent/mobileqq/friend/servlet/coder/FriendListJCECoder:<init>	()V
    //   53: invokevirtual 135	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   56: pop
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 83	com/tencent/mobileqq/friend/servlet/FriendService:jdField_a_of_type_Boolean	Z
    //   62: goto -23 -> 39
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	FriendService
    //   34	2	1	bool	boolean
    //   65	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	65	finally
    //   42	62	65	finally
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
    Object localObject1 = null;
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject2 = paramFromServiceMsg.getServiceCmd();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "response.serviceCmd");
      localObject2 = a((String)localObject2);
      if (localObject2 != null) {
        localObject1 = ((BaseJCECoder)localObject2).a(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    for (;;)
    {
      a(paramToServiceMsg, paramFromServiceMsg, localObject1);
      return;
      QLog.d("IMCore.friend.FriendServlet", 1, "onReceive[" + paramFromServiceMsg.getServiceCmd() + "]: coder is null");
      continue;
      QLog.d("IMCore.friend.FriendServlet", 1, "onReceive[" + paramFromServiceMsg.getServiceCmd() + "]: response is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.servlet.FriendService
 * JD-Core Version:    0.7.0.1
 */