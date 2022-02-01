package com.tencent.tkd.topicsdk.selecttopic;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/selecttopic/BaseSelectView;", "BEAN", "HOLDER", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "context", "Landroid/app/Activity;", "listPresenter", "Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;", "(Landroid/app/Activity;Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "footerView", "Landroid/view/View;", "mIsLoadingMore", "", "mOnScrollListener", "com/tencent/tkd/topicsdk/selecttopic/BaseSelectView$mOnScrollListener$1", "Lcom/tencent/tkd/topicsdk/selecttopic/BaseSelectView$mOnScrollListener$1;", "mSelectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bean", "", "rightActionText", "", "getRightActionText", "()Ljava/lang/String;", "selectTip", "getSelectTip", "addItemToTop", "(Ljava/lang/Object;)V", "handleRightActionClick", "onAttachedToWindow", "onDetachedFromWindow", "setCenterEmpty", "setCenterError", "errorCode", "", "errorMsg", "setCenterHide", "setCenterLoading", "setFooterError", "setFooterHasMore", "setFooterHide", "setFooterLoading", "setFooterNoMore", "setFooterViewFail", "setFooterViewFinish", "setFooterViewHide", "setFooterViewLoading", "setFooterViewShow", "setHeaderError", "setHeaderLoading", "setHeaderSuccess", "setListData", "allList", "", "isAppend", "setOnSelectCallback", "callback", "setTotal", "total", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract class BaseSelectView<BEAN, HOLDER extends CommonListAdapter.BaseListViewHolder>
  extends RelativeLayout
  implements ListContract.IListView<BEAN>
{
  private View jdField_a_of_type_AndroidViewView;
  private final ListPresenter<BEAN, ListContract.IListView<BEAN>> jdField_a_of_type_ComTencentTkdTopicsdkMvpListPresenter;
  private BaseSelectView.mOnScrollListener.1 jdField_a_of_type_ComTencentTkdTopicsdkSelecttopicBaseSelectView$mOnScrollListener$1;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Function1<? super BEAN, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  private final String b;
  
  public BaseSelectView(@NotNull Activity paramActivity, @NotNull ListPresenter<BEAN, ListContract.IListView<BEAN>> paramListPresenter)
  {
    super((Context)paramActivity);
    this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListPresenter = paramListPresenter;
    this.jdField_a_of_type_ComTencentTkdTopicsdkSelecttopicBaseSelectView$mOnScrollListener$1 = new BaseSelectView.mOnScrollListener.1(this);
    LayoutInflater.from((Context)paramActivity).inflate(R.layout.H, (ViewGroup)this, true);
    ((PressTextView)a(R.id.ba)).setOnClickListener((View.OnClickListener)new BaseSelectView.1(this));
    ((PressRelativeLayout)a(R.id.I)).setOnClickListener((View.OnClickListener)new BaseSelectView.2(this));
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
  }
  
  private final void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    localView.setVisibility(8);
  }
  
  private final void c()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("footerView");
    }
    localView.setVisibility(0);
  }
  
  private final void d()
  {
    c();
    Object localObject = (ImageView)a(R.id.q);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomLoadingIcon");
    ((ImageView)localObject).setVisibility(0);
    localObject = (PressTextView)a(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setText((CharSequence)getResources().getString(R.string.F));
    localObject = (PressTextView)a(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setClickable(false);
    localObject = (PressTextView)a(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setEnabled(false);
  }
  
  private final void e()
  {
    c();
    Object localObject = (ImageView)a(R.id.q);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomLoadingIcon");
    ((ImageView)localObject).setVisibility(8);
    localObject = (PressTextView)a(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setText((CharSequence)getResources().getString(R.string.D));
    localObject = (PressTextView)a(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setClickable(true);
    localObject = (PressTextView)a(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setEnabled(true);
    ((PressTextView)a(R.id.r)).setOnClickListener((View.OnClickListener)new BaseSelectView.setFooterViewFail.1(this));
  }
  
  private final void f()
  {
    c();
    Object localObject = (ImageView)a(R.id.q);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomLoadingIcon");
    ((ImageView)localObject).setVisibility(8);
    localObject = (PressTextView)a(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setText((CharSequence)getResources().getString(R.string.E));
    localObject = (PressTextView)a(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setClickable(false);
    localObject = (PressTextView)a(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bottomText");
    ((PressTextView)localObject).setEnabled(false);
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
  public abstract CommonListAdapter<BEAN, HOLDER> a();
  
  @NotNull
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a() {}
  
  public final void a(BEAN paramBEAN)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBEAN);
    localArrayList.addAll((Collection)a().a());
    a().a((List)localArrayList);
    paramBEAN = (ListView)a(R.id.au);
    Intrinsics.checkExpressionValueIsNotNull(paramBEAN, "listView");
    paramBEAN.setVisibility(0);
    paramBEAN = (RelativeLayout)a(R.id.aC);
    Intrinsics.checkExpressionValueIsNotNull(paramBEAN, "loadingLayout");
    paramBEAN.setVisibility(8);
    paramBEAN = (PressRelativeLayout)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(paramBEAN, "errorLayout");
    paramBEAN.setVisibility(8);
  }
  
  @NotNull
  public String b()
  {
    return this.b;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = (TextView)a(R.id.bg);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "selectTipView");
    ((TextView)localObject).setText((CharSequence)a());
    if (((CharSequence)b()).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = (PressTextView)a(R.id.ba);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "rightActionBtn");
        ((PressTextView)localObject).setText((CharSequence)b());
        ((PressTextView)a(R.id.ba)).setOnClickListener((View.OnClickListener)new BaseSelectView.onAttachedToWindow.1(this));
      }
      localObject = LayoutInflater.from(getContext()).inflate(R.layout.K, null, false);
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
      localObject = (ListView)a(R.id.au);
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("footerView");
      }
      ((ListView)localObject).addFooterView(localView);
      localObject = (ListView)a(R.id.au);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "listView");
      ((ListView)localObject).setAdapter((ListAdapter)a());
      localObject = (ListView)a(R.id.au);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "listView");
      ((ListView)localObject).setOnItemClickListener((AdapterView.OnItemClickListener)new BaseSelectView.onAttachedToWindow.2(this));
      ((ListView)a(R.id.au)).setOnScrollListener((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentTkdTopicsdkSelecttopicBaseSelectView$mOnScrollListener$1);
      this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListPresenter.a((ListContract.IListView)this);
      ListContract.IListPresenter.DefaultImpls.a(this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListPresenter, null, 1, null);
      return;
    }
  }
  
  public void onDetachedFromWindow()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListPresenter.a();
    super.onDetachedFromWindow();
  }
  
  public void setCenterEmpty()
  {
    Object localObject = (ListView)a(R.id.au);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "listView");
    ((ListView)localObject).setVisibility(8);
    localObject = (RelativeLayout)a(R.id.aC);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loadingLayout");
    ((RelativeLayout)localObject).setVisibility(8);
    localObject = (PressRelativeLayout)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "errorLayout");
    ((PressRelativeLayout)localObject).setVisibility(8);
  }
  
  public void setCenterError(int paramInt, @Nullable String paramString)
  {
    paramString = (ListView)a(R.id.au);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "listView");
    paramString.setVisibility(8);
    paramString = (RelativeLayout)a(R.id.aC);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "loadingLayout");
    paramString.setVisibility(8);
    paramString = (PressRelativeLayout)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "errorLayout");
    paramString.setVisibility(0);
  }
  
  public void setCenterHide()
  {
    Object localObject = (ListView)a(R.id.au);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "listView");
    ((ListView)localObject).setVisibility(0);
    localObject = (RelativeLayout)a(R.id.aC);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loadingLayout");
    ((RelativeLayout)localObject).setVisibility(8);
  }
  
  public void setCenterLoading()
  {
    Object localObject = (ListView)a(R.id.au);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "listView");
    ((ListView)localObject).setVisibility(8);
    localObject = (PressRelativeLayout)a(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "errorLayout");
    ((PressRelativeLayout)localObject).setVisibility(8);
    localObject = (RelativeLayout)a(R.id.aC);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loadingLayout");
    ((RelativeLayout)localObject).setVisibility(0);
  }
  
  public void setFooterError(int paramInt, @Nullable String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    e();
  }
  
  public void setFooterHasMore()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setFooterHide()
  {
    b();
  }
  
  public void setFooterLoading()
  {
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  public void setFooterNoMore()
  {
    this.jdField_a_of_type_Boolean = false;
    f();
  }
  
  public void setHeaderError(int paramInt, @Nullable String paramString) {}
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public void setListData(@NotNull List<? extends BEAN> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "allList");
    a().a(paramList);
  }
  
  public final void setOnSelectCallback(@NotNull Function1<? super BEAN, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public void setTotal(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selecttopic.BaseSelectView
 * JD-Core Version:    0.7.0.1
 */