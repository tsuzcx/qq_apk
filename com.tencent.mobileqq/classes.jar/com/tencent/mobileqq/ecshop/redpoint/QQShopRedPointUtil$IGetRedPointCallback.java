package com.tencent.mobileqq.ecshop.redpoint;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/redpoint/QQShopRedPointUtil$IGetRedPointCallback;", "", "onGetRedPoint", "", "redPointInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/ecshop/redpoint/RedPointInfo;", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface QQShopRedPointUtil$IGetRedPointCallback
{
  public abstract void a(@NotNull ArrayList<RedPointInfo> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil.IGetRedPointCallback
 * JD-Core Version:    0.7.0.1
 */