package com.tencent.tkd.weibo.framework.mvp;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "COOKIE", "isSuccess", "", "isEnd", "totalSize", "", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "cookie", "errorCode", "errorMsg", "", "invoke", "(ZZILjava/util/ArrayList;Ljava/lang/Object;ILjava/lang/String;)V"}, k=3, mv={1, 1, 16})
final class ListModel$loadFirstPage$2
  extends Lambda
  implements Function7<Boolean, Boolean, Integer, ArrayList<BEAN>, COOKIE, Integer, String, Unit>
{
  ListModel$loadFirstPage$2(ListModel paramListModel, boolean paramBoolean, Function6 paramFunction6)
  {
    super(7);
  }
  
  public final void invoke(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, @NotNull ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "list");
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    ListModel.a(this.this$0, this.$needCache, paramBoolean1, paramBoolean2, paramInt1, (List)paramArrayList, paramCOOKIE, paramInt2, paramString, this.$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.ListModel.loadFirstPage.2
 * JD-Core Version:    0.7.0.1
 */