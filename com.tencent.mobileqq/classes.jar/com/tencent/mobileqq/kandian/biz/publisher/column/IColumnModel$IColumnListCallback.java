package com.tencent.mobileqq.kandian.biz.publisher.column;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnListCallback;", "", "onResult", "", "errorCode", "", "errorMsg", "", "cookie", "", "isEnd", "", "topicList", "", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IColumnModel$IColumnListCallback
{
  public abstract void a(int paramInt, @NotNull String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<TopicInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.column.IColumnModel.IColumnListCallback
 * JD-Core Version:    0.7.0.1
 */