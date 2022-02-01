package com.tencent.mobileqq.education.answersearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.education.api.IAnswerSearchApi;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/answersearch/AnswerSearchResultFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "bitmapBase64", "", "bitmapFilePath", "lifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleAndViewModelStoreOwner;", "viewModel", "Lcom/tencent/mobileqq/education/answersearch/AnswerSearchResultViewModel;", "webResultContainer", "Landroid/widget/FrameLayout;", "doOnCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleSearchResultData", "", "result", "initIntentData", "initViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class AnswerSearchResultFragment
  extends WebViewFragment
{
  public static final AnswerSearchResultFragment.Companion a = new AnswerSearchResultFragment.Companion(null);
  private FrameLayout b;
  private LifeCycleAndViewModelStoreOwner c;
  private AnswerSearchResultViewModel d;
  private String e;
  
  private final void a()
  {
    Object localObject = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment((Activity)getActivity());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(ILifeCycleFra…feCycleFragment(activity)");
    this.c = ((LifeCycleAndViewModelStoreOwner)localObject);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject = ViewModelProviderHelper.a((ViewModelStoreOwner)localObject).get(AnswerSearchResultViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewModelProviderHelper.…ultViewModel::class.java)");
    this.d = ((AnswerSearchResultViewModel)localObject);
  }
  
  private final void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    localObject = ((AnswerSearchResultViewModel)localObject).c();
    TouchWebView localTouchWebView = this.webView;
    if (localTouchWebView != null) {
      localTouchWebView.callJs("injectAnswer", new String[] { localObject });
    }
  }
  
  private final void b()
  {
    if (getIntent().getIntExtra("answer_search_result_params_key_pic_type", 0) == 1)
    {
      localObject = getIntent().getStringExtra("answer_search_result_params_key_pic_data");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "getIntent().getStringExt…SULT_PARAMS_KEY_PIC_DATA)");
      this.e = ((String)localObject);
    }
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bitmapFilePath");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      String str = this.e;
      if (str == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bitmapFilePath");
      }
      ((AnswerSearchResultViewModel)localObject).a(str);
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((AnswerSearchResultViewModel)localObject).a().observe(getViewLifecycleOwner(), (Observer)new AnswerSearchResultFragment.initIntentData.1(this));
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((AnswerSearchResultViewModel)localObject).b();
    }
  }
  
  protected boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131629323, null);
    paramViewGroup = paramLayoutInflater.findViewById(2131450081);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "rootContainer.findViewBy….id.web_result_container)");
    this.b = ((FrameLayout)paramViewGroup);
    if ((WebAccelerateHelper.preloadBrowserView instanceof WebBrowserViewContainer))
    {
      paramViewGroup = WebAccelerateHelper.preloadBrowserView;
      if (paramViewGroup != null)
      {
        this.contentView = ((WebBrowserViewContainer)paramViewGroup);
        WebAccelerateHelper.preloadBrowserView = (View)null;
        getStatistics().aG = true;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.webview.swift.WebBrowserViewContainer");
      }
    }
    else
    {
      this.contentView = new WebBrowserViewContainer((Context)super.getQBaseActivity());
    }
    paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("webResultContainer");
    }
    paramBundle.addView((View)this.contentView, (ViewGroup.LayoutParams)paramViewGroup);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("expose#photo_result_page#view", null);
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.answersearch.AnswerSearchResultFragment
 * JD-Core Version:    0.7.0.1
 */