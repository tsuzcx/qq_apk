package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bglu;
import bglv;
import bgmk;
import bgok;
import bgop;
import bgor;
import bgpt;
import bgpu;
import com.tencent.qqmini.sdk.core.widget.KeyboardLayout;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class InputJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_HIDE_KEY_BORAD = "hideKeyboard";
  public static final String EVENT_SHOW_KEY_BORAD = "showKeyboard";
  public static final String EVENT_SHOW_KEY_BORAD_VALUE = "setKeyboardValue";
  public static final String EVENT_UPDATE_INPUT = "updateInput";
  public static final String EVENT_UPDATE_KEYBOARD = "updateKeyboard";
  public static final String ON_KEYBOARD_COMPLETE_CALLBACK = "onKeyboardComplete";
  public static final String ON_KEYBOARD_CONFIRM_CALLBACK = "onKeyboardConfirm";
  public static final String ON_KEYBOARD_INPUT_CALLBACK = "onKeyboardInput";
  private static final String TAG = "NetworkJsPlugin";
  private long lastShowInputTime;
  private KeyboardLayout mKeyboardLayout;
  private bgpu mListener = new InputJsPlugin.4(this);
  private bgpt mSoftKeyboardStateHelper;
  
  private void handleHideKeyboard(bgok parambgok, KeyboardLayout paramKeyboardLayout)
  {
    try
    {
      EditText localEditText = paramKeyboardLayout.a();
      JSONObject localJSONObject = bgop.a("hideKeyboard", null);
      parambgok.a.a(parambgok.jdField_b_of_type_Int, localJSONObject.toString());
      if (paramKeyboardLayout.getVisibility() != 8) {
        paramKeyboardLayout.setVisibility(8);
      }
      hideSoftInput(paramKeyboardLayout.getContext(), localEditText);
      return;
    }
    catch (Exception parambgok)
    {
      QMLog.e("NetworkJsPlugin", "hideKeyboard exception", parambgok);
    }
  }
  
  private void handleShowKeyboard(bgok parambgok, KeyboardLayout paramKeyboardLayout)
  {
    try
    {
      Context localContext = paramKeyboardLayout.getContext();
      if (paramKeyboardLayout.getVisibility() != 0) {
        paramKeyboardLayout.setVisibility(0);
      }
      paramKeyboardLayout.setParam(parambgok.jdField_b_of_type_JavaLangString);
      EditText localEditText = paramKeyboardLayout.a();
      Button localButton = paramKeyboardLayout.a();
      showSoftInput(localContext, localEditText);
      localEditText.addTextChangedListener(new InputJsPlugin.5(this, parambgok));
      localEditText.setOnEditorActionListener(new InputJsPlugin.6(this, localEditText, parambgok, paramKeyboardLayout, localContext));
      localButton.setOnClickListener(new InputJsPlugin.7(this, localEditText, parambgok, paramKeyboardLayout, localContext));
      parambgok.a(bgop.a("showKeyboard", null));
      return;
    }
    catch (Exception parambgok)
    {
      QMLog.e("NetworkJsPlugin", "showKeyboard exception", parambgok);
    }
  }
  
  private void handleUpdateKeyboard(bgok parambgok, KeyboardLayout paramKeyboardLayout)
  {
    try
    {
      paramKeyboardLayout = paramKeyboardLayout.a();
      paramKeyboardLayout.setText(new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optString("value", ""));
      paramKeyboardLayout.setSelection(paramKeyboardLayout.getText().length());
      paramKeyboardLayout = bgop.a("updateKeyboard", null);
      parambgok.a.a(parambgok.jdField_b_of_type_Int, paramKeyboardLayout.toString());
      return;
    }
    catch (Exception parambgok)
    {
      QMLog.e("NetworkJsPlugin", "updateKeyboard exception", parambgok);
    }
  }
  
  private void hideSoftInput(Context paramContext, EditText paramEditText)
  {
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null) {
      paramContext.hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
    }
    paramEditText.clearFocus();
  }
  
  private void showSoftInput(Context paramContext, EditText paramEditText)
  {
    paramEditText.setFocusable(true);
    paramEditText.setFocusableInTouchMode(true);
    paramEditText.requestFocus();
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null) {
      paramContext.showSoftInput(paramEditText, 2);
    }
  }
  
  public KeyboardLayout getKeyboard()
  {
    ViewGroup localViewGroup;
    Object localObject;
    if (this.mKeyboardLayout == null)
    {
      if ((this.mMiniAppContext == null) || (this.mMiniAppContext.a() == null)) {
        return null;
      }
      localViewGroup = (ViewGroup)this.mMiniAppContext.a().findViewById(16908290);
      new RelativeLayout(this.mMiniAppContext.a());
      this.mKeyboardLayout = new KeyboardLayout(this.mMiniAppContext.a());
      if (!(localViewGroup instanceof FrameLayout)) {
        break label144;
      }
      localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      localViewGroup.addView(this.mKeyboardLayout, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.mSoftKeyboardStateHelper = new bgpt(localViewGroup);
      this.mSoftKeyboardStateHelper.a(this.mListener);
      return this.mKeyboardLayout;
      label144:
      if ((localViewGroup instanceof RelativeLayout))
      {
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        localViewGroup.addView(this.mKeyboardLayout, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void hideKeyboard(bgok parambgok)
  {
    bgor.a(new InputJsPlugin.3(this, parambgok));
  }
  
  public void hideKeyboardUI()
  {
    if (this.mMiniAppContext != null) {}
    for (Activity localActivity = this.mMiniAppContext.a();; localActivity = null)
    {
      if ((this.mKeyboardLayout != null) && (this.mKeyboardLayout.getVisibility() == 0) && (localActivity != null))
      {
        hideSoftInput(localActivity, this.mKeyboardLayout.a());
        this.mKeyboardLayout.setVisibility(8);
      }
      return;
    }
  }
  
  public boolean onInterceptJsEvent(bgok parambgok)
  {
    if (!this.mIsMiniGame)
    {
      this.mMiniAppContext.a(bgmk.a(parambgok, 2));
      return true;
    }
    return false;
  }
  
  public void onPause()
  {
    hideKeyboardUI();
  }
  
  public void setKeyboardValue(bgok parambgok) {}
  
  public void showKeyboard(bgok parambgok)
  {
    if (System.currentTimeMillis() - this.lastShowInputTime > 1000L)
    {
      this.lastShowInputTime = System.currentTimeMillis();
      bgor.a(new InputJsPlugin.1(this, parambgok));
    }
  }
  
  public void updateInput(bgok parambgok) {}
  
  public void updateKeyboard(bgok parambgok)
  {
    bgor.a(new InputJsPlugin.2(this, parambgok));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InputJsPlugin
 * JD-Core Version:    0.7.0.1
 */