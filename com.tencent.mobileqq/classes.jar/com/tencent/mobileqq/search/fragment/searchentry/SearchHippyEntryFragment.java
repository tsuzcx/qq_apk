package com.tencent.mobileqq.search.fragment.searchentry;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.kandian.biz.search.entity.ReadInJoySearchWord;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter.CommonEvent;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler;
import com.tencent.mobileqq.search.fragment.searchentry.nativemethod.INativeMethodHandler;
import com.tencent.mobileqq.search.fragment.searchentry.nativemethod.SearchNativeMethodController;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.List;

public class SearchHippyEntryFragment
  extends ViolaFragment
  implements HippyQQEngine.HippyQQEngineListener, ISearchEntryFragment, INativeMethodHandler
{
  public static final String COMPONENT_SEARCH = "SearchPageView";
  public static final String MODULE_SEARCH = "search";
  public static final String SearchHippyPageFromResultPage = "3";
  public static final String SearchHippyPageFromTopBar = "1";
  private static final String TAG = "SearchHippyEntryFragmen";
  private QQAppInterface app;
  private SearchHippyEventEmitter eventEmitter = null;
  @NonNull
  private final SearchHotwordHandler hotwordHandler = new SearchHotwordHandler();
  private Bundle initData = new Bundle(9);
  private SearchNativeMethodController nativeMethodController;
  private String openFrom;
  
  private void initHippyEngine(ViewGroup paramViewGroup)
  {
    this.mHippyQQEngine = new SearchEntryHippyEngine(this, this.hotwordHandler, this);
    this.nativeMethodController = new SearchNativeMethodController(getQBaseActivity(), this.app, this);
    this.nativeMethodController.registerNativeMethod(this.mHippyQQEngine);
    this.eventEmitter = new SearchHippyEventEmitter(this.mHippyQQEngine, this.hotwordHandler);
    this.hotwordHandler.setEventEmitter(this.eventEmitter);
    UniteSearchReportController.a(this.app, new ReportModelDC02528().module("search_hippy").action("load_start"));
    new UniteSearchHandler(this.app).b(this.app, "load_start", "search_hippy", UniteSearchReportController.a(25), "", "", "");
  }
  
  private void setBackgroundColor(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      paramViewGroup.setBackgroundColor(Color.parseColor("#000000"));
      return;
    }
    paramViewGroup.setBackgroundColor(Color.parseColor("#ffffff"));
  }
  
  private void setStatusBar()
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      setStatusBarColor("#000000");
      setStatusBarFontColor(Boolean.valueOf(true));
      return;
    }
    setStatusBarColor("#ffffff");
    setStatusBarFontColor(Boolean.valueOf(false));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    SearchHippyEventEmitter localSearchHippyEventEmitter = this.eventEmitter;
    if ((localSearchHippyEventEmitter != null) && (paramEditable != null)) {
      localSearchHippyEventEmitter.sendTextChangedEvent(paramEditable.toString());
    }
  }
  
  public void fillKeyword(String paramString)
  {
    if ((getQBaseActivity() instanceof UniteSearchActivity)) {
      ((UniteSearchActivity)getQBaseActivity()).a(paramString, true, false);
    }
  }
  
  @NonNull
  public QBaseFragment getFragment()
  {
    return this;
  }
  
  @NonNull
  public Bundle getInitData()
  {
    return this.initData;
  }
  
  public String getUrl()
  {
    return "https://viola.qq.com/js/search.js?_rij_violaUrl=1&hideNav=1";
  }
  
  public void hideInputMethod()
  {
    if ((getQBaseActivity() instanceof UniteSearchActivity)) {
      ((UniteSearchActivity)getQBaseActivity()).b();
    }
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.mPresenter.a().a(false);
    super.initAfterVisible(paramBundle, paramViewGroup);
    Log.d("SearchHippyEntryFragmen", "initAfterVisible: ");
    setBackgroundColor(paramViewGroup);
    setStatusBar();
    if (this.mHippyQQEngine == null) {
      initHippyEngine(paramViewGroup);
    }
    this.mPresenter.a().a();
    setNoPadding();
  }
  
  public void onDestroy()
  {
    if ((this.nativeMethodController != null) && (this.mHippyQQEngine != null)) {
      this.nativeMethodController.unRegisterNativeMethod(this.mHippyQQEngine);
    }
    super.onDestroy();
    SearchHippyEventEmitter localSearchHippyEventEmitter = this.eventEmitter;
    if (localSearchHippyEventEmitter != null) {
      localSearchHippyEventEmitter.destroy();
    }
    if (this.mHippyQQEngine != null) {
      this.mHippyQQEngine.onDestroy();
    }
    this.hotwordHandler.destroy();
    ReadInJoySearchWord.a += SearchEntryConfigManager.a;
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Hippy: initHippy error statusCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", msg=");
      localStringBuilder.append(paramString);
      QLog.d("SearchHippyEntryFragmen", 2, localStringBuilder.toString());
    }
    if (getQBaseActivity() != null)
    {
      SearchEntryHippyEngine.hippyError = true;
      UniteSearchActivity.a(getQBaseActivity(), null, 25, 0L, null, 0, null);
    }
    UniteSearchReportController.a(this.app, new ReportModelDC02528().module("search_hippy").action("load_error").ver4(paramString));
    new UniteSearchHandler(this.app).b(this.app, "load_error", "search_hippy", UniteSearchReportController.a(25), "", paramString, "");
  }
  
  public void onHotwordClick(int paramInt)
  {
    this.hotwordHandler.onHotwordClick(paramInt);
  }
  
  public void onPause()
  {
    super.onPause();
    this.eventEmitter.sendCommonEvent(SearchHippyEventEmitter.CommonEvent.SearchUnitWillHide, null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.hotwordHandler.getSearchFEHotwordItems(new SearchHippyEntryFragment.2(this));
  }
  
  public void onSoftKeyboardClosed()
  {
    SearchHippyEventEmitter localSearchHippyEventEmitter = this.eventEmitter;
    if (localSearchHippyEventEmitter != null) {
      localSearchHippyEventEmitter.sendSoftKeyboardHideEvent();
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    SearchHippyEventEmitter localSearchHippyEventEmitter = this.eventEmitter;
    if (localSearchHippyEventEmitter != null) {
      localSearchHippyEventEmitter.sendSoftKeyboardShowEvent(paramInt);
    }
  }
  
  public void onSuccess()
  {
    SearchEntryHippyEngine.hippyError = false;
    this.mPresenter.a().a();
    this.hotwordHandler.notifyFEHotwordChanged();
    Log.d("SearchHippyEntryFragmen", "hippyengine onSuccess: ");
    this.hotwordHandler.getSearchFEHotwordItems(new SearchHippyEntryFragment.3(this));
    UniteSearchReportController.a(this.app, new ReportModelDC02528().module("search_hippy").action("load_success"));
    new UniteSearchHandler(this.app).b(this.app, "load_success", "search_hippy", UniteSearchReportController.a(25), "", "", "");
  }
  
  public void refresh() {}
  
  public void refreshDataModels(List<SearchEntryDataModel> paramList, boolean paramBoolean) {}
  
  public void requestSearchHotWord(boolean paramBoolean)
  {
    this.hotwordHandler.requestSearchHotWord(paramBoolean);
  }
  
  public void setApp(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public void setHotwordVisible(boolean paramBoolean)
  {
    UiThreadUtil.a(new SearchHippyEntryFragment.1(this, paramBoolean));
  }
  
  public void setInitData(@NonNull Bundle paramBundle)
  {
    this.initData = paramBundle;
    if (paramBundle.getInt("from") == 25)
    {
      this.openFrom = "1";
      return;
    }
    this.openFrom = "3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.SearchHippyEntryFragment
 * JD-Core Version:    0.7.0.1
 */