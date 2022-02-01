package com.tencent.tkd.topicsdk.selectowner;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "cookieNew", "", "isEnd", "", "topicList", "", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class SelectTopicModel$loadDataFromNetwork$1
  extends Lambda
  implements Function5<Integer, String, byte[], Boolean, List<? extends TopicInfo>, Unit>
{
  SelectTopicModel$loadDataFromNetwork$1(Function7 paramFunction7)
  {
    super(5);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<TopicInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    ThreadManagerKt.a((Function0)new SelectTopicModel.loadDataFromNetwork.1.1(this, paramInt, paramBoolean, paramList, paramArrayOfByte, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectTopicModel.loadDataFromNetwork.1
 * JD-Core Version:    0.7.0.1
 */