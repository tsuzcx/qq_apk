package com.tencent.mobileqq.kandian.biz.publisher.column;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel;", "", "createColumn", "", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "callback", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnCallback;", "editColumn", "getColumnList", "cookie", "", "topTopicId", "", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnListCallback;", "IColumnCallback", "IColumnListCallback", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IColumnModel
{
  public abstract void a(@Nullable byte[] paramArrayOfByte, long paramLong, @Nullable IColumnModel.IColumnListCallback paramIColumnListCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.column.IColumnModel
 * JD-Core Version:    0.7.0.1
 */