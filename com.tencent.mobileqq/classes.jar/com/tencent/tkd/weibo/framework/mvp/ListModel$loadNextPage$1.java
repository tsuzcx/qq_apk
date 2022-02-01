package com.tencent.tkd.weibo.framework.mvp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "COOKIE", "isSuccess", "", "isEnd", "totalSize", "", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "cookie", "errorCode", "errorMsg", "", "invoke", "(ZZILjava/util/ArrayList;Ljava/lang/Object;ILjava/lang/String;)V"}, k=3, mv={1, 1, 16})
final class ListModel$loadNextPage$1
  extends Lambda
  implements Function7<Boolean, Boolean, Integer, ArrayList<BEAN>, COOKIE, Integer, String, Unit>
{
  ListModel$loadNextPage$1(ListModel paramListModel, Function4 paramFunction4)
  {
    super(7);
  }
  
  public final void invoke(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, @NotNull ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "list");
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    this.this$0.a().addAll((Collection)paramArrayList);
    if (paramBoolean1)
    {
      ListModel.a(this.this$0, paramCOOKIE);
      paramArrayList = this.this$0;
      if (paramBoolean2) {
        break label90;
      }
    }
    label90:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      paramArrayList.a(paramBoolean2);
      this.$callback.invoke(Boolean.valueOf(paramBoolean1), this.this$0.a(), Integer.valueOf(paramInt2), paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.ListModel.loadNextPage.1
 * JD-Core Version:    0.7.0.1
 */