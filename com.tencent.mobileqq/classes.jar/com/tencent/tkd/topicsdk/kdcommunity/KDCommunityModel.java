package com.tencent.tkd.topicsdk.kdcommunity;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.framework.DataTransferManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityModel;", "Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IModel;", "()V", "loadCommunityList", "", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMsg", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class KDCommunityModel
  implements KDCommunityContract.IModel
{
  public static final KDCommunityModel.Companion a = new KDCommunityModel.Companion(null);
  
  public void a(@NotNull Function3<? super Integer, ? super String, ? super List<CommunityInfo>, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "callback");
    DataTransferManager.a.a(null, (Function5)new KDCommunityModel.loadCommunityList.1(paramFunction3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.KDCommunityModel
 * JD-Core Version:    0.7.0.1
 */