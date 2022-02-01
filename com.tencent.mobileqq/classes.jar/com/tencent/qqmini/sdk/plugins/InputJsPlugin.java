package com.tencent.qqmini.sdk.plugins;

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
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.KeyboardLayout;
import org.json.JSONObject;

@JsPlugin
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
  private static final String TAG = "InputJsPlugin";
  private long lastShowInputTime;
  private KeyboardLayout mKeyboardLayout;
  private SoftKeyboardStateHelper.SoftKeyboardStateListener mListener = new InputJsPlugin.1(this);
  private SoftKeyboardStateHelper mSoftKeyboardStateHelper;
  
  private void addTextChangedListener(RequestEvent paramRequestEvent, EditText paramEditText)
  {
    paramEditText.addTextChangedListener(new InputJsPlugin.6(this, paramRequestEvent));
  }
  
  private void handleHideKeyboard(RequestEvent paramRequestEvent, KeyboardLayout paramKeyboardLayout)
  {
    try
    {
      EditText localEditText = paramKeyboardLayout.getInputET();
      JSONObject localJSONObject = ApiUtil.wrapCallbackOk("hideKeyboard", null);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
      if (paramKeyboardLayout.getVisibility() != 8) {
        paramKeyboardLayout.setVisibility(8);
      }
      hideSoftInput(paramKeyboardLayout.getContext(), localEditText);
      return;
    }
    catch (Exception paramRequestEvent)
    {
      QMLog.e("InputJsPlugin", "hideKeyboard exception", paramRequestEvent);
    }
  }
  
  private void handleShowKeyboard(RequestEvent paramRequestEvent, KeyboardLayout paramKeyboardLayout)
  {
    try
    {
      Context localContext = paramKeyboardLayout.getContext();
      if (paramKeyboardLayout.getVisibility() != 0) {
        paramKeyboardLayout.setVisibility(0);
      }
      paramKeyboardLayout.setParam(paramRequestEvent.jsonParams);
      EditText localEditText = paramKeyboardLayout.getInputET();
      Button localButton = paramKeyboardLayout.getConfirmBT();
      showSoftInput(localContext, localEditText);
      addTextChangedListener(paramRequestEvent, localEditText);
      setOnEditorActionListener(paramRequestEvent, paramKeyboardLayout, localContext, localEditText);
      setOnClickListener(paramRequestEvent, paramKeyboardLayout, localContext, localEditText, localButton);
      paramRequestEvent.ok(ApiUtil.wrapCallbackOk("showKeyboard", null));
      return;
    }
    catch (Exception paramRequestEvent)
    {
      QMLog.e("InputJsPlugin", "showKeyboard exception", paramRequestEvent);
    }
  }
  
  private void handleUpdateKeyboard(RequestEvent paramRequestEvent, KeyboardLayout paramKeyboardLayout)
  {
    try
    {
      paramKeyboardLayout = paramKeyboardLayout.getInputET();
      paramKeyboardLayout.setText(new JSONObject(paramRequestEvent.jsonParams).optString("value", ""));
      paramKeyboardLayout.setSelection(paramKeyboardLayout.getText().length());
      paramKeyboardLayout = ApiUtil.wrapCallbackOk("updateKeyboard", null);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramKeyboardLayout.toString());
      return;
    }
    catch (Exception paramRequestEvent)
    {
      QMLog.e("InputJsPlugin", "updateKeyboard exception", paramRequestEvent);
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
  
  private void setOnClickListener(RequestEvent paramRequestEvent, KeyboardLayout paramKeyboardLayout, Context paramContext, EditText paramEditText, Button paramButton)
  {
    paramButton.setOnClickListener(new InputJsPlugin.5(this, paramEditText, paramRequestEvent, paramKeyboardLayout, paramContext));
  }
  
  private void setOnEditorActionListener(RequestEvent paramRequestEvent, KeyboardLayout paramKeyboardLayout, Context paramContext, EditText paramEditText)
  {
    paramEditText.setOnEditorActionListener(new InputJsPlugin.7(this, paramEditText, paramRequestEvent, paramKeyboardLayout, paramContext));
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
    if (this.mKeyboardLayout == null) {
      if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null))
      {
        ViewGroup localViewGroup = (ViewGroup)this.mMiniAppContext.getAttachedActivity().findViewById(16908290);
        new RelativeLayout(this.mMiniAppContext.getAttachedActivity());
        this.mKeyboardLayout = new KeyboardLayout(this.mMiniAppContext.getAttachedActivity());
        Object localObject;
        if ((localViewGroup instanceof FrameLayout))
        {
          localObject = new FrameLayout.LayoutParams(-1, -2);
          ((FrameLayout.LayoutParams)localObject).gravity = 80;
          localViewGroup.addView(this.mKeyboardLayout, (ViewGroup.LayoutParams)localObject);
        }
        else if ((localViewGroup instanceof RelativeLayout))
        {
          localObject = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          localViewGroup.addView(this.mKeyboardLayout, (ViewGroup.LayoutParams)localObject);
        }
        this.mSoftKeyboardStateHelper = new SoftKeyboardStateHelper(localViewGroup);
        this.mSoftKeyboardStateHelper.addSoftKeyboardStateListener(this.mListener);
      }
      else
      {
        return null;
      }
    }
    return this.mKeyboardLayout;
  }
  
  @JsEvent({"hideKeyboard"})
  public void hideKeyboard(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new InputJsPlugin.4(this, paramRequestEvent));
  }
  
  public void hideKeyboardUI()
  {
    Activity localActivity;
    if (this.mMiniAppContext != null) {
      localActivity = this.mMiniAppContext.getAttachedActivity();
    } else {
      localActivity = null;
    }
    KeyboardLayout localKeyboardLayout = this.mKeyboardLayout;
    if ((localKeyboardLayout != null) && (localKeyboardLayout.getVisibility() == 0) && (localActivity != null))
    {
      hideSoftInput(localActivity, this.mKeyboardLayout.getInputET());
      this.mKeyboardLayout.setVisibility(8);
    }
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    if (!this.mIsMiniGame)
    {
      this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 2));
      return true;
    }
    return false;
  }
  
  public void onPause()
  {
    hideKeyboardUI();
  }
  
  @JsEvent({"setKeyboardValue"})
  public void setKeyboardValue(RequestEvent paramRequestEvent) {}
  
  @JsEvent({"showKeyboard"})
  public void showKeyboard(RequestEvent paramRequestEvent)
  {
    if (System.currentTimeMillis() - this.lastShowInputTime > 1000L)
    {
      this.lastShowInputTime = System.currentTimeMillis();
      AppBrandTask.runTaskOnUiThread(new InputJsPlugin.2(this, paramRequestEvent));
    }
  }
  
  @JsEvent({"updateInput"})
  public void updateInput(RequestEvent paramRequestEvent) {}
  
  @JsEvent({"updateKeyboard"})
  public void updateKeyboard(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new InputJsPlugin.3(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InputJsPlugin
 * JD-Core Version:    0.7.0.1
 */