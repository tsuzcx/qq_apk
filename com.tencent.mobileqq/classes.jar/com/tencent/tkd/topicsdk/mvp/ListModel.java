package com.tencent.tkd.topicsdk.mvp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mvp/ListModel;", "BEAN", "COOKIE", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListModel;", "()V", "hasNextPage", "", "getHasNextPage", "()Z", "setHasNextPage", "(Z)V", "mCookie", "Ljava/lang/Object;", "mErrorCode", "", "mErrorMsg", "", "mHasLoadedDataFromDB", "mHasLoadedDataFromNetwork", "mIsFirstLoadNetworkFailed", "mList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getMList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setMList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "mTotalSize", "getMTotalSize", "()I", "setMTotalSize", "(I)V", "total", "getTotal", "handleFirstPageDataFromDB", "", "list", "", "callback", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "isSuccess", "isCacheData", "errorCode", "errorMsg", "Lcom/tencent/tkd/topicsdk/mvp/FirstPageCallback;", "handleFirstPageDataFromNetwork", "needCache", "isEnd", "totalSize", "cookie", "(ZZZILjava/util/List;Ljava/lang/Object;ILjava/lang/String;Lkotlin/jvm/functions/Function6;)V", "loadDataFromDB", "Lkotlin/Function1;", "loadDataFromNetwork", "Lkotlin/Function7;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/tkd/topicsdk/mvp/LoadDataFromNetworkCallback;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function7;)V", "loadFirstPage", "loadNextPage", "Lkotlin/Function4;", "allList", "Lcom/tencent/tkd/topicsdk/mvp/NextPageCallback;", "resetStates", "saveDataToDB", "Companion", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public abstract class ListModel<BEAN, COOKIE>
  implements ListContract.IListModel<BEAN>
{
  public static final ListModel.Companion a = new ListModel.Companion(null);
  private boolean b;
  private boolean c;
  private boolean d;
  private int e;
  private String f = "";
  private COOKIE g;
  @NotNull
  private CopyOnWriteArrayList<BEAN> h = new CopyOnWriteArrayList();
  private boolean i;
  private int j;
  
  private final void a(List<? extends BEAN> paramList, Function6<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super Boolean, ? super Integer, ? super String, Unit> paramFunction6)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    this.c = true;
    boolean bool = this.b;
    Integer localInteger = Integer.valueOf(0);
    if (!bool)
    {
      this.h.addAll((Collection)paramList);
      this.i = false;
      paramFunction6.invoke(localBoolean, paramList, localInteger, localBoolean, localInteger, "");
      return;
    }
    if (this.d)
    {
      paramFunction6.invoke(Boolean.valueOf(false), paramList, localInteger, localBoolean, Integer.valueOf(this.e), this.f);
      return;
    }
    a((List)this.h);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, List<? extends BEAN> paramList, COOKIE paramCOOKIE, int paramInt2, String paramString, Function6<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super Boolean, ? super Integer, ? super String, Unit> paramFunction6)
  {
    this.b = true;
    if ((paramBoolean2) && (paramInt1 >= 0)) {
      this.j = paramInt1;
    }
    if (this.c)
    {
      if (paramBoolean2)
      {
        this.h.clear();
        this.h.addAll((Collection)paramList);
        a(paramList);
        this.g = paramCOOKIE;
        this.i = (paramBoolean3 ^ true);
      }
      paramFunction6.invoke(Boolean.valueOf(paramBoolean2), paramList, Integer.valueOf(paramInt1), Boolean.valueOf(false), Integer.valueOf(paramInt2), paramString);
      return;
    }
    if (paramBoolean2)
    {
      this.h.clear();
      this.h.addAll((Collection)paramList);
      this.g = paramCOOKIE;
      this.i = (paramBoolean3 ^ true);
      paramFunction6.invoke(Boolean.valueOf(paramBoolean2), paramList, Integer.valueOf(paramInt1), Boolean.valueOf(false), Integer.valueOf(paramInt2), paramString);
      return;
    }
    this.d = true;
    this.e = paramInt2;
    this.f = paramString;
    if (!paramBoolean1) {
      paramFunction6.invoke(Boolean.valueOf(paramBoolean2), paramList, Integer.valueOf(paramInt1), Boolean.valueOf(false), Integer.valueOf(paramInt2), paramString);
    }
  }
  
  private final void c()
  {
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = 0;
    this.f = "";
  }
  
  public abstract void a(@Nullable COOKIE paramCOOKIE, @NotNull Function7<? super Boolean, ? super Boolean, ? super Integer, ? super ArrayList<BEAN>, ? super COOKIE, ? super Integer, ? super String, Unit> paramFunction7);
  
  public abstract void a(@NotNull List<? extends BEAN> paramList);
  
  public abstract void a(@NotNull Function1<? super List<? extends BEAN>, Unit> paramFunction1);
  
  public void a(@NotNull Function4<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super String, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    a(this.g, (Function7)new ListModel.loadNextPage.1(this, paramFunction4));
  }
  
  protected final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void a(boolean paramBoolean, @NotNull Function6<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super Boolean, ? super Integer, ? super String, Unit> paramFunction6)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction6, "callback");
    c();
    if (paramBoolean) {
      a((Function1)new ListModel.loadFirstPage.1(this, paramFunction6));
    }
    a(null, (Function7)new ListModel.loadFirstPage.2(this, paramBoolean, paramFunction6));
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  @NotNull
  protected final CopyOnWriteArrayList<BEAN> b()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.ListModel
 * JD-Core Version:    0.7.0.1
 */