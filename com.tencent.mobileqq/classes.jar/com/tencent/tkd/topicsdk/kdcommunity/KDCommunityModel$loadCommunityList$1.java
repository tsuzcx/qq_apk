package com.tencent.tkd.topicsdk.kdcommunity;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "", "communityList", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class KDCommunityModel$loadCommunityList$1
  extends Lambda
  implements Function5<Integer, String, String, Boolean, List<? extends CommunityInfo>, Unit>
{
  KDCommunityModel$loadCommunityList$1(Function3 paramFunction3)
  {
    super(5);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString1, @Nullable String paramString2, boolean paramBoolean, @Nullable List<CommunityInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "errorMsg");
    paramString2 = new StringBuilder();
    paramString2.append("loadCommunityList, errorCode=");
    paramString2.append(paramInt);
    paramString2.append(", errorMsg=");
    paramString2.append(paramString1);
    TLog.a("KDCommunityModel", paramString2.toString());
    this.$callback.invoke(Integer.valueOf(paramInt), paramString1, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.KDCommunityModel.loadCommunityList.1
 * JD-Core Version:    0.7.0.1
 */