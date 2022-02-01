package com.tencent.tkd.topicsdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.Companion;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import com.tencent.tkd.topicsdk.common.R.id;
import com.tencent.tkd.topicsdk.common.R.layout;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mvp/BaseListView;", "BEAN", "Landroid/widget/RelativeLayout;", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "context", "Landroid/content/Context;", "listPresenter", "Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/tkd/topicsdk/mvp/BaseListAdapter;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/mvp/BaseListAdapter;", "footerView", "Landroid/view/View;", "isLoadingMore", "", "isSoftInputShowing", "itemSelectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bean", "", "listview", "Landroid/widget/ListView;", "getListview", "()Landroid/widget/ListView;", "setListview", "(Landroid/widget/ListView;)V", "onScrollListener", "com/tencent/tkd/topicsdk/mvp/BaseListView$onScrollListener$1", "Lcom/tencent/tkd/topicsdk/mvp/BaseListView$onScrollListener$1;", "onAttachedToWindow", "onDetachedFromWindow", "setCenterEmpty", "setCenterError", "errorCode", "", "errorMsg", "", "setCenterHide", "setCenterLoading", "setFooterError", "setFooterHasMore", "setFooterHide", "setFooterLoading", "setFooterNoMore", "setFooterViewFail", "setFooterViewFinish", "setFooterViewHide", "setFooterViewLoading", "setFooterViewShow", "setHeaderError", "setHeaderLoading", "setHeaderSuccess", "setItemSelectCallback", "callback", "setListData", "allList", "", "isAppend", "setTotal", "total", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public abstract class BaseListView<BEAN>
  extends RelativeLayout
  implements ListContract.IListView<BEAN>
{
  @NotNull
  private ListView a;
  private Function1<? super BEAN, Unit> b;
  private boolean c;
  private View d;
  private boolean e;
  private BaseListView.onScrollListener.1 f;
  private final ListPresenter<BEAN, ListContract.IListView<BEAN>> g;
  private HashMap h;
  
  public BaseListView(@NotNull Context paramContext, @NotNull ListPresenter<BEAN, ListContract.IListView<BEAN>> paramListPresenter)
  {
    super(paramContext);
    this.g = paramListPresenter;
    this.f = new BaseListView.onScrollListener.1(this, paramContext);
    LayoutInflater.from(paramContext).inflate(R.layout.b, (ViewGroup)this, true);
    paramListPresenter = findViewById(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(paramListPresenter, "findViewById(R.id.list_view)");
    this.a = ((ListView)paramListPresenter);
    ((RelativeLayout)a(R.id.c)).setOnClickListener((View.OnClickListener)new BaseListView.1(this));
    KeyBoardChangeListener.a.a((Activity)paramContext).a((KeyBoardChangeListener.KeyboardListener)new BaseListView..special..inlined.apply.lambda.1(this));
  }
  
  private final void a()
  {
    View localView = this.d;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    localView.setVisibility(8);
  }
  
  private final void b()
  {
    View localView = this.d;
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
    if (this.h == null) {
      this.h = new HashMap();
    }
    View localView2 = (View)this.h.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.h.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public abstract BaseListAdapter<BEAN> getAdapter();
  
  public int getDividerHeight()
  {
    return ListContract.IListView.DefaultImpls.a(this);
  }
  
  @NotNull
  public final ListView getListview()
  {
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = LayoutInflater.from(getContext()).inflate(R.layout.a, null, false);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "LayoutInflater.from(cont…footer_view, null, false)");
    this.d = ((View)localObject);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    ((View)localObject).setClickable(false);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    ((View)localObject).setEnabled(false);
    localObject = (TextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tv_empty");
    ((TextView)localObject).setText((CharSequence)getEmptyText());
    localObject = (ListView)a(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setDividerHeight(getDividerHeight());
    localObject = (ListView)a(R.id.d);
    View localView = this.d;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    ((ListView)localObject).addFooterView(localView);
    localObject = (ListView)a(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setAdapter((ListAdapter)getAdapter());
    localObject = (ListView)a(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setOnItemClickListener((AdapterView.OnItemClickListener)new BaseListView.onAttachedToWindow.1(this));
    localObject = (ListView)a(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    ((ListView)a(R.id.d)).setOnScrollListener((AbsListView.OnScrollListener)this.f);
    this.g.a((ListContract.IListView)this);
    ListContract.IListPresenter.DefaultImpls.a(this.g, null, 1, null);
  }
  
  protected void onDetachedFromWindow()
  {
    this.g.a();
    super.onDetachedFromWindow();
  }
  
  public void setCenterEmpty()
  {
    Object localObject = (ListView)a(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
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
    paramString = (ListView)a(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "list_view");
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
    ListView localListView = (ListView)a(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(localListView, "list_view");
    localListView.setVisibility(0);
  }
  
  public void setCenterLoading()
  {
    Object localObject = (ListView)a(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setVisibility(8);
    localObject = (RelativeLayout)a(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "errorLayout");
    ((RelativeLayout)localObject).setVisibility(8);
  }
  
  public void setFooterError(int paramInt, @Nullable String paramString)
  {
    this.c = false;
    d();
  }
  
  public void setFooterHasMore()
  {
    this.c = false;
  }
  
  public void setFooterHide()
  {
    a();
  }
  
  public void setFooterLoading()
  {
    this.c = true;
    c();
  }
  
  public void setFooterNoMore()
  {
    this.c = false;
    e();
  }
  
  public void setHeaderError(int paramInt, @Nullable String paramString) {}
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public final void setItemSelectCallback(@NotNull Function1<? super BEAN, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    this.b = paramFunction1;
  }
  
  public void setListData(@NotNull List<? extends BEAN> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "allList");
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)a(R.id.b);
      Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "emptyLayout");
      localRelativeLayout.setVisibility(8);
    }
    getAdapter().a(paramList);
    if ((getAdapter().a().size() < 15) && (this.g.c().a())) {
      this.g.b();
    }
  }
  
  public final void setListview(@NotNull ListView paramListView)
  {
    Intrinsics.checkParameterIsNotNull(paramListView, "<set-?>");
    this.a = paramListView;
  }
  
  public void setTotal(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.BaseListView
 * JD-Core Version:    0.7.0.1
 */