package com.tencent.tkd.topicsdk.uiImpl;

import com.tencent.tkd.topicsdk.framework.DataTransferManager;
import com.tencent.tkd.weibo.data.IDataTransfer;
import com.tencent.tkd.weibo.data.IDataTransfer.ContactCallback;
import com.tencent.tkd.weibo.data.IDataTransfer.TopicCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/uiImpl/UIDataTransferImpl;", "Lcom/tencent/tkd/weibo/data/IDataTransfer;", "()V", "getMyFansList", "", "cookie", "", "callback", "Lcom/tencent/tkd/weibo/data/IDataTransfer$ContactCallback;", "getMyFollowList", "getTweetHotList", "pageNum", "", "Lcom/tencent/tkd/weibo/data/IDataTransfer$TopicCallback;", "getTweetRecentTopicList", "getTweetSearchTopicList", "wording", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class UIDataTransferImpl
  implements IDataTransfer
{
  public void a(int paramInt, @NotNull IDataTransfer.TopicCallback paramTopicCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicCallback, "callback");
    DataTransferManager.a(DataTransferManager.a, paramInt, 0, (Function4)new UIDataTransferImpl.getTweetHotList.1(paramInt, paramTopicCallback), 2, null);
  }
  
  public void a(@NotNull String paramString, int paramInt, @NotNull IDataTransfer.TopicCallback paramTopicCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    Intrinsics.checkParameterIsNotNull(paramTopicCallback, "callback");
    DataTransferManager.a(DataTransferManager.a, paramInt, paramString, 0, (Function4)new UIDataTransferImpl.getTweetSearchTopicList.1(paramInt, paramTopicCallback), 4, null);
  }
  
  public void a(@Nullable byte[] paramArrayOfByte, @NotNull IDataTransfer.ContactCallback paramContactCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramContactCallback, "callback");
    DataTransferManager.b(DataTransferManager.a, paramArrayOfByte, 0, (Function5)new UIDataTransferImpl.getMyFansList.1(paramContactCallback), 2, null);
  }
  
  public void b(@Nullable byte[] paramArrayOfByte, @NotNull IDataTransfer.ContactCallback paramContactCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramContactCallback, "callback");
    DataTransferManager.a(DataTransferManager.a, paramArrayOfByte, 0, (Function5)new UIDataTransferImpl.getMyFollowList.1(paramContactCallback), 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.uiImpl.UIDataTransferImpl
 * JD-Core Version:    0.7.0.1
 */