package com.tencent.tkd.topicsdk.kdcommunity;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IModel;", "", "loadCommunityList", "", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMsg", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface KDCommunityContract$IModel
{
  public abstract void a(@NotNull Function3<? super Integer, ? super String, ? super List<CommunityInfo>, Unit> paramFunction3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.KDCommunityContract.IModel
 * JD-Core Version:    0.7.0.1
 */