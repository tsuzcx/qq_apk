package com.tencent.mobileqq.minigame.jsapi.manager;

import android.content.Context;
import android.text.Editable;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.minigame.jsapi.callbacks.PluginResultCallback;
import com.tencent.mobileqq.minigame.jsapi.widgets.KeyboardLayout;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONObject;

public class KeyboardHandler
{
  private static final String TAG = "KeyboardHandler";
  private static KeyboardHandler mInstance;
  
  public static KeyboardHandler get()
  {
    if (mInstance == null) {}
    try
    {
      mInstance = new KeyboardHandler();
      return mInstance;
    }
    finally {}
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
  
  public void hideKeyboard(KeyboardLayout paramKeyboardLayout, PluginResultCallback paramPluginResultCallback, int paramInt)
  {
    try
    {
      EditText localEditText = paramKeyboardLayout.getInputET();
      paramPluginResultCallback.invokeCallback(paramInt, ApiUtil.wrapCallbackOk("hideKeyboard", null).toString());
      if (paramKeyboardLayout.getVisibility() != 8) {
        paramKeyboardLayout.setVisibility(8);
      }
      hideSoftInput(paramKeyboardLayout.getContext(), localEditText);
      return;
    }
    catch (Exception paramKeyboardLayout)
    {
      GameLog.getInstance().e("KeyboardHandler", "hideKeyboard exception", paramKeyboardLayout);
    }
  }
  
  public void hideSoftInput(Context paramContext, EditText paramEditText)
  {
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null) {
      paramContext.hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
    }
    paramEditText.clearFocus();
  }
  
  public void showKeyboard(KeyboardLayout paramKeyboardLayout, PluginResultCallback paramPluginResultCallback, String paramString, int paramInt)
  {
    try
    {
      Context localContext = paramKeyboardLayout.getContext();
      if (paramKeyboardLayout.getVisibility() != 0) {
        paramKeyboardLayout.setVisibility(0);
      }
      paramKeyboardLayout.setParam(paramString);
      paramString = paramKeyboardLayout.getInputET();
      Button localButton = paramKeyboardLayout.getConfirmBT();
      showSoftInput(localContext, paramString);
      paramString.addTextChangedListener(new KeyboardHandler.1(this, paramPluginResultCallback));
      paramString.setOnEditorActionListener(new KeyboardHandler.2(this, paramString, paramPluginResultCallback, paramKeyboardLayout, localContext));
      localButton.setOnClickListener(new KeyboardHandler.3(this, paramString, paramPluginResultCallback, paramKeyboardLayout, localContext));
      paramPluginResultCallback.invokeCallback(paramInt, ApiUtil.wrapCallbackOk("showKeyboard", null).toString());
      return;
    }
    catch (Exception paramKeyboardLayout)
    {
      GameLog.getInstance().e("KeyboardHandler", "showKeyboard exception", paramKeyboardLayout);
    }
  }
  
  public void updateKeyboard(KeyboardLayout paramKeyboardLayout, PluginResultCallback paramPluginResultCallback, String paramString, int paramInt)
  {
    try
    {
      paramKeyboardLayout = paramKeyboardLayout.getInputET();
      paramKeyboardLayout.setText(new JSONObject(paramString).optString("value", ""));
      paramKeyboardLayout.setSelection(paramKeyboardLayout.getText().length());
      paramPluginResultCallback.invokeCallback(paramInt, ApiUtil.wrapCallbackOk("updateKeyboard", null).toString());
      return;
    }
    catch (Exception paramKeyboardLayout)
    {
      GameLog.getInstance().e("KeyboardHandler", "updateKeyboard exception", paramKeyboardLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.KeyboardHandler
 * JD-Core Version:    0.7.0.1
 */