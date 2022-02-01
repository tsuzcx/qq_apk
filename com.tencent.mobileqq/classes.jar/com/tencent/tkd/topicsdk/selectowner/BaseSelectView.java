package com.tencent.tkd.topicsdk.selectowner;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import com.tencent.tkd.topicsdk.list.CommonListAdapter.BaseListViewHolder;
import com.tencent.tkd.topicsdk.mvp.ListContract.IListPresenter.DefaultImpls;
import com.tencent.tkd.topicsdk.mvp.ListContract.IListView;
import com.tencent.tkd.topicsdk.mvp.ListContract.IListView.DefaultImpls;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
import com.tencent.tkd.topicsdk.widget.PressRelativeLayout;
import com.tencent.tkd.topicsdk.widget.PressTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/selectowner/BaseSelectView;", "BEAN", "HOLDER", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "context", "Landroid/app/Activity;", "listPresenter", "Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;", "(Landroid/app/Activity;Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "footerView", "Landroid/view/View;", "mIsLoadingMore", "", "mOnScrollListener", "com/tencent/tkd/topicsdk/selectowner/BaseSelectView$mOnScrollListener$1", "Lcom/tencent/tkd/topicsdk/selectowner/BaseSelectView$mOnScrollListener$1;", "mSelectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bean", "", "selectTip", "", "getSelectTip", "()Ljava/lang/String;", "addItemToTop", "(Ljava/lang/Object;)V", "getEmptyText", "onAttachedToWindow", "onDetachedFromWindow", "setCenterEmpty", "setCenterError", "errorCode", "", "errorMsg", "setCenterHide", "setCenterLoading", "setFooterError", "setFooterHasMore", "setFooterHide", "setFooterLoading", "setFooterNoMore", "setFooterViewFail", "setFooterViewFinish", "setFooterViewHide", "setFooterViewLoading", "setFooterViewShow", "setHeaderError", "setHeaderLoading", "setHeaderSuccess", "setListData", "allList", "", "isAppend", "setOnSelectCallback", "callback", "setTotal", "total", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract class BaseSelectView<BEAN, HOLDER extends CommonListAdapter.BaseListViewHolder>
  extends RelativeLayout
  implements ListContract.IListView<BEAN>
{
  private Function1<? super BEAN, Unit> a;
  private boolean b;
  private View c;
  private BaseSelectView.mOnScrollListener.1 d;
  @NotNull
  private final String e;
  private final ListPresenter<BEAN, ListContract.IListView<BEAN>> f;
  private HashMap g;
  
  public BaseSelectView(@NotNull Activity paramActivity, @NotNull ListPresenter<BEAN, ListContract.IListView<BEAN>> paramListPresenter)
  {
    super(paramActivity);
    this.f = paramListPresenter;
    this.d = new BaseSelectView.mOnScrollListener.1(this);
    LayoutInflater.from(paramActivity).inflate(R.layout.C, (ViewGroup)this, true);
    ((PressRelativeLayout)a(R.id.m)).setOnClickListener((View.OnClickListener)new BaseSelectView.1(this));
    this.e = "";
  }
  
  private final void a()
  {
    View localView = this.c;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    localView.setVisibility(8);
  }
  
  private final void b()
  {
    View localView = this.c;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    localView.setVisibility(0);
  }
  
  private final void c()
  {
    b();
    Object localObject = (ImageView)a(R.id.e);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomLoadingIcon");
    ((ImageView)localObject).setVisibility(0);
    localObject = (PressTextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setText((CharSequence)getResources().getString(R.string.u));
    localObject = (PressTextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setClickable(false);
    localObject = (PressTextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setEnabled(false);
  }
  
  private final void d()
  {
    b();
    Object localObject = (ImageView)a(R.id.e);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomLoadingIcon");
    ((ImageView)localObject).setVisibility(8);
    localObject = (PressTextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setText((CharSequence)getResources().getString(R.string.s));
    localObject = (PressTextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setClickable(true);
    localObject = (PressTextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setEnabled(true);
    ((PressTextView)a(R.id.f)).setOnClickListener((View.OnClickListener)new BaseSelectView.setFooterViewFail.1(this));
  }
  
  private final void e()
  {
    b();
    Object localObject = (ImageView)a(R.id.e);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomLoadingIcon");
    ((ImageView)localObject).setVisibility(8);
    localObject = (PressTextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setText((CharSequence)getResources().getString(R.string.t));
    localObject = (PressTextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setClickable(false);
    localObject = (PressTextView)a(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setEnabled(false);
  }
  
  public View a(int paramInt)
  {
    if (this.g == null) {
      this.g = new HashMap();
    }
    View localView2 = (View)this.g.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.g.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(BEAN paramBEAN)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBEAN);
    localArrayList.addAll((Collection)getAdapter().a());
    getAdapter().a((List)localArrayList);
    paramBEAN = (ListView)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(paramBEAN, "list_view");
    paramBEAN.setVisibility(0);
    paramBEAN = (RelativeLayout)a(R.id.M);
    Intrinsics.checkExpressionValueIsNotNull(paramBEAN, "loadingLayout");
    paramBEAN.setVisibility(8);
    paramBEAN = (PressRelativeLayout)a(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(paramBEAN, "errorLayout");
    paramBEAN.setVisibility(8);
  }
  
  @NotNull
  public abstract CommonListAdapter<BEAN, HOLDER> getAdapter();
  
  public int getDividerHeight()
  {
    return ListContract.IListView.DefaultImpls.a(this);
  }
  
  @NotNull
  public String getEmptyText()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getString(R.string.q);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getStr…tring.empty_content_tips)");
    return localObject;
  }
  
  @NotNull
  public String getSelectTip()
  {
    return this.e;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = (TextView)a(R.id.ah);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "selectTipView");
    ((TextView)localObject).setText((CharSequence)getSelectTip());
    localObject = LayoutInflater.from(getContext()).inflate(R.layout.F, null, false);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "LayoutInflater.from(cont…footer_view, null, false)");
    this.c = ((View)localObject);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    ((View)localObject).setClickable(false);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    ((View)localObject).setEnabled(false);
    localObject = (ListView)a(R.id.I);
    View localView = this.c;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    ((ListView)localObject).addFooterView(localView);
    localObject = (ListView)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setAdapter((ListAdapter)getAdapter());
    localObject = (ListView)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setOnItemClickListener((AdapterView.OnItemClickListener)new BaseSelectView.onAttachedToWindow.1(this));
    ((ListView)a(R.id.I)).setOnScrollListener((AbsListView.OnScrollListener)this.d);
    this.f.a((ListContract.IListView)this);
    ListContract.IListPresenter.DefaultImpls.a(this.f, null, 1, null);
  }
  
  protected void onDetachedFromWindow()
  {
    this.f.a();
    super.onDetachedFromWindow();
  }
  
  public void setCenterEmpty()
  {
    Object localObject = (ListView)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setVisibility(8);
    localObject = (RelativeLayout)a(R.id.M);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loadingLayout");
    ((RelativeLayout)localObject).setVisibility(8);
    localObject = (PressRelativeLayout)a(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "errorLayout");
    ((PressRelativeLayout)localObject).setVisibility(8);
  }
  
  public void setCenterError(int paramInt, @Nullable String paramString)
  {
    paramString = (ListView)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "list_view");
    paramString.setVisibility(8);
    paramString = (RelativeLayout)a(R.id.M);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "loadingLayout");
    paramString.setVisibility(8);
    paramString = (PressRelativeLayout)a(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "errorLayout");
    paramString.setVisibility(0);
  }
  
  public void setCenterHide()
  {
    Object localObject = (ListView)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setVisibility(0);
    localObject = (RelativeLayout)a(R.id.M);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loadingLayout");
    ((RelativeLayout)localObject).setVisibility(8);
  }
  
  public void setCenterLoading()
  {
    Object localObject = (ListView)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "list_view");
    ((ListView)localObject).setVisibility(8);
    localObject = (PressRelativeLayout)a(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "errorLayout");
    ((PressRelativeLayout)localObject).setVisibility(8);
    localObject = (RelativeLayout)a(R.id.M);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loadingLayout");
    ((RelativeLayout)localObject).setVisibility(0);
  }
  
  public void setFooterError(int paramInt, @Nullable String paramString)
  {
    this.b = false;
    d();
  }
  
  public void setFooterHasMore()
  {
    this.b = false;
  }
  
  public void setFooterHide()
  {
    a();
  }
  
  public void setFooterLoading()
  {
    this.b = true;
    c();
  }
  
  public void setFooterNoMore()
  {
    this.b = false;
    e();
  }
  
  public void setHeaderError(int paramInt, @Nullable String paramString) {}
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public void setListData(@NotNull List<? extends BEAN> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "allList");
    getAdapter().a(paramList);
  }
  
  public final void setOnSelectCallback(@NotNull Function1<? super BEAN, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    this.a = paramFunction1;
  }
  
  public void setTotal(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.BaseSelectView
 * JD-Core Version:    0.7.0.1
 */