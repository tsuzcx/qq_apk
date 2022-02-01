package com.tencent.tkd.weibo.framework.mvp;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/framework/mvp/ListModel;", "BEAN", "COOKIE", "Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListModel;", "()V", "hasNextPage", "", "getHasNextPage", "()Z", "setHasNextPage", "(Z)V", "mCookie", "Ljava/lang/Object;", "mErrorCode", "", "mErrorMsg", "", "mHasLoadedDataFromDB", "mHasLoadedDataFromNetwork", "mIsFirstLoadNetworkFailed", "mList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getMList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setMList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "mTotalSize", "getMTotalSize", "()I", "setMTotalSize", "(I)V", "total", "getTotal", "handleFirstPageDataFromDB", "", "list", "", "callback", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "isSuccess", "isCacheData", "errorCode", "errorMsg", "Lcom/tencent/tkd/weibo/framework/mvp/FirstPageCallback;", "handleFirstPageDataFromNetwork", "needCache", "isEnd", "totalSize", "cookie", "(ZZZILjava/util/List;Ljava/lang/Object;ILjava/lang/String;Lkotlin/jvm/functions/Function6;)V", "loadDataFromDB", "Lkotlin/Function1;", "loadDataFromNetwork", "Lkotlin/Function7;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/tkd/weibo/framework/mvp/LoadDataFromNetworkCallback;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function7;)V", "loadFirstPage", "loadNextPage", "Lkotlin/Function4;", "allList", "Lcom/tencent/tkd/weibo/framework/mvp/NextPageCallback;", "resetStates", "saveDataToDB", "Companion", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public abstract class ListModel<BEAN, COOKIE>
  implements ListContract.IListModel<BEAN>
{
  public static final ListModel.Companion a;
  private int jdField_a_of_type_Int;
  private COOKIE jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString = "";
  @NotNull
  private CopyOnWriteArrayList<BEAN> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListModel$Companion = new ListModel.Companion(null);
  }
  
  private final void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private final void a(List<? extends BEAN> paramList, Function6<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super Boolean, ? super Integer, ? super String, Unit> paramFunction6)
  {
    this.jdField_b_of_type_Boolean = true;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((Collection)paramList);
      this.d = false;
      paramFunction6.invoke(Boolean.valueOf(true), paramList, Integer.valueOf(0), Boolean.valueOf(true), Integer.valueOf(0), "");
      return;
    }
    if (this.c)
    {
      paramFunction6.invoke(Boolean.valueOf(false), paramList, Integer.valueOf(0), Boolean.valueOf(true), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
      return;
    }
    a((List)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, List<? extends BEAN> paramList, COOKIE paramCOOKIE, int paramInt2, String paramString, Function6<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super Boolean, ? super Integer, ? super String, Unit> paramFunction6)
  {
    this.jdField_a_of_type_Boolean = true;
    if ((paramBoolean2) && (paramInt1 >= 0)) {
      this.jdField_b_of_type_Int = paramInt1;
    }
    if (this.jdField_b_of_type_Boolean) {
      if (paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((Collection)paramList);
        a(paramList);
        this.jdField_a_of_type_JavaLangObject = paramCOOKIE;
        if (!paramBoolean3)
        {
          paramBoolean1 = true;
          this.d = paramBoolean1;
        }
      }
      else
      {
        paramFunction6.invoke(Boolean.valueOf(paramBoolean2), paramList, Integer.valueOf(paramInt1), Boolean.valueOf(false), Integer.valueOf(paramInt2), paramString);
      }
    }
    do
    {
      return;
      paramBoolean1 = false;
      break;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((Collection)paramList);
        this.jdField_a_of_type_JavaLangObject = paramCOOKIE;
        if (!paramBoolean3) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          this.d = paramBoolean1;
          paramFunction6.invoke(Boolean.valueOf(paramBoolean2), paramList, Integer.valueOf(paramInt1), Boolean.valueOf(false), Integer.valueOf(paramInt2), paramString);
          return;
        }
      }
      this.c = true;
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_a_of_type_JavaLangString = paramString;
    } while (paramBoolean1);
    paramFunction6.invoke(Boolean.valueOf(paramBoolean2), paramList, Integer.valueOf(paramInt1), Boolean.valueOf(false), Integer.valueOf(paramInt2), paramString);
  }
  
  @NotNull
  protected final CopyOnWriteArrayList<BEAN> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public abstract void a(@Nullable COOKIE paramCOOKIE, @NotNull Function7<? super Boolean, ? super Boolean, ? super Integer, ? super ArrayList<BEAN>, ? super COOKIE, ? super Integer, ? super String, Unit> paramFunction7);
  
  public abstract void a(@NotNull List<? extends BEAN> paramList);
  
  public abstract void a(@NotNull Function1<? super List<? extends BEAN>, Unit> paramFunction1);
  
  public void a(@NotNull Function4<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super String, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    a(this.jdField_a_of_type_JavaLangObject, (Function7)new ListModel.loadNextPage.1(this, paramFunction4));
  }
  
  protected final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void a(boolean paramBoolean, @NotNull Function6<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super Boolean, ? super Integer, ? super String, Unit> paramFunction6)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction6, "callback");
    a();
    if (paramBoolean) {
      a((Function1)new ListModel.loadFirstPage.1(this, paramFunction6));
    }
    a(null, (Function7)new ListModel.loadFirstPage.2(this, paramBoolean, paramFunction6));
  }
  
  public boolean a()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.ListModel
 * JD-Core Version:    0.7.0.1
 */