package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.kandian.biz.publisher.column.IColumnModel.IColumnCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/DataTransferImpl$editTopic$1", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnCallback;", "onResult", "", "errorCode", "", "errorMsg", "", "bizCode", "columnId", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataTransferImpl$editTopic$1
  implements IColumnModel.IColumnCallback
{
  public void a(int paramInt1, @NotNull String paramString, int paramInt2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    int i = 0;
    if ((paramInt1 == 0) && (paramLong != 0L)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      paramInt1 = i;
    } else {
      paramInt1 = -1;
    }
    this.a.invoke(Integer.valueOf(paramInt1), paramString, String.valueOf(paramInt2), Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.DataTransferImpl.editTopic.1
 * JD-Core Version:    0.7.0.1
 */