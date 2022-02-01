package com.tencent.tkd.topicsdk.kdcommunity;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "<anonymous parameter 1>", "", "list", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class KDCommunityPresenter$refreshCommunityList$1$1
  extends Lambda
  implements Function3<Integer, String, List<? extends CommunityInfo>, Unit>
{
  KDCommunityPresenter$refreshCommunityList$1$1(KDCommunityContract.IView paramIView)
  {
    super(3);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable List<CommunityInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 1>");
    this.$this_apply.b();
    if (paramInt == 0)
    {
      paramString = (Collection)paramList;
      if ((paramString != null) && (!paramString.isEmpty())) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      if (paramInt == 0)
      {
        this.$this_apply.c();
        this.$this_apply.a(paramList);
        return;
      }
    }
    this.$this_apply.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.KDCommunityPresenter.refreshCommunityList.1.1
 * JD-Core Version:    0.7.0.1
 */