package com.tencent.mobileqq.friend.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.friend.config.FriendConfig;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.friend.handler.recevier.BaseProtocolReceiver;
import com.tencent.mobileqq.friend.handler.recevier.FriendListReceiver;
import com.tencent.mobileqq.friend.handler.recevier.SetGroupReceiver;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.friend.processor.FriendBusinessProcessorFactory;
import com.tencent.mobileqq.friend.servlet.FriendService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/handler/FriendHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/common/app/AppInterface;", "(Lcom/tencent/common/app/AppInterface;)V", "mBusinessProcessorFactory", "Lcom/tencent/mobileqq/friend/processor/FriendBusinessProcessorFactory;", "mBusinessProcessors", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/friend/processor/BaseFriendProcessor;", "Lkotlin/collections/ArrayList;", "getMBusinessProcessors", "()Ljava/util/ArrayList;", "setMBusinessProcessors", "(Ljava/util/ArrayList;)V", "mConfig", "Lcom/tencent/mobileqq/friend/config/FriendConfig;", "getMConfig", "()Lcom/tencent/mobileqq/friend/config/FriendConfig;", "mProtocolProcessors", "Lcom/tencent/mobileqq/friend/handler/recevier/BaseProtocolReceiver;", "mRequestFriendListTimestamp", "", "getMRequestFriendListTimestamp", "()J", "setMRequestFriendListTimestamp", "(J)V", "mService", "Lcom/tencent/mobileqq/friend/servlet/FriendService;", "getMService", "()Lcom/tencent/mobileqq/friend/servlet/FriendService;", "initProtocolProcessors", "", "isRequestingFriendList", "", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "requestFriendGroup", "requestData", "Lcom/tencent/mobileqq/friend/data/GroupRequestData;", "requestFriendList", "Lcom/tencent/mobileqq/friend/data/FriendListRequestData;", "checkFreq", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendHandler
  extends BusinessHandler
{
  public static final FriendHandler.Companion a;
  private long jdField_a_of_type_Long;
  @NotNull
  private final FriendConfig jdField_a_of_type_ComTencentMobileqqFriendConfigFriendConfig;
  private final FriendBusinessProcessorFactory jdField_a_of_type_ComTencentMobileqqFriendProcessorFriendBusinessProcessorFactory;
  @NotNull
  private final FriendService jdField_a_of_type_ComTencentMobileqqFriendServletFriendService;
  @NotNull
  private ArrayList<BaseFriendProcessor> jdField_a_of_type_JavaUtilArrayList;
  private final ArrayList<BaseProtocolReceiver<FriendHandler>> b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqFriendHandlerFriendHandler$Companion = new FriendHandler.Companion(null);
  }
  
  public FriendHandler(@NotNull AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFriendServletFriendService = new FriendService(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFriendConfigFriendConfig = new FriendConfig((AppRuntime)paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFriendProcessorFriendBusinessProcessorFactory = new FriendBusinessProcessorFactory();
    this.b = new ArrayList();
    paramAppInterface = this.jdField_a_of_type_ComTencentMobileqqFriendProcessorFriendBusinessProcessorFactory.a((AppRuntime)this.appRuntime);
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "mBusinessProcessorFactor…getProcessors(appRuntime)");
    this.jdField_a_of_type_JavaUtilArrayList = paramAppInterface;
    a();
  }
  
  private final void a()
  {
    ArrayList localArrayList = this.b;
    AppInterface localAppInterface = this.appRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localAppInterface, "appRuntime");
    localArrayList.add(new FriendListReceiver(localAppInterface, this));
    localArrayList = this.b;
    localAppInterface = this.appRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localAppInterface, "appRuntime");
    localArrayList.add(new SetGroupReceiver(localAppInterface, this));
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final FriendConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendConfigFriendConfig;
  }
  
  @NotNull
  public final FriendService a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendServletFriendService;
  }
  
  @NotNull
  public final ArrayList<BaseFriendProcessor> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void a(@NotNull FriendListRequestData paramFriendListRequestData, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFriendListRequestData, "requestData");
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendHandler", 2, "requestFriendList| requestData: " + paramFriendListRequestData + ", checkFreq: " + paramBoolean);
    }
    long l = System.currentTimeMillis();
    if (!paramFriendListRequestData.isRequestSingle())
    {
      if ((paramBoolean) && (a()) && (l - this.jdField_a_of_type_Long < 300000L))
      {
        QLog.d("IMCore.friend.FriendHandler", 1, "requestFriendList| request too busy");
        return;
      }
      this.jdField_a_of_type_Long = l;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.getFriendGroupList");
    Intrinsics.checkExpressionValueIsNotNull(localToServiceMsg, "createToServiceMsg(Frien…MD.GET_FRIEND_GROUP_LIST)");
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.extraData.putSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName(), (Serializable)paramFriendListRequestData);
    this.jdField_a_of_type_ComTencentMobileqqFriendServletFriendService.a(localToServiceMsg);
  }
  
  public final void a(@NotNull GroupRequestData paramGroupRequestData)
  {
    Intrinsics.checkParameterIsNotNull(paramGroupRequestData, "requestData");
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendHandler", 2, "requestFriendGroup| requestData: " + paramGroupRequestData);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putSerializable(Reflection.getOrCreateKotlinClass(GroupRequestData.class).getSimpleName(), (Serializable)paramGroupRequestData);
    paramGroupRequestData = this.jdField_a_of_type_ComTencentMobileqqFriendServletFriendService;
    Intrinsics.checkExpressionValueIsNotNull(localToServiceMsg, "request");
    paramGroupRequestData.a(localToServiceMsg);
  }
  
  public final boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendHandler", 2, "isRequestingFriendList, timestamp: " + this.jdField_a_of_type_Long);
    }
    return this.jdField_a_of_type_Long > 0L;
  }
  
  @NotNull
  public Class<? extends BusinessObserver> observerClass()
  {
    return IFriendObserver.class;
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      QLog.e("IMCore.friend.FriendHandler", 1, "onReceive| req == null || res == null");
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.FriendHandler", 2, "onReceive| " + paramToServiceMsg.getServiceCmd());
      }
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        BaseProtocolReceiver localBaseProtocolReceiver = (BaseProtocolReceiver)localIterator.next();
        String str = paramToServiceMsg.getServiceCmd();
        Intrinsics.checkExpressionValueIsNotNull(str, "req.serviceCmd");
        if (localBaseProtocolReceiver.a(str)) {
          localBaseProtocolReceiver.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.FriendHandler
 * JD-Core Version:    0.7.0.1
 */