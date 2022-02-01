package com.tencent.tkd.topicsdk.selecttopic;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "cookieStr", "isEnd", "", "communityList", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class SelectCommunityModel$loadDataFromNetwork$1
  extends Lambda
  implements Function5<Integer, String, String, Boolean, List<? extends CommunityInfo>, Unit>
{
  SelectCommunityModel$loadDataFromNetwork$1(Function7 paramFunction7)
  {
    super(5);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString1, @Nullable String paramString2, boolean paramBoolean, @Nullable List<CommunityInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "errorMsg");
    ThreadManagerKt.a((Function0)new SelectCommunityModel.loadDataFromNetwork.1.1(this, paramInt, paramString2, paramBoolean, paramList, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selecttopic.SelectCommunityModel.loadDataFromNetwork.1
 * JD-Core Version:    0.7.0.1
 */