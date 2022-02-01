package com.tencent.mobileqq.search.fragment.searchentry;

import andr;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import bass;
import bbaa;
import bbda;
import bjne;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter.CommonEvent;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler;
import com.tencent.mobileqq.search.fragment.searchentry.nativemethod.INativeMethodHandler;
import com.tencent.mobileqq.search.fragment.searchentry.nativemethod.SearchNativeMethodController;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import sya;
import thu;

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
  private SearchHippyEventEmitter eventEmitter;
  @NonNull
  private final SearchHotwordHandler hotwordHandler = new SearchHotwordHandler();
  private Bundle initData = new Bundle(9);
  private SearchNativeMethodController nativeMethodController;
  private String openFrom;
  
  private void initHippyEngine(ViewGroup paramViewGroup)
  {
    this.mHippyQQEngine = new SearchEntryHippyEngine(this, this.hotwordHandler, this);
    this.nativeMethodController = new SearchNativeMethodController(getActivity(), this.app, this);
    this.nativeMethodController.registerNativeMethod(this.mHippyQQEngine);
    this.eventEmitter = new SearchHippyEventEmitter(this.mHippyQQEngine, this.hotwordHandler);
    this.hotwordHandler.setEventEmitter(this.eventEmitter);
    bbda.a(this.app, new ReportModelDC02528().module("search_hippy").action("load_start"));
    new andr(this.app).b(this.app, "load_start", "search_hippy", bbda.a(25), "", "", "");
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
    if ((this.eventEmitter != null) && (paramEditable != null)) {
      this.eventEmitter.sendTextChangedEvent(paramEditable.toString());
    }
  }
  
  public void fillKeyword(String paramString)
  {
    if ((getActivity() instanceof UniteSearchActivity)) {
      ((UniteSearchActivity)getActivity()).a(paramString, true, false);
    }
  }
  
  @NonNull
  public Fragment getFragment()
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
    if ((getActivity() instanceof UniteSearchActivity)) {
      ((UniteSearchActivity)getActivity()).b();
    }
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    if (this.mViolaUiDelegate != null) {
      this.mViolaUiDelegate.a(false);
    }
    super.initAfterVisible(paramBundle, paramViewGroup);
    Log.d("SearchHippyEntryFragmen", "initAfterVisible: ");
    setBackgroundColor(paramViewGroup);
    setStatusBar();
    if (this.mHippyQQEngine == null) {
      initHippyEngine(paramViewGroup);
    }
    if (this.mViolaUiDelegate != null) {
      this.mViolaUiDelegate.d();
    }
    setNoPadding();
  }
  
  public void onDestroy()
  {
    if ((this.nativeMethodController != null) && (this.mHippyQQEngine != null)) {
      this.nativeMethodController.unRegisterNativeMethod(this.mHippyQQEngine);
    }
    super.onDestroy();
    if (this.eventEmitter != null) {
      this.eventEmitter.destroy();
    }
    if (this.mHippyQQEngine != null) {
      this.mHippyQQEngine.onDestroy();
    }
    this.hotwordHandler.destroy();
    sya.a += bass.a;
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchHippyEntryFragmen", 2, "Hippy: initHippy error statusCode=" + paramInt + ", msg=" + paramString);
    }
    if (getActivity() != null)
    {
      SearchEntryHippyEngine.hippyError = true;
      UniteSearchActivity.a(getActivity(), null, 25, 0L, null, 0, null);
    }
    bbda.a(this.app, new ReportModelDC02528().module("search_hippy").action("load_error").ver4(paramString));
    new andr(this.app).b(this.app, "load_error", "search_hippy", bbda.a(25), "", paramString, "");
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
    if (this.eventEmitter != null) {
      this.eventEmitter.sendSoftKeyboardHideEvent();
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (this.eventEmitter != null) {
      this.eventEmitter.sendSoftKeyboardShowEvent(paramInt);
    }
  }
  
  public void onSuccess()
  {
    SearchEntryHippyEngine.hippyError = false;
    if (this.mViolaUiDelegate != null) {
      this.mViolaUiDelegate.d();
    }
    this.hotwordHandler.notifyFEHotwordChanged();
    Log.d("SearchHippyEntryFragmen", "hippyengine onSuccess: ");
    this.hotwordHandler.getSearchFEHotwordItems(new SearchHippyEntryFragment.3(this));
    bbda.a(this.app, new ReportModelDC02528().module("search_hippy").action("load_success"));
    new andr(this.app).b(this.app, "load_success", "search_hippy", bbda.a(25), "", "", "");
  }
  
  public void refresh() {}
  
  public void refreshDataModels(List<bbaa> paramList, boolean paramBoolean) {}
  
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
    bjne.a(new SearchHippyEntryFragment.1(this, paramBoolean));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.SearchHippyEntryFragment
 * JD-Core Version:    0.7.0.1
 */