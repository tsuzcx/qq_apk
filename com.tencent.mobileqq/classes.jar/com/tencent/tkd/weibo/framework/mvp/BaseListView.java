package com.tencent.tkd.weibo.framework.mvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.weibo.R.id;
import com.tencent.tkd.weibo.R.layout;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/framework/mvp/BaseListView;", "BEAN", "Landroid/widget/RelativeLayout;", "Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListView;", "context", "Landroid/content/Context;", "listPresenter", "Lcom/tencent/tkd/weibo/framework/mvp/ListPresenter;", "(Landroid/content/Context;Lcom/tencent/tkd/weibo/framework/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListAdapter;", "getAdapter", "()Lcom/tencent/tkd/weibo/framework/mvp/BaseListAdapter;", "footerView", "Landroid/view/View;", "isLoadingMore", "", "itemSelectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bean", "", "onScrollListener", "com/tencent/tkd/weibo/framework/mvp/BaseListView$onScrollListener$1", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListView$onScrollListener$1;", "onTouchScrollListener", "Lkotlin/Function0;", "getOnTouchScrollListener", "()Lkotlin/jvm/functions/Function0;", "setOnTouchScrollListener", "(Lkotlin/jvm/functions/Function0;)V", "onAttachedToWindow", "onDetachedFromWindow", "setCenterEmpty", "setCenterError", "errorCode", "", "errorMsg", "", "setCenterHide", "setCenterLoading", "setFooterError", "setFooterHasMore", "setFooterHide", "setFooterLoading", "setFooterNoMore", "setFooterViewFail", "setFooterViewFinish", "setFooterViewHide", "setFooterViewLoading", "setFooterViewShow", "setHeaderError", "setHeaderLoading", "setHeaderSuccess", "setItemSelectCallback", "callback", "setListData", "allList", "", "isAppend", "setTotal", "total", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public abstract class BaseListView<BEAN>
  extends RelativeLayout
  implements ListContract.IListView<BEAN>
{
  private View jdField_a_of_type_AndroidViewView;
  private BaseListView.onScrollListener.1 jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpBaseListView$onScrollListener$1;
  private final ListPresenter<BEAN, ListContract.IListView<BEAN>> jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListPresenter;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  @Nullable
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  private Function1<? super BEAN, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean;
  
  private final void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    localView.setVisibility(8);
  }
  
  private final void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    localView.setVisibility(0);
  }
  
  private final void c()
  {
    b();
    TextView localTextView = (TextView)a(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "bottomText");
    localTextView.setClickable(false);
    localTextView = (TextView)a(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "bottomText");
    localTextView.setEnabled(false);
  }
  
  private final void d()
  {
    b();
    TextView localTextView = (TextView)a(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "bottomText");
    localTextView.setClickable(true);
    localTextView = (TextView)a(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "bottomText");
    localTextView.setEnabled(true);
    ((TextView)a(R.id.a)).setOnClickListener((View.OnClickListener)new BaseListView.setFooterViewFail.1(this));
  }
  
  private final void e()
  {
    b();
    TextView localTextView = (TextView)a(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "bottomText");
    localTextView.setClickable(false);
    localTextView = (TextView)a(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "bottomText");
    localTextView.setEnabled(false);
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public abstract BaseListAdapter<BEAN> a();
  
  @Nullable
  public final Function0<Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction0;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = LayoutInflater.from(getContext()).inflate(R.layout.b, null, false);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "LayoutInflater.from(cont…footer_view, null, false)");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    ((View)localObject).setClickable(false);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    ((View)localObject).setEnabled(false);
    localObject = (ListView)a(R.id.f);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    ((ListView)localObject).addFooterView(localView);
    localObject = (ListView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "listView");
    ((ListView)localObject).setAdapter((ListAdapter)a());
    localObject = (ListView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "listView");
    ((ListView)localObject).setOnItemClickListener((AdapterView.OnItemClickListener)new BaseListView.onAttachedToWindow.1(this));
    ((ListView)a(R.id.f)).setOnScrollListener((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpBaseListView$onScrollListener$1);
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListPresenter.a((ListContract.IListView)this);
    ListContract.IListPresenter.DefaultImpls.a(this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListPresenter, null, 1, null);
  }
  
  public void onDetachedFromWindow()
  {
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListPresenter.a();
    super.onDetachedFromWindow();
  }
  
  public void setCenterEmpty()
  {
    Object localObject = (ListView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "listView");
    ((ListView)localObject).setVisibility(8);
    localObject = (RelativeLayout)a(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "errorLayout");
    ((RelativeLayout)localObject).setVisibility(8);
    localObject = (RelativeLayout)a(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "emptyLayout");
    ((RelativeLayout)localObject).setVisibility(0);
  }
  
  public void setCenterError(int paramInt, @Nullable String paramString)
  {
    paramString = (ListView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "listView");
    paramString.setVisibility(8);
    paramString = (RelativeLayout)a(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "errorLayout");
    paramString.setVisibility(0);
    paramString = (RelativeLayout)a(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "emptyLayout");
    paramString.setVisibility(8);
  }
  
  public void setCenterHide()
  {
    ListView localListView = (ListView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localListView, "listView");
    localListView.setVisibility(0);
  }
  
  public void setCenterLoading()
  {
    Object localObject = (ListView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "listView");
    ((ListView)localObject).setVisibility(8);
    localObject = (RelativeLayout)a(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "errorLayout");
    ((RelativeLayout)localObject).setVisibility(8);
  }
  
  public void setFooterError(int paramInt, @Nullable String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    d();
  }
  
  public void setFooterHasMore()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setFooterHide()
  {
    a();
  }
  
  public void setFooterLoading()
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void setFooterNoMore()
  {
    this.jdField_a_of_type_Boolean = false;
    e();
  }
  
  public void setHeaderError(int paramInt, @Nullable String paramString) {}
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public final void setItemSelectCallback(@NotNull Function1<? super BEAN, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public void setListData(@NotNull List<? extends BEAN> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "allList");
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)a(R.id.b);
        Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "emptyLayout");
        localRelativeLayout.setVisibility(8);
      }
      a().a(paramList);
      if ((a().a().size() < 15) && (this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListPresenter.a().a())) {
        this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListPresenter.b();
      }
      return;
    }
  }
  
  public final void setOnTouchScrollListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public void setTotal(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.BaseListView
 * JD-Core Version:    0.7.0.1
 */