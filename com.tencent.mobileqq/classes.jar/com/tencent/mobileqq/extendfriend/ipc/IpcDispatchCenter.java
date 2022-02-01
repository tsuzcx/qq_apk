package com.tencent.mobileqq.extendfriend.ipc;

import android.os.Bundle;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/ipc/IpcDispatchCenter;", "", "mIpcModule", "Leipc/EIPCModule;", "defaultSyncHandler", "Lcom/tencent/mobileqq/extendfriend/ipc/IpcDispatchCenter$IpcSyncHandler;", "(Leipc/EIPCModule;Lcom/tencent/mobileqq/extendfriend/ipc/IpcDispatchCenter$IpcSyncHandler;)V", "mDefaultSyncHandler", "mDispatchMap", "Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;", "", "destroy", "", "handleMessage", "Leipc/EIPCResult;", "message", "params", "Landroid/os/Bundle;", "callbackId", "", "registerHandler", "syncHandler", "unregisterHandler", "IpcAsyncHandler", "IpcSyncHandler", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class IpcDispatchCenter
{
  private final QQConcurrentHashMap<String, IpcDispatchCenter.IpcSyncHandler> jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap;
  private final IpcDispatchCenter.IpcSyncHandler jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter$IpcSyncHandler;
  private final EIPCModule jdField_a_of_type_EipcEIPCModule;
  
  public IpcDispatchCenter(@NotNull EIPCModule paramEIPCModule, @Nullable IpcDispatchCenter.IpcSyncHandler paramIpcSyncHandler)
  {
    this.jdField_a_of_type_EipcEIPCModule = paramEIPCModule;
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap = new QQConcurrentHashMap(1023, 10, 4);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter$IpcSyncHandler = paramIpcSyncHandler;
  }
  
  @Nullable
  public final EIPCResult a(@NotNull String paramString, @Nullable Bundle paramBundle, int paramInt)
  {
    Object localObject2 = null;
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Object localObject1 = (IpcDispatchCenter.IpcSyncHandler)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(paramString);
    if (localObject1 != null) {}
    try
    {
      Bundle localBundle = ((IpcDispatchCenter.IpcSyncHandler)localObject1).a(paramString, paramBundle, paramInt);
      localObject1 = localBundle;
      if (localBundle == null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter$IpcSyncHandler;
        if (localObject1 == null) {
          break label102;
        }
      }
      label102:
      for (localObject1 = ((IpcDispatchCenter.IpcSyncHandler)localObject1).a(paramString, paramBundle, paramInt);; localObject1 = null)
      {
        paramString = localObject2;
        if (localObject1 != null)
        {
          paramString = EIPCResult.createSuccessResult((Bundle)localObject1);
          this.jdField_a_of_type_EipcEIPCModule.callbackResult(paramInt, paramString);
        }
        return paramString;
        localBundle = null;
        break;
      }
      return EIPCResult.createExceptionResult((Throwable)paramString);
    }
    catch (Exception paramString) {}
  }
  
  public final void a(@NotNull String paramString, @NotNull IpcDispatchCenter.IpcSyncHandler paramIpcSyncHandler)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Intrinsics.checkParameterIsNotNull(paramIpcSyncHandler, "syncHandler");
    ((Map)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap).put(paramString, paramIpcSyncHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.IpcDispatchCenter
 * JD-Core Version:    0.7.0.1
 */